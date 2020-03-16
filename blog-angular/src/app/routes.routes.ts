import {Route} from '@angular/router';
import {HomeComponent} from './components/pages/home/home.component';
import {PostsComponent} from './components/pages/posts/posts.component';
import {PostsShowComponent} from './components/pages/posts/posts-show/posts-show.component';
import {AuthorComponent} from './components/pages/author/author.component';
import {AuthorShowComponent} from './components/pages/author/author-show/author-show.component';
import {LoginComponent} from './components/pages/login/login.component';
import {RestrictComponent} from './components/pages/restrict/restrict.component';

export const routes: Route[] = [
  {path: 'home', component: HomeComponent},
  {path: 'posts', component: PostsComponent},
  {path: 'posts/:id', component: PostsShowComponent},
  {path: 'authors', component: AuthorComponent},
  {path: 'authors/:id', component: AuthorShowComponent},
  {path: 'login', component: LoginComponent},
  {path: 'restrict/:id', component: RestrictComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];
