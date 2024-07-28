package net.one97.paytm.vipcashback.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.m.p;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseNewOffersListModal;
import net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer;
import net.one97.paytm.common.entity.vipcashback.VoucherTermsResponse;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.vipcashback.f.d;

public final class a {
    public static final d l = new d((byte) 0);
    private static final String p;
    /* access modifiers changed from: private */
    public static boolean q;

    /* renamed from: a  reason: collision with root package name */
    public final Context f20759a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20760b = "status";

    /* renamed from: c  reason: collision with root package name */
    public final String f20761c = "stage";

    /* renamed from: d  reason: collision with root package name */
    public final String f20762d = "page_number";

    /* renamed from: e  reason: collision with root package name */
    public final String f20763e = "page_size";

    /* renamed from: f  reason: collision with root package name */
    public final String f20764f = "offer_tag";

    /* renamed from: g  reason: collision with root package name */
    public final String f20765g = "oldest_txn_time";

    /* renamed from: h  reason: collision with root package name */
    public int f20766h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f20767i = 1;
    public int j = 1;
    public String k = "";
    private final String m = "after_id";
    private final String n = "page_offset";
    private final boolean o;

    public a(boolean z) {
        this.o = z;
        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
        kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
        Context applicationContext = b2.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
        this.f20759a = applicationContext;
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    static {
        String name = a.class.getName();
        kotlin.g.b.k.a((Object) name, "VIPCashBackDataModel::class.java.name");
        p = name;
    }

    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        public static final C0390a f20808a = new C0390a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20809b = f20809b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20810c = f20810c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20811d = f20811d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String f20812e = f20812e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final String f20813f = f20813f;

        /* renamed from: g  reason: collision with root package name */
        private static final String f20814g = f20814g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final String f20815h = f20815h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final String f20816i = "EXPIRED";
        /* access modifiers changed from: private */
        public static final String j = j;
        /* access modifiers changed from: private */
        public static final String k = k;
        /* access modifiers changed from: private */
        public static final String l = l;
        /* access modifiers changed from: private */
        public static final String m = m;
        /* access modifiers changed from: private */
        public static final String n = n;
        private static final String o = o;

        /* renamed from: net.one97.paytm.vipcashback.d.a$i$a  reason: collision with other inner class name */
        public static final class C0390a {
            private C0390a() {
            }

            public /* synthetic */ C0390a(byte b2) {
                this();
            }
        }
    }

    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public static final C0392a f20825a = new C0392a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private static final String f20826b = f20826b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20827c = f20827c;

        /* renamed from: net.one97.paytm.vipcashback.d.a$k$a  reason: collision with other inner class name */
        public static final class C0392a {
            private C0392a() {
            }

