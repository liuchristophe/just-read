import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AdminPanelDialogComponent } from 'src/app/features/admin-panel-dialog/admin-panel-dialog.component';

interface Navigation {
  title: string,
  link: string,
  selected: boolean
}

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  
  /** Todo : remplacer par l'id de la librairie connectée **/
  libraryId = "3e5bcb50-fd09-4e80-85d0-42d787b20596"; //"735cee1b-7e87-4d3e-a58a-7d02d7bcc9ae";

  home = {'title': 'Accueil', 'link': '/home', 'selected': false};
  creationLibrary = {'title': 'Créer ma librairie', 'link': 'libraryCreation', 'selected': false};
  dashboard = {'title': 'Tableau de bord', 'link': '/dashboard/', 'selected': false};
  navigations: Navigation[] = [this.home, this.dashboard, this.creationLibrary];

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openAdminPanelDialog() {
    const dialogRef = this.dialog.open(AdminPanelDialogComponent, {
      width: '500px',
      height: '500px'
    });
  }

}
