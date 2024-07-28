package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    c f2515a;

    /* renamed from: b  reason: collision with root package name */
    int f2516b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2517c = -1;

    /* renamed from: d  reason: collision with root package name */
    d f2518d = null;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f2519e;

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<a> f2520f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private SparseArray<c> f2521g = new SparseArray<>();

    b(Context context, ConstraintLayout constraintLayout, int i2) {
        this.f2519e = constraintLayout;
        a(context, i2);
    }

    public final void a(int i2, float f2, float f3) {
        c cVar;
        a aVar;
        int a2;
        c cVar2;
        int i3 = this.f2516b;
        if (i3 == i2) {
            if (i2 == -1) {
                aVar = this.f2520f.valueAt(0);
            } else {
                aVar = this.f2520f.get(i3);
            }
            if ((this.f2517c == -1 || !aVar.f2523b.get(this.f2517c).a(f2, f3)) && this.f2517c != (a2 = aVar.a(f2, f3))) {
                if (a2 == -1) {
                    cVar2 = this.f2515a;
                } else {
                    cVar2 = aVar.f2523b.get(a2).f2531f;
                }
                if (a2 != -1) {
                    aVar.f2523b.get(a2);
                }
                if (cVar2 != null) {
                    this.f2517c = a2;
                    cVar2.c(this.f2519e);
                    return;
                }
                return;
            }
            return;
        }
        this.f2516b = i2;
        a aVar2 = this.f2520f.get(this.f2516b);
        int a3 = aVar2.a(f2, f3);
        if (a3 == -1) {
            cVar = aVar2.f2525d;
        } else {
            cVar = aVar2.f2523b.get(a3).f2531f;
        }
        if (a3 != -1) {
            aVar2.f2523b.get(a3);
        }
        if (cVar == null) {
            StringBuilder sb = new StringBuilder("NO Constraint set found ! id=");
            sb.append(i2);
            sb.append(", dim =");
            sb.append(f2);
            sb.append(", ");
            sb.append(f3);
            return;
        }
        this.f2517c = a3;
        cVar.c(this.f2519e);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2522a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<C0035b> f2523b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2524c = -1;

        /* renamed from: d  reason: collision with root package name */
        c f2525d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2522a = obtainStyledAttributes.getResourceId(index, this.f2522a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2524c = obtainStyledAttributes.getResourceId(index, this.f2524c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2524c);
                    context.getResources().getResourceName(this.f2524c);
                    if (Item.KEY_LAYOUT.equals(resourceTypeName)) {
                        this.f2525d = new c();
                        this.f2525d.a(context, this.f2524c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f2523b.size(); i2++) {
                if (this.f2523b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    static class C0035b {

        /* renamed from: a  reason: collision with root package name */
        float f2526a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2527b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f2528c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f2529d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f2530e = -1;

        /* renamed from: f  reason: collision with root package name */
        c f2531f;

        public C0035b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.f2530e = obtainStyledAttributes.getResourceId(index, this.f2530e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2530e);
                    context.getResources().getResourceName(this.f2530e);
                    if (Item.KEY_LAYOUT.equals(resourceTypeName)) {
                        this.f2531f = new c();
                        this.f2531f.a(context, this.f2530e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2529d = obtainStyledAttributes.getDimension(index, this.f2529d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2527b = obtainStyledAttributes.getDimension(index, this.f2527b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2528c = obtainStyledAttributes.getDimension(index, this.f2528c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2526a = obtainStyledAttributes.getDimension(index, this.f2526a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public final boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f2526a) && f2 < this.f2526a) {
                return false;
            }
            if (!Float.isNaN(this.f2527b) && f3 < this.f2527b) {
                return false;
            }
            if (!Float.isNaN(this.f2528c) && f2 > this.f2528c) {
                return false;
            }
            if (Float.isNaN(this.f2529d) || f3 <= this.f2529d) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "id"
            android.content.res.Resources r1 = r11.getResources()
            android.content.res.XmlResourceParser r12 = r1.getXml(r12)
            r1 = 0
            int r2 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
        L_0x000f:
            r3 = 1
            if (r2 == r3) goto L_0x00e3
            if (r2 == 0) goto L_0x00da
            r4 = 2
            if (r2 == r4) goto L_0x0019
            goto L_0x00dd
        L_0x0019:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r5 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r6 = 0
            r7 = 4
            r8 = 3
            r9 = -1
            switch(r5) {
                case -1349929691: goto L_0x0051;
                case 80204913: goto L_0x0047;
                case 1382829617: goto L_0x003d;
                case 1657696882: goto L_0x0033;
                case 1901439077: goto L_0x0029;
                default: goto L_0x0028;
            }     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
        L_0x0028:
            goto L_0x005b
        L_0x0029:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r2 == 0) goto L_0x005b
            r2 = 3
            goto L_0x005c
        L_0x0033:
            java.lang.String r5 = "layoutDescription"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r2 == 0) goto L_0x005b
            r2 = 0
            goto L_0x005c
        L_0x003d:
            java.lang.String r5 = "StateSet"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r2 == 0) goto L_0x005b
            r2 = 1
            goto L_0x005c
        L_0x0047:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r2 == 0) goto L_0x005b
            r2 = 2
            goto L_0x005c
        L_0x0051:
            java.lang.String r5 = "ConstraintSet"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r2 == 0) goto L_0x005b
            r2 = 4
            goto L_0x005c
        L_0x005b:
            r2 = -1
        L_0x005c:
            if (r2 == 0) goto L_0x00dd
            if (r2 == r3) goto L_0x00dd
            if (r2 == r4) goto L_0x00cd
            if (r2 == r8) goto L_0x00c0
            if (r2 == r7) goto L_0x0068
            goto L_0x00dd
        L_0x0068:
            androidx.constraintlayout.widget.c r2 = new androidx.constraintlayout.widget.c     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r4 = r12.getAttributeCount()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
        L_0x0071:
            if (r6 >= r4) goto L_0x00dd
            java.lang.String r5 = r12.getAttributeName(r6)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            boolean r5 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r5 == 0) goto L_0x00bd
            java.lang.String r4 = r12.getAttributeValue(r6)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            java.lang.String r5 = "/"
            boolean r5 = r4.contains(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r5 == 0) goto L_0x00a1
            r5 = 47
            int r5 = r4.indexOf(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r5 = r5 + r3
            java.lang.String r5 = r4.substring(r5)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            android.content.res.Resources r6 = r11.getResources()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            java.lang.String r7 = r11.getPackageName()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r5 = r6.getIdentifier(r5, r0, r7)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            goto L_0x00a2
        L_0x00a1:
            r5 = -1
        L_0x00a2:
            if (r5 != r9) goto L_0x00b4
            if (r4 == 0) goto L_0x00b4
            int r6 = r4.length()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r6 <= r3) goto L_0x00b4
            java.lang.String r3 = r4.substring(r3)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r5 = java.lang.Integer.parseInt(r3)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
        L_0x00b4:
            r2.a((android.content.Context) r11, (org.xmlpull.v1.XmlPullParser) r12)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            android.util.SparseArray<androidx.constraintlayout.widget.c> r3 = r10.f2521g     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r3.put(r5, r2)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            goto L_0x00dd
        L_0x00bd:
            int r6 = r6 + 1
            goto L_0x0071
        L_0x00c0:
            androidx.constraintlayout.widget.b$b r2 = new androidx.constraintlayout.widget.b$b     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            if (r1 == 0) goto L_0x00dd
            java.util.ArrayList<androidx.constraintlayout.widget.b$b> r3 = r1.f2523b     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            goto L_0x00dd
        L_0x00cd:
            androidx.constraintlayout.widget.b$a r1 = new androidx.constraintlayout.widget.b$a     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r1.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r2 = r10.f2520f     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            int r3 = r1.f2522a     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            r2.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            goto L_0x00dd
        L_0x00da:
            r12.getName()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
        L_0x00dd:
            int r2 = r12.next()     // Catch:{ XmlPullParserException -> 0x00e9, IOException -> 0x00e4 }
            goto L_0x000f
        L_0x00e3:
            return
        L_0x00e4:
            r11 = move-exception
            r11.printStackTrace()
            return
        L_0x00e9:
            r11 = move-exception
            r11.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }
}
