export interface Books {
    id: number;
    title: string;
    authorName: string;
    price: number;
}
  
export interface Review {
    id: number;
    bookId: number;
    reviewerName: string;
    rating: number;
    comment: string;
}