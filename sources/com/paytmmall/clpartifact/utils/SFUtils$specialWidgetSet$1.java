package com.paytmmall.clpartifact.utils;

import java.util.HashSet;

public final class SFUtils$specialWidgetSet$1 extends HashSet<String> {
    SFUtils$specialWidgetSet$1() {
        add(ViewHolderFactory.TYPE_CAROUSEL_LOCKED_CARD);
        add(ViewHolderFactory.TYPE_CAROUSEL_SCRATCH_CARD);
        add(ViewHolderFactory.TYPE_P4B_ANNOUNCEMENT);
        add(ViewHolderFactory.TYPE_P4B_HOMETABS);
        add(ViewHolderFactory.TYPE_P4B_QR);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj != null ? obj instanceof String : true)) {
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
        if (!(obj != null ? obj instanceof String : true)) {
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
