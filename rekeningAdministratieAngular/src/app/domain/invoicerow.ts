import { Vehicle } from './vehicle'
export class InvoiceRow {
    constructor(
        public id: number,
        public price: Number,
        public description: string,
        public vehicle: Vehicle
    ) {

    }
}