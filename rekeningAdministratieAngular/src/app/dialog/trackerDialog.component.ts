import { TrackerService } from './../rest/tracker.service';
import { Tracker } from './../domain/tracker';
import { Component } from "@angular/core";

@Component({
    selector : 'tracker-dialog',
    templateUrl : './trackerDialog.html',
    styleUrls: ['./../app.component.css']
})

export class TrackerDialogComponent{
    tracker: Tracker;

    constructor(private trackerService : TrackerService){}

    onclickAddTracker(value: string){
        this.tracker = new Tracker();
        this.tracker.id = value;
        this.trackerService.createNewTracker(this.tracker);
    }
}