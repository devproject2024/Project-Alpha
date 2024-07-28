package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.g;
import net.one97.paytm.moneytransfer.view.a.f;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.b.a;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.moneytransfer.viewmodel.e;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CommentsEditText;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class n extends Fragment implements View.OnClickListener, View.OnFocusChangeListener, net.one97.paytm.common.a, n.c, f.b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f54547c = new a((byte) 0);
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public Uri B;
    private Dialog C;
    private String D;
    private String E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    /* access modifiers changed from: private */
    public boolean J;
    private boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    private boolean M;
    /* access modifiers changed from: private */
    public boolean N;
    /* access modifiers changed from: private */
    public boolean O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private boolean T;
    private net.one97.paytm.moneytransfer.viewmodel.e U;
    private net.one97.paytm.moneytransfer.viewmodel.b V;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    public CustomAmountTextInputEditText f54548a;
    private TextView aA;
    private View aB;
    private View aC;
    private LottieAnimationView aD;
    private ImageView aE;
    private ArrayList<UpiProfileDefaultBank> aF = new ArrayList<>();
    /* access modifiers changed from: private */
    public List<? extends UpiProfileDefaultBank> aG;
    private j aH;
    private MoneyTransferV3Activity.d aI = MoneyTransferV3Activity.d.VPA;
    private int aJ = -1;
    private String aK;
    private int aL;
    private UPICheckBalanceHelper aM;
    /* access modifiers changed from: private */
    public net.one97.paytm.moneytransfer.utils.n aN;
    private boolean aO;
    private final z aP = new z(this);
    private HashMap aQ;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private View aj;
    private LinearLayout ak;
    private TextView al;
    private LottieAnimationView am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private ImageView aq;
    private ImageView ar;
    private View as;
    private View at;
    private ImageView au;
    private NestedScrollView av;
    private TextView aw;
    private TextView ax;
    private LinearLayout ay;
    private View az;

    /* renamed from: b  reason: collision with root package name */
    int f54549b;

    /* renamed from: d  reason: collision with root package name */
    private final int f54550d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f54551e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final String f54552f = "PYTM0123456";

    /* renamed from: g  reason: collision with root package name */
    private final String f54553g = "^0+";

    /* renamed from: h  reason: collision with root package name */
    private TextView f54554h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f54555i;
    private TextView j;
    private ShimmerFrameLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private RelativeLayout o;
    private CommentsEditText p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private ImageView v;
    private View w;
    private View x;
    /* access modifiers changed from: private */
    public MoneyTransferV3Activity.a y = MoneyTransferV3Activity.a.ACCOUNT_NUMBER;
    private UpiConstants.MoneyTransferPaymentOption z = UpiConstants.MoneyTransferPaymentOption.ALL;

    static final class b<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<DealsEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54557a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f54558b;

        b(n nVar, View view) {
            this.f54557a = nVar;
            this.f54558b = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            DealsEntity dealsEntity;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null && (dealsEntity = (DealsEntity) cVar.f54033b) != null) {
                n nVar = this.f54557a;
                View view = this.f54558b;
                f.b bVar = nVar;
                FragmentActivity activity = nVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                nVar.aN = new net.one97.paytm.moneytransfer.utils.n(view, bVar, new WeakReference(activity), dealsEntity);
            }
        }
    }

    static final class k<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<b.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54567a;

        k(n nVar) {
            this.f54567a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            n nVar = this.f54567a;
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            n.b(nVar, cVar);
        }
    }

    static final class l<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<e.C0981e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54568a;

        l(n nVar) {
            this.f54568a = nVar;
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
                int i2 = o.f54585a[dVar.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.f54568a.u();
                        n nVar = this.f54568a;
                        ResultType resulttype = cVar.f54033b;
                        if (resulttype == null) {
                            kotlin.g.b.k.a();
                        }
                        n.a(nVar, (e.C0981e) resulttype);
                    } else if (i2 == 3) {
                        this.f54568a.u();
                        this.f54568a.a(cVar.f54034c);
                    }
                } else if (!this.f54568a.J && !this.f54568a.L && !this.f54568a.O && !this.f54568a.P && !this.f54568a.N) {
                    n.i(this.f54568a);
                }
            }
        }
    }

    static final class m<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54569a;

        m(n nVar) {
            this.f54569a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            this.f54569a.u();
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null && o.f54589e[dVar.ordinal()] == 1) {
                net.one97.paytm.moneytransfer.utils.m.c((Activity) this.f54569a.getActivity());
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.fragments.n$n  reason: collision with other inner class name */
    static final class C0977n<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54570a;

        C0977n(n nVar) {
            this.f54570a = nVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
            r1 = r5.f54034c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                net.one97.paytm.moneytransfer.model.c r5 = (net.one97.paytm.moneytransfer.model.c) r5
                r0 = 0
                if (r5 == 0) goto L_0x0008
                net.one97.paytm.moneytransfer.model.d r1 = r5.f54032a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.moneytransfer.view.fragments.o.f54587c
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x008d
                r3 = 2
                if (r1 == r3) goto L_0x0082
                r3 = 3
                if (r1 == r3) goto L_0x001e
                goto L_0x0081
            L_0x001e:
                net.one97.paytm.upi.common.UpiCustomVolleyError r1 = r5.f54034c
                if (r1 == 0) goto L_0x0076
                net.one97.paytm.upi.common.UpiCustomVolleyError r1 = r5.f54034c
                if (r1 == 0) goto L_0x002b
                java.lang.String r1 = r1.getAlertMessage()
                goto L_0x002c
            L_0x002b:
                r1 = r0
            L_0x002c:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0038
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0037
                goto L_0x0038
            L_0x0037:
                r2 = 0
            L_0x0038:
                if (r2 != 0) goto L_0x0076
                if (r5 == 0) goto L_0x0045
                net.one97.paytm.upi.common.UpiCustomVolleyError r1 = r5.f54034c
                if (r1 == 0) goto L_0x0045
                java.lang.String r1 = r1.getAlertMessage()
                goto L_0x0046
            L_0x0045:
                r1 = r0
            L_0x0046:
                net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
                java.lang.String r2 = r2.toString()
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x0063
                net.one97.paytm.moneytransfer.view.fragments.n r5 = r4.f54570a
                int r0 = net.one97.paytm.moneytransfer.R.string.something_went_wrong_cl_lib
                java.lang.String r0 = r5.getString(r0)
                java.lang.String r1 = "getString(R.string.something_went_wrong_cl_lib)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r5.a((java.lang.String) r0)
                return
            L_0x0063:
                net.one97.paytm.moneytransfer.view.fragments.n r1 = r4.f54570a
                net.one97.paytm.upi.common.UpiCustomVolleyError r5 = r5.f54034c
                if (r5 == 0) goto L_0x006d
                java.lang.String r0 = r5.getAlertMessage()
            L_0x006d:
                if (r0 != 0) goto L_0x0072
                kotlin.g.b.k.a()
            L_0x0072:
                r1.a((java.lang.String) r0)
                return
            L_0x0076:
                net.one97.paytm.moneytransfer.view.fragments.n r5 = r4.f54570a
                androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
                if (r5 == 0) goto L_0x0081
                r5.finish()
            L_0x0081:
                return
            L_0x0082:
                net.one97.paytm.moneytransfer.view.fragments.n r0 = r4.f54570a
                ResultType r5 = r5.f54033b
                java.lang.String r5 = java.lang.String.valueOf(r5)
                net.one97.paytm.moneytransfer.view.fragments.n.a((net.one97.paytm.moneytransfer.view.fragments.n) r0, (java.lang.String) r5)
            L_0x008d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.C0977n.onChanged(java.lang.Object):void");
        }
    }

    static final class o<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.a<e.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54571a;

        o(n nVar) {
            this.f54571a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            NetworkCustomError networkCustomError;
            String alertTitle;
            e.c cVar;
            String str;
            net.one97.paytm.moneytransfer.model.a aVar = (net.one97.paytm.moneytransfer.model.a) obj;
            e.c cVar2 = null;
            if (aVar != null) {
                dVar = aVar.f54025a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = o.f54590f[dVar.ordinal()];
                if (i2 == 1) {
                    n.i(this.f54571a);
                } else if (i2 == 2) {
                    this.f54571a.u();
                    if (aVar != null) {
                        cVar2 = (e.c) aVar.f54026b;
                    }
                    if (cVar2 != null) {
                        n.a(this.f54571a, cVar2);
                    }
                } else if (i2 == 3) {
                    this.f54571a.u();
                    if (aVar != null && (networkCustomError = aVar.f54027c) != null && (alertTitle = networkCustomError.getAlertTitle()) != null && (cVar = (e.c) aVar.f54026b) != null && (str = cVar.f54741c) != null) {
                        this.f54571a.b(alertTitle, str);
                    }
                } else if (i2 == 4) {
                    this.f54571a.u();
                    net.one97.paytm.moneytransfer.utils.m.b((Activity) this.f54571a.getActivity());
                }
            }
        }
    }

    static final class r<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<e.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54574a;

        r(n nVar) {
            this.f54574a = nVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b5, code lost:
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
                int[] r2 = net.one97.paytm.moneytransfer.view.fragments.o.f54586b
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x0135
                r3 = 2
                if (r1 == r3) goto L_0x0045
                r9 = 3
                if (r1 == r9) goto L_0x001f
                goto L_0x0134
            L_0x001f:
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                r9.u()
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_error"
                java.lang.String r5 = ""
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.W
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                goto L_0x0134
            L_0x0045:
                net.one97.paytm.moneytransfer.view.fragments.n r1 = r8.f54574a
                r1.u()
                ResultType r1 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r1 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r1
                if (r1 == 0) goto L_0x0053
                java.lang.Integer r1 = r1.f54743b
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                if (r1 != 0) goto L_0x0057
                goto L_0x008f
            L_0x0057:
                int r4 = r1.intValue()
                if (r4 != r3) goto L_0x008f
                net.one97.paytm.moneytransfer.view.fragments.n r1 = r8.f54574a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                r2 = r1
                android.content.Context r2 = (android.content.Context) r2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r9 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r9
                if (r9 == 0) goto L_0x0073
                java.lang.String r0 = r9.f54744c
            L_0x0073:
                r1.append(r0)
                java.lang.String r7 = r1.toString()
                java.lang.String r3 = "wallet_money_transfer"
                java.lang.String r4 = "mpin_not_set"
                java.lang.String r5 = "/money-transfer/payment"
                java.lang.String r6 = "api_response_failure"
                net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.W
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                return
            L_0x008f:
                if (r1 != 0) goto L_0x0092
                return
            L_0x0092:
                int r1 = r1.intValue()
                if (r1 != 0) goto L_0x0134
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransfer.viewmodel.e$d r9 = (net.one97.paytm.moneytransfer.viewmodel.e.d) r9
                if (r9 == 0) goto L_0x00a2
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = r9.f54742a
                if (r9 != 0) goto L_0x00a7
            L_0x00a2:
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = new net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount
                r9.<init>()
            L_0x00a7:
                java.lang.String r1 = r9.getIfsc()
                if (r1 == 0) goto L_0x0134
                net.one97.paytm.moneytransfer.view.fragments.n r1 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.W
                if (r1 == 0) goto L_0x00c0
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00c0
                java.lang.String r1 = r1.getIfsc()
                goto L_0x00c1
            L_0x00c0:
                r1 = r0
            L_0x00c1:
                java.lang.String r3 = r9.getIfsc()
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                if (r1 == 0) goto L_0x0134
                net.one97.paytm.moneytransfer.view.fragments.n r1 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.W
                if (r1 == 0) goto L_0x00dd
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00dd
                java.lang.String r0 = r1.getAccRefId()
            L_0x00dd:
                java.lang.String r1 = r9.getAccRefId()
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x0134
                boolean r0 = r9.isMpinSet()
                if (r0 == 0) goto L_0x0114
                net.one97.paytm.moneytransfer.view.fragments.n r0 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.W
                if (r0 == 0) goto L_0x00f8
                r0.setDebitBank(r9)
            L_0x00f8:
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                r9.v()
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
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
            L_0x0114:
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.W
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_success"
                java.lang.String r5 = "mpin_still_not_set"
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
            L_0x0134:
                return
            L_0x0135:
                net.one97.paytm.moneytransfer.view.fragments.n r9 = r8.f54574a
                net.one97.paytm.moneytransfer.view.fragments.n.i(r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.r.onChanged(java.lang.Object):void");
        }
    }

    static final class s<T> implements androidx.lifecycle.z<ArrayList<UpiProfileDefaultBank>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54575a;

        s(n nVar) {
            this.f54575a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f54575a.aG = (ArrayList) obj;
        }
    }

    static final class t<T> implements androidx.lifecycle.z<ArrayList<UpiProfileDefaultBank>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54576a;

        t(n nVar) {
            this.f54576a = nVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            if (kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) java.lang.Boolean.TRUE) != false) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r3) {
            /*
                r2 = this;
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                if (r3 == 0) goto L_0x002f
                net.one97.paytm.moneytransfer.view.fragments.n r0 = r2.f54576a
                net.one97.paytm.moneytransfer.viewmodel.b r0 = net.one97.paytm.moneytransfer.view.fragments.n.a((net.one97.paytm.moneytransfer.view.fragments.n) r0)
                r1 = 0
                if (r0 == 0) goto L_0x0010
                java.lang.Boolean r0 = r0.f54678c
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                if (r0 == 0) goto L_0x0025
                net.one97.paytm.moneytransfer.view.fragments.n r0 = r2.f54576a
                net.one97.paytm.moneytransfer.viewmodel.b r0 = net.one97.paytm.moneytransfer.view.fragments.n.a((net.one97.paytm.moneytransfer.view.fragments.n) r0)
                if (r0 == 0) goto L_0x001d
                java.lang.Boolean r1 = r0.f54678c
            L_0x001d:
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x002f
            L_0x0025:
                net.one97.paytm.moneytransfer.view.fragments.n r0 = r2.f54576a
                net.one97.paytm.moneytransfer.view.fragments.n.a((net.one97.paytm.moneytransfer.view.fragments.n) r0, (java.util.ArrayList) r3)
                net.one97.paytm.moneytransfer.view.fragments.n r3 = r2.f54576a
                net.one97.paytm.moneytransfer.view.fragments.n.b((net.one97.paytm.moneytransfer.view.fragments.n) r3)
            L_0x002f:
                net.one97.paytm.moneytransfer.view.fragments.n r3 = r2.f54576a
                r3.O()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.t.onChanged(java.lang.Object):void");
        }
    }

    static final class u<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<b.C0979b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54577a;

        u(n nVar) {
            this.f54577a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            n nVar = this.f54577a;
            String str = null;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = o.f54588d[dVar.ordinal()];
                if (i2 == 1) {
                    Uri m = nVar.B;
                    if (m != null) {
                        str = m.getQueryParameter("pn");
                    }
                    if (TextUtils.isEmpty(str)) {
                        n.n(nVar);
                    }
                } else if (i2 == 2) {
                    n.o(nVar);
                    n.a(nVar, cVar);
                } else if (i2 == 3) {
                    n.o(nVar);
                    nVar.a(cVar.f54034c);
                }
            }
        }
    }

    public static final /* synthetic */ TextView F(n nVar) {
        TextView textView = nVar.q;
        if (textView == null) {
            kotlin.g.b.k.a("amountErrorTV");
        }
        return textView;
    }

    public static final /* synthetic */ CustomAmountTextInputEditText J(n nVar) {
        CustomAmountTextInputEditText customAmountTextInputEditText = nVar.f54548a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        return customAmountTextInputEditText;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.viewmodel.b a(n nVar) {
        net.one97.paytm.moneytransfer.viewmodel.b bVar = nVar.V;
        if (bVar == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        return bVar;
    }

    public static final /* synthetic */ View p(n nVar) {
        View view = nVar.az;
        if (view == null) {
            kotlin.g.b.k.a("mDetailsLayout");
        }
        return view;
    }

    public static final /* synthetic */ TextView q(n nVar) {
        TextView textView = nVar.j;
        if (textView == null) {
            kotlin.g.b.k.a("receiverIFSC");
        }
        return textView;
    }

    public static final /* synthetic */ TextView r(n nVar) {
        TextView textView = nVar.f54555i;
        if (textView == null) {
            kotlin.g.b.k.a("receiverVPAOrAccountNumber");
        }
        return textView;
    }

    public static final /* synthetic */ LinearLayout s(n nVar) {
        LinearLayout linearLayout = nVar.ay;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mToolbarTitleLayout");
        }
        return linearLayout;
    }

    public static final /* synthetic */ TextView t(n nVar) {
        TextView textView = nVar.ax;
        if (textView == null) {
            kotlin.g.b.k.a("mToolbarSubTitle");
        }
        return textView;
    }

    public static final /* synthetic */ TextView u(n nVar) {
        TextView textView = nVar.aw;
        if (textView == null) {
            kotlin.g.b.k.a("mToolbarTitle");
        }
        return textView;
    }

    public static final /* synthetic */ View w(n nVar) {
        View view = nVar.aj;
        if (view == null) {
            kotlin.g.b.k.a("selectedAccCardView");
        }
        return view;
    }

    public static final /* synthetic */ TextView x(n nVar) {
        TextView textView = nVar.s;
        if (textView == null) {
            kotlin.g.b.k.a("addMessageTV");
        }
        return textView;
    }

    public static final /* synthetic */ View y(n nVar) {
        View view = nVar.x;
        if (view == null) {
            kotlin.g.b.k.a("mCommentsUnderline");
        }
        return view;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static n a(Bundle bundle) {
            kotlin.g.b.k.c(bundle, "bundle");
            n nVar = new n();
            nVar.setArguments(bundle);
            return nVar;
        }
    }

    /* JADX WARNING: type inference failed for: r0v277, types: [android.os.Parcelable] */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x0c20, code lost:
        if (r3 != false) goto L_0x0c24;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x0d40  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0d68  */
    /* JADX WARNING: Removed duplicated region for block: B:606:0x0d80  */
    /* JADX WARNING: Removed duplicated region for block: B:609:0x0d87  */
    /* JADX WARNING: Removed duplicated region for block: B:627:0x0dce  */
    /* JADX WARNING: Removed duplicated region for block: B:652:0x0e25  */
    /* JADX WARNING: Removed duplicated region for block: B:667:0x0e58  */
    /* JADX WARNING: Removed duplicated region for block: B:687:0x0e9b  */
    /* JADX WARNING: Removed duplicated region for block: B:694:0x0eb2  */
    /* JADX WARNING: Removed duplicated region for block: B:696:0x0eb9  */
    /* JADX WARNING: Removed duplicated region for block: B:699:0x0ec7  */
    /* JADX WARNING: Removed duplicated region for block: B:706:0x0ef0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r32, android.view.ViewGroup r33, android.os.Bundle r34) {
        /*
            r31 = this;
            r1 = r31
            r0 = r32
            java.lang.String r2 = "inflater"
            kotlin.g.b.k.c(r0, r2)
            int r2 = net.one97.paytm.moneytransfer.R.layout.money_tranfer_fragment
            r3 = 0
            r4 = r33
            android.view.View r2 = r0.inflate(r2, r4, r3)
            r0 = r1
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0)
            java.lang.Class<net.one97.paytm.moneytransfer.viewmodel.e> r4 = net.one97.paytm.moneytransfer.viewmodel.e.class
            androidx.lifecycle.ai r0 = r0.a(r4)
            net.one97.paytm.moneytransfer.viewmodel.e r0 = (net.one97.paytm.moneytransfer.viewmodel.e) r0
            r1.U = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 != 0) goto L_0x002c
            kotlin.g.b.k.a()
        L_0x002c:
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0)
            java.lang.Class<net.one97.paytm.moneytransfer.viewmodel.b> r4 = net.one97.paytm.moneytransfer.viewmodel.b.class
            androidx.lifecycle.ai r0 = r0.a(r4)
            java.lang.String r4 = "ViewModelProviders.of(ac…ityViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.moneytransfer.viewmodel.b r0 = (net.one97.paytm.moneytransfer.viewmodel.b) r0
            r1.V = r0
            java.lang.String r0 = "view"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.tv_receiver_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.f54554h = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_acc_number
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.tv_receiver_acc_number)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.f54555i = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.edit_p2b_comment
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.edit_p2b_comment)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.upi.util.CommentsEditText r0 = (net.one97.paytm.upi.util.CommentsEditText) r0
            r1.p = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_ifsc
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.tv_receiver_ifsc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.j = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankImageView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.bankImageView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.n = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.shimmer_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.shimmer_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.upi.common.ShimmerFrameLayout r0 = (net.one97.paytm.upi.common.ShimmerFrameLayout) r0
            r1.k = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_et
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.amount_et)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = (net.one97.paytm.upi.common.CustomAmountTextInputEditText) r0
            r1.f54548a = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_error_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.amount_error_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.q = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.rupee_prefix_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r4 = "view.findViewById(R.id.rupee_prefix_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.r = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.iv_back_button1
            android.view.View r0 = r2.findViewById(r0)
            r4 = r1
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.selectedBankDownArrowTV
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.selectedBankDownArrowTV)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.aE = r0
            android.widget.ImageView r0 = r1.aE
            if (r0 != 0) goto L_0x00ef
            java.lang.String r5 = "selectedBankDownArrowTV"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00ef:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.txt_add_desc
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.txt_add_desc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.s = r0
            android.widget.TextView r0 = r1.s
            if (r0 != 0) goto L_0x010a
            java.lang.String r5 = "addMessageTV"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x010a:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.headerBankLogoName
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.headerBankLogoName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.l = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ll_uni_pay
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById<TextView>(R.id.ll_uni_pay)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.m = r0
            android.widget.TextView r0 = r1.m
            if (r0 != 0) goto L_0x0134
            java.lang.String r5 = "mProceedPayment"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0134:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.tranfer_from_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tranfer_from_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.t = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.transfered_from
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.transfered_from)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.u = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.accountLoadingLayout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.accountLoadingLayout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.aB = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.accountsLoader
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.accountsLoader)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r1.aD = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.mt_selected_account_cv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.mt_selected_account_cv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.aj = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_selected_source_label
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tv_selected_source_label)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.an = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ll_pay_wrapper
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.ll_pay_wrapper)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.ak = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.check_balance_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.check_balance_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.al = r0
            android.widget.TextView r0 = r1.al
            if (r0 != 0) goto L_0x01b4
            java.lang.String r5 = "checkBalanceTV"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x01b4:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.check_balance_loader
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.check_balance_loader)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r1.am = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.source_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.source_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.ao = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.card_view_button
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.card_view_button)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.ap = r0
            android.widget.TextView r0 = r1.ap
            if (r0 != 0) goto L_0x01ed
            java.lang.String r5 = "mCardViewProceed"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x01ed:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.sender_bank_iv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.sender_bank_iv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.aq = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.arrow_iv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.arrow_iv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.au = r0
            android.widget.ImageView r0 = r1.au
            if (r0 != 0) goto L_0x0217
            java.lang.String r5 = "mCardToggleDownIv"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0217:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.rl_uni_selected_payment_inst
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.r…ni_selected_payment_inst)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1.o = r0
            android.widget.RelativeLayout r0 = r1.o
            if (r0 != 0) goto L_0x0232
            java.lang.String r5 = "mOpenBottomSheetRlv"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0232:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.v_uni_et_sep_2
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.v_uni_et_sep_2)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.x = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.v_uni_et_sep_1
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.v_uni_et_sep_1)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.w = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankarrow
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.bankarrow)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.ar = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankDetailsContainer
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.bankDetailsContainer)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.as = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankNameContainer
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.bankNameContainer)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.at = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_scrollview
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.amount_scrollview)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            r1.av = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.lnr_details_layout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.lnr_details_layout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.az = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.title_layout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.title_layout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.ay = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.toolbar_title
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.toolbar_title)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.aw = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.toolbar_subtitle
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.toolbar_subtitle)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.ax = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ivVerificationLogo
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.ivVerificationLogo)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.v = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.accountTypeCurrent
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.accountTypeCurrent)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.aC = r0
            android.widget.ImageView r0 = r1.v
            if (r0 != 0) goto L_0x02e6
            java.lang.String r5 = "ivVerificationLogo"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x02e6:
            r0.setOnClickListener(r4)
            int r0 = net.one97.paytm.moneytransfer.R.id.tvbhimUpi
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tvbhimUpi)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.aA = r0
            android.widget.TextView r0 = r1.aA
            if (r0 != 0) goto L_0x0301
            java.lang.String r5 = "tvbhimUpi"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0301:
            r0.setOnClickListener(r4)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            java.lang.String r4 = "amountET"
            if (r0 != 0) goto L_0x030d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x030d:
            java.lang.String r5 = ""
            r0.setPrefix(r5)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0319
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0319:
            r6 = 7
            r0.setMaxDigitsBeforeDecimalPoint(r6)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0324
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0324:
            net.one97.paytm.moneytransfer.view.fragments.n$z r6 = r1.aP
            android.text.TextWatcher r6 = (android.text.TextWatcher) r6
            r0.addTextChangedListener(r6)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0332
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0332:
            net.one97.paytm.moneytransfer.view.fragments.n$c r6 = new net.one97.paytm.moneytransfer.view.fragments.n$c
            r6.<init>(r1)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r0.setOnClickListener(r6)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            java.lang.String r6 = "messageET"
            if (r0 != 0) goto L_0x0345
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0345:
            net.one97.paytm.moneytransfer.view.fragments.n$d r7 = new net.one97.paytm.moneytransfer.view.fragments.n$d
            r7.<init>(r1)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r0.setOnClickListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0356
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0356:
            net.one97.paytm.moneytransfer.view.fragments.n$e r7 = new net.one97.paytm.moneytransfer.view.fragments.n$e
            r7.<init>(r1)
            android.widget.TextView$OnEditorActionListener r7 = (android.widget.TextView.OnEditorActionListener) r7
            r0.setOnEditorActionListener(r7)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            if (r0 != 0) goto L_0x0367
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0367:
            net.one97.paytm.moneytransfer.view.fragments.n$f r7 = new net.one97.paytm.moneytransfer.view.fragments.n$f
            r7.<init>(r1)
            android.widget.TextView$OnEditorActionListener r7 = (android.widget.TextView.OnEditorActionListener) r7
            r0.setOnEditorActionListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0378
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0378:
            net.one97.paytm.moneytransfer.view.fragments.n$g r7 = new net.one97.paytm.moneytransfer.view.fragments.n$g
            r7.<init>(r1)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText$EditTextImeBackListener r7 = (net.one97.paytm.upi.common.CustomAmountTextInputEditText.EditTextImeBackListener) r7
            r0.setOnEditTextImeBackListener(r7)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            if (r0 != 0) goto L_0x0389
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0389:
            net.one97.paytm.moneytransfer.view.fragments.n$h r7 = new net.one97.paytm.moneytransfer.view.fragments.n$h
            r7.<init>(r1)
            net.one97.paytm.upi.util.CommentsEditText$EditTextImeBackListener r7 = (net.one97.paytm.upi.util.CommentsEditText.EditTextImeBackListener) r7
            r0.setOnEditTextImeBackListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x039a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x039a:
            r7 = r1
            android.view.View$OnFocusChangeListener r7 = (android.view.View.OnFocusChangeListener) r7
            r0.setOnFocusChangeListener(r7)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            if (r0 != 0) goto L_0x03a7
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x03a7:
            net.one97.paytm.moneytransfer.view.fragments.n$i r7 = new net.one97.paytm.moneytransfer.view.fragments.n$i
            r7.<init>(r1)
            android.view.View$OnFocusChangeListener r7 = (android.view.View.OnFocusChangeListener) r7
            r0.setOnFocusChangeListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x03b8
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03b8:
            r0.requestFocus()
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x03c2
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03c2:
            android.widget.EditText r0 = (android.widget.EditText) r0
            androidx.fragment.app.FragmentActivity r7 = r31.getActivity()
            android.app.Activity r7 = (android.app.Activity) r7
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r0, (android.app.Activity) r7)
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.b()
            r7 = 8
            if (r0 == 0) goto L_0x03e5
            int r0 = net.one97.paytm.moneytransfer.R.id.motif_iv_bg
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r8 = "view.findViewById<ImageView>(R.id.motif_iv_bg)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r7)
        L_0x03e5:
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.b()
            if (r0 == 0) goto L_0x03fb
            int r0 = net.one97.paytm.moneytransfer.R.id.rel_bottom
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r8 = "view.findViewById<RelativeLayout>(R.id.rel_bottom)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setVisibility(r7)
        L_0x03fb:
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            boolean r8 = r0 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r8 != 0) goto L_0x0404
            r0 = 0
        L_0x0404:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r0 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r0
            if (r0 == 0) goto L_0x040d
            boolean r0 = r0.o()
            goto L_0x040e
        L_0x040d:
            r0 = 0
        L_0x040e:
            java.lang.String r8 = "moneyTransferActivityViewModel"
            if (r0 == 0) goto L_0x045c
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0419
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0419:
            if (r0 == 0) goto L_0x0440
            net.one97.paytm.moneytransfer.viewmodel.b$c r10 = new net.one97.paytm.moneytransfer.viewmodel.b$c
            r10.<init>(r0)
            java.util.concurrent.Callable r10 = (java.util.concurrent.Callable) r10
            io.reactivex.rxjava3.a.y r10 = io.reactivex.rxjava3.a.y.a(r10)
            io.reactivex.rxjava3.a.x r11 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.y r10 = r10.b((io.reactivex.rxjava3.a.x) r11)
            io.reactivex.rxjava3.a.x r11 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.y r10 = r10.a((io.reactivex.rxjava3.a.x) r11)
            net.one97.paytm.moneytransfer.viewmodel.b$d r11 = new net.one97.paytm.moneytransfer.viewmodel.b$d
            r11.<init>(r0)
            io.reactivex.rxjava3.a.aa r11 = (io.reactivex.rxjava3.a.aa) r11
            r10.c(r11)
        L_0x0440:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0447
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0447:
            if (r0 == 0) goto L_0x045c
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.p2p.theme.DealsEntity>> r0 = r0.t
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x045c
            r10 = r1
            androidx.lifecycle.q r10 = (androidx.lifecycle.q) r10
            net.one97.paytm.moneytransfer.view.fragments.n$b r11 = new net.one97.paytm.moneytransfer.view.fragments.n$b
            r11.<init>(r1, r2)
            androidx.lifecycle.z r11 = (androidx.lifecycle.z) r11
            r0.observe(r10, r11)
        L_0x045c:
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0467
            android.content.Intent r0 = r0.getIntent()
            goto L_0x0468
        L_0x0467:
            r0 = 0
        L_0x0468:
            java.lang.String r10 = "username"
            java.lang.String r11 = "receiverName"
            java.lang.String r12 = "vpa"
            java.lang.String r13 = "receiverIFSC"
            java.lang.String r14 = "java.lang.String.format(format, *args)"
            java.lang.String r15 = "bankIV"
            r9 = 1
            if (r0 == 0) goto L_0x08eb
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0488
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0488
            android.net.Uri r0 = r0.getData()
            goto L_0x0489
        L_0x0488:
            r0 = 0
        L_0x0489:
            if (r0 == 0) goto L_0x08eb
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x049c
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x049c
            android.net.Uri r0 = r0.getData()
            goto L_0x049d
        L_0x049c:
            r0 = 0
        L_0x049d:
            r1.B = r0
            r1.F = r9
            net.one97.paytm.upi.util.UpiConstants$MoneyTransferPaymentOption r0 = net.one97.paytm.upi.util.UpiConstants.MoneyTransferPaymentOption.UPI
            r1.z = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x04b8
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x04b8
            java.lang.String r5 = "is_from_scan"
            boolean r0 = r0.getBooleanExtra(r5, r3)
            goto L_0x04b9
        L_0x04b8:
            r0 = 0
        L_0x04b9:
            r1.H = r0
            android.net.Uri r0 = r1.B
            if (r0 == 0) goto L_0x08e4
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            java.lang.String r0 = net.one97.paytm.moneytransfer.utils.m.i(r0)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            r1.B = r0     // Catch:{ UnsupportedEncodingException -> 0x08db }
            android.net.Uri r0 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x08db }
            if (r0 == 0) goto L_0x04d8
            java.lang.String r5 = "pa"
            java.lang.String r0 = r0.getQueryParameter(r5)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            goto L_0x04d9
        L_0x04d8:
            r0 = 0
        L_0x04d9:
            android.net.Uri r5 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x08db }
            if (r5 == 0) goto L_0x04e4
            java.lang.String r7 = "am"
            java.lang.String r5 = r5.getQueryParameter(r7)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            goto L_0x04e5
        L_0x04e4:
            r5 = 0
        L_0x04e5:
            android.net.Uri r7 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x08db }
            if (r7 == 0) goto L_0x04f0
            java.lang.String r3 = "pn"
            java.lang.String r3 = r7.getQueryParameter(r3)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            goto L_0x04f1
        L_0x04f0:
            r3 = 0
        L_0x04f1:
            android.net.Uri r7 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x08db }
            if (r7 == 0) goto L_0x04fc
            java.lang.String r9 = "mam"
            java.lang.String r9 = r7.getQueryParameter(r9)     // Catch:{ UnsupportedEncodingException -> 0x08db }
            goto L_0x04fd
        L_0x04fc:
            r9 = 0
        L_0x04fd:
            android.net.Uri r7 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x08db }
            if (r7 == 0) goto L_0x050d
            r17 = r2
            java.lang.String r2 = "tid"
            java.lang.String r2 = r7.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x050a }
            goto L_0x0510
        L_0x050a:
            r0 = move-exception
            goto L_0x08de
        L_0x050d:
            r17 = r2
            r2 = 0
        L_0x0510:
            android.net.Uri r7 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x050a }
            if (r7 == 0) goto L_0x0520
            r18 = r8
            java.lang.String r8 = "tn"
            java.lang.String r7 = r7.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0523
        L_0x051d:
            r0 = move-exception
            goto L_0x08e0
        L_0x0520:
            r18 = r8
            r7 = 0
        L_0x0523:
            android.net.Uri r8 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r8 == 0) goto L_0x0530
            r19 = r10
            java.lang.String r10 = "mc"
            java.lang.String r8 = r8.getQueryParameter(r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0533
        L_0x0530:
            r19 = r10
            r8 = 0
        L_0x0533:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x0540
            r20 = r8
            java.lang.String r8 = "url"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0543
        L_0x0540:
            r20 = r8
            r8 = 0
        L_0x0543:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x0550
            r21 = r8
            java.lang.String r8 = "tr"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0553
        L_0x0550:
            r21 = r8
            r8 = 0
        L_0x0553:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x055f
            r22 = r8
            java.lang.String r8 = "mode"
            r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0561
        L_0x055f:
            r22 = r8
        L_0x0561:
            android.net.Uri r8 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r8 == 0) goto L_0x056a
            java.lang.String r10 = "sign"
            r8.getQueryParameter(r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x056a:
            android.net.Uri r8 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r8 == 0) goto L_0x0575
            java.lang.String r10 = "orgid"
            java.lang.String r8 = r8.getQueryParameter(r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0576
        L_0x0575:
            r8 = 0
        L_0x0576:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x0583
            r23 = r8
            java.lang.String r8 = "mid"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0586
        L_0x0583:
            r23 = r8
            r8 = 0
        L_0x0586:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x0593
            r24 = r8
            java.lang.String r8 = "msid"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0596
        L_0x0593:
            r24 = r8
            r8 = 0
        L_0x0596:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x05a3
            r25 = r8
            java.lang.String r8 = "mtid"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x05a6
        L_0x05a3:
            r25 = r8
            r8 = 0
        L_0x05a6:
            android.net.Uri r10 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x05b3
            r26 = r8
            java.lang.String r8 = "bharatqr"
            java.lang.String r8 = r10.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x05b6
        L_0x05b3:
            r26 = r8
            r8 = 0
        L_0x05b6:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 != 0) goto L_0x0720
            java.lang.String r10 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r10 = "uriVPAOrAccount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r10 = ".ifsc.npci"
            r27 = r8
            r8 = 1
            boolean r10 = kotlin.m.p.c(r0, r10, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r10 == 0) goto L_0x06ad
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = "@"
            r28 = r2
            r2 = 6
            r29 = r9
            r9 = 0
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.String) r8, (int) r9, (boolean) r9, (int) r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r8 = 1
            int r2 = r2 + r8
            r8 = r0
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r10 = ".ifsc.npci"
            r30 = r4
            r4 = 6
            int r4 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.String) r10, (int) r9, (boolean) r9, (int) r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r2 = r0.substring(r2, r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = "@"
            r9 = 6
            r10 = 0
            int r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String) r8, (int) r10, (boolean) r10, (int) r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r0 = r0.substring(r10, r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r4 = r1.j     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 != 0) goto L_0x0616
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0616:
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            int r8 = net.one97.paytm.moneytransfer.R.string.money_transfer_ifsc_with_placeholder_without_bold     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = r1.getString(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r9 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r16 = 0
            r10[r16] = r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = java.lang.String.format(r8, r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r4.setText(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r4 = r1.j     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 != 0) goto L_0x0641
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0641:
            r8 = 0
            r4.setVisibility(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r4 = r1.l     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 != 0) goto L_0x064e
            java.lang.String r8 = "headerBankLogoName"
            kotlin.g.b.k.a((java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x064e:
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            int r8 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r9 = net.one97.paytm.upi.util.UpiUtils.maskNumber(r0)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r13 = 4
            java.lang.String r9 = net.one97.paytm.upi.util.UpiAppUtils.insertSpaceAfterInterval(r9, r13)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r13 = 0
            r10[r13] = r9     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = r1.getString(r8, r10)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r9 = "getString(R.string.money…umber(accountNumber), 4))"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.Object[] r9 = new java.lang.Object[r13]     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r13)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r4.setText(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.ImageView r4 = r1.n     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 != 0) goto L_0x0683
            kotlin.g.b.k.a((java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0683:
            androidx.fragment.app.FragmentActivity r8 = r31.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r4, (java.lang.String) r2, (android.content.Context) r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.os.Bundle r4 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 == 0) goto L_0x0699
            java.lang.String r8 = "ifsc"
            r4.putString(r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0699:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r1.y = r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.os.Bundle r2 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x06a8
            r2.putString(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x06a8:
            r31.m()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0728
        L_0x06ad:
            r28 = r2
            r30 = r4
            r29 = r9
            r2 = 1
            r1.T = r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r1.y = r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r2 = r1.l     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x06c3
            java.lang.String r4 = "headerBankLogoName"
            kotlin.g.b.k.a((java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x06c3:
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            int r4 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r8 = 0
            r9[r8] = r0     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r4 = r1.getString(r4, r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r9 = "getString(R.string.money…ut_bold, uriVPAOrAccount)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r4 = java.lang.String.format(r4, r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r2.setText(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r2 = 1098907648(0x41800000, float:16.0)
            androidx.fragment.app.FragmentActivity r4 = r31.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            int r2 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r2, r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.ImageView r4 = r1.n     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r4 != 0) goto L_0x06fb
            kotlin.g.b.k.a((java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x06fb:
            r4.setPadding(r2, r2, r2, r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.ImageView r2 = r1.n     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0705
            kotlin.g.b.k.a((java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0705:
            java.lang.String r4 = "UPI"
            androidx.fragment.app.FragmentActivity r8 = r31.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r2, (java.lang.String) r4, (android.content.Context) r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r2 = r1.j     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0717
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0717:
            r4 = 8
            r2.setVisibility(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r31.l()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0728
        L_0x0720:
            r28 = r2
            r30 = r4
            r27 = r8
            r29 = r9
        L_0x0728:
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0742
            java.lang.String r3 = net.one97.paytm.moneytransfer.utils.m.l(r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.widget.TextView r2 = r1.f54554h     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x073c
            kotlin.g.b.k.a((java.lang.String) r11)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x073c:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r2.setText(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0742:
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0772
            java.lang.String r7 = net.one97.paytm.moneytransfer.utils.m.l(r7)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.p     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0756
            kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0756:
            r4 = r7
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r2.setText(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.p     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0763
            kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0763:
            r4 = 0
            r2.setVisibility(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.p     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x076e
            kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x076e:
            r4 = 0
            r2.setEnabled(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0772:
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0792
            r1.f((java.lang.String) r5)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r1.aa = r5     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f54548a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x0787
            kotlin.g.b.k.a((java.lang.String) r30)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0787:
            android.widget.EditText r2 = (android.widget.EditText) r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            androidx.fragment.app.FragmentActivity r4 = r31.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ UnsupportedEncodingException -> 0x051d }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r2, (android.app.Activity) r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0792:
            r9 = r29
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x07a1
            r9 = r29
            r1.Z = r9     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x07a3
        L_0x07a1:
            r9 = r29
        L_0x07a3:
            java.lang.String r2 = r1.aa     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = net.one97.paytm.moneytransfer.utils.m.h(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x07bf
            java.lang.String r2 = r1.Z     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = net.one97.paytm.moneytransfer.utils.m.h(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x07bf
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f54548a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x07ba
            kotlin.g.b.k.a((java.lang.String) r30)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07ba:
            r4 = 0
            r2.setEnabled(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x07ca
        L_0x07bf:
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f54548a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x07c6
            kotlin.g.b.k.a((java.lang.String) r30)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07c6:
            r4 = 1
            r2.setEnabled(r4)     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07ca:
            r2 = r28
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 != 0) goto L_0x07d8
            r2 = r28
            r1.ac = r2     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07d8:
            android.os.Bundle r2 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x07e5
            r4 = r19
            r2.putString(r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07e5:
            android.os.Bundle r2 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x07f2
            java.lang.String r3 = "key_amount"
            r2.putString(r3, r5)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07f2:
            android.os.Bundle r2 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x07ff
            java.lang.String r3 = "key_comment"
            r2.putString(r3, r7)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x07ff:
            android.os.Bundle r2 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r2 == 0) goto L_0x080a
            r2.putString(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x080a:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0819
            java.lang.String r2 = "extra_key_ref_url"
            r8 = r21
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0819:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0828
            java.lang.String r2 = "extra_key_ref_id"
            r8 = r22
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0828:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0837
            java.lang.String r2 = "extra_key_mcc"
            r8 = r20
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0837:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0844
            java.lang.String r2 = "extra_key_upi_min_amount"
            r0.putString(r2, r9)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0844:
            boolean r0 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0858
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0867
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "01"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x0867
        L_0x0858:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x0867
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "04"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x0867:
            r8 = r27
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x051d }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 != 0) goto L_0x088b
            java.lang.String r0 = "1"
            r8 = r27
            r2 = 0
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r2)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x088b
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x088b
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "03"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x088b:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x089e
            java.lang.String r2 = "extra_key_intent_sign"
            android.net.Uri r3 = r1.B     // Catch:{ UnsupportedEncodingException -> 0x051d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x089e:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x08ad
            java.lang.String r2 = "extra_key_intent_orgid"
            r8 = r23
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x08ad:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x08bc
            java.lang.String r2 = "extra_key_intent_mid"
            r8 = r24
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x08bc:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x08cb
            java.lang.String r2 = "extra_key_intent_msid"
            r8 = r25
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
        L_0x08cb:
            android.os.Bundle r0 = r31.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x051d }
            if (r0 == 0) goto L_0x08e8
            java.lang.String r2 = "extra_key_intent_mtid"
            r8 = r26
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x051d }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x051d }
            goto L_0x08e8
        L_0x08db:
            r0 = move-exception
            r17 = r2
        L_0x08de:
            r18 = r8
        L_0x08e0:
            r0.printStackTrace()
            goto L_0x08e8
        L_0x08e4:
            r17 = r2
            r18 = r8
        L_0x08e8:
            r9 = 0
            goto L_0x0d34
        L_0x08eb:
            r17 = r2
            r30 = r4
            r18 = r8
            r4 = r10
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0903
            java.lang.String r2 = "isVPA"
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            goto L_0x0904
        L_0x0903:
            r9 = 0
        L_0x0904:
            if (r9 != 0) goto L_0x0909
            kotlin.g.b.k.a()
        L_0x0909:
            boolean r0 = r9.booleanValue()
            r1.T = r0
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x091c
            java.lang.String r2 = "upi_p2p_payment_route"
            java.lang.String r9 = r0.getString(r2)
            goto L_0x091d
        L_0x091c:
            r9 = 0
        L_0x091d:
            r1.ah = r9
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x092c
            java.lang.String r2 = "phone_number"
            java.lang.String r9 = r0.getString(r2)
            goto L_0x092d
        L_0x092c:
            r9 = 0
        L_0x092d:
            r1.ag = r9
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x093c
            java.lang.String r2 = "user_upi_details"
            java.io.Serializable r9 = r0.getSerializable(r2)
            goto L_0x093d
        L_0x093c:
            r9 = 0
        L_0x093d:
            boolean r0 = r9 instanceof net.one97.paytm.upi.common.upi.UpiProfileDefaultBank
            if (r0 != 0) goto L_0x0942
            r9 = 0
        L_0x0942:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r9 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r9
            r1.W = r9
            boolean r0 = r1.T
            java.lang.String r2 = "picture"
            if (r0 == 0) goto L_0x0a3b
            r3 = 0
            r1.K = r3
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            r1.y = r0
            android.widget.TextView r0 = r1.f54554h
            if (r0 != 0) goto L_0x095a
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x095a:
            android.os.Bundle r3 = r31.getArguments()
            if (r3 == 0) goto L_0x0965
            java.lang.String r9 = r3.getString(r4)
            goto L_0x0966
        L_0x0965:
            r9 = 0
        L_0x0966:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            android.widget.TextView r0 = r1.l
            if (r0 != 0) goto L_0x0974
            java.lang.String r3 = "headerBankLogoName"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0974:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "getString(R.string.money…ransfer_upi_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 1
            java.lang.Object[] r7 = new java.lang.Object[r4]
            android.os.Bundle r8 = r31.getArguments()
            if (r8 == 0) goto L_0x0990
            java.lang.String r9 = r8.getString(r12)
            r8 = 0
            goto L_0x0992
        L_0x0990:
            r8 = 0
            r9 = 0
        L_0x0992:
            r7[r8] = r9
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r4)
            java.lang.String r3 = java.lang.String.format(r3, r7)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.widget.TextView r0 = r1.j
            if (r0 != 0) goto L_0x09ab
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x09ab:
            r3 = 8
            r0.setVisibility(r3)
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x09bb
            java.lang.String r9 = r0.getString(r2)
            goto L_0x09bc
        L_0x09bb:
            r9 = 0
        L_0x09bc:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x09c9
            int r0 = r9.length()
            if (r0 != 0) goto L_0x09c7
            goto L_0x09c9
        L_0x09c7:
            r0 = 0
            goto L_0x09ca
        L_0x09c9:
            r0 = 1
        L_0x09ca:
            if (r0 == 0) goto L_0x09f5
            r0 = 1098907648(0x41800000, float:16.0)
            androidx.fragment.app.FragmentActivity r2 = r31.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            int r0 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r0, r2)
            android.widget.ImageView r2 = r1.n
            if (r2 != 0) goto L_0x09df
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x09df:
            r2.setPadding(r0, r0, r0, r0)
            android.widget.ImageView r0 = r1.n
            if (r0 != 0) goto L_0x09e9
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x09e9:
            androidx.fragment.app.FragmentActivity r2 = r31.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = "UPI"
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r0, (java.lang.String) r3, (android.content.Context) r2)
            goto L_0x0a35
        L_0x09f5:
            android.widget.ImageView r0 = r1.n
            if (r0 != 0) goto L_0x09fc
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x09fc:
            r3 = 0
            r0.setPadding(r3, r3, r3, r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            android.os.Bundle r3 = r31.getArguments()
            if (r3 == 0) goto L_0x0a0f
            java.lang.String r9 = r3.getString(r2)
            goto L_0x0a10
        L_0x0a0f:
            r9 = 0
        L_0x0a10:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r9)
            net.one97.paytm.upi.util.CircleTransform r2 = new net.one97.paytm.upi.util.CircleTransform
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.b((int) r2)
            android.widget.ImageView r2 = r1.n
            if (r2 != 0) goto L_0x0a32
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0a32:
            r0.a((android.widget.ImageView) r2)
        L_0x0a35:
            r31.l()
            r8 = 1
            goto L_0x0b7e
        L_0x0a3b:
            net.one97.paytm.moneytransfer.d.d$a r0 = net.one97.paytm.moneytransfer.d.d.f53996a
            net.one97.paytm.moneytransfer.d.d r0 = net.one97.paytm.moneytransfer.d.d.a.a()
            net.one97.paytm.moneytransfer.d.a r0 = net.one97.paytm.moneytransfer.d.d.b(r0)
            androidx.fragment.app.FragmentActivity r3 = r31.getActivity()
            if (r3 != 0) goto L_0x0a4e
            kotlin.g.b.k.a()
        L_0x0a4e:
            java.lang.String r7 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            android.content.Context r3 = (android.content.Context) r3
            boolean r0 = r0.b((android.content.Context) r3)
            r1.K = r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            r1.y = r0
            android.widget.TextView r0 = r1.f54554h
            if (r0 != 0) goto L_0x0a66
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0a66:
            android.os.Bundle r3 = r31.getArguments()
            if (r3 == 0) goto L_0x0a71
            java.lang.String r9 = r3.getString(r4)
            goto L_0x0a72
        L_0x0a71:
            r9 = 0
        L_0x0a72:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            android.widget.TextView r0 = r1.f54555i
            if (r0 != 0) goto L_0x0a80
            java.lang.String r3 = "receiverVPAOrAccountNumber"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0a80:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 1
            java.lang.Object[] r7 = new java.lang.Object[r4]
            android.os.Bundle r8 = r31.getArguments()
            if (r8 == 0) goto L_0x0a9b
            java.lang.String r9 = r8.getString(r12)
            goto L_0x0a9c
        L_0x0a9b:
            r9 = 0
        L_0x0a9c:
            java.lang.String r8 = net.one97.paytm.upi.util.UpiUtils.maskAccNumberWithSpace(r9)
            r9 = 0
            r7[r9] = r8
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r4)
            java.lang.String r3 = java.lang.String.format(r3, r7)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0ac0
            java.lang.String r3 = "ifsc"
            java.lang.String r9 = r0.getString(r3)
            goto L_0x0ac1
        L_0x0ac0:
            r9 = 0
        L_0x0ac1:
            android.widget.TextView r0 = r1.j
            if (r0 != 0) goto L_0x0ac8
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0ac8:
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.s
            if (r0 != 0) goto L_0x0ad5
            java.lang.String r4 = "addMessageTV"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0ad5:
            r0.setVisibility(r3)
            android.view.View r0 = r1.w
            if (r0 != 0) goto L_0x0ae1
            java.lang.String r4 = "mAmountUnderline"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0ae1:
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.j
            if (r0 != 0) goto L_0x0aeb
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0aeb:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_ifsc_with_placeholder_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r8 = 1
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r7 = 0
            r4[r7] = r9
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r8)
            java.lang.String r3 = java.lang.String.format(r3, r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0b19
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0b1a
        L_0x0b19:
            r0 = 0
        L_0x0b1a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0b27
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0b25
            goto L_0x0b27
        L_0x0b25:
            r0 = 0
            goto L_0x0b28
        L_0x0b27:
            r0 = 1
        L_0x0b28:
            if (r0 == 0) goto L_0x0b3b
            android.widget.ImageView r0 = r1.n
            if (r0 != 0) goto L_0x0b31
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0b31:
            androidx.fragment.app.FragmentActivity r2 = r31.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r0, (java.lang.String) r9, (android.content.Context) r2)
            goto L_0x0b7b
        L_0x0b3b:
            android.widget.ImageView r0 = r1.n
            if (r0 != 0) goto L_0x0b42
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0b42:
            r3 = 0
            r0.setPadding(r3, r3, r3, r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            android.os.Bundle r3 = r31.getArguments()
            if (r3 == 0) goto L_0x0b55
            java.lang.String r9 = r3.getString(r2)
            goto L_0x0b56
        L_0x0b55:
            r9 = 0
        L_0x0b56:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r9)
            net.one97.paytm.upi.util.CircleTransform r2 = new net.one97.paytm.upi.util.CircleTransform
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.b((int) r2)
            android.widget.ImageView r2 = r1.n
            if (r2 != 0) goto L_0x0b78
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0b78:
            r0.a((android.widget.ImageView) r2)
        L_0x0b7b:
            r31.m()
        L_0x0b7e:
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0b8c
            java.lang.String r2 = "amount"
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x0b8d
        L_0x0b8c:
            r0 = r5
        L_0x0b8d:
            r1.f((java.lang.String) r0)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            if (r0 != 0) goto L_0x0b97
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0b97:
            android.os.Bundle r2 = r31.getArguments()
            if (r2 == 0) goto L_0x0ba8
            java.lang.String r3 = "comments"
            java.lang.String r2 = r2.getString(r3)
            if (r2 == 0) goto L_0x0ba8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0bab
        L_0x0ba8:
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x0bab:
            r0.setText(r2)
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0bbb
            java.lang.String r2 = "txn_id"
            java.lang.String r9 = r0.getString(r2)
            goto L_0x0bbc
        L_0x0bbb:
            r9 = 0
        L_0x0bbc:
            r1.ac = r9
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0bcb
            java.lang.String r2 = "upi_tran_log_id"
            java.lang.String r9 = r0.getString(r2)
            goto L_0x0bcc
        L_0x0bcb:
            r9 = 0
        L_0x0bcc:
            r1.ab = r9
            android.os.Bundle r0 = r31.getArguments()
            if (r0 == 0) goto L_0x0bdc
            r2 = -1
            java.lang.String r3 = "source_of_initiation"
            int r0 = r0.getInt(r3, r2)
            goto L_0x0bdd
        L_0x0bdc:
            r0 = -1
        L_0x0bdd:
            r1.aJ = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0bf3
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0bf3
            java.lang.String r2 = "EXTRA_DEEP_LINK_FLAG"
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0bf4
        L_0x0bf3:
            r0 = 0
        L_0x0bf4:
            if (r0 == 0) goto L_0x0c23
            androidx.fragment.app.FragmentActivity r9 = r31.getActivity()
            boolean r0 = r9 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r0 != 0) goto L_0x0bff
            r9 = 0
        L_0x0bff:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r9 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r9
            if (r9 == 0) goto L_0x0c1f
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c19
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c19
            java.lang.String r2 = "EXTRA_DEEP_LINK_DATA"
            android.os.Parcelable r0 = r0.getParcelableExtra(r2)
            r9 = r0
            net.one97.paytm.deeplink.DeepLinkData r9 = (net.one97.paytm.deeplink.DeepLinkData) r9
            goto L_0x0c1a
        L_0x0c19:
            r9 = 0
        L_0x0c1a:
            boolean r3 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a((net.one97.paytm.deeplink.DeepLinkData) r9)
            goto L_0x0c20
        L_0x0c1f:
            r3 = 0
        L_0x0c20:
            if (r3 == 0) goto L_0x0c23
            goto L_0x0c24
        L_0x0c23:
            r8 = 0
        L_0x0c24:
            r1.G = r8
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c3a
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c3a
            java.lang.String r2 = "is_from_univ_p2p"
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0c3c
        L_0x0c3a:
            r3 = 0
            r0 = 0
        L_0x0c3c:
            r1.L = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c51
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c51
            java.lang.String r2 = "is_for_imps_from_univ_p2p"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0c52
        L_0x0c51:
            r0 = 0
        L_0x0c52:
            r1.M = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c67
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c67
            java.lang.String r2 = "add_money_to_ppb"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0c68
        L_0x0c67:
            r0 = 0
        L_0x0c68:
            r1.N = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c7d
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c7d
            java.lang.String r2 = "intent_extra_is_offline_pg"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0c7e
        L_0x0c7d:
            r0 = 0
        L_0x0c7e:
            r1.O = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0c93
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0c93
            java.lang.String r2 = "upi_push"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0c94
        L_0x0c93:
            r0 = 0
        L_0x0c94:
            r1.P = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0ca9
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0ca9
            java.lang.String r2 = "is_collect_request"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0caa
        L_0x0ca9:
            r0 = 0
        L_0x0caa:
            r1.J = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0cbf
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0cbf
            java.lang.String r2 = "upi_is_self"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0cc0
        L_0x0cbf:
            r0 = 0
        L_0x0cc0:
            r1.I = r0
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0cd5
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0cd5
            java.lang.String r2 = "from_app_evoke"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0cd6
        L_0x0cd5:
            r0 = 0
        L_0x0cd6:
            r1.R = r0
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0cf0
            boolean r2 = r1.L
            boolean r3 = r1.J
            boolean r4 = r1.O
            boolean r5 = r1.P
            boolean r6 = r1.N
            r0.f54734g = r2
            r0.f54735h = r3
            r0.f54736i = r4
            r0.j = r5
            r0.k = r6
        L_0x0cf0:
            boolean r0 = r1.M
            if (r0 == 0) goto L_0x0cf8
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            r1.aI = r0
        L_0x0cf8:
            boolean r0 = r1.L
            if (r0 != 0) goto L_0x0d0c
            boolean r0 = r1.N
            if (r0 != 0) goto L_0x0d0c
            boolean r0 = r1.P
            if (r0 != 0) goto L_0x0d0c
            boolean r0 = r1.O
            if (r0 != 0) goto L_0x0d0c
            boolean r0 = r1.J
            if (r0 == 0) goto L_0x0d0f
        L_0x0d0c:
            r31.v()
        L_0x0d0f:
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0d22
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0d22
            java.lang.String r2 = "uni_p2p_landing_intent_extra_theme"
            java.lang.String r9 = r0.getStringExtra(r2)
            goto L_0x0d23
        L_0x0d22:
            r9 = 0
        L_0x0d23:
            r1.aK = r9
            boolean r0 = r1.J
            if (r0 == 0) goto L_0x08e8
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0d30
            kotlin.g.b.k.a((java.lang.String) r30)
        L_0x0d30:
            r9 = 0
            r0.setEnabled(r9)
        L_0x0d34:
            net.one97.paytm.moneytransfer.d.c$a r0 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r0 = net.one97.paytm.moneytransfer.d.c.a.a()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0d5c
            androidx.fragment.app.FragmentActivity r0 = r31.getActivity()
            if (r0 == 0) goto L_0x0d59
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0d59
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0d59
            java.lang.String r2 = "isGalleryScan"
            boolean r3 = r0.getBoolean(r2)
            goto L_0x0d5a
        L_0x0d59:
            r3 = 0
        L_0x0d5a:
            r1.aO = r3
        L_0x0d5c:
            r31.o()
            int r0 = r1.f54549b
            r1.a((int) r0)
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0d6b
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0d6b:
            androidx.lifecycle.y r0 = r0.c()
            r2 = r1
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.moneytransfer.view.fragments.n$t r3 = new net.one97.paytm.moneytransfer.view.fragments.n$t
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0d83
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0d83:
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>> r0 = r0.f54684i
            if (r0 != 0) goto L_0x0d8a
            kotlin.g.b.k.a()
        L_0x0d8a:
            net.one97.paytm.moneytransfer.view.fragments.n$s r3 = new net.one97.paytm.moneytransfer.view.fragments.n$s
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0da6
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.lang.String>> r0 = r0.f54732e
            if (r0 == 0) goto L_0x0da6
            net.one97.paytm.moneytransfer.view.fragments.n$n r3 = new net.one97.paytm.moneytransfer.view.fragments.n$n
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0da6:
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0db8
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.lang.String>> r0 = r0.f54730c
            if (r0 == 0) goto L_0x0db8
            net.one97.paytm.moneytransfer.view.fragments.n$m r3 = new net.one97.paytm.moneytransfer.view.fragments.n$m
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0db8:
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0dca
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.e$e>> r0 = r0.f54728a
            if (r0 == 0) goto L_0x0dca
            net.one97.paytm.moneytransfer.view.fragments.n$l r3 = new net.one97.paytm.moneytransfer.view.fragments.n$l
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0dca:
            android.net.Uri r0 = r1.B
            if (r0 == 0) goto L_0x0dfd
            if (r0 == 0) goto L_0x0dd7
            java.lang.String r3 = "pa"
            java.lang.String r9 = r0.getQueryParameter(r3)
            goto L_0x0dd8
        L_0x0dd7:
            r9 = 0
        L_0x0dd8:
            android.net.Uri r0 = r1.B
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r9 == 0) goto L_0x0dea
            net.one97.paytm.moneytransfer.viewmodel.b r3 = r1.V
            if (r3 != 0) goto L_0x0de7
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0de7:
            r3.a((java.lang.String) r9, (java.lang.String) r0)
        L_0x0dea:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0df1
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0df1:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.b$b>> r0 = r0.p
            net.one97.paytm.moneytransfer.view.fragments.n$u r3 = new net.one97.paytm.moneytransfer.view.fragments.n$u
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0dfd:
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0e0f
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.e$d>> r0 = r0.f54733f
            if (r0 == 0) goto L_0x0e0f
            net.one97.paytm.moneytransfer.view.fragments.n$r r3 = new net.one97.paytm.moneytransfer.view.fragments.n$r
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0e0f:
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r1.U
            if (r0 == 0) goto L_0x0e21
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r0 = r0.f54729b
            if (r0 == 0) goto L_0x0e21
            net.one97.paytm.moneytransfer.view.fragments.n$o r3 = new net.one97.paytm.moneytransfer.view.fragments.n$o
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0e21:
            boolean r0 = r1.T
            if (r0 != 0) goto L_0x0e54
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0e2c
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0e2c:
            if (r0 == 0) goto L_0x0e31
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r9 = r0.q
            goto L_0x0e32
        L_0x0e31:
            r9 = 0
        L_0x0e32:
            if (r9 == 0) goto L_0x0e3b
            java.lang.Object r0 = r9.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r0 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r0
            goto L_0x0e3c
        L_0x0e3b:
            r0 = 0
        L_0x0e3c:
            if (r0 == 0) goto L_0x0e48
            r31.aa()
            r31.ac()
            r31.O()
            goto L_0x0e54
        L_0x0e48:
            if (r9 == 0) goto L_0x0e54
            net.one97.paytm.moneytransfer.view.fragments.n$p r0 = new net.one97.paytm.moneytransfer.view.fragments.n$p
            r0.<init>(r1)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r9.observe(r2, r0)
        L_0x0e54:
            boolean r0 = r1.T
            if (r0 != 0) goto L_0x0e97
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0e5f
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0e5f:
            if (r0 == 0) goto L_0x0e6d
            androidx.lifecycle.y<java.lang.String> r0 = r0.f54680e
            if (r0 == 0) goto L_0x0e6d
            java.lang.Object r0 = r0.getValue()
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0e6e
        L_0x0e6d:
            r9 = 0
        L_0x0e6e:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0e80
            r31.V()
            r31.ac()
            r31.O()
            goto L_0x0e97
        L_0x0e80:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0e87
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0e87:
            if (r0 == 0) goto L_0x0e97
            androidx.lifecycle.y<java.lang.String> r0 = r0.f54680e
            if (r0 == 0) goto L_0x0e97
            net.one97.paytm.moneytransfer.view.fragments.n$q r3 = new net.one97.paytm.moneytransfer.view.fragments.n$q
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0e97:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.V
            if (r0 != 0) goto L_0x0e9e
            kotlin.g.b.k.a((java.lang.String) r18)
        L_0x0e9e:
            if (r0 == 0) goto L_0x0eae
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.b$a>> r0 = r0.m
            if (r0 == 0) goto L_0x0eae
            net.one97.paytm.moneytransfer.view.fragments.n$k r3 = new net.one97.paytm.moneytransfer.view.fragments.n$k
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0eae:
            androidx.core.widget.NestedScrollView r0 = r1.av
            if (r0 != 0) goto L_0x0eb7
            java.lang.String r2 = "amountScrollView"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0eb7:
            if (r0 == 0) goto L_0x0ec3
            net.one97.paytm.moneytransfer.view.fragments.n$j r2 = new net.one97.paytm.moneytransfer.view.fragments.n$j
            r2.<init>(r1)
            androidx.core.widget.NestedScrollView$b r2 = (androidx.core.widget.NestedScrollView.b) r2
            r0.setOnScrollChangeListener(r2)
        L_0x0ec3:
            boolean r0 = r1.F
            if (r0 == 0) goto L_0x0ef0
            android.widget.TextView r0 = r1.t
            if (r0 != 0) goto L_0x0ed0
            java.lang.String r2 = "transferFromTV"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0ed0:
            int r2 = net.one97.paytm.moneytransfer.R.string.upi_pay_from
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r1.u
            if (r0 != 0) goto L_0x0ee4
            java.lang.String r2 = "transferedFromTV"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0ee4:
            int r2 = net.one97.paytm.moneytransfer.R.string.upi_pay_from
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            goto L_0x0f18
        L_0x0ef0:
            android.widget.TextView r0 = r1.t
            if (r0 != 0) goto L_0x0ef9
            java.lang.String r2 = "transferFromTV"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0ef9:
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_from_
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r1.u
            if (r0 != 0) goto L_0x0f0d
            java.lang.String r2 = "transferedFromTV"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0f0d:
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_from_
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0f18:
            android.content.Context r0 = r17.getContext()
            java.lang.String r2 = "/mt_p2p_enter_amt_screen"
            net.one97.paytm.moneytransfer.utils.f.a(r0, r2)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.aO && UpiUtils.doShowScanAndPayPopUp(getActivity())) {
            net.one97.paytm.moneytransfer.view.b.a aVar = new net.one97.paytm.moneytransfer.view.b.a();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("from_scan_pay", true);
            Bundle arguments = getArguments();
            bundle2.putString("name", arguments != null ? arguments.getString("username") : null);
            aVar.setArguments(bundle2);
            aVar.show(getChildFragmentManager(), "");
        }
    }

    static final class j implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54566a;

        j(n nVar) {
            this.f54566a = nVar;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            if ((n.p(this.f54566a).getHeight() - n.q(this.f54566a).getHeight()) - n.r(this.f54566a).getHeight() >= i3) {
                n.s(this.f54566a).setVisibility(8);
            } else if (n.s(this.f54566a).getVisibility() == 8) {
                n.s(this.f54566a).setVisibility(0);
                n.t(this.f54566a).setVisibility(0);
                TextView u = n.u(this.f54566a);
                String str = null;
                if (u != null) {
                    Bundle arguments = this.f54566a.getArguments();
                    u.setText(String.valueOf(arguments != null ? arguments.get("username") : null));
                }
                if (this.f54566a.y == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
                    TextView t = n.t(this.f54566a);
                    kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
                    String string = this.f54566a.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.money…placeholder_without_bold)");
                    Object[] objArr = new Object[1];
                    Bundle arguments2 = this.f54566a.getArguments();
                    if (arguments2 != null) {
                        str = arguments2.getString("vpa");
                    }
                    objArr[0] = str;
                    String format = String.format(string, Arrays.copyOf(objArr, 1));
                    kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                    t.setText(format);
                    return;
                }
                TextView t2 = n.t(this.f54566a);
                kotlin.g.b.aa aaVar2 = kotlin.g.b.aa.f47921a;
                String string2 = this.f54566a.getString(R.string.money_transfer_upi_without_bold);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.money…ransfer_upi_without_bold)");
                Object[] objArr2 = new Object[1];
                Bundle arguments3 = this.f54566a.getArguments();
                if (arguments3 != null) {
                    str = arguments3.getString("vpa");
                }
                objArr2[0] = str;
                String format2 = String.format(string2, Arrays.copyOf(objArr2, 1));
                kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                t2.setText(format2);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54559a;

        c(n nVar) {
            this.f54559a = nVar;
        }

        public final void onClick(View view) {
            if (n.w(this.f54559a).getVisibility() == 0) {
                this.f54559a.a(false);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54560a;

        d(n nVar) {
            this.f54560a = nVar;
        }

        public final void onClick(View view) {
            if (n.w(this.f54560a).getVisibility() == 0) {
                this.f54560a.a(false);
            }
        }
    }

    public static final class e implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54561a;

        e(n nVar) {
            this.f54561a = nVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            kotlin.g.b.k.c(textView, "v");
            if (i2 != 6) {
                return false;
            }
            this.f54561a.a(true);
            return false;
        }
    }

    public static final class f implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54562a;

        f(n nVar) {
            this.f54562a = nVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            kotlin.g.b.k.c(textView, "v");
            if (i2 != 6) {
                return false;
            }
            this.f54562a.a(true);
            return false;
        }
    }

    static final class g implements CustomAmountTextInputEditText.EditTextImeBackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54563a;

        g(n nVar) {
            this.f54563a = nVar;
        }

        public final void onImeBack(CustomAmountTextInputEditText customAmountTextInputEditText, String str) {
            try {
                this.f54563a.a(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static final class h implements CommentsEditText.EditTextImeBackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54564a;

        h(n nVar) {
            this.f54564a = nVar;
        }

        public final void onImeBack(CommentsEditText commentsEditText, String str) {
            try {
                this.f54564a.a(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static final class i implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54565a;

        i(n nVar) {
            this.f54565a = nVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                try {
                    if (n.x(this.f54565a).getVisibility() == 8 && n.y(this.f54565a).getVisibility() == 4) {
                        net.one97.paytm.moneytransfer.utils.c.a(n.y(this.f54565a), 400);
                    }
                    this.f54565a.a(false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (n.x(this.f54565a).getVisibility() == 8) {
                net.one97.paytm.moneytransfer.utils.c.b(n.y(this.f54565a), 400);
            }
        }
    }

    public final void a(boolean z2) {
        if (!z2 || !k()) {
            View view = this.aj;
            if (view == null) {
                kotlin.g.b.k.a("selectedAccCardView");
            }
            if (view.getVisibility() == 0) {
                View view2 = this.aj;
                if (view2 == null) {
                    kotlin.g.b.k.a("selectedAccCardView");
                }
                net.one97.paytm.moneytransfer.utils.c.a(view2);
            }
            LinearLayout linearLayout = this.ak;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mPayWrapper");
            }
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = this.ak;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("mPayWrapper");
        }
        linearLayout2.setVisibility(8);
        View view3 = this.aj;
        if (view3 == null) {
            kotlin.g.b.k.a("selectedAccCardView");
        }
        if (view3.getVisibility() == 8) {
            View view4 = this.aj;
            if (view4 == null) {
                kotlin.g.b.k.a("selectedAccCardView");
            }
            net.one97.paytm.moneytransfer.utils.c.b(view4);
        }
    }

    private final boolean k() {
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        return arrayList != null && arrayList.size() > 0;
    }

    private final void l() {
        View view = this.as;
        if (view == null) {
            kotlin.g.b.k.a("bankDetailsContainer");
        }
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.at;
        if (view2 == null) {
            kotlin.g.b.k.a("banknameContainer");
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ImageView imageView = this.ar;
        if (imageView == null) {
            kotlin.g.b.k.a("bankArrowTV");
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void m() {
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("bankname") : null;
        if (!TextUtils.isEmpty(string)) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("vpa");
            }
            TextView textView = this.l;
            if (textView == null) {
                kotlin.g.b.k.a("headerBankLogoName");
            }
            textView.setText(net.one97.paytm.moneytransfer.utils.m.a(string, str));
            View view = this.at;
            if (view == null) {
                kotlin.g.b.k.a("banknameContainer");
            }
            if (view != null) {
                view.setOnClickListener(this);
            }
            ImageView imageView = this.ar;
            if (imageView == null) {
                kotlin.g.b.k.a("bankArrowTV");
            }
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            View view2 = this.at;
            if (view2 == null) {
                kotlin.g.b.k.a("banknameContainer");
            }
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.at;
        if (view3 == null) {
            kotlin.g.b.k.a("banknameContainer");
        }
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.as;
        if (view4 == null) {
            kotlin.g.b.k.a("bankDetailsContainer");
        }
        if (view4 != null) {
            view4.setVisibility(0);
        }
    }

    public final void a(int i2, UpiProfileDefaultBank upiProfileDefaultBank, boolean z2) {
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z2);
        startActivityForResult(intent, i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (!this.aF.isEmpty()) {
            UpiProfileDefaultBank upiProfileDefaultBank = this.aF.get(i2);
            kotlin.g.b.k.a((Object) upiProfileDefaultBank, "vpaList.get(position)");
            UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
            if (upiProfileDefaultBank2 == null) {
                kotlin.g.b.k.a();
            }
            a(upiProfileDefaultBank2);
            return;
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mOpenBottomSheetRlv");
        }
        relativeLayout.setVisibility(8);
        if (net.one97.paytm.moneytransfer.utils.m.b((Context) getActivity()) || !UpiUtils.isInActiveProfileExist(getActivity())) {
            if (net.one97.paytm.moneytransfer.utils.m.b(getContext())) {
                if (getContext() == null) {
                    kotlin.g.b.k.a();
                }
                if (getContext() == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.upi.registration.b.a.b a2 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
                kotlin.g.b.k.a((Object) a2, "Injection.provideUpiRegi…ervices(context!!, null))");
                if (!a2.h() || n()) {
                    TextView textView = this.m;
                    if (textView == null) {
                        kotlin.g.b.k.a("mProceedPayment");
                    }
                    textView.setText(getString(R.string.upi_link_account));
                    net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "link_bank_account_visible", "/money-transfer/payment", "", "");
                    RelativeLayout relativeLayout2 = this.o;
                    if (relativeLayout2 == null) {
                        kotlin.g.b.k.a("mOpenBottomSheetRlv");
                    }
                    relativeLayout2.setVisibility(8);
                    return;
                }
            }
            N();
            return;
        }
        TextView textView2 = this.m;
        if (textView2 == null) {
            kotlin.g.b.k.a("mProceedPayment");
        }
        textView2.setText(getString(R.string.upi_reactivate_account));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r0.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean n() {
        /*
            r2 = this;
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r2.V
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            if (r0 == 0) goto L_0x0018
            androidx.lifecycle.y r0 = r0.c()
            if (r0 == 0) goto L_0x0018
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x0023
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0023
            return r1
        L_0x0023:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.n():boolean");
    }

    private final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mOpenBottomSheetRlv");
        }
        relativeLayout.setVisibility(0);
        TextView textView = this.m;
        if (textView == null) {
            kotlin.g.b.k.a("mProceedPayment");
        }
        textView.setText(getString(R.string.proceed));
        CommentsEditText commentsEditText = this.p;
        if (commentsEditText == null) {
            kotlin.g.b.k.a("messageET");
        }
        commentsEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        if (!this.J) {
            this.W = upiProfileDefaultBank;
        }
        if (upiProfileDefaultBank.getDebitBank() != null) {
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "currentBankObject.debitBank");
            if (debitBank.getBankName() != null) {
                BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank2, "currentBankObject.debitBank");
                if (debitBank2.getAccount() != null) {
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank3, "currentBankObject.debitBank");
                    if (!TextUtils.isEmpty(debitBank3.getIfsc())) {
                        BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank != null ? upiProfileDefaultBank.getDebitBank() : null;
                        kotlin.g.b.k.a((Object) debitBank4, "debitBank");
                        this.D = debitBank4.getAccount();
                        TextView textView2 = this.ao;
                        if (textView2 == null) {
                            kotlin.g.b.k.a("mCardSelectedBankNameTv");
                        }
                        textView2.setText(net.one97.paytm.moneytransfer.utils.m.a(debitBank4.getBankName(), debitBank4.getAccount()));
                        if (debitBank4.isMpinSet()) {
                            S();
                        } else {
                            T();
                        }
                        this.E = debitBank4.getIfsc();
                        if (upiProfileDefaultBank.getPaymentMode() == UpiProfileDefaultBank.PAYMENT_MODE.IMPS) {
                            ImageView imageView = this.aq;
                            if (imageView == null) {
                                kotlin.g.b.k.a("mCardSelectedBankIv");
                            }
                            String str = this.E;
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.moneytransfer.utils.m.a(imageView, str, (Context) getActivity());
                            if (kotlin.g.b.k.a((Object) "CURRENT", (Object) debitBank4.getAccountType())) {
                                View view = this.aC;
                                if (view == null) {
                                    kotlin.g.b.k.a("currentAccountTV");
                                }
                                view.setVisibility(0);
                                TextView textView3 = this.an;
                                if (textView3 == null) {
                                    kotlin.g.b.k.a("mSelectedSourceBankTv");
                                }
                                textView3.setText(getString(R.string.mt_current_account_with_bank_name, debitBank4.getBankName()));
                            } else {
                                View view2 = this.aC;
                                if (view2 == null) {
                                    kotlin.g.b.k.a("currentAccountTV");
                                }
                                view2.setVisibility(8);
                                TextView textView4 = this.an;
                                if (textView4 == null) {
                                    kotlin.g.b.k.a("mSelectedSourceBankTv");
                                }
                                textView4.setText(debitBank4.getBankName());
                            }
                        } else {
                            TextView textView5 = this.an;
                            if (textView5 == null) {
                                kotlin.g.b.k.a("mSelectedSourceBankTv");
                            }
                            textView5.setText(debitBank4.getBankName());
                            if (!TextUtils.isEmpty(debitBank4.getBankLogoUrl())) {
                                ImageView imageView2 = this.aq;
                                if (imageView2 == null) {
                                    kotlin.g.b.k.a("mCardSelectedBankIv");
                                }
                                net.one97.paytm.moneytransfer.utils.m.a(imageView2, debitBank4.getBankLogoUrl(), (Context) getActivity());
                            }
                            View view3 = this.aC;
                            if (view3 == null) {
                                kotlin.g.b.k.a("currentAccountTV");
                            }
                            view3.setVisibility(8);
                        }
                        RelativeLayout relativeLayout2 = this.o;
                        if (relativeLayout2 == null) {
                            kotlin.g.b.k.a("mOpenBottomSheetRlv");
                        }
                        relativeLayout2.setVisibility(0);
                        d();
                    }
                }
            }
        }
    }

    private final void o() {
        j jVar = this.aH;
        if (jVar == null) {
            this.aH = new j();
            j jVar2 = this.aH;
            if (jVar2 != null) {
                jVar2.a(Integer.valueOf(this.f54549b));
            }
            j jVar3 = this.aH;
            if (jVar3 != null) {
                jVar3.a((List<? extends UpiProfileDefaultBank>) this.aF);
            }
            j jVar4 = this.aH;
            if (jVar4 != null) {
                jVar4.f54493a = this.F;
                return;
            }
            return;
        }
        if (jVar != null) {
            jVar.a(Integer.valueOf(this.f54549b));
        }
        j jVar5 = this.aH;
        if (jVar5 != null) {
            jVar5.b((List<? extends UpiProfileDefaultBank>) this.aF);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z2) {
        if (!i()) {
            return;
        }
        if (z2) {
            Fragment c2 = getChildFragmentManager().c(j.class.getName());
            if (c2 == null || !c2.isAdded()) {
                UpiAppUtils.hideKeyboard(getActivity());
                j jVar = this.aH;
                if (jVar != null) {
                    jVar.showNow(getChildFragmentManager(), j.class.getName());
                    return;
                }
                return;
            }
            return;
        }
        j jVar2 = this.aH;
        if (jVar2 != null) {
            jVar2.dismiss();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((MoneyTransferV3Activity) activity).a(upiCustomVolleyError);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity");
        }
    }

    public final void a(MoneyTransferV3Activity.b bVar) {
        String str;
        kotlin.g.b.k.c(bVar, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        if (bVar == MoneyTransferV3Activity.b.PLEASE_ADD_BANK) {
            str = getString(R.string.please_add_a_bank_account);
            kotlin.g.b.k.a((Object) str, "getString(R.string.please_add_a_bank_account)");
        } else if (bVar == MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG) {
            str = getString(R.string.upi_oops_something_went_wrong);
            kotlin.g.b.k.a((Object) str, "getString(R.string.upi_oops_something_went_wrong)");
        } else if (bVar == MoneyTransferV3Activity.b.CANNOT_TRANSFER_TO_SAME_ACC) {
            str = getString(R.string.you_cannot_transfer_money_to_same_account);
            kotlin.g.b.k.a((Object) str, "getString(R.string.you_c…er_money_to_same_account)");
        } else if (bVar == MoneyTransferV3Activity.b.NO_SIM) {
            str = getString(R.string.no_sim_attached);
            kotlin.g.b.k.a((Object) str, "getString(R.string.no_sim_attached)");
        } else {
            str = "";
        }
        a(str);
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ((MoneyTransferV3Activity) activity2).f(str);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity");
        }
    }

    public static final class z implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54584a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "editable");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
        }

        z(n nVar) {
            this.f54584a = nVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
            boolean z = true;
            if (charSequence.length() == 0) {
                n.F(this.f54584a).setVisibility(4);
                n.G(this.f54584a);
                return;
            }
            n.H(this.f54584a);
            n.I(this.f54584a);
            TextView F = n.F(this.f54584a);
            kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
            String string = this.f54584a.getString(R.string.mt_amount_in_words_placeholder);
            kotlin.g.b.k.a((Object) string, "getString(R.string.mt_amount_in_words_placeholder)");
            String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(net.one97.paytm.moneytransfer.utils.m.g(String.valueOf(n.J(this.f54584a).getText())))}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            F.setText(format);
            n.F(this.f54584a).setVisibility(0);
            if (this.f54584a.y == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                FragmentActivity activity = this.f54584a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                if (b2.b((Context) activity) && this.f54584a.p()) {
                    try {
                        double parseDouble = Double.parseDouble(UpiAppUtils.getCleanString(String.valueOf(n.J(this.f54584a).getText())));
                        n nVar = this.f54584a;
                        if (parseDouble < UpiUtils.getUpiIMPSSwitchLimit(this.f54584a.getContext())) {
                            z = false;
                        }
                        nVar.A = z;
                        this.f54584a.d();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (kotlin.m.p.a(r0, r1, true) != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r1 = r1.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r3 = this;
            boolean r0 = r3.Z()
            if (r0 != 0) goto L_0x0029
            boolean r0 = r3.A
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r3.f54552f
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.W
            if (r1 == 0) goto L_0x001b
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = r1.getIfsc()
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r2 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r0 == 0) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.VPA
            r3.aI = r0
            return
        L_0x0029:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            r3.aI = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.d():void");
    }

    public final void e() {
        if (this.F) {
            if (this.H) {
                UpiAppUtils.hideKeyboard(getActivity());
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                a((Bundle) null);
            }
        } else if (this.G || this.J) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.moneytransfer.utils.m.a(activity3);
        }
        net.one97.paytm.moneytransfer.utils.n nVar = this.aN;
        if (nVar != null) {
            nVar.a();
        }
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.iv_back_button1) {
            e();
        } else if ((view != null && view.getId() == R.id.arrow_iv) || (view != null && view.getId() == R.id.selectedBankDownArrowTV)) {
            b(true);
        } else if (view != null && view.getId() == R.id.txt_add_desc) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "add_message_clicked", "/money-transfer/payment", "", "");
            CommentsEditText commentsEditText = this.p;
            if (commentsEditText == null) {
                kotlin.g.b.k.a("messageET");
            }
            commentsEditText.setVisibility(0);
            TextView textView = this.s;
            if (textView == null) {
                kotlin.g.b.k.a("addMessageTV");
            }
            textView.setVisibility(8);
            CommentsEditText commentsEditText2 = this.p;
            if (commentsEditText2 == null) {
                kotlin.g.b.k.a("messageET");
            }
            commentsEditText2.requestFocus();
            CommentsEditText commentsEditText3 = this.p;
            if (commentsEditText3 == null) {
                kotlin.g.b.k.a("messageET");
            }
            net.one97.paytm.moneytransfer.utils.m.a((EditText) commentsEditText3, (Activity) getActivity());
            View view2 = this.w;
            if (view2 == null) {
                kotlin.g.b.k.a("mAmountUnderline");
            }
            net.one97.paytm.moneytransfer.utils.c.b(view2, 400);
            View view3 = this.x;
            if (view3 == null) {
                kotlin.g.b.k.a("mCommentsUnderline");
            }
            net.one97.paytm.moneytransfer.utils.c.a(view3, 400);
        } else if (view != null && view.getId() == R.id.rl_uni_selected_payment_inst) {
            com.paytm.utility.b.c((Activity) getActivity());
            b(true);
        } else if (view != null && view.getId() == R.id.ll_uni_pay) {
            TextView textView2 = this.m;
            if (textView2 == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            if (kotlin.m.p.a(textView2.getText().toString(), getString(R.string.proceed), true)) {
                g();
                return;
            }
            TextView textView3 = this.m;
            if (textView3 == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            if (kotlin.m.p.a(textView3.getText().toString(), getString(R.string.upi_reactivate_account), true)) {
                b(2012);
            } else if (net.one97.paytm.moneytransfer.utils.m.b((Context) getActivity())) {
                f();
            } else if (UpiUtils.isInActiveProfileExist(getActivity())) {
                startActivity(UpiUtils.getUpiLandingPageActivityIntent(getActivity()));
            } else {
                Intent intent = new Intent(getActivity(), UpiSelectBankActivity.class);
                intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                intent.setFlags(536870912);
                startActivityForResult(intent, 352);
            }
        } else if (view != null && view.getId() == R.id.card_view_button) {
            g();
        } else if ((view != null && view.getId() == R.id.bankNameContainer) || (view != null && view.getId() == R.id.bankarrow)) {
            View view4 = this.as;
            if (view4 == null) {
                kotlin.g.b.k.a("bankDetailsContainer");
            }
            String str = null;
            if (view4.getVisibility() == 0) {
                Bundle arguments = getArguments();
                String string = arguments != null ? arguments.getString("bankname") : null;
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str = arguments2.getString("vpa");
                }
                TextView textView4 = this.l;
                if (textView4 == null) {
                    kotlin.g.b.k.a("headerBankLogoName");
                }
                textView4.setText(net.one97.paytm.moneytransfer.utils.m.a(string, str));
                View view5 = this.as;
                if (view5 == null) {
                    kotlin.g.b.k.a("bankDetailsContainer");
                }
                view5.setVisibility(8);
                ImageView imageView = this.ar;
                if (imageView == null) {
                    kotlin.g.b.k.a("bankArrowTV");
                }
                net.one97.paytm.moneytransfer.utils.c.a(imageView, 1);
                return;
            }
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str = arguments3.getString("bankname");
            }
            TextView textView5 = this.l;
            if (textView5 == null) {
                kotlin.g.b.k.a("headerBankLogoName");
            }
            textView5.setText(str);
            View view6 = this.as;
            if (view6 == null) {
                kotlin.g.b.k.a("bankDetailsContainer");
            }
            view6.setVisibility(0);
            ImageView imageView2 = this.ar;
            if (imageView2 == null) {
                kotlin.g.b.k.a("bankArrowTV");
            }
            net.one97.paytm.moneytransfer.utils.c.a(imageView2, 0);
        } else if ((view != null && view.getId() == R.id.ivVerificationLogo) || (view != null && view.getId() == R.id.tvbhimUpi)) {
            new net.one97.paytm.upi.profile.view.h().show(getChildFragmentManager(), "SignStatusInfoBS");
        } else if (view != null && view.getId() == R.id.check_balance_tv) {
            P();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p() {
        /*
            r7 = this;
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aF
            if (r0 == 0) goto L_0x007a
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
            java.lang.String r2 = "vpaItem"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getDebitBank()
            r3 = 0
            if (r2 == 0) goto L_0x0025
            java.lang.String r2 = r2.getIfsc()
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            if (r2 == 0) goto L_0x0008
            java.lang.String r2 = r7.f54552f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r1.getDebitBank()
            if (r4 == 0) goto L_0x0035
            java.lang.String r4 = r4.getIfsc()
            goto L_0x0036
        L_0x0035:
            r4 = r3
        L_0x0036:
            r5 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r5)
            if (r2 == 0) goto L_0x0008
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getDebitBank()
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r2.getAccount()
            if (r2 == 0) goto L_0x0066
            net.one97.paytm.moneytransfer.viewmodel.b r4 = r7.V
            if (r4 != 0) goto L_0x0052
            java.lang.String r6 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0052:
            if (r4 == 0) goto L_0x005e
            androidx.lifecycle.y<java.lang.String> r4 = r4.f54680e
            if (r4 == 0) goto L_0x005e
            java.lang.Object r3 = r4.getValue()
            java.lang.String r3 = (java.lang.String) r3
        L_0x005e:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
        L_0x0066:
            if (r3 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            boolean r2 = r3.booleanValue()
            if (r2 == 0) goto L_0x0008
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r1 = r1.getPaymentMode()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r2 = net.one97.paytm.upi.common.upi.UpiProfileDefaultBank.PAYMENT_MODE.UPI
            if (r1 != r2) goto L_0x0008
            return r5
        L_0x007a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.p():boolean");
    }

    private final CommonPayParams q() {
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString(UpiConstants.EXTRA_INTENT_INITIATION_MODE, "00") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(UpiConstants.EXTRA_INTENT_SIGN) : null;
        Bundle arguments3 = getArguments();
        CommonPayParams.Builder builder = new CommonPayParams.Builder(string, string2, arguments3 != null ? arguments3.getString(UpiConstants.EXTRA_INTENT_ORD_ID) : null);
        Bundle arguments4 = getArguments();
        CommonPayParams.Builder merchantId = builder.setMerchantId(arguments4 != null ? arguments4.getString(UpiConstants.EXTRA_INTENT_MID) : null);
        Bundle arguments5 = getArguments();
        CommonPayParams.Builder merchantStoreId = merchantId.setMerchantStoreId(arguments5 != null ? arguments5.getString(UpiConstants.EXTRA_INTENT_MSID) : null);
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str = arguments6.getString(UpiConstants.EXTRA_INTENT_MTID);
        }
        return merchantStoreId.setMerchantTerminalId(str).build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
        if (kotlin.m.p.a(r0 != null ? r0.getString(net.one97.paytm.upi.util.UpiConstants.EXTRA_KEY_MCC) : null, "0000", true) == false) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0743  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x075c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r() {
        /*
            r16 = this;
            r1 = r16
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            java.lang.String r2 = "amountET"
            if (r0 != 0) goto L_0x000b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x000b:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = com.paytm.utility.b.Q((java.lang.String) r0)
            r1.X = r0
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.p
            if (r0 != 0) goto L_0x0022
            java.lang.String r3 = "messageET"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0022:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.Y = r0
            android.widget.TextView r0 = r1.q
            java.lang.String r3 = "amountErrorTV"
            if (r0 != 0) goto L_0x0035
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0035:
            android.content.Context r4 = r16.getContext()
            if (r4 != 0) goto L_0x003e
            kotlin.g.b.k.a()
        L_0x003e:
            int r5 = net.one97.paytm.moneytransfer.R.color.color_222222
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setTextColor(r4)
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x004e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x004e:
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a
            int r4 = net.one97.paytm.moneytransfer.R.string.mt_amount_in_words_placeholder
            java.lang.String r4 = r1.getString(r4)
            java.lang.String r5 = "getString(R.string.mt_amount_in_words_placeholder)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r7 = r1.f54548a
            if (r7 != 0) goto L_0x0065
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0065:
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = net.one97.paytm.moneytransfer.utils.m.g(r7)
            java.lang.String r7 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r7)
            r8 = 0
            r6[r8] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r5)
            java.lang.String r4 = java.lang.String.format(r4, r6)
            java.lang.String r6 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x0091
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0091:
            r0.setVisibility(r8)
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMaxAmountAllowed(r0)
            boolean r0 = r1.J
            r4 = 0
            if (r0 != 0) goto L_0x00cd
            android.os.Bundle r0 = r16.getArguments()
            java.lang.String r7 = "extra_key_mcc"
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r0.getString(r7)
            goto L_0x00b1
        L_0x00b0:
            r0 = r4
        L_0x00b1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d7
            android.os.Bundle r0 = r16.getArguments()
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = r0.getString(r7)
            goto L_0x00c5
        L_0x00c4:
            r0 = r4
        L_0x00c5:
            java.lang.String r7 = "0000"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r7, (boolean) r5)
            if (r0 != 0) goto L_0x00d7
        L_0x00cd:
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            double r9 = net.one97.paytm.upi.util.UpiUtils.getUPIP2MMaxAmountAllowed(r0)
        L_0x00d7:
            android.os.Bundle r0 = r16.getArguments()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r7 = "vpa"
            java.lang.String r0 = r0.getString(r7)
            goto L_0x00e5
        L_0x00e4:
            r0 = r4
        L_0x00e5:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = r1.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            java.lang.String r12 = "getString(R.string.money…nsfer_account_validation)"
            java.lang.String r13 = "Important"
            if (r7 != r11) goto L_0x03ef
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.aI
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            if (r7 != r11) goto L_0x02b2
            java.lang.String r6 = r1.X
            net.one97.paytm.moneytransfer.viewmodel.b r7 = r1.V
            java.lang.String r9 = "moneyTransferActivityViewModel"
            if (r7 != 0) goto L_0x0100
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0100:
            double r10 = r7.j
            net.one97.paytm.moneytransfer.viewmodel.b r7 = r1.V
            if (r7 != 0) goto L_0x0109
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0109:
            double r12 = r7.k
            boolean r6 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r6, (double) r10, (double) r12)
            if (r6 != 0) goto L_0x0187
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x0118
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0118:
            r0.setVisibility(r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.moneytransfer.viewmodel.b r4 = r1.V
            if (r4 != 0) goto L_0x0127
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0127:
            double r6 = r4.j
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)
            r0.append(r4)
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2
            java.lang.String r4 = r1.getString(r4)
            r0.append(r4)
            net.one97.paytm.moneytransfer.viewmodel.b r4 = r1.V
            if (r4 != 0) goto L_0x0140
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0140:
            double r6 = r4.k
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r4 = r1.q
            if (r4 != 0) goto L_0x0154
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0154:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            java.lang.String r0 = r1.getString(r6, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x016a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x016a:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x0173
            kotlin.g.b.k.a()
        L_0x0173:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x0183
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0183:
            r0.requestFocus()
            return
        L_0x0187:
            boolean r6 = r1.aO
            if (r6 == 0) goto L_0x01fe
            java.lang.String r6 = r1.X
            net.one97.paytm.moneytransfer.viewmodel.b r7 = r1.V
            if (r7 != 0) goto L_0x0194
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0194:
            double r10 = r7.j
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r7 = r7.y
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)
            double r12 = (double) r7
            boolean r6 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r6, (double) r10, (double) r12)
            if (r6 != 0) goto L_0x01fe
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x01b0
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01b0:
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x01ba
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01ba:
            int r4 = net.one97.paytm.moneytransfer.R.string.upi_gallery_scan_error
            java.lang.Object[] r5 = new java.lang.Object[r5]
            net.one97.paytm.moneytransfer.d.c$a r6 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r6 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r6 = r6.y
            int r6 = net.one97.paytm.moneytransfer.d.c.b(r6)
            double r6 = (double) r6
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)
            r5[r8] = r6
            java.lang.String r4 = r1.getString(r4, r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x01e1
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01e1:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x01ea
            kotlin.g.b.k.a()
        L_0x01ea:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x01fa
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01fa:
            r0.requestFocus()
            return
        L_0x01fe:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0226
            net.one97.paytm.moneytransfer.viewmodel.b r2 = r1.V
            if (r2 != 0) goto L_0x020e
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x020e:
            androidx.lifecycle.y<java.lang.String> r2 = r2.f54680e
            if (r2 == 0) goto L_0x0219
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x021a
        L_0x0219:
            r2 = r4
        L_0x021a:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 == 0) goto L_0x0226
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.CANNOT_TRANSFER_TO_SAME_ACC
            r1.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r0)
            return
        L_0x0226:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r1.W
            if (r0 == 0) goto L_0x0234
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0234
            java.lang.String r4 = r0.getAccountType()
        L_0x0234:
            if (r4 != 0) goto L_0x0238
            goto L_0x0733
        L_0x0238:
            int r0 = r4.hashCode()
            r2 = -1704036199(0xffffffff9a6e7899, float:-4.9314664E-23)
            if (r0 == r2) goto L_0x0283
            r2 = 1844922713(0x6df74959, float:9.5664337E27)
            if (r0 == r2) goto L_0x0248
            goto L_0x0733
        L_0x0248:
            java.lang.String r0 = "CURRENT"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0733
            java.lang.String r0 = r16.ad()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0733
            java.lang.String r0 = r1.X
            if (r0 != 0) goto L_0x0263
            kotlin.g.b.k.a()
        L_0x0263:
            java.lang.String r2 = r16.ad()
            boolean r0 = a((java.lang.String) r0, (java.lang.String) r2)
            if (r0 != 0) goto L_0x0733
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_insufficient_ppb_bal
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r8)
            r0.show()
            return
        L_0x0283:
            java.lang.String r0 = "SAVINGS"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0733
            java.lang.String r0 = r1.X
            if (r0 != 0) goto L_0x0292
            kotlin.g.b.k.a()
        L_0x0292:
            java.lang.String r2 = r16.s()
            boolean r0 = a((java.lang.String) r0, (java.lang.String) r2)
            if (r0 != 0) goto L_0x0733
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_insufficient_ppb_bal
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r8)
            r0.show()
            return
        L_0x02b2:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.aI
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.VPA
            if (r7 != r11) goto L_0x0733
            boolean r7 = r1.aO
            if (r7 == 0) goto L_0x02c9
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r7 = r7.y
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)
            double r9 = (double) r7
        L_0x02c9:
            java.lang.String r7 = r1.X
            android.content.Context r11 = r16.getContext()
            double r14 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r11)
            boolean r7 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (double) r14, (double) r9)
            if (r7 != 0) goto L_0x0371
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x02e0
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02e0:
            r0.setVisibility(r8)
            boolean r0 = r1.aO
            if (r0 == 0) goto L_0x030f
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x02ee
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02ee:
            int r4 = net.one97.paytm.moneytransfer.R.string.upi_gallery_scan_error
            java.lang.Object[] r5 = new java.lang.Object[r5]
            net.one97.paytm.moneytransfer.d.c$a r6 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r6 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r6 = r6.y
            int r6 = net.one97.paytm.moneytransfer.d.c.b(r6)
            double r6 = (double) r6
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)
            r5[r8] = r6
            java.lang.String r4 = r1.getString(r4, r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            goto L_0x034d
        L_0x030f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r4 = r16.getContext()
            double r6 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r4)
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)
            r0.append(r4)
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2
            java.lang.String r4 = r1.getString(r4)
            r0.append(r4)
            java.lang.String r4 = com.paytm.utility.b.a((double) r9)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r4 = r1.q
            if (r4 != 0) goto L_0x033e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x033e:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            java.lang.String r0 = r1.getString(r6, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x034d:
            android.widget.TextView r0 = r1.q
            if (r0 != 0) goto L_0x0354
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0354:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x035d
            kotlin.g.b.k.a()
        L_0x035d:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a
            if (r0 != 0) goto L_0x036d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x036d:
            r0.requestFocus()
            return
        L_0x0371:
            boolean r2 = r16.t()
            if (r2 == 0) goto L_0x03c3
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_account_validation
            java.lang.String r2 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r1.W
            if (r3 == 0) goto L_0x0399
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r3.getDebitBank()
            if (r3 == 0) goto L_0x0399
            java.lang.String r4 = r3.getBankName()
        L_0x0399:
            r7[r8] = r4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r1.S
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7[r5] = r3
            r3 = 2
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r7, r3)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.upi.util.CustomDialog.showAlert(r0, r13, r2)
            return
        L_0x03c3:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0733
            java.lang.String r2 = r1.D
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r8)
            if (r0 == 0) goto L_0x0733
            int r0 = net.one97.paytm.moneytransfer.R.string.you_cannot_transfer_money_to_same_account
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r2 = "getString(R.string.you_c…er_money_to_same_account)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.moneytransfer.R.string.error
            java.lang.String r3 = r1.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            return
        L_0x03ef:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = r1.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r7 != r11) goto L_0x0733
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.aI     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.VPA     // Catch:{ Exception -> 0x072f }
            if (r7 != r11) goto L_0x0573
            boolean r7 = r1.aO     // Catch:{ Exception -> 0x072f }
            if (r7 == 0) goto L_0x040c
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()     // Catch:{ Exception -> 0x072f }
            java.lang.String r7 = r7.y     // Catch:{ Exception -> 0x072f }
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)     // Catch:{ Exception -> 0x072f }
            double r9 = (double) r7     // Catch:{ Exception -> 0x072f }
        L_0x040c:
            java.lang.String r7 = r1.X     // Catch:{ Exception -> 0x072f }
            android.content.Context r11 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            double r14 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r11)     // Catch:{ Exception -> 0x072f }
            boolean r7 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (double) r14, (double) r9)     // Catch:{ Exception -> 0x072f }
            if (r7 != 0) goto L_0x04b4
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0423
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0423:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x072f }
            boolean r0 = r1.aO     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0452
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0431
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0431:
            int r4 = net.one97.paytm.moneytransfer.R.string.upi_gallery_scan_error     // Catch:{ Exception -> 0x072f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.moneytransfer.d.c$a r6 = net.one97.paytm.moneytransfer.d.c.C     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.moneytransfer.d.c r6 = net.one97.paytm.moneytransfer.d.c.a.a()     // Catch:{ Exception -> 0x072f }
            java.lang.String r6 = r6.y     // Catch:{ Exception -> 0x072f }
            int r6 = net.one97.paytm.moneytransfer.d.c.b(r6)     // Catch:{ Exception -> 0x072f }
            double r6 = (double) r6     // Catch:{ Exception -> 0x072f }
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x072f }
            r5[r8] = r6     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = r1.getString(r4, r5)     // Catch:{ Exception -> 0x072f }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x072f }
            r0.setText(r4)     // Catch:{ Exception -> 0x072f }
            goto L_0x0490
        L_0x0452:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x072f }
            r0.<init>()     // Catch:{ Exception -> 0x072f }
            android.content.Context r4 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            double r6 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r4 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r4 != 0) goto L_0x0481
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0481:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x072f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x072f }
            r5[r8] = r0     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.getString(r6, r5)     // Catch:{ Exception -> 0x072f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x072f }
            r4.setText(r0)     // Catch:{ Exception -> 0x072f }
        L_0x0490:
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0497
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0497:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            if (r3 != 0) goto L_0x04a0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x04a0:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x072f }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x072f }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x04b0
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x072f }
        L_0x04b0:
            r0.requestFocus()     // Catch:{ Exception -> 0x072f }
            return
        L_0x04b4:
            boolean r7 = r16.t()     // Catch:{ Exception -> 0x072f }
            if (r7 == 0) goto L_0x0506
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()     // Catch:{ Exception -> 0x072f }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x072f }
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x072f }
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_account_validation     // Catch:{ Exception -> 0x072f }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x072f }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x072f }
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r1.W     // Catch:{ Exception -> 0x072f }
            if (r3 == 0) goto L_0x04dc
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r3.getDebitBank()     // Catch:{ Exception -> 0x072f }
            if (r3 == 0) goto L_0x04dc
            java.lang.String r4 = r3.getBankName()     // Catch:{ Exception -> 0x072f }
        L_0x04dc:
            r7[r8] = r4     // Catch:{ Exception -> 0x072f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x072f }
            r3.<init>()     // Catch:{ Exception -> 0x072f }
            int r4 = r1.S     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r4)     // Catch:{ Exception -> 0x072f }
            r3.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x072f }
            r7[r5] = r3     // Catch:{ Exception -> 0x072f }
            r3 = 2
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r7, r3)     // Catch:{ Exception -> 0x072f }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x072f }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.util.CustomDialog.showAlert(r0, r13, r2)     // Catch:{ Exception -> 0x072f }
            return
        L_0x0506:
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x072f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x072f }
            if (r6 != 0) goto L_0x0573
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x072f }
            boolean r6 = r1.b((java.lang.String) r6)     // Catch:{ Exception -> 0x072f }
            if (r6 == 0) goto L_0x0573
            int r2 = net.one97.paytm.moneytransfer.R.string.mt_transfer_to_same_vpa     // Catch:{ Exception -> 0x072f }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x072f }
            r3[r8] = r0     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r1.W     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x052f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x052f
            java.lang.String r0 = r0.getBankName()     // Catch:{ Exception -> 0x072f }
            goto L_0x0530
        L_0x052f:
            r0 = r4
        L_0x0530:
            r3[r5] = r0     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.D     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0557
            java.lang.String r4 = r1.D     // Catch:{ Exception -> 0x072f }
            if (r4 != 0) goto L_0x053d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x053d:
            int r4 = r4.length()     // Catch:{ Exception -> 0x072f }
            int r4 = r4 + -4
            if (r0 == 0) goto L_0x054f
            java.lang.String r4 = r0.substring(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x072f }
            goto L_0x0557
        L_0x054f:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x072f }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)     // Catch:{ Exception -> 0x072f }
            throw r0     // Catch:{ Exception -> 0x072f }
        L_0x0557:
            r0 = 2
            r3[r0] = r4     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.getString(r2, r3)     // Catch:{ Exception -> 0x072f }
            java.lang.String r2 = "getString(R.string.mt_tr…ForPayment!!.length - 4))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x072f }
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()     // Catch:{ Exception -> 0x072f }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x072f }
            int r3 = net.one97.paytm.moneytransfer.R.string.error     // Catch:{ Exception -> 0x072f }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x072f }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x072f }
            return
        L_0x0573:
            boolean r0 = r1.F     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0609
            java.lang.String r0 = r1.Z     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0609
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0609
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x058e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x058e:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.Z     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0599
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x0599:
            double r11 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.X     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r11, (double) r6)     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0609
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x05ac
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x05ac:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x072f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x072f }
            r0.<init>()     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r11)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r4 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r4 != 0) goto L_0x05d6
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x05d6:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x072f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x072f }
            r5[r8] = r0     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.getString(r6, r5)     // Catch:{ Exception -> 0x072f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x072f }
            r4.setText(r0)     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x05ec
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x05ec:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            if (r3 != 0) goto L_0x05f5
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x05f5:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x072f }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x072f }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0605
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x072f }
        L_0x0605:
            r0.requestFocus()     // Catch:{ Exception -> 0x072f }
            return
        L_0x0609:
            boolean r0 = r1.F     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0694
            java.lang.String r0 = r1.Z     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0694
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0694
            java.lang.String r0 = r1.Z     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0624
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x0624:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.X     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r6, (double) r9)     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0694
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0637
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0637:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x072f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x072f }
            r0.<init>()     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r4 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r4 != 0) goto L_0x0661
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0661:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x072f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x072f }
            r5[r8] = r0     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.getString(r6, r5)     // Catch:{ Exception -> 0x072f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x072f }
            r4.setText(r0)     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0677
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0677:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            if (r3 != 0) goto L_0x0680
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x0680:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x072f }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x072f }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0690
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x072f }
        L_0x0690:
            r0.requestFocus()     // Catch:{ Exception -> 0x072f }
            return
        L_0x0694:
            boolean r0 = r1.F     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0733
            java.lang.String r0 = r1.Z     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0733
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x072f }
            if (r0 == 0) goto L_0x0733
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x06af
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x06af:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.X     // Catch:{ Exception -> 0x072f }
            android.content.Context r4 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r4)     // Catch:{ Exception -> 0x072f }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r9, (double) r6)     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0733
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x06ca
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x06ca:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x072f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x072f }
            r0.<init>()     // Catch:{ Exception -> 0x072f }
            android.content.Context r4 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            int r4 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r4 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x072f }
            r0.append(r4)     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r4 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r4 != 0) goto L_0x06fc
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x06fc:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x072f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x072f }
            r5[r8] = r0     // Catch:{ Exception -> 0x072f }
            java.lang.String r0 = r1.getString(r6, r5)     // Catch:{ Exception -> 0x072f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x072f }
            r4.setText(r0)     // Catch:{ Exception -> 0x072f }
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x0712
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x072f }
        L_0x0712:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x072f }
            if (r3 != 0) goto L_0x071b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x072f }
        L_0x071b:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x072f }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x072f }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x072f }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f54548a     // Catch:{ Exception -> 0x072f }
            if (r0 != 0) goto L_0x072b
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x072f }
        L_0x072b:
            r0.requestFocus()     // Catch:{ Exception -> 0x072f }
            return
        L_0x072f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0733:
            boolean r0 = r1.J
            if (r0 == 0) goto L_0x075c
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.upi.util.UpiUtils.doShowSecurityPopUp(r0)
            if (r0 == 0) goto L_0x075c
            net.one97.paytm.moneytransfer.view.b.a r0 = new net.one97.paytm.moneytransfer.view.b.a
            r0.<init>()
            net.one97.paytm.moneytransfer.view.fragments.n$aa r2 = new net.one97.paytm.moneytransfer.view.fragments.n$aa
            r2.<init>(r1)
            net.one97.paytm.moneytransfer.view.b.a$d r2 = (net.one97.paytm.moneytransfer.view.b.a.d) r2
            r0.a((net.one97.paytm.moneytransfer.view.b.a.d) r2)
            androidx.fragment.app.j r2 = r16.getChildFragmentManager()
            java.lang.String r3 = ""
            r0.show((androidx.fragment.app.j) r2, (java.lang.String) r3)
            return
        L_0x075c:
            r16.v()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.r():void");
    }

    public static final class aa implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54556a;

        aa(n nVar) {
            this.f54556a = nVar;
        }

        public final void onDismiss() {
            this.f54556a.v();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String s() {
        /*
            r2 = this;
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r2.V
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            androidx.lifecycle.y<java.lang.String> r0 = r0.f54681f
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r0 = ""
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.s():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r5 = r5.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aF
            if (r0 == 0) goto L_0x0070
            java.util.List<? extends net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aG
            if (r0 != 0) goto L_0x000b
            kotlin.g.b.k.a()
        L_0x000b:
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0070
            java.lang.Object r1 = r0.next()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
            java.lang.String r2 = r1.getVirtualAddress()
            r3 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r3)
            if (r2 == 0) goto L_0x000f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getCreditBank()
            if (r2 == 0) goto L_0x000f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getCreditBank()
            java.lang.String r4 = "upiProfileDefaultBank.creditBank"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.getAccount()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = r7.W
            r6 = 0
            if (r5 == 0) goto L_0x0049
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = r5.getAccount()
            goto L_0x004a
        L_0x0049:
            r5 = r6
        L_0x004a:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r3)
            if (r2 == 0) goto L_0x000f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getCreditBank()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r1 = r1.getIfsc()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r7.W
            if (r2 == 0) goto L_0x0069
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x0069
            java.lang.String r6 = r2.getIfsc()
        L_0x0069:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)
            if (r1 == 0) goto L_0x000f
            return r3
        L_0x0070:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.b(java.lang.String):boolean");
    }

    private static boolean a(String str, String str2) {
        try {
            if (Double.compare(Double.parseDouble(str), Double.parseDouble(str2)) <= 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = (r0 = (r0 = r0.getDebitBank()).getBankMetaData()).getPerTxnLimit();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean t() {
        /*
            r7 = this;
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r7.W
            r1 = 0
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.upi.common.upi.UpiBankMetaData r0 = r0.getBankMetaData()
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = r0.getPerTxnLimit()
            if (r0 == 0) goto L_0x001c
            int r0 = java.lang.Integer.parseInt(r0)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r7.S = r0
            int r0 = r7.S
            if (r0 > 0) goto L_0x0024
            return r1
        L_0x0024:
            java.lang.String r2 = r7.X
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = (double) r0
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r2, (double) r3, (double) r5)
            if (r0 != 0) goto L_0x0031
            r0 = 1
            return r0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.t():boolean");
    }

    private void b(int i2) {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, i2);
    }

    public final void f() {
        AccountProviderActivity.a((Fragment) this, 31);
    }

    /* access modifiers changed from: private */
    public final void u() {
        Dialog dialog;
        Dialog dialog2 = this.C;
        if (dialog2 != null) {
            if (dialog2 == null) {
                kotlin.g.b.k.a();
            }
            if (dialog2.isShowing() && (dialog = this.C) != null) {
                dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void v() {
        String str;
        Bundle arguments;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f54548a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        this.X = com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText.getText()));
        CommentsEditText commentsEditText = this.p;
        if (commentsEditText == null) {
            kotlin.g.b.k.a("messageET");
        }
        this.Y = String.valueOf(commentsEditText.getText());
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("username") : null;
        if (!com.paytm.utility.a.m(getActivity())) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof MoneyTransferV3Activity)) {
                activity = null;
            }
            MoneyTransferV3Activity moneyTransferV3Activity = (MoneyTransferV3Activity) activity;
            if (moneyTransferV3Activity != null) {
                moneyTransferV3Activity.a(getString(R.string.no_connection), getResources().getString(R.string.no_internet), getString(R.string.ok));
                return;
            }
            return;
        }
        if (this.aI == MoneyTransferV3Activity.d.VPA) {
            if (A()) {
                z();
                if (this.J) {
                    this.y = MoneyTransferV3Activity.a.VPA;
                    this.z = UpiConstants.MoneyTransferPaymentOption.UPI;
                    CharSequence charSequence = string;
                    if ((charSequence == null || kotlin.m.p.a(charSequence)) && (arguments = getArguments()) != null) {
                        arguments.putString("username", "NA");
                    }
                }
                w();
                str = "upi";
            } else {
                return;
            }
        } else if (this.aI == MoneyTransferV3Activity.d.SAVINGS_ACCOUNT) {
            u();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            if (!b2.c(activity2)) {
                x();
            } else {
                F();
            }
            str = "paytm_bank";
        } else {
            str = "";
        }
        c(str);
    }

    private final void w() {
        e.a aVar;
        net.one97.paytm.moneytransfer.viewmodel.e eVar = this.U;
        UPIBankHealthResponseModel uPIBankHealthResponseModel = null;
        if (eVar != null) {
            aVar = eVar.f54731d;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            uPIBankHealthResponseModel = aVar.f54738b;
        }
        if (uPIBankHealthResponseModel != null) {
            a(aVar);
        } else {
            M();
        }
    }

    private final void c(String str) {
        if (this.aJ == MoneyTransferV3Activity.c.NEW_ACCOUNT.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "new_account_entered");
        } else if (this.aJ == MoneyTransferV3Activity.c.BENEFICIARY_LIST.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "saved_account");
        } else if (this.aJ == MoneyTransferV3Activity.c.PHONEBOOK.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "phonebook");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r1 = r1.f54680e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r11 = this;
            r0 = r11
            r1 = r16
            net.one97.paytm.moneytransfer.utils.k r2 = new net.one97.paytm.moneytransfer.utils.k
            r3 = r0
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r4 = r0
            net.one97.paytm.common.a r4 = (net.one97.paytm.common.a) r4
            r5 = 0
            r2.<init>((androidx.fragment.app.Fragment) r3, (net.one97.paytm.common.a) r4, (net.one97.paytm.upi.common.upi.CommonPayParams) r5)
            r2.b()
            r3 = 0
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x001e
            java.lang.String r6 = "\\n"
            java.lang.String r1 = kotlin.m.p.a(r1, r6, r4, r3)
            goto L_0x001f
        L_0x001e:
            r1 = r5
        L_0x001f:
            if (r1 == 0) goto L_0x0029
            java.lang.String r6 = "\\r"
            java.lang.String r1 = kotlin.m.p.a(r1, r6, r4, r3)
            r6 = r1
            goto L_0x002a
        L_0x0029:
            r6 = r5
        L_0x002a:
            boolean r1 = r11.H()
            if (r1 == 0) goto L_0x0033
            r2.a()
        L_0x0033:
            net.one97.paytm.moneytransfer.viewmodel.b r1 = r0.V
            if (r1 != 0) goto L_0x003c
            java.lang.String r3 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x003c:
            if (r1 == 0) goto L_0x004a
            androidx.lifecycle.y<java.lang.String> r1 = r1.f54680e
            if (r1 == 0) goto L_0x004a
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            goto L_0x004b
        L_0x004a:
            r10 = r5
        L_0x004b:
            r1 = r2
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        FragmentActivity activity;
        String str;
        FragmentActivity activity2;
        FragmentActivity activity3;
        FragmentActivity activity4;
        FragmentActivity activity5;
        super.onActivityResult(i2, i3, intent);
        Serializable serializable = null;
        if (i2 == 3333) {
            if (i3 == -1) {
                if (intent != null) {
                    serializable = intent.getSerializableExtra("imps_data");
                }
                if (serializable != null) {
                    b((UpiBaseDataModel) (CJRMoneyTransferIMPSInitiateDataModel) serializable);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
            } else if (this.L && (activity5 = getActivity()) != null) {
                activity5.finish();
            }
        } else if (i2 == 2020) {
            if (i3 == 0) {
                if (this.L && (activity4 = getActivity()) != null) {
                    activity4.finish();
                }
            } else if (i3 == -1 && intent != null && intent.hasExtra("verifier_imps_data")) {
                Serializable serializableExtra = intent.getSerializableExtra("verifier_imps_data");
                if (!(serializableExtra instanceof CJRMoneyTransferIMPSInitiateDataModel)) {
                    serializableExtra = null;
                }
                b((UpiBaseDataModel) (CJRMoneyTransferIMPSInitiateDataModel) serializableExtra);
            }
        } else if (i2 == 4444) {
            n nVar = this;
            if (i3 == -1) {
                nVar.v();
            } else if (nVar.L) {
                FragmentActivity activity6 = nVar.getActivity();
                if (activity6 == null) {
                    kotlin.g.b.k.a();
                }
                activity6.finish();
            }
        } else if (i2 == 2011) {
            if (i3 == -1) {
                v();
            } else if ((this.L || this.N || this.O || this.J || this.P) && (activity3 = getActivity()) != null) {
                activity3.finish();
            }
        } else if (i2 == 2012) {
            if (i3 == -1) {
                if (getActivity() instanceof MoneyTransferV3Activity) {
                    FragmentActivity activity7 = getActivity();
                    if (activity7 != null) {
                        ((MoneyTransferV3Activity) activity7).p();
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity");
                }
            } else if ((this.L || this.N || this.O || this.J || this.P) && (activity2 = getActivity()) != null) {
                activity2.finish();
            }
        } else if (i2 == 31 && i3 == -1) {
            if (intent != null) {
                serializable = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            }
            if (serializable != null) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializable;
                Fragment fragment = this;
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                BankVpaCreationActivity.a(fragment, accountProvider, bVar.b().getValue(), 34);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
        } else if (i2 == 34 && i3 == -1) {
            if (getActivity() instanceof MoneyTransferV3Activity) {
                FragmentActivity activity8 = getActivity();
                if (activity8 != null) {
                    ((MoneyTransferV3Activity) activity8).p();
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity");
            }
        } else if (i2 == 2013) {
            if (i3 == -1) {
                Uri uri = this.B;
                if (uri == null || (str = uri.getQueryParameter("pa")) == null) {
                    str = "";
                }
                kotlin.g.b.k.a((Object) str, "uri?.getQueryParameter(\"pa\") ?: \"\"");
                net.one97.paytm.moneytransfer.viewmodel.b bVar2 = this.V;
                if (bVar2 == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                bVar2.a(str, String.valueOf(this.B));
                return;
            }
            FragmentActivity activity9 = getActivity();
            if (activity9 != null) {
                activity9.finish();
            }
        } else if (i2 == 10) {
            if (i3 == -1) {
                v();
            } else if ((this.L || this.N || this.O || this.J || this.P) && (activity = getActivity()) != null) {
                activity.finish();
            }
        } else if (i2 == 352) {
            if (i3 == -1 && (getActivity() instanceof MoneyTransferV3Activity)) {
                FragmentActivity activity10 = getActivity();
                if (activity10 != null) {
                    ((MoneyTransferV3Activity) activity10).p();
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity");
            }
        } else if (i2 == this.f54550d && i3 == -1) {
            P();
        } else if (i2 == this.f54551e && i3 == -1 && (getActivity() instanceof MoneyTransferV3Activity)) {
            S();
        }
    }

    private final void a(Bundle bundle) {
        net.one97.paytm.upi.deeplink.b bVar = new net.one97.paytm.upi.deeplink.b();
        bVar.f66689d = bundle;
        bVar.f66688c = true;
        bVar.f66687b = this.B;
        bVar.show(getChildFragmentManager(), bVar.f66686a);
        a(false);
    }

    private void b(UpiBaseDataModel upiBaseDataModel) {
        FragmentActivity activity;
        androidx.lifecycle.y<PPBCurrentAccountModel> yVar;
        Intent intent;
        Intent intent2;
        androidx.lifecycle.y<String> yVar2;
        if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            Intent intent3 = new Intent(getActivity(), MoneyTransferPostTransactionActivity.class);
            intent3.putExtra("key_bundle", upiBaseDataModel);
            Bundle arguments = getArguments();
            String str = null;
            intent3.putExtra(LocaleDBContract.BaseTable.KEY, arguments != null ? arguments.getString("username") : null);
            intent3.putExtra("key_amount", UpiUtils.convertToTwoPlaces(this.X));
            intent3.putExtra("key_comment", this.Y);
            Bundle arguments2 = getArguments();
            intent3.putExtra("key_bank_name", arguments2 != null ? arguments2.getString("bankname") : null);
            intent3.putExtra("key_account_no_vpa_adhaar", this.y);
            intent3.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, this.L);
            Bundle arguments3 = getArguments();
            intent3.putExtra("key_account_number", arguments3 != null ? arguments3.getString("vpa") : null);
            Bundle arguments4 = getArguments();
            intent3.putExtra("key_ppb_account_number", arguments4 != null ? arguments4.getString("vpa") : null);
            net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
            if (bVar == null) {
                kotlin.g.b.k.a("moneyTransferActivityViewModel");
            }
            intent3.putExtra("key_payer_ppb_account_number", (bVar == null || (yVar2 = bVar.f54680e) == null) ? null : yVar2.getValue());
            intent3.putExtra("is_deeplink", this.F);
            Bundle arguments5 = getArguments();
            intent3.putExtra("ref_id", arguments5 != null ? arguments5.getString(UpiConstants.EXTRA_KEY_REF_ID) : null);
            intent3.putExtra("ifsc", C());
            FragmentActivity activity2 = getActivity();
            boolean z2 = false;
            if (!(activity2 == null || (intent2 = activity2.getIntent()) == null)) {
                z2 = intent2.getBooleanExtra("is_from_chat_flow", false);
            }
            intent3.putExtra("is_from_chat_flow", z2);
            intent3.putExtra("key_account_number_selected", D());
            intent3.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, this.J);
            Bundle arguments6 = getArguments();
            intent3.putExtra("picture", arguments6 != null ? arguments6.getString("picture") : null);
            intent3.putExtra("uni_p2p_landing_intent_extra_theme", this.aK);
            intent3.putExtra("from_app_evoke", this.R);
            FragmentActivity activity3 = getActivity();
            intent3.putExtra("split_bill_data", (activity3 == null || (intent = activity3.getIntent()) == null) ? null : intent.getSerializableExtra("split_bill_data"));
            if (H()) {
                net.one97.paytm.moneytransfer.viewmodel.b bVar2 = this.V;
                if (bVar2 == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                intent3.putExtra("ppb_ica", (bVar2 == null || (yVar = bVar2.q) == null) ? null : yVar.getValue());
            }
            if (this.R) {
                intent3.addFlags(33554432);
            }
            startActivity(intent3);
            if (this.M && kotlin.m.p.a("SUCCESS", ((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel).getmStatus(), true) && !TextUtils.isEmpty(this.ag)) {
                if (TextUtils.isEmpty(this.ah) || !kotlin.g.b.k.a((Object) "QR_CODE", (Object) this.ah)) {
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    FragmentActivity activity4 = getActivity();
                    if (activity4 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity4, "activity!!");
                    Context context = activity4;
                    Bundle arguments7 = getArguments();
                    if (arguments7 != null) {
                        str = arguments7.getString("username");
                    }
                    String str2 = str;
                    if (str2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) str2, "arguments?.getString(BundleConstants.USERNAME)!!");
                    String str3 = this.ag;
                    if (str3 == null) {
                        kotlin.g.b.k.a();
                    }
                    System.currentTimeMillis();
                    String str4 = this.X;
                    if (str4 == null) {
                        kotlin.g.b.k.a();
                    }
                    b2.a(context, str2, str3, str4, false);
                } else {
                    d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    FragmentActivity activity5 = getActivity();
                    if (activity5 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity5, "activity!!");
                    Context context2 = activity5;
                    Bundle arguments8 = getArguments();
                    if (arguments8 != null) {
                        str = arguments8.getString("username");
                    }
                    String str5 = str;
                    if (str5 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) str5, "arguments?.getString(BundleConstants.USERNAME)!!");
                    String str6 = this.ag;
                    if (str6 == null) {
                        kotlin.g.b.k.a();
                    }
                    System.currentTimeMillis();
                    String str7 = this.X;
                    if (str7 == null) {
                        kotlin.g.b.k.a();
                    }
                    b3.a(context2, str5, str6, str7, true);
                }
            }
            K();
            if (!this.R && (activity = getActivity()) != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity6 = getActivity();
            if (activity6 != null) {
                activity6.finish();
            }
        }
    }

    private final void x() {
        Intent intent;
        try {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            intent = b2.a((Activity) activity);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            intent = null;
        }
        startActivityForResult(intent, 4444);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r2 == null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y() {
        /*
            r10 = this;
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            java.lang.String r1 = "@"
            android.os.Bundle r2 = r10.getArguments()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = "vpa"
            if (r2 == 0) goto L_0x0012
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0079 }
            if (r2 != 0) goto L_0x0014
        L_0x0012:
            java.lang.String r2 = ""
        L_0x0014:
            java.lang.String r4 = "arguments?.getString(Bun…_OR_ACCOUNT_NUMBER) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0079 }
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0079 }
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0079 }
            r6 = 0
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6)     // Catch:{ Exception -> 0x0079 }
            if (r4 == 0) goto L_0x007d
            android.os.Bundle r4 = r10.getArguments()     // Catch:{ Exception -> 0x0079 }
            if (r4 == 0) goto L_0x0078
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0079 }
            r7 = 6
            int r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String) r1, (int) r6, (boolean) r6, (int) r7)     // Catch:{ Exception -> 0x0079 }
            int r5 = r5 + 1
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            if (r2 == 0) goto L_0x0072
            java.lang.String r5 = r2.substring(r5)     // Catch:{ Exception -> 0x0079 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x0079 }
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0079 }
            int r1 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r1, (int) r6, (boolean) r6, (int) r7)     // Catch:{ Exception -> 0x0079 }
            int r1 = r1 + 1
            if (r2 == 0) goto L_0x006c
            java.lang.String r1 = r2.substring(r1)     // Catch:{ Exception -> 0x0079 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0079 }
            if (r1 == 0) goto L_0x0066
            java.lang.String r0 = r1.toLowerCase()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = kotlin.m.p.a(r2, r5, r0, r6)     // Catch:{ Exception -> 0x0079 }
            r4.putString(r3, r0)     // Catch:{ Exception -> 0x0079 }
            return
        L_0x0066:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0079 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0079 }
            throw r0     // Catch:{ Exception -> 0x0079 }
        L_0x006c:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0079 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0079 }
            throw r0     // Catch:{ Exception -> 0x0079 }
        L_0x0072:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0079 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0079 }
            throw r0     // Catch:{ Exception -> 0x0079 }
        L_0x0078:
            return
        L_0x0079:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.y():void");
    }

    private final void z() {
        if (TextUtils.isEmpty(this.Y)) {
            this.Y = "NA";
        }
        this.X = UpiUtils.convertToTwoPlaces(this.X);
        if (TextUtils.isEmpty(this.ac)) {
            this.ad = UpiUtils.getUpiSequenceNo();
        } else {
            this.ad = this.ac;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = r0.f54032a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r3 = this;
            boolean r0 = r3.H
            if (r0 == 0) goto L_0x005c
            android.widget.TextView r0 = r3.f54554h
            if (r0 != 0) goto L_0x000d
            java.lang.String r1 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000d:
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005c
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r3.V
            if (r0 != 0) goto L_0x0026
            java.lang.String r1 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0026:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.viewmodel.b$b>> r0 = r0.p
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.moneytransfer.model.c r0 = (net.one97.paytm.moneytransfer.model.c) r0
            if (r0 == 0) goto L_0x003f
            net.one97.paytm.moneytransfer.model.d r0 = r0.f54032a
            if (r0 == 0) goto L_0x003f
            net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.LOADING
            boolean r0 = r0.equals(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005c
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r1 = net.one97.paytm.moneytransfer.R.string.upi_qr_vpa_verify_fetch_message
            r2 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            return
        L_0x005c:
            boolean r0 = r3.Q
            if (r0 == 0) goto L_0x006a
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = r3.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r0 != r1) goto L_0x006a
            r3.E()
            return
        L_0x006a:
            r3.r()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.g():void");
    }

    private final boolean A() {
        if (Build.VERSION.SDK_INT >= 23 && !B()) {
            return false;
        }
        if (UpiUtils.isSimAvailable(getActivity())) {
            return true;
        }
        b((int) CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        return false;
    }

    private final boolean B() {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 101);
        return false;
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 101) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                FragmentActivity activity = getActivity();
                if (!(activity instanceof MoneyTransferV3Activity)) {
                    activity = null;
                }
                MoneyTransferV3Activity moneyTransferV3Activity = (MoneyTransferV3Activity) activity;
                if (moneyTransferV3Activity != null) {
                    moneyTransferV3Activity.a(getString(R.string.upi_mandatory_permission_denied), getString(R.string.upi_read_phone_state_permission_text_new), getString(R.string.upi_grant_permission));
                }
            } else {
                v();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        b(upiBaseDataModel);
    }

    public final void onResume() {
        super.onResume();
    }

    private final String C() {
        if (this.y == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return arguments.getString("ifsc");
            }
            return null;
        } else if (this.y == MoneyTransferV3Activity.a.VPA) {
            return "UPI";
        } else {
            return null;
        }
    }

    private final String D() {
        if (this.y == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
            return getString(R.string.upi_acc_no_prefix);
        }
        if (this.y == MoneyTransferV3Activity.a.VPA) {
            return getString(R.string.money_transfer_upi_string);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r0 = r4.i()
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.app.c$a r0 = new androidx.appcompat.app.c$a
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            if (r1 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            r1 = 0
            r0.a((boolean) r1)
            android.view.LayoutInflater r1 = r4.getLayoutInflater()
            java.lang.String r2 = "this.layoutInflater"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 0
            if (r1 == 0) goto L_0x002d
            int r3 = net.one97.paytm.moneytransfer.R.layout.mt_custom_alert_dialog
            android.view.View r1 = r1.inflate(r3, r2)
            goto L_0x002e
        L_0x002d:
            r1 = r2
        L_0x002e:
            r0.a((android.view.View) r1)
            if (r1 == 0) goto L_0x003c
            int r3 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_title
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            if (r3 == 0) goto L_0x0044
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x0044:
            if (r1 == 0) goto L_0x004f
            int r5 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_message
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x0050
        L_0x004f:
            r5 = r2
        L_0x0050:
            if (r5 == 0) goto L_0x0057
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x0057:
            androidx.appcompat.app.c r5 = r0.a()
            java.lang.String r6 = "dialogBuilder.create()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r1 == 0) goto L_0x006b
            int r6 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_btn_positive
            android.view.View r6 = r1.findViewById(r6)
            r2 = r6
            android.widget.Button r2 = (android.widget.Button) r2
        L_0x006b:
            if (r2 == 0) goto L_0x0077
            net.one97.paytm.moneytransfer.view.fragments.n$v r6 = new net.one97.paytm.moneytransfer.view.fragments.n$v
            r6.<init>(r4, r5)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
        L_0x0077:
            r5.show()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.b(java.lang.String, java.lang.String):void");
    }

    static final class v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54578a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f54579b;

        v(n nVar, androidx.appcompat.app.c cVar) {
            this.f54578a = nVar;
            this.f54579b = cVar;
        }

        public final void onClick(View view) {
            this.f54579b.dismiss();
            FragmentActivity activity = this.f54578a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void E() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.mt_verify_merchant_dialog, (ViewGroup) null, false);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        androidx.appcompat.app.c a2 = new c.a(activity2).a(inflate).a();
        kotlin.g.b.k.a((Object) a2, "AlertDialog.Builder(acti…ew)\n            .create()");
        ((TextView) inflate.findViewById(R.id.recent_confirm_btn)).setOnClickListener(new x(this, a2));
        ((TextView) inflate.findViewById(R.id.recent_cancel_btn)).setOnClickListener(new y(a2));
        a2.show();
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54581a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f54582b;

        x(n nVar, androidx.appcompat.app.c cVar) {
            this.f54581a = nVar;
            this.f54582b = cVar;
        }

        public final void onClick(View view) {
            this.f54582b.dismiss();
            this.f54581a.r();
        }
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f54583a;

        y(androidx.appcompat.app.c cVar) {
            this.f54583a = cVar;
        }

        public final void onClick(View view) {
            this.f54583a.dismiss();
        }
    }

    private final void F() {
        if (H()) {
            J();
        } else if (G()) {
            I();
        } else {
            h();
        }
    }

    private final boolean G() {
        String str = this.X;
        Double d2 = null;
        Double valueOf = str != null ? Double.valueOf(Double.parseDouble(str)) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        double doubleValue = valueOf.doubleValue();
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
        if (bVar == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        if (bVar != null) {
            d2 = Double.valueOf(bVar.l);
        }
        return doubleValue > d2.doubleValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean H() {
        /*
            r2 = this;
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r2.W
            if (r0 == 0) goto L_0x000f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getAccountType()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = "CURRENT"
            boolean r0 = r1.equals(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.H():boolean");
    }

    private final void I() {
        net.one97.paytm.moneytransfer.viewmodel.e eVar = this.U;
        if (eVar != null) {
            String str = this.X;
            Bundle arguments = getArguments();
            String str2 = null;
            String string = arguments != null ? arguments.getString("ifsc") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str2 = arguments2.getString("username");
            }
            eVar.a(str, string, str2);
        }
    }

    private final void J() {
        net.one97.paytm.moneytransfer.viewmodel.e eVar = this.U;
        if (eVar != null) {
            String str = this.X;
            Bundle arguments = getArguments();
            String str2 = null;
            String string = arguments != null ? arguments.getString("ifsc") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str2 = arguments2.getString("username");
            }
            eVar.b(str, string, str2);
        }
    }

    public final void h() {
        String str;
        Bundle arguments = getArguments();
        String str2 = null;
        String string = arguments != null ? arguments.getString("username") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("username") : null;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString("bankname")) == null) {
            str = "";
        }
        String str3 = str;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString("ifsc") : null;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            str2 = arguments5.getString("vpa");
        }
        a(string, string2, str3, string3, str2, com.paytm.utility.a.b((Context) getActivity()), this.X, this.Y);
    }

    public final boolean i() {
        if (getActivity() == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        return !valueOf.booleanValue() && isResumed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r1.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void K() {
        /*
            r3 = this;
            net.one97.paytm.moneytransfer.utils.g$a r0 = net.one97.paytm.moneytransfer.utils.g.f54162a
            android.content.Context r0 = r3.getContext()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.W
            r2 = 0
            if (r1 == 0) goto L_0x0016
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = r1.getAccount()
            goto L_0x0017
        L_0x0016:
            r1 = r2
        L_0x0017:
            net.one97.paytm.moneytransfer.utils.g.a.a(r0, r1)
            net.one97.paytm.moneytransfer.utils.g$a r0 = net.one97.paytm.moneytransfer.utils.g.f54162a
            android.content.Context r0 = r3.getContext()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.W
            if (r1 == 0) goto L_0x002e
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = r1.getIfsc()
        L_0x002e:
            net.one97.paytm.moneytransfer.utils.g.a.b(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.K():void");
    }

    private final void L() {
        g.a aVar = net.one97.paytm.moneytransfer.utils.g.f54162a;
        String a2 = g.a.a(getContext());
        g.a aVar2 = net.one97.paytm.moneytransfer.utils.g.f54162a;
        String b2 = g.a.b(getContext());
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(b2)) {
            ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
            kotlin.j.d a3 = arrayList != null ? kotlin.a.k.a((Collection<?>) arrayList) : null;
            if (a3 == null) {
                kotlin.g.b.k.a();
            }
            int i2 = a3.f47939a;
            int i3 = a3.f47940b;
            if (i2 <= i3) {
                while (true) {
                    UpiProfileDefaultBank upiProfileDefaultBank = arrayList.get(i2);
                    kotlin.g.b.k.a((Object) upiProfileDefaultBank, "upiList[i]");
                    UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
                    if (upiProfileDefaultBank2 != null) {
                        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank2.getDebitBank();
                        kotlin.g.b.k.a((Object) debitBank, "currentProfileBank!!.debitBank");
                        String account = debitBank.getAccount();
                        if (a2 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (kotlin.m.p.a(account, a2, true)) {
                            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank2.getDebitBank();
                            kotlin.g.b.k.a((Object) debitBank2, "currentProfileBank!!.debitBank");
                            String ifsc = debitBank2.getIfsc();
                            if (b2 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (kotlin.m.p.a(ifsc, b2, true)) {
                                this.f54549b = i2;
                                this.aL = i2;
                                return;
                            }
                        }
                    }
                    if (i2 != i3) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void M() {
        net.one97.paytm.moneytransfer.viewmodel.e eVar = this.U;
        if (eVar != null) {
            eVar.a();
        }
    }

    private final void a(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
        if (this.aL == this.f54549b) {
            c(uPIBankHealthResponseModel);
        } else {
            M();
        }
    }

    private final void b(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
        String str;
        if (i() && uPIBankHealthResponseModel != null) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putString("payer_or_payee", uPIBankHealthResponseModel.getBankDown());
            bundle.putString("neft_error_message", uPIBankHealthResponseModel.getMsg());
            bundle.putString("neft_tooltip_message", uPIBankHealthResponseModel.getNote());
            bundle.putString("category", uPIBankHealthResponseModel.getCategory());
            if (this.T || TextUtils.isEmpty(uPIBankHealthResponseModel.getBankDown())) {
                str = "upi";
            } else {
                Bundle arguments = getArguments();
                str = arguments != null ? arguments.getString("ifsc") : null;
            }
            bundle.putString("ifsc", str);
            cVar.setArguments(bundle);
            cVar.show(getChildFragmentManager(), "");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        r5 = (r5 = r5.get(r4.aL)).getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c(net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r5) {
        /*
            r4 = this;
            boolean r0 = r4.i()
            if (r0 == 0) goto L_0x007e
            if (r5 == 0) goto L_0x007e
            net.one97.paytm.moneytransfer.view.fragments.c r0 = new net.one97.paytm.moneytransfer.view.fragments.c
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = r5.getBankDown()
            java.lang.String r3 = "payer_or_payee"
            r1.putString(r3, r2)
            java.lang.String r2 = r5.getMsg()
            java.lang.String r3 = "neft_error_message"
            r1.putString(r3, r2)
            java.lang.String r2 = r5.getNote()
            java.lang.String r3 = "neft_tooltip_message"
            r1.putString(r3, r2)
            java.lang.String r5 = r5.getCategory()
            java.lang.String r2 = "category"
            r1.putString(r2, r5)
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r5 = r4.aF
            java.lang.String r2 = "bank_count"
            if (r5 == 0) goto L_0x004f
            r3 = r5
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x004f
            int r5 = r5.size()
            r1.putInt(r2, r5)
            goto L_0x0053
        L_0x004f:
            r5 = 0
            r1.putInt(r2, r5)
        L_0x0053:
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r5 = r4.aF
            if (r5 == 0) goto L_0x006c
            int r2 = r4.aL
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r5
            if (r5 == 0) goto L_0x006c
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
            if (r5 == 0) goto L_0x006c
            java.lang.String r5 = r5.getIfsc()
            goto L_0x006d
        L_0x006c:
            r5 = 0
        L_0x006d:
            java.lang.String r2 = "ifsc"
            r1.putString(r2, r5)
            r0.setArguments(r1)
            androidx.fragment.app.j r5 = r4.getChildFragmentManager()
            java.lang.String r1 = ""
            r0.show((androidx.fragment.app.j) r5, (java.lang.String) r1)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.c(net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel):void");
    }

    private final void N() {
        if (com.paytm.utility.a.m(getContext())) {
            View view = this.aB;
            if (view == null) {
                kotlin.g.b.k.a("accountsLoadingLayout");
            }
            view.setVisibility(0);
            RelativeLayout relativeLayout = this.o;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mOpenBottomSheetRlv");
            }
            relativeLayout.setVisibility(8);
            LinearLayout linearLayout = this.ak;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mPayWrapper");
            }
            linearLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.aD;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("accountsLoadingAnimationView");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
            TextView textView = this.m;
            if (textView == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            if (textView != null) {
                textView.setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void O() {
        View view = this.aB;
        if (view == null) {
            kotlin.g.b.k.a("accountsLoadingLayout");
        }
        view.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.aD;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("accountsLoadingAnimationView");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        TextView textView = this.m;
        if (textView == null) {
            kotlin.g.b.k.a("mProceedPayment");
        }
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void P() {
        /*
            r4 = this;
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.a.m(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0034
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r2 = r0 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r2 != 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r0 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r0
            if (r0 == 0) goto L_0x0033
            int r1 = net.one97.paytm.moneytransfer.R.string.no_connection
            java.lang.String r1 = r4.getString(r1)
            android.content.res.Resources r2 = r4.getResources()
            int r3 = net.one97.paytm.moneytransfer.R.string.no_internet
            java.lang.String r2 = r2.getString(r3)
            int r3 = net.one97.paytm.moneytransfer.R.string.ok
            java.lang.String r3 = r4.getString(r3)
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0033:
            return
        L_0x0034:
            int r0 = net.one97.paytm.moneytransfer.R.string.check_balance
            java.lang.String r0 = r4.getString(r0)
            android.widget.TextView r2 = r4.al
            java.lang.String r3 = "checkBalanceTV"
            if (r2 != 0) goto L_0x0043
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0043:
            if (r2 == 0) goto L_0x004a
            java.lang.CharSequence r2 = r2.getText()
            goto L_0x004b
        L_0x004a:
            r2 = r1
        L_0x004b:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0073
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r4.W
            if (r0 == 0) goto L_0x0059
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r1 = r0.getPaymentMode()
        L_0x0059:
            if (r1 != 0) goto L_0x005c
            return
        L_0x005c:
            int[] r0 = net.one97.paytm.moneytransfer.view.fragments.o.f54591g
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x006f
            r1 = 2
            if (r0 == r1) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            r4.R()
        L_0x006e:
            return
        L_0x006f:
            r4.Q()
            return
        L_0x0073:
            int r0 = net.one97.paytm.moneytransfer.R.string.mt_set_upi_pin
            java.lang.String r0 = r4.getString(r0)
            android.widget.TextView r2 = r4.al
            if (r2 != 0) goto L_0x0080
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0080:
            if (r2 == 0) goto L_0x0087
            java.lang.CharSequence r2 = r2.getText()
            goto L_0x0088
        L_0x0087:
            r2 = r1
        L_0x0088:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c0
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r4.aF
            if (r0 == 0) goto L_0x009b
            boolean r2 = r0.isEmpty()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x009c
        L_0x009b:
            r2 = r1
        L_0x009c:
            if (r2 != 0) goto L_0x00a1
            kotlin.g.b.k.a()
        L_0x00a1:
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00c0
            int r2 = r4.f54549b
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x00c0
            int r2 = r4.f54551e
            if (r0 == 0) goto L_0x00bc
            int r1 = r4.f54549b
            java.lang.Object r0 = r0.get(r1)
            r1 = r0
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
        L_0x00bc:
            r0 = 0
            r4.a((int) r2, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1, (boolean) r0)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.P():void");
    }

    /* access modifiers changed from: private */
    public final void Q() {
        if (this.aM == null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            this.aM = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.f54550d)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        UpiProfileDefaultBank upiProfileDefaultBank2 = this.W;
        upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getDebitBank() : null);
        UpiProfileDefaultBank upiProfileDefaultBank3 = this.W;
        upiProfileDefaultBank.setVirtualAddress(upiProfileDefaultBank3 != null ? upiProfileDefaultBank3.getVirtualAddress() : null);
        UPICheckBalanceHelper uPICheckBalanceHelper = this.aM;
        if (uPICheckBalanceHelper != null) {
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f54548a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        customAmountTextInputEditText.clearFocus();
        CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f54548a;
        if (customAmountTextInputEditText2 == null) {
            kotlin.g.b.k.a("amountET");
        }
        customAmountTextInputEditText2.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        TextView textView = this.al;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        textView.requestFocus();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void R() {
        /*
            r7 = this;
            r7.U()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r7.W
            r1 = 0
            if (r0 == 0) goto L_0x0013
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getAccountType()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 != 0) goto L_0x0017
            return
        L_0x0017:
            int r2 = r0.hashCode()
            r3 = -1704036199(0xffffffff9a6e7899, float:-4.9314664E-23)
            r4 = 0
            r5 = 1
            java.lang.String r6 = "moneyTransferActivityViewModel"
            if (r2 == r3) goto L_0x008b
            r3 = 1844922713(0x6df74959, float:9.5664337E27)
            if (r2 == r3) goto L_0x002b
            goto L_0x00cd
        L_0x002b:
            java.lang.String r2 = "CURRENT"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = r7.ad()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0058
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_new_balance
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = r7.ad()
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r2)
            r1[r4] = r2
            java.lang.String r0 = r7.getString(r0, r1)
            r7.d((java.lang.String) r0)
            r7.j()
            return
        L_0x0058:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r7.V
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x005f:
            if (r0 == 0) goto L_0x00cd
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r7.W
            if (r2 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            net.one97.paytm.moneytransfer.viewmodel.b r3 = r7.V
            if (r3 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x006f:
            if (r3 == 0) goto L_0x0087
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r3 = r3.q
            if (r3 == 0) goto L_0x0087
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r3 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r3
            if (r3 == 0) goto L_0x0087
            net.one97.paytm.common.entity.PPBCurrentAccountModel$Ica r3 = r3.getIca()
            if (r3 == 0) goto L_0x0087
            java.lang.String r1 = r3.getCaId()
        L_0x0087:
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r2, (java.lang.String) r1)
            return
        L_0x008b:
            java.lang.String r1 = "SAVINGS"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = r7.s()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00b8
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_new_balance
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = r7.s()
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r2)
            r1[r4] = r2
            java.lang.String r0 = r7.getString(r0, r1)
            r7.d((java.lang.String) r0)
            r7.j()
            return
        L_0x00b8:
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r7.V
            if (r0 != 0) goto L_0x00bf
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00bf:
            if (r0 == 0) goto L_0x00cd
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r7.W
            if (r1 != 0) goto L_0x00c8
            kotlin.g.b.k.a()
        L_0x00c8:
            java.lang.String r2 = ""
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1, (java.lang.String) r2)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.R():void");
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            c(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            c(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    private final void c(boolean z2) {
        if (isAdded()) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new w(this), childFragmentManager, z2);
        }
    }

    public static final class w implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54580a;

        w(n nVar) {
            this.f54580a = nVar;
        }

        public final void onReEnterClicked() {
            this.f54580a.Q();
        }

        public final void onCreateNewPinClicked() {
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            UpiProfileDefaultBank k = this.f54580a.W;
            String str = null;
            upiProfileDefaultBank.setDebitBank(k != null ? k.getDebitBank() : null);
            UpiProfileDefaultBank k2 = this.f54580a.W;
            if (k2 != null) {
                str = k2.getVirtualAddress();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            n nVar = this.f54580a;
            nVar.a(nVar.f54551e, upiProfileDefaultBank, true);
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (isAdded()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(\n             …alance)\n                )");
            } else {
                str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
            }
            d(str4);
            TextView textView = this.al;
            if (textView == null) {
                kotlin.g.b.k.a("checkBalanceTV");
            }
            textView.setVisibility(0);
        }
    }

    public final void b() {
        j();
    }

    public final void Z_() {
        U();
    }

    private final void S() {
        TextView textView = this.al;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView != null) {
            textView.setText(getString(R.string.check_balance));
        }
        TextView textView2 = this.al;
        if (textView2 == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView2 != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
        }
    }

    private final void d(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.al;
            if (textView == null) {
                kotlin.g.b.k.a("checkBalanceTV");
            }
            if (textView != null) {
                textView.setText(charSequence);
            }
            TextView textView2 = this.al;
            if (textView2 == null) {
                kotlin.g.b.k.a("checkBalanceTV");
            }
            if (textView2 != null) {
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_666666));
            }
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f54548a;
            if (customAmountTextInputEditText == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText.setOnFocusChangeListener(this);
            CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f54548a;
            if (customAmountTextInputEditText2 == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText2.requestFocus();
            a(true);
        }
    }

    private final void T() {
        TextView textView = this.al;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView != null) {
            textView.setText(getString(R.string.mt_set_upi_pin));
        }
        TextView textView2 = this.al;
        if (textView2 == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView2 != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
        }
    }

    private final void U() {
        TextView textView = this.al;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        textView.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.am;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        lottieAnimationView.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = this.am;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        AnimationFactory.startWalletLoader(lottieAnimationView2);
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        LottieAnimationView lottieAnimationView = this.am;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = this.am;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        lottieAnimationView2.setVisibility(8);
        TextView textView = this.al;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        textView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r0.f54680e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V() {
        /*
            r2 = this;
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r2.V
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            if (r0 == 0) goto L_0x0016
            androidx.lifecycle.y<java.lang.String> r0 = r0.f54680e
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            boolean r1 = r2.K
            if (r1 == 0) goto L_0x002d
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002d
            boolean r1 = r2.X()
            if (r1 != 0) goto L_0x002d
            r2.e((java.lang.String) r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.V():void");
    }

    private final void e(String str) {
        if (!Y()) {
            Bundle arguments = getArguments();
            if (!kotlin.m.p.a(str, arguments != null ? arguments.getString("vpa") : null, false)) {
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                upiProfileDefaultBank.setPaymentMode(UpiProfileDefaultBank.PAYMENT_MODE.IMPS);
                upiProfileDefaultBank.setDebitBank(new BankAccountDetails.BankAccount());
                BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank, "savingsAccount.debitBank");
                debitBank.setAccount(str);
                BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
                if (debitBank2 != null) {
                    debitBank2.setIfsc(this.f54552f);
                }
                BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank3, "savingsAccount.debitBank");
                debitBank3.setAccountType("SAVINGS");
                BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank4, "savingsAccount.debitBank");
                debitBank4.setBankName(getString(R.string.money_tranfer_balance_paytm_bank_string));
                BankAccountDetails.BankAccount debitBank5 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank5, "savingsAccount.debitBank");
                debitBank5.setMbeba("Y");
                this.aF.add(upiProfileDefaultBank);
            }
        }
    }

    private final void W() {
        BankAccountDetails.BankAccount bankAccount;
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList != null) {
            Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                UpiProfileDefaultBank next = it2.next();
                String str = this.f54552f;
                UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
                BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
                kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
                if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                    if (next != null) {
                        bankAccount = next.getDebitBank();
                    } else {
                        bankAccount = null;
                    }
                    kotlin.g.b.k.a((Object) bankAccount, "currentSelectedBankObject?.debitBank");
                    String account = bankAccount.getAccount();
                    net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
                    if (bVar == null) {
                        kotlin.g.b.k.a("moneyTransferActivityViewModel");
                    }
                    if (!account.equals((bVar == null || (yVar = bVar.f54680e) == null) ? null : yVar.getValue())) {
                        continue;
                    } else {
                        if (next != null) {
                            payment_mode = next.getPaymentMode();
                        }
                        if (payment_mode == UpiProfileDefaultBank.PAYMENT_MODE.IMPS) {
                            this.aF.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    private final boolean X() {
        BankAccountDetails.BankAccount bankAccount;
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.f54552f;
            UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
            BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                if (next != null) {
                    bankAccount = next.getDebitBank();
                } else {
                    bankAccount = null;
                }
                kotlin.g.b.k.a((Object) bankAccount, "currentSelectedBankObject?.debitBank");
                String account = bankAccount.getAccount();
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                if (!account.equals((bVar == null || (yVar = bVar.f54680e) == null) ? null : yVar.getValue())) {
                    continue;
                } else {
                    if (next != null) {
                        payment_mode = next.getPaymentMode();
                    }
                    if (payment_mode == UpiProfileDefaultBank.PAYMENT_MODE.IMPS) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean Y() {
        BankAccountDetails.BankAccount bankAccount;
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.f54552f;
            UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
            BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                if (next != null) {
                    bankAccount = next.getDebitBank();
                } else {
                    bankAccount = null;
                }
                kotlin.g.b.k.a((Object) bankAccount, "currentSelectedBankObject?.debitBank");
                String account = bankAccount.getAccount();
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                if (!account.equals((bVar == null || (yVar = bVar.f54680e) == null) ? null : yVar.getValue())) {
                    continue;
                } else {
                    if (next != null) {
                        payment_mode = next.getPaymentMode();
                    }
                    if (payment_mode == UpiProfileDefaultBank.PAYMENT_MODE.UPI) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean Z() {
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        UpiProfileDefaultBank upiProfileDefaultBank = arrayList.get(this.f54549b);
        kotlin.g.b.k.a((Object) upiProfileDefaultBank, "vpaList.get(currentSelectedPosition)");
        UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
        return (upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getPaymentMode() : null) == UpiProfileDefaultBank.PAYMENT_MODE.IMPS;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0 = r0.q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aa() {
        /*
            r3 = this;
            boolean r0 = r3.ab()
            if (r0 != 0) goto L_0x0052
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r3.V
            java.lang.String r1 = "moneyTransferActivityViewModel"
            if (r0 != 0) goto L_0x000f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000f:
            r2 = 0
            if (r0 == 0) goto L_0x0015
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.q
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r3.V
            if (r0 != 0) goto L_0x001f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001f:
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.q
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r0 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r0
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r3.V
            if (r0 != 0) goto L_0x0036
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.q
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            if (r0 == 0) goto L_0x0045
            java.lang.Object r0 = r0.getValue()
            r2 = r0
            net.one97.paytm.common.entity.PPBCurrentAccountModel r2 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r2
        L_0x0045:
            android.content.Context r0 = r3.getContext()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = net.one97.paytm.moneytransfer.utils.m.a((android.content.Context) r0, (net.one97.paytm.common.entity.PPBCurrentAccountModel) r2)
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r1 = r3.aF
            r1.add(r0)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.aa():void");
    }

    private final boolean ab() {
        BankAccountDetails.BankAccount bankAccount;
        BankAccountDetails.BankAccount debitBank;
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.f54552f;
            String str2 = null;
            BankAccountDetails.BankAccount debitBank2 = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank2, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank2.getIfsc(), true)) {
                if (next != null) {
                    bankAccount = next.getDebitBank();
                } else {
                    bankAccount = null;
                }
                kotlin.g.b.k.a((Object) bankAccount, "currentSelectedBankObject?.debitBank");
                String account = bankAccount.getAccount();
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.V;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                if (!account.equals((bVar == null || (yVar = bVar.f54680e) == null) ? null : yVar.getValue())) {
                    continue;
                } else {
                    if ((next != null ? next.getPaymentMode() : null) != UpiProfileDefaultBank.PAYMENT_MODE.IMPS) {
                        continue;
                    } else {
                        if (!(next == null || (debitBank = next.getDebitBank()) == null)) {
                            str2 = debitBank.getAccRefNumber();
                        }
                        if (kotlin.g.b.k.a((Object) "CURRENT", (Object) str2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void ac() {
        o();
        a(this.f54549b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String ad() {
        /*
            r2 = this;
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r2.V
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            androidx.lifecycle.y<java.lang.String> r0 = r0.f54682g
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r0 = ""
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.ad():java.lang.String");
    }

    private final void f(String str) {
        String str2;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f54548a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        if (customAmountTextInputEditText != null) {
            if (str != null) {
                str2 = new kotlin.m.l(this.f54553g).replaceFirst(str, "");
            } else {
                str2 = null;
            }
            customAmountTextInputEditText.setText(str2);
        }
    }

    public final void a(ThemeData themeData) {
        if (ae()) {
            net.one97.paytm.moneytransfer.utils.n nVar = this.aN;
            String str = null;
            if (!(nVar == null || themeData == null)) {
                nVar.f54181c = themeData;
                nVar.f54179a = true;
                String themeId = themeData.getThemeId();
                if (themeId == null) {
                    kotlin.g.b.k.a();
                }
                nVar.f54180b = themeId;
                if (TextUtils.isEmpty(nVar.f54180b)) {
                    View view = nVar.f54182d;
                    ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.motif_iv_bg) : null;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                } else {
                    View view2 = nVar.f54182d;
                    ImageView imageView2 = view2 != null ? (ImageView) view2.findViewById(R.id.motif_iv_bg) : null;
                    if (imageView2 != null) {
                        imageView2.setVisibility(4);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                }
                int parseColor = Color.parseColor(themeData.getBgcolor());
                nVar.a(parseColor);
                nVar.b(parseColor);
                nVar.c(parseColor);
                nVar.e(parseColor);
                nVar.d(Color.parseColor(themeData.getColor()));
                nVar.f(Color.parseColor(themeData.getColor()));
                nVar.a(themeData.getJsonData());
            }
            if (themeData != null) {
                str = themeData.getThemeId();
            }
            this.aK = str;
        }
    }

    public final void c() {
        Context context;
        Context context2;
        if (ae()) {
            net.one97.paytm.moneytransfer.utils.n nVar = this.aN;
            if (nVar != null) {
                nVar.f54181c = null;
                nVar.f54179a = false;
                nVar.f54180b = "";
                View view = nVar.f54182d;
                if (!(view == null || (context2 = view.getContext()) == null)) {
                    int c2 = androidx.core.content.b.c(context2, R.color.color_ffffff);
                    nVar.a(c2);
                    nVar.b(c2);
                    nVar.c(c2);
                    nVar.e(c2);
                }
                View view2 = nVar.f54182d;
                if (!(view2 == null || (context = view2.getContext()) == null)) {
                    nVar.d(androidx.core.content.b.c(context, R.color.color_222222));
                    nVar.f(androidx.core.content.b.c(context, R.color.color_00b9f5));
                }
                nVar.a("");
            }
            this.aK = "";
        }
    }

    private final boolean ae() {
        return getActivity() != null && isAdded() && isResumed();
    }

    static final class q<T> implements androidx.lifecycle.z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54573a;

        q(n nVar) {
            this.f54573a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f54573a.V();
            this.f54573a.ac();
            this.f54573a.O();
        }
    }

    static final class p<T> implements androidx.lifecycle.z<PPBCurrentAccountModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54572a;

        p(n nVar) {
            this.f54572a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f54572a.aa();
            this.f54572a.ac();
            this.f54572a.O();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r1 = r5.f54738b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.moneytransfer.viewmodel.e.a r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = r5.f54737a
            goto L_0x0007
        L_0x0006:
            r1 = r0
        L_0x0007:
            if (r1 != 0) goto L_0x000a
            goto L_0x005d
        L_0x000a:
            int r2 = r1.hashCode()
            r3 = 62368553(0x3b7ab29, float:1.079507E-36)
            if (r2 == r3) goto L_0x0057
            r3 = 63294573(0x3c5cc6d, float:1.1625553E-36)
            if (r2 == r3) goto L_0x0019
            goto L_0x005d
        L_0x0019:
            java.lang.String r2 = "BLOCK"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            if (r5 == 0) goto L_0x002c
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r1 = r5.f54738b
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = r1.getBankDown()
            goto L_0x002d
        L_0x002c:
            r1 = r0
        L_0x002d:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x004f
            r2 = 0
            java.lang.String r3 = "PAYER"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x0047
            if (r5 == 0) goto L_0x0043
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f54738b
        L_0x0043:
            r4.a((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x0047:
            if (r5 == 0) goto L_0x004b
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f54738b
        L_0x004b:
            r4.b((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x004f:
            if (r5 == 0) goto L_0x0053
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f54738b
        L_0x0053:
            r4.b((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x0057:
            java.lang.String r5 = "ALLOW"
            boolean r5 = r1.equals(r5)
        L_0x005d:
            r4.M()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.a(net.one97.paytm.moneytransfer.viewmodel.e$a):void");
    }

    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            TextView textView = this.s;
            if (textView == null) {
                kotlin.g.b.k.a("addMessageTV");
            }
            if (textView.getVisibility() == 8) {
                View view2 = this.w;
                if (view2 == null) {
                    kotlin.g.b.k.a("mAmountUnderline");
                }
                net.one97.paytm.moneytransfer.utils.c.a(view2, 200);
            }
            a(true);
            return;
        }
        TextView textView2 = this.s;
        if (textView2 == null) {
            kotlin.g.b.k.a("addMessageTV");
        }
        if (textView2.getVisibility() == 8) {
            View view3 = this.w;
            if (view3 == null) {
                kotlin.g.b.k.a("mAmountUnderline");
            }
            net.one97.paytm.moneytransfer.utils.c.b(view3, 200);
        }
    }

    public static final /* synthetic */ void a(n nVar, ArrayList<UpiProfileDefaultBank> arrayList) {
        BankAccountDetails.BankAccount debitBank;
        boolean z2 = false;
        if (!nVar.T && arrayList != null && !arrayList.isEmpty()) {
            ArrayList<UpiProfileDefaultBank> arrayList2 = new ArrayList<>();
            Bundle arguments = nVar.getArguments();
            String string = arguments != null ? arguments.getString("vpa") : null;
            Iterator it2 = arrayList.iterator();
            kotlin.g.b.k.a((Object) it2, "list?.iterator()");
            while (it2.hasNext()) {
                UpiProfileDefaultBank upiProfileDefaultBank = it2 != null ? (UpiProfileDefaultBank) it2.next() : null;
                kotlin.g.b.k.a((Object) upiProfileDefaultBank, "iter?.next()");
                if (!kotlin.m.p.a((upiProfileDefaultBank == null || (debitBank = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank.getAccount(), string, false)) {
                    arrayList2.add(upiProfileDefaultBank);
                }
            }
            arrayList = arrayList2;
        }
        nVar.aF = arrayList;
        boolean p2 = nVar.p();
        if (nVar.T) {
            nVar.K = false;
            nVar.W();
        } else {
            if (!p2) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                FragmentActivity activity = nVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                if (b2.b((Context) activity)) {
                    z2 = true;
                }
            }
            nVar.K = z2;
            if (!p2) {
                nVar.V();
            }
            if (!nVar.ab()) {
                nVar.aa();
            }
        }
        nVar.L();
        nVar.ac();
    }

    public static final /* synthetic */ void b(n nVar) {
        ArrayList<UpiProfileDefaultBank> arrayList;
        String sb;
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        n nVar2 = nVar;
        if ((!nVar2.O && !nVar2.L && !nVar2.N && !nVar2.P) && (arrayList = nVar2.aF) != null && (true ^ arrayList.isEmpty())) {
            UpiProfileDefaultBank upiProfileDefaultBank = arrayList.get(nVar2.aL);
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) upiProfileDefaultBank, "upiLists?.get(selectedBa…ForHealthCheckPosition)!!");
            String str = null;
            if (nVar2.T) {
                Bundle arguments = nVar.getArguments();
                sb = arguments != null ? arguments.getString("vpa") : null;
                if (sb == null) {
                    kotlin.g.b.k.a();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                Bundle arguments2 = nVar.getArguments();
                sb2.append(arguments2 != null ? arguments2.getString("vpa") : null);
                sb2.append("@");
                Bundle arguments3 = nVar.getArguments();
                sb2.append(arguments3 != null ? arguments3.getString("ifsc") : null);
                sb2.append(".ifsc.npci");
                sb = sb2.toString();
            }
            String str2 = sb;
            net.one97.paytm.moneytransfer.viewmodel.e eVar = nVar2.U;
            if (eVar != null) {
                String str3 = nVar2.X;
                String virtualAddress = upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null;
                String ifsc = (upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank3.getIfsc();
                String account = (upiProfileDefaultBank == null || (debitBank2 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank2.getAccount();
                String customerName = (upiProfileDefaultBank == null || (debitBank = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank.getCustomerName();
                Bundle arguments4 = nVar.getArguments();
                String string = arguments4 != null ? arguments4.getString("username") : null;
                Bundle arguments5 = nVar.getArguments();
                String string2 = arguments5 != null ? arguments5.getString("bankname") : null;
                Bundle arguments6 = nVar.getArguments();
                if (arguments6 != null) {
                    str = arguments6.getString("ifsc");
                }
                new net.one97.paytm.upi.f.b().a(new e.h(eVar), str3, virtualAddress, ifsc, account, customerName, string, string2, str, str2);
            }
        }
    }

    public static final /* synthetic */ void i(n nVar) {
        Dialog dialog;
        if (nVar.C == null) {
            nVar.C = UpiAppUtils.getWalletStyleProgressDialog(nVar.getActivity());
        }
        Dialog dialog2 = nVar.C;
        if (dialog2 != null) {
            if (dialog2 == null) {
                kotlin.g.b.k.a();
            }
            if (!dialog2.isShowing() && (dialog = nVar.C) != null) {
                dialog.show();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x025b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.view.fragments.n r17, net.one97.paytm.moneytransfer.viewmodel.e.C0981e r18) {
        /*
            r0 = r17
            r1 = r18
            if (r1 == 0) goto L_0x02c2
            java.lang.Integer r2 = r1.f54746b
            if (r2 != 0) goto L_0x000b
            goto L_0x0018
        L_0x000b:
            int r3 = r2.intValue()
            r4 = 2
            if (r3 != r4) goto L_0x0018
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
            r0.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r1)
            return
        L_0x0018:
            r3 = 1
            if (r2 != 0) goto L_0x001d
            goto L_0x02b4
        L_0x001d:
            int r4 = r2.intValue()
            if (r4 != 0) goto L_0x02b4
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            r4 = 0
            if (r2 == 0) goto L_0x002d
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            goto L_0x002e
        L_0x002d:
            r2 = r4
        L_0x002e:
            if (r2 != 0) goto L_0x0036
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.PLEASE_ADD_BANK
            r0.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r1)
            return
        L_0x0036:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x02ae
            if (r2 == 0) goto L_0x0041
            java.lang.String r2 = r2.getVirtualAddress()
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            if (r2 != 0) goto L_0x0046
            goto L_0x02ae
        L_0x0046:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x0059
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x0059
            boolean r2 = r2.isMpinSet()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x005a
        L_0x0059:
            r2 = r4
        L_0x005a:
            if (r2 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            boolean r2 = r2.booleanValue()
            java.lang.String r5 = "ifsc"
            java.lang.String r6 = "vpa"
            if (r2 != 0) goto L_0x0118
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r0.W
            if (r1 == 0) goto L_0x0078
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x0078
            java.lang.String r1 = r1.getIfsc()
            goto L_0x0079
        L_0x0078:
            r1 = r4
        L_0x0079:
            java.lang.String r2 = "PYTM0123456"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x00df
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r1 = r0.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            if (r1 != r2) goto L_0x00df
            android.os.Bundle r1 = r17.getArguments()
            java.lang.String r2 = "username"
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0095
        L_0x0094:
            r1 = r4
        L_0x0095:
            android.os.Bundle r3 = r17.getArguments()
            if (r3 == 0) goto L_0x00a0
            java.lang.String r2 = r3.getString(r2)
            goto L_0x00a1
        L_0x00a0:
            r2 = r4
        L_0x00a1:
            android.os.Bundle r3 = r17.getArguments()
            if (r3 == 0) goto L_0x00ae
            java.lang.String r7 = "bankname"
            java.lang.String r3 = r3.getString(r7)
            goto L_0x00af
        L_0x00ae:
            r3 = r4
        L_0x00af:
            android.os.Bundle r7 = r17.getArguments()
            if (r7 == 0) goto L_0x00ba
            java.lang.String r5 = r7.getString(r5)
            goto L_0x00bb
        L_0x00ba:
            r5 = r4
        L_0x00bb:
            android.os.Bundle r7 = r17.getArguments()
            if (r7 == 0) goto L_0x00c5
            java.lang.String r4 = r7.getString(r6)
        L_0x00c5:
            r6 = r4
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r7 = com.paytm.utility.a.b((android.content.Context) r4)
            java.lang.String r8 = r0.X
            java.lang.String r9 = r0.Y
            r0 = r17
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x00df:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 != 0) goto L_0x00eb
            kotlin.g.b.k.a()
        L_0x00eb:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            r1.add(r2)
            net.one97.paytm.upi.common.upi.UserUpiDetails$Builder r2 = new net.one97.paytm.upi.common.upi.UserUpiDetails$Builder
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r0.W
            if (r3 == 0) goto L_0x00fd
            java.lang.String r3 = r3.getVirtualAddress()
            goto L_0x00fe
        L_0x00fd:
            r3 = r4
        L_0x00fe:
            r2.<init>(r4, r3)
            java.util.List r1 = (java.util.List) r1
            net.one97.paytm.upi.common.upi.UserUpiDetails$Builder r1 = r2.setBankAccountList(r1)
            net.one97.paytm.upi.common.upi.UserUpiDetails r1 = r1.build()
            net.one97.paytm.moneytransfer.viewmodel.e r0 = r0.U
            if (r0 == 0) goto L_0x0117
            java.lang.String r2 = "userUpiDetails"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.a((net.one97.paytm.upi.common.upi.UserUpiDetails) r1)
        L_0x0117:
            return
        L_0x0118:
            java.lang.String r14 = r1.f54745a
            r1 = r14
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x02ad
            if (r14 != 0) goto L_0x0128
            kotlin.g.b.k.a()
        L_0x0128:
            r17.y()
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x0137
            java.lang.String r2 = r2.getString(r6)
            if (r2 != 0) goto L_0x0139
        L_0x0137:
            java.lang.String r2 = ""
        L_0x0139:
            java.lang.String r6 = "arguments?.getString(Bun…_OR_ACCOUNT_NUMBER) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r6 = r0.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r9 = "(this as java.lang.String).toLowerCase()"
            if (r6 != r7) goto L_0x0174
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = "@"
            r6.append(r2)
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x0160
            java.lang.String r2 = r2.getString(r5)
            goto L_0x0161
        L_0x0160:
            r2 = r4
        L_0x0161:
            r6.append(r2)
            java.lang.String r2 = ".ifsc.npci"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r0.ae = r2
            java.lang.String r2 = "ACCOUNTIFSC"
            r0.af = r2
            goto L_0x01a1
        L_0x0174:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r5 = r0.y
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r6 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r5 != r6) goto L_0x01a1
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x019f
            java.lang.String r6 = "paytm"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, false)
            if (r5 == 0) goto L_0x019f
            if (r2 == 0) goto L_0x0199
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            r0.ae = r2
            goto L_0x01a1
        L_0x0199:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x019f:
            r0.ae = r2
        L_0x01a1:
            java.lang.String r2 = r0.ae
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0277
            java.lang.String r2 = r0.ad
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0277
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0277
            net.one97.paytm.moneytransfer.viewmodel.e r3 = r0.U
            if (r3 == 0) goto L_0x02a1
            java.lang.String r1 = r0.X
            java.lang.String r5 = r0.ae
            boolean r2 = r0.J
            if (r2 == 0) goto L_0x01d7
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x01d5
            java.lang.String r6 = "payer_vpa"
            java.lang.String r2 = r2.getString(r6)
        L_0x01d3:
            r6 = r2
            goto L_0x01ef
        L_0x01d5:
            r6 = r4
            goto L_0x01ef
        L_0x01d7:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x01e0
            java.lang.String r2 = r2.getVirtualAddress()
            goto L_0x01e1
        L_0x01e0:
            r2 = r4
        L_0x01e1:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            if (r2 == 0) goto L_0x0271
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            goto L_0x01d3
        L_0x01ef:
            android.widget.TextView r2 = r0.f54554h
            if (r2 != 0) goto L_0x01f8
            java.lang.String r7 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x01f8:
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r7 = r2.toString()
            java.lang.String r8 = r0.Y
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x0211
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x0211
            java.lang.String r2 = r2.getAccount()
            goto L_0x0212
        L_0x0211:
            r2 = r4
        L_0x0212:
            java.lang.String r9 = net.one97.paytm.upi.util.UpiUtils.maskNumber(r2)
            java.lang.String r10 = r0.ad
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x0226
            java.lang.String r11 = "extra_key_mcc"
            java.lang.String r2 = r2.getString(r11)
            r11 = r2
            goto L_0x0227
        L_0x0226:
            r11 = r4
        L_0x0227:
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x0235
            java.lang.String r12 = "extra_key_ref_id"
            java.lang.String r2 = r2.getString(r12)
            r12 = r2
            goto L_0x0236
        L_0x0235:
            r12 = r4
        L_0x0236:
            android.os.Bundle r2 = r17.getArguments()
            if (r2 == 0) goto L_0x0244
            java.lang.String r13 = "extra_key_ref_url"
            java.lang.String r2 = r2.getString(r13)
            r13 = r2
            goto L_0x0245
        L_0x0244:
            r13 = r4
        L_0x0245:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x025b
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x025b
            net.one97.paytm.upi.common.upi.BankAccountDetails$CredsAllowed r2 = r2.getCredsAllowed()
            if (r2 == 0) goto L_0x025b
            java.util.List r2 = r2.getChild()
            r15 = r2
            goto L_0x025c
        L_0x025b:
            r15 = r4
        L_0x025c:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.W
            if (r2 == 0) goto L_0x026a
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x026a
            java.lang.String r4 = r2.getBankName()
        L_0x026a:
            r16 = r4
            r4 = r1
            r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x02a1
        L_0x0271:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x0277:
            android.content.Context r1 = r17.getContext()
            int r2 = net.one97.paytm.moneytransfer.R.string.upi_error_something_went_wrong
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r3)
            r1.show()
            boolean r1 = r0.P
            if (r1 != 0) goto L_0x0298
            boolean r1 = r0.O
            if (r1 != 0) goto L_0x0298
            boolean r1 = r0.L
            if (r1 != 0) goto L_0x0298
            boolean r1 = r0.N
            if (r1 != 0) goto L_0x0298
            boolean r1 = r0.J
            if (r1 == 0) goto L_0x02a1
        L_0x0298:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            if (r1 == 0) goto L_0x02a1
            r1.finish()
        L_0x02a1:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = net.one97.paytm.upi.util.GetCredentialsApiBuilder.getTrust(r1)
            r0.ai = r1
        L_0x02ad:
            return
        L_0x02ae:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
            r0.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r1)
            return
        L_0x02b4:
            if (r2 != 0) goto L_0x02b7
            return
        L_0x02b7:
            int r1 = r2.intValue()
            if (r1 != r3) goto L_0x02c2
            r1 = 2011(0x7db, float:2.818E-42)
            r0.b((int) r1)
        L_0x02c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.a(net.one97.paytm.moneytransfer.view.fragments.n, net.one97.paytm.moneytransfer.viewmodel.e$e):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.view.fragments.n r11, java.lang.String r12) {
        /*
            boolean r0 = r11.O
            r1 = -1
            r2 = 0
            if (r0 != 0) goto L_0x02b9
            boolean r0 = r11.P
            if (r0 == 0) goto L_0x000c
            goto L_0x02b9
        L_0x000c:
            boolean r0 = r11.F
            r3 = 0
            if (r0 == 0) goto L_0x0017
            boolean r0 = r11.H
            if (r0 != 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            java.lang.String r4 = "username"
            java.lang.String r5 = "key_intent_params"
            java.lang.String r6 = "extra_key_ref_id"
            java.lang.String r7 = "extra_key_ref_url"
            java.lang.String r8 = "extra_key_mcc"
            if (r0 == 0) goto L_0x00a7
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "extra_key_mpin"
            r0.putString(r1, r12)
            java.lang.String r12 = r11.ad
            java.lang.String r1 = "extra_key_deeplink_txn_id"
            r0.putString(r1, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x0040
            java.lang.String r12 = r12.getString(r4)
            goto L_0x0041
        L_0x0040:
            r12 = r2
        L_0x0041:
            java.lang.String r1 = "payee_name"
            r0.putString(r1, r12)
            java.lang.String r12 = r11.X
            java.lang.String r12 = net.one97.paytm.upi.util.UpiUtils.convertToTwoPlaces(r12)
            java.lang.String r1 = "amount"
            r0.putString(r1, r12)
            java.lang.String r12 = r11.Y
            java.lang.String r1 = "extra_key_comments"
            r0.putString(r1, r12)
            java.lang.String r12 = r11.ae
            java.lang.String r1 = "payee_vpa"
            r0.putString(r1, r12)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r12 = r11.W
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r1 = "user_upi_details"
            r0.putSerializable(r1, r12)
            net.one97.paytm.upi.common.upi.CommonPayParams r12 = r11.q()
            java.io.Serializable r12 = (java.io.Serializable) r12
            r0.putSerializable(r5, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x007c
            java.lang.String r12 = r12.getString(r8)
            goto L_0x007d
        L_0x007c:
            r12 = r2
        L_0x007d:
            r0.putString(r8, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x008b
            java.lang.String r12 = r12.getString(r7)
            goto L_0x008c
        L_0x008b:
            r12 = r2
        L_0x008c:
            r0.putString(r7, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x0099
            java.lang.String r2 = r12.getString(r6)
        L_0x0099:
            r0.putString(r6, r2)
            java.lang.String r12 = r11.Z
            java.lang.String r1 = "extra_key_upi_min_amount"
            r0.putString(r1, r12)
            r11.a((android.os.Bundle) r0)
            return
        L_0x00a7:
            java.lang.String r0 = "mpin"
            kotlin.g.b.k.c(r12, r0)
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r9 = r11.getActivity()
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity> r10 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.class
            r0.<init>(r9, r10)
            java.lang.String r9 = "key_bundle"
            r0.putExtra(r9, r2)
            net.one97.paytm.upi.common.upi.CommonPayParams r9 = r11.q()
            java.io.Serializable r9 = (java.io.Serializable) r9
            r0.putExtra(r5, r9)
            android.os.Bundle r5 = r11.getArguments()
            if (r5 == 0) goto L_0x00d2
            java.lang.String r4 = r5.getString(r4)
            goto L_0x00d3
        L_0x00d2:
            r4 = r2
        L_0x00d3:
            java.lang.String r5 = "key_name"
            r0.putExtra(r5, r4)
            java.lang.String r4 = "key_mpin"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.ai
            java.lang.String r4 = "npci_trust"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.D()
            java.lang.String r4 = "key_account_number_selected"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.X
            java.lang.String r12 = net.one97.paytm.upi.util.UpiUtils.convertToTwoPlaces(r12)
            java.lang.String r4 = "key_amount"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.Y
            java.lang.String r4 = "key_comment"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x010c
            java.lang.String r4 = "bankname"
            java.lang.String r12 = r12.getString(r4)
            goto L_0x010d
        L_0x010c:
            r12 = r2
        L_0x010d:
            java.lang.String r4 = "key_bank_name"
            r0.putExtra(r4, r12)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r12 = r11.y
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r4 = "key_account_no_vpa_adhaar"
            r0.putExtra(r4, r12)
            net.one97.paytm.moneytransfer.viewmodel.b r12 = r11.V
            if (r12 != 0) goto L_0x0124
            java.lang.String r4 = "moneyTransferActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0124:
            if (r12 == 0) goto L_0x0131
            androidx.lifecycle.y<java.lang.String> r12 = r12.f54680e
            if (r12 == 0) goto L_0x0131
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0132
        L_0x0131:
            r12 = r2
        L_0x0132:
            java.lang.String r4 = "key_payer_ppb_account_number"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x0144
            java.lang.String r4 = "vpa"
            java.lang.String r12 = r12.getString(r4)
            goto L_0x0145
        L_0x0144:
            r12 = r2
        L_0x0145:
            java.lang.String r4 = "key_account_number"
            r0.putExtra(r4, r12)
            boolean r12 = r11.H
            java.lang.String r4 = "is_from_scan"
            r0.putExtra(r4, r12)
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            java.lang.String r4 = "is_from_chat_flow"
            if (r12 == 0) goto L_0x0164
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x0164
            boolean r12 = r12.getBooleanExtra(r4, r3)
            goto L_0x0165
        L_0x0164:
            r12 = 0
        L_0x0165:
            r0.putExtra(r4, r12)
            boolean r12 = r11.H
            java.lang.String r4 = "is_deeplink"
            if (r12 != 0) goto L_0x0174
            boolean r12 = r11.F
            r0.putExtra(r4, r12)
            goto L_0x0177
        L_0x0174:
            r0.putExtra(r4, r3)
        L_0x0177:
            boolean r12 = r11.L
            java.lang.String r4 = "is_from_univ_p2p"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.aK
            java.lang.String r4 = "uni_p2p_landing_intent_extra_theme"
            r0.putExtra(r4, r12)
            boolean r12 = r11.R
            java.lang.String r4 = "from_app_evoke"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.C()
            java.lang.String r5 = "ifsc"
            r0.putExtra(r5, r12)
            boolean r12 = r11.J
            java.lang.String r5 = "is_collect_request"
            r0.putExtra(r5, r12)
            boolean r12 = r11.I
            java.lang.String r5 = "upi_is_self"
            r0.putExtra(r5, r12)
            boolean r12 = r11.J
            java.lang.String r5 = "payer_vpa"
            java.lang.String r9 = "collect_request_txn_id"
            if (r12 == 0) goto L_0x01c4
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r12 = r11.W
            if (r12 == 0) goto L_0x01be
            android.os.Bundle r10 = r11.getArguments()
            if (r10 == 0) goto L_0x01ba
            java.lang.String r10 = r10.getString(r5)
            goto L_0x01bb
        L_0x01ba:
            r10 = r2
        L_0x01bb:
            r12.setVirtualAddress(r10)
        L_0x01be:
            java.lang.String r12 = r11.ac
            r0.putExtra(r9, r12)
            goto L_0x01c9
        L_0x01c4:
            java.lang.String r12 = r11.ad
            r0.putExtra(r9, r12)
        L_0x01c9:
            java.lang.String r12 = r11.ae
            java.lang.String r9 = "payee_address"
            r0.putExtra(r9, r12)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r12 = r11.W
            java.io.Serializable r12 = (java.io.Serializable) r12
            r0.putExtra(r5, r12)
            boolean r12 = r11.R
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x01e9
            java.lang.String r4 = "mobile"
            java.lang.String r12 = r12.getString(r4)
            goto L_0x01ea
        L_0x01e9:
            r12 = r2
        L_0x01ea:
            java.lang.String r4 = "payee_mob_no"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x01fa
            java.lang.String r12 = r12.getString(r8)
            goto L_0x01fb
        L_0x01fa:
            r12 = r2
        L_0x01fb:
            java.lang.String r4 = "mcc"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x020b
            java.lang.String r12 = r12.getString(r7)
            goto L_0x020c
        L_0x020b:
            r12 = r2
        L_0x020c:
            java.lang.String r4 = "ref_url"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.ab
            java.lang.String r4 = "upi_tran_log_id"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x0223
            java.lang.String r12 = r12.getString(r6)
            goto L_0x0224
        L_0x0223:
            r12 = r2
        L_0x0224:
            java.lang.String r4 = "ref_id"
            r0.putExtra(r4, r12)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r12 = r11.y
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r4 = "payee_acc_or_vpa"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.Z
            java.lang.String r4 = "min_amt_deep_link"
            r0.putExtra(r4, r12)
            boolean r12 = r11.F
            java.lang.String r4 = "is_from_upi_deep_link"
            r0.putExtra(r4, r12)
            java.lang.String r12 = r11.af
            java.lang.String r4 = "global_address_type"
            r0.putExtra(r4, r12)
            android.os.Bundle r12 = r11.getArguments()
            java.lang.String r4 = "picture"
            if (r12 == 0) goto L_0x0254
            java.lang.String r12 = r12.getString(r4)
            goto L_0x0255
        L_0x0254:
            r12 = r2
        L_0x0255:
            r0.putExtra(r4, r12)
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            java.lang.String r4 = "split_bill_data"
            if (r12 == 0) goto L_0x026b
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x026b
            java.io.Serializable r12 = r12.getSerializableExtra(r4)
            goto L_0x026c
        L_0x026b:
            r12 = r2
        L_0x026c:
            r0.putExtra(r4, r12)
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0285
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x0285
            java.lang.String r2 = "hide_isa_fd"
            boolean r12 = r12.getBooleanExtra(r2, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
        L_0x0285:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r12 = "hide_isa_fd"
            r0.putExtra(r12, r2)
            boolean r12 = r11.F
            if (r12 != 0) goto L_0x0294
            boolean r12 = r11.R
            if (r12 == 0) goto L_0x0299
        L_0x0294:
            r12 = 33554432(0x2000000, float:9.403955E-38)
            r0.addFlags(r12)
        L_0x0299:
            r11.K()
            boolean r12 = r11.R
            if (r12 != 0) goto L_0x02ac
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 != 0) goto L_0x02a9
            kotlin.g.b.k.a()
        L_0x02a9:
            r12.setResult(r1)
        L_0x02ac:
            r11.startActivity(r0)
            androidx.fragment.app.FragmentActivity r11 = r11.getActivity()
            if (r11 != 0) goto L_0x02e4
            kotlin.g.b.k.a()
            goto L_0x02e4
        L_0x02b9:
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            if (r0 == 0) goto L_0x02ca
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x02ca
            java.lang.String r3 = "upi_mpin"
            r0.putExtra(r3, r12)
        L_0x02ca:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x02dd
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            if (r0 == 0) goto L_0x02da
            android.content.Intent r2 = r0.getIntent()
        L_0x02da:
            r12.setResult(r1, r2)
        L_0x02dd:
            androidx.fragment.app.FragmentActivity r11 = r11.getActivity()
            if (r11 != 0) goto L_0x02e4
            return
        L_0x02e4:
            r11.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.a(net.one97.paytm.moneytransfer.view.fragments.n, java.lang.String):void");
    }

    public static final /* synthetic */ void n(n nVar) {
        ShimmerFrameLayout shimmerFrameLayout = nVar.k;
        if (shimmerFrameLayout == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout.setVisibility(0);
        ShimmerFrameLayout shimmerFrameLayout2 = nVar.k;
        if (shimmerFrameLayout2 == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout2.startShimmerAnimation();
    }

    public static final /* synthetic */ void o(n nVar) {
        ShimmerFrameLayout shimmerFrameLayout = nVar.k;
        if (shimmerFrameLayout == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout.setVisibility(8);
        ShimmerFrameLayout shimmerFrameLayout2 = nVar.k;
        if (shimmerFrameLayout2 == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout2.stopShimmerAnimation();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.view.fragments.n r7, net.one97.paytm.moneytransfer.model.c r8) {
        /*
            ResultType r8 = r8.f54033b
            net.one97.paytm.moneytransfer.viewmodel.b$b r8 = (net.one97.paytm.moneytransfer.viewmodel.b.C0979b) r8
            r0 = 0
            if (r8 == 0) goto L_0x000a
            java.lang.String r1 = r8.f54690b
            goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            if (r2 != 0) goto L_0x0094
            android.widget.TextView r2 = r7.f54554h
            if (r2 != 0) goto L_0x001d
            java.lang.String r4 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x001d:
            r2.setText(r1)
            if (r8 == 0) goto L_0x0025
            java.lang.String r1 = r8.f54692d
            goto L_0x0026
        L_0x0025:
            r1 = r0
        L_0x0026:
            java.lang.String r2 = "NOT AVAILABLE"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 != 0) goto L_0x0128
            if (r8 == 0) goto L_0x0033
            java.lang.String r1 = r8.f54692d
            goto L_0x0034
        L_0x0033:
            r1 = r0
        L_0x0034:
            java.lang.String r2 = "INVALID"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            boolean r2 = r7.F
            if (r2 == 0) goto L_0x006a
            r7.Q = r1
            android.widget.ImageView r2 = r7.v
            java.lang.String r4 = "ivVerificationLogo"
            if (r2 != 0) goto L_0x0049
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0049:
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r7.aA
            if (r2 != 0) goto L_0x0056
            java.lang.String r6 = "tvbhimUpi"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0056:
            r2.setVisibility(r5)
            android.widget.ImageView r2 = r7.v
            if (r2 != 0) goto L_0x0060
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_unverified_merchant
            goto L_0x0067
        L_0x0065:
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_verified_merchant
        L_0x0067:
            r2.setBackgroundResource(r1)
        L_0x006a:
            if (r8 == 0) goto L_0x006e
            java.lang.String r0 = r8.f54692d
        L_0x006e:
            java.lang.String r8 = "VERIFIED"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 == 0) goto L_0x0128
            boolean r8 = r7.H
            java.lang.String r0 = "extra_key_intent_mode"
            if (r8 == 0) goto L_0x0088
            android.os.Bundle r7 = r7.getArguments()
            if (r7 == 0) goto L_0x0087
            java.lang.String r8 = "02"
            r7.putString(r0, r8)
        L_0x0087:
            return
        L_0x0088:
            android.os.Bundle r7 = r7.getArguments()
            if (r7 == 0) goto L_0x0093
            java.lang.String r8 = "05"
            r7.putString(r0, r8)
        L_0x0093:
            return
        L_0x0094:
            if (r8 == 0) goto L_0x0099
            java.lang.String r1 = r8.f54691c
            goto L_0x009a
        L_0x0099:
            r1 = r0
        L_0x009a:
            if (r8 == 0) goto L_0x00a2
            int r8 = r8.f54689a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
        L_0x00a2:
            java.lang.String r8 = "Error"
            if (r0 != 0) goto L_0x00a7
            goto L_0x00bc
        L_0x00a7:
            int r2 = r0.intValue()
            if (r2 != r3) goto L_0x00bc
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_unable_to_verify_vpa
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "getString(R.string.upi_unable_to_verify_vpa)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r7.b((java.lang.String) r8, (java.lang.String) r0)
            return
        L_0x00bc:
            if (r0 != 0) goto L_0x00bf
            return
        L_0x00bf:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x0128
            java.lang.String r0 = "401"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x00d7
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.moneytransfer.utils.m.b((android.app.Activity) r0)
        L_0x00d7:
            java.lang.String r0 = "XH"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = "J02"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = "U17"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = "0037"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x0105
        L_0x00f7:
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_address_incorrect
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "getString(R.string.upi_address_incorrect)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r7.b((java.lang.String) r8, (java.lang.String) r0)
        L_0x0105:
            java.lang.String r0 = "INT-1470"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x011b
            int r0 = net.one97.paytm.moneytransfer.R.string.mt_vpa_verify_no_bank_linked_err
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "getString(R.string.mt_vp…erify_no_bank_linked_err)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r7.b((java.lang.String) r8, (java.lang.String) r0)
        L_0x011b:
            java.lang.String r8 = "1006"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r3)
            if (r8 == 0) goto L_0x0128
            r8 = 2013(0x7dd, float:2.821E-42)
            r7.b((int) r8)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.n.a(net.one97.paytm.moneytransfer.view.fragments.n, net.one97.paytm.moneytransfer.model.c):void");
    }

    public static final /* synthetic */ void a(n nVar, e.c cVar) {
        Integer num;
        androidx.lifecycle.y<String> yVar;
        String str = null;
        if (cVar != null) {
            num = cVar.f54739a;
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            String str2 = cVar != null ? cVar.f54740b : null;
            String str3 = cVar != null ? cVar.f54741c : null;
            if (nVar.i()) {
                net.one97.paytm.moneytransfer.e.a aVar = new net.one97.paytm.moneytransfer.e.a();
                Bundle bundle = new Bundle();
                bundle.putString("amount", nVar.X);
                Bundle arguments = nVar.getArguments();
                bundle.putString("ifsc", arguments != null ? arguments.getString("ifsc") : null);
                Bundle arguments2 = nVar.getArguments();
                if (!TextUtils.isEmpty(arguments2 != null ? arguments2.getString("bankname") : null)) {
                    Bundle arguments3 = nVar.getArguments();
                    bundle.putString("bankname", arguments3 != null ? arguments3.getString("bankname") : null);
                } else {
                    Bundle arguments4 = nVar.getArguments();
                    bundle.putString("bankname", arguments4 != null ? arguments4.getString("username") : null);
                }
                Bundle arguments5 = nVar.getArguments();
                if (arguments5 != null) {
                    str = arguments5.getString("vpa");
                }
                bundle.putString("vpa", str);
                bundle.putString("neft_error_message", str2);
                bundle.putString("neft_tooltip_message", str3);
                aVar.setArguments(bundle);
                aVar.show(nVar.getChildFragmentManager(), "");
            }
        } else if (num != null && num.intValue() == 2) {
            String str4 = cVar != null ? cVar.f54740b : null;
            if (cVar != null) {
                str = cVar.f54741c;
            }
            if (nVar.i()) {
                net.one97.paytm.moneytransfer.e.c cVar2 = new net.one97.paytm.moneytransfer.e.c();
                Bundle bundle2 = new Bundle();
                bundle2.putString("neft_error_message", str4);
                bundle2.putString("neft_tooltip_message", str);
                cVar2.setArguments(bundle2);
                cVar2.show(nVar.getChildFragmentManager(), "");
            }
        } else if (num != null && num.intValue() == 1) {
            nVar.h();
        } else if (num != null && num.intValue() == 4) {
            Toast.makeText(nVar.getContext(), cVar.f54740b, 1).show();
        } else if (num != null && num.intValue() == 3) {
            String str5 = cVar != null ? cVar.f54740b : null;
            String str6 = cVar != null ? cVar.f54741c : null;
            if (nVar.i()) {
                net.one97.paytm.moneytransfer.e.b bVar = new net.one97.paytm.moneytransfer.e.b();
                Bundle bundle3 = new Bundle();
                bundle3.putString("amount", nVar.X);
                bundle3.putString("ifsc", nVar.E);
                bundle3.putString("bankname", nVar.getString(R.string.money_tranfer_balance_paytm_bank_string));
                net.one97.paytm.moneytransfer.viewmodel.b bVar2 = nVar.V;
                if (bVar2 == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                if (!(bVar2 == null || (yVar = bVar2.f54680e) == null)) {
                    str = yVar.getValue();
                }
                bundle3.putString("vpa", String.valueOf(str));
                bundle3.putString("neft_error_message", str5);
                bundle3.putString("neft_tooltip_message", str6);
                bVar.setArguments(bundle3);
                bVar.show(nVar.getChildFragmentManager(), "");
            }
        }
    }

    public static final /* synthetic */ void b(n nVar, net.one97.paytm.moneytransfer.model.c cVar) {
        String str;
        if (cVar != null) {
            nVar.j();
            int i2 = o.f54592h[cVar.f54032a.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    b.a aVar = (b.a) resulttype;
                    if (aVar != null) {
                        Integer num = aVar.f54688d;
                        if (num != null && num.intValue() == 0) {
                            if (!TextUtils.isEmpty(aVar.f54685a)) {
                                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f54687c) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f54687c) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                                    str = nVar.getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(aVar.f54686b), UpiAppUtils.priceToString(aVar.f54685a));
                                    kotlin.g.b.k.a((Object) str, "getString(\n             …                        )");
                                } else {
                                    str = nVar.getString(R.string.upi_new_balance, UpiAppUtils.priceToString(aVar.f54685a));
                                    kotlin.g.b.k.a((Object) str, "getString(\n             …                        )");
                                }
                                nVar.d(str);
                                return;
                            }
                            nVar.S();
                            Toast.makeText(nVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                            return;
                        } else if (num != null && num.intValue() == 2) {
                            Fragment parentFragment = nVar.getParentFragment();
                            if (parentFragment != null) {
                                n nVar2 = (n) parentFragment;
                                if (nVar2 != null) {
                                    nVar2.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                                    return;
                                }
                                return;
                            }
                            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.fragments.MoneyTransferPaymentFragment");
                        } else if (num != null && num.intValue() == 1) {
                            nVar.b(nVar.f54550d);
                            return;
                        } else if (num != null && num.intValue() == 3) {
                            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
                            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                            FragmentActivity activity = nVar.getActivity();
                            if (activity == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) activity, "activity!!");
                            new NetworkCustomError();
                            b2.a((Activity) activity, (String) null, true);
                            return;
                        } else if (num != null && num.intValue() == 4) {
                            Toast.makeText(nVar.getActivity(), R.string.upi_incorrect_mpin, 1).show();
                        } else if (num != null && num.intValue() == 5) {
                            Toast.makeText(nVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                            nVar.S();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (i2 == 3) {
                    nVar.S();
                    Toast.makeText(nVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                    return;
                } else if (i2 != 4) {
                    return;
                }
                nVar.S();
                return;
            }
            nVar.U();
        }
    }

    public static final /* synthetic */ void G(n nVar) {
        TextView textView = nVar.r;
        if (textView == null) {
            kotlin.g.b.k.a("rupeePrefixTV");
        }
        Context context = nVar.getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(context, R.color.edittext_hint_color));
    }

    public static final /* synthetic */ void H(n nVar) {
        ThemeData themeData;
        net.one97.paytm.moneytransfer.utils.n nVar2 = nVar.aN;
        ThemeData themeData2 = null;
        if (nVar2 != null) {
            themeData = nVar2.f54181c;
        } else {
            themeData = null;
        }
        if (themeData != null) {
            TextView textView = nVar.r;
            if (textView == null) {
                kotlin.g.b.k.a("rupeePrefixTV");
            }
            net.one97.paytm.moneytransfer.utils.n nVar3 = nVar.aN;
            if (nVar3 != null) {
                themeData2 = nVar3.f54181c;
            }
            if (themeData2 == null) {
                kotlin.g.b.k.a();
            }
            textView.setTextColor(Color.parseColor(themeData2.getColor()));
            return;
        }
        TextView textView2 = nVar.r;
        if (textView2 == null) {
            kotlin.g.b.k.a("rupeePrefixTV");
        }
        Context context = nVar.getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_222222));
    }

    public static final /* synthetic */ void I(n nVar) {
        ThemeData themeData;
        net.one97.paytm.moneytransfer.utils.n nVar2 = nVar.aN;
        ThemeData themeData2 = null;
        if (nVar2 != null) {
            themeData = nVar2.f54181c;
        } else {
            themeData = null;
        }
        if (themeData != null) {
            TextView textView = nVar.q;
            if (textView == null) {
                kotlin.g.b.k.a("amountErrorTV");
            }
            net.one97.paytm.moneytransfer.utils.n nVar3 = nVar.aN;
            if (nVar3 != null) {
                themeData2 = nVar3.f54181c;
            }
            if (themeData2 == null) {
                kotlin.g.b.k.a();
            }
            textView.setTextColor(Color.parseColor(themeData2.getColor()));
            return;
        }
        TextView textView2 = nVar.q;
        if (textView2 == null) {
            kotlin.g.b.k.a("amountErrorTV");
        }
        Context context = nVar.getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_666666));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.aQ;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
