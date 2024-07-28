package net.one97.paytm.paymentsBank.chequebook.trackingflow.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.a.a;

public final class a extends RecyclerView.a<C0291a> {

    /* renamed from: a  reason: collision with root package name */
    private final a.C0290a f17928a;

    /* renamed from: b  reason: collision with root package name */
    private final CBTLandingView f17929b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0291a aVar = (C0291a) vVar;
        k.c(aVar, "holder");
        this.f17928a.a(aVar, i2);
        if (i2 == 0) {
            aVar.f17934e.setVisibility(4);
        } else {
            aVar.f17934e.setVisibility(0);
        }
        if (i2 == getItemCount() - 1) {
            aVar.f17935f.setVisibility(4);
        } else {
            aVar.f17935f.setVisibility(0);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return new C0291a(from != null ? from.inflate(R.layout.cb_tracking_details_item, viewGroup, false) : null, this.f17929b, this.f17928a);
    }

    public a(a.C0290a aVar, CBTLandingView cBTLandingView) {
        k.c(aVar, "presenter");
        k.c(cBTLandingView, "context");
        this.f17928a = aVar;
        this.f17929b = cBTLandingView;
    }

    public final int getItemCount() {
        return this.f17928a.d();
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.trackingflow.view.a$a  reason: collision with other inner class name */
    public static final class C0291a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f17930a;

        /* renamed from: b  reason: collision with root package name */
        public final Button f17931b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f17932c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f17933d;

        /* renamed from: e  reason: collision with root package name */
        public final View f17934e;

        /* renamed from: f  reason: collision with root package name */
        public final View f17935f;

        /* renamed from: g  reason: collision with root package name */
        public final ImageView f17936g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f17937h;

        /* renamed from: i  reason: collision with root package name */
        private final a.C0290a f17938i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0291a(View view, Context context, a.C0290a aVar) {
            super(view);
            k.c(context, "context");
            k.c(aVar, "presenter");
            if (view == null) {
                k.a();
            }
            this.f17938i = aVar;
            TextView textView = (TextView) view.findViewById(R.id.cbt_date);
            if (textView != null) {
                this.f17930a = textView;
                Button button = (Button) view.findViewById(R.id.bt_upload_your_signaturee);
                if (button != null) {
                    this.f17931b = button;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_status_message);
                    if (textView2 != null) {
                        this.f17932c = textView2;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_required_info);
                        if (textView3 != null) {
                            this.f17933d = textView3;
                            View findViewById = view.findViewById(R.id.upperLine);
                            if (findViewById != null) {
                                this.f17934e = findViewById;
                                View findViewById2 = view.findViewById(R.id.lowerLine);
                                if (findViewById2 != null) {
                                    this.f17935f = findViewById2;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.circleIv);
                                    if (imageView != null) {
                                        this.f17936g = imageView;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_popup_cont);
                                        if (linearLayout != null) {
                                            this.f17937h = linearLayout;
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
                throw new u("null cannot be cast to non-null type android.widget.Button");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        public final void a(TextView textView, boolean z) {
            if (z) {
                textView.setTypeface(this.f17930a.getTypeface(), 1);
            } else {
                textView.setTypeface(this.f17930a.getTypeface(), 0);
            }
        }

        public static void a(View view, int i2) {
            if (i2 == 104) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            if (i2 == 100) {
                view.setBackgroundColor(b.c(view.getContext(), net.one97.paytm.common.assets.R.color.color_21c17a));
            } else if (i2 == 101) {
                view.setBackgroundColor(b.c(view.getContext(), R.color.color_ebebeb));
            } else if (i2 == 102) {
                view.setBackgroundColor(b.c(view.getContext(), R.color.red));
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.trackingflow.view.a$a$a  reason: collision with other inner class name */
        public static final class C0292a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0291a f17939a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.a f17940b;

            public C0292a(C0291a aVar, x.a aVar2) {
                this.f17939a = aVar;
                this.f17940b = aVar2;
            }

            public final void onGlobalLayout() {
                if (!this.f17940b.element) {
                    this.f17940b.element = true;
                    ViewGroup.LayoutParams layoutParams = this.f17939a.f17935f.getLayoutParams();
                    View view = this.f17939a.itemView;
                    k.a((Object) view, "itemView");
                    layoutParams.height = view.getHeight() - 20;
                    this.f17939a.f17935f.setLayoutParams(layoutParams);
                }
            }
        }

        public final void onClick(View view) {
            a.C0290a aVar = this.f17938i;
            if (view == null) {
                k.a();
            }
            Object tag = view.getTag();
            if (tag != null) {
                aVar.a(((Integer) tag).intValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }
}
