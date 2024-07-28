package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import net.one97.paytm.common.widgets.R;

public class ExpandableLayout extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Boolean f59204a = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Boolean f59205b = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f59206c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f59207d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f59208e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f59209f;

    public ExpandableLayout(Context context) {
        super(context);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public void setAnimationRunning(boolean z) {
        this.f59204a = Boolean.valueOf(z);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, R.layout.view_expandable, this);
        this.f59208e = (FrameLayout) inflate.findViewById(R.id.view_expandable_headerlayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ExpandableLayout_el_headerLayout, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableLayout_el_contentLayout, -1);
        this.f59207d = (FrameLayout) inflate.findViewById(R.id.view_expandable_contentLayout);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        } else if (!isInEditMode()) {
            this.f59206c = Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.ExpandableLayout_el_duration, getContext().getResources().getInteger(17694720)));
            View inflate2 = View.inflate(context, resourceId, (ViewGroup) null);
            inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f59208e.addView(inflate2);
            View inflate3 = View.inflate(context, resourceId2, (ViewGroup) null);
            inflate3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f59207d.addView(inflate3);
            this.f59207d.setVisibility(8);
            this.f59208e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!ExpandableLayout.this.f59204a.booleanValue()) {
                        if (ExpandableLayout.this.f59207d.getVisibility() == 0) {
                            ExpandableLayout expandableLayout = ExpandableLayout.this;
                            ExpandableLayout.a(expandableLayout, (View) expandableLayout.f59207d);
                        } else {
                            ExpandableLayout expandableLayout2 = ExpandableLayout.this;
                            ExpandableLayout.b(expandableLayout2, (View) expandableLayout2.f59207d);
                        }
                        Boolean unused = ExpandableLayout.this.f59204a = Boolean.TRUE;
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                Boolean unused = ExpandableLayout.this.f59204a = Boolean.FALSE;
                            }
                        }, (long) ExpandableLayout.this.f59206c.intValue());
                    }
                }
            });
            obtainStyledAttributes.recycle();
        }
    }

    public FrameLayout getHeaderLayout() {
        return this.f59208e;
    }

    public FrameLayout getContentLayout() {
        return this.f59207d;
    }

    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        this.f59209f.setAnimationListener(animationListener);
    }

    static /* synthetic */ void a(ExpandableLayout expandableLayout, final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        expandableLayout.f59209f = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                if (f2 == 1.0f) {
                    view.setVisibility(8);
                    Boolean unused = ExpandableLayout.this.f59205b = Boolean.FALSE;
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredHeight;
                layoutParams.height = i2 - ((int) (((float) i2) * f2));
                view.requestLayout();
            }
        };
        expandableLayout.f59209f.setDuration((long) expandableLayout.f59206c.intValue());
        view.startAnimation(expandableLayout.f59209f);
    }

    static /* synthetic */ void b(ExpandableLayout expandableLayout, final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        expandableLayout.f59209f = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i2 == 0) {
                    Boolean unused = ExpandableLayout.this.f59205b = Boolean.TRUE;
                }
                view.getLayoutParams().height = i2 == 0 ? -2 : (int) (((float) measuredHeight) * f2);
                view.requestLayout();
            }
        };
        expandableLayout.f59209f.setDuration((long) expandableLayout.f59206c.intValue());
        view.startAnimation(expandableLayout.f59209f);
    }
}
