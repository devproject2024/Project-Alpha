package net.one97.paytm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJRTnCModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.j;

public class AJRNativeBannerActivity extends CJRActionBarBaseActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    public ActionBar f51372a;

    /* renamed from: b  reason: collision with root package name */
    private CJRHomePageItem f51373b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f51374c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f51375d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f51376e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f51377f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f51378g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f51379h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f51380i;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_native_banner);
        this.f51373b = (CJRHomePageItem) getIntent().getSerializableExtra("intent_extra_promo_info");
        this.f51374c = (ImageView) findViewById(R.id.banner_image);
        this.f51375d = (TextView) findViewById(R.id.banner_promo_code);
        this.f51376e = (TextView) findViewById(R.id.teamsHeading);
        this.f51377f = (TextView) findViewById(R.id.bannerDes);
        this.f51378g = (TextView) findViewById(R.id.banner_promo_static);
        this.f51379h = (ProgressBar) findViewById(R.id.bannerProgressBar);
        this.f51380i = (RelativeLayout) findViewById(R.id.bookNowView);
        this.f51380i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRNativeBannerActivity.this.a(view);
            }
        });
        if (!TextUtils.isEmpty(this.f51373b.getImageUrl())) {
            str = this.f51373b.getImageUrl();
        } else {
            str = !TextUtils.isEmpty(this.f51373b.getAltImageUrl()) ? this.f51373b.getAltImageUrl() : null;
        }
        if (!TextUtils.isEmpty(str)) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(getApplicationContext());
            a2.f43753a = str;
            b.a.C0750a.a(a2, this.f51374c, (com.paytm.utility.b.b.b) null, 2);
        }
        this.f51375d.setText(this.f51373b.getName());
        this.f51379h.setVisibility(0);
        c.a();
        String a3 = c.a("promoSearchUrl", (String) null);
        if (!TextUtils.isEmpty(this.f51373b.getName()) && !TextUtils.isEmpty(a3)) {
            String format = String.format(a3, new Object[]{this.f51373b.getName()});
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.f42878b = a.c.HOME;
            bVar.n = a.b.USER_FACING;
            bVar.o = "NATIVE_BANNER_SCREEN";
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = format;
            bVar.f42885i = new CJRTnCModel();
            bVar.j = this;
            a l = bVar.l();
            l.f42859c = false;
            l.a();
        }
        this.f51372a = getSupportActionBar();
        CJRHomePageItem cJRHomePageItem = this.f51373b;
        if (cJRHomePageItem != null) {
            if (cJRHomePageItem.getTitle() == null || TextUtils.isEmpty(this.f51373b.getTitle().trim())) {
                str2 = this.f51373b.getName() != null ? this.f51373b.getName() : "";
            } else {
                str2 = this.f51373b.getTitle();
            }
            setTitle(str2);
        }
        this.f51372a.a(false);
        p();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String url = this.f51373b.getURL();
        if (!TextUtils.isEmpty(url)) {
            CJRHomePageItem a2 = net.one97.paytm.utils.c.a((Context) this, url.trim());
            j.a((Context) this, a2.getURLType(), (IJRDataModel) a2, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (c) null);
        }
        finish();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        k();
        i();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRTnCModel cJRTnCModel;
        String[] split;
        this.f51379h.setVisibility(8);
        if ((iJRPaytmDataModel instanceof CJRTnCModel) && (cJRTnCModel = (CJRTnCModel) iJRPaytmDataModel) != null && !TextUtils.isEmpty(cJRTnCModel.getTerms().trim()) && (split = cJRTnCModel.getTerms().split("<br>")) != null && split.length > 0) {
            List<String> asList = Arrays.asList(split);
            StringBuilder sb = new StringBuilder();
            for (String str : asList) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                    if (str.contains("<br>")) {
                        str = str.replaceAll("<br>", "");
                    }
                    sb.append(str);
                    sb.append("\n\n");
                }
            }
            this.f51377f.setText(sb.toString());
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f51379h.setVisibility(8);
        Toast.makeText(this, "Error", 0).show();
    }
}
