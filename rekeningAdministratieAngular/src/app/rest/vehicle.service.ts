import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { Vehicle } from './../domain/vehicle';

@Injectable()
export class VehicleService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Vehicle/";
    private localurl = "http://localhost:58444/S61D_RekeningAdministratie/api/Vehicle/";

    constructor(private http: Http) { }

    createVehicle(value : Vehicle) : Promise<Vehicle>{
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + "CreateVehicle",  JSON.stringify(value), { headers: headers })
                        .toPromise()
                        .then(this.extractData);

    }
    getVehicleById(id: any): Promise<Vehicle[]> {
        return this.http.get(this.localurl + "GetAllVehicle/" + id)
            .toPromise()
            .then(this.extractData);
    }

    getVehicleByLicensePlate(value: string): Promise<Vehicle> {
        return this.http.get(this.localurl + "GetVehicleByLicensePlate/" + value)
            .toPromise()
            .then(this.extractData);
    }

    updateVehicleAutorisateCode(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + "UpdateAuthorisatieCode", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    updateTracker(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + "UpdateTracker", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    addVehicleToDriver(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + "AddVehicleToDriver", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}