import { Component } from '@angular/core'

import { InvoiceService } from './../rest/invoice.Service';
import { Invoice } from './../domain/invoice';
import { InvoiceRow } from './../domain/invoiceRow';
import { InvoiceRowService } from './../rest/invoiceRow.Service';
import { Driver } from './../domain/driver';
import { DriverService } from './../rest/driver.Service'

@Component({
    selector: 'invoice-page',
    templateUrl: './invoice.html',
    styleUrls: ['./../app.component.css']

})

export class InvoicePageComponent {
    private invoiceList: Invoice[] = [];
    private invoiceRowList: InvoiceRow[] = [];
    private invoice: Invoice;
    private drivers: Driver[] = [];
    constructor(private invoiceService: InvoiceService, private invoiceRowService: InvoiceRowService, private driverService : DriverService) { }



    onClickSelectedInvoice(name: any) {
        this.invoiceService.getInvoicesByDriver(name)
            .then(value => this.invoiceList = value);
        //console.log(this.invoiceList[0]);
    }

    onClickShowInvoiceDetails(id: any) {
        this.invoiceRowService.getInvoiceRowByInvoice(id)
            .then(value => this.invoiceRowList = value)
            
    }

    onClickCreateInvoice(name: string, lastname: string){
        this.driverService.getDriverByFullName(name, lastname)
            .then((value => this.drivers = value))
            .then(() => {
                this.invoiceService.createNewInvoice(this.drivers[0])
                                    .then(value => {
                                        if(value != null){
                                            this.invoiceList.push(value)
                                        }
                                    })
            })
            
    }
}