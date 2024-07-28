package net.one97.paytm.paymentsBank.widget.croptool;

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
import android.provider.MediaStore;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public final class CropImage {
    private static List<Intent> a(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Uri b2 = b(context);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
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

    public static a a() {
        return new a((byte) 0);
    }

    public static ActivityResult a(Intent intent) {
        if (intent != null) {
            return (ActivityResult) intent.getParcelableExtra(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_RESULT);
        }
        return null;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f19647a;

        /* renamed from: b  reason: collision with root package name */
        private final CropImageOptions f19648b;

        /* renamed from: c  reason: collision with root package name */
        private String f19649c;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f19647a = null;
            this.f19648b = new CropImageOptions();
        }

        private Intent a(Context context) {
            this.f19648b.a();
            Intent intent = new Intent();
            intent.setClass(context, CropImageActivity.class);
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.f19649c)) {
                intent.putExtra("CROP_IMAGE_FILE_PATH", this.f19649c);
            }
            bundle.putParcelable(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_SOURCE, this.f19647a);
            bundle.putParcelable(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_OPTIONS, this.f19648b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
            return intent;
        }

        public final void a(Activity activity) {
            this.f19648b.a();
            activity.startActivityForResult(a((Context) activity), 203);
        }

        public final void a(Activity activity, int i2) {
            this.f19648b.a();
            activity.startActivityForResult(a((Context) activity), i2);
        }

        public final a a(PBCropImageView.c cVar) {
            this.f19648b.f19657d = cVar;
            return this;
        }

        public final a a(String str) {
            this.f19649c = str;
            return this;
        }
    }

    public static final class ActivityResult extends PBCropImageView.a implements Parcelable {
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
            parcel.writeParcelable(this.f19682a, i2);
            parcel.writeParcelable(this.f19683b, i2);
            parcel.writeSerializable(this.f19684c);
            parcel.writeFloatArray(this.f19685d);
            parcel.writeParcelable(this.f19686e, i2);
            parcel.writeParcelable(this.f19687f, i2);
            parcel.writeInt(this.f19688g);
            parcel.writeInt(this.f19689h);
        }
    }

    public static void a(Activity activity) {
        Intent intent;
        String string = activity.getString(R.string.pb_crop_select_image);
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = activity.getPackageManager();
        if (!a((Context) activity)) {
            arrayList.addAll(a((Context) activity, packageManager));
        }
        List<Intent> a2 = a(packageManager, "android.intent.action.GET_CONTENT");
        if (a2.size() == 0) {
            a2 = a(packageManager, "android.intent.action.PICK");
        }
        arrayList.addAll(a2);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent createChooser = Intent.createChooser(intent, string);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        activity.startActivityForResult(createChooser, 200);
    }
}
