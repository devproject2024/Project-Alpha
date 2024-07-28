package net.one97.paytm.paymentsBank.createfd.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity;
import net.one97.paytm.paymentsBank.createfd.activity.FdPostTransactionActivity;
import net.one97.paytm.paymentsBank.createfd.b.h;
import net.one97.paytm.paymentsBank.createfd.c.c;
import net.one97.paytm.paymentsBank.createfd.model.CreateFdModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.createfd.utils.c;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.si.c.f;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;
import net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText;

public final class a extends b implements c.b, c.d, f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0301a f18082f = new C0301a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public c.a f18083a;

    /* renamed from: b  reason: collision with root package name */
    public io.reactivex.rxjava3.b.c f18084b;

    /* renamed from: c  reason: collision with root package name */
    View f18085c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f18086d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public Runnable f18087e = new e(this);

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f18088g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.createfd.utils.c f18089h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18090i;
    private TextView j;
    private TextView k;
    private RelativeLayout l;
    private LottieAnimationView m;
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class g<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18097a;

        g(a aVar) {
            this.f18097a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str = (String) obj;
            a aVar = this.f18097a;
            k.a((Object) str, "input");
            aVar.c(str);
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "title");
        com.paytm.utility.b.b((Context) getActivity(), str, str2);
    }

    public final c.a a() {
        c.a aVar = this.f18083a;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.b.a$a  reason: collision with other inner class name */
    public static final class C0301a {
        private C0301a() {
        }

        public /* synthetic */ C0301a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.create_fd_layout, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r8v18, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r8, r0)
            super.onViewCreated(r8, r9)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r9 = 0
            if (r8 == 0) goto L_0x0017
            int r0 = net.one97.paytm.paymentsBank.R.id.addMoneyView
            android.view.View r8 = r8.findViewById(r0)
            goto L_0x0018
        L_0x0017:
            r8 = r9
        L_0x0018:
            r7.f18085c = r8
            android.view.View r8 = r7.f18085c
            if (r8 == 0) goto L_0x0027
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_add_money_heading
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            goto L_0x0028
        L_0x0027:
            r8 = r9
        L_0x0028:
            r7.f18090i = r8
            android.view.View r8 = r7.f18085c
            if (r8 == 0) goto L_0x0037
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_add_money_ok
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            goto L_0x0038
        L_0x0037:
            r8 = r9
        L_0x0038:
            r7.j = r8
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x0049
            int r0 = net.one97.paytm.paymentsBank.R.id.progress_bar
            android.view.View r8 = r8.findViewById(r0)
            android.widget.ProgressBar r8 = (android.widget.ProgressBar) r8
            goto L_0x004a
        L_0x0049:
            r8 = r9
        L_0x004a:
            r7.f18088g = r8
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x005b
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_fd_creation_block
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            goto L_0x005c
        L_0x005b:
            r8 = r9
        L_0x005c:
            r7.k = r8
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x006d
            int r0 = net.one97.paytm.paymentsBank.R.id.fd_loader_lyt
            android.view.View r8 = r8.findViewById(r0)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            goto L_0x006e
        L_0x006d:
            r8 = r9
        L_0x006e:
            r7.l = r8
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x007f
            int r9 = net.one97.paytm.paymentsBank.R.id.fd_loader
            android.view.View r8 = r8.findViewById(r9)
            r9 = r8
            com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
        L_0x007f:
            r7.m = r9
            r8 = 1
            r7.c((boolean) r8)
            net.one97.paytm.paymentsBank.createfd.d.a r9 = new net.one97.paytm.paymentsBank.createfd.d.a
            net.one97.paytm.paymentsBank.slfd.c r0 = net.one97.paytm.paymentsBank.slfd.c.f18958a
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.paymentsBank.slfd.a.a.b r0 = net.one97.paytm.paymentsBank.slfd.c.a(r0)
            r1 = r7
            net.one97.paytm.paymentsBank.createfd.c.c$b r1 = (net.one97.paytm.paymentsBank.createfd.c.c.b) r1
            r9.<init>(r0, r1)
            net.one97.paytm.paymentsBank.createfd.c.c$a r9 = (net.one97.paytm.paymentsBank.createfd.c.c.a) r9
            r7.f18083a = r9
            net.one97.paytm.paymentsBank.createfd.c.c$a r9 = r7.f18083a
            java.lang.String r0 = "presenter"
            if (r9 != 0) goto L_0x00ae
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00ae:
            r9.a()
            net.one97.paytm.paymentsBank.createfd.c.c$a r9 = r7.f18083a
            if (r9 != 0) goto L_0x00b8
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00b8:
            r9.b()
            int r9 = net.one97.paytm.paymentsBank.R.id.btn_create_fd
            android.view.View r9 = r7.a((int) r9)
            android.widget.Button r9 = (android.widget.Button) r9
            if (r9 == 0) goto L_0x00cf
            net.one97.paytm.paymentsBank.createfd.b.a$f r0 = new net.one97.paytm.paymentsBank.createfd.b.a$f
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x00cf:
            int r9 = net.one97.paytm.paymentsBank.R.string.pdc_proceed_agree
            java.lang.String r9 = r7.getString(r9)
            java.lang.String r0 = "getString(R.string.pdc_proceed_agree)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            int r0 = net.one97.paytm.paymentsBank.R.string.pdc_tnc
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "getString(R.string.pdc_tnc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = " "
            r1.append(r9)
            r1.append(r0)
            java.lang.String r9 = r1.toString()
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            android.text.SpannableString r2 = new android.text.SpannableString
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r2.<init>(r9)
            r1.element = r2
            net.one97.paytm.paymentsBank.createfd.b.a$i r2 = new net.one97.paytm.paymentsBank.createfd.b.a$i
            r2.<init>(r7, r1)
            T r3 = r1.element
            android.text.SpannableString r3 = (android.text.SpannableString) r3
            r4 = 6
            r5 = 0
            int r6 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r0, (int) r5, (boolean) r5, (int) r4)
            int r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r0, (int) r5, (boolean) r5, (int) r4)
            int r0 = r0.length()
            int r9 = r9 + r0
            r0 = 33
            r3.setSpan(r2, r6, r9, r0)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r9 = r7.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r0 = "tv_terms_and_condition"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            T r2 = r1.element
            android.text.SpannableString r2 = (android.text.SpannableString) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r9.setText(r2)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r9 = r7.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r9.setMovementMethod(r2)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r9 = r7.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            T r0 = r1.element
            android.text.SpannableString r0 = (android.text.SpannableString) r0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r9 = r7.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x016e
            r9.setHighlightColor(r5)
        L_0x016e:
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_amount
            android.view.View r9 = r7.a((int) r9)
            net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText r9 = (net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText) r9
            java.lang.String r0 = "tv_amount"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            java.lang.String r0 = ""
            r9.setPrefix(r0)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_amount
            android.view.View r9 = r7.a((int) r9)
            net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText r9 = (net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText) r9
            io.reactivex.rxjava3.a.p r9 = net.one97.paytm.paymentsBank.utils.q.a(r9)
            r0 = 100
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            io.reactivex.rxjava3.a.p r9 = r9.debounce(r0, r2)
            io.reactivex.rxjava3.a.x r0 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.p r9 = r9.observeOn(r0)
            net.one97.paytm.paymentsBank.createfd.b.a$g r0 = new net.one97.paytm.paymentsBank.createfd.b.a$g
            r0.<init>(r7)
            io.reactivex.rxjava3.d.g r0 = (io.reactivex.rxjava3.d.g) r0
            io.reactivex.rxjava3.b.c r9 = r9.subscribe(r0)
            java.lang.String r0 = "RxViewObservable.fromVie…ext(input)\n\n            }"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r7.f18084b = r9
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_interest_table_id
            android.view.View r9 = r7.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x01c3
            net.one97.paytm.paymentsBank.createfd.b.a$h r0 = new net.one97.paytm.paymentsBank.createfd.b.a$h
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x01c3:
            net.one97.paytm.paymentsBank.createfd.utils.c r9 = new net.one97.paytm.paymentsBank.createfd.utils.c
            int r0 = net.one97.paytm.paymentsBank.R.id.wbJS_lyt
            android.view.View r0 = r7.a((int) r0)
            android.webkit.WebView r0 = (android.webkit.WebView) r0
            android.content.Context r1 = r7.getContext()
            r2 = r7
            net.one97.paytm.paymentsBank.createfd.utils.c$d r2 = (net.one97.paytm.paymentsBank.createfd.utils.c.d) r2
            r9.<init>(r0, r1, r2)
            r7.f18089h = r9
            net.one97.paytm.paymentsBank.createfd.utils.b$a r9 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a
            boolean r9 = net.one97.paytm.paymentsBank.createfd.utils.b.a.a()
            if (r9 == 0) goto L_0x0253
            int r9 = net.one97.paytm.paymentsBank.R.id.btn_create_fd
            android.view.View r9 = r7.a((int) r9)
            android.widget.Button r9 = (android.widget.Button) r9
            if (r9 == 0) goto L_0x01ee
            r9.setEnabled(r5)
        L_0x01ee:
            int r9 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r9 >= r0) goto L_0x020f
            int r9 = net.one97.paytm.paymentsBank.R.id.btn_create_fd
            android.view.View r9 = r7.a((int) r9)
            android.widget.Button r9 = (android.widget.Button) r9
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0205
            kotlin.g.b.k.a()
        L_0x0205:
            int r1 = net.one97.paytm.paymentsBank.R.drawable.create_fd_disable_bg
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r9.setBackgroundDrawable(r0)
            goto L_0x022e
        L_0x020f:
            int r9 = net.one97.paytm.paymentsBank.R.id.btn_create_fd
            android.view.View r9 = r7.a((int) r9)
            android.widget.Button r9 = (android.widget.Button) r9
            java.lang.String r0 = "btn_create_fd"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0225
            kotlin.g.b.k.a()
        L_0x0225:
            int r1 = net.one97.paytm.paymentsBank.R.drawable.create_fd_disable_bg
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r9.setBackground(r0)
        L_0x022e:
            android.widget.TextView r9 = r7.k
            if (r9 == 0) goto L_0x0235
            r9.setVisibility(r5)
        L_0x0235:
            int r9 = net.one97.paytm.paymentsBank.R.string.pb_fd_creation_block_time
            java.lang.String r9 = r7.getString(r9)
            java.lang.String r0 = "getString(R.string.pb_fd_creation_block_time)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.widget.TextView r0 = r7.k
            if (r0 == 0) goto L_0x0253
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fd_creation_time_msg
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r5] = r9
            java.lang.String r8 = r7.getString(r1, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18096a;

        f(a aVar) {
            this.f18096a = aVar;
        }

        public final void onClick(View view) {
            Object obj;
            b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            Context context = this.f18096a.getContext();
            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) this.f18096a.a(R.id.tv_amount);
            String str = null;
            if (context != null) {
                try {
                    obj = context.getSystemService("input_method");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                obj = null;
            }
            if (obj != null) {
                ((InputMethodManager) obj).hideSoftInputFromWindow(customAmountTextInputEditText != null ? customAmountTextInputEditText.getWindowToken() : null, 0);
                c.a a2 = this.f18096a.a();
                CustomAmountTextInputEditText customAmountTextInputEditText2 = (CustomAmountTextInputEditText) this.f18096a.a(R.id.tv_amount);
                k.a((Object) customAmountTextInputEditText2, "tv_amount");
                Editable text = customAmountTextInputEditText2.getText();
                if (text != null) {
                    str = text.toString();
                }
                String ab = net.one97.paytm.bankCommon.mapping.a.ab(str);
                k.a((Object) ab, "CJRAppUtility.getCleanSt…_amount.text?.toString())");
                this.f18096a.a(a2.b(ab), (String) null);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18098a;

        h(a aVar) {
            this.f18098a = aVar;
        }

        public final void onClick(View view) {
            Editable text;
            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) this.f18098a.a(R.id.tv_amount);
            String str = null;
            if (!TextUtils.isEmpty(customAmountTextInputEditText != null ? customAmountTextInputEditText.getText() : null)) {
                this.f18098a.a(true);
                c.a a2 = this.f18098a.a();
                CustomAmountTextInputEditText customAmountTextInputEditText2 = (CustomAmountTextInputEditText) this.f18098a.a(R.id.tv_amount);
                if (!(customAmountTextInputEditText2 == null || (text = customAmountTextInputEditText2.getText()) == null)) {
                    str = text.toString();
                }
                a2.d(net.one97.paytm.bankCommon.mapping.a.ab(str));
                return;
            }
            this.f18098a.a(b.a.C0305a.ZERO_AMOUNT, (String) null);
        }
    }

    public final void b() {
        Button button = (Button) a(R.id.btn_create_fd);
        if (button != null) {
            button.performClick();
        }
    }

    public static final class i extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18099a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f18100b;

        i(a aVar, x.e eVar) {
            this.f18099a = aVar;
            this.f18100b = eVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            Selection.setSelection((SpannableString) this.f18100b.element, 0);
            this.f18099a.a().a(true);
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            Context context = this.f18099a.getContext();
            if (context == null) {
                k.a();
            }
            textPaint.setColor(androidx.core.content.b.c(context, R.color.paytm_blue));
        }
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        CustomAmountTextInputEditText customAmountTextInputEditText;
        k.c(slfdMetaApiResponseModel, Payload.RESPONSE);
        net.one97.paytm.paymentsBank.createfd.utils.c cVar = this.f18089h;
        if (cVar != null) {
            cVar.a(slfdMetaApiResponseModel);
        }
        a("");
        Double fdCapAmount = slfdMetaApiResponseModel.getFdCapAmount();
        int length = String.valueOf(fdCapAmount != null ? Long.valueOf((long) fdCapAmount.doubleValue()) : null).length();
        if (length > 0 && (customAmountTextInputEditText = (CustomAmountTextInputEditText) a(R.id.tv_amount)) != null) {
            customAmountTextInputEditText.setMaxDigitsBeforeDecimalPoint(length);
        }
    }

    public final void a(b.a.C0305a aVar, String str) {
        k.c(aVar, "status");
        if (aVar == b.a.C0305a.SUCCESS) {
            a(true);
            c.a aVar2 = this.f18083a;
            if (aVar2 == null) {
                k.a("presenter");
            }
            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) a(R.id.tv_amount);
            k.a((Object) customAmountTextInputEditText, "tv_amount");
            Editable text = customAmountTextInputEditText.getText();
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(text != null ? text.toString() : null);
            k.a((Object) ab, "CJRAppUtility.getCleanSt…_amount.text?.toString())");
            aVar2.a(ab);
        } else if (aVar == b.a.C0305a.ZERO_AMOUNT) {
            a(false);
            androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineErrorMsgStyle);
            TextView textView = (TextView) a(R.id.tv_amt_inline_msg);
            if (textView != null) {
                textView.setText(getString(R.string.fd_inline_msg_zero_amt));
            }
        } else if (aVar == b.a.C0305a.LESS_THEN_FLOOR_AMT) {
            a(false);
            androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineErrorMsgStyle);
            TextView textView2 = (TextView) a(R.id.tv_amt_inline_msg);
            if (textView2 != null) {
                int i2 = R.string.fd_inline_msg_floor_amt;
                Object[] objArr = new Object[1];
                c.a aVar3 = this.f18083a;
                if (aVar3 == null) {
                    k.a("presenter");
                }
                objArr[0] = net.one97.paytm.bankCommon.mapping.a.ad(aVar3.c());
                textView2.setText(getString(i2, objArr));
            }
        } else if (aVar == b.a.C0305a.GREATER_THEN_CAP_AMT) {
            a(false);
            androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineErrorMsgStyle);
            TextView textView3 = (TextView) a(R.id.tv_amt_inline_msg);
            if (textView3 != null) {
                int i3 = R.string.fd_inline_msg_cap_amt;
                Object[] objArr2 = new Object[1];
                c.a aVar4 = this.f18083a;
                if (aVar4 == null) {
                    k.a("presenter");
                }
                objArr2[0] = net.one97.paytm.bankCommon.mapping.a.ad(aVar4.d());
                textView3.setText(getString(i3, objArr2));
            }
        } else if (aVar == b.a.C0305a.ADDMONEY) {
            i();
        } else if (aVar == b.a.C0305a.PAN_UPDATION_REQUIRED) {
            a(false);
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.pan_updation_message);
            }
            SpannableString spannableString = new SpannableString(str);
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_ff585d)), 0, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(getString(R.string.add_pan));
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context2, R.color.color_00aced)), 0, spannableString2.length(), 33);
            spannableString2.setSpan(new j(this), 0, spannableString2.length(), 33);
            SpannableStringBuilder append = new SpannableStringBuilder().append(spannableString).append(StringUtility.NEW_LINE).append(spannableString2);
            TextView textView4 = (TextView) a(R.id.tv_amt_inline_msg);
            if (textView4 != null) {
                textView4.setText(append);
            }
            androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineUpdatedErrorMsgStyle);
            TextView textView5 = (TextView) a(R.id.tv_amt_inline_msg);
            k.a((Object) textView5, "tv_amt_inline_msg");
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (aVar == b.a.C0305a.FAILURE) {
            a(false);
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.fd_unknown_issue);
            }
            androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineErrorMsgStyle);
            TextView textView6 = (TextView) a(R.id.tv_amt_inline_msg);
            if (textView6 != null) {
                textView6.setText(str);
            }
        } else if (aVar == b.a.C0305a.PROCESSING) {
            a(true);
        }
    }

    public static final class j extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18101a;

        j(a aVar) {
            this.f18101a = aVar;
        }

        public final void onClick(View view) {
            k.c(view, "p0");
            a.a(this.f18101a);
        }
    }

    private final void i() {
        a(false);
        SpannableString spannableString = new SpannableString(getString(R.string.fd_insufficent_money));
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_ff585d)), 0, spannableString.length(), 33);
        SpannableString spannableString2 = new SpannableString(getString(R.string.fd_creation_add_money));
        spannableString2.setSpan(new b(this), 0, spannableString2.length(), 33);
        SpannableStringBuilder append = new SpannableStringBuilder().append(spannableString).append("  ").append(spannableString2);
        TextView textView = (TextView) a(R.id.tv_amt_inline_msg);
        if (textView != null) {
            textView.setText(append);
        }
        androidx.core.widget.i.a((TextView) a(R.id.tv_amt_inline_msg), R.style.fdInlineUpdatedErrorMsgStyle);
        TextView textView2 = (TextView) a(R.id.tv_amt_inline_msg);
        k.a((Object) textView2, "tv_amt_inline_msg");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18091a;

        b(a aVar) {
            this.f18091a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
            r0 = r0.getText();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                java.lang.String r0 = "widget"
                kotlin.g.b.k.c(r4, r0)
                net.one97.paytm.paymentsBank.createfd.b.a r0 = r3.f18091a
                int r1 = net.one97.paytm.paymentsBank.R.id.tv_amount
                android.view.View r0 = r0.a((int) r1)
                net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText r0 = (net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText) r0
                if (r0 == 0) goto L_0x001c
                android.text.Editable r0 = r0.getText()
                if (r0 == 0) goto L_0x001c
                java.lang.String r0 = r0.toString()
                goto L_0x001d
            L_0x001c:
                r0 = 0
            L_0x001d:
                java.lang.String r0 = net.one97.paytm.bankCommon.mapping.a.ab(r0)
                net.one97.paytm.paymentsBank.createfd.b.a r1 = r3.f18091a
                net.one97.paytm.paymentsBank.createfd.c.c$a r1 = r1.a()
                java.lang.String r2 = "amount"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                java.lang.String r0 = r1.e(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "paytmmp://cash_wallet?featuretype=bank_landing&amount="
                r1.<init>(r2)
                r1.append(r0)
                java.lang.String r0 = "&hide_isa_fd=true"
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
                net.one97.paytm.paymentsBank.createfd.b.a r2 = r3.f18091a
                android.content.Context r2 = r2.getContext()
                r1.checkDeepLink(r2, r0)
                r4.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.b.onClick(android.view.View):void");
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
            Context context = this.f18091a.getContext();
            if (context == null) {
                k.a();
            }
            textPaint.setColor(androidx.core.content.b.c(context, R.color.color_00aced));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r1 = r1.getPeakInterestRatePerAnnum();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "%"
            java.lang.String r1 = "interest"
            kotlin.g.b.k.c(r9, r1)
            net.one97.paytm.paymentsBank.createfd.c.c$a r1 = r8.f18083a     // Catch:{ Exception -> 0x012a }
            java.lang.String r2 = "presenter"
            if (r1 != 0) goto L_0x0010
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x012a }
        L_0x0010:
            net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel r1 = r1.e()     // Catch:{ Exception -> 0x012a }
            r3 = 0
            if (r1 == 0) goto L_0x0026
            java.lang.Double r1 = r1.getPeakInterestRatePerAnnum()     // Catch:{ Exception -> 0x012a }
            if (r1 == 0) goto L_0x0026
            double r4 = r1.doubleValue()     // Catch:{ Exception -> 0x012a }
            java.lang.String r1 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x012a }
            goto L_0x0027
        L_0x0026:
            r1 = r3
        L_0x0027:
            net.one97.paytm.paymentsBank.createfd.c.c$a r4 = r8.f18083a     // Catch:{ Exception -> 0x012a }
            if (r4 != 0) goto L_0x002e
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x012a }
        L_0x002e:
            net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel r4 = r4.e()     // Catch:{ Exception -> 0x012a }
            if (r4 == 0) goto L_0x0039
            java.lang.Integer r4 = r4.getPeakTenureMonths()     // Catch:{ Exception -> 0x012a }
            goto L_0x003a
        L_0x0039:
            r4 = r3
        L_0x003a:
            java.lang.String r5 = ""
            r6 = r9
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x012a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x012a }
            r7 = 0
            if (r6 != 0) goto L_0x0061
            java.lang.String r6 = "0"
            boolean r6 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r6, (boolean) r7)     // Catch:{ Exception -> 0x012a }
            if (r6 != 0) goto L_0x0061
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
            java.lang.String r6 = "₹"
            r5.<init>(r6)     // Catch:{ Exception -> 0x012a }
            java.lang.String r9 = net.one97.paytm.bankCommon.mapping.a.ad(r9)     // Catch:{ Exception -> 0x012a }
            r5.append(r9)     // Catch:{ Exception -> 0x012a }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x012a }
        L_0x0061:
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x012a }
            if (r9 != 0) goto L_0x011c
            if (r4 == 0) goto L_0x0075
            int r9 = r4.intValue()     // Catch:{ Exception -> 0x012a }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x012a }
            goto L_0x0076
        L_0x0075:
            r9 = r3
        L_0x0076:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x012a }
            if (r9 != 0) goto L_0x011c
            if (r1 != 0) goto L_0x0083
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x012a }
        L_0x0083:
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012a }
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x012a }
            boolean r9 = kotlin.m.p.c((java.lang.CharSequence) r9, (java.lang.CharSequence) r4)     // Catch:{ Exception -> 0x012a }
            if (r9 != 0) goto L_0x009e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
            r9.<init>()     // Catch:{ Exception -> 0x012a }
            r9.append(r1)     // Catch:{ Exception -> 0x012a }
            r9.append(r0)     // Catch:{ Exception -> 0x012a }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x012a }
        L_0x009e:
            android.text.SpannableString r9 = new android.text.SpannableString     // Catch:{ Exception -> 0x012a }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x012a }
            r9.<init>(r5)     // Catch:{ Exception -> 0x012a }
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x012a }
            r4 = 1
            r0.<init>(r4)     // Catch:{ Exception -> 0x012a }
            int r5 = r9.length()     // Catch:{ Exception -> 0x012a }
            r6 = 33
            r9.setSpan(r0, r7, r5, r6)     // Catch:{ Exception -> 0x012a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
            java.lang.String r5 = " "
            r0.<init>(r5)     // Catch:{ Exception -> 0x012a }
            int r5 = net.one97.paytm.paymentsBank.R.string.fd_interest     // Catch:{ Exception -> 0x012a }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ Exception -> 0x012a }
            r0.append(r5)     // Catch:{ Exception -> 0x012a }
            java.lang.String r5 = " @ "
            r0.append(r5)     // Catch:{ Exception -> 0x012a }
            int r5 = net.one97.paytm.paymentsBank.R.string.fd_calculator_interest_rate_create_fd     // Catch:{ Exception -> 0x012a }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x012a }
            r6[r7] = r1     // Catch:{ Exception -> 0x012a }
            net.one97.paytm.paymentsBank.createfd.c.c$a r1 = r8.f18083a     // Catch:{ Exception -> 0x012a }
            if (r1 != 0) goto L_0x00d7
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x012a }
        L_0x00d7:
            net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel r1 = r1.e()     // Catch:{ Exception -> 0x012a }
            if (r1 == 0) goto L_0x00e1
            java.lang.Integer r3 = r1.getPeakTenureMonths()     // Catch:{ Exception -> 0x012a }
        L_0x00e1:
            r6[r4] = r3     // Catch:{ Exception -> 0x012a }
            java.lang.String r1 = r8.getString(r5, r6)     // Catch:{ Exception -> 0x012a }
            r0.append(r1)     // Catch:{ Exception -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012a }
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x012a }
            r1.<init>()     // Catch:{ Exception -> 0x012a }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012a }
            android.text.SpannableStringBuilder r9 = r1.append(r9)     // Catch:{ Exception -> 0x012a }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x012a }
            android.text.SpannableStringBuilder r9 = r9.append(r0)     // Catch:{ Exception -> 0x012a }
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_intrst_detail     // Catch:{ Exception -> 0x012a }
            android.view.View r0 = r8.a((int) r0)     // Catch:{ Exception -> 0x012a }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x010e
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012a }
            r0.setText(r9)     // Catch:{ Exception -> 0x012a }
        L_0x010e:
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_intrst_detail     // Catch:{ Exception -> 0x012a }
            android.view.View r9 = r8.a((int) r9)     // Catch:{ Exception -> 0x012a }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x012a }
            if (r9 == 0) goto L_0x011b
            r9.setVisibility(r7)     // Catch:{ Exception -> 0x012a }
        L_0x011b:
            return
        L_0x011c:
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_intrst_detail     // Catch:{ Exception -> 0x012a }
            android.view.View r9 = r8.a((int) r9)     // Catch:{ Exception -> 0x012a }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x012a }
            if (r9 == 0) goto L_0x012a
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ Exception -> 0x012a }
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|(1:10)|11|12|(1:14)|15|(2:17|18)(2:19|20)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[Catch:{ NumberFormatException -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067 A[Catch:{ NumberFormatException -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[Catch:{ NumberFormatException -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "tv_amt_inline_msg"
            int r2 = net.one97.paytm.paymentsBank.R.id.tv_amount
            android.view.View r2 = r6.a((int) r2)
            net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText r2 = (net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText) r2
            java.lang.String r3 = "tv_amount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 0
            r2.setError(r3)
            java.lang.String r7 = net.one97.paytm.bankCommon.mapping.a.ab(r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NumberFormatException -> 0x00c7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            if (r2 == 0) goto L_0x0039
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg     // Catch:{ NumberFormatException -> 0x00c7 }
            android.view.View r7 = r6.a((int) r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException -> 0x00c7 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x00c7 }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NumberFormatException -> 0x00c7 }
            r7.setText(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            r6.a((java.lang.String) r0)     // Catch:{ NumberFormatException -> 0x00c7 }
            return
        L_0x0039:
            java.lang.String r2 = net.one97.paytm.bankCommon.mapping.a.ab(r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x00c7 }
            r3.<init>(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            long r2 = r3.longValue()     // Catch:{ NumberFormatException -> 0x00c7 }
            net.one97.paytm.paymentsBank.createfd.utils.c r4 = r6.f18089h     // Catch:{ Exception -> 0x004d }
            if (r4 == 0) goto L_0x004d
            r4.a((long) r2)     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            net.one97.paytm.paymentsBank.createfd.c.c$a r4 = r6.f18083a     // Catch:{ NumberFormatException -> 0x00c7 }
            if (r4 != 0) goto L_0x0056
            java.lang.String r5 = "presenter"
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ NumberFormatException -> 0x00c7 }
        L_0x0056:
            java.lang.String r7 = net.one97.paytm.bankCommon.mapping.a.ab(r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.String r5 = "CJRAppUtility.getCleanString(cleanText)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)     // Catch:{ NumberFormatException -> 0x00c7 }
            net.one97.paytm.paymentsBank.createfd.utils.b$a$a r7 = r4.c(r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            net.one97.paytm.paymentsBank.createfd.utils.b$a$a r4 = net.one97.paytm.paymentsBank.createfd.utils.b.a.C0305a.ADDMONEY     // Catch:{ NumberFormatException -> 0x00c7 }
            if (r7 != r4) goto L_0x006b
            r6.i()     // Catch:{ NumberFormatException -> 0x00c7 }
            return
        L_0x006b:
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg     // Catch:{ NumberFormatException -> 0x00c7 }
            android.view.View r7 = r6.a((int) r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException -> 0x00c7 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x00c7 }
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ NumberFormatException -> 0x00c7 }
            r7.setText(r4)     // Catch:{ NumberFormatException -> 0x00c7 }
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg     // Catch:{ NumberFormatException -> 0x00c7 }
            android.view.View r7 = r6.a((int) r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException -> 0x00c7 }
            int r4 = net.one97.paytm.paymentsBank.R.style.fdInlineMsgStyle     // Catch:{ NumberFormatException -> 0x00c7 }
            androidx.core.widget.i.a((android.widget.TextView) r7, (int) r4)     // Catch:{ NumberFormatException -> 0x00c7 }
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg     // Catch:{ NumberFormatException -> 0x00c7 }
            android.view.View r7 = r6.a((int) r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException -> 0x00c7 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00c7 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x00c7 }
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fd_rupees     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ NumberFormatException -> 0x00c7 }
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.String r2 = net.one97.paytm.paymentsBank.utils.i.a((long) r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            r4.append(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.String r2 = r4.toString()     // Catch:{ NumberFormatException -> 0x00c7 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NumberFormatException -> 0x00c7 }
            r7.setText(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg     // Catch:{ NumberFormatException -> 0x00c7 }
            android.view.View r7 = r6.a((int) r7)     // Catch:{ NumberFormatException -> 0x00c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException -> 0x00c7 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x00c7 }
            r2 = 0
            r7.setVisibility(r2)     // Catch:{ NumberFormatException -> 0x00c7 }
            return
        L_0x00c7:
            r7 = move-exception
            r7.printStackTrace()
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_amt_inline_msg
            android.view.View r7 = r6.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            r1 = 4
            r7.setVisibility(r1)
            r6.a((java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.c(java.lang.String):void");
    }

    public final void b(String str) {
        TextView textView = (TextView) a(R.id.tv_ac_bal);
        if (textView != null) {
            textView.setText(getString(R.string.fd_saving_account_balance, str));
        }
    }

    public final void c() {
        a(false);
        c.a aVar = this.f18083a;
        if (aVar == null) {
            k.a("presenter");
        }
        aVar.f();
    }

    public final void b(b.a.C0305a aVar, String str) {
        k.c(aVar, "amtStatus");
        a(false);
        a(aVar, str);
    }

    public final void a(boolean z) {
        if (z) {
            f();
        } else {
            h();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Integer r3, com.paytm.network.model.NetworkCustomError r4) {
        /*
            r2 = this;
            r0 = 0
            r2.a((boolean) r0)
            net.one97.paytm.paymentsBank.createfd.utils.b$a r0 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a
            int r0 = net.one97.paytm.paymentsBank.createfd.utils.b.p
            r1 = 0
            if (r3 != 0) goto L_0x000e
            goto L_0x0042
        L_0x000e:
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x0042
            android.content.Context r3 = r2.getContext()
            if (r3 == 0) goto L_0x0027
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0027
            int r4 = net.one97.paytm.paymentsBank.R.string.no_internet
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0028
        L_0x0027:
            r3 = r1
        L_0x0028:
            android.content.Context r4 = r2.getContext()
            if (r4 == 0) goto L_0x003a
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x003a
            int r0 = net.one97.paytm.paymentsBank.R.string.no_connection
            java.lang.String r1 = r4.getString(r0)
        L_0x003a:
            android.content.Context r4 = r2.getContext()
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r1, (java.lang.String) r3)
            return
        L_0x0042:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            java.lang.Exception r4 = (java.lang.Exception) r4
            net.one97.paytm.paymentsBank.utils.j.a((android.app.Activity) r3, (java.lang.Exception) r4, (java.lang.String) r1, (android.os.Bundle) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.a(java.lang.Integer, com.paytm.network.model.NetworkCustomError):void");
    }

    public final void b(boolean z) {
        if (z) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Activity activity2 = activity;
            int i2 = R.string.pb_fd_passcode_title;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) a(R.id.tv_amount);
            k.a((Object) customAmountTextInputEditText, "tv_amount");
            Editable text = customAmountTextInputEditText.getText();
            sb.append(text != null ? text.toString() : null);
            objArr[0] = sb.toString();
            String string = getString(i2, objArr);
            k.a((Object) string, "getString(R.string.pb_fd…_amount.text?.toString())");
            String string2 = getString(R.string.pb_fd_passcode_hint);
            k.a((Object) string2, "getString(R.string.pb_fd_passcode_hint)");
            BankPasscodeActivity.a aVar2 = BankPasscodeActivity.r;
            String j2 = BankPasscodeActivity.z;
            k.c(activity2, "ctx");
            k.c(string, "title");
            k.c(string2, "hintAbovePasscodeView");
            k.c(j2, "from");
            Intent intent = new Intent(activity2, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", string);
            intent.putExtra(BankPasscodeActivity.x, string2);
            intent.putExtra("r_token", true);
            intent.putExtra(BankPasscodeActivity.y, j2);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity2.startActivityForResult(intent, 121);
            return;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 == null) {
            k.a();
        }
        com.paytm.utility.b.a((Context) activity3, getString(R.string.pb_fd_tnc_saved_updated));
    }

    public final void a(CreateFdModel createFdModel) {
        k.c(createFdModel, "fdcreationResponse");
        a(false);
        if (!p.a(createFdModel.getStatus(), "success", false)) {
            a((Integer) 400, new NetworkCustomError(createFdModel.getMessage()));
        } else if (getContext() instanceof CreateFdActivity) {
            Context context = getContext();
            String str = null;
            if (!(context instanceof CreateFdActivity)) {
                context = null;
            }
            CreateFdActivity createFdActivity = (CreateFdActivity) context;
            if (createFdActivity != null) {
                String orderId = createFdModel.getOrderId();
                CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) a(R.id.tv_amount);
                k.a((Object) customAmountTextInputEditText, "tv_amount");
                Editable text = customAmountTextInputEditText.getText();
                if (text != null) {
                    str = text.toString();
                }
                Intent intent = new Intent(createFdActivity, FdPostTransactionActivity.class);
                b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                intent.putExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18190e, orderId);
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                intent.putExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18191f, str);
                b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                String e2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18192g;
                b.a aVar4 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                intent.putExtra(e2, net.one97.paytm.paymentsBank.createfd.utils.b.o);
                intent.setFlags(33554432);
                createFdActivity.startActivity(intent);
                createFdActivity.finish();
            }
        }
    }

    public final void c(boolean z) {
        if (z) {
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            net.one97.paytm.common.widgets.a.a(this.m);
            return;
        }
        RelativeLayout relativeLayout2 = this.l;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        net.one97.paytm.common.widgets.a.b(this.m);
    }

    public final void d() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void a(FDProjectionListModel fDProjectionListModel) {
        k.c(fDProjectionListModel, "fdProjectionListModel");
        if (isAdded()) {
            a(false);
            if (fDProjectionListModel.getFdInterestProjectionDtoList() != null) {
                List<FDProjectionListModel.FdInterestProjectionDtoList> fdInterestProjectionDtoList = fDProjectionListModel.getFdInterestProjectionDtoList();
                androidx.fragment.app.j jVar = null;
                Integer valueOf = fdInterestProjectionDtoList != null ? Integer.valueOf(fdInterestProjectionDtoList.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 0) {
                    h.a aVar = h.f18126a;
                    h hVar = new h();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(h.f18127b, fDProjectionListModel);
                    hVar.setArguments(bundle);
                    Context context = getContext();
                    if (!(context instanceof AppCompatActivity)) {
                        context = null;
                    }
                    AppCompatActivity appCompatActivity = (AppCompatActivity) context;
                    if (appCompatActivity != null) {
                        jVar = appCompatActivity.getSupportFragmentManager();
                    }
                    if (jVar == null) {
                        k.a();
                    }
                    hVar.show(jVar, h.class.getSimpleName());
                }
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.b.c cVar = this.f18084b;
        if (cVar == null) {
            k.a("disposable");
        }
        if (!cVar.isDisposed()) {
            io.reactivex.rxjava3.b.c cVar2 = this.f18084b;
            if (cVar2 == null) {
                k.a("disposable");
            }
            cVar2.dispose();
        }
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        k.c(arrayList, "mTncDataList");
        if (isAdded()) {
            if (!net.one97.paytm.bankCommon.mapping.a.c(getContext())) {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
            } else if (arrayList.size() > 0) {
                net.one97.paytm.paymentsBank.si.c.f a2 = net.one97.paytm.paymentsBank.si.c.f.a(arrayList);
                a2.a((f.a) this);
                a2.show(getChildFragmentManager(), "tncFragment");
            }
        }
    }

    public final void g() {
        c.a aVar = this.f18083a;
        if (aVar == null) {
            k.a("presenter");
        }
        aVar.b(false);
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18095a;

        e(a aVar) {
            this.f18095a = aVar;
        }

        public final void run() {
            this.f18095a.a().a();
            TextView textView = (TextView) this.f18095a.a(R.id.tv_amt_inline_msg);
            k.a((Object) textView, "tv_amt_inline_msg");
            textView.setText("");
        }
    }

    public final void onDestroyView() {
        this.f18086d.removeCallbacks(this.f18087e);
        super.onDestroyView();
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        r3 = r3.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(double r3, java.lang.Integer r5) {
        /*
            r2 = this;
            net.one97.paytm.paymentsBank.createfd.utils.b$a r0 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x0091 }
            int r0 = net.one97.paytm.paymentsBank.createfd.utils.b.f18187b     // Catch:{ Exception -> 0x0091 }
            if (r5 != 0) goto L_0x0009
            return
        L_0x0009:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0091 }
            if (r5 != r0) goto L_0x0091
            android.content.Context r5 = r2.getContext()     // Catch:{ Exception -> 0x0091 }
            if (r5 != 0) goto L_0x0018
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0091 }
        L_0x0018:
            int r0 = net.one97.paytm.paymentsBank.R.color.color_21c17a     // Catch:{ Exception -> 0x0091 }
            int r5 = androidx.core.content.b.c(r5, r0)     // Catch:{ Exception -> 0x0091 }
            java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0091 }
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fd_add_money_success     // Catch:{ Exception -> 0x0091 }
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = net.one97.paytm.bankCommon.mapping.a.ad(r3)     // Catch:{ Exception -> 0x0091 }
            r4 = 0
            r0[r4] = r3     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = r2.getString(r5, r0)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r5 = "getString(\n             …      )\n                )"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0091 }
            android.view.View r5 = r2.f18085c     // Catch:{ Exception -> 0x0091 }
            if (r5 == 0) goto L_0x0041
            r5.setVisibility(r4)     // Catch:{ Exception -> 0x0091 }
        L_0x0041:
            android.widget.TextView r4 = r2.f18090i     // Catch:{ Exception -> 0x0091 }
            if (r4 == 0) goto L_0x004a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0091 }
            r4.setText(r3)     // Catch:{ Exception -> 0x0091 }
        L_0x004a:
            kotlin.g.b.x$e r3 = new kotlin.g.b.x$e     // Catch:{ Exception -> 0x0091 }
            r3.<init>()     // Catch:{ Exception -> 0x0091 }
            net.one97.paytm.paymentsBank.createfd.b.a$d r4 = new net.one97.paytm.paymentsBank.createfd.b.a$d     // Catch:{ Exception -> 0x0091 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0091 }
            r3.element = r4     // Catch:{ Exception -> 0x0091 }
            android.widget.TextView r4 = r2.j     // Catch:{ Exception -> 0x0091 }
            if (r4 == 0) goto L_0x0064
            net.one97.paytm.paymentsBank.createfd.b.a$c r5 = new net.one97.paytm.paymentsBank.createfd.b.a$c     // Catch:{ Exception -> 0x0091 }
            r5.<init>(r2, r3)     // Catch:{ Exception -> 0x0091 }
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5     // Catch:{ Exception -> 0x0091 }
            r4.setOnClickListener(r5)     // Catch:{ Exception -> 0x0091 }
        L_0x0064:
            android.view.View r4 = r2.f18085c     // Catch:{ Exception -> 0x0091 }
            if (r4 == 0) goto L_0x0073
            T r3 = r3.element     // Catch:{ Exception -> 0x0091 }
            net.one97.paytm.paymentsBank.createfd.b.a$d r3 = (net.one97.paytm.paymentsBank.createfd.b.a.d) r3     // Catch:{ Exception -> 0x0091 }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x0091 }
            r0 = 5000(0x1388, double:2.4703E-320)
            r4.postDelayed(r3, r0)     // Catch:{ Exception -> 0x0091 }
        L_0x0073:
            int r3 = net.one97.paytm.paymentsBank.R.id.tv_amount     // Catch:{ Exception -> 0x0091 }
            android.view.View r3 = r2.a((int) r3)     // Catch:{ Exception -> 0x0091 }
            net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText r3 = (net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText) r3     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0088
            android.text.Editable r3 = r3.getText()     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0088
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            if (r3 != 0) goto L_0x008e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0091 }
        L_0x008e:
            r2.c((java.lang.String) r3)     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.a.a(double, java.lang.Integer):void");
    }

    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18094a;

        d(a aVar) {
            this.f18094a = aVar;
        }

        public final void run() {
            View view = this.f18094a.f18085c;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18092a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f18093b;

        c(a aVar, x.e eVar) {
            this.f18092a = aVar;
            this.f18093b = eVar;
        }

        public final void onClick(View view) {
            View view2 = this.f18092a.f18085c;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.f18092a.f18085c;
            if (view3 != null) {
                view3.removeCallbacks((d) this.f18093b.element);
            }
        }
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public static final /* synthetic */ void a(a aVar) {
        try {
            net.one97.paytm.bankOpen.f.b().checkDeepLinking(aVar.getActivity(), net.one97.paytm.bankCommon.utils.a.a(net.one97.paytm.bankCommon.utils.a.b(), CJRPGTransactionRequestUtils.PAYER_BANK_NAME, true));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
