package com.google.android.gms.common.api.internal;

import android.os.Build;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;

public abstract class bo {

    /* renamed from: a  reason: collision with root package name */
    private final int f8471a;

    public bo(int i2) {
        this.f8471a = i2;
    }

    public abstract void a(Status status);

    public abstract void a(cz czVar, boolean z);

    public abstract void a(RuntimeException runtimeException);

    public abstract void c(f.a<?> aVar) throws DeadObjectException;

    static /* synthetic */ Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if ((Build.VERSION.SDK_INT >= 15) && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }
}
