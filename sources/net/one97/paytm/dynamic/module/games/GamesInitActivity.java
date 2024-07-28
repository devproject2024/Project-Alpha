package net.one97.paytm.dynamic.module.games;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;

public class GamesInitActivity extends AppCompatActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onCreate(r11)
            net.one97.paytm.games.e.g r11 = net.one97.paytm.games.e.g.a()
            android.content.Context r0 = r10.getApplicationContext()
            net.one97.paytm.dynamic.module.games.GamepindMapperJarvisImpl r1 = net.one97.paytm.dynamic.module.games.GamepindMapperJarvisImpl.getInstance()
            r11.a(r0, r1)
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r0 = "keyObject"
            android.os.Parcelable r11 = r11.getParcelableExtra(r0)
            net.one97.paytm.deeplink.DeepLinkData r11 = (net.one97.paytm.deeplink.DeepLinkData) r11
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r0.<init>()
            java.lang.String r1 = r11.f50283a
            r0.setDeeplink(r1)
            java.lang.String r1 = r11.f50284b
            r0.setUrlType(r1)
            java.lang.String r1 = r0.getURLType()
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r2) {
                case -1951307489: goto L_0x0066;
                case -1768323999: goto L_0x005c;
                case -925311729: goto L_0x0052;
                case -401029978: goto L_0x0048;
                case 1832157899: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0070
        L_0x003e:
            java.lang.String r2 = "pfgPassbook"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0070
            r1 = 3
            goto L_0x0071
        L_0x0048:
            java.lang.String r2 = "paytmFirstGamesX"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0070
            r1 = 2
            goto L_0x0071
        L_0x0052:
            java.lang.String r2 = "rooter"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0070
            r1 = 4
            goto L_0x0071
        L_0x005c:
            java.lang.String r2 = "gamepind"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0070
            r1 = 1
            goto L_0x0071
        L_0x0066:
            java.lang.String r2 = "gamepind_weex"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0070
            r1 = 0
            goto L_0x0071
        L_0x0070:
            r1 = -1
        L_0x0071:
            java.lang.String r2 = "extra_home_data"
            r8 = 0
            if (r1 == 0) goto L_0x0100
            r9 = 67108864(0x4000000, float:1.5046328E-36)
            if (r1 == r7) goto L_0x00e7
            if (r1 == r6) goto L_0x00a3
            if (r1 == r5) goto L_0x0093
            if (r1 == r4) goto L_0x0082
            goto L_0x0107
        L_0x0082:
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<net.one97.paytm.games.activity.pf.PFGameWebActivity> r0 = net.one97.paytm.games.activity.pf.PFGameWebActivity.class
            r8.<init>(r10, r0)
            r8.addFlags(r9)
            android.net.Uri r11 = r11.f50289g
            r8.setData(r11)
            goto L_0x0107
        L_0x0093:
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<net.one97.paytm.games.activity.GpGamePassbookActivity> r0 = net.one97.paytm.games.activity.GpGamePassbookActivity.class
            r8.<init>(r10, r0)
            r8.addFlags(r9)
            android.net.Uri r11 = r11.f50289g
            r8.setData(r11)
            goto L_0x0107
        L_0x00a3:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00dc }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00dc }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)     // Catch:{ Exception -> 0x00dc }
            android.net.Uri r11 = r11.f50289g     // Catch:{ Exception -> 0x00dc }
            java.lang.String r1 = "url"
            java.lang.String r11 = r11.getQueryParameter(r1)     // Catch:{ Exception -> 0x00dc }
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x00dc }
            r0.setData(r11)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x00dc }
            java.lang.String r11 = "pfgChooserEnabled"
            java.lang.String r11 = net.one97.paytm.j.c.a((java.lang.String) r11, (java.lang.String) r8)     // Catch:{ Exception -> 0x00dc }
            boolean r11 = java.lang.Boolean.parseBoolean(r11)     // Catch:{ Exception -> 0x00dc }
            if (r11 == 0) goto L_0x00da
            java.lang.String r11 = "pfgChooserTitle"
            java.lang.String r11 = net.one97.paytm.j.c.a((java.lang.String) r11, (java.lang.String) r8)     // Catch:{ Exception -> 0x00dc }
            android.content.Intent r11 = android.content.Intent.createChooser(r0, r11)     // Catch:{ Exception -> 0x00dc }
            r8 = r11
            goto L_0x0107
        L_0x00da:
            r8 = r0
            goto L_0x0107
        L_0x00dc:
            r11 = 2131955536(0x7f130f50, float:1.9547602E38)
            android.widget.Toast r11 = android.widget.Toast.makeText(r10, r11, r3)
            r11.show()
            goto L_0x0107
        L_0x00e7:
            android.net.Uri r11 = r11.f50289g
            java.lang.String r1 = "product_id"
            java.lang.String r11 = r11.getQueryParameter(r1)
            r0.setContentID(r11)
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<net.one97.paytm.games.activity.GpGameDataActivity> r11 = net.one97.paytm.games.activity.GpGameDataActivity.class
            r8.<init>(r10, r11)
            r8.addFlags(r9)
            r8.putExtra(r2, r0)
            goto L_0x0107
        L_0x0100:
            android.content.Intent r8 = net.one97.paytm.games.e.f.c(r10)
            r8.putExtra(r2, r0)
        L_0x0107:
            if (r8 == 0) goto L_0x010c
            r10.startActivity(r8)
        L_0x010c:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.games.GamesInitActivity.onCreate(android.os.Bundle):void");
    }
}
