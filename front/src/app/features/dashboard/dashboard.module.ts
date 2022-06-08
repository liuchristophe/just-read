import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DashboardRoutingModule } from './dashboard-routing.module';

import { DashboardComponent } from './dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';
import { MatMenuModule } from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';

@NgModule({
    declarations: [
      DashboardComponent,
      SidebarComponent
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
      MatDividerModule
    ],
    exports: []
  })
  export class DashboardModule { }