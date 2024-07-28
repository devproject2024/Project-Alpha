package androidx.palette.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f4007a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f4008b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f4009c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f4010d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f4011e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f4012f;

    /* renamed from: g  reason: collision with root package name */
    final float[] f4013g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    final float[] f4014h = new float[3];

    /* renamed from: i  reason: collision with root package name */
    final float[] f4015i = new float[3];
    boolean j = true;

    static {
        c cVar = new c();
        f4007a = cVar;
        c(cVar);
        d(f4007a);
        c cVar2 = new c();
        f4008b = cVar2;
        b(cVar2);
        d(f4008b);
        c cVar3 = new c();
        f4009c = cVar3;
        a(cVar3);
        d(f4009c);
        c cVar4 = new c();
        f4010d = cVar4;
        c(cVar4);
        e(f4010d);
        c cVar5 = new c();
        f4011e = cVar5;
        b(cVar5);
        e(f4011e);
        c cVar6 = new c();
        f4012f = cVar6;
        a(cVar6);
        e(f4012f);
    }

    c() {
        a(this.f4013g);
        a(this.f4014h);
        float[] fArr = this.f4015i;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private static void a(c cVar) {
        float[] fArr = cVar.f4014h;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void b(c cVar) {
        float[] fArr = cVar.f4014h;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void c(c cVar) {
        float[] fArr = cVar.f4014h;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void d(c cVar) {
        float[] fArr = cVar.f4013g;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void e(c cVar) {
        float[] fArr = cVar.f4013g;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }
}
