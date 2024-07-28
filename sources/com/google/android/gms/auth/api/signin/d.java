package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final /* synthetic */ class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    static final Comparator f8241a = new d();

    private d() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).f8352a.compareTo(((Scope) obj2).f8352a);
    }
}
