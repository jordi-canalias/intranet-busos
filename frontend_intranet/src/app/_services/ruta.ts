export class Ruta {
    id_ruta:number;
    nom: string = "";
    caracter: string = "";
    client: string = "";
    recollida: string = "";
    destinacio: string = "";
    informacion: string = "";
    guia_asignat: string = "";


    constructor(
        id_ruta:number,
        nom: string = "",
        caracter: string = "",
        recollida: string = "",
        destinacio: string = "",
        informacion: string = "",
        client: string = "",
        guia_asignat: string = "",
    ){
        this.id_ruta=id_ruta;
        this.nom=nom;
        this.caracter=caracter;
        this.client=client;
        this.destinacio=destinacio;
        this.guia_asignat=guia_asignat;
        this.informacion=informacion;
        this.recollida=recollida;
    }
}
