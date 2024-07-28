package net.one97.paytm.addmoney.utils;

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
import net.one97.paytm.addmoney.R;

public class ExpandableTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f48931a;

    /* renamed from: b  reason: collision with root package name */
    private TextView.BufferType f48932b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f48933c;

    /* renamed from: e  reason: collision with root package name */
    private int f48934e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f48935f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f48936g;

    /* renamed from: h  reason: collision with root package name */
    private a f48937h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f48938i;
    private boolean j;
    private int k;
    private int l;
    private int m;

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48933c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AMReadMoreTextView);
        this.f48934e = obtainStyledAttributes.getInt(R.styleable.AMReadMoreTextView_trimLengthAM, 240);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AMReadMoreTextView_trimCollapsedTextAM, R.string.know_more);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.AMReadMoreTextView_trimExpandedTextAM, R.string.placeholder);
        this.f48935f = getResources().getString(resourceId);
        if (resourceId2 != 0) {
            this.f48936g = getResources().getString(resourceId2);
        } else {
            this.f48936g = "";
        }
        this.m = obtainStyledAttributes.getInt(R.styleable.AMReadMoreTextView_trimLinesAM, 2);
        this.f48938i = obtainStyledAttributes.getColor(R.styleable.AMReadMoreTextView_colorClickableTextAM, b.c(context, R.color.black));
        this.j = obtainStyledAttributes.getBoolean(R.styleable.AMReadMoreTextView_showTrimExpandedTextAM, true);
        this.k = obtainStyledAttributes.getInt(R.styleable.AMReadMoreTextView_trimModeAM, 0);
        obtainStyledAttributes.recycle();
        this.f48937h = new a(this, (byte) 0);
        if (this.k == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = ExpandableTextView.this.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                    ExpandableTextView.d(ExpandableTextView.this);
                    ExpandableTextView.this.a();
                }
            });
        }
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        super.setText(getDisplayableText(), this.f48932b);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }

    private CharSequence getDisplayableText() {
        CharSequence charSequence = this.f48931a;
        if (this.k != 1 || charSequence == null || charSequence.length() <= this.f48934e) {
            if (this.k != 0 || charSequence == null || this.l <= 0) {
                return charSequence;
            }
            if (!this.f48933c) {
                return c();
            }
            if (getLayout().getLineCount() > this.m) {
                return b();
            }
            return charSequence;
        } else if (this.f48933c) {
            return b();
        } else {
            return c();
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f48931a = charSequence;
        this.f48932b = bufferType;
        a();
    }

    private CharSequence b() {
        int length = this.f48931a.length();
        int i2 = this.k;
        if (i2 == 0 ? (length = this.l - ((this.f48935f.length() + 4) + 1)) < 0 : i2 == 1) {
            length = this.f48934e + 1;
        }
        return a(new SpannableStringBuilder(this.f48931a, 0, length).append("... ").append(this.f48935f), this.f48935f);
    }

    private CharSequence c() {
        if (!this.j) {
            return this.f48931a;
        }
        CharSequence charSequence = this.f48931a;
        return a(new SpannableStringBuilder(charSequence, 0, charSequence.length()).append(this.f48936g), this.f48936g);
    }

    private CharSequence a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        spannableStringBuilder.setSpan(this.f48937h, spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void setTrimLength(int i2) {
        this.f48934e = i2;
        a();
    }

    public void setColorClickableText(int i2) {
        this.f48938i = i2;
    }

    public void setTrimCollapsedText(CharSequence charSequence) {
        this.f48935f = charSequence;
    }

    public void setTrimExpandedText(CharSequence charSequence) {
        this.f48936g = charSequence;
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

        /* synthetic */ a(ExpandableTextView expandableTextView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            boolean unused = expandableTextView.f48933c = !expandableTextView.f48933c;
            ExpandableTextView.this.a();
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.f48938i);
        }
    }

    static /* synthetic */ void d(ExpandableTextView expandableTextView) {
        try {
            if (expandableTextView.m == 0) {
                expandableTextView.l = expandableTextView.getLayout().getLineEnd(0);
            } else if (expandableTextView.m <= 0 || expandableTextView.getLineCount() < expandableTextView.m) {
                expandableTextView.l = -1;
            } else {
                expandableTextView.l = expandableTextView.getLayout().getLineEnd(expandableTextView.m - 1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
