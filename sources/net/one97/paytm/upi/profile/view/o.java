package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.a.k;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UpiConstants;

public class o extends f implements k.b {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f68338a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68339b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68340c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f68341d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f68342e;

    /* renamed from: f  reason: collision with root package name */
    private String f68343f;

    /* renamed from: g  reason: collision with root package name */
    private BankAccountDetails.BankAccount f68344g;

    /* renamed from: h  reason: collision with root package name */
    private k.a f68345h;

    /* renamed from: i  reason: collision with root package name */
    private n f68346i;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static o a(String str, BankAccountDetails.BankAccount bankAccount) {
        o oVar = new o();
        Bundle bundle = new Bundle();
        bundle.putString("vpa", str);
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, bankAccount);
        oVar.setArguments(bundle);
        return oVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f68343f = getArguments().getString("vpa");
        this.f68344g = (BankAccountDetails.BankAccount) getArguments().getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
        getContext();
        this.f68345h = new net.one97.paytm.upi.profile.presenter.k(this, g.a(), this.f68343f, this.f68344g.getAccRefNumber());
        this.f68346i = new n(getContext(), this.f68345h);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_saved_account, viewGroup, false);
        this.f68338a = (ImageView) inflate.findViewById(R.id.iv_close);
        this.f68338a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (o.this.isAdded()) {
                    o.this.dismissAllowingStateLoss();
                }
            }
        });
        this.f68342e = (LottieAnimationView) inflate.findViewById(R.id.lav_account_loader);
        this.f68339b = (TextView) inflate.findViewById(R.id.tv_upi_address);
        this.f68341d = (RecyclerView) inflate.findViewById(R.id.rv_bank_account);
        this.f68340c = (TextView) inflate.findViewById(R.id.tv_add_account);
        this.f68340c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.startActivityForResult(new Intent(o.this.getContext(), AccountProviderActivity.class), 288);
            }
        });
        this.f68339b.setText(getString(R.string.upi_address_placeholder, this.f68343f));
        this.f68341d.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f68341d.setAdapter(this.f68346i);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f68345h.f();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68345h.e();
    }

    public final void a(boolean z) {
        if (z) {
            this.f68342e.setVisibility(0);
            AnimationFactory.startWalletLoader(this.f68342e);
            this.f68341d.setVisibility(8);
            return;
        }
        this.f68342e.setVisibility(8);
        AnimationFactory.stopWalletLoader(this.f68342e);
        this.f68341d.setVisibility(0);
    }

    public final void b(boolean z) {
        if (z) {
            this.f68342e.setVisibility(0);
            AnimationFactory.startWalletLoader(this.f68342e);
            return;
        }
        this.f68342e.setVisibility(8);
        AnimationFactory.stopWalletLoader(this.f68342e);
    }

    public final void a(int i2) {
        n nVar = this.f68346i;
        if (nVar != null) {
            nVar.notifyItemChanged(i2);
        }
    }

    public final void b(int i2) {
        n nVar = this.f68346i;
        if (nVar != null) {
            nVar.notifyItemRangeRemoved(0, i2);
        }
    }

    public final void c(int i2) {
        n nVar = this.f68346i;
        if (nVar != null) {
            nVar.notifyItemRangeInserted(0, i2);
        }
    }

    public final void c(boolean z) {
        getString(R.string.upi_error);
        String string = getString(R.string.upi_default_bank_account_change_failed);
        if (z) {
            getString(R.string.upi_success);
            string = getString(R.string.upi_default_bank_account_change_success);
        }
        Toast.makeText(getContext(), string, 0).show();
    }

    public final void a() {
        if (getActivity() != null && (getActivity() instanceof UpiLandingPageActivity)) {
            UpiLandingPageActivity upiLandingPageActivity = (UpiLandingPageActivity) getActivity();
            upiLandingPageActivity.e();
            a.a((Context) upiLandingPageActivity).a(new Intent(UpiConstants.INTENT_ACTION_REFRESH_LINKED_ACCOUNTS));
            upiLandingPageActivity.f68749c = true;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getActivity();
        if (i3 != -1) {
            return;
        }
        if (i2 == 288) {
            BankVpaCreationActivity.a((Fragment) this, (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), this.f68343f, 304);
        } else if (i2 == 304) {
            this.f68345h.e();
            a();
        } else if (i2 == 320) {
            this.f68345h.e();
            a();
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        UpiProfileAccountDetailActivity.a(this, bankAccount, this.f68343f, UpiConstants.REQUEST_CODE_BANK_DETAIL);
    }
}
