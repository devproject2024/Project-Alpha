package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import androidx.lifecycle.a;
import java.lang.ref.WeakReference;

public class NavigableViewModel<T> extends a {
    private WeakReference<T> navigatorRef;

    public NavigableViewModel(Application application) {
        super(application);
    }

    public void setNavigator(T t) {
        this.navigatorRef = new WeakReference<>(t);
    }

    public WeakReference<T> getNavigatorRef() {
        return this.navigatorRef;
    }

    public T getNavigator() {
        WeakReference<T> weakReference = this.navigatorRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void onCleared() {
        WeakReference<T> weakReference = this.navigatorRef;
        if (weakReference != null) {
            weakReference.clear();
            this.navigatorRef = null;
        }
        super.onCleared();
    }
}
