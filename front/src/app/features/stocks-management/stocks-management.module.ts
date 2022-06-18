import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';

import { StocksManagementRoutingModule } from './stocks-management-routing.module';

import { StocksManagementComponent } from './stocks-management.component';
import { StocksListComponent } from './stocks-list/stocks-list.component';
import { ManagementBookCardComponent } from './management-book-card/management-book-card.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ManagementAddStockComponent } from './management-add-stock/management-add-stock.component';
import { ManagementDisplayStockComponent } from './management-display-stock/management-display-stock.component';

import {NgPipesModule} from 'ngx-pipes';

@NgModule({
  declarations: [
    StocksManagementComponent, 
    StocksListComponent, 
    ManagementBookCardComponent, 
    ManagementAddStockComponent, 
    ManagementDisplayStockComponent
  ],
  imports: [
    CommonModule
    , StocksManagementRoutingModule
    , MatIconModule,
    ReactiveFormsModule,
    NgPipesModule
  ],
  exports: [

  ]
})
export class StocksManagementModule { }
