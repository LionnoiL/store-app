package ua.gaponov.store.errors;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ErrorMessages {

    private List<String> errors = new ArrayList<>();

    public void addError(String message) {
        errors.add(message);
    }

    public void clear() {
        errors.clear();
    }
}
