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

import { DriverService } from './rest/driver.Service';
import { VehicleService } from './rest/vehicle.service';
import { TarievenPageComponent } from "app/tarieven/tarieven.component";

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
    VehicleEditDialogComponent
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
    VehicleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
