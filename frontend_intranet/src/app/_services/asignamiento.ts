export class Asignamiento {
    id_asignacion:number;
    id_usuari:number;
    id_liniaruta:number;
    nom: string = "";
    tipus: string = "";
    fecha: string = "";
   

    constructor(
        id_asignacion:number,
        id_usuari:number,
        id_liniaruta:number,
        nom: string = "",
        tipus: string = "",
        fecha: string = "",
        
    ){
        this.id_asignacion=id_asignacion;
        this.id_usuari=id_usuari;
        this.id_liniaruta=id_liniaruta;
        this.nom=nom;
        this.tipus=tipus;
        this.fecha=fecha;
    }
}