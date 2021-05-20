export class User {
    id_usuari:number;
    nom: string = "";
    cognoms: string = "";
    funcio: string = "";
    fecha_entrada: string = "";
    telefon: string = "";
    correu_electronic: string = "";
    permisos: string = "";
    contrasenya: string = "";


    constructor(
        id_usuari:number,
        nom: string = "",
        cognoms: string = "",
        contrasenya: string = "",
        funcio: string = "",
        telefon:string = "",
        correu_electronic: string = "",
        fecha_entrada: string = "",
        permisos: string = "") {
            this.id_usuari=id_usuari;
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.cognoms=cognoms;
        this.correu_electronic=correu_electronic;
        this.funcio=funcio;
        this.permisos=permisos;
        this.telefon=telefon;
        this.fecha_entrada=fecha_entrada;
    }
}