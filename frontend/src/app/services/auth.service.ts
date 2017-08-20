import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {JsonHttpService} from "./json-http.service";
import "rxjs/add/operator/do";
import * as urls from "../../urls";


// const jwtDecode = require('jwt-decode');

@Injectable()
export class AuthService {

  private authEvents: Subject<AuthEvent>;

  constructor(private http: JsonHttpService) {
    this.authEvents = new Subject<AuthEvent>();
  }

  login(email: string, password: string): Observable<Response> {
    const body = {
      email: email,
      password: password,
    };
    return this.http.post(urls.devLoginUrl, body).do((resp: Response) => {
      localStorage.setItem('jwt', resp.json().token);
      this.authEvents.next(new DidLogin());
    });
  }

  logout(): void {
    localStorage.removeItem('jwt');
    this.authEvents.next(new DidLogout());
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }

  get events(): Observable<AuthEvent> {
    return this.authEvents;
  }

}

export class DidLogin {
}

export class DidLogout {
}

export type AuthEvent = DidLogin | DidLogout;

