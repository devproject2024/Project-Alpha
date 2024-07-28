package net.one97.paytm.games.e;

import android.content.Context;
import android.provider.Settings;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.k;
import com.paytm.utility.q;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Locale;
import net.one97.paytm.games.c.a;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GamepindSpsClient;
import net.one97.paytm.games.model.GamepindTaskEngineClient;
import net.one97.paytm.games.model.GamesGboClient;
import net.one97.paytm.games.model.GamesPcsClient;
import net.one97.paytm.upi.util.UpiContract;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    private static final g f35613d = new g();

    /* renamed from: a  reason: collision with root package name */
    public int f35614a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35615b;

    /* renamed from: c  reason: collision with root package name */
    public final SimpleDateFormat f35616c = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /* renamed from: e  reason: collision with root package name */
    private Context f35617e;

    /* renamed from: f  reason: collision with root package name */
    private a f35618f;

    /* renamed from: g  reason: collision with root package name */
    private String f35619g;

    /* renamed from: h  reason: collision with root package name */
    private GamepindCasClient f35620h;

    /* renamed from: i  reason: collision with root package name */
    private GamepindSpsClient f35621i;
    private GamesPcsClient j;
    private GamesGboClient k;
    private GamepindTaskEngineClient l;

    public static g a() {
        return f35613d;
    }

    private g() {
    }

    public final Context b() {
        a c2;
        if (this.f35617e == null && (c2 = c()) != null) {
            this.f35617e = c2.getApplicationContext();
        }
        return this.f35617e.getApplicationContext();
    }

    public final synchronized void a(Context context, a aVar) {
        if (this.f35618f == null) {
            this.f35618f = aVar;
        }
        if (this.f35617e == null) {
            this.f35617e = context;
        }
    }

    public final a c() {
        if (this.f35618f == null) {
            try {
                Constructor<?> declaredConstructor = Class.forName("net.one97.paytm.dynamic.module.games.GamepindMapperJarvisImpl").getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                this.f35618f = (a) declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        return this.f35618f;
    }

    public final synchronized String a(Context context) {
        if (this.f35619g == null) {
            this.f35619g = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        }
        return this.f35619g;
    }

    public final synchronized GamepindCasClient d() {
        String str;
        if (this.f35620h != null) {
            return this.f35620h;
        }
        if (k.a()) {
            str = c().getGtmString("gamesCasClient");
        } else {
            str = c().getGtmString("gamepind_cas_client_mall_app");
        }
        this.f35620h = (GamepindCasClient) new f().a(str, GamepindCasClient.class);
        if (this.f35620h == null) {
            this.f35620h = new GamepindCasClient();
            this.f35620h.mId = "";
            this.f35620h.mSecret = "";
            this.f35620h.mapperId = "";
            this.f35620h.property = "";
            this.f35620h.source = "";
        }
        if (this.f35620h.leaderboardPageSize <= 0) {
            this.f35620h.leaderboardPageSize = 20;
        }
        return this.f35620h;
    }

    public final synchronized GamepindSpsClient e() {
        if (this.f35621i != null) {
            return this.f35621i;
        }
        GamepindSpsClient gamepindSpsClient = (GamepindSpsClient) new f().a(c().getGtmString("gamepind_sps_client"), GamepindSpsClient.class);
        if (gamepindSpsClient == null) {
            gamepindSpsClient = new GamepindSpsClient();
            gamepindSpsClient.mId = "";
            gamepindSpsClient.mSecret = "";
            gamepindSpsClient.checksumHashKey = "";
        }
        if (gamepindSpsClient.verifyTimeoutMillis <= 0) {
            gamepindSpsClient.verifyTimeoutMillis = AppConstants.START_OTP_FLOW;
        }
        this.f35621i = gamepindSpsClient;
        return gamepindSpsClient;
    }

    public final synchronized GamepindTaskEngineClient f() {
        if (this.l != null) {
            return this.l;
        }
        GamepindTaskEngineClient gamepindTaskEngineClient = (GamepindTaskEngineClient) new f().a(c().getGtmString("gamepind_task_engine_client"), GamepindTaskEngineClient.class);
        if (gamepindTaskEngineClient == null) {
            gamepindTaskEngineClient = new GamepindTaskEngineClient();
            gamepindTaskEngineClient.mId = "";
            gamepindTaskEngineClient.mSecret = "";
            gamepindTaskEngineClient.appCode = "";
            gamepindTaskEngineClient.gameName = "";
            gamepindTaskEngineClient.shortcutRuleId = "";
            gamepindTaskEngineClient.shortcutEventCode = "";
        }
        if (f.a((Object) gamepindTaskEngineClient.ruleId)) {
            gamepindTaskEngineClient.ruleId = e.f35608a ? "139" : "161";
            gamepindTaskEngineClient.eventCode = "LOYALTY-BONUS";
            gamepindTaskEngineClient.gameName = "gamepind";
            gamepindTaskEngineClient.appCode = "PP-APP-GP";
        }
        this.l = gamepindTaskEngineClient;
        return gamepindTaskEngineClient;
    }

    public final synchronized GamesPcsClient g() {
        if (this.j != null) {
            return this.j;
        }
        GamesPcsClient gamesPcsClient = (GamesPcsClient) new f().a(c().getGtmString("games_pcs_client"), GamesPcsClient.class);
        if (gamesPcsClient == null) {
            gamesPcsClient = new GamesPcsClient();
            gamesPcsClient.mId = "";
            gamesPcsClient.mSecret = "";
        }
        this.j = gamesPcsClient;
        return gamesPcsClient;
    }

    public final synchronized GamesGboClient h() {
        if (this.k != null) {
            return this.k;
        }
        GamesGboClient gamesGboClient = (GamesGboClient) new f().a(c().getGtmString("games_gbo_client"), GamesGboClient.class);
        if (gamesGboClient == null) {
            gamesGboClient = new GamesGboClient();
            gamesGboClient.mBuildCu = "";
            gamesGboClient.mChannelCu = "";
            gamesGboClient.mChannel = "";
        }
        this.k = gamesGboClient;
        return gamesGboClient;
    }

    public final boolean i() {
        return this.f35614a > 0;
    }
}
