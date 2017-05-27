package dao;

/**
 * Created by Sergey on 20.02.2017.
 */
public class DAOException extends Exception {
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message) {
        super(message);
    }
}