package com.google.android.gms.internal.j;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.j.k;
import java.util.ArrayList;

final class n extends k.f {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ int[] f10361e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ int f10362f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f10363g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ String f10364h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(e eVar, int[] iArr, int i2, String str, String str2) {
        super(eVar);
        this.f10361e = iArr;
        this.f10362f = i2;
        this.f10363g = str;
        this.f10364h = str2;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        x xVar = (x) bVar;
        ArrayList arrayList = new ArrayList();
        for (int valueOf : this.f10361e) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        xVar.a(this.f10344d, arrayList, this.f10362f, this.f10363g, this.f10364h);
    }
}
