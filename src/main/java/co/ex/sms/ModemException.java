package co.ex.sms;

public class ModemException extends Exception {
    public ModemException(String message) {
        super(message);
    }

    public ModemException(String message, Throwable cause) {
        super(message, cause);
    }
}