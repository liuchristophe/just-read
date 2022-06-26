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
  ];
  @Input() library!: LibraryModel;
  constructor() { }

  ngOnInit(): void {
  }

}
