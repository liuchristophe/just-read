import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs';
import {BookDto} from '../Dtos/BookDto';
import { BookModel } from '../models/books.model';
import { AddressModel } from '../models/library.model';
import { LibraryModel, StockModel } from '../models/library.model';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private urlBook = `/api/books`;
  private urlLibrary = `/api/library`

  constructor(private httpClient : HttpClient) { }

  getBookById$(id: number): Observable<BookModel> {
    return this.httpClient.get<BookModel>(this.urlBook+`/${id}`);
  }
  
  getAllBooks$(): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook);
  }

  getBooksByCategoryName$(categoryName : string): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook+`/category/${categoryName}`);
  }

  createBook$(data: any): Observable<any>{
    return this.httpClient.post(this.urlBook,data);
  }

  searchByTitle$(name: string):Observable<Object>{
    return this.httpClient.get(this.urlBook+'/search/'+name);
  }

  getAllLibrary$(): Observable<Array<LibraryModel>>{
    return this.httpClient.get<Array<LibraryModel>>(this.urlLibrary);
  }

  getAdresse$(adresse: string): Observable<Array<any>>{
    return this.httpClient.get<Array<any>>("https://api-adresse.data.gouv.fr/search/?q="+adresse.replace(" ", "+"))
  }
  
  addStock$(idLibrary : string, stockItem : StockModel): Observable<any>{
    return this.httpClient.post(`${this.urlLibrary}/${idLibrary}/stock/add`,stockItem);
  }

  getStock$(idLibrary: string): Observable<Array<StockModel>>{
    return this.httpClient.get<Array<StockModel>>(`${this.urlLibrary}/${idLibrary}/stock`);
  }


  getBooksNotInStock$(idLibrary: string): Observable<Array<StockModel>>{
    return this.httpClient.get<BookDto[]>(`${this.urlBook}/bookNotInLibrary/${idLibrary}`).pipe(map(
      dtos => dtos.map(dto=>new StockModel({quantity:0,unitPrice:0,book:dto,id:""}))
    ));
  }

  updateStock$(idLibrary: string, idStockItem: string, stockItem: StockModel): Observable<any>{
    return this.httpClient.patch(`${this.urlLibrary}/${idLibrary}/stock/update/${idStockItem}`, stockItem);
  }

  deleteStock$(idLibrary: string, idStockItem: string):Observable<any>{
    return this.httpClient.delete(`${this.urlLibrary}/${idLibrary}/stock/remove/${idStockItem}`);
  }
}
