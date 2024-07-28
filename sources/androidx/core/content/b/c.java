package androidx.core.content.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c {

    public interface a {
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        public final androidx.core.e.a f2837a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2838b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2839c;

        public d(androidx.core.e.a aVar, int i2, int i3) {
            this.f2837a = aVar;
            this.f2839c = i2;
            this.f2838b = i3;
        }
    }

    /* renamed from: androidx.core.content.b.c$c  reason: collision with other inner class name */
    public static final class C0040c {

        /* renamed from: a  reason: collision with root package name */
        public final String f2831a;

        /* renamed from: b  reason: collision with root package name */
        public int f2832b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2833c;

        /* renamed from: d  reason: collision with root package name */
        public String f2834d;

        /* renamed from: e  reason: collision with root package name */
        public int f2835e;

        /* renamed from: f  reason: collision with root package name */
        public int f2836f;

        public C0040c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.f2831a = str;
            this.f2832b = i2;
            this.f2833c = z;
            this.f2834d = str2;
            this.f2835e = i3;
            this.f2836f = i4;
        }
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final C0040c[] f2830a;

        public b(C0040c[] cVarArr) {
            this.f2830a = cVarArr;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.b.c.a a(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000a
            r2 = 1
            if (r0 != r2) goto L_0x0000
        L_0x000a:
            if (r0 != r1) goto L_0x0025
            java.lang.String r0 = "font-family"
            r2 = 0
            r3.require(r1, r2, r0)
            java.lang.String r1 = r3.getName()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0021
            androidx.core.content.b.c$a r3 = b(r3, r4)
            return r3
        L_0x0021:
            a((org.xmlpull.v1.XmlPullParser) r3)
            return r2
        L_0x0025:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.c.a(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.b.c$a");
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(c(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0040c[]) arrayList.toArray(new C0040c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new d(new androidx.core.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        int i3;
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                i3 = obtainTypedArray.getType(0);
            } else {
                TypedValue typedValue = new TypedValue();
                obtainTypedArray.getValue(0, typedValue);
                i3 = typedValue.type;
            }
            if (i3 == 1) {
                for (int i4 = 0; i4 < obtainTypedArray.length(); i4++) {
                    int resourceId = obtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static C0040c c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
            i2 = R.styleable.FontFamilyFont_fontWeight;
        } else {
            i2 = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i7 = obtainAttributes.getInt(i2, 400);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
            i3 = R.styleable.FontFamilyFont_fontStyle;
        } else {
            i3 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
            i4 = R.styleable.FontFamilyFont_ttcIndex;
        } else {
            i4 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
            i5 = R.styleable.FontFamilyFont_fontVariationSettings;
        } else {
            i5 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i5);
        int i8 = obtainAttributes.getInt(i4, 0);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_font)) {
            i6 = R.styleable.FontFamilyFont_font;
        } else {
            i6 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i6, 0);
        String string2 = obtainAttributes.getString(i6);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0040c(string2, i7, z, string, i8, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
