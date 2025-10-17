package edu.curso.agenda.error

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.net.URI
import java.time.OffsetDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ProblemDetail> {
        val fieldErrors = ex.bindingResult.fieldErrors.map { fe ->
            mapOf(
                "field" to fe.field,
                "message" to (fe.defaultMessage ?: "valor inválido"),
                "rejectedValue" to fe.rejectedValue
            )
        }
        val globalErrors = ex.bindingResult.globalErrors.map { ge ->
            mapOf(
                "object" to ge.objectName,
                "message" to (ge.defaultMessage ?: "inválido")
            )
        }
        val problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST).apply {
            title = "Requisição inválida"
            detail = "Falha de validação"
            setProperty("errors", fieldErrors + globalErrors)
            setProperty("timestamp", OffsetDateTime.now())
            instance = URI.create(request.requestURI)
        }
        return ResponseEntity.badRequest().body(problem)
    }

    // Para @RequestParam/@PathVariable e validação de métodos (@Validated)
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(
        ex: ConstraintViolationException,
        request: HttpServletRequest
    ): ResponseEntity<ProblemDetail> {
        val errors = ex.constraintViolations.map { v ->
            mapOf(
                "field" to v.propertyPath.toString(),
                "message" to v.message,
                "invalidValue" to v.invalidValue
            )
        }
        val problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST).apply {
            title = "Requisição inválida"
            detail = "Falha de validação"
            setProperty("errors", errors)
            setProperty("timestamp", OffsetDateTime.now())
            instance = URI.create(request.requestURI)
        }
        return ResponseEntity.badRequest().body(problem)
    }


    // Para qualquer outro tipo de exception
    @ExceptionHandler(Exception::class)
    fun handleException(
        ex: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ProblemDetail> {
        val problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST).apply {
            title = "Requisição inválida"
            detail = "Falha de validação"
            setProperty("timestamp", OffsetDateTime.now())
            instance = URI.create(request.requestURI)
        }
        return ResponseEntity.badRequest().body(problem)
    }
}