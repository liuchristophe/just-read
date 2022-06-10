import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { BookModel } from '../models/books.model';
import { LibraryModel } from '../models/library.model';
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

  getBooksByCategoryName(categoryName : string): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook+`/category/${categoryName}`);
  }

  createBook(data: any): Observable<any>{
    return this.httpClient.post(this.urlBook,data);
  }

  searchByTitle(name: string):Observable<Object>{
    return this.httpClient.get(this.urlBook+'/search/'+name);
  }

  getAllLibrary(): Observable<Array<LibraryModel>>{
    return this.httpClient.get<Array<LibraryModel>>(this.urlLibrary);
  }
}
