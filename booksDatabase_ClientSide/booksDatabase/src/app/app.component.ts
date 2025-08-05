import { Component, OnInit } from '@angular/core';
import { Books } from './models';
import { BooksService } from './books.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  books: Books[] = [];
  title = 'Books Database';

  constructor(private booksService: BooksService) {}

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks(): void {
    this.booksService.getAllBooks().subscribe(books => this.books = books);
  }
}
