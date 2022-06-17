import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { ApiService } from 'src/app/core/services/api.service';

@Component({
  selector: 'app-stocks-list',
  templateUrl: './stocks-list.component.html',
  styleUrls: ['./stocks-list.component.scss']
})
export class StocksListComponent implements OnInit {

  // books = [this.book1, this.book2];
  books?: BookModel[];
  
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getAllBooks$()
    .pipe()
    .subscribe((data) => {
      this.books = data;
    }, error => {
      alert(`N'arrive pas à récupérer le getAllBooks ...`);
    });
  }

// id de la librairie de test ci-dessous  
// 3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0

}
