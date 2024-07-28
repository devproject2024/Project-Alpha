package net.one97.paytm.payments.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.payments.activity.AJREnterPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.AJRNomineeDetails;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class j extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    String f17238a;

    /* renamed from: b  reason: collision with root package name */
    CustProductList f17239b;

    /* renamed from: c  reason: collision with root package name */
    private H5Event f17240c;

    /* renamed from: d  reason: collision with root package name */
    private Context f17241d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.phoenix.api.b f17242e;

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f17243a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f17244b;

        a(j jVar, Activity activity) {
            this.f17243a = jVar;
            this.f17244b = activity;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof IsaDetailsModel) {
                j.a(this.f17243a, this.f17244b, ((IsaDetailsModel) iJRPaytmDataModel).getNomineeList());
            }
        }
    }

    static final class c<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17246a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f17247b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17248c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f17249d;

        c(Activity activity, j jVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
            this.f17246a = activity;
            this.f17247b = jVar;
            this.f17248c = bVar;
            this.f17249d = h5Event;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof CustProductList) {
                j jVar = this.f17247b;
                CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
                jVar.f17239b = custProductList;
                net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
                jVar.f17238a = net.one97.paytm.paymentsBank.utils.a.a(custProductList, true);
                if (TextUtils.isEmpty(this.f17247b.f17238a)) {
                    return;
                }
                if (net.one97.paytm.paymentsBank.utils.j.a().equals("ISA")) {
                    j jVar2 = this.f17247b;
                    Activity activity = this.f17246a;
                    HashMap hashMap = new HashMap();
                    String simpleName = jVar2.getClass().getSimpleName();
                    k.a((Object) simpleName, "javaClass.simpleName");
                    hashMap.put("screen_name", simpleName);
                    Context context = activity;
                    f a2 = net.one97.paytm.paymentsBank.b.a.a(context, com.paytm.utility.d.a(context), jVar2.f17238a, new a(jVar2, activity), new b(jVar2), a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
                    k.a((Object) a2, "PaymentBankAPIRequestFac…additionalParam\n        )");
                    a2.a("isaDetailsApi");
                    activity.getApplicationContext();
                    net.one97.paytm.bankCommon.g.c.a();
                    net.one97.paytm.bankCommon.g.c.a(a2);
                } else if (net.one97.paytm.paymentsBank.utils.j.a().equals("ICA")) {
                    j.a(this.f17247b, this.f17246a, custProductList.getIca().getNominees());
                }
            }
        }
    }

    public j() {
        super("openNomineeScreen");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return false;
        }
        Context baseContext = activity.getBaseContext();
        k.a((Object) baseContext, "activity.baseContext");
        this.f17241d = baseContext;
        this.f17242e = bVar;
        this.f17240c = h5Event;
        HashMap hashMap = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) activity, (g.b<IJRPaytmDataModel>) new c(activity, this, bVar, h5Event), (g.a) new d(this, bVar, h5Event), a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
        a2.a("custProductListApi");
        activity.getApplicationContext();
        net.one97.paytm.bankCommon.g.c.a();
        net.one97.paytm.bankCommon.g.c.a(a2);
        return true;
    }

    static final class d implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f17250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17251b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f17252c;

        d(j jVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
            this.f17250a = jVar;
            this.f17251b = bVar;
            this.f17252c = h5Event;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f17250a.a();
        }
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f17245a;

        b(j jVar) {
            this.f17245a = jVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f17245a.a();
        }
    }

    private final void b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "true");
        net.one97.paytm.phoenix.api.b bVar = this.f17242e;
        if (bVar == null) {
            k.a("mBridgeContext");
        }
        if (bVar != null) {
            H5Event h5Event = this.f17240c;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "false");
        Context context = this.f17241d;
        if (context == null) {
            k.a("context");
        }
        String string = context.getString(R.string.error);
        Context context2 = this.f17241d;
        if (context2 == null) {
            k.a("context");
        }
        jSONObject.put(string, context2.getString(R.string.pb_something_wrong_try_again));
        net.one97.paytm.phoenix.api.b bVar = this.f17242e;
        if (bVar == null) {
            k.a("mBridgeContext");
        }
        if (bVar != null) {
            H5Event h5Event = this.f17240c;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }

    public static final /* synthetic */ void a(j jVar, Activity activity, List list) {
        if (list != null ? !list.isEmpty() : false) {
            if (!TextUtils.isEmpty(jVar.f17238a)) {
                Intent intent = new Intent(activity, AJRNomineeDetails.class);
                intent.putExtra("NOMINEE_ITEM", list != null ? (NomineeModel) list.get(0) : null);
                intent.putExtra("extra_account_number", jVar.f17238a);
                intent.putExtra("isEditable", true);
                activity.startActivityForResult(intent, 110);
                jVar.b();
                return;
            }
        } else if (!net.one97.paytm.paymentsBank.utils.j.a().equals("ICA")) {
            CustProductList custProductList = jVar.f17239b;
            if (custProductList == null) {
                k.a("mCustomerProductList");
            }
            if (custProductList != null) {
                Context context = activity;
                if (net.one97.paytm.bankCommon.h.b.a(context)) {
                    Intent intent2 = new Intent(context, PaymentsBankBaseActivity.class);
                    intent2.putExtra("extraDefaultFrame", 2);
                    intent2.putExtra("DO_CREATE_ACCOUNT", false);
                    intent2.putExtra("ACCOUNT_NUMBER", jVar.f17238a);
                    activity.startActivity(intent2);
                    jVar.b();
                    return;
                }
                activity.startActivityForResult(new Intent(context, AJREnterPasscode.class), 123);
                jVar.b();
                return;
            }
        }
        jVar.a();
    }
}
