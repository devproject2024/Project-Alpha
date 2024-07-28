package com.google.android.gms.location.places;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzb extends AbstractSafeParcelable {
    static <E> Set<E> a(List<E> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(list));
    }
}
