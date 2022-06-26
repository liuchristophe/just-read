import { Component, OnInit } from '@angular/core';
import { ManagementCardModel } from 'src/app/core/models/management-card-type.model';

@Component({
  selector: 'app-management-display-stock',
  templateUrl: './management-display-stock.component.html',
  styleUrls: ['./management-display-stock.component.scss']
})
export class ManagementDisplayStockComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  getManagementType() {
    return ManagementCardModel.UPDATE;
  }
}
