package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.os.Bundle;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;

public class H5NavigationClassProvider implements PhoenixNavigationClassProvider {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01e7, code lost:
        r18 = "pm_upload";
     */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0389 A[Catch:{ ClassNotFoundException -> 0x05a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean navigateTo(android.app.Activity r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25) {
        /*
            r20 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "pinCode"
            java.lang.String r5 = "customer_name"
            java.lang.String r6 = "currentMetalPrice"
            java.lang.String r7 = "cta"
            r8 = 0
            if (r1 != 0) goto L_0x0012
            return r8
        L_0x0012:
            boolean r0 = r20.checkIfHandledByBank(r21, r22, r23, r24, r25)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9 = 1
            if (r0 == 0) goto L_0x001a
            return r9
        L_0x001a:
            boolean r0 = r20.checkIfHandledByKyc(r21, r22, r23, r24, r25)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0021
            return r9
        L_0x0021:
            r0 = -1
            int r10 = r22.hashCode()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r11 = "pm_upload"
            r12 = 2
            java.lang.String r13 = "ajrOrderIssue"
            switch(r10) {
                case -2110752736: goto L_0x01a8;
                case -2061487986: goto L_0x019d;
                case -2008762749: goto L_0x0194;
                case -1953745200: goto L_0x0189;
                case -1891893513: goto L_0x017f;
                case -1636525884: goto L_0x0174;
                case -1482722755: goto L_0x0169;
                case -1449401609: goto L_0x015e;
                case -1337282948: goto L_0x0153;
                case -1334939880: goto L_0x0148;
                case -984890862: goto L_0x013c;
                case -816877299: goto L_0x0131;
                case -793386370: goto L_0x0125;
                case -786681338: goto L_0x0119;
                case -731041269: goto L_0x010d;
                case -567028024: goto L_0x0101;
                case -502770291: goto L_0x00f6;
                case -467819670: goto L_0x00ea;
                case -371813004: goto L_0x00de;
                case -309675391: goto L_0x00d3;
                case -286873378: goto L_0x00c7;
                case 106776441: goto L_0x00bb;
                case 275235080: goto L_0x00b0;
                case 456602111: goto L_0x00a5;
                case 596408584: goto L_0x0099;
                case 626327979: goto L_0x008d;
                case 687330211: goto L_0x0080;
                case 710458298: goto L_0x0074;
                case 834080063: goto L_0x0068;
                case 1135742238: goto L_0x005c;
                case 1657675760: goto L_0x0050;
                case 1757258715: goto L_0x0045;
                case 1835901522: goto L_0x0039;
                case 2143090804: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x01b2
        L_0x0030:
            boolean r10 = r2.equals(r13)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 1
            goto L_0x01b2
        L_0x0039:
            java.lang.String r10 = "eventsPdpPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 9
            goto L_0x01b2
        L_0x0045:
            java.lang.String r10 = "eduformPaymentPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 4
            goto L_0x01b2
        L_0x0050:
            java.lang.String r10 = "insOpenOrderSummary"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 19
            goto L_0x01b2
        L_0x005c:
            java.lang.String r10 = "getImageEvents"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 33
            goto L_0x01b2
        L_0x0068:
            java.lang.String r10 = "insSessionExpiryEvent"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 25
            goto L_0x01b2
        L_0x0074:
            java.lang.String r10 = "eventsSvgPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 11
            goto L_0x01b2
        L_0x0080:
            java.lang.String r10 = "updateOauthCreditCardFlag"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 29
            goto L_0x01b2
        L_0x008d:
            java.lang.String r10 = "eventsPsPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 10
            goto L_0x01b2
        L_0x0099:
            java.lang.String r10 = "paytmFirstLanding"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 27
            goto L_0x01b2
        L_0x00a5:
            java.lang.String r10 = "firstCardBillPayment"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 2
            goto L_0x01b2
        L_0x00b0:
            java.lang.String r10 = "fasTagPGPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 7
            goto L_0x01b2
        L_0x00bb:
            java.lang.String r10 = "pm_pg"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 15
            goto L_0x01b2
        L_0x00c7:
            java.lang.String r10 = "paytmPickContact"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 14
            goto L_0x01b2
        L_0x00d3:
            java.lang.String r10 = "ctaDetail"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 0
            goto L_0x01b2
        L_0x00de:
            java.lang.String r10 = "fasTagDealsPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 8
            goto L_0x01b2
        L_0x00ea:
            java.lang.String r10 = "insShowErrorToast"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 22
            goto L_0x01b2
        L_0x00f6:
            java.lang.String r10 = "goldPaymentGatewayPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 5
            goto L_0x01b2
        L_0x0101:
            java.lang.String r10 = "paytmLogin"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 12
            goto L_0x01b2
        L_0x010d:
            java.lang.String r10 = "insProceedToPayment"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 24
            goto L_0x01b2
        L_0x0119:
            java.lang.String r10 = "payment"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 31
            goto L_0x01b2
        L_0x0125:
            java.lang.String r10 = "insOpenDeepLink"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 26
            goto L_0x01b2
        L_0x0131:
            java.lang.String r10 = "paymentGatewayPage"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 6
            goto L_0x01b2
        L_0x013c:
            java.lang.String r10 = "pm_web"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 16
            goto L_0x01b2
        L_0x0148:
            java.lang.String r10 = "insOpenCSTScreen"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 20
            goto L_0x01b2
        L_0x0153:
            java.lang.String r10 = "insDownloadPDF"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 23
            goto L_0x01b2
        L_0x015e:
            java.lang.String r10 = "insOpenUrl"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 21
            goto L_0x01b2
        L_0x0169:
            java.lang.String r10 = "offlineaadharkyc"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 32
            goto L_0x01b2
        L_0x0174:
            java.lang.String r10 = "nearbuyCheckout"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 30
            goto L_0x01b2
        L_0x017f:
            java.lang.String r10 = "firstCardNeedHelp"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 3
            goto L_0x01b2
        L_0x0189:
            java.lang.String r10 = "openGoldDeeplink"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 13
            goto L_0x01b2
        L_0x0194:
            boolean r10 = r2.equals(r11)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 17
            goto L_0x01b2
        L_0x019d:
            java.lang.String r10 = "insOnBackPressed"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 18
            goto L_0x01b2
        L_0x01a8:
            java.lang.String r10 = "saveAndOpenFile"
            boolean r10 = r2.equals(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r10 == 0) goto L_0x01b2
            r0 = 28
        L_0x01b2:
            java.lang.String r10 = "response"
            java.lang.String r14 = "action"
            java.lang.String r15 = "data"
            java.lang.String r8 = "paytmNavigateTo"
            switch(r0) {
                case 0: goto L_0x0354;
                case 1: goto L_0x0351;
                case 2: goto L_0x0343;
                case 3: goto L_0x0339;
                case 4: goto L_0x0332;
                case 5: goto L_0x032b;
                case 6: goto L_0x0319;
                case 7: goto L_0x0312;
                case 8: goto L_0x030b;
                case 9: goto L_0x0302;
                case 10: goto L_0x02f8;
                case 11: goto L_0x02ee;
                case 12: goto L_0x02e5;
                case 13: goto L_0x02d9;
                case 14: goto L_0x02bb;
                case 15: goto L_0x02b1;
                case 16: goto L_0x02a7;
                case 17: goto L_0x029d;
                case 18: goto L_0x0298;
                case 19: goto L_0x0291;
                case 20: goto L_0x0291;
                case 21: goto L_0x0291;
                case 22: goto L_0x0291;
                case 23: goto L_0x0291;
                case 24: goto L_0x0291;
                case 25: goto L_0x028b;
                case 26: goto L_0x0277;
                case 27: goto L_0x0235;
                case 28: goto L_0x01ef;
                case 29: goto L_0x01eb;
                case 30: goto L_0x01e1;
                case 31: goto L_0x01da;
                case 32: goto L_0x01d3;
                case 33: goto L_0x01c0;
                default: goto L_0x01bd;
            }
        L_0x01bd:
            r1 = 0
            goto L_0x05a4
        L_0x01c0:
            if (r1 == 0) goto L_0x01bd
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x01bd
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            android.content.Intent r1 = net.one97.paytm.dynamic.module.fastag.helper.FastagImageCropHelper.getCropImageIntent(r21)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2 = 1230(0x4ce, float:1.724E-42)
            r0.a(r1, r2, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r9
        L_0x01d3:
            java.lang.String r0 = "com.karza.aadhaarsdk.AadharActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x01e7
        L_0x01da:
            java.lang.String r0 = "net.one97.paytm.finance.FinancePaymentHelperActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x01e7
        L_0x01e1:
            java.lang.String r0 = "net.one97.paytm.nearbuy_h5.AJRNearbuyCheckoutActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x01e7:
            r18 = r11
            goto L_0x037f
        L_0x01eb:
            com.paytm.utility.b.x((android.content.Context) r21)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r9
        L_0x01ef:
            boolean r0 = r3.containsKey(r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0232
            java.lang.String r0 = "net.one97.paytm.CSTH5FileUtil"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0227 }
            java.lang.String r9 = "saveFileToStorage"
            r18 = r11
            java.lang.Class[] r11 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x0225 }
            java.lang.Class<java.lang.String> r19 = java.lang.String.class
            r16 = 0
            r11[r16] = r19     // Catch:{ Exception -> 0x0225 }
            java.lang.Class<android.app.Activity> r19 = android.app.Activity.class
            r17 = 1
            r11[r17] = r19     // Catch:{ Exception -> 0x0225 }
            java.lang.reflect.Method r9 = r0.getDeclaredMethod(r9, r11)     // Catch:{ Exception -> 0x0225 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0225 }
            java.lang.Object[] r11 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0225 }
            java.lang.String r10 = r3.getString(r10)     // Catch:{ Exception -> 0x0225 }
            r12 = 0
            r11[r12] = r10     // Catch:{ Exception -> 0x0225 }
            r10 = 1
            r11[r10] = r1     // Catch:{ Exception -> 0x0225 }
            r9.invoke(r0, r11)     // Catch:{ Exception -> 0x0225 }
            goto L_0x0274
        L_0x0225:
            r0 = move-exception
            goto L_0x022a
        L_0x0227:
            r0 = move-exception
            r18 = r11
        L_0x022a:
            java.lang.String r0 = r0.getMessage()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            com.paytm.utility.q.b(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x0274
        L_0x0232:
            r18 = r11
            goto L_0x0274
        L_0x0235:
            r18 = r11
            java.lang.String r0 = r3.getString(r14)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r3.putString(r14, r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r9 = "openOrderSummary"
            boolean r9 = r9.equalsIgnoreCase(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r9 == 0) goto L_0x024e
            java.lang.String r0 = "net.one97.paytm.prime.activity.PrimeLoaderActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x024e:
            java.lang.String r9 = "processTransaction"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0274
            java.lang.String r0 = "net.one97.paytm.prime.activity.PrimeLoaderActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r1 == 0) goto L_0x037f
            boolean r9 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r9 == 0) goto L_0x037f
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2.putExtras(r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 3001(0xbb9, float:4.205E-42)
            r0.a(r2, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x0274:
            r0 = 0
            goto L_0x037f
        L_0x0277:
            java.lang.String r0 = "is_internal_flow"
            r2 = 1
            r3.putBoolean(r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "url"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r0, r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r0
        L_0x028b:
            r2 = 0
            net.one97.paytm.auth.b.b.a(r1, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r4 = 1
            return r4
        L_0x0291:
            r4 = 1
            net.one97.paytm.h5.a r0 = net.one97.paytm.h5.a.f50535a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.h5.a.a(r1, r3, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r4
        L_0x0298:
            r4 = 1
            r21.finish()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r4
        L_0x029d:
            r18 = r11
            java.lang.String r0 = "com.paytmmoney.lite.mod.MoneyUploadActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x02a7:
            r18 = r11
            java.lang.String r0 = "com.paytmmoney.lite.mod.GenericWebView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x02b1:
            r18 = r11
            java.lang.String r0 = "com.paytmmoney.lite.mod.PaymentWebview"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x02bb:
            if (r1 == 0) goto L_0x02d7
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x02d7
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r2 = "android.intent.action.PICK"
            android.net.Uri r3 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r0.<init>(r2, r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r2 = "vnd.android.cursor.dir/phone_v2"
            r0.setType(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2 = 1224(0x4c8, float:1.715E-42)
            r1.a(r0, r2, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x02d7:
            r1 = 1
            return r1
        L_0x02d9:
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = r3.getString(r15)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2 = 0
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r0
        L_0x02e5:
            r18 = r11
            net.one97.paytm.auth.b.b.a(r1, r9)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r0 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            goto L_0x037f
        L_0x02ee:
            r18 = r11
            java.lang.String r0 = "net.one97.paytm.o2o.events.weex.activity.AJRWeexEventSVGActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x02f8:
            r18 = r11
            java.lang.String r0 = "net.one97.paytm.o2o.events.weex.activity.AJRWeexEventPackagelActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x0302:
            r18 = r11
            java.lang.String r0 = "net.one97.paytm.o2o.events.weex.activity.WXAJREventDetailActivity"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x037f
        L_0x030b:
            net.one97.paytm.recharge.c$a r0 = net.one97.paytm.recharge.c.f60405a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.recharge.c.a.b(r1, r3, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r4 = 1
            return r4
        L_0x0312:
            r4 = 1
            net.one97.paytm.recharge.c$a r0 = net.one97.paytm.recharge.c.f60405a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.recharge.c.a.a(r1, r3, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r4
        L_0x0319:
            java.lang.String r0 = r3.getString(r15)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r2 = "totalPrice"
            java.lang.String r2 = r3.getString(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.h5.b r3 = net.one97.paytm.h5.b.f50536a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.h5.b.a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x032b:
            net.one97.paytm.h5.b r0 = net.one97.paytm.h5.b.f50536a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.h5.b.a(r1, r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r4 = 1
            return r4
        L_0x0332:
            r4 = 1
            net.one97.paytm.recharge.c$a r0 = net.one97.paytm.recharge.c.f60405a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            net.one97.paytm.recharge.c.a.b(r1, r3, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r4
        L_0x0339:
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "paytmmp://csttree?featuretype=cst_issue&verticalid=750001"
            r2 = 0
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r0
        L_0x0343:
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "deeplink"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r2 = 0
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            return r0
        L_0x0351:
            r18 = r11
            goto L_0x0379
        L_0x0354:
            r18 = r11
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0371 }
            java.lang.String r9 = r3.getString(r10)     // Catch:{ JSONException -> 0x0371 }
            r0.<init>(r9)     // Catch:{ JSONException -> 0x0371 }
            net.one97.paytm.deeplink.h$a r9 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ JSONException -> 0x0371 }
            java.lang.String r9 = "deeplink"
            java.lang.Object r0 = r0.get(r9)     // Catch:{ JSONException -> 0x0371 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0371 }
            r9 = 0
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r0, r9)     // Catch:{ JSONException -> 0x0371 }
            return r0
        L_0x0371:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            com.paytm.utility.q.b(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0379:
            java.lang.String r0 = "net.one97.paytm.cst.activity.AJRCSTOrderIssues"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x037f:
            java.lang.String r9 = "userFeedback"
            r10 = 0
            boolean r9 = r3.getBoolean(r9, r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r9 != 0) goto L_0x05a2
            java.lang.String r9 = r3.getString(r7)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r9 == 0) goto L_0x039e
            java.lang.String r9 = r3.getString(r7)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            boolean r9 = r9.equalsIgnoreCase(r13)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r9 == 0) goto L_0x039e
            r21.finish()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x0595
        L_0x039e:
            android.content.Intent r9 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtras(r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.Object r0 = r3.get(r6)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x03b7
            java.lang.Object r0 = r3.get(r6)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = r0.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x03b8
        L_0x03b7:
            r0 = r10
        L_0x03b8:
            java.lang.Object r11 = r3.get(r5)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r11 == 0) goto L_0x03c7
            java.lang.Object r11 = r3.get(r5)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r11 = r11.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x03c8
        L_0x03c7:
            r11 = r10
        L_0x03c8:
            java.lang.Object r12 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r12 == 0) goto L_0x03d6
            java.lang.Object r10 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r10 = r10.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x03d6:
            r9.putExtra(r6, r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r4, r10)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r5, r11)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "cstorderItem"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x03f6
            java.lang.String r0 = "cstorderItemData"
            java.lang.String r4 = "cstorderItem"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r4 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x03f6:
            java.lang.String r0 = "ctaNode"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x040d
            java.lang.String r0 = "ctaNodeData"
            java.lang.String r4 = "ctaNode"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r4 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x040d:
            java.lang.String r0 = "cjrOrderQueryReason"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0424
            java.lang.String r0 = "cjrOrderQueryReasonData"
            java.lang.String r4 = "cjrOrderQueryReason"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r4 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0424:
            java.lang.String r0 = "parentIssueList"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x043b
            java.lang.String r0 = "parentIssueListData"
            java.lang.String r4 = "parentIssueList"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r4 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x043b:
            if (r24 == 0) goto L_0x0449
            boolean r0 = r2.equalsIgnoreCase(r13)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 != 0) goto L_0x0449
            r0 = 268468224(0x10008000, float:2.5342157E-29)
            r9.addFlags(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0449:
            java.lang.String r0 = "paytmFirstLanding"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0457
            java.lang.String r0 = net.one97.paytm.prime.f.b.f59789a     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r4 = 1
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0457:
            java.lang.String r0 = "primeBuyPlan"
            java.lang.String r4 = r3.getString(r14)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0468
            r0 = 603979776(0x24000000, float:2.7755576E-17)
            r9.setFlags(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0468:
            java.lang.String r0 = "isH5Enable"
            r4 = 1
            r9.putExtra(r0, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "paytmLogin"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0486
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1221(0x4c5, float:1.711E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x0486:
            java.lang.String r0 = "selectAndUploadFile"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x049e
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1222(0x4c6, float:1.712E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x049e:
            java.lang.String r0 = "cstWidgetLanding"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x04b6
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1223(0x4c7, float:1.714E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x04b6:
            java.lang.String r0 = "eduMerchantCheckout"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x04ce
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1226(0x4ca, float:1.718E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x04ce:
            java.lang.String r0 = "eduformPaymentPage"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x04e6
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1227(0x4cb, float:1.72E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x04e6:
            java.lang.String r0 = "payment"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x04fe
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1228(0x4cc, float:1.721E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x04fe:
            java.lang.String r0 = "offlineaadharkyc"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0534
            java.lang.String r0 = "token"
            boolean r0 = r3.containsKey(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0532
            if (r1 == 0) goto L_0x0532
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0532
            java.lang.String r0 = "KARZA-TOKEN"
            java.lang.String r2 = "token"
            java.lang.String r2 = r3.getString(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r0 = "CLIENT"
            java.lang.String r2 = "paytm"
            r9.putExtra(r0, r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1229(0x4cd, float:1.722E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x0532:
            r1 = 0
            return r1
        L_0x0534:
            java.lang.String r0 = "pm_pg"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x054c
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1010(0x3f2, float:1.415E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x054c:
            r4 = r18
            boolean r0 = r4.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0564
            if (r1 == 0) goto L_0x0580
            boolean r0 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0580
            r0 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1014(0x3f6, float:1.421E-42)
            r0.a(r9, r1, r8)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1 = 1
            return r1
        L_0x0564:
            java.lang.String r0 = "nearbuyCheckout"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x057d
            java.lang.String r0 = "requestBody"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r9.putExtra(r15, r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r1.startActivity(r9)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            r4 = 0
            r1.overridePendingTransition(r4, r4)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            goto L_0x0580
        L_0x057d:
            r1.startActivity(r9)     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0580:
            java.lang.String r0 = r3.getString(r7)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0595
            java.lang.String r0 = r3.getString(r7)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            java.lang.String r3 = "go to order history"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 == 0) goto L_0x0595
            r21.finish()     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x0595:
            if (r25 == 0) goto L_0x05a2
            java.lang.String r0 = "cstWidgetLanding"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ ClassNotFoundException -> 0x05a5 }
            if (r0 != 0) goto L_0x05a2
            r21.finish()     // Catch:{ ClassNotFoundException -> 0x05a5 }
        L_0x05a2:
            r1 = 0
            goto L_0x05ae
        L_0x05a4:
            return r1
        L_0x05a5:
            r0 = move-exception
            r1 = 0
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x05ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.H5NavigationClassProvider.navigateTo(android.app.Activity, java.lang.String, android.os.Bundle, boolean, boolean):boolean");
    }

    public boolean checkIfHandledByBank(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.payments.c.b.b");
            Object obj = cls.getField("INSTANCE").get(cls);
            return ((Boolean) obj.getClass().getDeclaredMethods()[0].invoke(obj, new Object[]{activity, str, bundle, Boolean.valueOf(z), Boolean.valueOf(z2)})).booleanValue();
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return false;
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
            return false;
        } catch (InvocationTargetException e4) {
            q.b(e4.getMessage());
            return false;
        } catch (NoSuchFieldException e5) {
            q.b(e5.getMessage());
            return false;
        }
    }

    public boolean checkIfHandledByKyc(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.kych5.a.b");
            Object obj = cls.getField("INSTANCE").get(cls);
            return ((Boolean) obj.getClass().getDeclaredMethods()[0].invoke(obj, new Object[]{activity, str, bundle, Boolean.valueOf(z), Boolean.valueOf(z2)})).booleanValue();
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return false;
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
            return false;
        } catch (InvocationTargetException e4) {
            q.b(e4.getMessage());
            return false;
        } catch (NoSuchFieldException e5) {
            q.b(e5.getMessage());
            return false;
        }
    }
}
