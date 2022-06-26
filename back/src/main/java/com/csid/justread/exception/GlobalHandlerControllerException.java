package com.csid.justread.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = {"com.csid.justread"} )
public class GlobalHandlerControllerException extends ResponseEntityExceptionHandler {

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        //Vous pouvez intialiser n'importe quelle donnée ici

    }

    @ModelAttribute
    public void globalAttributes(Model model) {
        model.addAttribute("technicalError", "Une erreur technique est survenue !");
    }

    @ExceptionHandler(Exception.class)//toutes les autres erreurs non gérées par le service sont interceptées ici
    public ResponseEntity<ServiceExceptionDto> unknowError(HttpServletRequest req, Exception ex) {
        ServiceExceptionDto response = new ServiceExceptionDto();
        response.setErrorCode("Technical Error");
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString());
        return new ResponseEntity<ServiceExceptionDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceExceptionDto> businessResourceError(HttpServletRequest req, ServiceException ex) {
        ServiceExceptionDto businessResourceExceptionDTO = new ServiceExceptionDto();
        businessResourceExceptionDTO.setStatus(ex.getStatus());
        businessResourceExceptionDTO.setErrorCode(ex.getErrorCode());
        businessResourceExceptionDTO.setErrorMessage(ex.getMessage());
        businessResourceExceptionDTO.setRequestURL(req.getRequestURL().toString());
        return new ResponseEntity<ServiceExceptionDto>(businessResourceExceptionDTO, ex.getStatus());
    }
}
