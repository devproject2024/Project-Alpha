package com.paytm.android.chat.utils.imagecropper;

import android.graphics.Bitmap;
import android.net.Uri;
import com.paytm.android.chat.utils.imagecropper.Callbacks;
import io.reactivex.rxjava3.a.y;

public class CropRequest {
    private CropImageView cropImageView;
    private int outputHeight;
    private int outputMaxHeight;
    private int outputMaxWidth;
    private int outputWidth;
    private Uri sourceUri;

    public CropRequest(CropImageView cropImageView2, Uri uri) {
        this.cropImageView = cropImageView2;
        this.sourceUri = uri;
    }

    public CropRequest outputWidth(int i2) {
        this.outputWidth = i2;
        this.outputHeight = 0;
        return this;
    }

    public CropRequest outputHeight(int i2) {
        this.outputHeight = i2;
        this.outputWidth = 0;
        return this;
    }

    public CropRequest outputMaxWidth(int i2) {
        this.outputMaxWidth = i2;
        return this;
    }

    public CropRequest outputMaxHeight(int i2) {
        this.outputMaxHeight = i2;
        return this;
    }

    private void build() {
        int i2 = this.outputWidth;
        if (i2 > 0) {
            this.cropImageView.setOutputWidth(i2);
        }
        int i3 = this.outputHeight;
        if (i3 > 0) {
            this.cropImageView.setOutputHeight(i3);
        }
        this.cropImageView.setOutputMaxSize(this.outputMaxWidth, this.outputMaxHeight);
    }

    public void execute(Callbacks.CropCallback cropCallback) {
        build();
        this.cropImageView.cropAsync(this.sourceUri, cropCallback);
    }

    public y<Bitmap> executeAsSingle() {
        build();
        return this.cropImageView.cropAsSingle(this.sourceUri);
    }
}
