package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.i;

public final class bv extends v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56537a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.oauth.e.b f56538b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56539c;

    public final View a(int i2) {
        if (this.f56539c == null) {
            this.f56539c = new HashMap();
        }
        View view = (View) this.f56539c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56539c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56539c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public bv() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bv(net.one97.paytm.oauth.e.b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56538b = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bv a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            k.c(bVar, "listener");
            bv bvVar = new bv(bVar);
            bvVar.setArguments(bundle);
            return bvVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verification_success, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        new Handler().postDelayed(new b(this), 100);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bv f56540a;

        b(bv bvVar) {
            this.f56540a = bvVar;
        }

        public final void run() {
            Bundle arguments = this.f56540a.getArguments();
            boolean z = arguments != null ? arguments.getBoolean("is_new_signup") : false;
            net.one97.paytm.oauth.e.b a2 = this.f56540a.f56538b;
            if (a2 != null) {
                Bundle arguments2 = this.f56540a.getArguments();
                String str = null;
                String string = arguments2 != null ? arguments2.getString("login_mobile") : null;
                Bundle arguments3 = this.f56540a.getArguments();
                if (arguments3 != null) {
                    str = arguments3.getString(H5Param.SESSION_ID);
                }
                a2.a(string, str, z, z ? i.SIGNUP : i.LOGIN);
            }
        }
    }
}
