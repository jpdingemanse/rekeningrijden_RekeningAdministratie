import { Component, Input, ViewChild } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';

@Component({
    selector : 'car-page',
    templateUrl : './vehicle.html',
    styleUrls: ['./../app.component.css']
})

export class VehiclePageComponent {
    @ViewChild('editAutorisatieCodeModal')
    bgModel;
    
    vehicleSelected : Vehicle;
    vehicleSearch : Vehicle;
    availableVehicleList : Vehicle[] = [];

    constructor(private vehicleService : VehicleService){}

    onclickSearch(value : string){
        this.availableVehicleList = [];
        this.vehicleService.getVehicleByLicensePlate(value)
                                .then(value => this.vehicleSearch = value)
                                .then(() => this.availableVehicleList.push(this.vehicleSearch));  
    }

    onclickShowModal(value : Vehicle){
        // this.bgModel.show();
    }
    onclickSaveAuthorisatieCode(vehicle: Vehicle ,value : string){
        this.vehicleSelected = new Vehicle();
        this.vehicleSelected.setDriver(vehicle.owner);
        this.vehicleSelected.setLicensePlate(vehicle.licensePlate);
        this.vehicleSelected.setautorisatieCode(value);
        this.vehicleService.updateVehicleAutorisateCode(this.vehicleSelected)
                            .then(value => console.log(value));
        
    }



}