export class Linia {
    nombre: string = "";
    hora_inicio: string = "";
    hora_final: string = "";
    info: string = "";
    bus_asignado: string = "";


    constructor(
        nombre: string = "",
        hora_inicio: string = "",
        hora_final: string = "",
        info: string = "",
        bus_asignado: string = "",
    ){
        this.nombre=nombre;
        this.hora_inicio=hora_inicio;
        this.hora_final=hora_final;
        this.bus_asignado=bus_asignado;
        this.info=info;
    }
}