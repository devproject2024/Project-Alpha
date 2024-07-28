package net.one97.paytm.feed.ui.feed.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.b.q;
import net.one97.paytm.feed.repository.models.cricket.FeedCricket;
import net.one97.paytm.feed.repository.models.cricket.FeedScore;

public final class a extends net.one97.paytm.feed.ui.base.b<q, FeedCricket, b> {

    /* renamed from: b  reason: collision with root package name */
    String f35016b;

    /* renamed from: c  reason: collision with root package name */
    private long f35017c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a f35018d;

    static final class b extends l implements kotlin.g.a.b<FeedScore, x> {
        final /* synthetic */ String $awayTeamAbbr;
        final /* synthetic */ String $awayTeamId;
        final /* synthetic */ String $awayTeamLogo;
        final /* synthetic */ String $homeTeamAbbr;
        final /* synthetic */ String $homeTeamId;
        final /* synthetic */ String $homeTeamLogo;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, String str2, String str3, String str4, String str5, String str6) {
            super(1);
            this.this$0 = aVar;
            this.$homeTeamId = str;
            this.$homeTeamLogo = str2;
            this.$homeTeamAbbr = str3;
            this.$awayTeamId = str4;
            this.$awayTeamLogo = str5;
            this.$awayTeamAbbr = str6;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedScore) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
            r4 = (r4 = r4.f35022d).getFeedCricketData();
         */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0121  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(net.one97.paytm.feed.repository.models.cricket.FeedScore r14) {
            /*
                r13 = this;
                java.lang.String r0 = "dataBinding.feedCricketHeaderInfo"
                java.lang.String r1 = ""
                if (r14 == 0) goto L_0x04e1
                net.one97.paytm.feed.ui.feed.c.a r2 = r13.this$0
                B r2 = r2.f34872a
                net.one97.paytm.feed.b.q r2 = (net.one97.paytm.feed.b.q) r2
                net.one97.paytm.feed.ui.feed.c.a r3 = r13.this$0
                java.lang.String r4 = r14.getResulttype()
                r3.f35016b = r4
                net.one97.paytm.feed.ui.feed.c.a r3 = r13.this$0
                B r3 = r3.f34872a
                net.one97.paytm.feed.b.q r3 = (net.one97.paytm.feed.b.q) r3
                android.widget.TextView r3 = r3.f34206a
                java.lang.String r4 = "dataBinding.feedCricketHeader"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                net.one97.paytm.feed.ui.feed.c.b r4 = r2.a()
                r5 = 0
                if (r4 == 0) goto L_0x0037
                net.one97.paytm.feed.repository.models.cricket.FeedCricket r4 = r4.f35022d
                if (r4 == 0) goto L_0x0037
                net.one97.paytm.feed.repository.models.cricket.FeedCricketData r4 = r4.getFeedCricketData()
                if (r4 == 0) goto L_0x0037
                java.lang.String r4 = r4.getTitle()
                goto L_0x0038
            L_0x0037:
                r4 = r5
            L_0x0038:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r3.setText(r4)
                net.one97.paytm.feed.ui.feed.c.b r2 = r2.a()     // Catch:{ Exception -> 0x0087 }
                if (r2 == 0) goto L_0x0061
                net.one97.paytm.feed.repository.models.cricket.FeedCricket r2 = r2.f35022d     // Catch:{ Exception -> 0x0087 }
                if (r2 == 0) goto L_0x0061
                net.one97.paytm.feed.repository.models.cricket.FeedCricketData r2 = r2.getFeedCricketData()     // Catch:{ Exception -> 0x0087 }
                if (r2 == 0) goto L_0x0061
                java.lang.String r2 = r2.getDescription()     // Catch:{ Exception -> 0x0087 }
                if (r2 == 0) goto L_0x0061
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0087 }
                java.lang.String r3 = "|"
                java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x0087 }
                java.util.List r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.String[]) r3)     // Catch:{ Exception -> 0x0087 }
                goto L_0x0062
            L_0x0061:
                r2 = r5
            L_0x0062:
                if (r2 == 0) goto L_0x006d
                int r3 = r2.size()     // Catch:{ Exception -> 0x0088 }
                if (r3 == 0) goto L_0x006b
                goto L_0x006d
            L_0x006b:
                r3 = r5
                goto L_0x0076
            L_0x006d:
                if (r2 == 0) goto L_0x006b
                r3 = 0
                java.lang.Object r3 = r2.get(r3)     // Catch:{ Exception -> 0x0088 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0088 }
            L_0x0076:
                net.one97.paytm.feed.ui.feed.c.a r4 = r13.this$0     // Catch:{ Exception -> 0x0088 }
                B r4 = r4.f34872a     // Catch:{ Exception -> 0x0088 }
                net.one97.paytm.feed.b.q r4 = (net.one97.paytm.feed.b.q) r4     // Catch:{ Exception -> 0x0088 }
                android.widget.TextView r4 = r4.f34207b     // Catch:{ Exception -> 0x0088 }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x0088 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0088 }
                r4.setText(r3)     // Catch:{ Exception -> 0x0088 }
                goto L_0x0099
            L_0x0087:
                r2 = r5
            L_0x0088:
                net.one97.paytm.feed.ui.feed.c.a r3 = r13.this$0
                B r3 = r3.f34872a
                net.one97.paytm.feed.b.q r3 = (net.one97.paytm.feed.b.q) r3
                android.widget.TextView r3 = r3.f34207b
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                r0 = r1
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r3.setText(r0)
            L_0x0099:
                java.lang.Integer r0 = r14.getInnings()
                r3 = 1
                java.lang.String r4 = "dataBinding.teamWinningInfo"
                java.lang.String r6 = "-/-"
                java.lang.String r7 = "dataBinding.team2Overs"
                java.lang.String r8 = "dataBinding.team2Score"
                java.lang.String r9 = "dataBinding.team1Overs"
                java.lang.String r10 = "dataBinding.team1Score"
                if (r0 != 0) goto L_0x00ad
                goto L_0x0121
            L_0x00ad:
                int r0 = r0.intValue()
                r11 = -1
                if (r0 != r11) goto L_0x0121
                net.one97.paytm.feed.ui.feed.c.a r14 = r13.this$0
                B r14 = r14.f34872a
                net.one97.paytm.feed.b.q r14 = (net.one97.paytm.feed.b.q) r14
                android.widget.TextView r14 = r14.f34212g
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
                r0 = r6
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r14.setText(r0)
                net.one97.paytm.feed.ui.feed.c.a r14 = r13.this$0
                B r14 = r14.f34872a
                net.one97.paytm.feed.b.q r14 = (net.one97.paytm.feed.b.q) r14
                android.widget.TextView r14 = r14.f34211f
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r9)
                r0 = r1
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r14.setText(r0)
                net.one97.paytm.feed.ui.feed.c.a r14 = r13.this$0
                B r14 = r14.f34872a
                net.one97.paytm.feed.b.q r14 = (net.one97.paytm.feed.b.q) r14
                android.widget.TextView r14 = r14.k
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r14.setText(r6)
                net.one97.paytm.feed.ui.feed.c.a r14 = r13.this$0
                B r14 = r14.f34872a
                net.one97.paytm.feed.b.q r14 = (net.one97.paytm.feed.b.q) r14
                android.widget.TextView r14 = r14.j
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r14.setText(r1)
                if (r2 == 0) goto L_0x0106
                int r14 = r2.size()
                r0 = 2
                if (r14 != r0) goto L_0x0106
                java.lang.Object r14 = r2.get(r3)
                r5 = r14
                java.lang.String r5 = (java.lang.String) r5
            L_0x0106:
                net.one97.paytm.feed.ui.feed.c.a r14 = r13.this$0
                B r14 = r14.f34872a
                net.one97.paytm.feed.b.q r14 = (net.one97.paytm.feed.b.q) r14
                android.widget.TextView r14 = r14.l
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
                java.lang.String r0 = java.lang.String.valueOf(r5)
                java.lang.String r1 = "Match starts at "
                java.lang.String r0 = r1.concat(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r14.setText(r0)
                return
            L_0x0121:
                java.lang.Integer r0 = r14.getInnings()
                java.lang.String r1 = "dataBinding.team2Logo"
                java.lang.String r2 = "dataBinding.team1Logo"
                java.lang.String r5 = " Overs"
                java.lang.String r11 = "/"
                java.lang.String r12 = "-1"
                if (r0 != 0) goto L_0x0133
                goto L_0x02b6
            L_0x0133:
                int r0 = r0.intValue()
                if (r0 != 0) goto L_0x02b6
                java.lang.Integer r0 = r14.getBatteamname()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r3 = r13.$homeTeamId     // Catch:{ Exception -> 0x02b5 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x02b5 }
                if (r0 != 0) goto L_0x0147
                goto L_0x01ee
            L_0x0147:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x02b5 }
                if (r0 != r3) goto L_0x01ee
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.ImageView r0 = r0.f34209d     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r13.$homeTeamLogo     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.utility.a.a(r0, r1, r12, r12)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34210e     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = "dataBinding.team1Name"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r13.$homeTeamAbbr     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34212g     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x02b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b5 }
                r1.<init>()     // Catch:{ Exception -> 0x02b5 }
                java.lang.Integer r2 = r14.getBatteamruns()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r11)     // Catch:{ Exception -> 0x02b5 }
                java.lang.Integer r2 = r14.getBatteamwkts()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34211f     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x02b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b5 }
                r1.<init>()     // Catch:{ Exception -> 0x02b5 }
                java.lang.Float r2 = r14.getBatteamovers()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r5)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.k     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r6)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.j     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = "Yet to bat"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                goto L_0x02a1
            L_0x01ee:
                java.lang.Integer r0 = r14.getBatteamname()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = r13.$awayTeamId     // Catch:{ Exception -> 0x02b5 }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x02b5 }
                if (r0 != 0) goto L_0x01fc
                goto L_0x02a1
            L_0x01fc:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x02b5 }
                if (r0 != r2) goto L_0x02a1
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.ImageView r0 = r0.f34213h     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r13.$awayTeamLogo     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.utility.a.a(r0, r1, r12, r12)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34214i     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = "dataBinding.team2Name"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r13.$awayTeamAbbr     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.k     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x02b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b5 }
                r1.<init>()     // Catch:{ Exception -> 0x02b5 }
                java.lang.Integer r2 = r14.getBatteamruns()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r11)     // Catch:{ Exception -> 0x02b5 }
                java.lang.Integer r2 = r14.getBatteamwkts()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.j     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x02b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b5 }
                r1.<init>()     // Catch:{ Exception -> 0x02b5 }
                java.lang.Float r2 = r14.getBatteamovers()     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r2)     // Catch:{ Exception -> 0x02b5 }
                r1.append(r5)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34212g     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r6)     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.f34211f     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r1 = "Yet to bat"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r1)     // Catch:{ Exception -> 0x02b5 }
            L_0x02a1:
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x02b5 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x02b5 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x02b5 }
                android.widget.TextView r0 = r0.l     // Catch:{ Exception -> 0x02b5 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x02b5 }
                java.lang.String r14 = r14.getStatus()     // Catch:{ Exception -> 0x02b5 }
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x02b5 }
                r0.setText(r14)     // Catch:{ Exception -> 0x02b5 }
            L_0x02b5:
                return
            L_0x02b6:
                java.lang.Integer r0 = r14.getInnings()
                if (r0 != 0) goto L_0x02bd
                return
            L_0x02bd:
                int r0 = r0.intValue()
                if (r0 != r3) goto L_0x04e1
                java.lang.Integer r0 = r14.getBatteamname()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r3 = r13.$homeTeamId     // Catch:{ Exception -> 0x04e1 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x04e1 }
                if (r0 != 0) goto L_0x02d1
                goto L_0x03c9
            L_0x02d1:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x04e1 }
                if (r0 != r3) goto L_0x03c9
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.ImageView r0 = r0.f34209d     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r13.$homeTeamLogo     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.utility.a.a(r0, r1, r12, r12)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34210e     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = "dataBinding.team1Name"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r13.$homeTeamAbbr     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34212g     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getBatteamruns()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r11)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getBatteamwkts()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34211f     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Float r2 = r14.getBatteamovers()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r5)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.k     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0runs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r11)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0Wkts()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.j     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = r13.$awayTeamAbbr     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = " scored "
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0runs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = " in "
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Float r2 = r14.getInning0Overs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r5)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                goto L_0x04cd
            L_0x03c9:
                java.lang.Integer r0 = r14.getBatteamname()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = r13.$awayTeamId     // Catch:{ Exception -> 0x04e1 }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x04e1 }
                if (r0 != 0) goto L_0x03d7
                goto L_0x04cd
            L_0x03d7:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x04e1 }
                if (r0 != r2) goto L_0x04cd
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.ImageView r0 = r0.f34213h     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r13.$awayTeamLogo     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.utility.a.a(r0, r1, r12, r12)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34214i     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = "dataBinding.team2Name"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r13.$awayTeamAbbr     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.k     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getBatteamruns()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r11)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getBatteamwkts()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.j     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Float r2 = r14.getBatteamovers()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r5)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34212g     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0runs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r11)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0Wkts()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.f34211f     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x04e1 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04e1 }
                r1.<init>()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = r13.$homeTeamAbbr     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = " scored "
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Integer r2 = r14.getInning0runs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = " in "
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                java.lang.Float r2 = r14.getInning0Overs()     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r2)     // Catch:{ Exception -> 0x04e1 }
                r1.append(r5)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r1)     // Catch:{ Exception -> 0x04e1 }
            L_0x04cd:
                net.one97.paytm.feed.ui.feed.c.a r0 = r13.this$0     // Catch:{ Exception -> 0x04e1 }
                B r0 = r0.f34872a     // Catch:{ Exception -> 0x04e1 }
                net.one97.paytm.feed.b.q r0 = (net.one97.paytm.feed.b.q) r0     // Catch:{ Exception -> 0x04e1 }
                android.widget.TextView r0 = r0.l     // Catch:{ Exception -> 0x04e1 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x04e1 }
                java.lang.String r14 = r14.getStatus()     // Catch:{ Exception -> 0x04e1 }
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x04e1 }
                r0.setText(r14)     // Catch:{ Exception -> 0x04e1 }
            L_0x04e1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.c.a.b.invoke(net.one97.paytm.feed.repository.models.cricket.FeedScore):void");
        }
    }

    static final class c extends l implements kotlin.g.a.b<FeedScore, x> {
        final /* synthetic */ kotlin.g.a.b $completionHandler;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.g.a.b bVar) {
            super(1);
            this.$completionHandler = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedScore) obj);
            return x.f47997a;
        }

        public final void invoke(FeedScore feedScore) {
            if (feedScore != null) {
                this.$completionHandler.invoke(feedScore);
            } else {
                this.$completionHandler.invoke(null);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.c.a$a  reason: collision with other inner class name */
    static final class C0574a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f35020b;

        C0574a(a aVar, b bVar) {
            this.f35019a = aVar;
            this.f35020b = bVar;
        }

        public final void onClick(View view) {
            a aVar = this.f35019a;
            View view2 = aVar.itemView;
            k.a((Object) view2, "itemView");
            Context context = view2.getContext();
            k.a((Object) context, "itemView.context");
            aVar.a(context, this.f35020b.f35022d.getFeedCricketData().getDataUrl(), this.f35020b.f35022d.getFeedCricketData().getHomeTeamId(), this.f35020b.f35022d.getFeedCricketData().getAwayTeamId(), this.f35020b.f35022d.getFeedCricketData().getHomeTeamAbbr(), this.f35020b.f35022d.getFeedCricketData().getHomeTeamLogo(), this.f35020b.f35022d.getFeedCricketData().getAwayTeamAbbr(), this.f35020b.f35022d.getFeedCricketData().getAwayTeamLogo());
        }
    }

    private final void a(Context context, String str, kotlin.g.a.b<? super FeedScore, x> bVar) {
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().c(context, "", str, new c(bVar));
        this.f35017c = System.currentTimeMillis();
    }

    public final void a(b bVar, int i2) {
        k.c(bVar, "viewModel");
        q qVar = (q) this.f34872a;
        qVar.setVariable(net.one97.paytm.feed.a.f33777d, bVar);
        qVar.setVariable(net.one97.paytm.feed.a.f33780g, bVar.f35022d);
        qVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        if (this.f35018d == null) {
            this.f35018d = new net.one97.paytm.feed.ui.feed.a();
            qVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35018d);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            qVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        ImageView imageView = ((q) this.f34872a).f34209d;
        k.a((Object) imageView, "dataBinding.team1Logo");
        net.one97.paytm.feed.utility.a.a(imageView, bVar.f35022d.getFeedCricketData().getHomeTeamLogo(), H5BridgeContext.INVALID_ID, H5BridgeContext.INVALID_ID);
        ImageView imageView2 = ((q) this.f34872a).f34213h;
        k.a((Object) imageView2, "dataBinding.team2Logo");
        net.one97.paytm.feed.utility.a.a(imageView2, bVar.f35022d.getFeedCricketData().getAwayTeamLogo(), H5BridgeContext.INVALID_ID, H5BridgeContext.INVALID_ID);
        TextView textView = ((q) this.f34872a).f34210e;
        k.a((Object) textView, "dataBinding.team1Name");
        textView.setText(bVar.f35022d.getFeedCricketData().getHomeTeamAbbr());
        TextView textView2 = ((q) this.f34872a).f34214i;
        k.a((Object) textView2, "dataBinding.team2Name");
        textView2.setText(bVar.f35022d.getFeedCricketData().getAwayTeamAbbr());
        ((q) this.f34872a).executePendingBindings();
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f35017c;
        if (currentTimeMillis - j >= 15000 || j == 0) {
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            a(context, bVar.f35022d.getFeedCricketData().getDataUrl(), bVar.f35022d.getFeedCricketData().getHomeTeamId(), bVar.f35022d.getFeedCricketData().getAwayTeamId(), bVar.f35022d.getFeedCricketData().getHomeTeamAbbr(), bVar.f35022d.getFeedCricketData().getHomeTeamLogo(), bVar.f35022d.getFeedCricketData().getAwayTeamAbbr(), bVar.f35022d.getFeedCricketData().getAwayTeamLogo());
        }
        ((q) this.f34872a).f34208c.setOnClickListener(new C0574a(this, bVar));
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Context context2 = context;
        String str8 = str;
        k.c(context, "context");
        k.c(str, "url");
        k.c(str2, "homeTeamId");
        k.c(str3, "awayTeamId");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        a(context, str, new b(this, str2, str5, str4, str3, str7, str6));
    }
}
