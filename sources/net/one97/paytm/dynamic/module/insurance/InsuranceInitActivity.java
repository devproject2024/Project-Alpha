package net.one97.paytm.dynamic.module.insurance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.insurance.b.d;
import net.one97.paytm.upi.util.UpiConstants;

public class InsuranceInitActivity extends AppCompatActivity {
    DeepLinkData deepLinkData;
    private HashMap<String, Object> initParams;
    String insFormH5URL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InsuranceImplProvider.init();
        new InsuranceH5Manager().init(getApplication());
        checkForDeepLinkIntent(getIntent(), this);
        finish();
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkForDeepLinkIntent(android.content.Intent r17, android.content.Context r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            f.a.a r3 = f.a.a.f13515a
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            f.a.a.a((java.lang.Boolean) r3)
            r3 = 0
            if (r0 == 0) goto L_0x001c
            java.lang.String r4 = "EXTRA_POST_PAYMENT_FLAG"
            boolean r4 = r0.getBooleanExtra(r4, r3)
            if (r4 == 0) goto L_0x001c
            r1.openOrderSummaryActivity(r2, r0)
            return
        L_0x001c:
            java.lang.String r4 = "EXTRA_DEEP_LINK_BUNDLE"
            android.os.Bundle r4 = r0.getBundleExtra(r4)
            java.lang.String r5 = "isFromH5"
            if (r4 == 0) goto L_0x0031
            java.lang.String r6 = "is_internal_flow"
            boolean r6 = r4.getBoolean(r6, r3)
            boolean r7 = r4.getBoolean(r5, r3)
            goto L_0x0038
        L_0x0031:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r6 = 0
            r7 = 0
        L_0x0038:
            r8 = 1
            if (r7 == 0) goto L_0x006d
            if (r6 != 0) goto L_0x006d
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.insurance.fourWheeler.utils.H5toInsuranceCommunicator> r2 = net.one97.paytm.insurance.fourWheeler.utils.H5toInsuranceCommunicator.class
            r0.<init>(r1, r2)
            r0.putExtra(r5, r8)
            java.lang.String r2 = "data"
            r0.putExtra(r2, r4)
            java.lang.String r2 = "target"
            java.lang.String r5 = r4.getString(r2)
            if (r5 == 0) goto L_0x0066
            java.lang.String r2 = r4.getString(r2)
            java.lang.String r4 = "insOpenCSTScreen"
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x0066
            java.lang.Class<net.one97.paytm.insurance.H5.InsuranceTransparentActivity> r2 = net.one97.paytm.insurance.H5.InsuranceTransparentActivity.class
            r0.setClass(r1, r2)
        L_0x0066:
            r1.startActivity(r0)
            r1.overridePendingTransition(r3, r3)
            return
        L_0x006d:
            if (r6 != 0) goto L_0x0080
            f.a.a r5 = f.a.a.f13515a
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            f.a.a.a((java.lang.Boolean) r5)
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r5 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r2, r5)
            r2.startActivity(r6)
        L_0x0080:
            java.lang.String r5 = "EXTRA_DEEP_LINK_DATA"
            android.os.Parcelable r6 = r0.getParcelableExtra(r5)
            net.one97.paytm.deeplink.DeepLinkData r6 = (net.one97.paytm.deeplink.DeepLinkData) r6
            if (r6 == 0) goto L_0x0651
            java.lang.String r7 = r6.f50284b
            r9 = -1
            int r10 = r7.hashCode()
            r12 = 14
            switch(r10) {
                case -1960656577: goto L_0x01b5;
                case -1957904636: goto L_0x01aa;
                case -1905437915: goto L_0x019f;
                case -1731647246: goto L_0x0194;
                case -1646056628: goto L_0x018a;
                case -1615128392: goto L_0x0180;
                case -1312451303: goto L_0x0176;
                case -951921574: goto L_0x016b;
                case -740215129: goto L_0x0160;
                case -297095233: goto L_0x0156;
                case 29304850: goto L_0x014a;
                case 31404711: goto L_0x013e;
                case 104372930: goto L_0x0132;
                case 169523058: goto L_0x0127;
                case 180723048: goto L_0x011b;
                case 906777209: goto L_0x010f;
                case 940264988: goto L_0x0103;
                case 1307450035: goto L_0x00f7;
                case 1341505643: goto L_0x00eb;
                case 1377553737: goto L_0x00df;
                case 1518141199: goto L_0x00d3;
                case 1570606907: goto L_0x00c7;
                case 1617835444: goto L_0x00bb;
                case 1797816555: goto L_0x00af;
                case 1837314404: goto L_0x00a3;
                case 1992578977: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x01c0
        L_0x0098:
            java.lang.String r10 = "insurance_buy"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 7
            goto L_0x01c1
        L_0x00a3:
            java.lang.String r10 = "brokinginsurance"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 23
            goto L_0x01c1
        L_0x00af:
            java.lang.String r10 = "insautopay"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 25
            goto L_0x01c1
        L_0x00bb:
            java.lang.String r10 = "reviewandbuyh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 15
            goto L_0x01c1
        L_0x00c7:
            java.lang.String r10 = "groupinsurance"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 24
            goto L_0x01c1
        L_0x00d3:
            java.lang.String r10 = "myinsh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 8
            goto L_0x01c1
        L_0x00df:
            java.lang.String r10 = "bundle_buy"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 14
            goto L_0x01c1
        L_0x00eb:
            java.lang.String r10 = "healthreactins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 22
            goto L_0x01c1
        L_0x00f7:
            java.lang.String r10 = "fillnbuyins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 11
            goto L_0x01c1
        L_0x0103:
            java.lang.String r10 = "fillandbuyins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 10
            goto L_0x01c1
        L_0x010f:
            java.lang.String r10 = "health1ins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 20
            goto L_0x01c1
        L_0x011b:
            java.lang.String r10 = "fillnbuyh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 12
            goto L_0x01c1
        L_0x0127:
            java.lang.String r10 = "lifeins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 4
            goto L_0x01c1
        L_0x0132:
            java.lang.String r10 = "myins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 9
            goto L_0x01c1
        L_0x013e:
            java.lang.String r10 = "posreviewbuyh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 17
            goto L_0x01c1
        L_0x014a:
            java.lang.String r10 = "healthins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 19
            goto L_0x01c1
        L_0x0156:
            java.lang.String r10 = "lifeinsh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 5
            goto L_0x01c1
        L_0x0160:
            java.lang.String r10 = "reviewandbuy"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 16
            goto L_0x01c1
        L_0x016b:
            java.lang.String r10 = "posreviewbuy"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 18
            goto L_0x01c1
        L_0x0176:
            java.lang.String r10 = "fourwheelerinsh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 1
            goto L_0x01c1
        L_0x0180:
            java.lang.String r10 = "buypayinsurance"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 6
            goto L_0x01c1
        L_0x018a:
            java.lang.String r10 = "fourwheelerins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 0
            goto L_0x01c1
        L_0x0194:
            java.lang.String r10 = "twowheelerins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 2
            goto L_0x01c1
        L_0x019f:
            java.lang.String r10 = "healthh5ins"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 21
            goto L_0x01c1
        L_0x01aa:
            java.lang.String r10 = "fillnbuyreact"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 13
            goto L_0x01c1
        L_0x01b5:
            java.lang.String r10 = "twowheelerinsh5"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x01c0
            r7 = 3
            goto L_0x01c1
        L_0x01c0:
            r7 = -1
        L_0x01c1:
            java.lang.String r9 = "isNativeInsuranceListing"
            java.lang.String r10 = "&"
            java.lang.String r13 = "isLoginRequired"
            java.lang.String r14 = "insurance_type"
            java.lang.String r15 = "?generic"
            java.lang.String r11 = "insuranceBrokingBaseUrl"
            java.lang.String r3 = ""
            r8 = 0
            switch(r7) {
                case 0: goto L_0x0621;
                case 1: goto L_0x0621;
                case 2: goto L_0x05fd;
                case 3: goto L_0x05fd;
                case 4: goto L_0x05d9;
                case 5: goto L_0x05d9;
                case 6: goto L_0x0590;
                case 7: goto L_0x054a;
                case 8: goto L_0x0525;
                case 9: goto L_0x0525;
                case 10: goto L_0x0476;
                case 11: goto L_0x0476;
                case 12: goto L_0x0476;
                case 13: goto L_0x0476;
                case 14: goto L_0x03c6;
                case 15: goto L_0x0383;
                case 16: goto L_0x0383;
                case 17: goto L_0x0343;
                case 18: goto L_0x0343;
                case 19: goto L_0x0321;
                case 20: goto L_0x0321;
                case 21: goto L_0x0321;
                case 22: goto L_0x0321;
                case 23: goto L_0x02bf;
                case 24: goto L_0x025c;
                case 25: goto L_0x01da;
                default: goto L_0x01d3;
            }
        L_0x01d3:
            net.one97.paytm.deeplink.t r3 = net.one97.paytm.deeplink.t.f50368a
            net.one97.paytm.deeplink.t.a(r16)
            goto L_0x0645
        L_0x01da:
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x023e
            java.lang.String r0 = r6.f50283a
            java.lang.String[] r0 = r0.split(r10)
            if (r0 == 0) goto L_0x0229
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0229
            r4 = r3
            r5 = r4
            r2 = 0
        L_0x01f0:
            int r6 = r0.length
            if (r2 >= r6) goto L_0x022b
            r6 = r0[r2]
            boolean r6 = r6.contains(r14)
            if (r6 == 0) goto L_0x020a
            r4 = r0[r2]
            r6 = r0[r2]
            int r6 = r6.indexOf(r14)
            int r6 = r6 + r12
            r7 = 1
            int r6 = r6 + r7
            java.lang.String r4 = r4.substring(r6)
        L_0x020a:
            r6 = r0[r2]
            java.lang.String r7 = "orderid"
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0226
            r5 = r0[r2]
            r6 = r0[r2]
            java.lang.String r7 = "orderid"
            int r6 = r6.indexOf(r7)
            int r6 = r6 + 7
            r7 = 1
            int r6 = r6 + r7
            java.lang.String r5 = r5.substring(r6)
        L_0x0226:
            int r2 = r2 + 1
            goto L_0x01f0
        L_0x0229:
            r4 = r3
            r5 = r4
        L_0x022b:
            int r0 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0236 }
            net.one97.paytm.insurance.b.d.a((int) r0)     // Catch:{ NumberFormatException -> 0x0236 }
            net.one97.paytm.insurance.b.d.c(r5)     // Catch:{ NumberFormatException -> 0x0236 }
            goto L_0x023e
        L_0x0236:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x023e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?autopay"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            return
        L_0x025c:
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02a1
            java.lang.String r0 = r6.f50283a
            java.lang.String[] r0 = r0.split(r10)
            if (r0 == 0) goto L_0x028e
            int r2 = r0.length
            if (r2 <= 0) goto L_0x028e
            r2 = 0
        L_0x0270:
            int r4 = r0.length
            if (r2 >= r4) goto L_0x028e
            r4 = r0[r2]
            boolean r4 = r4.contains(r14)
            if (r4 == 0) goto L_0x028b
            r3 = r0[r2]
            r0 = r0[r2]
            int r0 = r0.indexOf(r14)
            int r0 = r0 + r12
            r2 = 1
            int r0 = r0 + r2
            java.lang.String r3 = r3.substring(r0)
            goto L_0x028e
        L_0x028b:
            int r2 = r2 + 1
            goto L_0x0270
        L_0x028e:
            net.one97.paytm.insurance.b.d.c(r8)     // Catch:{ NumberFormatException -> 0x0299 }
            int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0299 }
            net.one97.paytm.insurance.b.d.a((int) r0)     // Catch:{ NumberFormatException -> 0x0299 }
            goto L_0x02a1
        L_0x0299:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x02a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = "MyInsuranceMwebV2"
            java.lang.String r2 = net.one97.paytm.insurance.b.a.c((java.lang.String) r2)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            return
        L_0x02bf:
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0305
            java.lang.String r0 = r6.f50283a
            java.lang.String[] r0 = r0.split(r10)
            if (r0 == 0) goto L_0x02f1
            int r2 = r0.length
            if (r2 <= 0) goto L_0x02f1
            r2 = 0
        L_0x02d3:
            int r4 = r0.length
            if (r2 >= r4) goto L_0x02f1
            r4 = r0[r2]
            boolean r4 = r4.contains(r14)
            if (r4 == 0) goto L_0x02ee
            r4 = r0[r2]
            r0 = r0[r2]
            int r0 = r0.indexOf(r14)
            int r0 = r0 + r12
            r2 = 1
            int r0 = r0 + r2
            java.lang.String r0 = r4.substring(r0)
            goto L_0x02f2
        L_0x02ee:
            int r2 = r2 + 1
            goto L_0x02d3
        L_0x02f1:
            r0 = r3
        L_0x02f2:
            net.one97.paytm.insurance.b.d.c(r8)     // Catch:{ NumberFormatException -> 0x02fd }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x02fd }
            net.one97.paytm.insurance.b.d.a((int) r0)     // Catch:{ NumberFormatException -> 0x02fd }
            goto L_0x0305
        L_0x02fd:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0305:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            return
        L_0x0321:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            net.one97.paytm.insurance.b.d.c(r8)
            net.one97.paytm.insurance.b.d.a((int) r12)
            return
        L_0x0343:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?posreviewbuy"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x037b
            android.net.Uri r0 = r6.f50289g
            java.lang.String r2 = "source"
            java.lang.String r0 = r0.getQueryParameter(r2)
            net.one97.paytm.insurance.b.d.b(r0)
            android.net.Uri r0 = r6.f50289g
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getQueryParameter(r2)
            net.one97.paytm.insurance.b.d.a((java.lang.String) r0)
        L_0x037b:
            r0 = 1
            r4.putBoolean(r13, r0)
            r1.openInsuranceH5Page(r4)
            return
        L_0x0383:
            net.one97.paytm.insurance.b.d.c(r8)
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03a4
            android.net.Uri r0 = r6.f50289g
            java.lang.String r2 = "source"
            java.lang.String r0 = r0.getQueryParameter(r2)
            net.one97.paytm.insurance.b.d.b(r0)
            android.net.Uri r0 = r6.f50289g
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getQueryParameter(r2)
            net.one97.paytm.insurance.b.d.a((java.lang.String) r0)
        L_0x03a4:
            r0 = 1
            r4.putBoolean(r13, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?reviewandbuy"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r4)
            return
        L_0x03c6:
            net.one97.paytm.insurance.b.d.c(r8)
            net.one97.paytm.insurance.b.a.a()
            boolean r7 = net.one97.paytm.insurance.b.a.b((java.lang.String) r9)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = r6.f50283a
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x040d
            java.lang.String r8 = r6.f50283a
            java.lang.String[] r8 = r8.split(r10)
            if (r8 == 0) goto L_0x040d
            int r10 = r8.length
            if (r10 <= 0) goto L_0x040d
            r10 = 0
        L_0x03e8:
            int r12 = r8.length
            if (r10 >= r12) goto L_0x040d
            r12 = r8[r10]
            java.lang.String r14 = "url"
            boolean r12 = r12.contains(r14)
            if (r12 == 0) goto L_0x040a
            r12 = r8[r10]
            r8 = r8[r10]
            java.lang.String r10 = "url"
            int r8 = r8.indexOf(r10)
            int r8 = r8 + 3
            r10 = 1
            int r8 = r8 + r10
            java.lang.String r8 = r12.substring(r8)
            goto L_0x040e
        L_0x040a:
            int r10 = r10 + 1
            goto L_0x03e8
        L_0x040d:
            r8 = r3
        L_0x040e:
            boolean r10 = r7.booleanValue()
            if (r10 == 0) goto L_0x042a
            java.lang.Class<common.landing.view.CategorySelectionActivity> r3 = common.landing.view.CategorySelectionActivity.class
            r0.setClass(r2, r3)
            java.lang.String r3 = "bundle_buy_flow"
            r4 = 1
            r0.putExtra(r3, r4)
            java.lang.String r3 = "url_bundle_buy"
            r0.putExtra(r3, r8)
            r0.putExtra(r9, r7)
            goto L_0x0645
        L_0x042a:
            r7 = 0
            r4.putBoolean(r13, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x044e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = "insuranceCategory"
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a((java.lang.String) r2)
            r0.append(r2)
            java.lang.String r2 = "&flag=bundle"
            r0.append(r2)
            java.lang.String r8 = r0.toString()
        L_0x044e:
            java.lang.String r0 = "listingUrl"
            r4.putString(r0, r8)
            f.a.a r0 = f.a.a.f13515a
            f.a.a.e(r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?insList"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r4)
            return
        L_0x0476:
            java.lang.String r0 = r6.f50283a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04bc
            java.lang.String r0 = r6.f50283a
            java.lang.String[] r0 = r0.split(r10)
            if (r0 == 0) goto L_0x04a8
            int r2 = r0.length
            if (r2 <= 0) goto L_0x04a8
            r2 = 0
        L_0x048a:
            int r4 = r0.length
            if (r2 >= r4) goto L_0x04a8
            r4 = r0[r2]
            boolean r4 = r4.contains(r14)
            if (r4 == 0) goto L_0x04a5
            r4 = r0[r2]
            r0 = r0[r2]
            int r0 = r0.indexOf(r14)
            int r0 = r0 + r12
            r2 = 1
            int r0 = r0 + r2
            java.lang.String r0 = r4.substring(r0)
            goto L_0x04a9
        L_0x04a5:
            int r2 = r2 + 1
            goto L_0x048a
        L_0x04a8:
            r0 = r3
        L_0x04a9:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x04b4 }
            net.one97.paytm.insurance.b.d.a((int) r0)     // Catch:{ NumberFormatException -> 0x04b4 }
            net.one97.paytm.insurance.b.d.c(r8)     // Catch:{ NumberFormatException -> 0x04b4 }
            goto L_0x04bc
        L_0x04b4:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x04bc:
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r0 = "insuranceFillnBuyBrokingList"
            java.lang.String r0 = net.one97.paytm.insurance.b.a.a(r0, r3)
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r4 = "MyInsuranceMwebV2"
            java.lang.String r4 = net.one97.paytm.insurance.b.a.c((java.lang.String) r4)
            r2.append(r4)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r1.insFormH5URL = r2
            if (r0 == 0) goto L_0x0518
            r2 = 0
        L_0x04e8:
            int r4 = r0.length     // Catch:{ NumberFormatException -> 0x0518 }
            if (r2 >= r4) goto L_0x0518
            f.a.a r4 = f.a.a.f13515a     // Catch:{ NumberFormatException -> 0x0518 }
            java.lang.Integer r4 = f.a.a.c()     // Catch:{ NumberFormatException -> 0x0518 }
            r5 = r0[r2]     // Catch:{ NumberFormatException -> 0x0518 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x0518 }
            boolean r4 = r4.equals(r5)     // Catch:{ NumberFormatException -> 0x0518 }
            if (r4 == 0) goto L_0x0515
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0518 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x0518 }
            net.one97.paytm.insurance.b.a.a()     // Catch:{ NumberFormatException -> 0x0518 }
            java.lang.String r5 = net.one97.paytm.insurance.b.a.a(r11, r3)     // Catch:{ NumberFormatException -> 0x0518 }
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0518 }
            r4.append(r15)     // Catch:{ NumberFormatException -> 0x0518 }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x0518 }
            r1.insFormH5URL = r4     // Catch:{ NumberFormatException -> 0x0518 }
        L_0x0515:
            int r2 = r2 + 1
            goto L_0x04e8
        L_0x0518:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r2 = 0
            r0.putBoolean(r13, r2)
            r1.openInsuranceH5Page(r0)
            return
        L_0x0525:
            net.one97.paytm.insurance.b.d.c(r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?myins"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r7 = 1
            r4.putBoolean(r13, r7)
            r1.openInsuranceH5Page(r4)
            return
        L_0x054a:
            r7 = 1
            net.one97.paytm.insurance.b.a.a()
            boolean r10 = net.one97.paytm.insurance.b.a.b((java.lang.String) r9)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            net.one97.paytm.insurance.b.d.c(r8)
            f.a.a r12 = f.a.a.f13515a
            f.a.a.e(r8)
            boolean r8 = r10.booleanValue()
            if (r8 == 0) goto L_0x056e
            r0.putExtra(r9, r7)
            java.lang.Class<common.landing.view.CategorySelectionActivity> r3 = common.landing.view.CategorySelectionActivity.class
            r0.setClass(r2, r3)
            goto L_0x0645
        L_0x056e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?insList"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r2 = 0
            r4.putBoolean(r13, r2)
            r1.openInsuranceH5Page(r4)
            return
        L_0x0590:
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r7 = "isNativeInsuranceLanding"
            boolean r7 = net.one97.paytm.insurance.b.a.b((java.lang.String) r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            net.one97.paytm.insurance.b.d.c(r8)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x05b7
            java.lang.String r3 = "isNativeInsuranceLanding"
            r4 = 1
            r0.putExtra(r3, r4)
            java.lang.Class<net.one97.paytm.insurance.common.landing.view.InsuranceBuyPayActivity> r3 = net.one97.paytm.insurance.common.landing.view.InsuranceBuyPayActivity.class
            java.lang.String r3 = r3.getName()
            r0.setClassName(r2, r3)
            goto L_0x0645
        L_0x05b7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            java.lang.String r2 = "?insHome"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r2 = 0
            r4.putBoolean(r13, r2)
            r1.openInsuranceH5Page(r4)
            return
        L_0x05d9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            net.one97.paytm.insurance.b.d.c(r8)
            r0 = 15
            net.one97.paytm.insurance.b.d.a((int) r0)
            return
        L_0x05fd:
            net.one97.paytm.insurance.b.d.c(r8)
            r0 = 13
            net.one97.paytm.insurance.b.d.a((int) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            return
        L_0x0621:
            net.one97.paytm.insurance.b.d.c(r8)
            r0 = 9
            net.one97.paytm.insurance.b.d.a((int) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r2 = net.one97.paytm.insurance.b.a.a(r11, r3)
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1.insFormH5URL = r0
            r1.openInsuranceH5Page(r8)
            return
        L_0x0645:
            r0.putExtra(r5, r6)
            java.lang.String r3 = "EXTRA_DEEP_LINK_FLAG"
            r4 = 1
            r0.putExtra(r3, r4)
            r2.startActivity(r0)
        L_0x0651:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.insurance.InsuranceInitActivity.checkForDeepLinkIntent(android.content.Intent, android.content.Context):void");
    }

    private void openOrderSummaryActivity(Context context, Intent intent) {
        d.a(intent.getIntExtra("insurance_type", 0));
        boolean booleanExtra = intent.getBooleanExtra("is_my_order_screen", false);
        boolean booleanExtra2 = intent.getBooleanExtra("show_home", false);
        String stringExtra = intent.getStringExtra(UpiConstants.FROM);
        Intent a2 = d.a(context, Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2));
        a2.putExtras(intent);
        a2.putExtra("order_id", intent.getStringExtra("order_id"));
        a2.putExtra("insurance_type", String.valueOf(intent.getIntExtra("insurance_type", -1)));
        a2.putExtra(UpiConstants.FROM, stringExtra);
        startActivity(a2);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
        a.b((Context) this);
    }

    private void openInsuranceH5Page(Bundle bundle) {
        DeepLinkData deepLinkData2 = this.deepLinkData;
        if (!(deepLinkData2 == null || deepLinkData2.f50289g == null)) {
            String[] split = this.deepLinkData.f50289g.toString().split("\\?");
            if (split.length == 2) {
                new StringBuilder(AppConstants.AND_SIGN).append(split[1]);
            }
        }
        u.a().a("insurance", "bdb415ca7bdaad7236801351d7e0a41c50793d73", this.insFormH5URL, getBundleForH5(bundle), "", (Context) this);
    }

    private Bundle getBundleForH5(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("canPullDown", false);
        bundle2.putBoolean("pullRefresh", false);
        bundle2.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle2.putString("paytmAppVersion", b.Q((Context) this));
        bundle2.putString("interface", "android");
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return bundle2;
    }
}
