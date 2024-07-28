package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

public final class fb extends bf.d<fb, a> implements co {
    private static volatile cx<fb> zzbg;
    /* access modifiers changed from: private */
    public static final fb zzsg = new fb();
    private byte zzsf = 2;

    public static final class a extends bf.c<fb, a> implements co {
        private a() {
            super(fb.zzsg);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        bf.a(fb.class, zzsg);
    }

    private fb() {
    }

    public static fb a() {
        return zzsg;
    }

    /* JADX WARNING: type inference failed for: r4v13, types: [com.google.android.gms.internal.clearcut.bf$b, com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.fb>] */
    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj) {
        cx<fb> cxVar;
        int i3 = 1;
        switch (fc.f9369a[i2 - 1]) {
            case 1:
                return new fb();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((cm) zzsg, "\u0003\u0000", (Object[]) null);
            case 4:
                return zzsg;
            case 5:
                cx<fb> cxVar2 = zzbg;
                cx<fb> cxVar3 = cxVar2;
                if (cxVar2 == null) {
                    synchronized (fb.class) {
                        cx<fb> cxVar4 = zzbg;
                        cxVar = cxVar4;
                        if (cxVar4 == null) {
                            ? bVar = new bf.b(zzsg);
                            zzbg = bVar;
                            cxVar = bVar;
                        }
                    }
                    cxVar3 = cxVar;
                }
                return cxVar3;
            case 6:
                return Byte.valueOf(this.zzsf);
            case 7:
                if (obj == null) {
                    i3 = 0;
                }
                this.zzsf = (byte) i3;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
