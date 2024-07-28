package androidx.core.content.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import androidx.core.app.l;
import androidx.core.graphics.drawable.IconCompat;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Set;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    Context f2812a;

    /* renamed from: b  reason: collision with root package name */
    String f2813b;

    /* renamed from: c  reason: collision with root package name */
    public Intent[] f2814c;

    /* renamed from: d  reason: collision with root package name */
    ComponentName f2815d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f2816e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f2817f;

    /* renamed from: g  reason: collision with root package name */
    CharSequence f2818g;

    /* renamed from: h  reason: collision with root package name */
    public IconCompat f2819h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2820i;
    l[] j;
    Set<String> k;
    boolean l;
    int m;

    b() {
    }

    /* access modifiers changed from: package-private */
    public final PersistableBundle a() {
        PersistableBundle persistableBundle = new PersistableBundle();
        l[] lVarArr = this.j;
        if (lVarArr != null && lVarArr.length > 0) {
            persistableBundle.putInt("extraPersonCount", lVarArr.length);
            int i2 = 0;
            while (i2 < this.j.length) {
                StringBuilder sb = new StringBuilder("extraPerson_");
                int i3 = i2 + 1;
                sb.append(i3);
                String sb2 = sb.toString();
                l lVar = this.j[i2];
                PersistableBundle persistableBundle2 = new PersistableBundle();
                persistableBundle2.putString("name", lVar.f2781a != null ? lVar.f2781a.toString() : null);
                persistableBundle2.putString("uri", lVar.f2783c);
                persistableBundle2.putString("key", lVar.f2784d);
                persistableBundle2.putBoolean("isBot", lVar.f2785e);
                persistableBundle2.putBoolean("isImportant", lVar.f2786f);
                persistableBundle.putPersistableBundle(sb2, persistableBundle2);
                i2 = i3;
            }
        }
        persistableBundle.putBoolean("extraLongLived", this.l);
        return persistableBundle;
    }

    /* access modifiers changed from: package-private */
    public final Intent a(Intent intent) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Intent[] intentArr = this.f2814c;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f2816e.toString());
        if (this.f2819h != null) {
            Drawable drawable = null;
            if (this.f2820i) {
                PackageManager packageManager = this.f2812a.getPackageManager();
                ComponentName componentName = this.f2815d;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f2812a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            IconCompat iconCompat = this.f2819h;
            Context context = this.f2812a;
            if (iconCompat.f2984a == 2) {
                String str = (String) iconCompat.f2985b;
                if (str.contains(AppConstants.COLON)) {
                    String str2 = str.split(AppConstants.COLON, -1)[1];
                    String str3 = str2.split("/", -1)[0];
                    String str4 = str2.split("/", -1)[1];
                    String str5 = str.split(AppConstants.COLON, -1)[0];
                    int identifier = IconCompat.a(context, str5).getIdentifier(str4, str3, str5);
                    if (iconCompat.f2988e != identifier) {
                        StringBuilder sb = new StringBuilder("Id has changed for ");
                        sb.append(str5);
                        sb.append("/");
                        sb.append(str4);
                        iconCompat.f2988e = identifier;
                    }
                }
            }
            int i2 = iconCompat.f2984a;
            if (i2 == 1) {
                bitmap = (Bitmap) iconCompat.f2985b;
                if (drawable != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } else if (i2 == 2) {
                try {
                    Context createPackageContext = context.createPackageContext(iconCompat.a(), 0);
                    if (drawable == null) {
                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, iconCompat.f2988e));
                    } else {
                        Drawable a2 = androidx.core.content.b.a(createPackageContext, iconCompat.f2988e);
                        if (a2.getIntrinsicWidth() > 0) {
                            if (a2.getIntrinsicHeight() > 0) {
                                bitmap2 = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                                a2.setBounds(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                                a2.draw(new Canvas(bitmap2));
                                bitmap = bitmap2;
                            }
                        }
                        int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                        bitmap2 = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                        a2.setBounds(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                        a2.draw(new Canvas(bitmap2));
                        bitmap = bitmap2;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException("Can't find package " + iconCompat.f2985b, e2);
                }
            } else if (i2 == 5) {
                bitmap = IconCompat.a((Bitmap) iconCompat.f2985b, true);
            } else {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            if (drawable != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                drawable.setBounds(width / 2, height / 2, width, height);
                drawable.draw(new Canvas(bitmap));
            }
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        }
        return intent;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f2821a = new b();

        public a(Context context, String str) {
            b bVar = this.f2821a;
            bVar.f2812a = context;
            bVar.f2813b = str;
        }
    }
}
