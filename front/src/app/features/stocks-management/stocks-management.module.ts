import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';

import { StocksManagementRoutingModule } from './stocks-management-routing.module';

import { StocksManagementComponent } from './stocks-management.component';
import { StocksListComponent } from './stocks-list/stocks-list.component';
import { ManagementBookCardComponent } from './management-book-card/management-book-card.component';


@NgModule({
  declarations: [
    StocksManagementComponent
    , StocksListComponent
    , ManagementBookCardComponent
  ],
  imports: [
    CommonModule
    , StocksManagementRoutingModule
    , MatIconModule
  ],
  exports: [

  ]
})
export class StocksManagementModule { }
