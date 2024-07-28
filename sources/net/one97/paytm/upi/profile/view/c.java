package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.a.b;
import net.one97.paytm.upi.profile.view.d;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.q;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.VerticalSpaceItemDecoration;

public class c extends h implements b.C1381b, d.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f68203a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b.a f68204b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f68205c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f68206d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68207e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressDialog f68208f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f68209g = new ArrayList<>();

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68204b = (b.a) obj;
    }

    public static c b() {
        return new c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_choose_bank, viewGroup, false);
        this.f68206d = (ImageView) inflate.findViewById(R.id.iv_bank_icon);
        this.f68207e = (TextView) inflate.findViewById(R.id.tv_bank_card_msg);
        this.f68203a = (RecyclerView) inflate.findViewById(R.id.rv_bank_account_list);
        this.f68205c = (LinearLayout) inflate.findViewById(R.id.ll_proceed);
        this.f68203a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f68203a.setAdapter(new d(getActivity(), this));
        this.f68203a.addItemDecoration(new VerticalSpaceItemDecoration(UpiAppUtils.convertDpToPixel(20.0f, getActivity())));
        this.f68205c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!c.this.f68209g.isEmpty()) {
                    c.this.f68204b.a(c.this.f68209g);
                }
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68204b.e();
    }

    public final void b(String str) {
        w.a().a(str).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.f68206d, (e) null);
    }

    public final void a(List<BankAccountDetails.BankAccount> list) {
        this.f68207e.setText(getString(R.string.upi_select_bank_msg_new, (list == null || list.size() <= 0) ? "" : list.get(0).getBankName()));
        d dVar = (d) this.f68203a.getAdapter();
        if (list != null) {
            dVar.f68214a.clear();
            dVar.f68214a.addAll(list);
            dVar.notifyDataSetChanged();
        }
    }

    public final void c(final UserUpiDetails userUpiDetails) {
        c();
        if (getActivity() != null) {
            d(userUpiDetails);
            if (getActivity() instanceof ChooseBankAccountActivity) {
                String str = ((ChooseBankAccountActivity) getActivity()).f68128a;
                final int a2 = ((ChooseBankAccountActivity) getActivity()).a();
                if (TextUtils.isEmpty(str)) {
                    if (userUpiDetails.getBankAccountList() != null) {
                        net.one97.paytm.upi.h hVar = i.a().m;
                        hVar.a("ChooseBankAccountFragment", userUpiDetails.getBankAccountList().size() + "_" + userUpiDetails.getSelectedBankIdx());
                    } else {
                        net.one97.paytm.upi.h hVar2 = i.a().m;
                        hVar2.a("ChooseBankAccountFragment", "null_" + userUpiDetails.getSelectedBankIdx());
                    }
                    ArrayList arrayList = (ArrayList) userUpiDetails.getBankAccountList();
                    if (arrayList != null && arrayList.size() == 1) {
                        a(userUpiDetails.getVpa(), (BankAccountDetails.BankAccount) arrayList.get(0), a2);
                    } else if (arrayList != null && arrayList.size() > 1) {
                        q.a aVar = q.f69021a;
                        q.a.a(arrayList, new q.b() {
                            public final void a() {
                                c.this.getActivity().setResult(-1);
                                c.this.getActivity().finish();
                            }

                            public final void a(BankAccountDetails.BankAccount bankAccount) {
                                c.this.a(userUpiDetails.getVpa(), bankAccount, a2);
                            }
                        }).show(getChildFragmentManager(), "");
                    }
                } else if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                    getActivity().setResult(-1, getActivity().getIntent());
                    getActivity().finish();
                } else {
                    i.a().m.a((Activity) getActivity(), str);
                    getActivity().finish();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, BankAccountDetails.BankAccount bankAccount, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bankAccount);
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, str).setBankAccountList(arrayList).build();
        Intent intent = new Intent(getContext(), SetMPINActivity.class);
        intent.putExtra("user_upi_details", build);
        intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, true);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, i2);
        startActivity(intent);
        getActivity().setResult(-1);
        getActivity().finish();
    }

    private void c() {
        ProgressDialog progressDialog = this.f68208f;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f68208f.dismiss();
        }
    }

    public final void a(String str) {
        c();
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "add_account_response_failure", str, "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        if ("96".equals(str)) {
            Toast.makeText(getActivity(), "Account has already been linked to your UPI profile", 1).show();
        } else {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_FAILURE, "", str, "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
    }

    public final void a(UserUpiDetails userUpiDetails) {
        c();
        if (getActivity() != null) {
            d(userUpiDetails);
            if (getActivity() instanceof ChooseBankAccountActivity) {
                String str = ((ChooseBankAccountActivity) getActivity()).f68128a;
                int a2 = ((ChooseBankAccountActivity) getActivity()).a();
                if (TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(getContext(), UPISettingsActivity.class);
                    intent.putExtra("user_upi_details", userUpiDetails);
                    intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, true);
                    intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, a2);
                    intent.putExtra(UpiConstants.EXTRA_IS_MPIN_SET, true);
                    if (userUpiDetails.getBankAccountList() != null && userUpiDetails.getBankAccountList().size() > 0) {
                        intent.putExtra(UpiConstants.EXTRA_ACCOUNT_TYPE_LINKED, userUpiDetails.getSelectedBankAccount().getAccountType());
                    }
                    startActivity(intent);
                } else if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                    getActivity().setResult(-1, getActivity().getIntent());
                    getActivity().finish();
                    return;
                } else {
                    i.a().m.a((Activity) getActivity(), str);
                }
            }
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }

    public final void b(UserUpiDetails userUpiDetails) {
        c();
        if (getActivity() != null) {
            d(userUpiDetails);
            if (getActivity() instanceof ChooseBankAccountActivity) {
                String str = ((ChooseBankAccountActivity) getActivity()).f68128a;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                        getActivity().setResult(-1, getActivity().getIntent());
                        getActivity().finish();
                        return;
                    }
                    i.a().m.a((Activity) getActivity(), str);
                }
            }
            Toast.makeText(getActivity(), R.string.upi_bank_link_success, 1).show();
            Intent intent = new Intent();
            if (userUpiDetails.getBankAccountList() != null && !userUpiDetails.getBankAccountList().isEmpty()) {
                intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, userUpiDetails.getSelectedBankAccount());
                intent.putExtra(UpiConstants.EXTRA_BANK_ACCOUNT_LIST, (ArrayList) userUpiDetails.getBankAccountList());
            }
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    private void d(UserUpiDetails userUpiDetails) {
        int i2;
        String str = "";
        String substring = (userUpiDetails == null || userUpiDetails.getAccountProvider() == null || TextUtils.isEmpty(userUpiDetails.getAccountProvider().getIfsc()) || userUpiDetails.getAccountProvider().getIfsc().length() <= 4) ? str : userUpiDetails.getAccountProvider().getIfsc().substring(0, 4);
        if (userUpiDetails == null || userUpiDetails.getBankAccountList() == null) {
            i2 = 0;
        } else {
            i2 = userUpiDetails.getBankAccountList().size();
            if (i2 > 0) {
                str = userUpiDetails.getBankAccountList().get(0).isMpinSet() ? H5AppHandler.CHECK_VALUE : "no";
            }
        }
        Context context = getContext();
        CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "add_account_response_success", "ifsc_" + substring + ";accounts_" + i2, "mbeba_".concat(str), "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_SUCCESS, "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
    }

    public final void a(ArrayList<String> arrayList) {
        this.f68209g = arrayList;
    }

    public void onDetach() {
        super.onDetach();
        this.f68204b.f();
    }

    public final void a() {
        this.f68208f = new ProgressDialog(getActivity());
        this.f68208f.setMessage(getString(R.string.please_wait));
        this.f68208f.setCancelable(false);
        this.f68208f.show();
    }
}
