import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from "@angular/http";

import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

import {AppComponent} from './components/app/app.component';
import {UserComponent} from './components/user/user.component';
import {AboutComponent} from './components/about/about.component';
import {LoginComponent} from './components/login/login.component';

import {JsonHttpService} from "./services/json-http.service";
import {AuthService} from "./services/auth.service";
import {TransactionsComponent} from './components/transactions/transactions.component';
import {FocusDirective} from "./directives/focus.directive";
import {HeaderComponent} from './components/header/header.component';
import {ROUTES} from "./app.routes";
import {CoreModule} from "./core/core.module";
import {OperationsComponent} from "./components/operations/operations.component";
import {WithdrawComponent} from './components/withdraw/withdraw.component';
import {OperationsService} from "./services/operations.service";

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AboutComponent,
    LoginComponent,
    TransactionsComponent,
    FocusDirective,
    HeaderComponent,
    OperationsComponent,
    WithdrawComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES, {
      preloadingStrategy: PreloadAllModules
    }),
    CoreModule
  ],
  providers: [JsonHttpService, AuthService, OperationsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
