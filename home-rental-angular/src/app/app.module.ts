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
import { LoginFormComponent } from './components/login-form/login-form.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { PersonalInfoPageComponent } from './page-components/personal-info-page/personal-info-page.component';
import { PersonalInfoFormComponent } from './components/personal-info-form/personal-info-form.component';
import { RegisterPageComponent } from './page-components/register-page/register-page.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { PasswordDirective } from './directives/password.directive';
import { StorageServiceModule } from 'ngx-webstorage-service';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    UserLoginPageComponent,
    AdminLoginPageComponent,
    LoginFormComponent,
    FooterComponent,
    HeaderComponent,
    PersonalInfoPageComponent,
    PersonalInfoFormComponent,
    RegisterPageComponent,
    RegisterFormComponent,
    PasswordDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    StorageServiceModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
