package edu.curso.agenda.exception

class APIException(val status : Int, message: String, except : Throwable) : Exception(message, except) {

    constructor( status : Int, message : String ) : this(status, message, Exception( message ))
    constructor( message : String ) : this(500, message, Exception( message ))

}