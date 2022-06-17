import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { StockModel } from 'src/app/core/models/library.model';
import { ApiService } from 'src/app/core/services/api.service';
import { BookCardComponent } from '../../book/book-card/book-card.component';
import { ManagementCardModel } from 'src/app/core/models/management-card-type.model';

@Component({
  selector: 'app-management-book-card',
  templateUrl: './management-book-card.component.html',
  styleUrls: ['./management-book-card.component.scss']
})
export class ManagementBookCardComponent implements OnInit {

  @Input() stock?: StockModel;
  @Input() type?: ManagementCardModel;

  formData!: FormGroup;
  
  stockItem?: StockModel;
  
  idLibrary = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.formData= new FormGroup({
      quantity: new FormControl(this.stock?.quantity),
      unitPrice: new FormControl(this.stock?.unitPrice)
    });
  }

  getImage() {
    return this.stock?.book.urlImage;
  }

  getTitle() {
    return this.stock?.book.title;
  }

  submit() {
    if (this.type) {
      if (this.type === 1) {
        this.addStock();
      }
      else if (this.type === 2) {

      }

    }
    else {
      alert(`le management stock card n'a pas de type!!!`);
    }
  }

  addStock(){
    console.log(`addStock déclanché ...`);
    if (this.stock) {
      this.stockItem = new StockModel(this.formData.value.quantity, this.formData.value.unitPrice, this.stock.book);
      console.log(`${JSON.stringify(this.stockItem)}`);
      this.apiService.addStock$(this.idLibrary,this.stockItem).subscribe();
      console.log(this.stockItem);
    }
    else {
      alert(``);
    }
  }

  // addStock( idLibrary : string, stockItem : StockModel ){
  //   this.apiService.addStock$(idLibrary, stockItem);
  //   console.log("déclenchement de la fonction d'ajout de stock");
  // }
  
  // $scope.addStock=function(){
  //   var StockModel={
      
  //     id: "",

  //     quantity: $scope.quantity,

  //     unitPrice: $scope.unitPrice

  //     book: this.book
  //   };
  // }

}
