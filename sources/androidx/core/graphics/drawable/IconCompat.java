package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: h  reason: collision with root package name */
    static final PorterDuff.Mode f2983h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2984a = -1;

    /* renamed from: b  reason: collision with root package name */
    public Object f2985b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2986c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2987d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f2988e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2989f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2990g = null;

    /* renamed from: i  reason: collision with root package name */
    PorterDuff.Mode f2991i = f2983h;
    public String j = null;

    public static IconCompat a(Context context, int i2) {
        if (context != null) {
            return a(context.getResources(), context.getPackageName(), i2);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static IconCompat a(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2988e = i2;
            if (resources != null) {
                try {
                    iconCompat.f2985b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2985b = str;
            }
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    public static IconCompat a(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f2985b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public IconCompat() {
    }

    private IconCompat(int i2) {
        this.f2984a = i2;
    }

    public final String a() {
        if (this.f2984a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f2985b);
        }
        if (this.f2984a == 2) {
            return ((String) this.f2985b).split(AppConstants.COLON, -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on ".concat(String.valueOf(this)));
    }

    public final int b() {
        if (this.f2984a == -1 && Build.VERSION.SDK_INT >= 23) {
            return c((Icon) this.f2985b);
        }
        if (this.f2984a == 2) {
            return this.f2988e;
        }
        throw new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
    }

    private Uri d() {
        if (this.f2984a == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.f2985b);
        }
        int i2 = this.f2984a;
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f2985b);
        }
        throw new IllegalStateException("called getUri() on ".concat(String.valueOf(this)));
    }

    public final Icon a(Context context) {
        Icon icon;
        switch (this.f2984a) {
            case -1:
                return (Icon) this.f2985b;
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.f2985b);
                break;
            case 2:
                icon = Icon.createWithResource(a(), this.f2988e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f2985b, this.f2988e, this.f2989f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f2985b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(a((Bitmap) this.f2985b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f2985b);
                    break;
                }
            case 6:
                if (context != null) {
                    InputStream b2 = b(context);
                    if (b2 != null) {
                        if (Build.VERSION.SDK_INT < 26) {
                            icon = Icon.createWithBitmap(a(BitmapFactory.decodeStream(b2), false));
                            break;
                        } else {
                            icon = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(b2));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + d());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + d());
                }
            default:
                throw new IllegalArgumentException("Unknown type");
        }
        ColorStateList colorStateList = this.f2990g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2991i;
        if (mode != f2983h) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    private InputStream b(Context context) {
        Uri d2 = d();
        String scheme = d2.getScheme();
        if ("content".equals(scheme) || CommunityPostActivity.TYPE_FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(d2);
            } catch (Exception unused) {
                new StringBuilder("Unable to load image from URI: ").append(d2);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2985b));
            } catch (FileNotFoundException unused2) {
                new StringBuilder("Unable to load image from path: ").append(d2);
                return null;
            }
        }
    }

    public static Resources a(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            String.format("Unable to find pkg=%s for icon", new Object[]{str});
            return null;
        }
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        switch (this.f2984a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f2985b);
                break;
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f2985b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f2985b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f2985b);
                break;
            default:
                throw new IllegalArgumentException("Invalid icon");
        }
        bundle.putInt("type", this.f2984a);
        bundle.putInt("int1", this.f2988e);
        bundle.putInt("int2", this.f2989f);
        ColorStateList colorStateList = this.f2990g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f2991i;
        if (mode != f2983h) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public String toString() {
        String str;
        if (this.f2984a == -1) {
            return String.valueOf(this.f2985b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2984a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = H5Utils.NETWORK_TYPE_UNKNOWN;
                break;
        }
        sb.append(str);
        switch (this.f2984a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2985b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2985b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(a());
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(b())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2988e);
                if (this.f2989f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2989f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2985b);
                break;
        }
        if (this.f2990g != null) {
            sb.append(" tint=");
            sb.append(this.f2990g);
        }
        if (this.f2991i != f2983h) {
            sb.append(" mode=");
            sb.append(this.f2991i);
        }
        sb.append(")");
        return sb.toString();
    }

    public static int a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            new StringBuilder("Unable to get icon type ").append(icon);
            return -1;
        } catch (InvocationTargetException unused2) {
            new StringBuilder("Unable to get icon type ").append(icon);
            return -1;
        } catch (NoSuchMethodException unused3) {
            new StringBuilder("Unable to get icon type ").append(icon);
            return -1;
        }
    }

    private static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    private static Uri d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }
}
