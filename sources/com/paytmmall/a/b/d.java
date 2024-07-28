package com.paytmmall.a.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity;
import com.paytmmall.artifact.common.b.a.a;
import com.paytmmall.artifact.common.b.a.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider;

public final class d implements PhoenixNavigationClassProvider {
    public final boolean navigateTo(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        char c2 = 0;
        if (activity == null) {
            return false;
        }
        String string = bundle.getString("url_type");
        if (string.equalsIgnoreCase(CLPConstants.WISHLIST)) {
            new a();
            if ("OPEN_WISHLIST".hashCode() != -1941558246) {
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    androidx.localbroadcastmanager.a.a.a(a.b()).a(new Intent("ACTION_UPDATE_WISHLIST"));
                }
            } else if (activity != null) {
                Intent intent = new Intent(activity, AJRShoppingCartActivity.class);
                intent.putExtra("need_wishlist_open", true);
                intent.putExtra("wishlist_source", "Account");
                activity.startActivity(intent);
            }
        } else {
            a aVar = new a();
            HashMap hashMap = new HashMap();
            hashMap.put("seoUrl", "");
            hashMap.put("urlType", string);
            if (System.currentTimeMillis() - aVar.f15660a >= 1000) {
                aVar.f15660a = System.currentTimeMillis();
                b.a((Map<String, String>) hashMap, (Context) activity);
            }
        }
        return true;
    }
}
