package net.one97.paytm.upi.common.models;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

public class CropResult {
    private final Bitmap mBitmap;
    private final float[] mCropPoints;
    private final Rect mCropRect;
    private final Exception mError;
    private final Bitmap mOriginalBitmap;
    private final Uri mOriginalUri;
    private final int mRotation;
    private final int mSampleSize;
    private final Uri mUri;
    private final Rect mWholeImageRect;

    CropResult(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i2, int i3) {
        this.mOriginalBitmap = bitmap;
        this.mOriginalUri = uri;
        this.mBitmap = bitmap2;
        this.mUri = uri2;
        this.mError = exc;
        this.mCropPoints = fArr;
        this.mCropRect = rect;
        this.mWholeImageRect = rect2;
        this.mRotation = i2;
        this.mSampleSize = i3;
    }

    public Bitmap getOriginalBitmap() {
        return this.mOriginalBitmap;
    }

    public Uri getOriginalUri() {
        return this.mOriginalUri;
    }

    public boolean isSuccessful() {
        return this.mError == null;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Exception getError() {
        return this.mError;
    }

    public float[] getCropPoints() {
        return this.mCropPoints;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public Rect getWholeImageRect() {
        return this.mWholeImageRect;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }
}
