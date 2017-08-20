import {CommonModule} from "@angular/common";
import {NgModule} from '@angular/core';
import {SkipSelf, Optional} from "@angular/core";
import {AuthService} from "../services/auth.service";
import {PrivatePageGuard} from "../services/private-page.guard";
import {PublicPageGuard} from "../services/public-page.guard";
import {XHRBackend, Http, RequestOptions, HttpModule} from "@angular/http";
import {HttpErrorHandlerService} from "../services/http-error-handler.service";
import {JsonHttpService} from "../services/json-http.service";

export function createJsonHttp(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  const ngHttp = new Http(xhrBackend, requestOptions);
  return new JsonHttpService(ngHttp);
}

@NgModule({
  imports: [
    CommonModule,
    HttpModule
  ],
  exports: [],
  providers: [
    {
      provide: JsonHttpService,
      useFactory: createJsonHttp,
      deps: [XHRBackend, RequestOptions]
    },
    HttpErrorHandlerService,
    AuthService,
    PrivatePageGuard,
    PublicPageGuard,
  ]
})
export class CoreModule {

  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  }

}
