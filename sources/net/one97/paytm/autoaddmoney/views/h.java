package net.one97.paytm.autoaddmoney.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
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
import net.one97.paytm.helper.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class h extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    private String f49443a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f49444b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f49445c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f49446d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49447e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f49448f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f49449g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f49450h;

    /* renamed from: i  reason: collision with root package name */
    private String f49451i;
    private IJRDataModel j;
    private HashMap k;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.am_frag_activated, (ViewGroup) null);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        TextView textView;
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            String string = arguments.getString("min_amount");
            k.a((Object) string, "arguments!!.getString(CJ…aramConstants.MIN_AMOUNT)");
            this.f49443a = string;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            String string2 = arguments2.getString("auto_amount");
            k.a((Object) string2, "arguments!!.getString(CJ…ramConstants.AUTO_AMOUNT)");
            this.f49451i = string2;
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
        }
        if (getContext() != null) {
            String string3 = getString(R.string.am_descrption_text);
            k.a((Object) string3, "getString(R.string.am_descrption_text)");
            CharSequence charSequence = string3;
            int a2 = p.a(charSequence, "‘", 0, false, 6);
            int a3 = p.a(charSequence, "’", 0, false, 6);
            TextView textView2 = this.f49445c;
            if (textView2 == null) {
                k.a("mTvDesText");
            }
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = this.f49445c;
            if (textView3 == null) {
                k.a("mTvDesText");
            }
            textView3.setText(charSequence, TextView.BufferType.SPANNABLE);
            TextView textView4 = this.f49445c;
            if (textView4 == null) {
                k.a("mTvDesText");
            }
            CharSequence text = textView4.getText();
            if (text != null) {
                ((Spannable) text).setSpan(new b(this), a2, a3 + 1, 33);
                String str2 = this.f49443a;
                if (str2 == null) {
                    k.a("mMinAmount");
                }
                if (!TextUtils.isEmpty(str2)) {
                    TextView textView5 = this.f49444b;
                    if (textView5 == null) {
                        k.a("mTvMinAmount");
                    }
                    int i2 = R.string.min_amount_rs;
                    Object[] objArr = new Object[1];
                    String str3 = this.f49443a;
                    if (str3 == null) {
                        k.a("mMinAmount");
                    }
                    objArr[0] = str3;
                    textView5.setText(getString(i2, objArr));
                    TextView textView6 = this.f49446d;
                    if (textView6 == null) {
                        k.a("mTvAutoAmount");
                    }
                    int i3 = R.string.auto_amount_rs;
                    Object[] objArr2 = new Object[1];
                    String str4 = this.f49451i;
                    if (str4 == null) {
                        k.a("mAutoAmount");
                    }
                    objArr2[0] = str4;
                    textView6.setText(getString(i3, objArr2));
                }
                String str5 = this.f49451i;
                if (str5 == null) {
                    k.a("mAutoAmount");
                }
                if (!TextUtils.isEmpty(str5)) {
                    TextView textView7 = this.f49446d;
                    if (textView7 == null) {
                        k.a("mTvAutoAmount");
                    }
                    int i4 = R.string.auto_amount_rs;
                    Object[] objArr3 = new Object[1];
                    String str6 = this.f49451i;
                    if (str6 == null) {
                        k.a("mAutoAmount");
                    }
                    objArr3[0] = str6;
                    textView7.setText(getString(i4, objArr3));
                }
                IJRDataModel iJRDataModel = this.j;
                if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card)) {
                    CJRAvailableInstrumentsAddMoney.Card card = (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel;
                    str = card.getCardScheme();
                    k.a((Object) str, "card.cardScheme");
                    TextView textView8 = this.f49447e;
                    if (textView8 == null) {
                        k.a("mTvCardName");
                    }
                    int i5 = R.string.card_name_format;
                    String cardType = card.getCardType();
                    k.a((Object) cardType, "card.cardType");
                    textView8.setText(getString(i5, card.getIssuerDisplayName(), p.a(cardType, "_", " ", false)));
                    TextView textView9 = this.f49448f;
                    if (textView9 == null) {
                        k.a("mTvCardNumber");
                    }
                    textView9.setText(getString(R.string.card_number_format, card.getCardFirstFourDigit(), card.getCardLastFourDigits()));
                } else if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card)) {
                    CJRAvailableInstrumentsAddMoneyCreditCard.Card card2 = (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
                    str = card2.getCardScheme();
                    k.a((Object) str, "card.cardScheme");
                    TextView textView10 = this.f49447e;
                    if (textView10 == null) {
                        k.a("mTvCardName");
                    }
                    int i6 = R.string.card_name_format;
                    String cardType2 = card2.getCardType();
                    k.a((Object) cardType2, "card.cardType");
                    textView10.setText(getString(i6, card2.getIssuerDisplayName(), p.a(cardType2, "_", " ", false)));
                    TextView textView11 = this.f49448f;
                    if (textView11 == null) {
                        k.a("mTvCardNumber");
                    }
                    textView11.setText(getString(R.string.card_number_format, card2.getCardFirstFourDigit(), card2.getCardLastFourDigits()));
                } else if (iJRDataModel == null || !(iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card)) {
                    str = "";
                } else {
                    TextView textView12 = this.f49450h;
                    if (textView12 == null) {
                        k.a("mTvLinkedAccount");
                    }
                    textView12.setText(getString(R.string.linked_account));
                    TextView textView13 = this.f49447e;
                    if (textView13 == null) {
                        k.a("mTvCardName");
                    }
                    textView13.setText(((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel).getIssuerDisplayName());
                    TextView textView14 = this.f49448f;
                    if (textView14 == null) {
                        k.a("mTvCardNumber");
                    }
                    int i7 = R.string.acc_number_format;
                    Object[] objArr4 = new Object[1];
                    String str7 = com.paytm.utility.b.l((Context) getActivity()).toString();
                    if (str7 != null) {
                        String substring = str7.substring(6, 10);
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        objArr4[0] = substring;
                        textView14.setText(getString(i7, objArr4));
                        str = SDKConstants.AI_KEY_PPBL;
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    b.C0869b.a aVar = b.C0869b.f49128a;
                    if (p.a(str, b.C0869b.a.a(), true)) {
                        ImageView imageView = this.f49449g;
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.maestro_icon_addmoney);
                        }
                    } else {
                        b.C0869b.a aVar2 = b.C0869b.f49128a;
                        if (p.a(str, b.C0869b.a.b(), true)) {
                            ImageView imageView2 = this.f49449g;
                            if (imageView2 != null) {
                                imageView2.setImageResource(R.drawable.visa_logo_addmoney);
                            }
                        } else {
                            b.C0869b.a aVar3 = b.C0869b.f49128a;
                            if (p.a(str, b.C0869b.a.c(), true)) {
                                ImageView imageView3 = this.f49449g;
                                if (imageView3 != null) {
                                    imageView3.setImageResource(R.drawable.ic_mastercard_logo_addmoney);
                                }
                            } else {
                                b.C0869b.a aVar4 = b.C0869b.f49128a;
                                if (p.a(str, b.C0869b.a.d(), true)) {
                                    ImageView imageView4 = this.f49449g;
                                    if (imageView4 != null) {
                                        imageView4.setImageResource(R.drawable.diners_addmoney);
                                    }
                                } else {
                                    b.C0869b.a aVar5 = b.C0869b.f49128a;
                                    if (p.a(str, b.C0869b.a.e(), true)) {
                                        ImageView imageView5 = this.f49449g;
                                        if (imageView5 != null) {
                                            imageView5.setImageResource(R.drawable.jcb_addmoney);
                                        }
                                    } else {
                                        b.C0869b.a aVar6 = b.C0869b.f49128a;
                                        if (p.a(str, b.C0869b.a.f(), true)) {
                                            ImageView imageView6 = this.f49449g;
                                            if (imageView6 != null) {
                                                imageView6.setImageResource(R.drawable.amex);
                                            }
                                        } else if (p.a(str, SDKConstants.AI_KEY_PPBL, true)) {
                                            ImageView imageView7 = this.f49449g;
                                            if (imageView7 != null) {
                                                imageView7.setImageResource(R.drawable.ic_paytm_logo);
                                            }
                                        } else {
                                            ImageView imageView8 = this.f49449g;
                                            if (imageView8 != null) {
                                                imageView8.setImageResource(17170445);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                View view = getView();
                if (view != null && (textView = (TextView) view.findViewById(R.id.tv_am_time)) != null) {
                    textView.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.text.Spannable");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_am_descrption_text);
        k.a((Object) findViewById, "view.findViewById(R.id.tv_am_descrption_text)");
        this.f49445c = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_linked_account);
        k.a((Object) findViewById2, "view.findViewById(R.id.tv_linked_account)");
        this.f49450h = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_min_amount);
        k.a((Object) findViewById3, "view.findViewById(R.id.tv_min_amount)");
        this.f49444b = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_card_number);
        k.a((Object) findViewById4, "view.findViewById(R.id.tv_card_number)");
        this.f49448f = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_amount_auto_add);
        k.a((Object) findViewById5, "view.findViewById(R.id.tv_amount_auto_add)");
        this.f49446d = (TextView) findViewById5;
        this.f49449g = (ImageView) view.findViewById(R.id.iv_bank_icon);
        View findViewById6 = view.findViewById(R.id.bank_name_tv);
        k.a((Object) findViewById6, "view.findViewById(R.id.bank_name_tv)");
        this.f49447e = (TextView) findViewById6;
        ((RelativeLayout) view.findViewById(R.id.help_layout)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f49452a;

        a(h hVar) {
            this.f49452a = hVar;
        }

        public final void onClick(View view) {
            h.a(this.f49452a);
        }
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f49453a;

        b(h hVar) {
            this.f49453a = hVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            this.f49453a.startActivity(new Intent(this.f49453a.getActivity(), AmAutomaticActivity.class));
            FragmentActivity activity = this.f49453a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final /* synthetic */ void a(h hVar) {
        c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = hVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        a2.a(activity, (Bundle) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
