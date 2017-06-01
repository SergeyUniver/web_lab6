package managed_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by Serug on 01.06.2017.
 */
@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {
    @ManagedProperty(value = "#{message}")
    private Message messageBean;
    private String message;

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessageString() {
        if(messageBean != null) {
            message = messageBean.getMessage();
        }
        return message;
    }

    public void setMessageBean(Message message) {
        this.messageBean = message;

    }
}