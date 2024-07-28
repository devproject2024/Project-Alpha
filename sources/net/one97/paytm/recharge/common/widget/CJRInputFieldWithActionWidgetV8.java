package net.one97.paytm.recharge.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public class CJRInputFieldWithActionWidgetV8 extends ConstraintLayout implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private String f61890a;

    /* renamed from: b  reason: collision with root package name */
    public int f61891b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61892c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f61893d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61894e;

    /* renamed from: f  reason: collision with root package name */
    private String f61895f;

    /* renamed from: g  reason: collision with root package name */
    private String f61896g;

    /* renamed from: h  reason: collision with root package name */
    private String f61897h;

    /* renamed from: i  reason: collision with root package name */
    private String f61898i;
    private View.OnFocusChangeListener j;
    private ArrayList<TextWatcher> k;
    private int l;
    private int m;
    private int n;
    /* access modifiers changed from: private */
    public StaticLayout o;
    private int p;
    private boolean q;
    private int r;
    private boolean s;
    private AnimatorListenerAdapter t;
    private HashMap u;

    public View a(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRInputFieldWithActionWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f61890a = "enter_input_field_focus.json";
        this.f61895f = "exit_input_field_focus.json";
        this.f61896g = "exit_input_field_focus_with_error.json";
        this.f61897h = "error_on_input_field_focus_out.json";
        this.f61898i = "enter_input_field_focus_with_clear_error.json";
        this.l = 8;
        this.m = 8;
        this.f61891b = 8;
        this.n = 8;
        this.q = true;
        this.r = R.color.color_ebebeb;
        b(R.layout.v8_content_input_field_with_action);
        this.t = new b(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRInputFieldWithActionWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* access modifiers changed from: protected */
    public String getENTER_FOCUS_LOTTIE_JSON() {
        return this.f61890a;
    }

    /* access modifiers changed from: protected */
    public void setENTER_FOCUS_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f61890a = str;
    }

    /* access modifiers changed from: protected */
    public String getEXIT_FOCUS_LOTTIE_JSON() {
        return this.f61895f;
    }

    /* access modifiers changed from: protected */
    public void setEXIT_FOCUS_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f61895f = str;
    }

    /* access modifiers changed from: protected */
    public String getEXIT_FOCUS_WITH_ERROR_LOTTIE_JSON() {
        return this.f61896g;
    }

    /* access modifiers changed from: protected */
    public void setEXIT_FOCUS_WITH_ERROR_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f61896g = str;
    }

    /* access modifiers changed from: protected */
    public String getERROR_ON_FOCUS_OUT_ERROR_LOTTIE_JSON() {
        return this.f61897h;
    }

    /* access modifiers changed from: protected */
    public void setERROR_ON_FOCUS_OUT_ERROR_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f61897h = str;
    }

    /* access modifiers changed from: protected */
    public String getENTER_FOCUS_WITH_CLEAR_ERROR_LOTTIE_JSON() {
        return this.f61898i;
    }

    /* access modifiers changed from: protected */
    public void setENTER_FOCUS_WITH_CLEAR_ERROR_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f61898i = str;
    }

    /* access modifiers changed from: protected */
    public final int getTxtErrorViewWidth() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public final void setTxtErrorViewWidth(int i2) {
        this.p = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean getShowViewAllInSeparateLine() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public final void setShowViewAllInSeparateLine(boolean z) {
        this.q = z;
    }

    /* access modifiers changed from: protected */
    public final TextView getTxt_error() {
        TextView textView = this.f61893d;
        if (textView == null) {
            k.a("txt_error");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final void setTxt_error(TextView textView) {
        k.c(textView, "<set-?>");
        this.f61893d = textView;
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(i2, this, true);
        View findViewById = findViewById(R.id.txt_error);
        k.a((Object) findViewById, "findViewById(R.id.txt_error)");
        this.f61893d = (TextView) findViewById;
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnFocusChangeListener(this);
        }
        CJRRechargeEditText cJRRechargeEditText2 = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText2 != null) {
            cJRRechargeEditText2.clearFocus();
        }
        a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), this.r));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        ax.a aVar = ax.f61521a;
        Context context = getContext();
        k.a((Object) context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = ax.a.a(applicationContext);
        if (a2.b("debug.setting.recharge.inline.viewall", false)) {
            this.q = !a2.b("debug.setting.recharge.inline.viewall", true, false);
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldWithActionWidgetV8 f61901a;

        c(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
            this.f61901a = cJRInputFieldWithActionWidgetV8;
        }

        public final void onGlobalLayout() {
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.f61901a;
            cJRInputFieldWithActionWidgetV8.setTxtErrorViewWidth(cJRInputFieldWithActionWidgetV8.getWidth());
            this.f61901a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void a() {
        this.j = null;
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }
        CJRRechargeEditText cJRRechargeEditText2 = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText2 != null) {
            cJRRechargeEditText2.setOnClickListener((View.OnClickListener) null);
        }
        ArrayList<TextWatcher> arrayList = this.k;
        if (arrayList != null) {
            for (TextWatcher textWatcher : arrayList) {
                CJRRechargeEditText cJRRechargeEditText3 = (CJRRechargeEditText) a(R.id.txt_input);
                if (cJRRechargeEditText3 != null) {
                    cJRRechargeEditText3.removeTextChangedListener(textWatcher);
                }
            }
        }
        ArrayList<TextWatcher> arrayList2 = this.k;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.k = null;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.lyt_actions);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener((View.OnClickListener) null);
        }
        TextView textView = (TextView) a(R.id.action_secondary_text);
        if (textView != null) {
            textView.setOnClickListener((View.OnClickListener) null);
        }
        TextView textView2 = (TextView) a(R.id.action_primary_text);
        if (textView2 != null) {
            textView2.setOnClickListener((View.OnClickListener) null);
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.action_primary_icon);
        if (frameLayout != null) {
            frameLayout.setOnClickListener((View.OnClickListener) null);
        }
        FrameLayout frameLayout2 = (FrameLayout) a(R.id.action_secondary_icon);
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener((View.OnClickListener) null);
        }
        TextView textView3 = (TextView) a(R.id.txt_viewall);
        if (textView3 != null) {
            textView3.setOnClickListener((View.OnClickListener) null);
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.divider_lottie);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = (CJRRechargeLottieAnimationView) a(R.id.divider_lottie);
        if (cJRRechargeLottieAnimationView2 != null) {
            cJRRechargeLottieAnimationView2.removeAllAnimatorListeners();
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView3 = (CJRRechargeLottieAnimationView) a(R.id.divider_lottie);
        if (cJRRechargeLottieAnimationView3 != null) {
            cJRRechargeLottieAnimationView3.removeAllUpdateListeners();
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView4 = (CJRRechargeLottieAnimationView) a(R.id.divider_lottie);
        if (cJRRechargeLottieAnimationView4 != null) {
            cJRRechargeLottieAnimationView4.removeAllLottieOnCompositionLoadedListener();
        }
        this.t = null;
        this.o = null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.j = null;
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }
        super.onDetachedFromWindow();
    }

    public final void b() {
        TextView textView = (TextView) a(R.id.hint_amount);
        k.a((Object) textView, "hint_amount");
        textView.setVisibility(0);
    }

    public final void a(boolean z) {
        TextView textView = (TextView) a(R.id.hint_amount);
        k.a((Object) textView, "hint_amount");
        textView.setText(z ? getContext().getString(R.string.rupees_re) : "");
    }

    public final void setSecondaryInputText(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) a(R.id.hint_amount);
            k.a((Object) textView, "hint_amount");
            textView.setText(charSequence);
            TextView textView2 = (TextView) a(R.id.hint_amount);
            k.a((Object) textView2, "hint_amount");
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = (TextView) a(R.id.hint_amount);
        k.a((Object) textView3, "hint_amount");
        textView3.setText("");
        TextView textView4 = (TextView) a(R.id.hint_amount);
        k.a((Object) textView4, "hint_amount");
        textView4.setVisibility(8);
    }

    public final void setSecondaryInputHint(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) a(R.id.hint_amount);
            k.a((Object) textView, "hint_amount");
            textView.setHint(charSequence);
            TextView textView2 = (TextView) a(R.id.hint_amount);
            k.a((Object) textView2, "hint_amount");
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = (TextView) a(R.id.hint_amount);
        k.a((Object) textView3, "hint_amount");
        textView3.setHint("");
        TextView textView4 = (TextView) a(R.id.hint_amount);
        k.a((Object) textView4, "hint_amount");
        textView4.setVisibility(8);
    }

    public final void setInputHintText(String str) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            if (str == null) {
                str = "";
            }
            cJRRechargeEditText.setHint(str);
        }
    }

    public final void setInputHintText(int i2) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setHint(getContext().getString(i2));
        }
    }

    public final void setInputFieldClickListener(View.OnClickListener onClickListener) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnClickListener(onClickListener);
        }
    }

    public void setInputFieldTextChangeListener(TextWatcher textWatcher) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (textWatcher != null) {
            ArrayList<TextWatcher> arrayList = this.k;
            if (arrayList == null) {
                k.a();
            }
            arrayList.add(textWatcher);
        }
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.addTextChangedListener(textWatcher);
        }
    }

    public final void a(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList;
        if (!(textWatcher == null || (arrayList = this.k) == null)) {
            arrayList.remove(textWatcher);
        }
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.removeTextChangedListener(textWatcher);
        }
    }

    public final void setInputFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.j = onFocusChangeListener;
    }

    public final void b(boolean z) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setFocusable(z);
        }
        CJRRechargeEditText cJRRechargeEditText2 = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText2 != null) {
            cJRRechargeEditText2.setFocusableInTouchMode(z);
        }
    }

    public void setEnabled(boolean z) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setEnabled(z);
        }
        CJRRechargeEditText cJRRechargeEditText2 = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText2 != null) {
            cJRRechargeEditText2.setFocusable(z);
        }
        CJRRechargeEditText cJRRechargeEditText3 = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText3 != null) {
            cJRRechargeEditText3.setFocusableInTouchMode(z);
        }
        super.setEnabled(z);
    }

    public final void setInputText(String str) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setText(str);
        }
    }

    public final void setInputSelection(int i2) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setSelection(i2);
        }
    }

    public final void a(String str) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.append(str);
        }
    }

    public String getInputText() {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        return String.valueOf(cJRRechargeEditText != null ? cJRRechargeEditText.getText() : null);
    }

    public final void setInputType(int i2) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setInputType(i2);
        }
    }

    public final CJRRechargeEditText getInputView() {
        return (CJRRechargeEditText) a(R.id.txt_input);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        k.c(inputFilterArr, "filters");
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setFilters(inputFilterArr);
        }
    }

    public final void setActionLayoutClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        ((ConstraintLayout) a(R.id.lyt_actions)).setOnClickListener(onClickListener);
    }

    public final void setFocusOutColor(int i2) {
        this.r = i2;
        a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), this.r));
    }

    public final void setInputHintTextColor(int i2) {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setHintTextColor(androidx.core.content.b.c(getContext(), i2));
        }
    }

    public final void setSecondaryHintTextColor(int i2) {
        ((TextView) a(R.id.hint_amount)).setHintTextColor(androidx.core.content.b.c(getContext(), i2));
    }

    public final void setActionSecondaryTextClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        ((TextView) a(R.id.action_secondary_text)).setOnClickListener(onClickListener);
    }

    public final View a(String str, int i2, View.OnClickListener onClickListener) {
        k.c(str, "primaryText");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) a(R.id.action_primary_text);
            k.a((Object) textView, "action_primary_text");
            textView.setText(charSequence);
            if (i2 == -1) {
                i2 = R.color.color_00b9f5;
            }
            ((TextView) a(R.id.action_primary_text)).setTextColor(androidx.core.content.b.c(getContext(), i2));
            ProgressBar progressBar = (ProgressBar) a(R.id.action_progress);
            k.a((Object) progressBar, "action_progress");
            if (progressBar.getVisibility() == 0) {
                this.n = 0;
            } else {
                TextView textView2 = (TextView) a(R.id.action_primary_text);
                k.a((Object) textView2, "action_primary_text");
                textView2.setVisibility(0);
                this.n = 0;
            }
            ((TextView) a(R.id.action_primary_text)).setOnClickListener(onClickListener);
        } else {
            TextView textView3 = (TextView) a(R.id.action_primary_text);
            k.a((Object) textView3, "action_primary_text");
            textView3.setText("");
            TextView textView4 = (TextView) a(R.id.action_primary_text);
            k.a((Object) textView4, "action_primary_text");
            textView4.setVisibility(8);
            this.n = 8;
        }
        TextView textView5 = (TextView) a(R.id.action_primary_text);
        k.a((Object) textView5, "action_primary_text");
        return textView5;
    }

    public final View a(int i2, View.OnClickListener onClickListener) {
        String string = getContext().getString(i2);
        k.a((Object) string, "context.getString(primaryTextId)");
        return a(string, -1, onClickListener);
    }

    public final View a(int i2, int i3) {
        String string = getContext().getString(i2);
        k.a((Object) string, "context.getString(primaryTextId)");
        return a(string, i3, (View.OnClickListener) null);
    }

    public final void setActionPrimaryTextClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        ((TextView) a(R.id.action_primary_text)).setOnClickListener(onClickListener);
    }

    public final TextView getActionPrimaryText() {
        return (TextView) a(R.id.action_primary_text);
    }

    public final void b(int i2, View.OnClickListener onClickListener) {
        ImageView imageView;
        try {
            ProgressBar progressBar = (ProgressBar) a(R.id.action_progress);
            k.a((Object) progressBar, "action_progress");
            if (progressBar.getVisibility() == 0) {
                this.m = 0;
            } else {
                FrameLayout frameLayout = (FrameLayout) a(R.id.action_primary_icon);
                k.a((Object) frameLayout, "action_primary_icon");
                frameLayout.setVisibility(0);
                this.m = 0;
            }
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.action_primary_icon);
            if (!(frameLayout2 == null || (imageView = (ImageView) frameLayout2.findViewById(R.id.primary_icon)) == null)) {
                imageView.setImageDrawable(f.b().a(getContext(), i2));
            }
            ((FrameLayout) a(R.id.action_primary_icon)).setOnClickListener(onClickListener);
        } catch (Resources.NotFoundException unused) {
            FrameLayout frameLayout3 = (FrameLayout) a(R.id.action_primary_icon);
            k.a((Object) frameLayout3, "action_primary_icon");
            frameLayout3.setVisibility(8);
            this.m = 8;
        }
    }

    public final void setActionPrimaryIconClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        ((FrameLayout) a(R.id.action_primary_icon)).setOnClickListener(onClickListener);
    }

    public final ImageView getActionPrimaryIcon() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.action_primary_icon);
        if (frameLayout != null) {
            return (ImageView) frameLayout.findViewById(R.id.primary_icon);
        }
        return null;
    }

    public final void c(int i2, View.OnClickListener onClickListener) {
        ImageView imageView;
        try {
            ProgressBar progressBar = (ProgressBar) a(R.id.action_progress);
            k.a((Object) progressBar, "action_progress");
            if (progressBar.getVisibility() == 0) {
                this.l = 0;
            } else {
                FrameLayout frameLayout = (FrameLayout) a(R.id.action_secondary_icon);
                k.a((Object) frameLayout, "action_secondary_icon");
                frameLayout.setVisibility(0);
                this.l = 0;
            }
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.action_secondary_icon);
            if (!(frameLayout2 == null || (imageView = (ImageView) frameLayout2.findViewById(R.id.secondary_icon)) == null)) {
                imageView.setImageDrawable(f.b().a(getContext(), i2));
            }
            ((FrameLayout) a(R.id.action_secondary_icon)).setOnClickListener(onClickListener);
        } catch (Resources.NotFoundException unused) {
            FrameLayout frameLayout3 = (FrameLayout) a(R.id.action_secondary_icon);
            k.a((Object) frameLayout3, "action_secondary_icon");
            frameLayout3.setVisibility(8);
            this.l = 8;
        }
    }

    public final void setActionSecondaryIconClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        ((FrameLayout) a(R.id.action_secondary_icon)).setOnClickListener(onClickListener);
    }

    public final void c(boolean z) {
        this.f61894e = z;
        if (z) {
            FrameLayout frameLayout = (FrameLayout) a(R.id.action_secondary_icon);
            k.a((Object) frameLayout, "action_secondary_icon");
            this.l = frameLayout.getVisibility();
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.action_primary_icon);
            k.a((Object) frameLayout2, "action_primary_icon");
            this.m = frameLayout2.getVisibility();
            TextView textView = (TextView) a(R.id.action_secondary_text);
            k.a((Object) textView, "action_secondary_text");
            this.f61891b = textView.getVisibility();
            TextView textView2 = (TextView) a(R.id.action_primary_text);
            k.a((Object) textView2, "action_primary_text");
            this.n = textView2.getVisibility();
            ProgressBar progressBar = (ProgressBar) a(R.id.action_progress);
            k.a((Object) progressBar, "action_progress");
            progressBar.setVisibility(0);
            FrameLayout frameLayout3 = (FrameLayout) a(R.id.action_secondary_icon);
            k.a((Object) frameLayout3, "action_secondary_icon");
            frameLayout3.setVisibility(8);
            FrameLayout frameLayout4 = (FrameLayout) a(R.id.action_primary_icon);
            k.a((Object) frameLayout4, "action_primary_icon");
            frameLayout4.setVisibility(8);
            TextView textView3 = (TextView) a(R.id.action_secondary_text);
            k.a((Object) textView3, "action_secondary_text");
            textView3.setVisibility(8);
            TextView textView4 = (TextView) a(R.id.action_primary_text);
            k.a((Object) textView4, "action_primary_text");
            textView4.setVisibility(8);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) a(R.id.action_progress);
        k.a((Object) progressBar2, "action_progress");
        progressBar2.setVisibility(8);
        FrameLayout frameLayout5 = (FrameLayout) a(R.id.action_secondary_icon);
        k.a((Object) frameLayout5, "action_secondary_icon");
        frameLayout5.setVisibility(this.l);
        FrameLayout frameLayout6 = (FrameLayout) a(R.id.action_primary_icon);
        k.a((Object) frameLayout6, "action_primary_icon");
        frameLayout6.setVisibility(this.m);
        TextView textView5 = (TextView) a(R.id.action_secondary_text);
        k.a((Object) textView5, "action_secondary_text");
        textView5.setVisibility(this.f61891b);
        TextView textView6 = (TextView) a(R.id.action_primary_text);
        k.a((Object) textView6, "action_primary_text");
        textView6.setVisibility(this.n);
    }

    public final TextView getErrorView() {
        TextView textView = this.f61893d;
        if (textView == null) {
            k.a("txt_error");
        }
        return textView;
    }

    public void b(String str) {
        TextView textView = (TextView) a(R.id.txt_viewall);
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = (TextView) a(R.id.txt_viewall);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            this.s = true;
            TextView textView3 = this.f61893d;
            if (textView3 == null) {
                k.a("txt_error");
            }
            textView3.setText(charSequence);
            TextView textView4 = this.f61893d;
            if (textView4 == null) {
                k.a("txt_error");
            }
            textView4.setTextColor(androidx.core.content.b.c(getContext(), R.color.color_fd5c5c));
            a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_fd5c5c));
            TextView textView5 = this.f61893d;
            if (textView5 == null) {
                k.a("txt_error");
            }
            textView5.setVisibility(0);
            CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
            if (cJRRechargeEditText != null) {
                cJRRechargeEditText.clearFocus();
                return;
            }
            return;
        }
        c();
    }

    public void c() {
        TextView textView = (TextView) a(R.id.txt_viewall);
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = (TextView) a(R.id.txt_viewall);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        this.s = false;
        TextView textView3 = this.f61893d;
        if (textView3 == null) {
            k.a("txt_error");
        }
        textView3.setText("");
        a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), this.r));
        TextView textView4 = this.f61893d;
        if (textView4 == null) {
            k.a("txt_error");
        }
        textView4.setVisibility(8);
    }

    public void c(String str) {
        k.c(str, "message");
        TextView textView = (TextView) a(R.id.txt_viewall);
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = (TextView) a(R.id.txt_viewall);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView3 = this.f61893d;
            if (textView3 == null) {
                k.a("txt_error");
            }
            textView3.setText(charSequence);
            TextView textView4 = this.f61893d;
            if (textView4 == null) {
                k.a("txt_error");
            }
            textView4.setTextColor(androidx.core.content.b.c(getContext(), R.color.color_999999));
            TextView textView5 = this.f61893d;
            if (textView5 == null) {
                k.a("txt_error");
            }
            textView5.setVisibility(0);
            return;
        }
        TextView textView6 = this.f61893d;
        if (textView6 == null) {
            k.a("txt_error");
        }
        textView6.setText("");
        TextView textView7 = this.f61893d;
        if (textView7 == null) {
            k.a("txt_error");
        }
        textView7.setVisibility(8);
    }

    public final StaticLayout getCurrentInlineMessageStaticLayout() {
        return this.o;
    }

    public void a(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3, StaticLayout staticLayout) {
        int i4;
        StaticLayout staticLayout2;
        boolean z;
        SpannableStringBuilder spannableStringBuilder2;
        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
        String str2 = str;
        int i5 = i2;
        int i6 = i3;
        k.c(spannableStringBuilder3, "message");
        k.c(str2, "readMore");
        TextView textView = (TextView) a(R.id.txt_viewall);
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = (TextView) a(R.id.txt_viewall);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        CharSequence charSequence = spannableStringBuilder3;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView3 = this.f61893d;
            if (textView3 == null) {
                k.a("txt_error");
            }
            textView3.setTextColor(androidx.core.content.b.c(getContext(), R.color.color_999999));
            TextView textView4 = this.f61893d;
            if (textView4 == null) {
                k.a("txt_error");
            }
            textView4.onPreDraw();
            TextView textView5 = this.f61893d;
            if (textView5 == null) {
                k.a("txt_error");
            }
            Layout layout = textView5.getLayout();
            TextPaint paint = layout != null ? layout.getPaint() : null;
            if (paint == null) {
                paint = new TextPaint();
                TextView textView6 = this.f61893d;
                if (textView6 == null) {
                    k.a("txt_error");
                }
                paint.setTextSize(textView6.getTextSize());
                if (Build.VERSION.SDK_INT >= 21) {
                    TextView textView7 = this.f61893d;
                    if (textView7 == null) {
                        k.a("txt_error");
                    }
                    paint.setLetterSpacing(textView7.getLetterSpacing());
                }
                TextView textView8 = this.f61893d;
                if (textView8 == null) {
                    k.a("txt_error");
                }
                paint.setTypeface(textView8.getTypeface());
            }
            TextPaint textPaint = paint;
            int i7 = this.p;
            if (i7 <= 0) {
                i7 = getWidth() > 0 ? getWidth() : 0;
            }
            this.p = i7;
            List<String> g2 = p.g(charSequence);
            if (this.p <= 0) {
                i4 = 2;
                staticLayout2 = staticLayout;
            } else if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(g2.get(0), 0, g2.get(0).length(), textPaint, this.p);
                TextView textView9 = this.f61893d;
                if (textView9 == null) {
                    k.a("txt_error");
                }
                float lineSpacingExtra = textView9.getLineSpacingExtra();
                TextView textView10 = this.f61893d;
                if (textView10 == null) {
                    k.a("txt_error");
                }
                staticLayout2 = obtain.setLineSpacing(lineSpacingExtra, textView10.getLineSpacingMultiplier()).setEllipsize(TextUtils.TruncateAt.END).setBreakStrategy(2).build();
                i4 = 2;
            } else {
                CharSequence charSequence2 = g2.get(0);
                int i8 = this.p;
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                TextView textView11 = this.f61893d;
                if (textView11 == null) {
                    k.a("txt_error");
                }
                float lineSpacingMultiplier = textView11.getLineSpacingMultiplier();
                TextView textView12 = this.f61893d;
                if (textView12 == null) {
                    k.a("txt_error");
                }
                i4 = 2;
                staticLayout2 = new StaticLayout(charSequence2, textPaint, i8, alignment, lineSpacingMultiplier, textView12.getLineSpacingExtra(), false);
            }
            this.o = staticLayout2;
            StaticLayout staticLayout3 = this.o;
            if (i6 < (staticLayout3 != null ? staticLayout3.getLineCount() : 0)) {
                CharSequence charSequence3 = str2;
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (this.q) {
                        TextView textView13 = this.f61893d;
                        if (textView13 == null) {
                            k.a("txt_error");
                        }
                        textView13.setMaxLines(i4);
                        TextView textView14 = (TextView) a(R.id.txt_viewall);
                        if (textView14 != null) {
                            textView14.setText(charSequence3);
                        }
                        TextView textView15 = (TextView) a(R.id.txt_viewall);
                        if (textView15 != null) {
                            textView15.setTextColor(androidx.core.content.b.c(getContext(), i5));
                        }
                        TextView textView16 = (TextView) a(R.id.txt_viewall);
                        if (textView16 != null) {
                            textView16.setOnClickListener(new d(this));
                        }
                        TextView textView17 = this.f61893d;
                        if (textView17 == null) {
                            k.a("txt_error");
                        }
                        textView17.setText(charSequence);
                        TextView textView18 = this.f61893d;
                        if (textView18 == null) {
                            k.a("txt_error");
                        }
                        textView18.setVisibility(0);
                        TextView textView19 = (TextView) a(R.id.txt_viewall);
                        if (textView19 != null) {
                            textView19.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    String concat = " .. ".concat(String.valueOf(str));
                    StaticLayout staticLayout4 = this.o;
                    if (staticLayout4 == null) {
                        k.a();
                    }
                    k.c(spannableStringBuilder3, "message");
                    k.c(concat, "viewAllPostFix");
                    k.c(staticLayout4, "staticLayout");
                    int lineEnd = staticLayout4.getLineEnd(i6 - 1);
                    if (lineEnd > 0) {
                        z = false;
                        spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3.subSequence(0, lineEnd - (concat.length() + 1))).append(concat);
                        k.a((Object) spannableStringBuilder2, "SpannableStringBuilder(m…)).append(viewAllPostFix)");
                    } else {
                        z = false;
                        spannableStringBuilder2 = spannableStringBuilder3;
                    }
                    CharSequence charSequence4 = spannableStringBuilder2;
                    int a2 = p.a(charSequence4, str2, z ? 1 : 0, z, 6);
                    if (a2 != -1) {
                        try {
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getContext(), i5)), a2, str.length() + a2, 33);
                        } catch (Exception unused) {
                        }
                        TextView textView20 = this.f61893d;
                        if (textView20 == null) {
                            k.a("txt_error");
                        }
                        textView20.setMovementMethod(LinkMovementMethod.getInstance());
                        try {
                            spannableStringBuilder2.setSpan(new CJRInputFieldWithActionWidgetV8$showInlineMessage$spanNoUnderline$1(this, spannableStringBuilder3, concat, concat), a2, str.length() + a2, 33);
                        } catch (Exception unused2) {
                        }
                    }
                    TextView textView21 = this.f61893d;
                    if (textView21 == null) {
                        k.a("txt_error");
                    }
                    textView21.setText(charSequence4);
                    TextView textView22 = this.f61893d;
                    if (textView22 == null) {
                        k.a("txt_error");
                    }
                    textView22.setVisibility(0);
                    return;
                }
            }
            TextView textView23 = this.f61893d;
            if (textView23 == null) {
                k.a("txt_error");
            }
            textView23.setText(charSequence);
            TextView textView24 = this.f61893d;
            if (textView24 == null) {
                k.a("txt_error");
            }
            textView24.setVisibility(0);
            return;
        }
        TextView textView25 = this.f61893d;
        if (textView25 == null) {
            k.a("txt_error");
        }
        textView25.setText("");
        TextView textView26 = this.f61893d;
        if (textView26 == null) {
            k.a("txt_error");
        }
        textView26.setVisibility(8);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldWithActionWidgetV8 f61902a;

        d(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
            this.f61902a = cJRInputFieldWithActionWidgetV8;
        }

        public final void onClick(View view) {
            this.f61902a.getTxt_error().setMaxLines(Integer.MAX_VALUE);
            k.a((Object) view, "it");
            view.setVisibility(8);
            this.f61902a.o = null;
        }
    }

    public final View d(String str) {
        k.c(str, "headerText");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition(this);
            }
            TextView textView = (TextView) a(R.id.txt_input_header);
            if (textView != null) {
                textView.setText(charSequence);
            }
            TextView textView2 = (TextView) a(R.id.txt_input_header);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            TextView textView3 = (TextView) a(R.id.txt_input_header);
            if (textView3 != null) {
                textView3.setText("");
            }
            TextView textView4 = (TextView) a(R.id.txt_input_header);
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        return (TextView) a(R.id.txt_input_header);
    }

    public final void d() {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.requestFocus();
        }
    }

    public final void setDividerColor(int i2) {
        a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), i2));
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldWithActionWidgetV8 f61900a;

        b(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
            this.f61900a = cJRInputFieldWithActionWidgetV8;
        }

        public final void onAnimationEnd(Animator animator) {
            View a2 = this.f61900a.a(R.id.divider);
            k.a((Object) a2, "divider");
            a2.setVisibility(0);
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) this.f61900a.a(R.id.divider_lottie);
            k.a((Object) cJRRechargeLottieAnimationView, "divider_lottie");
            cJRRechargeLottieAnimationView.setVisibility(8);
        }
    }

    private final void e(String str) {
        if (this.f61892c) {
            View a2 = a(R.id.divider);
            k.a((Object) a2, "divider");
            a2.setVisibility(8);
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.divider_lottie);
            k.a((Object) cJRRechargeLottieAnimationView, "divider_lottie");
            cJRRechargeLottieAnimationView.setVisibility(0);
            ((CJRRechargeLottieAnimationView) a(R.id.divider_lottie)).setAnimation(str);
            ((CJRRechargeLottieAnimationView) a(R.id.divider_lottie)).addAnimatorListener(this.t);
            ((CJRRechargeLottieAnimationView) a(R.id.divider_lottie)).playAnimation();
        }
    }

    public final void e() {
        e(getEXIT_FOCUS_LOTTIE_JSON());
    }

    public void onFocusChange(View view, boolean z) {
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            num = Integer.valueOf(cJRRechargeEditText.getId());
        }
        if (k.a((Object) valueOf, (Object) num)) {
            if (z) {
                a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_00b9f5));
                if (this.s) {
                    e(getENTER_FOCUS_WITH_CLEAR_ERROR_LOTTIE_JSON());
                } else {
                    e(getENTER_FOCUS_LOTTIE_JSON());
                }
            } else {
                a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), this.r));
                if (this.s) {
                    e(getEXIT_FOCUS_WITH_ERROR_LOTTIE_JSON());
                    a(R.id.divider).setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_fd5c5c));
                } else {
                    e();
                }
            }
            View.OnFocusChangeListener onFocusChangeListener = this.j;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z);
            }
        }
    }

    public final void setSecondaryIconVisibility(int i2) {
        ProgressBar progressBar = (ProgressBar) a(R.id.action_progress);
        k.a((Object) progressBar, "action_progress");
        if (progressBar.getVisibility() == 0) {
            this.n = i2;
            return;
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.action_secondary_icon);
        k.a((Object) frameLayout, "action_secondary_icon");
        frameLayout.setVisibility(i2);
    }

    public void setLargeAmount() {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setTextSize(2, 36.0f);
        }
        ((TextView) a(R.id.hint_amount)).setTextSize(2, 36.0f);
        TextView textView = (TextView) a(R.id.action_primary_text);
        k.a((Object) textView, "action_primary_text");
        textView.setGravity(8388693);
    }

    public static final class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldWithActionWidgetV8 f61899a;

        a(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
            this.f61899a = cJRInputFieldWithActionWidgetV8;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) this.f61899a.a(R.id.txt_input);
            if (cJRRechargeEditText == null) {
                return true;
            }
            cJRRechargeEditText.requestFocus();
            return true;
        }
    }

    public final void f() {
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnEditorActionListener(new a(this));
        }
    }
}
