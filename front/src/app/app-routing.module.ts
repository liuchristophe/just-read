import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormAjoutLivreComponent } from './features/dashboard/form-ajout-livre/form-ajout-livre.component';
import { HomeComponent } from './shared/components/home/home.component';
import { PageNotFoundComponent } from './shared/components/page-not-found/page-not-found.component';
import { BookDetailsComponent } from './features/book/book-details/book-details.component';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { FormLibraryCreationComponent } from './features/form-library-creation/form-library-creation.component';

const routes: Routes = [
  {path : '',redirectTo:'home', pathMatch:'full'},
  {path : 'home', component: HomeComponent},
  {path : 'libraryCreation', component: FormLibraryCreationComponent },
  {path : 'dashboard', loadChildren: () => import(`./features/dashboard/dashboard.module`).then(m => m.DashboardModule) },
  {path : '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
