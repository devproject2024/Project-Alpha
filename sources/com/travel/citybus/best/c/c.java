package com.travel.citybus.best.c;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.best.b.c;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.best.model.BestTokenIssueParams;
import com.travel.citybus.brts.f;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import com.travel.citybus.brts.model.pojo.CJRRouteInfoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    final c.a f23048a;

    public c(c.a aVar) {
        k.c(aVar, "view");
        this.f23048a = aVar;
    }

    public final void a(Context context, CJRRouteInfoModel cJRRouteInfoModel, o<String, String> oVar, ArrayList<CJRBrtsPaxInfo> arrayList) {
        k.c(context, "context");
        k.c(oVar, "stops");
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusTokenUrl");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.travel.citybus.brts.a.m;
        }
        String str = a2;
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        BestTokenIssueParams bestTokenIssueParams = new BestTokenIssueParams();
        bestTokenIssueParams.setUserId(com.paytm.utility.b.n(context));
        bestTokenIssueParams.setSource(oVar.getFirst());
        bestTokenIssueParams.setDestination(oVar.getSecond());
        String str2 = null;
        bestTokenIssueParams.setRouteId(cJRRouteInfoModel != null ? cJRRouteInfoModel.getMerchantRouteId() : null);
        if (cJRRouteInfoModel != null) {
            str2 = cJRRouteInfoModel.getRouteName();
        }
        bestTokenIssueParams.setRouteName(str2);
        if (arrayList != null) {
            Iterator<CJRBrtsPaxInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRBrtsPaxInfo next = it2.next();
                int intValue = bestTokenIssueParams.getPassengerCount().intValue();
                k.a((Object) next, "pax");
                bestTokenIssueParams.setPassengerCount(Integer.valueOf(intValue + next.getCount()));
            }
        }
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str, (Map) null, hashMap, new com.google.gson.f().b(bestTokenIssueParams), new BestEPurseTokenResponse(), new a(this));
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23049a;

        a(c cVar) {
            this.f23049a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23049a.f23048a.a(false);
            this.f23049a.f23048a.b(com.travel.citybus.best.e.a.a(networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
                BestEPurseTokenResponse bestEPurseTokenResponse = (BestEPurseTokenResponse) iJRPaytmDataModel;
                BestEPurse response = bestEPurseTokenResponse.getResponse();
                if ((response != null ? response.getToken() : null) != null) {
                    c.a aVar = this.f23049a.f23048a;
                    if (aVar != null) {
                        aVar.a(bestEPurseTokenResponse.getResponse());
                        return;
                    }
                    return;
                }
                this.f23049a.f23048a.b(bestEPurseTokenResponse.getStatusMessage());
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f23048a.a(false);
        this.f23048a.c();
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        c.a aVar;
        BestToken token;
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof BestEPurseTokenResponse)) {
            BestEPurseTokenResponse bestEPurseTokenResponse = (BestEPurseTokenResponse) iJRPaytmDataModel;
            BestEPurse response = bestEPurseTokenResponse.getResponse();
            String str = null;
            if ((response != null ? response.getToken() : null) != null) {
                BestEPurse response2 = bestEPurseTokenResponse.getResponse();
                if (!(response2 == null || (token = response2.getToken()) == null)) {
                    str = token.getStatus();
                }
                if (k.a((Object) str, (Object) com.travel.citybus.best.a.b.INVALID.name()) && (aVar = this.f23048a) != null) {
                    aVar.S_();
                    return;
                }
                return;
            }
            this.f23048a.c();
        }
    }
}
