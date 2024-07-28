package com.paytm.android.chat.data.db.room.db_entities;

import kotlin.g.b.g;
import kotlin.m.p;

public enum UserInfoSource {
    USER_API,
    SENDBIRD_USER,
    PUSH,
    FRIENDS_API;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((g) null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final UserInfoSource fromString(String str) {
            for (UserInfoSource userInfoSource : UserInfoSource.values()) {
                if (p.a(userInfoSource.toString(), str, true)) {
                    return userInfoSource;
                }
            }
            return null;
        }
    }
}
