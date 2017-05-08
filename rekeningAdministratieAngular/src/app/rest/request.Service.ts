import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { Vehicle } from './../domain/vehicle';
import { Request } from 'app/domain/request';

@Injectable()
export class RequestService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Request/";
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/Request/";

    constructor(private http: Http) { }

    getAllRequestInProgress(){
         return this.http.get(this.url + "GetRequestInProgress")
            .toPromise()
            .then(this.extractData);
    }

    updateRequestStatus(request : Request) : Promise<boolean>{
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + "UpdateRequestStatus", JSON.stringify(request), {headers: header})
                    .toPromise()
                    .then(this.extractData);
    }
    private extractData(res: Response) {
        return res.json();
    }
}