export class Parada {
    id_parada: number;
    nombre: string = "";
    ubicacion: string = "";
    info: string = "";

    constructor(
        id_parada: number,
        nombre: string = "",
        info: string = "",
        ubicacion: string = "",
    ) {
        this.id_parada = id_parada;
        this.nombre = nombre;
        this.info = info;
        this.ubicacion = ubicacion;
    }
}