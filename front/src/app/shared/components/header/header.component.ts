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

  home = {'title': 'Accueil', 'link': '/home', 'selected': false};
  dashboard = {'title': 'Tableau de bord', 'link': '/dashboard', 'selected': false};
  addbook = {'title':'Ajouter un livre', 'link':'/ajoutLivre','selected' : false};
  bookList = {'title':'Liste des livres', 'link':'/bookList', 'selected' : false};
  navigations: Navigation[] = [this.home, this.dashboard, this.addbook, this.bookList];

  constructor() { }

  ngOnInit(): void {
  }

}
