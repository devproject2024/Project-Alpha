package net.one97.paytm.moneytransfer.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.c;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.a;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.CustProductListV2;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class k implements Response.ErrorListener, Response.Listener<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f54164a;

    /* renamed from: b  reason: collision with root package name */
    protected Fragment f54165b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f54166c;

    /* renamed from: d  reason: collision with root package name */
    private String f54167d;

    /* renamed from: e  reason: collision with root package name */
    private String f54168e;

    /* renamed from: f  reason: collision with root package name */
    private String f54169f;

    /* renamed from: g  reason: collision with root package name */
    private String f54170g;

    /* renamed from: h  reason: collision with root package name */
    private String f54171h;

    /* renamed from: i  reason: collision with root package name */
    private String f54172i;
    private String j;
    private String k;
    private boolean l;
    private boolean m = true;
    private a n;
    private boolean o = false;
    private CommonPayParams p;

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            e();
            CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) iJRPaytmDataModel;
            Activity activity = this.f54164a;
            if (activity != null && !activity.isFinishing() && cJRMoneyTransferIMPSInitiateDataModel != null && cJRMoneyTransferIMPSInitiateDataModel.getmStatus() != null) {
                if (cJRMoneyTransferIMPSInitiateDataModel.getmStatus() != null) {
                    cJRMoneyTransferIMPSInitiateDataModel.getmStatus();
                }
                if (cJRMoneyTransferIMPSInitiateDataModel.getMessage() != null) {
                    cJRMoneyTransferIMPSInitiateDataModel.getMessage();
                }
                String str = cJRMoneyTransferIMPSInitiateDataModel.getmStatus() != null ? cJRMoneyTransferIMPSInitiateDataModel.getmStatus() : "";
                new StringBuilder().append(cJRMoneyTransferIMPSInitiateDataModel.getResponse_code());
                if (str.equalsIgnoreCase("SUCCESS")) {
                    a aVar = this.n;
                    if (aVar != null) {
                        aVar.a(cJRMoneyTransferIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("failed") || str.equalsIgnoreCase("FAILURE")) {
                    a aVar2 = this.n;
                    if (aVar2 != null) {
                        aVar2.a(cJRMoneyTransferIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("PENDING")) {
                    a aVar3 = this.n;
                    if (aVar3 != null) {
                        aVar3.a(cJRMoneyTransferIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("passcode_required")) {
                    Intent intent = null;
                    try {
                        intent = d.c().b(this.f54164a);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    intent.putExtra("imps_passcode_flow", true);
                    intent.putExtra("ENTER_HEADER", cJRMoneyTransferIMPSInitiateDataModel.getMessage());
                    intent.putExtra("imps_data", cJRMoneyTransferIMPSInitiateDataModel);
                    this.f54165b.startActivityForResult(intent, 3333);
                } else if (!str.equalsIgnoreCase("need_verify")) {
                } else {
                    if (this.f54165b != null) {
                        d.c().a(this.f54165b, cJRMoneyTransferIMPSInitiateDataModel);
                    } else {
                        d.c().a(this.f54164a, cJRMoneyTransferIMPSInitiateDataModel);
                    }
                }
            }
        }
    }

    public k(Activity activity, a aVar, CommonPayParams commonPayParams) {
        this.f54164a = activity;
        this.n = aVar;
        this.p = commonPayParams;
    }

    public k(Fragment fragment, a aVar, CommonPayParams commonPayParams) {
        this.f54165b = fragment;
        this.f54164a = fragment.getActivity();
        this.n = aVar;
        this.p = commonPayParams;
    }

    public final void a() {
        this.o = true;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Activity activity = this.f54164a;
        if (activity != null && !activity.isFinishing()) {
            this.f54167d = str;
            this.f54168e = str2;
            this.f54169f = str3;
            this.f54170g = str4;
            this.f54171h = str5;
            this.f54172i = str6;
            this.j = str7;
            this.k = str8;
            this.l = false;
            if (str9 == null) {
                d();
                b.a(this.f54164a.getApplicationContext()).b(new a.C0960a() {
                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CustProductListV2) {
                            CustProductListV2 custProductListV2 = (CustProductListV2) iJRPaytmDataModel;
                            if (custProductListV2.getStatus().equalsIgnoreCase("SUCCESS") && custProductListV2.isSuccess() && custProductListV2.getResponse() != null) {
                                String isaStatus = custProductListV2.getResponse().getIsaStatus();
                                char c2 = 65535;
                                switch (isaStatus.hashCode()) {
                                    case -2125830485:
                                        if (isaStatus.equals("ISSUED")) {
                                            c2 = 6;
                                            break;
                                        }
                                        break;
                                    case -1757359925:
                                        if (isaStatus.equals("INITIATED")) {
                                            c2 = 4;
                                            break;
                                        }
                                        break;
                                    case -604548089:
                                        if (isaStatus.equals("IN_PROGRESS")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -287297839:
                                        if (isaStatus.equals("NOT_APPLIED")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 2332508:
                                        if (isaStatus.equals("LEAD")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case 35394935:
                                        if (isaStatus.equals("PENDING")) {
                                            c2 = 5;
                                            break;
                                        }
                                        break;
                                    case 2066319421:
                                        if (isaStatus.equals("FAILED")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                    case 1:
                                        d.c().a(d.c().a(), a.NOT_APPLIED.getNumVal());
                                        return;
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                        d.c().a(d.c().a(), a.PROCESSING.getNumVal());
                                        return;
                                    case 6:
                                        d.c().a(d.c().a(), a.ISSUED.getNumVal());
                                        k.this.a(custProductListV2.getResponse().getAccountNumber());
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    }

                    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                        k.this.c();
                    }
                }, new a.c() {
                });
                return;
            }
            a(str9);
        }
    }

    public final void b() {
        this.m = true;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        Activity activity = this.f54164a;
        if (activity != null && !activity.isFinishing()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.j);
                jSONObject.put("benAccNo", this.f54171h);
                jSONObject.put("benBankName", this.f54169f);
                jSONObject.put("benIfsc", this.f54170g);
                jSONObject.put("channel", "MOB");
                jSONObject.put("client", "androidapp");
                jSONObject.put("remAccNo", str);
                jSONObject.put("transactionType", "APP_FUND_TRANSFER");
                jSONObject.put(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
                jSONObject.put("isAddBeneficiary", this.m);
                jSONObject.put("txnReqId", com.paytm.utility.b.q());
                if (this.o) {
                    jSONObject.put(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
                }
                JSONObject d2 = c.d(this.f54164a);
                d2.put("beneficiary_name", this.f54168e);
                if (com.paytm.utility.k.b()) {
                    d2.getJSONObject("deviceInfo").put("appName", "ppb-app");
                }
                jSONObject.put("properties", d2);
                if (this.p != null && !this.p.getExtendedInfo().isEmpty()) {
                    for (Map.Entry next : this.p.getExtendedInfo().entrySet()) {
                        d2.put((String) next.getKey(), next.getValue());
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String e3 = com.paytm.utility.b.e(this.f54164a.getApplicationContext(), net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().f53990e));
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("channel", "MOB");
            hashMap.put("User-Agent", UpiConstants.B2C_ANDROID);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("userToken", com.paytm.utility.a.q(this.f54164a));
            } catch (JSONException unused) {
            }
            hashMap.put("authorization", jSONObject2.toString());
            if (com.paytm.utility.a.m(this.f54164a)) {
                d();
                f.b(this.f54164a.getApplicationContext()).add(new com.paytm.network.c(this.f54164a, a.c.MONEYTRANSFER, a.C0715a.POST, e3, hashMap, this, this, new CJRMoneyTransferIMPSInitiateDataModel(), jSONObject.toString()));
                return;
            }
            c();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        Activity activity = this.f54164a;
        if (activity != null && !activity.isFinishing()) {
            e();
            Activity activity2 = this.f54164a;
            com.paytm.utility.b.a((Context) activity2, activity2.getResources().getString(R.string.no_connection), this.f54164a.getResources().getString(R.string.no_internet));
        }
    }

    public final void onErrorResponse(VolleyError volleyError) {
        Activity activity = this.f54164a;
        if (activity != null && !activity.isFinishing()) {
            e();
            if (volleyError != null) {
                try {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError((Throwable) volleyError);
                    if (!TextUtils.isEmpty(upiCustomVolleyError.getMessage()) && (upiCustomVolleyError.getMessage().equalsIgnoreCase("410") || upiCustomVolleyError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                        d.c().a(this.f54164a, (Exception) upiCustomVolleyError, (String) null);
                    } else if (upiCustomVolleyError.getMessage() != null && !d.c().a((Context) this.f54164a, (Exception) upiCustomVolleyError)) {
                        if (upiCustomVolleyError.getMessage() == null || !upiCustomVolleyError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.b((Context) this.f54164a, this.f54164a.getResources().getString(R.string.network_error_heading), this.f54164a.getResources().getString(R.string.network_error_message) + " " + upiCustomVolleyError.getUrl());
                            return;
                        }
                        com.paytm.utility.b.d((Context) this.f54164a, upiCustomVolleyError.getUrl(), upiCustomVolleyError.getmErrorCode());
                    }
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    private void d() {
        try {
            if (this.f54166c == null) {
                this.f54166c = m.a(this.f54164a);
            }
            if (this.f54166c != null && !this.f54166c.isShowing()) {
                this.f54166c.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void e() {
        try {
            if (this.f54166c != null && this.f54166c.isShowing()) {
                this.f54166c.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }
}
