package com.paytm.android.chat.data.db.room;

import android.content.Context;
import androidx.room.i;
import com.paytm.android.chat.data.db.room.db_entities.UserExtendedMetaDataEntity;
import com.paytm.utility.q;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;

public final class DBManager {
    public static final DBManager INSTANCE = new DBManager();
    /* access modifiers changed from: private */
    public static final String TAG = TAG;
    /* access modifiers changed from: private */
    public static ChatDB db;
    private static boolean initialized;

    static final class b<T> implements g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41895a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    private DBManager() {
    }

    public static final /* synthetic */ ChatDB access$getDb$p(DBManager dBManager) {
        ChatDB chatDB = db;
        if (chatDB == null) {
            k.a("db");
        }
        return chatDB;
    }

    public final ChatDB getDb() {
        ChatDB chatDB = db;
        if (chatDB == null) {
            k.a("db");
        }
        return chatDB;
    }

    public final void init(Context context) {
        k.c(context, "context");
        if (!initialized) {
            ChatDB c2 = i.a(context.getApplicationContext(), ChatDB.class, "chatDb.db").b().c();
            k.a((Object) c2, "Room.databaseBuilder(con…uctiveMigration().build()");
            db = c2;
            initialized = true;
        }
    }

    public final UserExtendedMetaDataEntity getUserExtendedMetaDataById(String str) {
        k.c(str, "sendbirdUserId");
        ChatDB chatDB = db;
        if (chatDB == null) {
            k.a("db");
        }
        return chatDB.userExtendedMetaDataDao().getBySendbirdUserId(str);
    }

    public final void insertOrReplaceExtendedMetaData(String str, String str2, long j) {
        if (str != null && (!p.a(str)) && str2 != null && (!p.a(str2))) {
            UserExtendedMetaDataEntity userExtendedMetaDataEntity = new UserExtendedMetaDataEntity();
            userExtendedMetaDataEntity.setSendbirdUserId(str);
            userExtendedMetaDataEntity.setMetaDataString(str2);
            userExtendedMetaDataEntity.setUpdatedAt(Long.valueOf(j));
            ChatDB chatDB = db;
            if (chatDB == null) {
                k.a("db");
            }
            UserExtendedMetaDataEntity bySendbirdUserId = chatDB.userExtendedMetaDataDao().getBySendbirdUserId(str);
            if (bySendbirdUserId != null) {
                Long updatedAt = bySendbirdUserId.getUpdatedAt();
                if ((updatedAt != null ? updatedAt.longValue() : 0) < j) {
                    ChatDB chatDB2 = db;
                    if (chatDB2 == null) {
                        k.a("db");
                    }
                    chatDB2.userExtendedMetaDataDao().insertOrReplace(userExtendedMetaDataEntity);
                    return;
                }
                return;
            }
            ChatDB chatDB3 = db;
            if (chatDB3 == null) {
                k.a("db");
            }
            chatDB3.userExtendedMetaDataDao().insertOrReplace(userExtendedMetaDataEntity);
        }
    }

    public final void clearAllData() {
        y.a(a.f41894a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(b.f41895a, (g<? super Throwable>) c.f41896a);
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f41894a = new a();

        a() {
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().clearAllTables();
            return x.f47997a;
        }
    }

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41896a = new c();

        c() {
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = DBManager.TAG;
            q.c("clearAllData");
        }
    }
}
