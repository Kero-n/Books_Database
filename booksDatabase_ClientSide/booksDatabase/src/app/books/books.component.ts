import { Component, OnInit } from '@angular/core';
import { Books } from '../models';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrl: './books.component.css'
})
export class BooksComponent implements OnInit {
  books: Books[] = [];

  constructor(private booksService: BooksService, private router: Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks(): void {
    this.booksService.getAllBooks()
      .subscribe(books => this.books = books);
  }

  giveReviews(id: number): void{
    this.router.navigate(['reviews', id ])
  }

  viewReviews(id: number): void{
    this.router.navigate(['viewReviews', id])
  }

}
