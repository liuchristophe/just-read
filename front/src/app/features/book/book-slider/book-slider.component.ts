import { Component, Input, OnInit } from '@angular/core';

import { BookItemModel } from '../../../core/models/book-item.model';

import { OwlOptions } from 'ngx-owl-carousel-o';
import { BookModel } from 'src/app/core/models/books.model';

@Component({
  selector: 'app-book-slider',
  templateUrl: './book-slider.component.html',
  styleUrls: ['./book-slider.component.scss']
})
export class BookSliderComponent implements OnInit {
  // title = `test`;
  @Input() title = ''; // decorate the property with @Input()
  @Input() books: Array<BookModel> = [
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51b3pKNydRL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51fUq9GSdlL._SY346_.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Zx+YW+o+L._SY346_.jpg',
      title: 'Vengeance glacée',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Mc2h+vQhL.jpg',
      title: 'Le dernier rituel',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51plZGnGurL._SY346_.jpg',
      title: 'Le Plus Grand Ennemi',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51b3pKNydRL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51fUq9GSdlL._SY346_.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Zx+YW+o+L._SY346_.jpg',
      title: 'Vengeance glacée',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51Mc2h+vQhL.jpg',
      title: 'Le dernier rituel',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://m.media-amazon.com/images/I/51plZGnGurL._SY346_.jpg',
      title: 'Le Plus Grand Ennemi',
      synopsys: '',
      author: '',
      year: 2000
    }
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

  constructor() { }

  ngOnInit(): void {
  }
}