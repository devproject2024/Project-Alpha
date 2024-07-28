package net.one97.paytm.n;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.passcode.DeviceAuthAttribute;
import net.one97.paytm.common.entity.passcode.UserAttributeInfo;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Activity f55734a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f55735b;

    /* renamed from: c  reason: collision with root package name */
    b f55736c;

    /* renamed from: d  reason: collision with root package name */
    public String f55737d;

    /* renamed from: e  reason: collision with root package name */
    public f f55738e;

    /* renamed from: net.one97.paytm.n.a$a  reason: collision with other inner class name */
    static final class C1040a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55739a;

        C1040a(a aVar) {
            this.f55739a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            g gVar;
            g gVar2;
            f fVar = (f) obj;
            if (fVar == null) {
                return;
            }
            if (fVar.f55796a == h.SUCCESS) {
                if (fVar.f55797b instanceof DeviceAuthAttribute) {
                    UserAttributeInfo userAttributeInfo = ((DeviceAuthAttribute) fVar.f55797b).getUserAttributeInfo();
                    String device_passcode_verified = userAttributeInfo != null ? userAttributeInfo.getDEVICE_PASSCODE_VERIFIED() : null;
                    a aVar = this.f55739a;
                    CharSequence charSequence = device_passcode_verified;
                    boolean z = true;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        e eVar = e.f55762a;
                        if (device_passcode_verified == null) {
                            k.a();
                        }
                        k.c(device_passcode_verified, "remotlyStoredDeviceId");
                        if (device_passcode_verified.compareTo(e.c()) != 0) {
                            z = false;
                        }
                        if (z) {
                            e eVar2 = e.f55762a;
                            e.e();
                            aVar.c();
                            return;
                        }
                    }
                    aVar.f55736c.a(false);
                    aVar.f55738e = new f(new c(aVar), aVar.f55737d);
                    a aVar2 = aVar;
                    if (aVar2.f55734a != null) {
                        f fVar2 = aVar.f55738e;
                        if (fVar2 != null) {
                            Activity activity = aVar.f55734a;
                            if (activity == null) {
                                k.a("activity");
                            }
                            fVar2.a(activity);
                            return;
                        }
                        return;
                    }
                    if (aVar2.f55735b != null) {
                        Fragment fragment = aVar.f55735b;
                        if (fragment == null) {
                            k.a("fragment");
                        }
                        if (fragment.isAdded()) {
                            f fVar3 = aVar.f55738e;
                            if (fVar3 != null) {
                                Fragment fragment2 = aVar.f55735b;
                                if (fragment2 == null) {
                                    k.a("fragment");
                                }
                                fVar3.a(fragment2);
                                return;
                            }
                            return;
                        }
                    }
                    f fVar4 = aVar.f55738e;
                    if (fVar4 != null && (gVar2 = fVar4.f55768a) != null) {
                        gVar2.b();
                    }
                }
            } else if (fVar.f55796a == h.ERROR && (gVar = fVar.f55798c) != null) {
                a.a(this.f55739a, gVar);
            }
        }
    }

    static final class b<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55740a;

        b(a aVar) {
            this.f55740a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            g gVar;
            f fVar = (f) obj;
            if (fVar == null) {
                return;
            }
            if (fVar.f55796a == h.SUCCESS) {
                e eVar = e.f55762a;
                e.e();
                this.f55740a.c();
            } else if (fVar.f55796a == h.ERROR && (gVar = fVar.f55798c) != null) {
                a.a(this.f55740a, gVar);
            }
        }
    }

    public a(Activity activity, b bVar, String str) {
        k.c(activity, "activity");
        k.c(bVar, "listener");
        this.f55734a = activity;
        this.f55736c = bVar;
        this.f55737d = str;
    }

    public a(Fragment fragment, b bVar, String str) {
        k.c(fragment, "fragment");
        k.c(bVar, "listener");
        this.f55735b = fragment;
        this.f55736c = bVar;
        this.f55737d = str;
    }

    public final void a() {
        this.f55736c.a(true);
        if (b()) {
            e eVar = e.f55762a;
            if (e.f()) {
                e eVar2 = e.f55762a;
                if (e.h()) {
                    e eVar3 = e.f55762a;
                    if (e.d()) {
                        c();
                        return;
                    }
                    d dVar = d.f55759a;
                    net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
                    k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
                    Context context = a2.getContext();
                    k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
                    LiveData<f> a3 = d.a(context);
                    if (a3 != null) {
                        a3.observeForever(new C1040a(this));
                        return;
                    }
                    return;
                }
            }
        }
        c();
    }

    public boolean b() {
        e eVar = e.f55762a;
        return a(e.b());
    }

    public static boolean a(String str) {
        k.c(str, "key");
        e eVar = e.f55762a;
        return e.a(str);
    }

    public static final class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55741a;

        c(a aVar) {
            this.f55741a = aVar;
        }

        public final void a() {
            this.f55741a.f55736c.a(true);
            a aVar = this.f55741a;
            e eVar = e.f55762a;
            e.c();
            d dVar = d.f55759a;
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            Context context = a2.getContext();
            k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
            LiveData<f> b2 = d.b(context);
            if (b2 != null) {
                b2.observeForever(new b(aVar));
            }
        }

        public final void b() {
            a aVar = this.f55741a;
            aVar.f55736c.a(false);
            aVar.f55736c.a();
        }
    }

    public static final class d implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55742a;

        public d(a aVar) {
            this.f55742a = aVar;
        }

        public final void a() {
            this.f55742a.d();
        }

        public final void b() {
            this.f55742a.f55736c.g(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f55736c.a(false);
        b bVar = this.f55736c;
        if (bVar != null) {
            bVar.ae_();
        }
    }

    public final void d() {
        b bVar = this.f55736c;
        if (bVar != null) {
            bVar.g(true);
        }
    }

    public static final /* synthetic */ void a(a aVar, g gVar) {
        aVar.f55736c.a(false);
        aVar.f55736c.a(gVar);
    }
}
