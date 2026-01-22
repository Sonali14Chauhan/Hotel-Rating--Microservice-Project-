package com.sona.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sona.main.entity.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateHotelFoundEx.class)
	public ResponseEntity<ErrorResponse> duplicateHotelException(DuplicateHotelFoundEx dhfx, WebRequest webreq){
		ErrorResponse errorResponse = new ErrorResponse(dhfx.getMessage(), webreq.getDescription(false),"DUPLICATE HOTEL FOUND");
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(HotelNotFoundEx.class)
	public ResponseEntity<ErrorResponse> hotelNotFoundException(HotelNotFoundEx hnfx, WebRequest webreq){
		
		ErrorResponse errorResponse = new ErrorResponse(hnfx.getMessage(), webreq.getDescription(false)," HOTEL NOT FOUND");
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
			
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
