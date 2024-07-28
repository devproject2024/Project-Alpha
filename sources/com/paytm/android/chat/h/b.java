package com.paytm.android.chat.h;

import com.paytm.android.chat.utils.ContactManager;
import io.reactivex.rxjava3.a.y;

final class b implements ContactManager.FetchUserInfo {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ kotlin.g.a.b f42258a;

    b(kotlin.g.a.b bVar) {
        this.f42258a = bVar;
    }

    public final /* synthetic */ y fetch(String str) {
        return (y) this.f42258a.invoke(str);
    }
}
