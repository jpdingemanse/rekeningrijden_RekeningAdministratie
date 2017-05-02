import { Component, Input } from '@angular/core'

import { RateService } from './../rest/rate.Service';
import { Rate } from './../domain/rate';

@Component({
    selector : 'rate-edit-dialog',
    templateUrl : './RateEditDialog.html',
    styleUrls: ['./../app.component.css']
})
export class RateEditDialogComponent {

    @Input('value')
    rate : Rate;
    rateList : Rate[] = [];

    constructor(private rateService : RateService){}
    
    onclickSubmit(tbNieuw : string) {
        this.rate.rate = parseFloat(tbNieuw);
        this.rateService.editRate(this.rate);
    }
}