package com.VoterApplication.VoterRegistration.Exceptions;

import com.VoterApplication.VoterRegistration.models.VoterRegistrationResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AadharException.class)
    public ResponseEntity<VoterRegistrationResponseBody> handleAdharException(AadharException exception){

        VoterRegistrationResponseBody<String> responseBody = new VoterRegistrationResponseBody<>();
        responseBody.setStatusCode(exception.getResultCode());
        responseBody.setMessage(exception.getMessage());
        responseBody.setData(null);
        responseBody.setZonedDateTime(ZonedDateTime.now());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }



}
