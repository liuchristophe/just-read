import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { BookModule } from './book/book.module';
import { DashboardModule } from './dashboard/dashboard.module';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule,
    DashboardModule
  ],
  exports:[
    BookModule
  ]
})
export class FeaturesModule { }
