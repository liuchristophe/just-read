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
  navigations: Navigation[] = [
    {'title': 'Accueil', 'link': '/', 'selected': false},
    {'title': 'Tableau de bord', 'link': '/dashboard', 'selected': false},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
