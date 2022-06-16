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
  descriptionEdit = false;
  imageEdit = false;

  constructor( private route:ActivatedRoute, private http: HttpClient ) { }

  ngOnInit(): void {
    this.loadLibrary();
  }

  /**| API |**/

  loadLibrary() {
    const libraryId = this.route.snapshot.paramMap.get('id');
    this.getLibraryById$(libraryId).subscribe( data => this.library = data );
  }
  getLibraryById$(id: string | null) : Observable<any> {
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
  toggleImageEdit   () { this.imageEdit   = !this.imageEdit;   }
  toggleDescriptionEdit () { this.descriptionEdit = !this.descriptionEdit; }
  resetEdit() { 
    this.titleEdit   = false;
    this.addressEdit = false;
    this.descriptionEdit = false;
    this.imageEdit = false;
  }

  /** SUBMIT **/

  updateOnSubmit() {
    let libraryUpdate: LibraryUpdateModel = { 
      name: this.library.name,
      address: this.library.address,
      urlImage: this.library.urlImage,
      description: this.library.description 
    };
    this.updateLibrary( this.library.id, libraryUpdate ).subscribe(data => { console.log(data) })
    this.resetEdit();
  }

  resetAll() {
    this.loadLibrary();
    this.resetEdit();
  }

}
