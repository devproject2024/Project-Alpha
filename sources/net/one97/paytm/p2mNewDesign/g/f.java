package net.one97.paytm.p2mNewDesign.g;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Footer;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.ShippingAddress;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.SiteWideOffer;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class f extends androidx.lifecycle.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.network.f> f51291a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f51292b;

    static final class a<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f51293a;

        a(f fVar) {
            this.f51293a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            h hVar = fVar.f55796a;
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            g gVar = fVar.f55798c;
            if (hVar == h.SUCCESS) {
                y a2 = this.f51293a.f51291a;
                f.a aVar = net.one97.paytm.network.f.f55795d;
                if (iJRPaytmDataModel != null) {
                    a2.postValue(f.a.a(iJRPaytmDataModel));
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
            } else if (hVar == h.ERROR && gVar != null) {
                y a3 = this.f51293a.f51291a;
                f.a aVar2 = net.one97.paytm.network.f.f55795d;
                int i2 = gVar.f55799a;
                IJRPaytmDataModel iJRPaytmDataModel2 = gVar.f55800b;
                if (iJRPaytmDataModel2 == null) {
                    k.a();
                }
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError == null) {
                    k.a();
                }
                a3.postValue(f.a.a(i2, iJRPaytmDataModel2, networkCustomError));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Application application) {
        super(application);
        k.c(application, "application");
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
        this.f51292b = context;
    }

    public final y<net.one97.paytm.network.f> a(String str, String str2, boolean z) {
        String str3 = str2 + str + "/detail?";
        HashMap hashMap = new HashMap();
        String a2 = d.a(this.f51292b);
        Map map = hashMap;
        k.a((Object) a2, "ssoToken");
        map.put(AppConstants.SSO_TOKEN, a2);
        map.put("actions", "1");
        if (z) {
            map.put(GAConstants.ACTION.RETRY, "1");
        }
        new net.one97.paytm.network.a(str3, new MyOrdersAPIResponse((String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (List) null, (List) null, (Double) null, (Double) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (String) null, (Footer) null, (ShippingAddress) null, (String) null, (String) null, (SiteWideOffer) null, -1, 1023, (kotlin.g.b.g) null), map, (Map<String, String>) null).a().observeForever(new a(this));
        return this.f51291a;
    }
}
