package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.core.widget.e;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ad;
import net.one97.paytm.recharge.common.utils.u;
import net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8;
import net.one97.paytm.recharge.mobile_v3.d.b;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;

public final class CJRAmountInputFieldWidgetV3 extends CJRAmountInputFieldWidgetV8 implements TextWatcher, View.OnClickListener, ad {

    /* renamed from: f  reason: collision with root package name */
    public ViewFlipper f63943f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f63944g;

    /* renamed from: h  reason: collision with root package name */
    public final l f63945h;

    /* renamed from: i  reason: collision with root package name */
    public final String f63946i;
    public final String j;
    public final String k;
    private final int l;
    private final String m;
    private String n;
    private String o;
    private String p;
    private FrameLayout q;
    private View.OnClickListener r;
    private b s;
    private View t;
    private HashMap u;

    public final View a(int i2) {
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

    public final void setLargeAmount() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRAmountInputFieldWidgetV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.l = 2;
        this.m = "plan.status.view.size";
        this.n = "v3_enter_input_field_focus.json";
        this.o = "v3_exit_input_field_focus.json";
        this.p = "error_on_input_field_focus_out.json";
        this.f63945h = new l("-?\\d+(\\.\\d+)?");
        this.f63946i = "0";
        this.j = "1";
        this.k = "2";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRAmountInputFieldWidgetV3(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final String getENTER_FOCUS_LOTTIE_JSON() {
        return this.n;
    }

    public final void setENTER_FOCUS_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.n = str;
    }

    public final String getEXIT_FOCUS_LOTTIE_JSON() {
        return this.o;
    }

    public final void setEXIT_FOCUS_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.o = str;
    }

    public final String getERROR_ON_FOCUS_OUT_ERROR_LOTTIE_JSON() {
        return this.p;
    }

