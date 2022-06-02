export interface LibraryModel {
    id: string,
    name: string,
    address: Address,
    orders: Array<Thing>,
    stocks: Array<Thing>
}

interface Thing {
    id: string;
}

interface Address {
    id: string,
    streetName: string,
    complementaryField: string,
    zipCode: string,
    city: string,
    country: string
}