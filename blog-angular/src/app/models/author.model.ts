export class AuthorModel {
  constructor(
    public id: number,
    public name: string,
    public description: string,
    public shortDescription: string,

    public created_at: string
  ) {}
}
