export class Token {
   
    id_usuari:number;
    usuari: string = "";
    token: string = "";
    hora_inici: string = "";
   

    constructor(
     
        id_usuari:number,  
        usuari: string = "",
        token: string = "",
        hora_inici: string = "",
        
    ){
      
        this.id_usuari=id_usuari;  
        this.usuari=usuari;
        this.token=token;
        this.hora_inici=hora_inici;
    }
}