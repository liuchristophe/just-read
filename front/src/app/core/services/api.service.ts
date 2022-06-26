import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs';
import {BookDto} from '../Dtos/BookDto';
import { BookModel } from '../models/books.model';
import { LibraryModel, StockModel } from '../models/library.model';

/**
 * Service contenant tous les appelles vers le back-end
 */
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private urlBook = `/api/books`;
  private urlLibrary = `/api/library`

  constructor(private httpClient : HttpClient) { }

  /**
   * Retourne l'observable pour récupéré le livre par id
   */
  getBookById$(id: number): Observable<BookModel> {
    return this.httpClient.get<BookModel>(this.urlBook+`/${id}`);
  }
  
  /**
   * Retourne l'observable pour récupéré tous les livre dans la base de  donnée
   */
  getAllBooks$(): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook);
  }

  /**
   * Retourne l'observable pour récupéré les livres d'un catégories précis
   */
  getBooksByCategoryName$(categoryName : string): Observable<Array<BookModel>>{
    return this.httpClient.get<Array<BookModel>>(this.urlBook+`/category/${categoryName}`);
  }

  /**
   * Retourne l'observable pour créer un livre dans la base de donnée
   */
  createBook$(data: any): Observable<any>{
    return this.httpClient.post(this.urlBook,data);
  }

  /**
   * Retourne l'observable pour récupéré le nom du livre précis
   */
  searchByTitle$(name: string):Observable<Object>{
    return this.httpClient.get(this.urlBook+'/search/'+name);
  }

  /**
   * Retourne l'observable pour récupéré les informations et les livres dans son stock
   */
  getAllLibrary$(): Observable<Array<LibraryModel>>{
    return this.httpClient.get<Array<LibraryModel>>(this.urlLibrary);
  }

  getAllLibraryNearby$(latitude: number, longitude: number): Observable<Array<LibraryModel>>{
    return this.httpClient.get<Array<LibraryModel>>(this.urlLibrary+"/rayon?latitude="+latitude+"&longitude="+longitude+"&rayon=30");
  }

  
  /**
   * Retourne l'observable pour récupéré
   */
  getAdresse$(adresse: string): Observable<Array<any>>{
    return this.httpClient.get<Array<any>>("https://api-adresse.data.gouv.fr/search/?q="+adresse.replace(" ", "+"))
  }

  /**
   * Retourne l'observable pour ajouter le livre dans le stock du librairie
   */
  addStock$(idLibrary : string, stockItem : StockModel): Observable<any>{
    return this.httpClient.post(`${this.urlLibrary}/${idLibrary}/stock/add`,stockItem);
  }

  /**
   * Retourne l'observable pour récupéré les livres dans le stock du librairie
   */
  getStock$(idLibrary: string): Observable<Array<StockModel>>{
    return this.httpClient.get<Array<StockModel>>(`${this.urlLibrary}/${idLibrary}/stock`);
  }

  /**
   * Retourne l'observable pour afficher les livre dont la librairie n'a pas ajouter dans son stock
   */
  getBooksNotInStock$(idLibrary: string): Observable<Array<StockModel>>{
    return this.httpClient.get<BookDto[]>(`${this.urlBook}/bookNotInLibrary/${idLibrary}`).pipe(map(
      dtos => dtos.map(dto=>new StockModel({quantity:0,unitPrice:0,book:dto,id:""}))
    ));
  }

  /**
   * Retourne l'observable pour mettre à jour un livre du stock
   */
  updateStock$(idLibrary: string, idStockItem: string, stockItem: StockModel): Observable<any>{
    return this.httpClient.patch(`${this.urlLibrary}/${idLibrary}/stock/update/${idStockItem}`, stockItem);
  }

  /**
   * Retourne l'observable pour supprimer le livre du stock
   */
  deleteStock$(idLibrary: string, idStockItem: string):Observable<any>{
    return this.httpClient.delete(`${this.urlLibrary}/${idLibrary}/stock/remove/${idStockItem}`);
  }
}
