package com.google.zxing.client.android.book;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import java.util.Locale;

public final class SearchBookContentsListItem extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f40154a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f40155b;

    SearchBookContentsListItem(Context context) {
        super(context);
    }

    public SearchBookContentsListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f40154a = (TextView) findViewById(R.id.page_number_view);
        this.f40155b = (TextView) findViewById(R.id.snippet_view);
    }

    public final void set(c cVar) {
        this.f40154a.setText(cVar.f40160b);
        String str = cVar.f40161c;
        if (str.isEmpty()) {
            this.f40155b.setText("");
        } else if (cVar.f40162d) {
            String lowerCase = c.a().toLowerCase(Locale.getDefault());
            String lowerCase2 = str.toLowerCase(Locale.getDefault());
            SpannableString spannableString = new SpannableString(str);
            StyleSpan styleSpan = new StyleSpan(1);
            int length = lowerCase.length();
            int i2 = 0;
            while (true) {
                int indexOf = lowerCase2.indexOf(lowerCase, i2);
                if (indexOf >= 0) {
                    int i3 = indexOf + length;
                    spannableString.setSpan(styleSpan, indexOf, i3, 0);
                    i2 = i3;
                } else {
                    this.f40155b.setText(spannableString);
                    return;
                }
            }
        } else {
            this.f40155b.setText(str);
        }
    }
}
