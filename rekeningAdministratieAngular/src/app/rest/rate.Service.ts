import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Rate } from './../domain/rate';

@Injectable()
export class RateService {
    // private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Rate/";
    private url = "http://localhost:18410/S61D_RekeningAdministratie/api/Rate/"

    constructor(private http: Http) { }

    getAllRates(): Promise<Rate[]> {
        return this.http.get(this.url + "getAllRates")
            .toPromise()
            .then(this.extractData);
    }

    editRate(rate: Rate) : Promise<Rate> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + 'editRate', JSON.stringify(rate), { headers: header })
        .toPromise().then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}