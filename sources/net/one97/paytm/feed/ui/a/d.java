package net.one97.paytm.feed.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.R;
import org.json.JSONArray;

public final class d extends i {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.feed.ui.a.a.b f34828a;

    /* renamed from: b  reason: collision with root package name */
    String f34829b = "";

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.feed.repository.a.b f34830d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f34831e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f34832f;

    public final void b() {
        HashMap hashMap = this.f34832f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class a extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            this.this$0.dismissAllowingStateLoss();
            if (str != null) {
                this.this$0.c();
            } else {
                d.b(this.this$0);
            }
        }
    }

    public final int a() {
        return R.layout.feed_language_progress;
    }

    public final void a(View view) {
        k.c(view, "view");
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        if (!TextUtils.isEmpty(net.one97.paytm.feed.e.c.d())) {
            JSONArray jSONArray = new JSONArray(this.f34829b);
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            this.f34830d = net.one97.paytm.feed.c.a.a();
            net.one97.paytm.feed.repository.a.b bVar = this.f34830d;
            if (bVar == null) {
                k.a("provideVolleyHelper");
            }
            Context context = this.f34865c;
            if (context == null) {
                k.a();
            }
            String jSONArray2 = jSONArray.toString();
            k.a((Object) jSONArray2, "jsArray.toString()");
            bVar.a(context, jSONArray2, (kotlin.g.a.b<? super String, x>) new a(this));
            return;
        }
        dismissAllowingStateLoss();
        this.f34865c = null;
        c();
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f34835a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f34836b;

        c(e eVar, d dVar) {
            this.f34835a = eVar;
            this.f34836b = dVar;
        }

        public final void run() {
            try {
                this.f34835a.dismissAllowingStateLoss();
                net.one97.paytm.feed.ui.a.a.b c2 = this.f34836b.f34828a;
                if (c2 != null) {
                    c2.a(false);
                }
                this.f34836b.f34865c = null;
                this.f34836b.f34828a = null;
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        f fVar = new f();
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.a(this.f34829b);
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        net.one97.paytm.feed.e.c.k();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            net.one97.paytm.feed.ui.a.a.b bVar2 = this.f34828a;
            if (bVar2 != null) {
                fVar.a(bVar2);
            }
            k.a((Object) activity, "it");
            fVar.show(activity.getSupportFragmentManager(), "status");
        }
        this.f34831e = new Handler();
        Handler handler = this.f34831e;
        if (handler == null) {
            k.a();
        }
        handler.postDelayed(new C0567d(this, fVar), 1500);
    }

    /* renamed from: net.one97.paytm.feed.ui.a.d$d  reason: collision with other inner class name */
    static final class C0567d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f34838b;

        C0567d(d dVar, f fVar) {
            this.f34837a = dVar;
            this.f34838b = fVar;
        }

        public final void run() {
            try {
                net.one97.paytm.feed.ui.a.a.b c2 = this.f34837a.f34828a;
                if (c2 != null) {
                    c2.a(true);
                }
                this.f34838b.dismissAllowingStateLoss();
                this.f34837a.f34865c = null;
                this.f34837a.f34828a = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        d();
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new b(this));
        return onCreateDialog;
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34833a;

        b(d dVar) {
            this.f34833a = dVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setBottomSheetCallback(new BottomSheetBehavior.a(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f34834a;

                    public final void onSlide(View view, float f2) {
                        k.c(view, "bottomSheet");
                    }

                    {
                        this.f34834a = r1;
                    }

                    public final void onStateChanged(View view, int i2) {
                        k.c(view, "bottomSheet");
                        if (i2 == 5) {
                            this.f34834a.f34833a.d();
                            this.f34834a.f34833a.dismissAllowingStateLoss();
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        Handler handler = this.f34831e;
        if (handler != null) {
            if (handler == null) {
                k.a();
            }
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f34828a = null;
    }

    public static final /* synthetic */ void b(d dVar) {
        FragmentActivity activity = dVar.getActivity();
        if (activity != null) {
            e eVar = new e();
            k.a((Object) activity, "it");
            eVar.show(activity.getSupportFragmentManager(), "status");
            dVar.f34831e = new Handler();
            Handler handler = dVar.f34831e;
            if (handler == null) {
                k.a();
            }
            handler.postDelayed(new c(eVar, dVar), 1500);
        }
    }
}
