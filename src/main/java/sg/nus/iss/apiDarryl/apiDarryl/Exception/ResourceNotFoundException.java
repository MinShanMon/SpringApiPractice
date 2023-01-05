package sg.nus.iss.apiDarryl.apiDarryl.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
