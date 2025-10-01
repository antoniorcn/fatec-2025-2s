package edu.curso.agenda.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(APIException::class)
    fun apiException(error : APIException, request : WebRequest) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(error.status).body(
            ErrorResponse(
                error.message?:"",
                "Erro",
                error.status,
                request.contextPath
            )
        )
    }

    @ExceptionHandler(Exception::class)
    fun regularException(error : Exception, request : WebRequest) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(500).body(
            ErrorResponse(
                error.message?:"",
                "Erro",
                500,
                request.contextPath
            )
        )
    }
}