package net.one97.paytm.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.WishList;
import net.one97.paytm.common.entity.shopping.WishListProduct;
import net.one97.paytm.j.c;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<String> f69803a = new ArrayList<>();

    public static void a(final Context context) {
        if (a.p(context)) {
            AnonymousClass1 r3 = new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    WishList wishList;
                    if ((iJRPaytmDataModel instanceof WishList) && (wishList = (WishList) iJRPaytmDataModel) != null) {
                        w.a((ArrayList) wishList.getmProduct());
                        w.b(context);
                    }
                }
            };
            c.a();
            String a2 = c.a("wishList", (String) null);
            if (!TextUtils.isEmpty(a2)) {
                d.a(context, com.paytm.utility.c.b(a2, context), r3, a.a((HashMap<String, String>) new HashMap(), context), (Map<String, String>) null, a.C0715a.GET, (String) null, new WishList(), a.c.MALL, a.b.SILENT).a();
            }
        }
    }

    public static void b(Context context) {
        ag.a(context.getApplicationContext()).a("key_wish_list_response", new f().b(f69803a), true);
    }

    public static void c(Context context) {
        ag.a(context.getApplicationContext()).a("key_wish_list_response", (String) null, true);
    }

    static /* synthetic */ void a(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f69803a.add(((WishListProduct) it2.next()).getProductId());
            }
        }
    }
}
