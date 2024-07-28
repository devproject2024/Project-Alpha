package net.one97.paytm.upi.profile.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.a.h;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class k extends h implements h.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public h.a f68291a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68292b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68293c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f68294d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f68295e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f68296f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68297g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68298h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f68299i;
    private TextView j;
    private ProgressDialog k;
    private boolean l;
    private BankAccountDetails.BankAccount m;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68291a = (h.a) obj;
    }

    public static k f() {
        return new k();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity();
        b a2 = g.a();
        getActivity();
        getActivity();
        this.f68291a = new net.one97.paytm.upi.profile.presenter.h(a2, g.a(a.a(g.d(), (a.C1347a) null)), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_profile, viewGroup, false);
        this.f68292b = (TextView) inflate.findViewById(R.id.tv_vpa_label);
        this.f68293c = (TextView) inflate.findViewById(R.id.tv_add_new_vpa);
        this.f68294d = (LinearLayout) inflate.findViewById(R.id.ll_upi_section_container);
        this.f68295e = (LinearLayout) inflate.findViewById(R.id.ll_error_container);
        this.f68296f = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f68297g = (TextView) inflate.findViewById(R.id.tv_retry);
        this.f68298h = (TextView) inflate.findViewById(R.id.tv_error_msg);
        this.f68299i = (TextView) inflate.findViewById(R.id.tv_deregister);
        this.j = (TextView) inflate.findViewById(R.id.tv_link_bank_acc);
        setHasOptionsMenu(true);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.a(view);
            }
        });
        this.f68297g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.g();
            }
        });
        this.f68293c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.f68291a.a(UpiGTMLoader.getInstance().getMaxVpaAllowed());
            }
        });
        return inflate;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.upi_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.upi_deregister).setVisible(PaytmUpiPrefUtil.getPref(getContext().getApplicationContext()).b("is_upi_user", false, true));
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.upi_deregister) {
            c.a aVar = new c.a(getActivity());
            aVar.a(true);
            aVar.b(R.string.upi_deregister_msg);
            aVar.a(R.string.upi_deregister_profile);
            aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    k.this.f68291a.a();
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
        return super.onOptionsItemSelected(menuItem);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68291a.e();
    }

    public final void a() {
        this.f68296f.setVisibility(0);
        this.f68295e.setVisibility(8);
        this.f68294d.setVisibility(8);
    }

    public final void a(UpiProfileModel.ProfileDetails profileDetails) {
        boolean z;
        boolean z2;
        this.f68296f.setVisibility(8);
        this.f68294d.setVisibility(0);
        this.f68295e.setVisibility(8);
        ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetails.getBankAccountList();
        List<UpiProfileDefaultBank> profileVpaList = profileDetails.getProfileVpaList();
        if (profileVpaList != null) {
            if (profileVpaList.size() == 1) {
                z2 = true;
                z = true;
            } else {
                z2 = false;
                z = false;
            }
            if (profileVpaList.size() >= UpiGTMLoader.getInstance().getMaxVpaAllowed()) {
                this.f68293c.setVisibility(8);
            } else {
                this.f68293c.setVisibility(0);
            }
            h();
            int i2 = 0;
            for (UpiProfileDefaultBank next : profileVpaList) {
                j childFragmentManager = getChildFragmentManager();
                j jVar = (j) childFragmentManager.c(next.getVirtualAddress() + "debit");
                if (jVar == null) {
                    j a2 = j.a(z2, i2, z, next, bankAccountList, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT);
                    q a3 = getChildFragmentManager().a();
                    int i3 = R.id.ll_section_container;
                    a3.a(i3, a2, next.getVirtualAddress() + "debit").c();
                } else {
                    jVar.a(next, (List<BankAccountDetails.BankAccount>) bankAccountList, z2, z);
                }
                j childFragmentManager2 = getChildFragmentManager();
                j jVar2 = (j) childFragmentManager2.c(next.getVirtualAddress() + "credit");
                if (jVar2 == null) {
                    j a4 = j.a(z2, i2, z, next, bankAccountList, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT);
                    q a5 = getChildFragmentManager().a();
                    int i4 = R.id.ll_section_container;
                    a5.a(i4, a4, next.getVirtualAddress() + "credit").c();
                } else {
                    jVar2.a(next, (List<BankAccountDetails.BankAccount>) bankAccountList, z2, z);
                }
                i2++;
            }
            if (this.l && bankAccountList != null && bankAccountList.size() > 0) {
                this.l = false;
                if (this.m == null) {
                    UpiProfileAccountDetailActivity.a(this, bankAccountList.get(bankAccountList.size() - 1), profileVpaList.get(0).getVirtualAddress(), 102);
                    return;
                }
                Iterator<BankAccountDetails.BankAccount> it2 = bankAccountList.iterator();
                while (it2.hasNext()) {
                    BankAccountDetails.BankAccount next2 = it2.next();
                    if (next2.getAccRefNumber().equals(this.m.getAccRefNumber())) {
                        UpiProfileAccountDetailActivity.a(this, next2, profileVpaList.get(0).getVirtualAddress(), 102);
                        return;
                    }
                }
                return;
            }
            return;
        }
        a((UpiCustomVolleyError) null);
    }

    public final void b() {
        this.f68296f.setVisibility(8);
        this.f68294d.setVisibility(8);
        this.f68295e.setVisibility(8);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        this.f68298h.setText(R.string.upi_profile_loading_error);
        this.f68296f.setVisibility(8);
        this.f68294d.setVisibility(8);
        this.f68295e.setVisibility(0);
        if (upiCustomVolleyError != null && UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            new Bundle();
            net.one97.paytm.upi.k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            k.class.getName();
            kVar.e(activity);
        }
    }

    public final void a(String str) {
        i();
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        } else {
            Toast.makeText(getActivity(), str, 1).show();
        }
    }

    public final void c() {
        i();
        c.a aVar = new c.a(getActivity());
        aVar.a(false);
        aVar.b(R.string.upi_post_deregister_msg);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                if (k.this.getActivity() instanceof UpiProfileActivity) {
                    k.this.getActivity().setResult(-1);
                    k.this.getActivity().finish();
                }
            }
        });
        aVar.b();
        b();
        h();
    }

    private void h() {
        if (getActivity() != null) {
            getActivity().invalidateOptionsMenu();
        }
    }

    private void i() {
        ProgressDialog progressDialog = this.k;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.k.dismiss();
        }
    }

    public final void d() {
        String string = getString(R.string.upi_deleting_profile);
        this.k = new ProgressDialog(getActivity());
        this.k.setMessage(string);
        this.k.setCancelable(false);
        this.k.show();
    }

    public final void e() {
        ProfileCreateVpaActivity.a((Fragment) this);
    }

    public final void a(int i2) {
        c.a aVar = new c.a(getActivity());
        aVar.b((CharSequence) getString(R.string.upi_vpa_limit_error, Integer.valueOf(i2)));
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        aVar.b();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a((Fragment) this, accountProvider, str, 101);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100) {
            if (i3 == -1) {
                g();
            }
        } else if (i2 == 101) {
            if (i3 == -1) {
                this.l = true;
            }
            g();
        } else if (i2 == 103) {
            if (i3 == -1) {
                this.f68291a.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
            }
        } else if (i2 == 102) {
            if (i3 == -1) {
                if (intent != null) {
                    this.l = intent.getBooleanExtra("launch_account_detail", false);
                    this.m = (BankAccountDetails.BankAccount) intent.getSerializableExtra(UpiConstants.EXTRA_SELECTED_BANK);
                }
                g();
            }
        } else if (i2 == 104 && i3 == -1) {
            AccountProviderActivity.a((Fragment) this, 103);
        }
    }

    public final void g() {
        this.f68291a.a(true);
        j();
    }

    private void j() {
        Intent intent = new Intent("refresh_upi_landing_receiver");
        intent.putExtra("refresh_upi_landing", true);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(intent);
    }

    public void onDetach() {
        super.onDetach();
        this.f68291a.f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (PaytmUpiPrefUtil.getPref(getContext().getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true)) {
            AccountProviderActivity.a((Fragment) this, 103);
            return;
        }
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 104);
        startActivityForResult(intent, 104);
    }
}
