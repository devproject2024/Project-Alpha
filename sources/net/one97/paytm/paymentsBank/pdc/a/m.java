package net.one97.paytm.paymentsBank.pdc.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.e;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.upi.util.UpiUtils;

public class m extends l implements View.OnClickListener, c.b, d {

    /* renamed from: a  reason: collision with root package name */
    c.a f18642a;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18643c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager f18644d;

    /* renamed from: e  reason: collision with root package name */
    private c f18645e;

    /* renamed from: f  reason: collision with root package name */
    private c f18646f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18647g;

    /* renamed from: h  reason: collision with root package name */
    private String f18648h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18649i;
    private c.b j;
    private boolean k = true;
    private String l;
    private String m;
    private String n;
    private String o;

    public static m a(String str, String str2, String str3, c.a aVar, c.b bVar) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putString("extraForgotPasscode", str);
        bundle.putString("firstTitle", str2);
        bundle.putString("desc", str3);
        bundle.putBoolean("isVerifyOnly", true);
        mVar.setArguments(bundle);
        mVar.f18642a = aVar;
        mVar.j = bVar;
        return mVar;
    }

    public static m b(String str, String str2, String str3, c.a aVar, c.b bVar) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putString("extraForgotPasscode", (String) null);
        bundle.putString("firstTitle", str);
        bundle.putString("secondTitle", str3);
        bundle.putString("desc", str2);
        bundle.putBoolean("isVerifyOnly", false);
        mVar.setArguments(bundle);
        mVar.f18642a = aVar;
        mVar.j = bVar;
        return mVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pdc_verify_passcode, (ViewGroup) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.l = arguments.getString("firstTitle");
        this.n = arguments.getString("secondTitle");
        this.m = arguments.getString("desc");
        this.k = arguments.getBoolean("isVerifyOnly");
        this.o = arguments.getString("extraForgotPasscode");
        arguments.getInt("isFrom");
        this.f18643c = (TextView) getView().findViewById(R.id.payment_bank_set_passcode_tv_title);
        this.f18649i = (TextView) getView().findViewById(R.id.tv_passcode_desc);
        TextView textView = (TextView) getView().findViewById(R.id.tv_forgot_passcode);
        if (!TextUtils.isEmpty(this.o)) {
            textView.setText(this.o);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    m.this.a(view);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        this.f18644d = (ViewPager) getView().findViewById(R.id.payment_bank_set_passcode_pager_passcode);
        this.f18647g = (TextView) getView().findViewById(R.id.set_passcode_tv_error_msg);
        e eVar = new e(getChildFragmentManager());
        this.f18644d.setAdapter(eVar);
        this.f18645e = (c) eVar.getItem(0);
        this.f18646f = (c) eVar.getItem(1);
        c cVar = this.f18645e;
        cVar.f16236a = this;
        cVar.f16238c = this;
        cVar.f16237b = this.f18642a;
        if (!this.k) {
            c cVar2 = this.f18646f;
            cVar2.f16236a = this;
            cVar2.f16238c = this;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.f18649i.setText("");
        } else {
            this.f18649i.setText(this.m);
        }
        if (TextUtils.isEmpty(this.l)) {
            this.f18643c.setText("");
        } else {
            this.f18643c.setText(this.l);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c.a aVar = this.f18642a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.set_passcode_img_close) {
            if (getActivity() != null && (getActivity() instanceof net.one97.paytm.bankCommon.f.e)) {
                getActivity().onBackPressed();
            }
            d();
        }
    }

    public final void a(String str, c cVar) {
        c cVar2 = this.f18645e;
        if (cVar == cVar2) {
            this.f18648h = str;
            cVar2.a();
            if (this.k) {
                d();
                this.f18645e.a(false);
                c.b bVar = this.j;
                if (bVar != null) {
                    bVar.a(str, this.f18645e);
                    return;
                }
                return;
            }
            this.f18646f.b();
            if (TextUtils.isEmpty(this.n)) {
                this.f18643c.setText("");
            } else {
                this.f18643c.setText(this.n);
            }
            this.f18649i.setVisibility(4);
            this.f18644d.setCurrentItem(1);
            return;
        }
        c cVar3 = this.f18646f;
        if (cVar == cVar3) {
            cVar3.b();
            if (!this.f18648h.equals(str)) {
                if (getString(R.string.pdc_set_new_atm_pin_reset).equalsIgnoreCase(this.l) || getString(R.string.set_your_atm_pin).equalsIgnoreCase(this.l)) {
                    this.f18647g.setText(getString(R.string.pb_pdc_atm_pin_mismatch));
                }
                this.f18647g.setVisibility(0);
                this.f18646f.a(true);
                return;
            }
            d();
            this.f18646f.a(false);
            c.b bVar2 = this.j;
            if (bVar2 != null) {
                bVar2.a(str, this.f18646f);
            }
        }
    }

    public final void b() {
        this.f18643c.setText(this.l);
        this.f18649i.setVisibility(0);
        this.f18647g.setVisibility(4);
        this.f18644d.setCurrentItem(0);
        this.f18645e.a();
        this.f18646f.a();
    }

    public final void a(boolean z) {
        if (z) {
            this.f18647g.setVisibility(0);
        } else {
            this.f18647g.setVisibility(8);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        c();
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && !networkCustomError.getMessage().equalsIgnoreCase("410")) {
            networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401);
        }
    }

    public final void b(boolean z) {
        this.f18645e.a(z);
        this.f18646f.a(z);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18647g.setText(str);
            this.f18647g.setVisibility(0);
            b(true);
            return;
        }
        this.f18647g.setVisibility(4);
        b(false);
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 134) {
            this.f18647g.setVisibility(4);
        }
    }
}
