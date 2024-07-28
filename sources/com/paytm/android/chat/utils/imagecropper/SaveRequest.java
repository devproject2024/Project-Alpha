package com.paytm.android.chat.utils.imagecropper;

import android.graphics.Bitmap;
import android.net.Uri;
import com.paytm.android.chat.utils.imagecropper.Callbacks;
import io.reactivex.rxjava3.a.y;

public class SaveRequest {
    private Bitmap.CompressFormat compressFormat;
    private int compressQuality = -1;
    private CropImageView cropImageView;
    private Bitmap image;

    public SaveRequest(CropImageView cropImageView2, Bitmap bitmap) {
        this.cropImageView = cropImageView2;
        this.image = bitmap;
    }

    public SaveRequest compressFormat(Bitmap.CompressFormat compressFormat2) {
        this.compressFormat = compressFormat2;
        return this;
    }

    public SaveRequest compressQuality(int i2) {
        this.compressQuality = i2;
        return this;
    }

    private void build() {
        Bitmap.CompressFormat compressFormat2 = this.compressFormat;
        if (compressFormat2 != null) {
            this.cropImageView.setCompressFormat(compressFormat2);
        }
        int i2 = this.compressQuality;
        if (i2 >= 0) {
            this.cropImageView.setCompressQuality(i2);
        }
    }

    public void execute(Uri uri, Callbacks.SaveCallback saveCallback) {
        build();
        this.cropImageView.saveAsync(uri, this.image, saveCallback);
    }

    public y<Uri> executeAsSingle(Uri uri) {
        build();
        return this.cropImageView.saveAsSingle(this.image, uri);
    }
}
