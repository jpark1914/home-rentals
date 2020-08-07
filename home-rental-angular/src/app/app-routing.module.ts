import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { PersonalInfoPageComponent } from './page-components/personal-info-page/personal-info-page.component';
import { RegisterPageComponent } from './page-components/register-page/register-page.component';
import { LoginPageComponent } from './page-components/login-page/login-page.component';


const routes: Routes = [
  { path: 'landing', component:  LandingPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'personal-info', component: PersonalInfoPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: '', redirectTo: '/landing', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
