import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Books, Review } from './models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<Books[]> {
    return this.http.get<Books[]>(`${this.baseUrl}/viewBooks`);
  }

  addReview(review: Review, id: number): Observable<Review> {
    return this.http.post<Review>(`${this.baseUrl}/addReview/${id}`, review);
  }

  getReviewsByBookId(bookId: number): Observable<Review[]> {
    return this.http.get<Review[]>(`${this.baseUrl}/viewReviews/${bookId}`);
  }

}
