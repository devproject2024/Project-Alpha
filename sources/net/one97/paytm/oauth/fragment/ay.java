package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.fragment.app.Fragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;

public final class ay {

    /* renamed from: a  reason: collision with root package name */
    public static final ay f56391a = new ay();

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56393a = new b();

        b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private ay() {
    }

    public static boolean a(Activity activity) {
        k.c(activity, "activity");
        return androidx.core.app.a.a((Context) activity, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        return androidx.core.app.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.app.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean b(Activity activity) {
        k.c(activity, "activity");
        Context context = activity;
        return androidx.core.app.a.a(context, "android.permission.SEND_SMS") == 0 && androidx.core.app.a.a(context, "android.permission.READ_SMS") == 0;
    }

    public static void a(String[] strArr, Fragment fragment, int i2) {
        k.c(strArr, "permissions");
        k.c(fragment, "fragment");
        fragment.requestPermissions(strArr, i2);
    }

    public static boolean a(Activity activity, String str) {
        k.c(activity, "activity");
        k.c(str, "mobileNo");
        Context context = activity;
        if (!((TextUtils.isEmpty(str) || !a(context, str)) ? true : a(context)) || !a(activity) || !b(activity)) {
            return false;
        }
        return true;
    }

    public static boolean c(Activity activity) {
        k.c(activity, "activity");
        return androidx.core.app.a.a((Context) activity, "android.permission.CALL_PHONE") == 0;
    }

    public static void d(Activity activity) {
        if (activity != null) {
            Context context = activity;
            new AlertDialog.Builder(context).setTitle(activity.getString(R.string.permission_dialog_title)).setMessage(b(context)).setPositiveButton(activity.getString(R.string.go_to_settings), new a(activity)).setNegativeButton(activity.getString(R.string.cancel), b.f56393a).setCancelable(false).create().show();
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f56392a;

        a(Activity activity) {
            this.f56392a = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + com.paytm.utility.b.B((Context) this.f56392a)));
            this.f56392a.startActivity(intent);
        }
    }

    private static SpannableString b(Context context) {
        String string = context.getString(R.string.permission_dialog_body);
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        String string2 = context.getString(R.string.settings);
        k.a((Object) string, "strAccessDenied");
        k.a((Object) string2, "strSettings");
        int a2 = p.a(charSequence, string2, 0, false, 6);
        int length = string2.length() + a2;
        String string3 = context.getString(R.string.permissions);
        k.a((Object) string3, "strPermission");
        int a3 = p.a(charSequence, string3, 0, false, 6);
        int length2 = string3.length() + a3;
        try {
            spannableString.setSpan(new StyleSpan(1), a2, length, 33);
            spannableString.setSpan(new StyleSpan(1), a3, length2, 33);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
        return spannableString;
    }

    private static boolean c(Context context) {
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        return OAuthUtils.b(context, net.one97.paytm.oauth.a.l());
    }

    public static boolean a(Context context, String str) {
        k.c(context, "context");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence) && TextUtils.isDigitsOnly(charSequence)) {
            k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
            String m = net.one97.paytm.oauth.a.m();
            k.a((Object) m, "OAuthGTMHelper.getInstance().locationRollOutSet");
            Iterable<String> a2 = p.a((CharSequence) p.a(p.a(p.a(m, "\\s", "", false), "[", "", false), "]", "", false), new String[]{AppConstants.COMMA});
            Collection arrayList = new ArrayList(kotlin.a.k.a(a2));
            for (String parseInt : a2) {
                arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
            }
            List list = (List) arrayList;
            if (str == null) {
                k.a();
            }
            boolean contains = list.contains(Integer.valueOf((int) (Long.parseLong(str) % 20)));
            if (!c(context) || !contains) {
                return false;
            }
            return true;
        }
        return false;
    }
}
