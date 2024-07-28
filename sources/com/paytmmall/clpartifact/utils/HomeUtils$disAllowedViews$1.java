package com.paytmmall.clpartifact.utils;

import java.util.HashSet;
import net.one97.paytm.common.entity.shopping.LayoutType;

public final class HomeUtils$disAllowedViews$1 extends HashSet<String> {
    HomeUtils$disAllowedViews$1() {
        add(LayoutType.LAYOUT_SMART_LIST.getName());
        add(LayoutType.LAYOUT_TICKER.getName());
        add(LayoutType.LAYOUT_SMART_ICON_CAROUSEL.getName());
        add(ViewHolderFactory.TYPE_ITEM_TABBED);
        add(ViewHolderFactory.TYPE_ITEM_TABBED_2);
        add(ViewHolderFactory.TYPE_TABBED_2_SALE);
        add(ViewHolderFactory.TYPE_H1_MERCHANT_BANNER);
        add(ViewHolderFactory.TYPE_DEALS_2XN);
        add(ViewHolderFactory.TYPE_TREE_1);
        add(LayoutType.LAYOUT_SMART_ICON_VIDEO.getName());
        add(ViewHolderFactory.LAYOUT_CAROUSEL_3);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return contains((String) obj);
    }

    public final /* bridge */ boolean contains(String str) {
        return super.contains(str);
    }

    public final int getSize() {
        return super.size();
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return remove((String) obj);
    }

    public final /* bridge */ boolean remove(String str) {
        return super.remove(str);
    }

    public final int size() {
        return getSize();
    }
}
