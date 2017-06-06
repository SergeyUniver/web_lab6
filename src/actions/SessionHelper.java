package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Ionas on 21.05.2017.
 */
public class SessionHelper {

    public static final String USER_ATTR = "user";

    private Date lastAccessTime;
    private int visitCount;

    public static SessionHelper createSession(HttpServletRequest request) {
        SessionHelper helper = new SessionHelper();
        HttpSession session = request.getSession(true);
        helper.lastAccessTime = new Date(session.getLastAccessedTime());
        String visitCountKey = "visitCount";
        if(session.isNew() || session.getAttribute(visitCountKey) == null){
            helper.visitCount = 0;
        }else{
            helper.visitCount = (Integer) session.getAttribute(visitCountKey);
        }
        session.setAttribute(visitCountKey,  helper.visitCount + 1);
        return helper;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
