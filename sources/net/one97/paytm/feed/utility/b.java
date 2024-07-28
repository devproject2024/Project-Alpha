package net.one97.paytm.feed.utility;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.feed.R;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f35385a = new b();

    public static final int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 8;
        }
        return 8;
    }

    public static final int a(boolean z) {
        return z ? 0 : 4;
    }

    public static final int a(boolean z, boolean z2) {
        return (z || z2) ? 0 : 8;
    }

    public static final String a() {
        return "";
    }

    public static final int b(boolean z, boolean z2) {
        return (z || z2) ? 8 : 0;
    }

    private b() {
    }

    public static final String a(Object obj, String str) {
        return String.valueOf(obj) + str;
    }

    public static final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(str);
        k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        long time = parse.getTime();
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        return DateUtils.getRelativeTimeSpanString(time, instance.getTimeInMillis(), 60000).toString();
    }

    public static final int b(String str) {
        return !TextUtils.isEmpty(str) ? 0 : 8;
    }

    public static final String a(boolean z, boolean z2, Context context) {
        k.c(context, "context");
        if (z) {
            String string = context.getResources().getString(R.string.feed_sensitive_static_text);
            k.a((Object) string, "context.resources.getStr…ed_sensitive_static_text)");
            return string;
        } else if (!z2) {
            return "";
        } else {
            String string2 = context.getResources().getString(R.string.feed_blocked_static_text);
            k.a((Object) string2, "context.resources.getStr…feed_blocked_static_text)");
            return string2;
        }
    }

    public static final String b(boolean z, boolean z2, Context context) {
        k.c(context, "context");
        if (z) {
            String string = context.getResources().getString(R.string.feed_see_comment);
            k.a((Object) string, "context.resources.getStr….string.feed_see_comment)");
            return string;
        } else if (!z2) {
            return "";
        } else {
            String string2 = context.getResources().getString(R.string.feed_edit_comment);
            k.a((Object) string2, "context.resources.getStr…string.feed_edit_comment)");
            return string2;
        }
    }

    public static final String a(Context context, int i2) {
        k.c(context, "context");
        if (i2 == 0) {
            return "";
        }
        if (i2 == 1) {
            String string = context.getString(R.string.feed_server_error);
            k.a((Object) string, "context.getString(R.string.feed_server_error)");
            return string;
        } else if (i2 != 2) {
            return "";
        } else {
            String string2 = context.getString(R.string.feed_retry);
            k.a((Object) string2, "context.getString(R.string.feed_retry)");
            return string2;
        }
    }

    public static final Drawable b(Context context, int i2) {
        k.c(context, "context");
        if (i2 == 1) {
            Drawable a2 = androidx.core.content.b.a(context, R.drawable.feed_no_data);
            if (a2 == null) {
                k.a();
            }
            k.a((Object) a2, "ContextCompat.getDrawabl….drawable.feed_no_data)!!");
            return a2;
        } else if (i2 != 2) {
            Drawable a3 = androidx.core.content.b.a(context, R.drawable.feed_no_data);
            if (a3 == null) {
                k.a();
            }
            k.a((Object) a3, "ContextCompat.getDrawabl….drawable.feed_no_data)!!");
            return a3;
        } else {
            Drawable a4 = androidx.core.content.b.a(context, R.drawable.feed_no_internet);
            if (a4 == null) {
                k.a();
            }
            k.a((Object) a4, "ContextCompat.getDrawabl…wable.feed_no_internet)!!");
            return a4;
        }
    }

    public static final String a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str2, "type");
        if (p.a(str2, "PLAYSTORE", true) && str != null) {
            try {
                context.getPackageManager().getPackageInfo(str, 0);
                String string = context.getString(R.string.feed_open);
                k.a((Object) string, "context.getString(R.string.feed_open)");
                return string;
            } catch (PackageManager.NameNotFoundException unused) {
                String string2 = context.getString(R.string.feed_download);
                k.a((Object) string2, "context.getString(R.string.feed_download)");
                return string2;
            }
        } else if (p.a(str2, "H5", true)) {
            String string3 = context.getString(R.string.feed_open);
            k.a((Object) string3, "context.getString(R.string.feed_open)");
            return string3;
        } else {
            String string4 = context.getString(R.string.feed_download);
            k.a((Object) string4, "context.getString(R.string.feed_download)");
            return string4;
        }
    }
}
