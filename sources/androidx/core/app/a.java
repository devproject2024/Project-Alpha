package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.o;
import java.util.List;
import java.util.Map;

public final class a extends androidx.core.content.b {

    /* renamed from: a  reason: collision with root package name */
    private static b f2659a;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    public interface C0038a {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean a();

        boolean b();
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static b a() {
        return f2659a;
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(oVar != null ? new d(oVar) : null);
        }
    }

    public static void b(Activity activity, o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(oVar != null ? new d(oVar) : null);
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i2) {
        b bVar = f2659a;
        if (bVar != null && bVar.a()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).validateRequestPermissionsRequestCode(i2);
            }
            activity.requestPermissions(strArr, i2);
        } else if (activity instanceof C0038a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((C0038a) activity).onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void e(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (Build.VERSION.SDK_INT <= 23) {
            new Handler(activity.getMainLooper()).post(new Runnable() {
                public final void run() {
                    if (!activity.isFinishing() && !c.a(activity)) {
                        activity.recreate();
                    }
                }
            });
        } else if (!c.a(activity)) {
            activity.recreate();
        }
    }

    static class d extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final o f2664a;

        public final void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public final void onRejectSharedElements(List<View> list) {
        }

        public final void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        public final void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        d(o oVar) {
            this.f2664a = oVar;
        }

        public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            Bitmap bitmap;
            View view2 = view;
            RectF rectF2 = rectF;
            o oVar = this.f2664a;
            if (view2 instanceof ImageView) {
                ImageView imageView = (ImageView) view2;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                        bitmap = null;
                    } else {
                        float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
                        if (!(drawable instanceof BitmapDrawable) || min != 1.0f) {
                            int i2 = (int) (((float) intrinsicWidth) * min);
                            int i3 = (int) (((float) intrinsicHeight) * min);
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            Rect bounds = drawable.getBounds();
                            int i4 = bounds.left;
                            int i5 = bounds.top;
                            int i6 = bounds.right;
                            int i7 = bounds.bottom;
                            drawable.setBounds(0, 0, i2, i3);
                            drawable.draw(canvas);
                            drawable.setBounds(i4, i5, i6, i7);
                            bitmap = createBitmap;
                        } else {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        }
                    }
                    if (bitmap != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("sharedElement:snapshot:bitmap", bitmap);
                        bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float[] fArr = new float[9];
                            imageView.getImageMatrix().getValues(fArr);
                            bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                        }
                        return bundle;
                    }
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (round <= 0 || round2 <= 0) {
                return null;
            }
            float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int i8 = (int) (((float) round) * min2);
            int i9 = (int) (((float) round2) * min2);
            if (oVar.f2807a == null) {
                oVar.f2807a = new Matrix();
            }
            oVar.f2807a.set(matrix);
            oVar.f2807a.postTranslate(-rectF2.left, -rectF2.top);
            oVar.f2807a.postScale(min2, min2);
            Bitmap createBitmap2 = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.concat(oVar.f2807a);
            view2.draw(canvas2);
            return createBitmap2;
        }

        public final void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            new o.a() {
                public final void a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            }.a();
        }

        public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
                if (bitmap == null) {
                    return null;
                }
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
                if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                    return imageView;
                }
                float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                imageView.setImageMatrix(matrix);
                return imageView;
            } else if (!(parcelable instanceof Bitmap)) {
                return null;
            } else {
                ImageView imageView2 = new ImageView(context);
                imageView2.setImageBitmap((Bitmap) parcelable);
                return imageView2;
            }
        }
    }
}
