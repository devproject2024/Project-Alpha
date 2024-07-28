package net.one97.paytm.paymentsBank.createfd.prefrence.c;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.paymentsBank.createfd.prefrence.b.b;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse;

public final class a implements g.a, g.b<IJRPaytmDataModel>, b.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PBTncData> f18169a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f18170b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18171c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18172d;

    /* renamed from: e  reason: collision with root package name */
    private String f18173e;

    /* renamed from: f  reason: collision with root package name */
    private FDStatusResponse f18174f;

    /* renamed from: g  reason: collision with root package name */
    private String f18175g;

    /* renamed from: h  reason: collision with root package name */
    private final net.one97.paytm.paymentsBank.slfd.a.a.b f18176h;

    /* renamed from: i  reason: collision with root package name */
    private final b.C0303b f18177i;

    public a(net.one97.paytm.paymentsBank.slfd.a.a.b bVar, b.C0303b bVar2) {
        k.c(bVar, "dataRepository");
        k.c(bVar2, "view");
        this.f18176h = bVar;
        this.f18177i = bVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        FDStatusResponse fDStatusResponse;
        Integer siId;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        b.C0303b bVar = this.f18177i;
        Double d2 = null;
        if (!(bVar != null ? Boolean.valueOf(bVar.d()) : null).booleanValue()) {
            return;
        }
        if (iJRPaytmDataModel instanceof SICreationResponse) {
            SICreationResponse sICreationResponse = (SICreationResponse) iJRPaytmDataModel;
            Integer responseCode = sICreationResponse.getResponseCode();
            if (responseCode != null && responseCode.intValue() == 200) {
                SICreationResponse.Payload payload = sICreationResponse.getPayload();
                if (!TextUtils.isEmpty((payload == null || (siId = payload.getSiId()) == null) ? null : String.valueOf(siId.intValue()))) {
                    SICreationResponse.Payload payload2 = sICreationResponse.getPayload();
                    Integer siId2 = payload2 != null ? payload2.getSiId() : null;
                    if (!(siId2 == null || (fDStatusResponse = this.f18174f) == null)) {
                        fDStatusResponse.setPreferenceSiId(siId2);
                    }
                    try {
                        String str = this.f18175g;
                        if (str != null) {
                            d2 = Double.valueOf(Double.parseDouble(str));
                        }
                        FDStatusResponse fDStatusResponse2 = this.f18174f;
                        if (fDStatusResponse2 != null) {
                            fDStatusResponse2.setPreferenceAmount(d2);
                        }
                    } catch (Exception unused) {
                    }
                    b.C0303b bVar2 = this.f18177i;
                    if (bVar2 != null) {
                        sICreationResponse.getResponseMessage();
                        bVar2.c();
                        return;
                    }
                    return;
                }
            }
            b.C0303b bVar3 = this.f18177i;
            if (bVar3 != null) {
                bVar3.b(sICreationResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof PBKYCFetchTnc) {
            this.f18177i.a(false);
            PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) iJRPaytmDataModel;
            if (pBKYCFetchTnc.getStatus() == null || !p.a(pBKYCFetchTnc.getStatus(), "error", true)) {
                if (pBKYCFetchTnc.getStatus() != null && p.a(pBKYCFetchTnc.getStatus(), "success", true) && pBKYCFetchTnc.getTncDataList() != null) {
                    this.f18169a.addAll(pBKYCFetchTnc.getTncDataList());
                    if (this.f18170b) {
                        this.f18177i.a(this.f18169a);
                        this.f18170b = false;
                        return;
                    }
                    b(this.f18171c);
                }
            } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                this.f18177i.a("Error", pBKYCFetchTnc.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof PBKYCTncAccept) {
            this.f18177i.a(false);
            PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel;
            if (pBKYCTncAccept.getStatus() == null || !p.a(pBKYCTncAccept.getStatus(), "error", true)) {
                if (pBKYCTncAccept.getStatus() != null && p.a(pBKYCTncAccept.getStatus(), "success", true) && k.a((Object) pBKYCTncAccept.getResponseCode(), (Object) "2004")) {
                    this.f18172d = true;
                    this.f18177i.b(this.f18171c);
                }
            } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                this.f18177i.a("Error", pBKYCTncAccept.getMessage());
            }
        }
    }

    public final void e() {
        if (this.f18169a.size() > 0) {
            b(true);
            return;
        }
        this.f18171c = true;
        a(false);
    }

    public final void a(boolean z) {
        this.f18170b = z;
        if (this.f18169a.size() > 0 && this.f18170b) {
            this.f18177i.a(this.f18169a);
        } else if (this.f18169a.size() == 0) {
            this.f18177i.a(true);
            this.f18176h.d(this, this);
        }
    }

    public final void b(boolean z) {
        this.f18171c = z;
        this.f18177i.a(true);
        this.f18176h.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18169a);
    }

    public final Integer d() {
        FDStatusResponse fDStatusResponse = this.f18174f;
        if (fDStatusResponse != null) {
            return fDStatusResponse.getPreferenceSiId();
        }
        return null;
    }

    public final Double c() {
        FDStatusResponse fDStatusResponse = this.f18174f;
        if (fDStatusResponse != null) {
            return fDStatusResponse.getPreferenceAmount();
        }
        return null;
    }

    public final Long a() {
        FDStatusResponse fDStatusResponse = this.f18174f;
        if ((fDStatusResponse != null ? fDStatusResponse.getMaxThreshold() : null) == null) {
            return 100000L;
        }
        FDStatusResponse fDStatusResponse2 = this.f18174f;
        if (fDStatusResponse2 != null) {
            return fDStatusResponse2.getMaxThreshold();
        }
        return null;
    }

    public final Long b() {
        FDStatusResponse fDStatusResponse = this.f18174f;
        if ((fDStatusResponse != null ? fDStatusResponse.getMinThreshold() : null) == null) {
            return 10000L;
        }
        FDStatusResponse fDStatusResponse2 = this.f18174f;
        if (fDStatusResponse2 != null) {
            return fDStatusResponse2.getMinThreshold();
        }
        return null;
    }

    public final void a(FDStatusResponse fDStatusResponse) {
        this.f18174f = fDStatusResponse;
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b.C0303b bVar;
        if ((iJRPaytmDataModel instanceof SICreationResponse) && (bVar = this.f18177i) != null) {
            bVar.b("");
        }
        b.C0303b bVar2 = this.f18177i;
        if (bVar2 != null) {
            bVar2.a(Integer.valueOf(i2), networkCustomError);
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "amount");
        k.c(str2, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        this.f18175g = str;
        net.one97.paytm.paymentsBank.slfd.a.a.b bVar = this.f18176h;
        if (bVar != null) {
            bVar.e(str, str2, this, this);
        }
    }

    public final void b(String str, String str2) {
        k.c(str, "siId");
        k.c(str2, "amount");
        this.f18175g = str2;
        net.one97.paytm.paymentsBank.slfd.a.a.b bVar = this.f18176h;
        if (bVar != null) {
            bVar.f(str, str2, this, this);
        }
    }

    public final void a(String str) {
        this.f18173e = str;
    }

    public final String f() {
        return this.f18173e;
    }
}
