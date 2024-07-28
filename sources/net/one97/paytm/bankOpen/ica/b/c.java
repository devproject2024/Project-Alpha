package net.one97.paytm.bankOpen.ica.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.b.d;
import net.one97.paytm.bankOpen.ica.view.stepview.BankStepsView;

public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.bankCommon.f.d f16473b;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f16474i;

    public final View a(int i2) {
        if (this.f16474i == null) {
            this.f16474i = new HashMap();
        }
        View view = (View) this.f16474i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16474i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int d() {
        return 1;
    }

    public final net.one97.paytm.bankCommon.f.d j() {
        net.one97.paytm.bankCommon.f.d dVar = this.f16473b;
        if (dVar == null) {
            k.a("fragmentActionListener");
        }
        return dVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_add_nominee_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((BankStepsView) a(R.id.stepsViewBank)).a(R.color.gray, R.color.dark_blue, R.color.paytm_primary_color, R.color.gray);
        ((BankStepsView) a(R.id.stepsViewBank)).setSteps(4, 3);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof net.one97.paytm.bankCommon.f.d) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f16473b = (net.one97.paytm.bankCommon.f.d) activity;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.listeners.FragmentActionListener");
            }
        }
        ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(new a(this));
        ((TextView) a(R.id.add_later_tv)).setOnClickListener(new b(this));
        ((Button) a(R.id.paytments_bank_add_nominee_btn_submit)).setOnClickListener(new C0237c(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16475a;

        a(c cVar) {
            this.f16475a = cVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16475a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16476a;

        b(c cVar) {
            this.f16476a = cVar;
        }

        public final void onClick(View view) {
            this.f16476a.j().onFragmentAction(102, (Object) null);
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.b.c$c  reason: collision with other inner class name */
    static final class C0237c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16477a;

        C0237c(c cVar) {
            this.f16477a = cVar;
        }

        public final void onClick(View view) {
            if (this.f16477a.f() && this.f16477a.j() != null) {
                NomineeModel nomineeModel = new NomineeModel();
                TextInputEditText textInputEditText = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_email);
                k.a((Object) textInputEditText, "add_nominee_edt_email");
                nomineeModel.setEmail(String.valueOf(textInputEditText.getText()));
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_state);
                k.a((Object) textInputEditText2, "add_nominee_edt_state");
                nomineeModel.setState(String.valueOf(textInputEditText2.getText()));
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f16477a.a(R.id.add_nominee_edt_city);
                k.a((Object) autoCompleteTextView, "add_nominee_edt_city");
                nomineeModel.setCity(autoCompleteTextView.getText().toString());
                TextInputEditText textInputEditText3 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_pincode);
                k.a((Object) textInputEditText3, "add_nominee_edt_pincode");
                nomineeModel.setPinCode(String.valueOf(textInputEditText3.getText()));
                TextInputEditText textInputEditText4 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_address_line2);
                k.a((Object) textInputEditText4, "add_nominee_edt_address_line2");
                nomineeModel.setStreetName(String.valueOf(textInputEditText4.getText()));
                TextInputEditText textInputEditText5 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_address_line3);
                k.a((Object) textInputEditText5, "add_nominee_edt_address_line3");
                nomineeModel.setAreaName(String.valueOf(textInputEditText5.getText()));
                TextInputEditText textInputEditText6 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_address_line1);
                k.a((Object) textInputEditText6, "add_nominee_edt_address_line1");
                nomineeModel.setHouseNo(String.valueOf(textInputEditText6.getText()));
                TextInputEditText textInputEditText7 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_relationship);
                k.a((Object) textInputEditText7, "add_nominee_edt_relationship");
                nomineeModel.setRelationship(String.valueOf(textInputEditText7.getText()));
                TextInputEditText textInputEditText8 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_dob);
                k.a((Object) textInputEditText8, "add_nominee_edt_dob");
                nomineeModel.setDob(String.valueOf(textInputEditText8.getText()));
                TextInputEditText textInputEditText9 = (TextInputEditText) this.f16477a.a(R.id.add_nominee_edt_name);
                k.a((Object) textInputEditText9, "add_nominee_edt_name");
                nomineeModel.setName(String.valueOf(textInputEditText9.getText()));
                this.f16477a.j().onFragmentAction(101, nomineeModel);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16474i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
