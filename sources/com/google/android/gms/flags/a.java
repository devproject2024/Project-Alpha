package com.google.android.gms.flags;

@Deprecated
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9023a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9024b;

    /* renamed from: c  reason: collision with root package name */
    private final T f9025c;

    @Deprecated
    /* renamed from: com.google.android.gms.flags.a$a  reason: collision with other inner class name */
    public static class C0135a extends a<Boolean> {
        public C0135a(String str, Boolean bool) {
            super(str, bool, (byte) 0);
        }
    }

    private a(String str, T t) {
        this.f9023a = 0;
        this.f9024b = str;
        this.f9025c = t;
        c.a().f9026a.add(this);
    }

    /* synthetic */ a(String str, Object obj, byte b2) {
        this(str, obj);
    }
}
