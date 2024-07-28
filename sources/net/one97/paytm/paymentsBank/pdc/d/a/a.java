package net.one97.paytm.paymentsBank.pdc.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.f.f;
import net.one97.paytm.bankCommon.mapping.h;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.bankCommon.model.PBCJRAddresses;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.PermanentAddress;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.pdc.response.PDCCheckoutResponse;
import net.one97.paytm.paymentsBank.utils.o;

public final class a implements b, f, net.one97.paytm.paymentsBank.pdc.d.b.a {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.pdc.c.b.a f18704a = new net.one97.paytm.paymentsBank.pdc.c.a.a();

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.pdc.view.b f18705b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<PBTncData> f18706c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18707d;

    /* renamed from: e  reason: collision with root package name */
    private String f18708e;

    /* renamed from: f  reason: collision with root package name */
    private String f18709f;

    /* renamed from: g  reason: collision with root package name */
    private String f18710g;

    /* renamed from: h  reason: collision with root package name */
    private PBCJRAddress f18711h;

    /* renamed from: i  reason: collision with root package name */
    private String f18712i;

    public a(net.one97.paytm.paymentsBank.pdc.view.b bVar) {
        this.f18705b = bVar;
    }

    public final void a(Context context) {
        this.f18705b.b();
        if (!com.paytm.utility.b.c(context)) {
            this.f18705b.f();
            return;
        }
        g a2 = g.a(context);
        if (a2 != null) {
            a2.b(this, "select address").a();
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, PBCJRAddress pBCJRAddress) {
        if (!com.paytm.utility.b.c(context)) {
            this.f18705b.f();
            return;
        }
        this.f18711h = pBCJRAddress;
        this.f18710g = str4;
        this.f18709f = str3;
        this.f18708e = str2;
        this.f18712i = str;
        this.f18707d = true;
        this.f18705b.b();
        ArrayList<PBTncData> arrayList = this.f18706c;
        if (arrayList == null) {
            this.f18704a.a(context, this);
        } else {
            this.f18704a.a(context, arrayList, this);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.paymentsBank.pdc.view.b bVar = this.f18705b;
        if (bVar != null) {
            bVar.e();
            if (iJRPaytmDataModel instanceof PBCJRAddresses) {
                PBCJRAddresses pBCJRAddresses = (PBCJRAddresses) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(pBCJRAddresses.getError())) {
                    this.f18705b.a(pBCJRAddresses.getError());
                } else if (!TextUtils.isEmpty(pBCJRAddresses.getStatus()) && pBCJRAddresses.getStatus().equalsIgnoreCase("Failure")) {
                    this.f18705b.a(pBCJRAddresses.getMessage());
                } else if (pBCJRAddresses.getAddress() != null) {
                    this.f18705b.a((ArrayList<PBCJRAddress>) pBCJRAddresses.getAddress());
                }
            } else if (iJRPaytmDataModel instanceof PBKYCFetchTnc) {
                PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) iJRPaytmDataModel;
                if (pBKYCFetchTnc.getStatus() == null || !pBKYCFetchTnc.getStatus().equalsIgnoreCase("error")) {
                    if (pBKYCFetchTnc.getStatus() != null && pBKYCFetchTnc.getStatus().equalsIgnoreCase("success") && pBKYCFetchTnc.getTncDataList() != null) {
                        this.f18706c = pBKYCFetchTnc.getTncDataList();
                        if (this.f18707d) {
                            this.f18705b.b();
                            this.f18704a.a(o.a().getApplicationContext(), this.f18706c, this);
                            return;
                        }
                        this.f18705b.b(this.f18706c);
                    }
                } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                    this.f18705b.a(pBKYCFetchTnc.getMessage());
                }
            } else if (iJRPaytmDataModel instanceof PBKYCTncAccept) {
                PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel;
                if (pBKYCTncAccept.getStatus() == null || !pBKYCTncAccept.getStatus().equalsIgnoreCase("error")) {
                    if (pBKYCTncAccept.getStatus() != null && pBKYCTncAccept.getStatus().equalsIgnoreCase("success") && pBKYCTncAccept.getResponseCode().equals("2004")) {
                        this.f18705b.b();
                        this.f18704a.a(this.f18711h, this.f18712i, this.f18708e, this.f18709f, o.a().getApplicationContext(), this);
                    }
                } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                    this.f18705b.a(pBKYCTncAccept.getMessage());
                }
            } else if (iJRPaytmDataModel instanceof PDCCheckoutResponse) {
                PDCCheckoutResponse pDCCheckoutResponse = (PDCCheckoutResponse) iJRPaytmDataModel;
                if (pDCCheckoutResponse.getResponseCode().intValue() != 200 || pDCCheckoutResponse.getPayload() == null || TextUtils.isEmpty(pDCCheckoutResponse.getPayload().getOrderId())) {
                    this.f18705b.a(pDCCheckoutResponse.getResponseMessage());
                } else {
                    this.f18705b.b(pDCCheckoutResponse.getPayload().getOrderId());
                }
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        net.one97.paytm.paymentsBank.pdc.view.b bVar = this.f18705b;
        if (bVar != null) {
            bVar.e();
            this.f18705b.a(h.a(networkCustomError));
        }
    }

    public final void b(Context context) {
        if (!com.paytm.utility.b.c(context)) {
            this.f18705b.f();
            return;
        }
        this.f18707d = false;
        this.f18705b.b();
        this.f18704a.a(context, this);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAadharPanGet)) {
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
            CersaiDetails cersaiInfo = cJRAadharPanGet.getCersaiInfo();
            if (cersaiInfo != null) {
                PermanentAddress permanentAddress = cersaiInfo.getAddress().getPermanentAddress();
                if (permanentAddress != null) {
                    PBCJRAddress pBCJRAddress = new PBCJRAddress();
                    pBCJRAddress.setName(TextUtils.isEmpty(cJRAadharPanGet.getName()) ? "" : cJRAadharPanGet.getName());
                    pBCJRAddress.setMobile(com.paytm.utility.b.l(o.a().getApplicationContext()));
                    pBCJRAddress.setCity(permanentAddress.getCity());
                    pBCJRAddress.setAreaName(permanentAddress.getLocality());
                    pBCJRAddress.setPin(permanentAddress.getPostalCode());
                    pBCJRAddress.setState(permanentAddress.getState());
                    pBCJRAddress.setAddress1(permanentAddress.getStreet1());
                    pBCJRAddress.setAddress2(permanentAddress.getStreet2());
                    this.f18705b.a(pBCJRAddress);
                    return;
                }
                return;
            }
            this.f18705b.a((PBCJRAddress) null);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        net.one97.paytm.paymentsBank.pdc.view.b bVar = this.f18705b;
        if (bVar != null) {
            bVar.e();
            this.f18705b.a(h.a(networkCustomError));
        }
    }
}
