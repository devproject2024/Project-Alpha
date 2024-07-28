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
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.travel.train.R;

public class CJRTrainShowTipsView extends RelativeLayout implements View.OnClickListener {
    private Paint A;
    private Paint B;
    private Paint C;
    private Paint D;
    private PorterDuffXfermode E;
    private ImageView F;
    private boolean G;
    private int H = 300;
    private int I = 300;

    /* renamed from: a  reason: collision with root package name */
    boolean f27465a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Point f27466b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f27467c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f27468d;

    /* renamed from: e  reason: collision with root package name */
    private String f27469e;

    /* renamed from: f  reason: collision with root package name */
    private String f27470f;

    /* renamed from: g  reason: collision with root package name */
    private String f27471g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f27472h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27473i;
    private int j = 0;
    private int k = 0;
    private c l;
    /* access modifiers changed from: private */
    public View m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private Drawable w;
    private int x = 220;
    private Bitmap y;
    private Canvas z;

    public CJRTrainShowTipsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public CJRTrainShowTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CJRTrainShowTipsView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setVisibility(8);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (CJRTrainShowTipsView.this.getDismissOnTouch()) {
                    CJRTrainShowTipsView.this.setVisibility(8);
                    ((ViewGroup) ((Activity) CJRTrainShowTipsView.this.getContext()).getWindow().getDecorView()).removeView(CJRTrainShowTipsView.this);
                }
            }
        });
        this.A = new Paint();
        this.B = new Paint();
        this.C = new Paint();
        this.D = new Paint();
        this.E = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.n = i2;
        this.o = i3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f27466b != null) {
            this.y = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.z = new Canvas(this.y);
            int i2 = this.r;
            if (i2 != 0) {
                this.A.setColor(i2);
            } else {
                this.A.setColor(Color.parseColor("#80000000"));
            }
            new StringBuilder().append(this.A.getColor());
            this.A.setAlpha(this.x);
            Canvas canvas2 = this.z;
            canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.z.getHeight(), this.A);
            this.D.setColor(getResources().getColor(17170445));
            this.D.setXfermode(this.E);
            int i3 = this.f27466b.x;
            float f2 = (float) i3;
            float f3 = (float) this.f27466b.y;
            this.z.drawCircle(f2, f3, (float) this.f27467c, this.D);
            canvas.drawBitmap(this.y, 0.0f, 0.0f, this.B);
            this.C.setStyle(Paint.Style.STROKE);
            int i4 = this.s;
            if (i4 != 0) {
                this.C.setColor(i4);
            } else {
                this.C.setColor(-1);
            }
            this.C.setAntiAlias(true);
            this.C.setStrokeWidth(3.0f);
            canvas.drawCircle(f2, f3, (float) this.f27467c, this.C);
        }
    }

    public final void a(final Activity activity) {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                ((ViewGroup) activity.getWindow().getDecorView()).addView(CJRTrainShowTipsView.this);
                CJRTrainShowTipsView.this.setVisibility(0);
                CJRTrainShowTipsView.this.startAnimation(AnimationUtils.loadAnimation(CJRTrainShowTipsView.this.getContext(), R.anim.anim_fade_in));
                CJRTrainShowTipsView.this.m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        if (!CJRTrainShowTipsView.this.f27465a) {
                            if (CJRTrainShowTipsView.this.m.getHeight() > 0 && CJRTrainShowTipsView.this.m.getWidth() > 0) {
                                CJRTrainShowTipsView.this.f27465a = true;
                            }
                            if (!CJRTrainShowTipsView.this.f27472h) {
                                int[] iArr = new int[2];
                                CJRTrainShowTipsView.this.m.getLocationInWindow(iArr);
                                Point unused = CJRTrainShowTipsView.this.f27466b = new Point(iArr[0] + (CJRTrainShowTipsView.this.m.getWidth() / 2), iArr[1] + (CJRTrainShowTipsView.this.m.getHeight() / 2));
                                int unused2 = CJRTrainShowTipsView.this.f27467c = CJRTrainShowTipsView.this.m.getWidth() / 2;
                            } else {
                                int[] iArr2 = new int[2];
                                CJRTrainShowTipsView.this.m.getLocationInWindow(iArr2);
                                Point unused3 = CJRTrainShowTipsView.this.f27466b = new Point(iArr2[0] + CJRTrainShowTipsView.this.f27466b.x, iArr2[1] + CJRTrainShowTipsView.this.f27466b.y);
                            }
                            CJRTrainShowTipsView.this.invalidate();
                            if (CJRTrainShowTipsView.this.n <= CJRTrainShowTipsView.this.f27466b.x + 10 || CJRTrainShowTipsView.this.o <= CJRTrainShowTipsView.this.f27466b.y + 10) {
                                CJRTrainShowTipsView.this.setVisibility(8);
                                ((ViewGroup) ((Activity) CJRTrainShowTipsView.this.getContext()).getWindow().getDecorView()).removeView(CJRTrainShowTipsView.this);
                                if (CJRTrainShowTipsView.this.getCallback() != null) {
                                    CJRTrainShowTipsView.this.getCallback().a(CJRTrainShowTipsView.this.m, false);
                                    return;
                                }
                                return;
                            }
                            CJRTrainShowTipsView.f(CJRTrainShowTipsView.this);
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
            getCallback().a(this.m, view.getId() == R.id.positive_btn);
        }
    }

    public void setTarget(View view) {
        this.m = view;
    }

    public void setTarget(View view, int i2, int i3, int i4) {
        this.f27472h = true;
        this.m = view;
        this.f27466b = new Point(i2, i3);
        this.f27467c = i4;
    }

    public void setPositiveButton(String str) {
        this.f27470f = str;
    }

    public String getPositiveButton() {
        return this.f27470f;
    }

    public void setNegativeButton(String str) {
        this.f27471g = str;
    }

    public String getNegativeButton() {
        return this.f27471g;
    }

    public void setDismissOnTouch(boolean z2) {
        this.G = z2;
    }

    public boolean getDismissOnTouch() {
        return this.G;
    }

    public void setTitle(String str) {
        this.f27468d = str;
    }

    public String getTitle() {
        return this.f27468d;
    }

    public String getDescription() {
        return this.f27469e;
    }

    public void setDescription(String str) {
        this.f27469e = str;
    }

    public void setDisplayOneTime(boolean z2) {
        this.f27473i = z2;
    }

    public c getCallback() {
        return this.l;
    }

    public void setCallback(c cVar) {
        this.l = cVar;
    }

    public void setDelay(int i2) {
        this.k = i2;
    }

    public int getDelay() {
        return this.k;
    }

    public void setDisplayOneTimeID(int i2) {
        this.j = i2;
    }

    public int getDisplayOneTimeID() {
        return this.j;
    }

    public void setTitle_color(int i2) {
        this.p = i2;
    }

    public int getTitle_color() {
        return this.p;
    }

    public void setDescription_color(int i2) {
        this.q = i2;
    }

    public int getDescription_color() {
        return this.q;
    }

    public void setBackground_color(int i2) {
        this.r = i2;
    }

    public int getBackground_color() {
        return this.r;
    }

    public void setCircleColor(int i2) {
        this.s = i2;
    }

    public int getCircleColor() {
        return this.s;
    }

    public void setBackground_alpha(int i2) {
        if (i2 > 255) {
            this.x = PriceRangeSeekBar.INVALID_POINTER_ID;
        } else if (i2 < 0) {
            this.x = 0;
        } else {
            this.x = i2;
        }
    }

    public int getBackground_alpha() {
        return this.x;
    }

    public void setButtonColor(int i2) {
        this.t = i2;
    }

    public int getButtonColor() {
        return this.t;
    }

    public void setButtonTextColor(int i2) {
        this.u = i2;
    }

    public int getButtonTextColor() {
        return this.u;
    }

    public void setLayout(int i2) {
        this.v = i2;
    }

    public void setCloseButtonDrawableBG(Drawable drawable) {
        this.w = drawable;
    }

    public Drawable getCloseButtonDrawableBG() {
        return this.w;
    }

    public void setLayoutWidthHeight(int i2, int i3) {
        this.H = i2;
        this.I = i3;
    }

    static /* synthetic */ void f(CJRTrainShowTipsView cJRTrainShowTipsView) {
        cJRTrainShowTipsView.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(cJRTrainShowTipsView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b.a(160.0f, cJRTrainShowTipsView.getContext()), b.a(160.0f, cJRTrainShowTipsView.getContext()));
        View inflate = LayoutInflater.from(cJRTrainShowTipsView.getContext()).inflate(cJRTrainShowTipsView.v, (ViewGroup) null);
        linearLayout.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.positive_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.negative_btn);
        View findViewById = inflate.findViewById(R.id.divider_view);
        ((TextView) inflate.findViewById(R.id.title_txt)).setText(cJRTrainShowTipsView.getTitle());
        ((TextView) inflate.findViewById(R.id.description_txt)).setText(cJRTrainShowTipsView.getDescription());
        if (textView != null) {
            textView.setText(cJRTrainShowTipsView.getPositiveButton());
            textView.setOnClickListener(cJRTrainShowTipsView);
            if (findViewById != null && cJRTrainShowTipsView.getPositiveButton() == null) {
                findViewById.setVisibility(8);
            }
        }
        if (textView2 != null) {
            textView2.setText(cJRTrainShowTipsView.getNegativeButton());
            textView2.setOnClickListener(cJRTrainShowTipsView);
        }
        if (cJRTrainShowTipsView.v == R.layout.pre_t_train_audio_show_tip_layout) {
            layoutParams = new RelativeLayout.LayoutParams(850, -2);
            if (cJRTrainShowTipsView.o / 2 > cJRTrainShowTipsView.f27466b.y) {
                layoutParams.height = (cJRTrainShowTipsView.f27466b.y + cJRTrainShowTipsView.f27467c) - cJRTrainShowTipsView.o;
                layoutParams.topMargin = cJRTrainShowTipsView.f27466b.y + cJRTrainShowTipsView.f27467c;
                linearLayout.setGravity(8388659);
                linearLayout.setPadding(50, 20, 15, 50);
            } else {
                layoutParams.height = cJRTrainShowTipsView.f27466b.y - cJRTrainShowTipsView.f27467c;
                linearLayout.setGravity(8388691);
                linearLayout.setPadding(50, 100, 15, 50);
            }
            layoutParams.addRule(11);
        } else {
            cJRTrainShowTipsView.F = (ImageView) inflate.findViewById(R.id.background_show_tip_image);
            linearLayout.setGravity(51);
            cJRTrainShowTipsView.H = layoutParams.width;
            cJRTrainShowTipsView.I = layoutParams.height;
            if (cJRTrainShowTipsView.n / 2 < cJRTrainShowTipsView.f27466b.x && cJRTrainShowTipsView.o / 2 > cJRTrainShowTipsView.f27466b.y) {
                cJRTrainShowTipsView.F.setRotation(0.0f);
                layoutParams.leftMargin = cJRTrainShowTipsView.f27466b.x - cJRTrainShowTipsView.H;
                layoutParams.topMargin = cJRTrainShowTipsView.f27466b.y;
            } else if (cJRTrainShowTipsView.n / 2 > cJRTrainShowTipsView.f27466b.x && cJRTrainShowTipsView.o / 2 > cJRTrainShowTipsView.f27466b.y) {
                cJRTrainShowTipsView.F.setRotation(270.0f);
                layoutParams.leftMargin = cJRTrainShowTipsView.f27466b.x;
                layoutParams.topMargin = cJRTrainShowTipsView.f27466b.y;
            } else if (cJRTrainShowTipsView.n / 2 < cJRTrainShowTipsView.f27466b.x && cJRTrainShowTipsView.o / 2 < cJRTrainShowTipsView.f27466b.y) {
                cJRTrainShowTipsView.F.setRotation(90.0f);
                layoutParams.leftMargin = cJRTrainShowTipsView.f27466b.x - cJRTrainShowTipsView.H;
                layoutParams.topMargin = cJRTrainShowTipsView.f27466b.y - cJRTrainShowTipsView.I;
            } else if (cJRTrainShowTipsView.n / 2 > cJRTrainShowTipsView.f27466b.x && cJRTrainShowTipsView.o / 2 < cJRTrainShowTipsView.f27466b.y) {
                cJRTrainShowTipsView.F.setRotation(180.0f);
                layoutParams.leftMargin = cJRTrainShowTipsView.f27466b.x;
                layoutParams.topMargin = cJRTrainShowTipsView.f27466b.y - cJRTrainShowTipsView.H;
            }
        }
        linearLayout.setLayoutParams(layoutParams);
        cJRTrainShowTipsView.addView(linearLayout);
    }
}
