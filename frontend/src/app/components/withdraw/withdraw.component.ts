import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {JsonHttpService} from "../../services/json-http.service";
import * as urls from "../../../urls";
import {Observable} from "rxjs/Observable";
import {OperationsService} from "../../services/operations.service";

@Component({
  selector: 'withdraw-component',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})

export class WithdrawComponent implements OnInit {

  balance: number;
  user: User;
  amount: string = "";

  constructor(private jsonHttpService: JsonHttpService,
              private operationService: OperationsService) {
  }

  ngOnInit() {
    this.loadBalance();
  }

  loadBalance() {
    this.jsonHttpService.get(urls.devListTransactionsUrl)
      .map(response => response.json()).catch((error: any) => Observable.throw(error.json().error || 'Server error'))
      .subscribe(balanceResponse => {
        console.log(balanceResponse);
        this.balance = balanceResponse;
        console.log(this.balance);
      });
  }

  digitPressed(input: number) {
    this.amount = this.amount + input;
  }

  clear() {
    this.amount = "";
  }

  submit() {
    if (this.amount.length > 1) {
      this.performWithdraw();
      return;
    }
    this.displayInappropriateAmountMessage();

  }

  displayInappropriateAmountMessage() {
    alert("Ne to")
  }


  performWithdraw() {
    console.log("Sending login request to server...");
    this.operationService.withdraw(this.amount)
      .subscribe((res) => {
        alert(res);
      }, e => this.handleError(e));
  }

  handleError(error) {
    switch (error.status) {
      case 416:
        alert("416");
    }
  }
}
