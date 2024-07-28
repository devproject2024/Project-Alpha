package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.e;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import net.one97.paytm.locale.a;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.utils.ag;

public final class d extends ad {

    static final class b implements net.one97.paytm.locale.b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f16835a = new b();

        b() {
        }

        public final void refreshHomeLocaleChange(boolean z, boolean z2) {
        }
    }

    public d() {
        super("paytmUpdateAppData", "paytmGetUserData");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        String action;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(!a(h5Event) || h5Event == null || (activity = h5Event.getActivity()) == null || (action = h5Event.getAction()) == null)) {
            int hashCode = action.hashCode();
            if (hashCode != -1490725974) {
                if (hashCode == -1206413119 && action.equals("paytmUpdateAppData")) {
                    String string = h5Event.getParam().getString("languageId");
                    CharSequence charSequence = string;
                    if (charSequence == null || charSequence.length() == 0) {
                        a(H5Event.Error.INVALID_PARAM, "Language id not passed!");
                        return false;
                    }
                    try {
                        net.one97.paytm.locale.a aVar = new net.one97.paytm.locale.a(new a(activity, this, h5Event), activity, b.f16835a);
                        if (activity != null) {
                            aVar.a(((PaytmH5Activity) activity).getSupportFragmentManager());
                            aVar.b(string);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
                        }
                    } catch (Exception e2) {
                        a((Object) "error");
                        e2.printStackTrace();
                        a(H5Event.Error.INVALID_PARAM, "Language id is not valid");
                    }
                }
            } else if (action.equals("paytmGetUserData")) {
                String string2 = h5Event.getParam().getString("key");
                if (string2 != null) {
                    int hashCode2 = string2.hashCode();
                    if (hashCode2 != 177705091) {
                        if (hashCode2 == 1094007236 && string2.equals("xAppRid")) {
                            a((Object) com.paytm.network.b.d.a(activity));
                        }
                    } else if (string2.equals("profileType")) {
                        a((Object) p.a(com.paytm.utility.b.ak(activity), e.b.RESELLER.name(), true) ? 1 : 0);
                    }
                }
                ag.a aVar2 = ag.f69605a;
                Context applicationContext = activity.getApplicationContext();
                k.a((Object) applicationContext, "activity.applicationContext");
                com.paytm.b.a.a a2 = ag.a.a(applicationContext);
                k.a((Object) string2, "key");
                a((Object) a2.b(string2, "", true));
            }
        }
        return true;
    }

    public static final class a implements a.C0945a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16832a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f16833b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f16834c;

        a(Activity activity, d dVar, H5Event h5Event) {
            this.f16832a = activity;
            this.f16833b = dVar;
            this.f16834c = h5Event;
        }

        public final void a(boolean z) {
            if (z) {
                Intent intent = new Intent("net.paytm.one97.action.REFRESH_LOGIN");
                intent.putExtra("setLanguage", true);
                androidx.localbroadcastmanager.a.a.a((Context) this.f16832a).a(intent);
                this.f16833b.a((Object) "success");
                return;
            }
            this.f16833b.a((Object) DirectFormItemType.CANCEL);
        }
    }
}
