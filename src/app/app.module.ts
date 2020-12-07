import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AuthService } from './auth.service' 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { EditComponent } from './edit/edit.component';
import { DeleteComponent } from './delete/delete.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { RegisterComponent } from './register/register.component';
import { RouterModule } from '@angular/router';
import { FormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SearchTrainComponent } from './search-train/search-train.component';
import { SearchRouteComponent } from './search-route/search-route.component';
import { PaymentComponent } from './payment/payment.component';
import { Payment1Component } from './payment1/payment1.component';
import { PassengersComponent } from './passengers/passengers.component';
import { AdminComponent } from './admin/admin.component';
import { UpdateRouteComponent } from './update-route/update-route.component';
import { UpdateTrainComponent } from './update-train/update-train.component';
import { ChangePasswordComponent} from './change-password/change-password.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { DeletetrainComponent } from './deletetrain/deletetrain.component';
import { PassengerlistComponent } from './passengerlist/passengerlist.component';
import { PassengereditComponent } from './passengeredit/passengeredit.component';
import { PassengerdeleteComponent } from './passengerdelete/passengerdelete.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AddTrainComponent } from './add-train/add-train.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    EditComponent,
    DeleteComponent,
    NotfoundComponent,
    RegisterComponent,
    LoginComponent,
    SignupComponent,
    SearchTrainComponent,
    SearchRouteComponent,
    PaymentComponent,
    Payment1Component,
    PassengersComponent,
    AdminComponent,
    UpdateRouteComponent,
    UpdateTrainComponent,
    ChangePasswordComponent,
    UserListComponent,
    UserEditComponent,
    DeletetrainComponent,
    PassengerlistComponent,
    PassengereditComponent,
    PassengerdeleteComponent,
    AdminListComponent,
    AddTrainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:"",component:HomeComponent,canActivate:[AuthService]},
      {path:"home",component:HomeComponent,canActivate:[AuthService]},
      {path:"register",component:RegisterComponent},
      {path:"edit/:No",component:EditComponent,canActivate:[AuthService]},
      {path:"delete/:userId",component:DeleteComponent,canActivate:[AuthService]},
      {path:"signup",component:SignupComponent},
      {path:"login",component:LoginComponent},
      {path:"about",component:AboutComponent},
      {path:"search-train",component:SearchTrainComponent},
      {path:"contact",component:ContactComponent},
      {path:"search-route/:source/:destination",component:SearchRouteComponent},
      {path:"admin",component:AdminComponent},
      {path:"passengers",component:PassengersComponent},
      {path:"payment/:No",component:PaymentComponent},
      {path:"user-list",component:UserListComponent},
       {path:"userEdit/:userId",component:UserEditComponent},
       {path:"update-train",component:UpdateTrainComponent},
       {path:"deletetrain/:trainId",component:DeletetrainComponent},
       {path:"passengerlist",component:PassengerlistComponent},
       {path:"passengerEdit/:passengerId",component:PassengereditComponent},
       {path:"passengerdelete/:passengerId",component:PassengerdeleteComponent},
       {path:"admin-list",component:AdminListComponent},
       {path:"add-train",component:AddTrainComponent},
       {path:"change-password",component:ChangePasswordComponent},
       {path:"**",component:NotfoundComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
