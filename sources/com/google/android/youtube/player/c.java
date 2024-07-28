package com.google.android.youtube.player;

public interface c {

    public enum a {
        EMBEDDING_DISABLED,
        BLOCKED_FOR_APP,
        NOT_PLAYABLE,
        NETWORK_ERROR,
        UNAUTHORIZED_OVERLAY,
        PLAYER_VIEW_TOO_SMALL,
        PLAYER_VIEW_NOT_VISIBLE,
        EMPTY_PLAYLIST,
        AUTOPLAY_DISABLED,
        USER_DECLINED_RESTRICTED_CONTENT,
        USER_DECLINED_HIGH_BANDWIDTH,
        UNEXPECTED_SERVICE_DISCONNECTION,
        INTERNAL_ERROR,
        UNKNOWN
    }

    public interface b {
        void a(boolean z);
    }

    /* renamed from: com.google.android.youtube.player.c$c  reason: collision with other inner class name */
    public interface C0610c {
        void a(c cVar, boolean z);
    }

    public interface d {
        void a();

        void b();
    }

    public interface e {
    }

    void a();

    void a(b bVar);

    void a(d dVar);

    void a(String str);

    void a(boolean z);

    void b(boolean z);
}
