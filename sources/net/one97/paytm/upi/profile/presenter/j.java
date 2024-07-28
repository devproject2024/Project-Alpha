package net.one97.paytm.upi.profile.presenter;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CreateSignatureResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.a.j;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class j implements j.a, a.C1382a {

    /* renamed from: g  reason: collision with root package name */
    private static String f68106g = "UpiQrCodePresenter";

    /* renamed from: a  reason: collision with root package name */
    private j.b f68107a;

    /* renamed from: b  reason: collision with root package name */
    private UpiProfileDefaultBank f68108b;

    /* renamed from: c  reason: collision with root package name */
    private b f68109c;

    /* renamed from: d  reason: collision with root package name */
    private String f68110d;

    /* renamed from: e  reason: collision with root package name */
    private String f68111e;

    /* renamed from: f  reason: collision with root package name */
    private String f68112f;

    public j(j.b bVar, UpiProfileDefaultBank upiProfileDefaultBank, b bVar2) {
        this.f68107a = bVar;
        this.f68108b = upiProfileDefaultBank;
        this.f68109c = bVar2;
        this.f68107a.a(this);
    }

    public final void e() {
        this.f68107a.a();
        UpiProfileDefaultBank upiProfileDefaultBank = this.f68108b;
        if (upiProfileDefaultBank != null) {
            b(upiProfileDefaultBank.getQrData());
            return;
        }
        throw new IllegalStateException("No upi data present");
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f68107a.a("Amount can't be empty");
            return;
        }
        this.f68111e = UpiAppUtils.getCleanString(str);
        BankAccountDetails.BankAccount creditBank = this.f68108b.getCreditBank();
        String virtualAddress = this.f68108b.getVirtualAddress();
        StringBuilder sb = new StringBuilder(AppConstants.MapQrConstants.UPI);
        sb.append("pa=");
        sb.append(virtualAddress);
        sb.append("&pn=");
        sb.append(creditBank.getCustomerName());
        if (!TextUtils.isEmpty(this.f68111e)) {
            sb.append("&am=");
            sb.append(this.f68111e);
        }
        if (!TextUtils.isEmpty(this.f68110d)) {
            sb.append("&tn=");
            sb.append(this.f68110d);
        }
        sb.append("&orgid=153006");
        sb.append("&mc=0000");
        String sb2 = sb.toString();
        this.f68107a.a();
        this.f68112f = sb2;
        net.one97.paytm.upi.profile.b.b.a aVar = this.f68109c.f67823a;
        aVar.a((a.C1382a) this, UpiRequestBuilder.CreateSignature.CreateSignatureUrl(aVar.f67892a), UpiRequestBuilder.CreateSignature.getParams(aVar.f67892a, sb2), UpiRequestBuilder.getHeadersWithApplicationJson(aVar.f67892a), (UpiBaseDataModel) new CreateSignatureResponse());
    }

    private void b(String str) {
        this.f68107a.b();
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(this.f68111e)) {
                str2 = String.valueOf(Double.parseDouble(this.f68111e));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f68107a.a(str, this.f68108b.getCreditBank().getCustomerName(), this.f68108b.getVirtualAddress(), str2);
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        if (upiBaseDataModel instanceof CreateSignatureResponse) {
            this.f68107a.b();
            CreateSignatureResponse createSignatureResponse = (CreateSignatureResponse) upiBaseDataModel;
            if (!"success".equalsIgnoreCase(createSignatureResponse.getStatus()) || !"0".equalsIgnoreCase(createSignatureResponse.getRespCode())) {
                this.f68107a.b(createSignatureResponse.getRespMessage());
                return;
            }
            String str = this.f68112f;
            b(str.concat("&sign=" + createSignatureResponse.getSignature()));
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        j.b bVar = this.f68107a;
        if (bVar != null) {
            bVar.a(upiCustomVolleyError);
        }
    }

    public final void f() {
        this.f68109c.a(f68106g);
        this.f68107a = null;
    }
}
