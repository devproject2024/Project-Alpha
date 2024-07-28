package net.one97.paytm.cashback.posttxn;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f49537a;

    /* renamed from: b  reason: collision with root package name */
    public String f49538b;

    /* renamed from: c  reason: collision with root package name */
    public String f49539c;

    /* renamed from: d  reason: collision with root package name */
    public String f49540d;

    /* renamed from: e  reason: collision with root package name */
    public String f49541e;

    /* renamed from: f  reason: collision with root package name */
    public String f49542f;

    /* renamed from: g  reason: collision with root package name */
    public String f49543g;

    /* renamed from: h  reason: collision with root package name */
    public String f49544h;

    public /* synthetic */ f(byte b2) {
        this();
    }

    private f() {
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49545a;

        /* renamed from: b  reason: collision with root package name */
        public String f49546b;

        /* renamed from: c  reason: collision with root package name */
        public String f49547c;

        /* renamed from: d  reason: collision with root package name */
        public String f49548d;

        /* renamed from: e  reason: collision with root package name */
        public String f49549e;

        /* renamed from: f  reason: collision with root package name */
        public String f49550f;

        /* renamed from: g  reason: collision with root package name */
        public String f49551g;

        /* renamed from: h  reason: collision with root package name */
        public String f49552h;

        public final f a() {
            if (this.f49545a == null && this.f49546b == null && this.f49547c == null && this.f49548d == null) {
                throw new IllegalArgumentException("PgTxnId, OrderId, UPIId, WalletId atleast one of them should be not null");
            }
            f fVar = new f((byte) 0);
            fVar.f49537a = this.f49545a;
            fVar.f49538b = this.f49546b;
            fVar.f49539c = this.f49547c;
            fVar.f49540d = this.f49548d;
            fVar.f49541e = this.f49549e;
            fVar.f49542f = this.f49550f;
            fVar.f49543g = this.f49551g;
            fVar.f49544h = this.f49552h;
            return fVar;
        }
    }
}
