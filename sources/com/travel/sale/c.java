package com.travel.sale;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.d;
import com.travel.sale.data.model.CampaignDetailsResponse;
import com.travel.sale.data.model.CampaignSubscriptionResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    y<CampaignDetailsResponse> f25733a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    y<com.travel.sale.data.model.a> f25734b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    y<CampaignSubscriptionResponse> f25735c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    y<com.travel.sale.data.model.a> f25736d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    y<CampaignSubscriptionResponse> f25737e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    y<com.travel.sale.data.model.a> f25738f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    com.travel.sale.data.a f25739g = new com.travel.sale.data.a();

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25740a;

        a(c cVar) {
            this.f25740a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f25740a.f25734b.setValue(new com.travel.sale.data.model.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CampaignDetailsResponse)) {
                this.f25740a.f25733a.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void a(Context context, String str) {
        com.paytm.network.b bVar;
        k.c(str, "campaignId");
        if (context != null && this.f25739g != null) {
            com.paytm.network.listener.b aVar = new a(this);
            k.c(context, "context");
            k.c(aVar, "paytmCommonApiListener");
            k.c(str, "campaignId");
            StringBuilder sb = new StringBuilder();
            k.a((Object) d.a(), "TravelController.getInstance()");
            sb.append(d.b().a("getTravelCampaignDetails"));
            sb.append(str);
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2) || context == null) {
                bVar = null;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.putAll(com.travel.sale.data.a.a(context));
                bVar = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_sales_campaign_details").a(a.C0715a.GET).a(Uri.parse(sb2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CampaignDetailsResponse()).a(aVar);
            }
            if (bVar != null) {
                com.paytm.network.a l = bVar.l();
                if (l != null) {
                    l.b(true);
                }
                if (l != null) {
                    l.a();
                    return;
                }
                return;
            }
            aVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
        }
    }

    /* renamed from: com.travel.sale.c$c  reason: collision with other inner class name */
    public static final class C0481c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25742a;

        C0481c(c cVar) {
            this.f25742a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f25742a.f25736d.setValue(new com.travel.sale.data.model.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CampaignSubscriptionResponse)) {
                this.f25742a.f25735c.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void a(Context context, String str, boolean z) {
        k.c(str, "campaignId");
        if (context != null && this.f25739g != null) {
            com.travel.sale.data.a.a(context, (com.paytm.network.listener.b) new C0481c(this), str, z);
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25741a;

        b(c cVar) {
            this.f25741a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f25741a.f25738f.setValue(new com.travel.sale.data.model.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CampaignSubscriptionResponse)) {
                this.f25741a.f25737e.setValue(iJRPaytmDataModel);
            }
        }
    }
}
