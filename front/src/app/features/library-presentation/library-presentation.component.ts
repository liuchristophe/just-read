import { Component, Input, OnInit } from '@angular/core';
import { BookModel } from 'src/app/core/models/books.model';
import { LibraryModel } from 'src/app/core/models/library.model';

@Component({
  selector: 'app-library-presentation',
  templateUrl: './library-presentation.component.html',
  styleUrls: ['./library-presentation.component.scss']
})
export class LibraryPresentationComponent implements OnInit {
  books: Array<BookModel> = [
    {
      id: "",
      categories: Array(),
      isbn: "",
      publisher: {name: ""},
      urlImage: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: 'Le héros de l’histoire est insouciant, mais il est attiré par le charme et les plaisirs de la haute société. Il réfléchit, au travers de son expérience, reconstruite par sa mémoire',
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
      synopsys: 'Le héros de l’histoire est insouciant, mais il est attiré par le charme et les plaisirs de la haute société. Il réfléchit, au travers de son expérience, reconstruite par sa mémoire',
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
  @Input() library!: LibraryModel;
  constructor() { }

  ngOnInit(): void {
  }

}
