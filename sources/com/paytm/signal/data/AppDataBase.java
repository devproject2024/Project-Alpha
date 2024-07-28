package com.paytm.signal.data;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;
import kotlin.x;

public abstract class AppDataBase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43634a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AppDataBase f43635b;

    public abstract d a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final AppDataBase a(Context context) {
            k.c(context, "context");
            if (AppDataBase.f43635b == null) {
                synchronized (this) {
                    if (AppDataBase.f43635b == null) {
                        AppDataBase.f43635b = i.a(context.getApplicationContext(), AppDataBase.class, "pai_signal").c();
                    }
                    x xVar = x.f47997a;
                }
            }
            AppDataBase b2 = AppDataBase.f43635b;
            if (b2 == null) {
                k.a();
            }
            return b2;
        }
    }
}
