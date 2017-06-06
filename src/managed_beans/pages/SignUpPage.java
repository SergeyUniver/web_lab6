package managed_beans.pages;

import dao.DAOException;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Ionas on 01.06.2017.
 */
@ManagedBean(name = "signUp", eager = true)
@RequestScoped
public class SignUpPage extends BasePage {

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

    public String register(){
        try {
            User user = sessionBean.getUserDAO().createNewUser(name, password);
            if(user == null){

                message = "User already exist";
                return "sign_up";
            }else{
                sessionBean.setUser(user);
                return "index";
            }
        } catch (DAOException e) {
            e.printStackTrace();
            message = "User already exist";
            return "sign_up";
        }
    }

}
