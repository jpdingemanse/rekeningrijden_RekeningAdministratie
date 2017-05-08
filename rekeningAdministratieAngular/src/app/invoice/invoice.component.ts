import { Component } from '@angular/core'

import { InvoiceService } from './../rest/invoice.Service';
import { Invoice } from './../domain/invoice';

@Component({
    selector : 'invoice-page',
    templateUrl : './invoice.html',
    styleUrls: ['./../app.component.css']
    
})

export class InvoicePageComponent {
    private invoiceList : Invoice[] = [];
    private invoice : Invoice;
     constructor(private invoiceService : InvoiceService){}

     
       
     onClickSelectedInvoice(id : any){
      
         console.log(id);
        this.invoiceService.getInvoicesByDriver(id)
                           .then(value => this.invoiceList = value);
        console.log(this.invoiceList[0]);
     }  
}