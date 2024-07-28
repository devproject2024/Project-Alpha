package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class h {

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        PendingIntent f2712a;

        /* renamed from: b  reason: collision with root package name */
        PendingIntent f2713b;

        /* renamed from: c  reason: collision with root package name */
        IconCompat f2714c;

        /* renamed from: d  reason: collision with root package name */
        int f2715d;

        /* renamed from: e  reason: collision with root package name */
        int f2716e;

        /* renamed from: f  reason: collision with root package name */
        int f2717f;
    }

    public static class e {
        String A;
        Bundle B;
        public int C;
        public int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        public String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        d O;
        public Notification P;
        boolean Q;
        @Deprecated
        public ArrayList<String> R;

        /* renamed from: a  reason: collision with root package name */
        public Context f2718a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f2719b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f2720c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f2721d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f2722e;

        /* renamed from: f  reason: collision with root package name */
        public PendingIntent f2723f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f2724g;

        /* renamed from: h  reason: collision with root package name */
        RemoteViews f2725h;

        /* renamed from: i  reason: collision with root package name */
        Bitmap f2726i;
        CharSequence j;
        public int k;
        public int l;
        public boolean m;
        boolean n;
        C0039h o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        public boolean x;
        boolean y;
        boolean z;

        public e(Context context, String str) {
            this.f2719b = new ArrayList<>();
            this.f2720c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.P = new Notification();
            this.f2718a = context;
            this.I = str;
            this.P.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.R = new ArrayList<>();
            this.N = true;
        }

        @Deprecated
        public e(Context context) {
            this(context, (String) null);
        }

        public final e a(long j2) {
            this.P.when = j2;
            return this;
        }

        public final e a(int i2) {
            this.P.icon = i2;
            return this;
        }

        public final e a(CharSequence charSequence) {
            this.f2721d = e(charSequence);
            return this;
        }

        public final e b(CharSequence charSequence) {
            this.f2722e = e(charSequence);
            return this;
        }

        public final e c(CharSequence charSequence) {
            this.p = e(charSequence);
            return this;
        }

        public final e a(PendingIntent pendingIntent) {
            this.f2723f = pendingIntent;
            return this;
        }

        public final e d(CharSequence charSequence) {
            this.P.tickerText = e(charSequence);
            return this;
        }

        public final e a(Uri uri) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.P.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public final e b(int i2) {
            Notification notification = this.P;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public final e a() {
            this.l = 0;
            return this;
        }

        public final e a(String str) {
            this.u = str;
            return this;
        }

        public final e b() {
            this.v = true;
            return this;
        }

        public final Bundle c() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public final e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2719b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public final e a(C0039h hVar) {
            if (this.o != hVar) {
                this.o = hVar;
                C0039h hVar2 = this.o;
                if (hVar2 != null) {
                    hVar2.a(this);
                }
            }
            return this;
        }

        public final e c(int i2) {
            this.C = i2;
            return this;
        }

        public final e b(String str) {
            this.I = str;
            return this;
        }

        public final Notification d() {
            Notification notification;
            Bundle a2;
            i iVar = new i(this);
            C0039h hVar = iVar.f2743b.o;
            if (hVar != null) {
                hVar.a((g) iVar);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                notification = iVar.f2742a.build();
            } else if (Build.VERSION.SDK_INT >= 24) {
                notification = iVar.f2742a.build();
                if (iVar.f2748g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || iVar.f2748g != 2)) {
                        i.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && iVar.f2748g == 1) {
                        i.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                iVar.f2742a.setExtras(iVar.f2747f);
                notification = iVar.f2742a.build();
                if (iVar.f2744c != null) {
                    notification.contentView = iVar.f2744c;
                }
                if (iVar.f2745d != null) {
                    notification.bigContentView = iVar.f2745d;
                }
                if (iVar.f2749h != null) {
                    notification.headsUpContentView = iVar.f2749h;
                }
                if (iVar.f2748g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || iVar.f2748g != 2)) {
                        i.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && iVar.f2748g == 1) {
                        i.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
                iVar.f2742a.setExtras(iVar.f2747f);
                notification = iVar.f2742a.build();
                if (iVar.f2744c != null) {
                    notification.contentView = iVar.f2744c;
                }
                if (iVar.f2745d != null) {
                    notification.bigContentView = iVar.f2745d;
                }
                if (iVar.f2748g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || iVar.f2748g != 2)) {
                        i.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && iVar.f2748g == 1) {
                        i.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 19) {
                SparseArray<Bundle> a3 = j.a(iVar.f2746e);
                if (a3 != null) {
                    iVar.f2747f.putSparseParcelableArray("android.support.actionExtras", a3);
                }
                iVar.f2742a.setExtras(iVar.f2747f);
                notification = iVar.f2742a.build();
                if (iVar.f2744c != null) {
                    notification.contentView = iVar.f2744c;
                }
                if (iVar.f2745d != null) {
                    notification.bigContentView = iVar.f2745d;
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                notification = iVar.f2742a.build();
                Bundle a4 = h.a(notification);
                Bundle bundle = new Bundle(iVar.f2747f);
                for (String str : iVar.f2747f.keySet()) {
                    if (a4.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a4.putAll(bundle);
                SparseArray<Bundle> a5 = j.a(iVar.f2746e);
                if (a5 != null) {
                    h.a(notification).putSparseParcelableArray("android.support.actionExtras", a5);
                }
                if (iVar.f2744c != null) {
                    notification.contentView = iVar.f2744c;
                }
                if (iVar.f2745d != null) {
                    notification.bigContentView = iVar.f2745d;
                }
            } else {
                notification = iVar.f2742a.getNotification();
            }
            if (iVar.f2743b.F != null) {
                notification.contentView = iVar.f2743b.F;
            }
            int i2 = Build.VERSION.SDK_INT;
            int i3 = Build.VERSION.SDK_INT;
            if (!(Build.VERSION.SDK_INT < 16 || hVar == null || (a2 = h.a(notification)) == null)) {
                hVar.a(a2);
            }
            return notification;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public final e a(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f2718a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
                }
            }
            this.f2726i = bitmap;
            return this;
        }

        public final e a(boolean z2) {
            if (z2) {
                this.P.flags |= 16;
            } else {
                this.P.flags &= -17;
            }
            return this;
        }
    }

    /* renamed from: androidx.core.app.h$h  reason: collision with other inner class name */
    public static abstract class C0039h {

        /* renamed from: b  reason: collision with root package name */
        protected e f2738b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2739c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f2740d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2741e = false;

        public void a(Bundle bundle) {
        }

        public void a(g gVar) {
        }

        public final void a(e eVar) {
            if (this.f2738b != eVar) {
                this.f2738b = eVar;
                e eVar2 = this.f2738b;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
            }
        }
    }

    public static class b extends C0039h {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f2708a;

        /* renamed from: f  reason: collision with root package name */
        private Bitmap f2709f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2710g;

        public final b a(CharSequence charSequence) {
            this.f2740d = e.e(charSequence);
            this.f2741e = true;
            return this;
        }

        public final b a(Bitmap bitmap) {
            this.f2708a = bitmap;
            return this;
        }

        public final b a() {
            this.f2709f = null;
            this.f2710g = true;
            return this;
        }

        public final void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(gVar.a()).setBigContentTitle(this.f2739c).bigPicture(this.f2708a);
                if (this.f2710g) {
                    bigPicture.bigLargeIcon(this.f2709f);
                }
                if (this.f2741e) {
                    bigPicture.setSummaryText(this.f2740d);
                }
            }
        }
    }

    public static class c extends C0039h {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f2711a;

        public final c a(CharSequence charSequence) {
            this.f2711a = e.e(charSequence);
            return this;
        }

        public final void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f2739c).bigText(this.f2711a);
                if (this.f2741e) {
                    bigText.setSummaryText(this.f2740d);
                }
            }
        }
    }

    public static class g extends C0039h {

        /* renamed from: a  reason: collision with root package name */
        private final List<a> f2728a = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private l f2729f;

        /* renamed from: g  reason: collision with root package name */
        private CharSequence f2730g;

        /* renamed from: h  reason: collision with root package name */
        private Boolean f2731h;

        private g() {
        }

        public g(l lVar) {
            if (!TextUtils.isEmpty(lVar.f2781a)) {
                this.f2729f = lVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public final g a(CharSequence charSequence, long j, l lVar) {
            this.f2728a.add(new a(charSequence, j, lVar));
            if (this.f2728a.size() > 25) {
                this.f2728a.remove(0);
            }
            return this;
        }

        private a a() {
            for (int size = this.f2728a.size() - 1; size >= 0; size--) {
                a aVar = this.f2728a.get(size);
                if (aVar.f2734c != null && !TextUtils.isEmpty(aVar.f2734c.f2781a)) {
                    return aVar;
                }
            }
            if (this.f2728a.isEmpty()) {
                return null;
            }
            List<a> list = this.f2728a;
            return list.get(list.size() - 1);
        }

        private boolean b() {
            for (int size = this.f2728a.size() - 1; size >= 0; size--) {
                a aVar = this.f2728a.get(size);
                if (aVar.f2734c != null && aVar.f2734c.f2781a == null) {
                    return true;
                }
            }
            return false;
        }

        private CharSequence a(a aVar) {
            CharSequence charSequence;
            androidx.core.f.a a2 = androidx.core.f.a.a();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = Build.VERSION.SDK_INT >= 21;
            int i2 = z ? -16777216 : -1;
            CharSequence charSequence2 = "";
            if (aVar.f2734c == null) {
                charSequence = charSequence2;
            } else {
                charSequence = aVar.f2734c.f2781a;
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.f2729f.f2781a;
                if (z && this.f2738b.C != 0) {
                    i2 = this.f2738b.C;
                }
            }
            CharSequence a3 = a2.a(charSequence);
            spannableStringBuilder.append(a3);
            spannableStringBuilder.setSpan(a(i2), spannableStringBuilder.length() - a3.length(), spannableStringBuilder.length(), 33);
            if (aVar.f2732a != null) {
                charSequence2 = aVar.f2732a;
            }
            spannableStringBuilder.append("  ").append(a2.a(charSequence2));
            return spannableStringBuilder;
        }

        private static TextAppearanceSpan a(int i2) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i2), (ColorStateList) null);
        }

        public final void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f2729f.f2781a);
            bundle.putBundle("android.messagingStyleUser", this.f2729f.a());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f2730g);
            if (this.f2730g != null && this.f2731h.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f2730g);
            }
            if (!this.f2728a.isEmpty()) {
                List<a> list = this.f2728a;
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar = list.get(i2);
                    Bundle bundle2 = new Bundle();
                    if (aVar.f2732a != null) {
                        bundle2.putCharSequence(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, aVar.f2732a);
                    }
                    bundle2.putLong("time", aVar.f2733b);
                    if (aVar.f2734c != null) {
                        bundle2.putCharSequence("sender", aVar.f2734c.f2781a);
                        if (Build.VERSION.SDK_INT >= 28) {
                            bundle2.putParcelable("sender_person", aVar.f2734c.b());
                        } else {
                            bundle2.putBundle("person", aVar.f2734c.a());
                        }
                    }
                    if (aVar.f2736e != null) {
                        bundle2.putString("type", aVar.f2736e);
                    }
                    if (aVar.f2737f != null) {
                        bundle2.putParcelable("uri", aVar.f2737f);
                    }
                    if (aVar.f2735d != null) {
                        bundle2.putBundle("extras", aVar.f2735d);
                    }
                    bundleArr[i2] = bundle2;
                }
                bundle.putParcelableArray("android.messages", bundleArr);
            }
            Boolean bool = this.f2731h;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            final CharSequence f2732a;

            /* renamed from: b  reason: collision with root package name */
            final long f2733b;

            /* renamed from: c  reason: collision with root package name */
            final l f2734c;

            /* renamed from: d  reason: collision with root package name */
            Bundle f2735d = new Bundle();

            /* renamed from: e  reason: collision with root package name */
            String f2736e;

            /* renamed from: f  reason: collision with root package name */
            Uri f2737f;

            public a(CharSequence charSequence, long j, l lVar) {
                this.f2732a = charSequence;
                this.f2733b = j;
                this.f2734c = lVar;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(androidx.core.app.g r11) {
            /*
                r10 = this;
                androidx.core.app.h$e r0 = r10.f2738b
                r1 = 1
                r2 = 0
                r3 = 28
                if (r0 == 0) goto L_0x001e
                androidx.core.app.h$e r0 = r10.f2738b
                android.content.Context r0 = r0.f2718a
                android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
                int r0 = r0.targetSdkVersion
                if (r0 >= r3) goto L_0x001e
                java.lang.Boolean r0 = r10.f2731h
                if (r0 != 0) goto L_0x001e
                java.lang.CharSequence r0 = r10.f2730g
                if (r0 == 0) goto L_0x0027
                r0 = 1
                goto L_0x0028
            L_0x001e:
                java.lang.Boolean r0 = r10.f2731h
                if (r0 == 0) goto L_0x0027
                boolean r0 = r0.booleanValue()
                goto L_0x0028
            L_0x0027:
                r0 = 0
            L_0x0028:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                r10.f2731h = r0
                int r0 = android.os.Build.VERSION.SDK_INT
                r4 = 24
                r5 = 0
                if (r0 < r4) goto L_0x00c0
                int r0 = android.os.Build.VERSION.SDK_INT
                if (r0 < r3) goto L_0x0045
                android.app.Notification$MessagingStyle r0 = new android.app.Notification$MessagingStyle
                androidx.core.app.l r1 = r10.f2729f
                android.app.Person r1 = r1.b()
                r0.<init>(r1)
                goto L_0x004e
            L_0x0045:
                android.app.Notification$MessagingStyle r0 = new android.app.Notification$MessagingStyle
                androidx.core.app.l r1 = r10.f2729f
                java.lang.CharSequence r1 = r1.f2781a
                r0.<init>(r1)
            L_0x004e:
                java.lang.Boolean r1 = r10.f2731h
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x005a
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r3) goto L_0x005f
            L_0x005a:
                java.lang.CharSequence r1 = r10.f2730g
                r0.setConversationTitle(r1)
            L_0x005f:
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r3) goto L_0x006c
                java.lang.Boolean r1 = r10.f2731h
                boolean r1 = r1.booleanValue()
                r0.setGroupConversation(r1)
            L_0x006c:
                java.util.List<androidx.core.app.h$g$a> r1 = r10.f2728a
                java.util.Iterator r1 = r1.iterator()
            L_0x0072:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00b8
                java.lang.Object r2 = r1.next()
                androidx.core.app.h$g$a r2 = (androidx.core.app.h.g.a) r2
                int r4 = android.os.Build.VERSION.SDK_INT
                if (r4 < r3) goto L_0x0096
                androidx.core.app.l r4 = r2.f2734c
                android.app.Notification$MessagingStyle$Message r6 = new android.app.Notification$MessagingStyle$Message
                java.lang.CharSequence r7 = r2.f2732a
                long r8 = r2.f2733b
                if (r4 != 0) goto L_0x008e
                r4 = r5
                goto L_0x0092
            L_0x008e:
                android.app.Person r4 = r4.b()
            L_0x0092:
                r6.<init>(r7, r8, r4)
                goto L_0x00a9
            L_0x0096:
                androidx.core.app.l r4 = r2.f2734c
                if (r4 == 0) goto L_0x009f
                androidx.core.app.l r4 = r2.f2734c
                java.lang.CharSequence r4 = r4.f2781a
                goto L_0x00a0
            L_0x009f:
                r4 = r5
            L_0x00a0:
                android.app.Notification$MessagingStyle$Message r6 = new android.app.Notification$MessagingStyle$Message
                java.lang.CharSequence r7 = r2.f2732a
                long r8 = r2.f2733b
                r6.<init>(r7, r8, r4)
            L_0x00a9:
                java.lang.String r4 = r2.f2736e
                if (r4 == 0) goto L_0x00b4
                java.lang.String r4 = r2.f2736e
                android.net.Uri r2 = r2.f2737f
                r6.setData(r4, r2)
            L_0x00b4:
                r0.addMessage(r6)
                goto L_0x0072
            L_0x00b8:
                android.app.Notification$Builder r11 = r11.a()
                r0.setBuilder(r11)
                return
            L_0x00c0:
                androidx.core.app.h$g$a r0 = r10.a()
                java.lang.CharSequence r3 = r10.f2730g
                if (r3 == 0) goto L_0x00da
                java.lang.Boolean r3 = r10.f2731h
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L_0x00da
                android.app.Notification$Builder r3 = r11.a()
                java.lang.CharSequence r4 = r10.f2730g
                r3.setContentTitle(r4)
                goto L_0x00f4
            L_0x00da:
                if (r0 == 0) goto L_0x00f4
                android.app.Notification$Builder r3 = r11.a()
                java.lang.String r4 = ""
                r3.setContentTitle(r4)
                androidx.core.app.l r3 = r0.f2734c
                if (r3 == 0) goto L_0x00f4
                android.app.Notification$Builder r3 = r11.a()
                androidx.core.app.l r4 = r0.f2734c
                java.lang.CharSequence r4 = r4.f2781a
                r3.setContentTitle(r4)
            L_0x00f4:
                if (r0 == 0) goto L_0x0108
                android.app.Notification$Builder r3 = r11.a()
                java.lang.CharSequence r4 = r10.f2730g
                if (r4 == 0) goto L_0x0103
                java.lang.CharSequence r0 = r10.a((androidx.core.app.h.g.a) r0)
                goto L_0x0105
            L_0x0103:
                java.lang.CharSequence r0 = r0.f2732a
            L_0x0105:
                r3.setContentText(r0)
            L_0x0108:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 16
                if (r0 < r3) goto L_0x015f
                android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
                r0.<init>()
                java.lang.CharSequence r3 = r10.f2730g
                if (r3 != 0) goto L_0x0120
                boolean r3 = r10.b()
                if (r3 == 0) goto L_0x011e
                goto L_0x0120
            L_0x011e:
                r3 = 0
                goto L_0x0121
            L_0x0120:
                r3 = 1
            L_0x0121:
                java.util.List<androidx.core.app.h$g$a> r4 = r10.f2728a
                int r4 = r4.size()
                int r4 = r4 - r1
            L_0x0128:
                if (r4 < 0) goto L_0x014f
                java.util.List<androidx.core.app.h$g$a> r6 = r10.f2728a
                java.lang.Object r6 = r6.get(r4)
                androidx.core.app.h$g$a r6 = (androidx.core.app.h.g.a) r6
                if (r3 == 0) goto L_0x0139
                java.lang.CharSequence r6 = r10.a((androidx.core.app.h.g.a) r6)
                goto L_0x013b
            L_0x0139:
                java.lang.CharSequence r6 = r6.f2732a
            L_0x013b:
                java.util.List<androidx.core.app.h$g$a> r7 = r10.f2728a
                int r7 = r7.size()
                int r7 = r7 - r1
                if (r4 == r7) goto L_0x0149
                java.lang.String r7 = "\n"
                r0.insert(r2, r7)
            L_0x0149:
                r0.insert(r2, r6)
                int r4 = r4 + -1
                goto L_0x0128
            L_0x014f:
                android.app.Notification$BigTextStyle r1 = new android.app.Notification$BigTextStyle
                android.app.Notification$Builder r11 = r11.a()
                r1.<init>(r11)
                android.app.Notification$BigTextStyle r11 = r1.setBigContentTitle(r5)
                r11.bigText(r0)
            L_0x015f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.h.g.a(androidx.core.app.g):void");
        }
    }

    public static class f extends C0039h {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<CharSequence> f2727a = new ArrayList<>();

        public final f a(CharSequence charSequence) {
            this.f2740d = e.e(charSequence);
            this.f2741e = true;
            return this;
        }

        public final void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(gVar.a()).setBigContentTitle(this.f2739c);
                if (this.f2741e) {
                    bigContentTitle.setSummaryText(this.f2740d);
                }
                Iterator<CharSequence> it2 = this.f2727a.iterator();
                while (it2.hasNext()) {
                    bigContentTitle.addLine(it2.next());
                }
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2699a;

        /* renamed from: b  reason: collision with root package name */
        final m[] f2700b;

        /* renamed from: c  reason: collision with root package name */
        final m[] f2701c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2702d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2703e;

        /* renamed from: f  reason: collision with root package name */
        final int f2704f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f2705g;
        @Deprecated

        /* renamed from: h  reason: collision with root package name */
        public int f2706h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f2707i;
        public PendingIntent j;
        private IconCompat k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.a((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        private a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle());
        }

        private a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            int i2;
            this.f2703e = true;
            this.k = iconCompat;
            if (iconCompat != null) {
                if (iconCompat.f2984a != -1 || Build.VERSION.SDK_INT < 23) {
                    i2 = iconCompat.f2984a;
                } else {
                    i2 = IconCompat.a((Icon) iconCompat.f2985b);
                }
                if (i2 == 2) {
                    this.f2706h = iconCompat.b();
                }
            }
            this.f2707i = e.e(charSequence);
            this.j = pendingIntent;
            this.f2699a = bundle;
            this.f2700b = null;
            this.f2701c = null;
            this.f2702d = true;
            this.f2704f = 0;
            this.f2703e = true;
            this.f2705g = false;
        }

        public final IconCompat a() {
            int i2;
            if (this.k == null && (i2 = this.f2706h) != 0) {
                this.k = IconCompat.a((Resources) null, "", i2);
            }
            return this.k;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return j.a(notification);
        }
        return null;
    }
}
