import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { LibraryModel } from 'src/app/core/models/library.model';
import { LibraryUpdateModel } from 'src/app/core/models/library-update.model';
import { AdminService } from 'src/app/core/services/admin.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  @Input() library!: LibraryModel;

  titleEdit   = false;
  addressEdit = false;
  descriptionEdit = false;
  

  constructor( private route:ActivatedRoute, private http: HttpClient, private adminService: AdminService ) { }

  ngOnInit(): void {
    // this.adminService.update$.subscribe()
    this.loadLibrary();
  }

  /**| API |**/

  async loadLibrary() {
    // const libraryTest_id = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';
    // const libraryId = this.route.snapshot.paramMap.get('id');
    let libraryId= '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';
    
    // console.log('attend');
    // await this.getLibraryId()
    //   .then(data => {libraryId = data})
    //   .catch(error => {alert('probleme lors du récupération id')});
    // console.log(`retour: ${libraryId}`);

    // if(libraryId != libraryTest_id){
    // this.getLibraryById$(libraryId).subscribe( data => this.library = data );
    // }
    // else{
    //   this.getLibraryById$(libraryTest_id).subscribe( data => this.library = data );
    // }
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
  toggleDescriptionEdit () { this.descriptionEdit = !this.descriptionEdit; }
  resetEdit() { 
    this.titleEdit   = false;
    this.addressEdit = false;
    this.descriptionEdit = false;
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

  async getLibraryId(): Promise<string> {
    console.log(`dans la methode getLibraryId`)
    return new Promise((resolve, reject) => {
      this.adminService.update$.subscribe(() => {
        console.log(`id = ${this.adminService.library_id}`);
        resolve(this.adminService.library_id);
        return;
      }, error => {
        console.log(`erreur`);
        reject(new Error('erreur inconnue'));
        return;
      })
    })
  }
}
