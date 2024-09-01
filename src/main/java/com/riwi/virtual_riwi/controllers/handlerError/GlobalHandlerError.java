package com.riwi.virtual_riwi.controllers.handlerError;

import com.riwi.virtual_riwi.dtos.exception.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//Es un manejador global que permite el manejo de excepciones en los controladores de app
@RestControllerAdvice
public class GlobalHandlerError {

    //Esta funcion  me sirve para el manejo  de no encontrar la entidad. (Codigo 404)
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlerEntityNotFound(EntityNotFoundException error){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                error.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Me sirve para la gestion o muestra de los argumentos no validos (Codigo 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handlerValidation(MethodArgumentNotValidException error){
        String errorMessage = error.getBindingResult().getAllErrors().stream()
                .map(e -> e.getDefaultMessage()) // Me optiene el primer mensaje de error
                .findFirst()
                .orElse("Validation error"); //Es un mensaje por defecto si no encuentra nada

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errorMessage,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Aqui es donde se maneja cualquier otra excepcion. (Codigo 500)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleGlobalError(Exception error){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
