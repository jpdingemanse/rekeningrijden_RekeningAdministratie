import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Invoice } from './../domain/invoice';

@Injectable()
export class InvoiceService {
    private url = "http//192.168.24.46/S61D_RekeningAdministratie/api/Driver/";
    private localurl = "http://localhost:58444/S61D_RekeningAdministratie/api/Invoice/"

    constructor(private http : Http){}

    getInvoicesByDriver(id : any) : Promise<Invoice []> {
        return this.http.get(this.localurl + 'GetInvoices/' + id)
                        .toPromise()
                        .then(this.extractData);
    }
 
    createNewInvoice(invoice : Invoice) : Promise<Invoice> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + 'CreateInvoice', JSON.stringify(invoice), {headers: header})
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}