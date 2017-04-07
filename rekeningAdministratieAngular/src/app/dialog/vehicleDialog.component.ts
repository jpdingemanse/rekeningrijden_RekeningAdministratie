import { Component, Input } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';

@Component({
    selector : 'car-dialog',
    templateUrl : './vehicleDialog.html',
    styleUrls: ['./../app.component.css']
})
export class VehicleDialogComponent {
    @Input('value')
    driver : Driver;

    selectedVehicleWithDriver : Vehicle;
    vehicleList : Vehicle[];
    vehicleSearch : Vehicle;
    availableVehicleList : Vehicle[] = [];

    constructor(private vehicleService : VehicleService){}

    
    onclickSearch(value : string) {
        this.vehicleService.getVehicleByLicensePlate(value)
                                .then(value => this.vehicleSearch = value)
                                .then(() => this.availableVehicleList.push(this.vehicleSearch));  
    }
    onclickGetAllVehicle() {
        this.vehicleService.getVehicleById(this.driver.id)
                            .then(value => this.vehicleList = value);
    }

    onclickAddDriverToVehicle(value: Vehicle){
        this.selectedVehicleWithDriver = new Vehicle();
        this.selectedVehicleWithDriver.setDriver(this.driver);
        this.selectedVehicleWithDriver.setLicensePlate(value.licensePlate);
        this.vehicleService.addVehicleToDriver(this.selectedVehicleWithDriver)
                            .then(value => this.vehicleList.push(value))
                            .then(() => this.availableVehicleList = []);
        
    }

}