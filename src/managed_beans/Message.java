package managed_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Serug on 01.06.2017.
 */

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {
    private String message = "Hello World!";

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}