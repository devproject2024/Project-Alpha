package com.travel.train.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.activity.AJREmbedWebView;

public class FJRTrainTDRBottomSheetFragment extends am {

    /* renamed from: a  reason: collision with root package name */
    private View f26699a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26700b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26701c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26702d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f26703e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f26704f;

    /* renamed from: g  reason: collision with root package name */
    private String f26705g;

    /* renamed from: h  reason: collision with root package name */
    private String f26706h;

    /* renamed from: i  reason: collision with root package name */
    private String f26707i;

    public interface a {
        void b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f26699a = layoutInflater.inflate(R.layout.pre_t_tdr_bottom_sheet_lyt, viewGroup, false);
        View view = this.f26699a;
        this.f26700b = (TextView) view.findViewById(R.id.rules_header);
        this.f26701c = (TextView) view.findViewById(R.id.disclimer_txt);
        this.f26702d = (TextView) view.findViewById(R.id.refund_rules);
        this.f26704f = (ImageView) view.findViewById(R.id.detail_close);
        this.f26704f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FJRTrainTDRBottomSheetFragment.this.f26703e != null) {
                    FJRTrainTDRBottomSheetFragment.this.f26703e.b();
                }
            }
        });
        this.f26703e = (a) getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("tdr_disclimer_text")) {
                this.f26705g = arguments.getString("tdr_disclimer_text");
            }
            if (arguments.containsKey("tdr_header")) {
                this.f26706h = arguments.getString("tdr_header");
            }
            if (arguments.containsKey("tdr_submit_txt")) {
                this.f26707i = arguments.getString("tdr_submit_txt");
            }
        }
        if (!TextUtils.isEmpty(this.f26705g)) {
            this.f26701c.setText(Html.fromHtml(this.f26705g));
        }
        if (!TextUtils.isEmpty(this.f26705g)) {
            this.f26700b.setText(this.f26706h);
        }
        if (!TextUtils.isEmpty(this.f26705g)) {
            TextView textView = this.f26702d;
            Spanned fromHtml = Html.fromHtml(this.f26707i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (final URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
                int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
                int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        if (!TextUtils.isEmpty(uRLSpan.getURL())) {
                            FJRTrainTDRBottomSheetFragment.a(FJRTrainTDRBottomSheetFragment.this, uRLSpan.getURL());
                        }
                    }
                }, spanStart, spanEnd, spanFlags);
                spannableStringBuilder.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, spanFlags);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.deep_sky_blue)), spanStart, spanEnd, spanFlags);
                spannableStringBuilder.removeSpan(uRLSpan);
            }
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this.f26699a;
    }

    static class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String str) {
            super(str);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    static /* synthetic */ void a(FJRTrainTDRBottomSheetFragment fJRTrainTDRBottomSheetFragment, String str) {
        Intent intent = new Intent(fJRTrainTDRBottomSheetFragment.getActivity(), AJREmbedWebView.class);
        intent.putExtra("url", "http://drive.google.com/viewerng/viewer?embedded=true&url=".concat(String.valueOf(str)));
        fJRTrainTDRBottomSheetFragment.getActivity().startActivity(intent);
    }
}
