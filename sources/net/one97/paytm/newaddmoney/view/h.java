package net.one97.paytm.newaddmoney.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.i;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.o;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.i.f;
import net.one97.paytm.newaddmoney.c.b;
import net.one97.paytm.newaddmoney.utils.AddMoneyCommonDestinationView;
import net.one97.paytm.newaddmoney.utils.e;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.newaddmoney.c.a f55963a;

    /* renamed from: b  reason: collision with root package name */
    private o f55964b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f55965c;

    public static final /* synthetic */ net.one97.paytm.newaddmoney.c.a a(h hVar) {
        net.one97.paytm.newaddmoney.c.a aVar = hVar.f55963a;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        String str;
        i<String> iVar;
        String str2;
        i<String> iVar2;
        String str3;
        i<String> iVar3;
        LayoutInflater layoutInflater2 = layoutInflater;
        k.c(layoutInflater2, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            b.a aVar = net.one97.paytm.newaddmoney.c.b.f55842a;
            FragmentActivity activity2 = getActivity();
            ai a2 = am.a(activity, (al.b) b.a.a(activity2 != null ? activity2.getApplication() : null, this)).a(net.one97.paytm.newaddmoney.c.a.class);
            k.a((Object) a2, "ViewModelProviders.of(it…neyViewModel::class.java)");
            this.f55963a = (net.one97.paytm.newaddmoney.c.a) a2;
        }
        boolean z = false;
        ViewDataBinding a3 = androidx.databinding.f.a(layoutInflater2, R.layout.layout_new_addmoney_selectdestination, viewGroup, false);
        if (a3 != null) {
            this.f55964b = (o) a3;
            if (getActivity() != null) {
                boolean a4 = e.a();
                String d2 = j.d(getActivity());
                AddMoneyCommonDestinationView addMoneyCommonDestinationView = new AddMoneyCommonDestinationView(getContext(), net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
                net.one97.paytm.newaddmoney.c.a aVar2 = this.f55963a;
                if (aVar2 == null) {
                    k.a("viewModel");
                }
                String str4 = aVar2.f55835e.get();
                CharSequence charSequence = str4;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    addMoneyCommonDestinationView.setSubTitle(str4);
                }
                if (a4) {
                    Context activity3 = getActivity();
                    String[] strArr = new String[4];
                    strArr[0] = e.a(getActivity());
                    strArr[1] = "";
                    strArr[2] = "";
                    net.one97.paytm.newaddmoney.c.a aVar3 = this.f55963a;
                    if (aVar3 == null) {
                        k.a("viewModel");
                    }
                    if (aVar3 == null || (iVar3 = aVar3.k) == null) {
                        str3 = null;
                    } else {
                        str3 = iVar3.get();
                    }
                    strArr[3] = str3;
                    net.one97.paytm.addmoney.utils.d.a(activity3, "add_money", "add_money_wallet_status", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), "Inactive");
                    String string = getString(R.string.now_acivate_wallet);
                    k.a((Object) string, "getString(R.string.now_acivate_wallet)");
                    addMoneyCommonDestinationView.setOtherText(string);
                    addMoneyCommonDestinationView.setOnClickListener(new b(this));
                    addMoneyCommonDestinationView.setDisabled(true);
                } else if (k.a((Object) "Non Wallet Account", (Object) d2)) {
                    Context activity4 = getActivity();
                    String[] strArr2 = new String[4];
                    strArr2[0] = e.a(getActivity());
                    strArr2[1] = "";
                    strArr2[2] = "";
                    net.one97.paytm.newaddmoney.c.a aVar4 = this.f55963a;
                    if (aVar4 == null) {
                        k.a("viewModel");
                    }
                    if (aVar4 == null || (iVar2 = aVar4.k) == null) {
                        str2 = null;
                    } else {
                        str2 = iVar2.get();
                    }
                    strArr2[3] = str2;
                    net.one97.paytm.addmoney.utils.d.a(activity4, "add_money", "add_money_wallet_status", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr2), "Inactive");
                    String string2 = getString(R.string.now_acivate_wallet);
                    k.a((Object) string2, "getString(R.string.now_acivate_wallet)");
                    addMoneyCommonDestinationView.setOtherText(string2);
                    addMoneyCommonDestinationView.setOnClickListener(new c(this));
                } else {
                    Context context = getContext();
                    String[] strArr3 = new String[4];
                    strArr3[0] = e.a(getActivity());
                    strArr3[1] = "";
                    strArr3[2] = "";
                    net.one97.paytm.newaddmoney.c.a aVar5 = this.f55963a;
                    if (aVar5 == null) {
                        k.a("viewModel");
                    }
                    if (aVar5 == null || (iVar = aVar5.k) == null) {
                        str = null;
                    } else {
                        str = iVar.get();
                    }
                    strArr3[3] = str;
                    net.one97.paytm.addmoney.utils.d.a(context, "add_money", "add_money_wallet_status", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr3), "Active");
                    net.one97.paytm.newaddmoney.c.a aVar6 = this.f55963a;
                    if (aVar6 == null) {
                        k.a("viewModel");
                    }
                    if (aVar6.o.getValue() == net.one97.paytm.newaddmoney.utils.b.TO_WALLET) {
                        addMoneyCommonDestinationView.setRadioButtonEnable(true);
                    }
                    addMoneyCommonDestinationView.setOnClickListener(new d(addMoneyCommonDestinationView, this));
                }
                o oVar = this.f55964b;
                if (!(oVar == null || (linearLayout2 = oVar.f48082b) == null)) {
                    linearLayout2.addView(addMoneyCommonDestinationView);
                }
            }
            AddMoneyCommonDestinationView addMoneyCommonDestinationView2 = new AddMoneyCommonDestinationView(getContext(), net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
            net.one97.paytm.newaddmoney.c.a aVar7 = this.f55963a;
            if (aVar7 == null) {
                k.a("viewModel");
            }
            CharSequence charSequence2 = aVar7.j.get();
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                net.one97.paytm.newaddmoney.c.a aVar8 = this.f55963a;
                if (aVar8 == null) {
                    k.a("viewModel");
                }
                addMoneyCommonDestinationView2.setSubTitle(aVar8.j.get());
            }
            net.one97.paytm.newaddmoney.c.a aVar9 = this.f55963a;
            if (aVar9 == null) {
                k.a("viewModel");
            }
            if (aVar9.o.getValue() == net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER) {
                addMoneyCommonDestinationView2.setRadioButtonEnable(true);
            }
            addMoneyCommonDestinationView2.setOnClickListener(new a(this, addMoneyCommonDestinationView2));
            o oVar2 = this.f55964b;
            if (!(oVar2 == null || (linearLayout = oVar2.f48082b) == null)) {
                linearLayout.addView(addMoneyCommonDestinationView2);
            }
            o oVar3 = this.f55964b;
            if (oVar3 != null) {
                return oVar3.getRoot();
            }
            return null;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.databinding.LayoutNewAddmoneySelectdestinationBinding");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f55966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AddMoneyCommonDestinationView f55967b;

        a(h hVar, AddMoneyCommonDestinationView addMoneyCommonDestinationView) {
            this.f55966a = hVar;
            this.f55967b = addMoneyCommonDestinationView;
        }

        public final void onClick(View view) {
            h.a(this.f55966a, this.f55967b, net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f55968a;

        b(h hVar) {
            this.f55968a = hVar;
        }

        public final void onClick(View view) {
            String str;
            i<String> iVar;
            Context activity = this.f55968a.getActivity();
            String[] strArr = new String[4];
            strArr[0] = e.a(this.f55968a.getActivity());
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a a2 = h.a(this.f55968a);
            if (a2 == null || (iVar = a2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(activity, "add_money", "add_money_wallet_activate", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
            net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            a3.a(context, "paytmmp://min_kyc?featuretype=popup");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f55969a;

        c(h hVar) {
            this.f55969a = hVar;
        }

        public final void onClick(View view) {
            String str;
            i<String> iVar;
            Context activity = this.f55969a.getActivity();
            String[] strArr = new String[4];
            strArr[0] = e.a(this.f55969a.getActivity());
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a a2 = h.a(this.f55969a);
            if (a2 == null || (iVar = a2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(activity, "add_money", "add_money_wallet_activate", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
            new net.one97.paytm.addmoney.landing.view.d().show(this.f55969a.getChildFragmentManager(), net.one97.paytm.addmoney.landing.view.d.class.getName());
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyCommonDestinationView f55970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f55971b;

        d(AddMoneyCommonDestinationView addMoneyCommonDestinationView, h hVar) {
            this.f55970a = addMoneyCommonDestinationView;
            this.f55971b = hVar;
        }

        public final void onClick(View view) {
            h.a(this.f55971b, this.f55970a, net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        if (!(getParentFragment() instanceof c) || getParentFragment() != null) {
            super.onDismiss(dialogInterface);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
    }

    public static final /* synthetic */ void a(h hVar, AddMoneyCommonDestinationView addMoneyCommonDestinationView, net.one97.paytm.newaddmoney.utils.b bVar) {
        LinearLayout linearLayout;
        o oVar = hVar.f55964b;
        if (!(oVar == null || (linearLayout = oVar.f48082b) == null)) {
            k.a((Object) linearLayout, "it");
            int childCount = linearLayout.getChildCount() - 1;
            if (childCount >= 0) {
                int i2 = 0;
                while (true) {
                    View childAt = linearLayout.getChildAt(i2);
                    if (childAt != null) {
                        ((AddMoneyCommonDestinationView) childAt).setRadioButtonEnable(false);
                        if (i2 == childCount) {
                            break;
                        }
                        i2++;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.utils.AddMoneyCommonDestinationView");
                    }
                }
            }
            addMoneyCommonDestinationView.setRadioButtonEnable(true);
        }
        net.one97.paytm.newaddmoney.c.a aVar = hVar.f55963a;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.o.postValue(bVar);
        hVar.dismiss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55965c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
