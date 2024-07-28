package androidx.core.content.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    public static ColorStateList a(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, (XmlPullParser) resources.getXml(i2), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000e
            r3 = 1
            if (r1 != r3) goto L_0x0004
        L_0x000e:
            if (r1 != r2) goto L_0x0015
            android.content.res.ColorStateList r4 = a(r4, r5, r0, r6)
            return r4
        L_0x0015:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.a.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARNING: type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            int r2 = r18.getDepth()
            r3 = 1
            int r2 = r2 + r3
            r4 = 20
            int[][] r5 = new int[r4][]
            int[] r4 = new int[r4]
            r6 = 0
            r7 = r4
            r4 = 0
        L_0x0013:
            int r8 = r18.next()
            if (r8 == r3) goto L_0x00e7
            int r9 = r18.getDepth()
            if (r9 >= r2) goto L_0x0022
            r10 = 3
            if (r8 == r10) goto L_0x00e7
        L_0x0022:
            r10 = 2
            if (r8 != r10) goto L_0x00e2
            if (r9 > r2) goto L_0x00e2
            java.lang.String r8 = r18.getName()
            java.lang.String r9 = "item"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00e2
            int[] r8 = androidx.core.R.styleable.ColorStateListItem
            if (r1 != 0) goto L_0x003e
            r9 = r17
            android.content.res.TypedArray r8 = r9.obtainAttributes(r0, r8)
            goto L_0x0044
        L_0x003e:
            r9 = r17
            android.content.res.TypedArray r8 = r1.obtainStyledAttributes(r0, r8, r6, r6)
        L_0x0044:
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            r11 = -65281(0xffffffffffff00ff, float:NaN)
            int r10 = r8.getColor(r10, r11)
            int r11 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            boolean r11 = r8.hasValue(r11)
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r11 == 0) goto L_0x005e
            int r11 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            float r12 = r8.getFloat(r11, r12)
            goto L_0x006c
        L_0x005e:
            int r11 = androidx.core.R.styleable.ColorStateListItem_alpha
            boolean r11 = r8.hasValue(r11)
            if (r11 == 0) goto L_0x006c
            int r11 = androidx.core.R.styleable.ColorStateListItem_alpha
            float r12 = r8.getFloat(r11, r12)
        L_0x006c:
            r8.recycle()
            int r8 = r19.getAttributeCount()
            int[] r11 = new int[r8]
            r13 = 0
            r14 = 0
        L_0x0077:
            if (r13 >= r8) goto L_0x009c
            int r15 = r0.getAttributeNameResource(r13)
            r3 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r3) goto L_0x0098
            r3 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r3) goto L_0x0098
            int r3 = androidx.core.R.attr.alpha
            if (r15 == r3) goto L_0x0098
            int r3 = r14 + 1
            boolean r16 = r0.getAttributeBooleanValue(r13, r6)
            if (r16 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            int r15 = -r15
        L_0x0095:
            r11[r14] = r15
            r14 = r3
        L_0x0098:
            int r13 = r13 + 1
            r3 = 1
            goto L_0x0077
        L_0x009c:
            int[] r3 = android.util.StateSet.trimStateSet(r11, r14)
            int r8 = android.graphics.Color.alpha(r10)
            float r8 = (float) r8
            float r8 = r8 * r12
            int r8 = java.lang.Math.round(r8)
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r10 = r10 & r11
            int r8 = r8 << 24
            r8 = r8 | r10
            int r10 = r4 + 1
            int r11 = r7.length
            if (r10 <= r11) goto L_0x00c1
            int r11 = androidx.core.content.b.e.a(r4)
            int[] r11 = new int[r11]
            java.lang.System.arraycopy(r7, r6, r11, r6, r4)
            r7 = r11
        L_0x00c1:
            r7[r4] = r8
            int r8 = r5.length
            if (r10 <= r8) goto L_0x00dc
            java.lang.Class r8 = r5.getClass()
            java.lang.Class r8 = r8.getComponentType()
            int r11 = androidx.core.content.b.e.a(r4)
            java.lang.Object r8 = java.lang.reflect.Array.newInstance(r8, r11)
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            java.lang.System.arraycopy(r5, r6, r8, r6, r4)
            r5 = r8
        L_0x00dc:
            r5[r4] = r3
            int[][] r5 = (int[][]) r5
            r4 = r10
            goto L_0x00e4
        L_0x00e2:
            r9 = r17
        L_0x00e4:
            r3 = 1
            goto L_0x0013
        L_0x00e7:
            int[] r0 = new int[r4]
            int[][] r1 = new int[r4][]
            java.lang.System.arraycopy(r7, r6, r0, r6, r4)
            java.lang.System.arraycopy(r5, r6, r1, r6, r4)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.a.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}
