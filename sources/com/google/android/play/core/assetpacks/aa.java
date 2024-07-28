package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.av;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.ce;
import com.google.android.play.core.b.ch;
import java.util.Arrays;

final class aa extends ce {

    /* renamed from: a  reason: collision with root package name */
    private final b f36946a = new b("AssetPackExtractionService");

    /* renamed from: b  reason: collision with root package name */
    private final Context f36947b;

    /* renamed from: c  reason: collision with root package name */
    private final AssetPackExtractionService f36948c;

    /* renamed from: d  reason: collision with root package name */
    private final ad f36949d;

    aa(Context context, AssetPackExtractionService assetPackExtractionService, ad adVar) {
        this.f36947b = context;
        this.f36948c = assetPackExtractionService;
        this.f36949d = adVar;
    }

    public final void a(Bundle bundle, ch chVar) throws RemoteException {
        String[] packagesForUid;
        this.f36946a.a("updateServiceState AIDL call", new Object[0]);
        if (av.a(this.f36947b) && (packagesForUid = this.f36947b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) != null && Arrays.asList(packagesForUid).contains("com.android.vending")) {
            chVar.a(this.f36948c.a(bundle), new Bundle());
            return;
        }
        chVar.a(new Bundle());
        this.f36948c.a();
    }

    public final void a(ch chVar) throws RemoteException {
        ad.c(this.f36949d.c());
        chVar.b(new Bundle());
    }
}
