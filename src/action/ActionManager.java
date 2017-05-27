package action;

import actions.*;
import dao.DAOCreator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Serug on 21.05.2017.
 */
public class ActionManager {
    /**
     * Get Action from name
     * @param actionName name of action
     * @return IAction class
     */
    public static IAction getAction(HttpServletRequest request, DAOCreator daoCreator) {
        String actionName = request.getParameter("action");
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
                default:
                    throw new UnsupportedOperationException(actionName);
            }
//        }
    }

    /**
     * Action enumeration
     */
    private enum ActionEnum {
        SHOW_ORDERS_BY_CLIENT, SHOW_MENU, SHOW_ACCEPTED_ORDERS, MAKE_ORDER;
    }
}