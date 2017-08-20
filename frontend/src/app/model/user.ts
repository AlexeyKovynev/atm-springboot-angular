export class User {
  constructor(public username: string,
              public password: string,
              public enabled?: boolean,
              public balance?: number) {
  }
}
