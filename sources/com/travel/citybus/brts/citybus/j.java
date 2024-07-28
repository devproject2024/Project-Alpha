package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.net.Uri;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestRecentResponse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.brts.citybus.x;
import com.travel.citybus.brts.model.CJRAmountPax;
import com.travel.citybus.brts.model.CJRBCLLData;
import com.travel.citybus.brts.model.pojo.CJRCity;
import com.travel.citybus.brts.model.pojo.CJRCityResponseModel;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class j implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public BestEPurseTokenResponse f23298a;

    /* renamed from: b  reason: collision with root package name */
    public final x.a f23299b;

    public j(x.a aVar) {
        k.c(aVar, "view");
        this.f23299b = aVar;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f23302a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f23303b;

        public b(j jVar, Context context) {
            this.f23302a = jVar;
            this.f23303b = context;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23302a.f23299b.showError(this.f23303b.getString(R.string.brts_some_went_wrong));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof BestRecentResponse) {
                this.f23302a.f23299b.showRecentBookedTickets((BestRecentResponse) iJRPaytmDataModel);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f23299b.showError("Something went wrong, please try again after some time");
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        BestEPurse response;
        BestEPurse response2;
        if (iJRPaytmDataModel != null) {
            this.f23299b.lottieLayoutGone();
            this.f23299b.showInternetIssue(false);
            if (iJRPaytmDataModel instanceof CJRCityResponseModel) {
                List<CJRCity> list = ((CJRCityResponseModel) iJRPaytmDataModel).getResponse().getList();
                if (list != null) {
                    List list2 = (ArrayList) list;
                    k.c(list2, "result");
                    this.f23299b.setCityListForBottomSheet(list2);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.citybus.brts.model.pojo.CJRCity> /* = java.util.ArrayList<com.travel.citybus.brts.model.pojo.CJRCity> */");
                }
            }
            if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
                this.f23298a = (BestEPurseTokenResponse) iJRPaytmDataModel;
                x.a aVar = this.f23299b;
                BestEPurseTokenResponse bestEPurseTokenResponse = this.f23298a;
                BestToken bestToken = null;
                aVar.showEPurseData(bestEPurseTokenResponse != null ? bestEPurseTokenResponse.getResponse() : null);
                x.a aVar2 = this.f23299b;
                BestEPurseTokenResponse bestEPurseTokenResponse2 = this.f23298a;
                aVar2.showActiveToken((bestEPurseTokenResponse2 == null || (response2 = bestEPurseTokenResponse2.getResponse()) == null) ? null : response2.getToken());
                x.a aVar3 = this.f23299b;
                BestEPurseTokenResponse bestEPurseTokenResponse3 = this.f23298a;
                if (!(bestEPurseTokenResponse3 == null || (response = bestEPurseTokenResponse3.getResponse()) == null)) {
                    bestToken = response.getActiveTicket();
                }
                aVar3.showActiveTicket(bestToken);
            }
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f23300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f23301b;

        public a(j jVar, Context context) {
            this.f23300a = jVar;
            this.f23301b = context;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJRBCLLData) {
                CJRBCLLData cJRBCLLData = (CJRBCLLData) iJRPaytmDataModel;
                boolean z = true;
                if (p.a(cJRBCLLData.getStatus(), "SUCCESS", true)) {
                    CJRAmountPax.CJRBCLLResponse response = cJRBCLLData.getResponse();
                    response.setRequestId(cJRBCLLData.getRequestId());
                    CharSequence charSequence = response.getmMerchantName();
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        CharSequence charSequence2 = response.getmDisplayMerchantName();
                        if (!(charSequence2 == null || charSequence2.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            this.f23300a.f23299b.showMerchantName(response.getmDisplayMerchantName());
                            x.a aVar = this.f23300a.f23299b;
                            k.a((Object) response, "cjrbcllResponse");
                            aVar.setBCLLData(response);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f23300a.f23299b.showError(cJRBCLLData.getStatusMessage());
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f23300a.f23299b.showError(this.f23301b.getString(R.string.brts_some_went_wrong));
        }
    }

    public static String a(String str) {
        k.c(str, "deepLinkUri");
        try {
            Uri parse = Uri.parse(c(str));
            k.a((Object) parse, "Uri.parse(url)");
            return parse.getQueryParameter("city");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        k.c(str, "deepLinkUri");
        try {
            Uri parse = Uri.parse(c(str));
            k.a((Object) parse, "Uri.parse(url)");
            return parse.getQueryParameter("merchantSourceId");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        String str2;
        k.c(str, "deepLinkUri");
        try {
            String query = new URI(str).getQuery();
            k.a((Object) query, "URI(deepLinkUri).query");
            str2 = p.a(query, "url=");
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            str2 = null;
        }
        return String.valueOf(str2);
    }
}
