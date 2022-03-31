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

  navigations: Navigation[] = [this.home, this.dashboard];

  constructor() { }

  ngOnInit(): void {
  }

}
