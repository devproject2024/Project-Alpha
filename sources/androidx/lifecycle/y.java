package androidx.lifecycle;

public class y<T> extends LiveData<T> {
    public y(T t) {
        super(t);
    }

    public y() {
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(T t) {
        super.setValue(t);
    }
}
