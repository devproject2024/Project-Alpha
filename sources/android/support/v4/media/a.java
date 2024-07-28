package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.util.List;

final class a {

    /* renamed from: android.support.v4.media.a$a  reason: collision with other inner class name */
    interface C0012a {
        void a();

        void b();

        void c();
    }

    interface c {
        void a(List<?> list);
    }

    static class b<T extends C0012a> extends MediaBrowser.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f858a;

        public b(T t) {
            this.f858a = t;
        }

        public final void onConnected() {
            this.f858a.a();
        }

        public final void onConnectionSuspended() {
            this.f858a.b();
        }

        public final void onConnectionFailed() {
            this.f858a.c();
        }
    }

    static class d<T extends c> extends MediaBrowser.SubscriptionCallback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f859a;

        public void onError(String str) {
        }

        public d(T t) {
            this.f859a = t;
        }

        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.f859a.a(list);
        }
    }
}
