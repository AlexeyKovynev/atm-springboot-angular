import {Injectable} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "./auth.service";

@Injectable()
export class HttpErrorHandlerService {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  handle(error: any) {
    if (error.status === 401) {
      this.authService.logout();
      this.router.navigate(['login']);
    }
  }

}
