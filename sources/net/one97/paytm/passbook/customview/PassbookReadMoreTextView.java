package net.one97.paytm.passbook.customview;

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
import net.one97.paytm.passbook.R;

public class PassbookReadMoreTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f57177a;

    /* renamed from: b  reason: collision with root package name */
    private TextView.BufferType f57178b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f57179c;

    /* renamed from: e  reason: collision with root package name */
    private int f57180e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f57181f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f57182g;

    /* renamed from: h  reason: collision with root package name */
    private a f57183h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f57184i;
    private boolean j;
    private int k;
    private int l;
    private int m;

    public PassbookReadMoreTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PassbookReadMoreTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57179c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PassReadMoreTextView);
        this.f57180e = obtainStyledAttributes.getInt(R.styleable.PassReadMoreTextView_trimLengthPass, 240);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PassReadMoreTextView_trimCollapsedTextPass, R.string.know_more);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.PassReadMoreTextView_trimExpandedTextPass, R.string.pass_know_less);
        this.f57181f = getResources().getString(resourceId);
        if (resourceId2 != 0) {
            this.f57182g = getResources().getString(resourceId2);
        } else {
            this.f57182g = "";
        }
        this.m = obtainStyledAttributes.getInt(R.styleable.PassReadMoreTextView_trimLinesPass, 2);
        this.f57184i = obtainStyledAttributes.getColor(R.styleable.PassReadMoreTextView_colorClickableTextPass, b.c(context, R.color.black));
        this.j = obtainStyledAttributes.getBoolean(R.styleable.PassReadMoreTextView_showTrimExpandedTextPass, true);
        this.k = obtainStyledAttributes.getInt(R.styleable.PassReadMoreTextView_trimModePass, 0);
        obtainStyledAttributes.recycle();
        this.f57183h = new a(this, (byte) 0);
        if (this.k == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = PassbookReadMoreTextView.this.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                    PassbookReadMoreTextView.d(PassbookReadMoreTextView.this);
                    PassbookReadMoreTextView.this.a();
                }
            });
        }
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        super.setText(getDisplayableText(), this.f57178b);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }

    private CharSequence getDisplayableText() {
        CharSequence charSequence = this.f57177a;
        if (this.k != 1 || charSequence == null || charSequence.length() <= this.f57180e) {
            if (this.k != 0 || charSequence == null || this.l <= 0) {
                return charSequence;
            }
            if (!this.f57179c) {
                return c();
            }
            if (getLayout().getLineCount() > this.m) {
                return b();
            }
            return charSequence;
        } else if (this.f57179c) {
            return b();
        } else {
            return c();
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f57177a = charSequence;
        this.f57178b = bufferType;
        a();
    }

    private CharSequence b() {
        int length = this.f57177a.length();
        int i2 = this.k;
        if (i2 == 0 ? (length = this.l - ((this.f57181f.length() + 4) + 1)) < 0 : i2 == 1) {
            length = this.f57180e + 1;
        }
        return a(new SpannableStringBuilder(this.f57177a, 0, length).append("... ").append(this.f57181f), this.f57181f);
    }

    private CharSequence c() {
        if (!this.j) {
            return this.f57177a;
        }
        CharSequence charSequence = this.f57177a;
        return a(new SpannableStringBuilder(charSequence, 0, charSequence.length()).append(this.f57182g), this.f57182g);
    }

    private CharSequence a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        spannableStringBuilder.setSpan(this.f57183h, spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void setTrimLength(int i2) {
        this.f57180e = i2;
        a();
    }

    public void setColorClickableText(int i2) {
        this.f57184i = i2;
    }

    public void setTrimCollapsedText(CharSequence charSequence) {
        this.f57181f = charSequence;
    }

    public void setTrimExpandedText(CharSequence charSequence) {
        this.f57182g = charSequence;
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

        /* synthetic */ a(PassbookReadMoreTextView passbookReadMoreTextView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            PassbookReadMoreTextView passbookReadMoreTextView = PassbookReadMoreTextView.this;
            boolean unused = passbookReadMoreTextView.f57179c = !passbookReadMoreTextView.f57179c;
            PassbookReadMoreTextView.this.a();
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(PassbookReadMoreTextView.this.f57184i);
        }
    }

    static /* synthetic */ void d(PassbookReadMoreTextView passbookReadMoreTextView) {
        try {
            if (passbookReadMoreTextView.m == 0) {
                passbookReadMoreTextView.l = passbookReadMoreTextView.getLayout().getLineEnd(0);
            } else if (passbookReadMoreTextView.m <= 0 || passbookReadMoreTextView.getLineCount() < passbookReadMoreTextView.m) {
                passbookReadMoreTextView.l = -1;
            } else {
                passbookReadMoreTextView.l = passbookReadMoreTextView.getLayout().getLineEnd(passbookReadMoreTextView.m - 1);
            }
        } catch (Exception unused) {
        }
    }
}
