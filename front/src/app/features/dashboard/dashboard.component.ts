import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
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

  titleId = "library-name"
  titleEdit   = false;
  addressEdit = false;

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

  /** title edit **/
  toggleTitleEdit() { this.titleEdit = !this.titleEdit; }

  updateTitle() {
    var name = document.querySelector(this.titleId)?.innerHTML; 
    if (name && ( name == this.library.name || name?.length <= 3 ) ) {
      this.library.name = name;
      /** Todo : faire l'update en base  **/
    }
    this.toggleTitleEdit();
  }

  resetTitle() {
    const tag = document.querySelector(this.titleId);
    var name  = tag?.innerHTML; 
    if (tag && name != this.library.name)  tag.innerHTML = this.library.name;
    this.toggleTitleEdit();
  }

  /** address edit **/
  toggleAddressEdit () {
    this.addressEdit = !this.addressEdit;
  }
}
