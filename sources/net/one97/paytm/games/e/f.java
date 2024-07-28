package net.one97.paytm.games.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.PfgHomeActivity;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.core.CJRGameInfo;
import net.one97.paytm.games.model.pfg.Game;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class f {
    public static boolean a(Object obj) {
        if (obj != null) {
            return (obj instanceof String) && ((String) obj).trim().length() == 0;
        }
        return true;
    }

    public static boolean a(Activity activity) {
        return activity == null || activity.isDestroyed() || activity.isFinishing();
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, 16974130);
        builder.setCancelable(z);
        builder.setMessage(str2);
        builder.setTitle(str);
        if (!a((Object) str3)) {
            builder.setPositiveButton(str3, onClickListener);
        }
        if (!a((Object) str4)) {
            builder.setNegativeButton(str4, onClickListener);
        }
        return builder.create();
    }

    public static void a(Context context, String str, String str2) {
        if (a((Object) str2)) {
            Toast.makeText(context, R.string.com_gamepind_some_error, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        if (a((Object) str)) {
            str = context.getString(R.string.com_gamepind_title_share_using);
        }
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static int a(String str) {
        if ("portrait".equalsIgnoreCase(str)) {
            return 1;
        }
        return (H5Param.LONG_LANDSCAPE.equalsIgnoreCase(str) || "forcedPortrait".equalsIgnoreCase(str)) ? 0 : -1;
    }

    public static boolean a(String str, boolean z) {
        String gtmString = g.a().c().getGtmString(str);
        return a((Object) gtmString) ? z : Boolean.parseBoolean(gtmString);
    }

    public static String b(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public static boolean a(Context context, String str) {
        String b2 = b(context, str);
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null || !shortcutManager.isRequestPinShortcutSupported()) {
            return false;
        }
        for (ShortcutInfo id : shortcutManager.getPinnedShortcuts()) {
            if (id.getId().equalsIgnoreCase(b2)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context, String str) {
        return context.getPackageName().concat(".inbox.games.weex").concat(a((Object) str) ? "" : AppUtility.CENTER_DOT.concat(String.valueOf(str)));
    }

    public static void a(Context context, int i2) {
        String str;
        if (i2 == 1) {
            str = context.getString(R.string.gamepind_shortcut_success);
        } else if (i2 == 2) {
            str = context.getString(R.string.com_gamepind_shortcut_exists);
        } else if (i2 != 3) {
            str = i2 != 4 ? "" : context.getString(R.string.com_gamepind_some_error);
        } else {
            str = context.getString(R.string.com_gamepind_shortcut_not_supported);
        }
        Toast.makeText(context, str, 0).show();
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(d.cv, "inbox");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
        hashMap.put("event_category", str);
        hashMap.put("event_action", str3);
        hashMap.put("event_label", str4);
        hashMap.put("event_label2", str5);
        hashMap.put("event_label3", Long.valueOf(j));
        g.a().c().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(d.cv, "inbox");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str2);
        hashMap.put("event_action", str3);
        if (!a((Object) str4)) {
            hashMap.put("event_label", str4);
        }
        if (!a((Object) str5)) {
            hashMap.put("event_label2", str5);
        }
        g.a().c().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static <T extends GpCommonBaseResponse> T a(NetworkCustomError networkCustomError, T t, Class<T> cls) {
        if (t.code == 0) {
            try {
                return (GpCommonBaseResponse) new com.google.gson.f().a(new String(networkCustomError.getNetworkResponse().data), cls);
            } catch (Exception unused) {
            }
        }
        return t;
    }

    public static void a(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            activity.setRequestedOrientation(i2);
        }
    }

    public static Intent c(Context context) {
        Intent intent = new Intent(context, PfgHomeActivity.class);
        intent.addFlags(67108864);
        return intent;
    }

    public static boolean a(SimpleDateFormat simpleDateFormat, long j, long j2) {
        if (j2 <= 0) {
            return false;
        }
        try {
            if (TimeUnit.MILLISECONDS.toDays(simpleDateFormat.parse(simpleDateFormat.format(new Date(j))).getTime() - simpleDateFormat.parse(simpleDateFormat.format(new Date(j2))).getTime()) > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static Long a() {
        return Long.valueOf(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(2));
    }

    public static Game a(CJRGameInfo cJRGameInfo) {
        Game game = new Game();
        StringBuilder sb = new StringBuilder();
        sb.append(cJRGameInfo.getProduct_id());
        game.setGameId(sb.toString());
        game.setGameName(cJRGameInfo.getName());
        game.setUrl(cJRGameInfo.attributes.html_5_link);
        String str = "0";
        game.setShowTitlebar(cJRGameInfo.attributes.getHideInGameHeader() ? str : "1");
        if (cJRGameInfo.attributes.no_cp_token) {
            str = "1";
        }
        game.setNoCpToken(str);
        game.setDestinationMID(cJRGameInfo.attributes.content_provider);
        game.setRecentTabIcon(cJRGameInfo.attributes.recent_tab_icon);
        game.setIconUrl(cJRGameInfo.image_url);
        game.setShareContent(cJRGameInfo.attributes.getShareGamepindPro());
        if (H5Param.LONG_LANDSCAPE.equalsIgnoreCase(cJRGameInfo.attributes.orientation)) {
            game.setOrientaion("2");
        } else if ("portrait".equalsIgnoreCase(cJRGameInfo.attributes.orientation)) {
            game.setOrientaion("1");
        }
        return game;
    }

    public static String c(Context context, String str) {
        if (a((Object) str) || context == null) {
        }
        return str;
    }

    public static String a(String str, Long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        return simpleDateFormat.format(new Date(l.longValue()));
    }

    public static void a(Uri.Builder builder, Uri uri) {
        for (String next : uri.getQueryParameterNames()) {
            if (!a((Object) next) && (next.startsWith("gp_") || next.startsWith("utm_"))) {
                builder.appendQueryParameter(next, uri.getQueryParameter(next));
            }
        }
    }
}
