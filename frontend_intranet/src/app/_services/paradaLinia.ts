export class ParadaLinia {
    id_linia: number;
    id_parada: number;
    ordre: number;
    hora: string = "";
    

    constructor(
        id_linia: number,
        id_parada: number,
        ordre: number,
        hora: string = "",
    ) {
        this.id_linia = id_linia;
        this.id_parada = id_parada;
        this.ordre = ordre;
        this.hora = hora;
    }
}