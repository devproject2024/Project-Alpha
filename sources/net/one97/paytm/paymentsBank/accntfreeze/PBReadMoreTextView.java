package net.one97.paytm.paymentsBank.accntfreeze;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import net.one97.paytm.paymentsBank.R;

public class PBReadMoreTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f17326a;

    /* renamed from: b  reason: collision with root package name */
    private TextView.BufferType f17327b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f17328c;

    /* renamed from: e  reason: collision with root package name */
    private int f17329e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f17330f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f17331g;

    /* renamed from: h  reason: collision with root package name */
    private a f17332h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f17333i;
    private boolean j;
    private int k;
    private int l;
    private int m;

    public PBReadMoreTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PBReadMoreTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17328c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PBReadMoreTextView);
        this.f17329e = obtainStyledAttributes.getInt(R.styleable.PBReadMoreTextView_trimLength, 240);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PBReadMoreTextView_trimCollapsedText, R.string.know_more);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.PBReadMoreTextView_trimExpandedText, R.string.pb_know_less);
        this.f17330f = getResources().getString(resourceId);
        if (resourceId2 != 0) {
            this.f17331g = getResources().getString(resourceId2);
        } else {
            this.f17331g = "";
        }
        this.m = obtainStyledAttributes.getInt(R.styleable.PBReadMoreTextView_trimLines, 2);
        this.f17333i = obtainStyledAttributes.getColor(R.styleable.PBReadMoreTextView_colorClickableText, b.c(context, R.color.black));
        this.j = obtainStyledAttributes.getBoolean(R.styleable.PBReadMoreTextView_showTrimExpandedText, true);
        this.k = obtainStyledAttributes.getInt(R.styleable.PBReadMoreTextView_trimMode, 0);
        obtainStyledAttributes.recycle();
        this.f17332h = new a(this, (byte) 0);
        if (this.k == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = PBReadMoreTextView.this.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                    PBReadMoreTextView.d(PBReadMoreTextView.this);
                    PBReadMoreTextView.this.a();
                }
            });
        }
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        super.setText(getDisplayableText(), this.f17327b);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }

    private CharSequence getDisplayableText() {
        CharSequence charSequence = this.f17326a;
        if (this.k != 1 || charSequence == null || charSequence.length() <= this.f17329e) {
            if (this.k != 0 || charSequence == null || this.l <= 0) {
                return charSequence;
            }
            if (!this.f17328c) {
                return c();
            }
            if (getLayout().getLineCount() > this.m) {
                return b();
            }
            return charSequence;
        } else if (this.f17328c) {
            return b();
        } else {
            return c();
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f17326a = charSequence;
        this.f17327b = bufferType;
        a();
    }

    private CharSequence b() {
        int length = this.f17326a.length();
        int i2 = this.k;
        if (i2 == 0 ? (length = this.l - ((this.f17330f.length() + 4) + 1)) < 0 : i2 == 1) {
            length = this.f17329e + 1;
        }
        return a(new SpannableStringBuilder(this.f17326a, 0, length).append("... ").append(this.f17330f), this.f17330f);
    }

    private CharSequence c() {
        if (!this.j) {
            return this.f17326a;
        }
        CharSequence charSequence = this.f17326a;
        return a(new SpannableStringBuilder(charSequence, 0, charSequence.length()).append(this.f17331g), this.f17331g);
    }

    private CharSequence a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        spannableStringBuilder.setSpan(this.f17332h, spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void setTrimLength(int i2) {
        this.f17329e = i2;
        a();
    }

    public void setColorClickableText(int i2) {
        this.f17333i = i2;
    }

    public void setTrimCollapsedText(CharSequence charSequence) {
        this.f17330f = charSequence;
    }

    public void setTrimExpandedText(CharSequence charSequence) {
        this.f17331g = charSequence;
    }

    public void setTrimMode(int i2) {
        this.k = i2;
    }

    public void setTrimLines(int i2) {
        this.m = i2;
    }

    class a extends ClickableSpan {
        private a() {
        }

        /* synthetic */ a(PBReadMoreTextView pBReadMoreTextView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            PBReadMoreTextView pBReadMoreTextView = PBReadMoreTextView.this;
            boolean unused = pBReadMoreTextView.f17328c = !pBReadMoreTextView.f17328c;
            PBReadMoreTextView.this.a();
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(PBReadMoreTextView.this.f17333i);
        }
    }

    static /* synthetic */ void d(PBReadMoreTextView pBReadMoreTextView) {
        try {
            if (pBReadMoreTextView.m == 0) {
                pBReadMoreTextView.l = pBReadMoreTextView.getLayout().getLineEnd(0);
            } else if (pBReadMoreTextView.m <= 0 || pBReadMoreTextView.getLineCount() < pBReadMoreTextView.m) {
                pBReadMoreTextView.l = -1;
            } else {
                pBReadMoreTextView.l = pBReadMoreTextView.getLayout().getLineEnd(pBReadMoreTextView.m - 1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
