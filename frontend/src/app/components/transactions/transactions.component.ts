import {Component, OnInit} from '@angular/core';
import {JsonHttpService} from "../../services/json-http.service";
import {Observable} from "rxjs/Observable";
import {AccountTransaction} from "../../model/account-transaction";
import * as urls from "../../../urls";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Component({
  selector: 'transactions-component',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactions: AccountTransaction[];
  totalRecords: number;

  constructor(private jsonHttpService: JsonHttpService) {
  }

  ngOnInit(): void {
    this.loadTransactions();
  }

  loadTransactions() {
    this.jsonHttpService.get(urls.devListTransactionsUrl)
      .map(response => response.json()).catch((error: any) => Observable.throw(error.json().error || 'Server error'))
      .subscribe(transactionsResponse => {
        console.log(transactionsResponse);
        this.transactions = transactionsResponse.accountTransactions;
        this.totalRecords = transactionsResponse.totalElements;
        console.log(this.transactions);
        console.log(this.totalRecords);
      });
  }

}
