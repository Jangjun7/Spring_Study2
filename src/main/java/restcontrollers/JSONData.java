package restcontrollers;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONData<T> {
    private boolean success;
    private HttpStatus status = HttpStatus.OK; // 200
    private T data;
    private String message;
}
