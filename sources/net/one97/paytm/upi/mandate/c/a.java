package net.one97.paytm.upi.mandate.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.v;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.e.w;
import net.one97.paytm.upi.mandate.a.d;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.update.a;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.view.MandateListActivity;
import net.one97.paytm.upi.mandate.view.model.a;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.view.UpiRequestMoneyPagerActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends net.one97.paytm.i.f implements n.c, d.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1352a f67054a = new C1352a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private MandateItem f67055b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.confirmation.c f67056c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.view.model.a f67057d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.a.d f67058e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public UpiProfileDefaultBank f67059f;

    /* renamed from: g  reason: collision with root package name */
    private UPICheckBalanceHelper f67060g;

    /* renamed from: h  reason: collision with root package name */
    private final int f67061h = 2222;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f67062i = 1221;
    private final int j = 1008;
    private final int k = 1009;
    private net.one97.paytm.upi.e.g l;
    /* access modifiers changed from: private */
    public UpiPendingRequestModel m;
    private net.one97.paytm.upi.mandate.utils.k n;
    private HashMap o;

    public static final a a(MandateItem mandateItem, androidx.fragment.app.j jVar, UpiPendingRequestModel upiPendingRequestModel) {
        return C1352a.a(mandateItem, jVar, upiPendingRequestModel);
    }

    static final class f<T> implements z<net.one97.paytm.upi.mandate.data.a<List<? extends UpiProfileDefaultBank>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67066a;

        f(a aVar) {
            this.f67066a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.mandate.data.a aVar = (net.one97.paytm.upi.mandate.data.a) obj;
            int i2 = b.f67076a[aVar.f67117a.ordinal()];
            if (i2 == 1) {
                AnimationFactory.stopWalletLoader(this.f67066a.c().r);
                a.a(this.f67066a, (List) aVar.f67118b, this.f67066a.c());
                TextView textView = this.f67066a.c().A;
                kotlin.g.b.k.a((Object) textView, "binding.proceedButton");
                net.one97.paytm.upi.f.b((View) textView);
            } else if (i2 == 2) {
                AnimationFactory.stopWalletLoader(this.f67066a.c().r);
            } else if (i2 == 3) {
                TextView textView2 = this.f67066a.c().A;
                kotlin.g.b.k.a((Object) textView2, "binding.proceedButton");
                net.one97.paytm.upi.f.a((View) textView2);
                AnimationFactory.startWalletLoader(this.f67066a.c().r);
                Group group = this.f67066a.c().f66809d;
                kotlin.g.b.k.a((Object) group, "binding.bankGroup");
                net.one97.paytm.upi.f.a((View) group);
                TextView textView3 = this.f67066a.c().f66814i;
                kotlin.g.b.k.a((Object) textView3, "binding.checkBalance");
                net.one97.paytm.upi.f.a((View) textView3);
                net.one97.paytm.upi.e.z zVar = this.f67066a.c().v;
                kotlin.g.b.k.a((Object) zVar, "binding.noBankSupportedLayout");
                ConstraintLayout a2 = zVar.a();
                kotlin.g.b.k.a((Object) a2, "binding.noBankSupportedLayout.root");
                net.one97.paytm.upi.f.a((View) a2);
            }
        }
    }

    static final class g<T> implements z<r<MandateDefaultResponseModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67067a;

        g(a aVar) {
            this.f67067a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity;
            r rVar = (r) obj;
            if (rVar != null) {
                int i2 = b.f67077b[rVar.f67411a.ordinal()];
                if (i2 == 1) {
                    a.a(this.f67067a);
                    a aVar = this.f67067a;
                    aVar.c();
                    a.a(aVar, rVar.f67413c);
                } else if (i2 == 2) {
                    a.a(this.f67067a);
                    androidx.localbroadcastmanager.a.a.a(this.f67067a.requireContext()).a(new Intent("action_refresh_pending_mandates"));
                    String str = a.b(this.f67067a).f67585e;
                    if (str == null) {
                        kotlin.g.b.k.a("_authorizationType");
                    }
                    if (!kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.upi.mandate.utils.d.DECLINE.getType())) {
                        a.c(this.f67067a);
                    } else if (this.f67067a.getActivity() instanceof MandateListActivity) {
                        this.f67067a.dismiss();
                    } else if (((this.f67067a.getActivity() instanceof UpiRequestMoneyPagerActivity) || (this.f67067a.getActivity() instanceof UpiPassbookActivity)) && (activity = this.f67067a.getActivity()) != null) {
                        activity.finish();
                    }
                } else if (i2 == 3) {
                    a.d(this.f67067a);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.view.model.a b(a aVar) {
        net.one97.paytm.upi.mandate.view.model.a aVar2 = aVar.f67057d;
        if (aVar2 == null) {
            kotlin.g.b.k.a("pendingMandateViewModel");
        }
        return aVar2;
    }

    public static final /* synthetic */ MandateItem f(a aVar) {
        MandateItem mandateItem = aVar.f67055b;
        if (mandateItem == null) {
            kotlin.g.b.k.a("mandateItem");
        }
        return mandateItem;
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.confirmation.c i(a aVar) {
        net.one97.paytm.upi.mandate.confirmation.c cVar = aVar.f67056c;
        if (cVar == null) {
            kotlin.g.b.k.a("bankViewModel");
        }
        return cVar;
    }

    public final net.one97.paytm.upi.e.g c() {
        net.one97.paytm.upi.e.g gVar = this.l;
        if (gVar == null) {
            kotlin.g.b.k.a();
        }
        return gVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            kotlin.g.b.k.a();
        }
        Serializable serializable = arguments.getSerializable(Payload.RESPONSE);
        if (serializable != null) {
            this.f67055b = (MandateItem) serializable;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializable2 = arguments2.getSerializable("upi_pending_req_model");
            if (!(serializable2 instanceof UpiPendingRequestModel)) {
                serializable2 = null;
            }
            this.m = (UpiPendingRequestModel) serializable2;
            UpiPendingRequestModel upiPendingRequestModel = this.m;
            if (upiPendingRequestModel != null) {
                if (upiPendingRequestModel == null) {
                    kotlin.g.b.k.a();
                }
                if (kotlin.g.b.k.a((Object) "COLLECT", (Object) upiPendingRequestModel.getType())) {
                    this.n = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH;
                    return;
                }
            }
            MandateItem mandateItem = this.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CharSequence accRefId = mandateItem.getAccRefId();
            if (!(accRefId == null || p.a(accRefId))) {
                this.n = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE;
            } else {
                this.n = net.one97.paytm.upi.mandate.utils.k.COLLECT;
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new b(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67063a;

        b(a aVar) {
            this.f67063a = aVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f67063a.getResources().getColor(R.color.transparent));
                    from.setState(3);
                    from.setHideable(true);
                    from.setSkipCollapsed(true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_mandate_collect_request, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            super.onViewCreated(r11, r12)
            net.one97.paytm.upi.e.g r11 = net.one97.paytm.upi.e.g.a(r11)
            r10.l = r11
            net.one97.paytm.upi.mandate.a.d r11 = new net.one97.paytm.upi.mandate.a.d
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            java.lang.String r0 = "mandateItem"
            if (r12 != 0) goto L_0x0019
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0019:
            java.lang.String r12 = r12.getBankFilterType()
            r11.<init>(r12)
            r10.f67058e = r11
            net.one97.paytm.upi.mandate.a.d r11 = r10.f67058e
            java.lang.String r12 = "adapter"
            if (r11 != 0) goto L_0x002b
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x002b:
            r1 = r10
            net.one97.paytm.upi.mandate.a.d$a r1 = (net.one97.paytm.upi.mandate.a.d.a) r1
            r11.a((net.one97.paytm.upi.mandate.a.d.a) r1)
            net.one97.paytm.upi.e.g r11 = r10.c()
            android.widget.ImageView r1 = r11.k
            net.one97.paytm.upi.mandate.c.a$h r2 = new net.one97.paytm.upi.mandate.c.a$h
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.widget.TextView r1 = r11.B
            int r2 = net.one97.paytm.upi.R.drawable.upi_ic_important
            r3 = 0
            r1.setCompoundDrawablesWithIntrinsicBounds(r2, r3, r3, r3)
            net.one97.paytm.upi.e.w r1 = r11.p
            androidx.recyclerview.widget.RecyclerView r1 = r1.f66919a
            java.lang.String r2 = "layoutBanksExpanded.allBankList"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.upi.mandate.a.d r2 = r10.f67058e
            if (r2 != 0) goto L_0x0059
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0059:
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r1.setAdapter(r2)
            net.one97.paytm.upi.mandate.utils.k r12 = r10.n
            java.lang.String r1 = "mandateSource"
            if (r12 != 0) goto L_0x0067
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0067:
            net.one97.paytm.upi.mandate.utils.k r2 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r12 != r2) goto L_0x007d
            android.widget.TextView r12 = r11.z
            java.lang.String r2 = "paymentTitle"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.upi_payment_request
            java.lang.String r2 = r10.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
        L_0x007d:
            android.widget.TextView r12 = r11.x
            java.lang.String r2 = "payeeName"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r10.f67055b
            if (r2 != 0) goto L_0x008b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x008b:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r2 = r2.getUserName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            android.widget.TextView r12 = r11.y
            java.lang.String r2 = "payeeVpa"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.upi_address_value
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x00ab
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00ab:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r6 = r6.getPayee()
            java.lang.String r6 = r6.getVpa()
            r5[r3] = r6
            java.lang.String r2 = r10.getString(r2, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            android.widget.TextView r12 = r11.f66806a
            java.lang.String r2 = "amountTextView"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            net.one97.paytm.upi.mandate.data.model.MandateItem r5 = r10.f67055b
            if (r5 != 0) goto L_0x00cc
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00cc:
            java.lang.String r5 = r5.getAmountRule()
            java.lang.String r6 = "MAX"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
            java.lang.String r7 = " "
            java.lang.String r8 = "UpiAppUtils.formatNumber(mandateItem.amount)"
            if (r5 == 0) goto L_0x0124
            net.one97.paytm.upi.mandate.utils.k r5 = r10.n
            if (r5 != 0) goto L_0x00e3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e3:
            net.one97.paytm.upi.mandate.utils.k r9 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r5 == r9) goto L_0x0124
            int r5 = net.one97.paytm.upi.R.string.upi_mandate_upto
            java.lang.String r5 = r10.getString(r5)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r9.append(r7)
            java.lang.String r5 = r9.toString()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            net.one97.paytm.upi.mandate.data.model.MandateItem r5 = r10.f67055b
            if (r5 != 0) goto L_0x010b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x010b:
            java.lang.String r5 = r5.getAmount()
            java.lang.String r5 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r5 = net.one97.paytm.upi.f.b((java.lang.String) r5)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x013c
        L_0x0124:
            net.one97.paytm.upi.mandate.data.model.MandateItem r5 = r10.f67055b
            if (r5 != 0) goto L_0x012b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x012b:
            java.lang.String r5 = r5.getAmount()
            java.lang.String r5 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r5 = net.one97.paytm.upi.f.b((java.lang.String) r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x013c:
            r12.setText(r5)
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x0146
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0146:
            java.lang.String r12 = r12.getLastAmount()
            java.lang.String r5 = "oldAmount"
            if (r12 == 0) goto L_0x01dc
            android.widget.TextView r12 = r11.w
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            net.one97.paytm.upi.mandate.data.model.MandateItem r8 = r10.f67055b
            if (r8 != 0) goto L_0x015a
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x015a:
            java.lang.String r8 = r8.getAmountRule()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r6)
            java.lang.String r8 = "UpiAppUtils.formatNumber(mandateItem.lastAmount)"
            if (r6 == 0) goto L_0x01ae
            net.one97.paytm.upi.mandate.utils.k r6 = r10.n
            if (r6 != 0) goto L_0x016d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x016d:
            net.one97.paytm.upi.mandate.utils.k r9 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r6 == r9) goto L_0x01ae
            int r6 = net.one97.paytm.upi.R.string.upi_mandate_upto
            java.lang.String r6 = r10.getString(r6)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r7)
            java.lang.String r6 = r9.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x0195
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0195:
            java.lang.String r6 = r6.getLastAmount()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r6)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r6 = net.one97.paytm.upi.f.b((java.lang.String) r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            goto L_0x01c6
        L_0x01ae:
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x01b5
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01b5:
            java.lang.String r6 = r6.getLastAmount()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r6)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r6 = net.one97.paytm.upi.f.b((java.lang.String) r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
        L_0x01c6:
            r12.setText(r6)
            android.widget.TextView r12 = r11.w
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            android.widget.TextView r6 = r11.w
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r6 = r6.getPaintFlags()
            r6 = r6 | 16
            r12.setPaintFlags(r6)
        L_0x01dc:
            net.one97.paytm.upi.util.CircularImageView r12 = r11.q
            android.content.res.Resources r6 = r10.getResources()
            int r7 = net.one97.paytm.upi.R.dimen.dimen_2dp
            float r6 = r6.getDimension(r7)
            int r6 = (int) r6
            r12.setCircularBorder(r4, r6)
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x01f3
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01f3:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r12 = r12.getPayee()
            java.lang.String r12 = r12.getImageUrl()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x0208
            boolean r12 = kotlin.m.p.a(r12)
            if (r12 == 0) goto L_0x0206
            goto L_0x0208
        L_0x0206:
            r12 = 0
            goto L_0x0209
        L_0x0208:
            r12 = 1
        L_0x0209:
            if (r12 == 0) goto L_0x0240
            net.one97.paytm.upi.util.CircularImageView r12 = r11.q
            int r6 = net.one97.paytm.upi.R.color.paytm_blue
            r12.setImageResource(r6)
            android.widget.TextView r12 = r11.u
            java.lang.String r6 = "nameInitials"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            android.view.View r12 = (android.view.View) r12
            net.one97.paytm.upi.f.b((android.view.View) r12)
            android.widget.TextView r12 = r11.u
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x022a
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x022a:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r6 = r6.getPayee()
            java.lang.String r6 = r6.getUserName()
            java.lang.String r6 = net.one97.paytm.upi.f.a((java.lang.String) r6)
            java.lang.String r6 = net.one97.paytm.upi.util.UpiUtils.getNameInitials(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            goto L_0x025e
        L_0x0240:
            com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x024b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x024b:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r6 = r6.getPayee()
            java.lang.String r6 = r6.getImageUrl()
            com.squareup.picasso.aa r12 = r12.a((java.lang.String) r6)
            net.one97.paytm.upi.util.CircularImageView r6 = r11.q
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r12.a((android.widget.ImageView) r6)
        L_0x025e:
            android.widget.TextView r12 = r11.C
            java.lang.String r6 = "updatePlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            android.view.View r12 = (android.view.View) r12
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r10.f67055b
            if (r6 != 0) goto L_0x026e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x026e:
            java.lang.String r6 = r6.getAccRefId()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x027f
            boolean r6 = kotlin.m.p.a(r6)
            if (r6 == 0) goto L_0x027d
            goto L_0x027f
        L_0x027d:
            r6 = 0
            goto L_0x0280
        L_0x027f:
            r6 = 1
        L_0x0280:
            if (r6 != 0) goto L_0x028f
            net.one97.paytm.upi.mandate.utils.k r6 = r10.n
            if (r6 != 0) goto L_0x0289
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0289:
            net.one97.paytm.upi.mandate.utils.k r1 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r6 == r1) goto L_0x028f
            r1 = 1
            goto L_0x0290
        L_0x028f:
            r1 = 0
        L_0x0290:
            net.one97.paytm.upi.f.a((android.view.View) r12, (boolean) r1)
            android.widget.TextView r12 = r11.l
            net.one97.paytm.upi.mandate.c.a$i r1 = new net.one97.paytm.upi.mandate.c.a$i
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            android.widget.TextView r12 = r11.A
            net.one97.paytm.upi.mandate.c.a$j r1 = new net.one97.paytm.upi.mandate.c.a$j
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            android.widget.ImageView r12 = r11.n
            net.one97.paytm.upi.mandate.c.a$k r1 = new net.one97.paytm.upi.mandate.c.a$k
            r1.<init>(r11, r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            net.one97.paytm.upi.e.w r12 = r11.p
            android.widget.ImageView r12 = r12.f66921c
            net.one97.paytm.upi.mandate.c.a$m r1 = new net.one97.paytm.upi.mandate.c.a$m
            r1.<init>(r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x02cc
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02cc:
            java.lang.String r12 = r12.getType()
            java.lang.String r1 = "ONETIME"
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r1)
            if (r12 == 0) goto L_0x033e
            android.widget.TextView r12 = r11.D
            r1 = r12
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.upi.f.b((android.view.View) r1)
            int r1 = net.one97.paytm.upi.R.string.upi_mandate_valid_to
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            net.one97.paytm.upi.mandate.data.model.MandateItem r7 = r10.f67055b
            if (r7 != 0) goto L_0x02ec
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02ec:
            java.lang.String r7 = r7.getValidityStartDate()
            java.lang.String r8 = "dd MMM yyyy"
            java.lang.String r9 = "ddMMyyyy"
            java.lang.String r7 = net.one97.paytm.upi.util.UpiUtils.convertDateFromTo(r9, r8, r7)
            r6[r3] = r7
            net.one97.paytm.upi.mandate.data.model.MandateItem r3 = r10.f67055b
            if (r3 != 0) goto L_0x0301
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0301:
            java.lang.String r3 = r3.getValidityEndDate()
            java.lang.String r3 = net.one97.paytm.upi.util.UpiUtils.convertDateFromTo(r9, r8, r3)
            r6[r4] = r3
            java.lang.String r1 = r10.getString(r1, r6)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            android.widget.TextView r12 = r11.w
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            android.view.View r12 = (android.view.View) r12
            android.content.res.Resources r1 = r10.getResources()
            int r3 = net.one97.paytm.upi.R.dimen.dimen_12dp
            float r1 = r1.getDimension(r3)
            int r1 = (int) r1
            net.one97.paytm.upi.f.b((android.view.View) r12, (int) r1)
            android.widget.TextView r12 = r11.f66806a
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.view.View r12 = (android.view.View) r12
            android.content.res.Resources r1 = r10.getResources()
            int r2 = net.one97.paytm.upi.R.dimen.dimen_12dp
            float r1 = r1.getDimension(r2)
            int r1 = (int) r1
            net.one97.paytm.upi.f.b((android.view.View) r12, (int) r1)
        L_0x033e:
            android.widget.TextView r12 = r11.f66814i
            net.one97.paytm.upi.mandate.c.a$l r1 = new net.one97.paytm.upi.mandate.c.a$l
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            net.one97.paytm.upi.e.z r11 = r11.v
            android.widget.TextView r11 = r11.f66934b
            java.lang.String r12 = "noBankSupportedLayout.heading"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x035a
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x035a:
            net.one97.paytm.upi.mandate.utils.m r12 = r12.getMandateTransactionType()
            net.one97.paytm.upi.mandate.utils.m r1 = net.one97.paytm.upi.mandate.utils.m.ASBA
            if (r12 != r1) goto L_0x036b
            int r12 = net.one97.paytm.upi.R.string.your_linked_bank_accounts_currently_do_not_support_ipo_payments
            java.lang.String r12 = r10.getString(r12)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            goto L_0x0373
        L_0x036b:
            int r12 = net.one97.paytm.upi.R.string.your_linked_bank_accounts_currently_do_not_support_scheduled_payments
            java.lang.String r12 = r10.getString(r12)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
        L_0x0373:
            r11.setText(r12)
            r11 = r10
            androidx.fragment.app.Fragment r11 = (androidx.fragment.app.Fragment) r11
            net.one97.paytm.upi.mandate.utils.o r12 = new net.one97.paytm.upi.mandate.utils.o
            r12.<init>()
            androidx.lifecycle.al$b r12 = (androidx.lifecycle.al.b) r12
            androidx.lifecycle.al r12 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r11, (androidx.lifecycle.al.b) r12)
            java.lang.Class<net.one97.paytm.upi.mandate.confirmation.c> r1 = net.one97.paytm.upi.mandate.confirmation.c.class
            androidx.lifecycle.ai r12 = r12.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(fr…, factory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            net.one97.paytm.upi.mandate.confirmation.c r12 = (net.one97.paytm.upi.mandate.confirmation.c) r12
            r10.f67056c = r12
            r12 = 0
            androidx.lifecycle.al r11 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r11, (androidx.lifecycle.al.b) r12)
            java.lang.Class<net.one97.paytm.upi.mandate.view.model.a> r12 = net.one97.paytm.upi.mandate.view.model.a.class
            androidx.lifecycle.ai r11 = r11.a(r12)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            net.one97.paytm.upi.mandate.view.model.a r11 = (net.one97.paytm.upi.mandate.view.model.a) r11
            r10.f67057d = r11
            net.one97.paytm.upi.mandate.view.model.a r11 = r10.f67057d
            if (r11 != 0) goto L_0x03ae
            java.lang.String r12 = "pendingMandateViewModel"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03ae:
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x03b5
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x03b5:
            r11.a((net.one97.paytm.upi.mandate.data.model.MandateItem) r12)
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67056c
            if (r11 != 0) goto L_0x03c1
            java.lang.String r12 = "bankViewModel"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03c1:
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r10.f67055b
            if (r12 != 0) goto L_0x03c8
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x03c8:
            net.one97.paytm.upi.mandate.utils.m r12 = r12.getMandateTransactionType()
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r10.f67055b
            if (r1 != 0) goto L_0x03d3
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x03d3:
            java.lang.String r0 = r1.getAccRefId()
            r11.a((net.one97.paytm.upi.mandate.utils.m) r12, (java.lang.String) r0)
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67056c
            if (r11 != 0) goto L_0x03e3
            java.lang.String r12 = "bankViewModel"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03e3:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r11 = r11.f67096a
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            androidx.lifecycle.q r12 = r10.getViewLifecycleOwner()
            net.one97.paytm.upi.mandate.c.a$f r0 = new net.one97.paytm.upi.mandate.c.a$f
            r0.<init>(r10)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r11.observe(r12, r0)
            net.one97.paytm.upi.mandate.view.model.a r11 = r10.f67057d
            if (r11 != 0) goto L_0x03fe
            java.lang.String r12 = "pendingMandateViewModel"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03fe:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.utils.r<net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel>> r11 = r11.f67583c
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            androidx.lifecycle.q r12 = r10.getViewLifecycleOwner()
            net.one97.paytm.upi.mandate.c.a$g r0 = new net.one97.paytm.upi.mandate.c.a$g
            r0.<init>(r10)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r11.observe(r12, r0)
            net.one97.paytm.upi.e.g r11 = r10.c()
            net.one97.paytm.upi.e.w r11 = r11.p
            androidx.recyclerview.widget.RecyclerView r11 = r11.f66919a
            net.one97.paytm.upi.mandate.c.a$d r12 = net.one97.paytm.upi.mandate.c.a.d.f67064a
            android.view.View$OnTouchListener r12 = (android.view.View.OnTouchListener) r12
            r11.setOnTouchListener(r12)
            net.one97.paytm.upi.e.g r11 = r10.c()
            androidx.core.widget.NestedScrollView r11 = r11.a()
            net.one97.paytm.upi.mandate.c.a$e r12 = new net.one97.paytm.upi.mandate.c.a$e
            r12.<init>(r10)
            android.view.View$OnLayoutChangeListener r12 = (android.view.View.OnLayoutChangeListener) r12
            r11.addOnLayoutChangeListener(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.c.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f67064a = new d();

        d() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            kotlin.g.b.k.a((Object) view, "v");
            view.getParent().requestDisallowInterceptTouchEvent(true);
            view.onTouchEvent(motionEvent);
            return true;
        }
    }

    static final class e implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67065a;

        e(a aVar) {
            this.f67065a = aVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (i3 != i7 || i5 != i9) {
                int i10 = 0;
                View childAt = this.f67065a.c().p.f66919a.getChildAt(0);
                RecyclerView recyclerView = this.f67065a.c().p.f66919a;
                kotlin.g.b.k.a((Object) recyclerView, "binding.layoutBanksExpanded.allBankList");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    i10 = adapter.getItemCount();
                }
                if (childAt != null && i10 > 2) {
                    RecyclerView recyclerView2 = this.f67065a.c().p.f66919a;
                    kotlin.g.b.k.a((Object) recyclerView2, "binding.layoutBanksExpanded.allBankList");
                    ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        layoutParams2.height = (int) (((double) childAt.getHeight()) * 2.7d);
                        RecyclerView recyclerView3 = this.f67065a.c().p.f66919a;
                        kotlin.g.b.k.a((Object) recyclerView3, "binding.layoutBanksExpanded.allBankList");
                        recyclerView3.setLayoutParams(layoutParams2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
            }
        }
    }

    private final void d(UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.mandate.confirmation.c cVar = this.f67056c;
        if (cVar == null) {
            kotlin.g.b.k.a("bankViewModel");
        }
        cVar.a(upiProfileDefaultBank);
        net.one97.paytm.upi.e.g c2 = c();
        TextView textView = c2.f66807b;
        kotlin.g.b.k.a((Object) textView, "availableBalance");
        textView.setText("");
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        TextView textView2 = c2.f66812g;
        kotlin.g.b.k.a((Object) textView2, "bankName");
        kotlin.g.b.k.a((Object) debitBank, "debitBank");
        String bankName = debitBank.getBankName();
        textView2.setText(bankName + UpiUtils.getFormattedMaskedAcc(debitBank.getMaskedAccountNumber()));
        UpiUtils.setBankIcon(c2.f66811f, debitBank, getContext());
        BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank2, "upiProfileDefaultBank.debitBank");
        if (!debitBank2.isMpinSet()) {
            BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank3, "upiProfileDefaultBank.debitBank");
            String ifsc = debitBank3.getIfsc();
            kotlin.g.b.k.a((Object) ifsc, "upiProfileDefaultBank.debitBank.ifsc");
            if (!p.a((CharSequence) ifsc, (CharSequence) "pytm", true)) {
                TextView textView3 = c2.f66814i;
                kotlin.g.b.k.a((Object) textView3, "checkBalance");
                textView3.setText(getString(R.string.set_upi_pin));
                return;
            }
        }
        TextView textView4 = c2.f66814i;
        kotlin.g.b.k.a((Object) textView4, "checkBalance");
        textView4.setText(getString(R.string.check_balance));
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67068a;

        h(a aVar) {
            this.f67068a = aVar;
        }

        public final void onClick(View view) {
            a.e(this.f67068a);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67069a;

        i(a aVar) {
            this.f67069a = aVar;
        }

        public final void onClick(View view) {
            a.C1370a aVar = net.one97.paytm.upi.mandate.update.a.f67340b;
            MandateItem f2 = a.f(this.f67069a);
            androidx.fragment.app.j childFragmentManager = this.f67069a.getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            kotlin.g.a.a<x> r1 = new kotlin.g.a.a<x>(this) {
                final /* synthetic */ i this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    a.g(this.this$0.f67069a);
                    net.one97.paytm.upi.mandate.view.model.a b2 = a.b(this.this$0.f67069a);
                    UpiPendingRequestModel h2 = this.this$0.f67069a.m;
                    UpiProfileDefaultBank upiProfileDefaultBank = a.i(this.this$0.f67069a).f67097b;
                    b2.f67587g = h2;
                    b2.f67588h = upiProfileDefaultBank;
                    b2.f67585e = net.one97.paytm.upi.mandate.utils.d.DECLINE.getType();
                    net.one97.paytm.upi.registration.b.a.b bVar = b2.f67582b;
                    kotlin.g.b.k.a((Object) bVar, "upiRegistrationRepository");
                    if (!bVar.g()) {
                        b2.f67583c.setValue(new r(net.one97.paytm.upi.mandate.utils.u.ERROR, (Object) null, t.c.f67422a, false, 10));
                    } else if (h2 == null || kotlin.g.b.k.a((Object) h2.getType(), (Object) "MANDATE")) {
                        b2.f67583c.setValue(new r(net.one97.paytm.upi.mandate.utils.u.LOADING, (Object) null, (t) null, false, 14));
                        b2.f67585e = net.one97.paytm.upi.mandate.utils.d.DECLINE.getType();
                        b2.b("");
                    } else {
                        UpiPendingRequestModel upiPendingRequestModel = b2.f67587g;
                        if (upiPendingRequestModel == null) {
                            kotlin.g.b.k.a();
                        }
                        b2.f67583c.setValue(new r(net.one97.paytm.upi.mandate.utils.u.LOADING, (Object) null, (t) null, false, 14));
                        net.one97.paytm.upi.passbook.b.a.b bVar2 = b2.f67581a;
                        a.C1379a bVar3 = new a.b(b2);
                        String payeeVa = upiPendingRequestModel.getPayeeVa();
                        UpiProfileDefaultBank upiProfileDefaultBank2 = b2.f67588h;
                        if (upiProfileDefaultBank2 == null) {
                            kotlin.g.b.k.a();
                        }
                        String virtualAddress = upiProfileDefaultBank2.getVirtualAddress();
                        String amount = upiPendingRequestModel.getAmount();
                        String note = upiPendingRequestModel.getNote();
                        String amount2 = upiPendingRequestModel.getAmount();
                        UpiPendingRequestModel upiPendingRequestModel2 = b2.f67587g;
                        if (upiPendingRequestModel2 == null) {
                            kotlin.g.b.k.a();
                        }
                        bVar2.a(bVar3, "", "", payeeVa, virtualAddress, amount, note, amount2, upiPendingRequestModel2.getTxnId(), "R", "A", "");
                    }
                }
            };
            kotlin.g.b.k.c(f2, "mandateItem");
            kotlin.g.b.k.c(childFragmentManager, "fragmentManager");
            kotlin.g.b.k.c(r1, "onDeclineClicked");
            net.one97.paytm.upi.mandate.update.a aVar2 = new net.one97.paytm.upi.mandate.update.a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mandate_Item", f2);
            aVar2.setArguments(bundle);
            kotlin.g.b.k.c(r1, "onDeclineClicked");
            aVar2.f67341a = r1;
            aVar2.show(childFragmentManager, "");
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67070a;

        j(a aVar) {
            this.f67070a = aVar;
        }

        public final void onClick(View view) {
            a.j(this.f67070a);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.upi.e.g f67071a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f67072b;

        k(net.one97.paytm.upi.e.g gVar, a aVar) {
            this.f67071a = gVar;
            this.f67072b = aVar;
        }

        public final void onClick(View view) {
            List list;
            CharSequence accRefId = a.f(this.f67072b).getAccRefId();
            if (accRefId == null || p.a(accRefId)) {
                kotlin.g.b.k.a((Object) view, "it");
                View rootView = view.getRootView();
                if (rootView != null) {
                    v.a((ViewGroup) rootView);
                    Group group = this.f67071a.f66809d;
                    kotlin.g.b.k.a((Object) group, "bankGroup");
                    net.one97.paytm.upi.f.a((View) group);
                    ImageView imageView = this.f67071a.n;
                    kotlin.g.b.k.a((Object) imageView, "downArrow");
                    net.one97.paytm.upi.f.a((View) imageView);
                    TextView textView = this.f67071a.f66814i;
                    kotlin.g.b.k.a((Object) textView, "checkBalance");
                    net.one97.paytm.upi.f.a((View) textView);
                    w wVar = this.f67071a.p;
                    kotlin.g.b.k.a((Object) wVar, "layoutBanksExpanded");
                    ConstraintLayout a2 = wVar.a();
                    kotlin.g.b.k.a((Object) a2, "layoutBanksExpanded.root");
                    net.one97.paytm.upi.f.b((View) a2);
                    Context requireContext = this.f67072b.requireContext();
                    net.one97.paytm.upi.mandate.data.a aVar = (net.one97.paytm.upi.mandate.data.a) a.i(this.f67072b).f67096a.getValue();
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "down_arrow_clicked", (aVar == null || (list = (List) aVar.f67118b) == null) ? null : kotlin.a.k.a((Iterable) list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) c.INSTANCE, 31), a.f(this.f67072b).getRecurrence(), "", "", a.f(this.f67072b).getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.upi.e.g f67074a;

        m(net.one97.paytm.upi.e.g gVar) {
            this.f67074a = gVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "it");
            View rootView = view.getRootView();
            if (rootView != null) {
                v.a((ViewGroup) rootView);
                Group group = this.f67074a.f66809d;
                kotlin.g.b.k.a((Object) group, "bankGroup");
                net.one97.paytm.upi.f.b((View) group);
                TextView textView = this.f67074a.f66814i;
                kotlin.g.b.k.a((Object) textView, "checkBalance");
                net.one97.paytm.upi.f.b((View) textView);
                ImageView imageView = this.f67074a.n;
                kotlin.g.b.k.a((Object) imageView, "downArrow");
                net.one97.paytm.upi.f.b((View) imageView);
                TextView textView2 = this.f67074a.f66807b;
                kotlin.g.b.k.a((Object) textView2, "availableBalance");
                textView2.setText("");
                w wVar = this.f67074a.p;
                kotlin.g.b.k.a((Object) wVar, "layoutBanksExpanded");
                ConstraintLayout a2 = wVar.a();
                kotlin.g.b.k.a((Object) a2, "layoutBanksExpanded.root");
                net.one97.paytm.upi.f.a((View) a2);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67073a;

        l(a aVar) {
            this.f67073a = aVar;
        }

        public final void onClick(View view) {
            BankAccountDetails.BankAccount debitBank;
            String ifsc;
            UpiProfileDefaultBank upiProfileDefaultBank = a.i(this.f67073a).f67097b;
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            if ((debitBank2 == null || !debitBank2.isMpinSet()) && ((debitBank = upiProfileDefaultBank.getDebitBank()) == null || (ifsc = debitBank.getIfsc()) == null || !p.a((CharSequence) ifsc, (CharSequence) "pytm", true))) {
                Intent intent = new Intent(this.f67073a.getActivity(), SetMPINActivity.class);
                UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(kotlin.a.k.a(upiProfileDefaultBank.getDebitBank())).build();
                kotlin.g.b.k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
                intent.putExtra("user_upi_details", build);
                a aVar = this.f67073a;
                aVar.startActivityForResult(intent, aVar.f67062i);
                return;
            }
            a aVar2 = this.f67073a;
            aVar2.b(a.i(aVar2).f67097b);
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.b<UpiProfileDefaultBank, String> {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        public final String invoke(UpiProfileDefaultBank upiProfileDefaultBank) {
            kotlin.g.b.k.c(upiProfileDefaultBank, "it");
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "it.debitBank");
            String bankName = debitBank.getBankName();
            kotlin.g.b.k.a((Object) bankName, "it.debitBank.bankName");
            return bankName;
        }
    }

    private final void d() {
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        net.one97.paytm.upi.mandate.utils.k kVar = this.n;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        String str = null;
        if (kVar == net.one97.paytm.upi.mandate.utils.k.COLLECT) {
            Context requireContext = requireContext();
            net.one97.paytm.upi.mandate.confirmation.c cVar = this.f67056c;
            if (cVar == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank = cVar.f67097b;
            if (!(upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null)) {
                str = debitBank3.getBankName();
            }
            String str2 = str;
            MandateItem mandateItem = this.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String recurrence = mandateItem.getRecurrence();
            MandateItem mandateItem2 = this.f67055b;
            if (mandateItem2 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "Create_proceed_bottomsheet_clicked", str2, recurrence, "", "", mandateItem2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar2 = this.n;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar2 == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
            Context requireContext2 = requireContext();
            net.one97.paytm.upi.mandate.confirmation.c cVar2 = this.f67056c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank2 = cVar2.f67097b;
            if (!(upiProfileDefaultBank2 == null || (debitBank2 = upiProfileDefaultBank2.getDebitBank()) == null)) {
                str = debitBank2.getBankName();
            }
            String str3 = str;
            MandateItem mandateItem3 = this.f67055b;
            if (mandateItem3 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String recurrence2 = mandateItem3.getRecurrence();
            MandateItem mandateItem4 = this.f67055b;
            if (mandateItem4 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, "Update_proceed_bottomsheet_clicked", str3, recurrence2, "", "", mandateItem4.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar3 = this.n;
        if (kVar3 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar3 == net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH) {
            Context requireContext3 = requireContext();
            net.one97.paytm.upi.mandate.confirmation.c cVar3 = this.f67056c;
            if (cVar3 == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank3 = cVar3.f67097b;
            if (!(upiProfileDefaultBank3 == null || (debitBank = upiProfileDefaultBank3.getDebitBank()) == null)) {
                str = debitBank.getBankName();
            }
            String str4 = str;
            MandateItem mandateItem5 = this.f67055b;
            if (mandateItem5 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String recurrence3 = mandateItem5.getRecurrence();
            MandateItem mandateItem6 = this.f67055b;
            if (mandateItem6 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, "Execution_proceed_bottomsheet_clicked", str4, recurrence3, "", "", mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_BS, "");
        }
    }

    public final void b(UpiProfileDefaultBank upiProfileDefaultBank) {
        UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
        this.f67059f = upiProfileDefaultBank2;
        UpiProfileDefaultBank upiProfileDefaultBank3 = this.f67059f;
        if (upiProfileDefaultBank3 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.upi.mandate.utils.k kVar = this.n;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar == net.one97.paytm.upi.mandate.utils.k.COLLECT) {
            Context requireContext = requireContext();
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank3.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "defaultBank.debitBank");
            String bankName = debitBank.getBankName();
            MandateItem mandateItem = this.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String recurrence = mandateItem.getRecurrence();
            MandateItem mandateItem2 = this.f67055b;
            if (mandateItem2 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "check_balance_clicked", bankName, recurrence, "", "", mandateItem2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
        } else {
            net.one97.paytm.upi.mandate.utils.k kVar2 = this.n;
            if (kVar2 == null) {
                kotlin.g.b.k.a("mandateSource");
            }
            if (kVar2 == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
                Context requireContext2 = requireContext();
                BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank3.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank2, "defaultBank.debitBank");
                String bankName2 = debitBank2.getBankName();
                MandateItem mandateItem3 = this.f67055b;
                if (mandateItem3 == null) {
                    kotlin.g.b.k.a("mandateItem");
                }
                String recurrence2 = mandateItem3.getRecurrence();
                MandateItem mandateItem4 = this.f67055b;
                if (mandateItem4 == null) {
                    kotlin.g.b.k.a("mandateItem");
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, "check_balance_clicked", bankName2, recurrence2, "", "", mandateItem4.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
            } else {
                net.one97.paytm.upi.mandate.utils.k kVar3 = this.n;
                if (kVar3 == null) {
                    kotlin.g.b.k.a("mandateSource");
                }
                if (kVar3 == net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH) {
                    Context requireContext3 = requireContext();
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank3.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank3, "defaultBank.debitBank");
                    String bankName3 = debitBank3.getBankName();
                    MandateItem mandateItem5 = this.f67055b;
                    if (mandateItem5 == null) {
                        kotlin.g.b.k.a("mandateItem");
                    }
                    String recurrence3 = mandateItem5.getRecurrence();
                    MandateItem mandateItem6 = this.f67055b;
                    if (mandateItem6 == null) {
                        kotlin.g.b.k.a("mandateItem");
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, "check_balance_clicked", bankName3, recurrence3, "", "", mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_BS, "");
                }
            }
        }
        if (com.paytm.utility.a.m(getContext())) {
            if (this.f67060g == null) {
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                UPICheckBalanceHelper.UPICheckBalanceBuilder tag = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.f67061h)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName());
                q viewLifecycleOwner = getViewLifecycleOwner();
                kotlin.g.b.k.a((Object) viewLifecycleOwner, "viewLifecycleOwner");
                this.f67060g = tag.setLifecycleOwner(viewLifecycleOwner).build();
            }
            UPICheckBalanceHelper uPICheckBalanceHelper = this.f67060g;
            if (uPICheckBalanceHelper == null) {
                kotlin.g.b.k.a();
            }
            if (upiProfileDefaultBank2 == null) {
                kotlin.g.b.k.a();
            }
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank2);
            return;
        }
        UpiUtils.showNoNetworkErrorDialog(getActivity());
    }

    public final void c(UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(getContext(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        startActivityForResult(intent, this.f67062i);
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "defaultBank");
        d(upiProfileDefaultBank);
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    public static final class n implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67075a;

        n(a aVar) {
            this.f67075a = aVar;
        }

        public final void onReEnterClicked() {
            a aVar = this.f67075a;
            aVar.b(aVar.f67059f);
        }

        public final void onCreateNewPinClicked() {
            a aVar = this.f67075a;
            UpiProfileDefaultBank l = aVar.f67059f;
            if (l == null) {
                kotlin.g.b.k.a();
            }
            BankAccountDetails.BankAccount debitBank = l.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "selectedBankAccount!!.debitBank");
            a.a(aVar, debitBank);
        }
    }

    private final void a(boolean z) {
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        IncorrectUpiPinBottomSheet.Companion.show(new n(this), childFragmentManager, z);
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
            str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
            kotlin.g.b.k.a((Object) str4, "getString(\n             …bleBalance)\n            )");
        } else {
            str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
            kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
        }
        w wVar = c().p;
        kotlin.g.b.k.a((Object) wVar, "binding.layoutBanksExpanded");
        ConstraintLayout a2 = wVar.a();
        kotlin.g.b.k.a((Object) a2, "binding.layoutBanksExpanded.root");
        if (net.one97.paytm.upi.f.d(a2)) {
            net.one97.paytm.upi.mandate.a.d dVar = this.f67058e;
            if (dVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            dVar.a(str4);
            return;
        }
        TextView textView = c().f66814i;
        kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
        net.one97.paytm.upi.f.c((View) textView);
        TextView textView2 = c().f66807b;
        kotlin.g.b.k.a((Object) textView2, "binding.availableBalance");
        textView2.setText(str4);
    }

    public final void b() {
        w wVar = c().p;
        kotlin.g.b.k.a((Object) wVar, "binding.layoutBanksExpanded");
        ConstraintLayout a2 = wVar.a();
        kotlin.g.b.k.a((Object) a2, "binding.layoutBanksExpanded.root");
        if (net.one97.paytm.upi.f.d(a2)) {
            net.one97.paytm.upi.mandate.a.d dVar = this.f67058e;
            if (dVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            dVar.b();
            return;
        }
        AnimationFactory.stopWalletLoader(c().j);
        TextView textView = c().f66814i;
        kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
        net.one97.paytm.upi.f.b((View) textView);
    }

    public final void Z_() {
        w wVar = c().p;
        kotlin.g.b.k.a((Object) wVar, "binding.layoutBanksExpanded");
        ConstraintLayout a2 = wVar.a();
        kotlin.g.b.k.a((Object) a2, "binding.layoutBanksExpanded.root");
        if (net.one97.paytm.upi.f.d(a2)) {
            net.one97.paytm.upi.mandate.a.d dVar = this.f67058e;
            if (dVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            dVar.a();
            return;
        }
        TextView textView = c().f66814i;
        kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
        net.one97.paytm.upi.f.c((View) textView);
        AnimationFactory.startWalletLoader(c().j);
    }

    public final void onDestroyView() {
        this.l = null;
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void onDestroy() {
        FragmentActivity activity;
        if ((getActivity() instanceof UpiRequestMoneyPagerActivity) && (activity = getActivity()) != null) {
            activity.finish();
        }
        super.onDestroy();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.k && i3 == -1) {
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            if (serializableExtra != null) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                Fragment fragment = this;
                net.one97.paytm.upi.mandate.confirmation.c cVar = this.f67056c;
                if (cVar == null) {
                    kotlin.g.b.k.a("bankViewModel");
                }
                BankVpaCreationActivity.a(fragment, accountProvider, cVar.a().getVirtualAddress(), this.j);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
        } else if ((i2 == this.j || i2 == this.f67062i) && i3 == -1) {
            net.one97.paytm.upi.mandate.confirmation.c cVar2 = this.f67056c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            MandateItem mandateItem = this.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            cVar2.a(mandateItem.getMandateTransactionType(), (String) null);
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.c.a$a  reason: collision with other inner class name */
    public static final class C1352a {
        private C1352a() {
        }

        public /* synthetic */ C1352a(byte b2) {
            this();
        }

        public static a a(MandateItem mandateItem, androidx.fragment.app.j jVar, UpiPendingRequestModel upiPendingRequestModel) {
            kotlin.g.b.k.c(mandateItem, Payload.RESPONSE);
            kotlin.g.b.k.c(jVar, "fragmentManager");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Payload.RESPONSE, mandateItem);
            bundle.putSerializable("upi_pending_req_model", upiPendingRequestModel);
            aVar.setArguments(bundle);
            aVar.show(jVar, "MandateCollectRequestBottomSheet");
            return aVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, List list, net.one97.paytm.upi.e.g gVar) {
        if (list != null) {
            net.one97.paytm.upi.mandate.confirmation.c cVar = aVar.f67056c;
            if (cVar == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            List<BankAccountDetails.BankAccount> c2 = cVar.c();
            if (list.isEmpty()) {
                Group group = gVar.f66809d;
                kotlin.g.b.k.a((Object) group, "bankGroup");
                net.one97.paytm.upi.f.a((View) group);
                ImageView imageView = gVar.n;
                kotlin.g.b.k.a((Object) imageView, "downArrow");
                net.one97.paytm.upi.f.a((View) imageView);
                TextView textView = gVar.f66814i;
                kotlin.g.b.k.a((Object) textView, "checkBalance");
                net.one97.paytm.upi.f.a((View) textView);
                net.one97.paytm.upi.e.z zVar = gVar.v;
                kotlin.g.b.k.a((Object) zVar, "noBankSupportedLayout");
                ConstraintLayout a2 = zVar.a();
                kotlin.g.b.k.a((Object) a2, "noBankSupportedLayout.root");
                net.one97.paytm.upi.f.b((View) a2);
                RecyclerView recyclerView = gVar.v.f66935c;
                kotlin.g.b.k.a((Object) recyclerView, "noBankSupportedLayout.unsupportedBankVpaList");
                recyclerView.setAdapter((RecyclerView.a) null);
                RecyclerView recyclerView2 = gVar.v.f66935c;
                kotlin.g.b.k.a((Object) recyclerView2, "noBankSupportedLayout.unsupportedBankVpaList");
                recyclerView2.setAdapter(new net.one97.paytm.upi.mandate.a.a(c2));
                TextView textView2 = gVar.A;
                kotlin.g.b.k.a((Object) textView2, "proceedButton");
                textView2.setText(aVar.getString(R.string.link_another_bank_and_proceed));
                return;
            }
            TextView textView3 = gVar.A;
            kotlin.g.b.k.a((Object) textView3, "proceedButton");
            textView3.setText(aVar.getString(R.string.proceed));
            Group group2 = gVar.f66809d;
            kotlin.g.b.k.a((Object) group2, "bankGroup");
            net.one97.paytm.upi.f.b((View) group2);
            TextView textView4 = gVar.f66814i;
            kotlin.g.b.k.a((Object) textView4, "checkBalance");
            net.one97.paytm.upi.f.b((View) textView4);
            ImageView imageView2 = gVar.n;
            kotlin.g.b.k.a((Object) imageView2, "downArrow");
            View view = imageView2;
            MandateItem mandateItem = aVar.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CharSequence accRefId = mandateItem.getAccRefId();
            net.one97.paytm.upi.f.a(view, accRefId == null || p.a(accRefId));
            net.one97.paytm.upi.e.z zVar2 = gVar.v;
            kotlin.g.b.k.a((Object) zVar2, "noBankSupportedLayout");
            ConstraintLayout a3 = zVar2.a();
            kotlin.g.b.k.a((Object) a3, "noBankSupportedLayout.root");
            net.one97.paytm.upi.f.a((View) a3);
            aVar.d((UpiProfileDefaultBank) list.get(0));
            net.one97.paytm.upi.mandate.confirmation.c cVar2 = aVar.f67056c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("bankViewModel");
            }
            kotlin.g.b.k.c(c2, "mainList");
            Iterable<BankAccountDetails.BankAccount> iterable = c2;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (BankAccountDetails.BankAccount debitBank : iterable) {
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                upiProfileDefaultBank.setDebitBank(debitBank);
                upiProfileDefaultBank.setVirtualAddress(cVar2.a().getVirtualAddress());
                arrayList.add(upiProfileDefaultBank);
            }
            List list2 = (List) arrayList;
            net.one97.paytm.upi.mandate.a.d dVar = aVar.f67058e;
            if (dVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            dVar.a((List<UpiProfileDefaultBank>) list2);
            net.one97.paytm.upi.mandate.a.d dVar2 = aVar.f67058e;
            if (dVar2 == null) {
                kotlin.g.b.k.a("adapter");
            }
            BankAccountDetails.BankAccount debitBank2 = ((UpiProfileDefaultBank) list.get(0)).getDebitBank();
            kotlin.g.b.k.a((Object) debitBank2, "data[0].debitBank");
            dVar2.b(debitBank2.getAccount());
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        net.one97.paytm.upi.e.g c2 = aVar.c();
        TextView textView = c2.l;
        kotlin.g.b.k.a((Object) textView, "declineButton");
        net.one97.paytm.upi.f.b((View) textView);
        TextView textView2 = c2.A;
        kotlin.g.b.k.a((Object) textView2, "proceedButton");
        net.one97.paytm.upi.f.b((View) textView2);
        FrameLayout frameLayout = c2.t;
        kotlin.g.b.k.a((Object) frameLayout, "moneyTransferLoaderContainer");
        net.one97.paytm.upi.f.a((View) frameLayout);
        AnimationFactory.stopWalletLoader(c2.s);
    }

    public static final /* synthetic */ void a(a aVar, t tVar) {
        Context context;
        if (tVar instanceof t.c) {
            Intent intent = new Intent(aVar.getContext(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            aVar.startActivityForResult(intent, 80);
        } else if (tVar instanceof t.a) {
            String str = ((t.a) tVar).f67420a;
            if (str == null) {
                str = aVar.getString(R.string.upi_some_went_wrong);
                kotlin.g.b.k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
            }
            Context context2 = aVar.getContext();
            if (context2 != null) {
                net.one97.paytm.upi.f.a(context2, str, 1);
            }
        } else if ((tVar instanceof t.k) || kotlin.g.b.k.a((Object) tVar, (Object) t.h.f67427a)) {
            Context context3 = aVar.getContext();
            if (context3 != null) {
                net.one97.paytm.upi.f.a(context3, R.string.error_fetching_profile_details, 1);
            }
        } else if (tVar instanceof t.i) {
            CustomDialog.showAlert(aVar.getActivity(), aVar.getResources().getString(R.string.no_connection), aVar.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.f) {
            Context context4 = aVar.getContext();
            if (context4 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = aVar.getString(R.string.something_went_wrong);
                    kotlin.g.b.k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                net.one97.paytm.upi.f.a(context4, str2, 1);
            }
        } else if (tVar instanceof t.j) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateListActivity.class.getName();
            a2.b().e(aVar.getActivity());
        } else if ((tVar instanceof t.g) && (context = aVar.getContext()) != null) {
            net.one97.paytm.upi.f.a(context, R.string.something_went_wrong, 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0090, code lost:
        r4 = (r4 = r4.getDebitBank()).getBankName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(net.one97.paytm.upi.mandate.c.a r33) {
        /*
            r0 = r33
            net.one97.paytm.upi.mandate.view.model.a r1 = r0.f67057d
            java.lang.String r2 = "pendingMandateViewModel"
            if (r1 != 0) goto L_0x000b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x000b:
            net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel r1 = r1.f67586f
            net.one97.paytm.upi.mandate.view.model.a r3 = r0.f67057d
            if (r3 != 0) goto L_0x0014
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0014:
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r2 = new net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            java.lang.String r5 = "_mandateItem"
            if (r4 != 0) goto L_0x001f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x001f:
            java.lang.String r6 = r4.getAmount()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x002a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x002a:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r4 = r4.getPayee()
            java.lang.String r7 = r4.getVpa()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x0039
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0039:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r4 = r4.getPayee()
            java.lang.String r8 = r4.getUserName()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x0048
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0048:
            java.lang.String r9 = r4.getNote()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x0053
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0053:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r4 = r4.getPayee()
            java.lang.String r10 = r4.getMcc()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x0062
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0062:
            java.lang.String r12 = r4.getCategory()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x006d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x006d:
            net.one97.paytm.upi.mandate.data.model.MandatePayer r4 = r4.getPayer()
            java.lang.String r13 = r4.getVpa()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x007c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x007c:
            net.one97.paytm.upi.mandate.data.model.MandatePayer r4 = r4.getPayer()
            java.lang.String r14 = r4.getBankIfsc()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = r3.f67588h
            java.lang.String r15 = ""
            if (r4 == 0) goto L_0x009a
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r4.getDebitBank()
            if (r4 == 0) goto L_0x009a
            java.lang.String r4 = r4.getBankName()
            if (r4 != 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r16 = r4
            goto L_0x009c
        L_0x009a:
            r16 = r15
        L_0x009c:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = r3.f67588h
            if (r4 == 0) goto L_0x00ae
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r4.getDebitBank()
            if (r4 == 0) goto L_0x00ae
            java.lang.String r4 = r4.getAccount()
            if (r4 != 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r15 = r4
        L_0x00ae:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = r3.f67588h
            if (r4 == 0) goto L_0x00c3
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r4.getDebitBank()
            if (r4 == 0) goto L_0x00c3
            net.one97.paytm.upi.common.upi.BankAccountDetails$CredsAllowed r4 = r4.getCredsAllowed()
            if (r4 == 0) goto L_0x00c3
            java.util.List r4 = r4.getChild()
            goto L_0x00c4
        L_0x00c3:
            r4 = 0
        L_0x00c4:
            r17 = r4
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x00cd
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00cd:
            java.lang.String r18 = r4.getValidityStartDate()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x00d8
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00d8:
            java.lang.String r19 = r4.getValidityEndDate()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x00e3
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00e3:
            java.lang.String r21 = r4.getUmn()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x00ee
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00ee:
            java.lang.String r22 = r4.getRefUrl()
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x00f9
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00f9:
            java.lang.String r23 = r4.getRefCategory()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = r3.f67588h
            if (r4 != 0) goto L_0x0104
            kotlin.g.b.k.a()
        L_0x0104:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r4.getDebitBank()
            java.lang.String r11 = "userSelectedBank!!.debitBank"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
            java.lang.String r25 = r4.getAccRefId()
            r26 = 0
            r27 = 0
            net.one97.paytm.upi.mandate.d.a r4 = net.one97.paytm.upi.mandate.d.a.f67112a
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r3.f67584d
            if (r4 != 0) goto L_0x011e
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x011e:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r31 = net.one97.paytm.upi.mandate.d.a.a((net.one97.paytm.upi.mandate.data.model.MandateItem) r4, (java.lang.String) null)
            r32 = 0
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r3 = r3.f67587g
            if (r3 != 0) goto L_0x012b
            kotlin.g.b.k.a()
        L_0x012b:
            net.one97.paytm.upi.common.upi.PendingCollectMandateDetails r3 = r3.getMandateDetails()
            java.lang.String r4 = "upiPendingRequestModel!!.mandateDetails"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getMaxDebitAmount()
            r28 = r3
            java.lang.String r4 = "upiPendingRequestModel!!…ateDetails.maxDebitAmount"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r29 = 4194304(0x400000, float:5.877472E-39)
            r30 = 0
            java.lang.String r20 = ""
            r4 = r2
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r3 = 0
            r10 = r3
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r21
            r21 = r22
            r22 = r23
            r23 = r25
            r24 = r26
            r25 = r27
            r26 = r31
            r27 = r32
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$a r3 = net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity.f67445a
            android.content.Context r3 = r33.getContext()
            if (r3 != 0) goto L_0x0176
            kotlin.g.b.k.a()
        L_0x0176:
            java.lang.String r4 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r1 != 0) goto L_0x0180
            kotlin.g.b.k.a()
        L_0x0180:
            net.one97.paytm.upi.mandate.utils.k r4 = r0.n
            if (r4 != 0) goto L_0x0189
            java.lang.String r5 = "mandateSource"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0189:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity.a.a(r3, r1, r2, r4)
            androidx.fragment.app.FragmentActivity r1 = r33.getActivity()
            boolean r1 = r1 instanceof net.one97.paytm.upi.passbook.view.UpiPassbookActivity
            if (r1 == 0) goto L_0x019b
            androidx.fragment.app.FragmentActivity r1 = r33.requireActivity()
            r1.finish()
        L_0x019b:
            r33.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.c.a.c(net.one97.paytm.upi.mandate.c.a):void");
    }

    public static final /* synthetic */ void d(a aVar) {
        net.one97.paytm.upi.e.g c2 = aVar.c();
        TextView textView = c2.l;
        kotlin.g.b.k.a((Object) textView, "declineButton");
        net.one97.paytm.upi.f.a((View) textView);
        TextView textView2 = c2.A;
        kotlin.g.b.k.a((Object) textView2, "proceedButton");
        net.one97.paytm.upi.f.c((View) textView2);
        FrameLayout frameLayout = c2.t;
        kotlin.g.b.k.a((Object) frameLayout, "moneyTransferLoaderContainer");
        net.one97.paytm.upi.f.b((View) frameLayout);
        AnimationFactory.startWalletLoader(c2.s);
    }

    public static final /* synthetic */ void e(a aVar) {
        net.one97.paytm.upi.mandate.utils.k kVar = aVar.n;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar == net.one97.paytm.upi.mandate.utils.k.COLLECT) {
            Context requireContext = aVar.requireContext();
            MandateItem mandateItem = aVar.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String vpa = mandateItem.getPayee().getVpa();
            MandateItem mandateItem2 = aVar.f67055b;
            if (mandateItem2 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "Create_Close_bottomsheet", "", "", "", vpa, mandateItem2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
        } else {
            net.one97.paytm.upi.mandate.utils.k kVar2 = aVar.n;
            if (kVar2 == null) {
                kotlin.g.b.k.a("mandateSource");
            }
            if (kVar2 == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
                Context requireContext2 = aVar.requireContext();
                MandateItem mandateItem3 = aVar.f67055b;
                if (mandateItem3 == null) {
                    kotlin.g.b.k.a("mandateItem");
                }
                String vpa2 = mandateItem3.getPayee().getVpa();
                MandateItem mandateItem4 = aVar.f67055b;
                if (mandateItem4 == null) {
                    kotlin.g.b.k.a("mandateItem");
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, "Update_Close_bottomsheet", "", "", "", vpa2, mandateItem4.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS, "");
            } else {
                net.one97.paytm.upi.mandate.utils.k kVar3 = aVar.n;
                if (kVar3 == null) {
                    kotlin.g.b.k.a("mandateSource");
                }
                if (kVar3 == net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH) {
                    Context requireContext3 = aVar.requireContext();
                    MandateItem mandateItem5 = aVar.f67055b;
                    if (mandateItem5 == null) {
                        kotlin.g.b.k.a("mandateItem");
                    }
                    String vpa3 = mandateItem5.getPayee().getVpa();
                    MandateItem mandateItem6 = aVar.f67055b;
                    if (mandateItem6 == null) {
                        kotlin.g.b.k.a("mandateItem");
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, "Execution_Close_bottomsheet", "", "", "", vpa3, mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_BS, "");
                }
            }
        }
        aVar.dismiss();
    }

    public static final /* synthetic */ void g(a aVar) {
        net.one97.paytm.upi.mandate.utils.k kVar = aVar.n;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar == net.one97.paytm.upi.mandate.utils.k.COLLECT) {
            Context requireContext = aVar.requireContext();
            MandateItem mandateItem = aVar.f67055b;
            if (mandateItem == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String vpa = mandateItem.getPayee().getVpa();
            MandateItem mandateItem2 = aVar.f67055b;
            if (mandateItem2 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "Create_Decline_bottomsheet", "", "", "", vpa, mandateItem2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_DECLINE_BS, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar2 = aVar.n;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar2 == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
            Context requireContext2 = aVar.requireContext();
            MandateItem mandateItem3 = aVar.f67055b;
            if (mandateItem3 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String vpa2 = mandateItem3.getPayee().getVpa();
            MandateItem mandateItem4 = aVar.f67055b;
            if (mandateItem4 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, "Update_Decline_bottomsheet", "", "", "", vpa2, mandateItem4.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_DECLINE_BS, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar3 = aVar.n;
        if (kVar3 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar3 == net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH) {
            Context requireContext3 = aVar.requireContext();
            MandateItem mandateItem5 = aVar.f67055b;
            if (mandateItem5 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            String vpa3 = mandateItem5.getPayee().getVpa();
            MandateItem mandateItem6 = aVar.f67055b;
            if (mandateItem6 == null) {
                kotlin.g.b.k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, "Execution_Decline_bottomsheet", "", "", "", vpa3, mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_BS, "");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        r1 = (java.util.List) r1.f67118b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void j(net.one97.paytm.upi.mandate.c.a r11) {
        /*
            net.one97.paytm.upi.mandate.confirmation.c r0 = r11.f67056c
            java.lang.String r1 = "bankViewModel"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f67097b
            if (r0 == 0) goto L_0x0035
            net.one97.paytm.upi.mandate.utils.k r2 = r11.n
            if (r2 != 0) goto L_0x0016
            java.lang.String r3 = "mandateSource"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0016:
            net.one97.paytm.upi.mandate.utils.k r3 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r2 != r3) goto L_0x0035
            net.one97.paytm.upi.mandate.view.model.a r0 = r11.f67057d
            if (r0 != 0) goto L_0x0023
            java.lang.String r2 = "pendingMandateViewModel"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0023:
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r2 = r11.m
            net.one97.paytm.upi.mandate.confirmation.c r3 = r11.f67056c
            if (r3 != 0) goto L_0x002c
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x002c:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.f67097b
            r0.a((net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r2, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1)
            r11.d()
            return
        L_0x0035:
            java.lang.String r2 = "mandateItem"
            if (r0 == 0) goto L_0x00ca
            r11.d()
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r11.f67055b
            if (r1 != 0) goto L_0x0043
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0043:
            java.lang.String r1 = r1.getAccRefId()
            java.lang.String r3 = "currentBank.debitBank.accRefId"
            java.lang.String r4 = "currentBank.debitBank"
            java.lang.String r5 = "context!!"
            if (r1 != 0) goto L_0x007e
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$a r1 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f67078a
            net.one97.paytm.upi.mandate.d.a r1 = net.one97.paytm.upi.mandate.d.a.f67112a
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r11.f67055b
            if (r1 != 0) goto L_0x005a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x005a:
            android.content.Context r2 = r11.getContext()
            if (r2 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String r0 = r0.getAccRefId()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.upi.mandate.d.a$a r0 = net.one97.paytm.upi.mandate.d.a.a((net.one97.paytm.upi.mandate.data.model.MandateItem) r1, (android.content.Context) r2, (java.lang.String) r0)
            net.one97.paytm.upi.mandate.utils.k r1 = net.one97.paytm.upi.mandate.utils.k.COLLECT
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.a.a(r0, r1)
            goto L_0x00ac
        L_0x007e:
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$a r1 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f67078a
            net.one97.paytm.upi.mandate.d.a r1 = net.one97.paytm.upi.mandate.d.a.f67112a
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r11.f67055b
            if (r1 != 0) goto L_0x0089
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0089:
            android.content.Context r2 = r11.getContext()
            if (r2 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String r0 = r0.getAccRefId()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.upi.mandate.d.a$a r0 = net.one97.paytm.upi.mandate.d.a.a((net.one97.paytm.upi.mandate.data.model.MandateItem) r1, (android.content.Context) r2, (java.lang.String) r0)
            net.one97.paytm.upi.mandate.utils.k r1 = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.a.a(r0, r1)
        L_0x00ac:
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.upi.requestmoney.view.UpiRequestMoneyPagerActivity
            if (r0 == 0) goto L_0x00be
            androidx.fragment.app.FragmentActivity r11 = r11.getActivity()
            if (r11 == 0) goto L_0x00bd
            r11.finish()
        L_0x00bd:
            return
        L_0x00be:
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.upi.mandate.view.MandateListActivity
            if (r0 == 0) goto L_0x012f
            r11.dismiss()
            return
        L_0x00ca:
            android.content.Context r0 = r11.requireContext()
            net.one97.paytm.upi.mandate.confirmation.c r3 = r11.f67056c
            if (r3 != 0) goto L_0x00d5
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d5:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r1 = r3.f67096a
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.upi.mandate.data.a r1 = (net.one97.paytm.upi.mandate.data.a) r1
            if (r1 == 0) goto L_0x00fb
            ResultType r1 = r1.f67118b
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x00fb
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            net.one97.paytm.upi.mandate.c.a$c r1 = net.one97.paytm.upi.mandate.c.a.c.INSTANCE
            r9 = r1
            kotlin.g.a.b r9 = (kotlin.g.a.b) r9
            r10 = 31
            java.lang.String r1 = kotlin.a.k.a((java.lang.Iterable) r3, (java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (int) r7, (java.lang.CharSequence) r8, (kotlin.g.a.b) r9, (int) r10)
            goto L_0x00fc
        L_0x00fb:
            r1 = 0
        L_0x00fc:
            r5 = r1
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r11.f67055b
            if (r1 != 0) goto L_0x0104
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0104:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r1 = r1.getPayee()
            java.lang.String r7 = r1.getVpa()
            net.one97.paytm.upi.mandate.data.model.MandateItem r1 = r11.f67055b
            if (r1 != 0) goto L_0x0113
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0113:
            java.lang.String r8 = r1.getAmount()
            java.lang.String r2 = "/Automatic_Payment_Collect_Creation"
            java.lang.String r3 = "Link_Another_Bank_clicked"
            java.lang.String r4 = "yes"
            java.lang.String r6 = ""
            java.lang.String r9 = "/Automatic_Payment_create_bottomsheet"
            java.lang.String r10 = ""
            r1 = r0
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r11
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            int r11 = r11.k
            net.one97.paytm.upi.registration.view.AccountProviderActivity.a((androidx.fragment.app.Fragment) r0, (int) r11)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.c.a.j(net.one97.paytm.upi.mandate.c.a):void");
    }

    public static final /* synthetic */ void a(a aVar, BankAccountDetails.BankAccount bankAccount) {
        Intent intent = new Intent(aVar.getActivity(), SetMPINActivity.class);
        List a2 = kotlin.a.k.a(bankAccount);
        UpiProfileDefaultBank upiProfileDefaultBank = aVar.f67059f;
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(a2).build();
        kotlin.g.b.k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
        intent.putExtra("user_upi_details", build);
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
        aVar.startActivityForResult(intent, aVar.f67062i);
    }
}
