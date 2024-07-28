package net.one97.paytm.games.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.widget.Toast;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.PFGGameWebActivity;
import net.one97.paytm.games.model.pfg.Game;

public final class c {
    public static String a(String str) {
        String str2 = str + AppConstants.COLON + System.currentTimeMillis();
        return "Basic " + Base64.encodeToString(str2.getBytes(), 2);
    }

    public static void a(Context context, String str, Game game, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intent intent = new Intent(context, PFGGameWebActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("object1", game);
        intent.putExtra("exitUrl", str4);
        intent.putExtra("property", str2);
        intent.putExtra("mv_cas_oauth_token", str3);
        intent.putExtra("masked_msisdn", str6);
        if (z) {
            intent.addFlags(67108864);
        }
        intent.putExtra("clickSource", str5);
        context.startActivity(intent);
    }

    public static boolean a(Activity activity, String str) {
        String[] strArr;
        try {
            String scheme = Uri.parse(str).getScheme();
            if (f.a((Object) scheme)) {
                return false;
            }
            String gtmString = g.a().c().getGtmString("gamepind_allowed_external_schemes_csv");
            if (gtmString == null) {
                strArr = null;
            } else {
                strArr = gtmString.split(AppConstants.COMMA);
            }
            if (strArr != null && strArr.length > 0) {
                for (String equalsIgnoreCase : strArr) {
                    if (scheme.equalsIgnoreCase(equalsIgnoreCase)) {
                        a((Context) activity, str);
                        return true;
                    }
                }
            }
            String gtmString2 = g.a().c().getGtmString("gamepind_allowed_external_domains_csv");
            if (f.a((Object) gtmString2)) {
                gtmString2 = "https://www.googleadservices,https://adclick,https://googlead,https://www.gamepix";
            }
            String[] split = gtmString2.split(AppConstants.COMMA);
            if (split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String trim = split[i2].trim();
                    if (f.a((Object) trim) || !str.startsWith(trim)) {
                        i2++;
                    } else {
                        a((Context) activity, str);
                        return true;
                    }
                }
            }
            if (scheme.equals("market")) {
                int indexOf = str.indexOf(g.a().c().getDeeplinkScheme() + AppConstants.COLON);
                if (indexOf == -1) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        if (intent.resolveActivity(activity.getPackageManager()) != null) {
                            activity.startActivity(intent);
                        }
                    } catch (Exception e2) {
                        if (b.v) {
                            q.b(e2.getMessage());
                        }
                    }
                    return true;
                } else if (indexOf < str.length()) {
                    g.a().c().checkDeepLinking(activity, str.substring(indexOf));
                    return true;
                }
            } else if (scheme.equals(g.a().c().getDeeplinkScheme())) {
                g.a().c().checkDeepLinking(activity, str);
                return true;
            }
            return false;
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
            return false;
        }
    }

    private static void a(Context context, String str) {
        if (f.a((Object) str)) {
            Toast.makeText(context, R.string.com_gamepind_some_error, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, R.string.com_gamepind_some_error, 0).show();
        }
    }

    public static void a(Activity activity) {
        String gtmString = g.a().c().getGtmString("gamepind_cst_deeplink");
        if (f.a((Object) gtmString)) {
            gtmString = "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=9";
        }
        a(activity, gtmString);
    }
}
