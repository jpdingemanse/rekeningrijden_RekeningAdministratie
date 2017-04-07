import { Component, ViewChild } from '@angular/core'

import { DriverService } from './../rest/driver.Service';
import { Driver } from './../domain/driver';

@Component({
    selector : 'gebruiker-page',
    templateUrl : './gebruiker.html',
    styleUrls: ['./../app.component.css']
})
export class GebruikerPageComponent {
    @ViewChild('carModal')
    bgModel;

    selectedDriver : Driver;
    driverList : Driver[];

    constructor(private driverService : DriverService){}

    onclickSearch(value : string) {
        let result  = value.split(' '); 
        if(result.length > 1){
            this.driverService.getDriverByFullName(result[0], result[1])
                                .then(value => this.driverList = value)
        }
        else{
            console.log(value);
        }
    }
    onclickSelectDriver(value : Driver){
        this.selectedDriver = value;
        this.bgModel.show();
    }
}