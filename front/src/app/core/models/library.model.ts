import { BookModel } from "./books.model";

export interface LibraryModel {
    id: string;
    name: string;
    urlImage: string;
    description: string;
    address: AddressModel;
    stocks: Array<StockModel>;
    orders: Array<OrderModel>;

}

export interface AddressModel {
    id: string;
    streetName: string;
    complementaryField: string;
    zipCode: string;
    city: string;
    country: string;
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
export class StockModel {
    quantity: number;
    unitPrice: number;
    book: BookModel;
    id_stock?: string;

    constructor(quantity: number, unitPrice: number, book: BookModel, id_stock?: string) {
        this.id_stock = id_stock;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.book = book;
    }

    // constructor() {
    //     this(null,null,null,null);
    // }
}