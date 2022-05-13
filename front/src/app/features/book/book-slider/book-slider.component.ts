import { Component, OnInit } from '@angular/core';

import { BookItemModel } from '../../../core/models/book-item.model';

@Component({
  selector: 'app-book-slider',
  templateUrl: './book-slider.component.html',
  styleUrls: ['./book-slider.component.scss']
})
export class BookSliderComponent implements OnInit {
  books: Array<BookItemModel> = [
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
    {
      image: 'https://images-na.ssl-images-amazon.com/images/I/71EuX4ow7LL.jpg',
      title: 'A la recherche du temps perdu',
      synopsys: '',
      author: '',
      year: 2000
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
