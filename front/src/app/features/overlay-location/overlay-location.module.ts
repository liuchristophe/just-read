
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { OverlayModule } from '@angular/cdk/overlay';
import { A11yModule } from '@angular/cdk/a11y';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatDividerModule } from '@angular/material/divider';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { OverlayLocationComponent } from './overlay-location.component';

@NgModule({
declarations: [OverlayLocationComponent],
imports: [
  CommonModule,
  MatInputModule,
  MatFormFieldModule,
  MatIconModule,
  OverlayModule,
  A11yModule,
  MatSlideToggleModule,
  MatDividerModule,
  ReactiveFormsModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatButtonModule,
],
exports: [
OverlayLocationComponent,
] })
export class OverlayLocationModule { }
