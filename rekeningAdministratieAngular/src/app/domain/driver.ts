import { Vehicle } from './vehicle';
export class Driver {
    constructor(
        public name: string,
        public lastname: string,
        public postalCode: string,
        public city: string,
        public email: string,
        public username: string,
        public password: string,
        public houseNumber: string,
        public phoneNumber: string
    ) {

    }
}