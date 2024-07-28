package net.one97.paytm.wallet.rateMerchant.utils;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.rateMerchant.c.c;

public final class a {
    public static final <T extends ai> T a(Fragment fragment, Class<T> cls) {
        k.c(fragment, "receiver$0");
        k.c(cls, "viewModelClass");
        c.a aVar = c.f71702a;
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Application application = activity.getApplication();
        k.a((Object) application, "activity!!.application");
        T a2 = am.a(fragment, (al.b) c.a.a(application)).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…ion)).get(viewModelClass)");
        return a2;
    }

    public static final String a(Context context, String str) {
        k.c(context, "context");
        String string = context.getString(R.string.channels_generic_error);
        if (str != null && str.equals(NetworkCustomError.ErrorType.NoConnectionError.name())) {
            string = context.getString(R.string.channels_no_internet);
        }
        k.a((Object) string, "errorMsg");
        return string;
    }
}
