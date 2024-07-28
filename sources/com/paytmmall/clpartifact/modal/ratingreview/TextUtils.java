package com.paytmmall.clpartifact.modal.ratingreview;

import android.graphics.Color;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.b;
import com.paytmmall.clpartifact.R;

public class TextUtils {
    public static void makeTextViewResizable(TextView textView, int i2) {
        makeTextViewResizable(textView, i2, "View more..", true);
    }

    /* access modifiers changed from: private */
    public static void makeTextViewResizable(final TextView textView, final int i2, final String str, final boolean z) {
        if (textView.getTag() == null) {
            textView.setTag(textView.getText());
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int i2 = i2;
                if (i2 == 0) {
                    int lineEnd = textView.getLayout().getLineEnd(0);
                    textView.setText(textView.getText().subSequence(0, (lineEnd - str.length()) + 1) + " " + str);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView = textView;
                    textView.setText(TextUtils.addClickablePartTextViewResizable(Html.fromHtml(textView.getText().toString()), textView, i2, str, z), TextView.BufferType.SPANNABLE);
                } else if (i2 <= 0 || textView.getLineCount() < i2) {
                    int lineEnd2 = textView.getLayout().getLineEnd(textView.getLayout().getLineCount() - 1);
                    textView.setText(textView.getText().subSequence(0, lineEnd2) + " " + str);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView2 = textView;
                    textView2.setText(TextUtils.addClickablePartTextViewResizable(Html.fromHtml(textView2.getText().toString()), textView, lineEnd2, str, z), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEnd3 = textView.getLayout().getLineEnd(i2 - 1);
                    textView.setText(textView.getText().subSequence(0, (lineEnd3 - str.length()) + 1) + " " + str);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView3 = textView;
                    textView3.setText(TextUtils.addClickablePartTextViewResizable(Html.fromHtml(textView3.getText().toString()), textView, i2, str, z), TextView.BufferType.SPANNABLE);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static SpannableStringBuilder addClickablePartTextViewResizable(Spanned spanned, final TextView textView, int i2, String str, final boolean z) {
        String obj = spanned.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        if (obj.contains(str)) {
            spannableStringBuilder.setSpan(new MySpannable(false) {
                public final void onClick(View view) {
                    if (z) {
                        TextView textView = textView;
                        textView.setLayoutParams(textView.getLayoutParams());
                        TextView textView2 = textView;
                        textView2.setText(textView2.getTag().toString(), TextView.BufferType.SPANNABLE);
                        textView.invalidate();
                        TextUtils.makeTextViewResizable(textView, -1, "See Less", false);
                        return;
                    }
                    TextView textView3 = textView;
                    textView3.setLayoutParams(textView3.getLayoutParams());
                    TextView textView4 = textView;
                    textView4.setText(textView4.getTag().toString(), TextView.BufferType.SPANNABLE);
                    textView.invalidate();
                    TextUtils.makeTextViewResizable(textView, 3, ".. See More", true);
                }
            }, obj.indexOf(str), obj.indexOf(str) + str.length(), 0);
        }
        return spannableStringBuilder;
    }

    public static class MySpannable extends ClickableSpan {
        private boolean isUnderline = true;

        public void onClick(View view) {
        }

        public MySpannable(boolean z) {
            this.isUnderline = z;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(this.isUnderline);
            textPaint.setColor(Color.parseColor("#1b76d3"));
        }
    }

    public static void setBackGroundColor(Group group, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = R.drawable.clp_review_bg_red;
        } else if (i2 == 2) {
            i3 = R.drawable.clp_review_bg_orange;
        } else {
            i3 = R.drawable.clp_review_bg_green;
        }
        group.setBackground(b.a(group.getContext(), i3));
    }
}
