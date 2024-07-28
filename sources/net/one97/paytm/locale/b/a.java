package net.one97.paytm.locale.b;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Map;
import net.one97.paytm.locale.b.n;

final class a implements n.a {
    a() {
    }

    public final Class<? extends View> a() {
        return BottomNavigationView.class;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        throw new java.lang.RuntimeException("Expecting menu, got ".concat(java.lang.String.valueOf(r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1 = r8.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r1.equals("menu") == false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r1 = r8.next();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.Integer, net.one97.paytm.locale.b.a.C0947a> a(android.content.res.Resources r8, int r9) {
        /*
            android.content.res.XmlResourceParser r8 = r8.getLayout(r9)
            android.util.AttributeSet r9 = android.util.Xml.asAttributeSet(r8)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            int r1 = r8.getEventType()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
        L_0x0011:
            r2 = 2
            java.lang.String r3 = "menu"
            r4 = 1
            if (r1 != r2) goto L_0x0036
            java.lang.String r1 = r8.getName()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            boolean r5 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r5 == 0) goto L_0x0026
            int r1 = r8.next()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            goto L_0x003c
        L_0x0026:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            java.lang.String r9 = "Expecting menu, got "
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            java.lang.String r9 = r9.concat(r0)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            r8.<init>(r9)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            throw r8     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
        L_0x0036:
            int r1 = r8.next()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r1 != r4) goto L_0x0011
        L_0x003c:
            r5 = 0
            r6 = 0
        L_0x003e:
            if (r5 != 0) goto L_0x0080
            if (r1 == r4) goto L_0x007a
            if (r1 == r2) goto L_0x0057
            r7 = 3
            if (r1 == r7) goto L_0x0048
            goto L_0x007b
        L_0x0048:
            java.lang.String r1 = r8.getName()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r1 == 0) goto L_0x007b
            int r6 = r6 + -1
            if (r6 > 0) goto L_0x007b
            goto L_0x007a
        L_0x0057:
            java.lang.String r1 = r8.getName()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            java.lang.String r7 = "item"
            boolean r7 = r1.equals(r7)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r7 == 0) goto L_0x0071
            android.util.Pair r1 = a(r9)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r1 == 0) goto L_0x007b
            java.lang.Object r7 = r1.first     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            java.lang.Object r1 = r1.second     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            r0.put(r7, r1)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            goto L_0x007b
        L_0x0071:
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            if (r1 == 0) goto L_0x007b
            int r6 = r6 + 1
            goto L_0x007b
        L_0x007a:
            r5 = 1
        L_0x007b:
            int r1 = r8.next()     // Catch:{ XmlPullParserException -> 0x0083, IOException -> 0x0081 }
            goto L_0x003e
        L_0x0080:
            return r0
        L_0x0081:
            r8 = move-exception
            goto L_0x0084
        L_0x0083:
            r8 = move-exception
        L_0x0084:
            java.lang.String r8 = r8.getMessage()
            com.paytm.utility.q.b(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.locale.b.a.a(android.content.res.Resources, int):java.util.Map");
    }

    private static Pair<Integer, C0947a> a(AttributeSet attributeSet) {
        String attributeValue;
        int attributeCount = attributeSet.getAttributeCount();
        C0947a aVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = attributeSet.getAttributeName(i3);
            char c2 = 65535;
            switch (attributeName.hashCode()) {
                case -1735877235:
                    if (attributeName.equals("android:title")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 110371416:
                    if (attributeName.equals("title")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 504469935:
                    if (attributeName.equals("titleCondensed")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 722953734:
                    if (attributeName.equals("android:id")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1529604634:
                    if (attributeName.equals("android:titleCondensed")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                i2 = attributeSet.getAttributeResourceValue(i3, 0);
            } else if (c2 == 2 || c2 == 3) {
                String attributeValue2 = attributeSet.getAttributeValue(i3);
                if (attributeValue2 != null && attributeValue2.startsWith("@")) {
                    if (aVar == null) {
                        aVar = new C0947a((byte) 0);
                    }
                    aVar.f53095a = attributeSet.getAttributeResourceValue(i3, 0);
                }
            } else if ((c2 == 4 || c2 == 5) && (attributeValue = attributeSet.getAttributeValue(i3)) != null && attributeValue.startsWith("@")) {
                if (aVar == null) {
                    aVar = new C0947a((byte) 0);
                }
                aVar.f53096b = attributeSet.getAttributeResourceValue(i3, 0);
            }
        }
        if (i2 == 0 || aVar == null) {
            return null;
        }
        return new Pair<>(Integer.valueOf(i2), aVar);
    }

    /* renamed from: net.one97.paytm.locale.b.a$a  reason: collision with other inner class name */
    static class C0947a {

        /* renamed from: a  reason: collision with root package name */
        public int f53095a;

        /* renamed from: b  reason: collision with root package name */
        public int f53096b;

        private C0947a() {
        }

        /* synthetic */ C0947a(byte b2) {
            this();
        }
    }

    public final View a(View view, AttributeSet attributeSet) {
        String attributeValue;
        if (view != null && BottomNavigationView.class.isInstance(view)) {
            Resources resources = view.getContext().getResources();
            BottomNavigationView bottomNavigationView = (BottomNavigationView) view;
            for (int i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                char c2 = 65535;
                int hashCode = attributeName.hashCode();
                if (hashCode != 3347807) {
                    if (hashCode == 1133452056 && attributeName.equals("app:menu")) {
                        c2 = 0;
                    }
                } else if (attributeName.equals("menu")) {
                    c2 = 1;
                }
                if ((c2 == 0 || c2 == 1) && (attributeValue = attributeSet.getAttributeValue(i2)) != null && attributeValue.startsWith("@")) {
                    for (Map.Entry next : a(resources, attributeSet.getAttributeResourceValue(i2, 0)).entrySet()) {
                        if (((C0947a) next.getValue()).f53095a != 0) {
                            bottomNavigationView.getMenu().findItem(((Integer) next.getKey()).intValue()).setTitle(resources.getString(((C0947a) next.getValue()).f53095a));
                        }
                        if (((C0947a) next.getValue()).f53096b != 0) {
                            bottomNavigationView.getMenu().findItem(((Integer) next.getKey()).intValue()).setTitleCondensed(resources.getString(((C0947a) next.getValue()).f53096b));
                        }
                    }
                }
            }
        }
        return view;
    }
}
