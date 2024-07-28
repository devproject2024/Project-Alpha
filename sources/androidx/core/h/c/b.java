package androidx.core.h.c;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.h.c.c;

public final class b {

    public interface a {
        boolean a(c cVar, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.lang.String r7, android.os.Bundle r8, androidx.core.h.c.b.a r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r1 = android.text.TextUtils.equals(r1, r7)
            if (r1 == 0) goto L_0x000e
            r7 = 0
            goto L_0x0017
        L_0x000e:
            java.lang.String r1 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 == 0) goto L_0x007e
            r7 = 1
        L_0x0017:
            r1 = 0
            if (r7 == 0) goto L_0x001d
            java.lang.String r2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x001f
        L_0x001d:
            java.lang.String r2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x001f:
            android.os.Parcelable r2 = r8.getParcelable(r2)     // Catch:{ all -> 0x0076 }
            android.os.ResultReceiver r2 = (android.os.ResultReceiver) r2     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x002a
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x002c
        L_0x002a:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x002c:
            android.os.Parcelable r3 = r8.getParcelable(r3)     // Catch:{ all -> 0x0074 }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0037
            java.lang.String r4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x0039
        L_0x0037:
            java.lang.String r4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x0039:
            android.os.Parcelable r4 = r8.getParcelable(r4)     // Catch:{ all -> 0x0074 }
            android.content.ClipDescription r4 = (android.content.ClipDescription) r4     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0044
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x0046
        L_0x0044:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x0046:
            android.os.Parcelable r5 = r8.getParcelable(r5)     // Catch:{ all -> 0x0074 }
            android.net.Uri r5 = (android.net.Uri) r5     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0051
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0053
        L_0x0051:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0053:
            int r6 = r8.getInt(r6)     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x005c
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x005e
        L_0x005c:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x005e:
            r8.getParcelable(r7)     // Catch:{ all -> 0x0074 }
            if (r3 == 0) goto L_0x006e
            if (r4 == 0) goto L_0x006e
            androidx.core.h.c.c r7 = new androidx.core.h.c.c     // Catch:{ all -> 0x0074 }
            r7.<init>(r3, r4, r5)     // Catch:{ all -> 0x0074 }
            boolean r0 = r9.a(r7, r6)     // Catch:{ all -> 0x0074 }
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.send(r0, r1)
        L_0x0073:
            return r0
        L_0x0074:
            r7 = move-exception
            goto L_0x0078
        L_0x0076:
            r7 = move-exception
            r2 = r1
        L_0x0078:
            if (r2 == 0) goto L_0x007d
            r2.send(r0, r1)
        L_0x007d:
            throw r7
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.c.b.a(java.lang.String, android.os.Bundle, androidx.core.h.c.b$a):boolean");
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, final a aVar) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        } else if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("onCommitContentListener must be non-null");
        } else if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionWrapper(inputConnection) {
                public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                    a aVar = aVar;
                    c cVar = null;
                    if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
                        cVar = new c(new c.a(inputContentInfo));
                    }
                    if (aVar.a(cVar, i2)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i2, bundle);
                }
            };
        } else {
            if (a.a(editorInfo).length == 0) {
                return inputConnection;
            }
            return new InputConnectionWrapper(inputConnection) {
                public final boolean performPrivateCommand(String str, Bundle bundle) {
                    if (b.a(str, bundle, aVar)) {
                        return true;
                    }
                    return super.performPrivateCommand(str, bundle);
                }
            };
        }
    }
}
