package db.exception;

public class DbException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public DbException(String msg){
        super(msg);
    }
    
}
