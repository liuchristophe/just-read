import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  appelleAPI() {
    this.httpClient.get<Test>(`/api/books`).subscribe(res => {
      console.log(`resultat : ${JSON.stringify(res)}`);
    }, error => {
      console.error(`erreur : ${JSON.stringify(error)}`);
    })
  }

}

interface Test {
  message: string;
}