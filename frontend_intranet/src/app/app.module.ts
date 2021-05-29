import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { ProfileComponent } from './profile/profile.component';
import { ForumComponent } from './forum/forum.component';
import { RutaComponent } from './ruta/ruta.component';
import { LineaComponent } from './linea/linea.component';
import { ParadaComponent } from './parada/parada.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { PermisosMenuComponent } from './permisos/permisos-menu.component';
import { InforutaComponent } from './inforuta/inforuta.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    ForumComponent,
    RutaComponent,
    LineaComponent,
    ParadaComponent,
    AssignmentComponent,
    PermisosMenuComponent,
    InforutaComponent,
    
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
