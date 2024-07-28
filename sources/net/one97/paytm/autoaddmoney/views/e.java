package net.one97.paytm.autoaddmoney.views;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.autoaddmoney.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49393a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<IJRDataModel> f49394b;

    /* renamed from: c  reason: collision with root package name */
    private String f49395c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f49396d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49397e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f49398f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f49399g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f49400h;

    /* renamed from: i  reason: collision with root package name */
    private String f49401i;
    private IJRDataModel j;
    private TextView k;
    /* access modifiers changed from: private */
    public net.one97.paytm.autoaddmoney.c.b l;
    private HashMap m;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.am_layout_deactivated, (ViewGroup) null);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        View findViewById;
        View findViewById2;
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.l = (net.one97.paytm.autoaddmoney.c.b) net.one97.paytm.autoaddmoney.util.a.a((AmAutomaticActivity) activity, net.one97.paytm.autoaddmoney.c.b.class);
            try {
                if (getArguments() != null) {
                    Bundle arguments = getArguments();
                    if (arguments == null) {
                        k.a();
                    }
                    String string = arguments.getString("min_amount");
                    k.a((Object) string, "arguments!!.getString(CJ…aramConstants.MIN_AMOUNT)");
                    this.f49395c = string;
                    Bundle arguments2 = getArguments();
                    if (arguments2 == null) {
                        k.a();
                    }
                    String string2 = arguments2.getString("auto_amount");
                    k.a((Object) string2, "arguments!!.getString(CJ…ramConstants.AUTO_AMOUNT)");
                    this.f49401i = string2;
                    Bundle arguments3 = getArguments();
                    if (arguments3 == null) {
                        k.a();
                    }
                    if (arguments3.containsKey("SAVED_CARD")) {
                        Bundle arguments4 = getArguments();
                        if ((arguments4 != null ? arguments4.getSerializable("SAVED_CARD") : null) != null) {
                            Bundle arguments5 = getArguments();
                            if (arguments5 == null) {
                                k.a();
                            }
                            Serializable serializable = arguments5.getSerializable("SAVED_CARD");
                            if (serializable != null) {
                                this.j = (IJRDataModel) serializable;
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.IJRDataModel");
                            }
                        }
                    }
                    Bundle arguments6 = getArguments();
                    if (arguments6 == null) {
                        k.a();
                    }
                    if (arguments6.containsKey("SAVED_CARDS")) {
                        Bundle arguments7 = getArguments();
                        Serializable serializable2 = arguments7 != null ? arguments7.getSerializable("SAVED_CARDS") : null;
                        if (serializable2 != null && (serializable2 instanceof ArrayList)) {
                            this.f49394b = (ArrayList) serializable2;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str2 = this.f49395c;
            if (str2 == null) {
                k.a("mMinAmount");
            }
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = this.f49396d;
                if (textView == null) {
                    k.a("mTvMinAmount");
                }
                int i2 = R.string.min_amount_rs;
                Object[] objArr = new Object[1];
                String str3 = this.f49395c;
                if (str3 == null) {
                    k.a("mMinAmount");
                }
                objArr[0] = str3;
                textView.setText(getString(i2, objArr));
                TextView textView2 = this.f49397e;
                if (textView2 == null) {
                    k.a("mTvAutoAmount");
                }
                int i3 = R.string.auto_amount_rs;
                Object[] objArr2 = new Object[1];
                String str4 = this.f49401i;
                if (str4 == null) {
                    k.a("mAutoAmount");
                }
                objArr2[0] = str4;
                textView2.setText(getString(i3, objArr2));
            }
            String str5 = this.f49401i;
            if (str5 == null) {
                k.a("mAutoAmount");
            }
            if (!TextUtils.isEmpty(str5)) {
                TextView textView3 = this.f49397e;
                if (textView3 == null) {
                    k.a("mTvAutoAmount");
                }
                int i4 = R.string.auto_amount_rs;
                Object[] objArr3 = new Object[1];
                String str6 = this.f49401i;
                if (str6 == null) {
                    k.a("mAutoAmount");
                }
                objArr3[0] = str6;
                textView3.setText(getString(i4, objArr3));
            }
            IJRDataModel iJRDataModel = this.j;
            if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card)) {
                CJRAvailableInstrumentsAddMoney.Card card = (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel;
                str = card.getCardScheme();
                k.a((Object) str, "card.cardScheme");
                TextView textView4 = this.f49398f;
                if (textView4 == null) {
                    k.a("mTvCardName");
                }
                int i5 = R.string.card_name_format;
                String cardType = card.getCardType();
                k.a((Object) cardType, "card.cardType");
                textView4.setText(getString(i5, card.getIssuerDisplayName(), p.a(cardType, "_", " ", false)));
                TextView textView5 = this.f49399g;
                if (textView5 == null) {
                    k.a("mTvCardNumber");
                }
                textView5.setText(getString(R.string.card_number_format, card.getCardFirstFourDigit(), card.getCardLastFourDigits()));
            } else if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card)) {
                CJRAvailableInstrumentsAddMoneyCreditCard.Card card2 = (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
                str = card2.getCardScheme();
                k.a((Object) str, "card.cardScheme");
                TextView textView6 = this.f49398f;
                if (textView6 == null) {
                    k.a("mTvCardName");
                }
                int i6 = R.string.card_name_format;
                String cardType2 = card2.getCardType();
                k.a((Object) cardType2, "card.cardType");
                textView6.setText(getString(i6, card2.getIssuerDisplayName(), p.a(cardType2, "_", " ", false)));
                TextView textView7 = this.f49399g;
                if (textView7 == null) {
                    k.a("mTvCardNumber");
                }
                textView7.setText(getString(R.string.card_number_format, card2.getCardFirstFourDigit(), card2.getCardLastFourDigits()));
            } else if (iJRDataModel == null || !(iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card)) {
                View view = getView();
                if (!(view == null || (findViewById2 = view.findViewById(R.id.linked_card_view)) == null)) {
                    findViewById2.setVisibility(8);
                }
                View view2 = getView();
                if (!(view2 == null || (findViewById = view2.findViewById(R.id.linked_tv)) == null)) {
                    findViewById.setVisibility(8);
                }
                str = "";
            } else {
                TextView textView8 = this.k;
                if (textView8 == null) {
                    k.a("mTvLinkedAccount");
                }
                textView8.setText(getString(R.string.linked_account));
                TextView textView9 = this.f49398f;
                if (textView9 == null) {
                    k.a("mTvCardName");
                }
                textView9.setText(((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel).getIssuerDisplayName());
                TextView textView10 = this.f49399g;
                if (textView10 == null) {
                    k.a("mTvCardNumber");
                }
                int i7 = R.string.acc_number_format;
                Object[] objArr4 = new Object[1];
                String str7 = com.paytm.utility.b.l((Context) getActivity()).toString();
                if (str7 != null) {
                    String substring = str7.substring(6, 10);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    objArr4[0] = substring;
                    textView10.setText(getString(i7, objArr4));
                    str = SDKConstants.AI_KEY_PPBL;
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                b.C0869b.a aVar = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.a(), true)) {
                    ImageView imageView = this.f49400h;
                    if (imageView == null) {
                        k.a("imglogo");
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.maestro_icon_addmoney);
                        return;
                    }
                    return;
                }
                b.C0869b.a aVar2 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.b(), true)) {
                    ImageView imageView2 = this.f49400h;
                    if (imageView2 == null) {
                        k.a("imglogo");
                    }
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.visa_logo_addmoney);
                        return;
                    }
                    return;
                }
                b.C0869b.a aVar3 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.c(), true)) {
                    ImageView imageView3 = this.f49400h;
                    if (imageView3 == null) {
                        k.a("imglogo");
                    }
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.ic_mastercard_logo_addmoney);
                        return;
                    }
                    return;
                }
                b.C0869b.a aVar4 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.d(), true)) {
                    ImageView imageView4 = this.f49400h;
                    if (imageView4 == null) {
                        k.a("imglogo");
                    }
                    if (imageView4 != null) {
                        imageView4.setImageResource(R.drawable.diners_addmoney);
                        return;
                    }
                    return;
                }
                b.C0869b.a aVar5 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.e(), true)) {
                    ImageView imageView5 = this.f49400h;
                    if (imageView5 == null) {
                        k.a("imglogo");
                    }
                    if (imageView5 != null) {
                        imageView5.setImageResource(R.drawable.jcb_addmoney);
                        return;
                    }
                    return;
                }
                b.C0869b.a aVar6 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.f(), true)) {
                    ImageView imageView6 = this.f49400h;
                    if (imageView6 == null) {
                        k.a("imglogo");
                    }
                    if (imageView6 != null) {
                        imageView6.setImageResource(R.drawable.amex);
                    }
                } else if (p.a(str, SDKConstants.AI_KEY_PPBL, true)) {
                    ImageView imageView7 = this.f49400h;
                    if (imageView7 == null) {
                        k.a("imglogo");
                    }
                    if (imageView7 != null) {
                        imageView7.setImageResource(R.drawable.ic_paytm_logo);
                    }
                } else {
                    ImageView imageView8 = this.f49400h;
                    if (imageView8 == null) {
                        k.a("imglogo");
                    }
                    if (imageView8 != null) {
                        imageView8.setImageResource(17170445);
                    }
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticActivity");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_min_amount);
        k.a((Object) findViewById, "view.findViewById(R.id.tv_min_amount)");
        this.f49396d = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_card_number);
        k.a((Object) findViewById2, "view.findViewById(R.id.tv_card_number)");
        this.f49399g = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.bank_name_tv);
        k.a((Object) findViewById3, "view.findViewById(R.id.bank_name_tv)");
        this.f49398f = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_auto_add_amount);
        k.a((Object) findViewById4, "view.findViewById(R.id.tv_auto_add_amount)");
        this.f49397e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.iv_bank_icon);
        k.a((Object) findViewById5, "view.findViewById(R.id.iv_bank_icon)");
        this.f49400h = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.linked_tv);
        k.a((Object) findViewById6, "view.findViewById(R.id.linked_tv)");
        this.k = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_activate_am);
        if (findViewById7 != null) {
            ((RelativeLayout) view.findViewById(R.id.help_layout)).setOnClickListener(new b(this));
            ((TextView) findViewById7).setOnClickListener(new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f49402a;

        b(e eVar) {
            this.f49402a = eVar;
        }

        public final void onClick(View view) {
            e.a(this.f49402a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f49403a;

        c(e eVar) {
            this.f49403a = eVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.autoaddmoney.c.b b2 = this.f49403a.l;
            if (b2 != null) {
                b2.a(true);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(e eVar) {
        net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = eVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        a2.a(activity, (Bundle) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
