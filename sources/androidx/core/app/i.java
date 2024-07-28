package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    final Notification.Builder f2742a;

    /* renamed from: b  reason: collision with root package name */
    final h.e f2743b;

    /* renamed from: c  reason: collision with root package name */
    RemoteViews f2744c;

    /* renamed from: d  reason: collision with root package name */
    RemoteViews f2745d;

    /* renamed from: e  reason: collision with root package name */
    final List<Bundle> f2746e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    final Bundle f2747f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    int f2748g;

    /* renamed from: h  reason: collision with root package name */
    RemoteViews f2749h;

    i(h.e eVar) {
        Notification.BubbleMetadata bubbleMetadata;
        this.f2743b = eVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2742a = new Notification.Builder(eVar.f2718a, eVar.I);
        } else {
            this.f2742a = new Notification.Builder(eVar.f2718a);
        }
        Notification notification = eVar.P;
        boolean z = false;
        this.f2742a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f2725h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f2721d).setContentText(eVar.f2722e).setContentInfo(eVar.j).setContentIntent(eVar.f2723f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f2724g, (notification.flags & 128) != 0).setLargeIcon(eVar.f2726i).setNumber(eVar.k).setProgress(eVar.r, eVar.s, eVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2742a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2742a.setSubText(eVar.p).setUsesChronometer(eVar.n).setPriority(eVar.l);
            Iterator<h.a> it2 = eVar.f2719b.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
            if (eVar.B != null) {
                this.f2747f.putAll(eVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.x) {
                    this.f2747f.putBoolean("android.support.localOnly", true);
                }
                if (eVar.u != null) {
                    this.f2747f.putString("android.support.groupKey", eVar.u);
                    if (eVar.v) {
                        this.f2747f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f2747f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (eVar.w != null) {
                    this.f2747f.putString("android.support.sortKey", eVar.w);
                }
            }
            this.f2744c = eVar.F;
            this.f2745d = eVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2742a.setShowWhen(eVar.m);
            if (Build.VERSION.SDK_INT < 21 && eVar.R != null && !eVar.R.isEmpty()) {
                this.f2747f.putStringArray("android.people", (String[]) eVar.R.toArray(new String[eVar.R.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2742a.setLocalOnly(eVar.x).setGroup(eVar.u).setGroupSummary(eVar.v).setSortKey(eVar.w);
            this.f2748g = eVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2742a.setCategory(eVar.A).setColor(eVar.C).setVisibility(eVar.D).setPublicVersion(eVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it3 = eVar.R.iterator();
            while (it3.hasNext()) {
                this.f2742a.addPerson(it3.next());
            }
            this.f2749h = eVar.H;
            if (eVar.f2720c.size() > 0) {
                Bundle bundle = eVar.c().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i2 = 0; i2 < eVar.f2720c.size(); i2++) {
                    bundle2.putBundle(Integer.toString(i2), j.a(eVar.f2720c.get(i2)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                eVar.c().putBundle("android.car.EXTENSIONS", bundle);
                this.f2747f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2742a.setExtras(eVar.B).setRemoteInputHistory(eVar.q);
            if (eVar.F != null) {
                this.f2742a.setCustomContentView(eVar.F);
            }
            if (eVar.G != null) {
                this.f2742a.setCustomBigContentView(eVar.G);
            }
            if (eVar.H != null) {
                this.f2742a.setCustomHeadsUpContentView(eVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2742a.setBadgeIconType(eVar.J).setShortcutId(eVar.K).setTimeoutAfter(eVar.L).setGroupAlertBehavior(eVar.M);
            if (eVar.z) {
                this.f2742a.setColorized(eVar.y);
            }
            if (!TextUtils.isEmpty(eVar.I)) {
                this.f2742a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2742a.setAllowSystemGeneratedContextualActions(eVar.N);
            Notification.Builder builder = this.f2742a;
            h.d dVar = eVar.O;
            if (dVar == null) {
                bubbleMetadata = null;
            } else {
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble((dVar.f2717f & 1) != 0).setDeleteIntent(dVar.f2713b).setIcon(dVar.f2714c.a((Context) null)).setIntent(dVar.f2712a).setSuppressNotification((dVar.f2717f & 2) != 0 ? true : z);
                if (dVar.f2715d != 0) {
                    suppressNotification.setDesiredHeight(dVar.f2715d);
                }
                if (dVar.f2716e != 0) {
                    suppressNotification.setDesiredHeightResId(dVar.f2716e);
                }
                bubbleMetadata = suppressNotification.build();
            }
            builder.setBubbleMetadata(bubbleMetadata);
        }
        if (eVar.Q) {
            if (this.f2743b.v) {
                this.f2748g = 2;
            } else {
                this.f2748g = 1;
            }
            this.f2742a.setVibrate((long[]) null);
            this.f2742a.setSound((Uri) null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f2742a.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f2743b.u)) {
                    this.f2742a.setGroup("silent");
                }
                this.f2742a.setGroupAlertBehavior(this.f2748g);
            }
        }
    }

    public final Notification.Builder a() {
        return this.f2742a;
    }

    private void a(h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat a2 = aVar.a();
            if (Build.VERSION.SDK_INT >= 23) {
                Icon icon = null;
                if (a2 != null) {
                    icon = a2.a((Context) null);
                }
                builder = new Notification.Action.Builder(icon, aVar.f2707i, aVar.j);
            } else {
                if (a2 != null) {
                    i2 = a2.b();
                } else {
                    i2 = 0;
                }
                builder = new Notification.Action.Builder(i2, aVar.f2707i, aVar.j);
            }
            if (aVar.f2700b != null) {
                for (RemoteInput addRemoteInput : m.a(aVar.f2700b)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.f2699a != null) {
                bundle = new Bundle(aVar.f2699a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f2702d);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.f2702d);
            }
            bundle.putInt("android.support.action.semanticAction", aVar.f2704f);
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.f2704f);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.f2705g);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.f2703e);
            builder.addExtras(bundle);
            this.f2742a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f2746e.add(j.a(this.f2742a, aVar));
        }
    }

    static void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
