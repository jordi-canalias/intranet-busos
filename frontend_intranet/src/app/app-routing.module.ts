import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { ForumComponent } from './forum/forum.component';
import { RutaComponent } from './ruta/ruta.component';
import { ParadaComponent } from './parada/parada.component';
import { LineaComponent } from './linea/linea.component';
import { AssignmentComponent } from './assignment/assignment.component';


const routes: Routes = [
  {path:'',component:LandingComponent},
  {path:'landing',component:LandingComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'profile',component:ProfileComponent},
  {path:'forum',component:ForumComponent},
  {path:'ruta',component:RutaComponent},
  {path:'ruta/:id',component:RutaComponent},
  {path:'linea',component:LineaComponent},
  {path:'linea/:id',component:LineaComponent},
  {path:'parada',component:ParadaComponent},
  {path:'assignment',component:AssignmentComponent},
  {path:'assignment/:id',component:AssignmentComponent},
  {path:'**',component:LandingComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
