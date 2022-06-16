import { BookModel } from "./books.model";

export interface LibraryModel {
    id: string,
    name: string,
    address: AddressModel
    urlImage: string;
    description: string;
    stocks: Array<StockModel>;
    orders: Array<OrderModel>;
}
interface AddressModel{
    id: string,
    streetName: string,
    complementaryField: string,
    zipCode: string,
    city: string,
    country: string
}
export interface OrderModel {
    id: string;
    date: string;
    tva: number;
    utilisateur: string;
    orderItem: Array<OrderItemModel>;
}
export interface OrderItemModel {
    id: string;
    price: number;
    quantity: number;
    book: BookModel;
}
export interface StockModel {
    id: string;
    quantity: number;
    unitPrice: number;
    book: BookModel;
}