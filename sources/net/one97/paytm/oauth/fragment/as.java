package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.google.android.material.bottomsheet.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.t;

public class as extends b implements View.OnClickListener, t {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f56378a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f56379b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f56380c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f56381d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f56382e;

    /* renamed from: f  reason: collision with root package name */
    private a f56383f;

    public interface a {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sign_out_all_account_bottom_sheet, viewGroup, false);
        this.f56378a = (ImageView) inflate.findViewById(R.id.logout_bottom_sheet_close);
        this.f56379b = (TextView) inflate.findViewById(R.id.logout_bottom_sheet_title);
        this.f56380c = (TextView) inflate.findViewById(R.id.logout_bottom_sheet_body);
        this.f56381d = (TextView) inflate.findViewById(R.id.bottomsheetbutton_logout);
        this.f56382e = (TextView) inflate.findViewById(R.id.logout_bottom_sheet_subscription);
        this.f56379b.setText(getString(R.string.lbl_logout_from_all_devices_title));
        this.f56380c.setText(getString(R.string.lbl_logout_from_all_devices_body));
        this.f56378a.setOnClickListener(this);
        this.f56381d.setOnClickListener(this);
        this.f56382e.setOnClickListener(this);
        return inflate;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.logout_bottom_sheet_close) {
            a("logout_from_all_devices_popup_discarded");
            dismissAllowingStateLoss();
        } else if (view.getId() == R.id.bottomsheetbutton_logout) {
            a("logout_clicked");
            net.one97.paytm.oauth.b.b.a(getContext(), (t) this);
        } else if (view.getId() == R.id.logout_bottom_sheet_subscription) {
            a("view_linked_apps_clicked");
            OauthModule.b().openAuthorizedMerchantActivity(getContext());
            dismissAllowingStateLoss();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        com.paytm.utility.b.Z(getContext());
        b();
        OauthModule.b().onLogout(getActivity(), false, (VolleyError) null);
        dismissAllowingStateLoss();
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.Z(getContext());
        if (networkCustomError.getStatusCode() == 200) {
            if (this.f56383f != null) {
                b();
            }
            OauthModule.b().onLogout(getActivity(), false, (VolleyError) null);
            dismissAllowingStateLoss();
        } else if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public final void a() {
        com.paytm.utility.b.k(getContext(), getContext().getString(R.string.please_wait));
    }

    private void a(String str) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "logout_from_all_devices", str, (ArrayList<String>) null, (String) null, "/security_settings", p.f56796a);
    }

    private static void b() {
        o oVar = o.f56791a;
        o.b(com.paytm.utility.b.ab(OauthModule.b().getApplicationContext()));
    }
}
