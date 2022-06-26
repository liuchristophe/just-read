import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from 'src/app/shared/components/page-not-found/page-not-found.component';
import { StocksManagementComponent } from './stocks-management.component';
import { ManagementAddStockComponent } from './management-add-stock/management-add-stock.component';
import { ManagementDisplayStockComponent } from './management-display-stock/management-display-stock.component';

const routes: Routes = [
    {   
        path: '', 
        component: StocksManagementComponent, 
        children: [
            { path: '', component: ManagementDisplayStockComponent },
            { path: 'ajout', component: ManagementAddStockComponent },
            { path: '**', component: PageNotFoundComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StocksManagementRoutingModule { }