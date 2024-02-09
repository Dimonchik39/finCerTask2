package org.example.task2;

public class NotFoundAnswerException extends Exception{
    public NotFoundAnswerException(String text) {
        super(text);
    }
}
