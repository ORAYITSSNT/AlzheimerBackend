package ma.wafae.ta3aounyati.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
public class ExceptionAbstract extends RuntimeException{
    private HttpStatus status;
    private String message;
    private Integer errorCode;
}

