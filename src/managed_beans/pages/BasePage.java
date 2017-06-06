package managed_beans.pages;

import managed_beans.property.SessionBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by Ionas on 01.06.2017.
 */
@ManagedBean(name = "base_page", eager = true)
@RequestScoped
public class BasePage {

    @ManagedProperty(value = "#{session_bean}")
    protected SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String indexPage(){
        if(sessionBean.isAuthorizeUser()){
            return "index";
        }else{
            return "sign_in";
        }
    }

    public String menuPage(){
        if(sessionBean.isAuthorizeUser()){
            return "menu";
        }else{
            return "sign_in";
        }
    }

    public String makeOrderPage(){
        if(sessionBean.isAuthorizeUser()){
            return "make_order";
        }else{
            return "sign_in";
        }
    }

    public String acceptedOrdersPage(){
        if(sessionBean.isAuthorizeUser()){
            return "accepted_orders";
        }else{
            return "sign_in";
        }
    }

    public String ordersByClientPage(){
        if(sessionBean.isAuthorizeUser()){
            return "orders";
        }else{
            return "sign_in";
        }
    }

    public String logOutPage(){
        sessionBean.clearUser();
        return "sign_in";
    }



}
