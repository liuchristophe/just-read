export interface LibraryUpdateModel {
    name: string|null,
    address: Address|null
}
interface Address {
    id: string,
    streetName: string,
    complementaryField: string,
    zipCode: string,
    city: string,
    country: string
}