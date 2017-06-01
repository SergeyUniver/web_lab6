package managed_beans.pages;

import dao.DAOException;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Serug on 01.06.2017.
 */
@ManagedBean(name = "signIn", eager = true)
@RequestScoped
public class SignInPage extends BasePage {

    private String message;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String message(){
        return message;
    }

    public String login(){
        try {
            User user = sessionBean.getUserDAO().tryAuthorize(name, password);
            if(user == null){

                message = "Wrong login or password";
                return "sign_in";
            }else{
                sessionBean.setUser(user);
                return "index";
            }
        } catch (DAOException e) {
            e.printStackTrace();
            message = "Wrong login or password";
            return "sign_in";
        }
    }

}
