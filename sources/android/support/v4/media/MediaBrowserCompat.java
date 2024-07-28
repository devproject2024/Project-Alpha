package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f787a = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    public final d f788b;

    public static abstract class c {
    }

    public interface d {
        void c();

        void d();

        MediaSessionCompat.Token e();
    }

    interface i {
        void a(Messenger messenger);

        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f788b = new g(context, componentName, bVar);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.f788b = new f(context, componentName, bVar);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f788b = new e(context, componentName, bVar);
        } else {
            this.f788b = new h(context, componentName, bVar);
        }
    }

    public final void a() {
        this.f788b.d();
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new MediaItem[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final int f791a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f792b;

        public int describeContents() {
            return 0;
        }

        public static List<MediaItem> a(List<?> list) {
            MediaItem mediaItem;
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                if (next == null || Build.VERSION.SDK_INT < 21) {
                    mediaItem = null;
                } else {
                    MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) next;
                    mediaItem = new MediaItem(MediaDescriptionCompat.a(mediaItem2.getDescription()), mediaItem2.getFlags());
                }
                arrayList.add(mediaItem);
            }
            return arrayList;
        }

        private MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(mediaDescriptionCompat.f833a)) {
                this.f791a = i2;
                this.f792b = mediaDescriptionCompat;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }

        MediaItem(Parcel parcel) {
            this.f791a = parcel.readInt();
            this.f792b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f791a);
            this.f792b.writeToParcel(parcel, i2);
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f791a + ", mDescription=" + this.f792b + '}';
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f795a;

        /* renamed from: b  reason: collision with root package name */
        a f796b;

        interface a {
            void a();

            void b();
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public b() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f795a = new a.b(new C0011b());
            } else {
                this.f795a = null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        class C0011b implements a.C0012a {
            C0011b() {
            }

            public final void a() {
                if (b.this.f796b != null) {
                    b.this.f796b.a();
                }
                b.this.a();
            }

            public final void b() {
                if (b.this.f796b != null) {
                    b.this.f796b.b();
                }
                b.this.b();
            }

            public final void c() {
                b.this.c();
            }
        }
    }

    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        final Object f828a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f829b = new Binder();

        /* renamed from: c  reason: collision with root package name */
        WeakReference<k> f830c;

        public l() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f828a = new b.C0013b(new b());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f828a = new a.d(new a());
            } else {
                this.f828a = null;
            }
        }

        class a implements a.c {
            a() {
            }

            public final void a(List<?> list) {
                k kVar = l.this.f830c == null ? null : (k) l.this.f830c.get();
                if (kVar == null) {
                    MediaItem.a(list);
                    return;
                }
                List<MediaItem> a2 = MediaItem.a(list);
                List<l> list2 = kVar.f826a;
                List<Bundle> list3 = kVar.f827b;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    Bundle bundle = list3.get(i2);
                    if (!(bundle == null || a2 == null)) {
                        int i3 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                        int i4 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        if (i3 != -1 || i4 != -1) {
                            int i5 = i4 * i3;
                            int i6 = i5 + i4;
                            if (i3 < 0 || i4 <= 0 || i5 >= a2.size()) {
                                Collections.emptyList();
                            } else {
                                if (i6 > a2.size()) {
                                    i6 = a2.size();
                                }
                                a2.subList(i5, i6);
                            }
                        }
                    }
                }
            }
        }

        class b extends a implements b.a {
            b() {
                super();
            }

            public final void b(List<?> list) {
                MediaItem.a(list);
            }
        }
    }

    static class h implements d, i {

        /* renamed from: a  reason: collision with root package name */
        final Context f807a;

        /* renamed from: b  reason: collision with root package name */
        final ComponentName f808b;

        /* renamed from: c  reason: collision with root package name */
        final b f809c;

        /* renamed from: d  reason: collision with root package name */
        final Bundle f810d;

        /* renamed from: e  reason: collision with root package name */
        final a f811e = new a(this);

        /* renamed from: f  reason: collision with root package name */
        int f812f = 1;

        /* renamed from: g  reason: collision with root package name */
        a f813g;

        /* renamed from: h  reason: collision with root package name */
        j f814h;

        /* renamed from: i  reason: collision with root package name */
        Messenger f815i;
        private final androidx.a.a<String, k> j = new androidx.a.a<>();
        private String k;
        private MediaSessionCompat.Token l;
        private Bundle m;
        private Bundle n;

        public h(Context context, ComponentName componentName, b bVar) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (bVar != null) {
                this.f807a = context;
                this.f808b = componentName;
                this.f809c = bVar;
                this.f810d = null;
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        public final void c() {
            int i2 = this.f812f;
            if (i2 == 0 || i2 == 1) {
                this.f812f = 2;
                this.f811e.post(new Runnable() {
                    public final void run() {
                        if (h.this.f812f != 0) {
                            h.this.f812f = 2;
                            if (MediaBrowserCompat.f787a && h.this.f813g != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + h.this.f813g);
                            } else if (h.this.f814h != null) {
                                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + h.this.f814h);
                            } else if (h.this.f815i == null) {
                                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                                intent.setComponent(h.this.f808b);
                                h hVar = h.this;
                                hVar.f813g = new a();
                                boolean z = false;
                                try {
                                    z = h.this.f807a.bindService(intent, h.this.f813g, 1);
                                } catch (Exception unused) {
                                    new StringBuilder("Failed binding to service ").append(h.this.f808b);
                                }
                                if (!z) {
                                    h.this.a();
                                    h.this.f809c.c();
                                }
                                if (MediaBrowserCompat.f787a) {
                                    h.this.b();
                                }
                            } else {
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + h.this.f815i);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f812f) + ")");
        }

        public final void d() {
            this.f812f = 0;
            this.f811e.post(new Runnable() {
                public final void run() {
                    if (h.this.f815i != null) {
                        try {
                            h.this.f814h.a(2, (Bundle) null, h.this.f815i);
                        } catch (RemoteException unused) {
                            new StringBuilder("RemoteException during connect for ").append(h.this.f808b);
                        }
                    }
                    int i2 = h.this.f812f;
                    h.this.a();
                    if (i2 != 0) {
                        h.this.f812f = i2;
                    }
                    if (MediaBrowserCompat.f787a) {
                        h.this.b();
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            a aVar = this.f813g;
            if (aVar != null) {
                this.f807a.unbindService(aVar);
            }
            this.f812f = 1;
            this.f813g = null;
            this.f814h = null;
            this.f815i = null;
            this.f811e.a((Messenger) null);
            this.k = null;
            this.l = null;
        }

        public final void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.f812f != 2) {
                    StringBuilder sb = new StringBuilder("onConnect from service while mState=");
                    sb.append(a(this.f812f));
                    sb.append("... ignoring");
                    return;
                }
                this.k = str;
                this.l = token;
                this.m = bundle;
                this.f812f = 3;
                if (MediaBrowserCompat.f787a) {
                    b();
                }
                this.f809c.a();
                try {
                    for (Map.Entry next : this.j.entrySet()) {
                        String str2 = (String) next.getKey();
                        k kVar = (k) next.getValue();
                        List<l> list = kVar.f826a;
                        List<Bundle> list2 = kVar.f827b;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            j jVar = this.f814h;
                            IBinder iBinder = list.get(i2).f829b;
                            Messenger messenger2 = this.f815i;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("data_media_item_id", str2);
                            androidx.core.app.d.a(bundle2, "data_callback_token", iBinder);
                            bundle2.putBundle("data_options", list2.get(i2));
                            jVar.a(3, bundle2, messenger2);
                        }
                    }
                } catch (RemoteException unused) {
                }
            }
        }

        public final void a(Messenger messenger) {
            new StringBuilder("onConnectFailed for ").append(this.f808b);
            if (a(messenger, "onConnectFailed")) {
                if (this.f812f != 2) {
                    StringBuilder sb = new StringBuilder("onConnect from service while mState=");
                    sb.append(a(this.f812f));
                    sb.append("... ignoring");
                    return;
                }
                a();
                this.f809c.c();
            }
        }

        public final void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f787a) {
                    StringBuilder sb = new StringBuilder("onLoadChildren for ");
                    sb.append(this.f808b);
                    sb.append(" id=");
                    sb.append(str);
                }
                k kVar = this.j.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.f787a;
                } else if (kVar.a(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.n = bundle2;
                            this.n = null;
                        }
                    } else if (list != null) {
                        this.n = bundle2;
                        this.n = null;
                    }
                }
            }
        }

        private static String a(int i2) {
            if (i2 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i2 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i2 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i2 != 3) {
                return i2 != 4 ? "UNKNOWN/".concat(String.valueOf(i2)) : "CONNECT_STATE_SUSPENDED";
            }
            return "CONNECT_STATE_CONNECTED";
        }

        private boolean a(Messenger messenger, String str) {
            int i2;
            if (this.f815i == messenger && (i2 = this.f812f) != 0 && i2 != 1) {
                return true;
            }
            int i3 = this.f812f;
            if (i3 == 0 || i3 == 1) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" for ");
            sb.append(this.f808b);
            sb.append(" with mCallbacksMessenger=");
            sb.append(this.f815i);
            sb.append(" this=");
            sb.append(this);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            new StringBuilder("  mServiceComponent=").append(this.f808b);
            new StringBuilder("  mCallback=").append(this.f809c);
            new StringBuilder("  mRootHints=").append(this.f810d);
            new StringBuilder("  mState=").append(a(this.f812f));
            new StringBuilder("  mServiceConnection=").append(this.f813g);
            new StringBuilder("  mServiceBinderWrapper=").append(this.f814h);
            new StringBuilder("  mCallbacksMessenger=").append(this.f815i);
            new StringBuilder("  mRootId=").append(this.k);
            new StringBuilder("  mMediaSessionToken=").append(this.l);
        }

        class a implements ServiceConnection {
            a() {
            }

            public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                a((Runnable) new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.f787a) {
                            StringBuilder sb = new StringBuilder("MediaServiceConnection.onServiceConnected name=");
                            sb.append(componentName);
                            sb.append(" binder=");
                            sb.append(iBinder);
                            h.this.b();
                        }
                        if (a.this.a("onServiceConnected")) {
                            h.this.f814h = new j(iBinder, h.this.f810d);
                            h.this.f815i = new Messenger(h.this.f811e);
                            h.this.f811e.a(h.this.f815i);
                            h.this.f812f = 2;
                            try {
                                if (MediaBrowserCompat.f787a) {
                                    h.this.b();
                                }
                                j jVar = h.this.f814h;
                                Context context = h.this.f807a;
                                Messenger messenger = h.this.f815i;
                                Bundle bundle = new Bundle();
                                bundle.putString("data_package_name", context.getPackageName());
                                bundle.putBundle("data_root_hints", jVar.f824a);
                                jVar.a(1, bundle, messenger);
                            } catch (RemoteException unused) {
                                new StringBuilder("RemoteException during connect for ").append(h.this.f808b);
                                if (MediaBrowserCompat.f787a) {
                                    h.this.b();
                                }
                            }
                        }
                    }
                });
            }

            public final void onServiceDisconnected(final ComponentName componentName) {
                a((Runnable) new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.f787a) {
                            StringBuilder sb = new StringBuilder("MediaServiceConnection.onServiceDisconnected name=");
                            sb.append(componentName);
                            sb.append(" this=");
                            sb.append(this);
                            sb.append(" mServiceConnection=");
                            sb.append(h.this.f813g);
                            h.this.b();
                        }
                        if (a.this.a("onServiceDisconnected")) {
                            h.this.f814h = null;
                            h.this.f815i = null;
                            h.this.f811e.a((Messenger) null);
                            h.this.f812f = 4;
                            h.this.f809c.b();
                        }
                    }
                });
            }

            private void a(Runnable runnable) {
                if (Thread.currentThread() == h.this.f811e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    h.this.f811e.post(runnable);
                }
            }

            /* access modifiers changed from: package-private */
            public final boolean a(String str) {
                if (h.this.f813g == this && h.this.f812f != 0 && h.this.f812f != 1) {
                    return true;
                }
                if (h.this.f812f == 0 || h.this.f812f == 1) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" for ");
                sb.append(h.this.f808b);
                sb.append(" with mServiceConnection=");
                sb.append(h.this.f813g);
                sb.append(" this=");
                sb.append(this);
                return false;
            }
        }

        public final MediaSessionCompat.Token e() {
            if (this.f812f == 3) {
                return this.l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f812f + ")");
        }
    }

    static class e implements b.a, d, i {

        /* renamed from: a  reason: collision with root package name */
        final Context f798a;

        /* renamed from: b  reason: collision with root package name */
        protected final Object f799b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f800c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f801d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        protected int f802e;

        /* renamed from: f  reason: collision with root package name */
        protected j f803f;

        /* renamed from: g  reason: collision with root package name */
        protected Messenger f804g;

        /* renamed from: h  reason: collision with root package name */
        private final androidx.a.a<String, k> f805h = new androidx.a.a<>();

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f806i;
        private Bundle j;

        public final void a(Messenger messenger) {
        }

        public final void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        e(Context context, ComponentName componentName, b bVar) {
            this.f798a = context;
            this.f800c = new Bundle();
            this.f800c.putInt("extra_client_version", 1);
            bVar.f796b = this;
            this.f799b = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) bVar.f795a, this.f800c);
        }

        public final void c() {
            ((MediaBrowser) this.f799b).connect();
        }

        public final void d() {
            Messenger messenger;
            j jVar = this.f803f;
            if (!(jVar == null || (messenger = this.f804g) == null)) {
                try {
                    jVar.a(7, (Bundle) null, messenger);
                } catch (RemoteException unused) {
                }
            }
            ((MediaBrowser) this.f799b).disconnect();
        }

        public final MediaSessionCompat.Token e() {
            if (this.f806i == null) {
                this.f806i = MediaSessionCompat.Token.a(((MediaBrowser) this.f799b).getSessionToken());
            }
            return this.f806i;
        }

        public final void a() {
            Bundle extras = ((MediaBrowser) this.f799b).getExtras();
            if (extras != null) {
                this.f802e = extras.getInt("extra_service_version", 0);
                IBinder a2 = androidx.core.app.d.a(extras, "extra_messenger");
                if (a2 != null) {
                    this.f803f = new j(a2, this.f800c);
                    this.f804g = new Messenger(this.f801d);
                    this.f801d.a(this.f804g);
                    try {
                        j jVar = this.f803f;
                        Context context = this.f798a;
                        Messenger messenger = this.f804g;
                        Bundle bundle = new Bundle();
                        bundle.putString("data_package_name", context.getPackageName());
                        bundle.putBundle("data_root_hints", jVar.f824a);
                        jVar.a(6, bundle, messenger);
                    } catch (RemoteException unused) {
                    }
                }
                android.support.v4.media.session.b a3 = b.a.a(androidx.core.app.d.a(extras, "extra_session_binder"));
                if (a3 != null) {
                    this.f806i = MediaSessionCompat.Token.a(((MediaBrowser) this.f799b).getSessionToken(), a3);
                }
            }
        }

        public final void b() {
            this.f803f = null;
            this.f804g = null;
            this.f806i = null;
            this.f801d.a((Messenger) null);
        }

        public final void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f804g == messenger) {
                k kVar = this.f805h.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.f787a;
                } else if (kVar.a(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.j = bundle2;
                            this.j = null;
                        }
                    } else if (list != null) {
                        this.j = bundle2;
                        this.j = null;
                    }
                }
            }
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar) {
            super(context, componentName, bVar);
        }
    }

    static class g extends f {
        g(Context context, ComponentName componentName, b bVar) {
            super(context, componentName, bVar);
        }
    }

    static class k {

        /* renamed from: a  reason: collision with root package name */
        final List<l> f826a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final List<Bundle> f827b = new ArrayList();

        public final l a(Bundle bundle) {
            for (int i2 = 0; i2 < this.f827b.size(); i2++) {
                if (androidx.media.d.a(this.f827b.get(i2), bundle)) {
                    return this.f826a.get(i2);
                }
            }
            return null;
        }
    }

    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<i> f793a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Messenger> f794b;

        a(i iVar) {
            this.f793a = new WeakReference<>(iVar);
        }

        public final void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f794b;
            if (weakReference != null && weakReference.get() != null && this.f793a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                i iVar = (i) this.f793a.get();
                Messenger messenger = (Messenger) this.f794b.get();
                try {
                    int i2 = message.what;
                    if (i2 == 1) {
                        Bundle bundle = data.getBundle("data_root_hints");
                        MediaSessionCompat.a(bundle);
                        iVar.a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                    } else if (i2 == 2) {
                        iVar.a(messenger);
                    } else if (i2 != 3) {
                        StringBuilder sb = new StringBuilder("Unhandled message: ");
                        sb.append(message);
                        sb.append("\n  Client version: 1\n  Service version: ");
                        sb.append(message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle("data_options");
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                        MediaSessionCompat.a(bundle3);
                        iVar.a(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    if (message.what == 1) {
                        iVar.a(messenger);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(Messenger messenger) {
            this.f794b = new WeakReference<>(messenger);
        }
    }

    static class j {

        /* renamed from: a  reason: collision with root package name */
        Bundle f824a;

        /* renamed from: b  reason: collision with root package name */
        private Messenger f825b;

        public j(IBinder iBinder, Bundle bundle) {
            this.f825b = new Messenger(iBinder);
            this.f824a = bundle;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f825b.send(obtain);
        }
    }

    static class ItemReceiver extends ResultReceiver {
        public final void a(int i2, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i2 == 0 && bundle != null && bundle.containsKey("media_item")) {
                bundle.getParcelable("media_item");
            }
        }
    }

    static class SearchResultReceiver extends ResultReceiver {
        public final void a(int i2, Bundle bundle) {
            Parcelable[] parcelableArray;
            MediaSessionCompat.a(bundle);
            if (i2 == 0 && bundle != null && bundle.containsKey("search_results") && (parcelableArray = bundle.getParcelableArray("search_results")) != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
        }
    }

    static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f789d;

        /* renamed from: e  reason: collision with root package name */
        private final c f790e;

        public final void a(int i2, Bundle bundle) {
            if (this.f790e != null) {
                MediaSessionCompat.a(bundle);
                if (i2 != -1 && i2 != 0 && i2 != 1) {
                    StringBuilder sb = new StringBuilder("Unknown result code: ");
                    sb.append(i2);
                    sb.append(" (extras=");
                    sb.append(this.f789d);
                    sb.append(", resultData=");
                    sb.append(bundle);
                    sb.append(")");
                }
            }
        }
    }
}
