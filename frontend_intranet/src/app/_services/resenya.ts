export class Resenya {
    id_resenya:number;
    nom: string = "";
    id_usuari: number;
    fecha: string = "";    
    informacion: string = "";
    hastags: string = "";


    constructor(
        id_resenya:number,
        nom: string = "",
        id_usuari: number,
        fecha: string = "",
        informacion: string = "",
        hastags: string = "",       
    ){
        this.id_resenya=id_resenya;
        this.nom=nom;
        this.id_usuari=id_usuari;
        this.fecha=fecha;
        this.informacion=informacion;
        this.hastags=hastags;
    }
}