            public /* synthetic */ C0392a(byte b2) {
                this();
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final C0384a f20777a = new C0384a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final int f20778b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final int f20779c = 1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final int f20780d = 2;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final int f20781e = 3;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final int f20782f = 4;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static final int f20783g = 5;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final int f20784h = 6;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final int f20785i = 7;
        /* access modifiers changed from: private */
        public static final int j = 8;

        /* renamed from: net.one97.paytm.vipcashback.d.a$b$a  reason: collision with other inner class name */
        public static final class C0384a {
            private C0384a() {
            }

            public /* synthetic */ C0384a(byte b2) {
                this();
            }
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final C0385a f20786a = new C0385a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20787b = "CASHBACK";
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20788c = f20788c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20789d = f20789d;

        /* renamed from: net.one97.paytm.vipcashback.d.a$c$a  reason: collision with other inner class name */
        public static final class C0385a {
            private C0385a() {
            }

            public /* synthetic */ C0385a(byte b2) {
                this();
            }
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.d.a$a  reason: collision with other inner class name */
    public static final class C0382a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0383a f20768a = new C0383a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final int f20769b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final int f20770c = 1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final int f20771d = 2;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final int f20772e = 3;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final int f20773f = 4;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static final int f20774g = 5;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final int f20775h = 6;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final int f20776i = 7;
        /* access modifiers changed from: private */
        public static final int j = 8;
        /* access modifiers changed from: private */
        public static final int k = 9;
        /* access modifiers changed from: private */
        public static final int l = 10;

        /* renamed from: net.one97.paytm.vipcashback.d.a$a$a  reason: collision with other inner class name */
        public static final class C0383a {
            private C0383a() {
            }

            public /* synthetic */ C0383a(byte b2) {
                this();
            }
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final C0388a f20797a = new C0388a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private static final String f20798b = f20798b;

        /* renamed from: c  reason: collision with root package name */
        private static final String f20799c = f20799c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20800d = f20800d;

        /* renamed from: e  reason: collision with root package name */
        private static final String f20801e = f20801e;

        /* renamed from: net.one97.paytm.vipcashback.d.a$g$a  reason: collision with other inner class name */
        public static final class C0388a {
            private C0388a() {
            }

            public /* synthetic */ C0388a(byte b2) {
                this();
            }
        }
    }

    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public static final C0389a f20802a = new C0389a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20803b = f20803b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20804c = f20804c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20805d = f20805d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String f20806e = f20806e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final String f20807f = f20807f;

        /* renamed from: net.one97.paytm.vipcashback.d.a$h$a  reason: collision with other inner class name */
        public static final class C0389a {
            private C0389a() {
            }

            public /* synthetic */ C0389a(byte b2) {
                this();
            }
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public static final C0387a f20792a = new C0387a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20793b = "GOLDBACK";
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20794c = "CASHBACK";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20795d = f20795d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String f20796e = "DEAL";

        /* renamed from: net.one97.paytm.vipcashback.d.a$f$a  reason: collision with other inner class name */
        public static final class C0387a {
            private C0387a() {
            }

            public /* synthetic */ C0387a(byte b2) {
                this();
            }
        }
    }

    public static final class j {

        /* renamed from: a  reason: collision with root package name */
        public static final C0391a f20817a = new C0391a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20818b = "EXPIRED";
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20819c = "CANCELLED";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f20820d = f20820d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String f20821e = f20821e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final String f20822f = f20822f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static final String f20823g = f20823g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final String f20824h = f20824h;

        /* renamed from: net.one97.paytm.vipcashback.d.a$j$a  reason: collision with other inner class name */
        public static final class C0391a {
            private C0391a() {
            }

            public /* synthetic */ C0391a(byte b2) {
                this();
            }
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final C0386a f20790a = new C0386a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20791b = f20791b;

        /* renamed from: net.one97.paytm.vipcashback.d.a$e$a  reason: collision with other inner class name */
        public static final class C0386a {
            private C0386a() {
            }

            public /* synthetic */ C0386a(byte b2) {
                this();
            }
        }
    }

    public static final class m {

        /* renamed from: a  reason: collision with root package name */
        public static final C0394a f20832a = new C0394a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20833b = "SUCCESS";
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f20834c = "CANCELLED";

        /* renamed from: net.one97.paytm.vipcashback.d.a$m$a  reason: collision with other inner class name */
        public static final class C0394a {
            private C0394a() {
            }

            public /* synthetic */ C0394a(byte b2) {
                this();
            }
        }
    }

    public static final class l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0393a f20828a = new C0393a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String f20829b = f20829b;

        /* renamed from: c  reason: collision with root package name */
        private static final String f20830c = f20830c;

        /* renamed from: d  reason: collision with root package name */
        private static final String f20831d = f20831d;

        /* renamed from: net.one97.paytm.vipcashback.d.a$l$a  reason: collision with other inner class name */
        public static final class C0393a {
            private C0393a() {
            }

            public /* synthetic */ C0393a(byte b2) {
                this();
            }
        }
    }

    public final com.paytm.network.a a(com.paytm.network.listener.b bVar, String str, String str2, boolean z) {
        kotlin.g.b.k.c(bVar, "apiListener");
        kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (z) {
            this.f20766h = 1;
        }
        kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String i2 = net.one97.paytm.vipcashback.f.f.i();
        IJRPaytmDataModel merchantCashbackOffer = new MerchantCashbackOffer();
        StringBuilder sb = new StringBuilder("?");
        sb.append(this.f20760b);
        sb.append("=");
        i.C0390a aVar = i.f20808a;
        sb.append(i.f20810c);
        sb.append(AppConstants.COMMA);
        i.C0390a aVar2 = i.f20808a;
        sb.append(i.f20809b);
        sb.append(AppConstants.COMMA);
        i.C0390a aVar3 = i.f20808a;
        sb.append(i.f20815h);
        sb.append(AppConstants.COMMA);
        i.C0390a aVar4 = i.f20808a;
        sb.append(i.n);
        sb.append(AppConstants.AND_SIGN);
        sb.append(this.f20762d);
        sb.append("=");
        sb.append(this.f20766h);
        sb.append(AppConstants.AND_SIGN);
        sb.append(this.f20763e);
        sb.append("=20");
        String a2 = kotlin.g.b.k.a(i2, (Object) sb.toString());
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb2 = new StringBuilder(AppConstants.AND_SIGN);
            sb2.append(this.f20764f);
            sb2.append("=");
            String encode = URLEncoder.encode(str, AppConstants.UTF_8);
            kotlin.g.b.k.a((Object) encode, "URLEncoder.encode(offersTag, \"UTF-8\")");
            sb2.append(p.a(encode, "+", "%20", false));
            a2 = kotlin.g.b.k.a(a2, (Object) sb2.toString());
        }
        d.a aVar5 = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l2 = d.a.c().a(a.C0715a.GET).a(a2).a((Map<String, String>) a()).a(merchantCashbackOffer).c(str2).a(bVar).l();
        kotlin.g.b.k.a((Object) l2, "networkCall");
        return l2;
    }

    public final com.paytm.network.a a(com.paytm.network.listener.b bVar, String str, int i2, int i3, String str2) {
        String str3;
        kotlin.g.b.k.c(bVar, "apiListener");
        kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (this.o) {
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str3 = net.one97.paytm.vipcashback.f.f.h();
        } else {
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str3 = net.one97.paytm.vipcashback.f.f.r();
        }
        String str4 = str3 + "?" + this.m + "=" + i2 + AppConstants.AND_SIGN + this.f20762d + "=" + this.j + AppConstants.AND_SIGN + this.f20763e + "=20&" + this.n + "=" + i3;
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(AppConstants.AND_SIGN);
            sb.append(this.f20764f);
            sb.append("=");
            String encode = URLEncoder.encode(str, AppConstants.UTF_8);
            kotlin.g.b.k.a((Object) encode, "URLEncoder.encode(offersTag, \"UTF-8\")");
            sb.append(p.a(encode, "+", "%20", false));
            str4 = sb.toString();
        }
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l2 = d.a.c().a(a.C0715a.GET).a(str4).a((Map<String, String>) a()).a((IJRPaytmDataModel) new CashBackBaseNewOffersListModal()).c(str2).a(bVar).l();
        kotlin.g.b.k.a((Object) l2, "networkCall");
        return l2;
    }

    public static com.paytm.network.a a(com.paytm.network.listener.b bVar, String str, String str2) {
        kotlin.g.b.k.c(bVar, "apiListener");
        kotlin.g.b.k.c(str, "url");
        kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l2 = d.a.c().a(a.C0715a.GET).a(str).a((Map<String, String>) a()).a((IJRPaytmDataModel) new VoucherTermsResponse()).c(str2).a(bVar).l();
        kotlin.g.b.k.a((Object) l2, "networkCall");
        return l2;
    }

    public static HashMap<String, String> a() {
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
        kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
        Context applicationContext = b2.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
        return d.a.a(applicationContext);
    }
}
