package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class i {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3909b = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    final boolean f3910a;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<String> f3911c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final Pattern f3912d;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    i(java.lang.String r10) {
        /*
            r9 = this;
            r9.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.f3911c = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "^"
            r0.<init>(r1)
            java.util.regex.Pattern r1 = f3909b
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.find()
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = "http[s]?://"
            r0.append(r1)
        L_0x0022:
            java.lang.String r1 = "\\{(.+?)\\}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r10)
            java.lang.String r2 = ".*"
            boolean r3 = r10.contains(r2)
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x003c
            r6 = r9
            r3 = r10
            r7 = r0
            r10 = 1
            r0 = 0
            goto L_0x0045
        L_0x003c:
            r3 = r9
            r6 = r0
            r0 = r10
            r10 = 0
        L_0x0040:
            r7 = r6
            r6 = r3
            r3 = r0
            r0 = r10
            r10 = 0
        L_0x0045:
            boolean r8 = r1.find()
            if (r8 == 0) goto L_0x0070
            java.lang.String r10 = r1.group(r4)
            java.util.ArrayList<java.lang.String> r8 = r6.f3911c
            r8.add(r10)
            int r10 = r1.start()
            java.lang.String r10 = r3.substring(r0, r10)
            java.lang.String r10 = java.util.regex.Pattern.quote(r10)
            r7.append(r10)
            java.lang.String r10 = "(.+?)"
            r7.append(r10)
            int r10 = r1.end()
            r0 = r3
            r3 = r6
            r6 = r7
            goto L_0x0040
        L_0x0070:
            int r1 = r3.length()
            if (r0 >= r1) goto L_0x0081
            java.lang.String r0 = r3.substring(r0)
            java.lang.String r0 = java.util.regex.Pattern.quote(r0)
            r7.append(r0)
        L_0x0081:
            java.lang.String r0 = r7.toString()
            java.lang.String r1 = "\\E.*\\Q"
            java.lang.String r0 = r0.replace(r2, r1)
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r6.f3912d = r0
            r6.f3910a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.i.<init>(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(Uri uri, Map<String, f> map) {
        Matcher matcher = this.f3912d.matcher(uri.toString());
        if (!matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f3911c.size();
        int i2 = 0;
        while (i2 < size) {
            String str = this.f3911c.get(i2);
            i2++;
            String decode = Uri.decode(matcher.group(i2));
            f fVar = map.get(str);
            if (fVar != null) {
                q qVar = fVar.f3876a;
                try {
                    qVar.a(bundle, str, qVar.a(decode));
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            } else {
                bundle.putString(str, decode);
            }
        }
        return bundle;
    }
}
