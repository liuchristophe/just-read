import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { PageNotFoundComponent } from 'src/app/shared/components/page-not-found/page-not-found.component';
import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';

const routes: Routes = [
    {   
        path: '', 
        component: DashboardComponent, 
        children: [
            { path: 'ajout_livre', component: FormAjoutLivreComponent },
            { path: '**', component: PageNotFoundComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule { }