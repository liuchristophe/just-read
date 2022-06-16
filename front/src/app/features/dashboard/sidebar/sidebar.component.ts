import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  links = [
    {
      title: 'Profil de ma librairie',
      redirection: 'profil'
    },
    {
      title: 'Gestion de stocks',
      redirection: 'stocks'
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
