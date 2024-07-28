package net.one97.paytm.oauth.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.c;
import androidx.core.content.b;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.h;

public final class ProgressViewButton extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56843a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f56844b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f56845c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56846d;

    public ProgressViewButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public ProgressViewButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    private View a(int i2) {
        if (this.f56846d == null) {
            this.f56846d = new HashMap();
        }
        View view = (View) this.f56846d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f56846d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressViewButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f56844b = true;
        View a2 = h.a(this, R.layout.layout_progress_button);
        a2.setId(View.generateViewId());
        c cVar = new c();
        addView(a2);
        cVar.b((ConstraintLayout) this);
        h.a(cVar, a2, this);
        setUpUi(attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressViewButton(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void setProgressShowing(boolean z) {
        this.f56843a = z;
    }

    private final void setUpUi(AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View a2;
        View a3;
        View a4;
        RoboTextView roboTextView;
        AppCompatImageView appCompatImageView;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ProgressViewButton);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ProgressViewButton_btnImage);
            String string = obtainStyledAttributes.getString(R.styleable.ProgressViewButton_btnText);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ProgressViewButton_btnBg);
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ProgressViewButton_progressBg);
            int i2 = 0;
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressViewButton_btnHeight, 0);
            this.f56844b = obtainStyledAttributes.getBoolean(R.styleable.ProgressViewButton_showImage, true);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imgLeft);
            if (appCompatImageView2 != null) {
                if (!this.f56844b) {
                    i2 = 8;
                }
                appCompatImageView2.setVisibility(i2);
            }
            if (!(drawable == null || (appCompatImageView = (AppCompatImageView) a(R.id.imgLeft)) == null)) {
                appCompatImageView.setImageDrawable(drawable);
            }
            if (!(string == null || (roboTextView = (RoboTextView) a(R.id.lblProceed)) == null)) {
                roboTextView.setText(string);
            }
            if (!(drawable2 == null || (a4 = a(R.id.viewProceedClick)) == null)) {
                a4.setBackground(drawable2);
            }
            if (!(drawable3 == null || (a3 = a(R.id.progressBgView)) == null)) {
                a3.setBackground(drawable3);
            }
            if (!(drawable3 == null || (a2 = a(R.id.progressBgView)) == null)) {
                a2.setBackground(drawable3);
            }
            if (dimensionPixelSize != 0) {
                View a5 = a(R.id.viewProceedClick);
                if (!(a5 == null || (layoutParams2 = a5.getLayoutParams()) == null)) {
                    layoutParams2.height = dimensionPixelSize;
                }
                View a6 = a(R.id.viewProceedClick);
                if (a6 != null) {
                    a6.requestLayout();
                }
                View a7 = a(R.id.progressBgView);
                if (!(a7 == null || (layoutParams = a7.getLayoutParams()) == null)) {
                    layoutParams.height = dimensionPixelSize;
                }
                View a8 = a(R.id.progressBgView);
                if (a8 != null) {
                    a8.requestLayout();
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void setButtonText(String str) {
        if (str != null) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.lblProceed);
            k.a((Object) roboTextView, "lblProceed");
            roboTextView.setText(str);
        }
    }

    public final void a() {
        View a2 = a(R.id.viewProceedClick);
        if (a2 != null) {
            a2.setBackgroundColor(b.c(getContext(), R.color.color_5fc5eb));
        }
    }

    public final void b() {
        View a2 = a(R.id.viewProceedClick);
        if (a2 != null) {
            a2.setBackgroundResource(R.drawable.selector_blue_btn);
        }
    }

    public final void c() {
        Group group = (Group) a(R.id.proceedClickGroup);
        k.a((Object) group, "proceedClickGroup");
        group.setVisibility(8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgLeft);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        Group group2 = (Group) a(R.id.progressGroup);
        k.a((Object) group2, "progressGroup");
        group2.setVisibility(0);
        OAuthUtils.a((LottieAnimationView) a(R.id.loader));
        this.f56843a = true;
    }

    public final void d() {
        Group group = (Group) a(R.id.progressGroup);
        k.a((Object) group, "progressGroup");
        int i2 = 8;
        group.setVisibility(8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgLeft);
        if (appCompatImageView != null) {
            if (this.f56844b) {
                i2 = 0;
            }
            appCompatImageView.setVisibility(i2);
        }
        Group group2 = (Group) a(R.id.proceedClickGroup);
        k.a((Object) group2, "proceedClickGroup");
        group2.setVisibility(0);
        OAuthUtils.b((LottieAnimationView) a(R.id.loader));
        this.f56843a = false;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f56845c = onClickListener;
        super.setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressViewButton f56847a;

        a(ProgressViewButton progressViewButton) {
            this.f56847a = progressViewButton;
        }

        public final void onClick(View view) {
            View.OnClickListener a2;
            if (!this.f56847a.f56843a && (a2 = this.f56847a.f56845c) != null) {
                a2.onClick(view);
            }
        }
    }
}
