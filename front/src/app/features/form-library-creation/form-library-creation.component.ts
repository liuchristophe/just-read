import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { map } from 'rxjs';
import { AddressModel, LibraryModel } from 'src/app/core/models/library.model';
import { ApiService } from 'src/app/core/services/api.service';

@Component({
  selector: 'app-form-library-creation',
  templateUrl: './form-library-creation.component.html',
  styleUrls: ['./form-library-creation.component.scss']
})
export class FormLibraryCreationComponent implements OnInit {

  form!: FormGroup;

  libraryToCreate?: LibraryModel ;

  address?: AddressModel;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(''),
      urlImage: new FormControl(''),
      address: new FormControl(''),
      description: new FormControl('')
    });
  }

  //Extraire l'attitude et longitude de l'api
  async createAddressInformations(address : string) : Promise<any> {
    return new Promise((resolve, reject) => {
      this.apiService
        .getAdresse$(address)
        .pipe()
        .subscribe(result => {
          if (result) {
            let data: any = result;
            console.log(`récup le premier result`);
            if (data.features.length >= 1)  {
              console.log(`true`);
              resolve(data.features[0]);
            }
            else {
              console.log(`false `);
            }
            return;
          }
          console.log('noooo error');
          reject(new Error('AAAAAAAA, address null !!!!!'));
          return;
        });
    }); 
  }

  async onSubmit(){
    // console.log(JSON.stringify(this.createAddressInformations(this.form.get('address')?.value)));
    await this.createLibraryModel();
    if (this.libraryToCreate) {
      this.apiService.createLibrary$(this.libraryToCreate).subscribe(() => {
        alert(`BRAVOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO`);
      }, error => {
        alert(`Echoué ...`);
      });
    }    
    // console.log('ou suis jeeeeee!!!!!');
  }

  async createAddressModel() {
    console.log(JSON.stringify(this.form.get('address')?.value));
    if (this.form.get('address')?.value) {
      console.log('coucou 1');
      let adress;
      await this.createAddressInformations(this.form.get('address')?.value)
        .then(data => {
          console.log(`promise return: `+JSON.stringify(data));
          let address = data;
          this.address = {
            'id': '',
            'streetName': address.properties.label,
            'complementaryField': '',
            'zipCode': address.properties.postcode,
            'city': address.properties.city,
            'country': address.properties.country,
            'latitude': address.geometry.coordinates[1],
            'longitude': address.geometry.coordinates[0]
          };
          console.log(JSON.stringify(this.address));
  
        })
        .catch(error => { 
          alert(`erreur lors de l'attribution de l'adresse ...`)
          console.log('rip ...');
        });


      console.log(`ici c le post librairie`);
        
    }
    else {
      console.log('ah c toi le coupable');
    }
  }

  async createLibraryModel(){
    await this.createAddressModel();
    let address = this.address;
    if (address) {
      let library = {
        'id' : '',
        'name': this.form.get('name')?.value,
        'address': address,
        'urlImage': this.form.get('urlImage')?.value,
        'description': this.form.get('description')?.value,
        'stocks': [],
        'orders': []
      };
      this.libraryToCreate = library;
      console.log(this.libraryToCreate);
    }
    else {
      console.log(`y'a rien`);
    }
  }
  
}