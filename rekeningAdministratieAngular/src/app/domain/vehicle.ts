import { Driver } from "app/domain/driver";

export class Vehicle {
    public licensePlate: string;
    public autorisatieCode: string;
    public owner: Driver;
    public iCan: string;
    constructor() { }

    setDriver(driver: Driver) {
        this.owner = driver;
    }
    setLicensePlate(licensePlate: string) {
        this.licensePlate = licensePlate;
    }
    setautorisatieCode(autorisatieCode: string) {
        this.autorisatieCode = autorisatieCode;
    }

}