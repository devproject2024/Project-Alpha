package net.one97.paytm.phoenix.util;

import java.util.Observable;

public abstract class a extends Observable {
    public final void a(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

    public final void b(Object obj) {
        setChanged();
        notifyObservers(obj);
    }
}
