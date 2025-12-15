package inha.edu.kr.airlineproject.exception;

public class AirplaneTypeAlreadyExistException extends RuntimeException {
    public AirplaneTypeAlreadyExistException(String message) {
        super(message);
    }
}
