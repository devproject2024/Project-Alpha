package com.travel.train.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.model.CJROfferItems;
import com.travel.train.model.CJRTnCModel;
import java.util.Arrays;
import java.util.List;

public class AJRTrainBannerActivity extends CJRTrainBaseActivity implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f25927a;

    /* renamed from: b  reason: collision with root package name */
    private CJROfferItems f25928b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f25929c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f25930d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f25931e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f25932f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f25933g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f25934h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f25935i;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.f25928b = (CJROfferItems) getIntent().getSerializableExtra("TrainCarousel");
        setContentView(R.layout.pre_t_action_bar_layout);
        String string = getResources().getString(R.string.app_name);
        CJROfferItems cJROfferItems = this.f25928b;
        if (cJROfferItems != null) {
            string = (cJROfferItems.getTitle() == null || TextUtils.isEmpty(this.f25928b.getTitle().trim())) ? this.f25928b.getName() != null ? this.f25928b.getName() : getString(R.string.app_name) : this.f25928b.getTitle();
        }
        setSupportActionBar((Toolbar) findViewById(R.id.base_toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(string);
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainBannerActivity.this.a(view);
            }
        });
        this.f25927a = (FrameLayout) findViewById(R.id.content_frame);
        this.f25927a.addView(getLayoutInflater().inflate(R.layout.pre_t_activity_train_banner, (ViewGroup) null));
        this.f25929c = (ImageView) findViewById(R.id.banner_image);
        this.f25930d = (TextView) findViewById(R.id.banner_promo_code);
        this.f25931e = (TextView) findViewById(R.id.teamsHeading);
        this.f25932f = (TextView) findViewById(R.id.bannerDes);
        this.f25933g = (TextView) findViewById(R.id.banner_promo_static);
        this.f25934h = (ProgressBar) findViewById(R.id.bannerProgressBar);
        this.f25935i = (RelativeLayout) findViewById(R.id.bookNowView);
        this.f25935i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainBannerActivity.this.finish();
            }
        });
        if (!TextUtils.isEmpty(this.f25928b.getmAltImageUrl())) {
            str = this.f25928b.getmAltImageUrl();
        } else {
            str = !TextUtils.isEmpty(this.f25928b.getmImageUrl()) ? this.f25928b.getmImageUrl() : null;
        }
        if (!TextUtils.isEmpty(str)) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(getApplicationContext());
            a2.f43753a = str;
            b.a.C0750a.a(a2.a(this.f25934h), this.f25929c, (com.paytm.utility.b.b.b) null, 2);
        }
        this.f25930d.setText(this.f25928b.getName());
        if (this.f25928b.getTnc() != null) {
            a(this.f25928b.getTnc());
            return;
        }
        com.travel.train.b.a();
        String N = com.travel.train.b.b().N();
        if (!TextUtils.isEmpty(this.f25928b.getName()) && !TextUtils.isEmpty(N)) {
            String format = String.format(N, new Object[]{this.f25928b.getName()});
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.u;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = format;
            bVar.f42882f = n.b((Context) this);
            bVar.f42885i = new CJRTnCModel();
            bVar.j = this;
            bVar.l().f42859c = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(next.trim())) {
                if (next.contains("<br>")) {
                    next = next.replaceAll("<br>", "");
                }
                sb.append(next);
                sb.append("\n\n");
            }
        }
        this.f25932f.setText(sb.toString());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bookNowView) {
            finish();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRTnCModel cJRTnCModel;
        String[] split;
        if ((iJRPaytmDataModel instanceof CJRTnCModel) && (cJRTnCModel = (CJRTnCModel) iJRPaytmDataModel) != null && !TextUtils.isEmpty(cJRTnCModel.getTerms().trim()) && (split = cJRTnCModel.getTerms().split("<br>")) != null && split.length > 0) {
            a((List<String>) Arrays.asList(split));
        }
    }
}
