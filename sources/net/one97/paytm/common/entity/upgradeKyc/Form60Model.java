package net.one97.paytm.common.entity.upgradeKyc;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.upgradeKyc.form60.a.a;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Form60Model implements Response.ErrorListener, Response.Listener<IJRDataModel>, a.C1316a {
    private static final String AGRI_INCOME = "agriculturalIncome";
    private static final String FORM60 = "form60Data";
    private static final String NON_AGRI_INCOME = "nonAgriculturalIncome";
    private static final String PAN_ACK_DATE = "panAckDate";
    private static final String PAN_ACK_NUMBER = "panAckNumber";
    /* access modifiers changed from: private */
    public a.b mPresenter;
    private ArrayList<TncData> mTncDataList;

    public Form60Model(a.b bVar) {
        this.mPresenter = bVar;
    }

    public void onDestroy() {
        if (this.mPresenter != null) {
            this.mPresenter = null;
        }
    }

    public void saveForm60DetailsApiCall(String str, String str2, String str3, String str4) {
        String str5;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str5 = d.a("kyc_save_profile_info");
        } else {
            str5 = null;
        }
        if (!URLUtil.isValidUrl(str5)) {
            this.mPresenter.c();
            return;
        }
        String e2 = b.e((Context) this.mPresenter.a(), str5);
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(this.mPresenter.a()));
        String e3 = b.e();
        String f2 = b.f();
        try {
            e.a aVar3 = e.f66028b;
            String c2 = e.a.b().c();
            hashMap.put("x-keyiv", f.a(c2, e3 + AppConstants.COLON + f2));
        } catch (Exception unused) {
        }
        CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
        cJRAadharPanSave.setIv(f2);
        cJRAadharPanSave.setKey(e3);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(NON_AGRI_INCOME, str4);
            jSONObject2.put(AGRI_INCOME, str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put(PAN_ACK_NUMBER, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put(PAN_ACK_DATE, str);
            }
            jSONObject.put(FORM60, jSONObject2);
        } catch (JSONException unused2) {
        }
        String jSONObject3 = jSONObject.toString();
        q.a(jSONObject3);
        try {
            jSONObject3 = f.a(f2, e3, jSONObject3);
        } catch (Exception unused3) {
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        e.a aVar5 = e.f66028b;
        a2.f42877a = e.a.b().a();
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = cJRAadharPanSave;
        a2.f42884h = jSONObject3;
        a2.f42880d = e2;
        a2.o = Form60Model.class.getName();
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                Form60Model.this.handleResponse(iJRPaytmDataModel);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (Form60Model.this.mPresenter != null) {
                    Form60Model.this.mPresenter.a(networkCustomError);
                }
            }
        };
        com.paytm.network.a l = a2.l();
        if (b.c((Context) this.mPresenter.a())) {
            l.a();
        }
    }

    public void saveForm60TncApiCall(ArrayList<TncData> arrayList) {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("kyc_tnc_user_url");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            this.mPresenter.c();
            return;
        }
        String e2 = b.e(this.mPresenter.a().getApplicationContext(), str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            this.mPresenter.a().getSystemService(ContactColumn.PHONE_NUMBER);
            jSONObject.put("deviceId", b.e((Context) this.mPresenter.a()));
            if (arrayList != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<TncData> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    TncData next = it2.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("code", next.getCode());
                        jSONObject2.put("version", next.getVersion());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("tnCList", jSONArray);
            }
        } catch (JSONException unused) {
        }
        String jSONObject3 = jSONObject.toString();
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this.mPresenter.a());
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        e.a aVar5 = e.f66028b;
        a3.f42877a = e.a.b().a();
        a3.f42879c = a.C0715a.PUT;
        a3.f42882f = a2;
        a3.f42885i = new KYCTncAccept();
        a3.o = Form60Model.class.getName();
        a3.f42884h = jSONObject3;
        a3.f42880d = e2;
        a3.n = a.b.USER_FACING;
        a3.j = new com.paytm.network.listener.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                Form60Model.this.handleResponse(iJRPaytmDataModel);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (Form60Model.this.mPresenter != null) {
                    Form60Model.this.mPresenter.a(networkCustomError);
                }
            }
        };
        com.paytm.network.a l = a3.l();
        if (b.c((Context) this.mPresenter.a())) {
            l.a();
            return;
        }
        a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this.mPresenter.a(), l);
    }

    public void fetchForm60TncApiCall() {
        String str;
        this.mTncDataList = new ArrayList<>();
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("form60fetchTnc");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = b.e((Context) this.mPresenter.a(), str);
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            e.a aVar4 = e.f66028b;
            Map<String, String> a2 = a.C1317a.a(e.a.b().a());
            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a3 = a.C1317a.a();
            e.a aVar6 = e.f66028b;
            a3.f42877a = e.a.b().a();
            a3.f42880d = e2;
            a3.f42879c = a.C0715a.GET;
            a3.f42882f = a2;
            a3.o = Form60Model.class.getName();
            a3.f42885i = new KYCFetchTnc();
            a3.n = a.b.USER_FACING;
            a3.j = new com.paytm.network.listener.b() {
                public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    Form60Model.this.handleResponse(iJRPaytmDataModel);
                }

                public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (Form60Model.this.mPresenter != null) {
                        Form60Model.this.mPresenter.a(networkCustomError);
                    }
                }
            };
            com.paytm.network.a l = a3.l();
            if (b.c((Context) this.mPresenter.a())) {
                l.a();
                return;
            }
            a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            a.C1317a.a((Context) this.mPresenter.a(), l);
            return;
        }
        this.mPresenter.c();
    }

    /* access modifiers changed from: private */
    public void handleResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRAadharPanSave) {
            CJRAadharPanSave cJRAadharPanSave = (CJRAadharPanSave) iJRPaytmDataModel;
            if ((!TextUtils.isEmpty(cJRAadharPanSave.getStatusMessage()) && cJRAadharPanSave.getStatusMessage().equalsIgnoreCase("success")) || (!TextUtils.isEmpty(cJRAadharPanSave.getStatusCode()) && cJRAadharPanSave.getStatusCode().equals(WebLogin.RESPONSE_CODE_SUCCESS))) {
                this.mPresenter.d();
            } else if (cJRAadharPanSave.getError() != null) {
                this.mPresenter.a(cJRAadharPanSave.getError().getErrorMsg());
            } else {
                this.mPresenter.a(cJRAadharPanSave.getErrorMessage());
            }
        } else if (iJRPaytmDataModel instanceof KYCFetchTnc) {
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
            if (kYCFetchTnc.getStatus() != null && kYCFetchTnc.getStatus().equalsIgnoreCase("success") && kYCFetchTnc.getTncDataList() != null) {
                this.mTncDataList = kYCFetchTnc.getTncDataList();
                a.b bVar = this.mPresenter;
                if (bVar != null) {
                    bVar.b(this.mTncDataList);
                }
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (kYCTncAccept.getStatus() != null && kYCTncAccept.getStatus().equalsIgnoreCase("success") && kYCTncAccept.getResponseCode().equals("2004")) {
                this.mPresenter.f();
            }
        }
    }

    public void onResponse(IJRDataModel iJRDataModel) {
        a.b bVar;
        if (iJRDataModel instanceof CJRAadharPanSave) {
            CJRAadharPanSave cJRAadharPanSave = (CJRAadharPanSave) iJRDataModel;
            if ((!TextUtils.isEmpty(cJRAadharPanSave.getStatusMessage()) && cJRAadharPanSave.getStatusMessage().equalsIgnoreCase("success")) || (!TextUtils.isEmpty(cJRAadharPanSave.getStatusCode()) && cJRAadharPanSave.getStatusCode().equals(WebLogin.RESPONSE_CODE_SUCCESS))) {
                this.mPresenter.d();
            } else if (cJRAadharPanSave.getError() != null) {
                this.mPresenter.a(cJRAadharPanSave.getError().getErrorMsg());
            } else {
                this.mPresenter.a(cJRAadharPanSave.getErrorMessage());
            }
        } else if (iJRDataModel instanceof KYCFetchTnc) {
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRDataModel;
            if (kYCFetchTnc.getStatus() != null && kYCFetchTnc.getStatus().equalsIgnoreCase("success") && kYCFetchTnc.getTncDataList() != null) {
                this.mTncDataList = kYCFetchTnc.getTncDataList();
                a.b bVar2 = this.mPresenter;
                if (bVar2 != null) {
                    bVar2.b(this.mTncDataList);
                }
            }
        } else if (iJRDataModel instanceof KYCTncAccept) {
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRDataModel;
            if (kYCTncAccept.getStatus() != null && kYCTncAccept.getStatus().equalsIgnoreCase("success") && kYCTncAccept.getResponseCode().equals("2004") && (bVar = this.mPresenter) != null) {
                bVar.f();
            }
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.mPresenter.a(volleyError);
    }
}
