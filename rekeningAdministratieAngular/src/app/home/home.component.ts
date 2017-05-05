import { Component, OnInit } from '@angular/core'

import { LoginService } from "app/global/login.Service";
import { UserService } from "app/rest/user.Service";
import { RequestService } from 'app/rest/request.Service';
import { DriverService } from 'app/rest/driver.Service';
import { VehicleService } from 'app/rest/vehicle.service'

import { Request } from 'app/domain/request';
import { Driver } from "app/domain/driver";
import { Vehicle } from "app/domain/vehicle";

@Component({
    selector: 'home-page',
    templateUrl: './home.html',
    styleUrls: ['./../app.component.css']
})
export class HomePageComponent implements OnInit {

    driver: Driver;

    allRequestInProgress: Request[]
    vehicle: Vehicle;

    licensePlate: string;
    message: String;
    selectedRequest: Request;

    confirmationMessage: string;

    constructor(private loginService: LoginService, private userService: UserService, private requestService: RequestService, private driverService: DriverService, private vehicleService: VehicleService) {
        this.allRequestInProgress = new Array;
    }
    ngOnInit() {
        this.getAllRequestInProgress()
    }

    getAllRequestInProgress() {
        this.requestService.getAllRequestInProgress()
            .then(value => {
                this.allRequestInProgress = value;
            })
    }

    getDriverById(value: number) {
        this.driverService.getDriverById(value)
            .then(value => {
                this.driver = value;
            })
    }

    getVehicleByLicensePlate(licensePlate: string) {
        this.vehicleService.getVehicleByLicensePlate(licensePlate)
            .then(value => {
                if (value != null) {
                    this.vehicle = value
                    this.licensePlate = value.licensePlate
                }
                else {
                    this.message = "Voegt eerst de vehicle toe"
                    this.confirmationMessage = "";
                }
            })
    }
    editClick(value: Request) {
        this.selectedRequest = value
        this.getDriverById(value.driverId)
        this.licensePlate = value.licensePlate
        this.getVehicleByLicensePlate(value.licensePlate);
    }

    addVehicleClick() {
        this.vehicle = new Vehicle();
        this.vehicle.licensePlate = this.licensePlate;
        this.vehicleService.createVehicle(this.vehicle)
            .then(value => {
                this.vehicle = value
                this.confirmationMessage = "Voertuig is toegevoegd"
                this.message = "";
            })
    }

    addVehicleToDriverClick() {
        this.vehicle.owner = this.driver
        this.vehicleService.addVehicleToDriver(this.vehicle)
            .then(value => {
                if (value != null) {
                    this.confirmationMessage = "Voertuig is gekoppeld aan de bestuurder"
                    this.message = "";
                    this.requestService.updateRequestStatus(this.selectedRequest)
                        .then(value => {
                            if (value) {
                                for (var i = 1; i < this.allRequestInProgress.length; i++) {
                                    if (this.selectedRequest.id == this.allRequestInProgress[i].id) {
                                        this.allRequestInProgress.splice(i, 1);
                                    }

                                }
                            }

                        })
                }
            })
    }








}