package net.one97.paytm;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatRatingBar;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.common.a.a;

public final class InsuranceOrderSummary extends PaytmActivity implements Response.ErrorListener, Response.Listener<IJRDataModel>, com.paytm.network.listener.b, net.one97.paytm.common.widgets.a.a {
    private static final String M = "1";
    /* access modifiers changed from: private */
    public static final String N = "7";
    /* access modifiers changed from: private */
    public static final String O = "6";
    /* access modifiers changed from: private */
    public static final String P = "18";
    /* access modifiers changed from: private */
    public static final String Q = Q;

    /* renamed from: b  reason: collision with root package name */
    public static final a f13533b = new a((byte) 0);
    private boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private RelativeLayout C;
    private TextView D;
    /* access modifiers changed from: private */
    public String E;
    private String F;
    /* access modifiers changed from: private */
    public CJROrderSummary G;
    private LottieAnimationView H;
    private RelativeLayout I;
    /* access modifiers changed from: private */
    public net.one97.paytm.insurance.common.a.a J;
    /* access modifiers changed from: private */
    public net.one97.paytm.common.widgets.c K;
    private CJROrderSummary L;
    private HashMap R;

    /* renamed from: a  reason: collision with root package name */
    String f13534a = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f13535c;

    /* renamed from: d  reason: collision with root package name */
    private Context f13536d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13537e = 5000;

    /* renamed from: f  reason: collision with root package name */
    private int f13538f = 30000;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f13539g;

    /* renamed from: h  reason: collision with root package name */
    private final long f13540h = 1000;

    /* renamed from: i  reason: collision with root package name */
    private Dialog f13541i;
    private ImageView j;
    private TextView k;
    private boolean l;
    private ImageView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private net.one97.paytm.model.b u;
    private boolean v = true;
    private boolean w = true;
    private LinearLayout x;
    private TextView y;
    private ImageView z;

