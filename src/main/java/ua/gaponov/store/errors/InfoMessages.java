package ua.gaponov.store.errors;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class InfoMessages {

    private List<String> messages = new ArrayList<>();

    public void addMessage(String message){
        messages.add(message);
    }
}