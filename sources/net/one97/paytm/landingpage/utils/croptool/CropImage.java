package net.one97.paytm.landingpage.utils.croptool;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.MediaStore;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;

public final class CropImage {
    static Intent a(Activity activity, boolean z, boolean z2) {
        Intent intent;
        String string = activity.getString(R.string.select_image);
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = activity.getPackageManager();
        if (!a((Context) activity) && z) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            arrayList.addAll(a((Context) activity, packageManager));
        }
        List<Intent> a2 = a(packageManager, "android.intent.action.GET_CONTENT");
        if (a2.size() == 0) {
            a2 = a(packageManager, "android.intent.action.PICK");
        }
        if (z2) {
            arrayList.addAll(a2);
        }
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent createChooser = Intent.createChooser(intent, string);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return createChooser;
    }

    private static List<Intent> a(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Uri b2 = b(context);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
            intent2.setPackage(next.activityInfo.packageName);
            if (b2 != null) {
                intent2.putExtra("output", b2);
            }
            arrayList.add(intent2);
        }
        return arrayList;
    }

    private static List<Intent> a(PackageManager packageManager, String str) {
        ArrayList arrayList = new ArrayList();
        Intent intent = str == "android.intent.action.GET_CONTENT" ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
            intent2.setPackage(next.activityInfo.packageName);
            arrayList.add(intent2);
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Intent intent3 = (Intent) it2.next();
            if (intent3.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                arrayList.remove(intent3);
                break;
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 23 && a(context, "android.permission.CAMERA") && context.checkSelfPermission("android.permission.CAMERA") != 0;
    }

    private static boolean a(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                for (String equalsIgnoreCase : strArr) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static Uri b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return Uri.fromFile(new File(externalCacheDir.getPath(), AppConstants.IMAGE_CLICK_BY_CAMERA));
        }
        return null;
    }

    public static boolean a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 && b(context, uri);
    }

    private static boolean b(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return false;
            }
            openInputStream.close();
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static a a(Uri uri) {
        return new a(uri, (byte) 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f52907a;

        /* renamed from: b  reason: collision with root package name */
        private final CropImageOptions f52908b;

        /* synthetic */ a(Uri uri, byte b2) {
            this(uri);
        }

        private a(Uri uri) {
            this.f52907a = uri;
            this.f52908b = new CropImageOptions();
        }

        public final Intent a(Context context, Class<?> cls) {
            this.f52908b.a();
            Intent intent = new Intent();
            intent.setClass(context, cls);
            Bundle bundle = new Bundle();
            bundle.putParcelable(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_SOURCE, this.f52907a);
            bundle.putParcelable(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_OPTIONS, this.f52908b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
            return intent;
        }

        public final void a(Activity activity, boolean z, boolean z2) {
            this.f52908b.a();
            Intent a2 = a(activity, CropImageActivity.class);
            a2.putExtra("is_camera_needed", z);
            a2.putExtra("is_gallery_neeedd", z2);
            activity.startActivityForResult(a2, 203);
        }

        public final a a(CropImageView.c cVar) {
            this.f52908b.f52915d = cVar;
            return this;
        }
    }

    public static final class ActivityResult extends CropImageView.a implements Parcelable {
        public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ActivityResult[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ActivityResult(parcel);
            }
        };

        public final int describeContents() {
            return 0;
        }

        public ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i2, Rect rect2, int i3) {
            super((Bitmap) null, uri, (Bitmap) null, uri2, exc, fArr, rect, rect2, i2, i3);
        }

        protected ActivityResult(Parcel parcel) {
            super((Bitmap) null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Bitmap) null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f52931a, i2);
            parcel.writeParcelable(this.f52932b, i2);
            parcel.writeSerializable(this.f52933c);
            parcel.writeFloatArray(this.f52934d);
            parcel.writeParcelable(this.f52935e, i2);
            parcel.writeParcelable(this.f52936f, i2);
            parcel.writeInt(this.f52937g);
            parcel.writeInt(this.f52938h);
        }
    }
}
