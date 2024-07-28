package net.one97.paytm.o2o.movies.moviepass.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.g.b.k;

public final class CJRMoviePassOderSummaryHeaderView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f75619a;

    /* renamed from: b  reason: collision with root package name */
    public Context f75620b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f75621c;

    /* renamed from: d  reason: collision with root package name */
    public String f75622d;

    /* renamed from: e  reason: collision with root package name */
    public String f75623e;

    /* renamed from: f  reason: collision with root package name */
    public String f75624f;

    /* renamed from: g  reason: collision with root package name */
    private View.OnClickListener f75625g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f75626h;

    public final View a(int i2) {
        if (this.f75626h == null) {
            this.f75626h = new HashMap();
        }
        View view = (View) this.f75626h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f75626h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Context getMContext() {
        return this.f75620b;
    }

    public final void setMContext(Context context) {
        k.c(context, "<set-?>");
        this.f75620b = context;
    }

    public final LinearLayout getMParentView() {
        return this.f75621c;
    }

    public final void setMParentView(LinearLayout linearLayout) {
        this.f75621c = linearLayout;
    }

    public final String getMStatus() {
        return this.f75622d;
    }

    public final void setMStatus(String str) {
        k.c(str, "<set-?>");
        this.f75622d = str;
    }

    public final String getHeading() {
        return this.f75623e;
    }

    public final void setHeading(String str) {
        this.f75623e = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMoviePassOderSummaryHeaderView(Context context, LinearLayout linearLayout, String str, String str2, String str3, View.OnClickListener onClickListener) {
        super(context);
        k.c(context, "mContext");
        k.c(str, "mStatus");
        k.c(onClickListener, "mClickListener");
        this.f75620b = context;
        this.f75621c = linearLayout;
        this.f75622d = str;
        this.f75623e = str2;
        this.f75624f = str3;
        this.f75625g = onClickListener;
    }

    public final View.OnClickListener getMClickListener() {
        return this.f75625g;
    }

    public final void setMClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "<set-?>");
        this.f75625g = onClickListener;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviePassOderSummaryHeaderView f75627a;

        public a(CJRMoviePassOderSummaryHeaderView cJRMoviePassOderSummaryHeaderView) {
            this.f75627a = cJRMoviePassOderSummaryHeaderView;
        }

        public final void onClick(View view) {
            this.f75627a.getMClickListener().onClick(view);
        }
    }
}
