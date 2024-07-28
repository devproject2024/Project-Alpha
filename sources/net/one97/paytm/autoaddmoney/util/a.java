package net.one97.paytm.autoaddmoney.util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import kotlin.g.b.k;
import net.one97.paytm.autoaddmoney.c;

public final class a {
    public static final <T extends ai> T a(AppCompatActivity appCompatActivity, Class<T> cls) {
        k.c(appCompatActivity, "receiver$0");
        k.c(cls, "viewModelClass");
        c.a aVar = c.f49170a;
        T a2 = am.a((FragmentActivity) appCompatActivity, (al.b) c.a.a(appCompatActivity.getApplication())).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…ion)).get(viewModelClass)");
        return a2;
    }
}
