package Excpections;

public class ProgrammerUnavailableNowException extends RuntimeException{
    public ProgrammerUnavailableNowException(String message) {
        super(message);
    }
}
