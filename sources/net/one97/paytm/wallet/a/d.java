package net.one97.paytm.wallet.a;

import com.google.zxing.r;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;

public abstract class d {
    public abstract void a(e eVar);

    private d() {
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    /* renamed from: net.one97.paytm.wallet.a.d$d  reason: collision with other inner class name */
    public static final class C1411d extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69856a;

        /* renamed from: b  reason: collision with root package name */
        private String f69857b;

        /* renamed from: c  reason: collision with root package name */
        private String f69858c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1411d(String str, String str2, String str3) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69856a = str;
            this.f69857b = str2;
            this.f69858c = str3;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            net.one97.paytm.wallet.f.c cVar = eVar.f69875a;
            if (cVar != null) {
                cVar.a(this.f69857b, this.f69858c);
            }
        }
    }

    public static final class e extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f69859a;

        /* renamed from: b  reason: collision with root package name */
        public Boolean f69860b;

        /* renamed from: c  reason: collision with root package name */
        private String f69861c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f69862d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, Boolean bool, Boolean bool2) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            kotlin.g.b.k.c(str2, "result");
            this.f69861c = str;
            this.f69859a = str2;
            this.f69860b = bool;
            this.f69862d = bool2;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            throw new IllegalMonitorStateException("Not handled");
        }
    }

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69853a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69853a = str;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            net.one97.paytm.wallet.f.c cVar = eVar.f69875a;
            if (cVar != null) {
                cVar.a(this.f69853a);
            }
        }
    }

    public static final class l extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69874a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69874a = str;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            net.one97.paytm.wallet.f.c cVar = eVar.f69875a;
            if (cVar != null) {
                cVar.b(this.f69874a);
            }
        }
    }

    public static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69855a;

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69855a = str;
        }
    }

    public static final class f extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69863a;

        /* renamed from: b  reason: collision with root package name */
        private Boolean f69864b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, Boolean bool) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69863a = str;
            this.f69864b = bool;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            eVar.a(this.f69864b);
        }
    }

    public static final class k extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69872a;

        /* renamed from: b  reason: collision with root package name */
        private r f69873b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, r rVar) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            kotlin.g.b.k.c(rVar, "result");
            this.f69872a = str;
            this.f69873b = rVar;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
            kotlin.g.b.k.a((Object) a2, "RiskInformationController.getInstance()");
            RiskExtendedInfo b2 = a2.b();
            kotlin.g.b.k.a((Object) b2, "RiskInformationControlle…stance().riskExtendedInfo");
            b2.setMode("nonPaytmqrCode");
            net.one97.paytm.wallet.f.c cVar = eVar.f69875a;
            if (cVar != null) {
                cVar.a(this.f69873b);
            }
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69854a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69854a = str;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            net.one97.paytm.f.b.a().b().setMode("nonPaytmqrCode");
            net.one97.paytm.wallet.f.c cVar = eVar.f69875a;
            if (cVar != null) {
                cVar.c(this.f69854a);
            }
        }
    }

    public static final class h extends d {

        /* renamed from: a  reason: collision with root package name */
        public final String f69866a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f69867b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69866a = str;
            this.f69867b = z;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            throw new IllegalMonitorStateException("Not handled");
        }
    }

    public static final class j extends d {

        /* renamed from: a  reason: collision with root package name */
        private String f69871a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            this.f69871a = str;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            throw new IllegalMonitorStateException("Not handled");
        }
    }

    public static final class g extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f69865a;

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            throw new IllegalMonitorStateException("Not handled");
        }
    }

    public static final class i extends d {

        /* renamed from: a  reason: collision with root package name */
        public final String f69868a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f69869b = false;

        /* renamed from: c  reason: collision with root package name */
        public final String f69870c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, String str2) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "qrData");
            kotlin.g.b.k.c(str2, "upiQR");
            this.f69868a = str;
            this.f69870c = str2;
        }

        public final void a(e eVar) {
            kotlin.g.b.k.c(eVar, "handler");
            throw new IllegalMonitorStateException("Not handled");
        }
    }
}
