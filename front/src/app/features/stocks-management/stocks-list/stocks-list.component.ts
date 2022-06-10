import { Component, OnInit } from '@angular/core';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';

@Component({
  selector: 'app-stocks-list',
  templateUrl: './stocks-list.component.html',
  styleUrls: ['./stocks-list.component.scss']
})
export class StocksListComponent implements OnInit {

  book1: BookItemModel = {
    title: `Le plus grand ennemi`, 
    image: `https://m.media-amazon.com/images/I/51plZGnGurL._SY346_.jpg`,
    synopsys: 'r',
    author: 'r',
    year: 0
  };
  book2: BookItemModel = {
    title: `Vengeance glacée`, 
    image: `https://m.media-amazon.com/images/I/51Zx+YW+o+L._SY346_.jpg`,
    synopsys: 'r',
    author: 'r',
    year: 0
  };
  books = [this.book1, this.book2]

  constructor() { }

  ngOnInit(): void {
  }

}
