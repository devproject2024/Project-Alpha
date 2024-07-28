package net.one97.paytm.upi.profile.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.t;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.f;
import net.one97.paytm.upi.profile.presenter.g;
import net.one97.paytm.upi.profile.view.f;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.HorizontalDividerItemDecoration;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public class j extends h implements f.c {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f68277a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f68278b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f68279c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public f.a f68280d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f68281e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68282f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68283g;

    /* renamed from: h  reason: collision with root package name */
    private View f68284h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f68285i;
    private boolean j;
    private int k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private ProgressDialog o;
    private ProgressBar p;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68280d = (f.a) obj;
    }

    public static j a(boolean z, int i2, boolean z2, UpiProfileDefaultBank upiProfileDefaultBank, ArrayList<BankAccountDetails.BankAccount> arrayList, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_menu", z);
        bundle.putBoolean("hide_delete_menu", z2);
        bundle.putInt("fragment_pos", i2);
        bundle.putSerializable("default_bank", upiProfileDefaultBank);
        bundle.putSerializable(UpiConstants.ARG_BANK_LIST, arrayList);
        bundle.putSerializable("section_type", profile_vpa_account_type);
        jVar.setArguments(bundle);
        return jVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.j = getArguments().getBoolean("hide_menu");
            this.k = getArguments().getInt("fragment_pos");
            this.f68285i = getArguments().getBoolean("hide_delete_menu");
            getActivity();
            this.f68280d = new g(net.one97.paytm.upi.g.a(), this, (UpiProfileDefaultBank) getArguments().getSerializable("default_bank"), (ArrayList) getArguments().getSerializable(UpiConstants.ARG_BANK_LIST), (UpiConstants.PROFILE_VPA_ACCOUNT_TYPE) getArguments().getSerializable("section_type"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_profile_account, viewGroup, false);
        this.l = (ImageView) inflate.findViewById(R.id.iv_overflow_menu);
        this.f68281e = (LinearLayout) inflate.findViewById(R.id.ll_content);
        this.m = (TextView) inflate.findViewById(R.id.tv_vpa_value);
        this.f68283g = (TextView) inflate.findViewById(R.id.tv_primary_label);
        this.f68279c = (RelativeLayout) inflate.findViewById(R.id.rl_profile_vpa_header);
        this.n = (TextView) inflate.findViewById(R.id.tv_vpa_section_header);
        this.f68277a = (RecyclerView) inflate.findViewById(R.id.rv_debit_account_list);
        this.f68278b = (LinearLayout) inflate.findViewById(R.id.ll_error_container);
        this.p = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f68282f = (TextView) inflate.findViewById(R.id.tv_no_acc_linked);
        this.f68284h = inflate.findViewById(R.id.view_divider);
        this.f68277a.addItemDecoration(new HorizontalDividerItemDecoration(getActivity(), b.a((Context) getActivity(), R.drawable.upi_divider), UpiAppUtils.convertDpToPixel(24.0f, getActivity())));
        this.f68282f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (j.this.f()) {
                    AccountProviderActivity.a((Fragment) j.this, 10);
                } else {
                    j.a(j.this, 11);
                }
            }
        });
        this.f68277a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f68277a.setHasFixedSize(true);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.b(j.this);
            }
        });
        if (this.j) {
            this.l.setVisibility(4);
        } else {
            this.l.setVisibility(0);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public void g() {
        c.a aVar = new c.a(getActivity());
        aVar.a(true);
        aVar.b(R.string.upi_delete_vpa_confirmation);
        aVar.a(R.string.upi_delete_vpa);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                j.this.f68280d.b();
                dialogInterface.dismiss();
            }
        });
        aVar.b(R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        aVar.b();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        f.a aVar = this.f68280d;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void a(int i2, int i3, BankAccountDetails.BankAccount bankAccount) {
        if (!this.f68277a.isComputingLayout()) {
            RecyclerView.a adapter = this.f68277a.getAdapter();
            adapter.notifyItemChanged(i2);
            adapter.notifyItemChanged(i3);
            this.f68280d.a(bankAccount);
            Intent intent = new Intent("refresh_upi_landing_receiver");
            intent.putExtra("refresh_upi_landing", true);
            a.a((Context) getActivity()).a(intent);
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount, String str) {
        UpiProfileAccountDetailActivity.a(getParentFragment(), bankAccount, str, 102);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a(getParentFragment(), accountProvider, str, 101);
    }

    public final void c() {
        e(getString(R.string.please_wait));
    }

    public final void b(String str) {
        h();
        if (getParentFragment() instanceof k) {
            k kVar = (k) getParentFragment();
            if (!TextUtils.isEmpty(str)) {
                androidx.fragment.app.j childFragmentManager = kVar.getChildFragmentManager();
                Fragment c2 = childFragmentManager.c(str + "debit");
                if (c2 != null) {
                    kVar.getChildFragmentManager().a().a(c2).c();
                }
                androidx.fragment.app.j childFragmentManager2 = kVar.getChildFragmentManager();
                Fragment c3 = childFragmentManager2.c(str + "credit");
                if (c3 != null) {
                    kVar.getChildFragmentManager().a().a(c3).c();
                }
                kVar.g();
            }
        }
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(getActivity(), str, 1).show();
        } else {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        }
        h();
    }

    public final void d() {
        e(getString(R.string.please_wait));
    }

    public final void e() {
        h();
        Toast.makeText(getActivity(), R.string.upi_primary_vpa_sucess, 1).show();
        if (getParentFragment() instanceof k) {
            ((k) getParentFragment()).g();
        }
    }

    public final void d(String str) {
        h();
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(getActivity(), str, 1).show();
        } else {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        }
    }

    public final void a() {
        e(getString(R.string.please_wait));
    }

    private void e(String str) {
        this.o = new ProgressDialog(getActivity());
        this.o.setCancelable(false);
        this.o.setMessage(str);
        this.o.show();
    }

    private void h() {
        ProgressDialog progressDialog = this.o;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public final void a(UserUpiDetails userUpiDetails) {
        h();
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
        if (selectedBankAccount != null) {
            Toast.makeText(getActivity(), getString(R.string.upi_default_account_success, selectedBankAccount.getBankName()), 1).show();
            return;
        }
        Toast.makeText(getActivity(), "Default bank changed", 1).show();
    }

    public final void a(String str) {
        h();
        if (TextUtils.isEmpty(str) || !"1006".equalsIgnoreCase(str)) {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        } else {
            Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 144);
            startActivityForResult(intent, 144);
        }
        this.f68280d.d();
    }

    public final void b() {
        RecyclerView.a adapter = this.f68277a.getAdapter();
        if (!this.f68277a.isComputingLayout() && adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final boolean f() {
        return PaytmUpiPrefUtil.getPref(getContext().getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10) {
            if (i3 == -1) {
                this.f68280d.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
            }
        } else if (i2 == 11) {
            if (i3 == -1) {
                AccountProviderActivity.a((Fragment) this, 10);
            }
        } else if (i2 == 12 && i3 == -1) {
            g();
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, List<BankAccountDetails.BankAccount> list, boolean z, boolean z2) {
        f.a aVar = this.f68280d;
        if (aVar != null) {
            aVar.a(upiProfileDefaultBank, list);
            this.f68285i = z2;
            if (z) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        f.a aVar = this.f68280d;
        if (aVar != null) {
            aVar.f();
        }
    }

    public final void a(String str, boolean z, List<BankAccountDetails.BankAccount> list, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type) {
        String str2;
        this.f68281e.setVisibility(0);
        this.p.setVisibility(8);
        this.m.setText(str);
        if (z) {
            this.f68283g.setVisibility(0);
        } else {
            this.f68283g.setVisibility(8);
        }
        if (list.size() > 0) {
            this.f68282f.setVisibility(8);
            this.n.setVisibility(0);
            this.f68284h.setVisibility(0);
            RecyclerView recyclerView = this.f68277a;
            f.a aVar = this.f68280d;
            recyclerView.setAdapter(new f(aVar, (f.a) aVar));
            this.f68277a.getAdapter().notifyDataSetChanged();
        } else {
            this.f68282f.setVisibility(8);
            this.n.setVisibility(8);
            this.f68284h.setVisibility(8);
        }
        if (UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT.equals(profile_vpa_account_type)) {
            this.f68279c.setVisibility(8);
            str2 = getString(R.string.upi_recieve_label);
        } else if (UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT.equals(profile_vpa_account_type)) {
            str2 = getString(R.string.upi_send_label);
            if (this.k == 0) {
                this.f68284h.setVisibility(8);
            }
        } else {
            return;
        }
        this.n.setText(String.format(getString(R.string.upi_profile_section_header), new Object[]{str2}));
    }

    static /* synthetic */ void a(j jVar, int i2) {
        Intent intent = new Intent(jVar.getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        jVar.startActivityForResult(intent, i2);
    }

    static /* synthetic */ void b(j jVar) {
        t tVar = new t(jVar.getActivity(), jVar.l);
        tVar.b().inflate(R.menu.upi_profile_menu, tVar.f1796a);
        tVar.f1796a.findItem(R.id.upi_delete_vpa).setVisible(!jVar.f68285i);
        tVar.f1796a.findItem(R.id.upi_set_primary_vpa).setVisible(!jVar.f68280d.c());
        tVar.f1798c = new t.b() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.upi_set_primary_vpa) {
                    if (j.this.f()) {
                        j.this.f68280d.g();
                        return true;
                    }
                    j.a(j.this, 11);
                    return true;
                } else if (itemId == R.id.upi_link_acc) {
                    if (j.this.f()) {
                        AccountProviderActivity.a((Fragment) j.this, 10);
                        return true;
                    }
                    j.a(j.this, 11);
                    return true;
                } else if (itemId != R.id.upi_delete_vpa) {
                    return true;
                } else {
                    if (j.this.f()) {
                        j.this.g();
                        return true;
                    }
                    j.a(j.this, 12);
                    return true;
                }
            }
        };
        tVar.f1797b.a();
    }
}
