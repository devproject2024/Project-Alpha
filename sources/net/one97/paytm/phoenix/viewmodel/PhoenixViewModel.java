package net.one97.paytm.phoenix.viewmodel;

import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import kotlin.g.b.k;

public final class PhoenixViewModel extends ai {
    private final y<Boolean> _dataLoading = new y<>();
    private final y<Event<String>> _javaScript = new y<>();
    private final y<Event<String>> _toastText = new y<>();
    private final Context applicationContext;
    private final LiveData<Boolean> dataLoading = this._dataLoading;
    private final LiveData<Event<String>> javaScript = this._javaScript;
    private final LiveData<Event<String>> toastText = this._toastText;

    public PhoenixViewModel(Context context) {
        k.c(context, "applicationContext");
        this.applicationContext = context;
    }

    public final LiveData<Event<String>> getJavaScript() {
        return this.javaScript;
    }

    public final LiveData<Boolean> getDataLoading() {
        return this.dataLoading;
    }

    public final LiveData<Event<String>> getToastText() {
        return this.toastText;
    }

    public final void loadJavascript(String str) {
        k.c(str, "script");
        if (k.a((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            this._javaScript.setValue(new Event(str));
        } else {
            this._javaScript.postValue(new Event(str));
        }
    }

    public final void showToastMessage(String str) {
        k.c(str, "message");
        if (k.a((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            this._toastText.setValue(new Event(str));
        } else {
            this._toastText.postValue(new Event(str));
        }
    }

    public final void showLoading(boolean z) {
        if (k.a((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            this._dataLoading.setValue(Boolean.valueOf(z));
        } else {
            this._dataLoading.postValue(Boolean.valueOf(z));
        }
    }
}
