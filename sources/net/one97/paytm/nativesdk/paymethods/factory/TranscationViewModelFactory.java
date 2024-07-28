package net.one97.paytm.nativesdk.paymethods.factory;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.viewmodel.TranscationViewModel;

public final class TranscationViewModelFactory implements al.b {
    private final Context context;
    private final String response;

    public TranscationViewModelFactory(Context context2, String str) {
        k.c(context2, "context");
        k.c(str, Payload.RESPONSE);
        this.context = context2;
        this.response = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getResponse() {
        return this.response;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(TranscationViewModel.class)) {
            return (ai) new TranscationViewModel(this.response);
        }
        throw new RuntimeException("View Model Not Defined");
    }
}
