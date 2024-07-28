package net.one97.paytm.phoenix.manager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public ValueCallback<Uri[]> f59599a;

    public final void a(Uri[] uriArr) {
        k.c(uriArr, "data");
        ValueCallback<Uri[]> valueCallback = this.f59599a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uriArr);
        }
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Intent r8, java.lang.String[] r9) {
        /*
            java.lang.String r0 = "video/*"
            java.lang.String r1 = "image/*"
            java.lang.String r2 = "application/*"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2}
            int r1 = r9.length
            r2 = 0
            r3 = 0
        L_0x000d:
            java.lang.String r4 = "android.intent.extra.MIME_TYPES"
            if (r3 >= r1) goto L_0x004e
            r5 = r9[r3]
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "."
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r7, (boolean) r2)
            if (r6 == 0) goto L_0x004b
            net.one97.paytm.phoenix.util.h r6 = net.one97.paytm.phoenix.util.h.f59643a
            java.util.HashMap r6 = net.one97.paytm.phoenix.util.h.a()
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0047
            int r4 = kotlin.a.f.b((T[]) r9, r5)
            net.one97.paytm.phoenix.util.h r6 = net.one97.paytm.phoenix.util.h.f59643a
            java.util.HashMap r6 = net.one97.paytm.phoenix.util.h.a()
            java.lang.Object r5 = r6.get(r5)
            if (r5 != 0) goto L_0x003f
            kotlin.g.b.k.a()
        L_0x003f:
            java.lang.String r6 = "PhoenixConstants.mimetyp…ashMap().get(extension)!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r9[r4] = r5
            goto L_0x004b
        L_0x0047:
            r8.putExtra(r4, r0)
            return
        L_0x004b:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x004e:
            r8.putExtra(r4, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.manager.b.a(android.content.Intent, java.lang.String[]):void");
    }

    public static void a(List<ResolveInfo> list, Intent intent, ArrayList<Intent> arrayList) {
        for (ResolveInfo next : list) {
            String str = next.activityInfo.packageName;
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(str, next.activityInfo.name));
            intent2.setPackage(str);
            arrayList.add(intent2);
        }
    }
}
