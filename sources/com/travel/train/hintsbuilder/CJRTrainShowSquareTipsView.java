package com.travel.train.hintsbuilder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.travel.train.R;

public class CJRTrainShowSquareTipsView extends RelativeLayout implements View.OnClickListener {
    private Canvas A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;
    private PorterDuffXfermode F;
    private boolean G;
    private int H = 300;
    private int I = 300;

    /* renamed from: a  reason: collision with root package name */
    int[] f27452a;

    /* renamed from: b  reason: collision with root package name */
    boolean f27453b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Point f27454c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f27455d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f27456e;

    /* renamed from: f  reason: collision with root package name */
    private String f27457f;

    /* renamed from: g  reason: collision with root package name */
    private String f27458g;

    /* renamed from: h  reason: collision with root package name */
    private String f27459h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f27460i;
    private boolean j;
    private int k = 0;
    private int l = 0;
    private c m;
    /* access modifiers changed from: private */
    public View n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private Drawable x;
    private int y = 220;
    private Bitmap z;

    public CJRTrainShowSquareTipsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public CJRTrainShowSquareTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CJRTrainShowSquareTipsView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setVisibility(8);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (CJRTrainShowSquareTipsView.this.getDismissOnTouch()) {
                    CJRTrainShowSquareTipsView.this.setVisibility(8);
                    ((ViewGroup) ((Activity) CJRTrainShowSquareTipsView.this.getContext()).getWindow().getDecorView()).removeView(CJRTrainShowSquareTipsView.this);
                }
            }
        });
        this.B = new Paint();
        this.C = new Paint();
        this.D = new Paint();
        this.E = new Paint();
        this.F = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.o = i2;
        this.p = i3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f27454c != null) {
            this.z = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.A = new Canvas(this.z);
            int i2 = this.s;
            if (i2 != 0) {
                this.B.setColor(i2);
            } else {
                this.B.setColor(Color.parseColor("#80000000"));
            }
            new StringBuilder().append(this.B.getColor());
            this.B.setAlpha(this.y);
            Canvas canvas2 = this.A;
            canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.A.getHeight(), this.B);
            this.E.setColor(getResources().getColor(17170445));
            this.E.setXfermode(this.F);
            this.f27452a = new int[2];
            this.n.getLocationInWindow(this.f27452a);
            int[] iArr = this.f27452a;
            this.A.drawRect(new Rect(iArr[0], iArr[1], iArr[0] + this.n.getWidth(), this.f27452a[1] + this.n.getHeight()), this.E);
            canvas.drawBitmap(this.z, 0.0f, 0.0f, this.C);
        }
    }

    public final void a(final Activity activity) {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                ((ViewGroup) activity.getWindow().getDecorView()).addView(CJRTrainShowSquareTipsView.this);
                CJRTrainShowSquareTipsView.this.setVisibility(0);
                CJRTrainShowSquareTipsView.this.startAnimation(AnimationUtils.loadAnimation(CJRTrainShowSquareTipsView.this.getContext(), R.anim.anim_fade_in));
                CJRTrainShowSquareTipsView.this.n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        if (!CJRTrainShowSquareTipsView.this.f27453b) {
                            if (CJRTrainShowSquareTipsView.this.n.getHeight() > 0 && CJRTrainShowSquareTipsView.this.n.getWidth() > 0) {
                                CJRTrainShowSquareTipsView.this.f27453b = true;
                            }
                            if (!CJRTrainShowSquareTipsView.this.f27460i) {
                                int[] iArr = new int[2];
                                CJRTrainShowSquareTipsView.this.n.getLocationInWindow(iArr);
                                Point unused = CJRTrainShowSquareTipsView.this.f27454c = new Point(iArr[0] + (CJRTrainShowSquareTipsView.this.n.getWidth() / 2), iArr[1] + (CJRTrainShowSquareTipsView.this.n.getHeight() / 2));
                                int unused2 = CJRTrainShowSquareTipsView.this.f27455d = CJRTrainShowSquareTipsView.this.n.getWidth() / 2;
                            } else {
                                int[] iArr2 = new int[2];
                                CJRTrainShowSquareTipsView.this.n.getLocationInWindow(iArr2);
                                Point unused3 = CJRTrainShowSquareTipsView.this.f27454c = new Point(iArr2[0] + CJRTrainShowSquareTipsView.this.f27454c.x, iArr2[1] + CJRTrainShowSquareTipsView.this.f27454c.y);
                            }
                            CJRTrainShowSquareTipsView.this.invalidate();
                            if (CJRTrainShowSquareTipsView.this.o <= CJRTrainShowSquareTipsView.this.f27454c.x + 10 || CJRTrainShowSquareTipsView.this.p <= CJRTrainShowSquareTipsView.this.f27454c.y + 10) {
                                CJRTrainShowSquareTipsView.this.setVisibility(8);
                                ((ViewGroup) ((Activity) CJRTrainShowSquareTipsView.this.getContext()).getWindow().getDecorView()).removeView(CJRTrainShowSquareTipsView.this);
                                if (CJRTrainShowSquareTipsView.this.getCallback() != null) {
                                    CJRTrainShowSquareTipsView.this.getCallback().a(CJRTrainShowSquareTipsView.this.n, false);
                                    return;
                                }
                                return;
                            }
                            CJRTrainShowSquareTipsView.f(CJRTrainShowSquareTipsView.this);
                        }
                    }
                });
            }
        }, (long) getDelay());
    }

    public void onClick(View view) {
        setVisibility(8);
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(this);
        if (getCallback() != null) {
            getCallback().a(this.n, view.getId() == R.id.positive_btn);
        }
    }

    public void setTarget(View view) {
        this.n = view;
    }

    public void setTarget(View view, int i2, int i3, int i4) {
        this.f27460i = true;
        this.n = view;
        this.f27454c = new Point(i2, i3);
        this.f27455d = i4;
    }

    public void setPositiveButton(String str) {
        this.f27458g = str;
    }

    public String getPositiveButton() {
        return this.f27458g;
    }

    public void setNegativeButton(String str) {
        this.f27459h = str;
    }

    public String getNegativeButton() {
        return this.f27459h;
    }

    public void setDismissOnTouch(boolean z2) {
        this.G = z2;
    }

    public boolean getDismissOnTouch() {
        return this.G;
    }

    public void setTitle(String str) {
        this.f27456e = str;
    }

    public String getTitle() {
        return this.f27456e;
    }

    public String getDescription() {
        return this.f27457f;
    }

    public void setDescription(String str) {
        this.f27457f = str;
    }

    public void setDisplayOneTime(boolean z2) {
        this.j = z2;
    }

    public c getCallback() {
        return this.m;
    }

    public void setCallback(c cVar) {
        this.m = cVar;
    }

    public void setDelay(int i2) {
        this.l = i2;
    }

    public int getDelay() {
        return this.l;
    }

    public void setDisplayOneTimeID(int i2) {
        this.k = i2;
    }

    public int getDisplayOneTimeID() {
        return this.k;
    }

    public void setTitle_color(int i2) {
        this.q = i2;
    }

    public int getTitle_color() {
        return this.q;
    }

    public void setDescription_color(int i2) {
        this.r = i2;
    }

    public int getDescription_color() {
        return this.r;
    }

    public void setBackground_color(int i2) {
        this.s = i2;
    }

    public int getBackground_color() {
        return this.s;
    }

    public void setCircleColor(int i2) {
        this.t = i2;
    }

    public int getCircleColor() {
        return this.t;
    }

    public void setBackground_alpha(int i2) {
        if (i2 > 255) {
            this.y = PriceRangeSeekBar.INVALID_POINTER_ID;
        } else if (i2 < 0) {
            this.y = 0;
        } else {
            this.y = i2;
        }
    }

    public int getBackground_alpha() {
        return this.y;
    }

    public void setButtonColor(int i2) {
        this.u = i2;
    }

    public int getButtonColor() {
        return this.u;
    }

    public void setButtonTextColor(int i2) {
        this.v = i2;
    }

    public int getButtonTextColor() {
        return this.v;
    }

    public void setLayout(int i2) {
        this.w = i2;
    }

    public void setCloseButtonDrawableBG(Drawable drawable) {
        this.x = drawable;
    }

    public Drawable getCloseButtonDrawableBG() {
        return this.x;
    }

    public void setLayoutWidthHeight(int i2, int i3) {
        this.H = i2;
        this.I = i3;
    }

    static /* synthetic */ void f(CJRTrainShowSquareTipsView cJRTrainShowSquareTipsView) {
        cJRTrainShowSquareTipsView.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(cJRTrainShowSquareTipsView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b.a(160.0f, cJRTrainShowSquareTipsView.getContext()), b.a(160.0f, cJRTrainShowSquareTipsView.getContext()));
        View inflate = LayoutInflater.from(cJRTrainShowSquareTipsView.getContext()).inflate(cJRTrainShowSquareTipsView.w, (ViewGroup) null);
        linearLayout.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.positive_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.negative_btn);
        View findViewById = inflate.findViewById(R.id.divider_view);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.show_tip_layout);
        ((TextView) inflate.findViewById(R.id.title_txt)).setText(cJRTrainShowSquareTipsView.getTitle());
        ((TextView) inflate.findViewById(R.id.description_txt)).setText(cJRTrainShowSquareTipsView.getDescription());
        if (textView != null) {
            textView.setText(cJRTrainShowSquareTipsView.getPositiveButton());
            textView.setOnClickListener(cJRTrainShowSquareTipsView);
            if (findViewById != null && cJRTrainShowSquareTipsView.getPositiveButton() == null) {
                findViewById.setVisibility(8);
            }
        }
        if (textView2 != null) {
            textView2.setText(cJRTrainShowSquareTipsView.getNegativeButton());
            textView2.setOnClickListener(cJRTrainShowSquareTipsView);
        }
        if (cJRTrainShowSquareTipsView.w == R.layout.pre_t_train_show_square_tip_view) {
            linearLayout.setGravity(51);
            cJRTrainShowSquareTipsView.H = layoutParams.width;
            cJRTrainShowSquareTipsView.I = layoutParams.height;
            layoutParams.leftMargin = cJRTrainShowSquareTipsView.f27454c.x - (layoutParams.width / 2);
            layoutParams.topMargin = cJRTrainShowSquareTipsView.f27454c.y + (cJRTrainShowSquareTipsView.n.getHeight() / 2) + 20;
            if (cJRTrainShowSquareTipsView.getDescription().equals(cJRTrainShowSquareTipsView.getResources().getString(R.string.train_show_tip_view_120_days))) {
                linearLayout.setRotation(180.0f);
                layoutParams.topMargin = ((layoutParams.topMargin - layoutParams.height) - cJRTrainShowSquareTipsView.n.getHeight()) - 10;
                linearLayout2.setRotation(180.0f);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
        cJRTrainShowSquareTipsView.addView(linearLayout);
    }
}
