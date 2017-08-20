import {Routes} from "@angular/router";

import {PublicPageGuard} from "./services/public-page.guard";
import {PrivatePageGuard} from "./services/private-page.guard";

import {LoginComponent} from "./components/login/login.component";
import {AboutComponent} from "./components/about/about.component";
import {TransactionsComponent} from "./components/transactions/transactions.component";
import {OperationsComponent} from "./components/operations/operations.component";
import {WithdrawComponent} from "./components/withdraw/withdraw.component";

export const ROUTES: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full', canActivate: [PublicPageGuard]},
  {path: 'login', component: LoginComponent, canActivate: [PublicPageGuard]},
  {path: 'about', component: AboutComponent},
  {path: 'operations', component: OperationsComponent, canActivate: [PrivatePageGuard]},
  {path: 'transactions', component: TransactionsComponent, canActivate: [PrivatePageGuard]},
  {path: 'withdraw', component: WithdrawComponent, canActivate: [PrivatePageGuard]}
];
