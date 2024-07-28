package androidx.databinding;

import androidx.databinding.h;

public class a implements h {
    private transient m mCallbacks;

    public void addOnPropertyChangedCallback(h.a aVar) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new m();
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.b(aVar);
            }
        }
    }

    public void notifyChange() {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.a(this, 0);
            }
        }
    }

    public void notifyPropertyChanged(int i2) {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.a(this, i2);
            }
        }
    }
}
