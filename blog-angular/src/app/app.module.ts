import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainHeaderComponent } from './components/squelettes/main-header/main-header.component';
import { FooterComponent } from './components/squelettes/footer/footer.component';
import { SideBarComponent } from './components/squelettes/side-bar/side-bar.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import {routes} from './routes.routes';
import { PostsComponent } from './components/pages/posts/posts.component';
import { PostsShowComponent } from './components/pages/posts/posts-show/posts-show.component';
import { AuthorComponent } from './components/pages/author/author.component';
import {AuthorShowComponent} from './components/pages/author/author-show/author-show.component';
import { LoginComponent } from './components/pages/login/login.component';
import { RestrictComponent } from './components/pages/restrict/restrict.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './services/authconfig.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    MainHeaderComponent,
    FooterComponent,
    SideBarComponent,
    HomeComponent,
    PostsComponent,
    PostsShowComponent,
    AuthorComponent,
    AuthorShowComponent,
    LoginComponent,
    RestrictComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
