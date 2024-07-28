package com.paytmmall.clpartifact.common;

import android.content.Intent;
import androidx.localbroadcastmanager.a.a;
import com.google.gson.f;
import com.paytmmall.clpartifact.modal.cart.CJRCart;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import com.paytmmall.clpartifact.modal.cart.CJRCartResponse;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class CartUtils {
    private static ConcurrentHashMap<Long, CJRCartItem> cartItemMap;
    private static CJRCart mCartCache;

    public static boolean hasCartDetails() {
        return cartItemMap != null;
    }

    public static void setCartItem(String str) {
        if (str != null) {
            try {
                CJRCart cart = ((CJRCartResponse) new f().a(str, CJRCartResponse.class)).getCart();
                mCartCache = cart;
                if (cartItemMap == null) {
                    synchronized (CartUtils.class) {
                        if (cartItemMap == null) {
                            cartItemMap = new ConcurrentHashMap<>();
                        }
                    }
                }
                cartItemMap.clear();
                if (cart != null && cart.getCartItems() != null) {
                    if (!cart.getCartItems().isEmpty()) {
                        Iterator<CJRCartItem> it2 = cart.getCartItems().iterator();
                        while (it2.hasNext()) {
                            CJRCartItem next = it2.next();
                            cartItemMap.put(Long.valueOf(next.getProductId()), next);
                        }
                        a.a(CLPArtifact.getInstance().getContext()).a(new Intent(CLPConstants.ACTION_UPDATE_CLP));
                    }
                }
            } catch (Exception e2) {
                LogUtils.printStackTrace(e2);
            }
        }
    }

    public static String getItemId(long j) {
        return hasItemWithId(j) ? cartItemMap.get(Long.valueOf(j)).getItemId() : "null";
    }

    public static boolean isCartEmpty() {
        ConcurrentHashMap<Long, CJRCartItem> concurrentHashMap = cartItemMap;
        return concurrentHashMap == null || concurrentHashMap.isEmpty();
    }

    public static boolean hasItemWithId(long j) {
        return !isCartEmpty() && cartItemMap.containsKey(Long.valueOf(j));
    }

    public static CJRCartItem getItem(long j) {
        if (hasItemWithId(j)) {
            return cartItemMap.get(Long.valueOf(j));
        }
        return null;
    }

    public static int itemCountInCart(long j) {
        if (hasItemWithId(j)) {
            return cartItemMap.get(Long.valueOf(j)).getQuantity();
        }
        return 0;
    }

    public static CJRCart getCartCache() {
        return mCartCache;
    }
}
