package net.one97.paytm.recharge.creditcard.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: c  reason: collision with root package name */
    public static final C1199a f62351c = new C1199a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public d f62352a;

    /* renamed from: b  reason: collision with root package name */
    public List<CJRCreditCardModelV8> f62353b;

    /* renamed from: d  reason: collision with root package name */
    private Context f62354d;

    /* renamed from: e  reason: collision with root package name */
    private String f62355e;

    /* renamed from: f  reason: collision with root package name */
    private String f62356f;

    public interface d {
        void a(View view, CJRCreditCardModelV8 cJRCreditCardModelV8);

        void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap);
    }

    public a(Context context, List<CJRCreditCardModelV8> list, String str, String str2) {
        k.c(context, "mContext");
        k.c(list, "mSavedCardsList");
        this.f62354d = context;
        this.f62353b = list;
        this.f62355e = str;
        this.f62356f = str2;
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.a.a$a  reason: collision with other inner class name */
    public static final class C1199a {
        private C1199a() {
        }

        public /* synthetic */ C1199a(byte b2) {
            this();
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        if (i2 == 1) {
            View inflate = LayoutInflater.from(this.f62354d).inflate(R.layout.layout_rv_saved_cardv2_footer, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(mCon…footer, viewGroup, false)");
            return new b(inflate, this.f62352a, this.f62354d);
        } else if (i2 != 3) {
            View inflate2 = LayoutInflater.from(this.f62354d).inflate(R.layout.layout_rv_saved_cardv2, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(mCon…cardv2, viewGroup, false)");
            return new e(inflate2, this.f62352a);
        } else {
            View inflate3 = LayoutInflater.from(this.f62354d).inflate(R.layout.fragment_creditcard_header, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(mCon…header, viewGroup, false)");
            return new c(inflate3, this.f62355e, this.f62356f);
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "itemClickListener");
        this.f62352a = dVar;
    }

    public final int getItemCount() {
        return this.f62353b.size() + 2;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar;
        TextView textView;
        Context context;
        String str;
        String a2;
        k.c(vVar, "holder");
        String str2 = null;
        if (vVar instanceof e) {
            e eVar = (e) vVar;
            boolean z = true;
            int i3 = i2 - 1;
            CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62353b.get(i3);
            k.c(cJRCreditCardModelV8, "savedCard");
            CardView cardView = eVar.f62370e;
            k.a((Object) cardView, "cardView");
            cardView.setTag(cJRCreditCardModelV8);
            ImageView imageView = eVar.f62372g;
            k.a((Object) imageView, "optionImageView");
            imageView.setTag(cJRCreditCardModelV8);
            RoboTextView roboTextView = eVar.f62366a;
            k.a((Object) roboTextView, "txtCardName");
            roboTextView.setText(cJRCreditCardModelV8.getOperaterName());
            RoboTextView roboTextView2 = eVar.f62367b;
            if (roboTextView2 != null) {
                String cardNumber = cJRCreditCardModelV8.getCardNumber();
                String str3 = "";
                if (!TextUtils.isEmpty(cardNumber)) {
                    if (cardNumber == null || (a2 = p.a(cardNumber, "-", str3, false)) == null) {
                        str = null;
                    } else {
                        str = p.a(a2, " ", str3, false);
                    }
                    if (str != null) {
                        int length = str.length() - 4;
                        if (str != null) {
                            str2 = str.substring(length);
                            k.a((Object) str2, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    str3 = str2;
                    if (str3 == null) {
                        k.a();
                    }
                }
                roboTextView2.setText(str3);
            }
            ba.a((View) eVar.f62371f, cJRCreditCardModelV8.getCardType());
            String rechargeAmount = cJRCreditCardModelV8.getRechargeAmount();
            if (rechargeAmount != null) {
                if (rechargeAmount.length() > 0) {
                    String a3 = com.paytm.utility.b.a(Double.parseDouble(rechargeAmount), "##,##,###.##");
                    TextView textView2 = eVar.f62374i;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    TextView textView3 = eVar.f62374i;
                    k.a((Object) textView3, "vissaBill");
                    TextView textView4 = eVar.f62374i;
                    k.a((Object) textView4, "vissaBill");
                    textView3.setText(textView4.getContext().getString(R.string.recharge_visa_bill_paid, new Object[]{a3}));
                }
            } else {
                TextView textView5 = eVar.f62374i;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            String rechargeDate = cJRCreditCardModelV8.getRechargeDate();
            if (rechargeDate != null) {
                if (rechargeDate.length() <= 0) {
                    z = false;
                }
                if (z) {
                    TextView textView6 = eVar.j;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                    }
                    TextView textView7 = eVar.j;
                    k.a((Object) textView7, "visaDate");
                    textView7.setText(ab.a(rechargeDate, "dd MMM, yyyy"));
                }
            } else {
                TextView textView8 = eVar.j;
                if (textView8 != null) {
                    textView8.setVisibility(8);
                }
            }
            String operaterImage = cJRCreditCardModelV8.getOperaterImage();
            String operaterCardTypeImage = cJRCreditCardModelV8.getOperaterCardTypeImage();
            if (!TextUtils.isEmpty(operaterImage)) {
                w.a().a(operaterImage).a(com.paytm.utility.b.c(42), com.paytm.utility.b.c(28)).d().a(eVar.f62368c);
            }
            if (!TextUtils.isEmpty(operaterCardTypeImage)) {
                w.a().a(operaterCardTypeImage).a(com.paytm.utility.b.c(36), com.paytm.utility.b.c(24)).d().a(eVar.f62369d);
            }
            if (i3 > 0) {
                eVar.k.startAnimation(AnimationUtils.loadAnimation(eVar.k.getContext(), R.anim.item_slide_from_top_to_bottom));
            }
        } else if ((vVar instanceof b) && (textView = bVar.f62357a) != null) {
            TextView textView9 = (bVar = (b) vVar).f62357a;
            if (!(textView9 == null || (context = textView9.getContext()) == null)) {
                str2 = context.getString(R.string.visa_pay_bill_for_other_credit_card);
            }
            textView.setText(str2);
        }
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return 3;
        }
        return i2 == this.f62353b.size() + 1 ? 1 : 2;
    }

    public static final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f62366a = ((RoboTextView) this.k.findViewById(R.id.txt_card_name));

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f62367b = ((RoboTextView) this.k.findViewById(R.id.txt_card_number));

        /* renamed from: c  reason: collision with root package name */
        ImageView f62368c = ((ImageView) this.k.findViewById(R.id.img_bank));

        /* renamed from: d  reason: collision with root package name */
        ImageView f62369d = ((ImageView) this.k.findViewById(R.id.cardtypeView));

        /* renamed from: e  reason: collision with root package name */
        CardView f62370e = ((CardView) this.k.findViewById(R.id.card_view));

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f62371f = ((RelativeLayout) this.k.findViewById(R.id.lyt_outer_container));

        /* renamed from: g  reason: collision with root package name */
        ImageView f62372g = ((ImageView) this.k.findViewById(R.id.saved_card_remove_menu));

        /* renamed from: h  reason: collision with root package name */
        View f62373h = this.k.findViewById(R.id.dummyview);

        /* renamed from: i  reason: collision with root package name */
        TextView f62374i = ((TextView) this.k.findViewById(R.id.visa_bill));
        TextView j = ((TextView) this.k.findViewById(R.id.visa_date));
        View k;
        d l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view, d dVar) {
            super(view);
            k.c(view, "view");
            this.k = view;
            this.l = dVar;
            this.f62370e.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ e f62375a;

                {
                    this.f62375a = r1;
                }

                public final void onClick(View view) {
                    HashMap hashMap;
                    if (this.f62375a.l != null) {
                        Object obj = null;
                        if (Build.VERSION.SDK_INT > 21) {
                            hashMap = new HashMap();
                            k.a((Object) view, "view");
                            hashMap.put(view.getContext().getString(R.string.transition_name_cc_button), new View(view.getContext()));
                        } else {
                            hashMap = null;
                        }
                        d dVar = this.f62375a.l;
                        if (dVar != null) {
                            if (view != null) {
                                obj = view.getTag();
                            }
                            if (obj != null) {
                                dVar.a((CJRCreditCardModelV8) obj, false, hashMap);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8");
                        }
                    }
                }
            });
            this.f62372g.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ e f62376a;

                {
                    this.f62376a = r1;
                }

                public final void onClick(View view) {
                    d dVar;
                    if (view != null && this.f62376a.l != null && (dVar = this.f62376a.l) != null) {
                        View view2 = this.f62376a.f62373h;
                        k.a((Object) view2, "dummyView");
                        Object tag = view.getTag();
                        if (tag != null) {
                            dVar.a(view2, (CJRCreditCardModelV8) tag);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8");
                    }
                }
            });
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f62357a;

        /* renamed from: b  reason: collision with root package name */
        final d f62358b;

        /* renamed from: c  reason: collision with root package name */
        private CardView f62359c;

        /* renamed from: d  reason: collision with root package name */
        private View f62360d;

        /* renamed from: e  reason: collision with root package name */
        private Context f62361e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, d dVar, Context context) {
            super(view);
            k.c(view, "view");
            k.c(context, "context");
            this.f62360d = view;
            this.f62358b = dVar;
            this.f62361e = context;
            View findViewById = this.f62360d.findViewById(R.id.footer_text);
            if (findViewById != null) {
                this.f62357a = (TextView) findViewById;
                View findViewById2 = this.f62360d.findViewById(R.id.card_view_footer);
                if (findViewById2 != null) {
                    this.f62359c = (CardView) findViewById2;
                    CardView cardView = this.f62359c;
                    if (cardView != null) {
                        cardView.setOnClickListener(new View.OnClickListener(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ b f62362a;

                            {
                                this.f62362a = r1;
                            }

                            public final void onClick(View view) {
                                if (this.f62362a.f62358b != null) {
                                    CJRCreditCardModelV8 cJRCreditCardModelV8 = new CJRCreditCardModelV8();
                                    cJRCreditCardModelV8.setCardTypeId(cJRCreditCardModelV8.getFreshCardId());
                                    this.f62362a.f62358b.a(cJRCreditCardModelV8, true, (HashMap<String, View>) null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.cardview.widget.CardView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private TextView f62363a;

        /* renamed from: b  reason: collision with root package name */
        private View f62364b;

        /* renamed from: c  reason: collision with root package name */
        private String f62365c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view, String str, String str2) {
            super(view);
            k.c(view, "view");
            this.f62364b = view;
            this.f62365c = str;
            View findViewById = this.f62364b.findViewById(R.id.view_disclaimer);
            if (findViewById != null) {
                this.f62363a = (TextView) findViewById;
                TextView textView = this.f62363a;
                if (textView != null) {
                    textView.setText(str2);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
