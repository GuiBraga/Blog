import {AuthorModel} from './author.model';

export class UserModel {
  constructor(
    public id: number,
    public username: string,
    public email: string,
    public created: string,
    public author?: AuthorModel
  ) {}
}
