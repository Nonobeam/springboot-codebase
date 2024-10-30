package org.nonoproject.nonoproject.utility.web.advice;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import org.nonoproject.nonoproject.utility.web.model.res.ApiResp;
import org.nonoproject.nonoproject.utility.web.model.res.ErrorCode;
import org.nonoproject.nonoproject.utility.web.model.res.FieldError;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public abstract class ExceptionHandlerAdvice {
    @Getter private final MessageSource messageSource;

    public ExceptionHandlerAdvice(final MessageSource source) {
    this.messageSource = source;
  }

    public List<FieldError> extractFieldErrors(BindingResult bindingResult) {
        if (!bindingResult.hasFieldErrors()) return Collections.emptyList();

        return bindingResult.getFieldErrors().stream()
            .map(
                error ->
                    FieldError.builder()
                        .field(error.getField())
                        .message(
                            messageSource.getMessage(
                                error.getDefaultMessage(), null, LocaleContextHolder.getLocale()))
                        .build())
            .toList();
    }

    public ResponseEntity<?> error(ErrorCode errorCode, List<FieldError> fieldErrors) {
        var message = messageSource.getMessage(errorCode.getSystemCode(), null, LocaleContextHolder.getLocale());
        var error = ApiResp.ErrorResp.builder().code(errorCode).message(message).details(fieldErrors).build();
        var response = ApiResp.builder().error(error).build();

        return ResponseEntity.status(error.getCode().getHttpStatusCode()).body(response);
    }

    public ResponseEntity<?> error(ErrorCode errorCode, Object... args) {
        var message = messageSource.getMessage(errorCode.getSystemCode(), args, LocaleContextHolder.getLocale());
        var error = ApiResp.ErrorResp.builder().code(errorCode).message(message).build();
        var response = ApiResp.builder().error(error).build();

        return ResponseEntity.status(error.getCode().getHttpStatusCode()).body(response);
    }
}
