package com.google.android.gms.internal.j;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.j.k;

final class l extends k.b {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ byte[] f10356e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f10357f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(e eVar, byte[] bArr, String str) {
        super(eVar);
        this.f10356e = bArr;
        this.f10357f = str;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        x xVar = (x) bVar;
        g gVar = this.f10340d;
        byte[] bArr = this.f10356e;
        String str = this.f10357f;
        if (TextUtils.isEmpty(str)) {
            str = xVar.a("com.google.android.safetynet.ATTEST_API_KEY");
        }
        ((i) xVar.r()).a(gVar, bArr, str);
    }
}
