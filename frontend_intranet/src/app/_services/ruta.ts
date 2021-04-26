export class Ruta {
    nombre: string = "";
    caracter: string = "";
    cliente: string = "";
    recogida: string = "";
    dest: string = "";
    info: string = "";
    guia_asignado: string = "";


    constructor(
        nombre: string = "",
        caracter: string = "",
        recogida: string = "",
        dest: string = "",
        info: string = "",
        cliente: string = "",
        guia_asignado: string = "",
    ){
        this.nombre=nombre;
        this.caracter=caracter;
        this.cliente=cliente;
        this.dest=dest;
        this.guia_asignado=guia_asignado;
        this.info=info;
        this.recogida=recogida;
    }
}
