export class User {
    username: string = "";
    surname: string = "";
    funcion: string = "";
    phone: string = "";
    email: string = "";
    permisos: string = "";
    pass: string = "";


    constructor(
        username: string = "",
        surname: string = "",
        pass: string = "",
        funcion: string = "",
        phone: string = "",
        email: string = "",
        permisos: string = "") {
        this.username = username;
        this.pass = pass;
        this.surname=surname;
        this.email=email;
        this.funcion=funcion;
        this.permisos=permisos;
        this.phone=phone;
    }
}