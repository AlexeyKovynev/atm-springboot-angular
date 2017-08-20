import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {User} from "../../model/user";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  @ViewChild('pinText') pin: ElementRef;
  @ViewChild('cardNumberText') card: ElementRef;

  cardActive: boolean = false;
  pinActive: boolean = false;
  user: User = new User("", "");

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.activateCard()
  }

  digitPressed(input: string) {
    if (this.cardActive && this.user.username.length < 16) {
      this.user.username = this.user.username + input;
    } else if (this.cardActive && this.user.username.length == 16) {
      this.activatePin();
    }
    if (this.pinActive && this.user.password.length < 4) {
      this.user.password = this.user.password + input;
    }
  }

  clear() {
    if (this.cardActive) {
      this.user.username = "";
    }
    if (this.pinActive) {
      this.user.password = "";
    }
  }

  submit() {
    if (this.user.username.length == 16 && this.user.password.length == 4) {
      this.login(this.user.username, this.user.password);
    } else {
      this.displayInapropriateLengthMessage();
    }
  }

  displayInapropriateLengthMessage() {

  }

  activatePin() {
    this.setFocus(this.pin);
    this.pinActive = true;
    this.cardActive = false;
  }

  activateCard() {
    this.setFocus(this.card);
    this.cardActive = true;
    this.pinActive = false;
  }

  private setFocus(el: ElementRef) {
    el.nativeElement.focus();
  }

  login(email, password) {
    console.log("Sending login request to server...");
    this.authService.login(email, password)
      .subscribe(() => {
        this.router.navigate(['/operations']);
      }, e => this.handleError(e));
  }

  handleError(error) {
    switch (error.status) {
      case 401:
        alert("401");
    }
  }
}
