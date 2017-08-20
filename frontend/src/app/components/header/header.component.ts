import {Component, HostListener, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'header-component',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isSignedIn: boolean;
  title: string = "ATM";

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.isSignedIn = this.authService.isSignedIn();
    this.authService.events.subscribe(() => {
      this.isSignedIn = this.authService.isSignedIn();
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
