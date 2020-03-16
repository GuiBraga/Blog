import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';
import {AuthorModel} from '../models/author.model';
import {StaticService} from './static.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  private authors = new Subject<AuthorModel[]>();
  public authors$ = this.authors.asObservable();

  constructor(private http: HttpClient, private staticService: StaticService) {}

  getAuthors() {
    this.http.get(this.staticService.baseUrl + 'authors/all', this.staticService.httpOptions).subscribe(
      (response: AuthorModel[]) => {
        this.authors.next(response);
      }, (error) => {
        console.log(error);
      }
    );
    return this.authors$;
  }

  getAuthor(id: number) {
   return this.http.get(this.staticService.baseUrl + 'authors/' + id, this.staticService.httpOptions);
  }
}
