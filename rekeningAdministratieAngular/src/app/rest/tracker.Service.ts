import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Vehicle } from './../domain/vehicle';
import { Tracker } from './../domain/tracker';
import { VehicleService } from './../rest/vehicle.service'

@Injectable()
export class TrackerService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Driver/";
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/Tracker/";
    vehicle: Vehicle;
    constructor(private http: Http, private vehicleService: VehicleService) {

    }

    createNewTracker(tracker: Tracker): Promise<Tracker> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + 'CreateTracker/', JSON.stringify(tracker), { headers: header })
            .toPromise()
            .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}