package br.com.b2w.starwars.planets.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.b2w.starwars.planets.exception.ServiceException;
import br.com.b2w.starwars.planets.model.PlanetResponse;

@ControllerAdvice
public class PlanetExceptionHandler extends ResponseEntityExceptionHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	   @Override
		protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
																				HttpHeaders headers, 
																				HttpStatus status, 
																				WebRequest request) {		
			return new ResponseEntity<>(new PlanetResponse("Error", ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}

	    @ExceptionHandler(ServiceException.class)
	    public ResponseEntity<PlanetResponse> handleServiceException(ServiceException ex, HttpServletRequest request) {
	        return new ResponseEntity<PlanetResponse>(new PlanetResponse(ex.getReason(), ex.getReasonDetail(), ex.getCode()), HttpStatus.valueOf(ex.getCode()));
	    }
	    
	    @ExceptionHandler(NullPointerException.class)
	    public ResponseEntity<PlanetResponse> nullPointerException(final NullPointerException ex) {

	        logger.info("Null Pointer Exception => {} => {}", ex.toString(), ex.getMessage());
	        return new ResponseEntity<PlanetResponse>(new PlanetResponse(ex.getMessage(),ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	
	
}
