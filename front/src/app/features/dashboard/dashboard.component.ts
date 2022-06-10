import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { LibraryModel } from 'src/app/core/models/library.model';
import { LibraryUpdateModel } from 'src/app/core/models/library-update.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  @Input() library!: LibraryModel;

  titleEdit   = false;
  addressEdit = false;

  constructor( private route:ActivatedRoute, private http: HttpClient ) { }

  ngOnInit(): void {
    this.loadLibrary();
  }

  /**| API |**/

  loadLibrary() {
    const libraryId = this.route.snapshot.paramMap.get('id');
    this.getLibraryById(libraryId).subscribe( data => this.library = data );
  }
  getLibraryById(id: string | null) : Observable<any> {
    let url = `api/library/${id}`;
    return this.http.get(url);
  }
  updateLibrary(id: string, data:LibraryUpdateModel) {
    let url = `api/library/${id}`;
    return this.http.patch(url, data);
  }

  /**| BUTTON CONTROLS |**/

  toggleTitleEdit   () { this.titleEdit   = !this.titleEdit;   }
  toggleAddressEdit () { this.addressEdit = !this.addressEdit; }

  /** TITLE **/

  updateTitle() {
    let libraryUpdate: LibraryUpdateModel = { name: this.library.name, address: null };
    this.updateLibrary( this.library.id, libraryUpdate ).subscribe(data => { console.log(data) })
    this.toggleTitleEdit();
  }
  resetTitle() {}

  /** ADDRESS **/

  updateAddress() {
    let libraryUpdate: LibraryUpdateModel = { name: null, address: this.library.address };
    this.updateLibrary( this.library.id, libraryUpdate ).subscribe(data => { console.log(data) })
    this.toggleAddressEdit();
  }
  resetAddress() {}
}
