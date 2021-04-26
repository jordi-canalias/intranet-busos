export class Parada {
    nombre: string = "";
    ubicacion: string = "";    
    info: string = "";
  
  constructor(
        nombre: string = "",       
        info: string = "",
        ubicacion: string = "",
    ){
        this.nombre=nombre;        
        this.info=info;
        this.ubicacion=ubicacion;
    }
}