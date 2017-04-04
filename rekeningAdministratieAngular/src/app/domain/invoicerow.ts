import { Vehicle } from './vehicle'
export class Invoicerow {
    constructor(
        public id: number,
        public price: number,
        public description: string,
        public vehicle: Vehicle
    ) {

    }
}