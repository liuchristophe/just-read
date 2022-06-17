import { Component, OnInit, Input } from '@angular/core';
import { map } from 'rxjs';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { StockModel } from 'src/app/core/models/library.model';
import { ManagementCardModel } from 'src/app/core/models/management-card-type.model';
import { ApiService } from 'src/app/core/services/api.service';

@Component({
  selector: 'app-stocks-list',
  templateUrl: './stocks-list.component.html',
  styleUrls: ['./stocks-list.component.scss']
})
export class StocksListComponent implements OnInit {

  // books = [this.book1, this.book2];
  stocks?: StockModel[];
  idLibrary = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';
  @Input() type ?: ManagementCardModel;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    console.log(`stock list appelé`);
    if(this.type){
      console.log(`stock list a un type`);
      if(this.type.valueOf() === ManagementCardModel.POST.valueOf() ){
        console.log(`type est ${this.type}`);
        this.apiService.getAllBooks$()
        .pipe(map(x=>{
          let stockModel: StockModel[] = [];
          x.forEach(book => {stockModel.push(new StockModel(0, 0, book, undefined))});
          console.log(`${JSON.stringify(x)}`)
          return stockModel;
        }))
        .subscribe((data) => {
          this.stocks = data;
        }, error => {
          alert(`N'arrive pas à récupérer le getAllBooks ...`);
        });
      }
      else if(this.type.valueOf() === ManagementCardModel.UPDATE.valueOf()){
        console.log(`type est ${this.type}`);
        this.apiService.getStock$(this.idLibrary)
        .pipe()
        .subscribe((data) => {
          this.stocks = data;
        }, error => {
          alert(`N'arrive pas à récupérer le getStock ...`);
        });
      }
    }
    else {
      console.log(`stock list n'a pas de type`);
    }
  }

  getCardType() {
    return ManagementCardModel.UPDATE;
  }

  

// id de la librairie de test ci-dessous  
// 3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0

}
