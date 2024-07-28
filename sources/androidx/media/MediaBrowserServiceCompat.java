package androidx.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3752a = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    final androidx.a.a<IBinder, b> f3753b = new androidx.a.a<>();

    /* renamed from: c  reason: collision with root package name */
    b f3754c;

    /* renamed from: d  reason: collision with root package name */
    final g f3755d = new g();

    /* renamed from: e  reason: collision with root package name */
    MediaSessionCompat.Token f3756e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f3768a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f3769b;
    }

    interface e {
        IBinder a();

        void a(String str, Bundle bundle, Bundle bundle2) throws RemoteException;

        void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void b() throws RemoteException;
    }

    static List<MediaBrowserCompat.MediaItem> b() {
        return null;
    }

    public abstract a a();

    final class g extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private final d f3827b = new d();

        g() {
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            Bundle data = message.getData();
            switch (message2.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    d dVar = this.f3827b;
                    String string = data.getString("data_package_name");
                    int i2 = data.getInt("data_calling_pid");
                    int i3 = data.getInt("data_calling_uid");
                    f fVar = new f(message2.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    boolean z = false;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i3);
                        int length = packagesForUid.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                if (packagesForUid[i4].equals(string)) {
                                    z = true;
                                } else {
                                    i4++;
                                }
                            }
                        }
                    }
                    if (z) {
                        MediaBrowserServiceCompat.this.f3755d.a(new Runnable(fVar, string, i2, i3, bundle) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f3786a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f3787b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ int f3788c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ int f3789d;

                            /* renamed from: e  reason: collision with root package name */
                            final /* synthetic */ Bundle f3790e;

                            {
                                this.f3786a = r2;
                                this.f3787b = r3;
                                this.f3788c = r4;
                                this.f3789d = r5;
                                this.f3790e = r6;
                            }

                            public final void run() {
                                IBinder a2 = this.f3786a.a();
                                MediaBrowserServiceCompat.this.f3753b.remove(a2);
                                b bVar = new b(this.f3787b, this.f3788c, this.f3789d, this.f3790e, this.f3786a);
                                MediaBrowserServiceCompat.this.f3754c = bVar;
                                bVar.f3777h = MediaBrowserServiceCompat.this.a();
                                MediaBrowserServiceCompat.this.f3754c = null;
                                if (bVar.f3777h == null) {
                                    StringBuilder sb = new StringBuilder("No root for client ");
                                    sb.append(this.f3787b);
                                    sb.append(" from service ");
                                    sb.append(getClass().getName());
                                    try {
                                        this.f3786a.b();
                                    } catch (RemoteException unused) {
                                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.f3787b);
                                    }
                                } else {
                                    try {
                                        MediaBrowserServiceCompat.this.f3753b.put(a2, bVar);
                                        a2.linkToDeath(bVar, 0);
                                        if (MediaBrowserServiceCompat.this.f3756e != null) {
                                            this.f3786a.a(bVar.f3777h.f3768a, MediaBrowserServiceCompat.this.f3756e, bVar.f3777h.f3769b);
                                        }
                                    } catch (RemoteException unused2) {
                                        new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.f3787b);
                                        MediaBrowserServiceCompat.this.f3753b.remove(a2);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + string);
                case 2:
                    d dVar2 = this.f3827b;
                    MediaBrowserServiceCompat.this.f3755d.a(new Runnable(new f(message2.replyTo)) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f3792a;

                        {
                            this.f3792a = r2;
                        }

                        public final void run() {
                            b remove = MediaBrowserServiceCompat.this.f3753b.remove(this.f3792a.a());
                            if (remove != null) {
                                remove.f3775f.a().unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    d dVar3 = this.f3827b;
                    String string2 = data.getString("data_media_item_id");
                    IBinder a2 = androidx.core.app.d.a(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.f3755d.a(new Runnable(new f(message2.replyTo), string2, a2, bundle2) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f3794a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ String f3795b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ IBinder f3796c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ Bundle f3797d;

                        {
                            this.f3794a = r2;
                            this.f3795b = r3;
                            this.f3796c = r4;
                            this.f3797d = r5;
                        }

                        public final void run() {
                            b bVar = MediaBrowserServiceCompat.this.f3753b.get(this.f3794a.a());
                            if (bVar == null) {
                                new StringBuilder("addSubscription for callback that isn't registered id=").append(this.f3795b);
                            } else {
                                MediaBrowserServiceCompat.this.a(this.f3795b, bVar, this.f3796c, this.f3797d);
                            }
                        }
                    });
                    return;
                case 4:
                    d dVar4 = this.f3827b;
                    String string3 = data.getString("data_media_item_id");
                    IBinder a3 = androidx.core.app.d.a(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.f3755d.a(new Runnable(new f(message2.replyTo), string3, a3) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f3799a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ String f3800b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ IBinder f3801c;

                        {
                            this.f3799a = r2;
                            this.f3800b = r3;
                            this.f3801c = r4;
                        }

                        public final void run() {
                            b bVar = MediaBrowserServiceCompat.this.f3753b.get(this.f3799a.a());
                            if (bVar == null) {
                                new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.f3800b);
                            } else if (!MediaBrowserServiceCompat.this.a(this.f3800b, bVar, this.f3801c)) {
                                StringBuilder sb = new StringBuilder("removeSubscription called for ");
                                sb.append(this.f3800b);
                                sb.append(" which is not subscribed");
                            }
                        }
                    });
                    return;
                case 5:
                    d dVar5 = this.f3827b;
                    String string4 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar2 = new f(message2.replyTo);
                    if (!TextUtils.isEmpty(string4) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.f3755d.a(new Runnable(fVar2, string4, resultReceiver) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f3803a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f3804b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ ResultReceiver f3805c;

                            {
                                this.f3803a = r2;
                                this.f3804b = r3;
                                this.f3805c = r4;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.f3753b.get(this.f3803a.a());
                                if (bVar == null) {
                                    new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.f3804b);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.f3804b;
                                AnonymousClass2 r4 = new c<MediaBrowserCompat.MediaItem>(str, this.f3805c) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f3762a;

                                    {
                                        this.f3762a = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void a() {
                                        if ((this.f3784i & 2) != 0) {
                                            this.f3762a.b(-1, (Bundle) null);
                                            return;
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("media_item", (Parcelable) null);
                                        this.f3762a.b(0, bundle);
                                    }
                                };
                                mediaBrowserServiceCompat.f3754c = bVar;
                                r4.f3784i = 2;
                                r4.c();
                                mediaBrowserServiceCompat.f3754c = null;
                                if (!r4.d()) {
                                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    d dVar6 = this.f3827b;
                    MediaBrowserServiceCompat.this.f3755d.a(new Runnable(new f(message2.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f3807a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ String f3808b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ int f3809c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ int f3810d;

                        /* renamed from: e  reason: collision with root package name */
                        final /* synthetic */ Bundle f3811e;

                        {
                            this.f3807a = r2;
                            this.f3808b = r3;
                            this.f3809c = r4;
                            this.f3810d = r5;
                            this.f3811e = r6;
                        }

                        public final void run() {
                            IBinder a2 = this.f3807a.a();
                            MediaBrowserServiceCompat.this.f3753b.remove(a2);
                            b bVar = new b(this.f3808b, this.f3809c, this.f3810d, this.f3811e, this.f3807a);
                            MediaBrowserServiceCompat.this.f3753b.put(a2, bVar);
                            try {
                                a2.linkToDeath(bVar, 0);
                            } catch (RemoteException unused) {
                            }
                        }
                    });
                    return;
                case 7:
                    d dVar7 = this.f3827b;
                    MediaBrowserServiceCompat.this.f3755d.a(new Runnable(new f(message2.replyTo)) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f3813a;

                        {
                            this.f3813a = r2;
                        }

                        public final void run() {
                            IBinder a2 = this.f3813a.a();
                            b remove = MediaBrowserServiceCompat.this.f3753b.remove(a2);
                            if (remove != null) {
                                a2.unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    d dVar8 = this.f3827b;
                    String string5 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar3 = new f(message2.replyTo);
                    if (!TextUtils.isEmpty(string5) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.f3755d.a(new Runnable(fVar3, string5, bundle4, resultReceiver2) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f3815a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f3816b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ Bundle f3817c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ ResultReceiver f3818d;

                            {
                                this.f3815a = r2;
                                this.f3816b = r3;
                                this.f3817c = r4;
                                this.f3818d = r5;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.f3753b.get(this.f3815a.a());
                                if (bVar == null) {
                                    new StringBuilder("search for callback that isn't registered query=").append(this.f3816b);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.f3816b;
                                AnonymousClass3 r4 = new c<List<MediaBrowserCompat.MediaItem>>(str, this.f3818d) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f3764a;

                                    {
                                        this.f3764a = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void a() {
                                        this.f3764a.b(-1, (Bundle) null);
                                    }
                                };
                                mediaBrowserServiceCompat.f3754c = bVar;
                                r4.f3784i = 4;
                                r4.c();
                                mediaBrowserServiceCompat.f3754c = null;
                                if (!r4.d()) {
                                    throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    d dVar9 = this.f3827b;
                    String string6 = data.getString("data_custom_action");
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar4 = new f(message2.replyTo);
                    if (!TextUtils.isEmpty(string6) && resultReceiver3 != null) {
                        MediaBrowserServiceCompat.this.f3755d.a(new Runnable(fVar4, string6, bundle5, resultReceiver3) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f3820a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f3821b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ Bundle f3822c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ ResultReceiver f3823d;

                            {
                                this.f3820a = r2;
                                this.f3821b = r3;
                                this.f3822c = r4;
                                this.f3823d = r5;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.f3753b.get(this.f3820a.a());
                                if (bVar == null) {
                                    StringBuilder sb = new StringBuilder("sendCustomAction for callback that isn't registered action=");
                                    sb.append(this.f3821b);
                                    sb.append(", extras=");
                                    sb.append(this.f3822c);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.f3821b;
                                Bundle bundle = this.f3822c;
                                AnonymousClass4 r5 = new c<Bundle>(str, this.f3823d) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f3766a;

                                    {
                                        this.f3766a = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final void b() {
                                        this.f3766a.b(-1, (Bundle) null);
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void a() {
                                        this.f3766a.b(0, (Bundle) null);
                                    }
                                };
                                mediaBrowserServiceCompat.f3754c = bVar;
                                if (r5.f3782g || r5.f3783h) {
                                    throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + r5.f3781f);
                                }
                                r5.f3783h = true;
                                r5.b();
                                mediaBrowserServiceCompat.f3754c = null;
                                if (!r5.d()) {
                                    throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
                                }
                            }
                        });
                        return;
                    }
                    return;
                default:
                    StringBuilder sb = new StringBuilder("Unhandled message: ");
                    sb.append(message2);
                    sb.append("\n  Service version: 2\n  Client version: ");
                    sb.append(message2.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        private void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    class b implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f3770a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3771b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3772c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f3773d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f3774e;

        /* renamed from: f  reason: collision with root package name */
        public final e f3775f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap<String, List<androidx.core.g.d<IBinder, Bundle>>> f3776g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public a f3777h;

        b(String str, int i2, int i3, Bundle bundle, e eVar) {
            this.f3770a = str;
            this.f3771b = i2;
            this.f3772c = i3;
            this.f3773d = new e.a(str, i2, i3);
            this.f3774e = bundle;
            this.f3775f = eVar;
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.f3755d.post(new Runnable() {
                public final void run() {
                    MediaBrowserServiceCompat.this.f3753b.remove(b.this.f3775f.a());
                }
            });
        }
    }

    public static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3780a;

        /* renamed from: f  reason: collision with root package name */
        final Object f3781f;

        /* renamed from: g  reason: collision with root package name */
        boolean f3782g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3783h;

        /* renamed from: i  reason: collision with root package name */
        int f3784i;

        /* access modifiers changed from: package-private */
        public void a() {
        }

        c(Object obj) {
            this.f3781f = obj;
        }

        public final void c() {
            if (this.f3782g || this.f3783h) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f3781f);
            }
            this.f3782g = true;
            a();
        }

        /* access modifiers changed from: package-private */
        public final boolean d() {
            return this.f3780a || this.f3782g || this.f3783h;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f3781f);
        }
    }

    class d {
        d() {
        }
    }

    static class f implements e {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f3825a;

        f(Messenger messenger) {
            this.f3825a = messenger;
        }

        public final IBinder a() {
            return this.f3825a.getBinder();
        }

        public final void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        public final void b() throws RemoteException {
            a(2, (Bundle) null);
        }

        public final void a(String str, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            a(3, bundle3);
        }

        private void a(int i2, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f3825a.send(obtain);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.g.d> list = bVar.f3776g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (androidx.core.g.d dVar : list) {
            if (iBinder == dVar.f2964a && d.a(bundle, (Bundle) dVar.f2965b)) {
                return;
            }
        }
        list.add(new androidx.core.g.d(iBinder, bundle));
        bVar.f3776g.put(str, list);
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass1 r1 = new c<List<MediaBrowserCompat.MediaItem>>(str) {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bundle f3760d = null;

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void a() {
                if (MediaBrowserServiceCompat.this.f3753b.get(bVar2.f3775f.a()) == bVar2) {
                    if ((this.f3784i & 1) != 0) {
                        MediaBrowserServiceCompat.b();
                    }
                    try {
                        bVar2.f3775f.a(str2, bundle2, this.f3760d);
                    } catch (RemoteException unused) {
                        StringBuilder sb = new StringBuilder("Calling onLoadChildren() failed for id=");
                        sb.append(str2);
                        sb.append(" package=");
                        sb.append(bVar2.f3770a);
                    }
                } else if (MediaBrowserServiceCompat.f3752a) {
                    StringBuilder sb2 = new StringBuilder("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb2.append(bVar2.f3770a);
                    sb2.append(" id=");
                    sb2.append(str2);
                }
            }
        };
        this.f3754c = bVar;
        if (bundle != null) {
            r1.f3784i = 1;
        }
        this.f3754c = null;
        if (r1.d()) {
            this.f3754c = bVar;
            this.f3754c = null;
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.f3770a + " id=" + str);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, b bVar, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (bVar.f3776g.remove(str) == null) {
                    z = false;
                }
                return z;
            } finally {
                this.f3754c = bVar;
                this.f3754c = null;
            }
        } else {
            List list = bVar.f3776g.get(str);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == ((androidx.core.g.d) it2.next()).f2964a) {
                        it2.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.f3776g.remove(str);
                }
            }
            this.f3754c = bVar;
            this.f3754c = null;
            return z2;
        }
    }
}
