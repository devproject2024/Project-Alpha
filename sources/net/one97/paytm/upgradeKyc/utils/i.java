package net.one97.paytm.upgradeKyc.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.u;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66336a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, EditText editText) {
            k.c(context, "context");
            k.c(editText, H5AppUtil.short_prepareTime);
            try {
                Object systemService = context.getSystemService("input_method");
                if (systemService != null) {
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }
}
