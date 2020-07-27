import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { UserLoginPageComponent } from './page-components/user-login-page/user-login-page.component';
import { AdminLoginPageComponent } from './page-components/admin-login-page/admin-login-page.component';
import { LoginHeaderComponent } from './components/login-header/login-header.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    UserLoginPageComponent,
    AdminLoginPageComponent,
    LoginHeaderComponent,
    LoginFormComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
