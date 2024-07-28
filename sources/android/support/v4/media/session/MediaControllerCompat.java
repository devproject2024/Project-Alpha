package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final b f860a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f861b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<a> f862c = new HashSet<>();

    public interface b {
        boolean a(KeyEvent keyEvent);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token != null) {
            this.f861b = token;
            if (Build.VERSION.SDK_INT >= 24) {
                this.f860a = new d(context, token);
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.f860a = new c(context, token);
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f860a = new MediaControllerImplApi21(context, token);
            } else {
                this.f860a = new e(token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final Object f869a;

        /* renamed from: b  reason: collision with root package name */
        C0014a f870b;

        /* renamed from: c  reason: collision with root package name */
        a f871c;

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f869a = new c.b(new b(this));
                return;
            }
            c cVar = new c(this);
            this.f871c = cVar;
            this.f869a = cVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Object obj, Bundle bundle) {
            C0014a aVar = this.f870b;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f873a;

            b(a aVar) {
                this.f873a = new WeakReference<>(aVar);
            }

            public final void a() {
                this.f873a.get();
            }

            public final void b() {
                a aVar = (a) this.f873a.get();
                if (aVar != null && aVar.f871c != null) {
                    int i2 = Build.VERSION.SDK_INT;
                }
            }

            public final void a(Object obj) {
                a aVar = (a) this.f873a.get();
                if (aVar != null && aVar.f871c == null) {
                    PlaybackStateCompat.a(obj);
                }
            }

            public final void b(Object obj) {
                if (((a) this.f873a.get()) != null) {
                    MediaMetadataCompat.a(obj);
                }
            }

            public final void a(List<?> list) {
                if (((a) this.f873a.get()) != null) {
                    MediaSessionCompat.QueueItem.a(list);
                }
            }

            public final void c() {
                this.f873a.get();
            }

            public final void d() {
                this.f873a.get();
            }

            public final void a(int i2, int i3, int i4, int i5, int i6) {
                if (((a) this.f873a.get()) != null) {
                    new f(i2, i3, i4, i5, i6);
                }
            }
        }

        static class c extends a.C0015a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f874a;

            public final void a(boolean z) throws RemoteException {
            }

            c(a aVar) {
                this.f874a = new WeakReference<>(aVar);
            }

            public final void a(String str, Bundle bundle) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(8, (Object) null, (Bundle) null);
                }
            }

            public final void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(5, list, (Bundle) null);
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, (Bundle) null);
                }
            }

            public final void b(boolean z) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public final void a(int i2) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public final void b(int i2) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, (Bundle) null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new f(parcelableVolumeInfo.f888a, parcelableVolumeInfo.f889b, parcelableVolumeInfo.f890c, parcelableVolumeInfo.f891d, parcelableVolumeInfo.f892e) : null, (Bundle) null);
                }
            }

            public final void b() throws RemoteException {
                a aVar = (a) this.f874a.get();
                if (aVar != null) {
                    aVar.a(13, (Object) null, (Bundle) null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        class C0014a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f872a;

            public final void handleMessage(Message message) {
                if (this.f872a) {
                    switch (message.what) {
                        case 1:
                            MediaSessionCompat.a(message.getData());
                            Object obj = message.obj;
                            return;
                        case 2:
                            Object obj2 = message.obj;
                            return;
                        case 3:
                            Object obj3 = message.obj;
                            return;
                        case 4:
                            Object obj4 = message.obj;
                            return;
                        case 5:
                            Object obj5 = message.obj;
                            return;
                        case 6:
                            Object obj6 = message.obj;
                            return;
                        case 7:
                            MediaSessionCompat.a((Bundle) message.obj);
                            return;
                        case 9:
                            ((Integer) message.obj).intValue();
                            return;
                        case 11:
                            ((Boolean) message.obj).booleanValue();
                            return;
                        case 12:
                            ((Integer) message.obj).intValue();
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f876a;

        /* renamed from: b  reason: collision with root package name */
        private final int f877b;

        /* renamed from: c  reason: collision with root package name */
        private final int f878c;

        /* renamed from: d  reason: collision with root package name */
        private final int f879d;

        /* renamed from: e  reason: collision with root package name */
        private final int f880e;

        f(int i2, int i3, int i4, int i5, int i6) {
            this.f876a = i2;
            this.f877b = i3;
            this.f878c = i4;
            this.f879d = i5;
            this.f880e = i6;
        }
    }

    static class e implements b {

        /* renamed from: a  reason: collision with root package name */
        private b f875a;

        public e(MediaSessionCompat.Token token) {
            this.f875a = b.a.a((IBinder) token.f885a);
        }

        public final boolean a(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.f875a.a(keyEvent);
                    return false;
                } catch (RemoteException unused) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }
    }

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f863a;

        /* renamed from: b  reason: collision with root package name */
        final Object f864b = new Object();

        /* renamed from: c  reason: collision with root package name */
        final List<a> f865c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        HashMap<a, a> f866d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        final MediaSessionCompat.Token f867e;

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f867e = token;
            this.f863a = new MediaController(context, (MediaSession.Token) this.f867e.f885a);
            if (this.f863a == null) {
                throw new RemoteException();
            } else if (this.f867e.f886b == null) {
                ((MediaController) this.f863a).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
            }
        }

        public final boolean a(KeyEvent keyEvent) {
            return ((MediaController) this.f863a).dispatchMediaButtonEvent(keyEvent);
        }

        static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f868a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f868a = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f868a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f864b) {
                        mediaControllerImplApi21.f867e.f886b = b.a.a(androidx.core.app.d.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                        mediaControllerImplApi21.f867e.f887c = bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
                        if (mediaControllerImplApi21.f867e.f886b != null) {
                            for (a next : mediaControllerImplApi21.f865c) {
                                a aVar = new a(next);
                                mediaControllerImplApi21.f866d.put(next, aVar);
                                next.f871c = aVar;
                                try {
                                    mediaControllerImplApi21.f867e.f886b.a((a) aVar);
                                    next.a(13, (Object) null, (Bundle) null);
                                } catch (RemoteException unused) {
                                }
                            }
                            mediaControllerImplApi21.f865c.clear();
                        }
                    }
                }
            }
        }

        static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public final void a() throws RemoteException {
                throw new AssertionError();
            }

            public final void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public final void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public final void a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public final void a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public final void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }
}
