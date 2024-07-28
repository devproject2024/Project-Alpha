package net.one97.paytm.recharge.creditcard.v4.a;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f62485a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private f f62486b;

    /* renamed from: c  reason: collision with root package name */
    private int f62487c;

    /* renamed from: d  reason: collision with root package name */
    private Context f62488d;

    /* renamed from: e  reason: collision with root package name */
    private List<CJRCreditCardModelV8> f62489e;

    /* renamed from: f  reason: collision with root package name */
    private String f62490f;

    /* renamed from: g  reason: collision with root package name */
    private final String f62491g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f62492h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f62493i;
    private final boolean j;
    private final String k;

    public interface e {
        void a();

        void a(View view, CJRCreditCardModelV8 cJRCreditCardModelV8, int i2);
    }

    public interface f extends e {
        void a(Bundle bundle, h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8);

        void a(RecyclerView.v vVar, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap);

        void b();
    }

    public a(Context context, List<CJRCreditCardModelV8> list, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        int i2;
        k.c(context, "mContext");
        k.c(list, "mSavedCardsList");
        k.c(str, "gaEventCategory");
        k.c(str2, "categoryId");
        k.c(str3, H5Logger.HEADER);
        this.f62488d = context;
        this.f62489e = list;
        this.f62490f = str;
        this.f62491g = str2;
        this.f62492h = z;
        this.f62493i = z2;
        this.j = z3;
        this.k = str3;
        if (!this.j || !this.f62492h) {
            i2 = (this.f62492h || this.j) ? 1 : 0;
        } else {
            i2 = 2;
        }
        this.f62487c = i2;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        if (i2 == 1) {
            View inflate = LayoutInflater.from(this.f62488d).inflate(R.layout.layout_rv_saved_cardv2_footer_v4, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(mCon…ter_v4, viewGroup, false)");
            return new c(inflate, this.f62486b, this.f62488d, this.f62490f, this.f62491g);
        } else if (i2 == 3) {
            View inflate2 = LayoutInflater.from(this.f62488d).inflate(R.layout.fragment_creditcard_header_v4, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(mCon…der_v4, viewGroup, false)");
            return new d(inflate2, this.k);
        } else if (i2 == 4) {
            View inflate3 = LayoutInflater.from(this.f62488d).inflate(R.layout.v4_never_miss_credit_card_bill_layout, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(mCon…layout, viewGroup, false)");
            return new C1205a(inflate3, this.f62486b);
        } else if (i2 != 5) {
            View inflate4 = LayoutInflater.from(this.f62488d).inflate(R.layout.layout_rv_saved_cardv4, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(mCon…cardv4, viewGroup, false)");
            return new h(inflate4, this.f62486b);
        } else {
            View inflate5 = LayoutInflater.from(this.f62488d).inflate(R.layout.v4_credit_card_shimmer_effect_view, viewGroup, false);
            k.a((Object) inflate5, "LayoutInflater.from(mCon…t_view, viewGroup, false)");
            return new g(inflate5);
        }
    }

    public final void a(f fVar) {
        k.c(fVar, "itemClickListener");
        this.f62486b = fVar;
    }

    public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8) {
        if (cJRCreditCardModelV8 != null) {
            notifyItemRemoved(this.f62489e.indexOf(cJRCreditCardModelV8) + this.f62487c);
            this.f62489e.remove(cJRCreditCardModelV8);
            if (this.f62489e.size() == 0 && this.f62486b != null) {
                CJRCreditCardModelV8 cJRCreditCardModelV82 = new CJRCreditCardModelV8();
                cJRCreditCardModelV82.setCardTypeId(cJRCreditCardModelV82.getFreshCardId());
                return;
            }
            return;
        }
        this.f62492h = false;
        boolean z = this.j;
        this.f62487c = z ? 1 : 0;
        notifyItemRemoved(z);
    }

    public final int getItemCount() {
        if (this.f62493i) {
            return 1;
        }
        return this.f62489e.size() + this.f62487c + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r3 = r3.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r3, r0)
            boolean r0 = r3 instanceof net.one97.paytm.recharge.creditcard.v4.a.a.h
            if (r0 == 0) goto L_0x0034
            net.one97.paytm.recharge.creditcard.v4.a.a$h r3 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r3     // Catch:{ Exception -> 0x001a }
            java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8> r0 = r2.f62489e     // Catch:{ Exception -> 0x001a }
            int r1 = r2.f62487c     // Catch:{ Exception -> 0x001a }
            int r4 = r4 - r1
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x001a }
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r4 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r4     // Catch:{ Exception -> 0x001a }
            r3.a((net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r4)     // Catch:{ Exception -> 0x001a }
            return
        L_0x001a:
            r3 = move-exception
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r0 = r3.getMessage()
            r4.setErrorMsg(r0)
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r4, (java.lang.Throwable) r3)
            return
        L_0x0034:
            boolean r4 = r3 instanceof net.one97.paytm.recharge.creditcard.v4.a.a.c
            if (r4 == 0) goto L_0x0056
            net.one97.paytm.recharge.creditcard.v4.a.a$c r3 = (net.one97.paytm.recharge.creditcard.v4.a.a.c) r3
            android.widget.TextView r4 = r3.f62497a
            if (r4 == 0) goto L_0x0055
            android.widget.TextView r3 = r3.f62497a
            if (r3 == 0) goto L_0x004f
            android.content.Context r3 = r3.getContext()
            if (r3 == 0) goto L_0x004f
            int r0 = net.one97.paytm.recharge.R.string.visa_pay_bill_for_other_credit_card_v4
            java.lang.String r3 = r3.getString(r0)
            goto L_0x0050
        L_0x004f:
            r3 = 0
        L_0x0050:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4.setText(r3)
        L_0x0055:
            return
        L_0x0056:
            boolean r4 = r3 instanceof net.one97.paytm.recharge.creditcard.v4.a.a.g
            if (r4 == 0) goto L_0x0061
            net.one97.paytm.recharge.creditcard.v4.a.a$g r3 = (net.one97.paytm.recharge.creditcard.v4.a.a.g) r3
            net.one97.paytm.common.views.ShimmerFrameLayout r3 = r3.f62506a     // Catch:{ all -> 0x0061 }
            r3.a()     // Catch:{ all -> 0x0061 }
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        if (this.f62493i) {
            return 5;
        }
        if (i2 == 0) {
            if (this.j) {
                return 3;
            }
            if (this.f62492h) {
                return 4;
            }
            return 2;
        } else if (i2 != 1 || !this.j) {
            if (i2 == getItemCount() - 1) {
                return 1;
            }
            return 2;
        } else if (this.f62492h) {
            return 4;
        } else {
            return 2;
        }
    }

    public static final class h extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f62508a = ((ConstraintLayout) this.f62514g.findViewById(R.id.root_lyt_card_item));

        /* renamed from: b  reason: collision with root package name */
        TextView f62509b = ((TextView) this.f62514g.findViewById(R.id.txt_details));

        /* renamed from: c  reason: collision with root package name */
        public final CJRRechargeLottieAnimationView f62510c = ((CJRRechargeLottieAnimationView) this.f62514g.findViewById(R.id.loading_three_dots_lav));

        /* renamed from: d  reason: collision with root package name */
        public TextView f62511d = ((TextView) this.f62514g.findViewById(R.id.btn_pay_more));

        /* renamed from: e  reason: collision with root package name */
        public ConstraintLayout f62512e = ((ConstraintLayout) this.f62514g.findViewById(R.id.cardDetailsCL));

        /* renamed from: f  reason: collision with root package name */
        boolean f62513f;

        /* renamed from: g  reason: collision with root package name */
        View f62514g;

        /* renamed from: h  reason: collision with root package name */
        public f f62515h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f62516i = ((TextView) this.f62514g.findViewById(R.id.txt_card_number));
        private ImageView j = ((ImageView) this.f62514g.findViewById(R.id.bank_logo));
        private TextView k = ((TextView) this.f62514g.findViewById(R.id.fallbackBankNameTV));
        private ImageView l = ((ImageView) this.f62514g.findViewById(R.id.cardtypeView));
        private ImageView m = ((ImageView) this.f62514g.findViewById(R.id.saved_card_remove_menu));
        private TextView n = ((TextView) this.f62514g.findViewById(R.id.txt_card_due_info));
        private TextView o = ((TextView) this.f62514g.findViewById(R.id.txt_label_1));
        private TextView p = ((TextView) this.f62514g.findViewById(R.id.txt_label_2));
        private TextView q = ((TextView) this.f62514g.findViewById(R.id.txt_amount_1));
        private TextView r = ((TextView) this.f62514g.findViewById(R.id.txt_amount_2));
        private Group s = ((Group) this.f62514g.findViewById(R.id.total_due_group));
        private Group t = ((Group) this.f62514g.findViewById(R.id.min_due_group));
        private TextView u = ((TextView) this.f62514g.findViewById(R.id.txt_card_holder_name));
        private ImageView v = ((ImageView) this.f62514g.findViewById(R.id.cardBgIV));
        private LinearLayout w = ((LinearLayout) this.f62514g.findViewById(R.id.lyt_txt_details));
        private String x = "";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(View view, f fVar) {
            super(view);
            k.c(view, "view");
            this.f62514g = view;
            this.f62515h = fVar;
            View.OnClickListener onClickListener = this;
            this.f62508a.setOnClickListener(onClickListener);
            this.m.setOnClickListener(onClickListener);
        }

        public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8) {
            List<CJRProductsItem> productList;
            CJRAggsItem selectedDCVariant;
            List<CJRProductsItem> productList2;
            CJRProductsItem cJRProductsItem;
            List<CJRProductsItem> productList3;
            CJRProductsItem cJRProductsItem2;
            List<CJRProductsItem> productList4;
            List<CJRProductsItem> productList5;
            CJRProductsItem cJRProductsItem3;
            k.c(cJRCreditCardModelV8, "savedCard");
            this.f62512e.clearAnimation();
            this.f62508a.clearAnimation();
            ConstraintLayout constraintLayout = this.f62512e;
            k.a((Object) constraintLayout, "cardDetailsCL");
            ai.a(constraintLayout);
            ConstraintLayout constraintLayout2 = this.f62508a;
            k.a((Object) constraintLayout2, "cardView");
            ai.a(constraintLayout2);
            ConstraintLayout constraintLayout3 = this.f62508a;
            k.a((Object) constraintLayout3, "cardView");
            constraintLayout3.setTag(cJRCreditCardModelV8);
            ImageView imageView = this.m;
            k.a((Object) imageView, "optionImageView");
            imageView.setTag(cJRCreditCardModelV8);
            String nameOnCard = cJRCreditCardModelV8.getNameOnCard();
            if (nameOnCard == null || !net.one97.paytm.recharge.common.utils.g.c(nameOnCard)) {
                TextView textView = this.u;
                k.a((Object) textView, "cardHolderName");
                textView.setVisibility(8);
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.b(this.f62508a);
                TextView textView2 = this.f62516i;
                if (textView2 == null) {
                    k.a();
                }
                cVar.a(textView2.getId(), 4, com.paytm.utility.b.c(13));
                cVar.c(this.f62508a);
            } else {
                TextView textView3 = this.u;
                k.a((Object) textView3, "cardHolderName");
                textView3.setVisibility(0);
                TextView textView4 = this.u;
                k.a((Object) textView4, "cardHolderName");
                textView4.setText(cJRCreditCardModelV8.getNameOnCard());
            }
            CJRAggsItem selectedDCVariant2 = cJRCreditCardModelV8.getSelectedDCVariant();
            String str = "";
            if (selectedDCVariant2 == null || (productList5 = selectedDCVariant2.getProductList()) == null || (cJRProductsItem3 = productList5.get(0)) == null) {
                az azVar = az.f61525a;
                ImageView imageView2 = this.v;
                k.a((Object) imageView2, "cardBgIV");
                az.a(imageView2, str);
            } else {
                az azVar2 = az.f61525a;
                ImageView imageView3 = this.v;
                k.a((Object) imageView3, "cardBgIV");
                String cardBgV4 = cJRProductsItem3.getCardBgV4();
                if (cardBgV4 == null) {
                    cardBgV4 = str;
                }
                az.a(imageView3, cardBgV4);
            }
            TextView textView5 = this.f62516i;
            if (textView5 != null) {
                textView5.setText(cJRCreditCardModelV8.getDisplayCardNumber());
            }
            if (cJRCreditCardModelV8.getCardTypeId() != cJRCreditCardModelV8.getRecentCardId()) {
                Group group = this.s;
                if (group != null) {
                    ai.b(group);
                }
                Group group2 = this.t;
                if (group2 != null) {
                    ai.b(group2);
                }
                LinearLayout linearLayout = this.w;
                if (linearLayout != null) {
                    ai.b(linearLayout);
                }
                this.n.setTextColor(androidx.core.content.b.c(this.f62514g.getContext(), R.color.color_1d2f54));
                TextView textView6 = this.n;
                if (textView6 != null) {
                    textView6.setText(this.f62514g.getContext().getString(R.string.txt_save_card_desc_text));
                }
                TextView textView7 = this.n;
                if (textView7 != null) {
                    ai.a(textView7);
                }
            } else {
                TextView textView8 = this.n;
                if (textView8 != null) {
                    k.a((Object) textView8, "lastPaidOrDueDetailsView");
                    textView8.setTypeface(textView8.getTypeface(), 0);
                }
                b(cJRCreditCardModelV8);
            }
            CJRAggsItem selectedDCVariant3 = cJRCreditCardModelV8.getSelectedDCVariant();
            String str2 = null;
            if (!(selectedDCVariant3 == null || (productList4 = selectedDCVariant3.getProductList()) == null || !(!productList4.isEmpty()))) {
                CJRAggsItem selectedDCVariant4 = cJRCreditCardModelV8.getSelectedDCVariant();
                List<CJRProductsItem> productList6 = selectedDCVariant4 != null ? selectedDCVariant4.getProductList() : null;
                if (productList6 == null) {
                    k.a();
                }
                str = productList6.get(0).getCardTypeLogo();
            }
            CJRAggsItem selectedDCVariant5 = cJRCreditCardModelV8.getSelectedDCVariant();
            if (!(selectedDCVariant5 == null || (productList = selectedDCVariant5.getProductList()) == null || !(!productList.isEmpty()) || (selectedDCVariant = cJRCreditCardModelV8.getSelectedDCVariant()) == null || (productList2 = selectedDCVariant.getProductList()) == null || (cJRProductsItem = productList2.get(0)) == null)) {
                String bankNameLogoV4 = cJRProductsItem.getBankNameLogoV4();
                if (bankNameLogoV4 == null || !net.one97.paytm.recharge.common.utils.g.c(bankNameLogoV4)) {
                    ImageView imageView4 = this.j;
                    if (imageView4 != null) {
                        ai.b(imageView4);
                    }
                    TextView textView9 = this.k;
                    if (textView9 != null) {
                        CJRAggsItem selectedDCVariant6 = cJRCreditCardModelV8.getSelectedDCVariant();
                        if (!(selectedDCVariant6 == null || (productList3 = selectedDCVariant6.getProductList()) == null || (cJRProductsItem2 = productList3.get(0)) == null)) {
                            str2 = cJRProductsItem2.getOperatorDisplayLabel();
                        }
                        textView9.setText(str2);
                    }
                    TextView textView10 = this.k;
                    if (textView10 != null) {
                        ai.a(textView10);
                    }
                } else {
                    ImageView imageView5 = this.j;
                    k.a((Object) imageView5, "imgBankView");
                    ba.a(imageView5.getContext(), cJRProductsItem.getBankNameLogoV4(), this.j, false);
                    TextView textView11 = this.k;
                    if (textView11 != null) {
                        ai.b(textView11);
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                ImageView imageView6 = this.l;
                if (imageView6 != null) {
                    ai.a(imageView6);
                }
                w.a().a(str).a(this.l);
                return;
            }
            ImageView imageView7 = this.l;
            if (imageView7 != null) {
                ai.b(imageView7);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[Catch:{ all -> 0x00f0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00dd A[Catch:{ all -> 0x00f0 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r19) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                r2 = 0
                if (r1 == 0) goto L_0x0010
                int r3 = r19.getId()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                goto L_0x0011
            L_0x0010:
                r3 = r2
            L_0x0011:
                androidx.constraintlayout.widget.ConstraintLayout r4 = r0.f62508a
                java.lang.String r5 = "cardView"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                int r4 = r4.getId()
                java.lang.String r5 = "null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8"
                if (r3 != 0) goto L_0x0022
                goto L_0x00f1
            L_0x0022:
                int r6 = r3.intValue()
                if (r6 != r4) goto L_0x00f1
                net.one97.paytm.recharge.creditcard.v4.a.a$f r3 = r0.f62515h
                if (r3 == 0) goto L_0x00f0
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 21
                if (r3 <= r4) goto L_0x004e
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                android.content.Context r4 = r19.getContext()
                int r6 = net.one97.paytm.recharge.R.string.transition_name_cc_button
                java.lang.String r4 = r4.getString(r6)
                android.view.View r6 = new android.view.View
                android.content.Context r7 = r19.getContext()
                r6.<init>(r7)
                r3.put(r4, r6)
                goto L_0x004f
            L_0x004e:
                r3 = r2
            L_0x004f:
                java.lang.Object r4 = r19.getTag()
                if (r4 == 0) goto L_0x00ea
                net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r4 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r4
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                r6 = 0
                r8 = 0
                if (r5 == 0) goto L_0x0084
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                if (r5 == 0) goto L_0x0075
                java.lang.Double r5 = r5.getAmount()
                if (r5 == 0) goto L_0x0075
                double r9 = r5.doubleValue()
                int r5 = java.lang.Double.compare(r9, r6)
                goto L_0x0076
            L_0x0075:
                r5 = 0
            L_0x0076:
                if (r5 > 0) goto L_0x0079
                goto L_0x0084
            L_0x0079:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                if (r5 == 0) goto L_0x0084
                java.lang.Double r5 = r5.getAmount()
                goto L_0x0085
            L_0x0084:
                r5 = r2
            L_0x0085:
                r4.setTotalDue(r5)
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                if (r5 == 0) goto L_0x00af
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                if (r5 == 0) goto L_0x009d
                double r9 = r5.getMinDueAmount()
                int r5 = java.lang.Double.compare(r9, r6)
                goto L_0x009e
            L_0x009d:
                r5 = 0
            L_0x009e:
                if (r5 > 0) goto L_0x00a1
                goto L_0x00af
            L_0x00a1:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r4.getBillsDetails()
                if (r5 == 0) goto L_0x00af
                double r5 = r5.getMinDueAmount()
                java.lang.Double r2 = java.lang.Double.valueOf(r5)
            L_0x00af:
                r4.setMinDue(r2)
                net.one97.paytm.recharge.creditcard.v4.a.a$f r2 = r0.f62515h
                if (r2 == 0) goto L_0x00bc
                r5 = r0
                androidx.recyclerview.widget.RecyclerView$v r5 = (androidx.recyclerview.widget.RecyclerView.v) r5
                r2.a(r5, r4, r8, r3)
            L_0x00bc:
                net.one97.paytm.recharge.ordersummary.h.d r9 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ all -> 0x00f0 }
                android.content.Context r1 = r19.getContext()     // Catch:{ all -> 0x00f0 }
                java.lang.String r2 = "view.context"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00f0 }
                r9.<init>(r1)     // Catch:{ all -> 0x00f0 }
                java.lang.String r10 = "onus_credit_card"
                java.lang.String r11 = "pay_clicked_on_cc"
                java.lang.String r12 = ""
                java.lang.String r1 = r0.x     // Catch:{ all -> 0x00f0 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x00f0 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00f0 }
                if (r1 == 0) goto L_0x00dd
                java.lang.String r1 = "Pay Bill"
                goto L_0x00df
            L_0x00dd:
                java.lang.String r1 = r0.x     // Catch:{ all -> 0x00f0 }
            L_0x00df:
                r13 = r1
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 112(0x70, float:1.57E-43)
                net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x00f0 }
                return
            L_0x00ea:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r5)
                throw r1
            L_0x00f0:
                return
            L_0x00f1:
                android.widget.ImageView r2 = r0.m
                java.lang.String r4 = "optionImageView"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                int r2 = r2.getId()
                if (r3 != 0) goto L_0x00ff
                return
            L_0x00ff:
                int r3 = r3.intValue()
                if (r3 != r2) goto L_0x011f
                net.one97.paytm.recharge.creditcard.v4.a.a$f r2 = r0.f62515h
                if (r2 == 0) goto L_0x011f
                java.lang.Object r3 = r19.getTag()
                if (r3 == 0) goto L_0x0119
                net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r3 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r3
                int r4 = r18.getAdapterPosition()
                r2.a(r1, r3, r4)
                return
            L_0x0119:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r5)
                throw r1
            L_0x011f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.a.a.h.onClick(android.view.View):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x008a, code lost:
            r0 = r0.get("order_id");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x010f, code lost:
            if (r0 == null) goto L_0x0111;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void b(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r13) {
            /*
                r12 = this;
                java.lang.String r0 = r13.getCTAButtonText()
                r1 = 1
                if (r0 == 0) goto L_0x004e
                java.lang.String r2 = "pay_bill"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
                java.lang.String r2 = "itemView"
                java.lang.String r3 = "payMoreTV"
                if (r0 == 0) goto L_0x0031
                android.widget.TextView r0 = r12.f62511d
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                android.view.View r3 = r12.itemView
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
                android.content.Context r2 = r3.getContext()
                int r3 = net.one97.paytm.recharge.R.string.recharge_pay_bill
                java.lang.String r2 = r2.getString(r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                java.lang.String r0 = "Pay Bill"
                r12.x = r0
                goto L_0x004e
            L_0x0031:
                java.lang.String r0 = "Pay More"
                r12.x = r0
                android.widget.TextView r0 = r12.f62511d
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                android.view.View r3 = r12.itemView
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
                android.content.Context r2 = r3.getContext()
                int r3 = net.one97.paytm.recharge.R.string.recharge_pay_more
                java.lang.String r2 = r2.getString(r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
            L_0x004e:
                java.lang.String r0 = r13.getCTACollapseText()
                r2 = 0
                if (r0 == 0) goto L_0x0111
                java.lang.String r3 = "show_bill_details"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                java.lang.String r1 = "billDetailTextView"
                if (r0 == 0) goto L_0x0082
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x0068
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
            L_0x0068:
                android.widget.TextView r0 = r12.f62509b
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.view.View r1 = r12.f62514g
                android.content.Context r1 = r1.getContext()
                int r3 = net.one97.paytm.recharge.R.string.lbl_see_bill_details
                java.lang.String r1 = r1.getString(r3)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                kotlin.x r0 = kotlin.x.f47997a
                goto L_0x010f
            L_0x0082:
                java.util.HashMap r0 = r13.getCtaMap()
                java.lang.String r3 = "order_id"
                if (r0 == 0) goto L_0x0095
                java.lang.Object r0 = r0.get(r3)
                if (r0 == 0) goto L_0x0095
                java.lang.String r0 = r0.toString()
                goto L_0x0096
            L_0x0095:
                r0 = r2
            L_0x0096:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0102
                java.util.HashMap r0 = r13.getCtaMap()
                if (r0 == 0) goto L_0x00af
                java.lang.Object r0 = r0.get(r3)
                if (r0 == 0) goto L_0x00af
                java.lang.String r0 = r0.toString()
                goto L_0x00b0
            L_0x00af:
                r0 = r2
            L_0x00b0:
                r3 = r0
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00f6
                java.math.BigDecimal r3 = new java.math.BigDecimal
                r3.<init>(r0)
                long r3 = r3.longValue()
                r5 = 0
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x00ea
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x00d1
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
            L_0x00d1:
                android.widget.TextView r0 = r12.f62509b
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.view.View r1 = r12.f62514g
                android.content.Context r1 = r1.getContext()
                int r3 = net.one97.paytm.recharge.R.string.lbl_see_details
                java.lang.String r1 = r1.getString(r3)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                kotlin.x r0 = kotlin.x.f47997a
                goto L_0x010f
            L_0x00ea:
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x010e
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
                kotlin.x r0 = kotlin.x.f47997a
                goto L_0x010f
            L_0x00f6:
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x010e
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
                kotlin.x r0 = kotlin.x.f47997a
                goto L_0x010f
            L_0x0102:
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x010e
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
                kotlin.x r0 = kotlin.x.f47997a
                goto L_0x010f
            L_0x010e:
                r0 = r2
            L_0x010f:
                if (r0 != 0) goto L_0x011f
            L_0x0111:
                r0 = r12
                net.one97.paytm.recharge.creditcard.v4.a.a$h r0 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r0
                android.widget.LinearLayout r0 = r0.w
                if (r0 == 0) goto L_0x011f
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
                kotlin.x r0 = kotlin.x.f47997a
            L_0x011f:
                java.lang.String r0 = r13.getCTAMessage()
                java.lang.String r1 = "#1d2f54"
                if (r0 == 0) goto L_0x0144
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r3 = android.text.TextUtils.isEmpty(r0)
                if (r3 != 0) goto L_0x0153
                android.widget.TextView r3 = r12.n
                if (r3 == 0) goto L_0x0136
                r3.setText(r0)
            L_0x0136:
                android.widget.TextView r0 = r12.n
                java.lang.String r3 = r13.getCTAMessageColor()
                int r3 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r3, (java.lang.String) r1)
                r0.setTextColor(r3)
                goto L_0x0153
            L_0x0144:
                r0 = r12
                net.one97.paytm.recharge.creditcard.v4.a.a$h r0 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r0
                android.widget.TextView r0 = r0.n
                java.lang.String r3 = "lastPaidOrDueDetailsView"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
            L_0x0153:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r13.getBillsDetails()
                java.lang.String r3 = "txtAmount1"
                java.lang.String r4 = "textLabel1"
                if (r0 == 0) goto L_0x022c
                android.view.View r0 = r12.f62514g
                net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = r13.getBillsDetails()
                java.lang.String r8 = a((android.view.View) r0, (net.one97.paytm.common.entity.recharge.CJRBillDetails) r1)
                kotlin.g.b.x$b r10 = new kotlin.g.b.x$b
                r10.<init>()
                r0 = 0
                r10.element = r0
                kotlin.g.b.x$b r11 = new kotlin.g.b.x$b
                r11.<init>()
                r11.element = r0
                r0 = r8
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L_0x01b2
                android.widget.TextView r1 = r12.o
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                r1.setText(r0)
                net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r13.getBillsDetails()
                double r0 = r12.a(r8, r13, r0)
                r10.element = r0
                android.widget.TextView r0 = r12.q
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
                double r3 = r10.element
                java.lang.String r1 = java.lang.String.valueOf(r3)
                android.text.SpannableString r1 = net.one97.paytm.recharge.widgets.c.d.j(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                androidx.constraintlayout.widget.Group r0 = r12.s
                if (r0 == 0) goto L_0x01bb
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
                goto L_0x01bb
            L_0x01b2:
                androidx.constraintlayout.widget.Group r0 = r12.s
                if (r0 == 0) goto L_0x01bb
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
            L_0x01bb:
                android.view.View r0 = r12.f62514g
                net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = r13.getBillsDetails()
                java.lang.String r9 = b(r0, r1)
                r0 = r9
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L_0x0204
                android.widget.TextView r1 = r12.p
                java.lang.String r3 = "textLabel2"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                r1.setText(r0)
                net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r13.getBillsDetails()
                double r0 = r12.b(r9, r13, r0)
                r11.element = r0
                android.widget.TextView r0 = r12.r
                java.lang.String r1 = "txtAmount2"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
                double r3 = r11.element
                java.lang.String r1 = java.lang.String.valueOf(r3)
                android.text.SpannableString r1 = net.one97.paytm.recharge.widgets.c.d.j(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                androidx.constraintlayout.widget.Group r0 = r12.t
                if (r0 == 0) goto L_0x020d
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
                goto L_0x020d
            L_0x0204:
                androidx.constraintlayout.widget.Group r0 = r12.t
                if (r0 == 0) goto L_0x020d
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.b(r0)
            L_0x020d:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r13.getBillsDetails()
                if (r0 == 0) goto L_0x0217
                java.lang.String r2 = r0.getDueDate()
            L_0x0217:
                r13.setDueDate(r2)
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x022b
                net.one97.paytm.recharge.creditcard.v4.a.a$h$a r1 = new net.one97.paytm.recharge.creditcard.v4.a.a$h$a
                r5 = r1
                r6 = r12
                r7 = r13
                r5.<init>(r6, r7, r8, r9, r10, r11)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
            L_0x022b:
                return
            L_0x022c:
                int r0 = r13.getCardTypeId()
                int r2 = r13.getRecentCardId()
                if (r0 != r2) goto L_0x02b2
                android.widget.TextView r0 = r12.o
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                android.view.View r2 = r12.f62514g
                android.content.Context r2 = r2.getContext()
                int r4 = net.one97.paytm.recharge.R.string.lbl_last_paid
                java.lang.String r2 = r2.getString(r4)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                android.widget.TextView r0 = r12.q
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
                java.lang.String r2 = r13.getRechargeAmount()
                android.text.SpannableString r2 = net.one97.paytm.recharge.widgets.c.d.j(r2)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                androidx.constraintlayout.widget.Group r0 = r12.s
                if (r0 == 0) goto L_0x0269
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
            L_0x0269:
                java.lang.String r0 = r13.getCTAMessage()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x02a4
                java.lang.String r0 = r13.getCreatedAT()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x02a4
                android.widget.TextView r0 = r12.n
                if (r0 == 0) goto L_0x028e
                java.lang.String r2 = r13.getCreatedAT()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
            L_0x028e:
                android.widget.TextView r0 = r12.n
                java.lang.String r2 = r13.getCTAMessageColor()
                int r1 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r2, (java.lang.String) r1)
                r0.setTextColor(r1)
                android.widget.TextView r0 = r12.n
                if (r0 == 0) goto L_0x02a4
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
            L_0x02a4:
                android.widget.LinearLayout r0 = r12.w
                if (r0 == 0) goto L_0x02b2
                net.one97.paytm.recharge.creditcard.v4.a.a$h$b r1 = new net.one97.paytm.recharge.creditcard.v4.a.a$h$b
                r1.<init>(r12, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
            L_0x02b2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.a.a.h.b(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8):void");
        }

        /* renamed from: net.one97.paytm.recharge.creditcard.v4.a.a$h$a  reason: collision with other inner class name */
        static final class C1206a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f62517a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRCreditCardModelV8 f62518b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f62519c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f62520d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ x.b f62521e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ x.b f62522f;

            C1206a(h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8, String str, String str2, x.b bVar, x.b bVar2) {
                this.f62517a = hVar;
                this.f62518b = cJRCreditCardModelV8;
                this.f62519c = str;
                this.f62520d = str2;
                this.f62521e = bVar;
                this.f62522f = bVar2;
            }

            public final void onClick(View view) {
                String str;
                TextView textView = this.f62517a.f62509b;
                String string = this.f62517a.f62514g.getContext().getString(R.string.lbl_see_bill_details);
                k.a((Object) textView, "it");
                if (p.a(string, textView.getText().toString(), true)) {
                    if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(textView, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                        Bundle bundle = new Bundle();
                        CJRBillDetails billsDetails = this.f62518b.getBillsDetails();
                        String str2 = null;
                        bundle.putString("bill_date", ab.a(billsDetails != null ? billsDetails.getBillDate() : null, "yyyy-MM-dd", "dd MMM yy"));
                        CJRBillDetails billsDetails2 = this.f62518b.getBillsDetails();
                        bundle.putString("due_date", ab.a(billsDetails2 != null ? billsDetails2.getDueDate() : null, "yyyy-MM-dd", "dd MMM yy"));
                        bundle.putString(SDKConstants.AI_KEY_CARD_NUMBER, this.f62518b.getDisplayCardNumber());
                        bundle.putString(PayUtility.BANK_NAME, textView.getContext().getString(R.string.lbl_bank_name, new Object[]{this.f62518b.getOperaterName()}));
                        bundle.putString("bank_logo_url", this.f62518b.getOperaterImage());
                        bundle.putString("lbl_1", this.f62519c);
                        bundle.putString("lbl_2", this.f62520d);
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        bundle.putString("amount_1", String.valueOf(net.one97.paytm.recharge.widgets.c.d.j(String.valueOf(this.f62521e.element))));
                        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        bundle.putString("amount_2", String.valueOf(net.one97.paytm.recharge.widgets.c.d.j(String.valueOf(this.f62522f.element))));
                        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRBillDetails billsDetails3 = this.f62518b.getBillsDetails();
                        if (billsDetails3 != null) {
                            str2 = String.valueOf(billsDetails3.getMinDueAmount());
                        }
                        bundle.putString("min_amount", String.valueOf(net.one97.paytm.recharge.widgets.c.d.j(str2)));
                        f fVar = this.f62517a.f62515h;
                        if (fVar != null) {
                            fVar.a(bundle, this.f62517a, this.f62518b);
                        }
                    }
                    str = "See Bill Details";
                } else {
                    str = "";
                }
                h.a(this.f62517a, str);
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f62523a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRCreditCardModelV8 f62524b;

            b(h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8) {
                this.f62523a = hVar;
                this.f62524b = cJRCreditCardModelV8;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0038, code lost:
                r1 = r1.get("order_id");
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r12) {
                /*
                    r11 = this;
                    net.one97.paytm.recharge.creditcard.v4.a.a$h r0 = r11.f62523a
                    android.view.View r0 = r0.f62514g
                    android.content.Context r0 = r0.getContext()
                    int r1 = net.one97.paytm.recharge.R.string.lbl_see_details
                    java.lang.String r0 = r0.getString(r1)
                    net.one97.paytm.recharge.creditcard.v4.a.a$h r1 = r11.f62523a
                    android.widget.TextView r1 = r1.f62509b
                    java.lang.String r2 = "billDetailTextView"
                    kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                    java.lang.CharSequence r1 = r1.getText()
                    java.lang.String r1 = r1.toString()
                    r2 = 1
                    boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                    if (r0 == 0) goto L_0x00af
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
                    r0.<init>()
                    java.lang.String r1 = "recharge_order_summary"
                    r0.setUrlType(r1)
                    net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r11.f62524b
                    java.util.HashMap r1 = r1.getCtaMap()
                    if (r1 == 0) goto L_0x0045
                    java.lang.String r2 = "order_id"
                    java.lang.Object r1 = r1.get(r2)
                    if (r1 == 0) goto L_0x0045
                    java.lang.String r1 = r1.toString()
                    goto L_0x0046
                L_0x0045:
                    r1 = 0
                L_0x0046:
                    r2 = r1
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x005c
                    java.math.BigDecimal r2 = new java.math.BigDecimal
                    r2.<init>(r1)
                    long r1 = r2.longValue()
                    java.lang.String r1 = java.lang.String.valueOf(r1)
                L_0x005c:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "paytmmp://recharge_order_summary?url=https://cart.paytm.com/v2/myOrders/"
                    r2.<init>(r3)
                    r2.append(r1)
                    java.lang.String r1 = "/detail"
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    r0.setUrl(r1)
                    net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r1 = "it"
                    kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)     // Catch:{ Exception -> 0x0090 }
                    android.content.Context r3 = r12.getContext()     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r12 = "it.context"
                    kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r12)     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r4 = "recharge_order_summary"
                    r5 = r0
                    net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5     // Catch:{ Exception -> 0x0090 }
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r2.loadPage(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0090 }
                    goto L_0x00a8
                L_0x0090:
                    r12 = move-exception
                    net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "Unable to handle cc see-order details : "
                    r1.<init>(r2)
                    java.lang.String r12 = r12.getMessage()
                    r1.append(r12)
                    java.lang.String r12 = r1.toString()
                    r0.debugLog(r12)
                L_0x00a8:
                    net.one97.paytm.recharge.creditcard.v4.a.a$h r12 = r11.f62523a
                    java.lang.String r0 = "See Details"
                    net.one97.paytm.recharge.creditcard.v4.a.a.h.a((net.one97.paytm.recharge.creditcard.v4.a.a.h) r12, (java.lang.String) r0)
                L_0x00af:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.a.a.h.b.onClick(android.view.View):void");
            }
        }

        private static String a(View view, CJRBillDetails cJRBillDetails) {
            String str;
            if (cJRBillDetails == null || (cJRBillDetails.getOriginalDueAmount() == -1000.0d && cJRBillDetails.getMinDueAmount() == -1000.0d && cJRBillDetails.getOriginalMinDueAmount() == -1000.0d)) {
                String string = view.getContext().getString(R.string.lbl_last_paid);
                k.a((Object) string, "view.context.getString(R.string.lbl_last_paid)");
                return string;
            }
            if (cJRBillDetails.getOriginalDueAmount() != -1000.0d && k.a(cJRBillDetails.getAmount(), cJRBillDetails.getOriginalDueAmount())) {
                str = view.getContext().getString(R.string.lbl_total_due);
            } else if (k.a(cJRBillDetails.getAmount(), 0.0d) || (cJRBillDetails.getOriginalDueAmount() != -1000.0d && cJRBillDetails.getAmount().doubleValue() < cJRBillDetails.getOriginalDueAmount())) {
                str = view.getContext().getString(R.string.lbl_amount_due);
            } else {
                str = "";
            }
            k.a((Object) str, "if (cjrBillDetails.origi…         \"\"\n            }");
            return str;
        }

        private static String b(View view, CJRBillDetails cJRBillDetails) {
            String str = "";
            if (cJRBillDetails == null) {
                return str;
            }
            if (cJRBillDetails.getOriginalMinDueAmount() != -1000.0d && cJRBillDetails.getMinDueAmount() != -1000.0d && cJRBillDetails.getMinDueAmount() > 0.0d && (cJRBillDetails.getMinDueAmount() == cJRBillDetails.getOriginalDueAmount() || cJRBillDetails.getMinDueAmount() < cJRBillDetails.getOriginalDueAmount())) {
                str = view.getContext().getString(R.string.lbl_min_due);
            } else if (cJRBillDetails.getOriginalDueAmount() != -1000.0d && (cJRBillDetails.getMinDueAmount() == 0.0d || cJRBillDetails.getMinDueAmount() == -1000.0d)) {
                str = view.getContext().getString(R.string.lbl_last_paid);
            }
            k.a((Object) str, "if (cjrBillDetails.origi…         \"\"\n            }");
            return str;
        }

        private final double a(String str, CJRCreditCardModelV8 cJRCreditCardModelV8, CJRBillDetails cJRBillDetails) {
            Double d2;
            if (cJRBillDetails != null && !p.a(str, this.f62514g.getContext().getString(R.string.lbl_last_paid), true)) {
                if (p.a(str, this.f62514g.getContext().getString(R.string.lbl_total_due), true)) {
                    d2 = Double.valueOf(cJRBillDetails.getOriginalDueAmount());
                } else if (p.a(str, this.f62514g.getContext().getString(R.string.lbl_amount_due), true)) {
                    d2 = cJRBillDetails.getAmount();
                } else {
                    d2 = Double.valueOf(0.0d);
                }
                k.a((Object) d2, "if (label.equals(view.co…        0.0\n            }");
                return d2.doubleValue();
            } else if (cJRBillDetails != null) {
                return cJRBillDetails.getLastPaidAmount();
            } else {
                String rechargeAmount = cJRCreditCardModelV8.getRechargeAmount();
                if (rechargeAmount != null) {
                    return Double.parseDouble(rechargeAmount);
                }
                return 0.0d;
            }
        }

        private final double b(String str, CJRCreditCardModelV8 cJRCreditCardModelV8, CJRBillDetails cJRBillDetails) {
            if (cJRBillDetails == null || p.a(str, this.f62514g.getContext().getString(R.string.lbl_last_paid), true)) {
                if (cJRBillDetails != null && cJRBillDetails.getLastPaidAmount() == -1000.0d) {
                    String rechargeAmount = cJRCreditCardModelV8.getRechargeAmount();
                    if (rechargeAmount != null) {
                        return Double.parseDouble(rechargeAmount);
                    }
                    return 0.0d;
                } else if (cJRBillDetails != null) {
                    return cJRBillDetails.getLastPaidAmount();
                } else {
                    String rechargeAmount2 = cJRCreditCardModelV8.getRechargeAmount();
                    if (rechargeAmount2 != null) {
                        return Double.parseDouble(rechargeAmount2);
                    }
                    return 0.0d;
                }
            } else if (p.a(str, this.f62514g.getContext().getString(R.string.lbl_min_due), true)) {
                return cJRBillDetails.getMinDueAmount();
            } else {
                return 0.0d;
            }
        }

        public static final class d implements Animator.AnimatorListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f62526a;

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public d(h hVar) {
                this.f62526a = hVar;
            }

            public final void onAnimationEnd(Animator animator) {
                if (!this.f62526a.f62513f) {
                    ConstraintLayout b2 = this.f62526a.f62512e;
                    k.a((Object) b2, "cardDetailsCL");
                    ai.b(b2);
                    h.c(this.f62526a);
                }
            }
        }

        public static final class c implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f62525a;

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            c(h hVar) {
                this.f62525a = hVar;
            }

            public final void onAnimationEnd(Animation animation) {
                ViewPropertyAnimator listener;
                h hVar = this.f62525a;
                hVar.f62513f = true;
                ConstraintLayout d2 = hVar.f62508a;
                k.a((Object) d2, "cardView");
                ai.b(d2);
                f a2 = this.f62525a.f62515h;
                if (a2 != null) {
                    a2.b();
                }
                ViewPropertyAnimator animate = this.f62525a.f62512e.animate();
                if (animate != null) {
                    ConstraintLayout b2 = this.f62525a.f62512e;
                    k.a((Object) b2, "cardDetailsCL");
                    ViewPropertyAnimator translationY = animate.translationY((float) b2.getHeight());
                    if (translationY != null && (listener = translationY.setListener((Animator.AnimatorListener) null)) != null) {
                        listener.start();
                    }
                }
            }
        }

        public static final /* synthetic */ void a(h hVar, String str) {
            try {
                Context context = hVar.f62514g.getContext();
                k.a((Object) context, "view.context");
                net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context), "onus_credit_card", "see_bill_details_clicked", "", str, (Object) null, (Object) null, (Object) null, 112);
            } catch (Throwable unused) {
            }
        }

        public static final /* synthetic */ void c(h hVar) {
            Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setAnimationListener(new c(hVar));
            hVar.f62508a.startAnimation(scaleAnimation);
        }
    }

    public static final class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f62497a;

        /* renamed from: b  reason: collision with root package name */
        private CJRFooterViewWidgetV3 f62498b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f62499c;

        /* renamed from: d  reason: collision with root package name */
        private View f62500d;

        /* renamed from: e  reason: collision with root package name */
        private final f f62501e;

        /* renamed from: f  reason: collision with root package name */
        private Context f62502f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view, f fVar, Context context, String str, String str2) {
            super(view);
            k.c(view, "view");
            k.c(context, "context");
            k.c(str, "gaEventCategory");
            k.c(str2, "categoryId");
            this.f62500d = view;
            this.f62501e = fVar;
            this.f62502f = context;
            View findViewById = this.f62500d.findViewById(R.id.cardLogoIV);
            if (findViewById != null) {
                this.f62499c = (ImageView) findViewById;
                View findViewById2 = this.f62500d.findViewById(R.id.footer_text);
                if (findViewById2 != null) {
                    this.f62497a = (TextView) findViewById2;
                    View findViewById3 = this.f62500d.findViewById(R.id.footer_menu);
                    if (findViewById3 != null) {
                        this.f62498b = (CJRFooterViewWidgetV3) findViewById3;
                        CJRFooterViewWidgetV3 cJRFooterViewWidgetV3 = this.f62498b;
                        if (cJRFooterViewWidgetV3 != null) {
                            cJRFooterViewWidgetV3.setEventCategory(str);
                        }
                        CJRFooterViewWidgetV3 cJRFooterViewWidgetV32 = this.f62498b;
                        if (cJRFooterViewWidgetV32 != null) {
                            cJRFooterViewWidgetV32.setCategory(str2);
                        }
                        TextView textView = this.f62497a;
                        if (textView != null) {
                            textView.setOnClickListener(this);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }

        public final void onClick(View view) {
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            TextView textView = this.f62497a;
            if (k.a((Object) valueOf, (Object) textView != null ? Integer.valueOf(textView.getId()) : null)) {
                CJRCreditCardModelV8 cJRCreditCardModelV8 = new CJRCreditCardModelV8();
                cJRCreditCardModelV8.setCardTypeId(cJRCreditCardModelV8.getFreshCardId());
                f fVar = this.f62501e;
                if (fVar != null) {
                    fVar.a(this, cJRCreditCardModelV8, true, (HashMap<String, View>) null);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.a.a$a  reason: collision with other inner class name */
    public static final class C1205a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private TextView f62494a;

        /* renamed from: b  reason: collision with root package name */
        private View f62495b;

        /* renamed from: c  reason: collision with root package name */
        private final e f62496c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1205a(View view, e eVar) {
            super(view);
            k.c(view, "view");
            this.f62495b = view;
            this.f62496c = eVar;
            View findViewById = this.f62495b.findViewById(R.id.billDetailsTV);
            if (findViewById != null) {
                this.f62494a = (TextView) findViewById;
                TextView textView = this.f62494a;
                if (textView != null) {
                    textView.setOnClickListener(this);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        public final void onClick(View view) {
            e eVar;
            Integer num = null;
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            TextView textView = this.f62494a;
            if (textView != null) {
                num = Integer.valueOf(textView.getId());
            }
            if (k.a((Object) valueOf, (Object) num)) {
                net.one97.paytm.recharge.widgets.c.e eVar2 = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
                if (view == null) {
                    k.a();
                }
                if (!eVar2.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI()) && (eVar = this.f62496c) != null) {
                    eVar.a();
                }
            }
        }
    }

    public static final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private TextView f62503a;

        /* renamed from: b  reason: collision with root package name */
        private View f62504b;

        /* renamed from: c  reason: collision with root package name */
        private String f62505c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view, String str) {
            super(view);
            k.c(view, "view");
            this.f62504b = view;
            this.f62505c = str;
            View findViewById = this.f62504b.findViewById(R.id.topview);
            if (findViewById != null) {
                this.f62503a = (TextView) findViewById;
                TextView textView = this.f62503a;
                if (textView != null) {
                    textView.setText(this.f62505c);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class g extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ShimmerFrameLayout f62506a;

        /* renamed from: b  reason: collision with root package name */
        private View f62507b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(View view) {
            super(view);
            k.c(view, "view");
            this.f62507b = view;
            View findViewById = this.f62507b.findViewById(R.id.root_shimmer_lyt);
            k.a((Object) findViewById, "view.findViewById(R.id.root_shimmer_lyt)");
            this.f62506a = (ShimmerFrameLayout) findViewById;
        }
    }

    public final void a() {
        int i2 = 1;
        this.f62492h = true;
        if (this.j) {
            i2 = 2;
        }
        this.f62487c = i2;
        notifyDataSetChanged();
    }
}
