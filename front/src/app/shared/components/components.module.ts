import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';

import { AngularComponent } from './angular/angular.component';
import { HeaderComponent } from './header/header.component';



@NgModule({
  declarations: [
    AngularComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  exports: [
    HeaderComponent,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ]
})
export class ComponentsModule { }
