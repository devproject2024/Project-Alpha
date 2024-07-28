package net.one97.paytm.moneytransferv4.accountsbottomsheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.v;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.e;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends net.one97.paytm.i.f implements View.OnClickListener, n.c, e.b {
    public static final b j = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f55005a;

    /* renamed from: b  reason: collision with root package name */
    c f55006b;

    /* renamed from: c  reason: collision with root package name */
    public final e f55007c = new e();

    /* renamed from: d  reason: collision with root package name */
    public List<? extends UpiProfileDefaultBank> f55008d;

    /* renamed from: e  reason: collision with root package name */
    public int f55009e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55010f;

    /* renamed from: g  reason: collision with root package name */
    public C0995a f55011g;

    /* renamed from: h  reason: collision with root package name */
    public v f55012h;

    /* renamed from: i  reason: collision with root package name */
    public String f55013i = "";
    private final int k;
    private final int l = 1;
    private final int m = 2;
    private final int n = 3;
    private final int o = 4;
    private UPICheckBalanceHelper p;
    private int q;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r;
    private HashMap s;

    /* renamed from: net.one97.paytm.moneytransferv4.accountsbottomsheet.a$a  reason: collision with other inner class name */
    public interface C0995a {
        void a();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            k.a();
        }
        this.r = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c) am.a(parentFragment).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.class);
    }

    public final void a(Integer num) {
        if (num == null) {
            k.a();
        }
        this.f55009e = num.intValue();
        e eVar = this.f55007c;
        if (eVar != null) {
            eVar.a(num.intValue());
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new e(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55016a;

        e(a aVar) {
            this.f55016a = aVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                FrameLayout frameLayout = (FrameLayout) aVar.findViewById(R.id.design_bottom_sheet);
                View findViewById = aVar.findViewById(R.id.touch_outside);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ e f55017a;

                        {
                            this.f55017a = r1;
                        }

                        public final void onClick(View view) {
                            String str;
                            String string;
                            String str2;
                            String string2;
                            if (this.f55017a.f55016a.d()) {
                                Context requireContext = this.f55017a.f55016a.requireContext();
                                Bundle arguments = this.f55017a.f55016a.getArguments();
                                if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                                    str2 = "";
                                } else {
                                    str2 = string2;
                                }
                                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, Events.Action.BOTTOMSHEET_TAP_OUTSIDE, "", "", "", str2, "", Events.Screen.BOTTOMSHEET, "");
                            } else if (this.f55017a.f55016a.e()) {
                                Context requireContext2 = this.f55017a.f55016a.requireContext();
                                Bundle arguments2 = this.f55017a.f55016a.getArguments();
                                if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                                    str = "";
                                } else {
                                    str = string;
                                }
                                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, Events.Action.BOTTOMSHEET_TAP_OUTSIDE, "", "", "", str, "", Events.Screen.BOTTOMSHEET, "");
                            }
                            this.f55017a.f55016a.dismissAllowingStateLoss();
                        }
                    });
                }
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f55016a.getResources().getColor(R.color.transparent));
                    from.setState(3);
                    from.setPeekHeight(500);
                    from.setHideable(true);
                    from.setSkipCollapsed(true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
        r0 = r0.e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r3, android.view.ViewGroup r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r3, r5)
            int r5 = net.one97.paytm.moneytransfer.R.layout.mt_v4_accounts_bottomsheet_fragment
            r0 = 0
            android.view.View r3 = r3.inflate(r5, r4, r0)
            net.one97.paytm.moneytransfer.c.v r4 = net.one97.paytm.moneytransfer.c.v.a(r3)
            java.lang.String r5 = "MtV4AccountsBottomsheetFragmentBinding.bind(view)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r2.f55012h = r4
            net.one97.paytm.moneytransfer.c.v r4 = r2.f55012h
            java.lang.String r5 = "binding"
            if (r4 != 0) goto L_0x0020
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0020:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f53855b
            java.lang.String r1 = "accountsRecyclerView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.moneytransferv4.accountsbottomsheet.e r1 = r2.f55007c
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
            net.one97.paytm.moneytransferv4.accountsbottomsheet.e r0 = r2.f55007c
            if (r0 == 0) goto L_0x0037
            java.util.List<? extends net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r1 = r2.f55008d
            r0.a((java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>) r1)
        L_0x0037:
            net.one97.paytm.moneytransfer.c.v r0 = r2.f55012h
            if (r0 != 0) goto L_0x003e
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x003e:
            androidx.recyclerview.widget.RecyclerView r0 = r0.f53855b
            java.lang.String r1 = "binding.accountsRecyclerView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.moneytransfer.c.v r1 = r2.f55012h
            if (r1 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x004c:
            androidx.constraintlayout.widget.ConstraintLayout r5 = r1.a()
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a$c r1 = new net.one97.paytm.moneytransferv4.accountsbottomsheet.a$c
            r1.<init>(r0)
            android.view.View$OnLayoutChangeListener r1 = (android.view.View.OnLayoutChangeListener) r1
            r5.addOnLayoutChangeListener(r1)
            net.one97.paytm.moneytransferv4.accountsbottomsheet.e r5 = r2.f55007c
            if (r5 == 0) goto L_0x0064
            r0 = r2
            net.one97.paytm.moneytransferv4.accountsbottomsheet.e$b r0 = (net.one97.paytm.moneytransferv4.accountsbottomsheet.e.b) r0
            r5.a((net.one97.paytm.moneytransferv4.accountsbottomsheet.e.b) r0)
        L_0x0064:
            android.widget.TextView r5 = r4.f53857d
            r0 = r2
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
            android.widget.TextView r5 = r4.m
            java.lang.String r0 = "upiId"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r2.r
            r1 = 0
            if (r0 == 0) goto L_0x0085
            androidx.lifecycle.y r0 = r0.e()
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0086
        L_0x0085:
            r0 = r1
        L_0x0086:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r5 = r2.r
            if (r5 == 0) goto L_0x009c
            androidx.lifecycle.y r5 = r5.f()
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r5.getValue()
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x009c:
            java.lang.String r5 = net.one97.paytm.upi.f.a((java.lang.String) r1)
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00b1
            android.content.Context r5 = r2.getContext()
            java.lang.String r5 = com.paytm.utility.b.j((android.content.Context) r5)
        L_0x00b1:
            android.widget.TextView r0 = r4.f53862i
            java.lang.String r1 = "name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.content.Context r0 = r2.getContext()
            java.lang.String r0 = com.paytm.utility.b.al(r0)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00f4
            com.squareup.picasso.w r5 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r5 = r5.a((java.lang.String) r0)
            net.one97.paytm.upi.util.CircleTransform r0 = new net.one97.paytm.upi.util.CircleTransform
            r0.<init>()
            com.squareup.picasso.ah r0 = (com.squareup.picasso.ah) r0
            com.squareup.picasso.aa r5 = r5.a((com.squareup.picasso.ah) r0)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r5 = r5.a((int) r0)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r5 = r5.b((int) r0)
            android.widget.ImageView r0 = r4.f53860g
            r5.a((android.widget.ImageView) r0)
            goto L_0x0104
        L_0x00f4:
            android.widget.TextView r0 = r4.f53859f
            java.lang.String r1 = "contactInitials"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r5 = net.one97.paytm.upi.util.UpiUtils.getNameInitials(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x0104:
            android.widget.TextView r5 = r4.j
            java.lang.String r0 = r2.f55013i
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.TextView) r5, (java.lang.String) r0)
            android.widget.TextView r5 = r4.j
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a$d r0 = new net.one97.paytm.moneytransferv4.accountsbottomsheet.a$d
            r0.<init>(r2)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
            boolean r5 = r2.f55010f
            if (r5 == 0) goto L_0x0127
            android.widget.TextView r4 = r4.j
            java.lang.String r5 = "proceed"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r4)
        L_0x0127:
            androidx.lifecycle.al r4 = new androidx.lifecycle.al
            r5 = r2
            androidx.lifecycle.ao r5 = (androidx.lifecycle.ao) r5
            net.one97.paytm.moneytransferv4.d.a.q r0 = r2.f55005a
            if (r0 != 0) goto L_0x0135
            java.lang.String r1 = "viewModelFactory"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0135:
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            r4.<init>((androidx.lifecycle.ao) r5, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.moneytransferv4.accountsbottomsheet.c> r5 = net.one97.paytm.moneytransferv4.accountsbottomsheet.c.class
            androidx.lifecycle.ai r4 = r4.a(r5)
            java.lang.String r5 = "ViewModelProvider(this, …eetViewModel::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c r4 = (net.one97.paytm.moneytransferv4.accountsbottomsheet.c) r4
            r2.f55006b = r4
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c r4 = r2.f55006b
            if (r4 != 0) goto L_0x0152
            java.lang.String r5 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0152:
            r4.b()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55015a;

        d(a aVar) {
            this.f55015a = aVar;
        }

        public final void onClick(View view) {
            C0995a a2 = this.f55015a.f55011g;
            if (a2 != null) {
                a2.a();
            }
            a.b(this.f55015a);
        }
    }

    public final void onClick(View view) {
        com.paytm.b.a.a aVar;
        boolean z;
        String str;
        com.paytm.b.a.a aVar2;
        Context applicationContext;
        Context applicationContext2;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.addBankAccount;
        if (valueOf != null && valueOf.intValue() == i2) {
            Context context = getContext();
            if (context == null || (applicationContext2 = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar3 = l.f54175a;
                aVar = l.a.a(applicationContext2);
            }
            boolean z2 = false;
            if (aVar != null) {
                z = aVar.b("is_upi_user", false, true);
            } else {
                z = false;
            }
            if (z) {
                Context context2 = getContext();
                if (context2 == null || (applicationContext = context2.getApplicationContext()) == null) {
                    aVar2 = null;
                } else {
                    l.a aVar4 = l.f54175a;
                    aVar2 = l.a.a(applicationContext);
                }
                if (aVar2 != null) {
                    z2 = aVar2.b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
                }
                if (!z2) {
                    int i3 = this.k;
                    Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
                    intent.putExtra("redirect", 80);
                    intent.setFlags(536870912);
                    startActivityForResult(intent, i3);
                } else if (com.paytm.utility.a.m(getContext())) {
                    AccountProviderActivity.a((Fragment) this, 31);
                } else {
                    m.d((Activity) getActivity());
                }
            } else if (UpiUtils.isInActiveProfileExist(getContext())) {
                startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(getActivity()), this.o);
            } else {
                Intent intent2 = new Intent(getActivity(), UpiSelectBankActivity.class);
                intent2.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                intent2.setFlags(536870912);
                startActivityForResult(intent2, 352);
            }
            if (e()) {
                List<? extends UpiProfileDefaultBank> list = this.f55008d;
                if (list != null) {
                    num = Integer.valueOf(list.size());
                }
                String str2 = String.valueOf(num) + " Banks";
                Context requireContext = requireContext();
                Bundle arguments = getArguments();
                if (arguments == null || (str = arguments.getString("vpa")) == null) {
                    str = "";
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, str2, "", "", str, "", Events.Screen.BOTTOMSHEET, "");
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        y<String> e2;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            String str = null;
            if (i2 == 352) {
                Fragment parentFragment = getParentFragment();
                if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
                if (bVar != null) {
                    bVar.k();
                }
            } else if (i2 == this.k) {
                Fragment parentFragment2 = getParentFragment();
                if (!(parentFragment2 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment2 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar2 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment2;
                if (bVar2 != null) {
                    bVar2.k();
                }
            } else if (i2 == this.o) {
                Fragment parentFragment3 = getParentFragment();
                if (!(parentFragment3 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment3 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar3 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment3;
                if (bVar3 != null) {
                    bVar3.k();
                }
            } else if (i2 == 10) {
                Fragment parentFragment4 = getParentFragment();
                if (!(parentFragment4 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment4 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar4 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment4;
                if (bVar4 != null) {
                    bVar4.k();
                }
            } else if (i2 == this.n) {
                Fragment parentFragment5 = getParentFragment();
                if (!(parentFragment5 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment5 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar5 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment5;
                if (bVar5 != null) {
                    bVar5.k();
                }
            } else if (i2 == 31) {
                Serializable serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
                if (serializableExtra != null) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                    Fragment fragment = this;
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.r;
                    if (!(cVar == null || (e2 = cVar.e()) == null)) {
                        str = e2.getValue();
                    }
                    BankVpaCreationActivity.a(fragment, accountProvider, str, 34);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            } else if (i2 == 34) {
                Fragment parentFragment6 = getParentFragment();
                if (!(parentFragment6 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment6 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar6 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment6;
                if (bVar6 != null) {
                    bVar6.k();
                }
            }
        } else if (i2 == this.l) {
            Toast.makeText(getActivity(), R.string.upi_check_balance_error, 1).show();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        String str2;
        UpiProfileDefaultBank f2 = f();
        if (f2 != null && e()) {
            Context requireContext = requireContext();
            BankAccountDetails.BankAccount debitBank = f2.getDebitBank();
            k.a((Object) debitBank, "it.debitBank");
            String bankName = debitBank.getBankName();
            Bundle arguments = getArguments();
            if (arguments == null || (str2 = arguments.getString("vpa")) == null) {
                str2 = "";
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, str, bankName, "", "", str2, "", Events.Screen.BOTTOMSHEET, "upi");
        }
    }

    /* access modifiers changed from: private */
    public final void b(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (this.p == null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.p = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.m)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UPICheckBalanceHelper uPICheckBalanceHelper = this.p;
        if (uPICheckBalanceHelper != null) {
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        }
    }

    public final void Z_() {
        this.f55007c.a();
    }

    public final void b() {
        this.f55007c.b();
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        String str5;
        k.c(str3, "accountType");
        if (isResumed()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(\n             …alance)\n                )");
            } else {
                str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
            }
            e eVar = this.f55007c;
            if (eVar != null) {
                eVar.a(str4);
            }
            UpiProfileDefaultBank g2 = g();
            if (g2 != null && e()) {
                Context requireContext = requireContext();
                BankAccountDetails.BankAccount debitBank = g2.getDebitBank();
                k.a((Object) debitBank, "it.debitBank");
                String bankName = debitBank.getBankName();
                Bundle arguments = getArguments();
                if (arguments == null || (str5 = arguments.getString("vpa")) == null) {
                    str5 = "";
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, bankName, "", "", str5, "", Events.Screen.BOTTOMSHEET, "upi");
            }
        }
    }

    public final void a(n.b bVar) {
        String str;
        String string;
        k.c(bVar, "errorUPI");
        if (isResumed()) {
            if (bVar == n.b.INCORRECT_MPIN) {
                a(false);
            } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
                a(true);
            } else {
                UpiUtils.handleCheckBalanceError(getActivity(), bVar);
            }
            UpiProfileDefaultBank g2 = g();
            if (g2 != null && e()) {
                Context requireContext = requireContext();
                BankAccountDetails.BankAccount debitBank = g2.getDebitBank();
                k.a((Object) debitBank, "it.debitBank");
                String bankName = debitBank.getBankName();
                String valueOf = String.valueOf(bVar.getErrorCode());
                String str2 = valueOf == null ? "" : valueOf;
                Bundle arguments = getArguments();
                if (arguments == null || (string = arguments.getString("vpa")) == null) {
                    str = "";
                } else {
                    str = string;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, bankName, str2, "", str, "", Events.Screen.BOTTOMSHEET, "upi");
            }
        }
    }

    private final void a(boolean z) {
        if (isAdded()) {
            j childFragmentManager = getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new f(this), childFragmentManager, z);
        }
    }

    public static final class f implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55018a;

        f(a aVar) {
            this.f55018a = aVar;
        }

        public final void onReEnterClicked() {
            String str;
            UpiProfileDefaultBank c2 = this.f55018a.f();
            if (c2 != null) {
                this.f55018a.b(c2);
                if (this.f55018a.e()) {
                    Context requireContext = this.f55018a.requireContext();
                    BankAccountDetails.BankAccount debitBank = c2.getDebitBank();
                    k.a((Object) debitBank, "it.debitBank");
                    String bankName = debitBank.getBankName();
                    Bundle arguments = this.f55018a.getArguments();
                    if (arguments == null || (str = arguments.getString("vpa")) == null) {
                        str = "";
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, "UPI_pin_reentered", bankName, "", "", str, "", Events.Screen.BOTTOMSHEET, "");
                }
            }
        }

        public final void onCreateNewPinClicked() {
            BankAccountDetails.BankAccount debitBank;
            UpiProfileDefaultBank c2 = this.f55018a.f();
            if (c2 != null && (debitBank = c2.getDebitBank()) != null) {
                a aVar = this.f55018a;
                k.c(debitBank, "bankAccount");
                aVar.a(CJRGTMConstants.MT_V4_RESET_UPI_PIN);
                Intent intent = new Intent(aVar.getActivity(), SetMPINActivity.class);
                List a2 = kotlin.a.k.a(debitBank);
                c cVar = aVar.f55006b;
                if (cVar == null) {
                    k.a("viewModel");
                }
                UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, cVar.a()).setBankAccountList(a2).build();
                k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
                intent.putExtra("user_upi_details", build);
                intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
                aVar.startActivityForResult(intent, 10);
            }
        }
    }

    public final void a(int i2) {
        String str;
        String string;
        String str2;
        String string2;
        this.f55009e = i2;
        if (isResumed()) {
            dismiss();
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
            parentFragment = null;
        }
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
        if (bVar != null) {
            bVar.f55442e = i2;
            bVar.b(false);
            bVar.a(i2);
            bVar.i();
        }
        if (d()) {
            Context requireContext = requireContext();
            List<? extends UpiProfileDefaultBank> list = this.f55008d;
            if (list == null) {
                k.a();
            }
            BankAccountDetails.BankAccount debitBank = ((UpiProfileDefaultBank) list.get(i2)).getDebitBank();
            k.a((Object) debitBank, "vpaList!!.get(position).debitBank");
            String bankName = debitBank.getBankName();
            Bundle arguments = getArguments();
            if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                str2 = "";
            } else {
                str2 = string2;
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, CJRGTMConstants.MT_V4_SOURCE_AC_LIST_ITEM_CLCIKED, bankName, "", "", str2, "", Events.Screen.BOTTOMSHEET, "");
        } else if (e()) {
            Context requireContext2 = requireContext();
            List<? extends UpiProfileDefaultBank> list2 = this.f55008d;
            if (list2 == null) {
                k.a();
            }
            BankAccountDetails.BankAccount debitBank2 = ((UpiProfileDefaultBank) list2.get(i2)).getDebitBank();
            k.a((Object) debitBank2, "vpaList!!.get(position).debitBank");
            String bankName2 = debitBank2.getBankName();
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                str = "";
            } else {
                str = string;
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, CJRGTMConstants.MT_V4_SOURCE_AC_LIST_ITEM_CLCIKED, bankName2, "", "", str, "", Events.Screen.BOTTOMSHEET, "");
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, int i2) {
        String str;
        String string;
        String str2;
        String string2;
        k.c(upiProfileDefaultBank, "upiProfileDefaultBank");
        if (isResumed()) {
            this.q = i2;
            if (com.paytm.utility.a.m(getContext())) {
                UpiProfileDefaultBank.PAYMENT_MODE paymentMode = upiProfileDefaultBank.getPaymentMode();
                if (paymentMode != null) {
                    int i3 = b.f55019a[paymentMode.ordinal()];
                    if (i3 == 1) {
                        b(upiProfileDefaultBank);
                    } else if (i3 == 2) {
                        b(upiProfileDefaultBank);
                    }
                }
            } else {
                m.d((Activity) getActivity());
            }
        }
        if (getParentFragment() instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b) {
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
            String bankName = debitBank.getBankName();
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
            } else if (((net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment).f55441d) {
                Context requireContext = requireContext();
                Bundle arguments = getArguments();
                if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                    str2 = "";
                } else {
                    str2 = string2;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, "check_balance_clicked", bankName, "", "", str2, this.f55013i, Events.Screen.BOTTOMSHEET, "");
            } else {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
                } else if (((net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment2).f55440c) {
                    Context requireContext2 = requireContext();
                    Bundle arguments2 = getArguments();
                    if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                        str = "";
                    } else {
                        str = string;
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, "check_balance_clicked", bankName, "", "", str, this.f55013i, Events.Screen.BOTTOMSHEET, "");
                }
            }
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (!isResumed()) {
            return;
        }
        if (com.paytm.utility.a.m(getContext())) {
            int i2 = this.n;
            a("set_new_mpin");
            Intent intent = new Intent(getActivity(), SetMPINActivity.class);
            ArrayList arrayList = new ArrayList();
            if (upiProfileDefaultBank == null) {
                k.a();
            }
            arrayList.add(upiProfileDefaultBank.getDebitBank());
            intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
            intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, false);
            startActivityForResult(intent, i2);
            return;
        }
        m.d((Activity) getActivity());
    }

    public final void c() {
        if (this.f55012h != null) {
            v vVar = this.f55012h;
            if (vVar == null) {
                k.a("binding");
            }
            TextView textView = vVar.j;
            k.a((Object) textView, "binding.proceed");
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
        }
    }

    /* access modifiers changed from: private */
    public final UpiProfileDefaultBank f() {
        List<? extends UpiProfileDefaultBank> list = this.f55008d;
        if (list == null || !(!list.isEmpty()) || this.f55009e >= list.size()) {
            return null;
        }
        return (UpiProfileDefaultBank) list.get(this.f55009e);
    }

    private final UpiProfileDefaultBank g() {
        List<? extends UpiProfileDefaultBank> list = this.f55008d;
        if (list == null || !(!list.isEmpty()) || this.q >= list.size()) {
            return null;
        }
        return (UpiProfileDefaultBank) list.get(this.q);
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        if (!jVar.h() && !jVar.i()) {
            super.show(jVar, str);
        }
    }

    static final class c implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f55014a;

        c(RecyclerView recyclerView) {
            this.f55014a = recyclerView;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (i3 != i7 || i5 != i9) {
                RecyclerView.LayoutManager layoutManager = this.f55014a.getLayoutManager();
                int i10 = 0;
                View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(0) : null;
                RecyclerView.a adapter = this.f55014a.getAdapter();
                if (adapter != null) {
                    i10 = adapter.getItemCount();
                }
                if (findViewByPosition != null && i10 > 3) {
                    net.one97.paytm.upi.f.a((View) this.f55014a, (int) (((double) findViewByPosition.getHeight()) * 3.6d));
                }
            }
        }
    }

    public final boolean d() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
            parentFragment = null;
        }
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
        if (bVar != null) {
            return bVar.f55441d;
        }
        return false;
    }

    public final boolean e() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
            parentFragment = null;
        }
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
        if (bVar != null) {
            return bVar.f();
        }
        return false;
    }

    public static final /* synthetic */ void b(a aVar) {
        UpiProfileDefaultBank f2;
        String str;
        String string;
        String str2;
        String string2;
        a aVar2 = aVar;
        if ((aVar.getParentFragment() instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b) && (f2 = aVar.f()) != null) {
            Fragment parentFragment = aVar.getParentFragment();
            if (parentFragment == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
            } else if (((net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment).f55441d) {
                Context requireContext = aVar.requireContext();
                BankAccountDetails.BankAccount debitBank = f2.getDebitBank();
                k.a((Object) debitBank, "it.debitBank");
                String bankName = debitBank.getBankName();
                Bundle arguments = aVar.getArguments();
                if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                    str2 = "";
                } else {
                    str2 = string2;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, Events.Action.BOTTOMSHEET_PROCEED_CLICKED, bankName, "", "", str2, aVar2.f55013i, Events.Screen.BOTTOMSHEET, "");
            } else {
                Fragment parentFragment2 = aVar.getParentFragment();
                if (parentFragment2 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
                } else if (((net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment2).f55440c) {
                    Context requireContext2 = aVar.requireContext();
                    BankAccountDetails.BankAccount debitBank2 = f2.getDebitBank();
                    k.a((Object) debitBank2, "it.debitBank");
                    String bankName2 = debitBank2.getBankName();
                    Bundle arguments2 = aVar.getArguments();
                    if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                        str = "";
                    } else {
                        str = string;
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, Events.Action.BOTTOMSHEET_PROCEED_CLICKED, bankName2, "", "", str, aVar2.f55013i, Events.Screen.BOTTOMSHEET, "");
                } else {
                    FragmentActivity activity = aVar.getActivity();
                    if (activity != null) {
                        MoneyTransferV4Activity moneyTransferV4Activity = (MoneyTransferV4Activity) activity;
                        if ((moneyTransferV4Activity != null ? Boolean.valueOf(moneyTransferV4Activity.m()) : null).booleanValue()) {
                            k.c(aVar2, "$this$sendEvent");
                            k.c("mt_p2p_new_v1", "cat");
                            k.c(CJRGTMConstants.MT_V4_PAY_BOTTOMSHEET_CLICKED, "action");
                            k.c(CJRGTMConstants.MT_V4_BOTTOMSHEET, "screen");
                            k.c(Events.Label.PAY, "label");
                            k.c("", "label2");
                            k.c("", "value");
                            Context context = aVar.getContext();
                            if (context != null) {
                                k.a((Object) context, "it");
                                net.one97.paytm.moneytransfer.utils.e.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_PAY_BOTTOMSHEET_CLICKED, CJRGTMConstants.MT_V4_BOTTOMSHEET, Events.Label.PAY, "", "");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity");
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
