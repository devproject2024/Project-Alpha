package net.one97.paytm.oauth.utils;

import java.util.Observable;

public abstract class c extends Observable {
    public final void a(Object obj) {
        setChanged();
        notifyObservers(obj);
    }
}
