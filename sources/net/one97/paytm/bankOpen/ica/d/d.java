package net.one97.paytm.bankOpen.ica.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.bankOpen.ica.c.a;
import net.one97.paytm.bankOpen.ica.model.EntityToSolutionsMap;
import net.one97.paytm.bankOpen.ica.model.ICALoanModel;
import net.one97.paytm.bankOpen.ica.model.ICAUpdateLeadResponse;
import net.one97.paytm.bankOpen.ica.model.Option;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends ai {

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16604a;

        a(x.e eVar) {
            this.f16604a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = c.f16215d;
            ((y) this.f16604a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<c<Object>> a() {
        ArrayList<ICALoanModel> c2;
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        g.b aVar2 = new a(eVar);
        g.a bVar = new b(eVar);
        k.c(aVar2, "responseListener");
        k.c(bVar, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String D = net.one97.paytm.bankCommon.utils.d.D();
        net.one97.paytm.bankOpen.c a2 = f.a();
        k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
        Context applicationContext = a2.getApplicationContext();
        if (!TextUtils.isEmpty(com.paytm.utility.d.a(applicationContext))) {
            String a3 = k.a(D, (Object) "?entityType=INDIVIDUAL&solutionType=limited_ca");
            Map hashMap = new HashMap();
            hashMap.put("applanguage", "en");
            hashMap.put("X-SRC", UpiConstants.B2C_ANDROID);
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            String a4 = com.paytm.utility.d.a(applicationContext);
            k.a((Object) a4, "CJRNetUtility.getSSOToken(context)");
            hashMap.put("session_token", a4);
            net.one97.paytm.bankOpen.c a5 = f.a();
            k.a((Object) a5, "PaymentBankAccOpenHelper.getImplListener()");
            String A = com.paytm.utility.b.A(a5.getApplicationContext());
            k.a((Object) A, "CJRAppCommonUtility.getD…ner().applicationContext)");
            hashMap.put("deviceIdentifier", A);
            hashMap.put("client", "ANDROID");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            a.C0240a aVar3 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            Boolean valueOf = a.C0240a.a() != null ? Boolean.valueOf(net.one97.paytm.bankOpen.ica.c.a.f()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                a.C0240a aVar4 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                Integer valueOf2 = (a.C0240a.a() == null || (c2 = net.one97.paytm.bankOpen.ica.c.a.c()) == null) ? null : Integer.valueOf(c2.size());
                if (valueOf2 == null) {
                    k.a();
                }
                if (valueOf2.intValue() > 0) {
                    a.C0240a aVar5 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                    ArrayList<ICALoanModel> c3 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.c() : null;
                    if (c3 != null) {
                        Iterator<ICALoanModel> it2 = c3.iterator();
                        while (it2.hasNext()) {
                            ICALoanModel next = it2.next();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, next.getAccountNumber());
                            jSONObject2.put("bankName", next.getBankName());
                            jSONObject2.put("branchName", next.getBranchName());
                            jSONObject2.put("currentPrincipalOutstanding", next.getCurrentPrincipalOutstanding());
                            jSONObject2.put("ifscCode", next.getIfscCode());
                            jSONObject2.put("loanAmount", next.getLoanAmount());
                            jSONObject2.put("typeOfLoan", next.getTypeOfLoan());
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
            }
            a.C0240a aVar6 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            Boolean valueOf3 = a.C0240a.a() != null ? Boolean.valueOf(net.one97.paytm.bankOpen.ica.c.a.f()) : null;
            if (valueOf3 == null) {
                k.a();
            }
            jSONObject.put("creditFacilityWithOtherBank", valueOf3.booleanValue());
            jSONObject.put("creditBankFacilityDetails", jSONArray);
            jSONObject.put("creditFacilityDocRequired", false);
            a.C0240a aVar7 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if ((a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.d() : null) != null) {
                JSONArray jSONArray2 = new JSONArray();
                a.C0240a aVar8 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                NomineeModel d2 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.d() : null;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("city", d2 != null ? d2.getCity() : null);
                jSONObject4.put("landMark", "");
                jSONObject4.put(AddEditGstinViewModelKt.BODY_PARAM_LINE1, d2 != null ? d2.getHouseNo() : null);
                jSONObject4.put(AddEditGstinViewModelKt.BODY_PARAM_LINE2, d2 != null ? d2.getStreetName() : null);
                jSONObject4.put(AddEditGstinViewModelKt.BODY_PARAM_LINE3, d2 != null ? d2.getAreaName() : null);
                jSONObject4.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, d2 != null ? d2.getPinCode() : null);
                jSONObject4.put("state", d2 != null ? d2.getState() : null);
                jSONObject3.put("dob", d2 != null ? d2.getDob() : null);
                jSONObject3.put(AppConstants.KEY_EMAIL, d2 != null ? d2.getEmail() : null);
                jSONObject3.put("isChecked", false);
                jSONObject3.put("name", d2 != null ? d2.getName() : null);
                jSONObject3.put("relation", d2 != null ? d2.getRelationship() : null);
                jSONObject3.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, jSONObject4);
                jSONArray2.put(jSONObject3);
                jSONObject.put("nomineeList", jSONArray2);
            }
            a.C0240a aVar9 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            HashMap<String, Option> b2 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.b() : null;
            if (b2 != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry next2 : b2.entrySet()) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("questionAlias", next2.getKey());
                    jSONObject5.put("answerAlias", next2.getValue());
                    jSONObject5.put("answerAliasList", (Object) null);
                    jSONArray3.put(jSONObject5);
                }
                jSONObject.put("questionAnswerList", jSONArray3);
            }
            ICAUpdateLeadResponse iCAUpdateLeadResponse = new ICAUpdateLeadResponse(false, false, (EntityToSolutionsMap) null, (String) null, (String) null, 31, (kotlin.g.b.g) null);
            HashMap hashMap2 = new HashMap();
            String simpleName = aVar.getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap2.put("screen_name", simpleName);
            IJRPaytmDataModel iJRPaytmDataModel = iCAUpdateLeadResponse;
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(a3, (g.b<IJRPaytmDataModel>) aVar2, bVar, iJRPaytmDataModel, (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            if (com.paytm.utility.b.c(applicationContext)) {
                k.a((Object) applicationContext, "context");
                applicationContext.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(bVar2);
            } else {
                bVar.onErrorResponse(-1, iJRPaytmDataModel2, new NetworkCustomError());
            }
        }
        return (y) eVar.element;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16605a;

        b(x.e eVar) {
            this.f16605a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16605a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
