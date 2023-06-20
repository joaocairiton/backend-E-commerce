import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';

import { SignupComponent } from './pages/signup/signup.component';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { AuthAdminGuard } from './service/auth-admin.guard';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AuthNormalGuard } from './service/auth-normal.guard';
import { LoginComponent } from './pages/login/login.component';
import { AdminComponent } from './pages/admin/admin.component';
import { UserListComponent } from './pages/user-list/user-list.component';
import { EditFormComponent } from './pages/edit-form/edit-form.component';

const routes: Routes = [
  {path : '',component : HomeComponent,pathMatch : 'full'},
  {path : 'sign-up',component : SignupComponent,pathMatch : 'full'},
  {path : 'login',component : LoginComponent,pathMatch : 'full'},
  {path : 'user-list',component : UserListComponent,pathMatch : 'full'},
  {path : 'edit',component : EditFormComponent,pathMatch :'full', canActivate:[AuthAdminGuard]},
  {path:'admin',component:AdminComponent,pathMatch:'full', canActivate:[AuthAdminGuard]},
  {path:'admin-dashboard',component:AdminDashboardComponent,pathMatch:'full', canActivate:[AuthAdminGuard]},
  {path:'user-dashboard',component:UserDashboardComponent,pathMatch:'full', canActivate:[AuthNormalGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
