package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import kotlin.g.b.k;
import net.one97.paytm.common.assets.R;

public final class NewHorizontalProgressTimelineView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f21049a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout.LayoutParams f21050b;

    /* renamed from: c  reason: collision with root package name */
    private int f21051c;

    /* renamed from: d  reason: collision with root package name */
    private int f21052d;

    /* renamed from: e  reason: collision with root package name */
    private int f21053e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21054f;

    public final LinearLayout.LayoutParams getLineLayoutParams() {
        LinearLayout.LayoutParams layoutParams = this.f21049a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        return layoutParams;
    }

    public final void setLineLayoutParams(LinearLayout.LayoutParams layoutParams) {
        k.c(layoutParams, "<set-?>");
        this.f21049a = layoutParams;
    }

    public final LinearLayout.LayoutParams getIconLayoutParams() {
        LinearLayout.LayoutParams layoutParams = this.f21050b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        return layoutParams;
    }

    public final void setIconLayoutParams(LinearLayout.LayoutParams layoutParams) {
        k.c(layoutParams, "<set-?>");
        this.f21050b = layoutParams;
    }

    public final int getTotalTxnCount() {
        return this.f21051c;
    }

    public final void setTotalTxnCount(int i2) {
        this.f21051c = i2;
    }

    public final int getSuccessTxnCount() {
        return this.f21052d;
    }

    public final void setSuccessTxnCount(int i2) {
        this.f21052d = i2;
    }

    public final int getMaxIconToBeShowed() {
        return this.f21053e;
    }

    public final void setMaxIconToBeShowed(int i2) {
        this.f21053e = i2;
    }

    public final void setInitialized(boolean z) {
        this.f21054f = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHorizontalProgressTimelineView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHorizontalProgressTimelineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewHorizontalProgressTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (!this.f21054f) {
            this.f21054f = true;
            super.onMeasure(i2, i3);
            int measuredWidth = getMeasuredWidth() / ((this.f21053e * 2) + 3);
            double d2 = (double) measuredWidth;
            int i6 = (int) (d2 + (0.1d * d2));
            Context context = getContext();
            k.a((Object) context, "context");
            this.f21049a = new LinearLayout.LayoutParams(measuredWidth, context.getResources().getDimensionPixelSize(R.dimen.dimen_3dp));
            LinearLayout.LayoutParams layoutParams = this.f21049a;
            if (layoutParams == null) {
                k.a("lineLayoutParams");
            }
            layoutParams.gravity = 16;
            this.f21050b = new LinearLayout.LayoutParams(i6, i6);
            setTimelineProgress(this.f21051c, this.f21052d, this.f21053e);
            return;
        }
        int childCount = getChildCount() - 1;
        int i7 = 0;
        if (childCount >= 0) {
            int i8 = 0;
            int i9 = 0;
            i4 = 0;
            while (true) {
                View childAt = getChildAt(i8);
                if (childAt != null) {
                    if (!(childAt instanceof TextView)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childAt.getLayoutParams().width), 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                        i5 = childAt.getLayoutParams().width;
                    } else {
                        TextView textView = (TextView) childAt;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(textView.getLayoutParams().width), 0), View.MeasureSpec.makeMeasureSpec(textView.getLayoutParams().height, 0));
                        i5 = textView.getMeasuredWidth();
                    }
                    i9 += i5;
                    if (i4 < childAt.getLayoutParams().height) {
                        i4 = childAt.getLayoutParams().height;
                    }
                }
                if (i8 == childCount) {
                    break;
                }
                i8++;
            }
            i7 = i9;
        } else {
            i4 = 0;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }

    public final void setTimelineProgress(int i2, int i3, int i4) {
        removeAllViews();
        int i5 = i3 >= i4 ? i4 : i3;
        int i6 = i4 < i3 ? 0 : (i3 <= i4 && i2 >= i4) ? i4 - i3 : i2 - i3;
        boolean z = false;
        if (i5 > 0) {
            int i7 = 1;
            while (true) {
                if (!z) {
                    z = true;
                } else {
                    addView(getGreenLine());
                }
                addView(getGreenIcon());
                if (i7 == i5) {
                    break;
                }
                i7++;
            }
        }
        if (i6 > 0) {
            int i8 = 1;
            while (true) {
                if (!z) {
                    addView(getGreyIcon());
                    z = true;
                } else {
                    addView(getGreyLine());
                    addView(getGreyIcon());
                }
                if (i8 == i6) {
                    break;
                }
                i8++;
            }
        }
        if (i2 > i4) {
            addView(getGreyLine());
            TextView textView = new TextView(getContext());
            textView.setText(getContext().getString(net.one97.paytm.vipcashback.R.string.post_txn_remaining_time, new Object[]{Integer.valueOf(i2 - i4)}));
            textView.setTextSize(2, 10.0f);
            textView.setTextColor(b.c(getContext(), R.color.color_666666));
            Context context = getContext();
            k.a((Object) context, "context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.dimen_4dp);
            int i9 = dimensionPixelSize * 2;
            int i10 = dimensionPixelSize / 2;
            textView.setPadding(i9, i10, i9, i10);
            textView.setSingleLine();
            textView.setBackground(b.a(getContext(), net.one97.paytm.vipcashback.R.drawable.shape_solid_bg_grey));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            addView(textView, layoutParams);
        }
        invalidate();
    }

    public final View getGreenIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        LinearLayout.LayoutParams layoutParams = this.f21050b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.cash_back);
        return appCompatImageView;
    }

    public final View getGreyIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        LinearLayout.LayoutParams layoutParams = this.f21050b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(net.one97.paytm.vipcashback.R.drawable.ic_cashback_timelinne_idle);
        return appCompatImageView;
    }

    public final View getGreenLine() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        LinearLayout.LayoutParams layoutParams = this.f21049a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(net.one97.paytm.vipcashback.R.drawable.shape_cashback_timeline_green);
        return appCompatImageView;
    }

    public final View getGreyLine() {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = this.f21049a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        view.setLayoutParams(layoutParams);
        view.setBackground(b.a(getContext(), net.one97.paytm.vipcashback.R.drawable.shape_cashback_timeline_grey));
        return view;
    }

    public static /* synthetic */ void a(NewHorizontalProgressTimelineView newHorizontalProgressTimelineView, int i2, int i3) {
        newHorizontalProgressTimelineView.f21051c = i3;
        newHorizontalProgressTimelineView.f21052d = i2;
        newHorizontalProgressTimelineView.f21053e = 6;
        newHorizontalProgressTimelineView.f21054f = false;
        newHorizontalProgressTimelineView.requestLayout();
    }
}
