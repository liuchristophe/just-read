export interface BookModel {
    id: string;
    title: string;
    synopsys: string;
    author: string;
    categories: Array<Thing>;
    isbn: string;
    year: number;
    publisher: Thing;
    urlImage: string;
}

interface Thing {
    name: string;
}