package com.travel.booking.datamodel;

public final class Status {
    private String debugMessage;
    private String message;
    private String title;

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public final void setDebugMessage(String str) {
        this.debugMessage = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
