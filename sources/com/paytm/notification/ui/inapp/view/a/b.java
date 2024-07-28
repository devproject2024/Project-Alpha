package com.paytm.notification.ui.inapp.view.a;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.paytm.notification.j;
import com.paytm.notification.models.FlashMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43370a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static FlashMessage f43371e;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public FlashMessage f43372b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f43373c;

    /* renamed from: d  reason: collision with root package name */
    private final Timer f43374d = new Timer();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f43375f;

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r13 = "inflater"
            kotlin.g.b.k.c(r11, r13)
            int r13 = com.paytm.notification.R.layout.flash_box_view
            r0 = 0
            android.view.View r11 = r11.inflate(r13, r12, r0)
            r12 = 0
            android.os.Bundle r13 = r10.getArguments()     // Catch:{ Exception -> 0x0020 }
            if (r13 == 0) goto L_0x001c
            java.lang.String r1 = "flash_message"
            android.os.Parcelable r13 = r13.getParcelable(r1)     // Catch:{ Exception -> 0x0020 }
            com.paytm.notification.models.FlashMessage r13 = (com.paytm.notification.models.FlashMessage) r13     // Catch:{ Exception -> 0x0020 }
            goto L_0x001d
        L_0x001c:
            r13 = r12
        L_0x001d:
            r10.f43372b = r13     // Catch:{ Exception -> 0x0020 }
            goto L_0x002c
        L_0x0020:
            r13 = move-exception
            com.paytm.notification.models.FlashMessage r1 = f43371e
            r10.f43372b = r1
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            r1.b(r13)
        L_0x002c:
            f43371e = r12
            int r13 = com.paytm.notification.R.id.root
            android.view.View r13 = r11.findViewById(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            int r1 = com.paytm.notification.R.id.dismiss
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = com.paytm.notification.R.id.msg_text
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.paytm.notification.R.id.action_btn
            android.view.View r3 = r11.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.paytm.notification.R.id.root
            android.view.View r4 = r11.findViewById(r4)
            java.lang.String r5 = "view.findViewById<Relati…m.notification.R.id.root)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r10.f43373c = r4
            java.lang.String r4 = "msgText"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            com.paytm.notification.models.FlashMessage r4 = r10.f43372b
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            java.lang.String r4 = "Thanks for using Paytm!!"
        L_0x0070:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            com.paytm.notification.models.FlashMessage r4 = r10.f43372b
            java.lang.String r5 = "root"
            java.lang.String r6 = "null cannot be cast to non-null type android.app.Activity"
            if (r4 == 0) goto L_0x00db
            java.lang.String r4 = r4.getPosition()
            if (r4 == 0) goto L_0x00db
            java.lang.String r7 = "top"
            boolean r4 = r4.equals(r7)
            r7 = 1
            if (r4 != r7) goto L_0x00db
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r7 = -1
            r8 = -2
            r4.<init>(r7, r8)
            com.paytm.notification.c.g$a r7 = com.paytm.notification.c.g.f43031a
            androidx.fragment.app.FragmentActivity r7 = r10.getActivity()
            if (r7 == 0) goto L_0x00d5
            android.app.Activity r7 = (android.app.Activity) r7
            android.content.Context r7 = (android.content.Context) r7
            r8 = 1101004800(0x41a00000, float:20.0)
            float r7 = com.paytm.notification.c.g.a.a(r7, r8)
            com.paytm.notification.c.g$a r8 = com.paytm.notification.c.g.f43031a
            androidx.fragment.app.FragmentActivity r8 = r10.getActivity()
            if (r8 == 0) goto L_0x00cf
            android.app.Activity r8 = (android.app.Activity) r8
            android.content.Context r8 = (android.content.Context) r8
            r9 = 1092616192(0x41200000, float:10.0)
            float r8 = com.paytm.notification.c.g.a.a(r8, r9)
            r9 = 48
            r4.gravity = r9
            int r7 = (int) r7
            r4.topMargin = r7
            r4.bottomMargin = r7
            int r7 = (int) r8
            r4.rightMargin = r7
            r4.leftMargin = r7
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r5)
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r13.setLayoutParams(r4)
            goto L_0x00db
        L_0x00cf:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x00d5:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x00db:
            com.paytm.notification.j r4 = com.paytm.notification.j.f43241a
            com.paytm.notification.data.c.h r4 = r4.c()
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 == 0) goto L_0x013a
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 != 0) goto L_0x00f0
            kotlin.g.b.k.a()
        L_0x00f0:
            java.lang.Integer r7 = r7.getFlashPrimaryColorFromResource$paytmnotification_paytmRelease()
            if (r7 == 0) goto L_0x013a
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 != 0) goto L_0x00ff
            kotlin.g.b.k.a()
        L_0x00ff:
            java.lang.Integer r7 = r7.getFlashPrimaryColorFromResource$paytmnotification_paytmRelease()
            if (r7 != 0) goto L_0x0106
            goto L_0x010c
        L_0x0106:
            int r7 = r7.intValue()
            if (r7 == 0) goto L_0x013a
        L_0x010c:
            androidx.fragment.app.FragmentActivity r7 = r10.getActivity()
            if (r7 == 0) goto L_0x0134
            android.app.Activity r7 = (android.app.Activity) r7
            android.content.Context r7 = (android.content.Context) r7
            com.paytm.notification.models.NotificationProjectConfig r8 = r4.g()
            if (r8 != 0) goto L_0x011f
            kotlin.g.b.k.a()
        L_0x011f:
            java.lang.Integer r8 = r8.getFlashPrimaryColorFromResource$paytmnotification_paytmRelease()
            if (r8 != 0) goto L_0x0128
            kotlin.g.b.k.a()
        L_0x0128:
            int r8 = r8.intValue()
            int r7 = androidx.core.content.b.c(r7, r8)
            r2.setTextColor(r7)
            goto L_0x0168
        L_0x0134:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x013a:
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 == 0) goto L_0x0168
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 != 0) goto L_0x0149
            kotlin.g.b.k.a()
        L_0x0149:
            java.lang.Integer r7 = r7.getFlashPrimaryColor$paytmnotification_paytmRelease()
            if (r7 == 0) goto L_0x0168
            com.paytm.notification.models.NotificationProjectConfig r7 = r4.g()
            if (r7 != 0) goto L_0x0158
            kotlin.g.b.k.a()
        L_0x0158:
            java.lang.Integer r7 = r7.getFlashPrimaryColor$paytmnotification_paytmRelease()
            if (r7 != 0) goto L_0x0161
            kotlin.g.b.k.a()
        L_0x0161:
            int r7 = r7.intValue()
            r2.setTextColor(r7)
        L_0x0168:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r5)
            android.graphics.drawable.Drawable r13 = r13.getBackground()
            if (r13 == 0) goto L_0x028e
            android.graphics.drawable.GradientDrawable r13 = (android.graphics.drawable.GradientDrawable) r13
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 == 0) goto L_0x01cc
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 != 0) goto L_0x0182
            kotlin.g.b.k.a()
        L_0x0182:
            java.lang.Integer r2 = r2.getFlashSecondaryColorFromResource$paytmnotification_paytmRelease()
            if (r2 == 0) goto L_0x01cc
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 != 0) goto L_0x0191
            kotlin.g.b.k.a()
        L_0x0191:
            java.lang.Integer r2 = r2.getFlashSecondaryColorFromResource$paytmnotification_paytmRelease()
            if (r2 != 0) goto L_0x0198
            goto L_0x019e
        L_0x0198:
            int r2 = r2.intValue()
            if (r2 == 0) goto L_0x01cc
        L_0x019e:
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            if (r2 == 0) goto L_0x01c6
            android.app.Activity r2 = (android.app.Activity) r2
            android.content.Context r2 = (android.content.Context) r2
            com.paytm.notification.models.NotificationProjectConfig r4 = r4.g()
            if (r4 != 0) goto L_0x01b1
            kotlin.g.b.k.a()
        L_0x01b1:
            java.lang.Integer r4 = r4.getFlashSecondaryColorFromResource$paytmnotification_paytmRelease()
            if (r4 != 0) goto L_0x01ba
            kotlin.g.b.k.a()
        L_0x01ba:
            int r4 = r4.intValue()
            int r2 = androidx.core.content.b.c(r2, r4)
            r13.setColor(r2)
            goto L_0x01fa
        L_0x01c6:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x01cc:
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 == 0) goto L_0x01fa
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 != 0) goto L_0x01db
            kotlin.g.b.k.a()
        L_0x01db:
            java.lang.Integer r2 = r2.getFlashSecondaryColor$paytmnotification_paytmRelease()
            if (r2 == 0) goto L_0x01fa
            com.paytm.notification.models.NotificationProjectConfig r2 = r4.g()
            if (r2 != 0) goto L_0x01ea
            kotlin.g.b.k.a()
        L_0x01ea:
            java.lang.Integer r2 = r2.getFlashSecondaryColor$paytmnotification_paytmRelease()
            if (r2 != 0) goto L_0x01f3
            kotlin.g.b.k.a()
        L_0x01f3:
            int r2 = r2.intValue()
            r13.setColor(r2)
        L_0x01fa:
            com.paytm.notification.ui.inapp.view.a.b$c r13 = new com.paytm.notification.ui.inapp.view.a.b$c
            r13.<init>(r10)
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r1.setOnClickListener(r13)
            android.widget.RelativeLayout r13 = r10.f43373c
            if (r13 != 0) goto L_0x020d
            java.lang.String r1 = "rootLayout"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x020d:
            com.paytm.notification.ui.inapp.view.a.b$d r1 = new com.paytm.notification.ui.inapp.view.a.b$d
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r13.setOnClickListener(r1)
            com.paytm.notification.models.FlashMessage r13 = r10.f43372b
            if (r13 == 0) goto L_0x0264
            java.util.HashMap r13 = r13.getActions()
            if (r13 == 0) goto L_0x0264
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x0264
            com.paytm.notification.models.FlashMessage r13 = r10.f43372b
            if (r13 == 0) goto L_0x0244
            java.util.HashMap r13 = r13.getActions()
            if (r13 == 0) goto L_0x0244
            java.util.Map r13 = (java.util.Map) r13
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
            if (r13 == 0) goto L_0x0244
            java.lang.Object r13 = r13.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            goto L_0x0245
        L_0x0244:
            r13 = r12
        L_0x0245:
            java.lang.String r1 = "action"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            if (r13 == 0) goto L_0x0252
            java.lang.Object r12 = r13.getKey()
            java.lang.String r12 = (java.lang.String) r12
        L_0x0252:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r3.setText(r12)
            r3.setVisibility(r0)
            com.paytm.notification.ui.inapp.view.a.b$e r12 = new com.paytm.notification.ui.inapp.view.a.b$e
            r12.<init>(r10, r13)
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            r3.setOnClickListener(r12)
        L_0x0264:
            com.paytm.notification.models.FlashMessage r12 = r10.f43372b
            if (r12 == 0) goto L_0x0271
            int r12 = r12.getDisplayPeriodInSecs()
            if (r12 != 0) goto L_0x0271
            r12 = 10000(0x2710, double:4.9407E-320)
            goto L_0x0281
        L_0x0271:
            com.paytm.notification.models.FlashMessage r12 = r10.f43372b
            if (r12 != 0) goto L_0x0278
            kotlin.g.b.k.a()
        L_0x0278:
            int r12 = r12.getDisplayPeriodInSecs()
            long r12 = (long) r12
            r0 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r0
        L_0x0281:
            com.paytm.notification.ui.inapp.view.a.b$g r0 = new com.paytm.notification.ui.inapp.view.a.b$g
            r0.<init>(r10)
            java.util.Timer r1 = r10.f43374d
            java.util.TimerTask r0 = (java.util.TimerTask) r0
            r1.schedule(r0, r12)
            return r11
        L_0x028e:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.inapp.view.a.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43377a;

        c(b bVar) {
            this.f43377a = bVar;
        }

        public final void onClick(View view) {
            this.f43377a.a(true);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43378a;

        d(b bVar) {
            this.f43378a = bVar;
        }

        public final void onClick(View view) {
            b bVar = this.f43378a;
            k.a((Object) view, "it");
            b.a(bVar, (String) null);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43379a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map.Entry f43380b;

        e(b bVar, Map.Entry entry) {
            this.f43379a = bVar;
            this.f43380b = entry;
        }

        public final void onClick(View view) {
            b bVar = this.f43379a;
            k.a((Object) view, "it");
            Map.Entry entry = this.f43380b;
            b.a(bVar, entry != null ? (String) entry.getValue() : null);
        }
    }

    public static final class g extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43382a;

        g(b bVar) {
            this.f43382a = bVar;
        }

        public final void run() {
            this.f43382a.a(false);
        }
    }

    public final void onDestroyView() {
        this.f43374d.cancel();
        super.onDestroyView();
        HashMap hashMap = this.f43375f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: com.paytm.notification.ui.inapp.view.a.b$b  reason: collision with other inner class name */
    static final class C0732b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43376a;

        C0732b(b bVar) {
            this.f43376a = bVar;
        }

        public final void run() {
            String str;
            com.paytm.notification.data.c.b a2 = j.f43241a.a();
            FlashMessage a3 = this.f43376a.f43372b;
            String pushId = a3 != null ? a3.getPushId() : null;
            if (pushId == null) {
                k.a();
            }
            FlashMessage a4 = this.f43376a.f43372b;
            if (a4 == null || (str = a4.getCampaignId()) == null) {
                str = "";
            }
            a2.c(pushId, str);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r0.getApplicationContext();
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ Exception -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r5) {
        /*
            r4 = this;
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 == 0) goto L_0x0092
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()     // Catch:{ Exception -> 0x008a }
            r1 = 0
            if (r0 == 0) goto L_0x0018
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getPackageName()     // Catch:{ Exception -> 0x008a }
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x0027
            int r2 = r2.length()     // Catch:{ Exception -> 0x008a }
            if (r2 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r2 = 0
            goto L_0x0028
        L_0x0027:
            r2 = 1
        L_0x0028:
            if (r2 != 0) goto L_0x0069
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x008a }
            java.lang.String r3 = "com.paytm.notification.OnFlashDismissed"
            r2.<init>(r3)     // Catch:{ Exception -> 0x008a }
            android.content.Intent r2 = r2.addCategory(r0)     // Catch:{ Exception -> 0x008a }
            android.content.Intent r0 = r2.setPackage(r0)     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = "Intent(INTENT_FLASH_DISM… .setPackage(packageName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x008a }
            androidx.fragment.app.FragmentActivity r2 = r4.getActivity()     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x004d
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x004d
            r2.sendOrderedBroadcast(r0, r1)     // Catch:{ Exception -> 0x008a }
        L_0x004d:
            com.paytm.notification.schedulers.b$a r0 = com.paytm.notification.schedulers.b.f43250b     // Catch:{ Exception -> 0x008a }
            com.paytm.notification.schedulers.c r0 = com.paytm.notification.schedulers.b.a.a()     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0058
            r0.c()     // Catch:{ Exception -> 0x008a }
        L_0x0058:
            if (r5 == 0) goto L_0x0069
            java.lang.Thread r5 = new java.lang.Thread     // Catch:{ Exception -> 0x008a }
            com.paytm.notification.ui.inapp.view.a.b$f r0 = new com.paytm.notification.ui.inapp.view.a.b$f     // Catch:{ Exception -> 0x008a }
            r0.<init>(r4)     // Catch:{ Exception -> 0x008a }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ Exception -> 0x008a }
            r5.<init>(r0)     // Catch:{ Exception -> 0x008a }
            r5.start()     // Catch:{ Exception -> 0x008a }
        L_0x0069:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()     // Catch:{ Exception -> 0x008a }
            if (r5 != 0) goto L_0x0072
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x008a }
        L_0x0072:
            java.lang.String r0 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x008a }
            androidx.fragment.app.j r5 = r5.getSupportFragmentManager()     // Catch:{ Exception -> 0x008a }
            androidx.fragment.app.q r5 = r5.a()     // Catch:{ Exception -> 0x008a }
            r0 = r4
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ Exception -> 0x008a }
            androidx.fragment.app.q r5 = r5.a((androidx.fragment.app.Fragment) r0)     // Catch:{ Exception -> 0x008a }
            r5.c()     // Catch:{ Exception -> 0x008a }
            return
        L_0x008a:
            r5 = move-exception
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r0.b(r5)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.inapp.view.a.b.a(boolean):void");
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43381a;

        f(b bVar) {
            this.f43381a = bVar;
        }

        public final void run() {
            String str;
            com.paytm.notification.data.c.b a2 = j.f43241a.a();
            FlashMessage a3 = this.f43381a.f43372b;
            String pushId = a3 != null ? a3.getPushId() : null;
            if (pushId == null) {
                k.a();
            }
            FlashMessage a4 = this.f43381a.f43372b;
            if (a4 == null || (str = a4.getCampaignId()) == null) {
                str = "";
            }
            a2.e(pushId, str);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(FlashMessage flashMessage) {
            k.c(flashMessage, "flashMessage");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putParcelable("flash_message", flashMessage);
            b.f43371e = flashMessage;
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r5 = r5.getPushBundle();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ Exception -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.paytm.notification.ui.inapp.view.a.b r4, java.lang.String r5) {
        /*
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x006b }
            com.paytm.notification.ui.inapp.view.a.b$b r1 = new com.paytm.notification.ui.inapp.view.a.b$b     // Catch:{ Exception -> 0x006b }
            r1.<init>(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ Exception -> 0x006b }
            r0.<init>(r1)     // Catch:{ Exception -> 0x006b }
            r0.start()     // Catch:{ Exception -> 0x006b }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x006b }
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L_0x0046
            com.paytm.notification.models.FlashMessage r5 = r4.f43372b     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x002c
            android.os.Bundle r5 = r5.getPushBundle()     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x002c
            java.lang.String r3 = "url"
            java.lang.String r5 = r5.getString(r3)     // Catch:{ Exception -> 0x004d }
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x004d }
            if (r3 == 0) goto L_0x003b
            int r3 = r3.length()     // Catch:{ Exception -> 0x004d }
            if (r3 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r3 = 0
            goto L_0x003c
        L_0x003b:
            r3 = 1
        L_0x003c:
            if (r3 != 0) goto L_0x004d
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x004d }
            r0.setData(r5)     // Catch:{ Exception -> 0x004d }
            goto L_0x004d
        L_0x0046:
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x004d }
            r0.setData(r5)     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            r4.a((boolean) r2)     // Catch:{ Exception -> 0x006b }
            android.net.Uri r5 = r0.getData()     // Catch:{ Exception -> 0x006b }
            if (r5 == 0) goto L_0x0073
            android.net.Uri r5 = r0.getData()     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = ""
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ Exception -> 0x006b }
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x0073
            r4.startActivity(r0)     // Catch:{ Exception -> 0x006b }
            return
        L_0x006b:
            r4 = move-exception
            com.paytm.notification.b.e$b r5 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5.b(r4)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.inapp.view.a.b.a(com.paytm.notification.ui.inapp.view.a.b, java.lang.String):void");
    }
}
