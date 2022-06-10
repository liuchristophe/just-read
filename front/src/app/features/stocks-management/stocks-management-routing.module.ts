import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from 'src/app/shared/components/page-not-found/page-not-found.component';
import { StocksManagementComponent } from './stocks-management.component';


const routes: Routes = [
    {   
        path: '', 
        component: StocksManagementComponent, 
        children: [
            { path: '**', component: PageNotFoundComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StocksManagementRoutingModule { }