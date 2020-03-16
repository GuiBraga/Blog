import {AfterViewInit, Component, OnInit} from '@angular/core';
import {AuthorModel} from '../../../models/author.model';
import {AuthorService} from '../../../services/author.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todos',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit, AfterViewInit {

  authors: AuthorModel[] = [];
  constructor(private authorService: AuthorService, private router: Router) { }

  ngOnInit() {
    this.authorService.getAuthors();
  }

  ngAfterViewInit(): void {
    this.authorService.authors$.subscribe(
      (authors: AuthorModel[]) => {
        this.authors = authors;
      }
    );
  }

  onShowComments(id: number) {
  }

  onCreateAuthor() {
  }
}
