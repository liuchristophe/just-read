import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';



@NgModule({
  declarations: [
    FormAjoutLivreComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    FormAjoutLivreComponent
  ]
})
export class FeaturesModule { }
