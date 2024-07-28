package net.one97.paytm.upgradeKyc.kycV3;

import android.app.Application;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.kycV3.c.g;

public final class b {
    public static final <T extends ai> T a(AppCompatActivity appCompatActivity, Class<T> cls) {
        k.c(appCompatActivity, "receiver$0");
        k.c(cls, "viewModelClass");
        g.a aVar = g.f66236a;
        Application application = appCompatActivity.getApplication();
        k.a((Object) application, "application");
        T a2 = am.a((FragmentActivity) appCompatActivity, (al.b) g.a.a(application)).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…ion)).get(viewModelClass)");
        return a2;
    }

    public static final <T extends ai> T a(Fragment fragment, Class<T> cls) {
        k.c(fragment, "receiver$0");
        k.c(cls, "viewModelClass");
        g.a aVar = g.f66236a;
        FragmentActivity activity = fragment.getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        T a2 = am.a(fragment, (al.b) g.a.a(application)).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…n!!)).get(viewModelClass)");
        return a2;
    }

    public static final void a(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(8);
    }

    public static final void b(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final boolean a(String str) {
        k.c(str, "panAckDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd");
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            Date parse2 = simpleDateFormat.parse(str);
            if (parse2 == null || !parse2.after(parse)) {
                return false;
            }
            return true;
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }
}
