package net.one97.paytm.phoenix.viewmodel;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ViewModelFactory extends al.d {
    public static final Companion Companion = new Companion((g) null);
    private final Context context;

    public ViewModelFactory(Context context2) {
        k.c(context2, "context");
        this.context = context2;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(PhoenixViewModel.class)) {
            return (ai) new PhoenixViewModel(this.context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + cls.getName());
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ViewModelFactory getViewModel(Context context) {
            k.c(context, "context");
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            return new ViewModelFactory(applicationContext);
        }
    }
}
