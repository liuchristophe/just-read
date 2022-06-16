import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
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

@NgModule({
    declarations: [
      DashboardComponent,
      SidebarComponent,
      FormAjoutLivreComponent
    ],
    imports: [
      CommonModule,
      DashboardRoutingModule,
      FormsModule,
      MatSidenavModule,
      FlexLayoutModule,
      RouterModule,
      MatMenuModule,
      MatListModule,
      MatDividerModule,
      StocksManagementModule
    ],
    exports: []
  })
  export class DashboardModule { }