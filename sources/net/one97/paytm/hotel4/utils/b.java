package net.one97.paytm.hotel4.utils;

import android.content.Context;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28634a;

    public b(Context context) {
        this.f28634a = context;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28635a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f28636b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f28637c = "";

        public final void a(String str) {
            k.c(str, "<set-?>");
            this.f28635a = str;
        }

        public final void b(String str) {
            k.c(str, "<set-?>");
            this.f28636b = str;
        }

        public final void c(String str) {
            k.c(str, "<set-?>");
            this.f28637c = str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0224, code lost:
        r5 = (r5 = r5.getApplicationContext()).getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.hotel4.utils.b.a a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.hotel4.utils.b$a r0 = new net.one97.paytm.hotel4.utils.b$a
            r0.<init>()
            int r1 = r5.hashCode()
            r2 = 56
            r3 = 0
            if (r1 == r2) goto L_0x0276
            switch(r1) {
                case 48: goto L_0x0212;
                case 49: goto L_0x01ad;
                case 50: goto L_0x0148;
                case 51: goto L_0x00e3;
                case 52: goto L_0x007e;
                case 53: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x02d9
        L_0x0019:
            java.lang.String r1 = "5"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0038
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0038
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0038
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_company_name_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0039
        L_0x0038:
            r5 = r3
        L_0x0039:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0057
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0057
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0057
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_company_name_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0058
        L_0x0057:
            r5 = r3
        L_0x0058:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0075
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0075
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0075
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_company_name_button
            java.lang.String r3 = r5.getString(r1)
        L_0x0075:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x007e:
            java.lang.String r1 = "4"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x009d
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x009d
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x009d
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_gst_number_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x009e
        L_0x009d:
            r5 = r3
        L_0x009e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x00bc
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x00bc
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x00bc
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_gst_number_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x00bd
        L_0x00bc:
            r5 = r3
        L_0x00bd:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x00da
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x00da
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x00da
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_gst_number_button
            java.lang.String r3 = r5.getString(r1)
        L_0x00da:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x00e3:
            java.lang.String r1 = "3"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0102
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0102
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0102
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_mobile_number_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0103
        L_0x0102:
            r5 = r3
        L_0x0103:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0121
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0121
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0121
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_mobile_number_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0122
        L_0x0121:
            r5 = r3
        L_0x0122:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x013f
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x013f
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x013f
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_mobile_number_button
            java.lang.String r3 = r5.getString(r1)
        L_0x013f:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x0148:
            java.lang.String r1 = "2"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0167
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0167
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0167
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_email_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0168
        L_0x0167:
            r5 = r3
        L_0x0168:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0186
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0186
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0186
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_email_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0187
        L_0x0186:
            r5 = r3
        L_0x0187:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x01a4
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x01a4
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x01a4
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_email_button
            java.lang.String r3 = r5.getString(r1)
        L_0x01a4:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x01ad:
            java.lang.String r1 = "1"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x01cc
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x01cc
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x01cc
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_last_name_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x01cd
        L_0x01cc:
            r5 = r3
        L_0x01cd:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x01eb
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x01eb
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x01eb
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_last_name_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x01ec
        L_0x01eb:
            r5 = r3
        L_0x01ec:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0209
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0209
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0209
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_last_name_button
            java.lang.String r3 = r5.getString(r1)
        L_0x0209:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x0212:
            java.lang.String r1 = "0"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0231
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0231
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0231
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_first_name_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0232
        L_0x0231:
            r5 = r3
        L_0x0232:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0250
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0250
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0250
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_first_name_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0251
        L_0x0250:
            r5 = r3
        L_0x0251:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x026e
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x026e
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x026e
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_first_name_button
            java.lang.String r3 = r5.getString(r1)
        L_0x026e:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
            goto L_0x02d9
        L_0x0276:
            java.lang.String r1 = "8"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x02d9
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x0295
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x0295
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0295
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_location_header
            java.lang.String r5 = r5.getString(r1)
            goto L_0x0296
        L_0x0295:
            r5 = r3
        L_0x0296:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.a(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x02b4
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x02b4
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x02b4
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_location_error
            java.lang.String r5 = r5.getString(r1)
            goto L_0x02b5
        L_0x02b4:
            r5 = r3
        L_0x02b5:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.b(r5)
            android.content.Context r5 = r4.f28634a
            if (r5 == 0) goto L_0x02d2
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x02d2
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x02d2
            int r1 = net.one97.paytm.hotels2.R.string.h4_error_location_button
            java.lang.String r3 = r5.getString(r1)
        L_0x02d2:
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.c(r5)
        L_0x02d9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.utils.b.a(java.lang.String):net.one97.paytm.hotel4.utils.b$a");
    }
}
