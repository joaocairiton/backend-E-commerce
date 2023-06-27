import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { authInterceptorProviders } from './service/auth.interceptor';
import { NavAdminComponent } from './components/nav-admin/nav-admin.component';
import { AdminComponent } from './pages/admin/admin/admin.component';
import { SidebarAdminComponent } from './components/sidebar-admin/sidebar-admin.component';
import { NavUserComponent } from './components/nav-user/nav-user.component';
import { UserComponent } from './pages/user/user/user.component';
import { ProductComponent } from './pages/products/product/product.component';
import { UserListComponent } from './pages/admin/user-list/user-list.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddFormComponent } from './pages/admin/add-form/add-form.component';
import { MaterialModule } from 'src/material.module';
import { ProfileAdminComponent } from './pages/admin/profile-admin/profile-admin.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { AddEditProductComponent } from './pages/products/add-edit-product/add-edit-product.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    NavAdminComponent,
    AdminComponent,
    SidebarAdminComponent,
    NavUserComponent,
    UserComponent,
    ProductComponent,
    UserListComponent,
    AddFormComponent,
    ProfileAdminComponent,
    WelcomeComponent,
    AddEditProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MaterialModule,

    
    
  ],
  providers: [
    authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
