package com.google.android.gms.internal.j;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.j.k;
import java.util.List;

final class m extends k.f {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ List f10358e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f10359f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f10360g = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(e eVar, List list, String str) {
        super(eVar);
        this.f10358e = list;
        this.f10359f = str;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        ((x) bVar).a(this.f10344d, this.f10358e, 1, this.f10359f, this.f10360g);
    }
}
