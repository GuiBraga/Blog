import { Component, OnInit } from '@angular/core';
import {AuthorService} from '../../../services/author.service';
import {PostService} from '../../../services/post.service';
import {AuthorModel} from '../../../models/author.model';
import {PostModel} from '../../../models/post.model';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

  authors: AuthorModel[] = [];
  posts: PostModel[] = [];
  constructor(
	private authorService: AuthorService,
	private postService: PostService,
  ) { }

  ngOnInit(): void {
  	this.authorService.getAuthors();
  	this.postService.getPosts();
  }

  ngAfterViewInit(): void {
    this.authorService.authors$.subscribe(
      (authors: AuthorModel[]) => {
        this.authors = authors;
      }
    );
    this.postService.posts$.subscribe(
      (posts: PostModel[]) => {
        this.posts = posts;
      }
    );
  }

}
