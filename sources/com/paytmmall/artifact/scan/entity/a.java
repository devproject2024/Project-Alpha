package com.paytmmall.artifact.scan.entity;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private boolean K;
    private boolean L;
    private boolean M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;

    /* renamed from: a  reason: collision with root package name */
    public String f15883a;

    /* renamed from: b  reason: collision with root package name */
    public String f15884b;

    /* renamed from: c  reason: collision with root package name */
    public String f15885c;

    /* renamed from: d  reason: collision with root package name */
    public String f15886d;

    /* renamed from: e  reason: collision with root package name */
    public String f15887e;

    /* renamed from: f  reason: collision with root package name */
    public String f15888f;

    /* renamed from: g  reason: collision with root package name */
    public String f15889g;

    /* renamed from: h  reason: collision with root package name */
    public String f15890h;

    /* renamed from: i  reason: collision with root package name */
    JSONObject f15891i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public final void a(JSONObject jSONObject, Context context) throws JSONException {
        this.f15891i = jSONObject;
        this.j = jSONObject.optString("MID");
        this.I = jSONObject.optString(CJRQRScanResultModel.KEY_PAYEE_TYPE);
        this.k = jSONObject.optString(CJRQRScanResultModel.KEY_MERCHANT_GUID_READ);
        this.L = jSONObject.optBoolean(CJRQRScanResultModel.KEY_OFFLINE_POST_CONVENIENCE, false);
        this.f15883a = jSONObject.optString("REQUEST_TYPE");
        this.l = jSONObject.optString("INDUSTRY_TYPE_ID");
        this.m = jSONObject.optString("CHANNEL_ID", "QRCODE");
        this.M = jSONObject.optBoolean(CJRQRScanResultModel.KEY_PG_ENABLED);
        this.f15889g = jSONObject.optString(CJRQRScanResultModel.KEY_MERCHANT_TRANS_ID);
        if (!this.M) {
            if (TextUtils.isEmpty(this.f15889g)) {
                this.n = jSONObject.optString("ORDER_ID", CJRQRScanResultModel.REQ_TYPE + System.currentTimeMillis());
            } else {
                this.n = this.f15889g;
            }
        }
        this.f15884b = jSONObject.optString("TXN_AMOUNT");
        this.o = jSONObject.optString(CJRQRScanResultModel.KEY_ORDER_DETAILS);
        this.p = jSONObject.optString("PRODUCT_ID");
        this.q = jSONObject.optString(CJRQRScanResultModel.KEY_PRODUCT_TYPE);
        this.r = jSONObject.optString(CJRQRScanResultModel.KEY_PRODUCT_DETAILS);
        this.s = jSONObject.optString(CJRQRScanResultModel.KEY_QUANTITY);
        this.f15885c = jSONObject.optString(CJRQRScanResultModel.KEY_COMMENT);
        this.t = jSONObject.optString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
        this.u = jSONObject.optString("WEBSITE");
        this.v = jSONObject.optString("CHECKSUMHASH");
        this.w = jSONObject.optString("AUTH_MODE", "USRPWD");
        this.x = jSONObject.optString("PAYMENT_TYPE_ID", "PPI");
        this.y = jSONObject.optString("ADDRESS_1");
        this.z = jSONObject.optString(CJRQRScanResultModel.KEY_ADDRESS_2);
        this.A = jSONObject.optString("CITY");
        this.B = jSONObject.optString("STATE");
        this.C = jSONObject.optString("PINCODE");
        this.D = jSONObject.optString("EMAIL");
        this.f15886d = jSONObject.optString(CJRQRScanResultModel.KEY_MOBILE_NO);
        this.f15887e = jSONObject.optString("NAME");
        this.E = jSONObject.optString(CJRQRScanResultModel.KEY_EXPIRY_DATE);
        this.f15888f = jSONObject.optString(CJRQRScanResultModel.KEY_MERCHANT_NAME);
        this.H = jSONObject.optString(CJRQRScanResultModel.KEY_TAG_LINE);
        this.F = jSONObject.optString(CJRQRScanResultModel.KEY_CURRENCY, "INR");
        this.G = jSONObject.optString(CJRQRScanResultModel.KEY_MSISDN, b.l(context));
        this.N = jSONObject.optString(CJRQRScanResultModel.KEY_MAPPING_ID);
        this.f15890h = jSONObject.optString("posId");
        this.P = jSONObject.optString(CJRQRScanResultModel.KEY_QR_CODE_ID);
        this.R = jSONObject.optString(CJRQRScanResultModel.KEY_ID);
        this.Q = jSONObject.optString(CJRQRScanResultModel.KEY_LINK_TYPE);
        this.O = jSONObject.optString(CJRQRScanResultModel.KEY_MERCHANT_STATUS);
        JSONObject optJSONObject = this.f15891i.optJSONObject("extendedInfo");
        if (optJSONObject != null) {
            this.J = optJSONObject.optString(CJRQRScanResultModel.KEY_LOGO_URL);
            this.K = optJSONObject.optBoolean(CJRQRScanResultModel.KEY_IS_GOLD);
        }
    }
}
