import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { PageNotFoundComponent } from 'src/app/shared/components/page-not-found/page-not-found.component';
import { ProfilComponent } from './profil/profil.component';

const routes: Routes = [
    {   
        path: '', 
        component: DashboardComponent, 
        children: [
            // { path: '', redirectTo: 'profil', pathMatch:'full' },
            { path: 'profil', component: ProfilComponent },
            { path: 'stocks', loadChildren: () => import(`../stocks-management/stocks-management.module`).then(m => m.StocksManagementModule) }, 
            { path: '**', component: PageNotFoundComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule { }