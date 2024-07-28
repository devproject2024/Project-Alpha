package androidx.databinding;

import java.io.Serializable;

public class i<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public i(T t) {
        this.mValue = t;
    }

    public i() {
    }

    public i(h... hVarArr) {
        super(hVarArr);
    }

    public T get() {
        return this.mValue;
    }

    public void set(T t) {
        if (t != this.mValue) {
            this.mValue = t;
            notifyChange();
        }
    }
}
