package com.paytm.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.ads.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.m.p;
import kotlin.x;

public class PaytmAdView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    com.paytm.ads.d.a f40852a;

    /* renamed from: b  reason: collision with root package name */
    String f40853b;

    /* renamed from: c  reason: collision with root package name */
    String f40854c;

    /* renamed from: d  reason: collision with root package name */
    boolean f40855d;

    /* renamed from: e  reason: collision with root package name */
    public String f40856e;

    /* renamed from: f  reason: collision with root package name */
    c f40857f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f40858g;

    /* renamed from: h  reason: collision with root package name */
    private final g f40859h = h.a(b.f40861a);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f40860i;
    private long j;
    private final g k = h.a(c.f40862a);

    public static abstract class a implements View.OnClickListener {
        public abstract void onAdClick(View view);

        public void onClick(View view) {
            String a2;
            if (view instanceof PaytmAdView) {
                PaytmAdView paytmAdView = (PaytmAdView) view;
                if (!(paytmAdView.f40860i == null || (a2 = paytmAdView.f40860i) == null || p.a(a2))) {
                    d dVar = d.f40887a;
                    String a3 = paytmAdView.f40860i;
                    if (a3 == null) {
                        k.a();
                    }
                    d.a(a3);
                }
            }
            onAdClick(view);
        }
    }

    static final class b extends l implements kotlin.g.a.a<ArrayList<b>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f40861a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final ArrayList<b> invoke() {
            return new ArrayList<>();
        }
    }

    static final class c extends l implements kotlin.g.a.a<ArrayList<String>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f40862a = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final ArrayList<String> invoke() {
            return new ArrayList<>();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaytmAdView(Context context) {
        super(context);
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f40858g = applicationContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaytmAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f40858g = applicationContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaytmAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f40858g = applicationContext;
    }

    public final PaytmAdView a(String str) {
        if (str != null) {
            getPixelUrls().add(str);
        }
        return this;
    }

    public final String getAdId$paytm_ad_sdk_release() {
        return this.f40856e;
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<b> getAdVerificationResources() {
        return (ArrayList) this.f40859h.getValue();
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<String> getPixelUrls() {
        return (ArrayList) this.k.getValue();
    }

    public final long getTime$paytm_ad_sdk_release() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((!getAdVerificationResources().isEmpty()) || (!getPixelUrls().isEmpty())) {
            timber.log.a.a("[AdEvent] onAttachedToWindow()", new Object[0]);
            e.a aVar = e.f40895a;
            Context context = getContext();
            k.a((Object) context, "context");
            e a2 = e.a.a(context);
            if (a2 != null) {
                a2.a(this);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder("[AdEvent] onAttachedToWindow() not ran!! Because adVerificationResources.isNotEmpty = ");
        sb.append(!getAdVerificationResources().isEmpty());
        sb.append(' ');
        sb.append("or pixelUrls.isNotEmpty() = ");
        sb.append(!getPixelUrls().isEmpty());
        timber.log.a.b(sb.toString(), new Object[0]);
    }

    public final void setAdId$paytm_ad_sdk_release(String str) {
        this.f40856e = str;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && (onClickListener instanceof a)) {
            super.setOnClickListener(onClickListener);
        } else if (onClickListener != null) {
            throw new Exception("Please implement OnAdClickListener class instead of OnClickListener interface");
        }
    }

    public final void setTime$paytm_ad_sdk_release(long j2) {
        this.j = j2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        String str;
        a.a.a.a.a.b.b bVar;
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder("Session finished for adSession id    ");
        com.paytm.ads.d.a aVar = this.f40852a;
        String str2 = null;
        if (aVar != null) {
            str = aVar.f40891b;
        } else {
            str = null;
        }
        sb.append(str);
        StringBuilder sb2 = new StringBuilder("[AdEvent][omid] destroySession() -> omid.finish() adSessionId: ");
        com.paytm.ads.d.a aVar2 = this.f40852a;
        if (aVar2 != null) {
            str2 = aVar2.f40891b;
        }
        sb2.append(str2);
        timber.log.a.a(sb2.toString(), new Object[0]);
        com.paytm.ads.d.a aVar3 = this.f40852a;
        if (!(aVar3 == null || (bVar = aVar3.f40892c) == null)) {
            bVar.b();
            x xVar = x.f47997a;
        }
        c cVar = this.f40857f;
        if (cVar != null) {
            cVar.destroy();
        }
        e.a aVar4 = e.f40895a;
        Context context = getContext();
        k.a((Object) context, "context");
        e a2 = e.a.a(context);
        if (a2 != null) {
            k.c(this, "view");
            try {
                if (getAdId$paytm_ad_sdk_release() != null && a2.f40897b.containsKey(getAdId$paytm_ad_sdk_release())) {
                    HashMap<String, WeakReference<PaytmAdView>> hashMap = a2.f40897b;
                    String adId$paytm_ad_sdk_release = getAdId$paytm_ad_sdk_release();
                    if (adId$paytm_ad_sdk_release == null) {
                        k.a();
                    }
                    hashMap.remove(adId$paytm_ad_sdk_release);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final PaytmAdView a(b bVar) {
        if ((bVar.f40876a == null || bVar.f40877b == null || bVar.f40878c == null) ? false : true) {
            getAdVerificationResources().add(bVar);
        }
        return this;
    }
}
