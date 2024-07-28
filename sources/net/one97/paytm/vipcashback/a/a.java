package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.vipcashback.e.b;
import net.one97.paytm.vipcashback.f.d;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    final Context f20535a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f20536b = true;

    /* renamed from: h  reason: collision with root package name */
    private final LayoutInflater f20537h = LayoutInflater.from(this.f20535a);

    /* renamed from: i  reason: collision with root package name */
    private final int f20538i;
    private final b j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, b bVar, RecyclerView recyclerView) {
        super(recyclerView);
        k.c(context, "context");
        k.c(bVar, "mPresenter");
        k.c(recyclerView, "list");
        this.f20535a = context;
        this.j = bVar;
    }

    public final int a() {
        return this.j.f20836a.size();
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        if (i2 <= this.j.f20836a.size()) {
            return this.f20538i;
        }
        return 0;
    }

    public final void a(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        C0375a aVar = (C0375a) vVar;
        if (this.f20536b) {
            View view = aVar.itemView;
            k.a((Object) view, "vh.itemView");
            view.setLayoutParams(new FrameLayout.LayoutParams(this.f20535a.getResources().getDimensionPixelSize(R.dimen.dimen_320dp), -2));
            net.one97.paytm.vipcashback.f.b.b(aVar.f20539a);
            net.one97.paytm.vipcashback.f.b.b(aVar.f20540b);
        } else {
            View view2 = aVar.itemView;
            k.a((Object) view2, "vh.itemView");
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            net.one97.paytm.vipcashback.f.b.a(aVar.f20539a);
            net.one97.paytm.vipcashback.f.b.a(aVar.f20540b);
        }
        aVar.f20541c.setBackground(androidx.core.content.b.a(this.f20535a, net.one97.paytm.vipcashback.R.drawable.cashback_default_background));
        b bVar = this.j;
        net.one97.paytm.vipcashback.view.b bVar2 = (net.one97.paytm.vipcashback.view.b) vVar;
        k.c(bVar2, "rowView");
        CashBackNewOfferModal cashBackNewOfferModal = bVar.f20836a.get(i2);
        k.a((Object) cashBackNewOfferModal, "newOffersList.get(position)");
        CashBackNewOfferModal cashBackNewOfferModal2 = cashBackNewOfferModal;
        bVar2.d();
        b.a(cashBackNewOfferModal2, bVar2);
        b.b(cashBackNewOfferModal2, bVar2);
        String shortDescription = cashBackNewOfferModal2 != null ? cashBackNewOfferModal2.getShortDescription() : null;
        k.a((Object) shortDescription, "offer?.shortDescription");
        bVar2.b(shortDescription);
        String backgroundImageUrl = cashBackNewOfferModal2.getBackgroundImageUrl();
        Boolean backgroundOverlay = cashBackNewOfferModal2.getBackgroundOverlay();
        k.a((Object) backgroundOverlay, "offer.backgroundOverlay");
        bVar2.b(backgroundImageUrl, backgroundOverlay.booleanValue());
        bVar2.a((View.OnClickListener) new b.C0396b(bVar, cashBackNewOfferModal2, bVar2));
        bVar2.b((View.OnClickListener) new b.c(bVar, cashBackNewOfferModal2, bVar2));
        bVar2.a((IJRPaytmDataModel) cashBackNewOfferModal2);
    }

    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = this.f20537h.inflate(net.one97.paytm.vipcashback.R.layout.cashback_new_offer_card_layoutv2, (ViewGroup) null, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…rd_layoutv2, null, false)");
        return new C0375a(this, inflate);
    }

    /* renamed from: net.one97.paytm.vipcashback.a.a$a  reason: collision with other inner class name */
    public final class C0375a extends RecyclerView.v implements net.one97.paytm.vipcashback.view.b {

        /* renamed from: a  reason: collision with root package name */
        TextView f20539a;

        /* renamed from: b  reason: collision with root package name */
        TextView f20540b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f20541c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f20542d;

        /* renamed from: e  reason: collision with root package name */
        private CircularImageView f20543e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f20544f;

        /* renamed from: g  reason: collision with root package name */
        private LottieAnimationView f20545g;

        /* renamed from: h  reason: collision with root package name */
        private View f20546h;

        /* renamed from: i  reason: collision with root package name */
        private RelativeLayout f20547i;
        private LottieAnimationView j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0375a(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20542d = aVar;
            View findViewById = view.findViewById(net.one97.paytm.vipcashback.R.id.offer_type_iv);
            if (findViewById != null) {
                this.f20543e = (CircularImageView) findViewById;
                View findViewById2 = view.findViewById(net.one97.paytm.vipcashback.R.id.cashback_offer_txt);
                if (findViewById2 != null) {
                    this.f20539a = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(net.one97.paytm.vipcashback.R.id.offer_desc);
                    if (findViewById3 != null) {
                        this.f20540b = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(net.one97.paytm.vipcashback.R.id.activate_offer);
                        if (findViewById4 != null) {
                            this.f20544f = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(net.one97.paytm.vipcashback.R.id.activateLoader);
                            if (findViewById5 != null) {
                                this.f20545g = (LottieAnimationView) findViewById5;
                                View findViewById6 = view.findViewById(net.one97.paytm.vipcashback.R.id.new_offer_card);
                                k.a((Object) findViewById6, "itemView.findViewById<View>(R.id.new_offer_card)");
                                this.f20546h = findViewById6;
                                View findViewById7 = view.findViewById(net.one97.paytm.vipcashback.R.id.rl_activated_offer);
                                if (findViewById7 != null) {
                                    this.f20547i = (RelativeLayout) findViewById7;
                                    View findViewById8 = view.findViewById(net.one97.paytm.vipcashback.R.id.activate_loader_sparcle);
                                    if (findViewById8 != null) {
                                        this.j = (LottieAnimationView) findViewById8;
                                        View findViewById9 = view.findViewById(net.one97.paytm.vipcashback.R.id.offer_rl);
                                        k.a((Object) findViewById9, "itemView.findViewById<Re…iveLayout>(R.id.offer_rl)");
                                        this.f20541c = (RelativeLayout) findViewById9;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                            }
                            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.widgets.CircularImageView");
        }

        public final void a(String str) {
            k.c(str, "msg");
            this.f20539a.setText(str);
        }

        public final void a(String str, boolean z) {
            d.a aVar = d.f20859a;
            d.a.a(this.f20542d.f20535a, this.f20543e, z, str);
        }

        public final void b(String str, boolean z) {
            d.a aVar = d.f20859a;
            d.a.a(this.f20542d.f20535a, str, (View) this.f20541c, z, net.one97.paytm.vipcashback.R.dimen.cashback_new_offer_list_item_height, this.f20542d.f20536b);
        }

        public final void b(String str) {
            k.c(str, "offerSubMsg");
            this.f20540b.setText(str);
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "offer");
            View view = this.itemView;
            k.a((Object) view, "itemView");
            view.setTag(iJRPaytmDataModel);
        }

        public final void a(View.OnClickListener onClickListener) {
            k.c(onClickListener, "onClickListener");
            this.f20546h.setOnClickListener(onClickListener);
        }

        public final void b(View.OnClickListener onClickListener) {
            k.c(onClickListener, "onClickListener");
            this.f20544f.setOnClickListener(onClickListener);
        }

        public final void a() {
            this.f20544f.setVisibility(4);
            net.one97.paytm.common.widgets.a.a(this.f20545g);
        }

        public final void b() {
            net.one97.paytm.common.widgets.a.b(this.f20545g);
            this.f20544f.setVisibility(0);
        }

        public final void c() {
            this.f20547i.setVisibility(0);
            d.a aVar = d.f20859a;
            LottieAnimationView lottieAnimationView = this.j;
            k.c(lottieAnimationView, "view");
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("activate_btn_sparcle_small.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
            this.f20544f.setVisibility(4);
        }

        public final void d() {
            this.f20547i.setVisibility(8);
            d.a aVar = d.f20859a;
            d.a.a(this.j);
            this.j.setVisibility(4);
            this.f20544f.setVisibility(0);
        }

        public final View e() {
            View view = this.itemView;
            k.a((Object) view, "itemView");
            return view;
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            if (networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 404) {
                com.paytm.utility.b.b(this.f20542d.f20535a, "", networkCustomError.getAlertMessage());
                return;
            }
            d.a aVar = d.f20859a;
            Context context = this.f20542d.f20535a;
            if (context != null) {
                d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) context, (Boolean) null, 12);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }
}
