import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { InvoiceRow } from './../domain/invoicerow';

@Injectable()
export class InvoiceRowService {
    private url = "http//192.168.24.46/S61D_RekeningAdministratie/api/Driver/";
    private localurl = "http://localhost:58444/S61D_RekeningAdministratie/api/InvoiceRow/"

    constructor(private http : Http){}

    getInvoiceRowByInvoice(id : any) : Promise<InvoiceRow []> {
        return this.http.get(this.localurl + 'GetInvoiceRows/' + id)
                        .toPromise()
                        .then(this.extractData);
    }
 
    createNewInvoiceRow(invoice : InvoiceRow) : Promise<InvoiceRow> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + 'CreateInvoiceRow', JSON.stringify(invoice), {headers: header})
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}