package net.one97.paytm.wallet.rateMerchant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.R;

public final class RateMerchantFragment extends net.one97.paytm.i.h {

    /* renamed from: d  reason: collision with root package name */
    public static final a f71584d = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String m = m;
    /* access modifiers changed from: private */
    public static final String n = n;

    /* renamed from: a  reason: collision with root package name */
    LottieAnimationView f71585a;

    /* renamed from: b  reason: collision with root package name */
    boolean f71586b;

    /* renamed from: c  reason: collision with root package name */
    float f71587c;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.wallet.rateMerchant.c.b f71588e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f71589f;

    /* renamed from: g  reason: collision with root package name */
    private Float f71590g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f71591h;

    /* renamed from: i  reason: collision with root package name */
    private UpdateRatingBroadcast f71592i;
    private boolean j;
    private String k;
    private String l = "";
    private HashMap o;

    public final View a(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class f<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71598a;

        f(RateMerchantFragment rateMerchantFragment) {
            this.f71598a = rateMerchantFragment;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
            r4 = r4.getErrorType();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.wallet.rateMerchant.a.a r4 = (net.one97.paytm.wallet.rateMerchant.a.a) r4
                if (r4 == 0) goto L_0x0150
                net.one97.paytm.wallet.rateMerchant.a.b r0 = r4.f71611a
                int[] r1 = net.one97.paytm.wallet.rateMerchant.d.f71706a
                int r0 = r0.ordinal()
                r0 = r1[r0]
                r1 = 1
                r2 = 0
                if (r0 == r1) goto L_0x0062
                r1 = 2
                if (r0 == r1) goto L_0x005a
                r1 = 3
                if (r0 == r1) goto L_0x001a
                goto L_0x0150
            L_0x001a:
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r0 = r3.f71598a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 != 0) goto L_0x0025
                kotlin.g.b.k.a()
            L_0x0025:
                java.lang.String r1 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.network.model.NetworkCustomError r4 = r4.f71613c
                if (r4 == 0) goto L_0x003b
                com.paytm.network.model.NetworkCustomError$ErrorType r4 = r4.getErrorType()
                if (r4 == 0) goto L_0x003b
                java.lang.String r4 = r4.name()
                goto L_0x003c
            L_0x003b:
                r4 = 0
            L_0x003c:
                java.lang.String r4 = net.one97.paytm.wallet.rateMerchant.utils.a.a((android.content.Context) r0, (java.lang.String) r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r0 = r3.f71598a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.content.Context r0 = (android.content.Context) r0
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                android.widget.Toast r4 = android.widget.Toast.makeText(r0, r4, r2)
                r4.show()
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                com.airbnb.lottie.LottieAnimationView r4 = r4.f71585a
                net.one97.paytm.common.widgets.a.b(r4)
                goto L_0x0150
            L_0x005a:
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                com.airbnb.lottie.LottieAnimationView r4 = r4.f71585a
                net.one97.paytm.common.widgets.a.a(r4)
                return
            L_0x0062:
                ResultType r4 = r4.f71612b
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r0)
                if (r4 == 0) goto L_0x0150
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                com.airbnb.lottie.LottieAnimationView r4 = r4.f71585a
                net.one97.paytm.common.widgets.a.b(r4)
                android.content.Intent r4 = new android.content.Intent
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment$a r0 = net.one97.paytm.wallet.rateMerchant.RateMerchantFragment.f71584d
                java.lang.String r0 = net.one97.paytm.wallet.rateMerchant.RateMerchantFragment.n
                r4.<init>(r0)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r0 = r3.f71598a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 != 0) goto L_0x008b
                kotlin.g.b.k.a()
            L_0x008b:
                android.content.Context r0 = (android.content.Context) r0
                androidx.localbroadcastmanager.a.a r0 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r0)
                r0.a((android.content.Intent) r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.content.Context r4 = (android.content.Context) r4
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r0 = r3.f71598a
                int r1 = net.one97.paytm.wallet.R.string.channels_review_submitted
                java.lang.String r0 = r0.getString(r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                android.widget.Toast r4 = android.widget.Toast.makeText(r4, r0, r2)
                r4.show()
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.textInputLayout
                android.view.View r4 = r4.a((int) r0)
                com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
                java.lang.String r0 = "textInputLayout"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.tvSubmit
                android.view.View r4 = r4.a((int) r0)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r0 = "tvSubmit"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.ratingBar
                android.view.View r4 = r4.a((int) r0)
                androidx.appcompat.widget.AppCompatRatingBar r4 = (androidx.appcompat.widget.AppCompatRatingBar) r4
                java.lang.String r0 = "ratingBar"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.tvRateMsg
                android.view.View r4 = r4.a((int) r0)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r0 = "tvRateMsg"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.write_a_review_tv
                android.view.View r4 = r4.a((int) r0)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r0 = "write_a_review_tv"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.thanks_for_review_tv
                android.view.View r4 = r4.a((int) r0)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r0 = "thanks_for_review_tv"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.no_rating_yet
                android.view.View r4 = r4.a((int) r0)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r0 = "no_rating_yet"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                int r0 = net.one97.paytm.wallet.R.id.end_separator_rnr
                android.view.View r4 = r4.a((int) r0)
                java.lang.String r0 = "end_separator_rnr"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment r4 = r3.f71598a
                java.lang.String r0 = "review_submitted"
                net.one97.paytm.wallet.rateMerchant.RateMerchantFragment.a((net.one97.paytm.wallet.rateMerchant.RateMerchantFragment) r4, (java.lang.String) r0)
            L_0x0150:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.rateMerchant.RateMerchantFragment.f.onChanged(java.lang.Object):void");
        }
    }

    static final class g<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<o<? extends Float, ? extends Boolean>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71599a;

        g(RateMerchantFragment rateMerchantFragment) {
            this.f71599a = rateMerchantFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar;
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            if (aVar != null) {
                if (d.f71707b[aVar.f71611a.ordinal()] == 1 && (oVar = (o) aVar.f71612b) != null && ((Boolean) oVar.getSecond()).booleanValue() && !this.f71599a.f71586b) {
                    a aVar2 = RateMerchantFragment.f71584d;
                    Intent intent = new Intent(RateMerchantFragment.m);
                    intent.putExtra("user_rating", ((Number) oVar.getFirst()).floatValue());
                    FragmentActivity activity = this.f71599a.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    androidx.localbroadcastmanager.a.a.a((Context) activity).a(intent);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.wallet.rateMerchant.c.b b(RateMerchantFragment rateMerchantFragment) {
        net.one97.paytm.wallet.rateMerchant.c.b bVar = rateMerchantFragment.f71588e;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f71592i = new UpdateRatingBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory("android.intent.category.DEFAULT");
        intentFilter.addAction(m);
        intentFilter.addAction(n);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
        UpdateRatingBroadcast updateRatingBroadcast = this.f71592i;
        if (updateRatingBroadcast == null) {
            k.a();
        }
        a2.a(updateRatingBroadcast, intentFilter);
        Bundle arguments = getArguments();
        this.j = arguments != null ? arguments.getBoolean("should_show_tap_to_rate") : false;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        if (this.j) {
            View inflate = layoutInflater.inflate(R.layout.fragment_tap_to_rate_layout_wallet, viewGroup, false);
            k.a((Object) inflate, "inflater.inflate(R.layou…wallet, container, false)");
            return inflate;
        }
        View inflate2 = layoutInflater.inflate(R.layout.fragment_rate_review_wallet, viewGroup, false);
        k.a((Object) inflate2, "inflater.inflate(R.layou…wallet, container, false)");
        return inflate2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f71585a = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        this.f71588e = (net.one97.paytm.wallet.rateMerchant.c.b) net.one97.paytm.wallet.rateMerchant.utils.a.a((Fragment) this, net.one97.paytm.wallet.rateMerchant.c.b.class);
        Bundle arguments = getArguments();
        Float f2 = null;
        this.k = arguments != null ? arguments.getString("merchant_id") : null;
        Bundle arguments2 = getArguments();
        boolean z = false;
        this.f71589f = arguments2 != null ? arguments2.getBoolean("should_show_review_text") : false;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            z = arguments3.getBoolean("be_the_first_one_view");
        }
        this.f71591h = z;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            f2 = Float.valueOf(arguments4.getFloat("user_rating"));
        }
        this.f71590g = f2;
        net.one97.paytm.wallet.rateMerchant.c.b bVar = this.f71588e;
        if (bVar == null) {
            k.a("viewModel");
        }
        o<String, String> b2 = bVar.j.b();
        if (b2 != null) {
            net.one97.paytm.wallet.rateMerchant.c.b bVar2 = this.f71588e;
            if (bVar2 == null) {
                k.a("viewModel");
            }
            String str2 = this.k;
            if (str2 == null) {
                k.a();
            }
            String first = b2.getFirst();
            String second = b2.getSecond();
            k.c(str2, SDKConstants.KEY_MERCHANT_ID);
            k.c(first, "clientId");
            k.c(second, "clientSecret");
            bVar2.f71690c = str2;
            bVar2.f71691d = first;
            bVar2.f71692e = second;
        }
        if (this.f71591h) {
            TextView textView = (TextView) a(R.id.tvRateMsg);
            k.a((Object) textView, "tvRateMsg");
            textView.setText(getString(R.string.review_and_rating));
            TextView textView2 = (TextView) a(R.id.no_rating_yet);
            k.a((Object) textView2, "no_rating_yet");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView2);
        }
        if (this.f71589f) {
            if (this.f71590g != null) {
                AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) a(R.id.ratingBar);
                k.a((Object) appCompatRatingBar, "ratingBar");
                Float f3 = this.f71590g;
                if (f3 == null) {
                    k.a();
                }
                appCompatRatingBar.setRating(f3.floatValue());
            }
            TextView textView3 = (TextView) a(R.id.write_a_review_tv);
            k.a((Object) textView3, "write_a_review_tv");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView3);
            TextView textView4 = (TextView) a(R.id.thanks_for_review_tv);
            k.a((Object) textView4, "thanks_for_review_tv");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView4);
        }
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str = arguments5.getString("channel_screen_name")) == null) {
            str = "";
        }
        this.l = str;
        net.one97.paytm.wallet.rateMerchant.c.b bVar3 = this.f71588e;
        if (bVar3 == null) {
            k.a("viewModel");
        }
        String str3 = this.l;
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        bVar3.f71693f = str3;
        net.one97.paytm.wallet.rateMerchant.c.b bVar4 = this.f71588e;
        if (bVar4 == null) {
            k.a("viewModel");
        }
        q qVar = this;
        bVar4.f71695h.observe(qVar, new f(this));
        net.one97.paytm.wallet.rateMerchant.c.b bVar5 = this.f71588e;
        if (bVar5 == null) {
            k.a("viewModel");
        }
        bVar5.f71696i.observe(qVar, new g(this));
        ((AppCompatEditText) a(R.id.tilReview)).addTextChangedListener(new b(this));
        ((TextView) a(R.id.write_a_review_tv)).setOnClickListener(new c(this));
        ((TextView) a(R.id.tvSubmit)).setOnClickListener(new d(this));
        ((AppCompatRatingBar) a(R.id.ratingBar)).setOnRatingBarChangeListener(new e(this));
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71594a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(RateMerchantFragment rateMerchantFragment) {
            this.f71594a = rateMerchantFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f71594a.a(R.id.textInputLayout);
            k.a((Object) textInputLayout, "textInputLayout");
            textInputLayout.setError("");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71595a;

        c(RateMerchantFragment rateMerchantFragment) {
            this.f71595a = rateMerchantFragment;
        }

        public final void onClick(View view) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f71595a.a(R.id.textInputLayout);
            k.a((Object) textInputLayout, "textInputLayout");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textInputLayout);
            TextView textView = (TextView) this.f71595a.a(R.id.tvSubmit);
            k.a((Object) textView, "tvSubmit");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView);
            ((TextInputLayout) this.f71595a.a(R.id.textInputLayout)).requestFocus();
            RateMerchantFragment rateMerchantFragment = this.f71595a;
            AppCompatEditText appCompatEditText = (AppCompatEditText) rateMerchantFragment.a(R.id.tilReview);
            k.a((Object) appCompatEditText, "tilReview");
            appCompatEditText.postDelayed(new h(rateMerchantFragment, appCompatEditText), 100);
            TextView textView2 = (TextView) this.f71595a.a(R.id.write_a_review_tv);
            k.a((Object) textView2, "write_a_review_tv");
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView2);
            RateMerchantFragment.a(this.f71595a, "review_clicked");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71596a;

        d(RateMerchantFragment rateMerchantFragment) {
            this.f71596a = rateMerchantFragment;
        }

        public final void onClick(View view) {
            if (RateMerchantFragment.a(this.f71596a)) {
                AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) this.f71596a.a(R.id.ratingBar);
                k.a((Object) appCompatRatingBar, "ratingBar");
                float rating = appCompatRatingBar.getRating();
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f71596a.a(R.id.tilReview);
                k.a((Object) appCompatEditText, "tilReview");
                String valueOf = String.valueOf(appCompatEditText.getText());
                net.one97.paytm.wallet.rateMerchant.c.b b2 = RateMerchantFragment.b(this.f71596a);
                o oVar = new o(Float.valueOf(rating), valueOf);
                k.c(oVar, "pair");
                b2.f71689b.setValue(oVar);
                RateMerchantFragment rateMerchantFragment = this.f71596a;
                try {
                    FragmentActivity activity = rateMerchantFragment.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        TextInputLayout textInputLayout = (TextInputLayout) rateMerchantFragment.a(R.id.textInputLayout);
                        k.a((Object) textInputLayout, "textInputLayout");
                        inputMethodManager.hideSoftInputFromWindow(textInputLayout.getWindowToken(), 0);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    static final class e implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71597a;

        e(RateMerchantFragment rateMerchantFragment) {
            this.f71597a = rateMerchantFragment;
        }

        public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
            if (f2 < 1.0f) {
                AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) this.f71597a.a(R.id.ratingBar);
                k.a((Object) appCompatRatingBar, "ratingBar");
                appCompatRatingBar.setRating(1.0f);
            }
            TextView textView = (TextView) this.f71597a.a(R.id.thanks_for_review_tv);
            k.a((Object) textView, "thanks_for_review_tv");
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView);
            TextInputLayout textInputLayout = (TextInputLayout) this.f71597a.a(R.id.textInputLayout);
            k.a((Object) textInputLayout, "textInputLayout");
            if (textInputLayout.getVisibility() != 0) {
                TextView textView2 = (TextView) this.f71597a.a(R.id.write_a_review_tv);
                k.a((Object) textView2, "write_a_review_tv");
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView2);
            }
            TextView textView3 = (TextView) this.f71597a.a(R.id.no_rating_yet);
            k.a((Object) textView3, "no_rating_yet");
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView3);
            RateMerchantFragment.a(this.f71597a, "rate_clicked");
            if (!this.f71597a.f71586b) {
                RateMerchantFragment.b(this.f71597a).f71694g.setValue(Float.valueOf(f2));
            }
        }
    }

    public final class UpdateRatingBroadcast extends BroadcastReceiver {
        public UpdateRatingBroadcast() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                a aVar = RateMerchantFragment.f71584d;
                if (action.equals(RateMerchantFragment.m)) {
                    RateMerchantFragment rateMerchantFragment = RateMerchantFragment.this;
                    rateMerchantFragment.f71586b = true;
                    rateMerchantFragment.f71587c = intent.getFloatExtra("user_rating", 0.0f);
                    AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) RateMerchantFragment.this.a(R.id.ratingBar);
                    k.a((Object) appCompatRatingBar, "ratingBar");
                    appCompatRatingBar.setRating(RateMerchantFragment.this.f71587c);
                }
                String action2 = intent.getAction();
                a aVar2 = RateMerchantFragment.f71584d;
                if (action2.equals(RateMerchantFragment.n)) {
                    TextInputLayout textInputLayout = (TextInputLayout) RateMerchantFragment.this.a(R.id.textInputLayout);
                    k.a((Object) textInputLayout, "textInputLayout");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textInputLayout);
                    TextView textView = (TextView) RateMerchantFragment.this.a(R.id.tvSubmit);
                    k.a((Object) textView, "tvSubmit");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
                    AppCompatRatingBar appCompatRatingBar2 = (AppCompatRatingBar) RateMerchantFragment.this.a(R.id.ratingBar);
                    k.a((Object) appCompatRatingBar2, "ratingBar");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(appCompatRatingBar2);
                    TextView textView2 = (TextView) RateMerchantFragment.this.a(R.id.tvRateMsg);
                    k.a((Object) textView2, "tvRateMsg");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textView2);
                    TextView textView3 = (TextView) RateMerchantFragment.this.a(R.id.write_a_review_tv);
                    k.a((Object) textView3, "write_a_review_tv");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textView3);
                    TextView textView4 = (TextView) RateMerchantFragment.this.a(R.id.thanks_for_review_tv);
                    k.a((Object) textView4, "thanks_for_review_tv");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textView4);
                    TextView textView5 = (TextView) RateMerchantFragment.this.a(R.id.no_rating_yet);
                    k.a((Object) textView5, "no_rating_yet");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(textView5);
                    View a2 = RateMerchantFragment.this.a(R.id.end_separator_rnr);
                    k.a((Object) a2, "end_separator_rnr");
                    net.one97.paytm.wallet.rateMerchant.utils.b.b(a2);
                }
            }
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantFragment f71600a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f71601b;

        h(RateMerchantFragment rateMerchantFragment, EditText editText) {
            this.f71600a = rateMerchantFragment;
            this.f71601b = editText;
        }

        public final void run() {
            Window window;
            try {
                FragmentActivity activity = this.f71600a.getActivity();
                InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f71601b, 1);
                    FragmentActivity activity2 = this.f71600a.getActivity();
                    if (activity2 != null && (window = activity2.getWindow()) != null) {
                        window.setSoftInputMode(32);
                    }
                }
            } catch (Exception e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
        UpdateRatingBroadcast updateRatingBroadcast = this.f71592i;
        if (updateRatingBroadcast == null) {
            k.a();
        }
        a2.a((BroadcastReceiver) updateRatingBroadcast);
    }

    public static final /* synthetic */ void a(RateMerchantFragment rateMerchantFragment, String str) {
        String str2;
        if (p.a(rateMerchantFragment.l, "channels/brands", true)) {
            str2 = "channels_brand";
        } else {
            str2 = p.a(rateMerchantFragment.l, "channels/merchant-page", true) ? "channels_merchant" : "";
        }
        String str3 = str2;
        net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
        FragmentActivity activity = rateMerchantFragment.getActivity();
        if (activity == null) {
            k.a();
        }
        a2.sendNewCustomGTMEvents(activity, str3, str, rateMerchantFragment.k, "", (String) null, rateMerchantFragment.l, "wallet");
    }

    public static final /* synthetic */ boolean a(RateMerchantFragment rateMerchantFragment) {
        AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) rateMerchantFragment.a(R.id.ratingBar);
        k.a((Object) appCompatRatingBar, "ratingBar");
        if (appCompatRatingBar.getRating() == 0.0f) {
            Toast.makeText(rateMerchantFragment.getActivity(), rateMerchantFragment.getString(R.string.give_rating), 1).show();
            return false;
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) rateMerchantFragment.a(R.id.tilReview);
        k.a((Object) appCompatEditText, "tilReview");
        CharSequence text = appCompatEditText.getText();
        if (!(text == null || p.a(text))) {
            return true;
        }
        TextInputLayout textInputLayout = (TextInputLayout) rateMerchantFragment.a(R.id.textInputLayout);
        k.a((Object) textInputLayout, "textInputLayout");
        textInputLayout.setError(rateMerchantFragment.getString(R.string.write_valid_review));
        return false;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
