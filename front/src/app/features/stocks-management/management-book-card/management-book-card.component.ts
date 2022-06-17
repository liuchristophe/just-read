import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { StockModel } from 'src/app/core/models/library.model';
import { ApiService } from 'src/app/core/services/api.service';
import { BookCardComponent } from '../../book/book-card/book-card.component';
@Component({
  selector: 'app-management-book-card',
  templateUrl: './management-book-card.component.html',
  styleUrls: ['./management-book-card.component.scss']
})
export class ManagementBookCardComponent implements OnInit {

  @Input() book?: BookModel;

  formData!: FormGroup;
  
  stockItem?: StockModel;
  
  idLibrary = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.formData= new FormGroup({
      quantity: new FormControl(),
      unitPrice: new FormControl()
    });
  }

  getImage() {
    return this.book?.urlImage;
  }

  getTitle() {
    return this.book?.title;
  }

  addStock(){
    console.log(`addStock déclanché ...`);
    if (this.book) {
      this.stockItem = new StockModel(this.formData.value.quantity, this.formData.value.unitPrice, this.book);
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
