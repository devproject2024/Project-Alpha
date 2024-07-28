package net.one97.paytm.coins.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.coins.customview.SlideButton;
import net.one97.paytm.coins.model.Attributes;
import net.one97.paytm.coins.model.Reward;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Reward> f16651a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    Context f16652b;

    /* renamed from: c  reason: collision with root package name */
    C0246b f16653c;

    /* renamed from: d  reason: collision with root package name */
    public double f16654d;

    /* renamed from: e  reason: collision with root package name */
    int f16655e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16656f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16657g = 1;

    /* renamed from: h  reason: collision with root package name */
    private LayoutInflater f16658h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16659i;

    /* renamed from: net.one97.paytm.coins.a.b$b  reason: collision with other inner class name */
    public interface C0246b {
        void a();

        void a(int i2, Reward reward);

        void a(int i2, Reward reward, SlideButton slideButton);

        void a(Reward reward);

        void a(boolean z, View view);

        void c();
    }

    public b(Context context, C0246b bVar, double d2, int i2) {
        k.c(context, "context");
        k.c(bVar, "listener");
        this.f16652b = context;
        this.f16653c = bVar;
        this.f16654d = d2;
        this.f16655e = i2;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f16658h = from;
        if (i2 == this.f16656f) {
            LayoutInflater layoutInflater = this.f16658h;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.point_reward_header, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…rd_header, parent, false)");
            return new a(this, inflate);
        }
        LayoutInflater layoutInflater2 = this.f16658h;
        if (layoutInflater2 == null) {
            k.a("mInflater");
        }
        View inflate2 = layoutInflater2.inflate(R.layout.point_reward_row, viewGroup, false);
        k.a((Object) inflate2, "mInflater.inflate(R.layo…eward_row, parent, false)");
        return new c(this, inflate2);
    }

    public final int getItemCount() {
        ArrayList<Reward> arrayList = this.f16651a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        return i2 == 0 ? this.f16656f : this.f16657g;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String a2;
        String str;
        k.c(vVar, "holder");
        if (vVar instanceof a) {
            if (this.f16659i) {
                a aVar = (a) vVar;
                aVar.f16663d.setVisibility(0);
                aVar.f16662c.setVisibility(0);
                aVar.f16660a.setVisibility(0);
            } else {
                a aVar2 = (a) vVar;
                aVar2.f16663d.setVisibility(8);
                aVar2.f16662c.setVisibility(8);
                aVar2.f16660a.setVisibility(8);
            }
            a aVar3 = (a) vVar;
            this.f16653c.a(this.f16659i, (View) aVar3.f16661b);
            RoboTextView roboTextView = aVar3.f16660a;
            if (this.f16654d == 0.0d) {
                str = "0";
            } else {
                str = net.one97.paytm.coins.c.e.a(this.f16654d);
            }
            roboTextView.setText(str);
        } else if (vVar instanceof c) {
            Attributes attributes = this.f16651a.get(i2).getAttributes();
            Double points_price = attributes != null ? attributes.getPoints_price() : null;
            c cVar = (c) vVar;
            TextView amountTexView = cVar.f16666b.getAmountTexView();
            k.a((Object) amountTexView, "holder.slide_button.amountTexView");
            amountTexView.setText((points_price == null || (a2 = net.one97.paytm.coins.c.e.a(points_price.doubleValue())) == null) ? "0.0" : a2);
            cVar.f16667c.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, vVar, i2));
            cVar.f16665a.setOnClickListener(new e(this, i2));
            cVar.f16665a.setOnClickListener(new f(this, vVar));
            cVar.f16666b.setSlideButtonListener(new g(this, i2, vVar));
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f16670b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16671c;

        d(b bVar, RecyclerView.v vVar, int i2) {
            this.f16669a = bVar;
            this.f16670b = vVar;
            this.f16671c = i2;
        }

        public final void onGlobalLayout() {
            ((c) this.f16670b).f16667c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            a aVar = new a(this);
            ((c) this.f16670b).f16667c.setTag(aVar);
            w.a().a(this.f16669a.f16651a.get(this.f16671c).getImage_url()).a(R.drawable.cashback_bg_place_holder).a(R.drawable.cashback_bg_place_holder).a((af) aVar);
        }

        public static final class a implements af {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f16672a;

            public final void onBitmapFailed(Exception exc, Drawable drawable) {
            }

            public final void onPrepareLoad(Drawable drawable) {
                k.c(drawable, "placeHolderDrawable");
            }

            a(d dVar) {
                this.f16672a = dVar;
            }

            public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                k.c(bitmap, "bitmap");
                k.c(dVar, "from");
                ((c) this.f16672a.f16670b).f16667c.setLayoutParams(new ConstraintLayout.LayoutParams(this.f16672a.f16669a.f16655e, (int) ((((float) ((c) this.f16672a.f16670b).f16667c.getWidth()) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()))));
                ((c) this.f16672a.f16670b).f16667c.setImageBitmap(bitmap);
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16674b;

        e(b bVar, int i2) {
            this.f16673a = bVar;
            this.f16674b = i2;
        }

        public final void onClick(View view) {
            C0246b bVar = this.f16673a.f16653c;
            int i2 = this.f16674b;
            Reward reward = this.f16673a.f16651a.get(this.f16674b);
            k.a((Object) reward, "mRewardList.get(position)");
            bVar.a(i2, reward);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16675a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f16676b;

        f(b bVar, RecyclerView.v vVar) {
            this.f16675a = bVar;
            this.f16676b = vVar;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a((View) ((c) this.f16676b).f16665a);
            this.f16675a.f16653c.a();
        }
    }

    public static final class g implements SlideButton.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16677a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16678b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f16679c;

        g(b bVar, int i2, RecyclerView.v vVar) {
            this.f16677a = bVar;
            this.f16678b = i2;
            this.f16679c = vVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0066, code lost:
            r0 = r0.getPoints_price();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r12 = this;
                net.one97.paytm.vipcashback.c.b r0 = net.one97.paytm.vipcashback.c.a.b()
                net.one97.paytm.coins.a.b r1 = r12.f16677a
                android.content.Context r1 = r1.f16652b
                r8 = 1
                java.lang.String[] r2 = new java.lang.String[r8]
                net.one97.paytm.coins.a.b r3 = r12.f16677a
                java.util.ArrayList<net.one97.paytm.coins.model.Reward> r3 = r3.f16651a
                int r4 = r12.f16678b
                java.lang.Object r3 = r3.get(r4)
                net.one97.paytm.coins.model.Reward r3 = (net.one97.paytm.coins.model.Reward) r3
                java.lang.String r3 = r3.getProduct_id()
                r9 = 0
                r2[r9] = r3
                java.util.ArrayList r4 = kotlin.a.k.d(r2)
                java.lang.String r2 = "paytm_coins"
                java.lang.String r3 = "coins_redemption_clicked"
                java.lang.String r5 = ""
                java.lang.String r6 = "/paytm_coins_catalog"
                java.lang.String r7 = "cashback"
                r0.sendNewCustomGTMEventsWithMultipleLabel(r1, r2, r3, r4, r5, r6, r7)
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                android.content.Context r0 = r0.f16652b
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 != 0) goto L_0x004a
                androidx.recyclerview.widget.RecyclerView$v r0 = r12.f16679c
                net.one97.paytm.coins.a.b$c r0 = (net.one97.paytm.coins.a.b.c) r0
                net.one97.paytm.coins.customview.SlideButton r0 = r0.f16666b
                r0.a()
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                net.one97.paytm.coins.a.b$b r0 = r0.f16653c
                r0.c()
                return
            L_0x004a:
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                java.util.ArrayList<net.one97.paytm.coins.model.Reward> r0 = r0.f16651a
                int r1 = r12.f16678b
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r1 = "mRewardList.get(position)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.coins.model.Reward r0 = (net.one97.paytm.coins.model.Reward) r0
                java.lang.String r2 = "reward"
                kotlin.g.b.k.c(r0, r2)
                net.one97.paytm.coins.model.Attributes r0 = r0.getAttributes()
                if (r0 == 0) goto L_0x0073
                java.lang.Double r0 = r0.getPoints_price()
                if (r0 == 0) goto L_0x0073
                java.lang.Number r0 = (java.lang.Number) r0
                double r2 = r0.doubleValue()
                goto L_0x0075
            L_0x0073:
                r2 = 0
            L_0x0075:
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                double r4 = r0.f16654d
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x009c
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                net.one97.paytm.coins.a.b$b r0 = r0.f16653c
                int r2 = r12.f16678b
                net.one97.paytm.coins.a.b r3 = r12.f16677a
                java.util.ArrayList<net.one97.paytm.coins.model.Reward> r3 = r3.f16651a
                int r4 = r12.f16678b
                java.lang.Object r3 = r3.get(r4)
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
                net.one97.paytm.coins.model.Reward r3 = (net.one97.paytm.coins.model.Reward) r3
                androidx.recyclerview.widget.RecyclerView$v r1 = r12.f16679c
                net.one97.paytm.coins.a.b$c r1 = (net.one97.paytm.coins.a.b.c) r1
                net.one97.paytm.coins.customview.SlideButton r1 = r1.f16666b
                r0.a(r2, r3, r1)
                return
            L_0x009c:
                net.one97.paytm.vipcashback.c.b r4 = net.one97.paytm.vipcashback.c.a.b()
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                android.content.Context r5 = r0.f16652b
                java.lang.String[] r0 = new java.lang.String[r8]
                net.one97.paytm.coins.a.b r2 = r12.f16677a
                java.util.ArrayList<net.one97.paytm.coins.model.Reward> r2 = r2.f16651a
                int r3 = r12.f16678b
                java.lang.Object r2 = r2.get(r3)
                net.one97.paytm.coins.model.Reward r2 = (net.one97.paytm.coins.model.Reward) r2
                java.lang.String r2 = r2.getProduct_id()
                r0[r9] = r2
                java.util.ArrayList r8 = kotlin.a.k.d(r0)
                java.lang.String r6 = "paytm_coins"
                java.lang.String r7 = "coins_redemption_insufficient_balance"
                java.lang.String r9 = ""
                java.lang.String r10 = "/paytm_coins_catalog"
                java.lang.String r11 = "cashback"
                r4.sendNewCustomGTMEventsWithMultipleLabel(r5, r6, r7, r8, r9, r10, r11)
                androidx.recyclerview.widget.RecyclerView$v r0 = r12.f16679c
                net.one97.paytm.coins.a.b$c r0 = (net.one97.paytm.coins.a.b.c) r0
                net.one97.paytm.coins.customview.SlideButton r0 = r0.f16666b
                r0.a()
                net.one97.paytm.coins.a.b r0 = r12.f16677a
                net.one97.paytm.coins.a.b$b r0 = r0.f16653c
                net.one97.paytm.coins.a.b r2 = r12.f16677a
                java.util.ArrayList<net.one97.paytm.coins.model.Reward> r2 = r2.f16651a
                int r3 = r12.f16678b
                java.lang.Object r2 = r2.get(r3)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
                net.one97.paytm.coins.model.Reward r2 = (net.one97.paytm.coins.model.Reward) r2
                r0.a(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.a.b.g.a():void");
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f16660a;

        /* renamed from: b  reason: collision with root package name */
        final LottieAnimationView f16661b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f16662c;

        /* renamed from: d  reason: collision with root package name */
        final ImageView f16663d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f16664e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f16664e = bVar;
            View findViewById = view.findViewById(R.id.tv_rewards_points);
            if (findViewById != null) {
                this.f16660a = (RoboTextView) findViewById;
                View findViewById2 = view.findViewById(R.id.loaderOnTopRight);
                if (findViewById2 != null) {
                    this.f16661b = (LottieAnimationView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_points);
                    if (findViewById3 != null) {
                        this.f16662c = (RoboTextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.iv_point_icon);
                        if (findViewById4 != null) {
                            this.f16663d = (ImageView) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
                }
                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            }
            throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f16665a;

        /* renamed from: b  reason: collision with root package name */
        final SlideButton f16666b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f16667c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f16668d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f16668d = bVar;
            View findViewById = view.findViewById(R.id.tv_view_details);
            if (findViewById != null) {
                this.f16665a = (RoboTextView) findViewById;
                View findViewById2 = view.findViewById(R.id.slide_button);
                if (findViewById2 != null) {
                    this.f16666b = (SlideButton) findViewById2;
                    View findViewById3 = view.findViewById(R.id.iv_reward_image);
                    if (findViewById3 != null) {
                        this.f16667c = (ImageView) findViewById3;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.coins.customview.SlideButton");
            }
            throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
        }
    }

    public final void a(double d2) {
        this.f16659i = true;
        if (!this.f16651a.isEmpty()) {
            this.f16654d = d2;
            notifyItemChanged(0);
        }
    }
}
