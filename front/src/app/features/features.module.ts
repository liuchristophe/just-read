import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FormAjoutLivreComponent } from './dashboard/form-ajout-livre/form-ajout-livre.component';
import { BookModule } from './book/book.module';
// import { DashboardComponent } from './dashboard/dashboard.component';
// import { SidebarComponent } from './dashboard/sidebar/sidebar.component';


import { DashboardModule } from './dashboard/dashboard.module';

@NgModule({
  declarations: [
    FormAjoutLivreComponent,
    // DashboardComponent,
    // SidebarComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule,
    DashboardModule
  ],
  exports:[
    FormAjoutLivreComponent,
    BookModule
  ]
})
export class FeaturesModule { }
