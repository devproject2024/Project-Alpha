package com.alipay.mobile.nebula.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.mobile.framework.loading.LoadingView;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import java.util.Map;

public class H5WebLoadingView extends LoadingView {
    private ImageButton mBackButton;
    private Context mContext;
    ValueAnimator mDarkAnim;
    private int mDarkColor;
    /* access modifiers changed from: private */
    public int mDarkDotX;
    private int mDarkDotY;
    private View mDivider;
    private Paint mDotPaint;
    private int mDotSize;
    private boolean mIsAnimating;
    private int mLightColor;
    /* access modifiers changed from: private */
    public int mLightDotX;
    private ImageView mLoadingIcon;
    private TextView mLoadingTitle;

    public void onHandleMessage(String str, Map<String, Object> map) {
    }

    public void onStop() {
    }

    public H5WebLoadingView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public void onStart() {
        startLoadingAnimation();
    }

    public void initView() {
        this.mLoadingIcon = new ImageView(this.mContext);
        this.mLoadingIcon.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mLoadingIcon.setImageResource(R.drawable.h5_default_loading_icon);
        this.mLoadingTitle = new TextView(this.mContext);
        this.mLoadingTitle.setGravity(17);
        this.mLoadingTitle.setTextColor(this.mContext.getResources().getColor(R.color.h5_web_loading_text));
        this.mLoadingTitle.setSingleLine();
        this.mLoadingTitle.setTextSize(14.0f);
        this.mLoadingTitle.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.mLoadingIcon);
        addView(this.mLoadingTitle);
        this.mBackButton = new ImageButton(this.mContext);
        this.mBackButton.setBackgroundColor(0);
        this.mBackButton.setImageResource(R.drawable.h5_title_bar_back_btn_selector);
        this.mBackButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mDivider = new View(this.mContext);
        this.mDivider.setBackgroundColor(-2500135);
        addView(this.mBackButton);
        addView(this.mDivider);
        this.mDarkColor = this.mContext.getResources().getColor(R.color.h5_web_loading_dot_dark);
        this.mLightColor = this.mContext.getResources().getColor(R.color.h5_web_loading_dot_light);
        this.mDotSize = getDimen(R.dimen.h5_loading_dot_size);
        this.mDotPaint = new Paint();
        this.mDotPaint.setStyle(Paint.Style.FILL);
        setBackgroundColor(this.mContext.getResources().getColor(R.color.h5_web_loading_default_bg));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int screenWidth = H5DimensionUtil.getScreenWidth(this.mContext) / 5;
        this.mLoadingIcon.measure(makeMeasureSpec(screenWidth), makeMeasureSpec(screenWidth));
        this.mLoadingTitle.measure(makeMeasureSpec(getDimen(R.dimen.h5_loading_title_width)), makeMeasureSpec(getDimen(R.dimen.h5_loading_title_height)));
        this.mBackButton.measure(makeMeasureSpec(getDimen(R.dimen.h5_loading_back_button_width)), makeMeasureSpec(getDimen(R.dimen.h5_title_height)));
        this.mDivider.measure(makeMeasureSpec(getDimen(R.dimen.h5_loading_divider_width)), makeMeasureSpec(getDimen(R.dimen.h5_loading_divider_height)));
        setMeasuredDimension(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ImageButton imageButton = this.mBackButton;
        imageButton.layout(0, 0, imageButton.getMeasuredWidth(), this.mBackButton.getMeasuredHeight());
        int measuredWidth = this.mBackButton.getMeasuredWidth();
        int dimen = (getDimen(R.dimen.h5_title_height) - this.mDivider.getMeasuredHeight()) / 2;
        View view = this.mDivider;
        view.layout(measuredWidth, dimen, view.getMeasuredWidth() + measuredWidth, this.mDivider.getMeasuredHeight() + dimen);
        int measuredWidth2 = (getMeasuredWidth() - this.mLoadingIcon.getMeasuredWidth()) / 2;
        int measuredHeight = getMeasuredHeight() / 4;
        ImageView imageView = this.mLoadingIcon;
        imageView.layout(measuredWidth2, measuredHeight, imageView.getMeasuredWidth() + measuredWidth2, this.mLoadingIcon.getMeasuredHeight() + measuredHeight);
        int measuredWidth3 = (getMeasuredWidth() - this.mLoadingTitle.getMeasuredWidth()) / 2;
        int measuredHeight2 = measuredHeight + this.mLoadingIcon.getMeasuredHeight() + getDimen(R.dimen.h5_loading_title_margin_top);
        TextView textView = this.mLoadingTitle;
        textView.layout(measuredWidth3, measuredHeight2, textView.getMeasuredWidth() + measuredWidth3, this.mLoadingTitle.getMeasuredHeight() + measuredHeight2);
        this.mDarkDotY = measuredHeight2 + this.mLoadingTitle.getMeasuredHeight() + getDimen(R.dimen.h5_loading_dot_margin_top);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mIsAnimating) {
            this.mDotPaint.setColor(this.mDarkColor);
            canvas.drawCircle((float) this.mDarkDotX, (float) this.mDarkDotY, (float) (this.mDotSize / 2), this.mDotPaint);
            this.mDotPaint.setColor(this.mLightColor);
            canvas.drawCircle((float) this.mLightDotX, (float) this.mDarkDotY, (float) (this.mDotSize / 2), this.mDotPaint);
        }
    }

    public void setLoadingInfo(String str, String str2, String str3) {
        this.mLoadingTitle.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            setBackgroundColor(Color.parseColor(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            this.mLoadingTitle.setTextColor(Color.parseColor(str3));
        }
    }

    public void setLoadingBitmap(Bitmap bitmap) {
        this.mLoadingIcon.setImageBitmap(bitmap);
    }

    public void startLoadingAnimation() {
        if (!this.mIsAnimating) {
            final int screenWidth = H5DimensionUtil.getScreenWidth(this.mContext) / 2;
            int dimen = getDimen(R.dimen.h5_loading_dot_margin_center);
            int i2 = this.mDotSize;
            this.mIsAnimating = true;
            this.mDarkAnim = ValueAnimator.ofInt(new int[]{(screenWidth - (i2 / 2)) - dimen, dimen + screenWidth + (i2 / 2)});
            this.mDarkAnim.setDuration(400);
            this.mDarkAnim.setRepeatCount(90);
            this.mDarkAnim.setRepeatMode(2);
            this.mDarkAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = H5WebLoadingView.this.mDarkDotX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int access$000 = H5WebLoadingView.this.mDarkDotX;
                    int i2 = screenWidth;
                    if (access$000 < i2) {
                        H5WebLoadingView h5WebLoadingView = H5WebLoadingView.this;
                        int unused2 = h5WebLoadingView.mLightDotX = (i2 + i2) - h5WebLoadingView.mDarkDotX;
                    } else {
                        H5WebLoadingView h5WebLoadingView2 = H5WebLoadingView.this;
                        int unused3 = h5WebLoadingView2.mLightDotX = i2 - (h5WebLoadingView2.mDarkDotX - screenWidth);
                    }
                    H5WebLoadingView.this.invalidate();
                }
            });
            this.mDarkAnim.start();
        }
    }

    public void stopLoadingAnimation() {
        this.mIsAnimating = false;
        ValueAnimator valueAnimator = this.mDarkAnim;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mDarkAnim.removeAllUpdateListeners();
            this.mDarkAnim = null;
        }
    }

    public ImageButton getBackButton() {
        return this.mBackButton;
    }

    private int getDimen(int i2) {
        return this.mContext.getResources().getDimensionPixelSize(i2);
    }

    private static int makeMeasureSpec(int i2) {
        return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }
}
