export class Parada {
    id_parada: number;
    nom: string = "";
    ubicacio: string = "";
    informacion: string = "";

    constructor(
        id_parada: number,
        nom: string = "",
        ubicacio: string = "",
        informacion: string = "",
    ) {
        this.id_parada = id_parada;
        this.nom = nom;      
        this.ubicacio = ubicacio;
        this.informacion = informacion;
    }
}