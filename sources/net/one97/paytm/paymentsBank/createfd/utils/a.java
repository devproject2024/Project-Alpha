package net.one97.paytm.paymentsBank.createfd.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.paytm.utility.q;
import com.paytm.utility.s;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final int f18179c = f18179c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0304a f18180d = new C0304a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f18181e;

    /* renamed from: a  reason: collision with root package name */
    public View f18182a;

    /* renamed from: b  reason: collision with root package name */
    public String f18183b;

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18185a = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.utils.a$a  reason: collision with other inner class name */
    public static final class C0304a {
        private C0304a() {
        }

        public /* synthetic */ C0304a(byte b2) {
            this();
        }
    }

    public final void a(Activity activity, String str, View view) {
        if (activity != null && view != null) {
            if (!s.a() || s.c(activity)) {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/png");
                    intent.putExtra("android.intent.extra.SUBJECT", activity.getString(R.string.post_payment_share_subject));
                    intent.putExtra("android.intent.extra.TEXT", str);
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                    view.draw(new Canvas(createBitmap));
                    String insertImage = MediaStore.Images.Media.insertImage(activity.getContentResolver(), createBitmap, activity.getString(R.string.pb_fd_title), (String) null);
                    if (insertImage != null) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                        Intent createChooser = Intent.createChooser(intent, activity.getString(R.string.post_payment_share_title));
                        if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                            activity.startActivity(createChooser);
                        } else {
                            Toast.makeText(activity, activity.getString(R.string.pb_fd_no_app_found), 1).show();
                        }
                    }
                } catch (Exception e2) {
                    Crashlytics.logException(e2);
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    q.b(message);
                }
            } else {
                androidx.core.app.a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, f18179c);
                this.f18183b = str;
                this.f18182a = view;
            }
        }
    }

    public static void a(Activity activity) {
        k.c(activity, "activity");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(activity.getString(R.string.pb_fd_write_to_sdcard_permission_alert_msg));
            builder.setPositiveButton(activity.getString(R.string.action_settings), new b(activity));
            builder.setNegativeButton(activity.getString(R.string.cancel), c.f18185a);
            builder.show();
        } catch (Exception e2) {
            Crashlytics.logException(e2);
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f18184a;

        b(Activity activity) {
            this.f18184a = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b((Context) this.f18184a);
        }
    }
}
