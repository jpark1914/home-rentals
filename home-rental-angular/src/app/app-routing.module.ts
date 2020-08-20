import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { PersonalInfoPageComponent } from './page-components/personal-info-page/personal-info-page.component';
import { RegisterPageComponent } from './page-components/register-page/register-page.component';
import { LoginPageComponent } from './page-components/login-page/login-page.component';
import { PropertyDetailsPageComponent } from './page-components/property-details-page/property-details-page.component';
import { SpouseInfoPageComponent } from './page-components/spouse-info-page/spouse-info-page.component';
import { VehicleInfoPageComponent } from './page-components/vehicle-info-page/vehicle-info-page.component';
import { BankInfoPageComponent } from './page-components/bank-info-page/bank-info-page.component';
import { ReferenceInfoPageComponent } from './page-components/reference-info-page/reference-info-page.component';
import { OtherInfoPageComponent } from './page-components/other-info-page/other-info-page.component';
import { RentalsAdminPageComponent } from './page-components/rentals-admin-page/rentals-admin-page.component';

const routes: Routes = [
  { path: 'landing', component: LandingPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'personal-info', component: PersonalInfoPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'property-details/:unitId', component: PropertyDetailsPageComponent },
  { path: 'spouse-info', component: SpouseInfoPageComponent },
  { path: 'vehicle-info', component: VehicleInfoPageComponent },
  { path: 'bank-info', component: BankInfoPageComponent },
  { path: 'reference-info', component: ReferenceInfoPageComponent },
  { path: 'other-info', component: OtherInfoPageComponent },
  { path: 'rental-admin', component: RentalsAdminPageComponent },
  { path: '', redirectTo: '/landing', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
