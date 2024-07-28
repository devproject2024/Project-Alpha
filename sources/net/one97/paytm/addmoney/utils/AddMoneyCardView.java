package net.one97.paytm.addmoney.utils;

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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.core.graphics.drawable.a;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.addmoney.R;

public class AddMoneyCardView extends LinearLayout {
    private LinearLayout A;
    private LottieAnimationView B;
    private LottieAnimationView C;
    private RelativeLayout D;
    private RadioButton E;

    /* renamed from: a  reason: collision with root package name */
    protected TextView f48894a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f48895b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f48896c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f48897d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f48898e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f48899f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f48900g;

    /* renamed from: h  reason: collision with root package name */
    protected ImageView f48901h;

    /* renamed from: i  reason: collision with root package name */
    public View f48902i;
    private LayoutInflater j;
    private int k;
    private int l;
    private float m;
    private String n;
    private float o;
    private String p;
    private float q;
    private int r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private int x;
    private ImageView y;
    private ImageView z;

    public AddMoneyCardView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public AddMoneyCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public AddMoneyCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public AddMoneyCardView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(AttributeSet attributeSet) {
        View view;
        this.j = (LayoutInflater) getContext().getSystemService("layout_inflater");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AddMoneyCardView);
        try {
            this.k = obtainStyledAttributes.getResourceId(R.styleable.AddMoneyCardView_layoutFile, 0);
            this.r = obtainStyledAttributes.getResourceId(R.styleable.AddMoneyCardView_leftIcon, 0);
            this.l = obtainStyledAttributes.getColor(R.styleable.AddMoneyCardView_circleColor, 0);
            this.m = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_circleRadius, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.n = obtainStyledAttributes.getString(R.styleable.AddMoneyCardView_title);
            this.o = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_titleTextSize, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.p = obtainStyledAttributes.getString(R.styleable.AddMoneyCardView_subtitle);
            this.q = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_subTitleTextSize, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.s = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_iconLeftMargin, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.t = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_iconTopMargin, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.v = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_iconHeight, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.u = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddMoneyCardView_iconWidth, (int) getResources().getDimension(R.dimen.dimen_0dp));
            this.w = obtainStyledAttributes.getColor(R.styleable.AddMoneyCardView_titleColor, -1);
            this.x = obtainStyledAttributes.getColor(R.styleable.AddMoneyCardView_subTitleColor, -1);
            obtainStyledAttributes.recycle();
            int i2 = this.k;
            if (i2 == 0) {
                view = this.j.inflate(R.layout.uam_card_view, (ViewGroup) null);
            } else {
                view = this.j.inflate(i2, (ViewGroup) null);
            }
            this.E = (RadioButton) view.findViewById(R.id.rb_select);
            this.f48901h = (ImageView) view.findViewById(R.id.icon);
            this.f48894a = (TextView) view.findViewById(R.id.title);
            this.f48895b = (TextView) view.findViewById(R.id.subTitle);
            this.f48897d = (TextView) view.findViewById(R.id.actionKnowMore);
            this.y = (ImageView) view.findViewById(R.id.circularImageView);
            this.z = (ImageView) view.findViewById(R.id.iv_info);
            this.B = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
            this.f48899f = (TextView) view.findViewById(R.id.description);
            this.f48898e = (TextView) view.findViewById(R.id.viewBalanceButton);
            this.C = (LottieAnimationView) view.findViewById(R.id.lav_progress);
            this.f48900g = (TextView) view.findViewById(R.id.tv_fee_title);
            this.A = (LinearLayout) view.findViewById(R.id.item_open_container);
            this.D = (RelativeLayout) view.findViewById(R.id.rl_content);
            this.f48902i = view.findViewById(R.id.v_divider);
            this.f48896c = (TextView) view.findViewById(R.id.tv_ppb_account_status);
            setTitle(this.n);
            setSubTitle(this.p);
            int i3 = this.w;
            if (i3 != -1) {
                setTitleColor(i3);
            }
            int i4 = this.x;
            if (i4 != -1) {
                setSubTitleColor(i4);
            }
            if (!(this.y == null || this.l == 0)) {
                Drawable a2 = b.a(getContext(), R.drawable.circular_facility_icon_bg_addmoney);
                a.a(a2, this.l);
                this.y.setImageDrawable(a2);
                if (this.m != 0.0f) {
                    ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
                    layoutParams.height = (int) this.m;
                    layoutParams.width = layoutParams.height;
                    this.y.setLayoutParams(layoutParams);
                }
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.imageLayout);
            if (!(viewGroup == null || this.m == 0.0f)) {
                ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                layoutParams2.height = (int) this.m;
                layoutParams2.width = layoutParams2.height;
                viewGroup.setLayoutParams(layoutParams2);
            }
            ImageView imageView = this.f48901h;
            if (imageView != null) {
                int i5 = this.r;
                if (i5 != 0) {
                    imageView.setImageResource(i5);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f48901h.getLayoutParams();
                if (this.s != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.leftMargin = (int) this.s;
                }
                if (this.t != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.topMargin = (int) this.t;
                }
                if (this.u != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.width = (int) this.u;
                }
                if (this.v != getResources().getDimension(R.dimen.dimen_0dp)) {
                    marginLayoutParams.height = (int) this.v;
                }
                this.f48901h.setLayoutParams(marginLayoutParams);
            }
            removeAllViews();
            addView(view);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setKnowMoreActionVisibility(boolean z2) {
        this.f48897d.setVisibility(z2 ? 0 : 8);
    }

    public void setClickOnKnowMore(View.OnClickListener onClickListener) {
        TextView textView = this.f48897d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setViewBalanceActionVisibility(boolean z2) {
        this.f48898e.setVisibility(z2 ? 0 : 8);
    }

    public void setClickListenerOnActionViewBalance(View.OnClickListener onClickListener) {
        TextView textView = this.f48898e;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        this.n = str;
        TextView textView = this.f48894a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSubTitle(String str) {
        this.p = str;
        if (this.f48895b == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f48895b.setVisibility(8);
            return;
        }
        this.f48895b.setVisibility(0);
        this.f48895b.setText(str);
    }

    public void setPpbAccountStatus(String str) {
        if (this.f48896c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f48896c.setVisibility(8);
            return;
        }
        this.f48896c.setVisibility(0);
        this.f48896c.setText(str);
    }

    public void setIcon(int i2) {
        this.r = i2;
        ImageView imageView = this.f48901h;
        if (imageView != null) {
            imageView.setImageDrawable(b.a(getContext(), i2));
        }
    }

    public void setTitleSize(float f2) {
        TextView textView;
        if (f2 != 0.0f && (textView = this.f48894a) != null) {
            textView.setTextSize(0, f2);
            this.o = f2;
        }
    }

    public void setSubTitleTextSize(float f2) {
        TextView textView;
        if (f2 != 0.0f && (textView = this.f48895b) != null) {
            textView.setTextSize(0, f2);
            this.q = f2;
        }
    }

    public void setTitleColor(int i2) {
        TextView textView = this.f48894a;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setSubTitleColor(int i2) {
        TextView textView = this.f48895b;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            setAnimation(this.B);
        } else {
            a(this.B);
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            this.f48895b.setVisibility(0);
            this.C.setVisibility(0);
            return;
        }
        this.f48895b.setVisibility(8);
        this.C.setVisibility(8);
    }

    private void setAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void setCircleColor(int i2) {
        this.l = i2;
        if (this.y != null && this.l != 0) {
            Drawable a2 = b.a(getContext(), R.drawable.circular_facility_icon_bg_addmoney);
            a.a(a2, this.l);
            this.y.setImageDrawable(a2);
        }
    }

    public void setKnowMoreActionText(String str) {
        if (this.f48897d == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f48897d.setVisibility(8);
            return;
        }
        this.f48897d.setVisibility(0);
        this.f48897d.setText(str);
    }

    public void setDescription(String str) {
        if (this.f48899f == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f48899f.setVisibility(8);
            return;
        }
        this.f48899f.setVisibility(0);
        this.f48899f.setText(str);
    }

    public void setTransactionFee(double d2) {
        if (this.f48900g == null) {
            return;
        }
        if (Double.compare(d2, 0.0d) <= 0) {
            this.f48900g.setVisibility(8);
            this.z.setVisibility(8);
            return;
        }
        this.f48900g.setText(getContext().getString(R.string.uam_transfer_fee));
        this.f48900g.setVisibility(8);
        this.z.setVisibility(8);
    }

    public void setRadioButtonCheck(boolean z2) {
        this.E.setChecked(z2);
    }

    public void setInfoViewClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setContentVisibility(int i2) {
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
        }
        View view = this.f48902i;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setId(int i2) {
        LinearLayout linearLayout = this.A;
        if (linearLayout != null) {
            linearLayout.setId(i2);
        }
    }

    public void setInfoIconVisibility(int i2) {
        this.z.setVisibility(i2);
    }
}
