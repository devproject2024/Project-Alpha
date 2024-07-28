package net.one97.paytm.recharge.common.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.s;
import net.one97.paytm.recharge.common.e.t;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class l extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: i  reason: collision with root package name */
    public static final a f60588i = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String o = o;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJROfferCode> f60589a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f60590b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60591c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60592d = true;

    /* renamed from: e  reason: collision with root package name */
    ClipboardManager f60593e;

    /* renamed from: f  reason: collision with root package name */
    final String f60594f;

    /* renamed from: g  reason: collision with root package name */
    final t f60595g;

    /* renamed from: h  reason: collision with root package name */
    public final int f60596h;
    /* access modifiers changed from: private */
    public int j = -1;
    /* access modifiers changed from: private */
    public String k = "";
    /* access modifiers changed from: private */
    public boolean l;
    private final b m;
    private final c n;

    public interface b {
        void a(int i2);

        void a(String str);

        boolean a();
    }

    public interface c {
        void a(String str, String str2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public l(List<? extends CJROfferCode> list, String str, b bVar, c cVar, t tVar, int i2) {
        k.c(tVar, "mPromoCodesOwner");
        this.f60594f = str;
        this.m = bVar;
        this.n = cVar;
        this.f60595g = tVar;
        this.f60596h = i2;
        Collection collection = list;
        if (collection != null && (true ^ collection.isEmpty())) {
            this.f60589a.addAll((List) collection);
        }
    }

    public final int getItemCount() {
        if (!this.f60591c) {
            return Math.min(this.f60596h, this.f60589a.size());
        }
        return this.f60589a.size();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (this.f60593e == null) {
            Context context = viewGroup.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            this.f60593e = (ClipboardManager) systemService;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v8_list_item_promo, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…tem_promo, parent, false)");
        return new d(this, inflate, this.m, this.n);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof d) {
            CJROfferCode cJROfferCode = this.f60589a.get(i2);
            k.a((Object) cJROfferCode, "offerList[position]");
            CJROfferCode cJROfferCode2 = cJROfferCode;
            d dVar = (d) vVar;
            TextView textView = dVar.f60598b;
            k.a((Object) textView, "holder.offerTitle");
            textView.setText(cJROfferCode2.getCode());
            TextView textView2 = dVar.f60599c;
            k.a((Object) textView2, "holder.offerDesc");
            textView2.setText(cJROfferCode2.getOfferText());
            if (!TextUtils.isEmpty(cJROfferCode2.getTerms())) {
                TextView textView3 = dVar.f60601e;
                k.a((Object) textView3, "holder.tvTermCondition");
                View view = vVar.itemView;
                k.a((Object) view, "holder.itemView");
                textView3.setText(view.getContext().getString(R.string.promo_terms));
                TextView textView4 = dVar.f60601e;
                k.a((Object) textView4, "holder.tvTermCondition");
                textView4.setVisibility(0);
            } else {
                TextView textView5 = dVar.f60601e;
                k.a((Object) textView5, "holder.tvTermCondition");
                textView5.setVisibility(8);
            }
            if (a(cJROfferCode2)) {
                cJROfferCode2.setChecked(true);
                this.f60590b = i2;
                dVar.a(i2);
            } else {
                cJROfferCode2.setChecked(false);
                if (!TextUtils.isEmpty(this.f60594f)) {
                    dVar.c();
                } else {
                    LottieAnimationView lottieAnimationView = dVar.f60600d;
                    k.a((Object) lottieAnimationView, "holder.imgTick");
                    lottieAnimationView.setVisibility(4);
                    TextView textView6 = dVar.f60597a;
                    k.a((Object) textView6, "holder.copyOffer");
                    textView6.setVisibility(4);
                    TextView textView7 = dVar.f60597a;
                    k.a((Object) textView7, "holder.copyOffer");
                    textView7.setClickable(false);
                }
            }
            if (cJROfferCode2.getIsOfferApplied()) {
                TextView textView8 = dVar.f60602f;
                k.a((Object) textView8, "holder.tvPromoError");
                textView8.setVisibility(0);
                TextView textView9 = dVar.f60602f;
                k.a((Object) textView9, "holder.tvPromoError");
                textView9.setText(this.k);
                LinearLayout linearLayout = dVar.f60604h;
                k.a((Object) linearLayout, "holder.promoOfferView");
                linearLayout.setAlpha(0.5f);
                RelativeLayout relativeLayout = dVar.f60605i;
                k.a((Object) relativeLayout, "holder.animationButton");
                relativeLayout.setAlpha(0.5f);
            } else {
                TextView textView10 = dVar.f60602f;
                k.a((Object) textView10, "holder.tvPromoError");
                textView10.setVisibility(8);
                TextView textView11 = dVar.f60602f;
                k.a((Object) textView11, "holder.tvPromoError");
                textView11.setText("");
                LinearLayout linearLayout2 = dVar.f60604h;
                k.a((Object) linearLayout2, "holder.promoOfferView");
                linearLayout2.setAlpha(1.0f);
                RelativeLayout relativeLayout2 = dVar.f60605i;
                k.a((Object) relativeLayout2, "holder.animationButton");
                relativeLayout2.setAlpha(1.0f);
            }
            if (cJROfferCode2.isExpanded()) {
                RelativeLayout relativeLayout3 = dVar.f60603g;
                k.a((Object) relativeLayout3, "holder.progress");
                relativeLayout3.setVisibility(0);
                return;
            }
            RelativeLayout relativeLayout4 = dVar.f60603g;
            k.a((Object) relativeLayout4, "holder.progress");
            relativeLayout4.setVisibility(8);
        }
    }

    public final boolean a(CJROfferCode cJROfferCode) {
        b bVar;
        String str;
        ClipData.Item itemAt;
        CharSequence text;
        k.c(cJROfferCode, "promoItem");
        try {
            ClipboardManager clipboardManager = this.f60593e;
            String str2 = null;
            ClipData primaryClip = clipboardManager != null ? clipboardManager.getPrimaryClip() : null;
            if ((primaryClip != null ? primaryClip.getItemCount() : 0) > 0) {
                if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null || (str = text.toString()) == null) {
                    str = "";
                }
                str2 = str;
            }
            if (str2 == null || !p.a(str2, cJROfferCode.getCode(), true) || (bVar = this.m) == null || !bVar.a()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public final void a(List<? extends CJROfferCode> list) {
        k.c(list, "offerList");
        this.l = false;
        this.f60589a.clear();
        this.f60589a.addAll(list);
        this.j = -1;
        notifyDataSetChanged();
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60597a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f60598b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f60599c;

        /* renamed from: d  reason: collision with root package name */
        final LottieAnimationView f60600d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f60601e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f60602f;

        /* renamed from: g  reason: collision with root package name */
        final RelativeLayout f60603g;

        /* renamed from: h  reason: collision with root package name */
        final LinearLayout f60604h;

        /* renamed from: i  reason: collision with root package name */
        final RelativeLayout f60605i;
        b j;
        c k;
        final /* synthetic */ l l;
        private final LinearLayout m;

        static final class a<T> implements z<CJRRechargeCart> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f60610a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.a f60611b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRRechargeErrorModel f60612c;

            a(d dVar, x.a aVar, CJRRechargeErrorModel cJRRechargeErrorModel) {
                this.f60610a = dVar;
                this.f60611b = aVar;
                this.f60612c = cJRRechargeErrorModel;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                CJRCart cart;
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) obj;
                String str = null;
                if ((cJRRechargeCart != null ? cJRRechargeCart.getCart() : null) != null) {
                    if (this.f60610a.l.j != -1) {
                        Object obj2 = this.f60610a.l.f60589a.get(this.f60610a.l.j);
                        k.a(obj2, "offerList[lastOfferAppliedPos]");
                        ((CJROfferCode) obj2).setExpanded(false);
                        this.f60610a.l.notifyItemChanged(this.f60610a.l.j);
                    }
                    az azVar = az.f61525a;
                    View view = this.f60610a.itemView;
                    k.a((Object) view, "itemView");
                    if (!az.a(view.getContext(), cJRRechargeCart, ACTION_TYPE.PROMO_VERIFY)) {
                        CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                        if (cartStatus != null) {
                            str = cartStatus.getResult();
                        }
                        if (p.a(str, "SUCCESS", true) && (cart = cJRRechargeCart.getCart()) != null && p.a(cart.getPromoStatus(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true) && this.f60610a.l.j != -1 && this.f60611b.element && cart.getPromoFailureText() != null) {
                            l lVar = this.f60610a.l;
                            String promoFailureText = cart.getPromoFailureText();
                            if (promoFailureText == null) {
                                promoFailureText = "";
                            }
                            lVar.k = promoFailureText;
                            Object obj3 = this.f60610a.l.f60589a.get(this.f60610a.l.j);
                            k.a(obj3, "offerList[lastOfferAppliedPos]");
                            ((CJROfferCode) obj3).setIsOfferApplied(true);
                            this.f60610a.l.notifyItemChanged(this.f60610a.getAdapterPosition());
                            this.f60611b.element = false;
                            az azVar2 = az.f61525a;
                            az.a(this.f60612c);
                        }
                    }
                    b bVar = this.f60610a.j;
                    if (bVar != null) {
                        bVar.a(8);
                    }
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(l lVar, View view, b bVar, c cVar) {
            super(view);
            k.c(view, "itemView");
            this.l = lVar;
            this.j = bVar;
            this.k = cVar;
            this.f60597a = (TextView) view.findViewById(R.id.txt_copy);
            this.f60598b = (TextView) view.findViewById(R.id.tv_offer_title);
            this.f60599c = (TextView) view.findViewById(R.id.tv_offer_desc);
            this.f60600d = (LottieAnimationView) view.findViewById(R.id.img_tick);
            this.f60601e = (TextView) view.findViewById(R.id.txt_term_condition);
            this.f60602f = (TextView) view.findViewById(R.id.promo_error);
            this.f60603g = (RelativeLayout) view.findViewById(R.id.progress);
            this.m = (LinearLayout) view.findViewById(R.id.offerContainer);
            this.f60604h = (LinearLayout) view.findViewById(R.id.promoOfferView);
            this.f60605i = (RelativeLayout) view.findViewById(R.id.animation_button);
            if (lVar.f60592d) {
                view.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f60606a;

                    {
                        this.f60606a = r1;
                    }

                    public final void onClick(View view) {
                        LottieAnimationView lottieAnimationView = this.f60606a.f60600d;
                        k.a((Object) lottieAnimationView, "imgTick");
                        if (lottieAnimationView.getVisibility() == 0) {
                            this.f60606a.a();
                            return;
                        }
                        try {
                            Object obj = this.f60606a.l.f60589a.get(this.f60606a.getAdapterPosition());
                            k.a(obj, "offerList[adapterPosition]");
                            if (!((CJROfferCode) obj).getIsOfferApplied()) {
                                this.f60606a.b();
                            }
                        } catch (Exception unused) {
                            CJRRechargeUtilities.INSTANCE.debugLog("IndexOutOfBoundException on offer view clicked");
                        }
                    }
                });
                this.f60600d.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f60607a;

                    {
                        this.f60607a = r1;
                    }

                    public final void onClick(View view) {
                        this.f60607a.a();
                    }
                });
                this.f60597a.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f60608a;

                    {
                        this.f60608a = r1;
                    }

                    public final void onClick(View view) {
                        try {
                            Object obj = this.f60608a.l.f60589a.get(this.f60608a.getAdapterPosition());
                            k.a(obj, "offerList[adapterPosition]");
                            if (!((CJROfferCode) obj).getIsOfferApplied()) {
                                this.f60608a.b();
                            }
                        } catch (Exception unused) {
                            CJRRechargeUtilities.INSTANCE.debugLog("IndexOutOfBoundException on offer selected");
                        }
                    }
                });
            } else {
                RelativeLayout relativeLayout = this.f60605i;
                k.a((Object) relativeLayout, "animationButton");
                relativeLayout.setVisibility(8);
                RelativeLayout relativeLayout2 = this.f60605i;
                k.a((Object) relativeLayout2, "animationButton");
                ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    LinearLayout linearLayout = this.f60604h;
                    k.a((Object) linearLayout, "promoOfferView");
                    ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                    if (layoutParams3 != null) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                        layoutParams4.weight += layoutParams2.weight;
                        LinearLayout linearLayout2 = this.f60604h;
                        k.a((Object) linearLayout2, "promoOfferView");
                        linearLayout2.setLayoutParams(layoutParams4);
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            }
            this.f60601e.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f60609a;

                {
                    this.f60609a = r1;
                }

                public final void onClick(View view) {
                    c cVar;
                    try {
                        Object obj = this.f60609a.l.f60589a.get(this.f60609a.getAdapterPosition());
                        k.a(obj, "offerList[adapterPosition]");
                        String terms = ((CJROfferCode) obj).getTerms();
                        if (!TextUtils.isEmpty(terms) && (cVar = this.f60609a.k) != null) {
                            Object obj2 = this.f60609a.l.f60589a.get(this.f60609a.getAdapterPosition());
                            k.a(obj2, "offerList[adapterPosition]");
                            String code = ((CJROfferCode) obj2).getCode();
                            k.a((Object) code, "offerList[adapterPosition].code");
                            if (terms == null) {
                                k.a();
                            }
                            cVar.a(code, terms);
                        }
                    } catch (Exception unused) {
                        CJRRechargeUtilities.INSTANCE.debugLog("IndexOutOfBoundException on offer T&C clicked");
                    }
                }
            });
        }

        public final void a() {
            if (getAdapterPosition() != -1) {
                Object obj = this.l.f60589a.get(getAdapterPosition());
                k.a(obj, "offerList[adapterPosition]");
                c();
                ((CJROfferCode) obj).setChecked(false);
                this.l.f60590b = -1;
                b bVar = this.j;
                if (bVar != null && bVar.a()) {
                    a aVar = l.f60588i;
                    ClipData newPlainText = ClipData.newPlainText(l.o, "");
                    ClipboardManager clipboardManager = this.l.f60593e;
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(newPlainText);
                    }
                }
                TextView textView = this.f60597a;
                k.a((Object) textView, "copyOffer");
                textView.setVisibility(0);
                TextView textView2 = this.f60597a;
                k.a((Object) textView2, "copyOffer");
                textView2.setClickable(true);
            }
        }

        public final void b() {
            if (getAdapterPosition() != -1) {
                b bVar = this.j;
                if (bVar != null) {
                    Object obj = this.l.f60589a.get(getAdapterPosition());
                    k.a(obj, "offerList[adapterPosition]");
                    String code = ((CJROfferCode) obj).getCode();
                    k.a((Object) code, "offerList[adapterPosition].code");
                    bVar.a(code);
                }
                b bVar2 = this.j;
                if (bVar2 == null || !bVar2.a()) {
                    View view = this.itemView;
                    k.a((Object) view, "itemView");
                    String str = null;
                    if (com.paytm.utility.b.c(view.getContext())) {
                        Object obj2 = this.l.f60589a.get(getAdapterPosition());
                        k.a(obj2, "offerList[adapterPosition]");
                        ((CJROfferCode) obj2).setExpanded(true);
                        this.l.notifyItemChanged(getAdapterPosition());
                        this.l.j = getAdapterPosition();
                        Object obj3 = this.l.f60589a.get(this.l.j);
                        k.a(obj3, "offerList[lastOfferAppliedPos]");
                        CJROfferCode cJROfferCode = (CJROfferCode) obj3;
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        ay ayVar = ay.f61523a;
                        ay.a(ERROR_TYPE.INLINE_ERROR, ACTION_TYPE.PROMO_VERIFY, a2);
                        if (this.l.f60595g instanceof s) {
                            b bVar3 = this.j;
                            if (bVar3 != null) {
                                bVar3.a(0);
                            }
                            x.a aVar = new x.a();
                            aVar.element = true;
                            y<CJRRechargeCart> b2 = ((s) this.l.f60595g).b(cJROfferCode, a2);
                            if (b2 != null) {
                                b2.observe(this.l.f60595g, new a(this, aVar, a2));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    az azVar = az.f61525a;
                    View view2 = this.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    ERROR_TYPE error_type = ERROR_TYPE.NO_CONNECTION;
                    ACTION_TYPE action_type = ACTION_TYPE.PROMO_VERIFY;
                    View view3 = this.itemView;
                    k.a((Object) view3, "itemView");
                    Resources resources = view3.getResources();
                    String string = resources != null ? resources.getString(R.string.no_connection) : null;
                    View view4 = this.itemView;
                    k.a((Object) view4, "itemView");
                    Resources resources2 = view4.getResources();
                    if (resources2 != null) {
                        str = resources2.getString(R.string.no_internet);
                    }
                    az.a(context, error_type, action_type, string, str);
                    return;
                }
                Object obj4 = this.l.f60589a.get(getAdapterPosition());
                k.a(obj4, "offerList[adapterPosition]");
                CJROfferCode cJROfferCode2 = (CJROfferCode) obj4;
                if (this.l.f60590b == -1) {
                    a(cJROfferCode2);
                } else if (cJROfferCode2.isChecked()) {
                    k.c(cJROfferCode2, "promoItem");
                    c();
                    cJROfferCode2.setChecked(false);
                    this.l.f60590b = -1;
                    TextView textView = this.f60597a;
                    k.a((Object) textView, "copyOffer");
                    textView.setVisibility(0);
                    TextView textView2 = this.f60597a;
                    k.a((Object) textView2, "copyOffer");
                    textView2.setClickable(true);
                } else {
                    a(cJROfferCode2);
                }
            }
        }

        public final void c() {
            LottieAnimationView lottieAnimationView = this.f60600d;
            k.a((Object) lottieAnimationView, "imgTick");
            lottieAnimationView.setVisibility(8);
            TextView textView = this.f60597a;
            k.a((Object) textView, "copyOffer");
            textView.setVisibility(0);
            TextView textView2 = this.f60597a;
            k.a((Object) textView2, "copyOffer");
            textView2.setClickable(true);
            TextView textView3 = this.f60597a;
            k.a((Object) textView3, "copyOffer");
            textView3.setText(this.l.f60594f);
            TextView textView4 = this.f60597a;
            k.a((Object) textView4, "copyOffer");
            textView4.setTextColor(androidx.core.content.b.c(textView4.getContext(), R.color.color_00b9f5));
            this.f60597a.setBackgroundResource(R.drawable.v8_shape_promo_action_btn);
        }

        private void a(CJROfferCode cJROfferCode) {
            k.c(cJROfferCode, "promoItem");
            this.l.l = true;
            a(getAdapterPosition());
            cJROfferCode.setChecked(true);
            if (this.l.f60590b != -1) {
                Object obj = this.l.f60589a.get(this.l.f60590b);
                k.a(obj, "offerList[lastCheckedPos]");
                ((CJROfferCode) obj).setChecked(false);
                this.l.notifyDataSetChanged();
            }
            this.l.f60590b = getAdapterPosition();
        }

        public final void a(int i2) {
            a aVar = l.f60588i;
            Object obj = this.l.f60589a.get(i2);
            k.a(obj, "offerList[position]");
            ClipData newPlainText = ClipData.newPlainText(l.o, ((CJROfferCode) obj).getCode());
            try {
                ClipboardManager clipboardManager = this.l.f60593e;
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(newPlainText);
                }
            } catch (SecurityException unused) {
            }
            TextView textView = this.f60597a;
            k.a((Object) textView, "copyOffer");
            textView.setVisibility(4);
            TextView textView2 = this.f60597a;
            k.a((Object) textView2, "copyOffer");
            textView2.setClickable(false);
            LottieAnimationView lottieAnimationView = this.f60600d;
            k.a((Object) lottieAnimationView, "imgTick");
            lottieAnimationView.setVisibility(0);
            d();
        }

        private void d() {
            this.f60600d.setAnimation("copy_animation.json");
            if (this.l.l) {
                this.f60600d.playAnimation();
                return;
            }
            LottieAnimationView lottieAnimationView = this.f60600d;
            k.a((Object) lottieAnimationView, "imgTick");
            lottieAnimationView.setProgress(1.0f);
        }
    }
}
