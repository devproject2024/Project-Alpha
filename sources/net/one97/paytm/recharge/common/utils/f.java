package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.paytm.utility.s;
import com.squareup.picasso.aa;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.m;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61626a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f61627f = 2210;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int f61628g = 2003;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static f f61629h;

    /* renamed from: b  reason: collision with root package name */
    private View f61630b;

    /* renamed from: c  reason: collision with root package name */
    private String f61631c;

    /* renamed from: d  reason: collision with root package name */
    private String f61632d;

    /* renamed from: e  reason: collision with root package name */
    private String f61633e;

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f61640a = new d();

        d() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private f() {
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a() {
            if (f.f61629h == null) {
                f.f61629h = new f((byte) 0);
            }
            f c2 = f.f61629h;
            if (c2 != null) {
                return c2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.utils.CJRBaseShareActionHandler");
        }
    }

    public final boolean a(Activity activity, int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 != f61627f && i2 != f61628g) {
            return false;
        }
        if (s.a(iArr)) {
            if (i2 == f61628g) {
                a(activity, this.f61631c, this.f61632d, this.f61633e);
            } else {
                a(activity, this.f61632d, this.f61630b);
            }
        } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", activity) != 1) {
            Toast.makeText(activity, activity.getString(R.string.permission_not_granted), 0).show();
            k.c(activity, "activity");
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(activity.getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(activity.getString(R.string.action_settings), new c(activity));
                builder.setNegativeButton(activity.getString(R.string.cancel), d.f61640a);
                builder.show();
            } catch (Exception e2) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            }
        } else if (i2 == f61628g && (activity instanceof m)) {
            ((m) activity).dismiss();
        }
        return true;
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
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawColor(-1);
                    view.draw(canvas);
                    k.a((Object) createBitmap, "cacheBmp");
                    intent.putExtra("android.intent.extra.STREAM", a(activity, createBitmap));
                    Intent createChooser = Intent.createChooser(intent, activity.getString(R.string.post_payment_share_title));
                    if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                        activity.startActivity(createChooser);
                    } else {
                        Toast.makeText(activity, activity.getString(R.string.no_app_found), 1).show();
                    }
                } catch (Exception e2) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    StringBuilder sb = new StringBuilder("Share: ");
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    sb.append(message);
                    net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                }
            } else {
                androidx.core.app.a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, f61627f);
                this.f61632d = str;
                this.f61630b = view;
            }
        }
    }

    private static Uri a(Context context, Bitmap bitmap) throws IOException {
        k.c(context, "context");
        k.c(bitmap, "cacheBmp");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, context.getString(R.string.title) + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
        fileOutputStream.close();
        StringBuilder sb = new StringBuilder();
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        sb.append(applicationContext.getPackageName());
        sb.append(".provider");
        Uri uriForFile = FileProvider.getUriForFile(context, sb.toString(), file);
        k.a((Object) uriForFile, "FileProvider.getUriForFi…Name + \".provider\", file)");
        return uriForFile;
    }

    public final class b implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f61634a;

        /* renamed from: b  reason: collision with root package name */
        private final Activity f61635b;

        /* renamed from: c  reason: collision with root package name */
        private final String f61636c;

        /* renamed from: d  reason: collision with root package name */
        private final String f61637d;

        /* renamed from: e  reason: collision with root package name */
        private final String f61638e;

        public final void onPrepareLoad(Drawable drawable) {
        }

        public b(f fVar, Activity activity, String str, String str2, String str3) {
            k.c(activity, "activity");
            k.c(str3, "imageUrl");
            this.f61634a = fVar;
            this.f61635b = activity;
            this.f61636c = str;
            this.f61637d = str2;
            this.f61638e = str3;
        }

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
            k.c(exc, "e");
            f.a(this.f61635b, this.f61636c, this.f61637d, (Bitmap) null);
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            f.a(this.f61635b, this.f61636c, this.f61637d, bitmap);
        }
    }

    public static void a(Activity activity, String str, String str2, Bitmap bitmap) {
        k.c(activity, "activity");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            String string = activity.getString(R.string.post_payment_share_subject);
            k.a((Object) string, "activity.getString(R.str…st_payment_share_subject)");
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    string = "";
                } else {
                    string = str;
                }
            }
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", str2);
            if (bitmap != null) {
                intent.putExtra("android.intent.extra.STREAM", a(activity, bitmap));
            }
            Intent createChooser = Intent.createChooser(intent, string);
            if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(createChooser, f61628g);
                return;
            }
            Toast.makeText(activity, activity.getString(R.string.no_app_found), 1).show();
            if (activity instanceof m) {
                ((m) activity).dismiss();
            }
        } catch (Exception e2) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            StringBuilder sb = new StringBuilder("Share: ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            if (activity instanceof m) {
                ((m) activity).dismiss();
            }
        }
    }

    public final void a(Activity activity, String str, String str2, String str3) {
        if (activity == null || (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3))) {
            if (activity instanceof m) {
                ((m) activity).dismiss();
            }
        } else if (s.a() && !s.c(activity)) {
            androidx.core.app.a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, f61628g);
            this.f61631c = str;
            this.f61632d = str2;
            this.f61633e = str3;
        } else if (!TextUtils.isEmpty(str3)) {
            aa a2 = w.a().a(str3);
            if (str3 == null) {
                k.a();
            }
            a2.a((af) new b(this, activity, str, str2, str3));
        } else {
            a(activity, str, str2, (Bitmap) null);
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f61639a;

        c(Activity activity) {
            this.f61639a = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b((Context) this.f61639a);
        }
    }
}
