package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49342a = new a((byte) 0);

    /* renamed from: f  reason: collision with root package name */
    private static boolean f49343f;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f49344b = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    private ShimmerFrameLayout f49345c;

    /* renamed from: d  reason: collision with root package name */
    private View f49346d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49347e;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f49348g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49349a;

        b(c cVar) {
            this.f49349a = cVar;
        }

        public final void onClick(View view) {
            c.a(this.f49349a);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.am_status_fargment_layout, (ViewGroup) null);
        k.a((Object) inflate, "view");
        View findViewById = inflate.findViewById(R.id.shimmer_layout);
        if (findViewById != null) {
            this.f49345c = (ShimmerFrameLayout) findViewById;
            this.f49346d = inflate.findViewById(R.id.layout_dummy_shiffer);
            View findViewById2 = inflate.findViewById(R.id.tv_automatic_status);
            if (findViewById2 != null) {
                this.f49347e = (TextView) findViewById2;
                TextView textView = this.f49347e;
                if (textView == null) {
                    k.a("mAutomaticTextView");
                }
                textView.setOnClickListener(new b(this));
                a();
                return inflate;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout");
    }

    /* renamed from: net.one97.paytm.autoaddmoney.views.c$c  reason: collision with other inner class name */
    public static final class C0877c implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49350a;

        C0877c(c cVar) {
            this.f49350a = cVar;
        }

        public final void a(CJRSubscribeFetchStatus cJRSubscribeFetchStatus) {
            c.b(this.f49350a);
            if (cJRSubscribeFetchStatus != null && this.f49350a.b()) {
                c.a(this.f49350a, cJRSubscribeFetchStatus);
            }
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            c.b(this.f49350a);
        }

        public final void a(NetworkCustomError networkCustomError) {
            c.b(this.f49350a);
            if (this.f49350a.getActivity() != null) {
                FragmentActivity activity = this.f49350a.getActivity();
                if (activity == null) {
                    k.a();
                }
                Activity activity2 = activity;
                if (networkCustomError == null) {
                    k.a();
                }
                AddMoneyUtils.a(activity2, networkCustomError, (String) null, Boolean.FALSE);
            }
        }

        public final void a() {
            c.b(this.f49350a);
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            c.b(this.f49350a);
            if (this.f49350a.getActivity() != null) {
                net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
                FragmentActivity activity = this.f49350a.getActivity();
                if (activity != null) {
                    a2.a((Activity) activity, (String) null, (Bundle) null);
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
    }

    private final void a() {
        net.one97.paytm.autoaddmoney.b bVar = net.one97.paytm.autoaddmoney.b.f49147a;
        net.one97.paytm.autoaddmoney.b.a(getActivity()).a((a.d) new C0877c(this));
    }

    /* access modifiers changed from: private */
    public final boolean b() {
        if (getActivity() == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        return !activity.isFinishing();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 123) {
            a();
        }
    }

    public static final /* synthetic */ void a(c cVar) {
        Intent intent = new Intent(cVar.getActivity(), AmAutomaticActivity.class);
        intent.putExtra("which_page", "add_money");
        cVar.startActivityForResult(intent, 123);
    }

    public static final /* synthetic */ void b(c cVar) {
        if (cVar.b()) {
            View view = cVar.f49346d;
            if (view != null) {
                view.setVisibility(8);
            }
            ShimmerFrameLayout shimmerFrameLayout = cVar.f49345c;
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if ("FAILURE".equals(r0) == false) goto L_0x00f3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.autoaddmoney.views.c r5, net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus r6) {
        /*
            java.lang.String r0 = r6.getStatusCode()
            java.lang.String r1 = "cJRSubscribeFetchStatus.statusCode"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r6.getStatusMessage()
            r2 = 1
            if (r1 == 0) goto L_0x001b
            java.lang.String r3 = "SUCCESS"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            if (r1 != 0) goto L_0x0021
            kotlin.g.b.k.a()
        L_0x0021:
            boolean r1 = r1.booleanValue()
            java.lang.String r3 = "USD_1027"
            java.lang.String r4 = "mAutomaticTextView"
            if (r1 == 0) goto L_0x00af
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus$Response r0 = r6.getResponse()
            java.lang.String r6 = r6.getStatusCode()
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x00bd
            java.lang.String r6 = "response"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r6 = r0.getStatusOfSubscription()
            net.one97.paytm.autoaddmoney.util.c r0 = net.one97.paytm.autoaddmoney.util.c.FAILED
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00bd
            net.one97.paytm.autoaddmoney.util.c r0 = net.one97.paytm.autoaddmoney.util.c.INACTIVE
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00bd
            net.one97.paytm.autoaddmoney.util.c r0 = net.one97.paytm.autoaddmoney.util.c.DISABLED_BY_USER
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x006b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.f49344b = r6
            goto L_0x00bd
        L_0x006b:
            net.one97.paytm.autoaddmoney.util.c r0 = net.one97.paytm.autoaddmoney.util.c.ACTIVE
            java.lang.String r0 = r0.toString()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x00ae
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x007e:
            r0 = 8
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x008a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x008a:
            int r0 = net.one97.paytm.addmoney.R.string.active_text_am
            java.lang.String r0 = r5.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x009c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x009c:
            android.content.Context r5 = r5.getContext()
            if (r5 != 0) goto L_0x00a5
            kotlin.g.b.k.a()
        L_0x00a5:
            int r0 = net.one97.paytm.addmoney.R.drawable.automatic_active_bg
            android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r5, (int) r0)
            r6.setBackground(r5)
        L_0x00ae:
            return
        L_0x00af:
            boolean r6 = r3.equals(r0)
            if (r6 != 0) goto L_0x00bd
            java.lang.String r6 = "FAILURE"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x00f3
        L_0x00bd:
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x00c4
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00c4:
            int r0 = net.one97.paytm.addmoney.R.string.automatic_setup_text
            java.lang.String r0 = r5.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x00d6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00d6:
            r0 = 0
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.f49347e
            if (r6 != 0) goto L_0x00e1
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00e1:
            android.content.Context r5 = r5.getContext()
            if (r5 != 0) goto L_0x00ea
            kotlin.g.b.k.a()
        L_0x00ea:
            int r0 = net.one97.paytm.addmoney.R.drawable.automatic_inactive_bg
            android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r5, (int) r0)
            r6.setBackground(r5)
        L_0x00f3:
            f49343f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.c.a(net.one97.paytm.autoaddmoney.views.c, net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49348g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
