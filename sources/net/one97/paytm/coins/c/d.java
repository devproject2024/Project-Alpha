package net.one97.paytm.coins.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.CashbackPreferenceUtility;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.c.a;
import net.one97.paytm.vipcashback.c.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f16733a = new d();

    private d() {
    }

    public static String a(String str, String str2, String str3) {
        k.c(str, "txnDate");
        k.c(str2, "currentFormat");
        k.c(str3, "expectedFormat");
        try {
            String format = new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
            k.a((Object) format, "outputFormat.format(dt)");
            return format;
        } catch (Exception unused) {
            return str;
        }
    }

    public static Bitmap a(View view) {
        k.c(view, "view");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        k.a((Object) createBitmap, "bitmap");
        return createBitmap;
    }

    public static void a(String str, String str2, Uri uri, String str3, Context context) {
        k.c(str, "subject");
        k.c(str2, "body");
        k.c(uri, "bmpUri");
        k.c(str3, "title");
        k.c(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("android.intent.extra.STREAM", uri);
        Intent createChooser = Intent.createChooser(intent, str3);
        if (createChooser.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(createChooser);
        } else {
            Toast.makeText(context, context.getString(R.string.no_app_found), 1).show();
        }
    }

    public static Uri a(Context context, Bitmap bitmap) {
        k.c(context, "context");
        k.c(bitmap, "cacheBmp");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, context.getString(R.string.title) + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
        fileOutputStream.close();
        Uri uriForFile = FileProvider.getUriForFile(context, a.b().getApplicationId() + ".provider", file);
        k.a((Object) uriForFile, "FileProvider.getUriForFi…Id() + \".provider\", file)");
        return uriForFile;
    }

    public static void a() {
        CashbackPreferenceUtility.Companion companion = CashbackPreferenceUtility.Companion;
        b b2 = a.b();
        k.a((Object) b2, "CashbackHelper.getImplListener()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
        companion.getPref(applicationContext).a("points_active", true, false);
    }

    public static boolean b() {
        CashbackPreferenceUtility.Companion companion = CashbackPreferenceUtility.Companion;
        b b2 = a.b();
        k.a((Object) b2, "CashbackHelper.getImplListener()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
        return companion.getPref(applicationContext).b("points_active", false, false);
    }
}
