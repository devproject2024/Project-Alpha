package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CropImage {
    public static final int CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE = 2011;
    public static final int CROP_IMAGE_ACTIVITY_REQUEST_CODE = 203;
    public static final int CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE = 204;
    public static final String CROP_IMAGE_EXTRA_OPTIONS = "CROP_IMAGE_EXTRA_OPTIONS";
    public static final String CROP_IMAGE_EXTRA_RESULT = "CROP_IMAGE_EXTRA_RESULT";
    public static final String CROP_IMAGE_EXTRA_SOURCE = "CROP_IMAGE_EXTRA_SOURCE";
    public static final String OPTION_TO_BE_OPEN = "gallery_or_camera";
    public static final int PICK_IMAGE_CHOOSER_REQUEST_CODE = 200;
    public static final int PICK_IMAGE_PERMISSIONS_REQUEST_CODE = 201;

    private CropImage() {
    }

    public static Bitmap toOvalBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawOval(new RectF(0.0f, 0.0f, (float) width, (float) height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static void startPickImageActivity(Activity activity, int i2) {
        activity.startActivityForResult(getPickImageChooserIntent(activity, i2), 200);
    }

    public static void startPickImageActivity(Context context, Fragment fragment, int i2) {
        fragment.startActivityForResult(getPickImageChooserIntent(context, i2), 200);
    }

    public static Intent getPickImageChooserIntent(Context context, int i2) {
        return getPickImageChooserIntent(context, context.getString(R.string.sheroes_pick_image_intent_chooser_title), false, true, i2);
    }

    public static Intent getPickImageChooserIntent(Context context, CharSequence charSequence, boolean z, boolean z2, int i2) {
        Intent intent;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (i2 != 1) {
            if (i2 != 2) {
                if (!isExplicitCameraPermissionRequired(context) && z2) {
                    arrayList.addAll(getCameraIntents(context, packageManager));
                }
                List<Intent> galleryIntents = getGalleryIntents(packageManager, "android.intent.action.GET_CONTENT", z);
                if (galleryIntents.size() == 0) {
                    galleryIntents = getGalleryIntents(packageManager, "android.intent.action.PICK", z);
                }
                arrayList.addAll(galleryIntents);
            } else {
                List<Intent> galleryIntent = getGalleryIntent(packageManager, "android.intent.action.GET_CONTENT", z);
                if (galleryIntent.size() == 0) {
                    galleryIntent = getGalleryIntents(packageManager, "android.intent.action.PICK", z);
                }
                arrayList.addAll(galleryIntent);
            }
        } else if (!isExplicitCameraPermissionRequired(context) && z2) {
            arrayList.addAll(getCameraIntents(context, packageManager));
        }
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent createChooser = Intent.createChooser(intent, charSequence);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return createChooser;
    }

    public static Intent getCameraIntent(Context context, Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (uri == null) {
            uri = getCaptureImageOutputUri(context);
        }
        intent.putExtra("output", uri);
        return intent;
    }

    public static List<Intent> getCameraIntents(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Uri captureImageOutputUri = getCaptureImageOutputUri(context);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
            intent2.setPackage(next.activityInfo.packageName);
            if (captureImageOutputUri != null) {
                intent2.putExtra("output", captureImageOutputUri);
            }
            arrayList.add(intent2);
        }
        return arrayList;
    }

    public static List<Intent> getGalleryIntents(PackageManager packageManager, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        Intent intent = str == "android.intent.action.GET_CONTENT" ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
            intent2.setPackage(next.activityInfo.packageName);
            arrayList.add(intent2);
        }
        if (!z) {
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
        }
        return arrayList;
    }

    public static List<Intent> getGalleryIntent(PackageManager packageManager, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        arrayList.add(intent);
        return arrayList;
    }

    public static boolean isExplicitCameraPermissionRequired(Context context) {
        return Build.VERSION.SDK_INT >= 23 && hasPermissionInManifest(context, "android.permission.CAMERA") && context.checkSelfPermission("android.permission.CAMERA") != 0;
    }

    public static boolean hasPermissionInManifest(Context context, String str) {
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

    public static Uri getCaptureImageOutputUri(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return Uri.fromFile(new File(externalCacheDir.getPath(), AppConstants.IMAGE_CLICK_BY_CAMERA));
        }
        return null;
    }

    public static Uri getPickImageResultUri(Context context, Intent intent) {
        String action;
        boolean z = true;
        if (!(intent == null || intent.getData() == null || ((action = intent.getAction()) != null && action.equals("android.media.action.IMAGE_CAPTURE")))) {
            z = false;
        }
        return (z || intent.getData() == null) ? getCaptureImageOutputUri(context) : intent.getData();
    }

    public static boolean isReadExternalStoragePermissionsRequired(Context context, Uri uri) {
        return Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 && isUriRequiresPermissions(context, uri);
    }

    public static boolean isUriRequiresPermissions(Context context, Uri uri) {
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

    public static ActivityBuilder activity() {
        return new ActivityBuilder((Uri) null, 0);
    }

    public static ActivityBuilder activity(Uri uri, int i2) {
        return new ActivityBuilder(uri, i2);
    }

    public static ActivityResult getActivityResult(Intent intent) {
        if (intent != null) {
            return (ActivityResult) intent.getParcelableExtra(CROP_IMAGE_EXTRA_RESULT);
        }
        return null;
    }

    public static final class ActivityBuilder {
        private int mImageSelectOptionPicker;
        private final CropImageOptions mOptions;
        private final Uri mSource;

        private ActivityBuilder(Uri uri, int i2) {
            this.mSource = uri;
            this.mImageSelectOptionPicker = i2;
            this.mOptions = new CropImageOptions();
        }

        public final Intent getIntent(Context context) {
            return getIntent(context, CropImageActivity.class);
        }

        public final Intent getIntent(Context context, Class<?> cls) {
            this.mOptions.validate();
            Intent intent = new Intent();
            intent.setClass(context, cls);
            Bundle bundle = new Bundle();
            bundle.putParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE, this.mSource);
            bundle.putParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS, this.mOptions);
            bundle.putInt(CropImage.OPTION_TO_BE_OPEN, this.mImageSelectOptionPicker);
            intent.putExtra("bundle", bundle);
            return intent;
        }

        public final void start(Activity activity) {
            this.mOptions.validate();
            activity.startActivityForResult(getIntent(activity), 203);
        }

        public final void start(Activity activity, Class<?> cls) {
            this.mOptions.validate();
            activity.startActivityForResult(getIntent(activity, cls), 203);
        }

        public final void start(Context context, Fragment fragment) {
            fragment.startActivityForResult(getIntent(context), 203);
        }

        public final void start(Context context, android.app.Fragment fragment) {
            fragment.startActivityForResult(getIntent(context), 203);
        }

        public final void start(Context context, Fragment fragment, Class<?> cls) {
            fragment.startActivityForResult(getIntent(context, cls), 203);
        }

        public final void start(Context context, android.app.Fragment fragment, Class<?> cls) {
            fragment.startActivityForResult(getIntent(context, cls), 203);
        }

        public final ActivityBuilder setCropShape(CropImageView.CropShape cropShape) {
            this.mOptions.cropShape = cropShape;
            return this;
        }

        public final ActivityBuilder setSnapRadius(float f2) {
            this.mOptions.snapRadius = f2;
            return this;
        }

        public final ActivityBuilder setTouchRadius(float f2) {
            this.mOptions.touchRadius = f2;
            return this;
        }

        public final ActivityBuilder setGuidelines(CropImageView.Guidelines guidelines) {
            this.mOptions.guidelines = guidelines;
            return this;
        }

        public final ActivityBuilder setScaleType(CropImageView.ScaleType scaleType) {
            this.mOptions.scaleType = scaleType;
            return this;
        }

        public final ActivityBuilder setShowCropOverlay(boolean z) {
            this.mOptions.showCropOverlay = z;
            return this;
        }

        public final ActivityBuilder setAutoZoomEnabled(boolean z) {
            this.mOptions.autoZoomEnabled = z;
            return this;
        }

        public final ActivityBuilder setMultiTouchEnabled(boolean z) {
            this.mOptions.multiTouchEnabled = z;
            return this;
        }

        public final ActivityBuilder setMaxZoom(int i2) {
            this.mOptions.maxZoom = i2;
            return this;
        }

        public final ActivityBuilder setInitialCropWindowPaddingRatio(float f2) {
            this.mOptions.initialCropWindowPaddingRatio = f2;
            return this;
        }

        public final ActivityBuilder setFixAspectRatio(boolean z) {
            this.mOptions.fixAspectRatio = z;
            return this;
        }

        public final ActivityBuilder setAspectRatio(int i2, int i3) {
            CropImageOptions cropImageOptions = this.mOptions;
            cropImageOptions.aspectRatioX = i2;
            cropImageOptions.aspectRatioY = i3;
            cropImageOptions.fixAspectRatio = true;
            return this;
        }

        public final ActivityBuilder setBorderLineThickness(float f2) {
            this.mOptions.borderLineThickness = f2;
            return this;
        }

        public final ActivityBuilder setBorderLineColor(int i2) {
            this.mOptions.borderLineColor = i2;
            return this;
        }

        public final ActivityBuilder setBorderCornerThickness(float f2) {
            this.mOptions.borderCornerThickness = f2;
            return this;
        }

        public final ActivityBuilder setBorderCornerOffset(float f2) {
            this.mOptions.borderCornerOffset = f2;
            return this;
        }

        public final ActivityBuilder setBorderCornerLength(float f2) {
            this.mOptions.borderCornerLength = f2;
            return this;
        }

        public final ActivityBuilder setBorderCornerColor(int i2) {
            this.mOptions.borderCornerColor = i2;
            return this;
        }

        public final ActivityBuilder setGuidelinesThickness(float f2) {
            this.mOptions.guidelinesThickness = f2;
            return this;
        }

        public final ActivityBuilder setGuidelinesColor(int i2) {
            this.mOptions.guidelinesColor = i2;
            return this;
        }

        public final ActivityBuilder setBackgroundColor(int i2) {
            this.mOptions.backgroundColor = i2;
            return this;
        }

        public final ActivityBuilder setMinCropWindowSize(int i2, int i3) {
            CropImageOptions cropImageOptions = this.mOptions;
            cropImageOptions.minCropWindowWidth = i2;
            cropImageOptions.minCropWindowHeight = i3;
            return this;
        }

        public final ActivityBuilder setMinCropResultSize(int i2, int i3) {
            CropImageOptions cropImageOptions = this.mOptions;
            cropImageOptions.minCropResultWidth = i2;
            cropImageOptions.minCropResultHeight = i3;
            return this;
        }

        public final ActivityBuilder setMaxCropResultSize(int i2, int i3) {
            CropImageOptions cropImageOptions = this.mOptions;
            cropImageOptions.maxCropResultWidth = i2;
            cropImageOptions.maxCropResultHeight = i3;
            return this;
        }

        public final ActivityBuilder setActivityTitle(CharSequence charSequence) {
            this.mOptions.activityTitle = charSequence;
            return this;
        }

        public final ActivityBuilder setActivityMenuIconColor(int i2) {
            this.mOptions.activityMenuIconColor = i2;
            return this;
        }

        public final ActivityBuilder setOutputUri(Uri uri) {
            this.mOptions.outputUri = uri;
            return this;
        }

        public final ActivityBuilder setOutputCompressFormat(Bitmap.CompressFormat compressFormat) {
            this.mOptions.outputCompressFormat = compressFormat;
            return this;
        }

        public final ActivityBuilder setOutputCompressQuality(int i2) {
            this.mOptions.outputCompressQuality = i2;
            return this;
        }

        public final ActivityBuilder setRequestedSize(int i2, int i3) {
            return setRequestedSize(i2, i3, CropImageView.RequestSizeOptions.RESIZE_INSIDE);
        }

        public final ActivityBuilder setRequestedSize(int i2, int i3, CropImageView.RequestSizeOptions requestSizeOptions) {
            CropImageOptions cropImageOptions = this.mOptions;
            cropImageOptions.outputRequestWidth = i2;
            cropImageOptions.outputRequestHeight = i3;
            cropImageOptions.outputRequestSizeOptions = requestSizeOptions;
            return this;
        }

        public final ActivityBuilder setNoOutputImage(boolean z) {
            this.mOptions.noOutputImage = z;
            return this;
        }

        public final ActivityBuilder setInitialCropWindowRectangle(Rect rect) {
            this.mOptions.initialCropWindowRectangle = rect;
            return this;
        }

        public final ActivityBuilder setInitialRotation(int i2) {
            this.mOptions.initialRotation = (i2 + 360) % 360;
            return this;
        }

        public final ActivityBuilder setAllowRotation(boolean z) {
            this.mOptions.allowRotation = z;
            return this;
        }

        public final ActivityBuilder setAllowFlipping(boolean z) {
            this.mOptions.allowFlipping = z;
            return this;
        }

        public final ActivityBuilder setAllowCounterRotation(boolean z) {
            this.mOptions.allowCounterRotation = z;
            return this;
        }

        public final ActivityBuilder setRotationDegrees(int i2) {
            this.mOptions.rotationDegrees = (i2 + 360) % 360;
            return this;
        }

        public final ActivityBuilder setFlipHorizontally(boolean z) {
            this.mOptions.flipHorizontally = z;
            return this;
        }

        public final ActivityBuilder setFlipVertically(boolean z) {
            this.mOptions.flipVertically = z;
            return this;
        }
    }

    public static final class ActivityResult extends CropImageView.CropResult implements Parcelable {
        public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
            public final ActivityResult createFromParcel(Parcel parcel) {
                return new ActivityResult(parcel);
            }

            public final ActivityResult[] newArray(int i2) {
                return new ActivityResult[i2];
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
            parcel.writeParcelable(getOriginalUri(), i2);
            parcel.writeParcelable(getUri(), i2);
            parcel.writeSerializable(getError());
            parcel.writeFloatArray(getCropPoints());
            parcel.writeParcelable(getCropRect(), i2);
            parcel.writeParcelable(getWholeImageRect(), i2);
            parcel.writeInt(getRotation());
            parcel.writeInt(getSampleSize());
        }
    }
}
