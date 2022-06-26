import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { RouterModule } from '@angular/router';

import { AngularComponent } from './angular/angular.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BannerComponent } from './banner/banner.component';
import { FeaturesModule } from 'src/app/features/features.module';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [
    AngularComponent,
    HeaderComponent,
    HomeComponent,
    PageNotFoundComponent,
    BannerComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    RouterModule,
    FeaturesModule
  ],
  exports: [
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    HeaderComponent,
    HomeComponent,
    PageNotFoundComponent,
    BannerComponent,
    FooterComponent
  ]
})
export class ComponentsModule { }
