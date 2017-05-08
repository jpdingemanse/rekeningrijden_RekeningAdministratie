import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './../app.component';
import { HomePageComponent } from './../home/home.component'
import { GebruikerPageComponent } from './../gebruiker/gebruiker.component';
import { TarievenPageComponent } from './../tarieven/tarieven.component';
import { VehiclePageComponent } from './../vehicle/vehicle.component';
import { InvoicePageComponent } from './../invoice/invoice.component';

export const router: Routes = [
    { path: 'home', component: HomePageComponent},
    { path: 'gebruiker', component: GebruikerPageComponent},
    { path: 'tarieven', component: TarievenPageComponent},
    { path: 'vehicle', component: VehiclePageComponent},
    { path: 'invoice', component: InvoicePageComponent}
];

export const Routing: ModuleWithProviders = RouterModule.forRoot(router);