package com.paytmmall.clpartifact.repositories;

import java.lang.ref.WeakReference;

public class BaseRepository<T> {
    private WeakReference<T> navigator;

    public void setNavigator(WeakReference<T> weakReference) {
        this.navigator = weakReference;
    }

    public T getNavigator() {
        WeakReference<T> weakReference = this.navigator;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
