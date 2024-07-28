package com.travel.bus.busticket.i;

import android.content.Context;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.b.a;
import com.travel.bus.pojo.busticket.CJRBusPGTokenList;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPGToken;

public final class p {
    public static String a(Context context) {
        return a.a(context.getApplicationContext()).b("sso_token=", "", true);
    }

    public static void a(String str) {
        com.travel.bus.a.a();
        a.a(com.travel.bus.a.b().D()).a("wallet_sso_token=", str, true);
    }

    public static void a(long j) {
        com.travel.bus.a.a();
        a.a(com.travel.bus.a.b().D()).a("wallet_token_expire=", j, true);
    }

    public static void b(String str) {
        com.travel.bus.a.a();
        a.a(com.travel.bus.a.b().D()).a("resource_owner_id", str, true);
    }

    public static String a(CJRBusPGTokenList cJRBusPGTokenList) {
        boolean z;
        ArrayList<CJRPGToken> pGTokenList = cJRBusPGTokenList.getPGTokenList();
        String str = null;
        if (pGTokenList == null) {
            return null;
        }
        int size = pGTokenList.size();
        long j = 0;
        String str2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            CJRPGToken cJRPGToken = pGTokenList.get(i2);
            String[] split = cJRPGToken.getScopes().split(AppConstants.COMMA);
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (!TextUtils.isEmpty(split[i3]) && split[i3].equalsIgnoreCase("wallet")) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                str = cJRPGToken.getToken();
                j = cJRPGToken.getExpires();
                break;
            }
            if (str2 == null) {
                str2 = cJRPGToken.getResourceOwnerId();
            }
            i2++;
        }
        a(j);
        a(str);
        b(str2);
        return str;
    }
}
