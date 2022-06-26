import { Component, OnInit } from '@angular/core';
import { ManagementCardModel } from 'src/app/core/models/management-card-type.model';

@Component({
  selector: 'app-stocks-management',
  templateUrl: './stocks-management.component.html',
  styleUrls: ['./stocks-management.component.scss']
})
export class StocksManagementComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  getManagementType() {
    return ManagementCardModel.UPDATE;
  }
}
