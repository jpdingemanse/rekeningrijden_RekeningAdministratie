import { TrackerService } from './../rest/tracker.service';
import { VehicleService } from './../rest/vehicle.service';
import { Tracker } from './../domain/tracker';
import { Vehicle } from './../domain/vehicle';
import { Component } from "@angular/core";

@Component({
    selector: 'tracker-dialog',
    templateUrl: './trackerDialog.html',
    styleUrls: ['./../app.component.css']
})

export class TrackerDialogComponent {
    tracker: Tracker;
    vehicle: Vehicle;

    constructor(private trackerService: TrackerService, private vehicleService: VehicleService) { }

    onclickAddTracker(value: string, licenseplate: string) {
        this.tracker = new Tracker();
        this.vehicle = new Vehicle();
        this.tracker.id = value;
        this.vehicle.licensePlate = licenseplate;
        this.vehicleService.getVehicleByLicensePlate(licenseplate)
            .then(value => this.vehicle = value)
            .then(() => {
                this.trackerService.createNewTracker(this.tracker)
                .then(value => this.tracker = value)
                .then(() => this.vehicle.tracker = this.tracker)
                .then(() => {
                    this.vehicleService.updateTracker(this.vehicle);
                });
                
            })

    }
    crateNewTracker(tracker: Tracker){
        
    }
}