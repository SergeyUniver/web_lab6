package action;

import dao.DAOCreator;

/**
 * Created by Ionas on 21.05.2017.
 */
public class Action {

    public static final String SESSION_PARAM = "session";
    public static final String IS_REDIRECT = "is_redirect";

    protected final DAOCreator daoCreator;

    public Action(DAOCreator daoCreator) {
        this.daoCreator = daoCreator;
    }
}
