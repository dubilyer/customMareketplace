package api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

import static utils.LoggerDecorator.logger;

public class CommonController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        return new ResponseEntity<>(getText(ex), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private String getText(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return new StringBuffer("<pre>")
                .append(ex.getMessage())
                .append("\n\n")
                .append(errors)
                .append("</pre>")
                .toString();
    }
}
