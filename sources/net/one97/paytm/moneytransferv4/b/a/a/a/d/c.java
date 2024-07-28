package net.one97.paytm.moneytransferv4.b.a.a.a.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.af;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.b.a;
import net.one97.paytm.moneytransfer.viewmodel.e;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.b.a.a.a.d.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.d.e;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GetCredentialsApiBuilder;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends net.one97.paytm.i.f implements View.OnClickListener, n.c, a.C1006a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f55240c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f55241a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.moneytransferv4.accounts.i f55242b;

    /* renamed from: d  reason: collision with root package name */
    private e f55243d;

    /* renamed from: e  reason: collision with root package name */
    private UpiPendingRequestModel f55244e;

    /* renamed from: f  reason: collision with root package name */
    private String f55245f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f55246g;

    /* renamed from: h  reason: collision with root package name */
    private ConstraintLayout f55247h;

    /* renamed from: i  reason: collision with root package name */
    private Group f55248i;
    /* access modifiers changed from: private */
    public PaymentManager.a j;
    private af k;
    private final String l = "mt_collect_info";
    /* access modifiers changed from: private */
    public a m = new a();
    /* access modifiers changed from: private */
    public ArrayList<UpiProfileDefaultBank> n = new ArrayList<>();
    private int o = -1;
    private final int p = 2;
    private final int q = 3;
    private UPICheckBalanceHelper r;
    private net.one97.paytm.moneytransfer.viewmodel.e s;
    private Intent t;
    private HashMap u;

    static final class b<T> implements z<net.one97.paytm.moneytransfer.model.c<BaseUpiResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55249a;

        b(c cVar) {
            this.f55249a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Context context;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            int i2 = d.f55263a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                PaymentManager.a b2 = this.f55249a.j;
                if (b2 != null) {
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    String txnId = c.a(this.f55249a).getTxnId();
                    kotlin.g.b.k.a((Object) txnId, "upiPendingRequestModel.txnId");
                    b2.a((BaseUpiResponse) resulttype, txnId, this.f55249a.f55246g);
                }
                this.f55249a.dismiss();
            } else if (i2 == 2 && (context = this.f55249a.getContext()) != null) {
                c cVar2 = this.f55249a;
                kotlin.g.b.k.a((Object) context, "it");
                String string = this.f55249a.getString(R.string.error);
                kotlin.g.b.k.a((Object) string, "getString(R.string.error)");
                String string2 = this.f55249a.getResources().getString(R.string.upi_request_declined_err_msg);
                kotlin.g.b.k.a((Object) string2, "resources.getString(R.st…request_declined_err_msg)");
                String string3 = this.f55249a.getString(R.string.ok);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.ok)");
                cVar2.a(context, string, string2, string3, true);
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.d.c$c  reason: collision with other inner class name */
    static final class C1008c<T> implements z<BaseUpiResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55250a;

        C1008c(c cVar) {
            this.f55250a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) obj;
            PaymentManager.a b2 = this.f55250a.j;
            if (b2 != null) {
                kotlin.g.b.k.a((Object) baseUpiResponse, "it");
                String txnId = c.a(this.f55250a).getTxnId();
                kotlin.g.b.k.a((Object) txnId, "upiPendingRequestModel.txnId");
                b2.a(baseUpiResponse, txnId, this.f55250a.f55246g);
            }
            this.f55250a.dismiss();
        }
    }

    static final class d<T> implements z<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55251a;

        d(c cVar) {
            this.f55251a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            int i2 = d.f55264b[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                ArrayList arrayList = (ArrayList) cVar.f54033b;
                Collection collection = arrayList;
                int i3 = 0;
                if (!(collection == null || collection.isEmpty())) {
                    if (arrayList == null) {
                        kotlin.g.b.k.a();
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setDebitBank((BankAccountDetails.BankAccount) it2.next());
                        upiProfileDefaultBank.setVirtualAddress(c.d(this.f55251a).a());
                        this.f55251a.n.add(upiProfileDefaultBank);
                    }
                    int size = this.f55251a.n.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        Object obj2 = this.f55251a.n.get(i3);
                        kotlin.g.b.k.a(obj2, "allBankList[i]");
                        UpiProfileDefaultBank upiProfileDefaultBank2 = (UpiProfileDefaultBank) obj2;
                        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank2.getDebitBank();
                        kotlin.g.b.k.a((Object) debitBank, "bank.debitBank");
                        Boolean primaryAccount = debitBank.getPrimaryAccount();
                        kotlin.g.b.k.a((Object) primaryAccount, "bank.debitBank.primaryAccount");
                        if (primaryAccount.booleanValue()) {
                            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank2.getDebitBank();
                            kotlin.g.b.k.a((Object) debitBank2, "bank.debitBank");
                            debitBank2.setSelected(true);
                            this.f55251a.b(upiProfileDefaultBank2);
                            this.f55251a.m.a(i3);
                            c.g(this.f55251a).f55268a = upiProfileDefaultBank2;
                            break;
                        }
                        i3++;
                    }
                    if (this.f55251a.n.size() > 1) {
                        this.f55251a.m.a((List<UpiProfileDefaultBank>) this.f55251a.n);
                    } else if (this.f55251a.n.size() == 1) {
                        ImageView imageView = c.h(this.f55251a).n;
                        kotlin.g.b.k.a((Object) imageView, "binding.downArrow");
                        net.one97.paytm.wallet.rateMerchant.utils.b.b(imageView);
                        net.one97.paytm.wallet.rateMerchant.utils.b.b(c.i(this.f55251a));
                    } else {
                        Context context = this.f55251a.getContext();
                        if (context != null) {
                            c cVar2 = this.f55251a;
                            kotlin.g.b.k.a((Object) context, "it");
                            String string = this.f55251a.getString(R.string.error);
                            kotlin.g.b.k.a((Object) string, "getString(R.string.error)");
                            String string2 = this.f55251a.getResources().getString(R.string.upi_unable_to_get_bank_accounts);
                            kotlin.g.b.k.a((Object) string2, "resources.getString(R.st…ble_to_get_bank_accounts)");
                            String string3 = this.f55251a.getString(R.string.ok);
                            kotlin.g.b.k.a((Object) string3, "getString(R.string.ok)");
                            cVar2.a(context, string, string2, string3, true);
                        }
                    }
                }
            } else if (i2 == 2) {
                net.one97.paytm.wallet.rateMerchant.utils.b.b(c.j(this.f55251a));
                TextView textView = c.h(this.f55251a).f53634h;
                kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
                net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
                TextView textView2 = c.h(this.f55251a).y;
                kotlin.g.b.k.a((Object) textView2, "binding.proceedButton");
                net.one97.paytm.wallet.rateMerchant.utils.b.b(textView2);
                Context context2 = this.f55251a.getContext();
                if (context2 != null) {
                    c cVar3 = this.f55251a;
                    kotlin.g.b.k.a((Object) context2, "it");
                    String string4 = this.f55251a.getString(R.string.error);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.error)");
                    String string5 = this.f55251a.getResources().getString(R.string.upi_unable_to_get_bank_accounts);
                    kotlin.g.b.k.a((Object) string5, "resources.getString(R.st…ble_to_get_bank_accounts)");
                    String string6 = this.f55251a.getString(R.string.ok);
                    kotlin.g.b.k.a((Object) string6, "getString(R.string.ok)");
                    cVar3.a(context2, string4, string5, string6, true);
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.moneytransfer.model.c<e.C0981e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55255a;

        h(c cVar) {
            this.f55255a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f55265c[dVar.ordinal()];
                if (i2 == 1) {
                    AnimationFactory.startWalletLoader(c.h(this.f55255a).v);
                } else if (i2 == 2) {
                    c cVar2 = this.f55255a;
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    c.a(cVar2, (e.C0981e) resulttype);
                } else if (i2 == 3) {
                    AnimationFactory.stopWalletLoader(c.h(this.f55255a).v);
                    this.f55255a.a((MoneyTransferV3Activity.b) null, (String) null, cVar.f54034c);
                }
            }
        }
    }

    static final class i<T> implements z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55256a;

        i(c cVar) {
            this.f55256a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f55266d[dVar.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    return;
                }
                if (i2 == 2) {
                    AnimationFactory.stopWalletLoader(c.h(this.f55256a).v);
                    c.a(this.f55256a, String.valueOf(cVar.f54033b));
                } else if (i2 == 3) {
                    AnimationFactory.stopWalletLoader(c.h(this.f55256a).v);
                    if (cVar.f54034c != null) {
                        UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
                        CharSequence alertMessage = upiCustomVolleyError != null ? upiCustomVolleyError.getAlertMessage() : null;
                        if (!(alertMessage == null || alertMessage.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            c cVar2 = this.f55256a;
                            UpiCustomVolleyError upiCustomVolleyError2 = cVar.f54034c;
                            String alertMessage2 = upiCustomVolleyError2 != null ? upiCustomVolleyError2.getAlertMessage() : null;
                            if (alertMessage2 == null) {
                                kotlin.g.b.k.a();
                            }
                            cVar2.a((MoneyTransferV3Activity.b) null, alertMessage2, (UpiCustomVolleyError) null);
                            return;
                        }
                    }
                    c cVar3 = this.f55256a;
                    cVar3.a((MoneyTransferV3Activity.b) null, cVar3.getString(R.string.something_went_wrong_cl_lib), (UpiCustomVolleyError) null);
                }
            }
        }
    }

    static final class j<T> implements z<net.one97.paytm.moneytransfer.model.c<e.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55257a;

        j(c cVar) {
            this.f55257a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
            r1 = r1.getDebitBank();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.moneytransfer.model.c r9 = (net.one97.paytm.moneytransfer.model.c) r9
                r0 = 0
                if (r9 == 0) goto L_0x0008
                net.one97.paytm.moneytransfer.model.d r1 = r9.f54032a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.moneytransferv4.b.a.a.a.d.d.f55267e
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x013a
                r3 = 2
                if (r1 == r3) goto L_0x0043
                r9 = 3
                if (r1 == r9) goto L_0x001f
                goto L_0x013a
            L_0x001f:
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_error"
                java.lang.String r5 = ""
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r0 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r9)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f55268a
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0)
                goto L_0x013a
            L_0x0043:
                ResultType r1 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r1 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r1
                if (r1 == 0) goto L_0x004c
                java.lang.Integer r1 = r1.f54743b
                goto L_0x004d
            L_0x004c:
                r1 = r0
            L_0x004d:
                if (r1 != 0) goto L_0x0050
                goto L_0x008b
            L_0x0050:
                int r4 = r1.intValue()
                if (r4 != r3) goto L_0x008b
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r1 = r8.f55257a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                r2 = r1
                android.content.Context r2 = (android.content.Context) r2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r9 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r9
                if (r9 == 0) goto L_0x006c
                java.lang.String r0 = r9.f54744c
            L_0x006c:
                r1.append(r0)
                java.lang.String r7 = r1.toString()
                java.lang.String r3 = "wallet_money_transfer"
                java.lang.String r4 = "mpin_not_set"
                java.lang.String r5 = "/money-transfer/payment"
                java.lang.String r6 = "api_response_failure"
                net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r0 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r9)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f55268a
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0)
                return
            L_0x008b:
                if (r1 != 0) goto L_0x008e
                return
            L_0x008e:
                int r1 = r1.intValue()
                if (r1 != 0) goto L_0x013a
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r9 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r9
                if (r9 == 0) goto L_0x009e
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = r9.f54742a
                if (r9 != 0) goto L_0x00a3
            L_0x009e:
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = new net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount
                r9.<init>()
            L_0x00a3:
                java.lang.String r1 = r9.getIfsc()
                if (r1 == 0) goto L_0x013a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r1 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r1 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r1)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.f55268a
                if (r1 == 0) goto L_0x00be
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00be
                java.lang.String r1 = r1.getIfsc()
                goto L_0x00bf
            L_0x00be:
                r1 = r0
            L_0x00bf:
                java.lang.String r3 = r9.getIfsc()
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                if (r1 == 0) goto L_0x013a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r1 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r1 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r1)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.f55268a
                if (r1 == 0) goto L_0x00dd
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00dd
                java.lang.String r0 = r1.getAccRefId()
            L_0x00dd:
                java.lang.String r1 = r9.getAccRefId()
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x013a
                boolean r0 = r9.isMpinSet()
                if (r0 == 0) goto L_0x0117
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r0 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r0 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r0)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f55268a
                if (r0 == 0) goto L_0x00fa
                r0.setDebitBank(r9)
            L_0x00fa:
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                r9.c()
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_success"
                java.lang.String r5 = "mpin_set"
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x0117:
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                net.one97.paytm.moneytransferv4.b.a.a.a.d.e r0 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.g(r9)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f55268a
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0)
                net.one97.paytm.moneytransferv4.b.a.a.a.d.c r9 = r8.f55257a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_success"
                java.lang.String r5 = "mpin_still_not_set"
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
            L_0x013a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.b.a.a.a.d.c.j.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ UpiPendingRequestModel a(c cVar) {
        UpiPendingRequestModel upiPendingRequestModel = cVar.f55244e;
        if (upiPendingRequestModel == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        return upiPendingRequestModel;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.accounts.i d(c cVar) {
        net.one97.paytm.moneytransferv4.accounts.i iVar = cVar.f55242b;
        if (iVar == null) {
            kotlin.g.b.k.a("selfAccviewModel");
        }
        return iVar;
    }

    public static final /* synthetic */ e g(c cVar) {
        e eVar = cVar.f55243d;
        if (eVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return eVar;
    }

    public static final /* synthetic */ af h(c cVar) {
        af afVar = cVar.k;
        if (afVar == null) {
            kotlin.g.b.k.a("binding");
        }
        return afVar;
    }

    public static final /* synthetic */ ConstraintLayout i(c cVar) {
        ConstraintLayout constraintLayout = cVar.f55247h;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("banksExpanded");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ Group j(c cVar) {
        Group group = cVar.f55248i;
        if (group == null) {
            kotlin.g.b.k.a("primaryGroup");
        }
        return group;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
        this.m.a((a.C1006a) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        ao aoVar = this;
        q qVar = this.f55241a;
        if (qVar == null) {
            kotlin.g.b.k.a("viewModelFactory");
        }
        ai a2 = new al(aoVar, (al.b) qVar).a(e.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProvider(this, …estViewModel::class.java]");
        this.f55243d = (e) a2;
        q qVar2 = this.f55241a;
        if (qVar2 == null) {
            kotlin.g.b.k.a("viewModelFactory");
        }
        ai a3 = new al(aoVar, (al.b) qVar2).a(net.one97.paytm.moneytransferv4.accounts.i.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProvider(this, …ntsViewModel::class.java]");
        this.f55242b = (net.one97.paytm.moneytransferv4.accounts.i) a3;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new f(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class f implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55253a;

        f(c cVar) {
            this.f55253a = cVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f55253a.getResources().getColor(R.color.transparent));
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
        return layoutInflater.inflate(R.layout.mt_v4_collect_rquest_pay_fragment, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            super.onViewCreated(r7, r8)
            net.one97.paytm.moneytransferv4.b.a.a.a.d.e r8 = r6.f55243d
            java.lang.String r0 = "viewModel"
            if (r8 != 0) goto L_0x0013
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0013:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.upi.common.upi.BaseUpiResponse>> r8 = r8.f55269b
            androidx.lifecycle.q r1 = r6.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$b r2 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$b
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r8.observe(r1, r2)
            net.one97.paytm.moneytransferv4.b.a.a.a.d.e r8 = r6.f55243d
            if (r8 != 0) goto L_0x002a
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x002a:
            androidx.lifecycle.y<net.one97.paytm.upi.common.upi.BaseUpiResponse> r8 = r8.f55270c
            androidx.lifecycle.q r0 = r6.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$c r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$c
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
            net.one97.paytm.moneytransferv4.accounts.i r8 = r6.f55242b
            java.lang.String r0 = "selfAccviewModel"
            if (r8 != 0) goto L_0x0043
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0043:
            r8.c()
            net.one97.paytm.moneytransferv4.accounts.i r8 = r6.f55242b
            if (r8 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x004d:
            androidx.lifecycle.LiveData<net.one97.paytm.moneytransfer.model.c<java.util.List<net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount>>> r8 = r8.f54965b
            androidx.lifecycle.q r0 = r6.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$d r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$d
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
            r8 = r6
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            androidx.lifecycle.al r8 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r8)
            java.lang.Class<net.one97.paytm.moneytransfer.viewmodel.e> r0 = net.one97.paytm.moneytransfer.viewmodel.e.class
            androidx.lifecycle.ai r8 = r8.a(r0)
            net.one97.paytm.moneytransfer.viewmodel.e r8 = (net.one97.paytm.moneytransfer.viewmodel.e) r8
            r6.s = r8
            net.one97.paytm.moneytransfer.viewmodel.e r8 = r6.s
            if (r8 == 0) goto L_0x0083
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.e$e>> r8 = r8.f54728a
            if (r8 == 0) goto L_0x0083
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$h r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$h
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x0083:
            net.one97.paytm.moneytransfer.viewmodel.e r8 = r6.s
            if (r8 == 0) goto L_0x0099
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.lang.String>> r8 = r8.f54732e
            if (r8 == 0) goto L_0x0099
            androidx.lifecycle.q r0 = r6.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$i r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$i
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x0099:
            net.one97.paytm.moneytransfer.viewmodel.e r8 = r6.s
            if (r8 == 0) goto L_0x00af
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.e$d>> r8 = r8.f54733f
            if (r8 == 0) goto L_0x00af
            androidx.lifecycle.q r0 = r6.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$j r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$j
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x00af:
            android.os.Bundle r8 = r6.getArguments()
            r0 = 0
            if (r8 == 0) goto L_0x00bd
            java.lang.String r1 = "data"
            java.io.Serializable r8 = r8.getSerializable(r1)
            goto L_0x00be
        L_0x00bd:
            r8 = r0
        L_0x00be:
            if (r8 == 0) goto L_0x0297
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r8
            r6.f55244e = r8
            android.os.Bundle r8 = r6.getArguments()
            if (r8 == 0) goto L_0x00d3
            java.lang.String r1 = "screenName"
            java.lang.String r2 = ""
            java.lang.String r8 = r8.getString(r1, r2)
            goto L_0x00d4
        L_0x00d3:
            r8 = r0
        L_0x00d4:
            if (r8 != 0) goto L_0x00d9
            kotlin.g.b.k.a()
        L_0x00d9:
            r6.f55245f = r8
            android.os.Bundle r8 = r6.getArguments()
            r1 = 0
            if (r8 == 0) goto L_0x00ec
            java.lang.String r0 = "isViewAll"
            boolean r8 = r8.getBoolean(r0, r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
        L_0x00ec:
            if (r0 != 0) goto L_0x00f1
            kotlin.g.b.k.a()
        L_0x00f1:
            boolean r8 = r0.booleanValue()
            r6.f55246g = r8
            r8 = r6
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c r8 = (net.one97.paytm.moneytransferv4.b.a.a.a.d.c) r8
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = r8.f55244e
            r0 = 1
            if (r8 == 0) goto L_0x0101
            r8 = 1
            goto L_0x0102
        L_0x0101:
            r8 = 0
        L_0x0102:
            if (r8 == 0) goto L_0x0293
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = r6.f55244e
            java.lang.String r2 = "upiPendingRequestModel"
            if (r8 != 0) goto L_0x010e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x010e:
            if (r8 != 0) goto L_0x0112
            goto L_0x0293
        L_0x0112:
            net.one97.paytm.moneytransfer.c.af r7 = net.one97.paytm.moneytransfer.c.af.a(r7)
            java.lang.String r8 = "MtV4CollectRquestPayFragmentBinding.bind(view)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            r6.k = r7
            net.one97.paytm.moneytransfer.c.af r7 = r6.k
            if (r7 != 0) goto L_0x0126
            java.lang.String r8 = "binding"
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0126:
            androidx.constraintlayout.widget.ConstraintLayout r8 = r7.q
            java.lang.String r3 = "layoutBanksExpanded"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            r6.f55247h = r8
            androidx.recyclerview.widget.RecyclerView r8 = r7.f53632f
            java.lang.String r3 = "bankRecyclerView"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            net.one97.paytm.moneytransferv4.b.a.a.a.d.a r4 = r6.m
            androidx.recyclerview.widget.RecyclerView$a r4 = (androidx.recyclerview.widget.RecyclerView.a) r4
            r8.setAdapter(r4)
            androidx.recyclerview.widget.RecyclerView r8 = r7.f53632f
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r6.getContext()
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r8.setLayoutManager(r3)
            androidx.constraintlayout.widget.Group r8 = r7.f53629c
            java.lang.String r3 = "bankGroup"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            r6.f55248i = r8
            android.widget.TextView r8 = r7.w
            java.lang.String r3 = "payeeName"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r3 = r6.f55244e
            if (r3 != 0) goto L_0x0167
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0167:
            java.lang.String r3 = r3.getPayeeName()
            java.lang.String r3 = net.one97.paytm.upi.f.a((java.lang.String) r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = r6.f55244e
            if (r8 != 0) goto L_0x017b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x017b:
            java.lang.String r8 = r8.getPayeeVa()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x018c
            int r8 = r8.length()
            if (r8 != 0) goto L_0x018a
            goto L_0x018c
        L_0x018a:
            r8 = 0
            goto L_0x018d
        L_0x018c:
            r8 = 1
        L_0x018d:
            java.lang.String r3 = "payeeVpa"
            if (r8 != 0) goto L_0x01b1
            android.widget.TextView r8 = r7.x
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_id_placeholder
            java.lang.Object[] r4 = new java.lang.Object[r0]
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r5 = r6.f55244e
            if (r5 != 0) goto L_0x01a1
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01a1:
            java.lang.String r5 = r5.getPayeeVa()
            r4[r1] = r5
            java.lang.String r3 = r6.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
            goto L_0x01bb
        L_0x01b1:
            android.widget.TextView r8 = r7.x
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            android.view.View r8 = (android.view.View) r8
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r8)
        L_0x01bb:
            int r8 = net.one97.paytm.moneytransfer.R.string.mt_rupees_collect
            java.lang.Object[] r3 = new java.lang.Object[r0]
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r4 = r6.f55244e
            if (r4 != 0) goto L_0x01c6
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01c6:
            java.lang.String r4 = r4.getAmount()
            java.lang.String r4 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r4)
            r3[r1] = r4
            java.lang.String r8 = r6.getString(r8, r3)
            java.lang.String r3 = "getString(\n             …del.amount)\n            )"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            android.widget.TextView r3 = r7.f53627a
            java.lang.String r4 = "amount"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.setText(r8)
            android.widget.TextView r3 = r7.y
            java.lang.String r4 = "proceedButton"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setText(r8)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = r6.f55244e
            if (r8 != 0) goto L_0x01f6
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01f6:
            java.lang.String r8 = r8.getNote()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0204
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0205
        L_0x0204:
            r1 = 1
        L_0x0205:
            java.lang.String r8 = "message"
            if (r1 != 0) goto L_0x0232
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r1 = r6.f55244e
            if (r1 != 0) goto L_0x0210
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0210:
            java.lang.String r1 = r1.getNote()
            java.lang.String r3 = "na"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r0)
            if (r0 != 0) goto L_0x0232
            android.widget.TextView r0 = r7.s
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r8 = r6.f55244e
            if (r8 != 0) goto L_0x0228
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0228:
            java.lang.String r8 = r8.getNote()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            goto L_0x023c
        L_0x0232:
            android.widget.TextView r0 = r7.s
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r0)
        L_0x023c:
            net.one97.paytm.upi.util.CircularImageView r8 = r7.o
            java.lang.String r0 = "image"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            android.widget.TextView r0 = r7.j
            java.lang.String r1 = "contactInitials"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r1 = r6.f55244e
            if (r1 != 0) goto L_0x0253
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0253:
            java.lang.String r1 = r1.getLogoUrl()
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r3 = r6.f55244e
            if (r3 != 0) goto L_0x025e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x025e:
            java.lang.String r2 = r3.getPayeeName()
            net.one97.paytm.moneytransferv4.g.a.a(r8, r0, r1, r2)
            android.widget.TextView r8 = r7.k
            r0 = r6
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            android.widget.TextView r8 = r7.y
            r8.setOnClickListener(r0)
            android.widget.TextView r8 = r7.z
            r8.setOnClickListener(r0)
            android.widget.ImageView r8 = r7.n
            r8.setOnClickListener(r0)
            android.widget.ImageView r8 = r7.C
            r8.setOnClickListener(r0)
            android.widget.TextView r8 = r7.f53634h
            r8.setOnClickListener(r0)
            android.widget.ImageView r7 = r7.f53635i
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$g r8 = new net.one97.paytm.moneytransferv4.b.a.a.a.d.c$g
            r8.<init>(r6)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
            return
        L_0x0293:
            r6.dismiss()
            return
        L_0x0297:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiPendingRequestModel"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.b.a.a.a.d.c.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55254a;

        g(c cVar) {
            this.f55254a = cVar;
        }

        public final void onClick(View view) {
            this.f55254a.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
        af afVar = this.k;
        if (afVar == null) {
            kotlin.g.b.k.a("binding");
        }
        AnimationFactory.stopWalletLoader(afVar.v);
    }

    public final void onClick(View view) {
        View view2 = view;
        String str = null;
        Integer valueOf = view2 != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.proceedButton;
        if (valueOf != null && valueOf.intValue() == i2) {
            UpiPendingRequestModel upiPendingRequestModel = this.f55244e;
            if (upiPendingRequestModel == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            if (upiPendingRequestModel.isVerifiedMerchant() || !UpiUtils.doShowSecurityPopUp(getActivity())) {
                c();
            } else {
                net.one97.paytm.moneytransfer.view.b.a aVar = new net.one97.paytm.moneytransfer.view.b.a();
                Bundle bundle = new Bundle();
                bundle.putBoolean("IS_FROM_COLLECT", true);
                UpiPendingRequestModel upiPendingRequestModel2 = this.f55244e;
                if (upiPendingRequestModel2 == null) {
                    kotlin.g.b.k.a("upiPendingRequestModel");
                }
                bundle.putString("collect_vpa", upiPendingRequestModel2.getPayeeVa());
                aVar.setArguments(bundle);
                aVar.a((a.d) new e(this));
                aVar.show(getChildFragmentManager(), "");
            }
            b(Events.Action.COLLECT_REQ_PAY_CLICKED);
            return;
        }
        int i3 = R.id.declineButton;
        if (valueOf != null && valueOf.intValue() == i3) {
            e eVar = this.f55243d;
            if (eVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            UpiPendingRequestModel upiPendingRequestModel3 = this.f55244e;
            if (upiPendingRequestModel3 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            String str2 = this.f55245f;
            if (str2 == null) {
                kotlin.g.b.k.a(SDKConstants.EVENT_KEY_SCREEN_NAME);
            }
            kotlin.g.b.k.c(upiPendingRequestModel3, "upiPendingRequestModel");
            kotlin.g.b.k.c("decline", "tag");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            y<net.one97.paytm.moneytransfer.model.c<BaseUpiResponse>> yVar = eVar.f55269b;
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
            eVar.f55271d.a(new e.b(eVar), "decline", "", upiPendingRequestModel3.getPayeeVa(), upiPendingRequestModel3.getPayerVa(), upiPendingRequestModel3.getAmount(), upiPendingRequestModel3.getNote(), upiPendingRequestModel3.getAmount(), upiPendingRequestModel3.getTxnId(), "R", "A", str2);
            b(Events.Action.COLLECT_REQ_DECLINE_CLICKED);
            return;
        }
        int i4 = R.id.spam;
        if (valueOf != null && valueOf.intValue() == i4) {
            e eVar2 = this.f55243d;
            if (eVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            UpiPendingRequestModel upiPendingRequestModel4 = this.f55244e;
            if (upiPendingRequestModel4 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            String str3 = this.f55245f;
            if (str3 == null) {
                kotlin.g.b.k.a(SDKConstants.EVENT_KEY_SCREEN_NAME);
            }
            kotlin.g.b.k.c(upiPendingRequestModel4, "upiPendingRequestModel");
            kotlin.g.b.k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
            eVar2.f55271d.a(new e.a(eVar2), "", upiPendingRequestModel4.getPayeeVa(), upiPendingRequestModel4.getPayerVa(), "A", str3);
            b(Events.Action.COLLECT_REQ_SPAM_CLICKED);
            return;
        }
        int i5 = R.id.downArrow;
        if (valueOf != null && valueOf.intValue() == i5) {
            if (Build.VERSION.SDK_INT >= 19) {
                View rootView = view.getRootView();
                if (rootView != null) {
                    TransitionManager.beginDelayedTransition((ViewGroup) rootView);
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            Group group = this.f55248i;
            if (group == null) {
                kotlin.g.b.k.a("primaryGroup");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(group);
            af afVar = this.k;
            if (afVar == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView = afVar.f53634h;
            kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
            ConstraintLayout constraintLayout = this.f55247h;
            if (constraintLayout == null) {
                kotlin.g.b.k.a("banksExpanded");
            }
            net.one97.paytm.upi.f.b((View) constraintLayout);
            a aVar3 = this.m;
            ArrayList<UpiProfileDefaultBank> arrayList = this.n;
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            aVar3.a((List<UpiProfileDefaultBank>) arrayList);
            return;
        }
        int i6 = R.id.upArrow;
        if (valueOf != null && valueOf.intValue() == i6) {
            if (Build.VERSION.SDK_INT >= 19) {
                View rootView2 = view.getRootView();
                if (rootView2 != null) {
                    TransitionManager.beginDelayedTransition((ViewGroup) rootView2);
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            Group group2 = this.f55248i;
            if (group2 == null) {
                kotlin.g.b.k.a("primaryGroup");
            }
            net.one97.paytm.upi.f.b((View) group2);
            af afVar2 = this.k;
            if (afVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView2 = afVar2.f53634h;
            kotlin.g.b.k.a((Object) textView2, "binding.checkBalance");
            net.one97.paytm.upi.f.b((View) textView2);
            ConstraintLayout constraintLayout2 = this.f55247h;
            if (constraintLayout2 == null) {
                kotlin.g.b.k.a("banksExpanded");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(constraintLayout2);
            return;
        }
        int i7 = R.id.checkBalance;
        if (valueOf != null && valueOf.intValue() == i7 && (view2 instanceof TextView)) {
            TextView textView3 = (TextView) view2;
            String obj = textView3.getText().toString();
            Context context = getContext();
            if (p.a(obj, context != null ? context.getString(R.string.check_balance) : null, true)) {
                e eVar3 = this.f55243d;
                if (eVar3 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                a(eVar3.f55268a, -1);
                af afVar3 = this.k;
                if (afVar3 == null) {
                    kotlin.g.b.k.a("binding");
                }
                AnimationFactory.startWalletLoader(afVar3.r);
                return;
            }
            String obj2 = textView3.getText().toString();
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.mt_set_upi_pin);
            }
            if (p.a(obj2, str, true)) {
                e eVar4 = this.f55243d;
                if (eVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                a(eVar4.f55268a);
            }
        }
    }

    public static final class e implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55252a;

        e(c cVar) {
            this.f55252a = cVar;
        }

        public final void onDismiss() {
            this.f55252a.c();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        this.j = null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r3 = r10.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r10) {
        /*
            r9 = this;
            net.one97.paytm.moneytransfer.c.af r0 = r9.k
            java.lang.String r1 = "binding"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            r2 = 0
            if (r10 == 0) goto L_0x0017
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r10.getDebitBank()
            if (r3 == 0) goto L_0x0017
            java.lang.String r3 = r3.getBankName()
            goto L_0x0018
        L_0x0017:
            r3 = r2
        L_0x0018:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0027
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r3 = 0
            goto L_0x0028
        L_0x0027:
            r3 = 1
        L_0x0028:
            java.lang.String r6 = "bankName"
            if (r3 != 0) goto L_0x0067
            android.widget.TextView r3 = r0.f53631e
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            if (r10 == 0) goto L_0x0043
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r7 = r10.getDebitBank()
            if (r7 == 0) goto L_0x0043
            java.lang.String r7 = r7.getBankName()
            goto L_0x0044
        L_0x0043:
            r7 = r2
        L_0x0044:
            r6.append(r7)
            java.lang.String r7 = " "
            r6.append(r7)
            if (r10 == 0) goto L_0x0059
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r7 = r10.getDebitBank()
            if (r7 == 0) goto L_0x0059
            java.lang.String r7 = r7.getMaskedAccountNumber()
            goto L_0x005a
        L_0x0059:
            r7 = r2
        L_0x005a:
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            goto L_0x0089
        L_0x0067:
            android.widget.TextView r3 = r0.f53631e
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            int r6 = net.one97.paytm.moneytransfer.R.string.mt_v4_bank_acc
            java.lang.Object[] r7 = new java.lang.Object[r5]
            if (r10 == 0) goto L_0x007d
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r8 = r10.getDebitBank()
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = r8.getMaskedAccountNumber()
            goto L_0x007e
        L_0x007d:
            r8 = r2
        L_0x007e:
            r7[r4] = r8
            java.lang.String r6 = r9.getString(r6, r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0089:
            if (r10 == 0) goto L_0x00a1
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r10.getDebitBank()
            if (r3 == 0) goto L_0x00a1
            java.lang.String r3 = r3.getIfsc()
            if (r3 == 0) goto L_0x00a1
            android.widget.ImageView r0 = r0.f53630d
            java.lang.String r6 = "bankImageView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.moneytransferv4.g.a.a((android.widget.ImageView) r0, (java.lang.String) r3)
        L_0x00a1:
            if (r10 == 0) goto L_0x00a8
            java.lang.String r0 = r10.getBalance()
            goto L_0x00a9
        L_0x00a8:
            r0 = r2
        L_0x00a9:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00b6
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00b4
            goto L_0x00b6
        L_0x00b4:
            r0 = 0
            goto L_0x00b7
        L_0x00b6:
            r0 = 1
        L_0x00b7:
            if (r0 != 0) goto L_0x00ca
            if (r10 == 0) goto L_0x00c0
            java.lang.String r0 = r10.getBalance()
            goto L_0x00c1
        L_0x00c0:
            r0 = r2
        L_0x00c1:
            if (r0 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            r9.a((java.lang.String) r0)
            goto L_0x00fb
        L_0x00ca:
            net.one97.paytm.moneytransfer.c.af r0 = r9.k
            if (r0 != 0) goto L_0x00d1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d1:
            android.widget.TextView r0 = r0.f53634h
            java.lang.String r3 = "binding.checkBalance"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r3 = net.one97.paytm.moneytransfer.R.string.check_balance
            java.lang.String r3 = r9.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.content.Context r0 = r9.getContext()
            if (r0 == 0) goto L_0x00fb
            net.one97.paytm.moneytransfer.c.af r3 = r9.k
            if (r3 != 0) goto L_0x00f0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00f0:
            android.widget.TextView r3 = r3.f53634h
            int r6 = net.one97.paytm.moneytransfer.R.color.color_00b9f5
            int r0 = androidx.core.content.b.c(r0, r6)
            r3.setTextColor(r0)
        L_0x00fb:
            if (r10 == 0) goto L_0x0108
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r10.getDebitBank()
            if (r0 == 0) goto L_0x0108
            java.lang.String r0 = r0.getAccount()
            goto L_0x0109
        L_0x0108:
            r0 = r2
        L_0x0109:
            if (r0 == 0) goto L_0x01af
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r10.getDebitBank()
            if (r0 == 0) goto L_0x0116
            java.lang.String r0 = r0.getBankName()
            goto L_0x0117
        L_0x0116:
            r0 = r2
        L_0x0117:
            if (r0 == 0) goto L_0x01af
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r10.getDebitBank()
            if (r0 == 0) goto L_0x0124
            java.lang.String r0 = r0.getIfsc()
            goto L_0x0125
        L_0x0124:
            r0 = r2
        L_0x0125:
            java.lang.String r3 = "PYTM0123456"
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r5)
            if (r0 != 0) goto L_0x015c
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r10.getDebitBank()
            if (r0 == 0) goto L_0x013c
            boolean r0 = r0.isMpinSet()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x013d
        L_0x013c:
            r0 = r2
        L_0x013d:
            if (r0 != 0) goto L_0x0142
            kotlin.g.b.k.a()
        L_0x0142:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x015c
            net.one97.paytm.moneytransfer.c.af r0 = r9.k
            if (r0 != 0) goto L_0x014f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x014f:
            android.widget.TextView r0 = r0.f53634h
            int r3 = net.one97.paytm.moneytransfer.R.string.mt_set_upi_pin
            java.lang.String r3 = r9.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x015c:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r10.getDebitBank()
            if (r0 == 0) goto L_0x0167
            java.lang.String r0 = r0.getBankName()
            goto L_0x0168
        L_0x0167:
            r0 = r2
        L_0x0168:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r10 = r10.getDebitBank()
            if (r10 == 0) goto L_0x0172
            java.lang.String r2 = r10.getAccount()
        L_0x0172:
            java.lang.String r10 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (java.lang.String) r2)
            java.lang.String r0 = "accountNo"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r0 = r10.length()
            if (r0 != 0) goto L_0x0184
            r4 = 1
        L_0x0184:
            java.lang.String r0 = "binding.bankName"
            if (r4 == 0) goto L_0x01a0
            net.one97.paytm.moneytransfer.c.af r10 = r9.k
            if (r10 != 0) goto L_0x018f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x018f:
            android.widget.TextView r10 = r10.f53631e
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            int r0 = net.one97.paytm.moneytransfer.R.string.money_tranfer_balance_paytm_bank_string
            java.lang.String r0 = r9.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.setText(r0)
            return
        L_0x01a0:
            net.one97.paytm.moneytransfer.c.af r2 = r9.k
            if (r2 != 0) goto L_0x01a7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01a7:
            android.widget.TextView r1 = r2.f53631e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            r1.setText(r10)
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.b.a.a.a.d.c.b(net.one97.paytm.upi.common.upi.UpiProfileDefaultBank):void");
    }

    public final void a(int i2) {
        if (i2 < this.n.size()) {
            e eVar = this.f55243d;
            if (eVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            eVar.f55268a = this.n.get(i2);
            e eVar2 = this.f55243d;
            if (eVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            b(eVar2.f55268a);
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, int i2) {
        if (isResumed() && isAdded()) {
            this.o = i2;
            if (!com.paytm.utility.a.m(getContext())) {
                net.one97.paytm.moneytransfer.utils.m.d((Activity) getActivity());
            } else if (upiProfileDefaultBank != null) {
                c(upiProfileDefaultBank);
            }
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (isResumed() && isAdded()) {
            if (com.paytm.utility.a.m(getContext())) {
                a(this.q, upiProfileDefaultBank);
            } else {
                net.one97.paytm.moneytransfer.utils.m.d((Activity) getActivity());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (this.r == null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            this.r = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.p)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UPICheckBalanceHelper uPICheckBalanceHelper = this.r;
        if (uPICheckBalanceHelper != null) {
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        }
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (!isResumed() || !isAdded()) {
            if (isAdded() && this.o != -1) {
                this.m.a();
            }
        } else if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    private final void a(boolean z) {
        if (isAdded()) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new m(this), childFragmentManager, z);
        }
    }

    public static final class m implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55262a;

        m(c cVar) {
            this.f55262a = cVar;
        }

        public final void onReEnterClicked() {
            UpiProfileDefaultBank upiProfileDefaultBank = c.g(this.f55262a).f55268a;
            if (upiProfileDefaultBank != null) {
                this.f55262a.c(upiProfileDefaultBank);
            }
        }

        public final void onCreateNewPinClicked() {
            BankAccountDetails.BankAccount debitBank;
            UpiProfileDefaultBank upiProfileDefaultBank = c.g(this.f55262a).f55268a;
            if (upiProfileDefaultBank != null && (debitBank = upiProfileDefaultBank.getDebitBank()) != null) {
                c cVar = this.f55262a;
                kotlin.g.b.k.c(debitBank, "bankAccount");
                Intent intent = new Intent(cVar.getActivity(), SetMPINActivity.class);
                List a2 = kotlin.a.k.a(debitBank);
                net.one97.paytm.moneytransferv4.accounts.i iVar = cVar.f55242b;
                if (iVar == null) {
                    kotlin.g.b.k.a("selfAccviewModel");
                }
                UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, iVar.a()).setBankAccountList(a2).build();
                kotlin.g.b.k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
                intent.putExtra("user_upi_details", build);
                intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
                cVar.startActivityForResult(intent, 10);
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (isResumed() && isAdded()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(\n             …alance)\n                )");
            } else {
                str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
            }
            if (this.o != -1) {
                try {
                    e eVar = this.f55243d;
                    if (eVar == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    if (kotlin.g.b.k.a((Object) eVar.f55268a, (Object) this.n.get(this.m.b()))) {
                        a(str4);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                }
                this.m.a(str4);
                return;
            }
            a(str4);
            e eVar2 = this.f55243d;
            if (eVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank = eVar2.f55268a;
            if (upiProfileDefaultBank != null) {
                upiProfileDefaultBank.setBalance(str4);
            }
        }
    }

    public final void b() {
        if (this.o == -1) {
            af afVar = this.k;
            if (afVar == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView = afVar.f53634h;
            kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
            net.one97.paytm.upi.f.b((View) textView);
            af afVar2 = this.k;
            if (afVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            AnimationFactory.stopWalletLoader(afVar2.r);
            return;
        }
        this.m.d();
    }

    public final void Z_() {
        if (this.o == -1) {
            af afVar = this.k;
            if (afVar == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView = afVar.f53634h;
            kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
            textView.setVisibility(4);
            af afVar2 = this.k;
            if (afVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            AnimationFactory.startWalletLoader(afVar2.r);
            return;
        }
        this.m.c();
    }

    private final void a(String str) {
        af afVar = this.k;
        if (afVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = afVar.f53634h;
        kotlin.g.b.k.a((Object) textView, "binding.checkBalance");
        textView.setText(str);
        Context context = getContext();
        if (context != null) {
            af afVar2 = this.k;
            if (afVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            afVar2.f53634h.setTextColor(androidx.core.content.b.c(context, R.color.color_222222));
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, false);
        startActivityForResult(intent, i2);
    }

    /* access modifiers changed from: private */
    public final void c() {
        if (!com.paytm.utility.a.m(getActivity())) {
            Context context = getContext();
            if (context != null) {
                kotlin.g.b.k.a((Object) context, "it");
                String string = getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getResources().getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "resources.getString(R.string.no_internet)");
                String string3 = getString(R.string.ok);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.ok)");
                a(context, string, string2, string3, false);
            }
        } else if (!UpiUtils.isSimAvailable(getContext())) {
            Context context2 = getContext();
            if (context2 != null) {
                kotlin.g.b.k.a((Object) context2, "it");
                String string4 = getString(R.string.upi_error_no_sim_title);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.upi_error_no_sim_title)");
                String string5 = getResources().getString(R.string.upi_error_no_sim_desc);
                kotlin.g.b.k.a((Object) string5, "resources.getString(R.st…ng.upi_error_no_sim_desc)");
                String string6 = getString(R.string.ok);
                kotlin.g.b.k.a((Object) string6, "getString(R.string.ok)");
                a(context2, string4, string5, string6, false);
            }
        } else {
            net.one97.paytm.moneytransfer.viewmodel.e eVar = this.s;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b r3, java.lang.String r4, net.one97.paytm.upi.common.UpiCustomVolleyError r5) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0003
            goto L_0x0005
        L_0x0003:
            java.lang.String r4 = ""
        L_0x0005:
            java.lang.String r0 = "getString(R.string.upi_oops_something_went_wrong)"
            if (r3 == 0) goto L_0x0046
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.PLEASE_ADD_BANK
            if (r3 != r1) goto L_0x0019
            int r3 = net.one97.paytm.moneytransfer.R.string.please_add_a_bank_account
            java.lang.String r4 = r2.getString(r3)
            java.lang.String r3 = "getString(R.string.please_add_a_bank_account)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            goto L_0x0046
        L_0x0019:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
            if (r3 != r1) goto L_0x0027
            int r3 = net.one97.paytm.moneytransfer.R.string.upi_oops_something_went_wrong
            java.lang.String r4 = r2.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            goto L_0x0046
        L_0x0027:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.CANNOT_TRANSFER_TO_SAME_ACC
            if (r3 != r1) goto L_0x0037
            int r3 = net.one97.paytm.moneytransfer.R.string.you_cannot_transfer_money_to_same_account
            java.lang.String r4 = r2.getString(r3)
            java.lang.String r3 = "getString(R.string.you_c…er_money_to_same_account)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            goto L_0x0046
        L_0x0037:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.NO_SIM
            if (r3 != r1) goto L_0x0046
            int r3 = net.one97.paytm.moneytransfer.R.string.no_sim_attached
            java.lang.String r4 = r2.getString(r3)
            java.lang.String r3 = "getString(R.string.no_sim_attached)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
        L_0x0046:
            if (r5 == 0) goto L_0x00c5
            java.lang.String r3 = r5.getmErrorCode()
            java.lang.String r4 = "401"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00a3
            java.lang.String r3 = r5.getmErrorCode()
            java.lang.String r4 = "410"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0061
            goto L_0x00a3
        L_0x0061:
            java.lang.String r3 = r5.getAlertMessage()
            if (r3 == 0) goto L_0x008e
            java.lang.String r3 = r5.getAlertMessage()
            java.lang.String r4 = "error.alertMessage"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r3 == 0) goto L_0x0086
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.m.p.b(r3)
            java.lang.String r3 = r3.toString()
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0097
            goto L_0x008e
        L_0x0086:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.CharSequence"
            r3.<init>(r4)
            throw r3
        L_0x008e:
            int r3 = net.one97.paytm.moneytransfer.R.string.upi_oops_something_went_wrong
            java.lang.String r3 = r2.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
        L_0x0097:
            android.content.Context r4 = r2.getContext()
            if (r4 == 0) goto L_0x00a2
            java.lang.String r5 = "Error"
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r3)
        L_0x00a2:
            return
        L_0x00a3:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x00c4
            net.one97.paytm.moneytransfer.d.d$a r4 = net.one97.paytm.moneytransfer.d.d.f53996a
            net.one97.paytm.moneytransfer.d.d r4 = net.one97.paytm.moneytransfer.d.d.a.a()
            net.one97.paytm.moneytransfer.d.a r4 = net.one97.paytm.moneytransfer.d.d.b(r4)
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            android.app.Activity r3 = (android.app.Activity) r3
            r5 = 0
            com.paytm.network.model.NetworkCustomError r0 = new com.paytm.network.model.NetworkCustomError
            r0.<init>()
            r0 = 0
            r4.a((android.app.Activity) r3, (java.lang.String) r5, (boolean) r0)
        L_0x00c4:
            return
        L_0x00c5:
            android.content.Context r3 = r2.getContext()
            if (r3 == 0) goto L_0x00e2
            androidx.appcompat.app.c$a r5 = new androidx.appcompat.app.c$a
            r5.<init>(r3)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.b((java.lang.CharSequence) r4)
            r3 = 17039370(0x104000a, float:2.42446E-38)
            net.one97.paytm.moneytransferv4.b.a.a.a.d.c$l r4 = net.one97.paytm.moneytransferv4.b.a.a.a.d.c.l.f55261a
            android.content.DialogInterface$OnClickListener r4 = (android.content.DialogInterface.OnClickListener) r4
            r5.b((int) r3, (android.content.DialogInterface.OnClickListener) r4)
            r5.b()
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.b.a.a.a.d.c.a(net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b, java.lang.String, net.one97.paytm.upi.common.UpiCustomVolleyError):void");
    }

    static final class l implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final l f55261a = new l();

        l() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    public final void a(Context context, String str, String str2, String str3, boolean z) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(str2, "msg");
        kotlin.g.b.k.c(str3, "buttonText");
        CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
        customWalletAlertDialog.setTitle(str);
        customWalletAlertDialog.setCanceledOnTouchOutside(false);
        customWalletAlertDialog.setCancelable(false);
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setButton(-1, str3, new k(this, customWalletAlertDialog, z));
        customWalletAlertDialog.show();
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustomWalletAlertDialog f55259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f55260c;

        k(c cVar, CustomWalletAlertDialog customWalletAlertDialog, boolean z) {
            this.f55258a = cVar;
            this.f55259b = customWalletAlertDialog;
            this.f55260c = z;
        }

        public final void onClick(View view) {
            this.f55259b.dismiss();
            if (this.f55260c) {
                this.f55258a.dismiss();
            }
        }
    }

    private final void b(String str) {
        UpiPendingRequestModel upiPendingRequestModel = this.f55244e;
        if (upiPendingRequestModel == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        if (upiPendingRequestModel != null) {
            Context context = getContext();
            UpiPendingRequestModel upiPendingRequestModel2 = this.f55244e;
            if (upiPendingRequestModel2 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            String refCategory = upiPendingRequestModel2.getRefCategory();
            UpiPendingRequestModel upiPendingRequestModel3 = this.f55244e;
            if (upiPendingRequestModel3 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.COLLECT, str, Events.Label.MT_HOMEPAGE, refCategory, "", upiPendingRequestModel3.getPayeeVa(), "", Events.Screen.MT_HOMEPAGE, "");
        }
    }

    public static final /* synthetic */ void a(c cVar, e.C0981e eVar) {
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.CredsAllowed credsAllowed;
        BankAccountDetails.BankAccount debitBank3;
        BankAccountDetails.BankAccount debitBank4;
        BankAccountDetails.BankAccount debitBank5;
        c cVar2 = cVar;
        e.C0981e eVar2 = eVar;
        Integer num = eVar2.f54746b;
        String str = null;
        if (num != null && num.intValue() == 2) {
            cVar2.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG, (String) null, (UpiCustomVolleyError) null);
            af afVar = cVar2.k;
            if (afVar == null) {
                kotlin.g.b.k.a("binding");
            }
            AnimationFactory.stopWalletLoader(afVar.v);
        } else if (num != null && num.intValue() == 0) {
            e eVar3 = cVar2.f55243d;
            if (eVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank = eVar3.f55268a;
            if ((upiProfileDefaultBank != null ? upiProfileDefaultBank.getDebitBank() : null) == null) {
                cVar2.a(MoneyTransferV3Activity.b.PLEASE_ADD_BANK, (String) null, (UpiCustomVolleyError) null);
                af afVar2 = cVar2.k;
                if (afVar2 == null) {
                    kotlin.g.b.k.a("binding");
                }
                AnimationFactory.stopWalletLoader(afVar2.v);
                return;
            }
            e eVar4 = cVar2.f55243d;
            if (eVar4 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank2 = eVar4.f55268a;
            Boolean valueOf = (upiProfileDefaultBank2 == null || (debitBank5 = upiProfileDefaultBank2.getDebitBank()) == null) ? null : Boolean.valueOf(debitBank5.isMpinSet());
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf.booleanValue()) {
                af afVar3 = cVar2.k;
                if (afVar3 == null) {
                    kotlin.g.b.k.a("binding");
                }
                AnimationFactory.stopWalletLoader(afVar3.v);
                ArrayList arrayList = new ArrayList();
                e eVar5 = cVar2.f55243d;
                if (eVar5 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                UpiProfileDefaultBank upiProfileDefaultBank3 = eVar5.f55268a;
                if (!(upiProfileDefaultBank3 == null || (debitBank4 = upiProfileDefaultBank3.getDebitBank()) == null)) {
                    arrayList.add(debitBank4);
                }
                e eVar6 = cVar2.f55243d;
                if (eVar6 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                UpiProfileDefaultBank upiProfileDefaultBank4 = eVar6.f55268a;
                UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank4 != null ? upiProfileDefaultBank4.getVirtualAddress() : null).setBankAccountList(arrayList).build();
                net.one97.paytm.moneytransfer.viewmodel.e eVar7 = cVar2.s;
                if (eVar7 != null) {
                    kotlin.g.b.k.a((Object) build, "userUpiDetails");
                    eVar7.a(build);
                    return;
                }
                return;
            }
            String str2 = eVar2.f54745a;
            CharSequence charSequence = str2;
            if (!TextUtils.isEmpty(charSequence)) {
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                UpiPendingRequestModel upiPendingRequestModel = cVar2.f55244e;
                if (upiPendingRequestModel == null) {
                    kotlin.g.b.k.a("upiPendingRequestModel");
                }
                String payeeVa = upiPendingRequestModel.getPayeeVa();
                kotlin.g.b.k.a((Object) payeeVa, "upiPendingRequestModel.payeeVa");
                if (p.a((CharSequence) payeeVa, (CharSequence) "paytm", false)) {
                    UpiPendingRequestModel upiPendingRequestModel2 = cVar2.f55244e;
                    if (upiPendingRequestModel2 == null) {
                        kotlin.g.b.k.a("upiPendingRequestModel");
                    }
                    String payeeVa2 = upiPendingRequestModel2.getPayeeVa();
                    kotlin.g.b.k.a((Object) payeeVa2, "upiPendingRequestModel.payeeVa");
                    if (payeeVa2 != null) {
                        kotlin.g.b.k.a((Object) payeeVa2.toLowerCase(), "(this as java.lang.String).toLowerCase()");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                UpiPendingRequestModel upiPendingRequestModel3 = cVar2.f55244e;
                if (upiPendingRequestModel3 == null) {
                    kotlin.g.b.k.a("upiPendingRequestModel");
                }
                if (!TextUtils.isEmpty(upiPendingRequestModel3.getPayeeVa())) {
                    UpiPendingRequestModel upiPendingRequestModel4 = cVar2.f55244e;
                    if (upiPendingRequestModel4 == null) {
                        kotlin.g.b.k.a("upiPendingRequestModel");
                    }
                    if (!TextUtils.isEmpty(upiPendingRequestModel4.getTxnId()) && !TextUtils.isEmpty(charSequence)) {
                        net.one97.paytm.moneytransfer.viewmodel.e eVar8 = cVar2.s;
                        if (eVar8 != null) {
                            UpiPendingRequestModel upiPendingRequestModel5 = cVar2.f55244e;
                            if (upiPendingRequestModel5 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String amount = upiPendingRequestModel5.getAmount();
                            UpiPendingRequestModel upiPendingRequestModel6 = cVar2.f55244e;
                            if (upiPendingRequestModel6 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String payeeVa3 = upiPendingRequestModel6.getPayeeVa();
                            UpiPendingRequestModel upiPendingRequestModel7 = cVar2.f55244e;
                            if (upiPendingRequestModel7 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String payerVa = upiPendingRequestModel7.getPayerVa();
                            UpiPendingRequestModel upiPendingRequestModel8 = cVar2.f55244e;
                            if (upiPendingRequestModel8 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String payeeName = upiPendingRequestModel8.getPayeeName();
                            UpiPendingRequestModel upiPendingRequestModel9 = cVar2.f55244e;
                            if (upiPendingRequestModel9 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String note = upiPendingRequestModel9.getNote();
                            e eVar9 = cVar2.f55243d;
                            if (eVar9 == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            UpiProfileDefaultBank upiProfileDefaultBank5 = eVar9.f55268a;
                            String maskNumber = UpiUtils.maskNumber((upiProfileDefaultBank5 == null || (debitBank3 = upiProfileDefaultBank5.getDebitBank()) == null) ? null : debitBank3.getAccount());
                            UpiPendingRequestModel upiPendingRequestModel10 = cVar2.f55244e;
                            if (upiPendingRequestModel10 == null) {
                                kotlin.g.b.k.a("upiPendingRequestModel");
                            }
                            String txnId = upiPendingRequestModel10.getTxnId();
                            e eVar10 = cVar2.f55243d;
                            if (eVar10 == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            UpiProfileDefaultBank upiProfileDefaultBank6 = eVar10.f55268a;
                            List<BankAccountDetails.BankAccountCredentials> child = (upiProfileDefaultBank6 == null || (debitBank2 = upiProfileDefaultBank6.getDebitBank()) == null || (credsAllowed = debitBank2.getCredsAllowed()) == null) ? null : credsAllowed.getChild();
                            e eVar11 = cVar2.f55243d;
                            if (eVar11 == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            UpiProfileDefaultBank upiProfileDefaultBank7 = eVar11.f55268a;
                            if (!(upiProfileDefaultBank7 == null || (debitBank = upiProfileDefaultBank7.getDebitBank()) == null)) {
                                str = debitBank.getBankName();
                            }
                            eVar8.a(amount, payeeVa3, payerVa, payeeName, note, maskNumber, txnId, "", "", "", str2, child, str);
                            return;
                        }
                        return;
                    }
                }
                Toast.makeText(cVar.getContext(), R.string.upi_error_something_went_wrong, 1).show();
                return;
            }
            af afVar4 = cVar2.k;
            if (afVar4 == null) {
                kotlin.g.b.k.a("binding");
            }
            AnimationFactory.stopWalletLoader(afVar4.v);
        } else if (num != null && num.intValue() == 1) {
            Intent intent = new Intent(cVar.getActivity(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            cVar2.startActivityForResult(intent, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        }
    }

    public static final /* synthetic */ void a(c cVar, String str) {
        cVar.t = new Intent(cVar.getContext(), MoneyTransferPostTransactionActivity.class);
        UpiPendingRequestModel upiPendingRequestModel = cVar.f55244e;
        if (upiPendingRequestModel == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        CharSequence payeeName = upiPendingRequestModel.getPayeeName();
        if (payeeName == null || p.a(payeeName)) {
            Intent intent = cVar.t;
            if (intent == null) {
                kotlin.g.b.k.a("intent");
            }
            intent.putExtra(LocaleDBContract.BaseTable.KEY, "NA");
        } else {
            Intent intent2 = cVar.t;
            if (intent2 == null) {
                kotlin.g.b.k.a("intent");
            }
            UpiPendingRequestModel upiPendingRequestModel2 = cVar.f55244e;
            if (upiPendingRequestModel2 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            intent2.putExtra(LocaleDBContract.BaseTable.KEY, upiPendingRequestModel2.getPayeeName());
        }
        Intent intent3 = cVar.t;
        if (intent3 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent3.putExtra("key_account_no_vpa_adhaar", MoneyTransferV3Activity.a.VPA);
        UpiPendingRequestModel upiPendingRequestModel3 = cVar.f55244e;
        if (upiPendingRequestModel3 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        if (TextUtils.isEmpty(upiPendingRequestModel3.getNote())) {
            Intent intent4 = cVar.t;
            if (intent4 == null) {
                kotlin.g.b.k.a("intent");
            }
            intent4.putExtra("key_comment", "NA");
        } else {
            Intent intent5 = cVar.t;
            if (intent5 == null) {
                kotlin.g.b.k.a("intent");
            }
            UpiPendingRequestModel upiPendingRequestModel4 = cVar.f55244e;
            if (upiPendingRequestModel4 == null) {
                kotlin.g.b.k.a("upiPendingRequestModel");
            }
            intent5.putExtra("key_comment", upiPendingRequestModel4.getNote());
        }
        Intent intent6 = cVar.t;
        if (intent6 == null) {
            kotlin.g.b.k.a("intent");
        }
        UpiPendingRequestModel upiPendingRequestModel5 = cVar.f55244e;
        if (upiPendingRequestModel5 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        intent6.putExtra("collect_request_txn_id", upiPendingRequestModel5.getTxnId());
        Intent intent7 = cVar.t;
        if (intent7 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent7.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, true);
        Intent intent8 = cVar.t;
        if (intent8 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent8.putExtra("is_deeplink", false);
        Intent intent9 = cVar.t;
        if (intent9 == null) {
            kotlin.g.b.k.a("intent");
        }
        e eVar = cVar.f55243d;
        if (eVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        intent9.putExtra(UpiConstants.EXTRA_PAYER_VPA, eVar.f55268a);
        Intent intent10 = cVar.t;
        if (intent10 == null) {
            kotlin.g.b.k.a("intent");
        }
        UpiPendingRequestModel upiPendingRequestModel6 = cVar.f55244e;
        if (upiPendingRequestModel6 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        intent10.putExtra("payee_address", upiPendingRequestModel6.getPayeeVa());
        Intent intent11 = cVar.t;
        if (intent11 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent11.putExtra("payee_acc_or_vpa", MoneyTransferV3Activity.a.VPA);
        Intent intent12 = cVar.t;
        if (intent12 == null) {
            kotlin.g.b.k.a("intent");
        }
        UpiPendingRequestModel upiPendingRequestModel7 = cVar.f55244e;
        if (upiPendingRequestModel7 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        intent12.putExtra("key_amount", UpiUtils.convertToTwoPlaces(upiPendingRequestModel7.getAmount()));
        Intent intent13 = cVar.t;
        if (intent13 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent13.putExtra("key_mpin", str);
        Intent intent14 = cVar.t;
        if (intent14 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent14.putExtra("npci_trust", GetCredentialsApiBuilder.getTrust(cVar.getActivity()));
        Intent intent15 = cVar.t;
        if (intent15 == null) {
            kotlin.g.b.k.a("intent");
        }
        UpiPendingRequestModel upiPendingRequestModel8 = cVar.f55244e;
        if (upiPendingRequestModel8 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        intent15.putExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, upiPendingRequestModel8.getTxnId());
        Intent intent16 = cVar.t;
        if (intent16 == null) {
            kotlin.g.b.k.a("intent");
        }
        UpiPendingRequestModel upiPendingRequestModel9 = cVar.f55244e;
        if (upiPendingRequestModel9 == null) {
            kotlin.g.b.k.a("upiPendingRequestModel");
        }
        intent16.putExtra("key_account_number", upiPendingRequestModel9.getPayeeVa());
        Intent intent17 = cVar.t;
        if (intent17 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent17.putExtra("ifsc", "UPI");
        Intent intent18 = cVar.t;
        if (intent18 == null) {
            kotlin.g.b.k.a("intent");
        }
        intent18.putExtra("key_account_number_selected", cVar.getString(R.string.money_transfer_upi_string));
        Intent intent19 = cVar.t;
        if (intent19 == null) {
            kotlin.g.b.k.a("intent");
        }
        cVar.startActivity(intent19);
        FragmentActivity activity = cVar.getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        activity.finish();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
