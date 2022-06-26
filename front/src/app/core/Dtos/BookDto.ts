export interface AuthorDto {
      id: string;
      firstname: string;
      lastname: string;
      pseudo: string;
      urlWiki: string;
      bookCount: number;
}
export interface CategoryDto {
    name: string;
}
export interface PublisherDto {
    //TODO
}

export interface stockDto{
    id: string | undefined;
    book: BookDto;
    quantity: number;
    unitPrice: number;
}

export interface BookDto {

    id: string;
    title: string;
    synopsys: string;
    author?: AuthorDto | null;
    categories: CategoryDto[];
    isbn: string;
    year: number;
    urlImage: string;
    publisher: PublisherDto;

}