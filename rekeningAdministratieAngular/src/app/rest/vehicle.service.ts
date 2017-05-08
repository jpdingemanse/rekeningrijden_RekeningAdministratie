import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { Vehicle } from './../domain/vehicle';

@Injectable()
export class VehicleService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Vehicle/";
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/Vehicle/";

    constructor(private http: Http) { }

    createVehicle(value : Vehicle) : Promise<Vehicle>{
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.url + "CreateVehicle",  JSON.stringify(value), { headers: headers })
                        .toPromise()
                        .then(this.extractData);

    }
    getVehicleById(id: any): Promise<Vehicle[]> {
        return this.http.get(this.url + "GetAllVehicle/" + id)
            .toPromise()
            .then(this.extractData);
    }

    getVehicleByLicensePlate(value: string): Promise<Vehicle> {
        return this.http.get(this.url + "GetVehicleByLicensePlate/" + value)
            .toPromise()
            .then(this.extractData);
    }

    updateVehicleAutorisateCode(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.url + "UpdateAuthorisatieCode", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    updateVehicleIcan(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.url + "UpdateIcan", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    addVehicleToDriver(value: Vehicle): Promise<Vehicle> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.url + "AddVehicleToDriver", JSON.stringify(value), { headers: headers })
            .toPromise()
            .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}