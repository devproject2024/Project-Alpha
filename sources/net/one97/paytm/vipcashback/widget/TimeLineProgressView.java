package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.TransactionsInfo;
import net.one97.paytm.vipcashback.R;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class TimeLineProgressView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup.LayoutParams f21055a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup.LayoutParams f21056b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransactionsInfo> f21057c;

    /* renamed from: d  reason: collision with root package name */
    private int f21058d;

    /* renamed from: e  reason: collision with root package name */
    private int f21059e;

    /* renamed from: f  reason: collision with root package name */
    private int f21060f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21061g;

    public final ViewGroup.LayoutParams getLineLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.f21055a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        return layoutParams;
    }

    public final void setLineLayoutParams(ViewGroup.LayoutParams layoutParams) {
        k.c(layoutParams, "<set-?>");
        this.f21055a = layoutParams;
    }

    public final ViewGroup.LayoutParams getIconLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.f21056b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        return layoutParams;
    }

    public final void setIconLayoutParams(ViewGroup.LayoutParams layoutParams) {
        k.c(layoutParams, "<set-?>");
        this.f21056b = layoutParams;
    }

    public final int getTotalTxnCount() {
        return this.f21058d;
    }

    public final void setTotalTxnCount(int i2) {
        this.f21058d = i2;
    }

    public final int getStageTxnCount() {
        return this.f21059e;
    }

    public final void setStageTxnCount(int i2) {
        this.f21059e = i2;
    }

    public final int getMaxIconToBeShowed() {
        return this.f21060f;
    }

    public final void setMaxIconToBeShowed(int i2) {
        this.f21060f = i2;
    }

    public final void setInitialized(boolean z) {
        this.f21061g = z;
    }

    public final ArrayList<TransactionsInfo> getInfo() {
        return this.f21057c;
    }

    public final void setInfo(ArrayList<TransactionsInfo> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f21057c = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeLineProgressView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeLineProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeLineProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f21060f = 6;
        this.f21057c = new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (!this.f21061g) {
            this.f21061g = true;
            super.onMeasure(i2, i3);
            int measuredWidth = getMeasuredWidth() / ((this.f21060f * 2) + 3);
            double d2 = (double) measuredWidth;
            int i6 = (int) (d2 + (0.1d * d2));
            Context context = getContext();
            k.a((Object) context, "context");
            this.f21055a = new LinearLayout.LayoutParams(measuredWidth, context.getResources().getDimensionPixelSize(R.dimen.dimen_3dp));
            this.f21056b = new LinearLayout.LayoutParams(i6, i6);
            setTimeLine(this.f21057c);
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

    public final void setTimeLine(ArrayList<TransactionsInfo> arrayList) {
        k.c(arrayList, "info");
        removeAllViews();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = this.f21060f;
            if (i3 >= i4) {
                if (i3 == i4) {
                    arrayList.size();
                    a(i3, "");
                }
                i2++;
            } else if (arrayList.get(i3).isStageCompleted()) {
                if (arrayList.get(i3).isSuccessful()) {
                    arrayList.size();
                    a(i3, "green");
                    addView(getCompleteIcon());
                } else {
                    arrayList.size();
                    a(i3, "");
                    addView(getGiftGreyIcon());
                }
            } else if (arrayList.get(i3).isSuccessful()) {
                arrayList.size();
                a(i3, "green");
                addView(getSuccessIcon());
            } else {
                arrayList.size();
                a(i3, "");
                addView(getGreyIcon());
            }
        }
        if (this.f21060f < arrayList.size()) {
            TextView textView = new TextView(getContext());
            textView.setText(getContext().getString(R.string.txns_remaining, new Object[]{String.valueOf(i2)}));
            textView.setTextSize(2, 11.0f);
            textView.setTextColor(b.c(getContext(), R.color.light_blue));
            Context context = getContext();
            k.a((Object) context, "context");
            textView.setPadding(0, 0, context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_4dp), 0);
            textView.setSingleLine();
            textView.setGravity(16);
            textView.setTextAlignment(3);
            textView.setBackground(b.a(getContext(), R.drawable.more_circle));
            addView(textView);
        }
    }

    public final View getSuccessIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21056b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.ic_tick_timeline);
        return appCompatImageView;
    }

    public final View getCompleteIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21056b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.ic_gift);
        return appCompatImageView;
    }

    public final View getGiftGreyIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21056b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.ic_gift_grey);
        return appCompatImageView;
    }

    public final View getGreyIcon() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21056b;
        if (layoutParams == null) {
            k.a("iconLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.new_circle);
        return appCompatImageView;
    }

    public final View getGreyLine() {
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21055a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        view.setLayoutParams(layoutParams);
        view.setBackground(b.a(getContext(), R.drawable.new_grey_line));
        return view;
    }

    public final View getGreenLine() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        ViewGroup.LayoutParams layoutParams = this.f21055a;
        if (layoutParams == null) {
            k.a("lineLayoutParams");
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setImageResource(R.drawable.shape_cashback_timeline_green);
        return appCompatImageView;
    }

    private void a(int i2, String str) {
        k.c(str, CLConstants.FIELD_FONT_COLOR);
        if (i2 == 0) {
            return;
        }
        if (str.equals("green")) {
            addView(getGreenLine());
        } else {
            addView(getGreyLine());
        }
    }
}
