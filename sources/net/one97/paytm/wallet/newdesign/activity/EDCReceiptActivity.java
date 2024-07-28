package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.wallet.edcreceipt.EDCReceiptResponseModel;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.landingpage.hometabs.a;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.l;
import org.json.JSONObject;

public class EDCReceiptActivity extends PaytmActivity {
    private ImageView A;
    private ImageView B;
    /* access modifiers changed from: private */
    public ScrollView C;
    private HomeTabItem[] D;
    private HashMap<String, View> E = new HashMap<>();
    private TableRow F;
    private TableRow G;
    private TableRow H;
    private TableRow I;
    private TableRow J;
    private TableRow K;
    private TableRow L;
    private TableRow M;
    private View.OnClickListener N = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!view.isSelected()) {
                Object tag = view.getTag();
                if (tag instanceof HomeTabItem) {
                    EDCReceiptActivity.a(EDCReceiptActivity.this, ((HomeTabItem) tag).getUrlType());
                } else {
                    q.c();
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Context f70485a;

    /* renamed from: b  reason: collision with root package name */
    private String f70486b;

    /* renamed from: c  reason: collision with root package name */
    private String f70487c;

    /* renamed from: d  reason: collision with root package name */
    private String f70488d;

    /* renamed from: e  reason: collision with root package name */
    private String f70489e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70490f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70491g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70492h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f70493i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    /* access modifiers changed from: private */
    public TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    /* access modifiers changed from: private */
    public LinearLayout x;
    private RelativeLayout y;
    private Dialog z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.edc_reciept_activity_layout);
        this.f70485a = getApplicationContext();
        this.f70490f = (TextView) findViewById(R.id.tv_payment_amount);
        this.C = (ScrollView) findViewById(R.id.sv_parent);
        this.f70491g = (TextView) findViewById(R.id.tv_customer_name);
        this.f70492h = (TextView) findViewById(R.id.tv_customer_add);
        this.f70493i = (TextView) findViewById(R.id.tv_merchant_details_card);
        this.j = (TextView) findViewById(R.id.tv_merchant_details);
        this.k = (TextView) findViewById(R.id.tv_reference_details);
        this.l = (TextView) findViewById(R.id.tv_reference_time_stamp);
        this.m = (TextView) findViewById(R.id.tv_transaction_id);
        this.n = (TextView) findViewById(R.id.tv_mid);
        this.o = (TextView) findViewById(R.id.tv_tid);
        this.p = (TextView) findViewById(R.id.tv_aid);
        this.q = (TextView) findViewById(R.id.tv_appr);
        this.r = (TextView) findViewById(R.id.tv_accquiring_bank);
        this.s = (TextView) findViewById(R.id.tv_more_details_text);
        this.x = (LinearLayout) findViewById(R.id.paymentDetailsContainer);
        this.A = (ImageView) findViewById(R.id.iv_card_type_logo);
        this.w = (TextView) findViewById(R.id.tv_card_holder_name);
        this.B = (ImageView) findViewById(R.id.iv_curtomer_logo);
        this.y = (RelativeLayout) findViewById(R.id.ll_root_view);
        this.C.setSmoothScrollingEnabled(true);
        a.a();
        this.D = a.b();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent_layout_bottom);
        int i2 = 0;
        while (true) {
            HomeTabItem[] homeTabItemArr = this.D;
            if (i2 < homeTabItemArr.length) {
                HomeTabItem homeTabItem = homeTabItemArr[i2];
                View inflate = getLayoutInflater().inflate(R.layout.home_tab_item_layout, (ViewGroup) null, false);
                inflate.setTag(homeTabItem);
                inflate.setOnClickListener(this.N);
                ((ImageView) inflate.findViewById(R.id.tab_img)).setImageDrawable(homeTabItem.getIcon());
                TextView textView = (TextView) inflate.findViewById(R.id.tab_txt);
                textView.setText(homeTabItem.getText());
                textView.setTextColor(b.b(this, homeTabItem.getTextColorResource()));
                this.E.put(homeTabItem.getUrlType(), inflate);
                inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
                linearLayout.addView(inflate, i2);
                i2++;
            } else {
                l.a((ViewGroup) linearLayout);
                this.y = (RelativeLayout) findViewById(R.id.ll_root_view);
                this.t = (TextView) findViewById(R.id.tv_download_receipt_text);
                this.u = (TextView) findViewById(R.id.tv_card_type_value);
                this.v = (TextView) findViewById(R.id.tv_transaction_type_value);
                this.F = (TableRow) findViewById(R.id.row_transcation_id);
                this.G = (TableRow) findViewById(R.id.row_mid);
                this.H = (TableRow) findViewById(R.id.row_tid);
                this.I = (TableRow) findViewById(R.id.row_aid);
                this.J = (TableRow) findViewById(R.id.row_appr);
                this.K = (TableRow) findViewById(R.id.row_accquiring_bank);
                this.L = (TableRow) findViewById(R.id.row_card_type);
                this.M = (TableRow) findViewById(R.id.row_transcation_type);
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        EDCReceiptActivity.this.s.setVisibility(8);
                        EDCReceiptActivity.this.x.setVisibility(0);
                        EDCReceiptActivity.this.C.scrollTo(0, EDCReceiptActivity.this.x.getBottom());
                    }
                });
                this.t.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        EDCReceiptActivity.d(EDCReceiptActivity.this);
                    }
                });
                a();
                return;
            }
        }
    }

    private void a() {
        if (!com.paytm.utility.a.p(this)) {
            b();
        } else if (getIntent() != null && getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            Uri parse = Uri.parse(getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA"));
            this.f70486b = parse.getQueryParameter("acquirementId");
            this.f70487c = parse.getQueryParameter("tid");
            this.f70488d = parse.getQueryParameter("mid");
            c();
        }
    }

    private void b() {
        startActivityForResult(new Intent(this, AJRAuthActivity.class), 0);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 0) {
            return;
        }
        if (com.paytm.utility.a.p(this)) {
            a();
        } else if (!isFinishing()) {
            finish();
        }
    }

    private void a(String str) {
        try {
            Toast.makeText(this, getString(R.string.cst_downloading_text), 0).show();
            Uri parse = Uri.parse(str);
            String guessFileName = URLUtil.guessFileName(str, (String) null, MimeTypeMap.getFileExtensionFromUrl(str));
            DownloadManager.Request request = new DownloadManager.Request(parse);
            request.setAllowedNetworkTypes(3);
            request.setTitle(getString(R.string.download_title));
            request.setDescription(getString(R.string.download_description));
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
            ((DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD)).enqueue(request);
        } catch (Exception unused) {
            b(this.f70485a.getString(R.string.wrong_error_mgs));
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean a2 = a(strArr);
        if (i2 == 1024) {
            if (!a2) {
                Context context = this.f70485a;
                com.paytm.utility.b.b(context, "", context.getString(R.string.permission_denied));
            } else if (com.paytm.utility.a.m(this.f70485a)) {
                a(this.f70489e);
            } else {
                Context context2 = this.f70485a;
                com.paytm.utility.b.b(context2, "", context2.getString(R.string.no_internet));
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private boolean a(String[] strArr) {
        try {
            if (Build.VERSION.SDK_INT < 23 || strArr == null) {
                return true;
            }
            for (String a2 : strArr) {
                if (androidx.core.app.a.a(getApplicationContext(), a2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a(true);
        c.a();
        String S = c.S();
        if (URLUtil.isValidUrl(S)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = d();
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            if (com.paytm.utility.a.m(this.f70485a)) {
                d.a(this.f70485a, S, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        EDCReceiptActivity.this.a(false);
                        EDCReceiptActivity.a(EDCReceiptActivity.this, (EDCReceiptResponseModel) iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        EDCReceiptActivity.this.a(false);
                        EDCReceiptActivity.this.b(networkCustomError.getMessage());
                    }
                }, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new EDCReceiptResponseModel(), a.c.PAYMENTS, a.b.SILENT).a();
                return;
            }
            Context context = this.f70485a;
            com.paytm.utility.b.b(context, "", context.getString(R.string.no_internet));
            return;
        }
        Context context2 = this.f70485a;
        com.paytm.utility.b.b(context2, "", context2.getString(R.string.msg_invalid_url));
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.something_wrong_try_again);
        }
        final h hVar = new h(this);
        hVar.setTitle(getString(R.string.error));
        hVar.a(str);
        hVar.a(-2, getString(R.string._cancel), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
                EDCReceiptActivity.this.finish();
            }
        });
        hVar.a(-1, getString(R.string._retry), new View.OnClickListener() {
            public final void onClick(View view) {
                EDCReceiptActivity.this.c();
                hVar.dismiss();
            }
        });
        hVar.setCanceledOnTouchOutside(false);
        hVar.setCancelable(false);
        hVar.show();
    }

    private void a(ImageView imageView, String str) {
        try {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(getApplicationContext());
            a2.f43753a = str;
            b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
            imageView.setVisibility(0);
        } catch (Exception unused) {
            imageView.setVisibility(8);
        }
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            StringBuilder sb = new StringBuilder();
            sb.append(new Date().getTime());
            jSONObject2.put("timeStamp", sb.toString());
            jSONObject2.put("oauthToken", com.paytm.utility.a.q(this));
            int i2 = this.f70485a.getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            jSONObject2.put("version", "1.0");
            jSONObject2.put("clientId", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            jSONObject2.put("customerLatLong", com.paytm.utility.a.g(this.f70485a) + AppConstants.COMMA + com.paytm.utility.a.h(this));
            jSONObject2.put("customerDeviceID", com.paytm.utility.a.d(this.f70485a));
            jSONObject.put("head", jSONObject2);
            jSONObject3.put("acquirementId", this.f70486b);
            jSONObject3.put("tid", this.f70487c);
            jSONObject3.put("mid", this.f70488d);
            jSONObject.put("body", jSONObject3);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            try {
                if (this.z == null) {
                    this.z = net.one97.paytm.wallet.utility.a.b((Activity) this);
                }
                if (this.z != null && !this.z.isShowing()) {
                    this.z.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (this.z != null && this.z.isShowing()) {
            this.z.dismiss();
        }
    }

    static /* synthetic */ void d(EDCReceiptActivity eDCReceiptActivity) {
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        if (TextUtils.isEmpty(eDCReceiptActivity.f70489e)) {
            return;
        }
        if (!eDCReceiptActivity.a(strArr)) {
            androidx.core.app.a.a(eDCReceiptActivity, strArr, TarConstants.EOF_BLOCK);
        } else if (com.paytm.utility.a.m(eDCReceiptActivity.f70485a)) {
            eDCReceiptActivity.a(eDCReceiptActivity.f70489e);
        } else {
            Context context = eDCReceiptActivity.f70485a;
            com.paytm.utility.b.b(context, "", context.getString(R.string.no_internet));
        }
    }

    static /* synthetic */ void a(EDCReceiptActivity eDCReceiptActivity, String str) {
        Intent intent = new Intent(eDCReceiptActivity, AJRMainActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        if (!str.isEmpty()) {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
        } else {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        }
        intent.putExtra("started_activity_from_recharge", true);
        eDCReceiptActivity.startActivity(intent);
        eDCReceiptActivity.finish();
    }

    static /* synthetic */ void a(EDCReceiptActivity eDCReceiptActivity, EDCReceiptResponseModel eDCReceiptResponseModel) {
        if (eDCReceiptResponseModel == null || eDCReceiptResponseModel.getBody() == null) {
            eDCReceiptActivity.y.setVisibility(8);
            eDCReceiptActivity.b(eDCReceiptActivity.getString(R.string.something_wrong_try_again));
        } else if ("S".equalsIgnoreCase(eDCReceiptResponseModel.getBody().getResultCode())) {
            eDCReceiptActivity.y.setVisibility(0);
            if (eDCReceiptResponseModel.getBody().getAmount() != null) {
                eDCReceiptActivity.f70490f.setText(com.paytm.utility.b.T(eDCReceiptResponseModel.getBody().getAmount()));
            }
            if (eDCReceiptResponseModel.getBody().getMerchantName() != null) {
                eDCReceiptActivity.f70491g.setText(eDCReceiptResponseModel.getBody().getMerchantName());
            }
            if (eDCReceiptResponseModel.getBody().getCity() != null) {
                eDCReceiptActivity.f70492h.setText(eDCReceiptResponseModel.getBody().getCity());
            }
            if (eDCReceiptResponseModel.getBody().getCardHolderName() != null) {
                eDCReceiptActivity.w.setVisibility(0);
                eDCReceiptActivity.w.setText(eDCReceiptResponseModel.getBody().getCardHolderName());
            }
            if (eDCReceiptResponseModel.getBody().getCardNumber() != null) {
                TextView textView = eDCReceiptActivity.f70493i;
                textView.setText(eDCReceiptActivity.getString(R.string.card_no) + " " + eDCReceiptResponseModel.getBody().getCardNumber());
            }
            if (eDCReceiptResponseModel.getBody().getPayMode() != null) {
                eDCReceiptActivity.j.setText(eDCReceiptResponseModel.getBody().getPayMode());
            }
            if (eDCReceiptResponseModel.getBody().getReferenceNumber() != null) {
                TextView textView2 = eDCReceiptActivity.k;
                textView2.setText(eDCReceiptActivity.getString(R.string.ref_deatils_edc) + eDCReceiptResponseModel.getBody().getReferenceNumber());
            }
            if (eDCReceiptResponseModel.getBody().getDate() != null) {
                eDCReceiptActivity.l.setText(eDCReceiptResponseModel.getBody().getDate());
            }
            if (eDCReceiptResponseModel.getBody().getTxnId() != null) {
                eDCReceiptActivity.m.setText(eDCReceiptResponseModel.getBody().getTxnId());
                eDCReceiptActivity.F.setVisibility(0);
            } else {
                eDCReceiptActivity.F.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getMid() != null) {
                eDCReceiptActivity.n.setText(eDCReceiptResponseModel.getBody().getMid());
                eDCReceiptActivity.G.setVisibility(0);
            } else {
                eDCReceiptActivity.G.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getTid() != null) {
                eDCReceiptActivity.o.setText(eDCReceiptResponseModel.getBody().getTid());
                eDCReceiptActivity.H.setVisibility(0);
            } else {
                eDCReceiptActivity.H.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getAid() != null) {
                eDCReceiptActivity.p.setText(eDCReceiptResponseModel.getBody().getAid());
                eDCReceiptActivity.I.setVisibility(0);
            } else {
                eDCReceiptActivity.I.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getApprCode() != null) {
                eDCReceiptActivity.q.setText(eDCReceiptResponseModel.getBody().getApprCode());
                eDCReceiptActivity.J.setVisibility(0);
            } else {
                eDCReceiptActivity.J.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getAcquiringBank() != null) {
                eDCReceiptActivity.r.setText(eDCReceiptResponseModel.getBody().getAcquiringBank());
                eDCReceiptActivity.K.setVisibility(0);
            } else {
                eDCReceiptActivity.K.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getCardType() != null) {
                eDCReceiptActivity.u.setText(eDCReceiptResponseModel.getBody().getCardType());
                eDCReceiptActivity.L.setVisibility(0);
            } else {
                eDCReceiptActivity.L.setVisibility(8);
            }
            if (eDCReceiptResponseModel.getBody().getTxnType() != null) {
                eDCReceiptActivity.v.setText(eDCReceiptResponseModel.getBody().getTxnType());
                eDCReceiptActivity.M.setVisibility(0);
            } else {
                eDCReceiptActivity.M.setVisibility(8);
            }
            if (!TextUtils.isEmpty(eDCReceiptResponseModel.getBody().getCardTypeImage())) {
                eDCReceiptActivity.a(eDCReceiptActivity.A, eDCReceiptResponseModel.getBody().getCardTypeImage());
            } else {
                eDCReceiptActivity.A.setVisibility(8);
            }
            if (!TextUtils.isEmpty(eDCReceiptResponseModel.getBody().getMerImage())) {
                eDCReceiptActivity.a(eDCReceiptActivity.B, eDCReceiptResponseModel.getBody().getMerImage());
            } else {
                eDCReceiptActivity.B.setVisibility(8);
            }
            if (!TextUtils.isEmpty(eDCReceiptResponseModel.getBody().getReceipturl())) {
                eDCReceiptActivity.t.setVisibility(0);
                eDCReceiptActivity.f70489e = eDCReceiptResponseModel.getBody().getReceipturl();
                return;
            }
            eDCReceiptActivity.t.setVisibility(8);
        } else {
            eDCReceiptActivity.y.setVisibility(8);
            eDCReceiptActivity.b(eDCReceiptResponseModel.getBody().getResultMsg());
        }
    }
}
