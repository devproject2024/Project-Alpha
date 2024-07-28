package net.one97.paytm.hotel4.service.model;

public final class ErrorData {
    private final String message;
    private final Integer statusCode;
    private final String title;

    public ErrorData(Integer num, String str, String str2) {
        this.statusCode = num;
        this.title = str;
        this.message = str2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getTitle() {
        return this.title;
    }
}
