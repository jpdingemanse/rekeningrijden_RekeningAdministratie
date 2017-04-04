import { Driver } from './driver'
export class Invoice {
    constructor(
        public id: number,
        public timeCreated: number,
        public drivers: Driver[]
    ) {

    }
}