package androidx.databinding;

public interface h {

    public static abstract class a {
        public abstract void onPropertyChanged(h hVar, int i2);
    }

    void addOnPropertyChangedCallback(a aVar);

    void removeOnPropertyChangedCallback(a aVar);
}
