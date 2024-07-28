package com.paytmmall.clpartifact.utils;

import android.text.TextUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.cart.CJRCart;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.wishList.WishListProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CLPWidgetUtils {
    public static List<Item> getRecentlyViewedItems() {
        List<Item> cartItems = getCartItems();
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        ArrayList<Item> arrayList = new ArrayList<>();
        if (communicationListener != null) {
            arrayList = communicationListener.getRecentlyViewedItems();
        }
        if (cartItems != null) {
            arrayList.removeAll(cartItems);
        }
        return arrayList;
    }

    public static List<Item> getWishListItems() {
        CLPArtifact instance = CLPArtifact.getInstance();
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        if (communicationListener != null && !TextUtils.isEmpty(communicationListener.getSSOToken(instance.getContext()))) {
            ArrayList arrayList = new ArrayList();
            List<WishListProduct> wishListProductsCache = CLPArtifact.getInstance().getCommunicationListener().getWishListProductsCache();
            if (wishListProductsCache != null && !wishListProductsCache.isEmpty()) {
                for (WishListProduct next : wishListProductsCache) {
                    if (next.isInStock) {
                        arrayList.add(getWishListViewItem(next));
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    public static List<Item> getCartItems() {
        CLPArtifact instance = CLPArtifact.getInstance();
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        if (communicationListener != null && !TextUtils.isEmpty(communicationListener.getSSOToken(instance.getContext()))) {
            ArrayList arrayList = new ArrayList();
            CJRCart cartCache = CartUtils.getCartCache();
            if (!(cartCache == null || cartCache.getCartItems() == null || cartCache.getCartItems().isEmpty())) {
                Iterator<CJRCartItem> it2 = cartCache.getCartItems().iterator();
                while (it2.hasNext()) {
                    arrayList.add(getCartViewItem(it2.next()));
                }
                return arrayList;
            }
        }
        return null;
    }

    private static Item getCartViewItem(CJRCartItem cJRCartItem) {
        Item item = new Item();
        item.setImageUrl(cJRCartItem.getImageUrl());
        Long parentID = cJRCartItem.getParentID();
        if (parentID == null) {
            parentID = Long.valueOf(cJRCartItem.getProductId());
        }
        item.setId(String.valueOf(parentID));
        item.setUrl(cJRCartItem.getUrl());
        item.setName(cJRCartItem.getTitle());
        item.setUrlType(cJRCartItem.getUrlType());
        return item;
    }

    private static Item getWishListViewItem(WishListProduct wishListProduct) {
        Item item = new Item();
        String parentID = wishListProduct.getParentID();
        if (parentID == null) {
            parentID = wishListProduct.getProductId();
        }
        item.setId(parentID);
        item.setImageUrl(wishListProduct.getImageUrl());
        item.setUrl(wishListProduct.getUrl());
        item.setName(wishListProduct.getName());
        item.setUrlType("product");
        return item;
    }
}
