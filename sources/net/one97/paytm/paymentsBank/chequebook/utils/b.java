package net.one97.paytm.paymentsBank.chequebook.utils;

import android.app.Application;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.utils.c;

public final class b {
    public static final <T extends ai> T a(Fragment fragment, Class<T> cls) {
        k.c(fragment, "receiver$0");
        k.c(cls, "viewModelClass");
        c.a aVar = c.f17946a;
        FragmentActivity activity = fragment.getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        T a2 = am.a(fragment, (al.b) c.a.a(application)).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…n!!)).get(viewModelClass)");
        return a2;
    }

    public static final void a(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final void b(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(8);
    }

    public static void a(AppCompatActivity appCompatActivity, int i2, Fragment fragment) {
        k.c(appCompatActivity, "receiver$0");
        k.c(fragment, "fragment");
        q b2 = appCompatActivity.getSupportFragmentManager().a().b(i2, fragment, (String) null);
        k.a((Object) b2, "this.supportFragmentMana…(layoutId, fragment, tag)");
        b2.c();
    }
}
