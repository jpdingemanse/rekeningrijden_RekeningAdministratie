import { Component, OnInit, ViewChild } from '@angular/core'

import { RateService } from './../rest/rate.Service';
import { Rate } from './../domain/rate';

@Component({
    selector : 'tarieven-page',
    templateUrl : './tarieven.html',
    styleUrls: ['./../app.component.css']
})
export class TarievenPageComponent implements OnInit {
    @ViewChild('rateEditModal')
    bgModel;

    private rateList : Rate[];
    private selectedRate : Rate;
        ngOnInit(): void {
            this.rateService.getAllRates()
                            .then(value => this.rateList = value)
                            .then(() => console.log(this.rateList))
        }

    constructor(private rateService : RateService){}

    onclickSelectedRate(value : Rate){
        this.selectedRate = value;
        this.bgModel.show();
    }

}