package com.paytm.android.chat;

import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.sendbird.android.BaseChannel;

public final class g {
    public static final ChannelMetaData a(BaseChannel baseChannel) {
        try {
            return (ChannelMetaData) new f().a(baseChannel != null ? baseChannel.getData() : null, ChannelMetaData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a A[Catch:{ Exception -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[Catch:{ Exception -> 0x0091 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.android.chat.bean.UserMetaData a(com.sendbird.android.User r6) {
        /*
            java.lang.String r0 = "l"
            r1 = 0
            if (r6 == 0) goto L_0x0092
            java.lang.String r2 = "info_1"
            java.lang.String r2 = r6.getMetaData(r2)     // Catch:{ Exception -> 0x0041 }
            if (r2 == 0) goto L_0x0041
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0041 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0041 }
            com.paytm.android.chat.bean.UserMetaData r2 = new com.paytm.android.chat.bean.UserMetaData     // Catch:{ Exception -> 0x0041 }
            r2.<init>()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = "n"
            java.lang.String r4 = r3.optString(r4, r1)     // Catch:{ Exception -> 0x0042 }
            r2.setName(r4)     // Catch:{ Exception -> 0x0042 }
            com.paytm.android.chat.bean.UserType$Companion r4 = com.paytm.android.chat.bean.UserType.Companion     // Catch:{ Exception -> 0x0042 }
            java.lang.String r5 = "t"
            java.lang.String r5 = r3.optString(r5, r1)     // Catch:{ Exception -> 0x0042 }
            com.paytm.android.chat.bean.UserType r4 = r4.fromString(r5)     // Catch:{ Exception -> 0x0042 }
            r2.setUserType(r4)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r4 = r3.optString(r0, r1)     // Catch:{ Exception -> 0x0042 }
            r2.setLocationString(r4)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r4 = "id"
            java.lang.String r3 = r3.optString(r4, r1)     // Catch:{ Exception -> 0x0042 }
            r2.setPaytmChannelId(r3)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0042
        L_0x0041:
            r2 = r1
        L_0x0042:
            java.lang.String r3 = "info_2"
            java.lang.String r3 = r6.getMetaData(r3)     // Catch:{ Exception -> 0x0060 }
            if (r3 == 0) goto L_0x0060
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0060 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0060 }
            if (r2 != 0) goto L_0x0057
            com.paytm.android.chat.bean.UserMetaData r3 = new com.paytm.android.chat.bean.UserMetaData     // Catch:{ Exception -> 0x0060 }
            r3.<init>()     // Catch:{ Exception -> 0x0060 }
            r2 = r3
        L_0x0057:
            if (r2 == 0) goto L_0x0060
            java.lang.String r0 = r4.optString(r0, r1)     // Catch:{ Exception -> 0x0060 }
            r2.setLogoUrl(r0)     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            java.lang.String r0 = "info_3"
            java.lang.String r6 = r6.getMetaData(r0)     // Catch:{ Exception -> 0x0091 }
            if (r6 == 0) goto L_0x0091
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0091 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0091 }
            if (r2 != 0) goto L_0x0075
            com.paytm.android.chat.bean.UserMetaData r6 = new com.paytm.android.chat.bean.UserMetaData     // Catch:{ Exception -> 0x0091 }
            r6.<init>()     // Catch:{ Exception -> 0x0091 }
            r2 = r6
        L_0x0075:
            if (r2 == 0) goto L_0x0080
            java.lang.String r6 = "a"
            java.lang.String r6 = r0.optString(r6, r1)     // Catch:{ Exception -> 0x0091 }
            r2.setAddressString(r6)     // Catch:{ Exception -> 0x0091 }
        L_0x0080:
            if (r2 == 0) goto L_0x0091
            com.paytm.android.chat.bean.RegistrationStatus$Companion r6 = com.paytm.android.chat.bean.RegistrationStatus.Companion     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = "rs"
            java.lang.String r0 = r0.optString(r3, r1)     // Catch:{ Exception -> 0x0091 }
            com.paytm.android.chat.bean.RegistrationStatus r6 = r6.fromString(r0)     // Catch:{ Exception -> 0x0091 }
            r2.setRegistrationStatus(r6)     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            return r2
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.g.a(com.sendbird.android.User):com.paytm.android.chat.bean.UserMetaData");
    }
}
