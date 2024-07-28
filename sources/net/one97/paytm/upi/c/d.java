package net.one97.paytm.upi.c;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.wifi.models.WifiConstantsKt;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f66618a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final String f66619b = "BharatQrHelper";

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ef A[EDGE_INSN: B:101:0x02ef->B:96:0x02ef ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02df A[LOOP:0: B:3:0x002a->B:94:0x02df, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.upi.c.c a(java.lang.String r38) throws java.lang.Exception {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r38)
            if (r0 != 0) goto L_0x0347
            java.lang.String r0 = ""
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r13 = r9
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r24 = r22
            r10 = 0
            r11 = 0
            r12 = 0
            r23 = 0
            r0 = r38
        L_0x002a:
            boolean r25 = android.text.TextUtils.isEmpty(r0)
            if (r25 != 0) goto L_0x02e7
            r1 = 2
            r38 = r2
            r2 = 0
            r26 = r3
            java.lang.String r3 = r0.substring(r2, r1)
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r27 = r0.substring(r2, r1)
            r28 = r4
            int r4 = java.lang.Integer.parseInt(r27)
            java.lang.String r1 = r0.substring(r1)
            r27 = r5
            java.lang.String r5 = r1.substring(r2, r4)
            java.lang.String r0 = "00"
            boolean r0 = r0.equals(r3)
            java.lang.String r2 = "BharatQrHelper"
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "version = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r5
        L_0x006a:
            r3 = r26
        L_0x006c:
            r5 = r27
            goto L_0x02d9
        L_0x0070:
            java.lang.String r0 = "01"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "initiationMethod = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r3 = r5
            goto L_0x006c
        L_0x0089:
            java.lang.String r0 = "02"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x02c6
            java.lang.String r0 = "03"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x009b
            goto L_0x02c6
        L_0x009b:
            java.lang.String r0 = "04"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x02b4
            java.lang.String r0 = "05"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00ad
            goto L_0x02b4
        L_0x00ad:
            java.lang.String r0 = "06"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x02a2
            java.lang.String r0 = "07"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            goto L_0x02a2
        L_0x00bf:
            java.lang.String r0 = "08"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00f1
            r0 = 11
            r3 = 0
            java.lang.String r3 = r5.substring(r3, r0)
            java.lang.String r0 = r5.substring(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "merchantBankIfsc = "
            r5.<init>(r8)
            r5.append(r3)
            java.lang.String r8 = " merchantAccountNumber = "
            r5.append(r8)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r5)
            r2 = r38
            r9 = r0
            r8 = r3
            goto L_0x006a
        L_0x00f1:
            java.lang.String r0 = "11"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0290
            java.lang.String r0 = "12"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0103
            goto L_0x0290
        L_0x0103:
            java.lang.String r0 = "26"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0114
            net.one97.paytm.upi.c.e r0 = b(r5)
            r2 = r38
            r10 = r0
            goto L_0x006a
        L_0x0114:
            java.lang.String r0 = "27"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0125
            net.one97.paytm.upi.c.f r0 = c(r5)
            r2 = r38
            r11 = r0
            goto L_0x006a
        L_0x0125:
            java.lang.String r0 = "28"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0136
            net.one97.paytm.upi.c.a r0 = d(r5)
            r2 = r38
            r12 = r0
            goto L_0x006a
        L_0x0136:
            java.lang.String r0 = "52"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0150
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "merchantCategoryCode = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r13 = r5
            goto L_0x006a
        L_0x0150:
            java.lang.String r0 = "53"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x016a
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "currencyCode = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r14 = r5
            goto L_0x006a
        L_0x016a:
            java.lang.String r0 = "54"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01a6
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0194
            java.lang.String r0 = "null"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0181
            goto L_0x0194
        L_0x0181:
            double r29 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException -> 0x018f }
            java.lang.Double r0 = java.lang.Double.valueOf(r29)     // Catch:{ NumberFormatException -> 0x018f }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x018f }
            r15 = r0
            goto L_0x0195
        L_0x018f:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0195
        L_0x0194:
            r15 = 0
        L_0x0195:
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "amount = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
        L_0x01a2:
            r2 = r38
            goto L_0x006a
        L_0x01a6:
            java.lang.String r0 = "55"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01c1
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "convenienceIndicator = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r16 = r5
            goto L_0x006a
        L_0x01c1:
            java.lang.String r0 = "56"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01dc
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "convenienceFee = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r17 = r5
            goto L_0x006a
        L_0x01dc:
            java.lang.String r0 = "57"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01f7
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "convenienceFeePercentage = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r18 = r5
            goto L_0x006a
        L_0x01f7:
            java.lang.String r0 = "58"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0212
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "countryCode = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r19 = r5
            goto L_0x006a
        L_0x0212:
            java.lang.String r0 = "59"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x022d
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "merchantName = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r20 = r5
            goto L_0x006a
        L_0x022d:
            java.lang.String r0 = "60"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0248
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "merchantCity = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r21 = r5
            goto L_0x006a
        L_0x0248:
            java.lang.String r0 = "61"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0263
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "postalCode = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r22 = r5
            goto L_0x006a
        L_0x0263:
            java.lang.String r0 = "62"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0275
            net.one97.paytm.upi.c.b r0 = e(r5)
            r2 = r38
            r23 = r0
            goto L_0x006a
        L_0x0275:
            java.lang.String r0 = "63"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "crc = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r24 = r5
            goto L_0x006a
        L_0x0290:
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "amexMerchantId = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r7 = r5
            goto L_0x006a
        L_0x02a2:
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "npciMerchantId = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r6 = r5
            goto L_0x006a
        L_0x02b4:
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "mastercardMerchantId = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r3 = r26
            goto L_0x02d9
        L_0x02c6:
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "visaMerchantId = "
            java.lang.String r0 = r3.concat(r0)
            net.one97.paytm.upi.common.PaytmLogs.i(r2, r0)
            r2 = r38
            r28 = r5
            goto L_0x006a
        L_0x02d9:
            int r0 = r1.length()
            if (r0 <= r4) goto L_0x02ef
            java.lang.String r0 = r1.substring(r4)
            r4 = r28
            goto L_0x002a
        L_0x02e7:
            r38 = r2
            r26 = r3
            r28 = r4
            r27 = r5
        L_0x02ef:
            r1 = r16
            r16 = r17
            r31 = r18
            r32 = r19
            r33 = r20
            r34 = r21
            r35 = r22
            r36 = r23
            r37 = r24
            r0 = r28
            net.one97.paytm.upi.c.c r4 = new net.one97.paytm.upi.c.c
            r4.<init>()
            r4.f66609a = r2
            r4.f66610b = r3
            r4.f66611c = r0
            r4.f66612d = r5
            r4.f66613e = r6
            r4.f66614f = r7
            r4.f66615g = r8
            r4.f66616h = r9
            r4.f66617i = r10
            r4.j = r11
            r4.k = r12
            r4.l = r13
            r4.m = r14
            r4.n = r15
            r4.o = r1
            r0 = r16
            r4.p = r0
            r0 = r31
            r4.q = r0
            r0 = r32
            r4.r = r0
            r0 = r33
            r4.s = r0
            r0 = r34
            r4.t = r0
            r0 = r35
            r4.u = r0
            r0 = r36
            r4.v = r0
            r0 = r37
            r4.w = r0
            return r4
        L_0x0347:
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.c.d.a(java.lang.String):net.one97.paytm.upi.c.c");
    }

    private static e b(String str) throws Exception {
        e eVar = new e();
        while (!TextUtils.isEmpty(str)) {
            String substring = str.substring(0, 2);
            String substring2 = str.substring(2);
            int parseInt = Integer.parseInt(substring2.substring(0, 2));
            String substring3 = substring2.substring(2);
            String substring4 = substring3.substring(0, parseInt);
            if ("00".equals(substring)) {
                eVar.f66624a = substring4;
                PaytmLogs.i("BharatQrHelper", "UpiRupayId = ".concat(String.valueOf(substring4)));
            } else if (WebLogin.RESPONSE_CODE_SUCCESS.equals(substring)) {
                eVar.f66625b = substring4;
                PaytmLogs.i("BharatQrHelper", "UpiAddress = ".concat(String.valueOf(substring4)));
            } else if ("02".equals(substring)) {
                if (TextUtils.isEmpty(substring4) || substring4.equalsIgnoreCase("null")) {
                    eVar.f66626c = null;
                } else {
                    eVar.f66626c = substring4;
                }
                PaytmLogs.i("BharatQrHelper", "UpiMinimumAmount = ".concat(String.valueOf(substring4)));
            }
            if (substring3.length() <= parseInt) {
                break;
            }
            str = substring3.substring(parseInt);
        }
        return eVar;
    }

    private static f c(String str) throws Exception {
        f fVar = new f();
        while (!TextUtils.isEmpty(str)) {
            String substring = str.substring(0, 2);
            String substring2 = str.substring(2);
            int parseInt = Integer.parseInt(substring2.substring(0, 2));
            String substring3 = substring2.substring(2);
            String substring4 = substring3.substring(0, parseInt);
            if ("00".equals(substring)) {
                fVar.f66627a = substring4;
                PaytmLogs.i("BharatQrHelper", "UpiReferenceRupayId = ".concat(String.valueOf(substring4)));
            } else if (WebLogin.RESPONSE_CODE_SUCCESS.equals(substring)) {
                fVar.f66628b = substring4;
                PaytmLogs.i("BharatQrHelper", "TransactionReference = ".concat(String.valueOf(substring4)));
            } else if ("02".equals(substring)) {
                fVar.f66629c = substring4;
                PaytmLogs.i("BharatQrHelper", "UrlReference = ".concat(String.valueOf(substring4)));
            }
            if (substring3.length() <= parseInt) {
                break;
            }
            str = substring3.substring(parseInt);
        }
        return fVar;
    }

    private static a d(String str) throws Exception {
        a aVar = new a();
        while (!TextUtils.isEmpty(str)) {
            String substring = str.substring(0, 2);
            String substring2 = str.substring(2);
            int parseInt = Integer.parseInt(substring2.substring(0, 2));
            String substring3 = substring2.substring(2);
            String substring4 = substring3.substring(0, parseInt);
            if ("00".equals(substring)) {
                aVar.f66599a = substring4;
                PaytmLogs.i("BharatQrHelper", "AadhaarRupayId = ".concat(String.valueOf(substring4)));
            } else if (WebLogin.RESPONSE_CODE_SUCCESS.equals(substring)) {
                aVar.f66600b = substring4;
                PaytmLogs.i("BharatQrHelper", "AadhaarNumber = ".concat(String.valueOf(substring4)));
            }
            if (substring3.length() <= parseInt) {
                break;
            }
            str = substring3.substring(parseInt);
        }
        return aVar;
    }

    private static b e(String str) throws Exception {
        b bVar = new b();
        while (!TextUtils.isEmpty(str)) {
            String substring = str.substring(0, 2);
            String substring2 = str.substring(2);
            int parseInt = Integer.parseInt(substring2.substring(0, 2));
            String substring3 = substring2.substring(2);
            String substring4 = substring3.substring(0, parseInt);
            if (WebLogin.RESPONSE_CODE_SUCCESS.equals(substring)) {
                bVar.f66601a = substring4;
                PaytmLogs.i("BharatQrHelper", "BillNumber = ".concat(String.valueOf(substring4)));
            } else if ("02".equals(substring)) {
                bVar.f66602b = substring4;
                PaytmLogs.i("BharatQrHelper", "MobileNumber = ".concat(String.valueOf(substring4)));
            } else if ("03".equals(substring)) {
                bVar.f66603c = substring4;
                PaytmLogs.i("BharatQrHelper", "StoreId = ".concat(String.valueOf(substring4)));
            } else if ("04".equals(substring)) {
                bVar.f66604d = substring4;
                PaytmLogs.i("BharatQrHelper", "LoyaltyNumber = ".concat(String.valueOf(substring4)));
            } else if ("05".equals(substring)) {
                bVar.f66605e = substring4;
                PaytmLogs.i("BharatQrHelper", "ReferenceId = ".concat(String.valueOf(substring4)));
            } else if ("06".equals(substring)) {
                bVar.f66606f = substring4;
                PaytmLogs.i("BharatQrHelper", "ConsumerId = ".concat(String.valueOf(substring4)));
            } else if ("07".equals(substring)) {
                bVar.f66607g = substring4;
                PaytmLogs.i("BharatQrHelper", "TerminalId = ".concat(String.valueOf(substring4)));
            } else if ("08".equals(substring)) {
                if (substring4.contains(WifiConstantsKt.SSID_EMPTY)) {
                    bVar.f66608h = null;
                } else {
                    bVar.f66608h = substring4;
                }
                PaytmLogs.i("BharatQrHelper", "Purpose = ".concat(String.valueOf(substring4)));
            }
            if (substring3.length() <= parseInt) {
                break;
            }
            str = substring3.substring(parseInt);
        }
        return bVar;
    }

    public final void a(final Context context, String str, String str2) {
        final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
        customWalletAlertDialog.setTitle(str);
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setButton(-1, Payload.RESPONSE_OK, new View.OnClickListener() {
            public final void onClick(View view) {
                customWalletAlertDialog.cancel();
            }
        });
        customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                i.a().m.a(context);
            }
        });
        customWalletAlertDialog.show();
    }
}
