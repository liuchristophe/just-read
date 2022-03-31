import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentsModule } from './components/components.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ComponentsModule
  ],
  exports: [
    ComponentsModule,
    RouterModule
  ]
})
export class SharedModule { }
