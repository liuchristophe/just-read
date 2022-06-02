import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { LibraryModel } from 'src/app/core/models/library.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  @Input() library!: LibraryModel;

  constructor( private route:ActivatedRoute, private http: HttpClient ) { }

  ngOnInit(): void {
    this.loadLibrary();
  }

  loadLibrary() {
    const libraryId = this.route.snapshot.paramMap.get('id');
    this.getLibraryById(libraryId).subscribe(
      data => this.library = data
    );
  }
  getLibraryById(id: string | null) : Observable<any> {
    let url = `api/library/${id}`;
    return this.http.get(url);
  }

}
