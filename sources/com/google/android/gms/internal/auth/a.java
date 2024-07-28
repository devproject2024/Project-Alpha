package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9073a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9074b;

    protected a(IBinder iBinder, String str) {
        this.f9073a = iBinder;
        this.f9074b = str;
    }

    public IBinder asBinder() {
        return this.f9073a;
    }
}
