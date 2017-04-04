import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './../app.component';
import { HomePageComponent } from './../home/home.component'
import { GebruikerPageComponent } from './../gebruiker/gebruiker.component';

export const router: Routes = [
    { path: '', redirectTo : 'home', pathMatch: 'full'},
    { path: 'home', component: HomePageComponent},
    { path: 'gebruiker', component: GebruikerPageComponent}
];

export const Routing: ModuleWithProviders = RouterModule.forRoot(router);