import { Vehicle } from './vehicle'
export class InvoiceRow {
    constructor(
        public id: number,
        public price: number,
        public description: string,
        public vehicle: Vehicle
    ) {

    }

    setPrice(price: number) {
        this.price = price;
    }
}