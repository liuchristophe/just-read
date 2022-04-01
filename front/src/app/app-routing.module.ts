import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormAjoutLivreComponent } from './features/form-ajout-livre/form-ajout-livre.component';
import { HomeComponent } from './shared/components/home/home.component';
import { PageNotFoundComponent } from './shared/components/page-not-found/page-not-found.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '**', component: PageNotFoundComponent},
  {path: 'ajoutLivre', component: FormAjoutLivreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
