package com.paytmmall.clpartifact.network;

public class Resource<T> {
    private T data;
    private Throwable error;
    private RequestType requestType;
    private Status status;

    private Resource() {
    }

    private Resource(Builder<T> builder) {
        this.data = builder.data;
        this.error = builder.error;
        this.status = builder.status;
        this.requestType = builder.requestType;
    }

    public T getData() {
        return this.data;
    }

    public Throwable getError() {
        return this.error;
    }

    public Status getStatus() {
        return this.status;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public static <T> Resource success(T t) {
        return new Builder().body(t).status(Status.SUCCESS).build();
    }

    public static <T> Resource error(Throwable th) {
        return new Builder().error(th).status(Status.FAIL).build();
    }

    public static <T> Resource progress(RequestType requestType2) {
        return new Builder().requestType(requestType2).status(Status.PROGRESS).build();
    }

    public Resource<T> setRequestType(RequestType requestType2) {
        this.requestType = requestType2;
        return this;
    }

    public static class Builder<T> {
        /* access modifiers changed from: private */
        public T data;
        /* access modifiers changed from: private */
        public Throwable error;
        /* access modifiers changed from: private */
        public RequestType requestType;
        /* access modifiers changed from: private */
        public Status status;

        public Builder<T> body(T t) {
            this.data = t;
            return this;
        }

        public Builder<T> error(Throwable th) {
            this.error = th;
            return this;
        }

        public Builder<T> status(Status status2) {
            this.status = status2;
            return this;
        }

        public Builder<T> requestType(RequestType requestType2) {
            this.requestType = requestType2;
            return this;
        }

        public Resource<T> build() {
            return new Resource<>(this);
        }
    }
}
