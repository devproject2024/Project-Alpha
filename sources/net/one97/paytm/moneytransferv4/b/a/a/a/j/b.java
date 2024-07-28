package net.one97.paytm.moneytransferv4.b.a.a.a.j;

import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;

public final class b extends e<a> {

    /* renamed from: b  reason: collision with root package name */
    public List<? extends AccountProviderBody.AccountProvider> f55321b;

    /* renamed from: c  reason: collision with root package name */
    private d f55322c;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        List<? extends AccountProviderBody.AccountProvider> list = this.f55321b;
        if (list != null) {
            ConstraintLayout constraintLayout = aVar.f55323a;
            k.a((Object) constraintLayout, "banksLayout");
            if (!f.d(constraintLayout)) {
                ConstraintLayout constraintLayout2 = aVar.f55323a;
                k.a((Object) constraintLayout2, "banksLayout");
                Collection collection = list;
                f.a((View) constraintLayout2, !collection.isEmpty());
                TextView textView = aVar.f55324b;
                k.a((Object) textView, "tvTitle");
                f.a((View) textView, !collection.isEmpty());
                TextView textView2 = aVar.f55325c;
                k.a((Object) textView2, "tvOffer");
                f.a((View) textView2, !collection.isEmpty());
                ImageView imageView = aVar.f55326d;
                k.a((Object) imageView, "mIcon1");
                TextView textView3 = aVar.f55330h;
                k.a((Object) textView3, "mItem1Tv");
                a.a((AccountProviderBody.AccountProvider) list.get(0), imageView, textView3);
                ImageView imageView2 = aVar.f55327e;
                k.a((Object) imageView2, "mIcon2");
                TextView textView4 = aVar.f55331i;
                k.a((Object) textView4, "mItem2Tv");
                a.a((AccountProviderBody.AccountProvider) list.get(1), imageView2, textView4);
                ImageView imageView3 = aVar.f55328f;
                k.a((Object) imageView3, "mIcon3");
                TextView textView5 = aVar.j;
                k.a((Object) textView5, "mItem3Tv");
                a.a((AccountProviderBody.AccountProvider) list.get(2), imageView3, textView5);
                ImageView imageView4 = aVar.f55329g;
                k.a((Object) imageView4, "mIcon4");
                TextView textView6 = aVar.k;
                k.a((Object) textView6, "mItem4Tv");
                a.a((AccountProviderBody.AccountProvider) list.get(3), imageView4, textView6);
                ((LinearLayout) aVar.l.findViewById(R.id.item1_ll)).setOnClickListener(new a.C1018a(aVar, list));
                ((LinearLayout) aVar.l.findViewById(R.id.item2_ll)).setOnClickListener(new a.C1019b(aVar, list));
                ((LinearLayout) aVar.l.findViewById(R.id.item3_ll)).setOnClickListener(new a.c(aVar, list));
                ((LinearLayout) aVar.l.findViewById(R.id.item4_ll)).setOnClickListener(new a.d(aVar, list));
                ((LinearLayout) aVar.l.findViewById(R.id.other_bank_ll)).setOnClickListener(new a.e(aVar));
                TextView textView7 = aVar.f55325c;
                k.a((Object) textView7, "tvOffer");
                View view = textView7;
                UpiGTMLoader instance = UpiGTMLoader.getInstance();
                k.a((Object) instance, "UpiGTMLoader.getInstance()");
                CharSequence upiOfferText = instance.getUpiOfferText();
                f.a(view, !(upiOfferText == null || upiOfferText.length() == 0));
                TextView textView8 = aVar.f55325c;
                k.a((Object) textView8, "tvOffer");
                try {
                    UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
                    k.a((Object) instance2, "UpiGTMLoader.getInstance()");
                    if (!TextUtils.isEmpty(instance2.getUpiOfferText())) {
                        textView8.setVisibility(0);
                        textView8.setMovementMethod(LinkMovementMethod.getInstance());
                        UpiGTMLoader instance3 = UpiGTMLoader.getInstance();
                        k.a((Object) instance3, "UpiGTMLoader.getInstance()");
                        String upiOfferText2 = instance3.getUpiOfferText();
                        k.a((Object) upiOfferText2, "offerText");
                        int a2 = p.a((CharSequence) upiOfferText2, "https", 0, false, 6);
                        int a3 = p.a((CharSequence) upiOfferText2, "'>", 0, false, 6);
                        if (upiOfferText2 != null) {
                            String substring = upiOfferText2.substring(a2, a3);
                            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (Build.VERSION.SDK_INT >= 24) {
                                str = Html.fromHtml(upiOfferText2, 0).toString();
                            } else {
                                str = Html.fromHtml(upiOfferText2).toString();
                            }
                            SpannableString spannableString = new SpannableString(str);
                            int a4 = p.a((CharSequence) str, "Know More", 0, false, 6);
                            spannableString.setSpan(new a.f(textView8, substring), a4, a4 + 9, 33);
                            textView8.setText(spannableString);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } catch (Exception unused) {
                    UpiGTMLoader instance4 = UpiGTMLoader.getInstance();
                    k.a((Object) instance4, "UpiGTMLoader.getInstance()");
                    if (!TextUtils.isEmpty(instance4.getUpiOfferText())) {
                        UpiGTMLoader instance5 = UpiGTMLoader.getInstance();
                        k.a((Object) instance5, "UpiGTMLoader.getInstance()");
                        textView8.setText(instance5.getUpiOfferText());
                        return;
                    }
                    textView8.setText(textView8.getContext().getString(R.string.upi_link_bank_money_transfer));
                }
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = net.one97.paytm.moneytransferv4.b.a.a.f.f55348a;
        return new a(f.a.a(viewGroup, g.WIDGET_TYPE_UPI_REGISTRATION.getId()), this.f55322c);
    }

    public final int a() {
        return g.WIDGET_TYPE_UPI_REGISTRATION.getId();
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55322c = dVar;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ConstraintLayout f55323a = ((ConstraintLayout) this.l.findViewById(R.id.cl_banks_layout));

        /* renamed from: b  reason: collision with root package name */
        final TextView f55324b = ((TextView) this.l.findViewById(R.id.tv_upi_registration_title));

        /* renamed from: c  reason: collision with root package name */
        final TextView f55325c = ((TextView) this.l.findViewById(R.id.tv_upi_registration_offer_text));

        /* renamed from: d  reason: collision with root package name */
        final ImageView f55326d = ((ImageView) this.l.findViewById(R.id.icon1));

        /* renamed from: e  reason: collision with root package name */
        final ImageView f55327e = ((ImageView) this.l.findViewById(R.id.icon2));

        /* renamed from: f  reason: collision with root package name */
        final ImageView f55328f = ((ImageView) this.l.findViewById(R.id.icon3));

        /* renamed from: g  reason: collision with root package name */
        final ImageView f55329g = ((ImageView) this.l.findViewById(R.id.icon4));

        /* renamed from: h  reason: collision with root package name */
        final TextView f55330h = ((TextView) this.l.findViewById(R.id.item1_tv));

        /* renamed from: i  reason: collision with root package name */
        final TextView f55331i = ((TextView) this.l.findViewById(R.id.item2_tv));
        final TextView j = ((TextView) this.l.findViewById(R.id.item3_tv));
        final TextView k = ((TextView) this.l.findViewById(R.id.item4_tv));
        View l;
        net.one97.paytm.moneytransferv4.b.a.a.d m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, net.one97.paytm.moneytransferv4.b.a.a.d dVar) {
            super(view);
            k.c(view, "view");
            this.l = view;
            this.m = dVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.j.b$a$a  reason: collision with other inner class name */
        static final class C1018a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55332a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f55333b;

            C1018a(a aVar, List list) {
                this.f55332a = aVar;
                this.f55333b = list;
            }

            public final void onClick(View view) {
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55332a.m;
                if (dVar != null) {
                    dVar.a((AccountProviderBody.AccountProvider) this.f55333b.get(0));
                }
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.j.b$a$b  reason: collision with other inner class name */
        static final class C1019b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55334a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f55335b;

            C1019b(a aVar, List list) {
                this.f55334a = aVar;
                this.f55335b = list;
            }

            public final void onClick(View view) {
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55334a.m;
                if (dVar != null) {
                    dVar.a((AccountProviderBody.AccountProvider) this.f55335b.get(1));
                }
            }
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55336a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f55337b;

            c(a aVar, List list) {
                this.f55336a = aVar;
                this.f55337b = list;
            }

            public final void onClick(View view) {
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55336a.m;
                if (dVar != null) {
                    dVar.a((AccountProviderBody.AccountProvider) this.f55337b.get(2));
                }
            }
        }

        static final class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55338a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f55339b;

            d(a aVar, List list) {
                this.f55338a = aVar;
                this.f55339b = list;
            }

            public final void onClick(View view) {
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55338a.m;
                if (dVar != null) {
                    dVar.a((AccountProviderBody.AccountProvider) this.f55339b.get(3));
                }
            }
        }

        static final class e implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55340a;

            e(a aVar) {
                this.f55340a = aVar;
            }

            public final void onClick(View view) {
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55340a.m;
                if (dVar != null) {
                    dVar.a((AccountProviderBody.AccountProvider) null);
                }
            }
        }

        static void a(AccountProviderBody.AccountProvider accountProvider, ImageView imageView, TextView textView) {
            String str = null;
            m.a(imageView, accountProvider != null ? accountProvider.getBankLogoUrl() : null, imageView.getContext());
            if (accountProvider != null) {
                str = accountProvider.getAccountProvider();
            }
            textView.setText(str);
        }

        public static final class f extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TextView f55341a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f55342b;

            f(TextView textView, String str) {
                this.f55341a = textView;
                this.f55342b = str;
            }

            public final void onClick(View view) {
                k.c(view, "textView");
                i a2 = i.a();
                k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                a2.c().a(this.f55341a.getContext(), this.f55342b);
            }

            public final void updateDrawState(TextPaint textPaint) {
                k.c(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }
}
