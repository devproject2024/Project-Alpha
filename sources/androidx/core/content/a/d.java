package androidx.core.content.a;

import android.app.Person;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c<?> f2822a;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0013
            java.lang.Class<android.content.pm.ShortcutManager> r0 = android.content.pm.ShortcutManager.class
            java.lang.Object r4 = r4.getSystemService(r0)
            android.content.pm.ShortcutManager r4 = (android.content.pm.ShortcutManager) r4
            boolean r4 = r4.isRequestPinShortcutSupported()
            return r4
        L_0x0013:
            java.lang.String r0 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            int r1 = androidx.core.content.b.a((android.content.Context) r4, (java.lang.String) r0)
            r2 = 0
            if (r1 == 0) goto L_0x001d
            return r2
        L_0x001d:
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "com.android.launcher.action.INSTALL_SHORTCUT"
            r1.<init>(r3)
            java.util.List r4 = r4.queryBroadcastReceivers(r1, r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x0030:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r4.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            java.lang.String r1 = r1.permission
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x004c
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0030
        L_0x004c:
            r4 = 1
            return r4
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.d.a(android.content.Context):boolean");
    }

    public static boolean a(Context context, b bVar, final IntentSender intentSender) {
        if (Build.VERSION.SDK_INT >= 26) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            ShortcutInfo.Builder intents = new ShortcutInfo.Builder(bVar.f2812a, bVar.f2813b).setShortLabel(bVar.f2816e).setIntents(bVar.f2814c);
            if (bVar.f2819h != null) {
                intents.setIcon(bVar.f2819h.a(bVar.f2812a));
            }
            if (!TextUtils.isEmpty(bVar.f2817f)) {
                intents.setLongLabel(bVar.f2817f);
            }
            if (!TextUtils.isEmpty(bVar.f2818g)) {
                intents.setDisabledMessage(bVar.f2818g);
            }
            if (bVar.f2815d != null) {
                intents.setActivity(bVar.f2815d);
            }
            if (bVar.k != null) {
                intents.setCategories(bVar.k);
            }
            intents.setRank(bVar.m);
            if (Build.VERSION.SDK_INT >= 29) {
                if (bVar.j != null && bVar.j.length > 0) {
                    Person[] personArr = new Person[bVar.j.length];
                    for (int i2 = 0; i2 < personArr.length; i2++) {
                        personArr[i2] = bVar.j[i2].b();
                    }
                    intents.setPersons(personArr);
                }
                intents.setLongLived(bVar.l);
            } else {
                intents.setExtras(bVar.a());
            }
            return shortcutManager.requestPinShortcut(intents.build(), intentSender);
        } else if (!a(context)) {
            return false;
        } else {
            Intent a2 = bVar.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
            if (intentSender == null) {
                context.sendBroadcast(a2);
                return true;
            }
            context.sendOrderedBroadcast(a2, (String) null, new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    try {
                        intentSender.sendIntent(context, 0, (Intent) null, (IntentSender.OnFinished) null, (Handler) null);
                    } catch (IntentSender.SendIntentException unused) {
                    }
                }
            }, (Handler) null, -1, (String) null, (Bundle) null);
            return true;
        }
    }
}
