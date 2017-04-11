import { Component, OnInit } from '@angular/core'

import { RateService } from './../rest/rate.Service';
import { Rate } from './../domain/rate';

@Component({
    selector : 'tarieven-page',
    templateUrl : './tarieven.html',
    styleUrls: ['./../app.component.css']
})
export class TarievenPageComponent implements OnInit {
    private rateList : Rate[];
    private selectedRate : Rate;
        ngOnInit(): void {
            this.rateService.getAllRates()
                            .then(value => this.rateList = value)
                            .then(() => console.log(this.rateList))
        }

    constructor(private rateService : RateService){}

    onclickSelectedRate(value : Rate, tbNieuw : string){
        this.selectedRate = value;
        this.selectedRate.rate = parseFloat(tbNieuw);
        this.rateService.editRate(this.selectedRate);
    }

}