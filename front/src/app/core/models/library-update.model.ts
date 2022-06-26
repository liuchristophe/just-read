/**
 * Interface Library
 */
export interface LibraryUpdateModel {
    name: string|null,
    address: Address|null, 
    urlImage: string|null,
    description: string|null
}
interface Address {
    id: string,
    streetName: string,
    complementaryField: string,
    zipCode: string,
    city: string,
    country: string,
    // longitude: string,
    // latitude: string
}