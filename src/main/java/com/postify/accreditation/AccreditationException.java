package com.postify.accreditation;

public class AccreditationException extends Exception {

    private static final long serialVersionUID = -265702304363921751L;

    public AccreditationException() {
        super();
    }

    public AccreditationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccreditationException(String message) {
        super(message);
    }

    public AccreditationException(Throwable cause) {
        super(cause);
    }

}
