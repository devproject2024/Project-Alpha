package net.one97.paytm.utils;

import java.util.HashMap;
import net.one97.paytm.p2mNewDesign.models.QrData;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f69662a;

    public enum a {
        Tscan,
        Tprocess,
        Tbackend,
        Tcached,
        Tpayment
    }

    public static b a() {
        if (f69662a == null) {
            synchronized (b.class) {
                if (f69662a == null) {
                    f69662a = new b();
                }
            }
        }
        return f69662a;
    }

    public static void b() {
        f69662a = null;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Long f69664a;

        /* renamed from: b  reason: collision with root package name */
        public Long f69665b;

        /* renamed from: c  reason: collision with root package name */
        public Long f69666c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f69667d;

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, Long> f69668e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        private final String f69669f = "p2m/p2p";

        public final void a(Long l) {
            this.f69664a = l;
        }

        public final void b(Long l) {
            this.f69665b = l;
        }

        public final void c(Long l) {
            this.f69666c = l;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(net.one97.paytm.utils.at.a r13, long r14, java.lang.String r16) {
            /*
                r12 = this;
                r0 = r12
                int[] r1 = net.one97.paytm.utils.at.AnonymousClass1.f69663a
                int r2 = r13.ordinal()
                r1 = r1[r2]
                r10 = 1
                r2 = 0
                if (r1 == r10) goto L_0x00ec
                r3 = 2
                if (r1 == r3) goto L_0x00b7
                r3 = 3
                if (r1 == r3) goto L_0x0083
                r3 = 4
                if (r1 == r3) goto L_0x004f
                r3 = 5
                if (r1 == r3) goto L_0x001b
                goto L_0x00ea
            L_0x001b:
                java.lang.Long r1 = r0.f69664a
                if (r1 == 0) goto L_0x00ea
                boolean r1 = r0.f69667d
                if (r1 == 0) goto L_0x00ea
                net.one97.paytm.p2mNewDesign.models.QrData r10 = new net.one97.paytm.p2mNewDesign.models.QrData
                java.lang.String r2 = r13.name()
                java.lang.Long r3 = r0.f69664a
                long r4 = r3.longValue()
                long r6 = r14 - r4
                java.lang.String r9 = "p2m/p2p"
                r1 = r10
                r4 = r14
                r8 = r16
                r1.<init>(r2, r3, r4, r6, r8, r9)
                java.util.HashMap<java.lang.String, java.lang.Long> r1 = r0.f69668e
                java.lang.Long r2 = r0.f69664a
                long r2 = r2.longValue()
                long r2 = r14 - r2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r3 = "Tpayment"
                r1.put(r3, r2)
                goto L_0x011e
            L_0x004f:
                java.lang.Long r1 = r0.f69666c
                if (r1 == 0) goto L_0x00ea
                boolean r1 = r0.f69667d
                if (r1 == 0) goto L_0x00ea
                net.one97.paytm.p2mNewDesign.models.QrData r10 = new net.one97.paytm.p2mNewDesign.models.QrData
                java.lang.String r2 = r13.name()
                java.lang.Long r3 = r0.f69666c
                long r4 = r3.longValue()
                long r6 = r14 - r4
                java.lang.String r8 = ""
                java.lang.String r9 = "p2m/p2p"
                r1 = r10
                r4 = r14
                r1.<init>(r2, r3, r4, r6, r8, r9)
                java.util.HashMap<java.lang.String, java.lang.Long> r1 = r0.f69668e
                java.lang.Long r2 = r0.f69666c
                long r2 = r2.longValue()
                long r2 = r14 - r2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r3 = "Tprocess"
                r1.put(r3, r2)
                goto L_0x011e
            L_0x0083:
                java.lang.Long r1 = r0.f69665b
                if (r1 == 0) goto L_0x00ea
                boolean r1 = r0.f69667d
                if (r1 == 0) goto L_0x00ea
                net.one97.paytm.p2mNewDesign.models.QrData r10 = new net.one97.paytm.p2mNewDesign.models.QrData
                java.lang.String r2 = r13.name()
                java.lang.Long r3 = r0.f69665b
                long r4 = r3.longValue()
                long r6 = r14 - r4
                java.lang.String r8 = ""
                java.lang.String r9 = "p2m/p2p"
                r1 = r10
                r4 = r14
                r1.<init>(r2, r3, r4, r6, r8, r9)
                java.util.HashMap<java.lang.String, java.lang.Long> r1 = r0.f69668e
                java.lang.Long r2 = r0.f69665b
                long r2 = r2.longValue()
                long r2 = r14 - r2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r3 = "Tcache"
                r1.put(r3, r2)
                goto L_0x011e
            L_0x00b7:
                java.lang.Long r1 = r0.f69665b
                if (r1 == 0) goto L_0x00ea
                boolean r1 = r0.f69667d
                if (r1 == 0) goto L_0x00ea
                net.one97.paytm.p2mNewDesign.models.QrData r10 = new net.one97.paytm.p2mNewDesign.models.QrData
                java.lang.String r2 = r13.name()
                java.lang.Long r3 = r0.f69665b
                long r4 = r3.longValue()
                long r6 = r14 - r4
                java.lang.String r9 = "p2m/p2p"
                r1 = r10
                r4 = r14
                r8 = r16
                r1.<init>(r2, r3, r4, r6, r8, r9)
                java.util.HashMap<java.lang.String, java.lang.Long> r1 = r0.f69668e
                java.lang.Long r2 = r0.f69665b
                long r2 = r2.longValue()
                long r2 = r14 - r2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r3 = "Tbackend"
                r1.put(r3, r2)
                goto L_0x011e
            L_0x00ea:
                r10 = r2
                goto L_0x011e
            L_0x00ec:
                java.lang.Long r1 = r0.f69664a
                if (r1 == 0) goto L_0x011b
                net.one97.paytm.p2mNewDesign.models.QrData r11 = new net.one97.paytm.p2mNewDesign.models.QrData
                java.lang.String r2 = r13.name()
                java.lang.Long r3 = r0.f69664a
                long r4 = r3.longValue()
                long r6 = r14 - r4
                java.lang.String r8 = ""
                java.lang.String r9 = "p2m/p2p"
                r1 = r11
                r4 = r14
                r1.<init>(r2, r3, r4, r6, r8, r9)
                java.util.HashMap<java.lang.String, java.lang.Long> r1 = r0.f69668e
                java.lang.Long r2 = r0.f69664a
                long r2 = r2.longValue()
                long r2 = r14 - r2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r3 = "Tscan"
                r1.put(r3, r2)
                r2 = r11
            L_0x011b:
                r0.f69667d = r10
                goto L_0x00ea
            L_0x011e:
                if (r10 == 0) goto L_0x012f
                net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
                net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
                android.content.Context r2 = r2.getContext()
                r1.sendPaymentSessionEvent(r2, r10)
            L_0x012f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.at.b.a(net.one97.paytm.utils.at$a, long, java.lang.String):void");
        }

        public final void a(long j, String str) {
            if (this.f69667d) {
                String b2 = net.one97.paytm.wallet.utility.a.b(d(this.f69664a), "dd-MM-yyyy HH:mm:ss:SSS");
                String b3 = net.one97.paytm.wallet.utility.a.b(d(Long.valueOf(j)), "dd-MM-yyyy HH:mm:ss:SSS");
                QrData qrData = new QrData();
                qrData.setEventName("ScanPaySessionData");
                qrData.setFlow("p2m/p2p");
                qrData.setStatus(str);
                qrData.setScanPaySessionStartTime(b2);
                qrData.setScanPaySessionEndTime(b3);
                qrData.setTscan(a("Tscan"));
                qrData.setTcache(a("Tcache"));
                qrData.setTbackend(a("Tbackend"));
                qrData.setTprocess(a("Tprocess"));
                qrData.setTpayment(a("Tpayment"));
                net.one97.paytm.wallet.communicator.b.a().sendPaymentSessionEvent(net.one97.paytm.wallet.communicator.b.a().getContext(), qrData);
            }
        }

        private static String d(Long l) {
            return l != null ? l.toString() : "0";
        }

        public final Long a(String str) {
            if (this.f69668e.get(str) != null) {
                return this.f69668e.get(str);
            }
            return 0L;
        }
    }

    /* renamed from: net.one97.paytm.utils.at$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69663a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                net.one97.paytm.utils.at$a[] r0 = net.one97.paytm.utils.at.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69663a = r0
                int[] r0 = f69663a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.utils.at$a r1 = net.one97.paytm.utils.at.a.Tscan     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69663a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.utils.at$a r1 = net.one97.paytm.utils.at.a.Tbackend     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f69663a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.utils.at$a r1 = net.one97.paytm.utils.at.a.Tcached     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f69663a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.utils.at$a r1 = net.one97.paytm.utils.at.a.Tprocess     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f69663a     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.utils.at$a r1 = net.one97.paytm.utils.at.a.Tpayment     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.at.AnonymousClass1.<clinit>():void");
        }
    }
}
