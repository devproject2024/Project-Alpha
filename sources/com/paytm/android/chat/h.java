package com.paytm.android.chat;

import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.db.room.db_entities.UserExtendedMetaDataEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.g;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.x;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    final String f42159a = "metadata_update";

    /* renamed from: b  reason: collision with root package name */
    final long f42160b = Long.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    final String f42161c = "_DETAILS_CHANNEL";

    /* renamed from: d  reason: collision with root package name */
    final f f42162d = new f();

    /* renamed from: e  reason: collision with root package name */
    io.reactivex.rxjava3.b.c f42163e;

    static final class b<T> implements g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42257a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f42259a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class e<T> implements g<io.reactivex.rxjava3.b.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42292a;

        e(h hVar) {
            this.f42292a = hVar;
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
            this.f42292a.f42163e = (io.reactivex.rxjava3.b.c) obj;
        }
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f42165b;

        a(h hVar, List list) {
            this.f42164a = hVar;
            this.f42165b = list;
        }

        /* renamed from: com.paytm.android.chat.h$a$a  reason: collision with other inner class name */
        public static final class C0699a implements OpenChannel.OpenChannelGetHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f42175a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f42176b;

            C0699a(String str, a aVar) {
                this.f42175a = str;
                this.f42176b = aVar;
            }

            public final void onResult(final OpenChannel openChannel, SendBirdException sendBirdException) {
                io.reactivex.rxjava3.i.a.a().a((Runnable) new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ C0699a f42183a;

                    {
                        this.f42183a = r1;
                    }

                    public final void run() {
                        try {
                            if (openChannel != null) {
                                openChannel.getPreviousMessagesByTimestamp(this.f42183a.f42176b.f42164a.f42160b, true, 1, true, BaseChannel.MessageTypeFilter.ALL, this.f42183a.f42176b.f42164a.f42159a, new BaseChannel.GetMessagesHandler(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AnonymousClass1 f42185a;

                                    {
                                        this.f42185a = r1;
                                    }

                                    public final void onResult(final List<BaseMessage> list, SendBirdException sendBirdException) {
                                        io.reactivex.rxjava3.i.a.a().a((Runnable) new Runnable(this) {

                                            /* renamed from: a  reason: collision with root package name */
                                            final /* synthetic */ AnonymousClass1 f42186a;

                                            {
                                                this.f42186a = r1;
                                            }

                                            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
                                                r0 = (com.sendbird.android.BaseMessage) kotlin.a.k.e(r0);
                                             */
                                            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
                                                r1 = com.paytm.android.chat.f.a(r1);
                                             */
                                            /* Code decompiled incorrectly, please refer to instructions dump. */
                                            public final void run() {
                                                /*
                                                    r4 = this;
                                                    java.util.List r0 = r2     // Catch:{ Exception -> 0x0028 }
                                                    if (r0 == 0) goto L_0x0028
                                                    java.lang.Object r0 = kotlin.a.k.e(r0)     // Catch:{ Exception -> 0x0028 }
                                                    com.sendbird.android.BaseMessage r0 = (com.sendbird.android.BaseMessage) r0     // Catch:{ Exception -> 0x0028 }
                                                    if (r0 == 0) goto L_0x0028
                                                    if (r0 == 0) goto L_0x0028
                                                    java.lang.String r1 = r0.getData()     // Catch:{ Exception -> 0x0028 }
                                                    if (r1 == 0) goto L_0x0028
                                                    java.lang.String r1 = com.paytm.android.chat.f.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0028 }
                                                    if (r1 == 0) goto L_0x0028
                                                    io.reactivex.rxjava3.a.x r2 = io.reactivex.rxjava3.i.a.b()     // Catch:{ Exception -> 0x0028 }
                                                    com.paytm.android.chat.h$a$a$1$1$1$1 r3 = new com.paytm.android.chat.h$a$a$1$1$1$1     // Catch:{ Exception -> 0x0028 }
                                                    r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x0028 }
                                                    java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x0028 }
                                                    r2.a((java.lang.Runnable) r3)     // Catch:{ Exception -> 0x0028 }
                                                L_0x0028:
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.C0699a.AnonymousClass1.AnonymousClass1.AnonymousClass1.run():void");
                                            }
                                        });
                                    }
                                });
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }

        public final /* synthetic */ Object call() {
            String str;
            try {
                for (ChatGroupChannelDataModel otherMember : this.f42165b) {
                    ChatManager b2 = ChatManager.b();
                    k.a((Object) b2, "ChatManager.getInstance()");
                    ChatUserDataModel otherMember2 = b2.a().getOtherMember(otherMember);
                    if (otherMember2 == null || (str = otherMember2.getSendbirdUserId()) == null) {
                        str = "";
                    }
                    OpenChannel.getChannel(str + this.f42164a.f42161c, new C0699a(str, this));
                }
            } catch (Exception unused) {
            }
            return x.f47997a;
        }
    }

    public final y<UserExtendedMetaData> a(String str) {
        k.c(str, "userId");
        io.reactivex.rxjava3.b.c cVar = this.f42163e;
        if (cVar != null) {
            cVar.dispose();
        }
        y<UserExtendedMetaData> a2 = y.a(new d(this, str)).a((g<? super io.reactivex.rxjava3.b.c>) new e(this));
        k.a((Object) a2, "Single.create<UserExtend…edMetaData = it\n        }");
        return a2;
    }

    static final class d<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42281a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f42282b;

        d(h hVar, String str) {
            this.f42281a = hVar;
            this.f42282b = str;
        }

        public final void subscribe(final z<UserExtendedMetaData> zVar) {
            UserExtendedMetaDataEntity userExtendedMetaDataById = DBManager.INSTANCE.getUserExtendedMetaDataById(this.f42282b);
            UserExtendedMetaData metaData = userExtendedMetaDataById != null ? userExtendedMetaDataById.getMetaData() : null;
            if (metaData != null) {
                k.a((Object) zVar, "emitter");
                f.a(zVar, metaData);
                return;
            }
            OpenChannel.getChannel(this.f42282b + this.f42281a.f42161c, new OpenChannel.OpenChannelGetHandler(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f42283a;

                {
                    this.f42283a = r1;
                }

                /* renamed from: com.paytm.android.chat.h$d$1$a */
                static final class a implements Runnable {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f42285a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ SendBirdException f42286b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ OpenChannel f42287c;

                    a(AnonymousClass1 r1, SendBirdException sendBirdException, OpenChannel openChannel) {
                        this.f42285a = r1;
                        this.f42286b = sendBirdException;
                        this.f42287c = openChannel;
                    }

                    public final void run() {
                        if (this.f42286b != null) {
                            z zVar = zVar;
                            k.a((Object) zVar, "emitter");
                            f.a(zVar, (Throwable) this.f42286b);
                            return;
                        }
                        OpenChannel openChannel = this.f42287c;
                        if (openChannel != null) {
                            openChannel.getPreviousMessagesByTimestamp(this.f42285a.f42283a.f42281a.f42160b, true, 1, true, BaseChannel.MessageTypeFilter.ALL, this.f42285a.f42283a.f42281a.f42159a, new BaseChannel.GetMessagesHandler(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ a f42288a;

                                {
                                    this.f42288a = r1;
                                }

                                /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
                                    r5 = (r5 = (com.sendbird.android.BaseMessage) kotlin.a.k.e(r4)).getData();
                                 */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onResult(java.util.List<com.sendbird.android.BaseMessage> r4, com.sendbird.android.SendBirdException r5) {
                                    /*
                                        r3 = this;
                                        java.lang.String r0 = "emitter"
                                        if (r5 == 0) goto L_0x0013
                                        com.paytm.android.chat.h$d$1$a r4 = r3.f42288a
                                        com.paytm.android.chat.h$d$1 r4 = r4.f42285a
                                        io.reactivex.rxjava3.a.z r4 = r3
                                        kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                                        java.lang.Throwable r5 = (java.lang.Throwable) r5
                                        com.paytm.android.chat.f.a(r4, (java.lang.Throwable) r5)
                                        return
                                    L_0x0013:
                                        if (r4 == 0) goto L_0x0028
                                        java.lang.Object r5 = kotlin.a.k.e(r4)
                                        com.sendbird.android.BaseMessage r5 = (com.sendbird.android.BaseMessage) r5
                                        if (r5 == 0) goto L_0x0028
                                        java.lang.String r5 = r5.getData()
                                        if (r5 == 0) goto L_0x0028
                                        java.lang.String r5 = com.paytm.android.chat.f.a((java.lang.String) r5)
                                        goto L_0x0029
                                    L_0x0028:
                                        r5 = 0
                                    L_0x0029:
                                        if (r5 == 0) goto L_0x0078
                                        java.lang.Object r4 = kotlin.a.k.d(r4)     // Catch:{ Exception -> 0x0064 }
                                        com.sendbird.android.BaseMessage r4 = (com.sendbird.android.BaseMessage) r4     // Catch:{ Exception -> 0x0064 }
                                        java.lang.String r5 = r4.getData()     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h$d$1$a r1 = r3.f42288a     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h$d$1 r1 = r1.f42285a     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h$d r1 = r1.f42283a     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h r1 = r1.f42281a     // Catch:{ Exception -> 0x0064 }
                                        com.google.gsonhtcfix.f r1 = r1.f42162d     // Catch:{ Exception -> 0x0064 }
                                        java.lang.Class<com.paytm.android.chat.bean.UserExtendedMetaData> r2 = com.paytm.android.chat.bean.UserExtendedMetaData.class
                                        java.lang.Object r1 = r1.a((java.lang.String) r5, r2)     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.bean.UserExtendedMetaData r1 = (com.paytm.android.chat.bean.UserExtendedMetaData) r1     // Catch:{ Exception -> 0x0064 }
                                        if (r1 == 0) goto L_0x0063
                                        com.paytm.android.chat.h$d$1$a r2 = r3.f42288a     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h$d$1 r2 = r2.f42285a     // Catch:{ Exception -> 0x0064 }
                                        io.reactivex.rxjava3.a.z r2 = r3     // Catch:{ Exception -> 0x0064 }
                                        kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.f.a(r2, r1)     // Catch:{ Exception -> 0x0064 }
                                        io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.i.a.b()     // Catch:{ Exception -> 0x0064 }
                                        com.paytm.android.chat.h$d$1$a$1$a r2 = new com.paytm.android.chat.h$d$1$a$1$a     // Catch:{ Exception -> 0x0064 }
                                        r2.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0064 }
                                        java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ Exception -> 0x0064 }
                                        r1.a((java.lang.Runnable) r2)     // Catch:{ Exception -> 0x0064 }
                                    L_0x0063:
                                        return
                                    L_0x0064:
                                        com.paytm.android.chat.h$d$1$a r4 = r3.f42288a
                                        com.paytm.android.chat.h$d$1 r4 = r4.f42285a
                                        io.reactivex.rxjava3.a.z r4 = r3
                                        kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                                        java.lang.Exception r5 = new java.lang.Exception
                                        r5.<init>()
                                        java.lang.Throwable r5 = (java.lang.Throwable) r5
                                        com.paytm.android.chat.f.a(r4, (java.lang.Throwable) r5)
                                        return
                                    L_0x0078:
                                        com.paytm.android.chat.h$d$1$a r4 = r3.f42288a
                                        com.paytm.android.chat.h$d$1 r4 = r4.f42285a
                                        io.reactivex.rxjava3.a.z r4 = r3
                                        kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                                        java.lang.Exception r5 = new java.lang.Exception
                                        r5.<init>()
                                        java.lang.Throwable r5 = (java.lang.Throwable) r5
                                        com.paytm.android.chat.f.a(r4, (java.lang.Throwable) r5)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.d.AnonymousClass1.a.AnonymousClass1.onResult(java.util.List, com.sendbird.android.SendBirdException):void");
                                }

                                /* renamed from: com.paytm.android.chat.h$d$1$a$1$a  reason: collision with other inner class name */
                                static final class C0704a implements Runnable {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AnonymousClass1 f42289a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ BaseMessage f42290b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ String f42291c;

                                    C0704a(AnonymousClass1 r1, BaseMessage baseMessage, String str) {
                                        this.f42289a = r1;
                                        this.f42290b = baseMessage;
                                        this.f42291c = str;
                                    }

                                    public final void run() {
                                        int i2 = (this.f42290b.getUpdatedAt() > 0 ? 1 : (this.f42290b.getUpdatedAt() == 0 ? 0 : -1));
                                        BaseMessage baseMessage = this.f42290b;
                                        DBManager.INSTANCE.insertOrReplaceExtendedMetaData(this.f42289a.f42288a.f42285a.f42283a.f42282b, this.f42291c, i2 == 0 ? baseMessage.getCreatedAt() : baseMessage.getUpdatedAt());
                                    }
                                }
                            });
                            return;
                        }
                        z zVar2 = zVar;
                        k.a((Object) zVar2, "emitter");
                        f.a(zVar2, (Throwable) new Exception());
                    }
                }

                public final void onResult(OpenChannel openChannel, SendBirdException sendBirdException) {
                    io.reactivex.rxjava3.i.a.a().a((Runnable) new a(this, sendBirdException, openChannel));
                }
            });
        }
    }
}
