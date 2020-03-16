import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorService} from '../../../../services/author.service';
import {AuthorModel} from '../../../../models/author.model';

@Component({
  selector: 'app-posts-show',
  templateUrl: './author-show.component.html',
  styleUrls: ['./author-show.component.css']
})
export class AuthorShowComponent implements OnInit {
  author: AuthorModel;
  constructor(
    private activatedRoute: ActivatedRoute,
    private authorService: AuthorService,
    private router: Router
    ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.authorService.getAuthor(id).subscribe(
      (receivedPost: AuthorModel) => {
          this.author = receivedPost;
      },
      (error) => {
          console.log(error);
      },
      () => {
        // complete.
    });
  }
}
