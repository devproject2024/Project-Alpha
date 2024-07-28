package net.one97.paytm.games.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.a.b;
import androidx.core.content.a.d;
import androidx.core.graphics.drawable.IconCompat;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.pfg.Game;

public class GpGameMenuActivity extends GpBaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private final String f35482b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private Game f35483c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_gamepind_activity_game_menu);
        findViewById(R.id.com_gamepind_txt_add_to_home).setOnClickListener(this);
        findViewById(R.id.com_gamepind_txt_report_an_issue).setOnClickListener(this);
        findViewById(R.id.root_activity).setOnClickListener(this);
        if (g.a().c().enableBranch()) {
            findViewById(R.id.com_gamepind_txt_share_game).setOnClickListener(this);
        } else {
            findViewById(R.id.com_gamepind_txt_share_game).setVisibility(8);
            findViewById(R.id.com_gamepind_div_share_game).setVisibility(8);
        }
        this.f35483c = (Game) getIntent().getParcelableExtra("object1");
        int a2 = f.a(this.f35483c.getOrientaion());
        f.a((Activity) this, a2);
        if (a2 == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f35466a = displayMetrics.heightPixels;
            int i2 = (displayMetrics.widthPixels - displayMetrics.heightPixels) / 2;
            ((LinearLayout.LayoutParams) findViewById(R.id.root_of_visible_views).getLayoutParams()).setMargins(i2, 0, i2, 0);
        }
        a(new IntentFilter("gamepind.action.shortcutStatus"));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.com_gamepind_txt_add_to_home) {
            f.a(this, "/inbox/games/webview", "gamepind_ingame", "triple_dot_option_clicked", getString(R.string.com_gamepind_menu_item_add_to_home), this.f35483c.getGameName());
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.PRODUCT_ID, this.f35483c.getGameId());
            hashMap.put("name", this.f35483c.getGameName());
            hashMap.put("recent_tab_icon", this.f35483c.getRecentTabIcon());
            String b2 = f.b(hashMap.get(CLPConstants.PRODUCT_ID));
            if (!d.a(this)) {
                f.a((Context) this, 3);
            } else if (Build.VERSION.SDK_INT < 26 || !f.a((Context) this, f.b(hashMap.get(CLPConstants.PRODUCT_ID)))) {
                b.a.C0750a a2 = b.a(this);
                a2.f43753a = f.b(hashMap.get("recent_tab_icon"));
                a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Bitmap>(this, b2, hashMap) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ Context f35610a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ String f35611b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ HashMap f35612c;

                    {
                        this.f35610a = r1;
                        this.f35611b = r2;
                        this.f35612c = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, c cVar) {
                        String str;
                        String str2;
                        Uri.Builder builder;
                        IconCompat iconCompat;
                        IconCompat iconCompat2;
                        Bitmap bitmap = (Bitmap) obj;
                        Context context = this.f35610a;
                        HashMap hashMap = this.f35612c;
                        if (hashMap == null) {
                            str = null;
                            iconCompat = IconCompat.a(context, R.drawable.ic_gamepind_shortcut);
                            builder = Uri.parse("paytmmp://gamepind_weex").buildUpon().appendQueryParameter("clickSource", "shortcut");
                            str2 = "Gamepind";
                        } else {
                            String b2 = f.b(hashMap.get(CLPConstants.PRODUCT_ID));
                            String b3 = f.b(hashMap.get("name"));
                            if (f.a((Object) b3)) {
                                f.a(context, 4);
                                return;
                            }
                            if (bitmap == null) {
                                iconCompat2 = IconCompat.a(context, R.drawable.ic_gamepind_shortcut);
                            } else {
                                iconCompat2 = IconCompat.a(bitmap);
                            }
                            builder = Uri.parse("paytmmp://gamepind").buildUpon().appendQueryParameter(CLPConstants.PRODUCT_ID, b2).appendQueryParameter("clickSource", "shortcut");
                            str2 = b3;
                            iconCompat = iconCompat2;
                            str = b2;
                        }
                        Intent splashIntent = g.a().c().getSplashIntent(context);
                        splashIntent.setAction("android.intent.action.MAIN");
                        splashIntent.setData(builder.build());
                        Intent intent = new Intent("gamepind.action.shortcutStatus");
                        intent.putExtra(CLPConstants.PRODUCT_ID, str);
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
                        b.a aVar = new b.a(context, f.b(context, str));
                        aVar.f2821a.f2819h = iconCompat;
                        aVar.f2821a.f2816e = str2;
                        aVar.f2821a.f2817f = str2;
                        aVar.f2821a.f2814c = new Intent[]{splashIntent};
                        aVar.f2821a.f2820i = true;
                        if (TextUtils.isEmpty(aVar.f2821a.f2816e)) {
                            throw new IllegalArgumentException("Shortcut must have a non-empty label");
                        } else if (aVar.f2821a.f2814c == null || aVar.f2821a.f2814c.length == 0) {
                            throw new IllegalArgumentException("Shortcut must have an intent");
                        } else {
                            d.a(context, aVar.f2821a, broadcast.getIntentSender());
                        }
                    }

                    public final void onError(Exception exc) {
                        f.a(this.f35610a, 4);
                    }
                });
            } else {
                f.a((Context) this, 2);
            }
        } else if (id == R.id.com_gamepind_txt_share_game) {
            f.a(this, "/inbox/games/webview", "gamepind_ingame", "triple_dot_option_clicked", getString(R.string.com_gamepind_menu_item_share_game), this.f35483c.getGameName());
            String concat = "gamepind?product_id=".concat(this.f35483c.getGameId());
            Uri.Builder buildUpon = Uri.parse("paytmmp://branchShare").buildUpon();
            buildUpon.appendQueryParameter("sharesheet", "false");
            buildUpon.appendQueryParameter("campaign", "GamepindInGameShare");
            buildUpon.appendQueryParameter("b_key", concat);
            buildUpon.appendQueryParameter("title", this.f35483c.getGameName());
            buildUpon.appendQueryParameter("imgUrl", this.f35483c.getIconUrl());
            String shareContent = this.f35483c.getShareContent();
            if (f.a((Object) shareContent)) {
                shareContent = getString(R.string.com_gamepind_share_desc, new Object[]{this.f35483c.getGameName()});
            }
            buildUpon.appendQueryParameter(RequestConfirmationDialogFragment.KEY_DESCRIPTION, shareContent);
            buildUpon.appendQueryParameter("campaignDisplayName", "Gamepind In Game Share");
            net.one97.paytm.games.e.c.a((Activity) this, buildUpon.build().toString());
        } else if (id == R.id.com_gamepind_txt_report_an_issue) {
            f.a(this, "/inbox/games/webview", "gamepind_ingame", "triple_dot_option_clicked", getString(R.string.com_gamepind_menu_item_report_an_issue), this.f35483c.getGameName());
            net.one97.paytm.games.e.c.a((Activity) this);
        } else if (id == R.id.root_activity) {
            finish();
        }
    }
}
