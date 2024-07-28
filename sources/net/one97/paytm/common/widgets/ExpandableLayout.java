package net.one97.paytm.common.widgets;

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

public class ExpandableLayout extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Boolean f49837a = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Boolean f49838b = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f49839c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f49840d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f49841e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f49842f;

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
        this.f49837a = Boolean.valueOf(z);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, R.layout.view_expandable, this);
        this.f49841e = (FrameLayout) inflate.findViewById(R.id.view_expandable_headerlayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ExpandableLayout_el_headerLayout, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableLayout_el_contentLayout, -1);
        this.f49840d = (FrameLayout) inflate.findViewById(R.id.view_expandable_contentLayout);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        } else if (!isInEditMode()) {
            this.f49839c = Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.ExpandableLayout_el_duration, getContext().getResources().getInteger(17694720)));
            View inflate2 = View.inflate(context, resourceId, (ViewGroup) null);
            inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f49841e.addView(inflate2);
            View inflate3 = View.inflate(context, resourceId2, (ViewGroup) null);
            inflate3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f49840d.addView(inflate3);
            this.f49840d.setVisibility(8);
            this.f49841e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!ExpandableLayout.this.f49837a.booleanValue()) {
                        if (ExpandableLayout.this.f49840d.getVisibility() == 0) {
                            ExpandableLayout expandableLayout = ExpandableLayout.this;
                            ExpandableLayout.a(expandableLayout, (View) expandableLayout.f49840d);
                        } else {
                            ExpandableLayout expandableLayout2 = ExpandableLayout.this;
                            ExpandableLayout.b(expandableLayout2, (View) expandableLayout2.f49840d);
                        }
                        Boolean unused = ExpandableLayout.this.f49837a = Boolean.TRUE;
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                Boolean unused = ExpandableLayout.this.f49837a = Boolean.FALSE;
                            }
                        }, (long) ExpandableLayout.this.f49839c.intValue());
                    }
                }
            });
            obtainStyledAttributes.recycle();
        }
    }

    public FrameLayout getHeaderLayout() {
        return this.f49841e;
    }

    public FrameLayout getContentLayout() {
        return this.f49840d;
    }

    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        this.f49842f.setAnimationListener(animationListener);
    }

    static /* synthetic */ void a(ExpandableLayout expandableLayout, final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        expandableLayout.f49842f = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                if (f2 == 1.0f) {
                    view.setVisibility(8);
                    Boolean unused = ExpandableLayout.this.f49838b = Boolean.FALSE;
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredHeight;
                layoutParams.height = i2 - ((int) (((float) i2) * f2));
                view.requestLayout();
            }
        };
        expandableLayout.f49842f.setDuration((long) expandableLayout.f49839c.intValue());
        view.startAnimation(expandableLayout.f49842f);
    }

    static /* synthetic */ void b(ExpandableLayout expandableLayout, final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        expandableLayout.f49842f = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i2 == 0) {
                    Boolean unused = ExpandableLayout.this.f49838b = Boolean.TRUE;
                }
                view.getLayoutParams().height = i2 == 0 ? -2 : (int) (((float) measuredHeight) * f2);
                view.requestLayout();
            }
        };
        expandableLayout.f49842f.setDuration((long) expandableLayout.f49839c.intValue());
        view.startAnimation(expandableLayout.f49842f);
    }
}
