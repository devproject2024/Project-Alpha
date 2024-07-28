package com.travel.travels.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.CJRActionBarBaseActivity;
import com.travel.R;
import com.travel.cdn.ResourceUtils;
import com.travel.model.ReferEarnBody;
import com.travel.model.ReferEarnModel;
import com.travel.travels.b.d;
import com.travel.utils.n;
import com.travel.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.deeplink.DeepLinkData;

public class AJRReferEarnActivity extends CJRActionBarBaseActivity implements View.OnClickListener, b {
    private static String j = "AJRReferEarnActivity";
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private String D;
    private ReferEarnModel E;
    private RelativeLayout F;
    private TextView G;
    private RelativeLayout H;

    /* renamed from: a  reason: collision with root package name */
    ImageView f28440a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f28441b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f28442c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f28443d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f28444e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f28445f;

    /* renamed from: g  reason: collision with root package name */
    TextView f28446g;

    /* renamed from: h  reason: collision with root package name */
    TextView f28447h;

    /* renamed from: i  reason: collision with root package name */
    TextView f28448i;
    private boolean k;
    private boolean l;
    private boolean m = false;
    private LottieAnimationView n;
    private boolean o;
    private boolean p;
    private boolean q = false;
    private ArrayList<String> r;
    private String x;
    private String y;
    private ImageView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bus_refer_earn);
        this.f28440a = (ImageView) findViewById(R.id.refer_icon);
        this.f28441b = (ImageView) findViewById(R.id.refer_logo);
        this.f28445f = (ImageView) findViewById(R.id.share_more);
        this.f28442c = (ImageView) findViewById(R.id.whats_icon);
        this.f28443d = (ImageView) findViewById(R.id.facebook_icon);
        this.f28444e = (ImageView) findViewById(R.id.twitter_icon);
        this.B = (ImageView) findViewById(R.id.motif_icon);
        this.C = (ImageView) findViewById(R.id.motif_icon_overlay);
        this.f28446g = (TextView) findViewById(R.id.invite_text);
        this.f28447h = (TextView) findViewById(R.id.referel_desc);
        this.f28448i = (TextView) findViewById(R.id.terms_condition);
        this.n = (LottieAnimationView) findViewById(R.id.lottie_progress_bar);
        this.H = (RelativeLayout) findViewById(R.id.container);
        this.F = (RelativeLayout) findViewById(R.id.error_layout);
        this.A = (ImageView) findViewById(R.id.back_button_retry);
        this.A.setOnClickListener(this);
        this.G = (TextView) findViewById(R.id.retry_button);
        this.G.setOnClickListener(this);
        this.z = (ImageView) findViewById(R.id.back_button);
        this.z.setOnClickListener(this);
        this.n.setVisibility(0);
        this.f28448i.setOnClickListener(this);
        this.f28443d.setOnClickListener(this);
        this.f28442c.setOnClickListener(this);
        this.f28444e.setOnClickListener(this);
        this.f28445f.setOnClickListener(this);
        ResourceUtils.loadTCoreImagesFromCDN(this.B, "travel_motif.png", false, false, n.a.V1);
        ResourceUtils.loadTCoreImagesFromCDN(this.C, "travel_motif.png", false, false, n.a.V1);
        ResourceUtils.loadTCoreImagesFromCDN(this.f28445f, "refer_social.png", false, false, n.a.V1);
        ResourceUtils.loadTCoreImagesFromCDN(this.f28442c, "refer_whats_app.png", false, false, n.a.V1);
        ResourceUtils.loadTCoreImagesFromCDN(this.f28443d, "refer_facebook.png", false, false, n.a.V1);
        ResourceUtils.loadTCoreImagesFromCDN(this.f28444e, "refer_twitter.png", false, false, n.a.V1);
        for (PackageInfo packageInfo : getApplicationContext().getPackageManager().getInstalledPackages(0)) {
            try {
                String charSequence = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                if (charSequence.contains("WhatsApp")) {
                    this.k = true;
                }
                if (charSequence.contains("Facebook")) {
                    this.l = true;
                }
                if (charSequence.contains("Twitter")) {
                    this.m = true;
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        if (this.k) {
            this.f28442c.setVisibility(0);
        }
        if (this.l) {
            this.f28443d.setVisibility(0);
        }
        if (this.m) {
            this.f28444e.setVisibility(0);
        }
        this.D = "flight";
        b();
    }

    public void onClick(View view) {
        if (view == this.f28443d) {
            f();
            this.p = true;
            this.o = false;
            this.q = false;
        } else if (view == this.f28442c) {
            f();
            this.p = false;
            this.o = true;
            this.q = false;
        } else if (view == this.f28444e) {
            f();
            this.p = false;
            this.o = false;
            this.q = true;
        } else if (view == this.f28445f) {
            g();
        } else if (view == this.f28448i) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putSerializable("offersTnC", this.r);
            dVar.setArguments(bundle);
            dVar.show(getSupportFragmentManager(), dVar.getTag());
        } else if (view == this.z || view == this.A) {
            onBackPressed();
        } else if (view == this.G) {
            b();
        }
    }

    private void b() {
        a(false);
        LottieAnimationView lottieAnimationView = this.n;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
        com.travel.d.a();
        String a2 = com.travel.d.b().a("travelReferAndEarn", "");
        if (TextUtils.isEmpty(a2)) {
            a(true);
            return;
        }
        String a3 = a(a2);
        HashMap hashMap = new HashMap();
        if (URLUtil.isValidUrl(a3)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = a3;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new ReferEarnModel();
            bVar.j = this;
            bVar.t = null;
            bVar.n = a.b.SILENT;
            bVar.o = "bus";
            a l2 = bVar.l();
            l2.f42860d = true;
            l2.a();
        }
    }

    private String a(String str) {
        try {
            if (getIntent() == null || getIntent().getExtras() == null || getIntent().getExtras().get("EXTRA_DEEP_LINK_DATA") == null || !(getIntent().getExtras().get("EXTRA_DEEP_LINK_DATA") instanceof DeepLinkData)) {
                return "";
            }
            String str2 = ((DeepLinkData) getIntent().getExtras().get("EXTRA_DEEP_LINK_DATA")).f50283a;
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            String queryParameter = Uri.parse(str2).getQueryParameter("vertical");
            if (TextUtils.isEmpty(queryParameter)) {
                return str2;
            }
            this.D = queryParameter;
            return Uri.parse(str).buildUpon().appendQueryParameter("category", this.D).build().toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str + "?category=" + this.D;
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a(false);
        LottieAnimationView lottieAnimationView = this.n;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        if (iJRPaytmDataModel instanceof ReferEarnModel) {
            this.E = (ReferEarnModel) iJRPaytmDataModel;
            ReferEarnModel referEarnModel = this.E;
            if (referEarnModel == null || referEarnModel.getBody() == null) {
                a(true);
                return;
            }
            ReferEarnBody body = this.E.getBody();
            if (body != null) {
                if (body.getTnc() != null && body.getTnc().size() > 0) {
                    this.r = body.getTnc();
                }
                if (body.getShareText() != null) {
                    this.x = body.getShareText();
                }
                if (body.getReferralText() != null) {
                    this.f28446g.setText(body.getReferralHeading());
                }
                if (body.getReferralText() != null) {
                    this.f28447h.setText(body.getReferralText());
                }
                if (body.getHeading() != null) {
                    this.f28448i.setText(body.getHeading());
                }
                if (body.getCategoryImageUrl() != null) {
                    this.y = body.getCategoryImageUrl();
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
                    a2.f43753a = this.y.replace(" ", "%20");
                    b.a.C0750a.a(a2, this.f28440a, (com.paytm.utility.b.b.b) null, 2);
                }
                if (body.getMainImageUrl() != null) {
                    float f2 = getResources().getDisplayMetrics().density;
                    com.paytm.utility.b.a((Activity) this);
                    b.a.C0750a a3 = com.paytm.utility.b.b.a(this);
                    a3.f43753a = body.getMainImageUrl().replace(" ", "%20");
                    b.a.C0750a.a(a3, this.f28441b, (com.paytm.utility.b.b.b) null, 2);
                }
            }
        }
    }

    private void a(boolean z2) {
        if (z2) {
            this.F.setVisibility(0);
            this.H.setVisibility(8);
            return;
        }
        this.F.setVisibility(8);
        this.H.setVisibility(0);
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(true);
        LottieAnimationView lottieAnimationView = this.n;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
    }

    private void f() {
        if (!h()) {
            a(200);
        }
    }

    private void g() {
        if (!h()) {
            a(300);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    private void a(int i2) {
        Intent intent = new Intent();
        com.travel.d.a();
        com.travel.d.b().a((Context) this, intent, i2);
    }

    private boolean h() {
        String b2 = r.a(getApplicationContext()).b("sso_token=", "", true);
        if (b2 == "" || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 200) {
            f();
        } else if (i2 == 300) {
            g();
        }
    }
}
