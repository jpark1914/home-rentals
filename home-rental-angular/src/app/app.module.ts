import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { UserLoginPageComponent } from './page-components/user-login-page/user-login-page.component';
import { AdminLoginPageComponent } from './page-components/admin-login-page/admin-login-page.component';
import { LoginHeaderComponent } from './components/login-header/login-header.component';
import { LoginFormComponent } from './components/login-form/login-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    UserLoginPageComponent,
    AdminLoginPageComponent,
    LoginHeaderComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
