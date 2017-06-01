import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { InvoiceRow } from './../domain/invoicerow';

@Injectable()
export class InvoiceRowService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/InvoiceRow/"
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/InvoiceRow/"


    constructor(private http : Http){}

    getInvoiceRowByInvoice(id : any) : Promise<InvoiceRow []> {
        return this.http.get(this.url + 'GetInvoiceRows/' + id)
                        .toPromise()
                        .then(this.extractData);
    }
 
    createNewInvoiceRow(invoice : InvoiceRow) : Promise<InvoiceRow> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + 'CreateInvoiceRow', JSON.stringify(invoice), {headers: header})
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}