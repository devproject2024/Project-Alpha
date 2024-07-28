package net.one97.paytm.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.paytm.b.a.a;
import com.paytm.utility.f;
import java.util.Date;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f72419a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static Date f72420b = new Date();

    /* renamed from: c  reason: collision with root package name */
    private static int f72421c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f72422d = false;

    /* renamed from: e  reason: collision with root package name */
    private static AlertDialog f72423e;

    public static void a(Context context) {
        a a2 = ag.a(context, f.a.PREF_NAME);
        if (a2.b("rta_install_date", 0, false) == 0) {
            Date date = new Date();
            a2.a("rta_install_date", date.getTime(), false);
            new StringBuilder("First install: ").append(date.toString());
        }
        a2.a("rta_launch_times", a2.b("rta_launch_times", 0, false) + 1, false);
        f72420b = new Date(a2.b("rta_install_date", 0, false));
        f72421c = a2.b("rta_launch_times", 0, false);
        f72422d = a2.b("rta_opt_out", false, false);
        a a3 = ag.a(context, f.a.PREF_NAME);
        new StringBuilder("Install Date: ").append(new Date(a3.b("rta_install_date", 0, false)));
        new StringBuilder("Launch Times: ").append(a3.b("rta_launch_times", 0, false));
        new StringBuilder("Opt out: ").append(a3.b("rta_opt_out", false, false));
    }

    public static void b(final Context context) {
        if (a()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.rta_dialog_title);
            builder.setMessage(R.string.rta_dialog_message);
            builder.setPositiveButton(R.string.rta_dialog_ok, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    String packageName = context.getPackageName();
                    ag.a(context, f.a.PREF_NAME).a("rta_opt_out", true, false);
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=".concat(String.valueOf(packageName)))));
                    f.b();
                }
            });
            builder.setNegativeButton(R.string.rta_dialog_cancel, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f.d(context);
                    f.b();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    f.d(context);
                    f.b();
                }
            });
            AlertDialog create = builder.create();
            f72423e = create;
            create.show();
        }
    }

    public static boolean a() {
        return !f72422d;
    }

    public static void b() {
        AlertDialog alertDialog = f72423e;
        if (alertDialog != null) {
            alertDialog.cancel();
            f72423e.dismiss();
            f72423e = null;
        }
    }

    static /* synthetic */ void d(Context context) {
        a a2 = ag.a(context, f.a.PREF_NAME);
        a2.a("rta_install_date", false);
        a2.a("rta_launch_times", false);
    }
}
