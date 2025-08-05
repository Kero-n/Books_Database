import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Review } from '../models';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
  review: Review = {
    id: 0,
    bookId: 0,
    reviewerName: '',
    rating: 0,
    comment: ''
  };
  gigi!: number;

  constructor(
    private booksService: BooksService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  onSubmit(): void {
    this.gigi = this.route.snapshot.params['id'];
    this.review.bookId = this.gigi;
    this.booksService.addReview(this.review, this.gigi).subscribe(
      data => {
        console.log(data);
        this.goToHome();
      },
      error => {
        console.log(error);
      }
    );
  }

  goToHome(){
    this.router.navigate(['/']);
  }
}
