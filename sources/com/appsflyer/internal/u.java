package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class u {
    u() {
    }

    /* renamed from: ι  reason: contains not printable characters */
    static b m199(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                d dVar = new d((byte) 0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!context.bindService(intent, dVar, 1)) {
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        throw new IOException("Google Play connection failed");
                    } else if (!dVar.f299) {
                        dVar.f299 = true;
                        e eVar = new e(dVar.f300.take());
                        b bVar = new b(eVar.m202(), eVar.m201());
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        return bVar;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (context != null) {
                        context.unbindService(dVar);
                    }
                    throw th;
                }
            } catch (Exception e3) {
                throw e3;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    static final class b {

        /* renamed from: ǃ  reason: contains not printable characters */
        private final boolean f297;

        /* renamed from: ɩ  reason: contains not printable characters */
        final String f298;

        b(String str, boolean z) {
            this.f298 = str;
            this.f297 = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ɩ  reason: contains not printable characters */
        public final boolean m200() {
            return this.f297;
        }
    }

    static final class d implements ServiceConnection {

        /* renamed from: ı  reason: contains not printable characters */
        boolean f299;

        /* renamed from: Ι  reason: contains not printable characters */
        final LinkedBlockingQueue<IBinder> f300;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private d() {
            this.f300 = new LinkedBlockingQueue<>(1);
            this.f299 = false;
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f300.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    static final class e implements IInterface {

        /* renamed from: ǃ  reason: contains not printable characters */
        private IBinder f301;

        e(IBinder iBinder) {
            this.f301 = iBinder;
        }

        public final IBinder asBinder() {
            return this.f301;
        }

        /* renamed from: ǃ  reason: contains not printable characters */
        public final String m202() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f301.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ı  reason: contains not printable characters */
        public final boolean m201() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f301.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
