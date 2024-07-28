package com.travel.sale;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.travel.d;
import com.travel.sale.data.model.CampaignDetailsResponse;
import com.travel.utils.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public class e extends h {

    /* renamed from: a  reason: collision with root package name */
    c f25752a;

    /* renamed from: b  reason: collision with root package name */
    final int f25753b = 3;

    /* renamed from: c  reason: collision with root package name */
    CampaignDetailsResponse f25754c;

    /* renamed from: d  reason: collision with root package name */
    final int f25755d = 101;

    /* renamed from: e  reason: collision with root package name */
    final int f25756e = 102;

    /* renamed from: f  reason: collision with root package name */
    final int f25757f = 103;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f25758g;

    public void f() {
        HashMap hashMap = this.f25758g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        q.a(activity != null ? activity.getApplicationContext() : null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.o<java.lang.String, java.lang.String> a(java.lang.Integer r9, com.paytm.network.model.IJRPaytmDataModel r10, com.paytm.network.model.NetworkCustomError r11) {
        /*
            r8 = this;
            com.travel.sale.data.model.TCErrorFormat r0 = new com.travel.sale.data.model.TCErrorFormat
            r0.<init>()
            r1 = 0
            if (r11 == 0) goto L_0x000b
            com.paytm.network.model.NetworkResponse r2 = r11.networkResponse
            goto L_0x000c
        L_0x000b:
            r2 = r1
        L_0x000c:
            if (r2 == 0) goto L_0x0040
            if (r11 == 0) goto L_0x0013
            com.paytm.network.model.NetworkResponse r2 = r11.networkResponse
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            byte[] r3 = r2.data
            if (r3 == 0) goto L_0x0040
            byte[] r2 = r2.data     // Catch:{ Exception -> 0x003c }
            java.lang.String r3 = "response.data"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x003c }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x003c }
            java.nio.charset.Charset r4 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x003c }
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x003c }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x003c }
            r2.<init>()     // Catch:{ Exception -> 0x003c }
            java.lang.Class r4 = r0.getClass()     // Catch:{ Exception -> 0x003c }
            java.lang.Object r2 = r2.a((java.lang.String) r3, r4)     // Catch:{ Exception -> 0x003c }
            java.lang.String r3 = "Gson().fromJson(jsonStri…cjrErrorFormat.javaClass)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x003c }
            com.travel.sale.data.model.TCErrorFormat r2 = (com.travel.sale.data.model.TCErrorFormat) r2     // Catch:{ Exception -> 0x003c }
            r0 = r2
            goto L_0x0040
        L_0x003c:
            r2 = move-exception
            r2.getMessage()
        L_0x0040:
            java.lang.String r2 = ""
            r3 = 0
            if (r9 != 0) goto L_0x0046
            goto L_0x004e
        L_0x0046:
            int r4 = r9.intValue()
            r5 = 401(0x191, float:5.62E-43)
            if (r4 == r5) goto L_0x0371
        L_0x004e:
            if (r9 != 0) goto L_0x0051
            goto L_0x0059
        L_0x0051:
            int r4 = r9.intValue()
            r5 = 410(0x19a, float:5.75E-43)
            if (r4 == r5) goto L_0x0371
        L_0x0059:
            if (r9 != 0) goto L_0x005c
            goto L_0x0066
        L_0x005c:
            int r4 = r9.intValue()
            r5 = 403(0x193, float:5.65E-43)
            if (r4 != r5) goto L_0x0066
            goto L_0x0371
        L_0x0066:
            r4 = 1
            if (r9 != 0) goto L_0x006a
            goto L_0x0072
        L_0x006a:
            int r5 = r9.intValue()
            r6 = 449(0x1c1, float:6.29E-43)
            if (r5 == r6) goto L_0x0325
        L_0x0072:
            if (r9 != 0) goto L_0x0075
            goto L_0x007d
        L_0x0075:
            int r5 = r9.intValue()
            r6 = 499(0x1f3, float:6.99E-43)
            if (r5 == r6) goto L_0x0325
        L_0x007d:
            if (r9 != 0) goto L_0x0080
            goto L_0x0088
        L_0x0080:
            int r5 = r9.intValue()
            r6 = 502(0x1f6, float:7.03E-43)
            if (r5 == r6) goto L_0x0325
        L_0x0088:
            if (r9 != 0) goto L_0x008b
            goto L_0x0093
        L_0x008b:
            int r5 = r9.intValue()
            r6 = 503(0x1f7, float:7.05E-43)
            if (r5 == r6) goto L_0x0325
        L_0x0093:
            if (r9 != 0) goto L_0x0096
            goto L_0x00a0
        L_0x0096:
            int r9 = r9.intValue()
            r5 = 504(0x1f8, float:7.06E-43)
            if (r9 != r5) goto L_0x00a0
            goto L_0x0325
        L_0x00a0:
            if (r0 == 0) goto L_0x010e
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r9 = r0.getStatus()
            if (r9 == 0) goto L_0x010e
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r9 = r0.getStatus()
            com.travel.sale.data.model.TCErrorFormat$CJRMessageFormat r9 = r9.getMessage()
            if (r9 == 0) goto L_0x010e
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r9 = r0.getStatus()
            com.travel.sale.data.model.TCErrorFormat$CJRMessageFormat r9 = r9.getMessage()
            java.lang.String r9 = r9.getTitle()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x00cb
            int r9 = r9.length()
            if (r9 != 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r9 = 0
            goto L_0x00cc
        L_0x00cb:
            r9 = 1
        L_0x00cc:
            if (r9 != 0) goto L_0x00e0
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r9 = r0.getStatus()
            com.travel.sale.data.model.TCErrorFormat$CJRMessageFormat r9 = r9.getMessage()
            java.lang.String r9 = r9.getTitle()
            java.lang.String r10 = "cjrErrorFormat.getStatus().getMessage().getTitle()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            goto L_0x00e1
        L_0x00e0:
            r9 = r2
        L_0x00e1:
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r10 = r0.getStatus()
            com.travel.sale.data.model.TCErrorFormat$CJRMessageFormat r10 = r10.getMessage()
            java.lang.String r10 = r10.getMessage()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x00f7
            int r10 = r10.length()
            if (r10 != 0) goto L_0x00f8
        L_0x00f7:
            r3 = 1
        L_0x00f8:
            if (r3 != 0) goto L_0x036d
            com.travel.sale.data.model.TCErrorFormat$TCErrorStatus r10 = r0.getStatus()
            com.travel.sale.data.model.TCErrorFormat$CJRMessageFormat r10 = r10.getMessage()
            java.lang.String r10 = r10.getMessage()
            java.lang.String r11 = "cjrErrorFormat.getStatus…getMessage().getMessage()"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            r2 = r10
            goto L_0x036d
        L_0x010e:
            if (r11 == 0) goto L_0x0115
            java.lang.String r9 = r11.getMessage()
            goto L_0x0116
        L_0x0115:
            r9 = r1
        L_0x0116:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x017b
            if (r11 == 0) goto L_0x0125
            java.lang.String r9 = r11.getAlertTitle()
            goto L_0x0126
        L_0x0125:
            r9 = r1
        L_0x0126:
            if (r9 == 0) goto L_0x017b
            if (r11 == 0) goto L_0x012f
            java.lang.String r9 = r11.getAlertMessage()
            goto L_0x0130
        L_0x012f:
            r9 = r1
        L_0x0130:
            if (r9 == 0) goto L_0x017b
            if (r11 == 0) goto L_0x0139
            java.lang.String r9 = r11.getAlertTitle()
            goto L_0x013a
        L_0x0139:
            r9 = r1
        L_0x013a:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0147
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0145
            goto L_0x0147
        L_0x0145:
            r9 = 0
            goto L_0x0148
        L_0x0147:
            r9 = 1
        L_0x0148:
            if (r9 != 0) goto L_0x0158
            if (r11 == 0) goto L_0x0151
            java.lang.String r9 = r11.getAlertTitle()
            goto L_0x0152
        L_0x0151:
            r9 = r1
        L_0x0152:
            java.lang.String r10 = "networkCustomError?.getAlertTitle()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            goto L_0x0159
        L_0x0158:
            r9 = r2
        L_0x0159:
            if (r11 == 0) goto L_0x0160
            java.lang.String r10 = r11.getAlertMessage()
            goto L_0x0161
        L_0x0160:
            r10 = r1
        L_0x0161:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x016b
            int r10 = r10.length()
            if (r10 != 0) goto L_0x016c
        L_0x016b:
            r3 = 1
        L_0x016c:
            if (r3 != 0) goto L_0x036d
            if (r11 == 0) goto L_0x0174
            java.lang.String r1 = r11.getAlertMessage()
        L_0x0174:
            java.lang.String r10 = "networkCustomError?.getAlertMessage()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r10)
            goto L_0x036c
        L_0x017b:
            if (r11 == 0) goto L_0x0182
            java.lang.String r9 = r11.getMessage()
            goto L_0x0183
        L_0x0182:
            r9 = r1
        L_0x0183:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r0 = "getResources().getString…ng.network_error_heading)"
            if (r9 != 0) goto L_0x01ec
            if (r11 == 0) goto L_0x0194
            com.paytm.network.model.NetworkCustomError$ErrorType r9 = r11.getErrorType()
            goto L_0x0195
        L_0x0194:
            r9 = r1
        L_0x0195:
            com.paytm.network.model.NetworkCustomError$ErrorType r10 = com.paytm.network.model.NetworkCustomError.ErrorType.ParsingError
            if (r9 != r10) goto L_0x01b9
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.error
            java.lang.String r2 = r9.getString(r10)
            java.lang.String r9 = "getResources().getString(R.string.error)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.general_error
            java.lang.String r9 = r9.getString(r10)
            java.lang.String r10 = "getResources().getString(R.string.general_error)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            goto L_0x039f
        L_0x01b9:
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.network_error_heading
            java.lang.String r2 = r9.getString(r10)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            android.content.res.Resources r10 = r8.getResources()
            int r0 = com.travel.R.string.network_error_message
            java.lang.String r10 = r10.getString(r0)
            r9.append(r10)
            java.lang.String r10 = " "
            r9.append(r10)
            if (r11 == 0) goto L_0x01e3
            java.lang.String r1 = r11.getUrl()
        L_0x01e3:
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            goto L_0x039f
        L_0x01ec:
            if (r10 == 0) goto L_0x0307
            boolean r9 = r10 instanceof com.travel.sale.data.model.CampaignSubscriptionResponse
            if (r9 == 0) goto L_0x025e
            com.travel.sale.data.model.CampaignSubscriptionResponse r10 = (com.travel.sale.data.model.CampaignSubscriptionResponse) r10
            com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r9 = r10.getBody()
            if (r9 == 0) goto L_0x01ff
            java.lang.String r9 = r9.getError()
            goto L_0x0200
        L_0x01ff:
            r9 = r1
        L_0x0200:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x020d
            int r9 = r9.length()
            if (r9 != 0) goto L_0x020b
            goto L_0x020d
        L_0x020b:
            r9 = 0
            goto L_0x020e
        L_0x020d:
            r9 = 1
        L_0x020e:
            if (r9 != 0) goto L_0x021d
            com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r9 = r10.getBody()
            if (r9 == 0) goto L_0x021a
            java.lang.String r1 = r9.getError()
        L_0x021a:
            r2 = r1
            goto L_0x02cb
        L_0x021d:
            com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r9 = r10.getBody()
            if (r9 == 0) goto L_0x0228
            java.lang.String r9 = r9.getMessage()
            goto L_0x0229
        L_0x0228:
            r9 = r1
        L_0x0229:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0236
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0234
            goto L_0x0236
        L_0x0234:
            r9 = 0
            goto L_0x0237
        L_0x0236:
            r9 = 1
        L_0x0237:
            if (r9 != 0) goto L_0x0244
            com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r9 = r10.getBody()
            if (r9 == 0) goto L_0x021a
            java.lang.String r1 = r9.getMessage()
            goto L_0x021a
        L_0x0244:
            java.lang.String r9 = r10.getMessage()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0255
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r9 = 0
            goto L_0x0256
        L_0x0255:
            r9 = 1
        L_0x0256:
            if (r9 != 0) goto L_0x02cb
            java.lang.String r2 = r10.getMessage()
            goto L_0x02cb
        L_0x025e:
            boolean r9 = r10 instanceof com.travel.sale.data.model.CampaignDetailsResponse
            if (r9 == 0) goto L_0x02cb
            com.travel.sale.data.model.CampaignDetailsResponse r10 = (com.travel.sale.data.model.CampaignDetailsResponse) r10
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r9 = r10.getBody()
            if (r9 == 0) goto L_0x026f
            java.lang.String r9 = r9.getError()
            goto L_0x0270
        L_0x026f:
            r9 = r1
        L_0x0270:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x027d
            int r9 = r9.length()
            if (r9 != 0) goto L_0x027b
            goto L_0x027d
        L_0x027b:
            r9 = 0
            goto L_0x027e
        L_0x027d:
            r9 = 1
        L_0x027e:
            if (r9 != 0) goto L_0x028b
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r9 = r10.getBody()
            if (r9 == 0) goto L_0x021a
            java.lang.String r1 = r9.getError()
            goto L_0x021a
        L_0x028b:
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r9 = r10.getBody()
            if (r9 == 0) goto L_0x0296
            java.lang.String r9 = r9.getMessage()
            goto L_0x0297
        L_0x0296:
            r9 = r1
        L_0x0297:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x02a4
            int r9 = r9.length()
            if (r9 != 0) goto L_0x02a2
            goto L_0x02a4
        L_0x02a2:
            r9 = 0
            goto L_0x02a5
        L_0x02a4:
            r9 = 1
        L_0x02a5:
            if (r9 != 0) goto L_0x02b3
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r9 = r10.getBody()
            if (r9 == 0) goto L_0x021a
            java.lang.String r1 = r9.getMessage()
            goto L_0x021a
        L_0x02b3:
            java.lang.String r9 = r10.getMessage()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x02c4
            int r9 = r9.length()
            if (r9 != 0) goto L_0x02c2
            goto L_0x02c4
        L_0x02c2:
            r9 = 0
            goto L_0x02c5
        L_0x02c4:
            r9 = 1
        L_0x02c5:
            if (r9 != 0) goto L_0x02cb
            java.lang.String r2 = r10.getMessage()
        L_0x02cb:
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x02d6
            int r9 = r9.length()
            if (r9 != 0) goto L_0x02d7
        L_0x02d6:
            r3 = 1
        L_0x02d7:
            if (r3 != 0) goto L_0x02da
            goto L_0x02e9
        L_0x02da:
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.general_error
            java.lang.String r2 = r9.getString(r10)
            if (r2 != 0) goto L_0x02e9
            kotlin.g.b.k.a()
        L_0x02e9:
            kotlin.o r9 = new kotlin.o
            android.content.res.Resources r10 = r8.getResources()
            int r11 = com.travel.R.string.error
            java.lang.String r10 = r10.getString(r11)
            r9.<init>(r10, r2)
            java.lang.Object r10 = r9.getFirst()
            r2 = r10
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r9 = r9.getSecond()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x039f
        L_0x0307:
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.network_error_heading
            java.lang.String r2 = r9.getString(r10)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            android.content.res.Resources r9 = r8.getResources()
            int r10 = com.travel.R.string.network_error_message
            java.lang.String r9 = r9.getString(r10)
            java.lang.String r10 = "getResources().getString…ng.network_error_message)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            goto L_0x039f
        L_0x0325:
            if (r11 == 0) goto L_0x032c
            java.lang.String r9 = r11.getAlertTitle()
            goto L_0x032d
        L_0x032c:
            r9 = r1
        L_0x032d:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x033a
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0338
            goto L_0x033a
        L_0x0338:
            r9 = 0
            goto L_0x033b
        L_0x033a:
            r9 = 1
        L_0x033b:
            if (r9 != 0) goto L_0x034b
            if (r11 == 0) goto L_0x0344
            java.lang.String r9 = r11.getAlertTitle()
            goto L_0x0345
        L_0x0344:
            r9 = r1
        L_0x0345:
            if (r9 != 0) goto L_0x034c
            kotlin.g.b.k.a()
            goto L_0x034c
        L_0x034b:
            r9 = r2
        L_0x034c:
            if (r11 == 0) goto L_0x0353
            java.lang.String r10 = r11.getAlertMessage()
            goto L_0x0354
        L_0x0353:
            r10 = r1
        L_0x0354:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x035e
            int r10 = r10.length()
            if (r10 != 0) goto L_0x035f
        L_0x035e:
            r3 = 1
        L_0x035f:
            if (r3 != 0) goto L_0x036d
            if (r11 == 0) goto L_0x0367
            java.lang.String r1 = r11.getAlertMessage()
        L_0x0367:
            if (r1 != 0) goto L_0x036c
            kotlin.g.b.k.a()
        L_0x036c:
            r2 = r1
        L_0x036d:
            r7 = r2
            r2 = r9
            r9 = r7
            goto L_0x039f
        L_0x0371:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x039e
            boolean r9 = r8.isDetached()
            if (r9 != 0) goto L_0x039e
            com.travel.d r9 = com.travel.d.a()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r10 = "TravelController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x0396 }
            com.travel.common.b r9 = com.travel.d.b()     // Catch:{ Exception -> 0x0396 }
            androidx.fragment.app.FragmentActivity r10 = r8.getActivity()     // Catch:{ Exception -> 0x0396 }
            android.app.Activity r10 = (android.app.Activity) r10     // Catch:{ Exception -> 0x0396 }
            java.lang.Exception r11 = (java.lang.Exception) r11     // Catch:{ Exception -> 0x0396 }
            r9.a((android.app.Activity) r10, (java.lang.Exception) r11, (boolean) r3)     // Catch:{ Exception -> 0x0396 }
            goto L_0x039e
        L_0x0396:
            r9 = move-exception
            boolean r10 = com.paytm.utility.b.v
            if (r10 == 0) goto L_0x039e
            r9.printStackTrace()
        L_0x039e:
            r9 = r2
        L_0x039f:
            kotlin.o r10 = new kotlin.o
            r10.<init>(r2, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.e.a(java.lang.Integer, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):kotlin.o");
    }

    public final void a(int i2) {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        k.a((Object) d.a(), "TravelController.getInstance()");
        d.b().a(getContext(), intent, i2);
    }
}
