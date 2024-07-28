package net.one97.paytm.paymentsBank.updateInfo.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;

public final class e extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19440b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f19441a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f19442c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f19443d;

    public interface b {
        void onProceedClicked(String str);
    }

    private View a(int i2) {
        if (this.f19443d == null) {
            this.f19443d = new HashMap();
        }
        View view = (View) this.f19443d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f19443d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(b bVar) {
        k.c(bVar, "<set-?>");
        this.f19441a = bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f19442c = arguments.getString("popupType");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_cersai_required_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        String str = this.f19442c;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1363895925) {
                if (hashCode == -263839376 && str.equals("addNominee")) {
                    TextView textView = (TextView) a(R.id.title);
                    k.a((Object) textView, "title");
                    textView.setText(getString(R.string.bank_add_nominee));
                    TextView textView2 = (TextView) a(R.id.tv_desc);
                    k.a((Object) textView2, "tv_desc");
                    textView2.setText(getString(R.string.bank_add_nominee_desc));
                    Button button = (Button) a(R.id.proceed);
                    k.a((Object) button, "proceed");
                    button.setText(getString(R.string.bank_add_nominee_btn));
                }
            } else if (str.equals("cersai")) {
                TextView textView3 = (TextView) a(R.id.title);
                k.a((Object) textView3, "title");
                textView3.setText(getString(R.string.update_your_kyc_details));
                TextView textView4 = (TextView) a(R.id.tv_desc);
                k.a((Object) textView4, "tv_desc");
                textView4.setText(getString(R.string.as_per_rbi_guidelines_for_));
                Button button2 = (Button) a(R.id.proceed);
                k.a((Object) button2, "proceed");
                button2.setText(getString(R.string.pb_cersai_update_now));
            }
        }
        ((Button) a(R.id.proceed)).setOnClickListener(new c(this));
        ((ImageView) a(R.id.cross_iv)).setOnClickListener(new d(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19444a;

        c(e eVar) {
            this.f19444a = eVar;
        }

        public final void onClick(View view) {
            b bVar = this.f19444a.f19441a;
            if (bVar == null) {
                k.a("listener");
            }
            bVar.onProceedClicked(this.f19444a.f19442c);
            this.f19444a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19445a;

        d(e eVar) {
            this.f19445a = eVar;
        }

        public final void onClick(View view) {
            this.f19445a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19443d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final e a(String str) {
        k.c(str, "popupType");
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putString("popupType", str);
        eVar.setArguments(bundle);
        return eVar;
    }
}
