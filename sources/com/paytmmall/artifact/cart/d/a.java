package com.paytmmall.artifact.cart.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.cart.entity.WishList;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.g;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.u;
import com.paytmmall.artifact.d.v;
import com.paytmmall.b.a;
import com.paytmmall.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<String> f15519a = new ArrayList<>();

    public static boolean a(Context context, String str) {
        if (!d.d(context)) {
            return false;
        }
        ArrayList<String> c2 = c(context);
        if (c2 != null) {
            f15519a = c2;
        }
        if (!f15519a.isEmpty() && f15519a.contains(str)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, WishList wishList) {
        if (wishList != null) {
            ArrayList<WishListProduct> arrayList = wishList.getmProduct();
            if (arrayList != null && !arrayList.isEmpty()) {
                androidx.localbroadcastmanager.a.a.a(context).a(new Intent(CLPConstants.ACTION_UPDATE_CLP));
                Iterator<WishListProduct> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f15519a.clear();
                    f15519a.add(it2.next().getProductId());
                }
            }
            a(context);
        }
    }

    public static void b(Context context, String str) {
        ArrayList<String> arrayList = f15519a;
        if (arrayList != null && !arrayList.contains(str)) {
            f15519a.add(str);
            a(context);
        }
    }

    public static void c(Context context, String str) {
        ArrayList<String> arrayList = f15519a;
        if (arrayList != null && !arrayList.isEmpty() && f15519a.contains(str)) {
            f15519a.remove(str);
            a(context);
        }
    }

    public static void a(Context context) {
        u.a(context.getApplicationContext()).a("key_wish_list_response", new f().a((Object) f15519a), true);
    }

    private static ArrayList<String> c(Context context) {
        String b2 = u.a(context.getApplicationContext()).b("key_wish_list_response", "", true);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            return new ArrayList<>(Arrays.asList((Object[]) new f().a(b2, String[].class)));
        } catch (Exception e2) {
            s.a(e2);
            return null;
        }
    }

    public static void b(final Context context) {
        com.paytmmall.artifact.common.a.a.a();
        String a2 = com.paytmmall.artifact.common.a.a.a("wishList", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            Context context2 = context;
            com.paytmmall.b.a.a(context2, a.C0216a.GET, g.b(a2, context), (String) null, d.a((HashMap<String, String>) new HashMap(), context), new StringModel(), new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    StringModel stringModel = (StringModel) iJRPaytmDataModel;
                    if (!TextUtils.isEmpty(stringModel.getData())) {
                        v.a().b(context, stringModel.getData());
                        a.a(context);
                    }
                }
            });
        }
    }
}
