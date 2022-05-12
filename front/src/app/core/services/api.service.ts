import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { BookModel } from '../models/books.model';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private urlBook = `/api/books`;

  constructor(private httpClient : HttpClient) { }

  getBookById$(id: number): Observable<BookModel> {
    return this.httpClient.get<BookModel>(this.urlBook+`/${id}`);
  }
  
  getAllBooks$(): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook);
  }

  createBook(data: any): Observable<any>{
    return this.httpClient.post(this.urlBook,data);
  }

  searchByTitle(name: string):Observable<Object>{
    return this.httpClient.get(this.urlBook+'/search/'+name);
  }
}
