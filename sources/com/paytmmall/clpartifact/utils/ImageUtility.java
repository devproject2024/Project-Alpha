package com.paytmmall.clpartifact.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.a;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.R;

public class ImageUtility {
    private static ImageUtility mInstance;

    private ImageUtility() {
    }

    public static ImageUtility getInstance() {
        if (mInstance == null) {
            mInstance = new ImageUtility();
        }
        return mInstance;
    }

    public void loadImageWithPlaceHolder(ImageView imageView, String str, boolean z) {
        loadImageWithOutCornerRadius(imageView, str, z, imageView.getContext());
    }

    public void loadImageWithPlaceHolder(ImageView imageView, String str, int i2, boolean z) {
        loadImageWithPlaceHolder(imageView, str, i2, z, imageView.getContext());
    }

    public void loadImageWithPlaceHolder(ImageView imageView, String str, int i2, boolean z, Context context) {
        if (!isActivityDestroyed(context)) {
            HomeUtils.d("loadImageWithPlaceHolder called with url ".concat(String.valueOf(str)), false);
            if (z) {
                b.a.C0750a a2 = b.a(context);
                a2.f43753a = str;
                b.a.C0750a a3 = a2.a((Object) Integer.valueOf(R.drawable.picasso_default_placeholder)).a(a.ALL);
                a3.M = false;
                b.a.C0750a.a(a3.a(i2, b.a.ALL), imageView, (com.paytm.utility.b.b.b) null, 2);
                return;
            }
            b.a.C0750a a4 = com.paytm.utility.b.b.a(context);
            a4.f43753a = str;
            b.a.C0750a a5 = a4.a((Object) Integer.valueOf(R.drawable.picasso_default_placeholder)).a(a.ALL);
            a5.M = false;
            a5.m = true;
            b.a.C0750a.a(a5.a(i2, b.a.ALL), imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public void loadImageWithOutCornerRadius(ImageView imageView, String str, boolean z, Context context) {
        if (!isActivityDestroyed(context)) {
            HomeUtils.d("loadImageWithOutCornerRadious called with url ".concat(String.valueOf(str)), false);
            if (z) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                a2.f43753a = str;
                b.a.C0750a a3 = a2.a((Object) Integer.valueOf(R.drawable.picasso_default_placeholder)).a(a.ALL);
                a3.M = false;
                b.a.C0750a.a(a3, imageView, (com.paytm.utility.b.b.b) null, 2);
                return;
            }
            b.a.C0750a a4 = com.paytm.utility.b.b.a(context);
            a4.f43753a = str;
            b.a.C0750a a5 = a4.a((Object) Integer.valueOf(R.drawable.picasso_default_placeholder)).a(a.ALL);
            a5.M = false;
            a5.m = true;
            b.a.C0750a.a(a5, imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public void loadImageWithOutPlaceHolder(ImageView imageView, String str, boolean z, Context context) {
        if (!isActivityDestroyed(context)) {
            HomeUtils.d("loadImageWithOutCornerRadious called with url ".concat(String.valueOf(str)), false);
            if (z) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                a2.f43753a = str;
                b.a.C0750a a3 = a2.a(a.ALL);
                a3.M = false;
                b.a.C0750a.a(a3, imageView, (com.paytm.utility.b.b.b) null, 2);
                return;
            }
            b.a.C0750a a4 = com.paytm.utility.b.b.a(context);
            a4.f43753a = str;
            b.a.C0750a a5 = a4.a(a.ALL);
            a5.M = false;
            a5.m = true;
            b.a.C0750a.a(a5, imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public void setBitmapDrawable(final ImageView imageView, String str) {
        if (!isActivitydestroyed(imageView)) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
            a2.f43753a = str;
            a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Bitmap>() {
                public void onError(Exception exc) {
                }

                public void onSuccess(Bitmap bitmap, c cVar) {
                    ImageView imageView = imageView;
                    imageView.setBackground(new BitmapDrawable(imageView.getContext().getResources(), bitmap));
                }
            });
        }
    }

    public void loadImageWithCustomPlaceHolder(ImageView imageView, String str, boolean z, int i2, Context context) {
        HomeUtils.d("loadImageWithCustomPlaceHolder with url ".concat(String.valueOf(str)), false);
        if (isActivityDestroyed(context)) {
            return;
        }
        if (z) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
            a2.f43753a = str;
            b.a.C0750a a3 = a2.a((Object) Integer.valueOf(i2)).a(a.ALL);
            a3.M = false;
            b.a.C0750a.a(a3, imageView, (com.paytm.utility.b.b.b) null, 2);
            return;
        }
        b.a.C0750a a4 = com.paytm.utility.b.b.a(context);
        a4.f43753a = str;
        b.a.C0750a a5 = a4.a((Object) Integer.valueOf(i2)).a(a.ALL);
        a5.M = false;
        a5.m = true;
        b.a.C0750a.a(a5, imageView, (com.paytm.utility.b.b.b) null, 2);
    }

    public static boolean isActivitydestroyed(View view) {
        Activity activity = view.getContext() instanceof Activity ? (Activity) view.getContext() : null;
        if (activity != null) {
            return activity.isFinishing() || activity.isDestroyed();
        }
        return false;
    }

    public static boolean isActivityDestroyed(Context context) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            return activity.isFinishing() || activity.isDestroyed();
        }
        return false;
    }

    public static void loadImageAsync(ImageView imageView, Context context, String str) {
        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
        a2.f43753a = str;
        a2.n = true;
        b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
    }

    public static void loadBackgroundImageAsync(final View view, Context context, String str) {
        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
        a2.f43753a = str;
        a2.l = true;
        a2.a((Object) Integer.valueOf(R.color.clp_light_grey_border)).a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
            public final void onError(Exception exc) {
            }

            public final void onSuccess(Drawable drawable, c cVar) {
                view.setBackground(drawable);
            }
        });
    }

    public static void loadBackgroundDrawableAsync(final View view, Context context, String str) {
        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
        a2.f43753a = str;
        a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
            public final void onError(Exception exc) {
            }

            public final void onSuccess(Drawable drawable, c cVar) {
                view.setBackground(drawable);
            }
        });
    }

    public static void loadBackgroundDrawableAsync(final View view, Context context, int i2) {
        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
        a2.f43753a = Integer.valueOf(i2);
        a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
            public final void onError(Exception exc) {
            }

            public final void onSuccess(Drawable drawable, c cVar) {
                view.setBackground(drawable);
            }
        });
    }

    public static void loadDrawableAsync(ImageView imageView, Context context, int i2) {
        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
        a2.f43753a = Integer.valueOf(i2);
        b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
    }
}
