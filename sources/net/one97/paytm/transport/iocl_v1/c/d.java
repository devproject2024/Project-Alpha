package net.one97.paytm.transport.iocl_v1.c;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.i;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.b;
import java.util.regex.Pattern;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl_v1.a.e;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;

public final class d extends b {

    /* renamed from: f  reason: collision with root package name */
    public FragmentActivity f14442f;

    /* renamed from: g  reason: collision with root package name */
    public i<String> f14443g = new i<>();

    /* renamed from: h  reason: collision with root package name */
    public i<String> f14444h = new i<>();

    /* renamed from: i  reason: collision with root package name */
    public i<String> f14445i = new i<>();
    public i<String> j = new i<>();
    public i<String> k = new i<>();
    public i<String> l = new i<>();
    public i<String> m = new i<>();
    public i<String> n = new i<>();
    public e.a o;
    public y<String> p = new y<>();

    public d(e.a aVar, Application application, FragmentActivity fragmentActivity) {
        super(application);
        this.o = aVar;
        this.f14442f = fragmentActivity;
        if (!b.c((Context) fragmentActivity)) {
            fragmentActivity.getString(R.string.iocl_no_connection);
            b.a((Context) (IOCLBaseActivity) fragmentActivity, fragmentActivity.getString(R.string.iocl_no_internet), false);
        } else if (b.r((Context) fragmentActivity)) {
            net.one97.paytm.transport.iocl_v1.b.b.a((Context) application, (com.paytm.network.listener.b) this);
        } else {
            ((IOCLBaseActivity) fragmentActivity).f();
        }
    }

    public static boolean a(String str) {
        return Pattern.compile("^[a-zA-Z\\s\\.]+$", 2).matcher(str).find();
    }

    public static boolean b(String str) {
        if (str != null && str.trim().split(" ").length <= 3) {
            return true;
        }
        return false;
    }

    public static void a(TextInputLayout textInputLayout, String str) {
        if (TextUtils.isEmpty(str)) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
        textInputLayout.setError(str);
    }
}
