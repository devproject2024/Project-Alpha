package com.paytmmall.artifact.d;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.f;
import com.google.gsonhtcfix.c.a;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import com.paytmmall.a.a.c;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import com.paytmmall.artifact.cart.entity.CJRCart;
import com.paytmmall.artifact.cart.entity.CJRLocation;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.cart.entity.WishList;
import com.paytmmall.artifact.search.entity.CJRSearchLayout;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public final class v {

    /* renamed from: d  reason: collision with root package name */
    private static v f15745d;

    /* renamed from: a  reason: collision with root package name */
    public CJRShoppingCart f15746a;

    /* renamed from: b  reason: collision with root package name */
    WishList f15747b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRSearchLayout> f15748c;

    /* renamed from: e  reason: collision with root package name */
    private m f15749e = m.a();

    private v() {
    }

    public static v a() {
        if (f15745d == null) {
            f15745d = new v();
        }
        return f15745d;
    }

    public static void a(Context context, Map<String, Object> map) {
        try {
            m.a().a(context, "gaData", new f().b(map));
        } catch (Exception e2) {
            s.a(e2);
        }
    }

    public static HashMap<String, Object> b() {
        try {
            return (HashMap) new f().a(m.a().a("gaData"), new a<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e2) {
            s.a(e2);
            return new HashMap<>();
        }
    }

    public final String a(String str) {
        return this.f15749e.a(str);
    }

    public final void a(Context context, String str) {
        if (str != null) {
            a(context, str, "cartResponse");
            b(str);
        }
    }

    private void b(String str) {
        this.f15746a = (CJRShoppingCart) com.paytmmall.artifact.e.a.a(str, CJRShoppingCart.class);
        t.e().setShoppingCart(str);
        CJRShoppingCart cJRShoppingCart = this.f15746a;
        CJRCart cart = cJRShoppingCart == null ? null : cJRShoppingCart.getCart();
        if (cart != null) {
            l.a(cart.getmCartId());
            if (cart.getCartItems() != null) {
                l.a(cart.getCartItems().size());
            }
        }
    }

    public final void b(Context context, String str) {
        if (str != null) {
            a(context, str, "wishlistResponse");
            h(context, str);
        }
    }

    private void h(Context context, String str) {
        this.f15747b = (WishList) com.paytmmall.artifact.e.a.a(str, WishList.class);
        com.paytmmall.artifact.cart.d.a.a(context, this.f15747b);
    }

    public final void c(Context context, String str) {
        a(context, str, "recentProducts");
    }

    private void a(Context context, String str, String str2) {
        this.f15749e.a(context, str2, str);
    }

    public final void d(Context context, String str) {
        this.f15749e.a(context, str);
    }

    public final ArrayList<CJRSearchLayout> c() {
        try {
            this.f15748c = (ArrayList) new com.google.gsonhtcfix.f().a(a("recentSearchString"), new a<ArrayList<CJRSearchLayout>>() {
            }.getType());
        } catch (Exception e2) {
            s.a(e2);
        }
        return this.f15748c;
    }

    public final void a(Context context, CJRSearchLayout cJRSearchLayout) {
        if (this.f15748c == null) {
            this.f15748c = new ArrayList<>();
        }
        this.f15748c.add(0, cJRSearchLayout);
        b(context);
    }

    public final void b(Context context) {
        try {
            c.a(context, "recentSearchString", new com.google.gsonhtcfix.f().a((Object) this.f15748c));
        } catch (ConcurrentModificationException e2) {
            s.a(e2);
        }
    }

    public static void e(Context context, String str) {
        m.a().a(context, "searchResponse", str);
    }

    public static void f(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) com.paytmmall.artifact.e.a.a(str, CJRShoppingCart.class);
            CJRAddress cJRAddress = new CJRAddress();
            if (!(cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getAddress() == null)) {
                cJRAddress = cJRShoppingCart.getCart().getAddress();
            }
            if (cJRAddress != null) {
                cJRAddress.setPin(TextUtils.isEmpty(cJRAddress.getPin()) ? cJRAddress.getPin() : "");
            }
            if (cJRAddress != null) {
                try {
                    CJRLocation cJRLocation = new CJRLocation();
                    double latitude = cJRAddress.getLocation().getLatitude();
                    double longitude = cJRAddress.getLocation().getLongitude();
                    if (!(latitude == Double.MIN_VALUE || longitude == Double.MIN_VALUE)) {
                        cJRLocation.setLongitude(longitude);
                        cJRLocation.setLatitude(latitude);
                        cJRAddress.setLocation(cJRLocation);
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            b.a(context, cJRAddress);
        }
    }

    public final void g(Context context, String str) {
        try {
            a(context, str, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            b.a(context, (CJRAddress) com.paytmmall.artifact.e.a.a(str, CJRAddress.class));
        } catch (Exception e2) {
            s.a(e2);
        }
    }

    public final void a(Context context) {
        d(context, "cartResponse");
        d(context, "wishlistResponse");
    }
}
