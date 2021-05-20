export class Linia {
    id_linia:number;
    nom: string = "";
    hora_inici: string = "";
    hora_finalitzacio: string = "";
    informacion: string = "";
    bus_asignat: string = "";


    constructor(
        id_linia:number,
        nom: string = "",
        hora_inici: string = "",
        hora_finalitzacio: string = "",
        informacion: string = "",
        bus_asignat: string = "",
    ){
        this.id_linia=id_linia;
        this.nom=nom;
        this.hora_inici=hora_inici;
        this.hora_finalitzacio=hora_finalitzacio;
        this.bus_asignat=bus_asignat;
        this.informacion=informacion;
    }
}