package net.one97.paytm.paymentsBank.createfd.prefrence;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.i;
import androidx.fragment.app.j;
import com.paytm.utility.f;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.payments.d.b;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.prefrence.a.a;
import net.one97.paytm.paymentsBank.createfd.prefrence.b.b;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class CreateFdPrefrenceLayout extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.createfd.prefrence.b.a f18145a;

    /* renamed from: b  reason: collision with root package name */
    private int f18146b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private Long f18147c = 100000L;

    /* renamed from: d  reason: collision with root package name */
    private Long f18148d = 10000L;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18149e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18150f;

    /* renamed from: g  reason: collision with root package name */
    private SeekBar f18151g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18152h;

    /* renamed from: i  reason: collision with root package name */
    private b.a f18153i;
    /* access modifiers changed from: private */
    public boolean j;
    private com.paytm.b.a.a k;
    private String l = "is_first_time";
    private boolean m;
    private HashMap n;

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18155a = new b();

        b() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final net.one97.paytm.paymentsBank.createfd.prefrence.b.a getFdUserPrefrenceCallBackListener() {
        return this.f18145a;
    }

    public final void setFdUserPrefrenceCallBackListener(net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar) {
        this.f18145a = aVar;
    }

    public final int getStep() {
        return this.f18146b;
    }

    public final void setStep(int i2) {
        this.f18146b = i2;
    }

    public final Long getMax() {
        return this.f18147c;
    }

    public final void setMax(Long l2) {
        this.f18147c = l2;
    }

    public final Long getMin() {
        return this.f18148d;
    }

    public final void setMin(Long l2) {
        this.f18148d = l2;
    }

    public final TextView getMinView() {
        return this.f18149e;
    }

    public final void setMinView(TextView textView) {
        this.f18149e = textView;
    }

    public final TextView getMaxView() {
        return this.f18150f;
    }

    public final void setMaxView(TextView textView) {
        this.f18150f = textView;
    }

    public final SeekBar getSeekbar() {
        return this.f18151g;
    }

    public final void setSeekbar(SeekBar seekBar) {
        this.f18151g = seekBar;
    }

    public final TextView getAmountView() {
        return this.f18152h;
    }

    public final void setAmountView(TextView textView) {
        this.f18152h = textView;
    }

    public final b.a getFdUserPrefrencePresenter() {
        return this.f18153i;
    }

    public final void setFdUserPrefrencePresenter(b.a aVar) {
        this.f18153i = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateFdPrefrenceLayout(Context context) {
        super(context);
        k.c(context, "ctx");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateFdPrefrenceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "ctx");
        k.c(attributeSet, "attrs");
    }

    public final void setCallBackListener(net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar) {
        k.c(aVar, "fdUserPrefrenceCallBackListener");
        this.f18145a = aVar;
    }

    public final void setSharedPrefrenceValue(boolean z) {
        if (!this.m) {
            ImageView imageView = (ImageView) a(R.id.pb_fd_new_img);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.m = z;
            com.paytm.b.a.a aVar = this.k;
            if (aVar != null) {
                aVar.a(this.l, this.m, false);
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) a(R.id.pb_fd_new_img);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        b.a aVar = net.one97.paytm.payments.d.b.f17268a;
        Context context = getContext();
        k.a((Object) context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.k = b.a.a(applicationContext, f.a.FD_FIRST_TIME_TRACK);
        try {
            com.paytm.b.a.a aVar2 = this.k;
            Boolean valueOf = aVar2 != null ? Boolean.valueOf(aVar2.b(this.l, false, false)) : null;
            if (valueOf == null) {
                k.a();
            }
            this.m = valueOf.booleanValue();
        } catch (ClassCastException e2) {
            com.paytm.b.a.a aVar3 = this.k;
            if (aVar3 == null || (str = aVar3.b(this.l, "def", false)) == null) {
                str = "";
            }
            l.a(str);
            l.a((Throwable) e2);
        } catch (Exception e3) {
            l.a((Throwable) e3);
        }
        this.f18151g = (SeekBar) findViewById(R.id.seekbar);
        this.f18149e = (TextView) findViewById(R.id.tv_min_amt);
        this.f18150f = (TextView) findViewById(R.id.tv_max_amt);
        this.f18152h = (TextView) findViewById(R.id.tv_pref_amt);
        SeekBar seekBar = this.f18151g;
        if (seekBar != null) {
            Long l2 = this.f18147c;
            if (l2 == null) {
                k.a();
            }
            long longValue = l2.longValue();
            Long l3 = this.f18148d;
            if (l3 == null) {
                k.a();
            }
            seekBar.setMax((int) ((longValue - l3.longValue()) / ((long) this.f18146b)));
        }
        setOnClickListener(b.f18155a);
        SeekBar seekBar2 = this.f18151g;
        if (seekBar2 != null) {
            seekBar2.setOnSeekBarChangeListener(new c(this));
        }
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateFdPrefrenceLayout f18156a;

        c(CreateFdPrefrenceLayout createFdPrefrenceLayout) {
            this.f18156a = createFdPrefrenceLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
            r5 = r5.getThumb();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onProgressChanged(android.widget.SeekBar r5, int r6, boolean r7) {
            /*
                r4 = this;
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r5 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                java.lang.Long r5 = r5.getMin()     // Catch:{ Exception -> 0x00c1 }
                if (r5 != 0) goto L_0x000b
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c1 }
            L_0x000b:
                long r0 = r5.longValue()     // Catch:{ Exception -> 0x00c1 }
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r5 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                int r5 = r5.getStep()     // Catch:{ Exception -> 0x00c1 }
                int r6 = r6 * r5
                long r5 = (long) r6     // Catch:{ Exception -> 0x00c1 }
                long r0 = r0 + r5
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r5 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                android.widget.SeekBar r5 = r5.getSeekbar()     // Catch:{ Exception -> 0x00c1 }
                r6 = 0
                if (r5 == 0) goto L_0x002d
                android.graphics.drawable.Drawable r5 = r5.getThumb()     // Catch:{ Exception -> 0x00c1 }
                if (r5 == 0) goto L_0x002d
                android.graphics.Rect r5 = r5.getBounds()     // Catch:{ Exception -> 0x00c1 }
                goto L_0x002e
            L_0x002d:
                r5 = r6
            L_0x002e:
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r7 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                android.widget.SeekBar r7 = r7.getSeekbar()     // Catch:{ Exception -> 0x00c1 }
                if (r7 == 0) goto L_0x0045
                android.graphics.drawable.Drawable r7 = r7.getThumb()     // Catch:{ Exception -> 0x00c1 }
                if (r7 == 0) goto L_0x0045
                int r7 = r7.getIntrinsicWidth()     // Catch:{ Exception -> 0x00c1 }
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00c1 }
                goto L_0x0046
            L_0x0045:
                r7 = r6
            L_0x0046:
                if (r7 != 0) goto L_0x004b
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c1 }
            L_0x004b:
                int r7 = r7.intValue()     // Catch:{ Exception -> 0x00c1 }
                int r7 = r7 / 2
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r2 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                int r3 = net.one97.paytm.paymentsBank.R.id.movableView     // Catch:{ Exception -> 0x00c1 }
                android.view.View r2 = r2.a(r3)     // Catch:{ Exception -> 0x00c1 }
                android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2     // Catch:{ Exception -> 0x00c1 }
                if (r2 == 0) goto L_0x0099
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r3 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                android.widget.SeekBar r3 = r3.getSeekbar()     // Catch:{ Exception -> 0x00c1 }
                if (r3 != 0) goto L_0x0068
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c1 }
            L_0x0068:
                int r3 = r3.getLeft()     // Catch:{ Exception -> 0x00c1 }
                if (r5 != 0) goto L_0x0071
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c1 }
            L_0x0071:
                if (r5 == 0) goto L_0x0079
                int r5 = r5.left     // Catch:{ Exception -> 0x00c1 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00c1 }
            L_0x0079:
                int r5 = r6.intValue()     // Catch:{ Exception -> 0x00c1 }
                int r3 = r3 + r5
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r5 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                int r6 = net.one97.paytm.paymentsBank.R.id.movableView     // Catch:{ Exception -> 0x00c1 }
                android.view.View r5 = r5.a(r6)     // Catch:{ Exception -> 0x00c1 }
                android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5     // Catch:{ Exception -> 0x00c1 }
                if (r5 != 0) goto L_0x008d
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c1 }
            L_0x008d:
                int r5 = r5.getWidth()     // Catch:{ Exception -> 0x00c1 }
                int r5 = r5 / 2
                int r3 = r3 - r5
                int r3 = r3 + r7
                float r5 = (float) r3     // Catch:{ Exception -> 0x00c1 }
                r2.setX(r5)     // Catch:{ Exception -> 0x00c1 }
            L_0x0099:
                net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r5 = r4.f18156a     // Catch:{ Exception -> 0x00c1 }
                int r6 = net.one97.paytm.paymentsBank.R.id.seekProgressView     // Catch:{ Exception -> 0x00c1 }
                android.view.View r5 = r5.a(r6)     // Catch:{ Exception -> 0x00c1 }
                android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x00c1 }
                if (r5 == 0) goto L_0x00c1
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r7 = "₹"
                r6.<init>(r7)     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r7 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r7 = net.one97.paytm.bankCommon.mapping.a.ad(r7)     // Catch:{ Exception -> 0x00c1 }
                r6.append(r7)     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00c1 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00c1 }
                r5.setText(r6)     // Catch:{ Exception -> 0x00c1 }
            L_0x00c1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout.c.onProgressChanged(android.widget.SeekBar, int, boolean):void");
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            this.f18156a.j = true;
            FrameLayout frameLayout = (FrameLayout) this.f18156a.a(R.id.movableView);
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            this.f18156a.j = false;
            FrameLayout frameLayout = (FrameLayout) this.f18156a.a(R.id.movableView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            j jVar = null;
            Integer valueOf = seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null;
            Long min = this.f18156a.getMin();
            if (min == null) {
                k.a();
            }
            long longValue = min.longValue();
            if (valueOf == null) {
                k.a();
            }
            long intValue = longValue + ((long) (valueOf.intValue() * this.f18156a.getStep()));
            double d2 = (double) intValue;
            b.a fdUserPrefrencePresenter = this.f18156a.getFdUserPrefrencePresenter();
            if (!k.a(d2, fdUserPrefrencePresenter != null ? fdUserPrefrencePresenter.c() : null)) {
                a.C0302a aVar = net.one97.paytm.paymentsBank.createfd.prefrence.a.a.f18158d;
                String valueOf2 = String.valueOf(intValue);
                k.c(valueOf2, "amt");
                net.one97.paytm.paymentsBank.createfd.prefrence.a.a aVar2 = new net.one97.paytm.paymentsBank.createfd.prefrence.a.a();
                Bundle bundle = new Bundle();
                bundle.putString(net.one97.paytm.paymentsBank.createfd.prefrence.a.a.f18159e, valueOf2);
                aVar2.setArguments(bundle);
                net.one97.paytm.paymentsBank.createfd.prefrence.b.a fdUserPrefrenceCallBackListener = this.f18156a.getFdUserPrefrenceCallBackListener();
                if (fdUserPrefrenceCallBackListener == null) {
                    k.a();
                }
                k.c(fdUserPrefrenceCallBackListener, "callBackListener");
                aVar2.f18161b = fdUserPrefrenceCallBackListener;
                CreateFdPrefrenceLayout createFdPrefrenceLayout = this.f18156a;
                k.c(createFdPrefrenceLayout, "fdLayout");
                aVar2.f18162c = createFdPrefrenceLayout;
                Context context = this.f18156a.getContext();
                if (!(context instanceof AppCompatActivity)) {
                    context = null;
                }
                AppCompatActivity appCompatActivity = (AppCompatActivity) context;
                if (appCompatActivity != null) {
                    jVar = appCompatActivity.getSupportFragmentManager();
                }
                if (jVar != null && !jVar.h() && !jVar.i()) {
                    aVar2.show(jVar, "pref");
                }
            }
        }
    }

    public final void setPogress(String str) {
        try {
            b.a aVar = this.f18153i;
            Double c2 = aVar != null ? aVar.c() : null;
            if (c2 == null) {
                k.a();
            }
            double doubleValue = c2.doubleValue();
            Long l2 = this.f18148d;
            if (l2 == null) {
                k.a();
            }
            int longValue = (int) ((doubleValue - ((double) l2.longValue())) / ((double) this.f18146b));
            SeekBar seekBar = this.f18151g;
            if (seekBar != null) {
                seekBar.setProgress(longValue);
            }
        } catch (Exception unused) {
        }
    }

    public final void setFirstTimeDefaultSeekValue(String str) {
        try {
            String t = n.t();
            k.a((Object) t, "PaymentBankGtmLoader.get…ultFdPrefrenceSeekValue()");
            double parseDouble = Double.parseDouble(t);
            Long l2 = this.f18148d;
            if (l2 == null) {
                k.a();
            }
            int longValue = (int) ((parseDouble - ((double) l2.longValue())) / ((double) this.f18146b));
            SeekBar seekBar = this.f18151g;
            if (seekBar != null) {
                seekBar.setProgress(longValue);
            }
        } catch (Exception unused) {
        }
    }

    public final void setFdUserPrefrenceLayout(String str, FDStatusResponse fDStatusResponse, b.a aVar) {
        TextView textView;
        Drawable a2;
        k.c(str, "status");
        k.c(fDStatusResponse, "fdStatusResponse");
        k.c(aVar, "presenter");
        this.f18153i = aVar;
        aVar.a(fDStatusResponse);
        if (!(((TextView) a(R.id.tv_change_limit)) == null || (a2 = androidx.core.content.b.a(getContext(), R.drawable.fd_pref_open)) == null)) {
            ((TextView) a(R.id.tv_change_limit)).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a2, (Drawable) null);
        }
        b.a aVar2 = this.f18153i;
        this.f18147c = aVar2 != null ? aVar2.a() : null;
        b.a aVar3 = this.f18153i;
        this.f18148d = aVar3 != null ? aVar3.b() : null;
        try {
            b.a aVar4 = this.f18153i;
            Double c2 = aVar4 != null ? aVar4.c() : null;
            if (!TextUtils.isEmpty(String.valueOf(c2)) && (textView = (TextView) a(R.id.tv_pref_amt)) != null) {
                StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
                if (c2 == null) {
                    k.a();
                }
                sb.append(net.one97.paytm.bankCommon.mapping.a.a(c2.doubleValue()));
                textView.setText(sb.toString());
            }
        } catch (Exception unused) {
        }
        TextView textView2 = this.f18149e;
        if (textView2 != null) {
            textView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.bankCommon.mapping.a.ad(String.valueOf(this.f18148d)));
        }
        TextView textView3 = this.f18150f;
        if (textView3 != null) {
            StringBuilder sb2 = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
            Long l2 = this.f18147c;
            sb2.append(net.one97.paytm.bankCommon.mapping.a.ad(l2 != null ? String.valueOf(l2.longValue()) : null));
            textView3.setText(sb2.toString());
        }
        Long l3 = this.f18147c;
        if (l3 == null) {
            k.a();
        }
        long longValue = l3.longValue();
        Long l4 = this.f18148d;
        if (l4 == null) {
            k.a();
        }
        int longValue2 = (int) ((longValue - l4.longValue()) / ((long) this.f18146b));
        SeekBar seekBar = this.f18151g;
        if (seekBar != null) {
            seekBar.setMax(longValue2);
        }
        setPogress((String) null);
        TextView textView4 = (TextView) a(R.id.tv_auto_fd_know_more);
        if (textView4 != null) {
            textView4.setOnClickListener(new a(this));
        }
        if (k.a((Object) str, (Object) b.a.C0306b.PREFRENCE_PENDING.getStatusValue())) {
            i.a((TextView) a(R.id.tv_auto_fd_heading), R.style.pbfdsweepnormalmsgStyle);
            ImageView imageView = (ImageView) a(R.id.pb_fd_new_img);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView5 = (TextView) a(R.id.tv_pref_amt);
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            setFirstTimePrefrenceGroup(8);
            setChangeLimitGroup(8);
            setPendingPrefrenceGroup(0);
        } else if (k.a((Object) str, (Object) b.a.C0306b.PREFRENCE_ALREADY_SET.getStatusValue())) {
            i.a((TextView) a(R.id.tv_auto_fd_heading), R.style.pbfdsweepnormalmsgStyle);
            ImageView imageView2 = (ImageView) a(R.id.pb_fd_new_img);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView6 = (TextView) a(R.id.tv_pref_amt);
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            setFirstTimePrefrenceGroup(8);
            setPendingPrefrenceGroup(8);
            setChangeLimitGroup(0);
            TextView textView7 = (TextView) a(R.id.tv_change_limit);
            if (textView7 != null) {
                textView7.setOnClickListener(new d(this));
            }
        } else if (k.a((Object) str, (Object) b.a.C0306b.PREFRENCE_FIRST_TIME.getStatusValue())) {
            setSharedPrefrenceValue(true);
            setFirstTimeDefaultSeekValue((String) null);
            i.a((TextView) a(R.id.tv_auto_fd_heading), R.style.pbfdsweepboldmsgStyle);
            TextView textView8 = (TextView) a(R.id.tv_pref_amt);
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            setPendingPrefrenceGroup(8);
            setChangeLimitGroup(8);
            setFirstTimePrefrenceGroup(0);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateFdPrefrenceLayout f18157a;

        d(CreateFdPrefrenceLayout createFdPrefrenceLayout) {
            this.f18157a = createFdPrefrenceLayout;
        }

        public final void onClick(View view) {
            this.f18157a.setSharedPrefrenceValue(true);
            i.a((TextView) this.f18157a.a(R.id.tv_auto_fd_heading), R.style.pbfdsweepboldmsgStyle);
            TextView textView = (TextView) this.f18157a.a(R.id.tv_pref_amt);
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.f18157a.setPendingPrefrenceGroup(8);
            this.f18157a.setChangeLimitGroup(8);
            this.f18157a.setFirstTimePrefrenceGroup(0);
        }
    }

    public final void setFdSubheadingText(String str, String str2) {
        k.c(str, "seniorCitizenValue");
        k.c(str2, "fdInterest");
        if (!TextUtils.isEmpty(str) && str.equals("Y")) {
            k.a((Object) n.v(), "PaymentBankGtmLoader.get…niorCitizenInterestRate()");
        }
    }

    public final void setChangeLimitGroup(int i2) {
        TextView textView = (TextView) a(R.id.tv_change_limit);
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    public final void setFirstTimePrefrenceGroup(int i2) {
        TextView textView = (TextView) a(R.id.tv_auto_fd_subheading);
        if (textView != null) {
            textView.setVisibility(i2);
        }
        SeekBar seekBar = this.f18151g;
        if (seekBar != null) {
            seekBar.setVisibility(i2);
        }
        TextView textView2 = (TextView) a(R.id.tv_min_amt);
        if (textView2 != null) {
            textView2.setVisibility(i2);
        }
        TextView textView3 = (TextView) a(R.id.tv_max_amt);
        if (textView3 != null) {
            textView3.setVisibility(i2);
        }
    }

    public final void setPendingPrefrenceGroup(int i2) {
        TextView textView = (TextView) a(R.id.tv_auto_fd_pending_subheading);
        if (textView != null) {
            textView.setVisibility(i2);
        }
        TextView textView2 = (TextView) a(R.id.tv_fd_pending_progress);
        if (textView2 != null) {
            textView2.setVisibility(i2);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateFdPrefrenceLayout f18154a;

        a(CreateFdPrefrenceLayout createFdPrefrenceLayout) {
            this.f18154a = createFdPrefrenceLayout;
        }

        public final void onClick(View view) {
            net.one97.paytm.paymentsBank.h.a a2 = o.a();
            Context context = this.f18154a.getContext();
            String n = n.n();
            Context context2 = this.f18154a.getContext();
            a2.openWebViewActivity(context, n, context2 != null ? context2.getString(R.string.paytm_payments_bank) : null);
        }
    }
}
