import { BookDto, CategoryDto } from "../Dtos";
import { AuthorDto, PublisherDto } from "../Dtos/BookDto";

/**
 * Objet à manipuler dans le code
 */
export class BookModel {
    id: string;
    title: string;
    synopsys: string;
    author: AuthorDto | null;
    categories: Array<CategoryDto>;
    isbn: string;
    year: number;
    publisher: PublisherDto;
    urlImage: string;

    constructor (dto: BookDto){
        this.id = dto.id;
    this.title = dto.title;
    this.synopsys = dto.synopsys;
    this.author = dto.author?dto.author:null;
    this.categories = dto.categories;
    this.isbn = dto.isbn;
    this.year = dto.year;
    this.publisher = dto.publisher;
    this.urlImage = dto.urlImage;
    }
}


interface Thing {
    name: string;
}