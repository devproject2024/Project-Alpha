package net.one97.paytm.bankOpen.ica.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.bankOpen.R;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0232a f16438a = new C0232a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private List<? extends net.one97.paytm.bankOpen.ica.model.a> f16439b;

    public a(List<? extends net.one97.paytm.bankOpen.ica.model.a> list) {
        k.c(list, "statusFlowList");
        this.f16439b = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        net.one97.paytm.bankOpen.ica.model.a aVar = (net.one97.paytm.bankOpen.ica.model.a) this.f16439b.get(i2);
        if (bVar != null && !aVar.g()) {
            bVar.f16446g.setBackgroundResource(0);
        }
        if (bVar != null) {
            String a2 = aVar.a();
            k.a((Object) a2, "pbgStatusFlow.title");
            boolean i3 = aVar.i();
            k.c(a2, "mTitle");
            CharSequence charSequence = a2;
            if (!TextUtils.isEmpty(charSequence)) {
                bVar.f16441b.setText(charSequence);
                bVar.f16441b.setVisibility(0);
                bVar.a(bVar.f16441b, i3);
            } else {
                bVar.f16441b.setVisibility(8);
            }
            x.a aVar2 = new x.a();
            aVar2.element = false;
            bVar.f16444e.getViewTreeObserver().addOnGlobalLayoutListener(new b.C0233a(bVar, aVar2));
        }
        if (bVar != null) {
            String b2 = aVar.b();
            k.a((Object) b2, "pbgStatusFlow.desc");
            k.c(b2, "desc");
            CharSequence charSequence2 = b2;
            if (TextUtils.isEmpty(charSequence2)) {
                bVar.f16442c.setVisibility(8);
            } else {
                bVar.f16442c.setText(charSequence2);
                bVar.f16442c.setVisibility(0);
            }
        }
        if (bVar != null) {
            String e2 = aVar.e();
            k.a((Object) e2, "pbgStatusFlow.date");
            boolean h2 = aVar.h();
            k.c(e2, "mDate");
            CharSequence charSequence3 = e2;
            if (TextUtils.isEmpty(charSequence3)) {
                bVar.f16440a.setText("");
                bVar.f16440a.setVisibility(4);
            } else {
                bVar.f16440a.setText(charSequence3);
                bVar.a(bVar.f16440a, h2);
                bVar.f16440a.setVisibility(0);
            }
        }
        if (bVar != null) {
            int c2 = aVar.c();
            int d2 = aVar.d();
            int f2 = aVar.f();
            b.a(bVar.f16443d, c2);
            b.a(bVar.f16444e, d2);
            if (f2 == 101) {
                bVar.f16445f.setImageDrawable(androidx.core.content.b.a(bVar.f16445f.getContext(), R.drawable.pb_ic_failed_small));
            } else if (f2 == 102) {
                bVar.f16445f.setImageDrawable(androidx.core.content.b.a(bVar.f16445f.getContext(), R.drawable.pb_ic_pending_small));
            } else if (f2 == 100) {
                bVar.f16445f.setImageDrawable(androidx.core.content.b.a(bVar.f16445f.getContext(), R.drawable.pb_cbt_green_oval_white_border));
            } else if (f2 == 103) {
                bVar.f16445f.setImageDrawable(androidx.core.content.b.a(bVar.f16445f.getContext(), R.drawable.pb_ic_marker_grey));
            } else if (f2 == 104) {
                bVar.f16445f.setImageDrawable(androidx.core.content.b.a(bVar.f16445f.getContext(), R.drawable.pb_green_tick_icon));
            }
        }
        if (i2 == 0) {
            bVar.f16443d.setVisibility(4);
        } else {
            bVar.f16443d.setVisibility(0);
        }
        if (i2 == getItemCount() - 1) {
            bVar.f16444e.setVisibility(4);
        } else {
            bVar.f16444e.setVisibility(0);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        View inflate = from != null ? from.inflate(R.layout.pb_ca_track_details_item, viewGroup, false) : null;
        Context context = viewGroup.getContext();
        k.a((Object) context, "parent.context");
        return new b(inflate, context);
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.a.a$a  reason: collision with other inner class name */
    public static final class C0232a {
        private C0232a() {
        }

        public /* synthetic */ C0232a(byte b2) {
            this();
        }
    }

    public final int getItemCount() {
        List<? extends net.one97.paytm.bankOpen.ica.model.a> list = this.f16439b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static final class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final TextView f16440a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f16441b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f16442c;

        /* renamed from: d  reason: collision with root package name */
        final View f16443d;

        /* renamed from: e  reason: collision with root package name */
        final View f16444e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f16445f;

        /* renamed from: g  reason: collision with root package name */
        LinearLayout f16446g;

        public final void onClick(View view) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, Context context) {
            super(view);
            k.c(context, "context");
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.cbt_date);
            if (textView != null) {
                this.f16440a = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_status_message);
                if (textView2 != null) {
                    this.f16441b = textView2;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_required_info);
                    if (textView3 != null) {
                        this.f16442c = textView3;
                        View findViewById = view.findViewById(R.id.upperLine);
                        if (findViewById != null) {
                            this.f16443d = findViewById;
                            View findViewById2 = view.findViewById(R.id.lowerLine);
                            if (findViewById2 != null) {
                                this.f16444e = findViewById2;
                                ImageView imageView = (ImageView) view.findViewById(R.id.circleIv);
                                if (imageView != null) {
                                    this.f16445f = imageView;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_popup_cont);
                                    if (linearLayout != null) {
                                        this.f16446g = linearLayout;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            throw new u("null cannot be cast to non-null type android.view.View");
                        }
                        throw new u("null cannot be cast to non-null type android.view.View");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        /* access modifiers changed from: package-private */
        public final void a(TextView textView, boolean z) {
            if (z) {
                textView.setTypeface(this.f16440a.getTypeface(), 1);
            } else {
                textView.setTypeface(this.f16440a.getTypeface(), 0);
            }
        }

        static void a(View view, int i2) {
            if (i2 == 104) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            if (i2 == 100) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), net.one97.paytm.common.assets.R.color.color_21c17a));
            } else if (i2 == 101) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.gray));
            } else if (i2 == 102) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.red));
            } else if (i2 == 103) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.grid_percentage_orange));
            }
        }

        /* renamed from: net.one97.paytm.bankOpen.ica.a.a$b$a  reason: collision with other inner class name */
        static final class C0233a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f16447a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.a f16448b;

            C0233a(b bVar, x.a aVar) {
                this.f16447a = bVar;
                this.f16448b = aVar;
            }

            public final void onGlobalLayout() {
                if (!this.f16448b.element) {
                    this.f16448b.element = true;
                    ViewGroup.LayoutParams layoutParams = this.f16447a.f16444e.getLayoutParams();
                    View view = this.f16447a.itemView;
                    k.a((Object) view, "itemView");
                    layoutParams.height = view.getHeight() - 20;
                    this.f16447a.f16444e.setLayoutParams(layoutParams);
                }
            }
        }
    }
}
