package net.one97.paytm.upi.deserializer;

import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.p;
import java.lang.reflect.Type;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;

public class BaseUpiDeserializer implements k<BaseUpiResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final int f66706a;

    public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) throws p {
        return a(lVar, jVar);
    }

    public BaseUpiDeserializer(int i2) {
        this.f66706a = i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c3 A[Catch:{ Exception -> 0x0232 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cc A[Catch:{ Exception -> 0x0232 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.one97.paytm.upi.common.upi.BaseUpiResponse a(com.google.gson.l r11, com.google.gson.j r12) throws com.google.gson.p {
        /*
            r10 = this;
            java.lang.String r0 = "SeqNo"
            java.lang.String r1 = "UserProfile"
            java.lang.String r2 = "UpiTranlogId"
            java.lang.String r3 = "BankRRN"
            java.lang.String r4 = "message"
            java.lang.String r5 = "response"
            java.lang.String r6 = "success"
            com.google.gson.o r11 = r11.h()
            r7 = 0
            r8 = 0
            boolean r9 = r11.a(r6)     // Catch:{ Exception -> 0x0096 }
            if (r9 == 0) goto L_0x0022
            com.google.gson.l r6 = r11.b(r6)     // Catch:{ Exception -> 0x0096 }
            boolean r8 = r6.g()     // Catch:{ Exception -> 0x0096 }
        L_0x0022:
            boolean r6 = r11.a(r5)     // Catch:{ Exception -> 0x0096 }
            if (r6 == 0) goto L_0x0031
            com.google.gson.l r5 = r11.b(r5)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r5 = r5.c()     // Catch:{ Exception -> 0x0096 }
            goto L_0x0032
        L_0x0031:
            r5 = r7
        L_0x0032:
            boolean r6 = r11.a(r4)     // Catch:{ Exception -> 0x0090 }
            if (r6 == 0) goto L_0x0041
            com.google.gson.l r4 = r11.b(r4)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r4 = r4.c()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0042
        L_0x0041:
            r4 = r7
        L_0x0042:
            boolean r6 = r11.a(r3)     // Catch:{ Exception -> 0x008b }
            if (r6 == 0) goto L_0x0051
            com.google.gson.l r3 = r11.b(r3)     // Catch:{ Exception -> 0x008b }
            java.lang.String r3 = r3.c()     // Catch:{ Exception -> 0x008b }
            goto L_0x0052
        L_0x0051:
            r3 = r7
        L_0x0052:
            boolean r6 = r11.a(r2)     // Catch:{ Exception -> 0x0087 }
            if (r6 == 0) goto L_0x0061
            com.google.gson.l r2 = r11.b(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x0087 }
            goto L_0x0062
        L_0x0061:
            r2 = r7
        L_0x0062:
            boolean r6 = r11.a(r1)     // Catch:{ Exception -> 0x0084 }
            if (r6 == 0) goto L_0x0071
            com.google.gson.l r1 = r11.b(r1)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0084 }
            goto L_0x0072
        L_0x0071:
            r1 = r7
        L_0x0072:
            boolean r6 = r11.a(r0)     // Catch:{ Exception -> 0x0082 }
            if (r6 == 0) goto L_0x009f
            com.google.gson.l r0 = r11.b(r0)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0082 }
            r7 = r0
            goto L_0x009f
        L_0x0082:
            r0 = move-exception
            goto L_0x009c
        L_0x0084:
            r0 = move-exception
            r1 = r7
            goto L_0x009c
        L_0x0087:
            r0 = move-exception
            r1 = r7
            r2 = r1
            goto L_0x009c
        L_0x008b:
            r0 = move-exception
            r1 = r7
            r2 = r1
            r3 = r2
            goto L_0x009c
        L_0x0090:
            r0 = move-exception
            r1 = r7
            r2 = r1
            r3 = r2
            r4 = r3
            goto L_0x009c
        L_0x0096:
            r0 = move-exception
            r1 = r7
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x009c:
            r0.printStackTrace()
        L_0x009f:
            net.one97.paytm.upi.common.upi.BaseUpiResponse r0 = new net.one97.paytm.upi.common.upi.BaseUpiResponse
            r0.<init>()
            r0.setSuccess(r8)
            r0.setResponse(r5)
            r0.setMessage(r4)
            r0.setBankRRN(r3)
            r0.setUpiTranlogId(r2)
            r0.setUserProfile(r1)
            r0.setSeqNo(r7)
            java.lang.String r1 = "MobileAppData"
            com.google.gson.l r11 = r11.b(r1)     // Catch:{ Exception -> 0x0232 }
            boolean r1 = r11 instanceof com.google.gson.r     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x00cc
            java.lang.String r11 = r11.c()     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x00cc:
            boolean r1 = r11 instanceof com.google.gson.o     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            int r1 = r10.f66706a     // Catch:{ Exception -> 0x0232 }
            r2 = 10
            java.lang.String r3 = "accounts"
            java.lang.String r4 = "details"
            if (r1 == r2) goto L_0x0208
            r2 = 12
            if (r1 == r2) goto L_0x01ee
            r2 = 17
            if (r1 == r2) goto L_0x01dd
            r2 = 21
            if (r1 == r2) goto L_0x01cc
            r2 = 23
            if (r1 == r2) goto L_0x01b2
            r2 = 25
            if (r1 == r2) goto L_0x01a0
            r2 = 100
            if (r1 == r2) goto L_0x0185
            switch(r1) {
                case 29: goto L_0x0173;
                case 30: goto L_0x0147;
                case 31: goto L_0x0135;
                case 32: goto L_0x0123;
                case 33: goto L_0x00fb;
                default: goto L_0x00f9;
            }
        L_0x00f9:
            goto L_0x0232
        L_0x00fb:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.i r11 = r11.i()     // Catch:{ Exception -> 0x0232 }
            int r1 = r11.a()     // Catch:{ Exception -> 0x0232 }
            if (r1 <= 0) goto L_0x0232
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$8 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$8     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0123:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$7 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$7     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0135:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$4 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$4     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0147:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            boolean r1 = r11.a(r3)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r3)     // Catch:{ Exception -> 0x0232 }
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$2 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$2     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0173:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$6 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$6     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0185:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            java.lang.Class<net.one97.paytm.upi.common.upi.GetProfileResponseDetails$ProfileDetails> r1 = net.one97.paytm.upi.common.upi.GetProfileResponseDetails.ProfileDetails.class
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            net.one97.paytm.upi.common.upi.GetProfileResponseDetails$ProfileDetails r11 = (net.one97.paytm.upi.common.upi.GetProfileResponseDetails.ProfileDetails) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x01a0:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$5 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$5     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x01b2:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            java.lang.Class<net.one97.paytm.upi.common.upi.GetProfileResponseDetails$ProfileDetails> r1 = net.one97.paytm.upi.common.upi.GetProfileResponseDetails.ProfileDetails.class
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            net.one97.paytm.upi.common.upi.GetProfileResponseDetails$ProfileDetails r11 = (net.one97.paytm.upi.common.upi.GetProfileResponseDetails.ProfileDetails) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x01cc:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$9 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$9     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x01dd:
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$3 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$3     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x01ee:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            java.lang.Class<net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProviderDetails> r1 = net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProviderDetails.class
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProviderDetails r11 = (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProviderDetails) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
            goto L_0x0232
        L_0x0208:
            boolean r1 = r11.a(r4)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r4)     // Catch:{ Exception -> 0x0232 }
            com.google.gson.o r11 = r11.h()     // Catch:{ Exception -> 0x0232 }
            boolean r1 = r11.a(r3)     // Catch:{ Exception -> 0x0232 }
            if (r1 == 0) goto L_0x0232
            com.google.gson.l r11 = r11.b(r3)     // Catch:{ Exception -> 0x0232 }
            net.one97.paytm.upi.deserializer.BaseUpiDeserializer$1 r1 = new net.one97.paytm.upi.deserializer.BaseUpiDeserializer$1     // Catch:{ Exception -> 0x0232 }
            r1.<init>()     // Catch:{ Exception -> 0x0232 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0232 }
            java.lang.Object r11 = r12.a(r11, r1)     // Catch:{ Exception -> 0x0232 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0232 }
            r0.setMobileAppData(r11)     // Catch:{ Exception -> 0x0232 }
        L_0x0232:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.deserializer.BaseUpiDeserializer.a(com.google.gson.l, com.google.gson.j):net.one97.paytm.upi.common.upi.BaseUpiResponse");
    }
}
