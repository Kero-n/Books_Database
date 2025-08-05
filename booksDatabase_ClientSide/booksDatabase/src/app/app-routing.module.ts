import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './books/books.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { ViewReviewsComponent } from './view-reviews/view-reviews.component';

const routes: Routes = [
  {path: 'books', component: BooksComponent},
  {path: 'reviews/:id', component: ReviewsComponent},
  {path: 'viewReviews/:id', component: ViewReviewsComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
