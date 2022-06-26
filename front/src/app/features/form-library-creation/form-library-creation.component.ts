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
  async createAddressInformations(address : string) : Promise<AddressModel> {
    return new Promise((resolve, reject) => {
      this.apiService
        .getAdresse$(address)
        .pipe()
        .subscribe(result => {
          if (result) {
            console.log('récup le premier result');
            if (result.length >= 1) resolve(result[0]);
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
    console.log(JSON.stringify(this.form.get('address')?.value));
    if (this.form.get('address')?.value) {
      console.log('coucou 1');
      let adress;
      await this.createAddressInformations(this.form.get('address')?.value)
        .then(address => {console.log("coucou 2, "+JSON.stringify(address))})
        .catch(error => console.log('rip ...'));
    }
    else {
      console.log('ah c toi le coupable');
    }
    console.log('ou suis je');
  }

  
}