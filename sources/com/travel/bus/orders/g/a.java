package com.travel.bus.orders.g;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.travel.bus.a.a;
import com.travel.bus.a.d;
import com.travel.bus.a.j;
import com.travel.bus.busticket.i.y;
import com.travel.bus.orders.f.h;
import com.travel.bus.orders.f.i;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.hotel.CJRHotelObject;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public final class a implements d, h {

    /* renamed from: a  reason: collision with root package name */
    public i f22634a;

    /* renamed from: b  reason: collision with root package name */
    CJRHotelObject f22635b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22636c;

    /* renamed from: d  reason: collision with root package name */
    private CJRBusOrderSummary f22637d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.bus.a.i f22638e;

    /* renamed from: f  reason: collision with root package name */
    private j f22639f;

    public a(Context context) {
        this.f22636c = context;
        if (this.f22636c != null) {
            y yVar = y.f22482a;
            y.a(CJRHotelObject.class).subscribe(new w<CJRHotelObject>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onSubscribe(c cVar) {
                }

                public final /* bridge */ /* synthetic */ void onNext(Object obj) {
                    a.this.f22635b = (CJRHotelObject) obj;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Error! Context can not be null.");
    }

    public final void a(i iVar) {
        this.f22634a = iVar;
        if (this.f22634a == null) {
            throw new IllegalArgumentException("Error! UI Listener can not be null.");
        }
    }

    public final void a(String str) {
        com.travel.bus.a.a();
        String str2 = com.travel.bus.a.b().N() + str + "/detail?";
        HashMap hashMap = new HashMap();
        hashMap.put("actions", "1");
        hashMap.put("item_tracking", "0");
        hashMap.put("single_card", "false");
        HashMap hashMap2 = new HashMap();
        b.a((HashMap<String, String>) hashMap2, this.f22636c);
        this.f22638e = new com.travel.bus.a.i(this.f22636c, str2, hashMap2, hashMap, new CJRBusOrderSummary(), this);
        com.travel.bus.a.i iVar = this.f22638e;
        iVar.f21498a = false;
        iVar.f21498a = true;
        iVar.f21500c = true;
        iVar.f21499b = true;
        if (iVar != null && str2 != null) {
            iVar.a(str2, hashMap);
            iVar.a();
        }
    }

    public final void b() {
        this.f22634a = null;
    }

    public final CJRBusOrderSummary c() {
        return this.f22637d;
    }

    public final CJRHotelObject d() {
        return this.f22635b;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        i iVar = this.f22634a;
        if (iVar != null) {
            if (iJRPaytmDataModel instanceof CJRBusOrderSummary) {
                iVar.f();
                CJRBusOrderSummary cJRBusOrderSummary = (CJRBusOrderSummary) iJRPaytmDataModel;
                this.f22637d = cJRBusOrderSummary;
                CJRBusOrderSummary cJRBusOrderSummary2 = this.f22637d;
                if (cJRBusOrderSummary2 != null && cJRBusOrderSummary2.getPaymentInfo() != null && this.f22637d.getPaymentInfo().size() > 0 && !TextUtils.isEmpty(this.f22637d.getPaymentInfo().get(0).getTransactionNumber())) {
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(this.f22636c, this.f22637d.getPaymentInfo().get(0).getTransactionNumber(), Double.valueOf(this.f22637d.getPaymentInfo().get(0).getPgAmount()));
                }
                this.f22634a.b(cJRBusOrderSummary);
            } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
                iVar.a((CJRActionResponse) iJRPaytmDataModel);
            }
        }
    }

    public final void a() {
        i iVar = this.f22634a;
        if (iVar != null) {
            iVar.f();
        }
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        if (cJROrderSummaryAction != null && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
            a.C0429a aVar = a.C0429a.GET;
            if (!TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getMethod()) && cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                aVar = a.C0429a.POST;
            }
            String url = cJROrderSummaryAction.getUrlParams().getUrl();
            CJRActionResponse cJRActionResponse = new CJRActionResponse();
            cJRActionResponse.setRequestUrl(url);
            this.f22639f = new j(this.f22636c, aVar, url, cJRActionResponse, this);
            j jVar = this.f22639f;
            jVar.f21498a = true;
            jVar.f21500c = true;
            if (jVar != null && url != null) {
                jVar.a(url, (HashMap) null);
                jVar.a();
            }
        }
    }
}
