import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Routing } from './routes/routing.component';
import { ModalModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';
import { HomePageComponent } from './home/home.component';
import { GebruikerPageComponent } from './gebruiker/gebruiker.component';
import { GebruikerTableComponent } from './gebruiker/gebruikertable.component';
import { TarievenPageComponent } from "app/tarieven/tarieven.component";

@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent,
    HomePageComponent,
    GebruikerPageComponent,
    GebruikerTableComponent,
    TarievenPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing,
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
