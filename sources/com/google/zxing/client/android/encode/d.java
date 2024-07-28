package com.google.zxing.client.android.encode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.client.android.R;
import com.google.zxing.g;
import com.google.zxing.l;
import com.google.zxing.w;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

final class d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f40209e = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f40210a;

    /* renamed from: b  reason: collision with root package name */
    String f40211b;

    /* renamed from: c  reason: collision with root package name */
    String f40212c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f40213d;

    /* renamed from: f  reason: collision with root package name */
    private final Context f40214f;

    /* renamed from: g  reason: collision with root package name */
    private a f40215g;

    /* renamed from: h  reason: collision with root package name */
    private final int f40216h;

    d(Context context, Intent intent, int i2, boolean z) throws w {
        this.f40214f = context;
        this.f40216h = i2;
        this.f40213d = z;
        String action = intent.getAction();
        if (action.equals("com.google.zxing.client.android.ENCODE")) {
            a(intent);
        } else if (!action.equals("android.intent.action.SEND")) {
        } else {
            if (intent.hasExtra("android.intent.extra.STREAM")) {
                b(intent);
                return;
            }
            String a2 = a.a(intent.getStringExtra("android.intent.extra.TEXT"));
            if (a2 == null && (a2 = a.a(intent.getStringExtra("android.intent.extra.HTML_TEXT"))) == null && (a2 = a.a(intent.getStringExtra("android.intent.extra.SUBJECT"))) == null) {
                String[] stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.EMAIL");
                a2 = stringArrayExtra != null ? a.a(stringArrayExtra[0]) : "?";
            }
            if (a2 == null || a2.isEmpty()) {
                throw new w("Empty EXTRA_TEXT");
            }
            this.f40210a = a2;
            this.f40215g = a.QR_CODE;
            if (intent.hasExtra("android.intent.extra.SUBJECT")) {
                this.f40211b = intent.getStringExtra("android.intent.extra.SUBJECT");
            } else if (intent.hasExtra("android.intent.extra.TITLE")) {
                this.f40211b = intent.getStringExtra("android.intent.extra.TITLE");
            } else {
                this.f40211b = this.f40210a;
            }
            this.f40212c = this.f40214f.getString(R.string.contents_text);
        }
    }

    private boolean a(Intent intent) {
        Bundle bundleExtra;
        String stringExtra = intent.getStringExtra("ENCODE_FORMAT");
        List list = null;
        this.f40215g = null;
        if (stringExtra != null) {
            try {
                this.f40215g = a.valueOf(stringExtra);
            } catch (IllegalArgumentException unused) {
            }
        }
        a aVar = this.f40215g;
        if (aVar == null || aVar == a.QR_CODE) {
            String stringExtra2 = intent.getStringExtra("ENCODE_TYPE");
            if (stringExtra2 != null && !stringExtra2.isEmpty()) {
                this.f40215g = a.QR_CODE;
                char c2 = 65535;
                switch (stringExtra2.hashCode()) {
                    case -1309271157:
                        if (stringExtra2.equals("PHONE_TYPE")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -670199783:
                        if (stringExtra2.equals("CONTACT_TYPE")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 709220992:
                        if (stringExtra2.equals("SMS_TYPE")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1349204356:
                        if (stringExtra2.equals("LOCATION_TYPE")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1778595596:
                        if (stringExtra2.equals("TEXT_TYPE")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1833351709:
                        if (stringExtra2.equals("EMAIL_TYPE")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    String stringExtra3 = intent.getStringExtra("ENCODE_DATA");
                    if (stringExtra3 != null && !stringExtra3.isEmpty()) {
                        this.f40210a = stringExtra3;
                        this.f40211b = stringExtra3;
                        this.f40212c = this.f40214f.getString(R.string.contents_text);
                    }
                } else if (c2 == 1) {
                    String a2 = a.a(intent.getStringExtra("ENCODE_DATA"));
                    if (a2 != null) {
                        this.f40210a = "mailto:".concat(String.valueOf(a2));
                        this.f40211b = a2;
                        this.f40212c = this.f40214f.getString(R.string.contents_email);
                    }
                } else if (c2 == 2) {
                    String a3 = a.a(intent.getStringExtra("ENCODE_DATA"));
                    if (a3 != null) {
                        this.f40210a = "tel:".concat(String.valueOf(a3));
                        this.f40211b = PhoneNumberUtils.formatNumber(a3);
                        this.f40212c = this.f40214f.getString(R.string.contents_phone);
                    }
                } else if (c2 == 3) {
                    String a4 = a.a(intent.getStringExtra("ENCODE_DATA"));
                    if (a4 != null) {
                        this.f40210a = "sms:".concat(String.valueOf(a4));
                        this.f40211b = PhoneNumberUtils.formatNumber(a4);
                        this.f40212c = this.f40214f.getString(R.string.contents_sms);
                    }
                } else if (c2 == 4) {
                    Bundle bundleExtra2 = intent.getBundleExtra("ENCODE_DATA");
                    if (bundleExtra2 != null) {
                        String string = bundleExtra2.getString("name");
                        String string2 = bundleExtra2.getString("company");
                        String string3 = bundleExtra2.getString("postal");
                        List<String> a5 = a(bundleExtra2, com.google.zxing.client.android.d.f40189a);
                        List<String> a6 = a(bundleExtra2, com.google.zxing.client.android.d.f40190b);
                        List<String> a7 = a(bundleExtra2, com.google.zxing.client.android.d.f40191c);
                        String string4 = bundleExtra2.getString("URL_KEY");
                        if (string4 != null) {
                            list = Collections.singletonList(string4);
                        }
                        String[] a8 = (this.f40213d ? new e() : new c()).a((List<String>) Collections.singletonList(string), string2, (List<String>) Collections.singletonList(string3), a5, a6, a7, (List<String>) list, bundleExtra2.getString("NOTE_KEY"));
                        if (!a8[1].isEmpty()) {
                            this.f40210a = a8[0];
                            this.f40211b = a8[1];
                            this.f40212c = this.f40214f.getString(R.string.contents_contact);
                        }
                    }
                } else if (c2 == 5 && (bundleExtra = intent.getBundleExtra("ENCODE_DATA")) != null) {
                    float f2 = bundleExtra.getFloat("LAT", Float.MAX_VALUE);
                    float f3 = bundleExtra.getFloat("LONG", Float.MAX_VALUE);
                    if (!(f2 == Float.MAX_VALUE || f3 == Float.MAX_VALUE)) {
                        this.f40210a = "geo:" + f2 + ',' + f3;
                        this.f40211b = f2 + AppConstants.COMMA + f3;
                        this.f40212c = this.f40214f.getString(R.string.contents_location);
                    }
                }
            }
        }
        String stringExtra4 = intent.getStringExtra("ENCODE_DATA");
        if (stringExtra4 != null && !stringExtra4.isEmpty()) {
            this.f40210a = stringExtra4;
            this.f40211b = stringExtra4;
            this.f40212c = this.f40214f.getString(R.string.contents_text);
        }
        String str = this.f40210a;
        return str != null && !str.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6 A[SYNTHETIC, Splitter:B:49:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Intent r15) throws com.google.zxing.w {
        /*
            r14 = this;
            com.google.zxing.a r0 = com.google.zxing.a.QR_CODE
            r14.f40215g = r0
            android.os.Bundle r15 = r15.getExtras()
            if (r15 == 0) goto L_0x00f2
            java.lang.String r0 = "android.intent.extra.STREAM"
            android.os.Parcelable r15 = r15.getParcelable(r0)
            android.net.Uri r15 = (android.net.Uri) r15
            if (r15 == 0) goto L_0x00ea
            r0 = 0
            android.content.Context r1 = r14.f40214f     // Catch:{ IOException -> 0x00dd }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ IOException -> 0x00dd }
            java.io.InputStream r1 = r1.openInputStream(r15)     // Catch:{ IOException -> 0x00dd }
            if (r1 == 0) goto L_0x00ca
            java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            r15.<init>()     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
        L_0x002a:
            int r3 = r1.read(r2)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            r4 = 0
            if (r3 <= 0) goto L_0x0035
            r15.write(r2, r4, r3)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            goto L_0x002a
        L_0x0035:
            byte[] r15 = r15.toByteArray()     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            int r3 = r15.length     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r5 = "UTF-8"
            r2.<init>(r15, r4, r3, r5)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            com.google.zxing.r r1 = new com.google.zxing.r
            com.google.zxing.a r3 = com.google.zxing.a.QR_CODE
            r1.<init>(r2, r15, r0, r3)
            com.google.zxing.client.a.q r15 = com.google.zxing.client.a.u.c((com.google.zxing.r) r1)
            boolean r0 = r15 instanceof com.google.zxing.client.a.d
            if (r0 == 0) goto L_0x00bd
            com.google.zxing.client.a.d r15 = (com.google.zxing.client.a.d) r15
            boolean r0 = r14.f40213d
            if (r0 == 0) goto L_0x0063
            com.google.zxing.client.android.encode.e r0 = new com.google.zxing.client.android.encode.e
            r0.<init>()
            goto L_0x0068
        L_0x0063:
            com.google.zxing.client.android.encode.c r0 = new com.google.zxing.client.android.encode.c
            r0.<init>()
        L_0x0068:
            r5 = r0
            java.lang.String[] r0 = r15.f40031a
            java.util.List r6 = a((java.lang.String[]) r0)
            java.lang.String r7 = r15.l
            java.lang.String[] r0 = r15.j
            java.util.List r8 = a((java.lang.String[]) r0)
            java.lang.String[] r0 = r15.f40034d
            java.util.List r9 = a((java.lang.String[]) r0)
            r10 = 0
            java.lang.String[] r0 = r15.f40036f
            java.util.List r11 = a((java.lang.String[]) r0)
            java.lang.String[] r15 = r15.o
            java.util.List r12 = a((java.lang.String[]) r15)
            r13 = 0
            java.lang.String[] r15 = r5.a((java.util.List<java.lang.String>) r6, (java.lang.String) r7, (java.util.List<java.lang.String>) r8, (java.util.List<java.lang.String>) r9, (java.util.List<java.lang.String>) r10, (java.util.List<java.lang.String>) r11, (java.util.List<java.lang.String>) r12, (java.lang.String) r13)
            r0 = 1
            r1 = r15[r0]
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00aa
            r1 = r15[r4]
            r14.f40210a = r1
            r15 = r15[r0]
            r14.f40211b = r15
            android.content.Context r15 = r14.f40214f
            int r0 = com.google.zxing.client.android.R.string.contents_contact
            java.lang.String r15 = r15.getString(r0)
            r14.f40212c = r15
        L_0x00aa:
            java.lang.String r15 = r14.f40210a
            if (r15 == 0) goto L_0x00b5
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x00b5
            return
        L_0x00b5:
            com.google.zxing.w r15 = new com.google.zxing.w
            java.lang.String r0 = "No content to encode"
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x00bd:
            com.google.zxing.w r15 = new com.google.zxing.w
            java.lang.String r0 = "Result was not an address"
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x00c5:
            r15 = move-exception
            goto L_0x00e4
        L_0x00c7:
            r15 = move-exception
            r0 = r1
            goto L_0x00de
        L_0x00ca:
            com.google.zxing.w r0 = new com.google.zxing.w     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r2 = "Can't open stream for "
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r15 = r2.concat(r15)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            r0.<init>((java.lang.String) r15)     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
            throw r0     // Catch:{ IOException -> 0x00c7, all -> 0x00c5 }
        L_0x00da:
            r15 = move-exception
            r1 = r0
            goto L_0x00e4
        L_0x00dd:
            r15 = move-exception
        L_0x00de:
            com.google.zxing.w r1 = new com.google.zxing.w     // Catch:{ all -> 0x00da }
            r1.<init>((java.lang.Throwable) r15)     // Catch:{ all -> 0x00da }
            throw r1     // Catch:{ all -> 0x00da }
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            r1.close()     // Catch:{ IOException -> 0x00e9 }
        L_0x00e9:
            throw r15
        L_0x00ea:
            com.google.zxing.w r15 = new com.google.zxing.w
            java.lang.String r0 = "No EXTRA_STREAM"
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x00f2:
            com.google.zxing.w r15 = new com.google.zxing.w
            java.lang.String r0 = "No extras"
            r15.<init>((java.lang.String) r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.encode.d.b(android.content.Intent):void");
    }

    private static List<String> a(Bundle bundle, String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            Object obj = bundle.get(str2);
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private static List<String> a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    /* access modifiers changed from: package-private */
    public final Bitmap a() throws w {
        String str;
        EnumMap enumMap;
        String str2 = this.f40210a;
        if (str2 == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str2.length()) {
                str = null;
                break;
            } else if (str2.charAt(i2) > 255) {
                str = AppConstants.UTF_8;
                break;
            } else {
                i2++;
            }
        }
        if (str != null) {
            EnumMap enumMap2 = new EnumMap(g.class);
            enumMap2.put(g.CHARACTER_SET, str);
            enumMap = enumMap2;
        } else {
            enumMap = null;
        }
        try {
            b a2 = new l().a(str2, this.f40215g, this.f40216h, this.f40216h, enumMap);
            int i3 = a2.f39889a;
            int i4 = a2.f39890b;
            int[] iArr = new int[(i3 * i4)];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * i3;
                for (int i7 = 0; i7 < i3; i7++) {
                    iArr[i6 + i7] = a2.a(i7, i5) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
