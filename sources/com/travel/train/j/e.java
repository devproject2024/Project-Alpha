package com.travel.train.j;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.b.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;

public final class e {
    public static boolean a(Context context) {
        String b2 = w.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2 == null || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String b(Context context) {
        return w.a(context.getApplicationContext()).b("sso_token=", "", true);
    }

    private static void a(String str) {
        b.a();
        w.a(b.b().a()).a("wallet_sso_token=", str, true);
    }

    private static void a(long j) {
        b.a();
        w.a(b.b().a()).a("wallet_token_expire=", j, true);
    }

    private static void b(String str) {
        b.a();
        a a2 = w.a(b.b().a());
        if (str != null) {
            a2.a("resource_owner_id", str, true);
        } else {
            a2.a("resource_owner_id", true);
        }
    }

    public static String a(CJRPGTokenList cJRPGTokenList) {
        boolean z;
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenList.getPGTokenList();
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
