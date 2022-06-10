import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ComponentsModule } from './components/components.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';
import { MatMenuModule } from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    ComponentsModule,
    MatDividerModule,
    MatListModule,
    FlexLayoutModule,
    MatMenuModule,
    RouterModule

  ],
  exports: [
    ComponentsModule
  ]
})
export class SharedModule { }
