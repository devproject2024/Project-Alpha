package com.paytm.android.chat.view.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.h.c.b;
import androidx.core.h.c.c;
import kotlin.g.b.k;

public final class ChatEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private String[] f42587a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f42588b;

    /* renamed from: c  reason: collision with root package name */
    private final b.a f42589c = new b(this);

    public interface a {
        void a(c cVar);
    }

    public final String[] getImgTypeString() {
        return this.f42587a;
    }

    public final void setImgTypeString(String[] strArr) {
        this.f42587a = strArr;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatEditText(Context context) {
        super(context);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        a();
    }

    private final void a() {
        this.f42587a = new String[]{"image/png", "image/gif", "image/jpeg", "image/webp"};
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        k.c(editorInfo, "outAttrs");
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null) {
            androidx.core.h.c.a.a(editorInfo, this.f42587a);
            return androidx.core.h.c.b.a(onCreateInputConnection, editorInfo, this.f42589c);
        }
        InputConnection onCreateInputConnection2 = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection2 == null) {
            return null;
        }
        return onCreateInputConnection2;
    }

    public final b.a getCallback() {
        return this.f42589c;
    }

    static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatEditText f42590a;

        b(ChatEditText chatEditText) {
            this.f42590a = chatEditText;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(androidx.core.h.c.c r7, int r8) {
            /*
                r6 = this;
                boolean r0 = androidx.core.d.a.a()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0010
                r8 = r8 & r1
                if (r8 == 0) goto L_0x0010
                r7.c()     // Catch:{ Exception -> 0x000f }
                goto L_0x0010
            L_0x000f:
                return r2
            L_0x0010:
                com.paytm.android.chat.view.input.ChatEditText r8 = r6.f42590a
                java.lang.String[] r8 = r8.getImgTypeString()
                if (r8 == 0) goto L_0x003d
                com.paytm.android.chat.view.input.ChatEditText r8 = r6.f42590a
                java.lang.String[] r8 = r8.getImgTypeString()
                if (r8 != 0) goto L_0x0023
                kotlin.g.b.k.a()
            L_0x0023:
                int r0 = r8.length
                r3 = 0
            L_0x0025:
                if (r3 >= r0) goto L_0x003d
                r4 = r8[r3]
                java.lang.String r5 = "inputContentInfo"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
                android.content.ClipDescription r5 = r7.b()
                boolean r4 = r5.hasMimeType(r4)
                if (r4 == 0) goto L_0x003a
                r8 = 1
                goto L_0x003e
            L_0x003a:
                int r3 = r3 + 1
                goto L_0x0025
            L_0x003d:
                r8 = 0
            L_0x003e:
                if (r8 != 0) goto L_0x0041
                return r2
            L_0x0041:
                com.paytm.android.chat.view.input.ChatEditText r8 = r6.f42590a
                com.paytm.android.chat.view.input.ChatEditText$a r8 = r8.f42588b
                if (r8 == 0) goto L_0x0057
                com.paytm.android.chat.view.input.ChatEditText r8 = r6.f42590a
                com.paytm.android.chat.view.input.ChatEditText$a r8 = r8.f42588b
                if (r8 != 0) goto L_0x0054
                kotlin.g.b.k.a()
            L_0x0054:
                r8.a(r7)
            L_0x0057:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.input.ChatEditText.b.a(androidx.core.h.c.c, int):boolean");
        }
    }

    public final void setKeyBoardInputCallbackListener(a aVar) {
        this.f42588b = aVar;
    }
}