    private View a(int i2) {
        if (this.R == null) {
            this.R = new HashMap();
        }
        View view = (View) this.R.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.R.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onErrorResponse(VolleyError volleyError) {
    }

    public static final /* synthetic */ LottieAnimationView a(InsuranceOrderSummary insuranceOrderSummary) {
        LottieAnimationView lottieAnimationView = insuranceOrderSummary.f13539g;
        if (lottieAnimationView == null) {
            k.a("mAnimSuccesView");
        }
        return lottieAnimationView;
    }

    public static final /* synthetic */ Context d(InsuranceOrderSummary insuranceOrderSummary) {
        Context context = insuranceOrderSummary.f13536d;
        if (context == null) {
            k.a("context");
        }
        return context;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        a(false);
        if (iJRDataModel instanceof CJROrderSummary) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRDataModel;
            this.G = cJROrderSummary;
            a(cJROrderSummary);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        g();
        a(false);
        Context context = this.f13536d;
        if (context == null) {
            k.a("context");
        }
        String str = null;
        String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
        if (networkCustomError != null) {
            str = networkCustomError.getAlertMessage();
        }
        com.paytm.utility.b.b(context, alertTitle, str);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a(false);
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
            this.G = cJROrderSummary;
            ScrollView scrollView = (ScrollView) a(R.id.scroll_view_parent);
            if (scrollView != null) {
                scrollView.setVisibility(0);
            }
            a(cJROrderSummary);
        }
        if (iJRPaytmDataModel instanceof CJROrderedCart) {
            g();
            CJROrderSummaryAction cJROrderSummaryAction = ((CJROrderedCart) iJRPaytmDataModel).getTapActions().get(0);
            k.a((Object) cJROrderSummaryAction, "response.tapActions[0]");
            CJROrderSummaryActionURLParams urlParams = cJROrderSummaryAction.getUrlParams();
            String url = urlParams != null ? urlParams.getUrl() : null;
            if (!TextUtils.isEmpty(url)) {
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    if (TextUtils.isEmpty(url)) {
                        if (!TextUtils.isEmpty(this.f13534a)) {
                            url = this.f13534a;
                        } else {
                            Context context = this.f13536d;
                            if (context == null) {
                                k.a("context");
                            }
                            url = context.getString(R.string.policy_wording);
                        }
                    }
                    Context context2 = this.f13536d;
                    if (context2 == null) {
                        k.a("context");
                    }
                    request.setDestinationInExternalFilesDir(context2, Environment.DIRECTORY_DOWNLOADS, k.a(url, (Object) ".pdf"));
                    Context context3 = this.f13536d;
                    if (context3 == null) {
                        k.a("context");
                    }
                    DownloadManager downloadManager = (DownloadManager) context3.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                    Context context4 = this.f13536d;
                    if (context4 == null) {
                        k.a("context");
                    }
                    context4.registerReceiver(new InsuranceOrderSummary$downloadPDF$1(this), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                    if (downloadManager == null) {
                        k.a();
                    }
                    downloadManager.enqueue(request);
                } catch (Exception unused) {
                }
            }
        }
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
        setContentView(R.layout.activity_insurance_order_summary);
        Context context = this;
        this.f13536d = context;
        this.f13535c = getIntent().getStringExtra("order_id");
        this.w = getIntent().getBooleanExtra("IS_MY_ORDER_SCREEN", false);
        this.v = getIntent().getBooleanExtra("IS_SHOW_HOME", true);
        this.H = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.I = (RelativeLayout) findViewById(R.id.lyt_progress);
        View findViewById = findViewById(R.id.top_success_view);
        if (findViewById != null) {
            this.j = (ImageView) findViewById;
            View findViewById2 = findViewById(R.id.top_success_anim_view);
            if (findViewById2 != null) {
                this.f13539g = (LottieAnimationView) findViewById2;
                View findViewById3 = findViewById(R.id.transaction_amount_success);
                if (findViewById3 != null) {
                    this.k = (TextView) findViewById3;
                    View findViewById4 = findViewById(R.id.name_tv);
                    if (findViewById4 != null) {
                        this.o = (TextView) findViewById4;
                        View findViewById5 = findViewById(R.id.ivInsurerLogo);
                        k.a((Object) findViewById5, "findViewById<ImageView>(R.id.ivInsurerLogo)");
                        this.m = (ImageView) findViewById5;
                        View findViewById6 = findViewById(R.id.tvVehicleNum);
                        k.a((Object) findViewById6, "findViewById(R.id.tvVehicleNum)");
                        this.p = (TextView) findViewById6;
                        View findViewById7 = findViewById(R.id.tvOrderId);
                        k.a((Object) findViewById7, "findViewById(R.id.tvOrderId)");
                        this.q = (TextView) findViewById7;
                        View findViewById8 = findViewById(R.id.viewDetailsMyOrders);
                        k.a((Object) findViewById8, "findViewById(R.id.viewDetailsMyOrders)");
                        this.s = (TextView) findViewById8;
                        View findViewById9 = findViewById(R.id.tvTimeDate);
                        k.a((Object) findViewById9, "findViewById(R.id.tvTimeDate)");
                        this.r = (TextView) findViewById9;
                        View findViewById10 = findViewById(R.id.post_payment_success);
                        k.a((Object) findViewById10, "findViewById<LinearLayou….id.post_payment_success)");
                        this.x = (LinearLayout) findViewById10;
                        View findViewById11 = findViewById(R.id.tvStatus);
                        k.a((Object) findViewById11, "findViewById(R.id.tvStatus)");
                        this.t = (TextView) findViewById11;
                        View findViewById12 = findViewById(R.id.icon_share);
                        k.a((Object) findViewById12, "findViewById(R.id.icon_share)");
                        this.n = (ImageView) findViewById12;
                        View findViewById13 = findViewById(R.id.added_successfully_tv);
                        k.a((Object) findViewById13, "findViewById(R.id.added_successfully_tv)");
                        this.y = (TextView) findViewById13;
                        View findViewById14 = findViewById(R.id.iv_insurance_logo);
                        k.a((Object) findViewById14, "findViewById(R.id.iv_insurance_logo)");
                        this.z = (ImageView) findViewById14;
                        this.E = getIntent().getStringExtra("insurance_type");
                        String str = this.E;
                        if (str != null) {
                            int hashCode = str.hashCode();
                            if (hashCode != 57) {
                                if (hashCode != 1570) {
                                    if (hashCode != 1574) {
                                        if (hashCode == 1575 && str.equals("18")) {
                                            TextView textView = this.y;
                                            if (textView == null) {
                                                k.a("titleTextView");
                                            }
                                            textView.setText(getString(R.string.cycle_insurance_purchased));
                                            ImageView imageView = this.z;
                                            if (imageView == null) {
                                                k.a("insuranceLogoImageView");
                                            }
                                            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ins_ic_two_wheeler));
                                        }
                                    } else if (str.equals(Q)) {
                                        TextView textView2 = this.y;
                                        if (textView2 == null) {
                                            k.a("titleTextView");
                                        }
                                        textView2.setText(getString(R.string.two_wheeler_insurance_purchased));
                                        ImageView imageView2 = this.z;
                                        if (imageView2 == null) {
                                            k.a("insuranceLogoImageView");
                                        }
                                        imageView2.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ins_ic_two_wheeler));
                                    }
                                } else if (str.equals("13")) {
                                    TextView textView3 = this.y;
                                    if (textView3 == null) {
                                        k.a("titleTextView");
                                    }
                                    textView3.setText(getString(R.string.two_wheeler_insurance_purchased));
                                    ImageView imageView3 = this.z;
                                    if (imageView3 == null) {
                                        k.a("insuranceLogoImageView");
                                    }
                                    imageView3.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ins_ic_two_wheeler));
                                }
                            } else if (str.equals("9")) {
                                TextView textView4 = this.y;
                                if (textView4 == null) {
                                    k.a("titleTextView");
                                }
                                textView4.setText(getString(R.string.car_insurance_purchased));
                                ImageView imageView4 = this.z;
                                if (imageView4 == null) {
                                    k.a("insuranceLogoImageView");
                                }
                                imageView4.setImageDrawable(androidx.core.content.b.a(context, R.drawable.car_insurance_logo));
                            }
                        }
                        ImageView imageView5 = this.n;
                        if (imageView5 == null) {
                            k.a("ivShare");
                        }
                        imageView5.setOnClickListener(new b(this));
                        LottieAnimationView lottieAnimationView = this.f13539g;
                        if (lottieAnimationView == null) {
                            k.a("mAnimSuccesView");
                        }
                        lottieAnimationView.setAnimation("payment-success.json");
                        LottieAnimationView lottieAnimationView2 = this.f13539g;
                        if (lottieAnimationView2 == null) {
                            k.a("mAnimSuccesView");
                        }
                        lottieAnimationView2.loop(true);
                        new Handler().postDelayed(new c(this), this.f13540h);
                        View findViewById15 = findViewById(R.id.contact_us_view);
                        k.a((Object) findViewById15, "findViewById(R.id.contact_us_view)");
                        this.C = (RelativeLayout) findViewById15;
                        RelativeLayout relativeLayout = this.C;
                        if (relativeLayout == null) {
                            k.a("rlContactUs");
                        }
                        relativeLayout.setOnClickListener(new d(this));
                        View findViewById16 = findViewById(R.id.tv_transaction_text);
                        k.a((Object) findViewById16, "findViewById(R.id.tv_transaction_text)");
                        this.D = (TextView) findViewById16;
                        if (this.w) {
                            ImageView imageView6 = (ImageView) a(R.id.ivBackBtn);
                            k.a((Object) imageView6, "ivBackBtn");
                            imageView6.setVisibility(0);
                            ((ImageView) a(R.id.ivBackBtn)).setOnClickListener(new e(this));
                        }
                        a(this.f13535c);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.insurance.b.c.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13542a;

        b(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13542a = insuranceOrderSummary;
        }

        public final void onClick(View view) {
            InsuranceOrderSummary insuranceOrderSummary = this.f13542a;
            if (Build.VERSION.SDK_INT < 23 || !s.a() || insuranceOrderSummary == null || insuranceOrderSummary.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/png");
                    intent.putExtra("android.intent.extra.SUBJECT", insuranceOrderSummary.getString(R.string.post_payment_share_subject));
                    intent.putExtra("android.intent.extra.TEXT", insuranceOrderSummary.f13534a);
                    View findViewById = insuranceOrderSummary.findViewById(R.id.lnr_details_layout);
                    k.a((Object) findViewById, "findViewById<View>(R.id.lnr_details_layout)");
                    k.c(findViewById, "view");
                    Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
                    findViewById.draw(new Canvas(createBitmap));
                    k.a((Object) createBitmap, "bitmap");
                    String insertImage = MediaStore.Images.Media.insertImage(insuranceOrderSummary.getContentResolver(), createBitmap, insuranceOrderSummary.getString(R.string.title), (String) null);
                    if (insertImage != null) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                        Intent createChooser = Intent.createChooser(intent, insuranceOrderSummary.getString(R.string.post_payment_share_title));
                        if (createChooser.resolveActivity(insuranceOrderSummary.getPackageManager()) != null) {
                            insuranceOrderSummary.startActivity(createChooser);
                        } else {
                            Toast.makeText(insuranceOrderSummary, insuranceOrderSummary.getString(R.string.no_app_found), 1).show();
                        }
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            } else {
                s.b((Activity) insuranceOrderSummary);
                Toast.makeText(insuranceOrderSummary, insuranceOrderSummary.getString(R.string.permission_not_granted), 0).show();
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13543a;

        c(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13543a = insuranceOrderSummary;
        }

        public final void run() {
            InsuranceOrderSummary.a(this.f13543a).playAnimation();
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13544a;

        d(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13544a = insuranceOrderSummary;
        }

        public final void onClick(View view) {
            net.one97.paytm.insurance.common.a.a aVar;
            InsuranceOrderSummary insuranceOrderSummary = this.f13544a;
            CJROrderSummary c2 = insuranceOrderSummary.G;
            if (c2 != null) {
                a.C0191a aVar2 = net.one97.paytm.insurance.common.a.a.f13991c;
                aVar = a.C0191a.a(c2);
            } else {
                aVar = null;
            }
            insuranceOrderSummary.J = aVar;
            net.one97.paytm.insurance.common.a.a b2 = this.f13544a.J;
            if (b2 != null) {
                b2.a(InsuranceOrderSummary.d(this.f13544a), this.f13544a.getSupportFragmentManager());
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13546a;

        e(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13546a = insuranceOrderSummary;
        }

        public final void onClick(View view) {
            this.f13546a.onBackPressed();
        }
    }

    public final void a(float f2) {
        net.one97.paytm.common.widgets.c cVar;
        View view;
        AppCompatRatingBar appCompatRatingBar;
        View view2;
        ImageView imageView;
        View view3;
        TextView textView;
        View view4;
        TextView textView2;
        Context context = this;
        com.paytm.utility.b.x(context, "is_app_rated");
        net.one97.paytm.insurance.b.c.a().sendNewCustomGTMEvents(getApplicationContext(), "app_rating", String.valueOf(Math.round(f2)), "Insurance", (String) null, (String) null, (String) null, "app_rating");
        if (f2 < 5.0f) {
            com.paytm.utility.b.a(getApplicationContext(), "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(getApplicationContext(), "app_rating_5_star_timestamp", 0);
            net.one97.paytm.common.widgets.c cVar2 = this.K;
            if (!(cVar2 == null || (view4 = cVar2.getView()) == null || (textView2 = (TextView) view4.findViewById(net.one97.paytm.common.widgets.R.id.tv_msg)) == null)) {
                textView2.setText(getString(net.one97.paytm.common.widgets.R.string.feedback_thanks_msg));
            }
            net.one97.paytm.common.widgets.c cVar3 = this.K;
            if (!(cVar3 == null || (view3 = cVar3.getView()) == null || (textView = (TextView) view3.findViewById(net.one97.paytm.common.widgets.R.id.tv_sub_msg)) == null)) {
                textView.setVisibility(8);
            }
            net.one97.paytm.common.widgets.c cVar4 = this.K;
            if (!(cVar4 == null || (view2 = cVar4.getView()) == null || (imageView = (ImageView) view2.findViewById(net.one97.paytm.common.widgets.R.id.iv_close_icon)) == null)) {
                imageView.setVisibility(8);
            }
            net.one97.paytm.common.widgets.c cVar5 = this.K;
            if (!(cVar5 == null || (view = cVar5.getView()) == null || (appCompatRatingBar = (AppCompatRatingBar) view.findViewById(net.one97.paytm.common.widgets.R.id.ratingBar)) == null)) {
                appCompatRatingBar.setRating(f2);
            }
            k.a((Object) net.one97.paytm.insurance.b.a.a(), "GTMHelper.getInstance()");
            new Handler().postDelayed(new j(this), net.one97.paytm.insurance.b.a.c());
        } else {
            com.paytm.utility.b.a(getApplicationContext(), "app_rating_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
            if (!isFinishing() && (cVar = this.K) != null) {
                cVar.dismiss();
            }
            com.paytm.utility.b.ai(context);
        }
        com.paytm.utility.b.a(getApplicationContext(), "app_rating_not_now_timestamp", 0);
    }

    public final void a() {
        net.one97.paytm.common.widgets.c cVar;
        com.paytm.utility.b.a(getApplicationContext(), "app_rating_not_now_timestamp", System.currentTimeMillis());
        com.paytm.utility.b.a(getApplicationContext(), "app_rating_5_star_timestamp", 0);
        com.paytm.utility.b.a(getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
        net.one97.paytm.insurance.b.c.a().sendNewCustomGTMEvents(getApplicationContext(), "app_rating", "cross_button_clicked", "Insurance", (String) null, (String) null, (String) null, "app_rating");
        net.one97.paytm.common.widgets.c cVar2 = this.K;
        Boolean bool = null;
        Boolean valueOf = cVar2 != null ? Boolean.valueOf(cVar2.isAdded()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            net.one97.paytm.common.widgets.c cVar3 = this.K;
            if (cVar3 != null) {
                bool = Boolean.valueOf(cVar3.isVisible());
            }
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue() && (cVar = this.K) != null) {
                cVar.dismiss();
            }
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13553a;

        j(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13553a = insuranceOrderSummary;
        }

        public final void run() {
            net.one97.paytm.common.widgets.c e2 = this.f13553a.K;
            if (e2 != null) {
                e2.dismiss();
            }
        }
    }

    private final void f() {
        ScrollView scrollView = (ScrollView) a(R.id.scroll_view_parent);
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
    }

    private final void a(String str) {
        f();
        a(true);
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
        k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
        sb.append(a2.getOrderDetailUrl());
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        Context context = this.f13536d;
        if (context == null) {
            k.a("context");
        }
        sb3.append(com.paytm.utility.b.b(context, sb2));
        sb3.append("&actions=1");
        String sb4 = sb3.toString();
        com.paytm.network.b bVar = new com.paytm.network.b();
        Context context2 = this.f13536d;
        if (context2 == null) {
            k.a("context");
        }
        com.paytm.network.a l2 = bVar.a(context2).a(a.C0715a.GET).a(a.c.INSURANCE).a(sb4).b((String) null).a((Map<String, String>) null).a((IJRPaytmDataModel) new CJROrderSummary()).c("InsuranceOrderSummary").a((com.paytm.network.listener.b) this).a(a.b.SILENT).l();
        if (l2 != null) {
            l2.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0101, code lost:
        r2 = (r2 = r2.get(0)).getFullFillmentOject();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.common.entity.shopping.CJROrderSummary r15) {
        /*
            r14 = this;
            boolean r0 = r14.isFinishing()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r14.L = r15
            if (r15 == 0) goto L_0x0235
            java.util.ArrayList r0 = r15.getOrderedCartList()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r2 = "orderSummary.orderedCartList.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getItemStatus()
            if (r0 == 0) goto L_0x0235
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getItemStatus()
            java.util.ArrayList r2 = r15.getOrderedCartList()
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            java.lang.String r3 = "orderSummary.orderedCart…get(0).getProductDetail()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.getBrandName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x006d
            java.util.ArrayList r2 = r15.getOrderedCartList()
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.getBrandName()
            java.lang.String r3 = "orderSummary.orderedCart…ProductDetail().brandName"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r14.f13534a = r2
        L_0x006d:
            java.lang.String r2 = "orderStatus"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r2 = d((java.lang.String) r0)
            java.lang.String r3 = "orderSummary?.orderedCartList.get(0)"
            if (r2 != 0) goto L_0x0213
            boolean r2 = e((java.lang.String) r0)
            java.lang.String r4 = "insurance_type_2w"
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x00e0
            java.lang.String r0 = "ins_failed"
            r14.F = r0
            f.a.a r0 = f.a.a.f13515a
            java.lang.String r0 = f.a.a.b()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            if (r0 == 0) goto L_0x0098
            r14.i()
            goto L_0x009b
        L_0x0098:
            r14.h()
        L_0x009b:
            r14.d((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r0 = r15.getRefund()
            java.lang.String r2 = "orderSummary?.refund"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c3
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r0 = r15.getRefund()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r5 = r0.getMessage()
            java.lang.String r0 = "orderSummary?.refund.message"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
        L_0x00c3:
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getStatusText()
            double r1 = r15.getGrandTotal()
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r14.a((java.lang.String) r0, (java.lang.String) r15, (java.lang.String) r5)
            return
        L_0x00e0:
            boolean r2 = b((java.lang.String) r0)
            r6 = 0
            if (r2 == 0) goto L_0x0147
            boolean r2 = r14.w
            if (r2 == 0) goto L_0x0147
            r14.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            java.util.ArrayList r2 = r15.getOrderedCartList()
            if (r2 == 0) goto L_0x010c
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2
            if (r2 == 0) goto L_0x010c
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r2 = r2.getFullFillmentOject()
            if (r2 == 0) goto L_0x010c
            java.lang.String r2 = r2.getFulfillmentResponse()
            goto L_0x010d
        L_0x010c:
            r2 = r6
        L_0x010d:
            java.lang.Class<net.one97.paytm.model.b> r4 = net.one97.paytm.model.b.class
            java.lang.Object r0 = r0.a((java.lang.String) r2, r4)
            net.one97.paytm.model.b r0 = (net.one97.paytm.model.b) r0
            if (r0 == 0) goto L_0x011a
            java.lang.String r2 = r0.f14195e
            goto L_0x011b
        L_0x011a:
            r2 = r6
        L_0x011b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x012a
            if (r0 == 0) goto L_0x0129
            java.lang.String r0 = r0.f14195e
            r5 = r0
            goto L_0x012a
        L_0x0129:
            r5 = r6
        L_0x012a:
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getStatusText()
            double r1 = r15.getGrandTotal()
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r14.a((java.lang.String) r0, (java.lang.String) r15, (java.lang.String) r5)
            return
        L_0x0147:
            boolean r0 = b((java.lang.String) r0)
            if (r0 == 0) goto L_0x01f3
            r14.d((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            java.lang.String r0 = "successful"
            r14.F = r0
            f.a.a r0 = f.a.a.f13515a
            java.lang.String r0 = f.a.a.b()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            if (r0 == 0) goto L_0x0164
            r14.i()
            goto L_0x0167
        L_0x0164:
            r14.h()
        L_0x0167:
            net.one97.paytm.model.b r0 = r14.u
            if (r0 == 0) goto L_0x016e
            java.lang.String r0 = r0.f14195e
            goto L_0x016f
        L_0x016e:
            r0 = r6
        L_0x016f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0180
            net.one97.paytm.model.b r0 = r14.u
            if (r0 == 0) goto L_0x017f
            java.lang.String r0 = r0.f14195e
            r5 = r0
            goto L_0x0180
        L_0x017f:
            r5 = r6
        L_0x0180:
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getStatusText()
            double r1 = r15.getGrandTotal()
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r14.a((java.lang.String) r0, (java.lang.String) r15, (java.lang.String) r5)
            boolean r15 = r14.w
            if (r15 != 0) goto L_0x0212
            net.one97.paytm.common.widgets.c r15 = r14.K
            if (r15 != 0) goto L_0x0212
            android.content.Context r7 = r14.f13536d
            if (r7 != 0) goto L_0x01ad
            java.lang.String r15 = "context"
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x01ad:
            net.one97.paytm.insurance.b.a r15 = net.one97.paytm.insurance.b.a.a()
            java.lang.String r0 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            long r8 = net.one97.paytm.insurance.b.a.d()
            net.one97.paytm.insurance.b.a r15 = net.one97.paytm.insurance.b.a.a()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            long r10 = net.one97.paytm.insurance.b.a.e()
            net.one97.paytm.insurance.b.a r15 = net.one97.paytm.insurance.b.a.a()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            long r12 = net.one97.paytm.insurance.b.a.f()
            boolean r15 = com.paytm.utility.b.a((android.content.Context) r7, (long) r8, (long) r10, (long) r12)
            if (r15 == 0) goto L_0x0212
            net.one97.paytm.common.widgets.c r15 = new net.one97.paytm.common.widgets.c
            r15.<init>()
            r14.K = r15
            net.one97.paytm.common.widgets.c r15 = r14.K
            if (r15 == 0) goto L_0x01e7
            r0 = r14
            net.one97.paytm.common.widgets.a.a r0 = (net.one97.paytm.common.widgets.a.a) r0
            r15.a((net.one97.paytm.common.widgets.a.a) r0)
        L_0x01e7:
            net.one97.paytm.common.widgets.c r15 = r14.K
            if (r15 == 0) goto L_0x01f2
            androidx.fragment.app.j r0 = r14.getSupportFragmentManager()
            r15.show((androidx.fragment.app.j) r0, (java.lang.String) r6)
        L_0x01f2:
            return
        L_0x01f3:
            r14.d((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getStatusText()
            double r1 = r15.getGrandTotal()
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r14.a((java.lang.String) r0, (java.lang.String) r15)
        L_0x0212:
            return
        L_0x0213:
            r14.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            r14.d((net.one97.paytm.common.entity.shopping.CJROrderSummary) r15)
            java.util.ArrayList r0 = r15.getOrderedCartList()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getStatusText()
            double r1 = r15.getGrandTotal()
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r14.a((java.lang.String) r0, (java.lang.String) r15)
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.InsuranceOrderSummary.a(net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }

    private final void a(String str, String str2, String str3) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.t;
            if (textView == null) {
                k.a("tvStatus");
            }
            textView.setText(charSequence);
        } else {
            TextView textView2 = this.t;
            if (textView2 == null) {
                k.a("tvStatus");
            }
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            TextView textView3 = this.k;
            if (textView3 == null) {
                k.a("mAmountTv");
            }
            textView3.setText(getString(R.string.ins_rupee_symbol_10) + str2);
        } else {
            TextView textView4 = this.k;
            if (textView4 == null) {
                k.a("mAmountTv");
            }
            textView4.setVisibility(8);
        }
        CharSequence charSequence2 = str3;
        if (!TextUtils.isEmpty(charSequence2)) {
            TextView textView5 = this.D;
            if (textView5 == null) {
                k.a("paymentText");
            }
            textView5.setText(charSequence2);
            TextView textView6 = this.D;
            if (textView6 == null) {
                k.a("paymentText");
            }
            textView6.setVisibility(0);
            return;
        }
        TextView textView7 = this.D;
        if (textView7 == null) {
            k.a("paymentText");
        }
        textView7.setVisibility(8);
    }

    private final void a(String str, String str2) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.t;
            if (textView == null) {
                k.a("tvStatus");
            }
            textView.setText(charSequence);
        } else {
            TextView textView2 = this.t;
            if (textView2 == null) {
                k.a("tvStatus");
            }
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            TextView textView3 = this.k;
            if (textView3 == null) {
                k.a("mAmountTv");
            }
            textView3.setText(getString(R.string.ins_rupee_symbol_10) + str2);
        } else {
            TextView textView4 = this.k;
            if (textView4 == null) {
                k.a("mAmountTv");
            }
            textView4.setVisibility(8);
        }
        TextView textView5 = this.D;
        if (textView5 == null) {
            k.a("paymentText");
        }
        textView5.setVisibility(8);
    }

    private static boolean b(String str) {
        return p.a(N, str, true);
    }

    private final void b(CJROrderSummary cJROrderSummary) {
        if (!this.A) {
            this.l = true;
            new Handler().postDelayed(new f(this), (long) this.f13538f);
        }
        new Handler().postDelayed(new g(this, cJROrderSummary), (long) this.f13537e);
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13547a;

        f(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13547a = insuranceOrderSummary;
        }

        public final void run() {
            this.f13547a.B = true;
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f13549b;

        g(InsuranceOrderSummary insuranceOrderSummary, CJROrderSummary cJROrderSummary) {
            this.f13548a = insuranceOrderSummary;
            this.f13549b = cJROrderSummary;
        }

        public final void run() {
            InsuranceOrderSummary.g(this.f13548a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        r4 = (r4 = (r4 = r15.getOrderedCartList()).get(0)).getFullFillmentOject();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c(net.one97.paytm.common.entity.shopping.CJROrderSummary r15) {
        /*
            r14 = this;
            int r0 = net.one97.paytm.insurance.R.id.my_order_success
            android.view.View r0 = r14.findViewById(r0)
            java.lang.String r1 = "findViewById<LinearLayout>(R.id.my_order_success)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1 = 0
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r14.x
            if (r0 != 0) goto L_0x001a
            java.lang.String r2 = "llPostPaymentSuccess"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001a:
            r2 = 8
            r0.setVisibility(r2)
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            r3 = 0
            if (r15 == 0) goto L_0x0040
            java.util.ArrayList r4 = r15.getOrderedCartList()
            if (r4 == 0) goto L_0x0040
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x0041
        L_0x0040:
            r4 = r3
        L_0x0041:
            java.lang.Class<net.one97.paytm.model.b> r5 = net.one97.paytm.model.b.class
            java.lang.Object r0 = r0.a((java.lang.String) r4, r5)
            net.one97.paytm.model.b r0 = (net.one97.paytm.model.b) r0
            if (r0 != 0) goto L_0x004c
            return
        L_0x004c:
            java.lang.String r4 = r0.f14192b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "findViewById<TextView>(R.id.tvPolicyNum)"
            if (r4 != 0) goto L_0x0079
            int r4 = net.one97.paytm.insurance.R.id.tvPolicyNum
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = r0.f14192b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            int r4 = net.one97.paytm.insurance.R.id.tvPolicyNum
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r1)
            goto L_0x0087
        L_0x0079:
            int r4 = net.one97.paytm.insurance.R.id.tvPolicyNum
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
        L_0x0087:
            if (r15 == 0) goto L_0x00a2
            java.util.ArrayList r4 = r15.getOrderedCartList()
            if (r4 == 0) goto L_0x00a2
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x00a2
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r4.getProductDetail()
            if (r4 == 0) goto L_0x00a2
            java.lang.String r4 = r4.getBrandName()
            goto L_0x00a3
        L_0x00a2:
            r4 = r3
        L_0x00a3:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00da
            int r4 = net.one97.paytm.insurance.R.id.name_tv_MO
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00ea
            if (r15 == 0) goto L_0x00d0
            java.util.ArrayList r5 = r15.getOrderedCartList()
            if (r5 == 0) goto L_0x00d0
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x00d0
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r5.getProductDetail()
            if (r5 == 0) goto L_0x00d0
            java.lang.String r5 = r5.getBrandName()
            goto L_0x00d1
        L_0x00d0:
            r5 = r3
        L_0x00d1:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            r4.setVisibility(r1)
            goto L_0x00ea
        L_0x00da:
            int r4 = net.one97.paytm.insurance.R.id.name_tv_MO
            android.view.View r4 = r14.findViewById(r4)
            java.lang.String r5 = "findViewById<TextView>(R.id.name_tv_MO)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
        L_0x00ea:
            if (r15 == 0) goto L_0x0105
            java.util.ArrayList r4 = r15.getOrderedCartList()
            if (r4 == 0) goto L_0x0105
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x0105
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r4.getProductDetail()
            if (r4 == 0) goto L_0x0105
            java.lang.String r4 = r4.getImageUrl()
            goto L_0x0106
        L_0x0105:
            r4 = r3
        L_0x0106:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "context"
            java.lang.String r6 = "findViewById<ImageView>(R.id.ivInsurerLogo_MO)"
            if (r4 != 0) goto L_0x0178
            com.squareup.picasso.w r4 = com.squareup.picasso.w.a()
            if (r15 == 0) goto L_0x0131
            java.util.ArrayList r7 = r15.getOrderedCartList()
            if (r7 == 0) goto L_0x0131
            java.lang.Object r7 = r7.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r7
            if (r7 == 0) goto L_0x0131
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r7.getProductDetail()
            if (r7 == 0) goto L_0x0131
            java.lang.String r7 = r7.getImageUrl()
            goto L_0x0132
        L_0x0131:
            r7 = r3
        L_0x0132:
            com.squareup.picasso.aa r4 = r4.a((java.lang.String) r7)
            r7 = r14
            android.content.Context r7 = (android.content.Context) r7
            int r8 = net.one97.paytm.insurance.R.drawable.ins_ic_default_bank
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r8)
            if (r7 != 0) goto L_0x0144
            kotlin.g.b.k.a()
        L_0x0144:
            com.squareup.picasso.aa r4 = r4.a((android.graphics.drawable.Drawable) r7)
            android.content.Context r7 = r14.f13536d
            if (r7 != 0) goto L_0x014f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x014f:
            int r8 = net.one97.paytm.insurance.R.drawable.ins_ic_default_bank
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r8)
            if (r7 != 0) goto L_0x015a
            kotlin.g.b.k.a()
        L_0x015a:
            com.squareup.picasso.aa r4 = r4.b((android.graphics.drawable.Drawable) r7)
            int r7 = net.one97.paytm.insurance.R.id.ivInsurerLogo_MO
            android.view.View r7 = r14.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r4.a((android.widget.ImageView) r7)
            int r4 = net.one97.paytm.insurance.R.id.ivInsurerLogo_MO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r4.setVisibility(r1)
            goto L_0x0186
        L_0x0178:
            int r4 = net.one97.paytm.insurance.R.id.ivInsurerLogo_MO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r4.setVisibility(r2)
        L_0x0186:
            int r4 = net.one97.paytm.insurance.R.id.tvDownloadPolicy
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.x$e r6 = new kotlin.g.b.x$e
            r6.<init>()
            java.lang.String r7 = ""
            r6.element = r7
            r8 = 1
            if (r15 == 0) goto L_0x021e
            java.util.ArrayList r9 = r15.getOrderedCartList()
            if (r9 == 0) goto L_0x021e
            java.lang.Object r9 = r9.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9
            if (r9 == 0) goto L_0x021e
            java.util.ArrayList r9 = r9.getAction()
            if (r9 == 0) goto L_0x021e
            java.util.ArrayList r9 = r15.getOrderedCartList()
            if (r9 == 0) goto L_0x01c1
            java.lang.Object r9 = r9.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9
            if (r9 == 0) goto L_0x01c1
            java.util.ArrayList r9 = r9.getAction()
            goto L_0x01c2
        L_0x01c1:
            r9 = r3
        L_0x01c2:
            if (r9 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            java.util.Iterator r9 = r9.iterator()
        L_0x01cb:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x021e
            java.lang.Object r10 = r9.next()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r10 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r10
            java.lang.String r11 = "element"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = r10.getActionName()
            java.lang.String r12 = "invoice"
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r12, (boolean) r8)
            if (r11 == 0) goto L_0x01cb
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r10 = r10.getUrlParams()
            if (r10 == 0) goto L_0x01f3
            java.lang.String r10 = r10.getUrl()
            goto L_0x01f4
        L_0x01f3:
            r10 = r3
        L_0x01f4:
            r6.element = r10
            T r10 = r6.element
            java.lang.String r10 = (java.lang.String) r10
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "&sso_token="
            r11.<init>(r12)
            net.one97.paytm.insurance.a.a r12 = net.one97.paytm.insurance.b.c.a()
            android.content.Context r13 = r14.f13536d
            if (r13 != 0) goto L_0x020c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x020c:
            java.lang.String r12 = r12.getSSOToken(r13)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r10 = kotlin.g.b.k.a((java.lang.String) r10, (java.lang.Object) r11)
            r6.element = r10
            goto L_0x01cb
        L_0x021e:
            T r5 = r6.element
            java.lang.String r5 = (java.lang.String) r5
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r9 = "tvDownloadPdf"
            if (r5 != 0) goto L_0x023d
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            r4.setVisibility(r1)
            net.one97.paytm.InsuranceOrderSummary$h r5 = new net.one97.paytm.InsuranceOrderSummary$h
            r5.<init>(r14, r6)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            goto L_0x0243
        L_0x023d:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            r4.setVisibility(r2)
        L_0x0243:
            java.lang.String r4 = r0.f14191a
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "findViewById<TextView>(R.id.tvVehicleNumMO)"
            if (r4 != 0) goto L_0x0282
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r9 = net.one97.paytm.insurance.R.string.for_vehicle_num
            java.lang.String r9 = r14.getString(r9)
            r6.append(r9)
            java.lang.String r9 = r0.f14191a
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r1)
            goto L_0x0290
        L_0x0282:
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
        L_0x0290:
            if (r15 == 0) goto L_0x02a3
            java.util.ArrayList r4 = r15.getOrderedCartList()
            if (r4 == 0) goto L_0x02a3
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x02a3
            java.lang.Object r4 = r4.mMetaDataResponse
            goto L_0x02a4
        L_0x02a3:
            r4 = r3
        L_0x02a4:
            if (r4 == 0) goto L_0x033a
            net.one97.paytm.model.MetaData r4 = new net.one97.paytm.model.MetaData
            r4.<init>()
            if (r15 == 0) goto L_0x02be
            java.util.ArrayList r6 = r15.getOrderedCartList()
            if (r6 == 0) goto L_0x02be
            java.lang.Object r6 = r6.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            if (r6 == 0) goto L_0x02be
            java.lang.Object r6 = r6.mMetaDataResponse
            goto L_0x02bf
        L_0x02be:
            r6 = r3
        L_0x02bf:
            com.google.gsonhtcfix.b.g r6 = (com.google.gsonhtcfix.b.g) r6
            net.one97.paytm.model.MetaData r4 = r4.createFromObject(r6)
            java.lang.String r6 = "MetaData().createFromObj… as LinkedTreeMap<*, *>?)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r6 = r4.vehicleNo
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x032b
            int r6 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r6 = r14.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.insurance.R.string.for_vehicle_num
            java.lang.String r10 = r14.getString(r10)
            r9.append(r10)
            java.lang.String r4 = r4.vehicleNo
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r6.setText(r4)
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r9 = net.one97.paytm.insurance.R.string.for_vehicle_num
            java.lang.String r9 = r14.getString(r9)
            r6.append(r9)
            java.lang.String r9 = r0.f14191a
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r1)
            goto L_0x0348
        L_0x032b:
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
            goto L_0x0348
        L_0x033a:
            int r4 = net.one97.paytm.insurance.R.id.tvVehicleNumMO
            android.view.View r4 = r14.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
        L_0x0348:
            java.lang.String r4 = r0.f14193c
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x035d
            java.lang.String r4 = r0.f14193c
            if (r4 != 0) goto L_0x0359
            kotlin.g.b.k.a()
        L_0x0359:
            java.lang.String r7 = c((java.lang.String) r4)
        L_0x035d:
            java.lang.String r4 = r0.f14194d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = " "
            if (r4 != 0) goto L_0x0392
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            r4.append(r5)
            int r6 = net.one97.paytm.insurance.R.string.to
            java.lang.String r6 = r14.getString(r6)
            r4.append(r6)
            r4.append(r5)
            java.lang.String r0 = r0.f14194d
            if (r0 != 0) goto L_0x0387
            kotlin.g.b.k.a()
        L_0x0387:
            java.lang.String r0 = c((java.lang.String) r0)
            r4.append(r0)
            java.lang.String r7 = r4.toString()
        L_0x0392:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r4 = "findViewById<TextView>(R.id.tvInsurancePeriod)"
            if (r0 != 0) goto L_0x03b9
            int r0 = net.one97.paytm.insurance.R.id.tvInsurancePeriod
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setText(r7)
            int r0 = net.one97.paytm.insurance.R.id.tvInsurancePeriod
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            goto L_0x03c7
        L_0x03b9:
            int r0 = net.one97.paytm.insurance.R.id.tvInsurancePeriod
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
        L_0x03c7:
            if (r15 == 0) goto L_0x03ce
            java.lang.String r0 = r15.getId()
            goto L_0x03cf
        L_0x03ce:
            r0 = r3
        L_0x03cf:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r4 = "findViewById<TextView>(R.id.tvOrderID)"
            if (r0 != 0) goto L_0x041e
            int r0 = net.one97.paytm.insurance.R.id.tvOrderID
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.aa r6 = kotlin.g.b.aa.f47921a
            int r6 = net.one97.paytm.insurance.R.string.order_id_with_value_and_colon
            java.lang.String r6 = r14.getString(r6)
            java.lang.String r7 = "getString(R.string.order_id_with_value_and_colon)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            if (r15 == 0) goto L_0x03fa
            java.lang.String r9 = r15.getId()
            goto L_0x03fb
        L_0x03fa:
            r9 = r3
        L_0x03fb:
            r7[r1] = r9
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r8)
            java.lang.String r6 = java.lang.String.format(r6, r7)
            java.lang.String r7 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            int r0 = net.one97.paytm.insurance.R.id.tvOrderID
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            goto L_0x042c
        L_0x041e:
            int r0 = net.one97.paytm.insurance.R.id.tvOrderID
            android.view.View r0 = r14.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
        L_0x042c:
            if (r15 == 0) goto L_0x0433
            java.lang.String r0 = r15.getCreatedAt()
            goto L_0x0434
        L_0x0433:
            r0 = r3
        L_0x0434:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04bb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r15 == 0) goto L_0x0448
            java.lang.String r1 = r15.getCreatedAt()
            goto L_0x0449
        L_0x0448:
            r1 = r3
        L_0x0449:
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r4 = "Locale.US"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r6 = "hh:mm a"
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r6, (java.util.Locale) r2)
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            if (r15 == 0) goto L_0x0465
            java.lang.String r1 = r15.getCreatedAt()
            goto L_0x0466
        L_0x0465:
            r1 = r3
        L_0x0466:
            java.util.Locale r2 = java.util.Locale.US
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r6 = "d"
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r6, (java.util.Locale) r2)
            r0.append(r1)
            r0.append(r5)
            if (r15 == 0) goto L_0x047e
            java.lang.String r1 = r15.getCreatedAt()
            goto L_0x047f
        L_0x047e:
            r1 = r3
        L_0x047f:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r6 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r6 = "MMM"
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r6, (java.util.Locale) r2)
            r0.append(r1)
            r0.append(r5)
            if (r15 == 0) goto L_0x049a
            java.lang.String r3 = r15.getCreatedAt()
        L_0x049a:
            java.util.Locale r15 = java.util.Locale.US
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r4)
            java.lang.String r1 = "yyyy"
            java.lang.String r15 = a((java.lang.String) r3, (java.lang.String) r1, (java.util.Locale) r15)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            int r0 = net.one97.paytm.insurance.R.id.tvTimeDateMyOrder
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.setText(r15)
            return
        L_0x04bb:
            int r15 = net.one97.paytm.insurance.R.id.tvTimeDateMyOrder
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r0 = "tvTimeDateMyOrder"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r15.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.InsuranceOrderSummary.c(net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f13551b;

        h(InsuranceOrderSummary insuranceOrderSummary, x.e eVar) {
            this.f13550a = insuranceOrderSummary;
            this.f13551b = eVar;
        }

        public final void onClick(View view) {
            try {
                InsuranceOrderSummary.a(this.f13550a, (String) this.f13551b.element);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r4 = (r4 = (r4 = r9.getOrderedCartList()).get(0)).getFullFillmentOject();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d(net.one97.paytm.common.entity.shopping.CJROrderSummary r9) {
        /*
            r8 = this;
            android.widget.LinearLayout r0 = r8.x
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "llPostPaymentSuccess"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            r1 = 0
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.insurance.R.id.my_order_success
            android.view.View r0 = r8.findViewById(r0)
            java.lang.String r2 = "findViewById<LinearLayout>(R.id.my_order_success)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r2 = 8
            r0.setVisibility(r2)
            if (r9 == 0) goto L_0x0024
            r9.getPaymentStatus()
        L_0x0024:
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            r3 = 0
            if (r9 == 0) goto L_0x0045
            java.util.ArrayList r4 = r9.getOrderedCartList()
            if (r4 == 0) goto L_0x0045
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x0045
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x0045
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x0046
        L_0x0045:
            r4 = r3
        L_0x0046:
            java.lang.Class<net.one97.paytm.model.b> r5 = net.one97.paytm.model.b.class
            java.lang.Object r0 = r0.a((java.lang.String) r4, r5)
            net.one97.paytm.model.b r0 = (net.one97.paytm.model.b) r0
            r8.u = r0
            if (r9 == 0) goto L_0x006b
            java.util.ArrayList r0 = r9.getOrderedCartList()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x006b
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = r0.getBrandName()
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r4 = "tvInsurerName"
            if (r0 != 0) goto L_0x009f
            android.widget.TextView r0 = r8.o
            if (r0 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x007d:
            if (r9 == 0) goto L_0x0098
            java.util.ArrayList r4 = r9.getOrderedCartList()
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x0098
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r4.getProductDetail()
            if (r4 == 0) goto L_0x0098
            java.lang.String r4 = r4.getBrandName()
            goto L_0x0099
        L_0x0098:
            r4 = r3
        L_0x0099:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            goto L_0x00a9
        L_0x009f:
            android.widget.TextView r0 = r8.o
            if (r0 != 0) goto L_0x00a6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00a6:
            r0.setVisibility(r2)
        L_0x00a9:
            if (r9 == 0) goto L_0x00c4
            java.util.ArrayList r0 = r9.getOrderedCartList()
            if (r0 == 0) goto L_0x00c4
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x00c4
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = r0.getImageUrl()
            goto L_0x00c5
        L_0x00c4:
            r0 = r3
        L_0x00c5:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x012b
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            if (r9 == 0) goto L_0x00ec
            java.util.ArrayList r4 = r9.getOrderedCartList()
            if (r4 == 0) goto L_0x00ec
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x00ec
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r4.getProductDetail()
            if (r4 == 0) goto L_0x00ec
            java.lang.String r4 = r4.getImageUrl()
            goto L_0x00ed
        L_0x00ec:
            r4 = r3
        L_0x00ed:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r4)
            android.content.Context r4 = r8.f13536d
            java.lang.String r5 = "context"
            if (r4 != 0) goto L_0x00fa
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00fa:
            int r6 = net.one97.paytm.insurance.R.drawable.ins_ic_default_bank
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r6)
            if (r4 != 0) goto L_0x0105
            kotlin.g.b.k.a()
        L_0x0105:
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r4)
            android.content.Context r4 = r8.f13536d
            if (r4 != 0) goto L_0x0110
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0110:
            int r5 = net.one97.paytm.insurance.R.drawable.ins_ic_default_bank
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            if (r4 != 0) goto L_0x011b
            kotlin.g.b.k.a()
        L_0x011b:
            com.squareup.picasso.aa r0 = r0.b((android.graphics.drawable.Drawable) r4)
            int r4 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0.a((android.widget.ImageView) r4)
            goto L_0x013b
        L_0x012b:
            int r0 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r0 = r8.findViewById(r0)
            java.lang.String r4 = "findViewById<ImageView>(R.id.ivInsurerLogo)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
        L_0x013b:
            if (r9 == 0) goto L_0x014e
            java.util.ArrayList r0 = r9.getOrderedCartList()
            if (r0 == 0) goto L_0x014e
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x014e
            java.lang.Object r0 = r0.mMetaDataResponse
            goto L_0x014f
        L_0x014e:
            r0 = r3
        L_0x014f:
            java.lang.String r4 = "tvVehicleNum"
            if (r0 == 0) goto L_0x01b0
            net.one97.paytm.model.MetaData r0 = new net.one97.paytm.model.MetaData
            r0.<init>()
            if (r9 == 0) goto L_0x016b
            java.util.ArrayList r5 = r9.getOrderedCartList()
            if (r5 == 0) goto L_0x016b
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x016b
            java.lang.Object r5 = r5.mMetaDataResponse
            goto L_0x016c
        L_0x016b:
            r5 = r3
        L_0x016c:
            com.google.gsonhtcfix.b.g r5 = (com.google.gsonhtcfix.b.g) r5
            net.one97.paytm.model.MetaData r0 = r0.createFromObject(r5)
            java.lang.String r5 = "MetaData().createFromObj… as LinkedTreeMap<*, *>?)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r5 = r0.vehicleNo
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01a5
            android.widget.TextView r5 = r8.p
            if (r5 != 0) goto L_0x0188
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0188:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r6 = net.one97.paytm.insurance.R.string.for_vehicle_num
            java.lang.String r6 = r8.getString(r6)
            r4.append(r6)
            java.lang.String r0 = r0.vehicleNo
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            goto L_0x01ba
        L_0x01a5:
            android.widget.TextView r0 = r8.p
            if (r0 != 0) goto L_0x01ac
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01ac:
            r0.setVisibility(r2)
            goto L_0x01ba
        L_0x01b0:
            android.widget.TextView r0 = r8.p
            if (r0 != 0) goto L_0x01b7
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01b7:
            r0.setVisibility(r2)
        L_0x01ba:
            if (r9 == 0) goto L_0x01c1
            java.lang.String r0 = r9.getId()
            goto L_0x01c2
        L_0x01c1:
            r0 = r3
        L_0x01c2:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r4 = "tvOrderId"
            if (r0 != 0) goto L_0x01ec
            android.widget.TextView r0 = r8.q
            if (r0 != 0) goto L_0x01d3
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01d3:
            int r4 = net.one97.paytm.insurance.R.string.order_id_with_value_and_colon
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            if (r9 == 0) goto L_0x01df
            java.lang.String r6 = r9.getId()
            goto L_0x01e0
        L_0x01df:
            r6 = r3
        L_0x01e0:
            r5[r1] = r6
            java.lang.String r4 = r8.getString(r4, r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            goto L_0x01f6
        L_0x01ec:
            android.widget.TextView r0 = r8.q
            if (r0 != 0) goto L_0x01f3
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01f3:
            r0.setVisibility(r2)
        L_0x01f6:
            if (r9 == 0) goto L_0x020b
            java.util.ArrayList r0 = r9.getOrderedCartList()
            if (r0 == 0) goto L_0x020b
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x020b
            java.lang.String r0 = r0.getItemStatus()
            goto L_0x020c
        L_0x020b:
            r0 = r3
        L_0x020c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x024b
            if (r9 == 0) goto L_0x0229
            java.util.ArrayList r0 = r9.getOrderedCartList()
            if (r0 == 0) goto L_0x0229
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x0229
            java.lang.String r0 = r0.getItemStatus()
            goto L_0x022a
        L_0x0229:
            r0 = r3
        L_0x022a:
            boolean r0 = b((java.lang.String) r0)
            if (r0 == 0) goto L_0x024b
            int r0 = net.one97.paytm.insurance.R.id.viewDetailsMyOrders
            android.view.View r0 = r8.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.viewDetailsMyOrders)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.s = r0
            android.widget.TextView r0 = r8.s
            if (r0 != 0) goto L_0x0248
            java.lang.String r1 = "tvViewDetails"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0248:
            r8.a((android.widget.TextView) r0)
        L_0x024b:
            if (r9 == 0) goto L_0x0252
            java.lang.String r0 = r9.getCreatedAt()
            goto L_0x0253
        L_0x0252:
            r0 = r3
        L_0x0253:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "tvTimeDate"
            if (r0 != 0) goto L_0x02dd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r9 == 0) goto L_0x0269
            java.lang.String r2 = r9.getCreatedAt()
            goto L_0x026a
        L_0x0269:
            r2 = r3
        L_0x026a:
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "Locale.US"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r6 = "hh:mm a"
            java.lang.String r2 = a((java.lang.String) r2, (java.lang.String) r6, (java.util.Locale) r4)
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            if (r9 == 0) goto L_0x0286
            java.lang.String r2 = r9.getCreatedAt()
            goto L_0x0287
        L_0x0286:
            r2 = r3
        L_0x0287:
            java.util.Locale r4 = java.util.Locale.US
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r6 = "d"
            java.lang.String r2 = a((java.lang.String) r2, (java.lang.String) r6, (java.util.Locale) r4)
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            if (r9 == 0) goto L_0x02a1
            java.lang.String r4 = r9.getCreatedAt()
            goto L_0x02a2
        L_0x02a1:
            r4 = r3
        L_0x02a2:
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r7 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = "MMM"
            java.lang.String r4 = a((java.lang.String) r4, (java.lang.String) r7, (java.util.Locale) r6)
            r0.append(r4)
            r0.append(r2)
            if (r9 == 0) goto L_0x02bd
            java.lang.String r3 = r9.getCreatedAt()
        L_0x02bd:
            java.util.Locale r9 = java.util.Locale.US
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r5)
            java.lang.String r2 = "yyyy"
            java.lang.String r9 = a((java.lang.String) r3, (java.lang.String) r2, (java.util.Locale) r9)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            android.widget.TextView r0 = r8.r
            if (r0 != 0) goto L_0x02d7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02d7:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            return
        L_0x02dd:
            android.widget.TextView r9 = r8.r
            if (r9 != 0) goto L_0x02e4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02e4:
            r9.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.InsuranceOrderSummary.d(net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }

    public static final class i extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceOrderSummary f13552a;

        i(InsuranceOrderSummary insuranceOrderSummary) {
            this.f13552a = insuranceOrderSummary;
        }

        public final void onClick(View view) {
            k.c(view, "textView");
            Intent intent = new Intent(InsuranceOrderSummary.d(this.f13552a), InsuranceOrderSummary.class);
            intent.putExtra("order_id", this.f13552a.f13535c);
            intent.putExtra("IS_MY_ORDER_SCREEN", true);
            intent.putExtra("insurance_type", this.f13552a.E);
            this.f13552a.startActivity(intent);
            this.f13552a.finish();
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    private final void a(TextView textView) {
        SpannableString spannableString = new SpannableString(getString(R.string.view_details_in_my_orders));
        spannableString.setSpan(new i(this), 16, 25, 33);
        if (textView != null) {
            textView.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void g() {
        try {
            Dialog dialog = this.f13541i;
            if (dialog == null) {
                k.a("mProgressDialog");
            }
            if (dialog != null) {
                Dialog dialog2 = this.f13541i;
                if (dialog2 == null) {
                    k.a("mProgressDialog");
                }
                if (dialog2.isShowing()) {
                    Dialog dialog3 = this.f13541i;
                    if (dialog3 == null) {
                        k.a("mProgressDialog");
                    }
                    dialog3.dismiss();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void a(boolean z2) {
        if (z2) {
            LottieAnimationView lottieAnimationView = this.H;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            net.one97.paytm.insurance.b.b.INSTANCE.setAnimation(this.H);
            TextView textView = this.y;
            if (textView == null) {
                k.a("titleTextView");
            }
            textView.setVisibility(8);
            TextView textView2 = (TextView) a(R.id.policy_insurer_tv);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = (TextView) a(R.id.tv_policy_num_title);
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = (TextView) a(R.id.tvDownloadPolicy);
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = (TextView) a(R.id.tvInsurancePeriod);
            if (textView5 != null) {
                textView5.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView6 = this.y;
        if (textView6 == null) {
            k.a("titleTextView");
        }
        textView6.setVisibility(0);
        TextView textView7 = (TextView) a(R.id.policy_insurer_tv);
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView2 = this.H;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
        net.one97.paytm.insurance.b.b.INSTANCE.stopAnimation(this.H);
    }

    private static String c(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        new SimpleDateFormat("MMM dd, yyyy");
        String format = new SimpleDateFormat("MMM dd, yyyy").format(parse);
        k.a((Object) format, "SimpleDateFormat(\"MMM dd, yyyy\").format(itemDate)");
        return format;
    }

    private static boolean d(String str) {
        return !N.equals(str) && !O.equals(str) && !P.equals(str) && !Q.equals(str);
    }

    private static boolean e(String str) {
        return O.equals(str) || P.equals(str) || Q.equals(str);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        if (this.v) {
            net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
            k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
            Intent intent = new Intent(this, a2.getLandingActivityClass());
            intent.setFlags(67108864);
            startActivity(intent);
        }
        finish();
    }

    private final void h() {
        try {
            HashMap hashMap = new HashMap(5);
            hashMap.put("event_category", "insurance_summary_Car Insurance");
            hashMap.put("event_action", "transaction_" + this.F);
            hashMap.put("vertical_name", "Buy Insurance");
            StringBuilder sb = new StringBuilder();
            f.a.a aVar = f.a.a.f13515a;
            String str = TextUtils.isEmpty(f.a.a.a()) ? "no" : H5AppHandler.CHECK_VALUE;
            sb.append("reg_num_given=" + str + ";");
            sb.append("reg_details_fetched=no;");
            sb.append("reg_details_correct=no;");
            sb.append("selected_from_recent=no;");
            sb.append("renewal_available=no;");
            sb.append("renewal_opted=no");
            hashMap.put("event_label2", sb.toString());
            net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
            k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
            if (com.paytm.utility.b.r(a2.getApplicationContext())) {
                net.one97.paytm.insurance.a.a a3 = net.one97.paytm.insurance.b.c.a();
                k.a((Object) a3, "InsuranceHelper.getInsuranceListener()");
                hashMap.put("user_id", com.paytm.utility.b.n(a3.getApplicationContext()));
            }
            net.one97.paytm.insurance.a.a a4 = net.one97.paytm.insurance.b.c.a();
            k.a((Object) a4, "InsuranceHelper.getInsuranceListener()");
            net.one97.paytm.insurance.b.c.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, a4.getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private final void i() {
        try {
            HashMap hashMap = new HashMap(5);
            hashMap.put("event_category", "insurance_summary_Twowheeler Insurance");
            hashMap.put("event_action", "transaction_" + this.F);
            hashMap.put("vertical_name", "Buy Insurance");
            StringBuilder sb = new StringBuilder();
            f.a.a aVar = f.a.a.f13515a;
            String str = TextUtils.isEmpty(f.a.a.a()) ? "no" : H5AppHandler.CHECK_VALUE;
            sb.append("reg_num_given=" + str + ";");
            sb.append("reg_details_fetched=no;");
            sb.append("reg_details_correct=no;");
            sb.append("selected_from_recent=no;");
            sb.append("renewal_available=no;");
            sb.append("renewal_opted=no");
            hashMap.put("event_label2", sb.toString());
            net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
            k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
            if (com.paytm.utility.b.r(a2.getApplicationContext())) {
                net.one97.paytm.insurance.a.a a3 = net.one97.paytm.insurance.b.c.a();
                k.a((Object) a3, "InsuranceHelper.getInsuranceListener()");
                hashMap.put("user_id", com.paytm.utility.b.n(a3.getApplicationContext()));
            }
            net.one97.paytm.insurance.a.a a4 = net.one97.paytm.insurance.b.c.a();
            k.a((Object) a4, "InsuranceHelper.getInsuranceListener()");
            net.one97.paytm.insurance.b.c.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, a4.getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private static String a(String str, String str2, Locale locale) {
        if (str != null) {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = charSequence.charAt(!z2 ? i2 : length) <= ' ';
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (!z3) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            if (charSequence.subSequence(i2, length + 1).toString().length() > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = null;
                try {
                    date = simpleDateFormat.parse(str);
                } catch (ParseException e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2, locale);
                if (date != null) {
                    String format = simpleDateFormat2.format(date);
                    k.a((Object) format, "S.format(date)");
                    return format;
                }
            }
        }
        return "";
    }

    public static final /* synthetic */ void g(InsuranceOrderSummary insuranceOrderSummary) {
        if (!insuranceOrderSummary.B) {
            insuranceOrderSummary.a(insuranceOrderSummary.f13535c);
        }
    }

    public static final /* synthetic */ void a(InsuranceOrderSummary insuranceOrderSummary, String str) {
        try {
            if (insuranceOrderSummary.f13541i == null) {
                Dialog walletStyleProgressDialog = net.one97.paytm.insurance.b.c.a().getWalletStyleProgressDialog(insuranceOrderSummary);
                k.a((Object) walletStyleProgressDialog, "InsuranceHelper.getInsur…StyleProgressDialog(this)");
                insuranceOrderSummary.f13541i = walletStyleProgressDialog;
            }
            Dialog dialog = insuranceOrderSummary.f13541i;
            if (dialog == null) {
                k.a("mProgressDialog");
            }
            if (!dialog.isShowing()) {
                Dialog dialog2 = insuranceOrderSummary.f13541i;
                if (dialog2 == null) {
                    k.a("mProgressDialog");
                }
                dialog2.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            Context context = insuranceOrderSummary.f13536d;
            if (context == null) {
                k.a("context");
            }
            com.paytm.network.b a2 = bVar.a(context).a(a.C0715a.GET).a(a.c.INSURANCE).a(str).b((String) null).a((Map<String, String>) null).a((IJRPaytmDataModel) new CJROrderedCart());
            Context context2 = insuranceOrderSummary.f13536d;
            if (context2 == null) {
                k.a("context");
            }
            a2.c(context2.getClass().getSimpleName()).a((com.paytm.network.listener.b) insuranceOrderSummary).a(a.b.USER_FACING).l().a();
        }
    }
}
