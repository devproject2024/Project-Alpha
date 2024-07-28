package net.one97.paytm.bankOpen.b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.c.a;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.R;

public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16371b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final String[] f16372i = {"Mother", "Father", "Guardian", "COURT_APPOINTED_DE_FACTO", "Others"};
    private HashMap j;

    private View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int d() {
        return 2;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.toolbarLayout);
        k.a((Object) relativeLayout, "toolbarLayout");
        relativeLayout.setVisibility(8);
        View a2 = a(R.id.view_toolbar);
        k.a((Object) a2, "view_toolbar");
        a2.setVisibility(8);
        RoboTextView roboTextView = (RoboTextView) a(R.id.add_nominee_tv_title);
        k.a((Object) roboTextView, "add_nominee_tv_title");
        roboTextView.setText(getString(R.string.pb_guardian_details));
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.add_nominee_til_name);
        k.a((Object) textInputLayout, "add_nominee_til_name");
        textInputLayout.setHint(getString(R.string.pb_guardian_name));
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.add_nominee_til_relationship);
        k.a((Object) textInputLayout2, "add_nominee_til_relationship");
        textInputLayout2.setHint(getString(R.string.bank_relationship_with_nominee));
        ((RoboTextView) a(R.id.add_nominee_tv_title)).setTextSize(2, 18.0f);
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.add_nominee_sv_layout);
        k.a((Object) nestedScrollView, "add_nominee_sv_layout");
        nestedScrollView.setScrollBarSize(0);
        NestedScrollView nestedScrollView2 = (NestedScrollView) a(R.id.add_nominee_sv_layout);
        k.a((Object) nestedScrollView2, "add_nominee_sv_layout");
        nestedScrollView2.setNestedScrollingEnabled(true);
        Button button = (Button) a(R.id.paytments_bank_add_nominee_btn_submit);
        k.a((Object) button, "paytments_bank_add_nominee_btn_submit");
        button.setVisibility(8);
        ((LinearLayout) a(R.id.ll_nominee_view)).setPadding(0, 0, 0, 0);
    }

    public final void e() {
        net.one97.paytm.bankCommon.c.a aVar = new net.one97.paytm.bankCommon.c.a(this.f16377d, getResources().getStringArray(R.array.payment_minor_nominee_relationship), this.f16379f);
        aVar.a(new b(this, aVar));
        aVar.a();
    }

    static final class b implements a.C0221a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16373a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.bankCommon.c.a f16374b;

        b(c cVar, net.one97.paytm.bankCommon.c.a aVar) {
            this.f16373a = cVar;
            this.f16374b = aVar;
        }

        public final void onItemSelected(int i2) {
            this.f16374b.b();
            c cVar = this.f16373a;
            cVar.f16379f = i2;
            cVar.f16378e.setText(this.f16373a.f16372i[this.f16373a.f16379f]);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(NomineeModel nomineeModel) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("NOMINEE_ITEM", nomineeModel);
            c cVar = new c();
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
