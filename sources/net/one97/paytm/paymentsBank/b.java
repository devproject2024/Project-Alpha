package net.one97.paytm.paymentsBank;

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
import net.one97.paytm.common.assets.R;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<? extends a> f17422a;

    public b(List<? extends a> list) {
        k.c(list, "statusFlowList");
        this.f17422a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        a aVar2 = (a) this.f17422a.get(i2);
        if (aVar != null) {
            if (!aVar2.g()) {
                aVar.f17429g.setBackgroundResource(0);
            } else {
                aVar.f17429g.setBackgroundResource(R.drawable.rectangle_nine_patch);
            }
        }
        if (aVar != null) {
            String a2 = aVar2.a();
            k.a((Object) a2, "pbgStatusFlow.title");
            boolean i3 = aVar2.i();
            k.c(a2, "mTitle");
            CharSequence charSequence = a2;
            if (!TextUtils.isEmpty(charSequence)) {
                aVar.f17424b.setText(charSequence);
                aVar.f17424b.setVisibility(0);
                aVar.a(aVar.f17424b, i3);
            } else {
                aVar.f17424b.setVisibility(8);
            }
            x.a aVar3 = new x.a();
            aVar3.element = false;
            aVar.f17427e.getViewTreeObserver().addOnGlobalLayoutListener(new a.C0264a(aVar, aVar3));
        }
        if (aVar != null) {
            String b2 = aVar2.b();
            k.a((Object) b2, "pbgStatusFlow.desc");
            k.c(b2, "desc");
            CharSequence charSequence2 = b2;
            if (TextUtils.isEmpty(charSequence2)) {
                aVar.f17425c.setVisibility(8);
            } else {
                aVar.f17425c.setText(charSequence2);
                aVar.f17425c.setVisibility(0);
            }
        }
        if (aVar != null) {
            String e2 = aVar2.e();
            k.a((Object) e2, "pbgStatusFlow.date");
            boolean h2 = aVar2.h();
            k.c(e2, "mDate");
            CharSequence charSequence3 = e2;
            if (TextUtils.isEmpty(charSequence3)) {
                aVar.f17423a.setText("");
                aVar.f17423a.setVisibility(4);
            } else {
                aVar.f17423a.setText(charSequence3);
                aVar.a(aVar.f17423a, h2);
                aVar.f17423a.setVisibility(0);
            }
        }
        if (aVar != null) {
            int c2 = aVar2.c();
            int d2 = aVar2.d();
            int f2 = aVar2.f();
            a.a(aVar.f17426d, c2);
            a.a(aVar.f17427e, d2);
            if (f2 == 101) {
                aVar.f17428f.setImageDrawable(androidx.core.content.b.a(aVar.f17428f.getContext(), R.drawable.pb_ic_failed_small));
            } else if (f2 == 102) {
                aVar.f17428f.setImageDrawable(androidx.core.content.b.a(aVar.f17428f.getContext(), R.drawable.pb_ic_pending_small));
            } else if (f2 == 100) {
                aVar.f17428f.setImageDrawable(androidx.core.content.b.a(aVar.f17428f.getContext(), R.drawable.pb_cbt_green_oval_white_border));
            } else if (f2 == 103) {
                aVar.f17428f.setImageDrawable(androidx.core.content.b.a(aVar.f17428f.getContext(), R.drawable.pb_ic_marker_grey));
            }
        }
        if (i2 == 0) {
            aVar.f17426d.setVisibility(4);
        } else {
            aVar.f17426d.setVisibility(0);
        }
        if (i2 == getItemCount() - 1) {
            aVar.f17427e.setVisibility(4);
        } else {
            aVar.f17427e.setVisibility(0);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        View inflate = from != null ? from.inflate(R.layout.pb_generic_tracking_details_item, viewGroup, false) : null;
        Context context = viewGroup.getContext();
        k.a((Object) context, "parent.context");
        return new a(inflate, context);
    }

    public final int getItemCount() {
        List<? extends a> list = this.f17422a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static final class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17423a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f17424b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f17425c;

        /* renamed from: d  reason: collision with root package name */
        final View f17426d;

        /* renamed from: e  reason: collision with root package name */
        final View f17427e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f17428f;

        /* renamed from: g  reason: collision with root package name */
        LinearLayout f17429g;

        public final void onClick(View view) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, Context context) {
            super(view);
            k.c(context, "context");
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.cbt_date);
            if (textView != null) {
                this.f17423a = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_status_message);
                if (textView2 != null) {
                    this.f17424b = textView2;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_required_info);
                    if (textView3 != null) {
                        this.f17425c = textView3;
                        View findViewById = view.findViewById(R.id.upperLine);
                        if (findViewById != null) {
                            this.f17426d = findViewById;
                            View findViewById2 = view.findViewById(R.id.lowerLine);
                            if (findViewById2 != null) {
                                this.f17427e = findViewById2;
                                ImageView imageView = (ImageView) view.findViewById(R.id.circleIv);
                                if (imageView != null) {
                                    this.f17428f = imageView;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_popup_cont);
                                    if (linearLayout != null) {
                                        this.f17429g = linearLayout;
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
                textView.setTypeface(this.f17423a.getTypeface(), 1);
            } else {
                textView.setTypeface(this.f17423a.getTypeface(), 0);
            }
        }

        static void a(View view, int i2) {
            if (i2 == 104) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            if (i2 == 100) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.color_21c17a));
            } else if (i2 == 101) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.gray));
            } else if (i2 == 102) {
                view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.red));
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.b$a$a  reason: collision with other inner class name */
        static final class C0264a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f17430a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.a f17431b;

            C0264a(a aVar, x.a aVar2) {
                this.f17430a = aVar;
                this.f17431b = aVar2;
            }

            public final void onGlobalLayout() {
                if (!this.f17431b.element) {
                    this.f17431b.element = true;
                    ViewGroup.LayoutParams layoutParams = this.f17430a.f17427e.getLayoutParams();
                    View view = this.f17430a.itemView;
                    k.a((Object) view, "itemView");
                    layoutParams.height = view.getHeight() - 20;
                    this.f17430a.f17427e.setLayoutParams(layoutParams);
                }
            }
        }
    }
}
