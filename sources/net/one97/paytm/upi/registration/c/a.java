package net.one97.paytm.upi.registration.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.registration.EditVpaResponse;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData<List<String>> f68518a = this.k;

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<Boolean> f68519b = this.l;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<Boolean> f68520c = this.m;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<Integer> f68521d = this.n;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<Boolean> f68522e = this.o;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<o<String, String>> f68523f = this.p;

    /* renamed from: g  reason: collision with root package name */
    public final LiveData<o<String, String>> f68524g = this.q;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, String> f68525h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<Boolean> f68526i = this.r;
    public final LiveData<Boolean> j = this.s;
    /* access modifiers changed from: private */
    public final y<List<String>> k = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> l = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> m = new y<>();
    private final y<Integer> n = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> o = new y<>();
    /* access modifiers changed from: private */
    public final y<o<String, String>> p = new y<>();
    /* access modifiers changed from: private */
    public final y<o<String, String>> q = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> r = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> s = new y<>();
    private final net.one97.paytm.upi.profile.b.b t;

    /* renamed from: net.one97.paytm.upi.registration.c.a$a  reason: collision with other inner class name */
    public interface C1390a {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(EditVpaResponse editVpaResponse);
    }

    public a(net.one97.paytm.upi.profile.b.b bVar) {
        k.c(bVar, "upiProfileRepository");
        this.t = bVar;
    }

    public static final class b implements C1390a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f68528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f68529b;

        b(a aVar, String str) {
            this.f68528a = aVar;
            this.f68529b = str;
        }

        public final void a(EditVpaResponse editVpaResponse) {
            k.c(editVpaResponse, Payload.RESPONSE);
            this.f68528a.l.setValue(Boolean.FALSE);
            if (p.a(editVpaResponse.getStatus(), "success", true)) {
                HashMap<String, String> vaMap = editVpaResponse.getVaMap();
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                Map map = vaMap;
                for (Map.Entry entry : map.entrySet()) {
                    if (k.a((Object) (String) entry.getValue(), (Object) "INACTIVE")) {
                        arrayList.add(entry.getKey());
                    } else if (!p.a((String) entry.getKey(), this.f68529b, true)) {
                        arrayList2.add(entry.getKey());
                    }
                }
                this.f68528a.f68525h.putAll(map);
                arrayList.addAll(arrayList2);
                this.f68528a.m.setValue(Boolean.valueOf(editVpaResponse.getEditable()));
                this.f68528a.k.setValue(arrayList);
            } else if (p.a((CharSequence) editVpaResponse.getResponseCode(), (CharSequence) "1006", false)) {
                this.f68528a.s.setValue(Boolean.TRUE);
            } else if (!p.a(editVpaResponse.getResponseMessage())) {
                this.f68528a.p.setValue(new o("Error", editVpaResponse.getResponseMessage()));
            } else {
                this.f68528a.p.setValue(new o("Error", "Something went wrong with your request. Please try again later."));
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            this.f68528a.l.setValue(Boolean.FALSE);
            this.f68528a.p.setValue(a.a(networkCustomError));
        }

        public final void a() {
            this.f68528a.l.setValue(Boolean.FALSE);
        }
    }

    public final void a(String str) {
        k.c(str, "currentVpa");
        this.l.setValue(Boolean.TRUE);
        this.t.a((C1390a) new b(this, str), str, Boolean.TRUE);
    }

    public final void a(UpiConstants.UpiVpaValidationError upiVpaValidationError) {
        int i2 = b.f68533a[upiVpaValidationError.ordinal()];
        if (i2 == 1) {
            this.n.setValue(Integer.valueOf(R.string.upi_vpa_length_breach));
        } else if (i2 == 2) {
            this.n.setValue(Integer.valueOf(R.string.upi_invalid_vpa));
        } else if (i2 == 3) {
            this.n.setValue(Integer.valueOf(R.string.upi_empty_vpa_error));
        } else if (i2 == 4) {
            this.n.setValue(Integer.valueOf(R.string.upi_vpa_unavailable));
        }
    }

    public static final class c implements C1390a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f68532a;

        c(a aVar) {
            this.f68532a = aVar;
        }

        public final void a(EditVpaResponse editVpaResponse) {
            k.c(editVpaResponse, Payload.RESPONSE);
            this.f68532a.r.setValue(Boolean.FALSE);
            if (p.a(editVpaResponse.getStatus(), "success", true)) {
                this.f68532a.o.setValue(Boolean.TRUE);
            } else if (p.a((CharSequence) editVpaResponse.getResponseCode(), (CharSequence) "1006", false)) {
                this.f68532a.s.setValue(Boolean.TRUE);
            } else if (!p.a(editVpaResponse.getResponseMessage())) {
                this.f68532a.q.setValue(new o("Error", editVpaResponse.getResponseMessage()));
            } else {
                this.f68532a.q.setValue(new o("Error", "Something went wrong with your request. Please try again later."));
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            this.f68532a.r.setValue(Boolean.FALSE);
            this.f68532a.q.setValue(a.a(networkCustomError));
        }

        public final void a() {
            this.f68532a.r.setValue(Boolean.FALSE);
        }
    }

    public final void b(String str) {
        this.r.setValue(Boolean.TRUE);
        this.t.a((C1390a) new c(this), str, Boolean.FALSE);
    }

    public static String c(String str) {
        k.c(str, "currentSelectedVpa");
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        int a2 = p.a((CharSequence) lowerCase, "@paytm", 0, false, 6);
        if (a2 == -1) {
            return str;
        }
        String substring = str.substring(0, a2);
        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final /* synthetic */ o a(NetworkCustomError networkCustomError) {
        if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NetworkError) {
            return new o("No Internet Connection", "We can not detect any internet connectivity. Please check your internet connection and try again.");
        }
        return new o("Something went wrong", "Something went wrong with your request. Please try again later.");
    }
}
