import { BookModel } from "./books.model";
import { BookDto} from "../Dtos";
import { stockDto } from "../Dtos/BookDto";

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

export class StockModel{
    quantity: number;
    unitPrice: number;
    book: BookModel;
    id?: string;

    // constructor(quantity: number, unitPrice: number, book: BookModel, id_stock?: string) {
    //     this.id = id_stock;
    //     this.quantity = quantity;
    //     this.unitPrice = unitPrice;
    //     this.book = book;
    // }

    constructor(dto: stockDto){
        this.book= new BookModel(dto.book);
        this.quantity= dto.quantity;
        this.unitPrice = dto.unitPrice;
        this.id = dto.id;
    }

    //TODO : use a stockDto
    // constructor() {
    //     this(null,null,null,null);
    // }

    public getQuantity(): number {
        return this.quantity;
    }

    public getUniPrice(): number {
        return this.unitPrice;
    }

    public getBook(): BookModel{
        return this.book;
    }

    public getId(): string | undefined {
        return this.id;
    }
}
