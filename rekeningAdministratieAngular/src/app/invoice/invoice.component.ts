import { Component } from '@angular/core'

import { InvoiceService } from './../rest/invoice.Service';
import { Invoice } from './../domain/invoice';
import { InvoiceRow } from './../domain/invoiceRow';
import { InvoiceRowService } from './../rest/invoiceRow.Service';

@Component({
    selector : 'invoice-page',
    templateUrl : './invoice.html',
    styleUrls: ['./../app.component.css']
    
})

export class InvoicePageComponent {
    private invoiceList : Invoice[] = [];
    private invoiceRowList : InvoiceRow[] = [];
    private invoice : Invoice;
     constructor(private invoiceService : InvoiceService, private invoiceRowService : InvoiceRowService){}

     
       
     onClickSelectedInvoice(name : any){
      
         console.log(name);
        this.invoiceService.getInvoicesByDriver(name)
                           .then(value => this.invoiceList = value);
        //console.log(this.invoiceList[0]);
     }  

     onClickShowInvoiceDetails(id : any){
         console.log(id);
         this.invoiceRowService.getInvoiceRowByInvoice(id)
                            .then(value => this.invoiceRowList = value);
     }

     onClickSendInvoices(){
         this.invoiceService.createNewInvoice;
     }
}