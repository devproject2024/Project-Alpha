package com.paytm.notification.data.datasource.dao;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.HashSet;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;

public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile g f43097b;

    /* renamed from: c  reason: collision with root package name */
    private volatile j f43098c;

    /* renamed from: d  reason: collision with root package name */
    private volatile d f43099d;

    /* renamed from: e  reason: collision with root package name */
    private volatile a f43100e;

    public final c createOpenHelper(a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `NotificationData` (`date` INTEGER NOT NULL, `priority` INTEGER, `status_push` INTEGER NOT NULL, `status_flash` INTEGER NOT NULL, `display_time` INTEGER NOT NULL, `campaignId` TEXT, `pushId` TEXT, `type` TEXT NOT NULL, `title` TEXT, `message` TEXT, `deep_link` TEXT, `extras` TEXT, `channelId` TEXT, `receiveTime` INTEGER, `expiry` INTEGER NOT NULL, `notificationId` INTEGER NOT NULL, `subtext` TEXT, `largeIconUrl` TEXT, `deep_link_type` TEXT, `rich_push` INTEGER NOT NULL, `server_receive_time` INTEGER NOT NULL, `messageId` TEXT, `senderId` TEXT, `sendTime` INTEGER, PRIMARY KEY(`notificationId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `InboxData` (`status` INTEGER, `date` TEXT, `priority` INTEGER, `customerId` TEXT NOT NULL, `pushId` TEXT NOT NULL, `content` TEXT, `extras` TEXT, `expiry_date` INTEGER NOT NULL, `state_changed` INTEGER NOT NULL, `expired` INTEGER NOT NULL, `title` TEXT NOT NULL, `body` TEXT NOT NULL, `imageUrl` TEXT, `deeplink` TEXT NOT NULL, `received_date` INTEGER NOT NULL, `campaignId` TEXT, PRIMARY KEY(`pushId`, `customerId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `FlashData` (`date` INTEGER NOT NULL, `priority` INTEGER, `status` INTEGER NOT NULL, `display_time` INTEGER NOT NULL, `campaignId` TEXT, `pushId` TEXT NOT NULL, `type` TEXT NOT NULL, `title` TEXT, `message` TEXT, `deep_link` TEXT, `extras` TEXT, `receiveTime` INTEGER, `expiry` INTEGER NOT NULL, `notificationId` INTEGER NOT NULL, `changed` INTEGER, `scheduledTime` INTEGER, `isFlash` INTEGER, `display_period_in_secs` INTEGER NOT NULL, `customerId` TEXT NOT NULL, `button_extras` TEXT, `image_url` TEXT, `position` TEXT, PRIMARY KEY(`pushId`, `customerId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `PushData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pushIdentifier` TEXT, `expiry` INTEGER NOT NULL)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '26e49ff7ba6029f481945f72eef9807e')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `NotificationData`");
                bVar.c("DROP TABLE IF EXISTS `InboxData`");
                bVar.c("DROP TABLE IF EXISTS `FlashData`");
                bVar.c("DROP TABLE IF EXISTS `PushData`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = AppDatabase_Impl.this.mDatabase = bVar;
                AppDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) AppDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                b bVar2 = bVar;
                HashMap hashMap = new HashMap(24);
                hashMap.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, new f.a(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, "INTEGER", true, 0, (String) null, 1));
                hashMap.put("priority", new f.a("priority", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("status_push", new f.a("status_push", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("status_flash", new f.a("status_flash", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("display_time", new f.a("display_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("campaignId", new f.a("campaignId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("pushId", new f.a("pushId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("type", new f.a("type", "TEXT", true, 0, (String) null, 1));
                hashMap.put("title", new f.a("title", "TEXT", false, 0, (String) null, 1));
                hashMap.put("message", new f.a("message", "TEXT", false, 0, (String) null, 1));
                hashMap.put(UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE, new f.a(UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE, "TEXT", false, 0, (String) null, 1));
                hashMap.put("extras", new f.a("extras", "TEXT", false, 0, (String) null, 1));
                hashMap.put("channelId", new f.a("channelId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("receiveTime", new f.a("receiveTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("expiry", new f.a("expiry", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("notificationId", new f.a("notificationId", "INTEGER", true, 1, (String) null, 1));
                Object obj = "notificationId";
                hashMap.put("subtext", new f.a("subtext", "TEXT", false, 0, (String) null, 1));
                hashMap.put("largeIconUrl", new f.a("largeIconUrl", "TEXT", false, 0, (String) null, 1));
                hashMap.put("deep_link_type", new f.a("deep_link_type", "TEXT", false, 0, (String) null, 1));
                hashMap.put("rich_push", new f.a("rich_push", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("server_receive_time", new f.a("server_receive_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("messageId", new f.a("messageId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("senderId", new f.a("senderId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("sendTime", new f.a("sendTime", "INTEGER", false, 0, (String) null, 1));
                Object obj2 = "expiry";
                Object obj3 = "receiveTime";
                f fVar = new f("NotificationData", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar2, "NotificationData");
                if (!fVar.equals(a2)) {
                    return new l.b(false, "NotificationData(com.paytm.notification.data.datasource.dao.NotificationData).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("status", new f.a("status", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, new f.a(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, "TEXT", false, 0, (String) null, 1));
                hashMap2.put("priority", new f.a("priority", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("customerId", new f.a("customerId", "TEXT", true, 2, (String) null, 1));
                hashMap2.put("pushId", new f.a("pushId", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("content", new f.a("content", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("extras", new f.a("extras", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("expiry_date", new f.a("expiry_date", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("state_changed", new f.a("state_changed", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("expired", new f.a("expired", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("title", new f.a("title", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("body", new f.a("body", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("deeplink", new f.a("deeplink", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("received_date", new f.a("received_date", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("campaignId", new f.a("campaignId", "TEXT", false, 0, (String) null, 1));
                Object obj4 = "extras";
                f fVar2 = new f("InboxData", hashMap2, new HashSet(0), new HashSet(0));
                f a3 = f.a(bVar2, "InboxData");
                if (!fVar2.equals(a3)) {
                    return new l.b(false, "InboxData(com.paytm.notification.data.datasource.dao.InboxData).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(22);
                hashMap3.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, new f.a(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("priority", new f.a("priority", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("status", new f.a("status", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("display_time", new f.a("display_time", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("campaignId", new f.a("campaignId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("pushId", new f.a("pushId", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("type", new f.a("type", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("title", new f.a("title", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("message", new f.a("message", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE, new f.a(UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE, "TEXT", false, 0, (String) null, 1));
                hashMap3.put(obj4, new f.a("extras", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(obj3, new f.a("receiveTime", "INTEGER", false, 0, (String) null, 1));
                Object obj5 = obj2;
                hashMap3.put(obj5, new f.a("expiry", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put(obj, new f.a("notificationId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("changed", new f.a("changed", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("scheduledTime", new f.a("scheduledTime", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("isFlash", new f.a("isFlash", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("display_period_in_secs", new f.a("display_period_in_secs", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("customerId", new f.a("customerId", "TEXT", true, 2, (String) null, 1));
                hashMap3.put("button_extras", new f.a("button_extras", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("image_url", new f.a("image_url", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(CLPConstants.ARGUMENT_KEY_POSITION, new f.a(CLPConstants.ARGUMENT_KEY_POSITION, "TEXT", false, 0, (String) null, 1));
                f fVar3 = new f("FlashData", hashMap3, new HashSet(0), new HashSet(0));
                f a4 = f.a(bVar2, "FlashData");
                if (!fVar3.equals(a4)) {
                    return new l.b(false, "FlashData(com.paytm.notification.data.datasource.dao.FlashData).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(3);
                hashMap4.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put("pushIdentifier", new f.a("pushIdentifier", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(obj5, new f.a("expiry", "INTEGER", true, 0, (String) null, 1));
                f fVar4 = new f("PushData", hashMap4, new HashSet(0), new HashSet(0));
                f a5 = f.a(bVar2, "PushData");
                if (fVar4.equals(a5)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "PushData(com.paytm.notification.data.datasource.dao.PushData).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
            }
        }, "26e49ff7ba6029f481945f72eef9807e", "9c15ea03bef9f338c513a9d142140c43")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "NotificationData", "InboxData", "FlashData", "PushData");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `NotificationData`");
            b2.c("DELETE FROM `InboxData`");
            b2.c("DELETE FROM `FlashData`");
            b2.c("DELETE FROM `PushData`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final g a() {
        g gVar;
        if (this.f43097b != null) {
            return this.f43097b;
        }
        synchronized (this) {
            if (this.f43097b == null) {
                this.f43097b = new h(this);
            }
            gVar = this.f43097b;
        }
        return gVar;
    }

    public final j b() {
        j jVar;
        if (this.f43098c != null) {
            return this.f43098c;
        }
        synchronized (this) {
            if (this.f43098c == null) {
                this.f43098c = new k(this);
            }
            jVar = this.f43098c;
        }
        return jVar;
    }

    public final d c() {
        d dVar;
        if (this.f43099d != null) {
            return this.f43099d;
        }
        synchronized (this) {
            if (this.f43099d == null) {
                this.f43099d = new e(this);
            }
            dVar = this.f43099d;
        }
        return dVar;
    }

    public final a d() {
        a aVar;
        if (this.f43100e != null) {
            return this.f43100e;
        }
        synchronized (this) {
            if (this.f43100e == null) {
                this.f43100e = new b(this);
            }
            aVar = this.f43100e;
        }
        return aVar;
    }
}
