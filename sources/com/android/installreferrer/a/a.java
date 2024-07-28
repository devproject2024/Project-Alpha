package com.android.installreferrer.a;

import android.content.Context;
import android.os.RemoteException;

public abstract class a {
    public abstract void a(c cVar);

    public abstract boolean a();

    public abstract void b();

    public abstract d c() throws RemoteException;

    /* renamed from: com.android.installreferrer.a.a$a  reason: collision with other inner class name */
    public static final class C0084a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6380a;

        /* synthetic */ C0084a(Context context, byte b2) {
            this(context);
        }

        private C0084a(Context context) {
            this.f6380a = context;
        }

        public final a a() {
            Context context = this.f6380a;
            if (context != null) {
                return new b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static C0084a a(Context context) {
        return new C0084a(context, (byte) 0);
    }
}
