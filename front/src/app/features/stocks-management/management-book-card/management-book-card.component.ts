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

  get bookImage(): string | undefined {
    let res = this.stock?.book.urlImage;
    if (res){
    console.log("bookImage for id",res);
      return res;
  }else {
      console.log("bookImage stock: ", this.stock)
      return 'https://binaries.templates.cdn.office.net/support/templates/fr-fr/lt22301254_quantized.png';
    }
  }

  getTitle() {
    if (this.stock?.book.title) 
      return this.stock.book.title;
    else {
      alert(`title is undefined ...`);
      return '';
    } 
  }

  submit() {
    console.log(this.type);
    if (this.type) {
      if (this.type.valueOf() === ManagementCardModel.POST.valueOf()) {
        this.addStock();
      }   
      else if (this.type.valueOf() === ManagementCardModel.UPDATE.valueOf()) {
        this.updateStock();
      }

    }
    else {
      alert(`le management stock card n'a pas de type!!!`);
    }
  }

  addStock(){
    console.log(`addStock déclenché ...`);
    if (this.stock) {
      this.stockItem = new StockModel({quantity:this.formData.value.quantity, unitPrice: this.formData.value.unitPrice, book:this.stock.book, id:''});
      console.log(`${JSON.stringify(this.stockItem)}`);
      this.apiService.addStock$(this.idLibrary,this.stockItem).subscribe();
      console.log(this.stockItem);
    }
    else {
      this.messageErreurObjetStock();
    }
  }

  updateStock(){
    console.log('updateStock déclenché')
    if (this.stock) {
      this.stockItem = new StockModel({quantity: this.formData.value.quantity, unitPrice:this.formData.value.unitPrice, book:this.stock.book, id:''});
      console.log(`${JSON.stringify(this.stockItem)}`);
      if (this.stockItem.id){
        this.apiService.updateStock$(this.idLibrary, this.stockItem.id, this.stockItem).subscribe();
      } 
      else 
        this.messageErreurStockId()
    }
    else {
      this.messageErreurObjetStock();
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

  private messageErreurObjetStock() {
    alert(`Erreur dans le code`);
    console.debug(`le management book card n'a pas d'information`);
  }

  private messageErreurStockId() {
    alert(`Erreur dans le code`);
    console.debug(`lors de l'update, il y a pas d'id`);
  }
}
