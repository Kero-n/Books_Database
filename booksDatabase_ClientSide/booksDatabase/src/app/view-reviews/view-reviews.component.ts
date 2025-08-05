import { Component, OnInit } from '@angular/core';
import { Review } from '../models';
import { ActivatedRoute } from '@angular/router';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-view-reviews',
  templateUrl: './view-reviews.component.html',
  styleUrl: './view-reviews.component.css'
})
export class ViewReviewsComponent implements OnInit{
  id!: number;
  review!: Review;

  constructor(private route: ActivatedRoute,private booksService: BooksService){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.review = {
      id: 0,
      bookId: 0,
      reviewerName: '',
      rating: 0,
      comment: ''
    };
  
    this.booksService.getReviewsByBookId(this.id).subscribe(data => {
      if (data && data.length > 0) {
        this.review = data[0];
      }
    });
  }
}
