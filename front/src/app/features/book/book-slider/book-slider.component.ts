import { Component, Injectable, Input, OnInit } from '@angular/core';

import { BookItemModel } from '../../../core/models/book-item.model';

import { OwlOptions } from 'ngx-owl-carousel-o';
import { BookModel } from 'src/app/core/models/books.model';
import { Overlay } from '@angular/cdk/overlay';
import { ComponentPortal } from '@angular/cdk/portal';
import { BookDetailsComponent } from '../book-details/book-details.component';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';

@Component({
  selector: 'app-book-slider',
  templateUrl: './book-slider.component.html',
  styleUrls: ['./book-slider.component.scss']
})

export class BookSliderComponent implements OnInit {
  // title = `test`;
  @Input() title = ''; // decorate the property with @Input()
  
  @Input() books: Array<BookModel> = [
  new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: 'Le héros de l’histoire est insouciant, mais il est attiré par le charme et les plaisirs de la haute société. Il réfléchit, au travers de son expérience, reconstruite par sa mémoire',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51b3pKNydRL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: 'Le héros de l’histoire est insouciant, mais il est attiré par le charme et les plaisirs de la haute société. Il réfléchit, au travers de son expérience, reconstruite par sa mémoire',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51fUq9GSdlL._SY346_.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      year: 2000
    }),
    new BookModel( {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Zx+YW+o+L._SY346_.jpg',
      title: 'Vengeance glacée',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Mc2h+vQhL.jpg',
      title: 'Le dernier rituel',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51plZGnGurL._SY346_.jpg',
      title: 'Le Plus Grand Ennemi',
      synopsys: '',
      year: 2000
    }),
    new BookModel( {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51b3pKNydRL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51fUq9GSdlL._SY346_.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Zx+YW+o+L._SY346_.jpg',
      title: 'Vengeance glacée',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Mc2h+vQhL.jpg',
      title: 'Le dernier rituel',
      synopsys: '',
      year: 2000
    }),
    new BookModel({
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51plZGnGurL._SY346_.jpg',
      title: 'Le Plus Grand Ennemi',
      synopsys: '',
      year: 2000
    })
  ];

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 250,
    navText: ['', ''],
    responsive: {
      // 0: {
      //   items: 1
      // },
      // 400: {
      //   items: 2
      // },
      // 740: {
      //   items: 3
      // },
      // 940: {
      //   items: 4
      // }
      0: {
        items: 1
      },
      20: {
        items: 2
      },
      40: {
        items: 3
      },
      60: {
        items: 4
      },
      80: {
        items: 5
      },
      100: {
        items: 6
      }
    },
    nav: true
  }
  
  detailClicked: boolean = false;

  constructor(private truc : BookDetailsOverlayService) { 
  }
  

  // open() {
  //   // Returns an OverlayRef (which is a PortalHost)
  //   const overlayRef = this.overlay.create();

  //   // Create ComponentPortal that can be attached to a PortalHost
  //   const filePreviewPortal = new ComponentPortal(BookDetailsComponent);

  //   // Attach ComponentPortal to PortalHost
  //   overlayRef.attach(filePreviewPortal);
  // }
  
  openDetails(){
    // this.truc.openOverlay();
  }
  ngOnInit(): void {
    this.truc.update$.subscribe(updated => {
      this.detailClicked = this.truc.detailClicked;
      console.log(`slider detailCLicked service = ${this.truc.detailClicked} detailClicked slider = ${this.detailClicked}`);
    })
  }
}