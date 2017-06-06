package action;

import actions.*;
import dao.DAOCreator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ionas on 21.05.2017.
 */
public class ActionManager {
    /**
     * Get Action from name
     * @param actionName name of action
     * @return IAction class
     */

    public static final String ACTION_ATTR = "action";

    public static IAction getAction(HttpServletRequest request, DAOCreator daoCreator) {
        String actionName = request.getParameter(ACTION_ATTR);
            ActionEnum actionEnum = ActionEnum.valueOf(actionName.toUpperCase().replace("-", "_"));
            switch (actionEnum) {
                case SHOW_ORDERS_BY_CLIENT:
                    return new ShowOrderByClientAction(daoCreator);
                case SHOW_MENU:
                    return new ShowMenuAction(daoCreator);
                case SHOW_ACCEPTED_ORDERS:
                    return new ShowAcceptedOrdersAction(daoCreator);
                case MAKE_ORDER:
                    return new MakeOrderAction(daoCreator);
                case SIGN_IN:
                    return new SignInAction(daoCreator);
                case SIGN_UP:
                    return new SignUpAction(daoCreator);
                case LOG_OUT:
                    return new LogOutAction(daoCreator);
                case EDIT_MENU:
                    return new EditMenuAction(daoCreator);
                case UPDATE_MENU_ITEM:
                    return new UpdateMenuAction(daoCreator);
                default:
                    throw new UnsupportedOperationException(actionName);
            }
//        }
    }

    /**
     * Action enumeration
     */
    public enum ActionEnum {
        SHOW_ORDERS_BY_CLIENT, SHOW_MENU, SHOW_ACCEPTED_ORDERS, MAKE_ORDER,
        SIGN_IN, SIGN_UP, LOG_OUT, EDIT_MENU, UPDATE_MENU_ITEM;
    }
}