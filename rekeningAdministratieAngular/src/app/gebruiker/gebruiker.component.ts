import { Component} from '@angular/core'

import { DriverService } from './../rest/driver.Service';
import { Driver } from './../domain/driver';

@Component({
    selector : 'gebruiker-page',
    templateUrl : './gebruiker.html',
    styleUrls: ['./../app.component.css']
})
export class GebruikerPageComponent {
    driver : Driver[];

    constructor(private driverService : DriverService){}

    onclickSearch(value : string) {
        let result  = value.split(' '); 
        if(result.length > 1){
            this.driverService.getDriverByFullName(result[0], result[1])
                                .then(value => this.driver = value)
                                .then(() => console.log(this.driver));
        }
        else{
            console.log(value);
        }
        
    }
}