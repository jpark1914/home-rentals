import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './page-components/landing-page/landing-page.component';
import { UserLoginPageComponent } from './page-components/user-login-page/user-login-page.component';
import { AdminLoginPageComponent } from './page-components/admin-login-page/admin-login-page.component';


const routes: Routes = [
  { path: 'landing', component:  LandingPageComponent },
  { path: 'login-user', component:  UserLoginPageComponent },
  { path: 'login-admin', component:  AdminLoginPageComponent },
  { path: '', redirectTo: '/landing', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
