import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {JsonHttpService} from "./json-http.service";
import "rxjs/add/operator/do";
import * as urls from "../../urls";
import {Withdrawal} from "../model/withdrawal";

@Injectable()
export class OperationsService {

  constructor(private http: JsonHttpService) {
  }

  withdraw(amount): Observable<Response> {
    return this.http.post(urls.devWithdrawUrl, new Withdrawal(amount)).do((resp: Response) => {
      console.log(resp);
      return resp;
    });
  }

}

