package net.one97.paytm.paymentsBank.cifCreation.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.cifCreation.a.a;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0295a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PBTncData> f17993a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f17994b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17995c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17996d;

    /* renamed from: e  reason: collision with root package name */
    private CIFCreationResponse f17997e;

    /* renamed from: f  reason: collision with root package name */
    private CIFStatusResponse f17998f;

    /* renamed from: g  reason: collision with root package name */
    private SlfdMetaApiResponseModel f17999g;

    /* renamed from: h  reason: collision with root package name */
    private final b f18000h;

    /* renamed from: i  reason: collision with root package name */
    private final a.b f18001i;

    public a(b bVar, a.b bVar2) {
        k.c(bVar, "slfdRepository");
        k.c(bVar2, "cifCreateView");
        this.f18000h = bVar;
        this.f18001i = bVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        this.f18001i.a(false);
        if (iJRPaytmDataModel instanceof CIFCreationResponse) {
            this.f17997e = (CIFCreationResponse) iJRPaytmDataModel;
            a.b bVar = this.f18001i;
            CIFCreationResponse cIFCreationResponse = this.f17997e;
            if (cIFCreationResponse == null) {
                k.a();
            }
            bVar.a(cIFCreationResponse);
        } else if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            this.f17999g = (SlfdMetaApiResponseModel) iJRPaytmDataModel;
            a.b bVar2 = this.f18001i;
            SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f17999g;
            if (slfdMetaApiResponseModel == null) {
                k.a();
            }
            bVar2.a(slfdMetaApiResponseModel);
        } else if (iJRPaytmDataModel instanceof PBCJRAccountSummary) {
            PBCJRAccountSummary pBCJRAccountSummary = (PBCJRAccountSummary) iJRPaytmDataModel;
            if (pBCJRAccountSummary.getStatus() != null && p.a(pBCJRAccountSummary.getStatus(), "success", true)) {
                this.f18001i.a(pBCJRAccountSummary.getSlfdBalance());
            }
        } else if (iJRPaytmDataModel instanceof CIFStatusResponse) {
            this.f17998f = (CIFStatusResponse) iJRPaytmDataModel;
            a.b bVar3 = this.f18001i;
            CIFStatusResponse cIFStatusResponse = this.f17998f;
            if (cIFStatusResponse == null) {
                k.a();
            }
            bVar3.a(cIFStatusResponse);
        } else if (iJRPaytmDataModel instanceof PBKYCFetchTnc) {
            this.f18001i.a(false);
            PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) iJRPaytmDataModel;
            if (pBKYCFetchTnc.getStatus() == null || !p.a(pBKYCFetchTnc.getStatus(), "error", true)) {
                if (pBKYCFetchTnc.getStatus() != null && p.a(pBKYCFetchTnc.getStatus(), "success", true) && pBKYCFetchTnc.getTncDataList() != null) {
                    this.f17993a.addAll(pBKYCFetchTnc.getTncDataList());
                    if (this.f17994b) {
                        this.f17994b = false;
                        this.f18001i.a(this.f17993a);
                        return;
                    }
                    a(true);
                }
            } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                a.b bVar4 = this.f18001i;
                String message = pBKYCFetchTnc.getMessage();
                k.a((Object) message, "response.message");
                bVar4.a("Error", message);
            }
        } else if (iJRPaytmDataModel instanceof PBKYCTncAccept) {
            this.f18001i.a(false);
            PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel;
            if (pBKYCTncAccept.getStatus() == null || !p.a(pBKYCTncAccept.getStatus(), "error", true)) {
                if (pBKYCTncAccept.getStatus() != null && p.a(pBKYCTncAccept.getStatus(), "success", true) && k.a((Object) pBKYCTncAccept.getResponseCode(), (Object) "2004")) {
                    this.f17996d = true;
                    this.f18001i.b(this.f17995c);
                }
            } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                a.b bVar5 = this.f18001i;
                String message2 = pBKYCTncAccept.getMessage();
                k.a((Object) message2, "response.message");
                bVar5.a("Error", message2);
            }
        }
    }

    public final void c() {
        if (this.f17996d) {
            this.f18001i.a(true);
            this.f18000h.e(this, this);
        } else if (this.f17993a.size() == 0) {
            b(false);
        } else {
            a(true);
        }
    }

    public final void d() {
        this.f18001i.a(true);
        this.f18000h.f(this, this);
    }

    public final void a(String str) {
        k.c(str, "accountNum");
        this.f18001i.a(true);
        this.f18000h.c(str, this, this);
    }

    public final void a() {
        this.f18000h.a(this, this);
    }

    public final void b() {
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        this.f18001i.a(false);
        a.b bVar = this.f18001i;
        if (networkCustomError == null || (str = networkCustomError.getAlertMessage()) == null) {
            str = "Some error occurred";
        }
        bVar.a("", str);
    }

    public final void b(boolean z) {
        this.f17994b = z;
        if (this.f17993a.size() > 0 && this.f17994b) {
            this.f18001i.a(this.f17993a);
        } else if (this.f17993a.size() == 0) {
            this.f18001i.a(true);
            this.f18000h.d(this, this);
        }
    }

    public final void a(boolean z) {
        this.f17995c = z;
        this.f18001i.a(true);
        this.f18000h.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f17993a);
    }
}
