package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.graphics.RectF;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropWindowMoveHandler;

final class CropWindowHandler {
    private final RectF mEdges = new RectF();
    private final RectF mGetEdges = new RectF();
    private float mMaxCropResultHeight;
    private float mMaxCropResultWidth;
    private float mMaxCropWindowHeight;
    private float mMaxCropWindowWidth;
    private float mMinCropResultHeight;
    private float mMinCropResultWidth;
    private float mMinCropWindowHeight;
    private float mMinCropWindowWidth;
    private float mScaleFactorHeight = 1.0f;
    private float mScaleFactorWidth = 1.0f;

    private static boolean isInCenterTargetZone(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f6 && f3 > f5 && f3 < f7;
    }

    CropWindowHandler() {
    }

    public final RectF getRect() {
        this.mGetEdges.set(this.mEdges);
        return this.mGetEdges;
    }

    public final float getMinCropWidth() {
        return Math.max(this.mMinCropWindowWidth, this.mMinCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMinCropHeight() {
        return Math.max(this.mMinCropWindowHeight, this.mMinCropResultHeight / this.mScaleFactorHeight);
    }

    public final float getMaxCropWidth() {
        return Math.min(this.mMaxCropWindowWidth, this.mMaxCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMaxCropHeight() {
        return Math.min(this.mMaxCropWindowHeight, this.mMaxCropResultHeight / this.mScaleFactorHeight);
    }

    public final float getScaleFactorWidth() {
        return this.mScaleFactorWidth;
    }

    public final float getScaleFactorHeight() {
        return this.mScaleFactorHeight;
    }

    public final void setMinCropResultSize(int i2, int i3) {
        this.mMinCropResultWidth = (float) i2;
        this.mMinCropResultHeight = (float) i3;
    }

    public final void setMaxCropResultSize(int i2, int i3) {
        this.mMaxCropResultWidth = (float) i2;
        this.mMaxCropResultHeight = (float) i3;
    }

    public final void setCropWindowLimits(float f2, float f3, float f4, float f5) {
        this.mMaxCropWindowWidth = f2;
        this.mMaxCropWindowHeight = f3;
        this.mScaleFactorWidth = f4;
        this.mScaleFactorHeight = f5;
    }

    public final void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.mMinCropWindowWidth = (float) cropImageOptions.minCropWindowWidth;
        this.mMinCropWindowHeight = (float) cropImageOptions.minCropWindowHeight;
        this.mMinCropResultWidth = (float) cropImageOptions.minCropResultWidth;
        this.mMinCropResultHeight = (float) cropImageOptions.minCropResultHeight;
        this.mMaxCropResultWidth = (float) cropImageOptions.maxCropResultWidth;
        this.mMaxCropResultHeight = (float) cropImageOptions.maxCropResultHeight;
    }

    public final void setRect(RectF rectF) {
        this.mEdges.set(rectF);
    }

    public final boolean showGuidelines() {
        return this.mEdges.width() >= 100.0f && this.mEdges.height() >= 100.0f;
    }

    public final CropWindowMoveHandler getMoveHandler(float f2, float f3, float f4, CropImageView.CropShape cropShape) {
        CropWindowMoveHandler.Type type;
        if (cropShape == CropImageView.CropShape.OVAL) {
            type = getOvalPressedMoveType(f2, f3);
        } else {
            type = getRectanglePressedMoveType(f2, f3, f4);
        }
        if (type != null) {
            return new CropWindowMoveHandler(type, this, f2, f3);
        }
        return null;
    }

    private CropWindowMoveHandler.Type getRectanglePressedMoveType(float f2, float f3, float f4) {
        if (isInCornerTargetZone(f2, f3, this.mEdges.left, this.mEdges.top, f4)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        if (isInCornerTargetZone(f2, f3, this.mEdges.right, this.mEdges.top, f4)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        if (isInCornerTargetZone(f2, f3, this.mEdges.left, this.mEdges.bottom, f4)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        if (isInCornerTargetZone(f2, f3, this.mEdges.right, this.mEdges.bottom, f4)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (isInCenterTargetZone(f2, f3, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom) && focusCenter()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        if (isInHorizontalTargetZone(f2, f3, this.mEdges.left, this.mEdges.right, this.mEdges.top, f4)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (isInHorizontalTargetZone(f2, f3, this.mEdges.left, this.mEdges.right, this.mEdges.bottom, f4)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (isInVerticalTargetZone(f2, f3, this.mEdges.left, this.mEdges.top, this.mEdges.bottom, f4)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        if (isInVerticalTargetZone(f2, f3, this.mEdges.right, this.mEdges.top, this.mEdges.bottom, f4)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (!isInCenterTargetZone(f2, f3, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom) || focusCenter()) {
            return null;
        }
        return CropWindowMoveHandler.Type.CENTER;
    }

    private CropWindowMoveHandler.Type getOvalPressedMoveType(float f2, float f3) {
        float width = this.mEdges.width() / 6.0f;
        float f4 = this.mEdges.left + width;
        float f5 = this.mEdges.left + (width * 5.0f);
        float height = this.mEdges.height() / 6.0f;
        float f6 = this.mEdges.top + height;
        float f7 = this.mEdges.top + (height * 5.0f);
        if (f2 < f4) {
            if (f3 < f6) {
                return CropWindowMoveHandler.Type.TOP_LEFT;
            }
            if (f3 < f7) {
                return CropWindowMoveHandler.Type.LEFT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        } else if (f2 < f5) {
            if (f3 < f6) {
                return CropWindowMoveHandler.Type.TOP;
            }
            if (f3 < f7) {
                return CropWindowMoveHandler.Type.CENTER;
            }
            return CropWindowMoveHandler.Type.BOTTOM;
        } else if (f3 < f6) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        } else {
            if (f3 < f7) {
                return CropWindowMoveHandler.Type.RIGHT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
    }

    private static boolean isInCornerTargetZone(float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f2 - f4) <= f6 && Math.abs(f3 - f5) <= f6;
    }

    private static boolean isInHorizontalTargetZone(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f5 && Math.abs(f3 - f6) <= f7;
    }

    private static boolean isInVerticalTargetZone(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.abs(f2 - f4) <= f7 && f3 > f5 && f3 < f6;
    }

    private boolean focusCenter() {
        return !showGuidelines();
    }
}
