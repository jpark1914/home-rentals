import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { PersonalInfoPageComponent } from './page-components/personal-info-page/personal-info-page.component';
import { PersonalInfoFormComponent } from './components/personal-info-form/personal-info-form.component';
import { RegisterPageComponent } from './page-components/register-page/register-page.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { PasswordDirective } from './directives/password.directive';
import { StorageServiceModule } from 'ngx-webstorage-service';
import { LoginPageComponent } from './page-components/login-page/login-page.component';
import { AlertComponent } from './components/alert/alert.component';
import { PropertyListComponent } from './components/property-list/property-list.component';
import { PropertyDetailsPageComponent } from './page-components/property-details-page/property-details-page.component';
import { PropertyDetailsComponent } from './components/property-details/property-details.component';
import { SpouseInfoPageComponent } from './page-components/spouse-info-page/spouse-info-page.component';
import { SpouseInfoFormComponent } from './components/spouse-info-form/spouse-info-form.component';
import { VehicleInfoPageComponent } from './page-components/vehicle-info-page/vehicle-info-page.component';
import { VehicleInfoFormComponent } from './components/vehicle-info-form/vehicle-info-form.component';
import { BankInfoPageComponent } from './page-components/bank-info-page/bank-info-page.component';
import { BankInfoFormComponent } from './components/bank-info-form/bank-info-form.component';
import { ReferenceInfoPageComponent } from './page-components/reference-info-page/reference-info-page.component';
import { ReferenceInfoFormComponent } from './components/reference-info-form/reference-info-form.component';
import { OtherInfoPageComponent } from './page-components/other-info-page/other-info-page.component';
import { OtherInfoFormComponent } from './components/other-info-form/other-info-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    LoginFormComponent,
    FooterComponent,
    HeaderComponent,
    PersonalInfoPageComponent,
    PersonalInfoFormComponent,
    RegisterPageComponent,
    RegisterFormComponent,
    PasswordDirective,
    LoginPageComponent,
    AlertComponent,
    PropertyListComponent,
    PropertyDetailsPageComponent,
    PropertyDetailsComponent,
    SpouseInfoPageComponent,
    SpouseInfoFormComponent,
    VehicleInfoPageComponent,
    VehicleInfoFormComponent,
    BankInfoPageComponent,
    BankInfoFormComponent,
    ReferenceInfoPageComponent,
    ReferenceInfoFormComponent,
    OtherInfoPageComponent,
    OtherInfoFormComponent,
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
