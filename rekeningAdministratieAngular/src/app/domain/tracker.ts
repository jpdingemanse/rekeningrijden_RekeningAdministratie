import { Vehicle } from './vehicle';
export class Tracker {
    
    constructor (
        public id : string,
        public latitude : number,
        public longitude : number,
        public vehicle : Vehicle
    ) { }
}