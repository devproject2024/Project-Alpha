package net.one97.paytm.autoaddmoney.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class b extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    public EditText f49119a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f49120b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49121c;

    /* renamed from: d  reason: collision with root package name */
    public int f49122d = -1;

    /* renamed from: e  reason: collision with root package name */
    final Activity f49123e;

    /* renamed from: f  reason: collision with root package name */
    final a f49124f;

    /* renamed from: g  reason: collision with root package name */
    final List<IJRDataModel> f49125g;

    /* renamed from: h  reason: collision with root package name */
    private final LayoutInflater f49126h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f49127i;

    public interface a {
        void a();

        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        int i3;
        int i4;
        String str3;
        int i5;
        String str4;
        int i6 = i2;
        c cVar = (c) vVar;
        k.c(cVar, "holder");
        cVar.f49139d.setTag(Integer.valueOf(i2));
        cVar.j.setTag(Integer.valueOf(i2));
        if (this.f49127i) {
            TextView textView = cVar.j;
            Activity activity = this.f49123e;
            textView.setText(activity != null ? activity.getString(R.string.proceed) : null);
        }
        TextView textView2 = this.f49121c;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        CharSequence f2 = net.one97.paytm.helper.a.f50546a.a().f("aam_activation_text");
        if (!TextUtils.isEmpty(f2)) {
            cVar.l.setText(f2);
            cVar.l.setVisibility(0);
        } else {
            cVar.l.setVisibility(8);
        }
        if (this.f49125g.get(i6) instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
            IJRDataModel iJRDataModel = this.f49125g.get(i6);
            if (iJRDataModel != null) {
                CJRAvailableInstrumentsAddMoneyCreditCard.Card card = (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
                TextView textView3 = cVar.f49138c;
                Activity activity2 = this.f49123e;
                textView3.setText(activity2 != null ? activity2.getString(R.string.card_number_format, new Object[]{card.getCardFirstFourDigit(), card.getCardLastFourDigits()}) : null);
                if (card.isChecked()) {
                    this.f49119a = cVar.f49141f;
                    AddMoneyUtils.a(cVar.f49141f, this.f49123e);
                    this.f49121c = cVar.f49143h;
                    i5 = 8;
                    cVar.f49142g.setVisibility(8);
                    EditText editText = this.f49119a;
                    if (editText != null) {
                        editText.setVisibility(0);
                    }
                    cVar.f49144i.setVisibility(0);
                    cVar.k.setVisibility(8);
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_active_addmoney_addmoney);
                    this.f49122d = i6;
                } else {
                    i5 = 8;
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_inactive_addmoney);
                    cVar.f49141f.setVisibility(8);
                    cVar.f49141f.clearFocus();
                    cVar.f49142g.setVisibility(8);
                    cVar.f49144i.setVisibility(8);
                    cVar.k.setVisibility(0);
                }
                cVar.f49143h.setVisibility(i5);
                str = card.getCardScheme();
                k.a((Object) str, "card.cardScheme");
                TextView textView4 = cVar.f49140e;
                Activity activity3 = this.f49123e;
                if (activity3 != null) {
                    int i7 = R.string.card_name_format;
                    String cardType = card.getCardType();
                    k.a((Object) cardType, "card.cardType");
                    str4 = activity3.getString(i7, new Object[]{card.getIssuerDisplayName(), p.a(cardType, "_", " ", false)});
                } else {
                    str4 = null;
                }
                textView4.setText(str4);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card");
            }
        } else if (this.f49125g.get(i6) instanceof CJRAvailableInstrumentsAddMoney.Card) {
            IJRDataModel iJRDataModel2 = this.f49125g.get(i6);
            if (iJRDataModel2 != null) {
                CJRAvailableInstrumentsAddMoney.Card card2 = (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel2;
                TextView textView5 = cVar.f49138c;
                Activity activity4 = this.f49123e;
                textView5.setText(activity4 != null ? activity4.getString(R.string.card_number_format, new Object[]{card2.getCardFirstFourDigit(), card2.getCardLastFourDigits()}) : null);
                if (card2.isChecked()) {
                    this.f49119a = cVar.f49141f;
                    AddMoneyUtils.a(cVar.f49141f, this.f49123e);
                    this.f49121c = cVar.f49143h;
                    EditText editText2 = this.f49119a;
                    if (editText2 != null) {
                        editText2.setVisibility(0);
                    }
                    i4 = 8;
                    cVar.f49142g.setVisibility(8);
                    cVar.f49144i.setVisibility(0);
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_active_addmoney_addmoney);
                    cVar.k.setVisibility(8);
                    this.f49122d = i6;
                } else {
                    i4 = 8;
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_inactive_addmoney);
                    cVar.f49141f.setVisibility(8);
                    cVar.f49142g.setVisibility(8);
                    cVar.f49144i.setVisibility(8);
                    cVar.k.setVisibility(0);
                    cVar.f49141f.clearFocus();
                }
                str = card2.getCardScheme();
                k.a((Object) str, "card.cardScheme");
                cVar.f49143h.setVisibility(i4);
                TextView textView6 = cVar.f49140e;
                Activity activity5 = this.f49123e;
                if (activity5 != null) {
                    int i8 = R.string.card_name_format;
                    String cardType2 = card2.getCardType();
                    k.a((Object) cardType2, "card.cardType");
                    str3 = activity5.getString(i8, new Object[]{card2.getIssuerDisplayName(), p.a(cardType2, "_", " ", false)});
                } else {
                    str3 = null;
                }
                textView6.setText(str3);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card");
            }
        } else if (this.f49125g.get(i6) instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
            IJRDataModel iJRDataModel3 = this.f49125g.get(i6);
            if (iJRDataModel3 != null) {
                CJRAvailableInstrumentsAddMoneyPPBL.Card card3 = (CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel3;
                TextView textView7 = cVar.f49138c;
                Activity activity6 = this.f49123e;
                if (activity6 != null) {
                    int i9 = R.string.acc_number_format;
                    Object[] objArr = new Object[1];
                    String str5 = com.paytm.utility.b.l((Context) this.f49123e).toString();
                    if (str5 != null) {
                        String substring = str5.substring(6, 10);
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        objArr[0] = substring;
                        str2 = activity6.getString(i9, objArr);
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    str2 = null;
                }
                textView7.setText(str2);
                if (card3.isChecked()) {
                    this.f49120b = cVar.f49142g;
                    this.f49121c = cVar.f49143h;
                    AddMoneyUtils.a(cVar.f49142g, this.f49123e);
                    cVar.l.setVisibility(8);
                    EditText editText3 = this.f49120b;
                    if (editText3 != null) {
                        editText3.setVisibility(0);
                    }
                    cVar.f49144i.setVisibility(0);
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_active_addmoney_addmoney);
                    i3 = 8;
                    cVar.k.setVisibility(8);
                    this.f49122d = i6;
                } else {
                    i3 = 8;
                    cVar.f49136a.setImageResource(R.drawable.ic_radio_inactive_addmoney);
                    cVar.f49142g.setVisibility(8);
                    cVar.f49141f.setVisibility(8);
                    cVar.l.setVisibility(8);
                    cVar.f49144i.setVisibility(8);
                    cVar.k.setVisibility(0);
                    cVar.f49142g.clearFocus();
                }
                cVar.f49143h.setVisibility(i3);
                TextView textView8 = this.f49121c;
                if (textView8 != null) {
                    textView8.setVisibility(i3);
                }
                cVar.f49140e.setText(card3.getIssuerDisplayName());
                str = SDKConstants.AI_KEY_PPBL;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card");
            }
        } else {
            str = "";
        }
        cVar.f49141f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        C0869b.a aVar = C0869b.f49128a;
        if (p.a(str, C0869b.a.a(), true)) {
            cVar.f49137b.setImageResource(R.drawable.maestro_icon_addmoney);
            return;
        }
        C0869b.a aVar2 = C0869b.f49128a;
        if (p.a(str, C0869b.a.b(), true)) {
            cVar.f49137b.setImageResource(R.drawable.visa_logo_addmoney);
            return;
        }
        C0869b.a aVar3 = C0869b.f49128a;
        if (p.a(str, C0869b.a.c(), true)) {
            cVar.f49137b.setImageResource(R.drawable.ic_mastercard_logo_addmoney);
            return;
        }
        C0869b.a aVar4 = C0869b.f49128a;
        if (p.a(str, C0869b.a.d(), true)) {
            cVar.f49137b.setImageResource(R.drawable.diners_addmoney);
            return;
        }
        C0869b.a aVar5 = C0869b.f49128a;
        if (p.a(str, C0869b.a.e(), true)) {
            cVar.f49137b.setImageResource(R.drawable.jcb_addmoney);
            return;
        }
        C0869b.a aVar6 = C0869b.f49128a;
        if (p.a(str, C0869b.a.f(), true)) {
            cVar.f49137b.setImageResource(R.drawable.amex);
            cVar.f49141f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        } else if (str.equals(SDKConstants.AI_KEY_PPBL)) {
            cVar.f49137b.setImageResource(R.drawable.ic_paytm_logo);
        } else {
            cVar.f49137b.setImageResource(17170445);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = this.f49126h.inflate(R.layout.am_select_card_adapter_row, viewGroup, false);
        k.a((Object) inflate, "view");
        return new c(this, inflate);
    }

    public b(Activity activity, a aVar, List<? extends IJRDataModel> list, boolean z) {
        k.c(aVar, "cardSelectListener");
        k.c(list, "savedcardList");
        this.f49123e = activity;
        this.f49124f = aVar;
        this.f49125g = list;
        this.f49127i = z;
        Activity activity2 = this.f49123e;
        Object systemService = activity2 != null ? activity2.getSystemService("layout_inflater") : null;
        if (systemService != null) {
            this.f49126h = (LayoutInflater) systemService;
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final String a() {
        String str = null;
        if (this.f49119a == null) {
            return null;
        }
        int i2 = 3;
        if (this.f49122d != -1 && c()) {
            i2 = 4;
        }
        EditText editText = this.f49119a;
        if (editText == null) {
            k.a();
        }
        String obj = editText.getText().toString();
        if (obj != null) {
            if (!(obj.length() == 0) && this.f49121c != null && obj.length() == i2) {
                TextView textView = this.f49121c;
                if (textView == null) {
                    k.a();
                }
                textView.setVisibility(8);
                return obj;
            }
        }
        TextView textView2 = this.f49121c;
        if (textView2 != null) {
            Activity activity = this.f49123e;
            if (activity != null) {
                str = activity.getString(R.string.enter_valid_cvv);
            }
            textView2.setText(str);
        }
        TextView textView3 = this.f49121c;
        if (textView3 == null) {
            k.a();
        }
        textView3.setVisibility(0);
        return obj;
    }

    public final String b() {
        EditText editText = this.f49120b;
        String str = null;
        if (editText == null) {
            return null;
        }
        if (editText == null) {
            k.a();
        }
        String obj = editText.getText().toString();
        if (obj != null) {
            if (!(obj.length() == 0) && this.f49121c != null && obj.length() == 4) {
                TextView textView = this.f49121c;
                if (textView == null) {
                    k.a();
                }
                textView.setVisibility(8);
                return obj;
            }
        }
        TextView textView2 = this.f49121c;
        if (textView2 != null) {
            Activity activity = this.f49123e;
            if (activity != null) {
                str = activity.getString(R.string.enter_valid_passcode);
            }
            textView2.setText(str);
        }
        TextView textView3 = this.f49121c;
        if (textView3 == null) {
            k.a();
        }
        textView3.setVisibility(0);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        if (!(this.f49125g.get(this.f49122d) instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card)) {
            return false;
        }
        IJRDataModel iJRDataModel = this.f49125g.get(this.f49122d);
        if (iJRDataModel != null) {
            String cardScheme = ((CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel).getCardScheme();
            C0869b.a aVar = C0869b.f49128a;
            if (p.a(cardScheme, C0869b.a.f(), true)) {
                return true;
            }
            return false;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card");
    }

    public final int getItemCount() {
        return this.f49125g.size();
    }

    /* renamed from: net.one97.paytm.autoaddmoney.a.b$b  reason: collision with other inner class name */
    public interface C0869b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49128a = a.f49129a;

        /* renamed from: net.one97.paytm.autoaddmoney.a.b$b$a */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ a f49129a = new a();

            /* renamed from: b  reason: collision with root package name */
            private static final String f49130b = f49130b;

            /* renamed from: c  reason: collision with root package name */
            private static final String f49131c = f49131c;

            /* renamed from: d  reason: collision with root package name */
            private static final String f49132d = f49132d;

            /* renamed from: e  reason: collision with root package name */
            private static final String f49133e = f49133e;

            /* renamed from: f  reason: collision with root package name */
            private static final String f49134f = f49134f;

            /* renamed from: g  reason: collision with root package name */
            private static final String f49135g = f49135g;

            private a() {
            }

            public static String a() {
                return f49130b;
            }

            public static String b() {
                return f49131c;
            }

            public static String c() {
                return f49132d;
            }

            public static String d() {
                return f49133e;
            }

            public static String e() {
                return f49134f;
            }

            public static String f() {
                return f49135g;
            }
        }
    }

    public final class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f49136a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f49137b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f49138c;

        /* renamed from: d  reason: collision with root package name */
        final View f49139d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f49140e;

        /* renamed from: f  reason: collision with root package name */
        final EditText f49141f;

        /* renamed from: g  reason: collision with root package name */
        final EditText f49142g;

        /* renamed from: h  reason: collision with root package name */
        final TextView f49143h;

        /* renamed from: i  reason: collision with root package name */
        final RelativeLayout f49144i;
        final TextView j;
        final View k;
        final TextView l;
        final /* synthetic */ b m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.m = bVar;
            View findViewById = view.findViewById(R.id.tv_acivate_am);
            if (findViewById != null) {
                this.j = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.separator);
                if (findViewById2 != null) {
                    this.k = findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_safegaurd);
                    if (findViewById3 != null) {
                        this.l = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.radio_button);
                        if (findViewById4 != null) {
                            this.f49136a = (ImageView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.activate_am_ly);
                            if (findViewById5 != null) {
                                this.f49144i = (RelativeLayout) findViewById5;
                                View findViewById6 = view.findViewById(R.id.card_type_iv);
                                if (findViewById6 != null) {
                                    this.f49137b = (ImageView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.tv_card_number);
                                    if (findViewById7 != null) {
                                        this.f49138c = (TextView) findViewById7;
                                        View findViewById8 = view.findViewById(R.id.parent_layout);
                                        k.a((Object) findViewById8, "itemView.findViewById(R.id.parent_layout)");
                                        this.f49139d = findViewById8;
                                        View findViewById9 = view.findViewById(R.id.bank_name_tv);
                                        if (findViewById9 != null) {
                                            this.f49140e = (TextView) findViewById9;
                                            View findViewById10 = view.findViewById(R.id.cvv_et);
                                            if (findViewById10 != null) {
                                                this.f49141f = (EditText) findViewById10;
                                                if (bVar.f49123e != null) {
                                                    this.f49141f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a((Context) this.m.f49123e, R.drawable.ic_card), (Drawable) null);
                                                }
                                                View findViewById11 = view.findViewById(R.id.passcode_et);
                                                if (findViewById11 != null) {
                                                    this.f49142g = (EditText) findViewById11;
                                                    View findViewById12 = view.findViewById(R.id.error_cvv);
                                                    if (findViewById12 != null) {
                                                        this.f49143h = (TextView) findViewById12;
                                                        View.OnClickListener onClickListener = this;
                                                        this.f49139d.setOnClickListener(onClickListener);
                                                        this.j.setOnClickListener(onClickListener);
                                                        this.f49142g.addTextChangedListener(new TextWatcher(this) {

                                                            /* renamed from: a  reason: collision with root package name */
                                                            final /* synthetic */ c f49145a;

                                                            public final void afterTextChanged(Editable editable) {
                                                            }

                                                            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                                            }

                                                            {
                                                                this.f49145a = r1;
                                                            }

                                                            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                                                this.f49145a.f49143h.setVisibility(8);
                                                                if (charSequence != null && charSequence.length() == 4) {
                                                                    b.a(this.f49145a.m, this.f49145a.f49142g);
                                                                }
                                                            }
                                                        });
                                                        this.f49141f.addTextChangedListener(new TextWatcher(this) {

                                                            /* renamed from: a  reason: collision with root package name */
                                                            final /* synthetic */ c f49146a;

                                                            public final void afterTextChanged(Editable editable) {
                                                            }

                                                            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                                            }

                                                            {
                                                                this.f49146a = r1;
                                                            }

                                                            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                                                this.f49146a.f49143h.setVisibility(8);
                                                                if (this.f49146a.m.f49122d != -1) {
                                                                    if ((this.f49146a.m.c() && charSequence != null && charSequence.length() == 4) || (!this.f49146a.m.c() && charSequence != null && charSequence.length() == 3)) {
                                                                        b.a(this.f49146a.m, this.f49146a.f49141f);
                                                                    }
                                                                }
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                                                }
                                                throw new u("null cannot be cast to non-null type android.widget.EditText");
                                            }
                                            throw new u("null cannot be cast to non-null type android.widget.EditText");
                                        }
                                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
            if (r5.length() == r0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
            if (r5.length() == 4) goto L_0x0067;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r5) {
            /*
                r4 = this;
                java.lang.String r0 = "view"
                kotlin.g.b.k.c(r5, r0)
                java.lang.Object r0 = r5.getTag()
                java.lang.String r0 = r0.toString()
                int r0 = java.lang.Integer.parseInt(r0)
                int r5 = r5.getId()
                int r1 = net.one97.paytm.addmoney.R.id.tv_acivate_am
                r2 = 1
                if (r5 != r1) goto L_0x0075
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r5.f49125g
                int r1 = r5.f49122d
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
                boolean r0 = r0 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card
                r1 = 4
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r5.b()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0066
                java.lang.String r5 = r5.b()
                if (r5 == 0) goto L_0x0066
                int r5 = r5.length()
                if (r5 != r1) goto L_0x0066
                goto L_0x0067
            L_0x0045:
                r0 = 3
                boolean r3 = r5.c()
                if (r3 == 0) goto L_0x004d
                r0 = 4
            L_0x004d:
                java.lang.String r1 = r5.a()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0066
                java.lang.String r5 = r5.a()
                if (r5 == 0) goto L_0x0066
                int r5 = r5.length()
                if (r5 != r0) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r2 = 0
            L_0x0067:
                if (r2 == 0) goto L_0x011d
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                net.one97.paytm.autoaddmoney.a.b$a r5 = r5.f49124f
                net.one97.paytm.autoaddmoney.a.b r0 = r4.m
                int r0 = r0.f49122d
                r5.a(r0)
                return
            L_0x0075:
                int r1 = net.one97.paytm.addmoney.R.id.parent_layout
                if (r5 != r1) goto L_0x011d
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                int r5 = r5.getItemCount()
                if (r5 <= 0) goto L_0x011d
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                int r5 = r5.f49122d
                if (r0 == r5) goto L_0x011d
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                int r1 = r5.f49122d
                r5.a(r1)
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                int r1 = r5.f49122d
                r5.notifyItemChanged(r1)
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r5 = r5.f49125g
                java.lang.Object r5 = r5.get(r0)
                net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5
                boolean r1 = r5 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card
                if (r1 == 0) goto L_0x00a9
                net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card r5 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card) r5
                r5.setChecked(r2)
                goto L_0x00bc
            L_0x00a9:
                boolean r1 = r5 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card
                if (r1 == 0) goto L_0x00b3
                net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard$Card r5 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card) r5
                r5.setChecked(r2)
                goto L_0x00bc
            L_0x00b3:
                boolean r1 = r5 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card
                if (r1 == 0) goto L_0x00bc
                net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL$Card r5 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card) r5
                r5.setChecked(r2)
            L_0x00bc:
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                android.widget.EditText r5 = r5.f49119a
                r1 = 8
                java.lang.String r2 = ""
                if (r5 == 0) goto L_0x00e2
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                android.widget.EditText r5 = r5.f49119a
                if (r5 != 0) goto L_0x00cf
                kotlin.g.b.k.a()
            L_0x00cf:
                r3 = r2
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r5.setText(r3)
                android.widget.EditText r5 = r4.f49141f
                r3 = r2
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r5.setText(r3)
                android.widget.TextView r5 = r4.f49143h
                r5.setVisibility(r1)
            L_0x00e2:
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                android.widget.EditText r5 = r5.f49120b
                if (r5 == 0) goto L_0x0103
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                android.widget.EditText r5 = r5.f49120b
                if (r5 != 0) goto L_0x00f1
                kotlin.g.b.k.a()
            L_0x00f1:
                r3 = r2
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r5.setText(r3)
                android.widget.EditText r5 = r4.f49142g
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r5.setText(r2)
                android.widget.TextView r5 = r4.f49143h
                r5.setVisibility(r1)
            L_0x0103:
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                android.widget.EditText r1 = r4.f49141f
                r5.f49119a = r1
                android.widget.EditText r1 = r4.f49142g
                r5.f49120b = r1
                android.widget.TextView r1 = r4.f49143h
                r5.f49121c = r1
                r5.notifyItemChanged(r0)
                net.one97.paytm.autoaddmoney.a.b r5 = r4.m
                r5.f49122d = r0
                net.one97.paytm.autoaddmoney.a.b$a r5 = r5.f49124f
                r5.a()
            L_0x011d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.a.b.c.onClick(android.view.View):void");
        }
    }

    public final void a(int i2) {
        if (i2 >= 0) {
            IJRDataModel iJRDataModel = this.f49125g.get(i2);
            if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card) {
                ((CJRAvailableInstrumentsAddMoney.Card) iJRDataModel).setChecked(false);
            } else if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                ((CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel).setChecked(false);
            } else if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                ((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel).setChecked(false);
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, View view) {
        Activity activity = bVar.f49123e;
        InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
        if (view != null) {
            if (inputMethodManager == null) {
                k.a();
            }
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
