export class ParadaCompleta {
    id_linia: number;
    id_parada: number;
    ordre: number;
    hora: string = "";
    ubicacio:string="";
    informacion:string="";
    nom:string="";
    

    constructor(
        id_linia: number,
        id_parada: number,
        ordre: number,
        hora: string = "",
        ubicacio: string = "",
        informacion: string = "",
        nom: string = "",
    ) {
        this.id_linia = id_linia;
        this.id_parada = id_parada;
        this.ordre = ordre;
        this.hora = hora;
        this.ubicacio = ubicacio;
        this.informacion = informacion;
        this.nom = nom;
    }
}