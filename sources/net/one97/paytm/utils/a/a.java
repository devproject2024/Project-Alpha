package net.one97.paytm.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;

public final class a implements Response.ErrorListener, Response.Listener<IJRDataModel>, com.paytm.network.listener.b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f69593c;

    /* renamed from: a  reason: collision with root package name */
    public b f69594a;

    /* renamed from: b  reason: collision with root package name */
    public String f69595b;

    /* renamed from: d  reason: collision with root package name */
    private C1407a f69596d;

    /* renamed from: net.one97.paytm.utils.a.a$a  reason: collision with other inner class name */
    public interface C1407a {
        void a(int i2);
    }

    public interface b {
        void onBankStatus(int i2, String str);
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (iJRDataModel instanceof CustProductList) {
            CustProductList custProductList = (CustProductList) iJRDataModel;
            net.one97.paytm.utils.a aVar = net.one97.paytm.utils.a.DEFAULT;
            if (!TextUtils.isEmpty(custProductList.getIsaStatus())) {
                if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
                    aVar = net.one97.paytm.utils.a.NOT_APPLIED;
                    b.h(CJRJarvisApplication.getAppContext());
                } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
                    aVar = net.one97.paytm.utils.a.PROCESSING;
                    b.i(CJRJarvisApplication.getAppContext());
                } else if (custProductList.getIsaStatus().equals("ISSUED")) {
                    aVar = net.one97.paytm.utils.a.ISSUED;
                    b.j(CJRJarvisApplication.getAppContext());
                    this.f69595b = custProductList.getIsaAccNum();
                }
            }
            C1407a aVar2 = this.f69596d;
            if (aVar2 != null) {
                aVar2.a(aVar.getNumVal());
                this.f69596d = null;
            }
            b bVar = this.f69594a;
            if (bVar != null) {
                bVar.onBankStatus(aVar.getNumVal(), this.f69595b);
                this.f69594a = null;
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (f69593c == null) {
            f69593c = new a();
        }
        return f69593c;
    }

    public final void a(Context context, C1407a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f69596d = aVar;
        if (b.b(applicationContext)) {
            aVar.a(net.one97.paytm.utils.a.ISSUED.getNumVal());
            this.f69596d = null;
        } else if (com.paytm.utility.a.m(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.payments.b.a.a.a(context, this, a.c.ADDMONEY, a.b.USER_FACING, hashMap).a();
        }
    }

    public final void onErrorResponse(VolleyError volleyError) {
        C1407a aVar = this.f69596d;
        if (aVar != null) {
            aVar.a(net.one97.paytm.utils.a.DEFAULT.getNumVal());
            this.f69596d = null;
        }
        b bVar = this.f69594a;
        if (bVar != null) {
            bVar.onBankStatus(net.one97.paytm.utils.a.DEFAULT.getNumVal(), "");
            this.f69594a = null;
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CustProductList) {
            CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
            net.one97.paytm.utils.a aVar = net.one97.paytm.utils.a.DEFAULT;
            if (!TextUtils.isEmpty(custProductList.getIsaStatus())) {
                if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
                    aVar = net.one97.paytm.utils.a.NOT_APPLIED;
                    b.h(CJRJarvisApplication.getAppContext());
                } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
                    aVar = net.one97.paytm.utils.a.PROCESSING;
                    b.i(CJRJarvisApplication.getAppContext());
                } else if (custProductList.getIsaStatus().equals("ISSUED")) {
                    aVar = net.one97.paytm.utils.a.ISSUED;
                    b.j(CJRJarvisApplication.getAppContext());
                    this.f69595b = custProductList.getIsaAccNum();
                }
            }
            C1407a aVar2 = this.f69596d;
            if (aVar2 != null) {
                aVar2.a(aVar.getNumVal());
                this.f69596d = null;
            }
            b bVar = this.f69594a;
            if (bVar != null) {
                bVar.onBankStatus(aVar.getNumVal(), this.f69595b);
                this.f69594a = null;
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        C1407a aVar = this.f69596d;
        if (aVar != null) {
            aVar.a(net.one97.paytm.utils.a.DEFAULT.getNumVal());
            this.f69596d = null;
        }
        b bVar = this.f69594a;
        if (bVar != null) {
            bVar.onBankStatus(net.one97.paytm.utils.a.DEFAULT.getNumVal(), "");
            this.f69594a = null;
        }
    }
}
