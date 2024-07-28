package net.one97.paytm.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import net.one97.paytm.c;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upgradeKyc.f.f;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f69726a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f69727b;

    /* renamed from: c  reason: collision with root package name */
    private static String f69728c;

    /* renamed from: d  reason: collision with root package name */
    private static String f69729d;

    /* renamed from: e  reason: collision with root package name */
    private static String f69730e;

    /* renamed from: f  reason: collision with root package name */
    private static String f69731f;

    /* renamed from: g  reason: collision with root package name */
    private static String f69732g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static boolean f69733h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static boolean f69734i = false;
    /* access modifiers changed from: private */
    public static int j = 0;

    static /* synthetic */ boolean b(boolean z) {
        return z;
    }

    static {
        Class<j> cls = j.class;
        f69726a = cls.getName();
        f69727b = cls.getSimpleName();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r3, android.content.Context r4) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case -1828465452: goto L_0x0028;
                case 1148336647: goto L_0x001e;
                case 1201768147: goto L_0x0014;
                case 1860402195: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0032
        L_0x000a:
            java.lang.String r0 = "wallet-addmoney"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 3
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "wallet-nearby"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 2
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "wallet-lifafa"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "wallet-pay"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 0
            goto L_0x0033
        L_0x0032:
            r3 = -1
        L_0x0033:
            if (r3 == 0) goto L_0x0056
            if (r3 == r2) goto L_0x004f
            if (r3 == r1) goto L_0x003b
            r3 = 0
            return r3
        L_0x003b:
            boolean r3 = com.paytm.utility.a.p(r4)
            if (r3 == 0) goto L_0x0048
            java.lang.Class<net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity> r3 = net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity.class
            java.lang.String r3 = r3.getName()
            return r3
        L_0x0048:
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r3 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            java.lang.String r3 = r3.getName()
            return r3
        L_0x004f:
            java.lang.Class<net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity> r3 = net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity.class
            java.lang.String r3 = r3.getName()
            return r3
        L_0x0056:
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2> r3 = net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.class
            java.lang.String r3 = r3.getName()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.j.a(java.lang.String, android.content.Context):java.lang.String");
    }

    public static void a(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        f69728c = str4;
        f69729d = str5;
        f69730e = str6;
        f69731f = str7;
        f69732g = str8;
        a(context, str, iJRDataModel, str2, i2, arrayList, z, str3, (c) null);
        f69728c = null;
        f69729d = null;
        f69730e = null;
        f69731f = null;
        f69732g = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x05f7  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r20, java.lang.String r21, net.one97.paytm.common.entity.IJRDataModel r22, java.lang.String r23, int r24, java.util.ArrayList<? extends net.one97.paytm.common.entity.CJRItem> r25, boolean r26, java.lang.String r27, net.one97.paytm.c r28) {
        /*
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r25
            r6 = r27
            java.lang.String r0 = "ActivityNavigation_loadPageFirstTrace"
            com.google.firebase.perf.metrics.Trace r7 = com.google.firebase.perf.a.a((java.lang.String) r0)
            java.lang.String r8 = "gold-passbook"
            java.lang.String r9 = "gold-sip"
            java.lang.String r10 = "gold"
            java.lang.String r11 = "gold-gift"
            java.lang.String r12 = "paytmmp://"
            java.lang.String r13 = "paytm_finance"
            java.lang.String r14 = "digital-gold"
            java.lang.String r15 = "movie"
            if (r3 == 0) goto L_0x0226
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.CJRItem     // Catch:{ Exception -> 0x021b }
            if (r0 == 0) goto L_0x0226
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0     // Catch:{ Exception -> 0x021b }
            java.lang.String r16 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x021b }
            if (r16 != 0) goto L_0x005b
            java.lang.String r5 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "paytmmp"
            boolean r4 = r5.startsWith(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x005b
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            r5 = 0
            boolean r4 = net.one97.paytm.deeplink.h.a.a(r1, r4, r5)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x0057
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x021b }
        L_0x0057:
            r7.stop()
            return
        L_0x005b:
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x00a0
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "amusement-parks"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x00a0
            net.one97.paytm.dynamicModule.DynamicModuleManager r4 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.isInstalled(r15)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x0087
            r4 = r1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.utils.-$$Lambda$j$NCV56m4GeAgRp-CMqKdkDMXdI00 r5 = new net.one97.paytm.utils.-$$Lambda$j$NCV56m4GeAgRp-CMqKdkDMXdI00     // Catch:{ Exception -> 0x021b }
            r5.<init>(r0, r1)     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r4, (java.lang.String) r15, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r5)     // Catch:{ Exception -> 0x021b }
            goto L_0x009c
        L_0x0087:
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = a((net.one97.paytm.common.entity.IJRDataModel) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x021b }
            r0.setUrl(r4)     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            r4 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)     // Catch:{ Exception -> 0x021b }
        L_0x009c:
            r7.stop()
            return
        L_0x00a0:
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x00e5
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "events"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x00e5
            net.one97.paytm.dynamicModule.DynamicModuleManager r4 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.isInstalled(r15)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x00cc
            r4 = r1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.utils.-$$Lambda$j$41gPbQdGjgPNbH8xw2hFu00LB1M r5 = new net.one97.paytm.utils.-$$Lambda$j$41gPbQdGjgPNbH8xw2hFu00LB1M     // Catch:{ Exception -> 0x021b }
            r5.<init>(r0, r1)     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r4, (java.lang.String) r15, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r5)     // Catch:{ Exception -> 0x021b }
            goto L_0x00e1
        L_0x00cc:
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = a((net.one97.paytm.common.entity.IJRDataModel) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x021b }
            r0.setUrl(r4)     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            r4 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)     // Catch:{ Exception -> 0x021b }
        L_0x00e1:
            r7.stop()
            return
        L_0x00e5:
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x0129
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.contains(r10)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x0129
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x0129
            java.lang.String r4 = r0.getURL()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "digitalgold"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x0129
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b }
            r4.<init>(r12)     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            r4.append(r0)     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x021b }
            r4 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)     // Catch:{ Exception -> 0x021b }
            r7.stop()
            return
        L_0x0129:
            net.one97.paytm.deeplink.aj r4 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = net.one97.paytm.deeplink.aj.a((java.lang.String) r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01e1
            net.one97.paytm.deeplink.aj r4 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = net.one97.paytm.deeplink.aj.b((java.lang.String) r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01e1
            net.one97.paytm.deeplink.aj r4 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = net.one97.paytm.deeplink.aj.c(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01e1
            net.one97.paytm.deeplink.aj r4 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = net.one97.paytm.deeplink.aj.d(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x015b
            goto L_0x01e1
        L_0x015b:
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x0171
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "Gold"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
        L_0x0171:
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "goldweex"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01b1
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "paytm-postpaid"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x0226
        L_0x01b1:
            net.one97.paytm.dynamicModule.DynamicModuleManager r4 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.isInstalled(r13)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01c7
            r4 = r1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.utils.-$$Lambda$j$NDvUGylPSeN96930EADxaY2KfXU r5 = new net.one97.paytm.utils.-$$Lambda$j$NDvUGylPSeN96930EADxaY2KfXU     // Catch:{ Exception -> 0x021b }
            r5.<init>(r1, r0)     // Catch:{ Exception -> 0x021b }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r4, (java.lang.String) r13, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r5)     // Catch:{ Exception -> 0x021b }
            goto L_0x01dd
        L_0x01c7:
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x021b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b }
            r4.<init>(r12)     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.getURLType()     // Catch:{ Exception -> 0x021b }
            r4.append(r0)     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x021b }
            r4 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)     // Catch:{ Exception -> 0x021b }
        L_0x01dd:
            r7.stop()
            return
        L_0x01e1:
            net.one97.paytm.dynamicModule.DynamicModuleManager r4 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "flight_dynamic"
            boolean r4 = r4.isInstalled(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 != 0) goto L_0x01fd
            r4 = r1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "flight_dynamic"
            r17 = r14
            net.one97.paytm.utils.-$$Lambda$j$vooJCHTezIyiK_qjWym8J7bsKeM r14 = new net.one97.paytm.utils.-$$Lambda$j$vooJCHTezIyiK_qjWym8J7bsKeM     // Catch:{ Exception -> 0x0219 }
            r14.<init>(r1, r0)     // Catch:{ Exception -> 0x0219 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r4, (java.lang.String) r5, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r14)     // Catch:{ Exception -> 0x0219 }
            goto L_0x0215
        L_0x01fd:
            r17 = r14
            net.one97.paytm.deeplink.h$a r4 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0219 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0219 }
            r4.<init>(r12)     // Catch:{ Exception -> 0x0219 }
            java.lang.String r0 = r0.getURLType()     // Catch:{ Exception -> 0x0219 }
            r4.append(r0)     // Catch:{ Exception -> 0x0219 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0219 }
            r4 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)     // Catch:{ Exception -> 0x0219 }
        L_0x0215:
            r7.stop()
            return
        L_0x0219:
            r0 = move-exception
            goto L_0x021e
        L_0x021b:
            r0 = move-exception
            r17 = r14
        L_0x021e:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x0228
        L_0x0226:
            r17 = r14
        L_0x0228:
            net.one97.paytm.upgradeKyc.f.f r0 = net.one97.paytm.upgradeKyc.f.f.a()
            net.one97.paytm.utils.j$1 r4 = new net.one97.paytm.utils.j$1
            r4.<init>()
            r0.a((android.content.Context) r1, (net.one97.paytm.upgradeKyc.f.f.a) r4)
            java.lang.String r0 = "native"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0256
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r0 == 0) goto L_0x0256
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRNativeBannerActivity> r3 = net.one97.paytm.AJRNativeBannerActivity.class
            r2.<init>(r1, r3)
            java.lang.String r3 = "intent_extra_promo_info"
            r2.putExtra(r3, r0)
            r1.startActivity(r2)
            r7.stop()
            return
        L_0x0256:
            boolean r4 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r4 == 0) goto L_0x0272
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r5 = r0.getURLType()
            boolean r5 = net.one97.paytm.deeplink.ac.a((java.lang.String) r2, (java.lang.String) r5)
            if (r5 == 0) goto L_0x0272
            java.lang.String r0 = r0.getURL()
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
            r7.stop()
            return
        L_0x0272:
            java.lang.String r0 = "transaction_detail"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0290
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.CJRItem
            if (r0 == 0) goto L_0x0290
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0
            java.lang.String r0 = r0.getItemID()
            java.lang.String r0 = net.one97.paytm.deeplink.ac.a.a(r0)
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
            r7.stop()
            return
        L_0x0290:
            java.lang.String r0 = "edc_receipt"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x02c6
            if (r4 == 0) goto L_0x02c6
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r2 = r0.getTxnId()
            java.lang.String r3 = r0.getMid()
            java.lang.String r0 = r0.getAcquirementId()
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity> r5 = net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity.class
            r4.<init>(r1, r5)
            java.lang.String r5 = "tid"
            r4.putExtra(r5, r2)
            java.lang.String r2 = "mid"
            r4.putExtra(r2, r3)
            java.lang.String r2 = "acquirementId"
            r4.putExtra(r2, r0)
            r1.startActivity(r4)
            r7.stop()
            return
        L_0x02c6:
            boolean r0 = android.text.TextUtils.isEmpty(r21)
            if (r0 == 0) goto L_0x02e9
            android.content.res.Resources r0 = r20.getResources()
            r2 = 2131963372(0x7f132dec, float:1.9563496E38)
            java.lang.String r0 = r0.getString(r2)
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131959083(0x7f131d2b, float:1.9554796E38)
            java.lang.String r2 = r2.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r2)
            r7.stop()
            return
        L_0x02e9:
            java.lang.String r0 = "nolink"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x02f5
            r7.stop()
            return
        L_0x02f5:
            if (r4 == 0) goto L_0x0319
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r5 = r0.getVerticalid()
            java.lang.String r14 = "66"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x0319
            java.lang.String r5 = "product"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0319
            java.lang.String r0 = r0.getURL()
            net.one97.paytm.marketplace.a.c((java.lang.String) r0)
            r7.stop()
            return
        L_0x0319:
            r5 = r3
            net.one97.paytm.common.entity.CJRDataModelItem r5 = (net.one97.paytm.common.entity.CJRDataModelItem) r5
            if (r4 == 0) goto L_0x0326
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r0 = r0.getPushFeatureType()
            goto L_0x0328
        L_0x0326:
            java.lang.String r0 = ""
        L_0x0328:
            r14 = r0
            boolean r0 = com.paytm.utility.b.F((java.lang.String) r21)     // Catch:{ Exception -> 0x0361 }
            if (r0 == 0) goto L_0x035e
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRCatalogItem     // Catch:{ Exception -> 0x0361 }
            if (r0 == 0) goto L_0x035e
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r0 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r0     // Catch:{ Exception -> 0x0361 }
            java.lang.String r0 = r0.getCategoryId()     // Catch:{ Exception -> 0x0361 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0361 }
            if (r0 == 0) goto L_0x035e
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r0 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r0     // Catch:{ Exception -> 0x0361 }
            java.lang.String r0 = net.one97.paytm.utils.l.a((net.one97.paytm.common.entity.CJRItem) r0)     // Catch:{ Exception -> 0x0361 }
            boolean r18 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0361 }
            if (r18 != 0) goto L_0x035e
            boolean r18 = android.text.TextUtils.isDigitsOnly(r0)     // Catch:{ Exception -> 0x0361 }
            if (r18 == 0) goto L_0x035e
            r18 = r15
            r15 = r5
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r15 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r15     // Catch:{ Exception -> 0x035c }
            r15.setCategoryId(r0)     // Catch:{ Exception -> 0x035c }
            goto L_0x036b
        L_0x035c:
            r0 = move-exception
            goto L_0x0364
        L_0x035e:
            r18 = r15
            goto L_0x036b
        L_0x0361:
            r0 = move-exception
            r18 = r15
        L_0x0364:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x036b:
            java.lang.String r0 = "homepage"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0382
            java.lang.String r0 = r5.getName()
            java.lang.String r15 = "Paytm Home"
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0382
            java.lang.String r0 = "homepage_secondary"
            goto L_0x0383
        L_0x0382:
            r0 = r2
        L_0x0383:
            if (r0 == 0) goto L_0x038f
            java.lang.String r2 = "dmrc"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x038f
            java.lang.String r0 = "DMRC"
        L_0x038f:
            java.lang.String r2 = r5.getName()
            if (r2 == 0) goto L_0x03a3
            java.lang.String r2 = r5.getName()
            java.lang.String r15 = "Events"
            boolean r2 = r2.equalsIgnoreCase(r15)
            if (r2 == 0) goto L_0x03a3
            java.lang.String r0 = "events"
        L_0x03a3:
            java.lang.String r2 = r5.getName()
            if (r2 == 0) goto L_0x03b7
            java.lang.String r2 = r5.getName()
            java.lang.String r15 = "goldweex"
            boolean r2 = r2.equalsIgnoreCase(r15)
            if (r2 == 0) goto L_0x03b7
            r0 = r17
        L_0x03b7:
            java.lang.String r2 = r5.getName()
            if (r2 == 0) goto L_0x03c9
            java.lang.String r2 = r5.getName()
            boolean r2 = r2.equalsIgnoreCase(r10)
            if (r2 == 0) goto L_0x03c9
            r0 = r17
        L_0x03c9:
            java.lang.String r2 = r5.getName()
            if (r2 == 0) goto L_0x03da
            java.lang.String r2 = r5.getName()
            boolean r2 = r2.equalsIgnoreCase(r9)
            if (r2 == 0) goto L_0x03da
            goto L_0x03db
        L_0x03da:
            r9 = r0
        L_0x03db:
            if (r9 == 0) goto L_0x03e5
            boolean r0 = r9.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x03e5
            r9 = r17
        L_0x03e5:
            if (r9 == 0) goto L_0x03ee
            boolean r0 = r9.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x03ee
            goto L_0x03ef
        L_0x03ee:
            r8 = r9
        L_0x03ef:
            if (r8 == 0) goto L_0x03f8
            boolean r0 = r8.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x03f8
            r8 = r11
        L_0x03f8:
            java.lang.String r0 = r5.getName()
            if (r0 == 0) goto L_0x040c
            java.lang.String r0 = r5.getName()
            java.lang.String r2 = "amusement"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x040c
            java.lang.String r8 = "amusement"
        L_0x040c:
            java.lang.String r0 = r5.getName()
            if (r0 == 0) goto L_0x0420
            java.lang.String r0 = r5.getName()
            java.lang.String r2 = "amusementparks"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0420
            java.lang.String r8 = "amusement"
        L_0x0420:
            java.lang.String r0 = r5.getName()
            java.lang.String r2 = "myprofile"
            if (r0 == 0) goto L_0x0433
            java.lang.String r0 = r5.getName()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0433
            r8 = r2
        L_0x0433:
            java.lang.String r0 = r5.getName()
            if (r0 == 0) goto L_0x0447
            java.lang.String r0 = r5.getName()
            java.lang.String r9 = "wishlist"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x0447
            java.lang.String r8 = "wishlist"
        L_0x0447:
            java.lang.String r0 = r5.getName()
            java.lang.String r9 = "updates"
            if (r0 == 0) goto L_0x045a
            java.lang.String r0 = r5.getName()
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x045a
            r8 = r9
        L_0x045a:
            java.lang.String r0 = r5.getName()
            java.lang.String r10 = "profile"
            if (r0 == 0) goto L_0x046d
            java.lang.String r0 = r5.getName()
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x046d
            r8 = r10
        L_0x046d:
            if (r8 == 0) goto L_0x0479
            java.lang.String r0 = "freemovie"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0479
            java.lang.String r8 = "freemovie"
        L_0x0479:
            if (r8 == 0) goto L_0x0485
            java.lang.String r0 = "giftcards"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0485
            java.lang.String r8 = "giftcards"
        L_0x0485:
            if (r8 == 0) goto L_0x0491
            java.lang.String r0 = "postorder_fb"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0491
            java.lang.String r8 = "postorder_fb"
        L_0x0491:
            if (r8 == 0) goto L_0x049d
            java.lang.String r0 = "cst"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x049d
            java.lang.String r8 = "cst"
        L_0x049d:
            if (r8 == 0) goto L_0x04b0
            java.lang.String r0 = "paytm.com"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04b0
            if (r4 == 0) goto L_0x04b0
            r0 = r5
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r8 = r0.getPushFeatureType()
        L_0x04b0:
            if (r8 == 0) goto L_0x04bc
            java.lang.String r0 = "video"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04bc
            java.lang.String r8 = "video"
        L_0x04bc:
            if (r8 == 0) goto L_0x04c8
            java.lang.String r0 = "luckylifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04c8
            java.lang.String r8 = "luckylifafa"
        L_0x04c8:
            if (r8 == 0) goto L_0x04d4
            java.lang.String r0 = "wallet-pay"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04d4
            java.lang.String r8 = "wallet-pay"
        L_0x04d4:
            if (r8 == 0) goto L_0x04e0
            java.lang.String r0 = "wallet-lifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04e0
            java.lang.String r8 = "wallet-lifafa"
        L_0x04e0:
            if (r8 == 0) goto L_0x04ec
            java.lang.String r0 = "wallet-acceptpayment"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04ec
            java.lang.String r8 = "wallet-acceptpayment"
        L_0x04ec:
            if (r8 == 0) goto L_0x04f8
            java.lang.String r0 = "wallet-addmoney"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04f8
            java.lang.String r8 = "wallet-addmoney"
        L_0x04f8:
            if (r8 == 0) goto L_0x0504
            java.lang.String r0 = "wallet-nearby"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0504
            java.lang.String r8 = "wallet-nearby"
        L_0x0504:
            if (r8 == 0) goto L_0x0510
            java.lang.String r0 = "wallet-passbook"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0510
            java.lang.String r8 = "wallet-passbook"
        L_0x0510:
            if (r8 == 0) goto L_0x051c
            java.lang.String r0 = "login"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x051c
            java.lang.String r8 = "login"
        L_0x051c:
            if (r8 == 0) goto L_0x0590
            java.lang.String r15 = "utility"
            boolean r15 = r8.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0590
            if (r4 == 0) goto L_0x0590
            r15 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r15 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r15
            java.lang.String r0 = r15.mUrl
            boolean r0 = com.paytm.utility.b.I((java.lang.String) r0)
            if (r0 == 0) goto L_0x0560
            java.lang.String r0 = "buypayinsurance"
            net.one97.paytm.dynamicModule.DynamicModuleManager r2 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            boolean r2 = r2.isInstalled(r13)
            if (r2 != 0) goto L_0x054b
            r2 = r1
            androidx.appcompat.app.AppCompatActivity r2 = (androidx.appcompat.app.AppCompatActivity) r2
            net.one97.paytm.utils.-$$Lambda$j$UXpm8z3EOCCqWqfLgVZHV0UO2ns r3 = new net.one97.paytm.utils.-$$Lambda$j$UXpm8z3EOCCqWqfLgVZHV0UO2ns
            r3.<init>(r0, r1)
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r2, (java.lang.String) r13, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r3)
            goto L_0x055c
        L_0x054b:
            java.lang.String r0 = r12.concat(r0)
            r15.setUrl(r0)
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a
            java.lang.String r0 = r15.getURL()
            r2 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r2)
        L_0x055c:
            r7.stop()
            return
        L_0x0560:
            java.lang.String r0 = r15.mUrl
            boolean r0 = net.one97.paytm.deeplink.j.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x0590
            net.one97.paytm.j.c.a()
            java.lang.String r0 = "is_education_h5_enabled"
            r19 = r8
            r8 = 0
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r8)
            if (r0 == 0) goto L_0x0592
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "paytmmp://edu-open-h5?qrCodeParams="
            r0.<init>(r2)
            java.lang.String r2 = r15.mUrl
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            net.one97.paytm.deeplink.h$a r2 = net.one97.paytm.deeplink.h.f50349a
            r3 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r3)
            r7.stop()
            return
        L_0x0590:
            r19 = r8
        L_0x0592:
            if (r4 == 0) goto L_0x05a6
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r0 = r0.getName()
            java.lang.String r8 = "fastag"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05a6
            java.lang.String r8 = "fastag_toll"
            goto L_0x05a8
        L_0x05a6:
            r8 = r19
        L_0x05a8:
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r15 = "cash_wallet"
            boolean r15 = r8.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x05d6
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x05d6
            java.lang.String r15 = "sendmoneymobile"
            boolean r15 = r14.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x05d6
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r14)
            java.lang.String r0 = (java.lang.String) r0
        L_0x05d6:
            java.lang.String r15 = "upi"
            boolean r15 = r8.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x05f0
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x05f0
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r14)
            java.lang.String r0 = (java.lang.String) r0
        L_0x05f0:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r15 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r15.<init>()
            if (r4 == 0) goto L_0x05fd
            r15 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r15 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r15
        L_0x05fa:
            r19 = r11
            goto L_0x0628
        L_0x05fd:
            boolean r4 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2
            if (r4 == 0) goto L_0x05fa
            r4 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r4
            r15.setOrigin(r6)
            r15.setUrlType(r8)
            r19 = r11
            java.lang.String r11 = r4.getImageUrl()
            r15.setImageUrl(r11)
            java.lang.String r11 = r4.getmID()
            r15.setMid(r11)
            java.lang.String r11 = r4.getName()
            r15.setName(r11)
            java.lang.String r4 = r4.getSeeAllUrl()
            r15.setUrl(r4)
        L_0x0628:
            net.one97.paytm.utils.j$6 r4 = new net.one97.paytm.utils.j$6
            r4.<init>(r15)
            android.os.Bundle r4 = net.one97.paytm.marketplace.a.a((java.util.HashMap<java.lang.String, java.io.Serializable>) r4)
            if (r0 != 0) goto L_0x0646
            boolean r11 = net.one97.paytm.marketplace.a.a((java.lang.String) r8)
            if (r11 == 0) goto L_0x0646
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a
            java.lang.String r0 = net.one97.paytm.marketplace.a.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r15, (java.lang.String) r8)
            net.one97.paytm.deeplink.h.a.a(r1, r0, r4)
            r7.stop()
            return
        L_0x0646:
            r4 = -1
            int r11 = r8.hashCode()
            r15 = 1
            switch(r11) {
                case -1828469535: goto L_0x06e8;
                case -1828465452: goto L_0x06de;
                case -1828460198: goto L_0x06d4;
                case -1733036585: goto L_0x06ca;
                case -1731647246: goto L_0x06bf;
                case -1646056628: goto L_0x06b4;
                case -1159865719: goto L_0x06a9;
                case 4834766: goto L_0x069f;
                case 29304850: goto L_0x0694;
                case 147595562: goto L_0x068a;
                case 1148336647: goto L_0x067f;
                case 1201768147: goto L_0x0674;
                case 1307450035: goto L_0x0668;
                case 1860402195: goto L_0x065d;
                case 1992578977: goto L_0x0651;
                default: goto L_0x064f;
            }
        L_0x064f:
            goto L_0x06f2
        L_0x0651:
            java.lang.String r11 = "insurance_buy"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 12
            goto L_0x06f2
        L_0x065d:
            java.lang.String r11 = "wallet-addmoney"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 5
            goto L_0x06f2
        L_0x0668:
            java.lang.String r11 = "fillnbuyins"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 14
            goto L_0x06f2
        L_0x0674:
            java.lang.String r11 = "wallet-nearby"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 4
            goto L_0x06f2
        L_0x067f:
            java.lang.String r11 = "wallet-lifafa"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 1
            goto L_0x06f2
        L_0x068a:
            java.lang.String r11 = "wallet-acceptpayment"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 2
            goto L_0x06f2
        L_0x0694:
            java.lang.String r11 = "healthins"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 13
            goto L_0x06f2
        L_0x069f:
            java.lang.String r11 = "wallet-passbook"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 3
            goto L_0x06f2
        L_0x06a9:
            java.lang.String r11 = "cst_flow"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 9
            goto L_0x06f2
        L_0x06b4:
            java.lang.String r11 = "fourwheelerins"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 10
            goto L_0x06f2
        L_0x06bf:
            java.lang.String r11 = "twowheelerins"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 11
            goto L_0x06f2
        L_0x06ca:
            java.lang.String r11 = "wallet-moneytransfer"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 6
            goto L_0x06f2
        L_0x06d4:
            java.lang.String r11 = "wallet-upi"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 7
            goto L_0x06f2
        L_0x06de:
            java.lang.String r11 = "wallet-pay"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 0
            goto L_0x06f2
        L_0x06e8:
            java.lang.String r11 = "wallet-kyc"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x06f2
            r4 = 8
        L_0x06f2:
            switch(r4) {
                case 0: goto L_0x08dc;
                case 1: goto L_0x08b0;
                case 2: goto L_0x08a9;
                case 3: goto L_0x08a0;
                case 4: goto L_0x089a;
                case 5: goto L_0x088a;
                case 6: goto L_0x0818;
                case 7: goto L_0x07d9;
                case 8: goto L_0x07ba;
                case 9: goto L_0x0724;
                case 10: goto L_0x06fc;
                case 11: goto L_0x06fc;
                case 12: goto L_0x06fc;
                case 13: goto L_0x06fc;
                case 14: goto L_0x06f8;
                default: goto L_0x06f5;
            }
        L_0x06f5:
            r4 = 0
            goto L_0x0901
        L_0x06f8:
            r7.stop()
            return
        L_0x06fc:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r12.concat(r0)
            net.one97.paytm.dynamicModule.DynamicModuleManager r2 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            boolean r2 = r2.isInstalled(r13)
            if (r2 != 0) goto L_0x071a
            r2 = r1
            androidx.appcompat.app.AppCompatActivity r2 = (androidx.appcompat.app.AppCompatActivity) r2
            net.one97.paytm.utils.-$$Lambda$j$mi8LU9Q1jGaTxbkynD652PG9QK4 r3 = new net.one97.paytm.utils.-$$Lambda$j$mi8LU9Q1jGaTxbkynD652PG9QK4
            r3.<init>(r1, r0)
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r2, (java.lang.String) r13, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r3)
            goto L_0x0720
        L_0x071a:
            net.one97.paytm.deeplink.h$a r2 = net.one97.paytm.deeplink.h.f50349a
            r3 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r3)
        L_0x0720:
            r7.stop()
            return
        L_0x0724:
            boolean r0 = com.paytm.utility.a.p(r20)
            if (r0 == 0) goto L_0x0782
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r2 = "from_deep_link"
            r0.putBoolean(r2, r15)
            boolean r2 = r5 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r2 == 0) goto L_0x07b6
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r5
            java.lang.String r2 = r5.getVerticalId()
            if (r2 == 0) goto L_0x0749
            java.lang.String r2 = r5.getVerticalId()
            java.lang.String r3 = "verticalId"
            r0.putString(r3, r2)
        L_0x0749:
            java.lang.String r2 = r5.getTrendingId()
            if (r2 == 0) goto L_0x0758
            java.lang.String r2 = r5.getTrendingId()
            java.lang.String r3 = "trendingId"
            r0.putString(r3, r2)
        L_0x0758:
            java.lang.String r2 = r5.getTemplateId()
            if (r2 == 0) goto L_0x0767
            java.lang.String r2 = r5.getTemplateId()
            java.lang.String r3 = "templateId"
            r0.putString(r3, r2)
        L_0x0767:
            java.lang.String r2 = r5.getFeatureType()
            if (r2 == 0) goto L_0x0776
            java.lang.String r2 = r5.getFeatureType()
            java.lang.String r3 = "vertical"
            r0.putString(r3, r2)
        L_0x0776:
            r2 = 67108864(0x4000000, double:3.31561842E-316)
            java.lang.String r4 = "intent_flag"
            r0.putLong(r4, r2)
            net.one97.paytm.deeplink.d.b(r1, r0)
            goto L_0x07b6
        L_0x0782:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r0 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r2.<init>(r1, r0)
            java.lang.String r0 = "resultant activity"
            java.lang.String r3 = "net.one97.paytm.cst.activity.AJRCSTOrderIssues"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0795 }
            r2.putExtra(r0, r3)     // Catch:{ ClassNotFoundException -> 0x0795 }
            goto L_0x079d
        L_0x0795:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x079d:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = "extra_home_data"
            r0.putSerializable(r3, r5)
            java.lang.String r3 = "origin"
            java.lang.String r4 = "deeplinking"
            r0.putString(r3, r4)
            java.lang.String r3 = "resultant activity_bundle"
            r2.putExtra(r3, r0)
            r1.startActivity(r2)
        L_0x07b6:
            r7.stop()
            return
        L_0x07ba:
            boolean r0 = com.paytm.utility.a.p(r20)
            if (r0 == 0) goto L_0x07cb
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity> r2 = net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
            goto L_0x07d5
        L_0x07cb:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.UpgraKycInfoActivity> r2 = net.one97.paytm.upgradeKyc.activity.UpgraKycInfoActivity.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
        L_0x07d5:
            r7.stop()
            return
        L_0x07d9:
            boolean r0 = com.paytm.utility.a.p(r20)
            if (r0 == 0) goto L_0x0803
            if (r1 != 0) goto L_0x07e5
            r7.stop()
            return
        L_0x07e5:
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            r0.<init>(r1)
            r2 = 2131961275(0x7f1325bb, float:1.9559242E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setMessage(r2)
            r0.setIndeterminate(r15)
            r0.show()
            net.one97.paytm.utils.j$10 r2 = new net.one97.paytm.utils.j$10
            r2.<init>(r0, r1)
            a((net.one97.paytm.upi.registration.b.a.a.C1389a) r2)
            goto L_0x0814
        L_0x0803:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity> r2 = net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity.class
            r0.<init>(r1, r2)
            java.lang.String r2 = "resultant_activity"
            java.lang.String r3 = "upi"
            r0.putExtra(r2, r3)
            r1.startActivity(r0)
        L_0x0814:
            r7.stop()
            return
        L_0x0818:
            boolean r0 = com.paytm.utility.a.p(r20)
            if (r0 == 0) goto L_0x0875
            if (r1 != 0) goto L_0x0824
            r7.stop()
            return
        L_0x0824:
            android.content.Context r0 = r20.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)
            java.lang.String r2 = "is_upi_user"
            r3 = 0
            boolean r0 = r0.b((java.lang.String) r2, (boolean) r3, (boolean) r15)
            if (r0 != 0) goto L_0x0865
            boolean r0 = net.one97.paytm.utils.a.b.b(r20)
            if (r0 == 0) goto L_0x083c
            goto L_0x0865
        L_0x083c:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity> r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.class
            r0.<init>(r1, r2)
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r0.setFlags(r2)
            r1.startActivity(r0)
            net.one97.paytm.utils.j$7 r0 = new net.one97.paytm.utils.j$7
            r0.<init>(r1)
            a((net.one97.paytm.upi.registration.b.a.a.C1389a) r0)
            net.one97.paytm.moneytransfer.b.a.b r0 = net.one97.paytm.moneytransfer.b.a(r20)
            net.one97.paytm.utils.j$8 r2 = new net.one97.paytm.utils.j$8
            r2.<init>(r1)
            net.one97.paytm.utils.j$9 r1 = new net.one97.paytm.utils.j$9
            r1.<init>()
            r0.b(r2, r1)
            goto L_0x0886
        L_0x0865:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity> r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.class
            r0.<init>(r1, r2)
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r0.setFlags(r2)
            r1.startActivity(r0)
            goto L_0x0886
        L_0x0875:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity> r2 = net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity.class
            r0.<init>(r1, r2)
            java.lang.String r2 = "dest"
            java.lang.String r3 = "money_transfer"
            r0.putExtra(r2, r3)
            r1.startActivity(r0)
        L_0x0886:
            r7.stop()
            return
        L_0x088a:
            net.one97.paytm.wallet.newdesign.a.a()
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
            r4 = 0
            java.lang.String[] r1 = new java.lang.String[r4]
            net.one97.paytm.wallet.newdesign.a.a((android.app.Activity) r0, (java.lang.String[]) r1)
            r7.stop()
            return
        L_0x089a:
            r4 = 0
            java.lang.String r0 = a((java.lang.String) r8, (android.content.Context) r1)
            goto L_0x0901
        L_0x08a0:
            java.lang.String r0 = "paytmmp://cash_wallet?featuretype=cash_ledger"
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
            r7.stop()
            return
        L_0x08a9:
            r4 = 0
            java.lang.String r11 = "paytmmp://accept_payment_onboarding"
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r11)
            goto L_0x0901
        L_0x08b0:
            r4 = 0
            boolean r0 = f69733h
            if (r0 != 0) goto L_0x08d7
            int r0 = j
            if (r0 != 0) goto L_0x08d7
            boolean r0 = com.paytm.utility.a.p(r20)
            if (r0 == 0) goto L_0x08d7
            java.lang.String r0 = "paytmmp://cash_wallet?featuretype=lifafa"
            java.lang.String r2 = "wallet"
            java.lang.String r0 = a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x08cb }
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ UnsupportedEncodingException -> 0x08cb }
            goto L_0x08d3
        L_0x08cb:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x08d3:
            r7.stop()
            return
        L_0x08d7:
            java.lang.String r0 = a((java.lang.String) r8, (android.content.Context) r1)
            goto L_0x0901
        L_0x08dc:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2> r2 = net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            java.lang.String r2 = "flow_through_pay_icon"
            r0.f71397i = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$e r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.e.NEW_WALLET_PAY_CLICK
            r0.j = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.PAY_CLICKED_NEW
            r0.l = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.PAY_CLICKED_NEW
            r0.k = r2
            r0.b((android.content.Context) r1)
            r7.stop()
            return
        L_0x0901:
            if (r0 == 0) goto L_0x0c92
            java.lang.String r11 = "external"
            boolean r11 = r8.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0c86 }
            if (r11 == 0) goto L_0x0940
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0c86 }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r2 != 0) goto L_0x091c
            r7.stop()
            return
        L_0x091c:
            java.lang.String r2 = "browser"
            java.lang.String r3 = "1"
            java.lang.String r0 = com.paytm.utility.c.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x0c86 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r3 = "android.intent.action.VIEW"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0c86 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x0c86 }
            android.content.pm.PackageManager r0 = r20.getPackageManager()     // Catch:{ Exception -> 0x0c86 }
            android.content.ComponentName r0 = r2.resolveActivity(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x093c
            r1.startActivity(r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x093c:
            r7.stop()
            return
        L_0x0940:
            java.lang.String r11 = "net.one97.paytm.o2o.movies.activity.MoviesHomeActivity"
            boolean r11 = r0.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0c86 }
            if (r11 != 0) goto L_0x0950
            java.lang.String r11 = "net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity"
            boolean r11 = r0.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0c86 }
            if (r11 == 0) goto L_0x096b
        L_0x0950:
            net.one97.paytm.dynamicModule.DynamicModuleManager r11 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0c86 }
            r12 = r18
            boolean r11 = r11.isInstalled(r12)     // Catch:{ Exception -> 0x0c86 }
            if (r11 != 0) goto L_0x096b
            r2 = r1
            androidx.appcompat.app.AppCompatActivity r2 = (androidx.appcompat.app.AppCompatActivity) r2     // Catch:{ Exception -> 0x0c86 }
            net.one97.paytm.utils.-$$Lambda$j$K9ipsejyfhKnM7rWgArXrHOJUTo r3 = new net.one97.paytm.utils.-$$Lambda$j$K9ipsejyfhKnM7rWgArXrHOJUTo     // Catch:{ Exception -> 0x0c86 }
            r3.<init>(r0, r1)     // Catch:{ Exception -> 0x0c86 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r2, (java.lang.String) r12, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r3)     // Catch:{ Exception -> 0x0c86 }
            r7.stop()
            return
        L_0x096b:
            android.content.Intent r11 = new android.content.Intent     // Catch:{ Exception -> 0x0c86 }
            java.lang.Class r12 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0c86 }
            r11.<init>(r1, r12)     // Catch:{ Exception -> 0x0c86 }
            if (r3 == 0) goto L_0x0985
            boolean r12 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x0985
            boolean r12 = net.one97.paytm.upi.util.UpiUtils.isInActiveProfileExist(r20)     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x0985
            java.lang.String r12 = "inactive_User"
            r11.putExtra(r12, r15)     // Catch:{ Exception -> 0x0c86 }
        L_0x0985:
            if (r3 == 0) goto L_0x09b5
            boolean r12 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x09b5
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0c86 }
            if (r12 != 0) goto L_0x09b5
            java.lang.String r12 = "grid"
            boolean r12 = r8.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x09b5
            r12 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r12 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r12     // Catch:{ Exception -> 0x0c86 }
            boolean r12 = r12.isFromReqDelivery()     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x09a7
            java.lang.String r12 = "is_from_req_delivery"
            r11.putExtra(r12, r15)     // Catch:{ Exception -> 0x0c86 }
        L_0x09a7:
            r12 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r12 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r12     // Catch:{ Exception -> 0x0c86 }
            net.one97.paytm.common.entity.IJRDataModel r12 = r12.getBuilderModel()     // Catch:{ Exception -> 0x0c86 }
            if (r12 == 0) goto L_0x09b5
            java.lang.String r13 = "intent_builder_model"
            r11.putExtra(r13, r12)     // Catch:{ Exception -> 0x0c86 }
        L_0x09b5:
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2> r12 = net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.class
            java.lang.String r12 = r12.getName()     // Catch:{ Exception -> 0x0c86 }
            boolean r0 = r12.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x09c6
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r11.setFlags(r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x09c6:
            java.lang.String r0 = "extra_home_data"
            r11.putExtra(r0, r3)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "smart_list"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x09d8
            java.lang.String r0 = "smart_list"
            r11.putExtra(r0, r15)     // Catch:{ Exception -> 0x0c86 }
        L_0x09d8:
            java.lang.String r0 = "search"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0a13
            java.lang.String r0 = "deeplinking"
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x0a07
            if (r28 == 0) goto L_0x09ff
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            boolean r0 = r0.isFromFromSearch()     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x09ff
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r12 = net.one97.paytm.c.a()     // Catch:{ Exception -> 0x0c86 }
            r0.setCategoryId(r12)     // Catch:{ Exception -> 0x0c86 }
            r12 = 0
            goto L_0x0a0d
        L_0x09ff:
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            r12 = 0
            r0.setCategoryId(r12)     // Catch:{ Exception -> 0x0c86 }
            goto L_0x0a0d
        L_0x0a07:
            r12 = 0
            java.lang.String r0 = "extra_home_data"
            r11.putExtra(r0, r3)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a0d:
            java.lang.String r0 = "is_from_search"
            r11.putExtra(r0, r15)     // Catch:{ Exception -> 0x0c86 }
            goto L_0x0a14
        L_0x0a13:
            r12 = 0
        L_0x0a14:
            r13 = r23
            if (r13 == 0) goto L_0x0a1d
            java.lang.String r0 = "calling activity"
            r11.putExtra(r0, r13)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a1d:
            java.lang.String r0 = "product"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0a62
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0c86 }
            r0.<init>()     // Catch:{ Exception -> 0x0c86 }
            r13 = r12
            r12 = r25
            if (r12 == 0) goto L_0x0a51
        L_0x0a2f:
            int r13 = r25.size()     // Catch:{ Exception -> 0x0c86 }
            if (r4 >= r13) goto L_0x0a51
            java.lang.Object r13 = r12.get(r4)     // Catch:{ Exception -> 0x0c86 }
            net.one97.paytm.common.entity.CJRItem r13 = (net.one97.paytm.common.entity.CJRItem) r13     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r13 = r13.getURL()     // Catch:{ Exception -> 0x0c86 }
            if (r13 == 0) goto L_0x0a4e
            java.lang.Object r13 = r12.get(r4)     // Catch:{ Exception -> 0x0c86 }
            net.one97.paytm.common.entity.CJRItem r13 = (net.one97.paytm.common.entity.CJRItem) r13     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r13 = r13.getURL()     // Catch:{ Exception -> 0x0c86 }
            r0.add(r13)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a4e:
            int r4 = r4 + 1
            goto L_0x0a2f
        L_0x0a51:
            java.lang.String r4 = "extra_intent_item_list"
            r11.putExtra(r4, r0)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "extra_intent_item_position"
            r4 = r24
            r11.putExtra(r0, r4)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "From"
            r11.putExtra(r0, r6)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a62:
            java.lang.String r0 = "homepage"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0a89
            java.lang.String r0 = r5.getName()     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r4 = "Paytm Home"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0a89
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r11.setFlags(r0)     // Catch:{ Exception -> 0x0c86 }
            r0 = 805306368(0x30000000, float:4.656613E-10)
            r11.setFlags(r0)     // Catch:{ Exception -> 0x0c86 }
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRCatalogItem     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0a89
            java.lang.String r0 = "launch_home_from_category_menu"
            r11.putExtra(r0, r15)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a89:
            if (r26 == 0) goto L_0x0a90
            java.lang.String r0 = "launched_from_catalog"
            r11.putExtra(r0, r15)     // Catch:{ Exception -> 0x0c86 }
        L_0x0a90:
            boolean r0 = android.text.TextUtils.isEmpty(r27)     // Catch:{ UnsupportedEncodingException -> 0x0aa2 }
            if (r0 != 0) goto L_0x0aae
            java.lang.String r0 = "origin"
            java.lang.String r4 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r6, r4)     // Catch:{ UnsupportedEncodingException -> 0x0aa2 }
            r11.putExtra(r0, r4)     // Catch:{ UnsupportedEncodingException -> 0x0aa2 }
            goto L_0x0aae
        L_0x0aa2:
            r0 = move-exception
            boolean r4 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x0c86 }
            if (r4 == 0) goto L_0x0aae
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0c86 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0aae:
            java.lang.String r0 = "resultant fragment type"
            if (r8 == 0) goto L_0x0abf
            java.lang.String r4 = "mall"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0c86 }
            if (r4 == 0) goto L_0x0abf
            java.lang.String r4 = "mall"
            r11.putExtra(r0, r4)     // Catch:{ Exception -> 0x0c86 }
        L_0x0abf:
            if (r8 == 0) goto L_0x0aca
            boolean r4 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r4 == 0) goto L_0x0aca
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0aca:
            if (r8 == 0) goto L_0x0ad5
            boolean r2 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0c86 }
            if (r2 == 0) goto L_0x0ad5
            r11.putExtra(r0, r9)     // Catch:{ Exception -> 0x0c86 }
        L_0x0ad5:
            if (r8 == 0) goto L_0x0ae0
            boolean r2 = r8.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0c86 }
            if (r2 == 0) goto L_0x0ae0
            r11.putExtra(r0, r10)     // Catch:{ Exception -> 0x0c86 }
        L_0x0ae0:
            if (r8 == 0) goto L_0x0b07
            java.lang.String r2 = "vibe"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r2 == 0) goto L_0x0b07
            java.lang.String r2 = "vibe"
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "category"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r2 = r2.getmVibeCategory()     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "article_id"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r2 = r2.getmVibeArticleId()     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0b07:
            if (r8 == 0) goto L_0x0b40
            java.lang.String r0 = "embed"
            boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b40
            if (r3 == 0) goto L_0x0b40
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b40
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r2 = "automatic"
            if (r0 == 0) goto L_0x0b40
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0c86 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0c86 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x0c86 }
            r0.clearQuery()     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b40
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b40
            android.content.Intent r11 = new android.content.Intent     // Catch:{ Exception -> 0x0c86 }
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity> r0 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity.class
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0b40:
            if (r8 == 0) goto L_0x0b57
            java.lang.String r0 = "wishlist"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b57
            java.lang.String r0 = "need_wishlist_open"
            r11.putExtra(r0, r15)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "wishlist_source"
            java.lang.String r2 = "Account"
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            goto L_0x0b89
        L_0x0b57:
            if (r8 == 0) goto L_0x0b89
            java.lang.String r0 = "signin_profile"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b89
            java.lang.String r0 = "redirectVertical"
            java.lang.String r2 = "login_signup"
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            if (r5 == 0) goto L_0x0b83
            boolean r0 = r5 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b83
            r0 = r5
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.getUtmSource()     // Catch:{ Exception -> 0x0c86 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x0b83
            r0 = r5
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.getUtmSource()     // Catch:{ Exception -> 0x0c86 }
            goto L_0x0b84
        L_0x0b83:
            r0 = 0
        L_0x0b84:
            java.lang.String r2 = "utmsource"
            r11.putExtra(r2, r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0b89:
            if (r8 == 0) goto L_0x0b9f
            java.lang.String r0 = "cst"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0b9f
            java.lang.String r0 = "issueTicketNumber"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r2 = r2.getmTicketId()     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0b9f:
            if (r8 == 0) goto L_0x0bb5
            java.lang.String r0 = "luckylifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0bb5
            java.lang.String r0 = "url"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r2 = r2.getURL()     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0bb5:
            if (r8 == 0) goto L_0x0bec
            java.lang.String r0 = "video"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0bec
            if (r3 == 0) goto L_0x0bec
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0bec
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0c86 }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r2 == 0) goto L_0x0bec
            java.lang.String r2 = com.paytm.utility.b.e((java.lang.String) r0)     // Catch:{ Exception -> 0x0c86 }
            if (r2 != 0) goto L_0x0bdc
            java.lang.String r2 = com.paytm.utility.b.f((java.lang.String) r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0bdc:
            com.paytm.utility.a.c()     // Catch:{ Exception -> 0x0c86 }
            if (r2 == 0) goto L_0x0bec
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x0bec
            java.lang.String r0 = net.one97.paytm.common.utility.b.aA     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0bec:
            if (r8 == 0) goto L_0x0bfd
            r2 = r17
            boolean r0 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0bfd
            java.lang.String r0 = r5.getName()     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r2, r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0bfd:
            if (r8 == 0) goto L_0x0c0c
            java.lang.String r0 = "upi_passbook"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c0c
            java.lang.String r0 = "upi_passbook_tab"
            r11.putExtra(r0, r14)     // Catch:{ Exception -> 0x0c86 }
        L_0x0c0c:
            if (r8 == 0) goto L_0x0c2e
            r2 = r19
            boolean r0 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c2e
            if (r3 == 0) goto L_0x0c2e
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c2e
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = r0.getPushRechargeNumber()     // Catch:{ Exception -> 0x0c86 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r2 != 0) goto L_0x0c2e
            java.lang.String r2 = "mobile"
            r11.putExtra(r2, r0)     // Catch:{ Exception -> 0x0c86 }
        L_0x0c2e:
            if (r8 == 0) goto L_0x0c56
            java.lang.String r0 = "utility"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x0c50
            java.lang.String r0 = "dth"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 != 0) goto L_0x0c50
            java.lang.String r0 = "utility_creditcard"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c56
            java.lang.String r0 = "rechOrdSum"
            boolean r0 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c56
        L_0x0c50:
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0c86 }
            r0.setOrigin(r6)     // Catch:{ Exception -> 0x0c86 }
        L_0x0c56:
            java.lang.String r0 = f69729d     // Catch:{ Exception -> 0x0c86 }
            if (r0 == 0) goto L_0x0c7d
            java.lang.String r0 = "logo_url"
            java.lang.String r2 = f69728c     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "banner_url"
            java.lang.String r2 = f69729d     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "display_title"
            java.lang.String r2 = f69730e     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "badge_url"
            java.lang.String r2 = f69731f     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
            java.lang.String r0 = "child_site_id"
            java.lang.String r2 = f69732g     // Catch:{ Exception -> 0x0c86 }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x0c86 }
        L_0x0c7d:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r11.addFlags(r0)     // Catch:{ Exception -> 0x0c86 }
            r1.startActivity(r11)     // Catch:{ Exception -> 0x0c86 }
            goto L_0x0c92
        L_0x0c86:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x0c92
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0c92:
            r7.stop()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.j.a(android.content.Context, java.lang.String, net.one97.paytm.common.entity.IJRDataModel, java.lang.String, int, java.util.ArrayList, boolean, java.lang.String, net.one97.paytm.c):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(IJRDataModel iJRDataModel, CJRItem cJRItem, Context context) {
        cJRItem.setUrl(a(iJRDataModel, cJRItem.getURL()));
        h.a aVar = h.f50349a;
        h.a.a(context, cJRItem.getURL(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(IJRDataModel iJRDataModel, CJRItem cJRItem, Context context) {
        cJRItem.setUrl(a(iJRDataModel, cJRItem.getURL()));
        h.a aVar = h.f50349a;
        h.a.a(context, cJRItem.getURL(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, CJRItem cJRItem) {
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://" + cJRItem.getURLType(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, CJRItem cJRItem) {
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://" + cJRItem.getURLType(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(CJRHomePageItem cJRHomePageItem, String str, Context context) {
        cJRHomePageItem.setUrl("paytmmp://".concat(String.valueOf(str)));
        h.a aVar = h.f50349a;
        h.a.a(context, cJRHomePageItem.getURL(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, String str) {
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Context context) {
        Intent intent;
        try {
            if (str.equalsIgnoreCase("net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity")) {
                intent = new Intent(context, Class.forName("net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity"));
            } else if (str.equalsIgnoreCase("net.one97.paytm.o2o.movies.activity.MoviesHomeActivity")) {
                intent = new Intent(context, Class.forName("net.one97.paytm.o2o.movies.activity.MoviesHomeActivity"));
            } else {
                intent = new Intent(context, Class.forName("net.one97.paytm.o2o.movies.activity.MoviesHomeActivity"));
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        return a.a() + "min_kyc?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0667 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r20, android.content.Context r21, java.lang.String r22, net.one97.paytm.common.entity.IJRDataModel r23, java.lang.String r24, int r25, java.util.ArrayList<? extends net.one97.paytm.common.entity.CJRItem> r26, boolean r27, java.lang.String r28) {
        /*
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r26
            r6 = r28
            java.lang.String r0 = "ActivityNavigation_loadPageSecondTrace"
            com.google.firebase.perf.metrics.Trace r7 = com.google.firebase.perf.a.a((java.lang.String) r0)
            java.lang.String r8 = "gold-passbook"
            java.lang.String r9 = "gold-sip"
            java.lang.String r10 = "paytmmp://"
            java.lang.String r11 = "gold-gift"
            java.lang.String r13 = "digital-gold"
            java.lang.String r14 = "paytm_finance"
            if (r3 == 0) goto L_0x030e
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.CJRItem     // Catch:{ Exception -> 0x0306 }
            if (r0 == 0) goto L_0x030e
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0     // Catch:{ Exception -> 0x0306 }
            java.lang.String r16 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r16 = a((java.lang.String) r16)     // Catch:{ Exception -> 0x0306 }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0306 }
            if (r16 != 0) goto L_0x003e
            java.lang.String r16 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r16 = a((java.lang.String) r16)     // Catch:{ Exception -> 0x0306 }
            goto L_0x0040
        L_0x003e:
            java.lang.String r16 = ""
        L_0x0040:
            r17 = r16
            boolean r16 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0306 }
            if (r16 == 0) goto L_0x0066
            boolean r16 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x0306 }
            if (r16 != 0) goto L_0x0066
            java.lang.String r12 = "home_upi_request"
            r15 = r17
            boolean r12 = r15.equals(r12)     // Catch:{ Exception -> 0x0306 }
            if (r12 == 0) goto L_0x0066
            net.one97.paytm.deeplink.h$a r12 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            r12 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r12)     // Catch:{ Exception -> 0x0306 }
            r7.stop()
            return
        L_0x0066:
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x007c
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "paytmmp://notification"
            boolean r12 = r12.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x0088
        L_0x007c:
            java.lang.String r12 = "notification"
            java.lang.String r15 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r12 = r12.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0306 }
            if (r12 == 0) goto L_0x008a
        L_0x0088:
            r12 = 1
            goto L_0x008b
        L_0x008a:
            r12 = 0
        L_0x008b:
            if (r12 == 0) goto L_0x009c
            net.one97.paytm.common.b.e r12 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            r12.d(r1, r0)     // Catch:{ Exception -> 0x0306 }
            r7.stop()
            return
        L_0x009c:
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x00de
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "paytmmp"
            boolean r12 = r12.startsWith(r15)     // Catch:{ Exception -> 0x0306 }
            if (r12 == 0) goto L_0x00de
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "cash_wallet"
            boolean r12 = r12.contains(r15)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x00d0
            java.lang.String r12 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            if (r12 == 0) goto L_0x00de
            java.lang.String r12 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "hotel"
            boolean r12 = r12.contains(r15)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x00de
        L_0x00d0:
            net.one97.paytm.deeplink.h$a r12 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            r12 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r12)     // Catch:{ Exception -> 0x0306 }
            r7.stop()
            return
        L_0x00de:
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "movie"
            if (r12 != 0) goto L_0x0123
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = "amusement-parks"
            boolean r5 = r12.contains(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x0123
            net.one97.paytm.dynamicModule.DynamicModuleManager r5 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.isInstalled(r15)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x010c
            r5 = r1
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.utils.-$$Lambda$j$jByt8n3VElcqeXK012j9sbWqkqg r12 = new net.one97.paytm.utils.-$$Lambda$j$jByt8n3VElcqeXK012j9sbWqkqg     // Catch:{ Exception -> 0x0306 }
            r12.<init>(r0, r1)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r5, (java.lang.String) r15, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r12)     // Catch:{ Exception -> 0x0306 }
            goto L_0x011f
        L_0x010c:
            java.lang.String r5 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = a((net.one97.paytm.common.entity.IJRDataModel) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0306 }
            r0.setUrl(r5)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = "paytmmp://amusement"
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
        L_0x011f:
            r7.stop()
            return
        L_0x0123:
            java.lang.String r5 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x0166
            java.lang.String r5 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "events"
            boolean r5 = r5.contains(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x0166
            net.one97.paytm.dynamicModule.DynamicModuleManager r5 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.isInstalled(r15)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x014f
            r5 = r1
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.utils.-$$Lambda$j$to_oGkzQDQsT-FPvE4KVKZtnvvs r12 = new net.one97.paytm.utils.-$$Lambda$j$to_oGkzQDQsT-FPvE4KVKZtnvvs     // Catch:{ Exception -> 0x0306 }
            r12.<init>(r0, r1)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r5, (java.lang.String) r15, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r12)     // Catch:{ Exception -> 0x0306 }
            goto L_0x0162
        L_0x014f:
            java.lang.String r5 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = a((net.one97.paytm.common.entity.IJRDataModel) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0306 }
            r0.setUrl(r5)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = "paytmmp://events"
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
        L_0x0162:
            r7.stop()
            return
        L_0x0166:
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x019e
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "movietickets"
            boolean r5 = r5.contains(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x019e
            net.one97.paytm.dynamicModule.DynamicModuleManager r0 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0306 }
            boolean r0 = r0.isInstalled(r15)     // Catch:{ Exception -> 0x0306 }
            if (r0 != 0) goto L_0x0192
            r0 = r1
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.utils.-$$Lambda$j$IOZfiTRV0iQH5RLV1O9E1L73imw r5 = new net.one97.paytm.utils.-$$Lambda$j$IOZfiTRV0iQH5RLV1O9E1L73imw     // Catch:{ Exception -> 0x0306 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r0, (java.lang.String) r15, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r5)     // Catch:{ Exception -> 0x0306 }
            goto L_0x019a
        L_0x0192:
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = "paytmmp://movietickets"
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
        L_0x019a:
            r7.stop()
            return
        L_0x019e:
            net.one97.paytm.deeplink.aj r5 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = net.one97.paytm.deeplink.aj.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02d2
            net.one97.paytm.deeplink.aj r5 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = net.one97.paytm.deeplink.aj.b((java.lang.String) r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02d2
            net.one97.paytm.deeplink.aj r5 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = net.one97.paytm.deeplink.aj.c(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02d2
            net.one97.paytm.deeplink.aj r5 = net.one97.paytm.deeplink.aj.f50320a     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = net.one97.paytm.deeplink.aj.d(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x01d0
            goto L_0x02d2
        L_0x01d0:
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x01e6
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "Gold"
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
        L_0x01e6:
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "goldweex"
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02a2
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "paytm-postpaid"
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x0228
            goto L_0x02a2
        L_0x0228:
            java.lang.String r5 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x030e
            java.lang.String r5 = "utility"
            java.lang.String r12 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x030e
            java.lang.String r5 = "46006"
            java.lang.String r12 = r0.getCategoryId()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x0256
            java.lang.String r5 = "46007"
            java.lang.String r12 = r0.getCategoryId()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x030e
        L_0x0256:
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = "is_education_h5_enabled"
            r12 = 0
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 == 0) goto L_0x030e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0306 }
            r5.<init>()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0306 }
            if (r12 != 0) goto L_0x0286
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0306 }
            java.lang.String r15 = "?qrCodeParams="
            r12.<init>(r15)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0306 }
            r12.append(r0)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x0306 }
            r5.append(r0)     // Catch:{ Exception -> 0x0306 }
        L_0x0286:
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "paytmmp://edu-open-h5"
            r0.<init>(r12)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0306 }
            r0.append(r5)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0306 }
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
            r7.stop()
            return
        L_0x02a2:
            net.one97.paytm.dynamicModule.DynamicModuleManager r5 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0306 }
            boolean r5 = r5.isInstalled(r14)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02b8
            r5 = r1
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.utils.-$$Lambda$j$aGKDDJz9nhYJG1BrfHwdbZndYLQ r12 = new net.one97.paytm.utils.-$$Lambda$j$aGKDDJz9nhYJG1BrfHwdbZndYLQ     // Catch:{ Exception -> 0x0306 }
            r12.<init>(r1, r0)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r5, (java.lang.String) r14, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r12)     // Catch:{ Exception -> 0x0306 }
            goto L_0x02ce
        L_0x02b8:
            net.one97.paytm.deeplink.h$a r5 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0306 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            r5.append(r0)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0306 }
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
        L_0x02ce:
            r7.stop()
            return
        L_0x02d2:
            net.one97.paytm.dynamicModule.DynamicModuleManager r5 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "flight_dynamic"
            boolean r5 = r5.isInstalled(r12)     // Catch:{ Exception -> 0x0306 }
            if (r5 != 0) goto L_0x02ec
            r5 = r1
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5     // Catch:{ Exception -> 0x0306 }
            java.lang.String r12 = "flight_dynamic"
            net.one97.paytm.utils.-$$Lambda$j$D5oDD3B4JxysSiuI2gnW2sam314 r15 = new net.one97.paytm.utils.-$$Lambda$j$D5oDD3B4JxysSiuI2gnW2sam314     // Catch:{ Exception -> 0x0306 }
            r15.<init>(r1, r0)     // Catch:{ Exception -> 0x0306 }
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r5, (java.lang.String) r12, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r15)     // Catch:{ Exception -> 0x0306 }
            goto L_0x0302
        L_0x02ec:
            net.one97.paytm.deeplink.h$a r5 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0306 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0306 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getURLType()     // Catch:{ Exception -> 0x0306 }
            r5.append(r0)     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0306 }
            r5 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)     // Catch:{ Exception -> 0x0306 }
        L_0x0302:
            r7.stop()
            return
        L_0x0306:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x030e:
            net.one97.paytm.upgradeKyc.f.f r0 = net.one97.paytm.upgradeKyc.f.f.a()
            net.one97.paytm.utils.j$12 r5 = new net.one97.paytm.utils.j$12
            r5.<init>()
            r0.a((android.content.Context) r1, (net.one97.paytm.upgradeKyc.f.f.a) r5)
            java.lang.String r0 = "transaction_detail"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0338
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.CJRItem
            if (r0 == 0) goto L_0x0338
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0
            java.lang.String r0 = r0.getItemID()
            java.lang.String r0 = net.one97.paytm.deeplink.ac.a.a(r0)
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
            r7.stop()
            return
        L_0x0338:
            java.lang.String r0 = "edc_receipt"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0370
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r0 == 0) goto L_0x0370
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r2 = r0.getTxnId()
            java.lang.String r3 = r0.getMid()
            java.lang.String r0 = r0.getAcquirementId()
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity> r5 = net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity.class
            r4.<init>(r1, r5)
            java.lang.String r5 = "tid"
            r4.putExtra(r5, r2)
            java.lang.String r2 = "mid"
            r4.putExtra(r2, r3)
            java.lang.String r2 = "acquirementId"
            r4.putExtra(r2, r0)
            r1.startActivity(r4)
            r7.stop()
            return
        L_0x0370:
            boolean r0 = android.text.TextUtils.isEmpty(r22)
            if (r0 == 0) goto L_0x0393
            android.content.res.Resources r0 = r21.getResources()
            r2 = 2131963372(0x7f132dec, float:1.9563496E38)
            java.lang.String r0 = r0.getString(r2)
            android.content.res.Resources r2 = r21.getResources()
            r3 = 2131959083(0x7f131d2b, float:1.9554796E38)
            java.lang.String r2 = r2.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r2)
            r7.stop()
            return
        L_0x0393:
            java.lang.String r0 = "nolink"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x039f
            r7.stop()
            return
        L_0x039f:
            boolean r5 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r5 == 0) goto L_0x03c5
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r12 = r0.getVerticalid()
            java.lang.String r15 = "66"
            boolean r12 = r15.equals(r12)
            if (r12 == 0) goto L_0x03c5
            java.lang.String r12 = "product"
            boolean r12 = r12.equals(r2)
            if (r12 == 0) goto L_0x03c5
            java.lang.String r0 = r0.getURL()
            net.one97.paytm.marketplace.a.c((java.lang.String) r0)
            r7.stop()
            return
        L_0x03c5:
            r12 = r3
            net.one97.paytm.common.entity.CJRDataModelItem r12 = (net.one97.paytm.common.entity.CJRDataModelItem) r12
            if (r5 == 0) goto L_0x03d2
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r0 = r0.getPushFeatureType()
            goto L_0x03d4
        L_0x03d2:
            java.lang.String r0 = ""
        L_0x03d4:
            r15 = r0
            boolean r0 = com.paytm.utility.b.F((java.lang.String) r22)     // Catch:{ Exception -> 0x040d }
            if (r0 == 0) goto L_0x040a
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRCatalogItem     // Catch:{ Exception -> 0x040d }
            if (r0 == 0) goto L_0x040a
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r0 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r0     // Catch:{ Exception -> 0x040d }
            java.lang.String r0 = r0.getCategoryId()     // Catch:{ Exception -> 0x040d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040d }
            if (r0 == 0) goto L_0x040a
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r0 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r0     // Catch:{ Exception -> 0x040d }
            java.lang.String r0 = net.one97.paytm.utils.l.a((net.one97.paytm.common.entity.CJRItem) r0)     // Catch:{ Exception -> 0x040d }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040d }
            if (r17 != 0) goto L_0x040a
            boolean r17 = android.text.TextUtils.isDigitsOnly(r0)     // Catch:{ Exception -> 0x040d }
            if (r17 == 0) goto L_0x040a
            r17 = r13
            r13 = r12
            net.one97.paytm.common.entity.shopping.CJRCatalogItem r13 = (net.one97.paytm.common.entity.shopping.CJRCatalogItem) r13     // Catch:{ Exception -> 0x0408 }
            r13.setCategoryId(r0)     // Catch:{ Exception -> 0x0408 }
            goto L_0x0417
        L_0x0408:
            r0 = move-exception
            goto L_0x0410
        L_0x040a:
            r17 = r13
            goto L_0x0417
        L_0x040d:
            r0 = move-exception
            r17 = r13
        L_0x0410:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0417:
            if (r5 == 0) goto L_0x0439
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r13 = r0.getDeeplink()
            if (r13 == 0) goto L_0x0439
            java.lang.String r0 = r0.getDeeplink()
            java.lang.String r13 = "inbox/feed"
            boolean r0 = r0.contains(r13)
            if (r0 == 0) goto L_0x0439
            net.one97.paytm.deeplink.m$b r0 = net.one97.paytm.deeplink.m.f50357b
            java.lang.String r1 = "inbox/feed"
            r0.a(r1)
            r7.stop()
            return
        L_0x0439:
            java.lang.String r0 = "homepage"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0450
            java.lang.String r0 = r12.getName()
            java.lang.String r13 = "Paytm Home"
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x0450
            java.lang.String r0 = "homepage_secondary"
            goto L_0x0451
        L_0x0450:
            r0 = r2
        L_0x0451:
            if (r0 == 0) goto L_0x045d
            java.lang.String r2 = "dmrc"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x045d
            java.lang.String r0 = "DMRC"
        L_0x045d:
            java.lang.String r2 = r12.getName()
            if (r2 == 0) goto L_0x0471
            java.lang.String r2 = r12.getName()
            java.lang.String r13 = "Events"
            boolean r2 = r2.equalsIgnoreCase(r13)
            if (r2 == 0) goto L_0x0471
            java.lang.String r0 = "events"
        L_0x0471:
            r13 = r0
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L_0x0486
            java.lang.String r0 = r12.getName()
            java.lang.String r2 = "goldweex"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0486
            r13 = r17
        L_0x0486:
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L_0x049a
            java.lang.String r0 = r12.getName()
            java.lang.String r2 = "gold"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x049a
            r13 = r17
        L_0x049a:
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L_0x04ab
            java.lang.String r0 = r12.getName()
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x04ab
            goto L_0x04ac
        L_0x04ab:
            r9 = r13
        L_0x04ac:
            if (r9 == 0) goto L_0x04b8
            java.lang.String r0 = "gold"
            boolean r0 = r9.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x04b8
            r9 = r17
        L_0x04b8:
            if (r9 == 0) goto L_0x04c1
            boolean r0 = r9.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x04c1
            goto L_0x04c2
        L_0x04c1:
            r8 = r9
        L_0x04c2:
            if (r8 == 0) goto L_0x04cb
            boolean r0 = r8.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x04cb
            r8 = r11
        L_0x04cb:
            java.lang.String r0 = r12.getName()
            java.lang.String r2 = "amusement"
            if (r0 == 0) goto L_0x04de
            java.lang.String r0 = r12.getName()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x04de
            r8 = r2
        L_0x04de:
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L_0x04f1
            java.lang.String r0 = r12.getName()
            java.lang.String r9 = "amusementparks"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x04f1
            r8 = r2
        L_0x04f1:
            java.lang.String r0 = r12.getName()
            java.lang.String r2 = "myprofile"
            if (r0 == 0) goto L_0x0504
            java.lang.String r0 = r12.getName()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0504
            r8 = r2
        L_0x0504:
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L_0x0518
            java.lang.String r0 = r12.getName()
            java.lang.String r9 = "wishlist"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x0518
            java.lang.String r8 = "wishlist"
        L_0x0518:
            java.lang.String r0 = r12.getName()
            java.lang.String r9 = "updates"
            if (r0 == 0) goto L_0x052b
            java.lang.String r0 = r12.getName()
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x052b
            r8 = r9
        L_0x052b:
            java.lang.String r0 = r12.getName()
            java.lang.String r13 = "profile"
            if (r0 == 0) goto L_0x053e
            java.lang.String r0 = r12.getName()
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto L_0x053e
            r8 = r13
        L_0x053e:
            if (r8 == 0) goto L_0x054a
            java.lang.String r0 = "freemovie"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x054a
            java.lang.String r8 = "freemovie"
        L_0x054a:
            if (r8 == 0) goto L_0x0556
            java.lang.String r0 = "giftcards"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0556
            java.lang.String r8 = "giftcards"
        L_0x0556:
            if (r8 == 0) goto L_0x0562
            java.lang.String r0 = "postorder_fb"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0562
            java.lang.String r8 = "postorder_fb"
        L_0x0562:
            if (r8 == 0) goto L_0x056e
            java.lang.String r0 = "cst"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x056e
            java.lang.String r8 = "cst"
        L_0x056e:
            if (r8 == 0) goto L_0x0581
            java.lang.String r0 = "paytm.com"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0581
            if (r5 == 0) goto L_0x0581
            r0 = r12
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r8 = r0.getPushFeatureType()
        L_0x0581:
            if (r8 == 0) goto L_0x058d
            java.lang.String r0 = "video"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x058d
            java.lang.String r8 = "video"
        L_0x058d:
            if (r8 == 0) goto L_0x0599
            java.lang.String r0 = "luckylifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0599
            java.lang.String r8 = "luckylifafa"
        L_0x0599:
            if (r8 == 0) goto L_0x05a5
            java.lang.String r0 = "wallet-pay"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05a5
            java.lang.String r8 = "wallet-pay"
        L_0x05a5:
            if (r8 == 0) goto L_0x05b1
            java.lang.String r0 = "wallet-lifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05b1
            java.lang.String r8 = "wallet-lifafa"
        L_0x05b1:
            if (r8 == 0) goto L_0x05bd
            java.lang.String r0 = "wallet-acceptpayment"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05bd
            java.lang.String r8 = "wallet-acceptpayment"
        L_0x05bd:
            if (r8 == 0) goto L_0x05c9
            java.lang.String r0 = "wallet-addmoney"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05c9
            java.lang.String r8 = "wallet-addmoney"
        L_0x05c9:
            if (r8 == 0) goto L_0x05d5
            java.lang.String r0 = "wallet-nearby"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05d5
            java.lang.String r8 = "wallet-nearby"
        L_0x05d5:
            if (r8 == 0) goto L_0x05e1
            java.lang.String r0 = "wallet-passbook"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05e1
            java.lang.String r8 = "wallet-passbook"
        L_0x05e1:
            if (r8 == 0) goto L_0x05ed
            java.lang.String r0 = "login"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05ed
            java.lang.String r8 = "login"
        L_0x05ed:
            if (r8 == 0) goto L_0x0633
            java.lang.String r0 = "utility"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0633
            if (r5 == 0) goto L_0x0633
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            r18 = r11
            java.lang.String r11 = r0.mUrl
            boolean r11 = com.paytm.utility.b.I((java.lang.String) r11)
            if (r11 == 0) goto L_0x0635
            java.lang.String r2 = "buypayinsurance"
            net.one97.paytm.dynamicModule.DynamicModuleManager r3 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            boolean r3 = r3.isInstalled(r14)
            if (r3 != 0) goto L_0x061e
            r3 = r1
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            net.one97.paytm.utils.-$$Lambda$j$uboI_xXTVqiEItGFhhMTeIh-28o r4 = new net.one97.paytm.utils.-$$Lambda$j$uboI_xXTVqiEItGFhhMTeIh-28o
            r4.<init>(r2, r1)
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r3, (java.lang.String) r14, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r4)
            goto L_0x062f
        L_0x061e:
            java.lang.String r2 = r10.concat(r2)
            r0.setUrl(r2)
            net.one97.paytm.deeplink.h$a r2 = net.one97.paytm.deeplink.h.f50349a
            java.lang.String r0 = r0.getURL()
            r2 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r2)
        L_0x062f:
            r7.stop()
            return
        L_0x0633:
            r18 = r11
        L_0x0635:
            if (r8 == 0) goto L_0x0667
            java.lang.String r0 = "twowheelerins"
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0667
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r10.concat(r0)
            net.one97.paytm.dynamicModule.DynamicModuleManager r2 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            boolean r2 = r2.isInstalled(r14)
            if (r2 != 0) goto L_0x065d
            r2 = r1
            androidx.appcompat.app.AppCompatActivity r2 = (androidx.appcompat.app.AppCompatActivity) r2
            net.one97.paytm.utils.-$$Lambda$j$l3KalYQZo6dyxnzpIIClePs_Mbs r3 = new net.one97.paytm.utils.-$$Lambda$j$l3KalYQZo6dyxnzpIIClePs_Mbs
            r3.<init>(r1, r0)
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r2, (java.lang.String) r14, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r3)
            goto L_0x0663
        L_0x065d:
            net.one97.paytm.deeplink.h$a r2 = net.one97.paytm.deeplink.h.f50349a
            r3 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r0, r3)
        L_0x0663:
            r7.stop()
            return
        L_0x0667:
            if (r5 == 0) goto L_0x067a
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            java.lang.String r0 = r0.getName()
            java.lang.String r10 = "fastag"
            boolean r0 = r10.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x067a
            java.lang.String r8 = "fastag_toll"
        L_0x067a:
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r10 = "cash_wallet"
            boolean r10 = r8.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x06a8
            boolean r10 = android.text.TextUtils.isEmpty(r15)
            if (r10 != 0) goto L_0x06a8
            java.lang.String r10 = "sendmoneymobile"
            boolean r10 = r15.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x06a8
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r15)
            java.lang.String r0 = (java.lang.String) r0
        L_0x06a8:
            java.lang.String r10 = "upi"
            boolean r10 = r8.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x06c2
            boolean r10 = android.text.TextUtils.isEmpty(r15)
            if (r10 != 0) goto L_0x06c2
            net.one97.paytm.utils.b r0 = net.one97.paytm.utils.b.f69703a
            java.util.Map r0 = net.one97.paytm.utils.b.a()
            java.lang.Object r0 = r0.get(r15)
            java.lang.String r0 = (java.lang.String) r0
        L_0x06c2:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r10 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r10.<init>()
            if (r5 == 0) goto L_0x06cd
            r10 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r10 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r10
            goto L_0x06f6
        L_0x06cd:
            boolean r5 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2
            if (r5 == 0) goto L_0x06f6
            r5 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r5 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r5
            r10.setOrigin(r6)
            r10.setUrlType(r8)
            java.lang.String r11 = r5.getImageUrl()
            r10.setImageUrl(r11)
            java.lang.String r11 = r5.getmID()
            r10.setMid(r11)
            java.lang.String r11 = r5.getName()
            r10.setName(r11)
            java.lang.String r5 = r5.getSeeAllUrl()
            r10.setUrl(r5)
        L_0x06f6:
            net.one97.paytm.utils.j$13 r5 = new net.one97.paytm.utils.j$13
            r5.<init>(r10)
            android.os.Bundle r5 = net.one97.paytm.marketplace.a.a((java.util.HashMap<java.lang.String, java.io.Serializable>) r5)
            int r19 = r8.hashCode()
            switch(r19) {
                case -1828469535: goto L_0x077b;
                case -1828465452: goto L_0x0771;
                case -1828460198: goto L_0x0767;
                case -1733036585: goto L_0x075d;
                case -1159865719: goto L_0x0752;
                case -536545217: goto L_0x0747;
                case 4834766: goto L_0x073d;
                case 147595562: goto L_0x0733;
                case 1148336647: goto L_0x0729;
                case 1201768147: goto L_0x071f;
                case 1344931288: goto L_0x0713;
                case 1860402195: goto L_0x0708;
                default: goto L_0x0706;
            }
        L_0x0706:
            goto L_0x0786
        L_0x0708:
            java.lang.String r11 = "wallet-addmoney"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 5
            goto L_0x0787
        L_0x0713:
            java.lang.String r11 = "fastag_toll"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 10
            goto L_0x0787
        L_0x071f:
            java.lang.String r11 = "wallet-nearby"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 4
            goto L_0x0787
        L_0x0729:
            java.lang.String r11 = "wallet-lifafa"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 1
            goto L_0x0787
        L_0x0733:
            java.lang.String r11 = "wallet-acceptpayment"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 2
            goto L_0x0787
        L_0x073d:
            java.lang.String r11 = "wallet-passbook"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 3
            goto L_0x0787
        L_0x0747:
            java.lang.String r11 = "paytmmoney"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 11
            goto L_0x0787
        L_0x0752:
            java.lang.String r11 = "cst_flow"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 9
            goto L_0x0787
        L_0x075d:
            java.lang.String r11 = "wallet-moneytransfer"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 6
            goto L_0x0787
        L_0x0767:
            java.lang.String r11 = "wallet-upi"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 7
            goto L_0x0787
        L_0x0771:
            java.lang.String r11 = "wallet-pay"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 0
            goto L_0x0787
        L_0x077b:
            java.lang.String r11 = "wallet-kyc"
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0786
            r11 = 8
            goto L_0x0787
        L_0x0786:
            r11 = -1
        L_0x0787:
            switch(r11) {
                case 0: goto L_0x099f;
                case 1: goto L_0x0973;
                case 2: goto L_0x096c;
                case 3: goto L_0x0963;
                case 4: goto L_0x095d;
                case 5: goto L_0x094d;
                case 6: goto L_0x08df;
                case 7: goto L_0x089f;
                case 8: goto L_0x0880;
                case 9: goto L_0x07e9;
                case 10: goto L_0x07ca;
                case 11: goto L_0x078d;
                default: goto L_0x078a;
            }
        L_0x078a:
            r11 = 0
            goto L_0x09cd
        L_0x078d:
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0     // Catch:{ Exception -> 0x07ba }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x07ba }
            boolean r2 = com.paytm.utility.v.a((java.lang.String) r0)     // Catch:{ Exception -> 0x07ba }
            if (r2 == 0) goto L_0x079e
            r7.stop()
            return
        L_0x079e:
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x07ba }
            if (r2 != 0) goto L_0x07a8
            r7.stop()
            return
        L_0x07a8:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x07ba }
            java.lang.String r3 = "android.intent.action.VIEW"
            r2.<init>(r3)     // Catch:{ Exception -> 0x07ba }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x07ba }
            r2.setData(r0)     // Catch:{ Exception -> 0x07ba }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x07ba }
            goto L_0x07c6
        L_0x07ba:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x07c6
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x07c6:
            r7.stop()
            return
        L_0x07ca:
            net.one97.paytm.dynamicModule.DynamicModuleManager r0 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            boolean r0 = r0.isInstalled(r14)
            if (r0 != 0) goto L_0x07e0
            r0 = r1
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            net.one97.paytm.utils.-$$Lambda$j$Rnk0l4CnPEcFH2CDFXiefJ1dedM r2 = new net.one97.paytm.utils.-$$Lambda$j$Rnk0l4CnPEcFH2CDFXiefJ1dedM
            r2.<init>(r1)
            net.one97.paytm.dynamicModule.DynamicModuleHelper.loadModuleWithBottomSheet((androidx.appcompat.app.AppCompatActivity) r0, (java.lang.String) r14, (net.one97.paytm.dynamicModule.DynamicModuleLoaderListener) r2)
            goto L_0x07e5
        L_0x07e0:
            java.lang.String r0 = "paytmmp://fastag_toll"
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
        L_0x07e5:
            r7.stop()
            return
        L_0x07e9:
            boolean r0 = com.paytm.utility.a.p(r21)
            if (r0 == 0) goto L_0x0848
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r2 = "from_deep_link"
            r3 = 1
            r0.putBoolean(r2, r3)
            boolean r2 = r12 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r2 == 0) goto L_0x087c
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r12 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r12
            java.lang.String r2 = r12.getVerticalId()
            if (r2 == 0) goto L_0x080f
            java.lang.String r2 = r12.getVerticalId()
            java.lang.String r3 = "verticalId"
            r0.putString(r3, r2)
        L_0x080f:
            java.lang.String r2 = r12.getTrendingId()
            if (r2 == 0) goto L_0x081e
            java.lang.String r2 = r12.getTrendingId()
            java.lang.String r3 = "trendingId"
            r0.putString(r3, r2)
        L_0x081e:
            java.lang.String r2 = r12.getTemplateId()
            if (r2 == 0) goto L_0x082d
            java.lang.String r2 = r12.getTemplateId()
            java.lang.String r3 = "templateId"
            r0.putString(r3, r2)
        L_0x082d:
            java.lang.String r2 = r12.getFeatureType()
            if (r2 == 0) goto L_0x083c
            java.lang.String r2 = r12.getFeatureType()
            java.lang.String r3 = "vertical"
            r0.putString(r3, r2)
        L_0x083c:
            r2 = 67108864(0x4000000, double:3.31561842E-316)
            java.lang.String r4 = "intent_flag"
            r0.putLong(r4, r2)
            net.one97.paytm.deeplink.d.b(r1, r0)
            goto L_0x087c
        L_0x0848:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r0 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r2.<init>(r1, r0)
            java.lang.String r0 = "resultant activity"
            java.lang.String r3 = "net.one97.paytm.cst.cstWidgetization.view.AJRCSTWidgetLanding"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x085b }
            r2.putExtra(r0, r3)     // Catch:{ ClassNotFoundException -> 0x085b }
            goto L_0x0863
        L_0x085b:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0863:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = "extra_home_data"
            r0.putSerializable(r3, r12)
            java.lang.String r3 = "origin"
            java.lang.String r4 = "deeplinking"
            r0.putString(r3, r4)
            java.lang.String r3 = "resultant activity_bundle"
            r2.putExtra(r3, r0)
            r1.startActivity(r2)
        L_0x087c:
            r7.stop()
            return
        L_0x0880:
            boolean r0 = com.paytm.utility.a.p(r21)
            if (r0 == 0) goto L_0x0891
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity> r2 = net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
            goto L_0x089b
        L_0x0891:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.UpgraKycInfoActivity> r2 = net.one97.paytm.upgradeKyc.activity.UpgraKycInfoActivity.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
        L_0x089b:
            r7.stop()
            return
        L_0x089f:
            boolean r0 = com.paytm.utility.a.p(r21)
            if (r0 == 0) goto L_0x08ca
            if (r1 != 0) goto L_0x08ab
            r7.stop()
            return
        L_0x08ab:
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            r0.<init>(r1)
            r2 = 2131961275(0x7f1325bb, float:1.9559242E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setMessage(r2)
            r2 = 1
            r0.setIndeterminate(r2)
            r0.show()
            net.one97.paytm.utils.j$5 r2 = new net.one97.paytm.utils.j$5
            r2.<init>(r0, r1)
            a((net.one97.paytm.upi.registration.b.a.a.C1389a) r2)
            goto L_0x08db
        L_0x08ca:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity> r2 = net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity.class
            r0.<init>(r1, r2)
            java.lang.String r2 = "resultant_activity"
            java.lang.String r3 = "upi"
            r0.putExtra(r2, r3)
            r1.startActivity(r0)
        L_0x08db:
            r7.stop()
            return
        L_0x08df:
            boolean r0 = com.paytm.utility.a.p(r21)
            if (r0 == 0) goto L_0x0938
            if (r1 != 0) goto L_0x08eb
            r7.stop()
            return
        L_0x08eb:
            android.content.Context r0 = r21.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)
            java.lang.String r2 = "is_upi_user"
            r3 = 0
            r4 = 1
            boolean r0 = r0.b((java.lang.String) r2, (boolean) r3, (boolean) r4)
            if (r0 != 0) goto L_0x092d
            boolean r0 = net.one97.paytm.utils.a.b.b(r21)
            if (r0 == 0) goto L_0x0904
            goto L_0x092d
        L_0x0904:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity> r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.class
            r0.<init>(r1, r2)
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r0.setFlags(r2)
            r1.startActivity(r0)
            net.one97.paytm.utils.j$2 r0 = new net.one97.paytm.utils.j$2
            r0.<init>(r1)
            a((net.one97.paytm.upi.registration.b.a.a.C1389a) r0)
            net.one97.paytm.moneytransfer.b.a.b r0 = net.one97.paytm.moneytransfer.b.a(r21)
            net.one97.paytm.utils.j$3 r2 = new net.one97.paytm.utils.j$3
            r2.<init>(r1)
            net.one97.paytm.utils.j$4 r1 = new net.one97.paytm.utils.j$4
            r1.<init>()
            r0.b(r2, r1)
            goto L_0x0949
        L_0x092d:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity> r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.class
            r0.<init>(r1, r2)
            r1.startActivity(r0)
            goto L_0x0949
        L_0x0938:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity> r2 = net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity.class
            r0.<init>(r1, r2)
            java.lang.String r2 = "dest"
            java.lang.String r3 = "money_transfer"
            r0.putExtra(r2, r3)
            r1.startActivity(r0)
        L_0x0949:
            r7.stop()
            return
        L_0x094d:
            net.one97.paytm.wallet.newdesign.a.a()
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
            r11 = 0
            java.lang.String[] r1 = new java.lang.String[r11]
            net.one97.paytm.wallet.newdesign.a.a((android.app.Activity) r0, (java.lang.String[]) r1)
            r7.stop()
            return
        L_0x095d:
            r11 = 0
            java.lang.String r0 = a((java.lang.String) r8, (android.content.Context) r1)
            goto L_0x09cd
        L_0x0963:
            java.lang.String r0 = "paytmmp://cash_wallet?featuretype=cash_ledger"
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)
            r7.stop()
            return
        L_0x096c:
            r11 = 0
            java.lang.String r14 = "paytmmp://accept_payment_onboarding"
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r14)
            goto L_0x09cd
        L_0x0973:
            r11 = 0
            boolean r0 = f69733h
            if (r0 != 0) goto L_0x099a
            int r0 = j
            if (r0 != 0) goto L_0x099a
            boolean r0 = com.paytm.utility.a.p(r21)
            if (r0 == 0) goto L_0x099a
            java.lang.String r0 = "paytmmp://cash_wallet?featuretype=lifafa"
            java.lang.String r2 = "wallet"
            java.lang.String r0 = net.one97.paytm.payments.d.a.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x098e }
            net.one97.paytm.payments.d.a.a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ UnsupportedEncodingException -> 0x098e }
            goto L_0x0996
        L_0x098e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0996:
            r7.stop()
            return
        L_0x099a:
            java.lang.String r0 = a((java.lang.String) r8, (android.content.Context) r1)
            goto L_0x09cd
        L_0x099f:
            net.one97.paytm.wallet.utility.d r0 = net.one97.paytm.wallet.utility.d.f72319a
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
            android.content.Intent r0 = net.one97.paytm.wallet.utility.d.b(r0)
            java.lang.String r2 = "TRIGGER"
            java.lang.String r3 = "PAY_BUTTON"
            r0.putExtra(r2, r3)
            r1.startActivity(r0)
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            java.lang.String r2 = "contact_screen"
            r0.f71397i = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$e r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.e.CONATCT_SCREEN
            r0.j = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.SCAN_QR_TO_PAY_CLICKED
            r0.l = r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.WAlLET_SEND_MONEY
            r0.k = r2
            r0.b((android.content.Context) r1)
            r7.stop()
            return
        L_0x09cd:
            if (r0 != 0) goto L_0x09e2
            boolean r14 = net.one97.paytm.marketplace.a.a((java.lang.String) r8)
            if (r14 == 0) goto L_0x09e2
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a
            java.lang.String r0 = net.one97.paytm.marketplace.a.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r10, (java.lang.String) r8)
            net.one97.paytm.deeplink.h.a.a(r1, r0, r5)
            r7.stop()
            return
        L_0x09e2:
            if (r0 == 0) goto L_0x0d41
            java.lang.String r5 = "external"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0d35 }
            if (r5 == 0) goto L_0x0a21
            r0 = r3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0d35 }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r2 != 0) goto L_0x09fd
            r7.stop()
            return
        L_0x09fd:
            java.lang.String r2 = "browser"
            java.lang.String r3 = "1"
            java.lang.String r0 = com.paytm.utility.c.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x0d35 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r3 = "android.intent.action.VIEW"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0d35 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x0d35 }
            android.content.pm.PackageManager r0 = r21.getPackageManager()     // Catch:{ Exception -> 0x0d35 }
            android.content.ComponentName r0 = r2.resolveActivity(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0a1d
            r1.startActivity(r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a1d:
            r7.stop()
            return
        L_0x0a21:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x0d35 }
            java.lang.Class r10 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0d35 }
            r5.<init>(r1, r10)     // Catch:{ Exception -> 0x0d35 }
            if (r3 == 0) goto L_0x0a3c
            boolean r10 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a3c
            boolean r10 = net.one97.paytm.upi.util.UpiUtils.isInActiveProfileExist(r21)     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a3c
            java.lang.String r10 = "inactive_User"
            r14 = 1
            r5.putExtra(r10, r14)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a3c:
            if (r3 == 0) goto L_0x0a6d
            boolean r10 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a6d
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0d35 }
            if (r10 != 0) goto L_0x0a6d
            java.lang.String r10 = "grid"
            boolean r10 = r8.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a6d
            r10 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r10 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r10     // Catch:{ Exception -> 0x0d35 }
            boolean r10 = r10.isFromReqDelivery()     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a5f
            java.lang.String r10 = "is_from_req_delivery"
            r14 = 1
            r5.putExtra(r10, r14)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a5f:
            r10 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r10 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r10     // Catch:{ Exception -> 0x0d35 }
            net.one97.paytm.common.entity.IJRDataModel r10 = r10.getBuilderModel()     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0a6d
            java.lang.String r14 = "intent_builder_model"
            r5.putExtra(r14, r10)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a6d:
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2> r10 = net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.class
            java.lang.String r10 = r10.getName()     // Catch:{ Exception -> 0x0d35 }
            boolean r0 = r10.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0a7e
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r5.setFlags(r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a7e:
            java.lang.String r0 = "extra_home_data"
            r5.putExtra(r0, r3)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "smart_list"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0a91
            java.lang.String r0 = "smart_list"
            r10 = 1
            r5.putExtra(r0, r10)     // Catch:{ Exception -> 0x0d35 }
        L_0x0a91:
            java.lang.String r0 = "search"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0ac3
            java.lang.String r0 = "deeplinking"
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 != 0) goto L_0x0ab8
            boolean r0 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x0d35 }
            if (r0 != 0) goto L_0x0ab0
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            r10 = r20
            r0.setCategoryId(r10)     // Catch:{ Exception -> 0x0d35 }
            goto L_0x0abd
        L_0x0ab0:
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            r10 = 0
            r0.setCategoryId(r10)     // Catch:{ Exception -> 0x0d35 }
            goto L_0x0abd
        L_0x0ab8:
            java.lang.String r0 = "extra_home_data"
            r5.putExtra(r0, r3)     // Catch:{ Exception -> 0x0d35 }
        L_0x0abd:
            java.lang.String r0 = "is_from_search"
            r10 = 1
            r5.putExtra(r0, r10)     // Catch:{ Exception -> 0x0d35 }
        L_0x0ac3:
            if (r4 == 0) goto L_0x0aca
            java.lang.String r0 = "calling activity"
            r5.putExtra(r0, r4)     // Catch:{ Exception -> 0x0d35 }
        L_0x0aca:
            java.lang.String r0 = "product"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0b0e
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0d35 }
            r0.<init>()     // Catch:{ Exception -> 0x0d35 }
            r4 = r26
            if (r4 == 0) goto L_0x0afd
        L_0x0adb:
            int r10 = r26.size()     // Catch:{ Exception -> 0x0d35 }
            if (r11 >= r10) goto L_0x0afd
            java.lang.Object r10 = r4.get(r11)     // Catch:{ Exception -> 0x0d35 }
            net.one97.paytm.common.entity.CJRItem r10 = (net.one97.paytm.common.entity.CJRItem) r10     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r10 = r10.getURL()     // Catch:{ Exception -> 0x0d35 }
            if (r10 == 0) goto L_0x0afa
            java.lang.Object r10 = r4.get(r11)     // Catch:{ Exception -> 0x0d35 }
            net.one97.paytm.common.entity.CJRItem r10 = (net.one97.paytm.common.entity.CJRItem) r10     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r10 = r10.getURL()     // Catch:{ Exception -> 0x0d35 }
            r0.add(r10)     // Catch:{ Exception -> 0x0d35 }
        L_0x0afa:
            int r11 = r11 + 1
            goto L_0x0adb
        L_0x0afd:
            java.lang.String r4 = "extra_intent_item_list"
            r5.putExtra(r4, r0)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "extra_intent_item_position"
            r4 = r25
            r5.putExtra(r0, r4)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "From"
            r5.putExtra(r0, r6)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b0e:
            java.lang.String r0 = "homepage"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0b36
            java.lang.String r0 = r12.getName()     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r4 = "Paytm Home"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0b36
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r5.setFlags(r0)     // Catch:{ Exception -> 0x0d35 }
            r0 = 805306368(0x30000000, float:4.656613E-10)
            r5.setFlags(r0)     // Catch:{ Exception -> 0x0d35 }
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRCatalogItem     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0b36
            java.lang.String r0 = "launch_home_from_category_menu"
            r4 = 1
            r5.putExtra(r0, r4)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b36:
            if (r27 == 0) goto L_0x0b3e
            java.lang.String r0 = "launched_from_catalog"
            r4 = 1
            r5.putExtra(r0, r4)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b3e:
            boolean r0 = android.text.TextUtils.isEmpty(r28)     // Catch:{ UnsupportedEncodingException -> 0x0b50 }
            if (r0 != 0) goto L_0x0b5c
            java.lang.String r0 = "origin"
            java.lang.String r4 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r6, r4)     // Catch:{ UnsupportedEncodingException -> 0x0b50 }
            r5.putExtra(r0, r4)     // Catch:{ UnsupportedEncodingException -> 0x0b50 }
            goto L_0x0b5c
        L_0x0b50:
            r0 = move-exception
            boolean r4 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x0d35 }
            if (r4 == 0) goto L_0x0b5c
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0d35 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b5c:
            java.lang.String r0 = "resultant fragment type"
            if (r8 == 0) goto L_0x0b6d
            java.lang.String r4 = "mall"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0d35 }
            if (r4 == 0) goto L_0x0b6d
            java.lang.String r4 = "mall"
            r5.putExtra(r0, r4)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b6d:
            if (r8 == 0) goto L_0x0b78
            boolean r4 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r4 == 0) goto L_0x0b78
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b78:
            if (r8 == 0) goto L_0x0b83
            boolean r2 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0d35 }
            if (r2 == 0) goto L_0x0b83
            r5.putExtra(r0, r9)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b83:
            if (r8 == 0) goto L_0x0b8e
            boolean r2 = r8.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0d35 }
            if (r2 == 0) goto L_0x0b8e
            r5.putExtra(r0, r13)     // Catch:{ Exception -> 0x0d35 }
        L_0x0b8e:
            if (r8 == 0) goto L_0x0bb5
            java.lang.String r2 = "vibe"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r2 == 0) goto L_0x0bb5
            java.lang.String r2 = "vibe"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "category"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = r2.getmVibeCategory()     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "article_id"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = r2.getmVibeArticleId()     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0bb5:
            if (r8 == 0) goto L_0x0bee
            java.lang.String r0 = "embed"
            boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0bee
            if (r3 == 0) goto L_0x0bee
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0bee
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = "automatic"
            if (r0 == 0) goto L_0x0bee
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0d35 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0d35 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x0d35 }
            r0.clearQuery()     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0bee
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0bee
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x0d35 }
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity> r0 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity.class
            r5.<init>(r1, r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0bee:
            if (r8 == 0) goto L_0x0c06
            java.lang.String r0 = "wishlist"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c06
            java.lang.String r0 = "need_wishlist_open"
            r2 = 1
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "wishlist_source"
            java.lang.String r2 = "Account"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            goto L_0x0c38
        L_0x0c06:
            if (r8 == 0) goto L_0x0c38
            java.lang.String r0 = "signin_profile"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c38
            java.lang.String r0 = "redirectVertical"
            java.lang.String r2 = "login_signup"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            if (r12 == 0) goto L_0x0c32
            boolean r0 = r12 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c32
            r0 = r12
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.getUtmSource()     // Catch:{ Exception -> 0x0d35 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 != 0) goto L_0x0c32
            r0 = r12
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.getUtmSource()     // Catch:{ Exception -> 0x0d35 }
            goto L_0x0c33
        L_0x0c32:
            r0 = 0
        L_0x0c33:
            java.lang.String r2 = "utmsource"
            r5.putExtra(r2, r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0c38:
            if (r8 == 0) goto L_0x0c4e
            java.lang.String r0 = "cst"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c4e
            java.lang.String r0 = "issueTicketNumber"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = r2.getmTicketId()     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0c4e:
            if (r8 == 0) goto L_0x0c64
            java.lang.String r0 = "luckylifafa"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c64
            java.lang.String r0 = "url"
            r2 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = r2.getURL()     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0c64:
            if (r8 == 0) goto L_0x0c9b
            java.lang.String r0 = "video"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c9b
            if (r3 == 0) goto L_0x0c9b
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0c9b
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.getURL()     // Catch:{ Exception -> 0x0d35 }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r2 == 0) goto L_0x0c9b
            java.lang.String r2 = com.paytm.utility.b.e((java.lang.String) r0)     // Catch:{ Exception -> 0x0d35 }
            if (r2 != 0) goto L_0x0c8b
            java.lang.String r2 = com.paytm.utility.b.f((java.lang.String) r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0c8b:
            com.paytm.utility.a.c()     // Catch:{ Exception -> 0x0d35 }
            if (r2 == 0) goto L_0x0c9b
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r0 != 0) goto L_0x0c9b
            java.lang.String r0 = net.one97.paytm.common.utility.b.aA     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0c9b:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x0d35 }
            r0.<init>()     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = "url_type"
            r0.putString(r2, r8)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = "url"
            r4 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r4     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r4 = r4.getURL()     // Catch:{ Exception -> 0x0d35 }
            r0.putString(r2, r4)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r2 = "origin"
            r0.putString(r2, r6)     // Catch:{ Exception -> 0x0d35 }
            net.one97.paytm.deeplink.h$a r2 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x0d35 }
            r2 = 0
            boolean r0 = net.one97.paytm.deeplink.h.a.a(r1, r2, r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0cc3
            r7.stop()
            return
        L_0x0cc3:
            if (r8 == 0) goto L_0x0cd4
            r2 = r17
            boolean r0 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0cd4
            java.lang.String r0 = r12.getName()     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r2, r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0cd4:
            if (r8 == 0) goto L_0x0ce3
            java.lang.String r0 = "upi_passbook"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0ce3
            java.lang.String r0 = "upi_passbook_tab"
            r5.putExtra(r0, r15)     // Catch:{ Exception -> 0x0d35 }
        L_0x0ce3:
            if (r8 == 0) goto L_0x0d05
            r2 = r18
            boolean r0 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0d05
            if (r3 == 0) goto L_0x0d05
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0d05
            r0 = r3
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = r0.getPushRechargeNumber()     // Catch:{ Exception -> 0x0d35 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0d35 }
            if (r2 != 0) goto L_0x0d05
            java.lang.String r2 = "mobile"
            r5.putExtra(r2, r0)     // Catch:{ Exception -> 0x0d35 }
        L_0x0d05:
            java.lang.String r0 = f69729d     // Catch:{ Exception -> 0x0d35 }
            if (r0 == 0) goto L_0x0d2c
            java.lang.String r0 = "logo_url"
            java.lang.String r2 = f69728c     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "banner_url"
            java.lang.String r2 = f69729d     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "display_title"
            java.lang.String r2 = f69730e     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "badge_url"
            java.lang.String r2 = f69731f     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
            java.lang.String r0 = "child_site_id"
            java.lang.String r2 = f69732g     // Catch:{ Exception -> 0x0d35 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x0d35 }
        L_0x0d2c:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r5.addFlags(r0)     // Catch:{ Exception -> 0x0d35 }
            r1.startActivity(r5)     // Catch:{ Exception -> 0x0d35 }
            goto L_0x0d41
        L_0x0d35:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x0d41
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0d41:
            r7.stop()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.j.a(java.lang.String, android.content.Context, java.lang.String, net.one97.paytm.common.entity.IJRDataModel, java.lang.String, int, java.util.ArrayList, boolean, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(IJRDataModel iJRDataModel, CJRItem cJRItem, Context context) {
        cJRItem.setUrl(a(iJRDataModel, cJRItem.getURL()));
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://amusement", (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(IJRDataModel iJRDataModel, CJRItem cJRItem, Context context) {
        cJRItem.setUrl(a(iJRDataModel, cJRItem.getURL()));
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://events", (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Context context) {
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://movietickets", (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, CJRItem cJRItem) {
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://" + cJRItem.getURLType(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, CJRItem cJRItem) {
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://" + cJRItem.getURLType(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(CJRHomePageItem cJRHomePageItem, String str, Context context) {
        cJRHomePageItem.setUrl("paytmmp://".concat(String.valueOf(str)));
        h.a aVar = h.f50349a;
        h.a.a(context, cJRHomePageItem.getURL(), (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? Uri.parse(str).getHost() : "";
    }

    public static void a() {
        f a2 = f.a();
        a2.f65991a = null;
        a2.f65992b = null;
        f.f65990c = null;
    }

    private static String a(IJRDataModel iJRDataModel, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !str.contains(EventsModuleManager.MODULE_NAME)) {
            str2 = (TextUtils.isEmpty(str) || !str.contains("amusement-parks")) ? "" : "paytmmp://amusement";
        } else {
            str2 = "paytmmp://events";
        }
        try {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) iJRDataModel;
            return (cJRHomePageItem == null || !cJRHomePageItem.isDeepLinking()) ? str2 : cJRHomePageItem.getDeeplink();
        } catch (Exception unused) {
            return str2;
        }
    }

    private static void a(a.C1389a aVar) {
        g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).e(aVar, f69726a, f69727b);
    }

    static /* synthetic */ void a(final Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.please_wait));
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        g.a().a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                ProgressDialog progressDialog = progressDialog;
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (!"success".equalsIgnoreCase(upiProfileModel.getStatus())) {
                        Toast.makeText(context, R.string.some_went_wrong, 1).show();
                    } else if (upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null) {
                        Toast.makeText(context, R.string.some_went_wrong, 1).show();
                    } else {
                        for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                            if (next.isPrimary()) {
                                String virtualAddress = next.getVirtualAddress();
                                UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                                UpiAddBankHelperActivity.a.a(context, virtualAddress);
                                return;
                            }
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                ProgressDialog progressDialog = progressDialog;
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(context, R.string.some_went_wrong, 1).show();
            }
        }, f69726a, "");
    }
}
