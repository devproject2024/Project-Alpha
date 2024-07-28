package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.IInterface;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    final IBinder f9119a;

    /* renamed from: b  reason: collision with root package name */
    final String f9120b;

    protected a(IBinder iBinder, String str) {
        this.f9119a = iBinder;
        this.f9120b = str;
    }

    public IBinder asBinder() {
        return this.f9119a;
    }
}
