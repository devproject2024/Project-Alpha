package net.one97.paytm.passbook.landing.repositories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.b.g;
import com.paytm.utility.h;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.BaseUpiResponse;
import net.one97.paytm.passbook.beans.upi.DeviceRegistrationFailure;
import net.one97.paytm.passbook.beans.upi.GetCredentialsResponse;
import net.one97.paytm.passbook.beans.upi.UPICheckBalanceListenerCallback;
import net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel;
import net.one97.paytm.passbook.beans.upi.UpiCallback;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.beans.upi.UpiProfileModel;
import net.one97.paytm.passbook.beans.upi.UpiToken;
import net.one97.paytm.passbook.landing.f.a;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.common.PaytmLogs;

public final class k extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final k f57801b = new k();

    /* renamed from: c  reason: collision with root package name */
    private static UpiProfileDefaultBank f57802c;

    private k() {
    }

    public static void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        f57802c = upiProfileDefaultBank;
    }

    public static UpiProfileDefaultBank b() {
        return f57802c;
    }

    public static final class d implements UpiCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57808a;

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "error");
        }

        d(y yVar) {
            this.f57808a = yVar;
        }

        public final void onSuccess(Object obj) {
            kotlin.g.b.k.c(obj, Payload.RESPONSE);
            if (obj instanceof UpiAvailabilityModel) {
                y yVar = this.f57808a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(obj));
            }
        }
    }

    public final LiveData<net.one97.paytm.passbook.mapping.a.f<UpiAvailabilityModel>> c() {
        y yVar = new y();
        net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
        a();
        b2.b((UpiCallback) new d(yVar));
        return yVar;
    }

    public static LiveData<net.one97.paytm.passbook.mapping.a.f<UpiProfileModel>> a(Context context) {
        kotlin.g.b.k.c(context, "context");
        y yVar = new y();
        f57802c = null;
        x.e eVar = new x.e();
        eVar.element = new io.reactivex.rxjava3.b.b();
        io.reactivex.rxjava3.a.y.a(new a(context)).a(new b(eVar, yVar));
        return yVar;
    }

    static final class a<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f57803a;

        a(Context context) {
            this.f57803a = context;
        }

        public final void subscribe(final z<net.one97.paytm.passbook.mapping.a.f<UpiProfileModel>> zVar) {
            net.one97.paytm.passbook.d.b().c((UpiCallback) new UpiCallback() {
                public final void onSuccess(Object obj) {
                    kotlin.g.b.k.c(obj, Payload.RESPONSE);
                    if (obj instanceof UpiProfileModel) {
                        z zVar = zVar;
                        f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                        zVar.onSuccess(f.a.a(obj));
                    }
                }

                public final void onError(Throwable th) {
                    if (th != null) {
                        zVar.onError(th);
                    }
                }
            });
        }
    }

    public static final class b implements aa<net.one97.paytm.passbook.mapping.a.f<? extends UpiProfileModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57805a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f57806b;

        b(x.e eVar, y yVar) {
            this.f57805a = eVar;
            this.f57806b = yVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            this.f57806b.postValue((net.one97.paytm.passbook.mapping.a.f) obj);
            ((io.reactivex.rxjava3.b.b) this.f57805a.element).dispose();
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
            ((io.reactivex.rxjava3.b.b) this.f57805a.element).a(cVar);
        }

        public final void onError(Throwable th) {
            ((io.reactivex.rxjava3.b.b) this.f57805a.element).dispose();
        }
    }

    public static void a(PassbookBalanceCardView passbookBalanceCardView, Activity activity, net.one97.paytm.passbook.landing.c.a aVar, UPICheckBalanceListenerCallback uPICheckBalanceListenerCallback) {
        kotlin.g.b.k.c(passbookBalanceCardView, "upiCard");
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(aVar, "balanceSummaryFragment");
        kotlin.g.b.k.c(uPICheckBalanceListenerCallback, H5Event.TYPE_CALL_BACK);
        if (!passbookBalanceCardView.getMUpiBankAccount().isMpinSet()) {
            net.one97.paytm.passbook.landing.f.a aVar2 = aVar.f57594b;
            if (aVar2 != null) {
                h hVar = new h(aVar2.N.getContext());
                hVar.a();
                Context context = aVar2.N.getContext();
                String str = null;
                hVar.a(context != null ? context.getString(R.string.mpin_missing_dlg_txt) : null);
                Context context2 = aVar2.N.getContext();
                hVar.a(-2, context2 != null ? context2.getString(R.string.already_set_upi_pin) : null, new a.q(aVar2, hVar));
                Context context3 = aVar2.N.getContext();
                if (context3 != null) {
                    str = context3.getString(R.string.set_upi_pin);
                }
                hVar.a(-1, str, new a.r(aVar2, hVar));
                hVar.show();
                return;
            }
            return;
        }
        net.one97.paytm.passbook.d.b().a(f57802c, activity, (Fragment) aVar, uPICheckBalanceListenerCallback);
    }

    public static final class e implements UpiCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.c.a f57809a;

        e(net.one97.paytm.passbook.landing.c.a aVar) {
            this.f57809a = aVar;
        }

        public final void onSuccess(Object obj) {
            kotlin.g.b.k.c(obj, Payload.RESPONSE);
            if (obj instanceof UpiToken) {
                k kVar = k.f57801b;
                UpiProfileDefaultBank b2 = k.b();
                if (b2 != null) {
                    k kVar2 = k.f57801b;
                    String upiToken = ((UpiToken) obj).getUpiToken();
                    kotlin.g.b.k.a((Object) upiToken, "response.upiToken");
                    k.a(upiToken, b2, this.f57809a);
                    return;
                }
                return;
            }
            net.one97.paytm.passbook.landing.f.a aVar = this.f57809a.f57594b;
            if (aVar != null) {
                aVar.a("", "");
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "error");
            net.one97.paytm.passbook.landing.f.a aVar = this.f57809a.f57594b;
            if (aVar != null) {
                aVar.a("", "");
            }
        }
    }

    public static void a(net.one97.paytm.passbook.landing.c.a aVar) {
        kotlin.g.b.k.c(aVar, "balanceSummaryFragment");
        net.one97.paytm.passbook.d.b().a((UpiCallback) new e(aVar), (DeviceRegistrationFailure) new f(aVar));
    }

    static final class f implements DeviceRegistrationFailure {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.c.a f57810a;

        f(net.one97.paytm.passbook.landing.c.a aVar) {
            this.f57810a = aVar;
        }

        public final void onDeviceRegistrationFailed() {
            net.one97.paytm.passbook.landing.f.a aVar = this.f57810a.f57594b;
            if (aVar != null && aVar.N.isAdded()) {
                Context context = aVar.N.getContext();
                net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                kotlin.g.b.k.a((Object) b2, "PassbookHelper.getImplListener()");
                Intent intent = new Intent(context, b2.e());
                intent.putExtra("redirect", 80);
                intent.setFlags(536870912);
                aVar.N.startActivityForResult(intent, 288);
            }
        }
    }

    public static final class c implements UpiCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.c.a f57807a;

        c(net.one97.paytm.passbook.landing.c.a aVar) {
            this.f57807a = aVar;
        }

        public final void onSuccess(Object obj) {
            String str;
            kotlin.g.b.k.c(obj, Payload.RESPONSE);
            if (obj instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) obj;
                if (!baseUpiResponse.isSuccess() || !kotlin.g.b.k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    net.one97.paytm.passbook.landing.f.a aVar = this.f57807a.f57594b;
                    if (aVar != null) {
                        aVar.a("", baseUpiResponse.getResponse());
                        return;
                    }
                    return;
                }
                try {
                    if (((BaseUpiResponse) obj).getMobileAppData() instanceof g) {
                        Object mobileAppData = ((BaseUpiResponse) obj).getMobileAppData();
                        if (mobileAppData != null) {
                            str = String.valueOf(((g) mobileAppData).get("totalBal"));
                        } else {
                            throw new u("null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<*, *>");
                        }
                    } else {
                        str = "";
                    }
                    int a2 = p.a((CharSequence) str, "=", 0, false, 6) + 1;
                    if (str != null) {
                        String substring = str.substring(a2);
                        kotlin.g.b.k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                        net.one97.paytm.passbook.landing.f.a aVar2 = this.f57807a.f57594b;
                        if (aVar2 != null) {
                            aVar2.a(substring, "");
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                } catch (Exception unused) {
                }
            } else {
                net.one97.paytm.passbook.landing.f.a aVar3 = this.f57807a.f57594b;
                if (aVar3 != null) {
                    aVar3.a("", "");
                }
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "error");
            net.one97.paytm.passbook.landing.f.a aVar = this.f57807a.f57594b;
            if (aVar != null) {
                aVar.a("", "");
            }
        }
    }

    public static final /* synthetic */ void a(String str, UpiProfileDefaultBank upiProfileDefaultBank, net.one97.paytm.passbook.landing.c.a aVar) {
        String a2 = q.a();
        try {
            net.one97.paytm.passbook.d.b().a(a2, str, upiProfileDefaultBank.getDebitBank(), (ResultReceiver) new UPIRemoteRepository$getBalanceCredentials$1(a2, upiProfileDefaultBank, aVar, new Handler()));
        } catch (Exception e2) {
            l.a((Throwable) e2);
        }
    }

    public static final /* synthetic */ void a(Bundle bundle, String str, UpiProfileDefaultBank upiProfileDefaultBank, net.one97.paytm.passbook.landing.c.a aVar) {
        String string = bundle.getString("error");
        if (string != null) {
            if (string.length() > 0) {
                return;
            }
        }
        Serializable serializable = bundle.getSerializable("credBlocks");
        if (serializable != null) {
            HashMap hashMap = (HashMap) serializable;
            List arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                try {
                    GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new com.google.gson.f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                    kotlin.g.b.k.a((Object) getCredentialsResponse, "getCredentialsResponse");
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (com.google.gson.u unused) {
                }
            }
            PaytmLogs.d("getCredentials", hashMap.toString());
            PaytmLogs.d("getCredentialsList", arrayList.toString());
            net.one97.paytm.passbook.d.b().a((List<GetCredentialsResponse>) arrayList, str, upiProfileDefaultBank, (UpiCallback) new c(aVar));
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
