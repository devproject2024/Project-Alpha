package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.g.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f6762a;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f6763b;

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f6764c = {Bitmap.Config.RGB_565};

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f6765d = {Bitmap.Config.ARGB_4444};

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f6766e = {Bitmap.Config.ALPHA_8};

    /* renamed from: f  reason: collision with root package name */
    private final b f6767f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final h<a, Bitmap> f6768g = new h<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f6769h = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f6762a = configArr;
        f6763b = configArr;
    }

    public final void a(Bitmap bitmap) {
        a a2 = this.f6767f.a(k.a(bitmap), bitmap.getConfig());
        this.f6768g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f6771a));
        Integer valueOf = Integer.valueOf(a2.f6771a);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(valueOf, Integer.valueOf(i2));
    }

    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int a2 = k.a(i2, i3, config);
        a a3 = this.f6767f.a(a2, config);
        int i4 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i5 = AnonymousClass1.f6770a[config.ordinal()];
            if (i5 == 1) {
                configArr = f6762a;
            } else if (i5 == 2) {
                configArr = f6764c;
            } else if (i5 != 3) {
                configArr = i5 != 4 ? new Bitmap.Config[]{config} : f6766e;
            } else {
                configArr = f6765d;
            }
        } else {
            configArr = f6763b;
        }
        int length = configArr.length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i4];
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(a2));
            if (ceilingKey == null || ceilingKey.intValue() > a2 * 8) {
                i4++;
            } else if (ceilingKey.intValue() != a2 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f6767f.a(a3);
                a3 = this.f6767f.a(ceilingKey.intValue(), config2);
            }
        }
        Bitmap a4 = this.f6768g.a(a3);
        if (a4 != null) {
            a(Integer.valueOf(a3.f6771a), a4);
            a4.reconfigure(i2, i3, config);
        }
        return a4;
    }

    public final Bitmap a() {
        Bitmap a2 = this.f6768g.a();
        if (a2 != null) {
            a(Integer.valueOf(k.a(a2)), a2);
        }
        return a2;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f6769h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f6769h.put(config, treeMap);
        return treeMap;
    }

    public final String b(Bitmap bitmap) {
        return a(k.a(bitmap), bitmap.getConfig());
    }

    public final String b(int i2, int i3, Bitmap.Config config) {
        return a(k.a(i2, i3, config), config);
    }

    public final int c(Bitmap bitmap) {
        return k.a(bitmap);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SizeConfigStrategy{groupedMap=");
        sb.append(this.f6768g);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f6769h.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f6769h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    static class b extends d<a> {
        b() {
        }

        public final a a(int i2, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.a(i2, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }
    }

    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f6771a;

        /* renamed from: b  reason: collision with root package name */
        private final b f6772b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f6773c;

        public a(b bVar) {
            this.f6772b = bVar;
        }

        public final void a(int i2, Bitmap.Config config) {
            this.f6771a = i2;
            this.f6773c = config;
        }

        public final void a() {
            this.f6772b.a(this);
        }

        public final String toString() {
            return n.a(this.f6771a, this.f6773c);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f6771a != aVar.f6771a || !k.a((Object) this.f6773c, (Object) aVar.f6773c)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i2 = this.f6771a * 31;
            Bitmap.Config config = this.f6773c;
            return i2 + (config != null ? config.hashCode() : 0);
        }
    }

    static String a(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    /* renamed from: com.bumptech.glide.load.b.a.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6770a = new int[Bitmap.Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6770a = r0
                int[] r0 = f6770a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6770a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f6770a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f6770a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.n.AnonymousClass1.<clinit>():void");
        }
    }
}
