package net.one97.paytm.upgradeKyc.editprofile.e;

import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.paymentsbank.UADPincode;
import net.one97.paytm.upgradeKyc.editprofile.b.a;

public final class c implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.d.a f65830a;

    /* renamed from: b  reason: collision with root package name */
    private a.c f65831b;

    public final void a() {
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
    }

    public c(a.c cVar, net.one97.paytm.upgradeKyc.editprofile.d.a aVar) {
        k.c(cVar, "view");
        k.c(aVar, "model");
        this.f65831b = cVar;
        this.f65830a = aVar;
    }

    public final void a(IJRDataModel iJRDataModel) {
        k.c(iJRDataModel, Payload.RESPONSE);
        if (iJRDataModel instanceof UADPincode) {
            UADPincode uADPincode = (UADPincode) iJRDataModel;
            if (uADPincode.getResponseCode() == null || !k.a((Object) uADPincode.getResponseCode(), (Object) "200")) {
                if (TextUtils.isEmpty(uADPincode.getResponseMessage())) {
                    this.f65831b.a("");
                    return;
                }
                a.c cVar = this.f65831b;
                String responseMessage = uADPincode.getResponseMessage();
                k.a((Object) responseMessage, "pincodeObj.responseMessage");
                cVar.a(responseMessage);
            } else if (uADPincode.getPincodeList() != null && uADPincode.getPincodeList().size() > 0) {
                a.c cVar2 = this.f65831b;
                UADPincode.SubPincode subPincode = uADPincode.getPincodeList().get(0);
                k.a((Object) subPincode, "pincodeObj.pincodeList[0]");
                cVar2.a(subPincode);
            } else if (uADPincode.getPincodeMap() == null || uADPincode.getPincodeMap().size() <= 0) {
                this.f65831b.a("");
            } else {
                ArrayList arrayList = new ArrayList();
                Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode.getPincodeMap();
                k.a((Object) pincodeMap, "pincodeObj.pincodeMap");
                for (Map.Entry next : pincodeMap.entrySet()) {
                    next.getKey();
                    arrayList.addAll((List) next.getValue());
                }
                a.c cVar3 = this.f65831b;
                Object obj = arrayList.get(0);
                k.a(obj, "pincode[0]");
                cVar3.a((UADPincode.SubPincode) obj);
            }
        }
    }
}
