package net.one97.paytm.paymentsBank.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.core.graphics.drawable.a;
import net.one97.paytm.paymentsBank.R;

public class FacilitiesView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f19623a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19624b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f19625c;

    /* renamed from: d  reason: collision with root package name */
    private String f19626d;

    /* renamed from: e  reason: collision with root package name */
    private float f19627e;

    /* renamed from: f  reason: collision with root package name */
    private String f19628f;

    /* renamed from: g  reason: collision with root package name */
    private float f19629g;

    /* renamed from: h  reason: collision with root package name */
    private int f19630h;

    public FacilitiesView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public FacilitiesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public FacilitiesView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public FacilitiesView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(AttributeSet attributeSet) {
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FacilitiesView);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FacilitiesView_layoutFile, 0);
            this.f19630h = obtainStyledAttributes.getResourceId(R.styleable.FacilitiesView_rightIcon, 0);
            int color = obtainStyledAttributes.getColor(R.styleable.FacilitiesView_circleColor, 0);
            float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_circleRadius, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.f19626d = obtainStyledAttributes.getString(R.styleable.FacilitiesView_title);
            this.f19627e = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_titleTextSize, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.f19628f = obtainStyledAttributes.getString(R.styleable.FacilitiesView_subtitle);
            this.f19629g = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_subTitleTextSize, (int) getResources().getDimension(R.dimen.dimen_0dp));
            float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_iconLeftMargin, (int) getResources().getDimension(R.dimen.dimen_0dp));
            float dimensionPixelSize3 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_iconTopMargin, (int) getResources().getDimension(R.dimen.dimen_0dp));
            float dimensionPixelSize4 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_iconHeight, (int) getResources().getDimension(R.dimen.dimen_0dp));
            float dimensionPixelSize5 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.FacilitiesView_iconWidth, (int) getResources().getDimension(R.dimen.dimen_0dp));
            int color2 = obtainStyledAttributes.getColor(R.styleable.FacilitiesView_titleColor, -1);
            int color3 = obtainStyledAttributes.getColor(R.styleable.FacilitiesView_subTitleColor, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == 0) {
                view = layoutInflater.inflate(R.layout.facilities_view_layout, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(resourceId, (ViewGroup) null);
            }
            this.f19625c = (ImageView) view.findViewById(R.id.imageView);
            ImageView imageView = (ImageView) view.findViewById(R.id.circularImageView);
            this.f19623a = (TextView) view.findViewById(R.id.facility_title);
            this.f19624b = (TextView) view.findViewById(R.id.facility_subtitle);
            setTitle(this.f19626d);
            setSubTitle(this.f19628f);
            if (color2 != -1) {
                setTitleColor(color2);
            }
            if (color3 != -1) {
                setSubTitleColor(color3);
            }
            if (!(imageView == null || color == 0)) {
                Drawable a2 = b.a(getContext(), R.drawable.pb_circular_facility_icon_bg);
                a.a(a2, color);
                imageView.setImageDrawable(a2);
                if (dimensionPixelSize != 0.0f) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = (int) dimensionPixelSize;
                    layoutParams.width = layoutParams.height;
                    imageView.setLayoutParams(layoutParams);
                }
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.imageLayout);
            if (!(viewGroup == null || dimensionPixelSize == 0.0f)) {
                ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                layoutParams2.height = (int) dimensionPixelSize;
                layoutParams2.width = layoutParams2.height;
                viewGroup.setLayoutParams(layoutParams2);
            }
            ImageView imageView2 = this.f19625c;
            if (imageView2 != null) {
                int i2 = this.f19630h;
                if (i2 != 0) {
                    imageView2.setImageResource(i2);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19625c.getLayoutParams();
                if (dimensionPixelSize2 != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.leftMargin = (int) dimensionPixelSize2;
                }
                if (dimensionPixelSize3 != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.topMargin = (int) dimensionPixelSize3;
                }
                if (dimensionPixelSize5 != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.width = (int) dimensionPixelSize5;
                }
                if (dimensionPixelSize4 != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.height = (int) dimensionPixelSize4;
                }
                this.f19625c.setLayoutParams(marginLayoutParams);
            }
            removeAllViews();
            addView(view);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setTitle(String str) {
        this.f19626d = str;
        TextView textView = this.f19623a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSubTitle(String str) {
        this.f19628f = str;
        if (this.f19624b == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f19624b.setVisibility(8);
            return;
        }
        this.f19624b.setVisibility(0);
        this.f19624b.setText(str);
    }

    public void setIcon(int i2) {
        this.f19630h = i2;
        ImageView imageView = this.f19625c;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public void setTitleSize(float f2) {
        TextView textView;
        if (f2 != 0.0f && (textView = this.f19623a) != null) {
            textView.setTextSize(0, f2);
            this.f19627e = f2;
        }
    }

    public void setSubTitleTextSize(float f2) {
        TextView textView;
        if (f2 != 0.0f && (textView = this.f19624b) != null) {
            textView.setTextSize(0, f2);
            this.f19629g = f2;
        }
    }

    public void setTitleColor(int i2) {
        TextView textView = this.f19623a;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setSubTitleColor(int i2) {
        TextView textView = this.f19624b;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }
}
