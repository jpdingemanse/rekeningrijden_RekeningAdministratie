import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Rate } from './../domain/rate';

@Injectable()
export class RateService {
    private url = "http//192.168.24.46/S61D_RekeningAdministratie/api/Rate/";
    private localurl = "http://localhost:8080/S61D_RekeningAdministratie/api/Rate/"

    constructor(private http : Http){}

    getAllRates(): Promise<Rate []> {
        return this.http.get(this.localurl + "getAllRates")
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}