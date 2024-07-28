package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.c.a;
import net.one97.paytm.bankOpen.ica.model.ICALoanModel;
import net.one97.paytm.bankOpen.ica.model.Option;

public final class l extends e {

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.bankCommon.f.d f16562b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16563c = ": ";

    /* renamed from: d  reason: collision with root package name */
    private HashMap f16564d;

    public final View a(int i2) {
        if (this.f16564d == null) {
            this.f16564d = new HashMap();
        }
        View view = (View) this.f16564d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16564d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        HashMap hashMap = this.f16564d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    public static final /* synthetic */ net.one97.paytm.bankCommon.f.d a(l lVar) {
        net.one97.paytm.bankCommon.f.d dVar = lVar.f16562b;
        if (dVar == null) {
            k.a("fragmentActionListener");
        }
        return dVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_review_detail_fragment, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.bankCommon.f.d) {
            this.f16562b = (net.one97.paytm.bankCommon.f.d) context;
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList<ICALoanModel> c2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View findViewById = view2 != null ? view2.findViewById(R.id.iv_back_arrow) : null;
        if (findViewById != null) {
            if (findViewById != null) {
                findViewById.setOnClickListener(new d(this));
            }
            ((Button) a(R.id.save_btn)).setOnClickListener(new e(this));
            View inflate = getLayoutInflater().inflate(R.layout.pb_ca_review_item_title, (LinearLayout) a(R.id.review_lyt), false);
            k.a((Object) inflate, "panView");
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            k.a((Object) textView, "panView.title");
            int i2 = R.string.pb_ca_pan_no;
            boolean z = true;
            Object[] objArr = new Object[1];
            a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() == null) {
                k.a();
            }
            objArr[0] = net.one97.paytm.bankOpen.ica.c.a.e();
            textView.setText(getString(i2, objArr));
            View inflate2 = getLayoutInflater().inflate(R.layout.pb_ca_review_item_title, (LinearLayout) a(R.id.review_lyt), false);
            k.a((Object) inflate2, "businessView");
            TextView textView2 = (TextView) inflate2.findViewById(R.id.title);
            k.a((Object) textView2, "businessView.title");
            textView2.setText(getString(R.string.pb_ca_biz_details));
            TextView textView3 = (TextView) inflate2.findViewById(R.id.edit_tv);
            k.a((Object) textView3, "businessView.edit_tv");
            textView3.setVisibility(0);
            ((TextView) inflate2.findViewById(R.id.edit_tv)).setOnClickListener(new a(this));
            View inflate3 = getLayoutInflater().inflate(R.layout.pb_ca_review_item_detail_tv, (ViewGroup) null, false);
            k.a((Object) inflate3, "bizDetailLyt");
            TextView textView4 = (TextView) inflate3.findViewById(R.id.details_title_tv);
            k.a((Object) textView4, "bizDetailLyt.details_title_tv");
            textView4.setVisibility(8);
            StringBuilder sb = new StringBuilder("");
            a.C0240a aVar2 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            HashMap<String, Option> b2 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.b() : null;
            if (b2 != null) {
                for (Map.Entry entry : b2.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append(this.f16563c);
                    sb.append(((Option) entry.getValue()).getText());
                    sb.append(StringUtility.NEW_LINE);
                }
                TextView textView5 = (TextView) inflate3.findViewById(R.id.details_info_tv);
                k.a((Object) textView5, "bizDetailLyt.details_info_tv");
                textView5.setText(sb.toString());
            }
            ((LinearLayout) inflate2.findViewById(R.id.review_list_lyt)).addView(inflate3);
            try {
                a.C0240a aVar3 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                Integer valueOf = (a.C0240a.a() == null || (c2 = net.one97.paytm.bankOpen.ica.c.a.c()) == null) ? null : Integer.valueOf(c2.size());
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 0) {
                    ((LinearLayout) inflate2.findViewById(R.id.review_list_lyt)).addView(getLayoutInflater().inflate(R.layout.pb_ca_loan_line, (ViewGroup) null, false));
                    a.C0240a aVar4 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                    ArrayList<ICALoanModel> c3 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.c() : null;
                    if (c3 != null) {
                        Iterator<ICALoanModel> it2 = c3.iterator();
                        while (it2.hasNext()) {
                            ICALoanModel next = it2.next();
                            StringBuilder sb2 = new StringBuilder("");
                            sb2.append(next.getBankName());
                            sb2.append("-");
                            sb2.append(next.getTypeOfLoan());
                            sb2.append(StringUtility.NEW_LINE);
                            sb2.append(getString(R.string.pb_ca_acc_no_loan_item));
                            sb2.append(" ");
                            sb2.append(next.getAccountNumber());
                            sb2.append(StringUtility.NEW_LINE);
                            sb2.append(getString(R.string.si_ifsc));
                            sb2.append(this.f16563c);
                            sb2.append(next.getIfscCode());
                            sb2.append(StringUtility.NEW_LINE);
                            sb2.append(getString(R.string.pb_ca_current_outstanding_principal));
                            sb2.append("-");
                            sb2.append(next.getCurrentPrincipalOutstanding());
                            sb2.append(StringUtility.NEW_LINE);
                            sb2.append(getString(R.string.pb_ca_amount_sanctioned));
                            sb2.append("-");
                            sb2.append(next.getLoanAmount());
                            sb2.append(StringUtility.NEW_LINE);
                            View inflate4 = getLayoutInflater().inflate(R.layout.pb_ca_review_item_detail_tv, (LinearLayout) a(R.id.review_lyt), false);
                            k.a((Object) inflate4, "loanDetailLyt");
                            TextView textView6 = (TextView) inflate4.findViewById(R.id.details_title_tv);
                            k.a((Object) textView6, "loanDetailLyt.details_title_tv");
                            textView6.setText(getString(R.string.pb_ca_loan_details));
                            TextView textView7 = (TextView) inflate4.findViewById(R.id.details_info_tv);
                            k.a((Object) textView7, "loanDetailLyt.details_info_tv");
                            textView7.setText(sb2);
                            ((LinearLayout) inflate2.findViewById(R.id.review_list_lyt)).addView(inflate4);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a.C0240a aVar5 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() == null) {
                k.a();
            }
            if (net.one97.paytm.bankOpen.ica.c.a.e().length() != 0) {
                z = false;
            }
            if (!z) {
                ((LinearLayout) a(R.id.review_lyt)).addView(inflate);
            }
            ((LinearLayout) a(R.id.review_lyt)).addView(inflate2);
            View inflate5 = getLayoutInflater().inflate(R.layout.pb_ca_review_item_title, (ViewGroup) null, false);
            k.a((Object) inflate5, "nomineeView");
            TextView textView8 = (TextView) inflate5.findViewById(R.id.title);
            k.a((Object) textView8, "nomineeView.title");
            textView8.setText(getString(R.string.pb_ca_nominee_details));
            a.C0240a aVar6 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() == null) {
                k.a();
            }
            if (net.one97.paytm.bankOpen.ica.c.a.d() == null) {
                TextView textView9 = (TextView) inflate5.findViewById(R.id.edit_tv);
                k.a((Object) textView9, "nomineeView.edit_tv");
                textView9.setText(getString(R.string.pb_ca_add));
                ((TextView) inflate5.findViewById(R.id.edit_tv)).setOnClickListener(new b(this));
            } else {
                View inflate6 = getLayoutInflater().inflate(R.layout.pb_ca_review_item_detail_tv, (ViewGroup) null, false);
                k.a((Object) inflate6, "nomineeDetailLyt");
                TextView textView10 = (TextView) inflate6.findViewById(R.id.details_title_tv);
                k.a((Object) textView10, "nomineeDetailLyt.details_title_tv");
                textView10.setVisibility(8);
                x.e eVar = new x.e();
                a.C0240a aVar7 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() == null) {
                    k.a();
                }
                eVar.element = net.one97.paytm.bankOpen.ica.c.a.d();
                StringBuilder sb3 = new StringBuilder("");
                sb3.append(getString(R.string.pb_ca_name));
                sb3.append(this.f16563c);
                NomineeModel nomineeModel = (NomineeModel) eVar.element;
                if (nomineeModel == null) {
                    k.a();
                }
                sb3.append(nomineeModel.getName());
                sb3.append(StringUtility.NEW_LINE);
                sb3.append(getString(R.string.pb_ca_dob));
                sb3.append(this.f16563c);
                sb3.append(((NomineeModel) eVar.element).getDob());
                sb3.append(StringUtility.NEW_LINE);
                sb3.append(getString(R.string.pb_ca_relationship));
                sb3.append(this.f16563c);
                sb3.append(((NomineeModel) eVar.element).getRelationship());
                sb3.append(StringUtility.NEW_LINE);
                sb3.append(getString(R.string.pb_ca_address));
                sb3.append(this.f16563c);
                sb3.append(((NomineeModel) eVar.element).getHouseNo());
                sb3.append(AppConstants.COMMA);
                sb3.append(((NomineeModel) eVar.element).getAreaName());
                sb3.append(AppConstants.COMMA);
                sb3.append(((NomineeModel) eVar.element).getCity());
                sb3.append("-");
                sb3.append(((NomineeModel) eVar.element).getPinCode());
                sb3.append(StringUtility.NEW_LINE);
                TextView textView11 = (TextView) inflate6.findViewById(R.id.details_info_tv);
                k.a((Object) textView11, "nomineeDetailLyt.details_info_tv");
                textView11.setText(sb3);
                ((LinearLayout) inflate5.findViewById(R.id.review_list_lyt)).addView(inflate6);
                TextView textView12 = (TextView) inflate5.findViewById(R.id.edit_tv);
                k.a((Object) textView12, "nomineeView.edit_tv");
                textView12.setText(getString(R.string.pb_nominee_edit));
                ((TextView) inflate5.findViewById(R.id.edit_tv)).setOnClickListener(new c(this, eVar));
            }
            ((LinearLayout) a(R.id.review_lyt)).addView(inflate5);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16569a;

        d(l lVar) {
            this.f16569a = lVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16569a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16570a;

        e(l lVar) {
            this.f16570a = lVar;
        }

        public final void onClick(View view) {
            if (l.a(this.f16570a) != null) {
                l.a(this.f16570a).onFragmentAction(110, (Object) null);
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16565a;

        a(l lVar) {
            this.f16565a = lVar;
        }

        public final void onClick(View view) {
            if (l.a(this.f16565a) != null) {
                l.a(this.f16565a).onFragmentAction(109, (Object) null);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16566a;

        b(l lVar) {
            this.f16566a = lVar;
        }

        public final void onClick(View view) {
            if (l.a(this.f16566a) != null) {
                l.a(this.f16566a).onFragmentAction(106, (Object) null);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16567a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f16568b;

        c(l lVar, x.e eVar) {
            this.f16567a = lVar;
            this.f16568b = eVar;
        }

        public final void onClick(View view) {
            if (l.a(this.f16567a) != null) {
                l.a(this.f16567a).onFragmentAction(106, (NomineeModel) this.f16568b.element);
            }
        }
    }
}
