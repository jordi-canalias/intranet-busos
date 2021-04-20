export class User {
    nombre: string = "";
    apellidos: string = "";
    funcion: string = "";
    telefono: string = "";
    email: string = "";
    permisos: string = "";
    pass: string = "";


    constructor(
        nombre: string = "",
        pass: string = "",
        apellidos: string = "",
        funcion: string = "",
        telefono: string = "",
        email: string = "",
        permisos: string = "") {
        this.nombre = nombre;
        this.pass = pass;
        this.apellidos=apellidos;
        this.email=email;
        this.funcion=funcion;
        this.permisos=permisos;
        this.telefono=telefono;
    }
}