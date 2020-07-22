import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { UserLoginPageComponent } from './page-components/user-login-page/user-login-page.component';
import { AdminLoginPageComponent } from './page-components/admin-login-page/admin-login-page.component';
import { LoginHeaderComponent } from './components/login-header/login-header.component';
import { UserLoginFormComponent } from './components/user-login-form/user-login-form.component';
import { AdminLoginFormComponent } from './components/admin-login-form/admin-login-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    UserLoginPageComponent,
    AdminLoginPageComponent,
    LoginHeaderComponent,
    UserLoginFormComponent,
    AdminLoginFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
