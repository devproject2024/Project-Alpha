package com.paytm.android.chat.utils.imagecropper;

import android.graphics.Bitmap;
import android.net.Uri;

public class Callbacks {

    public interface CropCallback extends ImageCallback {
        void onSuccess(Bitmap bitmap);
    }

    public interface ImageCallback {
        void onError(Throwable th);
    }

    public interface LoadCallback extends ImageCallback {
        void onSuccess();
    }

    public interface SaveCallback extends ImageCallback {
        void onSuccess(Uri uri);
    }
}
