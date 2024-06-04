package org.example.emptest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.emptest.api.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class APIExceptionController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorResult badRequestHandler(Exception e){
        //HttpMessageNotReadableException
        log.info("exception", e);
        return new ErrorResult("Not found", "요청한 페이지가 없습니다.");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult serverErrorHandler(Exception e){
        //HttpMessageNotReadableException
        log.info("exception", e);
        return new ErrorResult("server error", "AKSJDHFAKJD");
    }
}
