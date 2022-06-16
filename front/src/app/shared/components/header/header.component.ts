import { Component, OnInit } from '@angular/core';

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
  dashboard = {'title': 'Tableau de bord', 'link': '/dashboard/' + this.libraryId, 'selected': false};
  addbook = {'title':'Ajouter un livre', 'link':'/ajoutLivre','selected' : false};
  bookList = {'title':'Liste des livres', 'link':'/bookList', 'selected' : false};
  navigations: Navigation[] = [this.home, this.dashboard, this.addbook, this.bookList];
/*
  dashboard = {'title': 'Tableau de bord', 'link': '/dashboard', 'selected': false};
  bookList = {'title':'Liste des livres', 'link':'/liste_livres', 'selected' : false};
  navigations: Navigation[] = [this.home, this.dashboard, this.bookList];
*/

  constructor() { }

  ngOnInit(): void {
  }

}
