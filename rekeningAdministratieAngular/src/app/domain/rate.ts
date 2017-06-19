export class Rate {
    constructor(
        public id: number,
        public currency: string,
        public rate: number,
        public region: string,
    ) {

    }
}