package net.one97.paytm.recharge.metro.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.metro.c.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;

public final class f extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f63470a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63471b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63472c;

    /* renamed from: d  reason: collision with root package name */
    TextView f63473d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63474e;

    /* renamed from: f  reason: collision with root package name */
    public View f63475f;

    /* renamed from: g  reason: collision with root package name */
    public View f63476g;

    /* renamed from: h  reason: collision with root package name */
    ImageView f63477h;

    /* renamed from: i  reason: collision with root package name */
    final c.a f63478i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view, c.a aVar) {
        super(view);
        k.c(view, "view");
        k.c(aVar, "listener");
        this.f63478i = aVar;
        this.f63471b = (TextView) view.findViewById(R.id.metro_recent_start_tv);
        this.f63472c = (TextView) view.findViewById(R.id.metro_recent_end_tv);
        this.f63473d = (TextView) view.findViewById(R.id.alt_metro_recent_end_tv);
        this.f63474e = (TextView) view.findViewById(R.id.journey_type_tv);
        this.f63475f = view.findViewById(R.id.recent_item_parent_lyt);
        this.f63476g = view.findViewById(R.id.row_divider);
        View findViewById = view.findViewById(R.id.middle_arrow_iv);
        k.a((Object) findViewById, "view.findViewById(R.id.middle_arrow_iv)");
        this.f63477h = (ImageView) findViewById;
        View view2 = this.itemView;
        this.f63470a = view2 != null ? view2.getContext() : null;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63479a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMetroQRFrequentOrder f63480b;

        public a(f fVar, CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
            this.f63479a = fVar;
            this.f63480b = cJRMetroQRFrequentOrder;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            r3 = r3.getResources();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
                r6 = this;
                net.one97.paytm.recharge.metro.d.f r7 = r6.f63479a
                android.content.Context r7 = r7.f63470a
                if (r7 == 0) goto L_0x004a
                net.one97.paytm.recharge.metro.d.f r7 = r6.f63479a
                android.content.Context r7 = r7.f63470a
                boolean r7 = com.paytm.utility.b.c((android.content.Context) r7)
                if (r7 != 0) goto L_0x0041
                net.one97.paytm.recharge.metro.d.f r7 = r6.f63479a
                net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
                android.content.Context r0 = r7.f63470a
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.RECENT_CLICK
                android.content.Context r3 = r7.f63470a
                r4 = 0
                if (r3 == 0) goto L_0x002c
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x002c
                int r5 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r3 = r3.getString(r5)
                goto L_0x002d
            L_0x002c:
                r3 = r4
            L_0x002d:
                android.content.Context r7 = r7.f63470a
                if (r7 == 0) goto L_0x003d
                android.content.res.Resources r7 = r7.getResources()
                if (r7 == 0) goto L_0x003d
                int r4 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r4 = r7.getString(r4)
            L_0x003d:
                net.one97.paytm.recharge.common.utils.az.a(r0, r1, r2, r3, r4)
                return
            L_0x0041:
                net.one97.paytm.recharge.metro.d.f r7 = r6.f63479a
                net.one97.paytm.recharge.metro.c.c$a r7 = r7.f63478i
                net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r0 = r6.f63480b
                r7.a(r0)
            L_0x004a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.f.a.onClick(android.view.View):void");
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63481a;

        public b(f fVar) {
            this.f63481a = fVar;
        }

        public final void onGlobalLayout() {
            TextView textView = this.f63481a.f63472c;
            CharSequence charSequence = null;
            ViewTreeObserver viewTreeObserver = textView != null ? textView.getViewTreeObserver() : null;
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            TextView textView2 = this.f63481a.f63472c;
            Context context = textView2 != null ? textView2.getContext() : null;
            if (context != null) {
                int a2 = com.paytm.utility.b.a((Activity) context);
                TextView textView3 = this.f63481a.f63472c;
                if (textView3 == null) {
                    return;
                }
                if (textView3.getRight() > a2 - 10) {
                    TextView textView4 = this.f63481a.f63471b;
                    if (textView4 != null) {
                        ai.a(textView4);
                    }
                    ImageView imageView = this.f63481a.f63477h;
                    if (imageView != null) {
                        ai.a(imageView);
                    }
                    TextView textView5 = this.f63481a.f63473d;
                    if (textView5 != null) {
                        TextView textView6 = this.f63481a.f63472c;
                        if (textView6 != null) {
                            charSequence = textView6.getText();
                        }
                        textView5.setText(charSequence);
                    }
                    TextView textView7 = this.f63481a.f63472c;
                    if (textView7 != null) {
                        ai.b(textView7);
                    }
                    TextView textView8 = this.f63481a.f63473d;
                    if (textView8 != null) {
                        ai.a(textView8);
                        return;
                    }
                    return;
                }
                TextView textView9 = this.f63481a.f63471b;
                if (textView9 != null) {
                    ai.a(textView9);
                }
                ImageView imageView2 = this.f63481a.f63477h;
                if (imageView2 != null) {
                    ai.a(imageView2);
                }
                TextView textView10 = this.f63481a.f63472c;
                if (textView10 != null) {
                    ai.a(textView10);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }
}
