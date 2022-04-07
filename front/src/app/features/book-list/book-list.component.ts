import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  constructor(private http: HttpClient) {
    this.ngOnInit();
   }

  async init(){
    this.bookList = await this.getBookList(0,10);
  }

  ngOnInit(): void {
  }
  public bookList = Array<{ id: string, name: string, syn: string}>();
  
  async getBookList(start : number, end : number){
    let bookList = Array<{ id: string, name: string, syn: string}>();
    for(let i=start;i<end;i++){
      this.getBookById$(i).subscribe(
        response => {
          bookList.push(
            {id: response['data']['idBook'], name: response['data']['bookName'], syn: response['data']['synopsys'] }
          );
        },
        async error =>{
          console.log("erreur : la fonction ne s'est pas déclenchée comme prévu")
        }
      )
    }
    console.log(bookList);
    return bookList;
  }

  getBookById$(id: number): Observable<any> {
    let url = `localhost:8080/books/${id}`;
    return this.http.get(url);
  }

}
