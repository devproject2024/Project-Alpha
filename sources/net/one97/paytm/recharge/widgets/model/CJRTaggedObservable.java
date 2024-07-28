package net.one97.paytm.recharge.widgets.model;

public class CJRTaggedObservable<T> {
    private T data;
    private String tag;

    public CJRTaggedObservable(String str, T t) {
        this.tag = str;
        this.data = t;
    }

    public String getTag() {
        return this.tag;
    }

    public T getData() {
        return this.data;
    }
}
