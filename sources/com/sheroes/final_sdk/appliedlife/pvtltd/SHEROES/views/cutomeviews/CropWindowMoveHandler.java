package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

final class CropWindowMoveHandler {
    private static final Matrix MATRIX = new Matrix();
    private final float mMaxCropHeight;
    private final float mMaxCropWidth;
    private final float mMinCropHeight;
    private final float mMinCropWidth;
    private final PointF mTouchOffset = new PointF();
    private final Type mType;

    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    private static float calculateAspectRatio(float f2, float f3, float f4, float f5) {
        return (f4 - f2) / (f5 - f3);
    }

    public CropWindowMoveHandler(Type type, CropWindowHandler cropWindowHandler, float f2, float f3) {
        this.mType = type;
        this.mMinCropWidth = cropWindowHandler.getMinCropWidth();
        this.mMinCropHeight = cropWindowHandler.getMinCropHeight();
        this.mMaxCropWidth = cropWindowHandler.getMaxCropWidth();
        this.mMaxCropHeight = cropWindowHandler.getMaxCropHeight();
        calculateTouchOffset(cropWindowHandler.getRect(), f2, f3);
    }

    public final void move(RectF rectF, float f2, float f3, RectF rectF2, int i2, int i3, float f4, boolean z, float f5) {
        float f6 = f2 + this.mTouchOffset.x;
        float f7 = f3 + this.mTouchOffset.y;
        if (this.mType == Type.CENTER) {
            moveCenter(rectF, f6, f7, rectF2, i2, i3, f4);
        } else if (z) {
            moveSizeWithFixedAspectRatio(rectF, f6, f7, rectF2, i2, i3, f4, f5);
        } else {
            moveSizeWithFreeAspectRatio(rectF, f6, f7, rectF2, i2, i3, f4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        r3 = r3 - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r4 = r2.mTouchOffset;
        r4.x = r1;
        r4.y = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r1 = r3 - r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void calculateTouchOffset(android.graphics.RectF r3, float r4, float r5) {
        /*
            r2 = this;
            int[] r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$sheroes$final_sdk$appliedlife$pvtltd$SHEROES$views$cutomeviews$CropWindowMoveHandler$Type
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropWindowMoveHandler$Type r1 = r2.mType
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 0
            switch(r0) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0037;
                case 3: goto L_0x0030;
                case 4: goto L_0x0029;
                case 5: goto L_0x0024;
                case 6: goto L_0x0021;
                case 7: goto L_0x001e;
                case 8: goto L_0x001b;
                case 9: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            r3 = 0
            goto L_0x0045
        L_0x0010:
            float r0 = r3.centerX()
            float r1 = r0 - r4
            float r3 = r3.centerY()
            goto L_0x0044
        L_0x001b:
            float r3 = r3.bottom
            goto L_0x0044
        L_0x001e:
            float r3 = r3.right
            goto L_0x0026
        L_0x0021:
            float r3 = r3.top
            goto L_0x0044
        L_0x0024:
            float r3 = r3.left
        L_0x0026:
            float r3 = r3 - r4
            r1 = r3
            goto L_0x000e
        L_0x0029:
            float r0 = r3.right
            float r1 = r0 - r4
            float r3 = r3.bottom
            goto L_0x0044
        L_0x0030:
            float r0 = r3.left
            float r1 = r0 - r4
            float r3 = r3.bottom
            goto L_0x0044
        L_0x0037:
            float r0 = r3.right
            float r1 = r0 - r4
            float r3 = r3.top
            goto L_0x0044
        L_0x003e:
            float r0 = r3.left
            float r1 = r0 - r4
            float r3 = r3.top
        L_0x0044:
            float r3 = r3 - r5
        L_0x0045:
            android.graphics.PointF r4 = r2.mTouchOffset
            r4.x = r1
            r4.y = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropWindowMoveHandler.calculateTouchOffset(android.graphics.RectF, float, float):void");
    }

    private void moveCenter(RectF rectF, float f2, float f3, RectF rectF2, int i2, int i3, float f4) {
        float centerX = f2 - rectF.centerX();
        float centerY = f3 - rectF.centerY();
        if (rectF.left + centerX < 0.0f || rectF.right + centerX > ((float) i2) || rectF.left + centerX < rectF2.left || rectF.right + centerX > rectF2.right) {
            centerX /= 1.05f;
            this.mTouchOffset.x -= centerX / 2.0f;
        }
        if (rectF.top + centerY < 0.0f || rectF.bottom + centerY > ((float) i3) || rectF.top + centerY < rectF2.top || rectF.bottom + centerY > rectF2.bottom) {
            centerY /= 1.05f;
            this.mTouchOffset.y -= centerY / 2.0f;
        }
        rectF.offset(centerX, centerY);
        snapEdgesToBounds(rectF, rectF2, f4);
    }

    private void moveSizeWithFreeAspectRatio(RectF rectF, float f2, float f3, RectF rectF2, int i2, int i3, float f4) {
        switch (this.mType) {
            case TOP_LEFT:
                RectF rectF3 = rectF;
                RectF rectF4 = rectF2;
                float f5 = f4;
                adjustTop(rectF3, f3, rectF4, f5, 0.0f, false, false);
                adjustLeft(rectF3, f2, rectF4, f5, 0.0f, false, false);
                return;
            case TOP_RIGHT:
                RectF rectF5 = rectF;
                RectF rectF6 = rectF2;
                adjustTop(rectF5, f3, rectF6, f4, 0.0f, false, false);
                adjustRight(rectF5, f2, rectF6, i2, f4, 0.0f, false, false);
                return;
            case BOTTOM_LEFT:
                RectF rectF7 = rectF;
                RectF rectF8 = rectF2;
                adjustBottom(rectF7, f3, rectF8, i3, f4, 0.0f, false, false);
                adjustLeft(rectF7, f2, rectF8, f4, 0.0f, false, false);
                return;
            case BOTTOM_RIGHT:
                RectF rectF9 = rectF;
                RectF rectF10 = rectF2;
                float f6 = f4;
                adjustBottom(rectF9, f3, rectF10, i3, f6, 0.0f, false, false);
                adjustRight(rectF9, f2, rectF10, i2, f6, 0.0f, false, false);
                return;
            case LEFT:
                adjustLeft(rectF, f2, rectF2, f4, 0.0f, false, false);
                return;
            case TOP:
                adjustTop(rectF, f3, rectF2, f4, 0.0f, false, false);
                return;
            case RIGHT:
                adjustRight(rectF, f2, rectF2, i2, f4, 0.0f, false, false);
                return;
            case BOTTOM:
                adjustBottom(rectF, f3, rectF2, i3, f4, 0.0f, false, false);
                return;
            default:
                return;
        }
    }

    private void moveSizeWithFixedAspectRatio(RectF rectF, float f2, float f3, RectF rectF2, int i2, int i3, float f4, float f5) {
        RectF rectF3 = rectF;
        float f6 = f2;
        float f7 = f3;
        RectF rectF4 = rectF2;
        float f8 = f5;
        switch (this.mType) {
            case TOP_LEFT:
                if (calculateAspectRatio(f2, f7, rectF3.right, rectF3.bottom) < f8) {
                    adjustTop(rectF, f3, rectF2, f4, f5, true, false);
                    adjustLeftByAspectRatio(rectF, f8);
                    return;
                }
                adjustLeft(rectF, f2, rectF2, f4, f5, true, false);
                adjustTopByAspectRatio(rectF, f8);
                return;
            case TOP_RIGHT:
                if (calculateAspectRatio(rectF3.left, f7, f2, rectF3.bottom) < f8) {
                    adjustTop(rectF, f3, rectF2, f4, f5, false, true);
                    adjustRightByAspectRatio(rectF, f8);
                    return;
                }
                adjustRight(rectF, f2, rectF2, i2, f4, f5, true, false);
                adjustTopByAspectRatio(rectF, f8);
                return;
            case BOTTOM_LEFT:
                if (calculateAspectRatio(f2, rectF3.top, rectF3.right, f7) < f8) {
                    adjustBottom(rectF, f3, rectF2, i3, f4, f5, true, false);
                    adjustLeftByAspectRatio(rectF, f8);
                    return;
                }
                adjustLeft(rectF, f2, rectF2, f4, f5, false, true);
                adjustBottomByAspectRatio(rectF, f8);
                return;
            case BOTTOM_RIGHT:
                if (calculateAspectRatio(rectF3.left, rectF3.top, f2, f7) < f8) {
                    adjustBottom(rectF, f3, rectF2, i3, f4, f5, false, true);
                    adjustRightByAspectRatio(rectF, f8);
                    return;
                }
                adjustRight(rectF, f2, rectF2, i2, f4, f5, false, true);
                adjustBottomByAspectRatio(rectF, f8);
                return;
            case LEFT:
                adjustLeft(rectF, f2, rectF2, f4, f5, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF4, f8);
                return;
            case TOP:
                adjustTop(rectF, f3, rectF2, f4, f5, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF4, f8);
                return;
            case RIGHT:
                adjustRight(rectF, f2, rectF2, i2, f4, f5, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF4, f8);
                return;
            case BOTTOM:
                adjustBottom(rectF, f3, rectF2, i3, f4, f5, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF4, f8);
                return;
            default:
                return;
        }
    }

    private void snapEdgesToBounds(RectF rectF, RectF rectF2, float f2) {
        if (rectF.left < rectF2.left + f2) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f2) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f2) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f2) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    private void adjustLeft(RectF rectF, float f2, RectF rectF2, float f3, float f4, boolean z, boolean z2) {
        if (f2 < 0.0f) {
            f2 /= 1.05f;
            this.mTouchOffset.x -= f2 / 1.1f;
        }
        if (f2 < rectF2.left) {
            this.mTouchOffset.x -= (f2 - rectF2.left) / 2.0f;
        }
        if (f2 - rectF2.left < f3) {
            f2 = rectF2.left;
        }
        if (rectF.right - f2 < this.mMinCropWidth) {
            f2 = rectF.right - this.mMinCropWidth;
        }
        if (rectF.right - f2 > this.mMaxCropWidth) {
            f2 = rectF.right - this.mMaxCropWidth;
        }
        if (f2 - rectF2.left < f3) {
            f2 = rectF2.left;
        }
        if (f4 > 0.0f) {
            float f5 = (rectF.right - f2) / f4;
            if (f5 < this.mMinCropHeight) {
                f2 = Math.max(rectF2.left, rectF.right - (this.mMinCropHeight * f4));
                f5 = (rectF.right - f2) / f4;
            }
            if (f5 > this.mMaxCropHeight) {
                f2 = Math.max(rectF2.left, rectF.right - (this.mMaxCropHeight * f4));
                f5 = (rectF.right - f2) / f4;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f5 < rectF2.top) {
                    f2 = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f4));
                    f5 = (rectF.right - f2) / f4;
                }
                if (z2 && rectF.top + f5 > rectF2.bottom) {
                    f2 = Math.max(f2, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f4)));
                }
            } else {
                f2 = Math.max(f2, Math.max(rectF2.left, rectF.right - (rectF2.height() * f4)));
            }
        }
        rectF.left = f2;
    }

    private void adjustRight(RectF rectF, float f2, RectF rectF2, int i2, float f3, float f4, boolean z, boolean z2) {
        float f5 = (float) i2;
        if (f2 > f5) {
            f2 = ((f2 - f5) / 1.05f) + f5;
            this.mTouchOffset.x -= (f2 - f5) / 1.1f;
        }
        if (f2 > rectF2.right) {
            this.mTouchOffset.x -= (f2 - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f2 < f3) {
            f2 = rectF2.right;
        }
        if (f2 - rectF.left < this.mMinCropWidth) {
            f2 = rectF.left + this.mMinCropWidth;
        }
        if (f2 - rectF.left > this.mMaxCropWidth) {
            f2 = rectF.left + this.mMaxCropWidth;
        }
        if (rectF2.right - f2 < f3) {
            f2 = rectF2.right;
        }
        if (f4 > 0.0f) {
            float f6 = (f2 - rectF.left) / f4;
            if (f6 < this.mMinCropHeight) {
                f2 = Math.min(rectF2.right, rectF.left + (this.mMinCropHeight * f4));
                f6 = (f2 - rectF.left) / f4;
            }
            if (f6 > this.mMaxCropHeight) {
                f2 = Math.min(rectF2.right, rectF.left + (this.mMaxCropHeight * f4));
                f6 = (f2 - rectF.left) / f4;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f6 < rectF2.top) {
                    f2 = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f4));
                    f6 = (f2 - rectF.left) / f4;
                }
                if (z2 && rectF.top + f6 > rectF2.bottom) {
                    f2 = Math.min(f2, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f4)));
                }
            } else {
                f2 = Math.min(f2, Math.min(rectF2.right, rectF.left + (rectF2.height() * f4)));
            }
        }
        rectF.right = f2;
    }

    private void adjustTop(RectF rectF, float f2, RectF rectF2, float f3, float f4, boolean z, boolean z2) {
        if (f2 < 0.0f) {
            f2 /= 1.05f;
            this.mTouchOffset.y -= f2 / 1.1f;
        }
        if (f2 < rectF2.top) {
            this.mTouchOffset.y -= (f2 - rectF2.top) / 2.0f;
        }
        if (f2 - rectF2.top < f3) {
            f2 = rectF2.top;
        }
        if (rectF.bottom - f2 < this.mMinCropHeight) {
            f2 = rectF.bottom - this.mMinCropHeight;
        }
        if (rectF.bottom - f2 > this.mMaxCropHeight) {
            f2 = rectF.bottom - this.mMaxCropHeight;
        }
        if (f2 - rectF2.top < f3) {
            f2 = rectF2.top;
        }
        if (f4 > 0.0f) {
            float f5 = (rectF.bottom - f2) * f4;
            if (f5 < this.mMinCropWidth) {
                f2 = Math.max(rectF2.top, rectF.bottom - (this.mMinCropWidth / f4));
                f5 = (rectF.bottom - f2) * f4;
            }
            if (f5 > this.mMaxCropWidth) {
                f2 = Math.max(rectF2.top, rectF.bottom - (this.mMaxCropWidth / f4));
                f5 = (rectF.bottom - f2) * f4;
            }
            if (!z || !z2) {
                if (z && rectF.right - f5 < rectF2.left) {
                    f2 = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f4));
                    f5 = (rectF.bottom - f2) * f4;
                }
                if (z2 && rectF.left + f5 > rectF2.right) {
                    f2 = Math.max(f2, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f4)));
                }
            } else {
                f2 = Math.max(f2, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f4)));
            }
        }
        rectF.top = f2;
    }

    private void adjustBottom(RectF rectF, float f2, RectF rectF2, int i2, float f3, float f4, boolean z, boolean z2) {
        float f5 = (float) i2;
        if (f2 > f5) {
            f2 = ((f2 - f5) / 1.05f) + f5;
            this.mTouchOffset.y -= (f2 - f5) / 1.1f;
        }
        if (f2 > rectF2.bottom) {
            this.mTouchOffset.y -= (f2 - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f2 < f3) {
            f2 = rectF2.bottom;
        }
        if (f2 - rectF.top < this.mMinCropHeight) {
            f2 = rectF.top + this.mMinCropHeight;
        }
        if (f2 - rectF.top > this.mMaxCropHeight) {
            f2 = rectF.top + this.mMaxCropHeight;
        }
        if (rectF2.bottom - f2 < f3) {
            f2 = rectF2.bottom;
        }
        if (f4 > 0.0f) {
            float f6 = (f2 - rectF.top) * f4;
            if (f6 < this.mMinCropWidth) {
                f2 = Math.min(rectF2.bottom, rectF.top + (this.mMinCropWidth / f4));
                f6 = (f2 - rectF.top) * f4;
            }
            if (f6 > this.mMaxCropWidth) {
                f2 = Math.min(rectF2.bottom, rectF.top + (this.mMaxCropWidth / f4));
                f6 = (f2 - rectF.top) * f4;
            }
            if (!z || !z2) {
                if (z && rectF.right - f6 < rectF2.left) {
                    f2 = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f4));
                    f6 = (f2 - rectF.top) * f4;
                }
                if (z2 && rectF.left + f6 > rectF2.right) {
                    f2 = Math.min(f2, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f4)));
                }
            } else {
                f2 = Math.min(f2, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f4)));
            }
        }
        rectF.bottom = f2;
    }

    private void adjustLeftByAspectRatio(RectF rectF, float f2) {
        rectF.left = rectF.right - (rectF.height() * f2);
    }

    private void adjustTopByAspectRatio(RectF rectF, float f2) {
        rectF.top = rectF.bottom - (rectF.width() / f2);
    }

    private void adjustRightByAspectRatio(RectF rectF, float f2) {
        rectF.right = rectF.left + (rectF.height() * f2);
    }

    private void adjustBottomByAspectRatio(RectF rectF, float f2) {
        rectF.bottom = rectF.top + (rectF.width() / f2);
    }

    private void adjustLeftRightByAspectRatio(RectF rectF, RectF rectF2, float f2) {
        rectF.inset((rectF.width() - (rectF.height() * f2)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    private void adjustTopBottomByAspectRatio(RectF rectF, RectF rectF2, float f2) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f2)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }
}
