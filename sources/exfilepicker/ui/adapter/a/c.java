package exfilepicker.ui.adapter.a;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.android.chat.R;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private final Context f46217b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatTextView f46218c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatImageView f46219d;

    public c(View view) {
        super(view);
        this.f46217b = view.getContext();
        this.f46218c = (AppCompatTextView) view.findViewById(R.id.filesize);
        this.f46219d = (AppCompatImageView) view.findViewById(R.id.thumbnail);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.io.File r3, boolean r4, boolean r5, exfilepicker.ui.a.a r6) {
        /*
            r2 = this;
            super.a(r3, r4, r5, r6)
            androidx.appcompat.widget.AppCompatTextView r4 = r2.f46218c
            r5 = 0
            if (r4 == 0) goto L_0x001a
            r4.setVisibility(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = r2.f46218c
            android.content.Context r6 = r2.f46217b
            long r0 = r3.length()
            java.lang.String r6 = exfilepicker.a.d.a((android.content.Context) r6, (long) r0)
            r4.setText(r6)
        L_0x001a:
            java.lang.String r4 = r3.getName()
            java.lang.String r4 = a(r4)
            r6 = -1
            int r0 = r4.hashCode()
            switch(r0) {
                case 99640: goto L_0x0067;
                case 105441: goto L_0x005d;
                case 110834: goto L_0x0053;
                case 111220: goto L_0x0049;
                case 3088960: goto L_0x003f;
                case 3268712: goto L_0x0035;
                case 3447940: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0071
        L_0x002b:
            java.lang.String r0 = "pptx"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 4
            goto L_0x0072
        L_0x0035:
            java.lang.String r0 = "jpeg"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 2
            goto L_0x0072
        L_0x003f:
            java.lang.String r0 = "docx"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 6
            goto L_0x0072
        L_0x0049:
            java.lang.String r0 = "ppt"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 3
            goto L_0x0072
        L_0x0053:
            java.lang.String r0 = "pdf"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 0
            goto L_0x0072
        L_0x005d:
            java.lang.String r0 = "jpg"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 1
            goto L_0x0072
        L_0x0067:
            java.lang.String r0 = "doc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0071
            r4 = 5
            goto L_0x0072
        L_0x0071:
            r4 = -1
        L_0x0072:
            switch(r4) {
                case 0: goto L_0x007f;
                case 1: goto L_0x007c;
                case 2: goto L_0x007c;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0076;
                case 6: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x0081
        L_0x0076:
            int r5 = com.paytm.android.chat.R.drawable.chat_icon_file_doc
            goto L_0x0081
        L_0x0079:
            int r5 = com.paytm.android.chat.R.drawable.chat_icon_file_ppt
            goto L_0x0081
        L_0x007c:
            int r5 = com.paytm.android.chat.R.drawable.chat_icon_file_jpg
            goto L_0x0081
        L_0x007f:
            int r5 = com.paytm.android.chat.R.drawable.chat_icon_file_pdf
        L_0x0081:
            java.lang.String r4 = r3.getName()
            java.lang.String r4 = a(r4)
            com.paytm.utility.q.d(r4)
            com.bumptech.glide.e.h r4 = new com.bumptech.glide.e.h
            r4.<init>()
            int r6 = com.paytm.android.chat.R.drawable.chat_efp__ic_file
            com.bumptech.glide.e.a r4 = r4.c((int) r6)
            com.bumptech.glide.e.h r4 = (com.bumptech.glide.e.h) r4
            android.content.Context r6 = r2.f46217b
            com.bumptech.glide.i r6 = com.bumptech.glide.b.b(r6)
            if (r5 == 0) goto L_0x00a5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
        L_0x00a5:
            com.bumptech.glide.h r3 = r6.a((java.lang.Object) r3)
            com.bumptech.glide.h r3 = r3.b((com.bumptech.glide.e.a<?>) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = r2.f46219d
            r3.a((android.widget.ImageView) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: exfilepicker.ui.adapter.a.c.a(java.io.File, boolean, boolean, exfilepicker.ui.a.a):void");
    }

    private static String a(String str) {
        String[] split = str.trim().split("\\.");
        return split.length >= 2 ? split[split.length - 1] : "";
    }
}
