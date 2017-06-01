import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Invoice } from './../domain/invoice';

@Injectable()
export class InvoiceService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Invoice/";
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/Invoice/"

    constructor(private http : Http){}

    getInvoicesByDriver(name : any) : Promise<Invoice []> {
        return this.http.get(this.url + 'GetInvoices/' + name)
                        .toPromise()
                        .then(this.extractData);
    }
 
    createNewInvoice(invoice : Invoice) : Promise<Invoice> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + 'CreateInvoice', JSON.stringify(invoice), {headers: header})
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}