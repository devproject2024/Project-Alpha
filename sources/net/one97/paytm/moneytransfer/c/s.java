package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import net.one97.paytm.moneytransfer.R;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53835a;

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f53836b;

    private s(FrameLayout frameLayout, TextView textView) {
        this.f53836b = frameLayout;
        this.f53835a = textView;
    }

    public final FrameLayout a() {
        return this.f53836b;
    }

    public static s a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.mt_search_title_item_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.titleText);
        if (textView != null) {
            return new s((FrameLayout) inflate, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("titleText"));
    }
}
