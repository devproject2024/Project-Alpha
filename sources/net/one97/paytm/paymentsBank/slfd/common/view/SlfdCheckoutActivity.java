package net.one97.paytm.paymentsBank.slfd.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.s;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.m.p;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.common.a.a;
import net.one97.paytm.paymentsBank.slfd.passbook.view.SlfdPassbookActivity;
import net.one97.paytm.paymentsBank.utils.o;

public final class SlfdCheckoutActivity extends SlfdBaseActivity implements a.b {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f18979b;

    /* renamed from: c  reason: collision with root package name */
    public a.C0328a f18980c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f18981d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.g f18982e = kotlin.h.a(new i(this));

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.g f18983f = kotlin.h.a(new d(this));

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.g f18984g = kotlin.h.a(new b(this));

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.g f18985h = kotlin.h.a(new a(this));

    /* renamed from: i  reason: collision with root package name */
    private HashMap f18986i;

    static {
        Class<SlfdCheckoutActivity> cls = SlfdCheckoutActivity.class;
        f18979b = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "orderId", "getOrderId()Ljava/lang/String;")), y.a((v) new w(y.b(cls), "isFromImpulse", "isFromImpulse()Z")), y.a((v) new w(y.b(cls), "amount", "getAmount()D")), y.a((v) new w(y.b(cls), "accountNum", "getAccountNum()Ljava/lang/String;"))};
    }

    /* access modifiers changed from: private */
    public final boolean h() {
        return ((Boolean) this.f18983f.getValue()).booleanValue();
    }

    private final double i() {
        return ((Number) this.f18984g.getValue()).doubleValue();
    }

    /* access modifiers changed from: private */
    public final String j() {
        return (String) this.f18985h.getValue();
    }

    public final View a(int i2) {
        if (this.f18986i == null) {
            this.f18986i = new HashMap();
        }
        View view = (View) this.f18986i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f18986i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z) {
    }

    public final a.C0328a f() {
        a.C0328a aVar = this.f18980c;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_fd_create_redeem_status;
    }

    static final class i extends l implements kotlin.g.a.a<String> {
        final /* synthetic */ SlfdCheckoutActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(SlfdCheckoutActivity slfdCheckoutActivity) {
            super(0);
            this.this$0 = slfdCheckoutActivity;
        }

        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("order_id");
        }
    }

    static final class d extends l implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ SlfdCheckoutActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(SlfdCheckoutActivity slfdCheckoutActivity) {
            super(0);
            this.this$0 = slfdCheckoutActivity;
        }

        public final boolean invoke() {
            return this.this$0.getIntent().getBooleanExtra("is_from_impulse", false);
        }
    }

    static final class b extends l implements kotlin.g.a.a<Double> {
        final /* synthetic */ SlfdCheckoutActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SlfdCheckoutActivity slfdCheckoutActivity) {
            super(0);
            this.this$0 = slfdCheckoutActivity;
        }

        public final double invoke() {
            return this.this$0.getIntent().getDoubleExtra("slfd_amount", 0.0d);
        }
    }

    static final class a extends l implements kotlin.g.a.a<String> {
        final /* synthetic */ SlfdCheckoutActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SlfdCheckoutActivity slfdCheckoutActivity) {
            super(0);
            this.this$0 = slfdCheckoutActivity;
        }

        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("account_num");
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context context = this;
        net.one97.paytm.paymentsBank.slfd.a.a.b a2 = net.one97.paytm.paymentsBank.slfd.c.a(context);
        String str = (String) this.f18982e.getValue();
        k.a((Object) str, "orderId");
        String n = com.paytm.utility.b.n(context);
        k.a((Object) n, "CJRAppCommonUtility.getUserId(this)");
        a.C0328a aVar = new net.one97.paytm.paymentsBank.slfd.common.b.a(this, a2, str, n, j(), h());
        k.c(aVar, "<set-?>");
        this.f18980c = aVar;
        f().a();
        TextView textView = (TextView) a(R.id.tv_fd_status_tip);
        k.a((Object) textView, "tv_fd_status_tip");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_redemption_list);
        k.a((Object) recyclerView, "rv_redemption_list");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ((RecyclerView) a(R.id.rv_redemption_list)).addItemDecoration(new net.one97.paytm.paymentsBank.slfd.redeemFd.h(net.one97.paytm.bankCommon.mapping.a.a(10.0f, context)));
        if (Build.VERSION.SDK_INT < 21) {
            ProgressBar progressBar = (ProgressBar) a(R.id.progress);
            k.a((Object) progressBar, H5Param.PROGRESS);
            Drawable f2 = androidx.core.graphics.drawable.a.f(progressBar.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(context, R.color.fd_status_pending_progress));
            ProgressBar progressBar2 = (ProgressBar) a(R.id.progress);
            k.a((Object) progressBar2, H5Param.PROGRESS);
            progressBar2.setIndeterminateDrawable(androidx.core.graphics.drawable.a.g(f2));
        } else {
            ProgressBar progressBar3 = (ProgressBar) a(R.id.progress);
            k.a((Object) progressBar3, H5Param.PROGRESS);
            progressBar3.getIndeterminateDrawable().setColorFilter(androidx.core.content.b.c(context, R.color.fd_status_pending_progress), PorterDuff.Mode.SRC_IN);
        }
        ((ImageView) a(R.id.iv_close)).setOnClickListener(new e(this));
        ((LinearLayout) a(R.id.ll_help_support)).setOnClickListener(new f(this));
        ((LinearLayout) a(R.id.ll_transaction_history)).setOnClickListener(new g(this));
        ((ImageView) a(R.id.iv_share)).setOnClickListener(new h(this));
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent("intent.action.updateSlfdLanding"));
        TextView textView2 = (TextView) a(R.id.tv_fd_date);
        k.a((Object) textView2, "tv_fd_date");
        textView2.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "hh:mm a, dd MMM yyyy", System.currentTimeMillis()));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18988a;

        e(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18988a = slfdCheckoutActivity;
        }

        public final void onClick(View view) {
            this.f18988a.finish();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18989a;

        f(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18989a = slfdCheckoutActivity;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            if (this.f18989a.h()) {
                str = "create";
                str2 = "/fixed-deposit/create-order-status";
            } else {
                str = "redeem";
                str2 = "/fixed-deposit/order-status-redeem";
            }
            net.one97.paytm.bankCommon.mapping.c.a(this.f18989a, "fixed_deposit", "help_clicked", str, (String) null, (String) null, str2, "fixed_deposit");
            net.one97.paytm.paymentsBank.h.a a2 = o.a();
            SlfdCheckoutActivity slfdCheckoutActivity = this.f18989a;
            a2.openCST(slfdCheckoutActivity, slfdCheckoutActivity.j());
            this.f18989a.finish();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18990a;

        g(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18990a = slfdCheckoutActivity;
        }

        public final void onClick(View view) {
            this.f18990a.startActivity(new Intent(this.f18990a, SlfdPassbookActivity.class));
            this.f18990a.finish();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18991a;

        h(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18991a = slfdCheckoutActivity;
        }

        public final void onClick(View view) {
            this.f18991a.g();
        }
    }

    public final void a() {
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nsv_main_content);
        k.a((Object) nestedScrollView, "nsv_main_content");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(nestedScrollView);
    }

    public final void b() {
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nsv_main_content);
        k.a((Object) nestedScrollView, "nsv_main_content");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(nestedScrollView);
    }

    public final void ai_() {
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nsv_main_content);
        k.a((Object) nestedScrollView, "nsv_main_content");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(nestedScrollView);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
    }

    private final void k() {
        TextView textView = (TextView) a(R.id.tv_fd_amount);
        k.a((Object) textView, "tv_fd_amount");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView);
        String c2 = net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(i()));
        net.one97.paytm.bankCommon.mapping.e.a(getString(R.string.fd_amount, new Object[]{c2}), (TextView) a(R.id.tv_fd_amount));
    }

    public final void a(BookingResponseListItem bookingResponseListItem) {
        k.c(bookingResponseListItem, "bookingResponseListItem");
        k();
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_create_title_for_status_success));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        String message = bookingResponseListItem.getMessage();
        if (message == null) {
            message = getString(R.string.fd_create_success_message);
        }
        textView2.setText(message);
        TextView textView3 = (TextView) a(R.id.tv_fd_status_tip);
        k.a((Object) textView3, "tv_fd_status_tip");
        textView3.setText(getString(R.string.fd_auto_renewed));
        ProgressBar progressBar = (ProgressBar) a(R.id.progress);
        k.a((Object) progressBar, H5Param.PROGRESS);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_created_fd_details);
        k.a((Object) linearLayout, "ll_created_fd_details");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout);
        TextView textView4 = (TextView) a(R.id.tv_fd_date);
        k.a((Object) textView4, "tv_fd_date");
        textView4.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "hh:mm a, dd MMM yyyy", bookingResponseListItem.getFdBookingDate()));
        TextView textView5 = (TextView) a(R.id.tv_fd_number);
        k.a((Object) textView5, "tv_fd_number");
        textView5.setText(getString(R.string.fd_num, new Object[]{bookingResponseListItem.getFdNumber()}));
        TextView textView6 = (TextView) a(R.id.tv_fd_interest);
        k.a((Object) textView6, "tv_fd_interest");
        textView6.setText(getString(R.string.fd_create_fd_roi, new Object[]{String.valueOf(bookingResponseListItem.getRateOfInterestPa())}));
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_success);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_success_icon);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "create_fd_successful", (String) null, (String) null, (String) null, "/fixed-deposit/create-order-status", "fixed_deposit");
    }

    public final void a(String str) {
        k();
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_create_title_for_status_pending));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_create_pending_message);
        }
        textView2.setText(str);
        l();
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_pending);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_status_pending);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "create_fd_inprocess", (String) null, (String) null, (String) null, "/fixed-deposit/create-order-status", "fixed_deposit");
    }

    public final void b(String str) {
        k();
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_fd_tip);
        k.a((Object) linearLayout, "ll_fd_tip");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        ProgressBar progressBar = (ProgressBar) a(R.id.progress);
        k.a((Object) progressBar, H5Param.PROGRESS);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_create_title_for_status_failed));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_create_failed_message);
        }
        textView2.setText(str);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_failed);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_fail);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "create_fd_failed", (String) null, (String) null, (String) null, "/fixed-deposit/create-order-status", "fixed_deposit");
    }

    public final void c(String str) {
        k();
        ProgressBar progressBar = (ProgressBar) a(R.id.progress);
        k.a((Object) progressBar, H5Param.PROGRESS);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_redeem_title_for_status_success));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_redeem_success_message);
        }
        textView2.setText(str);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_success);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_success_icon);
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_fd_tip);
        k.a((Object) linearLayout, "ll_fd_tip");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "redeem_successful", (String) null, (String) null, (String) null, "/fixed-deposit/order-status-redeem", "fixed_deposit");
    }

    public final void d(String str) {
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_redeem_title_for_status_partial));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_redeem_partial_success_message, new Object[]{String.valueOf(i())});
        }
        textView2.setText(str);
        ProgressBar progressBar = (ProgressBar) a(R.id.progress);
        k.a((Object) progressBar, H5Param.PROGRESS);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_pending);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_status_pending);
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_fd_tip);
        k.a((Object) linearLayout, "ll_fd_tip");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "redeem_successful", (String) null, (String) null, (String) null, "/fixed-deposit/order-status-redeem", "fixed_deposit");
    }

    public final void e(String str) {
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_redeem_title_for_status_pending));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_redeem_pending_message);
        }
        textView2.setText(str);
        l();
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_pending);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_status_pending);
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "redeem_inprocess", (String) null, (String) null, (String) null, "/fixed-deposit/order-status-redeem", "fixed_deposit");
    }

    private final void l() {
        if (p.a("en-IN", com.paytm.utility.b.g(), true)) {
            TextView textView = (TextView) a(R.id.tv_fd_status_tip);
            k.a((Object) textView, "tv_fd_status_tip");
            textView.setText(m());
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_fd_status_tip);
        k.a((Object) textView2, "tv_fd_status_tip");
        textView2.setText(getString(R.string.fd_booking_pending_note));
    }

    public final void f(String str) {
        k();
        TextView textView = (TextView) a(R.id.tv_status_title);
        k.a((Object) textView, "tv_status_title");
        textView.setText(getString(R.string.fd_redeem_title_for_status_failed));
        TextView textView2 = (TextView) a(R.id.tv_status_message);
        k.a((Object) textView2, "tv_status_message");
        if (str == null) {
            str = getString(R.string.fd_redeem_failure_message);
        }
        textView2.setText(str);
        ProgressBar progressBar = (ProgressBar) a(R.id.progress);
        k.a((Object) progressBar, H5Param.PROGRESS);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_fd_status_container);
        k.a((Object) constraintLayout, "cl_fd_status_container");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((View) constraintLayout, R.color.fd_status_failed);
        ImageView imageView = (ImageView) a(R.id.iv_fd_status);
        k.a((Object) imageView, "iv_fd_status");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(imageView, R.drawable.pb_ic_fail);
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_fd_tip);
        k.a((Object) linearLayout, "ll_fd_tip");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        Context context = this;
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/failed-status-redeem", "fixed-deposit", context);
        net.one97.paytm.bankCommon.mapping.c.a(context, "fixed_deposit", "redeem_failed", (String) null, (String) null, (String) null, "/fixed-deposit/order-status-redeem", "fixed_deposit");
    }

    public final void a(List<RedemptionResponseListItem> list) {
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_redeem_fd_parent);
        k.a((Object) linearLayout, "ll_redeem_fd_parent");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout);
        TextView textView = (TextView) a(R.id.tv_redeem_fd_header);
        k.a((Object) textView, "tv_redeem_fd_header");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_redemption_list);
        k.a((Object) recyclerView, "rv_redemption_list");
        recyclerView.setAdapter(new a(list, false));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_redemption_list);
        k.a((Object) recyclerView2, "rv_redemption_list");
        RecyclerView.a adapter = recyclerView2.getAdapter();
        if (adapter == null) {
            k.a();
        }
        adapter.notifyDataSetChanged();
    }

    public final void a(double d2) {
        String c2 = net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(d2));
        TextView textView = (TextView) a(R.id.tv_sa_balance);
        k.a((Object) textView, "tv_sa_balance");
        textView.setText(getString(R.string.fd_sa_balance, new Object[]{c2}));
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18992a;

        j(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18992a = slfdCheckoutActivity;
        }

        public final void run() {
            this.f18992a.f().a(false);
            this.f18992a.f().c();
        }
    }

    public final void a(long j2) {
        this.f18981d.postDelayed(new j(this), j2);
    }

    public final void g() {
        if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.pb_post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", "");
                NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nsv_main_content);
                k.a((Object) nestedScrollView, "nsv_main_content");
                View view = nestedScrollView;
                k.c(view, "view");
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                k.a((Object) createBitmap, "bitmap");
                String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.pb_title), (String) null);
                if (insertImage != null) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                    Intent createChooser = Intent.createChooser(intent, getString(R.string.pb_post_payment_share_title));
                    if (createChooser.resolveActivity(getPackageManager()) != null) {
                        startActivity(createChooser);
                    } else {
                        Toast.makeText(this, getString(R.string.pb_no_app_found), 1).show();
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            s.b((Activity) this);
            Toast.makeText(this, getString(R.string.pb_permission_not_granted), 0).show();
        }
    }

    private SpannableString m() {
        String string = getString(R.string.fd_booking_pending_note);
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        c cVar = new c(this);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00b9f5"));
        k.a((Object) string, "msg");
        int a2 = p.a(charSequence, "Transaction", 0, false, 6);
        int i2 = a2 + 19;
        spannableString.setSpan(cVar, a2, i2, 33);
        spannableString.setSpan(foregroundColorSpan, a2, i2, 33);
        return spannableString;
    }

    public static final class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdCheckoutActivity f18987a;

        c(SlfdCheckoutActivity slfdCheckoutActivity) {
            this.f18987a = slfdCheckoutActivity;
        }

        public final void onClick(View view) {
            k.c(view, "textView");
            SlfdCheckoutActivity slfdCheckoutActivity = this.f18987a;
            slfdCheckoutActivity.startActivity(new Intent(slfdCheckoutActivity, SlfdPassbookActivity.class));
            this.f18987a.finish();
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 == 56 && s.a(iArr)) {
            g();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f().b();
        this.f18981d.removeCallbacks((Runnable) null);
    }
}