    public final void setERROR_ON_FOCUS_OUT_ERROR_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.p = str;
    }

    public final void b(int i2) {
        super.b(R.layout.v3_content_input_field_with_action);
        this.f63943f = (ViewFlipper) findViewById(R.id.view_flipper_info_secondary);
        setFocusOutColor(R.color.v3_input_focus_out);
        setInputHintTextColor(R.color.v3_input_hint);
        TextView textView = (TextView) findViewById(R.id.hint_amount);
        k.a((Object) textView, "secondaryInputView");
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setHintTextColor(androidx.core.content.b.c(getContext(), R.color.v3_input_hint_rupee));
        ViewFlipper viewFlipper = this.f63943f;
        this.t = viewFlipper != null ? viewFlipper.findViewById(R.id.lyt_info_secondary_product_type) : null;
        this.q = (FrameLayout) findViewById(R.id.lyt_divider);
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        b bVar = this.s;
        if (bVar != null) {
            if (bVar == null) {
                k.a();
            }
            bVar.a("dispatch.key.event", keyEvent);
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final void a() {
        super.a();
        this.f63943f = null;
        this.s = null;
        this.f63944g = null;
        this.r = null;
    }

    public final void setOnKeyUpDownListener(b bVar) {
        k.c(bVar, "onKeyListener");
        this.s = bVar;
        ((CJRRechargeEditText) findViewById(R.id.txt_input)).setOnKeyUpDownListener(bVar);
    }

    public final void g() {
        ViewFlipper viewFlipper = this.f63943f;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(8);
        }
    }

    public final void d(boolean z) {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, z ? com.paytm.utility.b.c(12) : 0);
        }
    }

    public final void e(String str) {
        k.c(str, "msg");
        getTxt_error().setVisibility(8);
        d(false);
        ViewFlipper viewFlipper = this.f63943f;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(0);
        }
        ViewFlipper viewFlipper2 = this.f63943f;
        if (viewFlipper2 == null) {
            k.a();
        }
        View findViewById = viewFlipper2.findViewById(R.id.lyt_info_secondary_checking);
        ViewFlipper viewFlipper3 = this.f63943f;
        if (viewFlipper3 != null) {
            if (viewFlipper3 == null) {
                k.a();
            }
            viewFlipper3.setDisplayedChild(viewFlipper3.indexOfChild(findViewById));
        }
        TextView textView = (TextView) findViewById.findViewById(R.id.txt_checking);
        k.a((Object) textView, "msgView");
        textView.setText(str);
        textView.setVisibility(0);
        View findViewById2 = findViewById.findViewById(R.id.lyt_lottie_checking);
        k.a((Object) findViewById2, "checkingLottieView");
        findViewById2.setVisibility(0);
    }

    private View d(String str, String str2, View.OnClickListener onClickListener) {
        k.c(str, "status");
        d(false);
        ViewFlipper viewFlipper = this.f63943f;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(0);
        }
        ViewFlipper viewFlipper2 = this.f63943f;
        if (viewFlipper2 == null) {
            k.a();
        }
        View findViewById = viewFlipper2.findViewById(R.id.lyt_info_secondary_bill_status_1);
        ViewFlipper viewFlipper3 = this.f63943f;
        if (viewFlipper3 != null) {
            if (viewFlipper3 == null) {
                k.a();
            }
            viewFlipper3.setDisplayedChild(viewFlipper3.indexOfChild(findViewById));
        }
        TextView textView = (TextView) findViewById.findViewById(R.id.txt_status);
        k.a((Object) textView, "statusView");
        textView.setText(str);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.txt_status_action);
        CharSequence charSequence = str2;
        if (!TextUtils.isEmpty(charSequence)) {
            k.a((Object) textView2, "statusActionView");
            textView2.setText(charSequence);
            textView2.setVisibility(0);
            textView2.setOnClickListener(onClickListener);
        } else {
            k.a((Object) textView2, "statusActionView");
            textView2.setVisibility(8);
        }
        return textView2;
    }

    public final View a(String str, String str2, View.OnClickListener onClickListener) {
        k.c(str, "status");
        return d(str, str2, onClickListener);
    }

    public static /* synthetic */ View b(CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3, String str) {
        k.c(str, "status");
        View d2 = cJRAmountInputFieldWidgetV3.d(str, (String) null, (View.OnClickListener) null);
        TextView textView = (TextView) cJRAmountInputFieldWidgetV3.findViewById(R.id.txt_status);
        textView.setTextColor(androidx.core.content.b.c(cJRAmountInputFieldWidgetV3.getContext(), R.color.v3_status_info_2));
        k.a((Object) textView, "statusView");
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        return d2;
    }

    public final View b(String str, String str2, View.OnClickListener onClickListener) {
        k.c(str, "status");
        return d(str, str2, onClickListener);
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList, ArrayList<o<String, String>> arrayList, boolean z) {
        if (!arrayList.isEmpty()) {
            ViewFlipper viewFlipper = this.f63943f;
            if (viewFlipper == null) {
                k.a();
            }
            View findViewById = viewFlipper.findViewById(R.id.lyt_info_secondary_plan_status_2);
            ViewFlipper viewFlipper2 = this.f63943f;
            if (viewFlipper2 != null) {
                if (viewFlipper2 == null) {
                    k.a();
                }
                viewFlipper2.setDisplayedChild(viewFlipper2.indexOfChild(findViewById));
            }
            View findViewById2 = findViewById.findViewById(R.id.img_tick_1);
            TextView textView = (TextView) findViewById.findViewById(R.id.txt_description_1);
            View findViewById3 = findViewById.findViewById(R.id.img_tick_2);
            TextView textView2 = (TextView) findViewById.findViewById(R.id.txt_description_2);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.ck_status_action_arrow);
            k.a((Object) textView, "txt_description_1");
            textView.setText(((String) arrayList.get(0).getFirst()) + ((String) arrayList.get(0).getSecond()));
            textView.setVisibility(0);
            k.a((Object) findViewById2, "img_tick_1");
            findViewById2.setVisibility(0);
            if (arrayList.size() >= 2) {
                k.a((Object) textView2, "txt_description_2");
                textView2.setText(((String) arrayList.get(1).getFirst()) + ((String) arrayList.get(1).getSecond()));
                textView2.setVisibility(0);
                k.a((Object) findViewById3, "img_tick_2");
                findViewById3.setVisibility(0);
            } else {
                k.a((Object) findViewById3, "img_tick_2");
                findViewById3.setVisibility(8);
                k.a((Object) textView2, "txt_description_2");
                textView2.setVisibility(8);
            }
            k.a((Object) findViewById, "displayedChild");
            findViewById.setTag(new o(cJRBrowsePlanProductList, arrayList));
            if (z) {
                k.a((Object) imageView, "downArrow");
                imageView.setVisibility(0);
                findViewById.setOnClickListener(this);
                return;
            }
            k.a((Object) imageView, "downArrow");
            imageView.setVisibility(8);
            return;
        }
        g();
        d(true);
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList, ArrayList<o<String, String>> arrayList) {
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDescription())) {
            ViewFlipper viewFlipper = this.f63943f;
            if (viewFlipper == null) {
                k.a();
            }
            View findViewById = viewFlipper.findViewById(R.id.lyt_info_secondary_plan_status_1);
            ViewFlipper viewFlipper2 = this.f63943f;
            if (viewFlipper2 != null) {
                if (viewFlipper2 == null) {
                    k.a();
                }
                viewFlipper2.setDisplayedChild(viewFlipper2.indexOfChild(findViewById));
            }
            TextView textView = (TextView) findViewById.findViewById(R.id.txt_status);
            k.a((Object) textView, "statusView");
            textView.setMaxLines(this.l);
            textView.setText(cJRBrowsePlanProductList.getParsedDescription());
            View findViewById2 = findViewById.findViewById(R.id.ck_status_action_arrow);
            k.a((Object) findViewById2, "checkBoxView");
            findViewById2.setSelected(false);
            findViewById2.setRotation(0.0f);
            View findViewById3 = findViewById.findViewById(R.id.lyt_status_action_arrow);
            k.a((Object) findViewById3, "arrowView");
            findViewById3.setVisibility(8);
            findViewById3.setOnClickListener((View.OnClickListener) null);
            k.a((Object) findViewById, "displayedChild");
            findViewById.setTag(new o(cJRBrowsePlanProductList, arrayList));
            findViewById.setOnClickListener((View.OnClickListener) null);
            getViewTreeObserver().addOnGlobalLayoutListener(new u(this.m, this));
            return;
        }
        g();
        d(true);
    }

    public final void a(CJRAggsItem cJRAggsItem, CJRProductsItem cJRProductsItem, View.OnClickListener onClickListener) {
        k.c(cJRAggsItem, "selectedProductType");
        k.c(cJRProductsItem, "selectedProduct");
        if (TextUtils.isEmpty(getInputText())) {
            g();
            d(true);
            return;
        }
        ViewFlipper viewFlipper = this.f63943f;
        if (viewFlipper == null) {
            k.a();
        }
        View findViewById = viewFlipper.findViewById(R.id.lyt_info_secondary_product_type);
        ViewFlipper viewFlipper2 = this.f63943f;
        if (viewFlipper2 != null) {
            if (viewFlipper2 == null) {
                k.a();
            }
            viewFlipper2.setDisplayedChild(viewFlipper2.indexOfChild(findViewById));
        }
        this.r = onClickListener;
        d(false);
        ViewFlipper viewFlipper3 = this.f63943f;
        if (viewFlipper3 != null) {
            viewFlipper3.setVisibility(0);
        }
        TextView textView = (TextView) findViewById.findViewById(R.id.txt_product_type_name);
        k.a((Object) textView, "productNameView");
        textView.setText(cJRProductsItem.getOperatorLabel() + ' ' + cJRAggsItem.getDisplayValue());
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.ck_status_action_arrow);
        e.a(imageView, androidx.core.content.b.b(getContext(), R.color.v3_action_active));
        k.a((Object) imageView, "checkBoxView");
        imageView.setSelected(false);
        imageView.setRotation(0.0f);
        k.a((Object) findViewById, "displayedChild");
        findViewById.setTag(cJRAggsItem);
        findViewById.setOnClickListener(this);
    }

    public final View c(String str, String str2, View.OnClickListener onClickListener) {
        k.c(str, "status");
        return d(str, str2, onClickListener);
    }

    public final void b(String str) {
        CJRRechargeEditText cJRRechargeEditText;
        View view = this.t;
        if (view == null || view.getVisibility() != 0) {
            ViewFlipper viewFlipper = this.f63943f;
            if (viewFlipper != null) {
                viewFlipper.setVisibility(8);
            }
        } else {
            ViewFlipper viewFlipper2 = this.f63943f;
            if (viewFlipper2 != null) {
                viewFlipper2.setVisibility(0);
            }
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            d(false);
        }
        super.b(str);
        if (str != null && !TextUtils.isEmpty(charSequence) && (cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input)) != null) {
            cJRRechargeEditText.requestFocus();
        }
    }

    public final void c() {
        super.c();
        ViewFlipper viewFlipper = this.f63943f;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(0);
        }
    }

    public final void c(String str) {
        ViewFlipper viewFlipper;
        k.c(str, "message");
        super.c(str);
        if (TextUtils.isEmpty(str) && (viewFlipper = this.f63943f) != null) {
            viewFlipper.setVisibility(8);
        }
    }

    public final void a(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3, StaticLayout staticLayout) {
        k.c(spannableStringBuilder, "message");
        k.c(str, "readMore");
        super.a(spannableStringBuilder, str, i2, i3, staticLayout);
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        View.OnClickListener onClickListener3;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.lyt_status_action_arrow;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.lyt_info_secondary_plan_status_1;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R.id.lyt_info_secondary_plan_status_2;
                if (valueOf != null && valueOf.intValue() == i4) {
                    ViewFlipper viewFlipper = this.f63943f;
                    if (viewFlipper == null) {
                        k.a();
                    }
                    View findViewById = viewFlipper.findViewById(R.id.lyt_info_secondary_plan_status_2);
                    View findViewById2 = findViewById.findViewById(R.id.ck_status_action_arrow);
                    k.a((Object) findViewById2, "checkBoxView");
                    findViewById2.setSelected(!findViewById2.isSelected());
                    if (this.f63944g != null && findViewById2.isSelected() && (onClickListener3 = this.f63944g) != null) {
                        onClickListener3.onClick(findViewById);
                        return;
                    }
                    return;
                }
                int i5 = R.id.lyt_info_secondary_product_type;
                if (valueOf != null && valueOf.intValue() == i5) {
                    ViewFlipper viewFlipper2 = this.f63943f;
                    if (viewFlipper2 == null) {
                        k.a();
                    }
                    View findViewById3 = viewFlipper2.findViewById(R.id.lyt_info_secondary_product_type);
                    View findViewById4 = findViewById3.findViewById(R.id.ck_status_action_arrow);
                    k.a((Object) findViewById4, "checkBoxView");
                    findViewById4.setSelected(!findViewById4.isSelected());
                    if (this.r != null && findViewById4.isSelected() && (onClickListener2 = this.r) != null) {
                        onClickListener2.onClick(findViewById3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ViewFlipper viewFlipper3 = this.f63943f;
        if (viewFlipper3 == null) {
            k.a();
        }
        View findViewById5 = viewFlipper3.findViewById(R.id.lyt_info_secondary_plan_status_1);
        TextView textView = (TextView) findViewById5.findViewById(R.id.txt_status);
        View findViewById6 = findViewById5.findViewById(R.id.ck_status_action_arrow);
        k.a((Object) findViewById6, "checkBoxView");
        findViewById6.setSelected(!findViewById6.isSelected());
        k.a((Object) textView, "statusView");
        textView.setSelected(!textView.isSelected());
        if (this.f63944g == null) {
            if (!findViewById6.isSelected() || !textView.isSelected()) {
                textView.setMaxLines(this.l);
            } else {
                textView.setMaxLines(Integer.MAX_VALUE);
            }
            findViewById6.animate().setDuration(375).rotationBy(180.0f).start();
        } else if ((findViewById6.isSelected() || textView.isSelected()) && (onClickListener = this.f63944g) != null) {
            onClickListener.onClick(findViewById5);
        }
    }

    public final void a(String str, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        View view;
        StaticLayout staticLayout;
        CharSequence charSequence;
        String str2 = str;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
        k.c(str2, "tag");
        k.c(onGlobalLayoutListener2, "layoutListener");
        if (k.a((Object) str2, (Object) this.m)) {
            ViewFlipper viewFlipper = this.f63943f;
            if (viewFlipper != null) {
                if (viewFlipper == null) {
                    k.a();
                }
                view = viewFlipper.getChildAt(viewFlipper.getDisplayedChild());
            } else {
                view = null;
            }
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i2 = R.id.lyt_info_secondary_plan_status_1;
            if (valueOf != null && valueOf.intValue() == i2) {
                getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener2);
                TextView textView = (TextView) view.findViewById(R.id.txt_status);
                View findViewById = view.findViewById(R.id.lyt_status_action_arrow);
                k.a((Object) textView, "statusView");
                int width = textView.getWidth();
                textView.onPreDraw();
                Layout layout = textView.getLayout();
                TextPaint paint = layout != null ? layout.getPaint() : null;
                if (paint == null) {
                    paint = new TextPaint();
                    paint.setTextSize(textView.getTextSize());
                    if (Build.VERSION.SDK_INT >= 21) {
                        paint.setLetterSpacing(textView.getLetterSpacing());
                    }
                    paint.setTypeface(textView.getTypeface());
                }
                TextPaint textPaint = paint;
                CharSequence text = textView.getText();
                k.a((Object) text, "statusView.text");
                p.g(text);
                if (width > 0) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        staticLayout = StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textPaint, width).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setEllipsize(TextUtils.TruncateAt.END).setText(textView.getText()).setBreakStrategy(1).build();
                    } else {
                        staticLayout = new StaticLayout(textView.getText(), textPaint, width, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), false);
                    }
                    k.a((Object) staticLayout, "if (Build.VERSION.SDK_IN…                        }");
                    int intValue = (staticLayout != null ? Integer.valueOf(staticLayout.getLineCount()) : null).intValue();
                    int i3 = this.l;
                    if (i3 < intValue) {
                        int lineVisibleEnd = staticLayout.getLineVisibleEnd(i3 - 1);
                        int lineStart = staticLayout.getLineStart(this.l - 1);
                        StringBuilder sb = new StringBuilder();
                        String obj = textView.getText().toString();
                        if (obj != null) {
                            String substring = obj.substring(lineStart, lineVisibleEnd);
                            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            int a2 = (lineStart + p.a((CharSequence) substring, ' ', p.d(substring))) - 1;
                            if (a2 >= 0) {
                                int i4 = 0;
                                while (true) {
                                    sb.append(obj.charAt(i4));
                                    if (i4 == a2) {
                                        break;
                                    }
                                    i4++;
                                }
                            }
                            String string = getContext().getString(R.string.v3_more_info_dots);
                            k.a((Object) string, "context.getString(R.string.v3_more_info_dots)");
                            String string2 = getContext().getString(R.string.v3_space_info_icon);
                            k.a((Object) string2, "context.getString(R.string.v3_space_info_icon)");
                            while (true) {
                                charSequence = sb;
                                if (p.b(charSequence).length() + string.length() + string2.length() < lineVisibleEnd || p.a(charSequence, ' ', p.d(charSequence)) <= 0) {
                                    sb.append(string);
                                    sb.append(string2);
                                    ImageSpan imageSpan = new ImageSpan(getContext(), R.drawable.v3_ic_info, 0);
                                    SpannableString spannableString = new SpannableString(charSequence);
                                    spannableString.setSpan(imageSpan, sb.length() - 2, sb.length() - 1, 0);
                                    textView.setText(spannableString);
                                    view.setOnClickListener(this);
                                    textView.setEllipsize(TextUtils.TruncateAt.END);
                                } else {
                                    sb.delete(p.a(charSequence, ' ', p.d(charSequence)), sb.length());
                                }
                            }
                            sb.append(string);
                            sb.append(string2);
                            ImageSpan imageSpan2 = new ImageSpan(getContext(), R.drawable.v3_ic_info, 0);
                            SpannableString spannableString2 = new SpannableString(charSequence);
                            spannableString2.setSpan(imageSpan2, sb.length() - 2, sb.length() - 1, 0);
                            textView.setText(spannableString2);
                            view.setOnClickListener(this);
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                    }
                    k.a((Object) findViewById, "arrowView");
                    findViewById.setVisibility(8);
                    findViewById.setOnClickListener((View.OnClickListener) null);
                    view.setOnClickListener((View.OnClickListener) null);
                    textView.setEllipsize((TextUtils.TruncateAt) null);
                    return;
                }
                k.a((Object) findViewById, "arrowView");
                findViewById.setVisibility(0);
                View.OnClickListener onClickListener = this;
                findViewById.setOnClickListener(onClickListener);
                view.setOnClickListener(onClickListener);
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }
}
