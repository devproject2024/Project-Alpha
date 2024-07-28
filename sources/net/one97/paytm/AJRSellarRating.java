package net.one97.paytm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel;
import net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating;
import net.one97.paytm.common.entity.SellerRating.CJRSellarRatingPostResponse;
import net.one97.paytm.h;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;

public class AJRSellarRating extends CJRActionBarBaseActivity implements RatingBar.OnRatingBarChangeListener, h.a {
    private h C;

    /* renamed from: a  reason: collision with root package name */
    private RatingBar f51756a;

    /* renamed from: b  reason: collision with root package name */
    private RatingBar f51757b;

    /* renamed from: c  reason: collision with root package name */
    private RatingBar f51758c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f51759d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f51760e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f51761f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f51762g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f51763h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f51764i;
    private ScrollView j;
    private EditText k;
    private Button l;

    public final void a() {
    }

    public final void a(CJROrderSummarySellarRating cJROrderSummarySellarRating) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.activity_rate_sellar, (ViewGroup) null));
        o();
        p();
        setTitle(getResources().getString(R.string.rate_the_sellar));
        int u = a.u(this);
        int i2 = u * 2;
        int i3 = (int) (((double) u) * 1.5d);
        this.j = (ScrollView) findViewById(R.id.rate_the_sellar);
        this.j.setPadding(i2, 0, i2, i2);
        this.f51759d = (TextView) findViewById(R.id.product_description_rate_type);
        this.f51759d.setPadding(0, 0, 0, i3);
        this.f51760e = (TextView) findViewById(R.id.product_packaging_rate_type);
        this.f51760e.setPadding(0, 0, 0, i3);
        this.f51761f = (TextView) findViewById(R.id.product_delivery_rate_type);
        this.f51761f.setPadding(0, 0, 0, i3);
        this.f51756a = (RatingBar) findViewById(R.id.rate_product_description);
        this.f51756a.setPadding(0, 0, 0, u);
        a(this.f51756a);
        this.f51756a.setOnRatingBarChangeListener(this);
        this.f51757b = (RatingBar) findViewById(R.id.rate_product_packaging);
        this.f51757b.setPadding(0, 0, 0, u);
        this.f51757b.setOnRatingBarChangeListener(this);
        a(this.f51757b);
        this.f51758c = (RatingBar) findViewById(R.id.rate_product_delivery);
        this.f51758c.setPadding(0, 0, 0, u);
        this.f51758c.setOnRatingBarChangeListener(this);
        a(this.f51758c);
        this.f51764i = (TextView) findViewById(R.id.product_description);
        int i4 = u / 2;
        this.f51764i.setPadding(0, i3, 0, i4);
        this.f51762g = (TextView) findViewById(R.id.product_packaging);
        this.f51762g.setPadding(0, u, 0, i4);
        this.f51763h = (TextView) findViewById(R.id.product_delivery);
        this.f51763h.setPadding(0, u, 0, i4);
        this.l = (Button) findViewById(R.id.btn_submit_btn);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSellarRating.a(AJRSellarRating.this);
            }
        });
        this.k = (EditText) findViewById(R.id.user_comments);
        this.k.setPadding(0, u, u, i2 + i2);
        this.C = new h(this);
        this.C.f52404c = this;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        k();
        i();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    private void a(RatingBar ratingBar) {
        ratingBar.setNumStars(5);
        LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange_promo_msg), PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(1).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(0).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
    }

    public void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
        switch (ratingBar.getId()) {
            case R.id.rate_product_delivery:
                try {
                    b();
                    String b2 = b((int) Math.ceil((double) this.f51758c.getRating()));
                    if (b2 != null) {
                        this.f51761f.setVisibility(0);
                        this.f51761f.setText(b2);
                        return;
                    }
                    this.f51761f.setVisibility(8);
                    return;
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                        return;
                    }
                    return;
                }
            case R.id.rate_product_description:
                try {
                    b();
                    String b3 = b((int) Math.ceil((double) this.f51756a.getRating()));
                    if (b3 != null) {
                        this.f51759d.setVisibility(0);
                        this.f51759d.setText(b3);
                        return;
                    }
                    this.f51759d.setVisibility(8);
                    return;
                } catch (Exception e3) {
                    if (b.v) {
                        q.b(e3.getMessage());
                        return;
                    }
                    return;
                }
            case R.id.rate_product_packaging:
                try {
                    b();
                    String b4 = b((int) Math.ceil((double) this.f51757b.getRating()));
                    if (b4 != null) {
                        this.f51760e.setVisibility(0);
                        this.f51760e.setText(b4);
                        return;
                    }
                    this.f51760e.setVisibility(8);
                    return;
                } catch (Exception e4) {
                    if (b.v) {
                        q.b(e4.getMessage());
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private void b() {
        int ceil = (int) Math.ceil((double) this.f51757b.getRating());
        int ceil2 = (int) Math.ceil((double) this.f51758c.getRating());
        int ceil3 = (int) Math.ceil((double) this.f51756a.getRating());
        if (ceil2 == 0 || ceil3 == 0 || ceil == 0) {
            this.l.setEnabled(false);
        } else {
            this.l.setEnabled(true);
        }
    }

    private String b(int i2) {
        if (i2 == 0) {
            return null;
        }
        if (i2 == 1) {
            return getResources().getString(R.string.one_rating);
        }
        if (i2 == 2) {
            return getResources().getString(R.string.two_rating);
        }
        if (i2 == 3) {
            return getResources().getString(R.string.three_rating);
        }
        if (i2 == 4) {
            return getResources().getString(R.string.four_rating);
        }
        if (i2 != 5) {
            return null;
        }
        return getResources().getString(R.string.five_rating);
    }

    private static String a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            for (Map.Entry next : hashMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(AppConstants.AND_SIGN);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), AppConstants.UTF_8));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), AppConstants.UTF_8));
            }
        } catch (UnsupportedEncodingException e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        return sb.toString();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onApiSuccess(iJRPaytmDataModel);
        if (iJRPaytmDataModel instanceof CJRSellarRatingPostResponse) {
            CJRSellarRatingPostResponse cJRSellarRatingPostResponse = (CJRSellarRatingPostResponse) iJRPaytmDataModel;
            m();
            if (cJRSellarRatingPostResponse != null && cJRSellarRatingPostResponse.getSuccessMessage() != null && cJRSellarRatingPostResponse.getSuccessMessage().equalsIgnoreCase("Success")) {
                CJROrderSummaryRatingModel cJROrderSummaryRatingModel = new CJROrderSummaryRatingModel();
                Intent intent = getIntent();
                cJROrderSummaryRatingModel.setIsRated(false);
                if (intent != null && intent.hasExtra("item_id")) {
                    cJROrderSummaryRatingModel.setItemId(intent.getLongExtra("item_id", 0));
                }
                RatingBar ratingBar = this.f51756a;
                if (ratingBar != null) {
                    cJROrderSummaryRatingModel.setProductDescRating(ratingBar.getRating());
                }
                RatingBar ratingBar2 = this.f51757b;
                if (ratingBar2 != null) {
                    cJROrderSummaryRatingModel.setProductPackagingRating(ratingBar2.getRating());
                }
                RatingBar ratingBar3 = this.f51758c;
                if (ratingBar3 != null) {
                    cJROrderSummaryRatingModel.setProductDeliveryRating(ratingBar3.getRating());
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(cJROrderSummaryRatingModel);
                CJROrderSummarySellarRating cJROrderSummarySellarRating = new CJROrderSummarySellarRating();
                cJROrderSummarySellarRating.setSellarRatingModel(arrayList);
                if (intent != null && intent.hasExtra("item_id") && intent.hasExtra("merchant_id")) {
                    h hVar = this.C;
                    hVar.a("item_id=" + intent.getLongExtra("item_id", 0) + "_merchant_id=" + intent.getLongExtra("merchant_id", 0), cJROrderSummarySellarRating);
                }
                View inflate = getLayoutInflater().inflate(R.layout.sellar_rating_custom_toast, (ViewGroup) findViewById(R.id.sellar_rating_custom_toast_lyt));
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(0);
                toast.setGravity(17, 0, 0);
                toast.setView(inflate);
                toast.show();
                finish();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            m();
            if (networkCustomError == null) {
                return;
            }
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                r.a((Activity) this, (Exception) networkCustomError, "", (Bundle) null);
            } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    return;
                }
                b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
            }
        }
    }

    static /* synthetic */ void a(AJRSellarRating aJRSellarRating) {
        try {
            c.a();
            String a2 = c.a("sellerratingPost", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                String b2 = b.b((Context) aJRSellarRating, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                HashMap hashMap2 = new HashMap();
                try {
                    Intent intent = aJRSellarRating.getIntent();
                    hashMap2.put("source", "order_summary");
                    hashMap2.put("channel", "androidapp");
                    if (intent != null && intent.hasExtra("item_id")) {
                        hashMap2.put("item_id", String.valueOf(intent.getLongExtra("item_id", 0)));
                    }
                    if (intent != null && intent.hasExtra("merchant_id")) {
                        hashMap2.put("merchant_id", String.valueOf(intent.getLongExtra("merchant_id", 0)));
                    }
                    if (aJRSellarRating.k != null && !TextUtils.isEmpty(aJRSellarRating.k.getText().toString())) {
                        hashMap2.put("review", aJRSellarRating.k.getText().toString());
                    }
                    if (aJRSellarRating.f51756a != null) {
                        hashMap2.put("s1", String.valueOf(aJRSellarRating.f51756a.getRating()));
                    }
                    if (aJRSellarRating.f51757b != null) {
                        hashMap2.put("s2", String.valueOf(aJRSellarRating.f51757b.getRating()));
                    }
                    if (aJRSellarRating.f51758c != null) {
                        hashMap2.put("s3", String.valueOf(aJRSellarRating.f51758c.getRating()));
                    }
                    hashMap2.put("set_id", "1");
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
                AJRSellarRating aJRSellarRating2 = aJRSellarRating;
                AJRSellarRating aJRSellarRating3 = aJRSellarRating;
                com.paytm.network.a a3 = d.a(aJRSellarRating2, b2, aJRSellarRating3, hashMap, (Map<String, String>) null, a.C0715a.POST, a((HashMap<String, String>) hashMap2), new CJRSellarRatingPostResponse(), a.c.HOME, a.b.SILENT);
                if (com.paytm.utility.a.m(aJRSellarRating)) {
                    a3.a();
                    aJRSellarRating.a((Context) aJRSellarRating, aJRSellarRating.getResources().getString(R.string.please_wait_progress_msg));
                    return;
                }
                r.a(a3, (Context) aJRSellarRating, (DialogInterface.OnCancelListener) aJRSellarRating);
                aJRSellarRating.m();
            }
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
        }
    }
}
