package com.paytm.android.chat.utils.imagecropper;

import android.graphics.RectF;
import android.net.Uri;
import com.paytm.android.chat.utils.imagecropper.Callbacks;
import io.reactivex.rxjava3.a.b;

public class LoadRequest {
    private CropImageView cropImageView;
    private RectF initialFrameRect;
    private float initialFrameScale;
    private Uri sourceUri;
    private boolean useThumbnail;

    public LoadRequest(CropImageView cropImageView2, Uri uri) {
        this.cropImageView = cropImageView2;
        this.sourceUri = uri;
    }

    public LoadRequest initialFrameScale(float f2) {
        this.initialFrameScale = f2;
        return this;
    }

    public LoadRequest initialFrameRect(RectF rectF) {
        this.initialFrameRect = rectF;
        return this;
    }

    public LoadRequest useThumbnail(boolean z) {
        this.useThumbnail = z;
        return this;
    }

    public void execute(Callbacks.LoadCallback loadCallback) {
        if (this.initialFrameRect == null) {
            this.cropImageView.setInitialFrameScale(this.initialFrameScale);
        }
        this.cropImageView.loadAsync(this.sourceUri, this.useThumbnail, this.initialFrameRect, loadCallback);
    }

    public b executeAsCompletable() {
        if (this.initialFrameRect == null) {
            this.cropImageView.setInitialFrameScale(this.initialFrameScale);
        }
        return this.cropImageView.loadAsCompletable(this.sourceUri, this.useThumbnail, this.initialFrameRect);
    }
}
