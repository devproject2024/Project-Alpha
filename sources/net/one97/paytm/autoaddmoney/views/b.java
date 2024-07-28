package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.appbar.AppBarLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.autoaddmoney.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;

public final class b extends net.one97.paytm.i.h implements AppBarLayout.b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f49323d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    IJRDataModel f49324a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f49325b;

    /* renamed from: c  reason: collision with root package name */
    boolean f49326c;

    /* renamed from: e  reason: collision with root package name */
    private NestedScrollView f49327e;

    /* renamed from: f  reason: collision with root package name */
    private String f49328f;

    /* renamed from: g  reason: collision with root package name */
    private CustomWalletLoaderDialog f49329g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.addmoney.a.e f49330h;

    /* renamed from: i  reason: collision with root package name */
    private String f49331i;
    private boolean j;
    private boolean k;
    private String l;
    private String m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    /* access modifiers changed from: private */
    public net.one97.paytm.autoaddmoney.c.b s;
    /* access modifiers changed from: private */
    public boolean t;
    private HashMap u;

    private View a(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d<T> implements z<net.one97.paytm.autoaddmoney.a<? extends x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49336a;

        d(b bVar) {
            this.f49336a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            this.f49336a.t = false;
            b.b(this.f49336a).setVisibility(0);
            net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity = this.f49336a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            a2.a(activity, (Bundle) null);
        }
    }

    static final class e<T> implements z<net.one97.paytm.autoaddmoney.a<? extends x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49337a;

        e(b bVar) {
            this.f49337a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            b.c(this.f49337a);
            b.a(this.f49337a, "Cancel_subscription_clicked");
        }
    }

    static final class f<T> implements z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49338a;

        f(b bVar) {
            this.f49338a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            com.paytm.network.a aVar2 = aVar != null ? (com.paytm.network.a) aVar.a() : null;
            if (aVar2 != null) {
                this.f49338a.a(aVar2);
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49339a;

        g(b bVar) {
            this.f49339a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                b.a(this.f49339a, (net.one97.paytm.autoaddmoney.b.d) aVar.a());
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.autoaddmoney.a<? extends x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49340a;

        h(b bVar) {
            this.f49340a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && ((x) aVar.a()) != null) {
                b bVar = this.f49340a;
                bVar.a((ArrayList<IJRDataModel>) bVar.f49325b);
                b.a(this.f49340a, "Change_Payment_clicked");
            }
        }
    }

    static final class i<T> implements z<net.one97.paytm.autoaddmoney.a<? extends x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49341a;

        i(b bVar) {
            this.f49341a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && ((x) aVar.a()) != null) {
                b.a(this.f49341a, "Change_Amount_clicked");
                net.one97.paytm.autoaddmoney.c.b e2 = this.f49341a.s;
                if (e2 != null) {
                    e2.a(false);
                }
            }
        }
    }

    public static final /* synthetic */ TextView b(b bVar) {
        TextView textView = bVar.o;
        if (textView == null) {
            k.a("tv_card_change");
        }
        return textView;
    }

    public final void onCreate(Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        LiveData liveData6;
        Window window;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(3);
        }
        if (getActivity() != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                this.s = (net.one97.paytm.autoaddmoney.c.b) net.one97.paytm.autoaddmoney.util.a.a((AmAutomaticActivity) activity2, net.one97.paytm.autoaddmoney.c.b.class);
                net.one97.paytm.autoaddmoney.c.b bVar = this.s;
                if (!(bVar == null || (liveData6 = bVar.n) == null)) {
                    liveData6.observe(this, new d(this));
                }
                net.one97.paytm.autoaddmoney.c.b bVar2 = this.s;
                if (!(bVar2 == null || (liveData5 = bVar2.f49202i) == null)) {
                    liveData5.observe(this, new e(this));
                }
                net.one97.paytm.autoaddmoney.c.b bVar3 = this.s;
                if (!(bVar3 == null || (liveData4 = bVar3.f49198e) == null)) {
                    liveData4.observe(this, new f(this));
                }
                net.one97.paytm.autoaddmoney.c.b bVar4 = this.s;
                if (!(bVar4 == null || (liveData3 = bVar4.f49194a) == null)) {
                    liveData3.observe(this, new g(this));
                }
                net.one97.paytm.autoaddmoney.c.b bVar5 = this.s;
                if (!(bVar5 == null || (liveData2 = bVar5.f49195b) == null)) {
                    liveData2.observe(this, new h(this));
                }
                net.one97.paytm.autoaddmoney.c.b bVar6 = this.s;
                if (bVar6 != null && (liveData = bVar6.f49196c) != null) {
                    liveData.observe(this, new i(this));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticActivity");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        net.one97.paytm.addmoney.a.e a2 = net.one97.paytm.addmoney.a.e.a(layoutInflater, viewGroup);
        k.a((Object) a2, "AmFragmentautoaddEditBin…flater, container, false)");
        this.f49330h = a2;
        net.one97.paytm.addmoney.a.e eVar = this.f49330h;
        if (eVar == null) {
            k.a("viewDataBinding");
        }
        eVar.setLifecycleOwner(this);
        net.one97.paytm.addmoney.a.e eVar2 = this.f49330h;
        if (eVar2 == null) {
            k.a("viewDataBinding");
        }
        return eVar2.getRoot();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        String str;
        String str2;
        IJRDataModel iJRDataModel = this.f49324a;
        if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card)) {
            CJRAvailableInstrumentsAddMoney.Card card = (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel;
            str = card.getCardScheme();
            k.a((Object) str, "card.cardScheme");
            str2 = card.getSavedCardId();
            TextView textView = this.n;
            if (textView == null) {
                k.a("tvBank_name_tv");
            }
            int i2 = R.string.card_name_format;
            String cardType = card.getCardType();
            k.a((Object) cardType, "card.cardType");
            textView.setText(getString(i2, card.getIssuerDisplayName(), p.a(cardType, "_", " ", false)));
            TextView textView2 = this.q;
            if (textView2 == null) {
                k.a("tv_cardno_tv");
            }
            textView2.setText(getString(R.string.card_number_format, card.getCardFirstFourDigit(), card.getCardLastFourDigits()));
        } else if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card)) {
            CJRAvailableInstrumentsAddMoneyCreditCard.Card card2 = (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
            str = card2.getCardScheme();
            k.a((Object) str, "card.cardScheme");
            str2 = card2.getSavedCardId();
            TextView textView3 = this.n;
            if (textView3 == null) {
                k.a("tvBank_name_tv");
            }
            int i3 = R.string.card_name_format;
            String cardType2 = card2.getCardType();
            k.a((Object) cardType2, "card.cardType");
            textView3.setText(getString(i3, card2.getIssuerDisplayName(), p.a(cardType2, "_", " ", false)));
            TextView textView4 = this.q;
            if (textView4 == null) {
                k.a("tv_cardno_tv");
            }
            textView4.setText(getString(R.string.card_number_format, card2.getCardFirstFourDigit(), card2.getCardLastFourDigits()));
        } else if (iJRDataModel == null || !(iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card)) {
            TextView textView5 = this.p;
            if (textView5 == null) {
                k.a("tv_linked_acc");
            }
            textView5.setVisibility(8);
            ImageView imageView = (ImageView) a(R.id.iv_bank_icon);
            k.a((Object) imageView, "iv_bank_icon");
            imageView.setVisibility(8);
            TextView textView6 = (TextView) a(R.id.bank_name_tv);
            k.a((Object) textView6, "bank_name_tv");
            textView6.setVisibility(8);
            TextView textView7 = (TextView) a(R.id.tv_card_number);
            k.a((Object) textView7, "tv_card_number");
            textView7.setVisibility(8);
            View a2 = a(R.id.pay_inner_divider);
            k.a((Object) a2, "pay_inner_divider");
            a2.setVisibility(8);
            TextView textView8 = this.o;
            if (textView8 == null) {
                k.a("tv_card_change");
            }
            textView8.setVisibility(8);
            View a3 = a(R.id.pay_divider);
            k.a((Object) a3, "pay_divider");
            a3.setVisibility(8);
            str2 = null;
            str = "";
        } else {
            TextView textView9 = this.n;
            if (textView9 == null) {
                k.a("tvBank_name_tv");
            }
            textView9.setText(((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel).getIssuerDisplayName());
            TextView textView10 = this.q;
            if (textView10 == null) {
                k.a("tv_cardno_tv");
            }
            int i4 = R.string.acc_number_format;
            Object[] objArr = new Object[1];
            String str3 = com.paytm.utility.b.l((Context) getActivity()).toString();
            if (str3 != null) {
                String substring = str3.substring(6, 10);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                objArr[0] = substring;
                textView10.setText(getString(i4, objArr));
                str2 = SDKConstants.AI_KEY_PPBL;
                str = str2;
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            b.C0869b.a aVar = b.C0869b.f49128a;
            if (p.a(str, b.C0869b.a.a(), true)) {
                ImageView imageView2 = this.r;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.maestro_icon_addmoney);
                }
            } else {
                b.C0869b.a aVar2 = b.C0869b.f49128a;
                if (p.a(str, b.C0869b.a.b(), true)) {
                    ImageView imageView3 = this.r;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.visa_logo_addmoney);
                    }
                } else {
                    b.C0869b.a aVar3 = b.C0869b.f49128a;
                    if (p.a(str, b.C0869b.a.c(), true)) {
                        ImageView imageView4 = this.r;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R.drawable.ic_mastercard_logo_addmoney);
                        }
                    } else {
                        b.C0869b.a aVar4 = b.C0869b.f49128a;
                        if (p.a(str, b.C0869b.a.d(), true)) {
                            ImageView imageView5 = this.r;
                            if (imageView5 != null) {
                                imageView5.setImageResource(R.drawable.diners_addmoney);
                            }
                        } else {
                            b.C0869b.a aVar5 = b.C0869b.f49128a;
                            if (p.a(str, b.C0869b.a.e(), true)) {
                                ImageView imageView6 = this.r;
                                if (imageView6 != null) {
                                    imageView6.setImageResource(R.drawable.jcb_addmoney);
                                }
                            } else {
                                b.C0869b.a aVar6 = b.C0869b.f49128a;
                                if (p.a(str, b.C0869b.a.f(), true)) {
                                    ImageView imageView7 = this.r;
                                    if (imageView7 != null) {
                                        imageView7.setImageResource(R.drawable.amex);
                                    }
                                } else if (str.equals(SDKConstants.AI_KEY_PPBL)) {
                                    ImageView imageView8 = this.r;
                                    if (imageView8 != null) {
                                        imageView8.setImageResource(R.drawable.ic_paytm_logo);
                                    }
                                } else {
                                    ImageView imageView9 = this.r;
                                    if (imageView9 != null) {
                                        imageView9.setImageResource(17170445);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    AmAutomaticActivity amAutomaticActivity = (AmAutomaticActivity) activity2;
                    amAutomaticActivity.f49287b = this.f49324a;
                    amAutomaticActivity.f49286a = str2;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticActivity");
            }
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        String replace;
        String str2;
        String replace2;
        super.onActivityCreated(bundle);
        Double d2 = null;
        try {
            Bundle arguments = getArguments();
            Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.containsKey("which_page")) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                Bundle arguments2 = getArguments();
                this.f49328f = arguments2 != null ? arguments2.getString("which_page") : null;
            }
            Bundle arguments3 = getArguments();
            Boolean valueOf2 = arguments3 != null ? Boolean.valueOf(arguments3.getBoolean("isEditMode", false)) : null;
            if (valueOf2 == null) {
                k.a();
            }
            this.k = valueOf2.booleanValue();
            Bundle arguments4 = getArguments();
            Boolean valueOf3 = arguments4 != null ? Boolean.valueOf(arguments4.getBoolean("fetch_status", false)) : null;
            if (valueOf3 == null) {
                k.a();
            }
            this.j = valueOf3.booleanValue();
            Bundle arguments5 = getArguments();
            this.l = arguments5 != null ? arguments5.getString("card_id") : null;
            Bundle arguments6 = getArguments();
            this.m = arguments6 != null ? arguments6.getString("auto_amount") : null;
            Bundle arguments7 = getArguments();
            this.f49331i = arguments7 != null ? arguments7.getString("min_amount") : null;
            Bundle arguments8 = getArguments();
            if ((arguments8 != null ? arguments8.getSerializable("SAVED_CARD") : null) != null) {
                Bundle arguments9 = getArguments();
                this.f49324a = (IJRDataModel) (arguments9 != null ? arguments9.getSerializable("SAVED_CARD") : null);
            }
            Bundle arguments10 = getArguments();
            Serializable serializable = arguments10 != null ? arguments10.getSerializable("SAVED_CARDS") : null;
            if (serializable != null && (serializable instanceof ArrayList)) {
                this.f49325b = (ArrayList) serializable;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.bank_name_tv) : null;
        if (textView == null) {
            k.a();
        }
        this.n = textView;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.tv_card_change) : null;
        if (textView2 == null) {
            k.a();
        }
        this.o = textView2;
        View view3 = getView();
        TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.tv_linked_acc) : null;
        if (textView3 == null) {
            k.a();
        }
        this.p = textView3;
        View view4 = getView();
        ImageView imageView = view4 != null ? (ImageView) view4.findViewById(R.id.iv_bank_icon) : null;
        if (imageView == null) {
            k.a();
        }
        this.r = imageView;
        View view5 = getView();
        TextView textView4 = view5 != null ? (TextView) view5.findViewById(R.id.tv_card_number) : null;
        if (textView4 == null) {
            k.a();
        }
        this.q = textView4;
        View view6 = getView();
        NestedScrollView nestedScrollView = view6 != null ? (NestedScrollView) view6.findViewById(R.id.scroll_view) : null;
        if (nestedScrollView == null) {
            k.a();
        }
        this.f49327e = nestedScrollView;
        if (!TextUtils.isEmpty(this.f49331i)) {
            String str3 = this.f49331i;
            Integer valueOf4 = str3 != null ? Integer.valueOf(p.a((CharSequence) str3, AppUtility.CENTER_DOT, 0, false, 6)) : null;
            if (valueOf4 == null) {
                k.a();
            }
            if (valueOf4.intValue() < 0) {
                str2 = this.f49331i;
            } else {
                String str4 = this.f49331i;
                str2 = (str4 == null || (replace2 = new l("0*$").replace((CharSequence) str4, "")) == null) ? null : new l("\\.$").replace((CharSequence) replace2, "");
            }
            this.f49331i = str2;
            TextView textView5 = (TextView) a(R.id.tv_am_desc);
            aa aaVar = aa.f47921a;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            String string = activity.getString(R.string.am_sub_desc);
            k.a((Object) string, "activity!!.getString(R.string.am_sub_desc)");
            String format = String.format(string, Arrays.copyOf(new Object[]{AddMoneyUtils.d(this.f49331i)}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView5.setText(format);
            TextView textView6 = (TextView) a(R.id.tv_am_desc);
            StringBuilder sb = new StringBuilder(StringUtility.NEW_LINE);
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            sb.append(activity2.getString(R.string.auto_am_time_check));
            textView6.append(sb.toString());
        }
        if (!TextUtils.isEmpty(this.m)) {
            String str5 = this.m;
            Integer valueOf5 = str5 != null ? Integer.valueOf(p.a((CharSequence) str5, AppUtility.CENTER_DOT, 0, false, 6)) : null;
            if (valueOf5 == null) {
                k.a();
            }
            if (valueOf5.intValue() < 0) {
                str = this.m;
            } else {
                String str6 = this.m;
                str = (str6 == null || (replace = new l("0*$").replace((CharSequence) str6, "")) == null) ? null : new l("\\.$").replace((CharSequence) replace, "");
            }
            this.m = str;
            ((TextView) a(R.id.tv_p2p_amount_add)).setText(getString(R.string.rs) + AddMoneyUtils.d(this.m));
        }
        a();
        Bundle arguments11 = getArguments();
        if ((arguments11 != null ? Double.valueOf(arguments11.getDouble("walletBalance")) : null) != null) {
            StringBuilder sb2 = new StringBuilder();
            Bundle arguments12 = getArguments();
            if (arguments12 != null) {
                d2 = Double.valueOf(arguments12.getDouble("walletBalance"));
            }
            sb2.append(d2);
            String d3 = AddMoneyUtils.d(sb2.toString());
            if (TextUtils.isEmpty(d3)) {
                d3 = "0.00";
            } else {
                k.a((Object) d3, "bal");
                if (p.b(d3, AppUtility.CENTER_DOT, false)) {
                    d3 = "0".concat(String.valueOf(d3));
                }
            }
            ((TextView) a(R.id.tv_wallet_balance)).setText(getString(R.string.uam_available_paytm_balance, d3));
        }
        net.one97.paytm.addmoney.a.e eVar = this.f49330h;
        if (eVar == null) {
            k.a("viewDataBinding");
        }
        eVar.a(this.s);
        net.one97.paytm.addmoney.a.e eVar2 = this.f49330h;
        if (eVar2 == null) {
            k.a("viewDataBinding");
        }
        eVar2.setLifecycleOwner(this);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, IJRDataModel iJRDataModel) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.STATUS, str);
        bundle.putString("STATUS_MESSAGE", str2);
        bundle.putSerializable("SAVED_CARD", iJRDataModel);
        iVar.setArguments(bundle);
        iVar.show(getChildFragmentManager(), b.class.getName());
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<IJRDataModel> arrayList) {
        new StringBuilder().append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        d dVar = new d();
        Bundle bundle = new Bundle();
        net.one97.paytm.autoaddmoney.util.d dVar2 = net.one97.paytm.autoaddmoney.util.d.f49283a;
        net.one97.paytm.autoaddmoney.util.d.a(arrayList);
        bundle.putSerializable("SAVED_CARDS", arrayList);
        bundle.putSerializable("AMOUNT_CHANGE", Boolean.valueOf(this.f49326c));
        bundle.putSerializable("SAVED_CARD", this.f49324a);
        bundle.putString("min_amount", com.paytm.utility.b.Q(this.f49331i));
        bundle.putString("auto_amount", com.paytm.utility.b.Q(this.m));
        bundle.putBoolean("EDIT_MODE", true);
        bundle.putBoolean("PAYMENT_MODE_CHANGE", true);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        bundle.putString("source", arguments.getString("source", ""));
        dVar.setArguments(bundle);
        dVar.show(getChildFragmentManager(), b.class.getName());
        com.paytm.utility.b.c((Activity) getActivity());
    }

    public final void a(com.paytm.network.a aVar) {
        k.c(aVar, "request");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new c(this, aVar));
        builder.show();
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49334a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f49335b;

        c(b bVar, com.paytm.network.a aVar) {
            this.f49334a = bVar;
            this.f49335b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f49334a.getActivity())) {
                this.f49335b.a();
            } else {
                this.f49334a.a(this.f49335b);
            }
        }
    }

    /* renamed from: net.one97.paytm.autoaddmoney.views.b$b  reason: collision with other inner class name */
    static final class C0876b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog f49333b;

        C0876b(b bVar, AlertDialog alertDialog) {
            this.f49332a = bVar;
            this.f49333b = alertDialog;
        }

        public final void onClick(View view) {
            this.f49333b.dismiss();
            if (this.f49332a.f49325b != null) {
                b bVar = this.f49332a;
                bVar.a((ArrayList<IJRDataModel>) bVar.f49325b);
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

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 2091) {
            a(this.f49325b);
        }
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        String.valueOf(i2);
    }

    public static final /* synthetic */ void c(b bVar) {
        TextView textView = bVar.o;
        if (textView == null) {
            k.a("tv_card_change");
        }
        textView.setVisibility(0);
        bVar.t = false;
        com.paytm.utility.b.c((Activity) bVar.getActivity());
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SAVED_CARD", bVar.f49324a);
        bundle.putString("min_amount", com.paytm.utility.b.Q(bVar.f49331i));
        bundle.putString("auto_amount", com.paytm.utility.b.Q(bVar.m));
        Bundle arguments = bVar.getArguments();
        if (arguments == null) {
            k.a();
        }
        bundle.putString("source", arguments.getString("source", ""));
        jVar.setArguments(bundle);
        FragmentActivity activity = bVar.getActivity();
        j supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            k.a();
        }
        jVar.show(supportFragmentManager, b.class.getName());
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = bVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context context = activity;
        Bundle arguments = bVar.getArguments();
        if (arguments == null) {
            k.a();
        }
        a2.a(context, "Auto Add Money", str, "", arguments.getString("source", ""), "", "", "");
    }

    public static final /* synthetic */ void a(b bVar, net.one97.paytm.autoaddmoney.b.d dVar) {
        CustomWalletLoaderDialog customWalletLoaderDialog;
        try {
            if (bVar.f49329g == null) {
                bVar.f49329g = new CustomWalletLoaderDialog(bVar.getActivity());
            }
            if (dVar == null || !dVar.f49160b) {
                if (bVar.f49329g != null && (customWalletLoaderDialog = bVar.f49329g) != null) {
                    customWalletLoaderDialog.dismissLoader();
                }
            } else if (bVar.f49329g != null) {
                CustomWalletLoaderDialog customWalletLoaderDialog2 = bVar.f49329g;
                if (customWalletLoaderDialog2 != null) {
                    customWalletLoaderDialog2.setTitle(dVar.f49159a);
                }
                CustomWalletLoaderDialog customWalletLoaderDialog3 = bVar.f49329g;
                if (customWalletLoaderDialog3 != null) {
                    customWalletLoaderDialog3.showLoader();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
