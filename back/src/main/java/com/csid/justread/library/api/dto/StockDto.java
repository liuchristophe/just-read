package com.csid.justread.library.api.dto;

import com.csid.justread.book.api.dto.BookDto;
import java.util.List;
import java.util.UUID;

public class StockDto {

    private UUID id;
    private int quantity;
    private int unitPrice;
    private List<BookDto> books;
    private LibraryDto library;

    //region * Methods *

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public LibraryDto getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDto library) {
        this.library = library;
    }

    //endregion

}
