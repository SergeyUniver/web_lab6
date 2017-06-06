package action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ionas on 21.05.2017.
 */
public interface IAction {
    void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}