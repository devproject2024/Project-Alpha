package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.a;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

final class b {

    interface a extends a.c {
        void b(List<?> list);
    }

    /* renamed from: android.support.v4.media.b$b  reason: collision with other inner class name */
    static class C0013b<T extends a> extends a.d<T> {
        C0013b(T t) {
            super(t);
        }

        public final void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((a) this.f859a).b(list);
        }

        public final void onError(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
        }
    }
}
