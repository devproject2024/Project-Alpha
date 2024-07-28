package net.one97.paytm.ups.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class UpsDb extends j {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static volatile UpsDb INSTANCE;

    public abstract UpsDao getUpsDao();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final synchronized UpsDb getDbInstance(Context context) {
            UpsDb access$getINSTANCE$cp;
            k.c(context, "context");
            if (UpsDb.INSTANCE == null) {
                UpsDb.INSTANCE = i.a(context, UpsDb.class, "ups_database").c();
            }
            access$getINSTANCE$cp = UpsDb.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }
    }
}
