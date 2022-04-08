import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormAjoutLivreComponent } from './features/form-ajout-livre/form-ajout-livre.component';
import { HomeComponent } from './shared/components/home/home.component';
import { PageNotFoundComponent } from './shared/components/page-not-found/page-not-found.component';
import { BookListComponent } from './features/book-list/book-list.component';
const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'ajoutLivre', component: FormAjoutLivreComponent},
  {path : 'bookList',component: BookListComponent}, 
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
