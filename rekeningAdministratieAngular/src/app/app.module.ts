import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Routing } from './routes/routing.component';
import { ModalModule, TabsModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';
import { HomePageComponent } from './home/home.component';
import { GebruikerPageComponent } from './gebruiker/gebruiker.component';
import { VehiclePageComponent } from './vehicle/vehicle.component';

import { VehicleDialogComponent } from './dialog/vehicleDialog.component';
import { VehicleEditDialogComponent } from './dialog/vehicleEditDialog.components';
import { TrackerDialogComponent } from './dialog/trackerDialog.component'
import { LoginComponent } from './login/login.component';
import { TarievenPageComponent } from "app/tarieven/tarieven.component";

import { DriverService } from './rest/driver.Service';
import { VehicleService } from './rest/vehicle.service';
import { TrackerService} from './rest/tracker.service';
import { RateService } from './rest/rate.Service';
import { UserService } from './rest/user.Service';
import { RequestService } from './rest/request.Service';
import { LoginService } from './global/login.Service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent,
    HomePageComponent,
    GebruikerPageComponent,
    TarievenPageComponent,
    VehicleDialogComponent,
    VehiclePageComponent,
    VehicleEditDialogComponent,
    TrackerDialogComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing,
    ModalModule.forRoot(),
    TabsModule.forRoot()
  ],
  providers: [
    DriverService,
    VehicleService,
    TrackerService,
    RateService,
    LoginService,
    UserService,
    RequestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
