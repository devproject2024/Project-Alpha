package com.google.android.youtube.player;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.youtube.player.internal.c;

public enum b {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    /* renamed from: com.google.android.youtube.player.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37547a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.android.youtube.player.b[] r0 = com.google.android.youtube.player.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37547a = r0
                int[] r0 = f37547a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.android.youtube.player.b r1 = com.google.android.youtube.player.b.SERVICE_MISSING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f37547a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.android.youtube.player.b r1 = com.google.android.youtube.player.b.SERVICE_DISABLED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f37547a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.android.youtube.player.b r1 = com.google.android.youtube.player.b.SERVICE_VERSION_UPDATE_REQUIRED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.youtube.player.b.AnonymousClass1.<clinit>():void");
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f37548a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f37549b;

        /* renamed from: c  reason: collision with root package name */
        private final int f37550c;

        public a(Activity activity, Intent intent, int i2) {
            this.f37548a = (Activity) c.a(activity);
            this.f37549b = (Intent) c.a(intent);
            this.f37550c = ((Integer) c.a(Integer.valueOf(i2))).intValue();
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            try {
                this.f37548a.startActivityForResult(this.f37549b, this.f37550c);
                dialogInterface.dismiss();
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    public final Dialog getErrorDialog(Activity activity, int i2) {
        return getErrorDialog(activity, i2, (DialogInterface.OnCancelListener) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.app.Dialog getErrorDialog(android.app.Activity r6, int r7, android.content.DialogInterface.OnCancelListener r8) {
        /*
            r5 = this;
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r6)
            if (r8 == 0) goto L_0x000a
            r0.setOnCancelListener(r8)
        L_0x000a:
            int[] r8 = com.google.android.youtube.player.b.AnonymousClass1.f37547a
            int r1 = r5.ordinal()
            r8 = r8[r1]
            r1 = 3
            r2 = 2
            r3 = 1
            if (r8 == r3) goto L_0x0026
            if (r8 == r2) goto L_0x001d
            if (r8 == r1) goto L_0x0026
            r8 = 0
            goto L_0x002e
        L_0x001d:
            java.lang.String r8 = com.google.android.youtube.player.internal.aa.a((android.content.Context) r6)
            android.content.Intent r8 = com.google.android.youtube.player.internal.aa.a((java.lang.String) r8)
            goto L_0x002e
        L_0x0026:
            java.lang.String r8 = com.google.android.youtube.player.internal.aa.a((android.content.Context) r6)
            android.content.Intent r8 = com.google.android.youtube.player.internal.aa.b((java.lang.String) r8)
        L_0x002e:
            com.google.android.youtube.player.b$a r4 = new com.google.android.youtube.player.b$a
            r4.<init>(r6, r8, r7)
            com.google.android.youtube.player.internal.q r7 = new com.google.android.youtube.player.internal.q
            r7.<init>(r6)
            int[] r6 = com.google.android.youtube.player.b.AnonymousClass1.f37547a
            int r8 = r5.ordinal()
            r6 = r6[r8]
            if (r6 == r3) goto L_0x008d
            if (r6 == r2) goto L_0x007e
            if (r6 == r1) goto L_0x0067
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Unexpected errorReason: "
            java.lang.String r8 = r5.name()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r0 = r8.length()
            if (r0 == 0) goto L_0x005d
            java.lang.String r7 = r7.concat(r8)
            goto L_0x0063
        L_0x005d:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r7)
            r7 = r8
        L_0x0063:
            r6.<init>(r7)
            throw r6
        L_0x0067:
            java.lang.String r6 = r7.f37583h
            android.app.AlertDialog$Builder r6 = r0.setTitle(r6)
            java.lang.String r8 = r7.f37584i
            android.app.AlertDialog$Builder r6 = r6.setMessage(r8)
            java.lang.String r7 = r7.j
        L_0x0075:
            android.app.AlertDialog$Builder r6 = r6.setPositiveButton(r7, r4)
            android.app.AlertDialog r6 = r6.create()
            return r6
        L_0x007e:
            java.lang.String r6 = r7.f37580e
            android.app.AlertDialog$Builder r6 = r0.setTitle(r6)
            java.lang.String r8 = r7.f37581f
            android.app.AlertDialog$Builder r6 = r6.setMessage(r8)
            java.lang.String r7 = r7.f37582g
            goto L_0x0075
        L_0x008d:
            java.lang.String r6 = r7.f37577b
            android.app.AlertDialog$Builder r6 = r0.setTitle(r6)
            java.lang.String r8 = r7.f37578c
            android.app.AlertDialog$Builder r6 = r6.setMessage(r8)
            java.lang.String r7 = r7.f37579d
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.youtube.player.b.getErrorDialog(android.app.Activity, int, android.content.DialogInterface$OnCancelListener):android.app.Dialog");
    }

    public final boolean isUserRecoverableError() {
        int i2 = AnonymousClass1.f37547a[ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3;
    }
}
