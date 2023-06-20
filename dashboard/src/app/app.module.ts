import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list'
import {MatFormFieldModule} from '@angular/material/form-field';

import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './pages/signup/signup.component';

import {MatInputModule} from '@angular/material/input';
import { LoginComponent } from './pages/login/login.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatSelectModule} from '@angular/material/select';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { authInterceptorProviders } from './service/auth.interceptor';
import { NavAdminComponent } from './components/nav-admin/nav-admin.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSidenavModule} from '@angular/material/sidenav';
import { AdminComponent } from './pages/admin/admin.component';
import { SidebarAdminComponent } from './components/sidebar-admin/sidebar-admin.component';
import { NavUserComponent } from './components/nav-user/nav-user.component';
import { UserComponent } from './pages/user/user/user.component';
import {MatSliderModule} from '@angular/material/slider';
import { ProductComponent } from './pages/products/product/product.component';
import { UserListComponent } from './pages/user-list/user-list.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import {  MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { EditFormComponent } from './pages/edit-form/edit-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddFormComponent } from './pages/add-form/add-form.component';


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
    EditFormComponent,
    AddFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,

    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatSelectModule,
    MatSnackBarModule,
    MatSidenavModule,
    MatDialogModule,
    MatSliderModule,
    MatPaginatorModule,
    MatTableModule,
    MatSortModule
  ],
  providers: [
    authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
