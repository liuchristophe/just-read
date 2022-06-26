import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSidenavModule } from '@angular/material/sidenav';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';
import { MatMenuModule } from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';

import { DashboardRoutingModule } from './dashboard-routing.module';

import { DashboardComponent } from './dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';
import { StocksManagementModule } from '../stocks-management/stocks-management.module';
import { ProfilComponent } from './profil/profil.component';

@NgModule({
    declarations: [
      DashboardComponent,
      SidebarComponent,
      FormAjoutLivreComponent,
      ProfilComponent
    ],
    imports: [
      CommonModule,
      DashboardRoutingModule,
      FormsModule,
      ReactiveFormsModule,
      MatSidenavModule,
      FlexLayoutModule,
      RouterModule,
      MatMenuModule,
      MatListModule,
      MatDividerModule,
      StocksManagementModule
    ],
    exports: [      
      ReactiveFormsModule
    ]
  })
  export class DashboardModule { }