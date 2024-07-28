package net.one97.paytm.wallet.h;

import android.webkit.URLUtil;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.entity.BankUPIResponse;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.utils.AppExecutor;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f70378a = new a();

    private a() {
    }

    /* renamed from: net.one97.paytm.wallet.h.a$a  reason: collision with other inner class name */
    public static final class C1419a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f70379a;

        C1419a(y yVar) {
            this.f70379a = yVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, "upiBaseDataModel");
            if (upiBaseDataModel instanceof UpiProfileModel) {
                y yVar = this.f70379a;
                f.a aVar = f.f55795d;
                UpiProfileModel.AccountDetails response = ((UpiProfileModel) upiBaseDataModel).getResponse();
                k.a((Object) response, "upiBaseDataModel.response");
                UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                k.a((Object) profileDetail, "upiBaseDataModel.response.profileDetail");
                yVar.postValue(f.a.a(new BankUPIResponse(profileDetail.getProfileVpaList())));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "upiCustomVolleyError");
            y yVar = this.f70379a;
            f.a aVar = f.f55795d;
            yVar.postValue(f.a.a(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null));
        }
    }

    public static void a(y<f> yVar) {
        k.c(yVar, "data");
        f.a aVar = f.f55795d;
        yVar.postValue(f.a.a());
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        a2.getContext();
        String str = PaySendActivityV2.f70521f;
        g.a().a((a.C1382a) new C1419a(yVar), str, str);
    }

    public static void b(y<f> yVar) {
        k.c(yVar, "data");
        f.a aVar = f.f55795d;
        yVar.postValue(f.a.a());
        try {
            c a2 = net.one97.paytm.wallet.communicator.b.a();
            c a3 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            String stringFromGTM = a2.getStringFromGTM(a3.getContext(), "pgWalletBalanceURL");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                c a4 = net.one97.paytm.wallet.communicator.b.a();
                k.a((Object) a4, "WalletCommManager.getWalletCommunicator()");
                String e2 = com.paytm.utility.b.e(a4.getContext(), stringFromGTM);
                Map hashMap = new HashMap();
                c a5 = net.one97.paytm.wallet.communicator.b.a();
                k.a((Object) a5, "WalletCommManager.getWalletCommunicator()");
                String a6 = d.a(a5.getContext());
                k.a((Object) a6, "CJRNetUtility.getSSOToke…etCommunicator().context)");
                hashMap.put("ssotoken", a6);
                hashMap.put("Accept-Encoding", "gzip");
                c a7 = net.one97.paytm.wallet.communicator.b.a();
                k.a((Object) a7, "WalletCommManager.getWalletCommunicator()");
                if (com.paytm.utility.b.c(a7.getContext())) {
                    net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, (String) null);
                    bVar.e();
                    bVar.a(FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT);
                    AppExecutor.getExecutor().runOnUiThread(new b(bVar, yVar));
                    return;
                }
                f.a aVar2 = f.f55795d;
                yVar.postValue(f.a.b());
            }
        } catch (Exception e3) {
            q.d(e3.toString());
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.network.b f70380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f70381b;

        b(net.one97.paytm.network.b bVar, y yVar) {
            this.f70380a = bVar;
            this.f70381b = yVar;
        }

        public final void run() {
            this.f70380a.a().observeForever(new z<f>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f70382a;

                {
                    this.f70382a = r1;
                }

                public final /* synthetic */ void onChanged(Object obj) {
                    f fVar = (f) obj;
                    h hVar = fVar.f55796a;
                    IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                    net.one97.paytm.network.g gVar = fVar.f55798c;
                    if (hVar == h.SUCCESS && (iJRPaytmDataModel instanceof CJRCashWallet)) {
                        y yVar = this.f70382a.f70381b;
                        f.a aVar = f.f55795d;
                        yVar.postValue(f.a.a(iJRPaytmDataModel));
                    } else if (hVar != h.ERROR || gVar == null) {
                        y yVar2 = this.f70382a.f70381b;
                        f.a aVar2 = f.f55795d;
                        yVar2.postValue(f.a.a(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null));
                    } else {
                        y yVar3 = this.f70382a.f70381b;
                        f.a aVar3 = f.f55795d;
                        yVar3.postValue(f.a.a(gVar.f55799a, gVar.f55800b, gVar.f55801c));
                    }
                }
            });
        }
    }
}
