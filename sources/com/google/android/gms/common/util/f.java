package com.google.android.gms.common.util;

import java.util.Collection;

public final class f {
    public static boolean a(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }
}
