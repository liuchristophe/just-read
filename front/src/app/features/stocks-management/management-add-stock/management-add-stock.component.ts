import { Component, OnInit } from '@angular/core';
import { ManagementCardModel } from 'src/app/core/models/management-card-type.model';

@Component({
  selector: 'app-management-add-stock',
  templateUrl: './management-add-stock.component.html',
  styleUrls: ['./management-add-stock.component.scss']
})
export class ManagementAddStockComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  getManagementType() {
    console.log(`va retourné un post ${JSON.stringify(ManagementCardModel.POST)}`)
    return ManagementCardModel.POST;
  }
}
