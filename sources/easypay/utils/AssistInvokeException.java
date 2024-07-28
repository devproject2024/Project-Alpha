package easypay.utils;

public class AssistInvokeException extends Exception {
    public AssistInvokeException() {
    }

    public AssistInvokeException(String str) {
        super(str);
    }

    protected AssistInvokeException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
