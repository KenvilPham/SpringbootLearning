package com.learn.springboot.employeethymleaf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String returnHome(ResourceNotFoundException ex, RedirectAttributes redirect) {
        redirect.addFlashAttribute("successMessage", ex.getMessage());
        return "redirect:/employee";
    }
}
