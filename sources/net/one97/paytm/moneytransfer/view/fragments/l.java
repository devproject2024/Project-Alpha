package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.q;
import net.one97.paytm.moneytransfer.view.a.a;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferAddBeneficiaryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.moneytransfer.viewmodel.g;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.profile.view.UpiProfileAccountDetailActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public class l extends h implements View.OnClickListener, c.b {

    /* renamed from: a  reason: collision with root package name */
    public static int f54507a = 5;
    private boolean A;
    private g B;
    private b C;
    /* access modifiers changed from: private */
    public BankAccountDetails.BankAccount D;
    /* access modifiers changed from: private */
    public int E = -1;
    private BroadcastReceiver F = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if ("action_delete_beneficiary".equalsIgnoreCase(intent.getAction()) && l.this.f54515i != null && l.this.f54515i.size() > 0) {
                String stringExtra = intent.getStringExtra("beneficiary_identifier");
                if (!TextUtils.isEmpty(stringExtra)) {
                    l.a(l.this, stringExtra);
                }
            }
        }
    };
    private BroadcastReceiver G = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiConstants.EXTRA_ACTION_MT_REFRESH_UPI_ACCOUNTS.equalsIgnoreCase(intent.getAction()) && l.this.t != null) {
                l.this.t.c();
                l.this.t.a();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public int f54508b = 0;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.d.b f54509c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f54510d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f54511e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f54512f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f54513g;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f54514h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<IJRDataModel> f54515i = new ArrayList<>();
    private ArrayList<IJRDataModel> j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public a l;
    /* access modifiers changed from: private */
    public int m = -1;
    private int n = -1;
    private BeneficiaryEntity o = null;
    /* access modifiers changed from: private */
    public com.google.android.material.bottomsheet.a p;
    private TextView q;
    private TextView r;
    private TextView s;
    /* access modifiers changed from: private */
    public c.a t;
    /* access modifiers changed from: private */
    public List<BankAccountDetails.BankAccount> u = new ArrayList();
    /* access modifiers changed from: private */
    public String v;
    private ShimmerFrameLayout w;
    private ShimmerFrameLayout x;
    private FrameLayout y;
    private FrameLayout z;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.t = (c.a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.localbroadcastmanager.a.a.a(getActivity().getApplicationContext()).a(this.G, new IntentFilter(UpiConstants.EXTRA_ACTION_MT_REFRESH_UPI_ACCOUNTS));
        androidx.localbroadcastmanager.a.a.a(getActivity().getApplicationContext()).a(this.F, new IntentFilter("action_delete_beneficiary"));
        this.B = (g) am.a(getActivity()).a(g.class);
        this.C = (b) am.a(getActivity()).a(b.class);
        this.C.c().observe(this, new z<ArrayList<UpiProfileDefaultBank>>() {
            public final /* synthetic */ void onChanged(Object obj) {
                l.this.t.c();
                l.this.t.a();
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_recent_txns, viewGroup, false);
        net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(getActivity());
        getActivity();
        net.one97.paytm.upi.profile.b.b a3 = net.one97.paytm.upi.g.a();
        getActivity();
        getActivity();
        net.one97.paytm.upi.registration.b.a.b a4 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null));
        getActivity();
        this.t = new net.one97.paytm.moneytransfer.presenter.b(this, a2, a3, a4, net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null));
        this.f54510d = (RecyclerView) inflate.findViewById(R.id.beneficiary_list);
        this.f54510d.setItemAnimator((RecyclerView.f) null);
        this.f54511e = (RecyclerView) inflate.findViewById(R.id.self_accounts_list);
        this.f54511e.setItemAnimator((RecyclerView.f) null);
        this.f54512f = (RelativeLayout) inflate.findViewById(R.id.saved_accounts_parent_layout);
        this.f54513g = (RelativeLayout) inflate.findViewById(R.id.self_accounts_parent_layout);
        this.q = (TextView) inflate.findViewById(R.id.tv_add_new);
        this.r = (TextView) inflate.findViewById(R.id.tv_add_new_self);
        this.s = (TextView) inflate.findViewById(R.id.tv_view_all);
        this.w = (ShimmerFrameLayout) inflate.findViewById(R.id.beneficiary_shimmer_layout);
        this.x = (ShimmerFrameLayout) inflate.findViewById(R.id.self_shimmer_layout);
        this.y = (FrameLayout) inflate.findViewById(R.id.progress_layout_beneficiary);
        this.z = (FrameLayout) inflate.findViewById(R.id.progress_layout_self_account);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.f54510d.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f54510d.setNestedScrollingEnabled(false);
        this.f54511e.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f54511e.setNestedScrollingEnabled(false);
        this.f54511e.setLayoutManager(new LinearLayoutManager(getActivity()));
        d.c();
        this.f54511e.setNestedScrollingEnabled(false);
        this.f54510d.setNestedScrollingEnabled(false);
        this.k = new net.one97.paytm.moneytransfer.view.a.a(getActivity(), new a.C0970a() {
            public final void a(int i2, TextView textView) {
            }

            public final void a(int i2) {
                int unused = l.this.m = i2;
                if (l.this.f54515i != null && l.this.f54515i.size() > 0) {
                    l.c(l.this);
                }
            }

            public final void b(int i2) {
                l.a(l.this, i2, false);
            }
        });
        this.k.a(this.f54515i);
        this.f54510d.setAdapter(this.k);
        this.l = new net.one97.paytm.moneytransfer.view.a.a(getActivity(), new a.C0970a() {
            public final void a(int i2) {
            }

            public final void b(int i2) {
                l.a(l.this, i2, true);
            }

            public final void a(int i2, TextView textView) {
                if (l.this.getString(R.string.check_balance).equalsIgnoreCase(textView.getText().toString())) {
                    l.this.a(i2);
                } else if (!l.this.getString(R.string.mt_set_upi_pin).equalsIgnoreCase(textView.getText().toString())) {
                } else {
                    if (com.paytm.utility.b.c(l.this.getContext())) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setVirtualAddress(l.this.v);
                        upiProfileDefaultBank.setDebitBank((BankAccountDetails.BankAccount) l.this.u.get(i2));
                        l.a(l.this, upiProfileDefaultBank);
                        return;
                    }
                    m.d((Activity) l.this.getActivity());
                }
            }
        });
        net.one97.paytm.moneytransfer.view.a.a aVar = this.l;
        aVar.f54205h = true;
        this.f54511e.setAdapter(aVar);
        this.t.e();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.G != null) {
            androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.G);
            this.G = null;
        }
        if (this.F != null) {
            androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.F);
            this.F = null;
        }
        c.a aVar = this.t;
        if (aVar != null) {
            aVar.f();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (com.paytm.utility.b.c(getContext())) {
            List<BankAccountDetails.BankAccount> list = this.u;
            if (list != null && !list.isEmpty()) {
                this.D = this.u.get(i2);
                this.E = i2;
                if (this.D.isMpinSet() || !"PYTM0123456".equalsIgnoreCase(this.D.getIfsc())) {
                    this.t.a(this.D);
                    return;
                }
                final BankAccountDetails.BankAccount bankAccount = this.D;
                final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
                hVar.a();
                hVar.setCanceledOnTouchOutside(false);
                hVar.a(getString(R.string.mt_mpin_not_set_info));
                hVar.a(-2, getString(R.string.mt_do_it_later), new View.OnClickListener() {
                    public final void onClick(View view) {
                        l.this.t.a(bankAccount);
                        hVar.dismiss();
                    }
                });
                hVar.a(-1, getString(R.string.set_upi_pin), new View.OnClickListener() {
                    public final void onClick(View view) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setVirtualAddress(l.this.v);
                        upiProfileDefaultBank.setDebitBank(bankAccount);
                        l.a(l.this, upiProfileDefaultBank);
                        hVar.dismiss();
                    }
                });
                hVar.show();
                return;
            }
            return;
        }
        this.l.a("");
        m.d((Activity) getActivity());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        BeneficiaryEntity beneficiaryEntity;
        int i4 = i2;
        int i5 = i3;
        final Intent intent2 = intent;
        if (i5 == -1 && i4 == 120) {
            if (this.n >= 0 && (beneficiaryEntity = this.o) != null) {
                beneficiaryEntity.setSelected(true);
                if (this.A) {
                    this.k.notifyItemChanged(this.n);
                } else {
                    this.l.notifyItemChanged(this.n);
                }
            }
        } else if (i4 == 1001) {
            if (i5 == -1) {
                this.t.a((AccountProviderBody.AccountProvider) intent2.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
            }
        } else if (i4 == 1002 || i4 == 1003) {
            int i6 = i5;
            int i7 = i4;
            if (i6 == -1) {
                this.t.c();
                g();
            }
            super.onActivityResult(i2, i3, intent);
        } else if (i4 == 80) {
            if (i5 == -1) {
                h();
            }
        } else if (i4 != 10) {
            if (i4 == 1004) {
                if (i5 == -1) {
                    if (intent2 != null) {
                        BeneficiaryEntity beneficiaryEntity2 = new BeneficiaryEntity();
                        String stringExtra = intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER);
                        String stringExtra2 = intent2.getStringExtra(UpiConstants.EXTRA_ACCOUNT_NAME);
                        String stringExtra3 = intent2.getStringExtra(UpiConstants.EXTRA_BANK_NAME);
                        String stringExtra4 = intent2.getStringExtra(UpiConstants.EXTRA_IFSC);
                        beneficiaryEntity2.beneficiaryId = intent2.getStringExtra(UpiConstants.EXTRA_BENEFICIARY_ID);
                        beneficiaryEntity2.instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
                        if (UpiAppUtils.checkIsVpa(stringExtra)) {
                            BeneficiaryEntity.UPI upi = new BeneficiaryEntity.UPI();
                            upi.accounts = new ArrayList<>();
                            BeneficiaryEntity.UPIAccount uPIAccount = new BeneficiaryEntity.UPIAccount();
                            uPIAccount.accountDetail = new BeneficiaryEntity.UPIAccountDetail();
                            uPIAccount.accountDetail.accountHolderName = stringExtra2;
                            uPIAccount.accountDetail.vpa = stringExtra;
                            uPIAccount.uuid = "";
                            upi.accounts.add(uPIAccount);
                            beneficiaryEntity2.instrumentPreferences.upi = upi;
                        } else {
                            BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
                            otherBank.accounts = new ArrayList<>();
                            BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
                            otherBankAccount.accountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
                            otherBankAccount.accountDetail.accountHolderName = stringExtra2;
                            otherBankAccount.accountDetail.accountNumber = stringExtra;
                            otherBankAccount.accountDetail.ifscCode = stringExtra4;
                            otherBankAccount.accountDetail.bankName = stringExtra3;
                            otherBankAccount.uuid = "";
                            otherBank.accounts.add(otherBankAccount);
                            beneficiaryEntity2.instrumentPreferences.otherBank = otherBank;
                        }
                        if (this.f54515i == null) {
                            this.f54515i = new ArrayList<>();
                        }
                        this.f54515i.add(0, beneficiaryEntity2);
                        net.one97.paytm.moneytransfer.view.a.a aVar = this.k;
                        if (aVar != null) {
                            aVar.notifyItemInserted(0);
                        }
                    }
                    if (intent2 != null) {
                        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mt_beneficiary_added_sheet, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_money_transfer);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_request_money);
                        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_name);
                        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_bank_name);
                        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_acc_no);
                        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_ifsc);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImageView);
                        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_request_money_arrow);
                        boolean isEmpty = TextUtils.isEmpty(intent2.getStringExtra(UpiConstants.EXTRA_BANK_NAME));
                        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.close_iv);
                        if (!isEmpty) {
                            textView4.setText(intent2.getStringExtra(UpiConstants.EXTRA_BANK_NAME));
                        } else {
                            textView4.setVisibility(8);
                        }
                        if (!TextUtils.isEmpty(intent2.getStringExtra(UpiConstants.EXTRA_IFSC))) {
                            textView6.setText(getString(R.string.money_transfer_ifsc_with_placeholder_without_bold, intent2.getStringExtra(UpiConstants.EXTRA_IFSC)));
                            w.a().a(UpiRequestBuilder.getBankIconUrl(getActivity().getApplicationContext(), intent2.getStringExtra(UpiConstants.EXTRA_IFSC))).a(R.drawable.mt_dummy_beneficiary_icon).b(R.drawable.ic_default_bank).a(imageView, (e) null);
                        } else {
                            textView6.setVisibility(8);
                            imageView.setImageDrawable(androidx.core.content.b.a((Context) getActivity(), R.drawable.ic_bhim));
                        }
                        textView3.setText(intent2.getStringExtra(UpiConstants.EXTRA_ACCOUNT_NAME));
                        if (UpiAppUtils.checkIsVpa(intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER))) {
                            textView5.setText(getString(R.string.money_transfer_upi_id_placeholder, intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER)));
                        } else {
                            textView5.setText(getString(R.string.money_transfer_acc_no_with_placeholder_without_bold, intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER)));
                            textView2.setVisibility(8);
                            imageView2.setVisibility(8);
                        }
                        final com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(getActivity());
                        aVar2.setContentView(inflate);
                        aVar2.setCancelable(true);
                        aVar2.setCanceledOnTouchOutside(true);
                        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
                        from.setState(3);
                        aVar2.show();
                        aVar2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                from.setState(4);
                            }
                        });
                        textView.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar2.dismiss();
                                d.a.a.c.a().c(new UpiDBTransactionModel("", intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER), intent2.getStringExtra(UpiConstants.EXTRA_ACCOUNT_NAME), intent2.getStringExtra(UpiConstants.EXTRA_BANK_NAME), intent2.getStringExtra(UpiConstants.EXTRA_IFSC), "", ""));
                            }
                        });
                        textView2.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar2.dismiss();
                                Intent intent = new Intent(l.this.getActivity(), RequestMoneyV2Activity.class);
                                intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, intent2.getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER));
                                l.this.startActivity(intent);
                            }
                        });
                        imageView3.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar2.dismiss();
                            }
                        });
                    }
                    j();
                }
                int i8 = i2;
            } else if (i2 == 11) {
                if (-1 == i3) {
                    a(this.l.f54202e);
                } else {
                    d();
                }
                super.onActivityResult(i2, i3, intent);
            }
            int i9 = i3;
            super.onActivityResult(i2, i3, intent);
        } else if (i5 == -1) {
            g();
        } else {
            d();
        }
        int i10 = i5;
        int i11 = i4;
        int i12 = i10;
        super.onActivityResult(i2, i3, intent);
    }

    private void g() {
        if (isAdded() && getActivity() != null) {
            this.t.a();
            ((MoneyTransferV3Activity) getActivity()).q();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        BankVpaCreationActivity.a((Fragment) this, accountProvider, this.v, 1002);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_view_all) {
            net.one97.paytm.moneytransfer.d.b bVar = this.f54509c;
            if (bVar != null) {
                int i2 = this.f54508b + 25;
                int d2 = this.t.d();
                net.one97.paytm.moneytransfer.view.a.a aVar = this.k;
                ArrayList arrayList = new ArrayList();
                Iterator<IJRDataModel> it2 = aVar.f54199b.iterator();
                while (it2.hasNext()) {
                    arrayList.add((BeneficiaryEntity) it2.next());
                }
                bVar.a(i2, d2, arrayList);
            }
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
        } else if (id == R.id.tv_add_new_self) {
            h();
        } else if (id == R.id.tv_add_new) {
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "add_new_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
            startActivityForResult(new Intent(getActivity(), MoneyTransferAddBeneficiaryActivity.class), 1004);
        }
    }

    private void h() {
        if (this.t.b()) {
            AccountProviderActivity.a((Fragment) this, 1001);
        } else {
            i();
        }
    }

    private void i() {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, 80);
    }

    public final void a() {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, 11);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            d.c().a((Activity) getActivity(), MoneyTransferV3Activity.class.getSimpleName());
        } else {
            com.paytm.utility.b.b((Context) getActivity(), "Error", upiCustomVolleyError.getAlertMessage());
        }
    }

    public final String e() {
        return this.v;
    }

    public final void a(ArrayList<BankAccountDetails.BankAccount> arrayList, String str) {
        if (isAdded()) {
            this.u = arrayList;
            this.v = str;
            List<BankAccountDetails.BankAccount> list = this.u;
            if (list != null && list.size() > 0) {
                this.j = new ArrayList<>();
                for (BankAccountDetails.BankAccount next : this.u) {
                    BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
                    BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
                    BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
                    BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
                    otherBankAccount.uuid = "0";
                    otherBankAccountDetail.accountHolderName = next.getCustomerName();
                    otherBankAccountDetail.accountNumber = next.getAccount();
                    otherBankAccountDetail.bankName = next.getBankName();
                    otherBankAccountDetail.ifscCode = next.getIfsc();
                    otherBankAccountDetail.logoUrl = next.getBankLogoUrl();
                    otherBankAccountDetail.isMpinSet = next.isMpinSet();
                    otherBankAccount.accountDetail = otherBankAccountDetail;
                    ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList2 = new ArrayList<>();
                    arrayList2.add(otherBankAccount);
                    otherBank.accounts = arrayList2;
                    instrumentPreferences.otherBank = otherBank;
                    beneficiaryEntity.instrumentPreferences = instrumentPreferences;
                    this.j.add(beneficiaryEntity);
                }
                this.l.a(this.j);
                this.f54513g.setVisibility(0);
            }
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            if (this.f54514h == null) {
                this.f54514h = UpiAppUtils.getWalletStyleProgressDialog(getActivity());
            }
            Dialog dialog = this.f54514h;
            if (dialog != null && !dialog.isShowing()) {
                this.f54514h.show();
                return;
            }
            return;
        }
        Dialog dialog2 = this.f54514h;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f54514h.dismiss();
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            this.y.setVisibility(0);
            this.w.startShimmerAnimation();
            return;
        }
        this.y.setVisibility(8);
        this.w.stopShimmerAnimation();
    }

    public final void c(boolean z2) {
        if (z2) {
            this.z.setVisibility(0);
            this.x.startShimmerAnimation();
            return;
        }
        this.z.setVisibility(8);
        this.x.stopShimmerAnimation();
    }

    public final void f() {
        this.f54513g.setVisibility(8);
    }

    public final void b() {
        f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_DELETE_SAVED_BANK, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
        this.f54515i.remove(this.m);
        this.k.notifyItemRemoved(this.m);
        j();
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.paytm.utility.b.a((Context) getActivity(), getResources().getString(R.string.error), str);
        } else {
            com.paytm.utility.b.a((Context) getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.some_went_wrong));
        }
    }

    public final void c() {
        a(false);
        d();
        Toast.makeText(getActivity(), R.string.some_went_wrong, 1).show();
    }

    private void e(boolean z2) {
        if (isAdded()) {
            IncorrectUpiPinBottomSheet.show(new IncorrectUpiPinBottomSheet.OnItemClick() {
                public final void onReEnterClicked() {
                    net.one97.paytm.moneytransfer.view.a.a k = l.this.l;
                    int j = l.this.E;
                    k.f54202e = j;
                    k.f54203f = true;
                    k.notifyItemChanged(j);
                    l.this.t.a(l.this.D);
                }

                public final void onCreateNewPinClicked() {
                    UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                    upiProfileDefaultBank.setVirtualAddress(l.this.v);
                    upiProfileDefaultBank.setDebitBank(l.this.D);
                    l.b(l.this, upiProfileDefaultBank);
                }
            }, getChildFragmentManager(), z2);
        }
    }

    public final void d() {
        this.l.a("");
    }

    public final void a(String str, String str2, String str3) {
        if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
            this.l.a(getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2)));
            return;
        }
        this.l.a(getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2)));
    }

    public final void d(boolean z2) {
        f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "homepage_check_balance_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, z2 ? "success" : ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, "");
    }

    public final synchronized void a(ArrayList<BeneficiaryEntity> arrayList) {
        if (isAdded()) {
            if (this.f54508b == 0) {
                this.f54515i.clear();
                this.f54515i.addAll(arrayList);
                this.k.notifyItemRangeInserted(0, arrayList.size());
                this.f54512f.setVisibility(0);
                boolean z2 = true;
                if (getActivity() != null) {
                    z2 = net.one97.paytm.moneytransfer.utils.l.a(getActivity().getApplicationContext()).b("is_beneficiary_animation_shown", false, true);
                }
                if (!z2) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            l.f(l.this);
                            net.one97.paytm.moneytransfer.view.a.a g2 = l.this.k;
                            if (g2.getItemCount() > 0) {
                                q qVar = g2.f54198a;
                                synchronized (qVar.f54193d) {
                                    qVar.f54190a.put("0", 2);
                                    if (qVar.f54191b.containsKey("0")) {
                                        qVar.f54191b.get("0").a(true);
                                    } else if (qVar.f54192c) {
                                        qVar.a("0", qVar.f54191b.get("0"));
                                    }
                                }
                                new Handler().postDelayed(new Runnable() {
                                    public final void run(
/*
Method generation error in method: net.one97.paytm.moneytransfer.view.a.a.1.run():void, dex: classes5.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.moneytransfer.view.a.a.1.run():void, class status: UNLOADED
                                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                    
*/
                                }, 500);
                            }
                        }
                    }, 1000);
                }
            } else {
                int size = this.f54515i.size();
                this.f54515i.addAll(arrayList);
                this.k.notifyItemRangeInserted(size, arrayList.size());
            }
            j();
        }
    }

    private void j() {
        ArrayList<IJRDataModel> arrayList = this.f54515i;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f54512f.setVisibility(8);
            return;
        }
        this.f54512f.setVisibility(0);
        if (this.f54515i.size() > f54507a) {
            this.s.setVisibility(0);
            this.s.setText(getString(R.string.mt_view_more));
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a((Context) getActivity(), R.drawable.ic_down_arrow), (Drawable) null);
            return;
        }
        this.s.setVisibility(8);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, String str) {
        if (getActivity() != null && isAdded()) {
            if (!TextUtils.isEmpty(str)) {
                if ("ZM".equals(str)) {
                    e(false);
                } else if ("1006".equals(str)) {
                    a();
                } else if ("Z6".equals(str)) {
                    e(true);
                } else {
                    Toast.makeText(getActivity(), R.string.upi_check_balance_error, 1).show();
                }
            } else if (upiCustomVolleyError != null) {
                String str2 = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str2) && UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                    com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
                } else if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(str2) || "410".equalsIgnoreCase(str2)) {
                    net.one97.paytm.moneytransfer.d.a c2 = d.c();
                    FragmentActivity activity = getActivity();
                    String canonicalName = MoneyTransferV3Activity.class.getCanonicalName();
                    new NetworkCustomError();
                    c2.a((Activity) activity, canonicalName, false);
                } else {
                    Toast.makeText(getActivity(), R.string.some_went_wrong, 1).show();
                }
            } else {
                Toast.makeText(getActivity(), R.string.some_went_wrong, 1).show();
            }
            d();
        }
    }

    static /* synthetic */ void a(l lVar, String str) {
        ArrayList<IJRDataModel> arrayList = lVar.f54515i;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < lVar.f54515i.size(); i2++) {
                if (str.equalsIgnoreCase(((BeneficiaryEntity) lVar.f54515i.get(i2)).beneficiaryId)) {
                    lVar.f54515i.remove(i2);
                    lVar.k.notifyItemRemoved(i2);
                    lVar.j();
                    return;
                }
            }
        }
    }

    static /* synthetic */ void c(l lVar) {
        View inflate = LayoutInflater.from(lVar.getActivity()).inflate(R.layout.confirm_delete_bottom_sheet, (ViewGroup) null);
        inflate.findViewById(R.id.delete_message);
        lVar.p = new com.google.android.material.bottomsheet.a(lVar.getActivity());
        lVar.p.setContentView(inflate);
        lVar.p.setCancelable(false);
        lVar.p.setCanceledOnTouchOutside(false);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setState(3);
        lVar.p.show();
        lVar.p.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_delete_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (com.paytm.utility.b.c(l.this.getContext())) {
                    l.this.p.dismiss();
                    l.i(l.this);
                    return;
                }
                com.paytm.utility.b.b((Context) l.this.getActivity(), "No Internet Connection", "We can not detect any internet connectivity. Please check your internet connection and try again.");
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.p.dismiss();
            }
        });
    }

    static /* synthetic */ void a(l lVar, int i2, boolean z2) {
        String str;
        String str2;
        String str3;
        if (!com.paytm.utility.b.c(lVar.getContext())) {
            m.d((Activity) lVar.getActivity());
        } else if (z2) {
            List<BankAccountDetails.BankAccount> list = lVar.u;
            if (list != null && !list.isEmpty()) {
                UpiProfileAccountDetailActivity.a(lVar, lVar.u.get(i2), lVar.v, 1003);
            }
        } else {
            String str4 = "";
            if (((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.otherBank != null) {
                str4 = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountHolderName;
                str = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName;
                String str5 = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber;
                str3 = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.otherBank.accounts.get(0).accountDetail.ifscCode;
                str2 = str5;
            } else if (((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.upi != null) {
                String str6 = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.upi.accounts.get(0).accountDetail.accountHolderName;
                str2 = ((BeneficiaryEntity) lVar.f54515i.get(i2)).instrumentPreferences.upi.accounts.get(0).accountDetail.vpa;
                str3 = str4;
                str4 = str6;
                str = str3;
            } else {
                str2 = str4;
                str = str2;
                str3 = str;
            }
            Intent intent = new Intent(lVar.getActivity(), MoneyTransferUserHistoryActivity.class);
            intent.putExtra("account_holder_name", str4);
            intent.putExtra(PayUtility.BANK_NAME, str);
            intent.putExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str2);
            intent.putExtra("ifsc_code", str3);
            lVar.startActivity(intent);
        }
    }

    static /* synthetic */ void a(l lVar, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(lVar.getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        if (build.getBankAccountList() != null) {
            net.one97.paytm.moneytransfer.d.a c2 = d.c();
            c2.b("MoneyTransferBeneficiaryListFragment", build.getBankAccountList().size() + "_" + build.getSelectedBankIdx());
        } else {
            net.one97.paytm.moneytransfer.d.a c3 = d.c();
            c3.b("MoneyTransferBeneficiaryListFragment", "null_" + build.getSelectedBankIdx());
        }
        lVar.startActivityForResult(intent, 10);
    }

    static /* synthetic */ void f(l lVar) {
        if (lVar.getActivity() != null) {
            net.one97.paytm.moneytransfer.utils.l.a(lVar.getActivity().getApplicationContext()).a("is_beneficiary_animation_shown", true, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void i(net.one97.paytm.moneytransfer.view.fragments.l r5) {
        /*
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r5.f54515i
            int r1 = r5.m
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r0 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r0
            java.lang.String r0 = r0.beneficiaryId
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r1 = r5.f54515i
            int r2 = r5.m
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            r2 = 0
            if (r1 == 0) goto L_0x0036
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r1 = r5.f54515i
            int r3 = r5.m
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r1 = r1.accounts
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r1
            java.lang.String r1 = r1.uuid
            goto L_0x0064
        L_0x0036:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r1 = r5.f54515i
            int r3 = r5.m
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r1 = r1.upi
            if (r1 == 0) goto L_0x0062
            r1 = 1
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r3 = r5.f54515i
            int r4 = r5.m
            java.lang.Object r3 = r3.get(r4)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r3 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r3
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r3 = r3.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r3 = r3.upi
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r3 = r3.accounts
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r3 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r3
            java.lang.String r3 = r3.uuid
            r1 = r3
            r3 = 1
            goto L_0x0065
        L_0x0062:
            java.lang.String r1 = ""
        L_0x0064:
            r3 = 0
        L_0x0065:
            androidx.fragment.app.FragmentActivity r4 = r5.getActivity()
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r4 == 0) goto L_0x0086
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0082
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x007c
            goto L_0x0082
        L_0x007c:
            net.one97.paytm.moneytransfer.a.c$a r5 = r5.t
            r5.a(r1, r0, r3)
            return
        L_0x0082:
            r5.b()
            return
        L_0x0086:
            r5.a((boolean) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.l.i(net.one97.paytm.moneytransfer.view.fragments.l):void");
    }

    static /* synthetic */ void b(l lVar, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(lVar.getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        if (build.getBankAccountList() != null) {
            net.one97.paytm.moneytransfer.d.a c2 = d.c();
            c2.b("MoneyTransferBeneficiaryListFragment", build.getBankAccountList().size() + "_" + build.getSelectedBankIdx());
        } else {
            net.one97.paytm.moneytransfer.d.a c3 = d.c();
            c3.b("MoneyTransferBeneficiaryListFragment", "null_" + build.getSelectedBankIdx());
        }
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
        lVar.startActivityForResult(intent, 10);
    }
}
