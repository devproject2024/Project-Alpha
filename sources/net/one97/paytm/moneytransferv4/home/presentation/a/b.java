package net.one97.paytm.moneytransferv4.home.presentation.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel;
import net.one97.paytm.common.entity.p2p.DestinationPayment;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PPBLLimits;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.g;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.b.a;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.a;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.f;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b;
import net.one97.paytm.moneytransferv4.f.b;
import net.one97.paytm.moneytransferv4.g.b;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a;
import net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c;
import net.one97.paytm.n.b;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CommentsEditText;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends net.one97.paytm.i.h implements View.OnClickListener, View.OnFocusChangeListener, net.one97.paytm.common.a, n.c, b.C1023b {
    public static final a o = new a((byte) 0);
    private RelativeLayout A;
    private TextView B;
    private TextView C;
    private ImageView D;
    private ImageView E;
    private UpiConstants.MoneyTransferPaymentOption F = UpiConstants.MoneyTransferPaymentOption.ALL;
    /* access modifiers changed from: private */
    public boolean G;
    /* access modifiers changed from: private */
    public Uri H;
    private Dialog I;
    private String J;
    private String K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q;
    /* access modifiers changed from: private */
    public boolean R;
    /* access modifiers changed from: private */
    public boolean S;
    /* access modifiers changed from: private */
    public boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a Z;

    /* renamed from: a  reason: collision with root package name */
    public CustomAmountTextInputEditText f55438a;
    private TextView aA;
    private View aB;
    private View aC;
    private LottieAnimationView aD;
    private ImageView aE;
    private ArrayList<UpiProfileDefaultBank> aF = new ArrayList<>();
    /* access modifiers changed from: private */
    public List<? extends UpiProfileDefaultBank> aG;
    private net.one97.paytm.moneytransferv4.accountsbottomsheet.a aH;
    private int aI = -1;
    private String aJ;
    private int aK;
    private UPICheckBalanceHelper aL;
    /* access modifiers changed from: private */
    public net.one97.paytm.moneytransferv4.f.a aM;
    private LinearLayout aN;
    private TextView aO;
    private CommentsEditText aP;
    private net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b aQ;
    /* access modifiers changed from: private */
    public PaymentCombinationAPIResponse aR;
    private LinearLayout aS;
    private ImageView aT;
    private Group aU;
    private boolean aV;
    private boolean aW;
    /* access modifiers changed from: private */
    public boolean aX;
    private final aj aY = new aj(this);
    private net.one97.paytm.n.c aZ = new net.one97.paytm.n.c((net.one97.paytm.n.b) new i(this), (Fragment) this);
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;
    private String al;
    private View am;
    private LinearLayout an;
    private TextView ao;
    private LottieAnimationView ap;
    private TextView aq;
    private ImageView ar;
    private TextView as;
    private TextView at;
    private ImageView au;
    private ImageView av;
    private View aw;
    private View ax;
    private ImageView ay;
    private View az;

    /* renamed from: b  reason: collision with root package name */
    public MoneyTransferV3Activity.a f55439b = MoneyTransferV3Activity.a.ACCOUNT_NUMBER;
    private HashMap ba;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55440c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55441d;

    /* renamed from: e  reason: collision with root package name */
    public int f55442e;

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c f55443f;

    /* renamed from: g  reason: collision with root package name */
    public UpiProfileDefaultBank f55444g;

    /* renamed from: h  reason: collision with root package name */
    public NestedScrollView f55445h;

    /* renamed from: i  reason: collision with root package name */
    public MoneyTransferV3Activity.d f55446i = MoneyTransferV3Activity.d.VPA;
    public ConstraintLayout j;
    public net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d k;
    public PaymentOptionItem l;
    public boolean m;
    public final WalletPaymentCallbackListener n = new al(this);
    private final int p;
    /* access modifiers changed from: private */
    public final int q = 1;
    private final String r = "PYTM0123456";
    private final String s = "^0+";
    private TextView t;
    private TextView u;
    private TextView v;
    private ShimmerFrameLayout w;
    private TextView x;
    private TextView y;
    private ImageView z;

    static final class aa<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<ArrayList<UpiProfileDefaultBank>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55447a;

        aa(b bVar) {
            this.f55447a = bVar;
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Boolean] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.moneytransfer.model.c r4 = (net.one97.paytm.moneytransfer.model.c) r4
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                r0.ae()
                if (r4 == 0) goto L_0x00c3
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                r0.ae()
                net.one97.paytm.moneytransfer.model.d r0 = r4.f54032a
                int[] r1 = net.one97.paytm.moneytransferv4.home.presentation.a.c.f55490b
                int r0 = r0.ordinal()
                r0 = r1[r0]
                r1 = 1
                r2 = 0
                if (r0 == r1) goto L_0x0087
                r1 = 2
                if (r0 == r1) goto L_0x0031
                r4 = 3
                if (r0 == r4) goto L_0x0024
                goto L_0x00c3
            L_0x0024:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r4 = r3.f55447a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.app.Activity r4 = (android.app.Activity) r4
                net.one97.paytm.moneytransfer.utils.m.b((android.app.Activity) r4)
                goto L_0x00c3
            L_0x0031:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                boolean r0 = r0.aD()
                if (r0 == 0) goto L_0x0051
                net.one97.paytm.upi.common.UpiCustomVolleyError r0 = r4.f54034c
                if (r0 == 0) goto L_0x0042
                java.lang.String r0 = r0.getmErrorCode()
                goto L_0x0043
            L_0x0042:
                r0 = r2
            L_0x0043:
                java.lang.String r1 = "514"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x0051
                net.one97.paytm.moneytransferv4.home.presentation.a.b r4 = r3.f55447a
                r4.x()
                return
            L_0x0051:
                net.one97.paytm.upi.common.UpiCustomVolleyError r0 = r4.f54034c
                if (r0 == 0) goto L_0x005a
                java.lang.String r0 = r0.getAlertMessage()
                goto L_0x005b
            L_0x005a:
                r0 = r2
            L_0x005b:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0076
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                net.one97.paytm.upi.common.UpiCustomVolleyError r4 = r4.f54034c
                if (r4 == 0) goto L_0x006d
                java.lang.String r2 = r4.getAlertMessage()
            L_0x006d:
                if (r2 != 0) goto L_0x0072
                kotlin.g.b.k.a()
            L_0x0072:
                r0.a((java.lang.String) r2)
                return
            L_0x0076:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r4 = r3.f55447a
                int r0 = net.one97.paytm.moneytransfer.R.string.something_went_wrong
                java.lang.String r0 = r4.getString(r0)
                java.lang.String r1 = "getString(R.string.something_went_wrong)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r4.a((java.lang.String) r0)
                return
            L_0x0087:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = net.one97.paytm.moneytransferv4.home.presentation.a.b.e((net.one97.paytm.moneytransferv4.home.presentation.a.b) r0)
                if (r0 == 0) goto L_0x0093
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.f55563c = r1
            L_0x0093:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = net.one97.paytm.moneytransferv4.home.presentation.a.b.e((net.one97.paytm.moneytransferv4.home.presentation.a.b) r0)
                if (r0 == 0) goto L_0x009e
                java.lang.Boolean r0 = r0.f55563c
                goto L_0x009f
            L_0x009e:
                r0 = r2
            L_0x009f:
                if (r0 == 0) goto L_0x00b3
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = net.one97.paytm.moneytransferv4.home.presentation.a.b.e((net.one97.paytm.moneytransferv4.home.presentation.a.b) r0)
                if (r0 == 0) goto L_0x00ab
                java.lang.Boolean r2 = r0.f55563c
            L_0x00ab:
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x00c3
            L_0x00b3:
                ResultType r4 = r4.f54033b
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                if (r4 == 0) goto L_0x00c3
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r3.f55447a
                net.one97.paytm.moneytransferv4.home.presentation.a.b.a((net.one97.paytm.moneytransferv4.home.presentation.a.b) r0, (java.util.ArrayList) r4)
                net.one97.paytm.moneytransferv4.home.presentation.a.b r4 = r3.f55447a
                net.one97.paytm.moneytransferv4.home.presentation.a.b.f((net.one97.paytm.moneytransferv4.home.presentation.a.b) r4)
            L_0x00c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aa.onChanged(java.lang.Object):void");
        }
    }

    static final class ab<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<a.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55448a;

        ab(b bVar) {
            this.f55448a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            b bVar = this.f55448a;
            String str = null;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f55494f[dVar.ordinal()];
                if (i2 == 1) {
                    Uri p = bVar.H;
                    if (p != null) {
                        str = p.getQueryParameter("pn");
                    }
                    if (TextUtils.isEmpty(str)) {
                        b.q(bVar);
                    }
                } else if (i2 == 2) {
                    b.r(bVar);
                    b.a(bVar, cVar);
                } else if (i2 == 3) {
                    b.r(bVar);
                    bVar.a(cVar.f54034c);
                }
            }
        }
    }

    static final class c<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.a<Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55464a;

        c(b bVar) {
            this.f55464a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.a aVar = (net.one97.paytm.moneytransfer.model.a) obj;
            if (aVar != null) {
                dVar = aVar.f54025a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f55489a[dVar.ordinal()];
                if (i2 == 1) {
                    b.b(this.f55464a);
                } else if (i2 == 2) {
                    this.f55464a.I();
                    b bVar = this.f55464a;
                    ResultType resulttype = aVar.f54026b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    b.a(bVar, ((Boolean) resulttype).booleanValue());
                } else if (i2 == 3) {
                    this.f55464a.I();
                    b.a(this.f55464a, false);
                } else if (i2 == 4) {
                    this.f55464a.I();
                    net.one97.paytm.moneytransfer.utils.m.b((Activity) this.f55464a.getActivity());
                }
            }
        }
    }

    static final class d<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<DealsEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55465a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f55466b;

        d(b bVar, View view) {
            this.f55465a = bVar;
            this.f55466b = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            DealsEntity dealsEntity;
            View view;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null && (dealsEntity = (DealsEntity) cVar.f54033b) != null && (view = this.f55466b) != null) {
                net.one97.paytm.moneytransfer.c.ag a2 = net.one97.paytm.moneytransfer.c.ag.a(view);
                kotlin.g.b.k.a((Object) a2, "MtV4FragmentPaymentLayoutBinding.bind(view)");
                b bVar = this.f55465a;
                b.C1023b bVar2 = bVar;
                FragmentActivity activity = bVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                bVar.aM = new net.one97.paytm.moneytransferv4.f.a(a2, bVar2, new WeakReference(activity), dealsEntity);
            }
        }
    }

    static final class h<T> implements androidx.lifecycle.z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55470a;

        h(b bVar) {
            this.f55470a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = ((net.one97.paytm.network.f) obj).f55797b;
            if (!(iJRPaytmDataModel instanceof PaymentCombinationAPIResponse)) {
                iJRPaytmDataModel = null;
            }
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRPaytmDataModel;
            if (paymentCombinationAPIResponse != null) {
                this.f55470a.aR = paymentCombinationAPIResponse;
                b.J(this.f55470a);
            }
        }
    }

    static final class r<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<a.C1030a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55480a;

        r(b bVar) {
            this.f55480a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            b bVar = this.f55480a;
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            b.b(bVar, cVar);
        }
    }

    static final class s<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<c.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55481a;

        s(b bVar) {
            this.f55481a = bVar;
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
                int i2 = c.f55491c[dVar.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.f55481a.I();
                        b bVar = this.f55481a;
                        ResultType resulttype = cVar.f54033b;
                        if (resulttype == null) {
                            kotlin.g.b.k.a();
                        }
                        b.a(bVar, (c.e) resulttype);
                    } else if (i2 == 3) {
                        this.f55481a.I();
                        this.f55481a.a(cVar.f54034c);
                    }
                } else if (!this.f55481a.f55441d && !this.f55481a.P && !this.f55481a.S && !this.f55481a.T && !this.f55481a.R) {
                    b.b(this.f55481a);
                }
            }
        }
    }

    static final class t<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55482a;

        t(b bVar) {
            this.f55482a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            this.f55482a.I();
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null && c.f55495g[dVar.ordinal()] == 1) {
                net.one97.paytm.moneytransfer.utils.m.c((Activity) this.f55482a.getActivity());
            }
        }
    }

    static final class u<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55483a;

        u(b bVar) {
            this.f55483a = bVar;
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
                int[] r2 = net.one97.paytm.moneytransferv4.home.presentation.a.c.f55493e
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
                net.one97.paytm.moneytransferv4.home.presentation.a.b r5 = r4.f55483a
                int r0 = net.one97.paytm.moneytransfer.R.string.something_went_wrong_cl_lib
                java.lang.String r0 = r5.getString(r0)
                java.lang.String r1 = "getString(R.string.something_went_wrong_cl_lib)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r5.a((java.lang.String) r0)
                return
            L_0x0063:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r1 = r4.f55483a
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
                net.one97.paytm.moneytransferv4.home.presentation.a.b r5 = r4.f55483a
                androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
                if (r5 == 0) goto L_0x0081
                r5.finish()
            L_0x0081:
                return
            L_0x0082:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r4.f55483a
                ResultType r5 = r5.f54033b
                java.lang.String r5 = java.lang.String.valueOf(r5)
                net.one97.paytm.moneytransferv4.home.presentation.a.b.c((net.one97.paytm.moneytransferv4.home.presentation.a.b) r0, (java.lang.String) r5)
            L_0x008d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.u.onChanged(java.lang.Object):void");
        }
    }

    static final class v<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.a<c.C1032c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55484a;

        v(b bVar) {
            this.f55484a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            NetworkCustomError networkCustomError;
            String alertTitle;
            c.C1032c cVar;
            String str;
            net.one97.paytm.moneytransfer.model.a aVar = (net.one97.paytm.moneytransfer.model.a) obj;
            c.C1032c cVar2 = null;
            if (aVar != null) {
                dVar = aVar.f54025a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f55496h[dVar.ordinal()];
                if (i2 == 1) {
                    b.b(this.f55484a);
                } else if (i2 == 2) {
                    this.f55484a.I();
                    if (aVar != null) {
                        cVar2 = (c.C1032c) aVar.f54026b;
                    }
                    if (cVar2 != null) {
                        b.a(this.f55484a, cVar2);
                    }
                } else if (i2 == 3) {
                    this.f55484a.I();
                    if (aVar != null && (networkCustomError = aVar.f54027c) != null && (alertTitle = networkCustomError.getAlertTitle()) != null && (cVar = (c.C1032c) aVar.f54026b) != null && (str = cVar.f55613c) != null) {
                        this.f55484a.c(alertTitle, str);
                    }
                } else if (i2 == 4) {
                    this.f55484a.I();
                    net.one97.paytm.moneytransfer.utils.m.b((Activity) this.f55484a.getActivity());
                }
            }
        }
    }

    static final class y<T> implements androidx.lifecycle.z<net.one97.paytm.moneytransfer.model.c<c.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55487a;

        y(b bVar) {
            this.f55487a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
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
                int[] r2 = net.one97.paytm.moneytransferv4.home.presentation.a.c.f55492d
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x0140
                r3 = 2
                if (r1 == r3) goto L_0x0046
                r9 = 3
                if (r1 == r9) goto L_0x001f
                goto L_0x013f
            L_0x001f:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                r9.I()
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_error"
                java.lang.String r5 = ""
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.f55444g
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                goto L_0x013f
            L_0x0046:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r1 = r8.f55487a
                r1.I()
                ResultType r1 = r9.f54033b
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$d r1 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.d) r1
                if (r1 == 0) goto L_0x0054
                java.lang.Integer r1 = r1.f55615b
                goto L_0x0055
            L_0x0054:
                r1 = r0
            L_0x0055:
                if (r1 != 0) goto L_0x0058
                goto L_0x0091
            L_0x0058:
                int r4 = r1.intValue()
                if (r4 != r3) goto L_0x0091
                net.one97.paytm.moneytransferv4.home.presentation.a.b r1 = r8.f55487a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                r2 = r1
                android.content.Context r2 = (android.content.Context) r2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$d r9 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.d) r9
                if (r9 == 0) goto L_0x0074
                java.lang.String r0 = r9.f55616c
            L_0x0074:
                r1.append(r0)
                java.lang.String r7 = r1.toString()
                java.lang.String r3 = "wallet_money_transfer"
                java.lang.String r4 = "mpin_not_set"
                java.lang.String r5 = "/money-transfer/payment"
                java.lang.String r6 = "api_response_failure"
                net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.f55444g
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                return
            L_0x0091:
                if (r1 != 0) goto L_0x0094
                return
            L_0x0094:
                int r1 = r1.intValue()
                if (r1 != 0) goto L_0x013f
                ResultType r9 = r9.f54033b
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$d r9 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.d) r9
                if (r9 == 0) goto L_0x00a4
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = r9.f55614a
                if (r9 != 0) goto L_0x00a9
            L_0x00a4:
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = new net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount
                r9.<init>()
            L_0x00a9:
                java.lang.String r1 = r9.getIfsc()
                if (r1 == 0) goto L_0x013f
                net.one97.paytm.moneytransferv4.home.presentation.a.b r1 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.f55444g
                if (r1 == 0) goto L_0x00c2
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00c2
                java.lang.String r1 = r1.getIfsc()
                goto L_0x00c3
            L_0x00c2:
                r1 = r0
            L_0x00c3:
                java.lang.String r3 = r9.getIfsc()
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                if (r1 == 0) goto L_0x013f
                net.one97.paytm.moneytransferv4.home.presentation.a.b r1 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r1.f55444g
                if (r1 == 0) goto L_0x00df
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
                if (r1 == 0) goto L_0x00df
                java.lang.String r0 = r1.getAccRefId()
            L_0x00df:
                java.lang.String r1 = r9.getAccRefId()
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x013f
                boolean r0 = r9.isMpinSet()
                if (r0 == 0) goto L_0x0117
                net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f55444g
                if (r0 == 0) goto L_0x00fa
                r0.setDebitBank(r9)
            L_0x00fa:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                r9.J()
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
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
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r9.f55444g
                r9.a(10, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r0, false)
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "wallet_money_transfer"
                java.lang.String r2 = "mpin_not_set"
                java.lang.String r3 = "/money-transfer/payment"
                java.lang.String r4 = "api_success"
                java.lang.String r5 = "mpin_still_not_set"
                net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                java.lang.String r0 = "mpin_not_set"
                r9.h((java.lang.String) r0)
            L_0x013f:
                return
            L_0x0140:
                net.one97.paytm.moneytransferv4.home.presentation.a.b r9 = r8.f55487a
                net.one97.paytm.moneytransferv4.home.presentation.a.b.b((net.one97.paytm.moneytransferv4.home.presentation.a.b) r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.y.onChanged(java.lang.Object):void");
        }
    }

    static final class z<T> implements androidx.lifecycle.z<ArrayList<UpiProfileDefaultBank>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55488a;

        z(b bVar) {
            this.f55488a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55488a.aG = (ArrayList) obj;
        }
    }

    public static final /* synthetic */ CustomAmountTextInputEditText E(b bVar) {
        CustomAmountTextInputEditText customAmountTextInputEditText = bVar.f55438a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        return customAmountTextInputEditText;
    }

    public static final /* synthetic */ TextView K(b bVar) {
        TextView textView = bVar.B;
        if (textView == null) {
            kotlin.g.b.k.a("amountErrorTV");
        }
        return textView;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a e(b bVar) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = bVar.Z;
        if (aVar == null) {
            kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ CommentsEditText t(b bVar) {
        CommentsEditText commentsEditText = bVar.aP;
        if (commentsEditText == null) {
            kotlin.g.b.k.a("messageEditText");
        }
        return commentsEditText;
    }

    public static final /* synthetic */ NestedScrollView u(b bVar) {
        NestedScrollView nestedScrollView = bVar.f55445h;
        if (nestedScrollView == null) {
            kotlin.g.b.k.a("amountScrollView");
        }
        return nestedScrollView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: type inference failed for: r0v292, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x08e8 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x08f5 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0900 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0913 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0934 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0939 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x094b A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0957 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x096c A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0976 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0984 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0991 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x099e A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x09a9 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x09b8 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x09c7 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x09d6 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x09e1 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x09f1 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0a2a A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0a3d A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0a4c A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0a5b A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0a6a A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0aa3 A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0aab A[Catch:{ UnsupportedEncodingException -> 0x064a }] */
    /* JADX WARNING: Removed duplicated region for block: B:707:0x0f1e  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0f2f  */
    /* JADX WARNING: Removed duplicated region for block: B:788:0x1058  */
    /* JADX WARNING: Removed duplicated region for block: B:789:0x1060  */
    /* JADX WARNING: Removed duplicated region for block: B:797:0x108a  */
    /* JADX WARNING: Removed duplicated region for block: B:798:0x1091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r31, android.view.ViewGroup r32, android.os.Bundle r33) {
        /*
            r30 = this;
            r1 = r30
            r0 = r31
            java.lang.String r2 = "inflater"
            kotlin.g.b.k.c(r0, r2)
            int r2 = net.one97.paytm.moneytransfer.R.layout.mt_v4_fragment_payment_layout
            r3 = 0
            r4 = r32
            android.view.View r2 = r0.inflate(r2, r4, r3)
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x001f
            java.lang.String r5 = "pcr"
            java.io.Serializable r0 = r0.getSerializable(r5)
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            boolean r5 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
            if (r5 != 0) goto L_0x0025
            r0 = 0
        L_0x0025:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
            r1.aR = r0
            net.one97.paytm.moneytransfer.d.c$a r0 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r0 = net.one97.paytm.moneytransfer.d.c.a.a()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0047
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r1.aR
            if (r0 == 0) goto L_0x0044
            net.one97.paytm.common.entity.p2p.ExtraData r0 = r0.getExtraData()
            if (r0 == 0) goto L_0x0044
            boolean r0 = r0.isGalleryScan()
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r1.aV = r0
        L_0x0047:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r1.aR
            if (r0 == 0) goto L_0x0056
            net.one97.paytm.common.entity.p2p.ExtraData r0 = r0.getExtraData()
            if (r0 == 0) goto L_0x0056
            boolean r0 = r0.isMidScan()
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            r1.aW = r0
            r0 = r1
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0)
            java.lang.Class<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c> r5 = net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.class
            androidx.lifecycle.ai r0 = r0.a(r5)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c) r0
            r1.f55443f = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 != 0) goto L_0x0073
            kotlin.g.b.k.a()
        L_0x0073:
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0)
            java.lang.Class<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a> r5 = net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.class
            androidx.lifecycle.ai r0 = r0.a(r5)
            java.lang.String r5 = "ViewModelProviders.of(ac…ityViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a) r0
            r1.Z = r0
            java.lang.String r0 = "view"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            int r0 = net.one97.paytm.moneytransfer.R.id.bankImageCollapsedView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.bankImageCollapsedView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.aT = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amountParentView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.amountParentView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.aS = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.messageEditText
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.messageEditText)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.util.CommentsEditText r0 = (net.one97.paytm.upi.util.CommentsEditText) r0
            r1.aP = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.addMessageTextView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.addMessageTextView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.aO = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ll_amount_wrapper
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.ll_amount_wrapper)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.aN = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tv_receiver_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.t = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_acc_number
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tv_receiver_acc_number)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.u = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_receiver_ifsc
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.tv_receiver_ifsc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.v = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankImageView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.bankImageView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.z = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.shimmer_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.shimmer_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.common.ShimmerFrameLayout r0 = (net.one97.paytm.upi.common.ShimmerFrameLayout) r0
            r1.w = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_et
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.amount_et)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = (net.one97.paytm.upi.common.CustomAmountTextInputEditText) r0
            r1.f55438a = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_error_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.amount_error_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.B = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.rupee_prefix_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r5 = "view.findViewById(R.id.rupee_prefix_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.C = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.iv_back_button1
            android.view.View r0 = r2.findViewById(r0)
            r5 = r1
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.selectedBankDownArrowTV
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.selectedBankDownArrowTV)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.aE = r0
            android.widget.ImageView r0 = r1.aE
            if (r0 != 0) goto L_0x0181
            java.lang.String r6 = "selectedBankDownArrowTV"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0181:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.headerBankLogoName
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.headerBankLogoName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.x = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ll_uni_pay
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById<TextView>(R.id.ll_uni_pay)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.y = r0
            android.widget.TextView r0 = r1.y
            if (r0 != 0) goto L_0x01ad
            java.lang.String r6 = "mProceedPayment"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01ad:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.accountLoadingLayout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.accountLoadingLayout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1.aB = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.accountsLoader
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.accountsLoader)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r1.aD = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.mt_selected_account_cv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.mt_selected_account_cv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1.am = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_selected_source_label
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.tv_selected_source_label)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.aq = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankImageCollapsedView
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.bankImageCollapsedView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.ar = r0
            android.view.View r0 = r1.am
            if (r0 != 0) goto L_0x0205
            java.lang.String r6 = "selectedAccCardView"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0205:
            int r6 = net.one97.paytm.moneytransfer.R.id.clickable_group
            android.view.View r0 = r0.findViewById(r6)
            java.lang.String r6 = "selectedAccCardView.find…yId(R.id.clickable_group)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            r1.aU = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.ll_pay_wrapper
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.ll_pay_wrapper)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.an = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.check_balance_tv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.check_balance_tv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.ao = r0
            android.widget.TextView r0 = r1.ao
            if (r0 != 0) goto L_0x023d
            java.lang.String r6 = "checkBalanceTV"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x023d:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.check_balance_loader
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.check_balance_loader)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r1.ap = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.source_name
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.source_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.as = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.card_view_button
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.card_view_button)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.at = r0
            android.widget.TextView r0 = r1.at
            if (r0 != 0) goto L_0x0279
            java.lang.String r6 = "mCardViewProceed"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0279:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.sender_bank_iv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.sender_bank_iv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.au = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.arrow_iv
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.arrow_iv)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.ay = r0
            android.widget.ImageView r0 = r1.ay
            if (r0 != 0) goto L_0x02a5
            java.lang.String r6 = "mCardToggleDownIv"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x02a5:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.rl_uni_selected_payment_inst
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.r…ni_selected_payment_inst)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1.A = r0
            android.widget.RelativeLayout r0 = r1.A
            if (r0 != 0) goto L_0x02c1
            java.lang.String r6 = "mOpenBottomSheetRlv"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x02c1:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.bankarrow
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.bankarrow)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.av = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankDetailsContainer
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.bankDetailsContainer)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1.aw = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.bankNameContainer
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.bankNameContainer)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1.ax = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.amount_scrollview
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.amount_scrollview)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            r1.f55445h = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.lnr_details_layout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.lnr_details_layout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1.az = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.options
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r6 = "view.findViewById(R.id.options)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.E = r0
            android.widget.ImageView r0 = r1.E
            java.lang.String r6 = "optionsIcon"
            if (r0 != 0) goto L_0x0327
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0327:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.ivVerificationLogo
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r7 = "view.findViewById(R.id.ivVerificationLogo)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.D = r0
            int r0 = net.one97.paytm.moneytransfer.R.id.accountTypeCurrent
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r7 = "view.findViewById(R.id.accountTypeCurrent)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            r1.aC = r0
            android.widget.ImageView r0 = r1.D
            if (r0 != 0) goto L_0x0351
            java.lang.String r7 = "ivVerificationLogo"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0351:
            r0.setOnClickListener(r5)
            int r0 = net.one97.paytm.moneytransfer.R.id.tvbhimUpi
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r7 = "view.findViewById(R.id.tvbhimUpi)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.aA = r0
            android.widget.TextView r0 = r1.aA
            if (r0 != 0) goto L_0x036e
            java.lang.String r7 = "tvbhimUpi"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x036e:
            r0.setOnClickListener(r5)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            java.lang.String r5 = "amountET"
            if (r0 != 0) goto L_0x037a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x037a:
            java.lang.String r7 = ""
            r0.setPrefix(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0386
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0386:
            r7 = 7
            r0.setMaxDigitsBeforeDecimalPoint(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0391
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0391:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$aj r7 = r1.aY
            android.text.TextWatcher r7 = (android.text.TextWatcher) r7
            r0.addTextChangedListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x039f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x039f:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$k r7 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$k
            r7.<init>(r1)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r0.setOnClickListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x03b0
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x03b0:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$l r7 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$l
            r7.<init>(r1)
            android.widget.TextView$OnEditorActionListener r7 = (android.widget.TextView.OnEditorActionListener) r7
            r0.setOnEditorActionListener(r7)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x03c1
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x03c1:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$m r7 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$m
            r7.<init>(r1)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText$EditTextImeBackListener r7 = (net.one97.paytm.upi.common.CustomAmountTextInputEditText.EditTextImeBackListener) r7
            r0.setOnEditTextImeBackListener(r7)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.aP
            java.lang.String r7 = "messageEditText"
            if (r0 != 0) goto L_0x03d4
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03d4:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$n r8 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$n
            r8.<init>(r1)
            android.widget.TextView$OnEditorActionListener r8 = (android.widget.TextView.OnEditorActionListener) r8
            r0.setOnEditorActionListener(r8)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.aP
            if (r0 != 0) goto L_0x03e5
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03e5:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$o r8 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$o
            r8.<init>(r1)
            net.one97.paytm.upi.util.CommentsEditText$EditTextImeBackListener r8 = (net.one97.paytm.upi.util.CommentsEditText.EditTextImeBackListener) r8
            r0.setOnEditTextImeBackListener(r8)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.aP
            if (r0 != 0) goto L_0x03f6
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03f6:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$p r8 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$p
            r8.<init>(r1)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r0.setOnClickListener(r8)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0407
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0407:
            r8 = r1
            android.view.View$OnFocusChangeListener r8 = (android.view.View.OnFocusChangeListener) r8
            r0.setOnFocusChangeListener(r8)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0414
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0414:
            r0.requestFocus()
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x041e
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x041e:
            android.widget.EditText r0 = (android.widget.EditText) r0
            androidx.fragment.app.FragmentActivity r8 = r30.getActivity()
            android.app.Activity r8 = (android.app.Activity) r8
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r0, (android.app.Activity) r8)
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.b()
            r8 = 8
            if (r0 == 0) goto L_0x0442
            int r0 = net.one97.paytm.moneytransfer.R.id.motif_iv_bg
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r9 = "view.findViewById<ImageView>(R.id.motif_iv_bg)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r8)
        L_0x0442:
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.b()
            if (r0 == 0) goto L_0x0459
            int r0 = net.one97.paytm.moneytransfer.R.id.rel_bottom
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r9 = "view.findViewById<RelativeLayout>(R.id.rel_bottom)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setVisibility(r8)
        L_0x0459:
            int r0 = net.one97.paytm.moneytransfer.R.id.pullDownLayout
            android.view.View r0 = r2.findViewById(r0)
            java.lang.String r9 = "view.findViewById(R.id.pullDownLayout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1.j = r0
            androidx.constraintlayout.widget.Group r0 = r1.aU
            if (r0 != 0) goto L_0x0472
            java.lang.String r9 = "clickableGroup"
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0472:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$e r9 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$e
            r9.<init>(r1)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            java.lang.String r10 = "$this$setAllOnClickListener"
            kotlin.g.b.k.c(r0, r10)
            int[] r10 = r0.getReferencedIds()
            java.lang.String r11 = "referencedIds"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            int r11 = r10.length
            r12 = 0
        L_0x0489:
            if (r12 >= r11) goto L_0x049b
            r13 = r10[r12]
            android.view.View r14 = r0.getRootView()
            android.view.View r13 = r14.findViewById(r13)
            r13.setOnClickListener(r9)
            int r12 = r12 + 1
            goto L_0x0489
        L_0x049b:
            android.widget.TextView r0 = r1.aO
            if (r0 != 0) goto L_0x04a4
            java.lang.String r9 = "addMessageTextView"
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x04a4:
            net.one97.paytm.moneytransferv4.home.presentation.a.b$f r9 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$f
            r9.<init>(r1)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r0.setOnClickListener(r9)
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x10ae
            net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity r0 = (net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity) r0
            if (r0 == 0) goto L_0x04c1
            boolean r0 = r0.m()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x04c2
        L_0x04c1:
            r0 = 0
        L_0x04c2:
            boolean r0 = r0.booleanValue()
            java.lang.String r9 = "moneyTransferv4ActivityViewModel"
            if (r0 == 0) goto L_0x0514
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x04d1
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x04d1:
            if (r0 == 0) goto L_0x04f8
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$c r10 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$c
            r10.<init>(r0)
            java.util.concurrent.Callable r10 = (java.util.concurrent.Callable) r10
            io.reactivex.rxjava3.a.y r10 = io.reactivex.rxjava3.a.y.a(r10)
            io.reactivex.rxjava3.a.x r11 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.y r10 = r10.b((io.reactivex.rxjava3.a.x) r11)
            io.reactivex.rxjava3.a.x r11 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.y r10 = r10.a((io.reactivex.rxjava3.a.x) r11)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$d r11 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$d
            r11.<init>(r0)
            io.reactivex.rxjava3.a.aa r11 = (io.reactivex.rxjava3.a.aa) r11
            r10.c(r11)
        L_0x04f8:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x04ff
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x04ff:
            if (r0 == 0) goto L_0x0514
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.p2p.theme.DealsEntity>> r0 = r0.s
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0514
            r10 = r1
            androidx.lifecycle.q r10 = (androidx.lifecycle.q) r10
            net.one97.paytm.moneytransferv4.home.presentation.a.b$d r11 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$d
            r11.<init>(r1, r2)
            androidx.lifecycle.z r11 = (androidx.lifecycle.z) r11
            r0.observe(r10, r11)
        L_0x0514:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r1.aR
            r10 = 1
            if (r0 != 0) goto L_0x0f16
            boolean r0 = r1.L
            java.lang.String r11 = "amount"
            if (r0 == 0) goto L_0x0570
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0534
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0534
            java.lang.String r12 = "EXTRA_DEEP_LINK_DATA"
            android.os.Parcelable r0 = r0.getParcelableExtra(r12)
            net.one97.paytm.deeplink.DeepLinkData r0 = (net.one97.paytm.deeplink.DeepLinkData) r0
            goto L_0x0535
        L_0x0534:
            r0 = 0
        L_0x0535:
            if (r0 == 0) goto L_0x0570
            java.lang.String r12 = r0.f50288f
            java.lang.String r13 = "money_transfer"
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r10)
            if (r12 == 0) goto L_0x0570
            java.lang.String r0 = r0.f50283a
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            android.net.Uri r0 = r0.build()
            java.lang.String r12 = "am"
            java.lang.String r12 = r0.getQueryParameter(r12)
            java.lang.String r13 = "tn"
            java.lang.String r0 = r0.getQueryParameter(r13)
            android.os.Bundle r13 = r30.getArguments()
            if (r13 == 0) goto L_0x0565
            r13.putString(r11, r12)
        L_0x0565:
            android.os.Bundle r12 = r30.getArguments()
            if (r12 == 0) goto L_0x0570
            java.lang.String r13 = "comments"
            r12.putString(r13, r0)
        L_0x0570:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x057b
            android.content.Intent r0 = r0.getIntent()
            goto L_0x057c
        L_0x057b:
            r0 = 0
        L_0x057c:
            java.lang.String r12 = "headerBankLogoName"
            java.lang.String r13 = "vpa"
            java.lang.String r14 = "receiverIFSC"
            java.lang.String r15 = "java.lang.String.format(format, *args)"
            java.lang.String r16 = "bankIV"
            if (r0 == 0) goto L_0x0aba
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x059a
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x059a
            android.net.Uri r0 = r0.getData()
            goto L_0x059b
        L_0x059a:
            r0 = 0
        L_0x059b:
            if (r0 == 0) goto L_0x0aba
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x05ae
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x05ae
            android.net.Uri r0 = r0.getData()
            goto L_0x05af
        L_0x05ae:
            r0 = 0
        L_0x05af:
            r1.H = r0
            r1.f55440c = r10
            net.one97.paytm.upi.util.UpiConstants$MoneyTransferPaymentOption r0 = net.one97.paytm.upi.util.UpiConstants.MoneyTransferPaymentOption.UPI
            r1.F = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x05ca
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x05ca
            java.lang.String r6 = "is_from_scan"
            boolean r0 = r0.getBooleanExtra(r6, r3)
            goto L_0x05cb
        L_0x05ca:
            r0 = 0
        L_0x05cb:
            r1.M = r0
            android.net.Uri r0 = r1.H
            if (r0 == 0) goto L_0x0f16
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            java.lang.String r0 = net.one97.paytm.moneytransfer.utils.m.i(r0)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            r1.H = r0     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            android.net.Uri r0 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r0 == 0) goto L_0x05ea
            java.lang.String r6 = "pa"
            java.lang.String r0 = r0.getQueryParameter(r6)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x05eb
        L_0x05ea:
            r0 = 0
        L_0x05eb:
            android.net.Uri r6 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r6 == 0) goto L_0x05f6
            java.lang.String r11 = "am"
            java.lang.String r6 = r6.getQueryParameter(r11)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x05f7
        L_0x05f6:
            r6 = 0
        L_0x05f7:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r11 == 0) goto L_0x0602
            java.lang.String r4 = "pn"
            java.lang.String r4 = r11.getQueryParameter(r4)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x0603
        L_0x0602:
            r4 = 0
        L_0x0603:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r11 == 0) goto L_0x060e
            java.lang.String r8 = "mam"
            java.lang.String r8 = r11.getQueryParameter(r8)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x060f
        L_0x060e:
            r8 = 0
        L_0x060f:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r11 == 0) goto L_0x061b
            java.lang.String r3 = "tid"
            java.lang.String r3 = r11.getQueryParameter(r3)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x061c
        L_0x061b:
            r3 = 0
        L_0x061c:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r11 == 0) goto L_0x0628
            java.lang.String r10 = "tn"
            java.lang.String r10 = r11.getQueryParameter(r10)     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            goto L_0x0629
        L_0x0628:
            r10 = 0
        L_0x0629:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0ab0 }
            if (r11 == 0) goto L_0x0639
            r18 = r2
            java.lang.String r2 = "mc"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x0636 }
            goto L_0x063c
        L_0x0636:
            r0 = move-exception
            goto L_0x0ab3
        L_0x0639:
            r18 = r2
            r2 = 0
        L_0x063c:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x0636 }
            if (r11 == 0) goto L_0x064d
            r19 = r9
            java.lang.String r9 = "url"
            java.lang.String r9 = r11.getQueryParameter(r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0650
        L_0x064a:
            r0 = move-exception
            goto L_0x0ab5
        L_0x064d:
            r19 = r9
            r9 = 0
        L_0x0650:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x065e
            r20 = r2
            java.lang.String r2 = "tr"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0661
        L_0x065e:
            r20 = r2
            r2 = 0
        L_0x0661:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x066d
            r21 = r2
            java.lang.String r2 = "mode"
            r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x066f
        L_0x066d:
            r21 = r2
        L_0x066f:
            android.net.Uri r2 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x0679
            java.lang.String r11 = "sign"
            r2.getQueryParameter(r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0679:
            android.net.Uri r2 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x0684
            java.lang.String r11 = "orgid"
            java.lang.String r2 = r2.getQueryParameter(r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0685
        L_0x0684:
            r2 = 0
        L_0x0685:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x0692
            r22 = r2
            java.lang.String r2 = "mid"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0695
        L_0x0692:
            r22 = r2
            r2 = 0
        L_0x0695:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x06a2
            r23 = r2
            java.lang.String r2 = "msid"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x06a5
        L_0x06a2:
            r23 = r2
            r2 = 0
        L_0x06a5:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x06b2
            r24 = r2
            java.lang.String r2 = "mtid"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x06b5
        L_0x06b2:
            r24 = r2
            r2 = 0
        L_0x06b5:
            android.net.Uri r11 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x06c2
            r25 = r2
            java.lang.String r2 = "bharatqr"
            java.lang.String r2 = r11.getQueryParameter(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x06c5
        L_0x06c2:
            r25 = r2
            r2 = 0
        L_0x06c5:
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 != 0) goto L_0x08ad
            java.lang.String r11 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r11 = "uriVPAOrAccount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r11 = ".ifsc.npci"
            r26 = r2
            r2 = 1
            boolean r11 = kotlin.m.p.c(r0, r11, r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r11 == 0) goto L_0x083d
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r2 = "@"
            r27 = r9
            r9 = 6
            r28 = r3
            r3 = 0
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.String) r2, (int) r3, (boolean) r3, (int) r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r9 = 1
            int r2 = r2 + r9
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r11 = ".ifsc.npci"
            r29 = r8
            r8 = 6
            int r8 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r11, (int) r3, (boolean) r3, (int) r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r2 = r0.substring(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r8 = "@"
            r9 = 6
            r11 = 0
            int r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String) r8, (int) r11, (boolean) r11, (int) r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r0 = r0.substring(r11, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r3 = r1.v     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x0726
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0726:
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            int r8 = net.one97.paytm.moneytransfer.R.string.money_transfer_ifsc_with_placeholder_without_bold     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r8 = r1.getString(r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r9 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r9 = 1
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r17 = 0
            r11[r17] = r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r8 = java.lang.String.format(r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r3.setText(r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r3 = r1.v     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x0751
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0751:
            r8 = 0
            r3.setVisibility(r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r3 = r1.x     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x075c
            kotlin.g.b.k.a((java.lang.String) r12)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x075c:
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            int r8 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r9 = 1
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r9 = net.one97.paytm.upi.util.UpiUtils.maskNumber(r0)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r14 = 4
            java.lang.String r9 = net.one97.paytm.upi.util.UpiAppUtils.insertSpaceAfterInterval(r9, r14)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r14 = 0
            r11[r14] = r9     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r8 = r1.getString(r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r9 = "getString(\n             …                        )"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.Object[] r9 = new java.lang.Object[r14]     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r14)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r3.setText(r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.ImageView r3 = r1.z     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x0791
            kotlin.g.b.k.a((java.lang.String) r16)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0791:
            androidx.fragment.app.FragmentActivity r8 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r3, (java.lang.String) r2, (android.content.Context) r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.os.Bundle r3 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 == 0) goto L_0x07a7
            java.lang.String r8 = "ifsc"
            r3.putString(r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x07a7:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r1.f55439b = r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x07b6
            r2.putString(r13, r0)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x07b6:
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x07c3
            java.lang.String r3 = "bankname"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x07c4
        L_0x07c3:
            r2 = 0
        L_0x07c4:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x081c
            android.os.Bundle r3 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 == 0) goto L_0x07d8
            java.lang.String r3 = r3.getString(r13)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x07d9
        L_0x07d8:
            r3 = 0
        L_0x07d9:
            android.widget.TextView r8 = r1.x     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r8 != 0) goto L_0x07e0
            kotlin.g.b.k.a((java.lang.String) r12)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x07e0:
            java.lang.String r2 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r8.setText(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.view.View r2 = r1.ax     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x07f2
            java.lang.String r3 = "banknameContainer"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x07f2:
            if (r2 == 0) goto L_0x07fa
            r3 = r1
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2.setOnClickListener(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x07fa:
            android.widget.ImageView r2 = r1.av     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0803
            java.lang.String r3 = "bankArrowTV"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0803:
            if (r2 == 0) goto L_0x080b
            r3 = r1
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2.setOnClickListener(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x080b:
            android.view.View r2 = r1.ax     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0814
            java.lang.String r3 = "banknameContainer"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0814:
            if (r2 == 0) goto L_0x08b5
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x08b5
        L_0x081c:
            android.view.View r2 = r1.ax     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0825
            java.lang.String r3 = "banknameContainer"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0825:
            if (r2 == 0) goto L_0x082c
            r3 = 8
            r2.setVisibility(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x082c:
            android.view.View r2 = r1.aw     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0835
            java.lang.String r3 = "bankDetailsContainer"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0835:
            if (r2 == 0) goto L_0x08b5
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x08b5
        L_0x083d:
            r28 = r3
            r29 = r8
            r27 = r9
            r1.Y = r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r1.f55439b = r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r2 = r1.x     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0850
            kotlin.g.b.k.a((java.lang.String) r12)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0850:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r8 = 0
            r9[r8] = r0     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r3 = r1.getString(r3, r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r9 = "getString(\n             …                        )"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r3 = java.lang.String.format(r3, r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2.setText(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2 = 1098907648(0x41800000, float:16.0)
            androidx.fragment.app.FragmentActivity r3 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            int r2 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.ImageView r3 = r1.z     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r3 != 0) goto L_0x0888
            kotlin.g.b.k.a((java.lang.String) r16)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0888:
            r3.setPadding(r2, r2, r2, r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.ImageView r2 = r1.z     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0892
            kotlin.g.b.k.a((java.lang.String) r16)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0892:
            java.lang.String r3 = "UPI"
            androidx.fragment.app.FragmentActivity r8 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r2, (java.lang.String) r3, (android.content.Context) r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r2 = r1.v     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08a4
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x08a4:
            r3 = 8
            r2.setVisibility(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r30.w()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x08b5
        L_0x08ad:
            r26 = r2
            r28 = r3
            r29 = r8
            r27 = r9
        L_0x08b5:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08d1
            java.lang.String r4 = net.one97.paytm.moneytransfer.utils.m.l(r4)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.widget.TextView r2 = r1.t     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08cb
            java.lang.String r3 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x08cb:
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2.setText(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x08d1:
            r2 = r10
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x08df
            int r2 = r2.length()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08dd
            goto L_0x08df
        L_0x08dd:
            r2 = 0
            goto L_0x08e0
        L_0x08df:
            r2 = 1
        L_0x08e0:
            if (r2 != 0) goto L_0x090a
            if (r10 == 0) goto L_0x090a
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.aP     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08eb
            kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x08eb:
            r3 = r10
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2.setText(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.aP     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x08f8
            kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x08f8:
            r3 = 0
            r2.setEnabled(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.upi.util.CommentsEditText r2 = r1.aP     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0903
            kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0903:
            r3 = 0
            r2.setFocusable(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r30.s()     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x090a:
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x092a
            r1.f((java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r1.ad = r6     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f55438a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x091f
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x091f:
            android.widget.EditText r2 = (android.widget.EditText) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            androidx.fragment.app.FragmentActivity r3 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r2, (android.app.Activity) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x092a:
            r8 = r29
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0939
            r8 = r29
            r1.ac = r8     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x093b
        L_0x0939:
            r8 = r29
        L_0x093b:
            java.lang.String r2 = r1.ad     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = net.one97.paytm.moneytransfer.utils.m.h(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x0957
            java.lang.String r2 = r1.ac     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = net.one97.paytm.moneytransfer.utils.m.h(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0957
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f55438a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0952
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0952:
            r3 = 0
            r2.setEnabled(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0962
        L_0x0957:
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f55438a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x095e
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x095e:
            r3 = 1
            r2.setEnabled(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0962:
            r3 = r28
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 != 0) goto L_0x0970
            r3 = r28
            r1.af = r3     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0970:
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x097e
            java.lang.String r3 = "username"
            r2.putString(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x097e:
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x098b
            java.lang.String r3 = "key_amount"
            r2.putString(r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x098b:
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x0998
            java.lang.String r3 = "key_comment"
            r2.putString(r3, r10)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r2 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0998:
            android.os.Bundle r2 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r2 == 0) goto L_0x09a3
            r2.putString(r13, r0)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x09a3:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x09b2
            java.lang.String r2 = "extra_key_ref_url"
            r9 = r27
            r0.putString(r2, r9)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x09b2:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x09c1
            java.lang.String r2 = "extra_key_ref_id"
            r3 = r21
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x09c1:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x09d0
            java.lang.String r2 = "extra_key_mcc"
            r3 = r20
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x09d0:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x09dd
            java.lang.String r2 = "extra_key_upi_min_amount"
            r0.putString(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x09dd:
            boolean r0 = r1.M     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x09f1
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a00
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "01"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0a00
        L_0x09f1:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a00
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "04"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a00:
            r2 = r26
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 != 0) goto L_0x0a24
            java.lang.String r0 = "1"
            r2 = r26
            r3 = 0
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a24
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a24
            java.lang.String r2 = "extra_key_intent_mode"
            java.lang.String r3 = "03"
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a24:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a37
            java.lang.String r2 = "extra_key_intent_sign"
            android.net.Uri r3 = r1.H     // Catch:{ UnsupportedEncodingException -> 0x064a }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a37:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a46
            java.lang.String r2 = "extra_key_intent_orgid"
            r3 = r22
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a46:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a55
            java.lang.String r2 = "extra_key_intent_mid"
            r3 = r23
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a55:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a64
            java.lang.String r2 = "extra_key_intent_msid"
            r3 = r24
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a64:
            android.os.Bundle r0 = r30.getArguments()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a73
            java.lang.String r2 = "extra_key_intent_mtid"
            r3 = r25
            r0.putString(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a73:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a91
            android.content.Intent r0 = r0.getIntent()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a91
            android.os.Bundle r0 = r0.getExtras()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0a91
            java.lang.String r2 = "isGalleryScan"
            r3 = 0
            boolean r0 = r0.getBoolean(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            r2 = 1
            if (r2 != r0) goto L_0x0a91
            r1.aV = r2     // Catch:{ UnsupportedEncodingException -> 0x064a }
        L_0x0a91:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0aab
            android.content.Intent r0 = r0.getIntent()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0aab
            android.os.Bundle r0 = r0.getExtras()     // Catch:{ UnsupportedEncodingException -> 0x064a }
            if (r0 == 0) goto L_0x0aab
            java.lang.String r2 = "isMidScan"
            r3 = 0
            boolean r0 = r0.getBoolean(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0aac
        L_0x0aab:
            r0 = 0
        L_0x0aac:
            r1.aW = r0     // Catch:{ UnsupportedEncodingException -> 0x064a }
            goto L_0x0f1a
        L_0x0ab0:
            r0 = move-exception
            r18 = r2
        L_0x0ab3:
            r19 = r9
        L_0x0ab5:
            r0.printStackTrace()
            goto L_0x0f1a
        L_0x0aba:
            r18 = r2
            r19 = r9
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0acf
            java.lang.String r2 = "isVPA"
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            goto L_0x0ad0
        L_0x0acf:
            r4 = 0
        L_0x0ad0:
            if (r4 != 0) goto L_0x0ad5
            kotlin.g.b.k.a()
        L_0x0ad5:
            boolean r0 = r4.booleanValue()
            r1.Y = r0
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0ae9
            java.lang.String r2 = "upi_p2p_payment_route"
            java.lang.String r4 = r0.getString(r2)
            goto L_0x0aea
        L_0x0ae9:
            r4 = 0
        L_0x0aea:
            r1.ak = r4
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0af9
            java.lang.String r2 = "phone_number"
            java.lang.String r4 = r0.getString(r2)
            goto L_0x0afa
        L_0x0af9:
            r4 = 0
        L_0x0afa:
            r1.aj = r4
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0b0a
            java.lang.String r2 = "user_upi_details"
            java.io.Serializable r4 = r0.getSerializable(r2)
            goto L_0x0b0b
        L_0x0b0a:
            r4 = 0
        L_0x0b0b:
            boolean r0 = r4 instanceof net.one97.paytm.upi.common.upi.UpiProfileDefaultBank
            if (r0 != 0) goto L_0x0b10
            r4 = 0
        L_0x0b10:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r4
            r1.f55444g = r4
            boolean r0 = r1.Y
            java.lang.String r2 = "picture"
            if (r0 == 0) goto L_0x0c0b
            r3 = 0
            r1.O = r3
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            r1.f55439b = r0
            android.widget.TextView r0 = r1.t
            if (r0 != 0) goto L_0x0b2a
            java.lang.String r3 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0b2a:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r3 = r1.aR
            if (r3 == 0) goto L_0x0b39
            net.one97.paytm.common.entity.p2p.ReceiverInfo r3 = r3.getReceiverInfo()
            if (r3 == 0) goto L_0x0b39
            java.lang.String r4 = r3.getName()
            goto L_0x0b3a
        L_0x0b39:
            r4 = 0
        L_0x0b3a:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            android.widget.TextView r0 = r1.x
            if (r0 != 0) goto L_0x0b46
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0b46:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "getString(R.string.money…ransfer_upi_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 1
            java.lang.Object[] r6 = new java.lang.Object[r4]
            android.os.Bundle r8 = r30.getArguments()
            if (r8 == 0) goto L_0x0b61
            java.lang.String r8 = r8.getString(r13)
            goto L_0x0b62
        L_0x0b61:
            r8 = 0
        L_0x0b62:
            r9 = 0
            r6[r9] = r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r3 = java.lang.String.format(r3, r6)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.widget.TextView r0 = r1.v
            if (r0 != 0) goto L_0x0b7c
            kotlin.g.b.k.a((java.lang.String) r14)
        L_0x0b7c:
            r3 = 8
            r0.setVisibility(r3)
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0b8c
            java.lang.String r4 = r0.getString(r2)
            goto L_0x0b8d
        L_0x0b8c:
            r4 = 0
        L_0x0b8d:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0b9a
            int r0 = r4.length()
            if (r0 != 0) goto L_0x0b98
            goto L_0x0b9a
        L_0x0b98:
            r0 = 0
            goto L_0x0b9b
        L_0x0b9a:
            r0 = 1
        L_0x0b9b:
            if (r0 == 0) goto L_0x0bc6
            r0 = 1098907648(0x41800000, float:16.0)
            androidx.fragment.app.FragmentActivity r2 = r30.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            int r0 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r0, r2)
            android.widget.ImageView r2 = r1.z
            if (r2 != 0) goto L_0x0bb0
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0bb0:
            r2.setPadding(r0, r0, r0, r0)
            android.widget.ImageView r0 = r1.z
            if (r0 != 0) goto L_0x0bba
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0bba:
            androidx.fragment.app.FragmentActivity r2 = r30.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = "UPI"
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r0, (java.lang.String) r3, (android.content.Context) r2)
            goto L_0x0c06
        L_0x0bc6:
            android.widget.ImageView r0 = r1.z
            if (r0 != 0) goto L_0x0bcd
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0bcd:
            r3 = 0
            r0.setPadding(r3, r3, r3, r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            android.os.Bundle r3 = r30.getArguments()
            if (r3 == 0) goto L_0x0be0
            java.lang.String r4 = r3.getString(r2)
            goto L_0x0be1
        L_0x0be0:
            r4 = 0
        L_0x0be1:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r4)
            net.one97.paytm.upi.util.CircleTransform r2 = new net.one97.paytm.upi.util.CircleTransform
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.b((int) r2)
            android.widget.ImageView r2 = r1.z
            if (r2 != 0) goto L_0x0c03
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0c03:
            r0.a((android.widget.ImageView) r2)
        L_0x0c06:
            r30.w()
            goto L_0x0d61
        L_0x0c0b:
            net.one97.paytm.moneytransfer.d.d$a r0 = net.one97.paytm.moneytransfer.d.d.f53996a
            net.one97.paytm.moneytransfer.d.d r0 = net.one97.paytm.moneytransfer.d.d.a.a()
            net.one97.paytm.moneytransfer.d.a r0 = net.one97.paytm.moneytransfer.d.d.b(r0)
            androidx.fragment.app.FragmentActivity r3 = r30.getActivity()
            if (r3 != 0) goto L_0x0c1e
            kotlin.g.b.k.a()
        L_0x0c1e:
            java.lang.String r4 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = (android.content.Context) r3
            boolean r0 = r0.b((android.content.Context) r3)
            r1.O = r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            r1.f55439b = r0
            android.widget.TextView r0 = r1.t
            if (r0 != 0) goto L_0x0c38
            java.lang.String r3 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0c38:
            android.os.Bundle r3 = r30.getArguments()
            if (r3 == 0) goto L_0x0c46
            java.lang.String r4 = "username"
            java.lang.String r4 = r3.getString(r4)
            goto L_0x0c47
        L_0x0c46:
            r4 = 0
        L_0x0c47:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            android.widget.TextView r0 = r1.u
            if (r0 != 0) goto L_0x0c55
            java.lang.String r3 = "receiverVPAOrAccountNumber"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0c55:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 1
            java.lang.Object[] r8 = new java.lang.Object[r4]
            android.os.Bundle r9 = r30.getArguments()
            if (r9 == 0) goto L_0x0c70
            java.lang.String r9 = r9.getString(r13)
            goto L_0x0c71
        L_0x0c70:
            r9 = 0
        L_0x0c71:
            java.lang.String r9 = net.one97.paytm.upi.util.UpiUtils.maskAccNumberWithSpace(r9)
            r10 = 0
            r8[r10] = r9
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r4)
            java.lang.String r3 = java.lang.String.format(r3, r8)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0c95
            java.lang.String r3 = "ifsc"
            java.lang.String r4 = r0.getString(r3)
            goto L_0x0c96
        L_0x0c95:
            r4 = 0
        L_0x0c96:
            android.widget.TextView r0 = r1.v
            if (r0 != 0) goto L_0x0c9d
            kotlin.g.b.k.a((java.lang.String) r14)
        L_0x0c9d:
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.v
            if (r0 != 0) goto L_0x0ca8
            kotlin.g.b.k.a((java.lang.String) r14)
        L_0x0ca8:
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_ifsc_with_placeholder_without_bold
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r8 = "getString(R.string.money…placeholder_without_bold)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r10 = 0
            r9[r10] = r4
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r8)
            java.lang.String r3 = java.lang.String.format(r3, r9)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0cd6
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0cd7
        L_0x0cd6:
            r0 = 0
        L_0x0cd7:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0ce4
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0ce2
            goto L_0x0ce4
        L_0x0ce2:
            r0 = 0
            goto L_0x0ce5
        L_0x0ce4:
            r0 = 1
        L_0x0ce5:
            if (r0 == 0) goto L_0x0cf8
            android.widget.ImageView r0 = r1.z
            if (r0 != 0) goto L_0x0cee
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0cee:
            androidx.fragment.app.FragmentActivity r2 = r30.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r0, (java.lang.String) r4, (android.content.Context) r2)
            goto L_0x0d38
        L_0x0cf8:
            android.widget.ImageView r0 = r1.z
            if (r0 != 0) goto L_0x0cff
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0cff:
            r3 = 0
            r0.setPadding(r3, r3, r3, r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            android.os.Bundle r3 = r30.getArguments()
            if (r3 == 0) goto L_0x0d12
            java.lang.String r4 = r3.getString(r2)
            goto L_0x0d13
        L_0x0d12:
            r4 = 0
        L_0x0d13:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r4)
            net.one97.paytm.upi.util.CircleTransform r2 = new net.one97.paytm.upi.util.CircleTransform
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.profile_logout
            com.squareup.picasso.aa r0 = r0.b((int) r2)
            android.widget.ImageView r2 = r1.z
            if (r2 != 0) goto L_0x0d35
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0d35:
            r0.a((android.widget.ImageView) r2)
        L_0x0d38:
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0d55
            java.lang.String r2 = "is_self_account"
            r3 = 0
            boolean r0 = r0.getBoolean(r2, r3)
            r2 = 1
            if (r2 != r0) goto L_0x0d55
            android.widget.ImageView r0 = r1.E
            if (r0 != 0) goto L_0x0d4f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0d4f:
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
            goto L_0x0d61
        L_0x0d55:
            android.widget.ImageView r0 = r1.E
            if (r0 != 0) goto L_0x0d5c
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0d5c:
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.b((android.view.View) r0)
        L_0x0d61:
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0d6d
            java.lang.String r0 = r0.getString(r11)
            if (r0 != 0) goto L_0x0d6f
        L_0x0d6d:
            java.lang.String r0 = ""
        L_0x0d6f:
            r1.f((java.lang.String) r0)
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0d80
            java.lang.String r2 = "txn_id"
            java.lang.String r4 = r0.getString(r2)
            goto L_0x0d81
        L_0x0d80:
            r4 = 0
        L_0x0d81:
            r1.af = r4
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0d91
            java.lang.String r2 = "upi_tran_log_id"
            java.lang.String r4 = r0.getString(r2)
            goto L_0x0d92
        L_0x0d91:
            r4 = 0
        L_0x0d92:
            r1.ae = r4
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x0da3
            r2 = -1
            java.lang.String r3 = "source_of_initiation"
            int r0 = r0.getInt(r3, r2)
            goto L_0x0da4
        L_0x0da3:
            r0 = -1
        L_0x0da4:
            r1.aI = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0dbc
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0dbc
            java.lang.String r2 = "EXTRA_DEEP_LINK_DATA"
            android.os.Parcelable r0 = r0.getParcelableExtra(r2)
            r4 = r0
            net.one97.paytm.deeplink.DeepLinkData r4 = (net.one97.paytm.deeplink.DeepLinkData) r4
            goto L_0x0dbd
        L_0x0dbc:
            r4 = 0
        L_0x0dbd:
            if (r4 == 0) goto L_0x0df0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0dd3
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0dd3
            java.lang.String r2 = "EXTRA_DEEP_LINK_FLAG"
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0dd4
        L_0x0dd3:
            r0 = 0
        L_0x0dd4:
            if (r0 == 0) goto L_0x0ded
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            boolean r2 = r0 instanceof net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity
            if (r2 != 0) goto L_0x0ddf
            r0 = 0
        L_0x0ddf:
            net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity r0 = (net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity) r0
            if (r0 == 0) goto L_0x0de8
            boolean r3 = net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity.a((net.one97.paytm.deeplink.DeepLinkData) r4)
            goto L_0x0de9
        L_0x0de8:
            r3 = 0
        L_0x0de9:
            if (r3 == 0) goto L_0x0ded
            r0 = 1
            goto L_0x0dee
        L_0x0ded:
            r0 = 0
        L_0x0dee:
            r1.L = r0
        L_0x0df0:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e04
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e04
            java.lang.String r2 = "is_from_univ_p2p"
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e06
        L_0x0e04:
            r3 = 0
            r0 = 0
        L_0x0e06:
            r1.P = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e1b
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e1b
            java.lang.String r2 = "is_for_imps_from_univ_p2p"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e1c
        L_0x0e1b:
            r0 = 0
        L_0x0e1c:
            r1.Q = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e31
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e31
            java.lang.String r2 = "add_money_to_ppb"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e32
        L_0x0e31:
            r0 = 0
        L_0x0e32:
            r1.R = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e47
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e47
            java.lang.String r2 = "intent_extra_is_offline_pg"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e48
        L_0x0e47:
            r0 = 0
        L_0x0e48:
            r1.S = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e5e
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e5e
            java.lang.String r2 = "upi_push"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e5f
        L_0x0e5e:
            r0 = 0
        L_0x0e5f:
            r1.T = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e74
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e74
            java.lang.String r2 = "is_collect_request"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e75
        L_0x0e74:
            r0 = 0
        L_0x0e75:
            r1.f55441d = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0e8b
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0e8b
            java.lang.String r2 = "upi_is_self"
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x0e8c
        L_0x0e8b:
            r0 = 0
        L_0x0e8c:
            r1.N = r0
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r1.f55443f
            if (r0 == 0) goto L_0x0ea5
            boolean r2 = r1.P
            boolean r3 = r1.S
            boolean r4 = r1.T
            boolean r6 = r1.R
            r0.j = r2
            r2 = 0
            r0.k = r2
            r0.l = r3
            r0.m = r4
            r0.n = r6
        L_0x0ea5:
            boolean r0 = r1.Q
            if (r0 == 0) goto L_0x0ead
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            r1.f55446i = r0
        L_0x0ead:
            boolean r0 = r1.P
            if (r0 != 0) goto L_0x0ebd
            boolean r0 = r1.R
            if (r0 != 0) goto L_0x0ebd
            boolean r0 = r1.T
            if (r0 != 0) goto L_0x0ebd
            boolean r0 = r1.S
            if (r0 == 0) goto L_0x0ec0
        L_0x0ebd:
            r30.J()
        L_0x0ec0:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0ed4
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0ed4
            java.lang.String r2 = "uni_p2p_landing_intent_extra_theme"
            java.lang.String r4 = r0.getStringExtra(r2)
            goto L_0x0ed5
        L_0x0ed4:
            r4 = 0
        L_0x0ed5:
            r1.aJ = r4
            boolean r0 = r1.f55441d
            if (r0 == 0) goto L_0x0f1a
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x0eec
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0eec
            java.lang.String r4 = r0.getStringExtra(r11)
            goto L_0x0eed
        L_0x0eec:
            r4 = 0
        L_0x0eed:
            r1.f((java.lang.String) r4)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0ef7
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0ef7:
            r2 = 0
            r0.setEnabled(r2)
            android.widget.TextView r0 = r1.aO
            if (r0 != 0) goto L_0x0f04
            java.lang.String r2 = "addMessageTextView"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0f04:
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.aP
            if (r0 != 0) goto L_0x0f10
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0f10:
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
            goto L_0x0f1a
        L_0x0f16:
            r18 = r2
            r19 = r9
        L_0x0f1a:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r1.aR
            if (r0 == 0) goto L_0x0f2f
            r30.q()
            r30.r()
            r30.o()
            r30.p()
            r30.Y()
            goto L_0x1037
        L_0x0f2f:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r1.f55443f
            if (r0 == 0) goto L_0x0f36
            r0.d()
        L_0x0f36:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r1.f55443f
            if (r0 == 0) goto L_0x0f4d
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r0 = r0.o
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0f4d
            r2 = r1
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.moneytransferv4.home.presentation.a.b$aa r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$aa
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0f4d:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x0f54
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x0f54:
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>> r0 = r0.f55569i
            if (r0 != 0) goto L_0x0f5b
            kotlin.g.b.k.a()
        L_0x0f5b:
            r2 = r1
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.moneytransferv4.home.presentation.a.b$z r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$z
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
            r30.q()
            r30.r()
            r30.o()
            android.net.Uri r0 = r1.H
            if (r0 == 0) goto L_0x0fa4
            if (r0 == 0) goto L_0x0f7e
            java.lang.String r3 = "pa"
            java.lang.String r4 = r0.getQueryParameter(r3)
            goto L_0x0f7f
        L_0x0f7e:
            r4 = 0
        L_0x0f7f:
            android.net.Uri r0 = r1.H
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r4 == 0) goto L_0x0f91
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r3 = r1.Z
            if (r3 != 0) goto L_0x0f8e
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x0f8e:
            r3.a((java.lang.String) r4, (java.lang.String) r0)
        L_0x0f91:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x0f98
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x0f98:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$b>> r0 = r0.o
            net.one97.paytm.moneytransferv4.home.presentation.a.b$ab r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$ab
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x0fa4:
            r30.p()
            r30.Y()
            boolean r0 = r1.Y
            if (r0 != 0) goto L_0x0fdd
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x0fb5
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x0fb5:
            if (r0 == 0) goto L_0x0fba
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r4 = r0.p
            goto L_0x0fbb
        L_0x0fba:
            r4 = 0
        L_0x0fbb:
            if (r4 == 0) goto L_0x0fc4
            java.lang.Object r0 = r4.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r0 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r0
            goto L_0x0fc5
        L_0x0fc4:
            r0 = 0
        L_0x0fc5:
            if (r0 == 0) goto L_0x0fd1
            r30.aq()
            r30.as()
            r30.ae()
            goto L_0x0fdd
        L_0x0fd1:
            if (r4 == 0) goto L_0x0fdd
            net.one97.paytm.moneytransferv4.home.presentation.a.b$w r0 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$w
            r0.<init>(r1)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r4.observe(r2, r0)
        L_0x0fdd:
            boolean r0 = r1.Y
            if (r0 != 0) goto L_0x1020
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x0fe8
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x0fe8:
            if (r0 == 0) goto L_0x0ff6
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55565e
            if (r0 == 0) goto L_0x0ff6
            java.lang.Object r0 = r0.getValue()
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0ff7
        L_0x0ff6:
            r4 = 0
        L_0x0ff7:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x1009
            r30.al()
            r30.as()
            r30.ae()
            goto L_0x1020
        L_0x1009:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x1010
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x1010:
            if (r0 == 0) goto L_0x1020
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55565e
            if (r0 == 0) goto L_0x1020
            net.one97.paytm.moneytransferv4.home.presentation.a.b$x r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$x
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x1020:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r1.Z
            if (r0 != 0) goto L_0x1027
            kotlin.g.b.k.a((java.lang.String) r19)
        L_0x1027:
            if (r0 == 0) goto L_0x1037
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$a>> r0 = r0.m
            if (r0 == 0) goto L_0x1037
            net.one97.paytm.moneytransferv4.home.presentation.a.b$r r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$r
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x1037:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r1.f55443f
            if (r0 == 0) goto L_0x104c
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<java.lang.Boolean>> r0 = r0.f55603d
            if (r0 == 0) goto L_0x104c
            r2 = r1
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.moneytransferv4.home.presentation.a.b$c r3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$c
            r3.<init>(r1)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x104c:
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x1060
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x1060
            java.lang.String r2 = "from_app_evoke"
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            goto L_0x1062
        L_0x1060:
            r3 = 0
            r0 = 0
        L_0x1062:
            r1.V = r0
            androidx.fragment.app.FragmentActivity r0 = r30.getActivity()
            if (r0 == 0) goto L_0x1076
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x1076
            java.lang.String r2 = "is_from_chat_flow"
            boolean r3 = r0.getBooleanExtra(r2, r3)
        L_0x1076:
            r1.W = r3
            android.content.Context r0 = r18.getContext()
            java.lang.String r2 = "/mt_p2p_enter_amt_screen"
            net.one97.paytm.moneytransfer.utils.f.a(r0, r2)
            r30.n()
            android.os.Bundle r0 = r30.getArguments()
            if (r0 == 0) goto L_0x1091
            java.lang.String r2 = "extra_key_intent_mid"
            java.lang.String r4 = r0.getString(r2)
            goto L_0x1092
        L_0x1091:
            r4 = 0
        L_0x1092:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r2 = 1
            r0 = r0 ^ r2
            android.content.Context r2 = r30.getContext()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "mt_p2p_new_v1"
            java.lang.String r4 = "enter_amt_screen_loaded"
            java.lang.String r5 = "/mt_p2p_enter_amt_screen"
            java.lang.String r7 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
            return r18
        L_0x10ae:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    private final void n() {
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.aR;
        if (paymentCombinationAPIResponse == null) {
            return;
        }
        if (a(paymentCombinationAPIResponse)) {
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
            if (customAmountTextInputEditText == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText.setEnabled(false);
            CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f55438a;
            if (customAmountTextInputEditText2 == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText2.setFocusable(false);
            TextView textView = this.aO;
            if (textView == null) {
                kotlin.g.b.k.a("addMessageTextView");
            }
            textView.setClickable(false);
            TextView textView2 = this.aO;
            if (textView2 == null) {
                kotlin.g.b.k.a("addMessageTextView");
            }
            textView2.setFocusable(false);
            View view = this.am;
            if (view == null) {
                kotlin.g.b.k.a("selectedAccCardView");
            }
            net.one97.paytm.upi.f.a(view);
            LinearLayout linearLayout = this.an;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mPayWrapper");
            }
            net.one97.paytm.upi.f.b((View) linearLayout);
            TextView textView3 = this.aq;
            if (textView3 == null) {
                kotlin.g.b.k.a("mSelectedSourceBankTv");
            }
            textView3.setText(getString(R.string.mt_choose_an_option));
            TextView textView4 = this.y;
            if (textView4 == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            Drawable background = textView4.getBackground();
            if (background != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.setColor(Color.parseColor("#80D5F6"));
                ImageView imageView = this.ar;
                if (imageView == null) {
                    kotlin.g.b.k.a("bankImageCollapsedView");
                }
                net.one97.paytm.upi.f.a((View) imageView);
                TextView textView5 = this.y;
                if (textView5 == null) {
                    kotlin.g.b.k.a("mProceedPayment");
                }
                textView5.setBackground(gradientDrawable);
                CustomAmountTextInputEditText customAmountTextInputEditText3 = this.f55438a;
                if (customAmountTextInputEditText3 == null) {
                    kotlin.g.b.k.a("amountET");
                }
                customAmountTextInputEditText3.post(new C1026b(this));
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText4 = this.f55438a;
        if (customAmountTextInputEditText4 == null) {
            kotlin.g.b.k.a("amountET");
        }
        customAmountTextInputEditText4.setEnabled(true);
        CustomAmountTextInputEditText customAmountTextInputEditText5 = this.f55438a;
        if (customAmountTextInputEditText5 == null) {
            kotlin.g.b.k.a("amountET");
        }
        customAmountTextInputEditText5.setFocusable(true);
        TextView textView6 = this.aO;
        if (textView6 == null) {
            kotlin.g.b.k.a("addMessageTextView");
        }
        textView6.setClickable(true);
        TextView textView7 = this.aO;
        if (textView7 == null) {
            kotlin.g.b.k.a("addMessageTextView");
        }
        textView7.setFocusable(true);
        View view2 = this.am;
        if (view2 == null) {
            kotlin.g.b.k.a("selectedAccCardView");
        }
        view2.setVisibility(0);
        LinearLayout linearLayout2 = this.an;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("mPayWrapper");
        }
        net.one97.paytm.upi.f.a((View) linearLayout2);
        ImageView imageView2 = this.ar;
        if (imageView2 == null) {
            kotlin.g.b.k.a("bankImageCollapsedView");
        }
        net.one97.paytm.upi.f.b((View) imageView2);
    }

    /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.a.b$b  reason: collision with other inner class name */
    static final class C1026b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55463a;

        C1026b(b bVar) {
            this.f55463a = bVar;
        }

        public final void run() {
            this.f55463a.b(true);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        String string;
        Editable text;
        String obj;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        a(view);
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.aR;
        String str3 = null;
        ExtraData extraData = paymentCombinationAPIResponse != null ? paymentCombinationAPIResponse.getExtraData() : null;
        if (extraData != null) {
            String amount = extraData.getAmount();
            if (amount == null) {
                amount = "";
            }
            String comment = extraData.getComment();
            if (comment == null) {
                comment = "";
            }
            CharSequence charSequence = amount;
            if (!kotlin.m.p.a(charSequence)) {
                CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
                if (customAmountTextInputEditText == null) {
                    kotlin.g.b.k.a("amountET");
                }
                customAmountTextInputEditText.setText(charSequence);
                CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f55438a;
                if (customAmountTextInputEditText2 == null) {
                    kotlin.g.b.k.a("amountET");
                }
                customAmountTextInputEditText2.setEnabled(extraData.isAmountEditable());
                CustomAmountTextInputEditText customAmountTextInputEditText3 = this.f55438a;
                if (customAmountTextInputEditText3 == null) {
                    kotlin.g.b.k.a("amountET");
                }
                customAmountTextInputEditText3.setFocusable(extraData.isAmountEditable());
            }
            CharSequence charSequence2 = comment;
            if (!kotlin.m.p.a(charSequence2)) {
                CommentsEditText commentsEditText = this.aP;
                if (commentsEditText == null) {
                    kotlin.g.b.k.a("messageEditText");
                }
                commentsEditText.setText(charSequence2);
                s();
                CommentsEditText commentsEditText2 = this.aP;
                if (commentsEditText2 == null) {
                    kotlin.g.b.k.a("messageEditText");
                }
                commentsEditText2.setEnabled(extraData.isCommentEditable());
                CommentsEditText commentsEditText3 = this.aP;
                if (commentsEditText3 == null) {
                    kotlin.g.b.k.a("messageEditText");
                }
                commentsEditText3.setFocusable(extraData.isCommentEditable());
            }
        }
        if (this.aV && UpiUtils.doShowScanAndPayPopUp(getActivity())) {
            net.one97.paytm.moneytransfer.view.b.a aVar = new net.one97.paytm.moneytransfer.view.b.a();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("from_scan_pay", true);
            bundle2.putBoolean("mid_scan_pay", this.aW);
            Bundle arguments = getArguments();
            if (arguments != null) {
                str3 = arguments.getString("username");
            }
            bundle2.putString("name", str3);
            aVar.setArguments(bundle2);
            aVar.show(getChildFragmentManager(), "");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText4 = this.f55438a;
        if (customAmountTextInputEditText4 == null) {
            kotlin.g.b.k.a("amountET");
        }
        if (customAmountTextInputEditText4 == null || (text = customAmountTextInputEditText4.getText()) == null || (obj = text.toString()) == null) {
            str = "";
        } else {
            str = obj;
        }
        if (this.f55440c) {
            Context context = getContext();
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                str2 = "";
            } else {
                str2 = string;
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.INTENT, "screen_open", "", "", "", str2, str, Events.Screen.ENTER_AMOUNT, "");
        }
    }

    private final void o() {
        androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<c.e>> yVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null && (yVar = cVar.f55601b) != null) {
            yVar.observe(this, new s(this));
        }
    }

    private final void p() {
        androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<c.d>> yVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null && (yVar = cVar.f55608i) != null) {
            yVar.observe(this, new y(this));
        }
    }

    private final void q() {
        androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<String>> yVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null && (yVar = cVar.f55606g) != null) {
            yVar.observe(this, new u(this));
        }
    }

    private final void r() {
        androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<String>> yVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null && (yVar = cVar.f55604e) != null) {
            yVar.observe(this, new t(this));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55467a;

        e(b bVar) {
            this.f55467a = bVar;
        }

        public final void onClick(View view) {
            this.f55467a.b(true);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55468a;

        f(b bVar) {
            this.f55468a = bVar;
        }

        public final void onClick(View view) {
            this.f55468a.s();
        }
    }

    /* access modifiers changed from: private */
    public final void s() {
        TextView textView = this.aO;
        if (textView == null) {
            kotlin.g.b.k.a("addMessageTextView");
        }
        net.one97.paytm.upi.f.a((View) textView);
        CommentsEditText commentsEditText = this.aP;
        if (commentsEditText == null) {
            kotlin.g.b.k.a("messageEditText");
        }
        net.one97.paytm.upi.f.b((View) commentsEditText);
        CommentsEditText commentsEditText2 = this.aP;
        if (commentsEditText2 == null) {
            kotlin.g.b.k.a("messageEditText");
        }
        commentsEditText2.requestFocus();
        LinearLayout linearLayout = this.aS;
        if (linearLayout == null) {
            kotlin.g.b.k.a("amountRootLayout");
        }
        linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingEnd(), (int) linearLayout.getResources().getDimension(R.dimen.dimen_120dp));
        CommentsEditText commentsEditText3 = this.aP;
        if (commentsEditText3 == null) {
            kotlin.g.b.k.a("messageEditText");
        }
        commentsEditText3.post(new ae(this));
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_MESSAGE_CLICKED, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
    }

    static final class ae implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55452a;

        ae(b bVar) {
            this.f55452a = bVar;
        }

        public final void run() {
            net.one97.paytm.moneytransfer.utils.m.a((EditText) b.t(this.f55452a), (Activity) this.f55452a.getActivity());
        }
    }

    static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55479a;

        q(b bVar) {
            this.f55479a = bVar;
        }

        public final void run() {
            b.u(this.f55479a).c(b.u(this.f55479a).getTop());
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55473a;

        k(b bVar) {
            this.f55473a = bVar;
        }

        public final void onClick(View view) {
            String str;
            String string;
            String str2;
            String string2;
            new Handler().post(new q(this.f55473a));
            this.f55473a.a(false);
            Fragment parentFragment = this.f55473a.getParentFragment();
            if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                parentFragment = null;
            }
            net.one97.paytm.moneytransferv4.a.a.a aVar = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment;
            if (aVar != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(aVar.a().f53764c);
                kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from…inding.bottomSheetLayout)");
                from.setState(3);
            }
            net.one97.paytm.moneytransfer.utils.f.a(view.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_AMOUNT_CLICKED, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
            if (this.f55473a.f55441d) {
                Context requireContext = this.f55473a.requireContext();
                Bundle arguments = this.f55473a.getArguments();
                if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                    str2 = "";
                } else {
                    str2 = string2;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, CJRGTMConstants.MT_V4_AMOUNT_CLICKED, "", "", "", str2, "", Events.Screen.ENTER_AMOUNT, "");
            } else if (this.f55473a.f()) {
                Context requireContext2 = this.f55473a.requireContext();
                Bundle arguments2 = this.f55473a.getArguments();
                if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                    str = "";
                } else {
                    str = string;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, CJRGTMConstants.MT_V4_AMOUNT_CLICKED, "", "", "", str, "", Events.Screen.ENTER_AMOUNT, "");
            }
        }
    }

    public static final class l implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55474a;

        l(b bVar) {
            this.f55474a = bVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            kotlin.g.b.k.c(textView, "v");
            if (i2 != 6) {
                return false;
            }
            this.f55474a.a(true);
            return false;
        }
    }

    static final class m implements CustomAmountTextInputEditText.EditTextImeBackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55475a;

        m(b bVar) {
            this.f55475a = bVar;
        }

        public final void onImeBack(CustomAmountTextInputEditText customAmountTextInputEditText, String str) {
            try {
                this.f55475a.a(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final class n implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55476a;

        n(b bVar) {
            this.f55476a = bVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            kotlin.g.b.k.c(textView, "v");
            if (i2 != 6) {
                return false;
            }
            this.f55476a.a(true);
            return false;
        }
    }

    static final class o implements CommentsEditText.EditTextImeBackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55477a;

        o(b bVar) {
            this.f55477a = bVar;
        }

        public final void onImeBack(CommentsEditText commentsEditText, String str) {
            try {
                this.f55477a.a(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55478a;

        p(b bVar) {
            this.f55478a = bVar;
        }

        public final void onClick(View view) {
            String str;
            String string;
            String str2;
            String string2;
            if (this.f55478a.f55441d) {
                Context requireContext = this.f55478a.requireContext();
                Bundle arguments = this.f55478a.getArguments();
                if (arguments == null || (string2 = arguments.getString("vpa")) == null) {
                    str2 = "";
                } else {
                    str2 = string2;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, CJRGTMConstants.MT_V4_MESSAGE_CLICKED, "", "", "", str2, "", Events.Screen.ENTER_AMOUNT, "");
            } else if (this.f55478a.f()) {
                Context requireContext2 = this.f55478a.requireContext();
                Bundle arguments2 = this.f55478a.getArguments();
                if (arguments2 == null || (string = arguments2.getString("vpa")) == null) {
                    str = "";
                } else {
                    str = string;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, Events.Category.INTENT, CJRGTMConstants.MT_V4_MESSAGE_CLICKED, "", "", "", str, "", Events.Screen.ENTER_AMOUNT, "");
            }
        }
    }

    public final void a(boolean z2) {
        if (!z2 || !v() || a(this.aR)) {
            u();
        } else {
            t();
        }
    }

    private static boolean a(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
        if (paymentCombinationAPIResponse == null) {
            return false;
        }
        b.a aVar = net.one97.paytm.moneytransferv4.g.b.f55426a;
        return b.a.a(paymentCombinationAPIResponse) == -1;
    }

    private final void t() {
        LinearLayout linearLayout = this.an;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mPayWrapper");
        }
        linearLayout.setVisibility(8);
        View view = this.am;
        if (view == null) {
            kotlin.g.b.k.a("selectedAccCardView");
        }
        if (view.getVisibility() == 8) {
            View view2 = this.am;
            if (view2 == null) {
                kotlin.g.b.k.a("selectedAccCardView");
            }
            net.one97.paytm.moneytransfer.utils.c.b(view2);
        }
        net.one97.paytm.moneytransferv4.f.a aVar = this.aM;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void u() {
        View view = this.am;
        if (view == null) {
            kotlin.g.b.k.a("selectedAccCardView");
        }
        if (view.getVisibility() == 0) {
            View view2 = this.am;
            if (view2 == null) {
                kotlin.g.b.k.a("selectedAccCardView");
            }
            net.one97.paytm.moneytransfer.utils.c.a(view2);
        }
        net.one97.paytm.moneytransferv4.f.a aVar = this.aM;
        if (aVar != null) {
            aVar.b();
        }
        LinearLayout linearLayout = this.an;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mPayWrapper");
        }
        linearLayout.setVisibility(0);
    }

    private final boolean v() {
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        return (arrayList != null && arrayList.size() > 0) || this.aR != null;
    }

    private final void w() {
        View view = this.aw;
        if (view == null) {
            kotlin.g.b.k.a("bankDetailsContainer");
        }
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.ax;
        if (view2 == null) {
            kotlin.g.b.k.a("banknameContainer");
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ImageView imageView = this.av;
        if (imageView == null) {
            kotlin.g.b.k.a("bankArrowTV");
        }
        if (imageView != null) {
            imageView.setVisibility(8);
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
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
    }

    public final void a(int i2) {
        if (!(!this.aF.isEmpty()) || i2 >= this.aF.size()) {
            RelativeLayout relativeLayout = this.A;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mOpenBottomSheetRlv");
            }
            relativeLayout.setVisibility(8);
            if (aD()) {
                x();
                return;
            }
            if (net.one97.paytm.moneytransfer.utils.m.b(getContext())) {
                if (getContext() == null) {
                    kotlin.g.b.k.a();
                }
                if (getContext() == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.upi.registration.b.a.b a2 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
                kotlin.g.b.k.a((Object) a2, "Injection.provideUpiRegi…, null)\n                )");
                if (!a2.h() || y()) {
                    TextView textView = this.y;
                    if (textView == null) {
                        kotlin.g.b.k.a("mProceedPayment");
                    }
                    textView.setText(requireContext().getString(R.string.upi_link_account));
                    net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "link_bank_account_visible", "/money-transfer/payment", "", "");
                    net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar = this.aH;
                    if (aVar != null) {
                        aVar.c();
                    }
                    RelativeLayout relativeLayout2 = this.A;
                    if (relativeLayout2 == null) {
                        kotlin.g.b.k.a("mOpenBottomSheetRlv");
                    }
                    relativeLayout2.setVisibility(8);
                    return;
                }
            }
            ad();
            return;
        }
        UpiProfileDefaultBank upiProfileDefaultBank = this.aF.get(i2);
        kotlin.g.b.k.a((Object) upiProfileDefaultBank, "vpaList.get(position)");
        UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
        if (upiProfileDefaultBank2 == null) {
            kotlin.g.b.k.a();
        }
        b(upiProfileDefaultBank2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r0.f55565e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r2 = this;
            boolean r0 = r2.Y
            if (r0 != 0) goto L_0x0023
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x000d
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000d:
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55565e
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x004c
        L_0x0023:
            android.widget.TextView r0 = r2.y
            if (r0 != 0) goto L_0x002c
            java.lang.String r1 = "mProceedPayment"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x002c:
            int r1 = net.one97.paytm.moneytransfer.R.string.upi_reactivate_account
            java.lang.String r1 = r2.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a r0 = r2.aH
            if (r0 == 0) goto L_0x003e
            r0.c()
        L_0x003e:
            android.widget.RelativeLayout r0 = r2.A
            if (r0 != 0) goto L_0x0047
            java.lang.String r1 = "mOpenBottomSheetRlv"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0047:
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.x():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (net.one97.paytm.moneytransfer.model.c) (r0 = r0.o).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean y() {
        /*
            r2 = this;
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r2.f55443f
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r0 = r0.o
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.moneytransfer.model.c r0 = (net.one97.paytm.moneytransfer.model.c) r0
            if (r0 == 0) goto L_0x0017
            ResultType r0 = r0.f54033b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0022
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0022
            return r1
        L_0x0022:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.y():boolean");
    }

    private final void b(UpiProfileDefaultBank upiProfileDefaultBank) {
        RelativeLayout relativeLayout = this.A;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mOpenBottomSheetRlv");
        }
        relativeLayout.setVisibility(0);
        TextView textView = this.y;
        if (textView == null) {
            kotlin.g.b.k.a("mProceedPayment");
        }
        textView.setText(getString(R.string.pay));
        this.f55444g = upiProfileDefaultBank;
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
                        this.J = debitBank4.getAccount();
                        TextView textView2 = this.as;
                        if (textView2 == null) {
                            kotlin.g.b.k.a("mCardSelectedBankNameTv");
                        }
                        textView2.setText(net.one97.paytm.moneytransfer.utils.m.a(debitBank4.getBankName(), debitBank4.getAccount()));
                        if (debitBank4.isMpinSet()) {
                            ai();
                        } else {
                            aj();
                        }
                        this.K = debitBank4.getIfsc();
                        if (upiProfileDefaultBank.getPaymentMode() == UpiProfileDefaultBank.PAYMENT_MODE.IMPS) {
                            ImageView imageView = this.au;
                            if (imageView == null) {
                                kotlin.g.b.k.a("mCardSelectedBankIv");
                            }
                            String str = this.K;
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.moneytransfer.utils.m.a(imageView, str, (Context) getActivity());
                            ImageView imageView2 = this.aT;
                            if (imageView2 == null) {
                                kotlin.g.b.k.a("collapsedBankImageView");
                            }
                            net.one97.paytm.moneytransfer.utils.m.a(imageView2, this.K, (Context) getActivity());
                            if (kotlin.g.b.k.a((Object) "CURRENT", (Object) debitBank4.getAccountType())) {
                                View view = this.aC;
                                if (view == null) {
                                    kotlin.g.b.k.a("currentAccountTV");
                                }
                                view.setVisibility(0);
                                TextView textView3 = this.aq;
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
                                TextView textView4 = this.aq;
                                if (textView4 == null) {
                                    kotlin.g.b.k.a("mSelectedSourceBankTv");
                                }
                                textView4.setText(net.one97.paytm.moneytransfer.utils.m.a(getString(R.string.mt_v4_selected_bank, debitBank4.getBankName()), debitBank4.getAccount()));
                            }
                        } else {
                            TextView textView5 = this.aq;
                            if (textView5 == null) {
                                kotlin.g.b.k.a("mSelectedSourceBankTv");
                            }
                            textView5.setText(net.one97.paytm.moneytransfer.utils.m.a(getString(R.string.mt_v4_selected_bank, debitBank4.getBankName()), debitBank4.getAccount()));
                            if (!TextUtils.isEmpty(debitBank4.getBankLogoUrl())) {
                                ImageView imageView3 = this.au;
                                if (imageView3 == null) {
                                    kotlin.g.b.k.a("mCardSelectedBankIv");
                                }
                                net.one97.paytm.moneytransfer.utils.m.a(imageView3, debitBank4.getBankLogoUrl(), (Context) getActivity());
                                ImageView imageView4 = this.aT;
                                if (imageView4 == null) {
                                    kotlin.g.b.k.a("collapsedBankImageView");
                                }
                                net.one97.paytm.moneytransfer.utils.m.a(imageView4, debitBank4.getBankLogoUrl(), (Context) getActivity());
                            }
                            View view3 = this.aC;
                            if (view3 == null) {
                                kotlin.g.b.k.a("currentAccountTV");
                            }
                            view3.setVisibility(8);
                        }
                        RelativeLayout relativeLayout2 = this.A;
                        if (relativeLayout2 == null) {
                            kotlin.g.b.k.a("mOpenBottomSheetRlv");
                        }
                        relativeLayout2.setVisibility(0);
                        c();
                    }
                }
            }
        }
    }

    private final void z() {
        if (this.aR == null) {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar = this.aH;
            if (aVar == null) {
                a.b bVar = net.one97.paytm.moneytransferv4.accountsbottomsheet.a.j;
                net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar2 = new net.one97.paytm.moneytransferv4.accountsbottomsheet.a();
                aVar2.setArguments((Bundle) null);
                this.aH = aVar2;
                net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar3 = this.aH;
                if (aVar3 != null) {
                    a.C0995a gVar = new g(this);
                    kotlin.g.b.k.c(gVar, H5Event.TYPE_CALL_BACK);
                    aVar3.f55011g = gVar;
                }
                net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar4 = this.aH;
                if (aVar4 != null) {
                    aVar4.a(Integer.valueOf(this.f55442e));
                }
                net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar5 = this.aH;
                if (aVar5 != null) {
                    List<? extends UpiProfileDefaultBank> list = this.aF;
                    kotlin.g.b.k.c(list, "vpaList");
                    aVar5.f55008d = list;
                }
                net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar6 = this.aH;
                if (aVar6 != null) {
                    aVar6.f55010f = this.f55440c;
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.a(Integer.valueOf(this.f55442e));
            }
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar7 = this.aH;
            if (aVar7 != null) {
                List<? extends UpiProfileDefaultBank> list2 = this.aF;
                kotlin.g.b.k.c(list2, "vpaList");
                aVar7.f55008d = list2;
                net.one97.paytm.moneytransferv4.accountsbottomsheet.e eVar = aVar7.f55007c;
                if (eVar != null) {
                    eVar.a((List<UpiProfileDefaultBank>) list2);
                    return;
                }
                return;
            }
            return;
        }
        View view = getView();
        if (view != null) {
            kotlin.g.b.k.a((Object) view, "it");
            a(view);
        }
    }

    public static final class g implements a.C0995a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55469a;

        g(b bVar) {
            this.f55469a = bVar;
        }

        public final void a() {
            this.f55469a.g();
        }
    }

    private final void a(View view) {
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.aR;
        if (paymentCombinationAPIResponse != null && this.aQ == null) {
            if (view != null) {
                net.one97.paytm.moneytransfer.c.ag a2 = net.one97.paytm.moneytransfer.c.ag.a(view);
                kotlin.g.b.k.a((Object) a2, "MtV4FragmentPaymentLayoutBinding.bind(view!!)");
                View findViewById = view.findViewById(R.id.mt_selected_account_cv);
                if (findViewById == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.moneytransfer.c.ac a3 = net.one97.paytm.moneytransfer.c.ac.a(findViewById);
                kotlin.g.b.k.a((Object) a3, "MtV4BottomPaymentCardLay…t_selected_account_cv)!!)");
                this.k = new net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d(a2, a3);
            }
            b.a aVar = net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b.f55101h;
            this.aQ = b.a.a(paymentCombinationAPIResponse);
            aw();
        }
    }

    public final void b(boolean z2) {
        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar;
        if (Z()) {
            if (!z2) {
                E();
                net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar2 = this.aQ;
                if (!(bVar2 == null || true != bVar2.isAdded() || (bVar = this.aQ) == null)) {
                    bVar.dismiss();
                }
            } else if (this.aR != null) {
                B();
            } else {
                A();
            }
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "down_arrow_clicked", CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
        }
    }

    private final void A() {
        net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar = this.aH;
        if (aVar != null && !aVar.isAdded()) {
            UpiAppUtils.hideKeyboard(getActivity());
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar2 = this.aH;
            if (aVar2 != null) {
                aVar2.showNow(getChildFragmentManager(), net.one97.paytm.moneytransferv4.accountsbottomsheet.a.class.getName());
            }
            UpiAppUtils.hideKeyboard(getActivity());
        }
    }

    private final void B() {
        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar = this.aQ;
        if (bVar != null && !bVar.isAdded()) {
            UpiAppUtils.hideKeyboard(getActivity());
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar2 = this.aQ;
            if (bVar2 != null) {
                bVar2.showNow(getChildFragmentManager(), net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b.class.getName());
            }
            UpiAppUtils.hideKeyboard(getActivity());
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((MoneyTransferV4Activity) activity).a(upiCustomVolleyError);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity");
        }
    }

    private void a(MoneyTransferV3Activity.b bVar) {
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
                ((MoneyTransferV4Activity) activity2).e(str);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity");
        }
    }

    public static final class aj implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55460a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "editable");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
        }

        aj(b bVar) {
            this.f55460a = bVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
            boolean z = false;
            if (charSequence.length() == 0) {
                b.K(this.f55460a).setVisibility(4);
                b.L(this.f55460a);
                this.f55460a.g("");
                return;
            }
            b.M(this.f55460a);
            b.N(this.f55460a);
            if (net.one97.paytm.moneytransfer.utils.m.m(charSequence.toString())) {
                TextView K = b.K(this.f55460a);
                kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
                String string = this.f55460a.getString(R.string.mt_amount_in_words_placeholder_singular);
                kotlin.g.b.k.a((Object) string, "getString(R.string.mt_am…rds_placeholder_singular)");
                String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(net.one97.paytm.moneytransfer.utils.m.g(String.valueOf(b.E(this.f55460a).getText())))}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                K.setText(format);
            } else {
                TextView K2 = b.K(this.f55460a);
                kotlin.g.b.aa aaVar2 = kotlin.g.b.aa.f47921a;
                String string2 = this.f55460a.getString(R.string.mt_amount_in_words_placeholder);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.mt_amount_in_words_placeholder)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(net.one97.paytm.moneytransfer.utils.m.g(String.valueOf(b.E(this.f55460a).getText())))}, 1));
                kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                K2.setText(format2);
            }
            b.K(this.f55460a).setVisibility(0);
            if (this.f55460a.f55439b == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                FragmentActivity activity = this.f55460a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                if (b2.b((Context) activity) && this.f55460a.C()) {
                    try {
                        double parseDouble = Double.parseDouble(UpiAppUtils.getCleanString(String.valueOf(b.E(this.f55460a).getText())));
                        b bVar = this.f55460a;
                        if (parseDouble >= UpiUtils.getUpiIMPSSwitchLimit(this.f55460a.getContext())) {
                            z = true;
                        }
                        bVar.G = z;
                        this.f55460a.c();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f55460a.g(charSequence.toString());
            if (!this.f55460a.aX) {
                this.f55460a.aX = true;
                net.one97.paytm.moneytransferv4.f.a D = this.f55460a.aM;
                if (D != null) {
                    D.a();
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
    public final void c() {
        /*
            r3 = this;
            boolean r0 = r3.ap()
            if (r0 != 0) goto L_0x0029
            boolean r0 = r3.G
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r3.r
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.f55444g
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
            r3.f55446i = r0
            return
        L_0x0029:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            r3.f55446i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.c():void");
    }

    public final void d() {
        String str;
        Context context;
        androidx.fragment.app.j supportFragmentManager;
        List<Fragment> g2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            boolean z2 = ((MoneyTransferV4Activity) activity).f55514a != null;
            Integer num = null;
            if (this.f55440c) {
                if (this.M) {
                    UpiAppUtils.hideKeyboard(getActivity());
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                } else {
                    a((Bundle) null);
                }
            } else if (!this.L && !this.f55441d && !z2) {
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.moneytransfer.utils.m.a(activity3);
            } else if (z2) {
                FragmentActivity activity4 = getActivity();
                if (!(activity4 == null || (supportFragmentManager = activity4.getSupportFragmentManager()) == null || (g2 = supportFragmentManager.g()) == null)) {
                    num = Integer.valueOf(g2.size());
                }
                if (num == null || num.intValue() <= 1) {
                    FragmentActivity activity5 = getActivity();
                    if (activity5 != null) {
                        activity5.finish();
                    }
                } else {
                    FragmentActivity activity6 = getActivity();
                    if (activity6 == null) {
                        kotlin.g.b.k.a();
                    }
                    net.one97.paytm.moneytransfer.utils.m.a(activity6);
                }
            } else {
                FragmentActivity activity7 = getActivity();
                if (activity7 != null) {
                    activity7.finish();
                }
            }
            net.one97.paytm.moneytransferv4.f.a aVar = this.aM;
            if (!(aVar == null || (context = aVar.f55408d) == null)) {
                aVar.b(androidx.core.content.b.c(context, R.color.color_ffffff));
            }
            if (this.aZ != null) {
                net.one97.paytm.n.d dVar = net.one97.paytm.n.d.f55759a;
                net.one97.paytm.n.d.a();
            }
            if (f()) {
                Context context2 = getContext();
                Bundle arguments = getArguments();
                if (arguments == null || (str = arguments.getString("vpa")) == null) {
                    str = "";
                }
                String str2 = str;
                CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
                if (customAmountTextInputEditText == null) {
                    kotlin.g.b.k.a("amountET");
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context2, Events.Category.INTENT, Events.Action.BACK_ARROW_CLICKED, "", "", "", str2, String.valueOf(customAmountTextInputEditText.getText()), Events.Screen.ENTER_AMOUNT, "");
                return;
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity");
    }

    public final void onClick(View view) {
        androidx.fragment.app.j supportFragmentManager;
        if (view != null && view.getId() == R.id.iv_back_button1) {
            d();
        } else if ((view != null && view.getId() == R.id.arrow_iv) || (view != null && view.getId() == R.id.selectedBankDownArrowTV)) {
            b(true);
            aB();
        } else if (view != null && view.getId() == R.id.rl_uni_selected_payment_inst) {
            com.paytm.utility.b.c((Activity) getActivity());
            TextView textView = this.aO;
            if (textView == null) {
                kotlin.g.b.k.a("addMessageTextView");
            }
            if (textView.isClickable()) {
                a(true);
            }
            b(true);
            aB();
        } else if (view != null && view.getId() == R.id.ll_uni_pay) {
            if (this.aR == null) {
                TextView textView2 = this.y;
                if (textView2 == null) {
                    kotlin.g.b.k.a("mProceedPayment");
                }
                String string = getString(R.string.pay);
                kotlin.g.b.k.a((Object) string, "getString(R.string.pay)");
                if (kotlin.m.p.a((CharSequence) textView2.getText().toString(), (CharSequence) string, true)) {
                    g();
                } else {
                    TextView textView3 = this.y;
                    if (textView3 == null) {
                        kotlin.g.b.k.a("mProceedPayment");
                    }
                    if (kotlin.m.p.a(textView3.getText().toString(), getString(R.string.upi_reactivate_account), true)) {
                        b(2012);
                    } else if (!net.one97.paytm.moneytransfer.utils.m.b((Context) getActivity())) {
                        if (UpiUtils.isInActiveProfileExist(getActivity())) {
                            startActivity(UpiUtils.getUpiLandingPageActivityIntent(getActivity()));
                        } else {
                            Intent intent = new Intent(getActivity(), UpiSelectBankActivity.class);
                            intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                            intent.setFlags(536870912);
                            startActivityForResult(intent, 352);
                        }
                        h(Events.Label.NOT_ONBOARDED);
                    } else {
                        e();
                        h(Events.Label.BANK_NOT_LINKED);
                    }
                }
            } else if (this.l != null) {
                g();
            }
            aC();
        } else if (view != null && view.getId() == R.id.card_view_button) {
            g();
            aC();
        } else if ((view != null && view.getId() == R.id.bankNameContainer) || (view != null && view.getId() == R.id.bankarrow)) {
            View view2 = this.aw;
            if (view2 == null) {
                kotlin.g.b.k.a("bankDetailsContainer");
            }
            String str = null;
            if (view2.getVisibility() == 0) {
                Bundle arguments = getArguments();
                String string2 = arguments != null ? arguments.getString("bankname") : null;
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str = arguments2.getString("vpa");
                }
                TextView textView4 = this.x;
                if (textView4 == null) {
                    kotlin.g.b.k.a("headerBankLogoName");
                }
                textView4.setText(net.one97.paytm.moneytransfer.utils.m.a(string2, str));
                View view3 = this.aw;
                if (view3 == null) {
                    kotlin.g.b.k.a("bankDetailsContainer");
                }
                view3.setVisibility(8);
                ImageView imageView = this.av;
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
            TextView textView5 = this.x;
            if (textView5 == null) {
                kotlin.g.b.k.a("headerBankLogoName");
            }
            textView5.setText(str);
            View view4 = this.aw;
            if (view4 == null) {
                kotlin.g.b.k.a("bankDetailsContainer");
            }
            view4.setVisibility(0);
            ImageView imageView2 = this.av;
            if (imageView2 == null) {
                kotlin.g.b.k.a("bankArrowTV");
            }
            net.one97.paytm.moneytransfer.utils.c.a(imageView2, 0);
        } else if ((view != null && view.getId() == R.id.ivVerificationLogo) || (view != null && view.getId() == R.id.tvbhimUpi)) {
            new net.one97.paytm.upi.profile.view.h().show(getChildFragmentManager(), "SignStatusInfoBS");
        } else if (view != null && view.getId() == R.id.check_balance_tv) {
            af();
        } else if (view != null && view.getId() == R.id.options) {
            UpiAppUtils.hideKeyboard(getActivity());
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                f.a aVar = net.one97.paytm.moneytransferv4.accountsbottomsheet.f.f55044a;
                f.a.a(getArguments()).show(supportFragmentManager, "");
            }
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
    public final boolean C() {
        /*
            r7 = this;
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aF
            if (r0 == 0) goto L_0x007b
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007b
            java.lang.Object r1 = r0.next()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
            java.lang.String r2 = "vpaItem"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getDebitBank()
            r3 = 0
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = r2.getIfsc()
            goto L_0x0027
        L_0x0026:
            r2 = r3
        L_0x0027:
            if (r2 == 0) goto L_0x0008
            java.lang.String r2 = r7.r
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = r1.getDebitBank()
            if (r4 == 0) goto L_0x0036
            java.lang.String r4 = r4.getIfsc()
            goto L_0x0037
        L_0x0036:
            r4 = r3
        L_0x0037:
            r5 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r5)
            if (r2 == 0) goto L_0x0008
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r1.getDebitBank()
            if (r2 == 0) goto L_0x0067
            java.lang.String r2 = r2.getAccount()
            if (r2 == 0) goto L_0x0067
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r4 = r7.Z
            if (r4 != 0) goto L_0x0053
            java.lang.String r6 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0053:
            if (r4 == 0) goto L_0x005f
            androidx.lifecycle.y<java.lang.String> r4 = r4.f55565e
            if (r4 == 0) goto L_0x005f
            java.lang.Object r3 = r4.getValue()
            java.lang.String r3 = (java.lang.String) r3
        L_0x005f:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
        L_0x0067:
            if (r3 != 0) goto L_0x006c
            kotlin.g.b.k.a()
        L_0x006c:
            boolean r2 = r3.booleanValue()
            if (r2 == 0) goto L_0x0008
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r1 = r1.getPaymentMode()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r2 = net.one97.paytm.upi.common.upi.UpiProfileDefaultBank.PAYMENT_MODE.UPI
            if (r1 != r2) goto L_0x0008
            return r5
        L_0x007b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.C():boolean");
    }

    /* JADX WARNING: type inference failed for: r4v12, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
        if (kotlin.m.p.a(r0 != null ? r0.getString(net.one97.paytm.upi.util.UpiConstants.EXTRA_KEY_MCC) : null, "0000", true) == false) goto L_0x00b4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D() {
        /*
            r16 = this;
            r1 = r16
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            java.lang.String r2 = "amountET"
            if (r0 != 0) goto L_0x000b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x000b:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = com.paytm.utility.b.Q((java.lang.String) r0)
            r1.aa = r0
            net.one97.paytm.upi.util.CommentsEditText r0 = r1.aP
            if (r0 != 0) goto L_0x0022
            java.lang.String r3 = "messageEditText"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0022:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.ab = r0
            android.widget.TextView r0 = r1.B
            java.lang.String r3 = "amountErrorTV"
            if (r0 != 0) goto L_0x0035
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0035:
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a
            int r4 = net.one97.paytm.moneytransfer.R.string.mt_amount_in_words_placeholder
            java.lang.String r4 = r1.getString(r4)
            java.lang.String r5 = "getString(R.string.mt_amount_in_words_placeholder)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r7 = r1.f55438a
            if (r7 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x004c:
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
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x0078
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0078:
            r0.setVisibility(r8)
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMaxAmountAllowed(r0)
            boolean r0 = r1.f55441d
            r4 = 0
            if (r0 != 0) goto L_0x00b4
            android.os.Bundle r0 = r16.getArguments()
            java.lang.String r7 = "extra_key_mcc"
            if (r0 == 0) goto L_0x0097
            java.lang.String r0 = r0.getString(r7)
            goto L_0x0098
        L_0x0097:
            r0 = r4
        L_0x0098:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00be
            android.os.Bundle r0 = r16.getArguments()
            if (r0 == 0) goto L_0x00ab
            java.lang.String r0 = r0.getString(r7)
            goto L_0x00ac
        L_0x00ab:
            r0 = r4
        L_0x00ac:
            java.lang.String r7 = "0000"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r7, (boolean) r5)
            if (r0 != 0) goto L_0x00be
        L_0x00b4:
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            double r9 = net.one97.paytm.upi.util.UpiUtils.getUPIP2MMaxAmountAllowed(r0)
        L_0x00be:
            android.os.Bundle r0 = r16.getArguments()
            if (r0 == 0) goto L_0x00cc
            java.lang.String r7 = "vpa"
            java.lang.String r0 = r0.getString(r7)
            goto L_0x00cd
        L_0x00cc:
            r0 = r4
        L_0x00cd:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = r1.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.WALLET
            if (r7 != r11) goto L_0x01f0
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = r1.l
            if (r0 == 0) goto L_0x088c
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r1.aR
            if (r0 == 0) goto L_0x00e0
            net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
            goto L_0x00e1
        L_0x00e0:
            r0 = r4
        L_0x00e1:
            if (r0 == 0) goto L_0x088c
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = r1.l
            if (r0 == 0) goto L_0x00f7
            java.lang.Integer r0 = r0.getMinLimit()
            if (r0 == 0) goto L_0x00f7
            int r0 = r0.intValue()
            double r6 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r6)
            goto L_0x00f8
        L_0x00f7:
            r0 = r4
        L_0x00f8:
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r6 = r1.l
            if (r6 == 0) goto L_0x010c
            java.lang.Integer r6 = r6.getMaxLimit()
            if (r6 == 0) goto L_0x010c
            int r6 = r6.intValue()
            double r6 = (double) r6
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            goto L_0x010d
        L_0x010c:
            r6 = r4
        L_0x010d:
            boolean r7 = r1.aV
            if (r7 == 0) goto L_0x0122
            net.one97.paytm.moneytransfer.d.c$a r6 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r6 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r6 = r6.y
            int r6 = net.one97.paytm.moneytransfer.d.c.b(r6)
            double r6 = (double) r6
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
        L_0x0122:
            if (r0 == 0) goto L_0x01e3
            if (r6 == 0) goto L_0x01e3
            java.lang.String r7 = r1.aa
            double r9 = r0.doubleValue()
            double r11 = r6.doubleValue()
            boolean r7 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (double) r9, (double) r11)
            if (r7 != 0) goto L_0x01e3
            android.widget.TextView r4 = r1.B
            if (r4 != 0) goto L_0x013d
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x013d:
            r4.setVisibility(r8)
            boolean r4 = r1.aV
            if (r4 == 0) goto L_0x016c
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x014b
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x014b:
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
            goto L_0x01aa
        L_0x016c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            double r9 = r0.doubleValue()
            java.lang.String r0 = com.paytm.utility.b.a((double) r9)
            r4.append(r0)
            int r0 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2
            java.lang.String r0 = r1.getString(r0)
            r4.append(r0)
            double r6 = r6.doubleValue()
            java.lang.String r0 = com.paytm.utility.b.a((double) r6)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.widget.TextView r4 = r1.B
            if (r4 != 0) goto L_0x019b
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x019b:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            java.lang.String r0 = r1.getString(r6, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x01aa:
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x01b1
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01b1:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x01ba
            kotlin.g.b.k.a()
        L_0x01ba:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x01ca
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01ca:
            r0.requestFocus()
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x01d4
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01d4:
            android.widget.EditText r0 = (android.widget.EditText) r0
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()
            android.app.Activity r2 = (android.app.Activity) r2
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r0, (android.app.Activity) r2)
            r16.E()
            return
        L_0x01e3:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d r0 = r1.k
            if (r0 == 0) goto L_0x01ea
            r0.a()
        L_0x01ea:
            net.one97.paytm.n.c r0 = r1.aZ
            r0.a((java.lang.String) r4, (java.lang.String) r4)
            return
        L_0x01f0:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = r1.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            java.lang.String r12 = "getString(R.string.money…nsfer_account_validation)"
            java.lang.String r13 = "Important"
            if (r7 != r11) goto L_0x0520
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.f55446i
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            if (r7 != r11) goto L_0x03ae
            boolean r6 = r16.ax()
            java.lang.String r7 = "moneyTransferv4ActivityViewModel"
            if (r6 == 0) goto L_0x020f
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r11 = r16.aA()
            goto L_0x0221
        L_0x020f:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r6 = r1.Z
            if (r6 != 0) goto L_0x0216
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0216:
            double r9 = r6.j
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r6 = r1.Z
            if (r6 != 0) goto L_0x021f
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x021f:
            double r11 = r6.k
        L_0x0221:
            boolean r6 = r1.aV
            if (r6 == 0) goto L_0x0232
            net.one97.paytm.moneytransfer.d.c$a r6 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r6 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r6 = r6.y
            int r6 = net.one97.paytm.moneytransfer.d.c.b(r6)
            double r11 = (double) r6
        L_0x0232:
            java.lang.String r6 = r1.aa
            boolean r6 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r6, (double) r9, (double) r11)
            if (r6 != 0) goto L_0x02eb
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x0241
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0241:
            r0.setVisibility(r8)
            boolean r0 = r1.aV
            if (r0 == 0) goto L_0x0270
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x024f
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x024f:
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
            goto L_0x02b2
        L_0x0270:
            java.lang.String r0 = com.paytm.utility.b.a((double) r9)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            int r0 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2
            java.lang.String r0 = r1.getString(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = com.paytm.utility.b.a((double) r11)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.widget.TextView r4 = r1.B
            if (r4 != 0) goto L_0x02a3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02a3:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            java.lang.String r0 = r1.getString(r6, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x02b2:
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x02b9
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02b9:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x02c2
            kotlin.g.b.k.a()
        L_0x02c2:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x02d2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x02d2:
            r0.requestFocus()
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x02dc
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x02dc:
            android.widget.EditText r0 = (android.widget.EditText) r0
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()
            android.app.Activity r2 = (android.app.Activity) r2
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r0, (android.app.Activity) r2)
            r16.E()
            return
        L_0x02eb:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0316
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r2 = r1.Z
            if (r2 != 0) goto L_0x02fb
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x02fb:
            androidx.lifecycle.y<java.lang.String> r2 = r2.f55565e
            if (r2 == 0) goto L_0x0306
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0307
        L_0x0306:
            r2 = r4
        L_0x0307:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 == 0) goto L_0x0316
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r0 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.CANNOT_TRANSFER_TO_SAME_ACC
            r1.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r0)
            r16.E()
            return
        L_0x0316:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r1.f55444g
            if (r0 == 0) goto L_0x0325
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0325
            java.lang.String r0 = r0.getAccountType()
            goto L_0x0326
        L_0x0325:
            r0 = r4
        L_0x0326:
            if (r0 != 0) goto L_0x032a
            goto L_0x03a9
        L_0x032a:
            int r2 = r0.hashCode()
            r3 = -1704036199(0xffffffff9a6e7899, float:-4.9314664E-23)
            if (r2 == r3) goto L_0x0377
            r3 = 1844922713(0x6df74959, float:9.5664337E27)
            if (r2 == r3) goto L_0x0339
            goto L_0x03a9
        L_0x0339:
            java.lang.String r2 = "CURRENT"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03a9
            java.lang.String r0 = r16.at()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03a9
            java.lang.String r0 = r1.aa
            if (r0 != 0) goto L_0x0354
            kotlin.g.b.k.a()
        L_0x0354:
            java.lang.String r2 = r16.at()
            boolean r0 = b((java.lang.String) r0, (java.lang.String) r2)
            if (r0 != 0) goto L_0x03a9
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_insufficient_ppb_bal
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r8)
            r0.show()
            r16.E()
            return
        L_0x0377:
            java.lang.String r2 = "SAVINGS"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03a9
            java.lang.String r0 = r1.aa
            if (r0 != 0) goto L_0x0386
            kotlin.g.b.k.a()
        L_0x0386:
            java.lang.String r2 = r16.G()
            boolean r0 = b((java.lang.String) r0, (java.lang.String) r2)
            if (r0 != 0) goto L_0x03a9
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_insufficient_ppb_bal
            java.lang.String r2 = r1.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r8)
            r0.show()
            r16.E()
            return
        L_0x03a9:
            r16.F()
            goto L_0x088c
        L_0x03ae:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.f55446i
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.VPA
            if (r7 != r11) goto L_0x088c
            boolean r7 = r16.ax()
            if (r7 == 0) goto L_0x03db
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r7 = r1.l
            if (r7 == 0) goto L_0x03c9
            net.one97.paytm.common.entity.p2p.SourcePayment r7 = r7.getSourcePayment()
            if (r7 == 0) goto L_0x03c9
            java.lang.String r7 = r7.getIfscCode()
            goto L_0x03ca
        L_0x03c9:
            r7 = r4
        L_0x03ca:
            java.lang.String r9 = "PYTM0123456"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x03d7
            double r9 = r16.aA()
            goto L_0x03db
        L_0x03d7:
            double r9 = r16.ay()
        L_0x03db:
            boolean r7 = r1.aV
            if (r7 == 0) goto L_0x03ec
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r7 = r7.y
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)
            double r9 = (double) r7
        L_0x03ec:
            java.lang.String r7 = r1.aa
            android.content.Context r11 = r16.getContext()
            double r14 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r11)
            boolean r7 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (double) r14, (double) r9)
            if (r7 != 0) goto L_0x0497
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x0403
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0403:
            r0.setVisibility(r8)
            boolean r0 = r1.aV
            if (r0 == 0) goto L_0x0432
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x0411
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0411:
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
            goto L_0x0470
        L_0x0432:
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
            android.widget.TextView r4 = r1.B
            if (r4 != 0) goto L_0x0461
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0461:
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            java.lang.String r0 = r1.getString(r6, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x0470:
            android.widget.TextView r0 = r1.B
            if (r0 != 0) goto L_0x0477
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0477:
            android.content.Context r3 = r16.getContext()
            if (r3 != 0) goto L_0x0480
            kotlin.g.b.k.a()
        L_0x0480:
            int r4 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a
            if (r0 != 0) goto L_0x0490
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0490:
            r0.requestFocus()
            r16.E()
            return
        L_0x0497:
            boolean r2 = r16.H()
            if (r2 == 0) goto L_0x04ec
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_account_validation
            java.lang.String r2 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r1.f55444g
            if (r3 == 0) goto L_0x04bf
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r3.getDebitBank()
            if (r3 == 0) goto L_0x04bf
            java.lang.String r4 = r3.getBankName()
        L_0x04bf:
            r7[r8] = r4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r1.X
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
            r16.E()
            return
        L_0x04ec:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x051b
            java.lang.String r2 = r1.J
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r8)
            if (r0 == 0) goto L_0x051b
            int r0 = net.one97.paytm.moneytransfer.R.string.you_cannot_transfer_money_to_same_account
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r2 = "getString(R.string.you_c…er_money_to_same_account)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.moneytransfer.R.string.error
            java.lang.String r3 = r1.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            r16.E()
            return
        L_0x051b:
            r16.F()
            goto L_0x088c
        L_0x0520:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r7 = r1.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r7 != r11) goto L_0x088c
            boolean r7 = r16.ax()
            if (r7 == 0) goto L_0x0530
            double r9 = r16.ay()
        L_0x0530:
            boolean r7 = r1.aV
            if (r7 == 0) goto L_0x0541
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r7 = r7.y
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)
            double r9 = (double) r7
        L_0x0541:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r7 = r1.f55446i     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r11 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.VPA     // Catch:{ Exception -> 0x0888 }
            if (r7 != r11) goto L_0x06cc
            java.lang.String r7 = r1.aa     // Catch:{ Exception -> 0x0888 }
            android.content.Context r11 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            double r14 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r11)     // Catch:{ Exception -> 0x0888 }
            boolean r7 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (double) r14, (double) r9)     // Catch:{ Exception -> 0x0888 }
            if (r7 != 0) goto L_0x0604
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x055e
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x055e:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0888 }
            boolean r0 = r1.aV     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x058d
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x056c
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x056c:
            int r6 = net.one97.paytm.moneytransfer.R.string.upi_gallery_scan_error     // Catch:{ Exception -> 0x0888 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.moneytransfer.d.c$a r7 = net.one97.paytm.moneytransfer.d.c.C     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.moneytransfer.d.c r7 = net.one97.paytm.moneytransfer.d.c.a.a()     // Catch:{ Exception -> 0x0888 }
            java.lang.String r7 = r7.y     // Catch:{ Exception -> 0x0888 }
            int r7 = net.one97.paytm.moneytransfer.d.c.b(r7)     // Catch:{ Exception -> 0x0888 }
            double r9 = (double) r7     // Catch:{ Exception -> 0x0888 }
            java.lang.String r7 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x0888 }
            r5[r8] = r7     // Catch:{ Exception -> 0x0888 }
            java.lang.String r5 = r1.getString(r6, r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0888 }
            r0.setText(r5)     // Catch:{ Exception -> 0x0888 }
            goto L_0x05cb
        L_0x058d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0888 }
            r0.<init>()     // Catch:{ Exception -> 0x0888 }
            android.content.Context r6 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            double r6 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r6 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r6 != 0) goto L_0x05bc
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x05bc:
            int r7 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x0888 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0888 }
            r5[r8] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.getString(r7, r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0888 }
            r6.setText(r0)     // Catch:{ Exception -> 0x0888 }
        L_0x05cb:
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x05d2
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x05d2:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            if (r3 != 0) goto L_0x05db
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x05db:
            int r5 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x0888 }
            int r3 = androidx.core.content.b.c(r3, r5)     // Catch:{ Exception -> 0x0888 }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x05eb
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
        L_0x05eb:
            r0.requestFocus()     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x05f5
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
        L_0x05f5:
            android.widget.EditText r0 = (android.widget.EditText) r0     // Catch:{ Exception -> 0x0888 }
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()     // Catch:{ Exception -> 0x0888 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r0, (android.app.Activity) r2)     // Catch:{ Exception -> 0x0888 }
            r16.E()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x0604:
            boolean r7 = r16.H()     // Catch:{ Exception -> 0x0888 }
            if (r7 == 0) goto L_0x065b
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()     // Catch:{ Exception -> 0x0888 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0888 }
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x0888 }
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_account_validation     // Catch:{ Exception -> 0x0888 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0888 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0888 }
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r1.f55444g     // Catch:{ Exception -> 0x0888 }
            if (r3 == 0) goto L_0x062d
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r3.getDebitBank()     // Catch:{ Exception -> 0x0888 }
            if (r3 == 0) goto L_0x062d
            java.lang.String r3 = r3.getBankName()     // Catch:{ Exception -> 0x0888 }
            goto L_0x062e
        L_0x062d:
            r3 = r4
        L_0x062e:
            r7[r8] = r3     // Catch:{ Exception -> 0x0888 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0888 }
            r3.<init>()     // Catch:{ Exception -> 0x0888 }
            int r9 = r1.X     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r9)     // Catch:{ Exception -> 0x0888 }
            r3.append(r9)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0888 }
            r7[r5] = r3     // Catch:{ Exception -> 0x0888 }
            r3 = 2
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r7, r3)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x0888 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.util.CustomDialog.showAlert(r0, r13, r2)     // Catch:{ Exception -> 0x0888 }
            r16.E()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x065b:
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0888 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0888 }
            if (r6 != 0) goto L_0x06cc
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0888 }
            boolean r6 = r1.b((java.lang.String) r6)     // Catch:{ Exception -> 0x0888 }
            if (r6 == 0) goto L_0x06cc
            int r2 = net.one97.paytm.moneytransfer.R.string.mt_transfer_to_same_vpa     // Catch:{ Exception -> 0x0888 }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0888 }
            r3[r8] = r0     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r1.f55444g     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x0684
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x0684
            java.lang.String r0 = r0.getBankName()     // Catch:{ Exception -> 0x0888 }
            goto L_0x0685
        L_0x0684:
            r0 = r4
        L_0x0685:
            r3[r5] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.J     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x06ac
            java.lang.String r5 = r1.J     // Catch:{ Exception -> 0x0888 }
            if (r5 != 0) goto L_0x0692
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x0692:
            int r5 = r5.length()     // Catch:{ Exception -> 0x0888 }
            int r5 = r5 + -4
            if (r0 == 0) goto L_0x06a4
            java.lang.String r0 = r0.substring(r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r5 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0888 }
            goto L_0x06ad
        L_0x06a4:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0888 }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0888 }
            throw r0     // Catch:{ Exception -> 0x0888 }
        L_0x06ac:
            r0 = r4
        L_0x06ad:
            r5 = 2
            r3[r5] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.getString(r2, r3)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r2 = "getString(\n             …                        )"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()     // Catch:{ Exception -> 0x0888 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x0888 }
            int r3 = net.one97.paytm.moneytransfer.R.string.error     // Catch:{ Exception -> 0x0888 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x0888 }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x0888 }
            r16.E()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x06cc:
            boolean r0 = r1.f55440c     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x0762
            java.lang.String r0 = r1.ac     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x0762
            java.lang.String r0 = r1.ad     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x0762
            java.lang.String r0 = r1.ad     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x06e7
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x06e7:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.ac     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x06f2
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x06f2:
            double r11 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r11, (double) r6)     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0762
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0705
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x0705:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0888 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0888 }
            r0.<init>()     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = com.paytm.utility.b.a((double) r11)     // Catch:{ Exception -> 0x0888 }
            r0.append(r9)     // Catch:{ Exception -> 0x0888 }
            int r9 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x0888 }
            r0.append(r9)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r6 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r6 != 0) goto L_0x072f
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x072f:
            int r7 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x0888 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0888 }
            r5[r8] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.getString(r7, r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0888 }
            r6.setText(r0)     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0745
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x0745:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            if (r3 != 0) goto L_0x074e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x074e:
            int r5 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x0888 }
            int r3 = androidx.core.content.b.c(r3, r5)     // Catch:{ Exception -> 0x0888 }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x075e
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
        L_0x075e:
            r0.requestFocus()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x0762:
            boolean r0 = r1.f55440c     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x07ed
            java.lang.String r0 = r1.ac     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x07ed
            java.lang.String r0 = r1.ad     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x07ed
            java.lang.String r0 = r1.ac     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x077d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x077d:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r6, (double) r9)     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x07ed
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0790
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x0790:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0888 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0888 }
            r0.<init>()     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            int r6 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r6 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r6 != 0) goto L_0x07ba
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x07ba:
            int r7 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x0888 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0888 }
            r5[r8] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.getString(r7, r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0888 }
            r6.setText(r0)     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x07d0
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x07d0:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            if (r3 != 0) goto L_0x07d9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x07d9:
            int r5 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x0888 }
            int r3 = androidx.core.content.b.c(r3, r5)     // Catch:{ Exception -> 0x0888 }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x07e9
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
        L_0x07e9:
            r0.requestFocus()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x07ed:
            boolean r0 = r1.f55440c     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x088c
            java.lang.String r0 = r1.ac     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x088c
            java.lang.String r0 = r1.ad     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.isValidAmount(r0)     // Catch:{ Exception -> 0x0888 }
            if (r0 == 0) goto L_0x088c
            java.lang.String r0 = r1.ad     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0808
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x0808:
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.aa     // Catch:{ Exception -> 0x0888 }
            android.content.Context r9 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r9)     // Catch:{ Exception -> 0x0888 }
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r0, (double) r9, (double) r6)     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x088c
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0823
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x0823:
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0888 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0888 }
            r0.<init>()     // Catch:{ Exception -> 0x0888 }
            android.content.Context r9 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            double r9 = net.one97.paytm.upi.util.UpiUtils.getMinAmountAllowed(r9)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = com.paytm.utility.b.a((double) r9)     // Catch:{ Exception -> 0x0888 }
            r0.append(r9)     // Catch:{ Exception -> 0x0888 }
            int r9 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_2     // Catch:{ Exception -> 0x0888 }
            java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x0888 }
            r0.append(r9)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)     // Catch:{ Exception -> 0x0888 }
            r0.append(r6)     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r6 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r6 != 0) goto L_0x0855
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x0855:
            int r7 = net.one97.paytm.moneytransfer.R.string.wallet_p2b_amount_error_part_1     // Catch:{ Exception -> 0x0888 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0888 }
            r5[r8] = r0     // Catch:{ Exception -> 0x0888 }
            java.lang.String r0 = r1.getString(r7, r5)     // Catch:{ Exception -> 0x0888 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0888 }
            r6.setText(r0)     // Catch:{ Exception -> 0x0888 }
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x086b
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0888 }
        L_0x086b:
            android.content.Context r3 = r16.getContext()     // Catch:{ Exception -> 0x0888 }
            if (r3 != 0) goto L_0x0874
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0888 }
        L_0x0874:
            int r5 = net.one97.paytm.moneytransfer.R.color.error_separator_view_color     // Catch:{ Exception -> 0x0888 }
            int r3 = androidx.core.content.b.c(r3, r5)     // Catch:{ Exception -> 0x0888 }
            r0.setTextColor(r3)     // Catch:{ Exception -> 0x0888 }
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r1.f55438a     // Catch:{ Exception -> 0x0888 }
            if (r0 != 0) goto L_0x0884
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0888 }
        L_0x0884:
            r0.requestFocus()     // Catch:{ Exception -> 0x0888 }
            return
        L_0x0888:
            r0 = move-exception
            r0.printStackTrace()
        L_0x088c:
            boolean r0 = r1.f55441d
            if (r0 == 0) goto L_0x08d3
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.upi.util.UpiUtils.doShowSecurityPopUp(r0)
            if (r0 == 0) goto L_0x08d3
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            if (r0 == 0) goto L_0x08b2
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x08b2
            java.lang.String r2 = "isVerifiedMerchant"
            boolean r0 = r0.getBooleanExtra(r2, r8)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
        L_0x08b2:
            if (r4 == 0) goto L_0x08ba
            boolean r0 = r4.booleanValue()
            if (r0 != 0) goto L_0x08d3
        L_0x08ba:
            net.one97.paytm.moneytransfer.view.b.a r0 = new net.one97.paytm.moneytransfer.view.b.a
            r0.<init>()
            net.one97.paytm.moneytransferv4.home.presentation.a.b$ak r2 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$ak
            r2.<init>(r1)
            net.one97.paytm.moneytransfer.view.b.a$d r2 = (net.one97.paytm.moneytransfer.view.b.a.d) r2
            r0.a((net.one97.paytm.moneytransfer.view.b.a.d) r2)
            androidx.fragment.app.j r2 = r16.getChildFragmentManager()
            java.lang.String r3 = ""
            r0.show((androidx.fragment.app.j) r2, (java.lang.String) r3)
            return
        L_0x08d3:
            r16.J()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.D():void");
    }

    public static final class ak implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55461a;

        ak(b bVar) {
            this.f55461a = bVar;
        }

        public final void onDismiss() {
            this.f55461a.J();
        }
    }

    private final void E() {
        try {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar = this.aH;
            if (aVar != null) {
                aVar.dismissAllowingStateLoss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void F() {
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        String str = null;
        String cleanString = UpiAppUtils.getCleanString(String.valueOf(customAmountTextInputEditText != null ? customAmountTextInputEditText.getText() : null));
        if (ax()) {
            PaymentOptionItem paymentOptionItem = this.l;
            if (paymentOptionItem != null) {
                str = paymentOptionItem.getCombinationName();
            }
            if (kotlin.g.b.k.a((Object) "UPI-BANK", (Object) str)) {
                if (cleanString == null) {
                    kotlin.g.b.k.a();
                }
                if (Double.parseDouble(cleanString) <= ay()) {
                    this.f55446i = MoneyTransferV3Activity.d.VPA;
                } else {
                    this.f55446i = MoneyTransferV3Activity.d.SAVINGS_ACCOUNT;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String G() {
        /*
            r2 = this;
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55566f
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r0 = ""
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.G():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        r5 = r5.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aF
            if (r0 == 0) goto L_0x0071
            java.util.List<? extends net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r0 = r7.aG
            if (r0 != 0) goto L_0x000b
            kotlin.g.b.k.a()
        L_0x000b:
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0071
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
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = r7.f55444g
            r6 = 0
            if (r5 == 0) goto L_0x004a
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
            if (r5 == 0) goto L_0x004a
            java.lang.String r5 = r5.getAccount()
            goto L_0x004b
        L_0x004a:
            r5 = r6
        L_0x004b:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r3)
            if (r2 == 0) goto L_0x000f
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getCreditBank()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r1 = r1.getIfsc()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r7.f55444g
            if (r2 == 0) goto L_0x006a
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x006a
            java.lang.String r6 = r2.getIfsc()
        L_0x006a:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)
            if (r1 == 0) goto L_0x000f
            return r3
        L_0x0071:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.b(java.lang.String):boolean");
    }

    private static boolean b(String str, String str2) {
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
    private final boolean H() {
        /*
            r7 = this;
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r7.f55444g
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
            r7.X = r0
            int r0 = r7.X
            if (r0 > 0) goto L_0x0024
            return r1
        L_0x0024:
            java.lang.String r2 = r7.aa
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = (double) r0
            boolean r0 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r2, (double) r3, (double) r5)
            if (r0 != 0) goto L_0x0031
            r0 = 1
            return r0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.H():boolean");
    }

    private void b(int i2) {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, i2);
    }

    public final void e() {
        AccountProviderActivity.a((Fragment) this, 31);
    }

    /* access modifiers changed from: private */
    public final void I() {
        Dialog dialog;
        Dialog dialog2 = this.I;
        if (dialog2 != null) {
            if (dialog2 == null) {
                kotlin.g.b.k.a();
            }
            if (dialog2.isShowing() && (dialog = this.I) != null) {
                dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void J() {
        String str;
        Bundle arguments;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        this.aa = com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText.getText()));
        CommentsEditText commentsEditText = this.aP;
        if (commentsEditText == null) {
            kotlin.g.b.k.a("messageEditText");
        }
        this.ab = String.valueOf(commentsEditText.getText());
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("username") : null;
        if (!com.paytm.utility.a.m(getActivity())) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof MoneyTransferV4Activity)) {
                activity = null;
            }
            MoneyTransferV4Activity moneyTransferV4Activity = (MoneyTransferV4Activity) activity;
            if (moneyTransferV4Activity != null) {
                moneyTransferV4Activity.a(getString(R.string.no_connection), getResources().getString(R.string.no_internet), getString(R.string.ok));
                return;
            }
            return;
        }
        if (this.f55446i == MoneyTransferV3Activity.d.VPA) {
            if (O()) {
                N();
                if (this.f55441d) {
                    this.f55439b = MoneyTransferV3Activity.a.VPA;
                    this.F = UpiConstants.MoneyTransferPaymentOption.UPI;
                    CharSequence charSequence = string;
                    if ((charSequence == null || kotlin.m.p.a(charSequence)) && (arguments = getArguments()) != null) {
                        arguments.putString("username", "NA");
                    }
                }
                K();
                str = "upi";
            } else {
                return;
            }
        } else if (this.f55446i == MoneyTransferV3Activity.d.SAVINGS_ACCOUNT) {
            I();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            if (!b2.c(activity2)) {
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
                if (cVar != null) {
                    cVar.b();
                }
            } else {
                T();
            }
            str = "paytm_bank";
        } else {
            str = "";
        }
        c(str);
    }

    private final void K() {
        c.a aVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        UPIBankHealthResponseModel uPIBankHealthResponseModel = null;
        if (cVar != null) {
            aVar = cVar.f55605f;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            uPIBankHealthResponseModel = aVar.f55610b;
        }
        if (uPIBankHealthResponseModel != null) {
            a(aVar);
        } else {
            ac();
        }
    }

    private final void c(String str) {
        if (this.aI == MoneyTransferV3Activity.c.NEW_ACCOUNT.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "new_account_entered");
        } else if (this.aI == MoneyTransferV3Activity.c.BENEFICIARY_LIST.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "saved_account");
        } else if (this.aI == MoneyTransferV3Activity.c.PHONEBOOK.ordinal()) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_to_pay_clicked", "/money-transfer/payment", str, "phonebook");
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11;
        androidx.lifecycle.y<String> yVar;
        String str12 = str5;
        net.one97.paytm.moneytransfer.utils.k kVar = new net.one97.paytm.moneytransfer.utils.k((Fragment) this, (net.one97.paytm.common.a) this, aE());
        kVar.b();
        if (str12 != null) {
            str9 = kotlin.m.p.a(str12, "\\n", "", false);
        } else {
            str9 = null;
        }
        if (str9 != null) {
            str10 = kotlin.m.p.a(str9, "\\r", "", false);
        } else {
            str10 = null;
        }
        if (V()) {
            kVar.a();
        }
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
        if (aVar == null) {
            kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
        }
        if (aVar == null || (yVar = aVar.f55565e) == null) {
            str11 = null;
        } else {
            str11 = yVar.getValue();
        }
        kVar.a(str, str2, str3, str4, str10, str6, str7, str8, str11);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            super.onActivityResult(r5, r6, r7)
            r0 = 0
            r1 = -1
            r2 = 3333(0xd05, float:4.67E-42)
            if (r5 != r2) goto L_0x0033
            if (r6 != r1) goto L_0x0025
            if (r7 == 0) goto L_0x0013
            java.lang.String r5 = "imps_data"
            java.io.Serializable r0 = r7.getSerializableExtra(r5)
        L_0x0013:
            if (r0 == 0) goto L_0x001d
            net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel r0 = (net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel) r0
            net.one97.paytm.upi.common.UpiBaseDataModel r0 = (net.one97.paytm.upi.common.UpiBaseDataModel) r0
            r4.b((net.one97.paytm.upi.common.UpiBaseDataModel) r0)
            return
        L_0x001d:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel"
            r5.<init>(r6)
            throw r5
        L_0x0025:
            boolean r5 = r4.P
            if (r5 == 0) goto L_0x0032
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x0032
            r5.finish()
        L_0x0032:
            return
        L_0x0033:
            r2 = 2020(0x7e4, float:2.83E-42)
            if (r5 != r2) goto L_0x0065
            if (r6 != 0) goto L_0x0047
            boolean r5 = r4.P
            if (r5 == 0) goto L_0x0194
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x0046
            r5.finish()
        L_0x0046:
            return
        L_0x0047:
            if (r6 != r1) goto L_0x0064
            if (r7 == 0) goto L_0x0064
            java.lang.String r5 = "verifier_imps_data"
            boolean r6 = r7.hasExtra(r5)
            if (r6 == 0) goto L_0x0064
            java.io.Serializable r5 = r7.getSerializableExtra(r5)
            boolean r6 = r5 instanceof net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel
            if (r6 != 0) goto L_0x005d
            r5 = r0
        L_0x005d:
            net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel r5 = (net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel) r5
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = (net.one97.paytm.upi.common.UpiBaseDataModel) r5
            r4.b((net.one97.paytm.upi.common.UpiBaseDataModel) r5)
        L_0x0064:
            return
        L_0x0065:
            r2 = 4444(0x115c, float:6.227E-42)
            if (r5 != r2) goto L_0x0083
            r5 = r4
            net.one97.paytm.moneytransferv4.home.presentation.a.b r5 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) r5
            if (r6 != r1) goto L_0x0072
            r5.J()
            return
        L_0x0072:
            boolean r6 = r5.P
            if (r6 == 0) goto L_0x0082
            androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
            if (r5 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            r5.finish()
        L_0x0082:
            return
        L_0x0083:
            r2 = 2011(0x7db, float:2.818E-42)
            if (r5 != r2) goto L_0x00a7
            if (r6 != r1) goto L_0x008d
            r4.J()
            return
        L_0x008d:
            boolean r5 = r4.P
            if (r5 != 0) goto L_0x009d
            boolean r5 = r4.R
            if (r5 != 0) goto L_0x009d
            boolean r5 = r4.S
            if (r5 != 0) goto L_0x009d
            boolean r5 = r4.T
            if (r5 == 0) goto L_0x00a6
        L_0x009d:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x00a6
            r5.finish()
        L_0x00a6:
            return
        L_0x00a7:
            r2 = 2012(0x7dc, float:2.82E-42)
            if (r5 != r2) goto L_0x00cb
            if (r6 != r1) goto L_0x00b1
            r4.k()
            return
        L_0x00b1:
            boolean r5 = r4.P
            if (r5 != 0) goto L_0x00c1
            boolean r5 = r4.R
            if (r5 != 0) goto L_0x00c1
            boolean r5 = r4.S
            if (r5 != 0) goto L_0x00c1
            boolean r5 = r4.T
            if (r5 == 0) goto L_0x00ca
        L_0x00c1:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x00ca
            r5.finish()
        L_0x00ca:
            return
        L_0x00cb:
            r2 = 31
            r3 = 34
            if (r5 != r2) goto L_0x0101
            if (r6 != r1) goto L_0x0101
            if (r7 == 0) goto L_0x00dc
            java.lang.String r5 = "account_provider"
            java.io.Serializable r5 = r7.getSerializableExtra(r5)
            goto L_0x00dd
        L_0x00dc:
            r5 = r0
        L_0x00dd:
            if (r5 == 0) goto L_0x00f9
            net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProvider r5 = (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r5
            r6 = r4
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r7 = r4.f55443f
            if (r7 == 0) goto L_0x00f5
            androidx.lifecycle.y r7 = r7.e()
            if (r7 == 0) goto L_0x00f5
            java.lang.Object r7 = r7.getValue()
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x00f5:
            net.one97.paytm.upi.profile.view.BankVpaCreationActivity.a((androidx.fragment.app.Fragment) r6, (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r5, (java.lang.String) r0, (int) r3)
            return
        L_0x00f9:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider"
            r5.<init>(r6)
            throw r5
        L_0x0101:
            if (r5 != r3) goto L_0x0109
            if (r6 != r1) goto L_0x0109
            r4.k()
            return
        L_0x0109:
            r7 = 2013(0x7dd, float:2.821E-42)
            if (r5 != r7) goto L_0x0140
            if (r6 != r1) goto L_0x0136
            android.net.Uri r5 = r4.H
            if (r5 == 0) goto L_0x011b
            java.lang.String r6 = "pa"
            java.lang.String r5 = r5.getQueryParameter(r6)
            if (r5 != 0) goto L_0x011d
        L_0x011b:
            java.lang.String r5 = ""
        L_0x011d:
            java.lang.String r6 = "uri?.getQueryParameter(\"pa\") ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r6 = r4.Z
            if (r6 != 0) goto L_0x012c
            java.lang.String r7 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x012c:
            android.net.Uri r7 = r4.H
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.a((java.lang.String) r5, (java.lang.String) r7)
            return
        L_0x0136:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x013f
            r5.finish()
        L_0x013f:
            return
        L_0x0140:
            r7 = 10
            if (r5 != r7) goto L_0x0164
            if (r6 != r1) goto L_0x014a
            r4.J()
            return
        L_0x014a:
            boolean r5 = r4.P
            if (r5 != 0) goto L_0x015a
            boolean r5 = r4.R
            if (r5 != 0) goto L_0x015a
            boolean r5 = r4.S
            if (r5 != 0) goto L_0x015a
            boolean r5 = r4.T
            if (r5 == 0) goto L_0x0163
        L_0x015a:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x0163
            r5.finish()
        L_0x0163:
            return
        L_0x0164:
            r7 = 352(0x160, float:4.93E-43)
            if (r5 != r7) goto L_0x016e
            if (r6 != r1) goto L_0x0194
            r4.k()
            return
        L_0x016e:
            int r7 = r4.p
            if (r5 != r7) goto L_0x0178
            if (r6 != r1) goto L_0x0178
            r4.af()
            return
        L_0x0178:
            int r7 = r4.q
            if (r5 != r7) goto L_0x018a
            if (r6 != r1) goto L_0x018a
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            boolean r5 = r5 instanceof net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity
            if (r5 == 0) goto L_0x0194
            r4.ai()
            return
        L_0x018a:
            r7 = 36865(0x9001, float:5.1659E-41)
            if (r5 != r7) goto L_0x0194
            net.one97.paytm.n.c r7 = r4.aZ
            r7.a((int) r5, (int) r6)
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.onActivityResult(int, int, android.content.Intent):void");
    }

    public final boolean f() {
        return this.f55440c && !this.M;
    }

    private final void a(Bundle bundle) {
        net.one97.paytm.upi.deeplink.b bVar = new net.one97.paytm.upi.deeplink.b();
        bVar.f66689d = bundle;
        bVar.f66688c = true;
        bVar.f66687b = this.H;
        bVar.show(getChildFragmentManager(), bVar.f66686a);
        a(false);
    }

    private void b(UpiBaseDataModel upiBaseDataModel) {
        FragmentActivity activity;
        androidx.lifecycle.y<PPBCurrentAccountModel> yVar;
        Intent intent;
        androidx.lifecycle.y<String> yVar2;
        if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            Intent intent2 = new Intent(getActivity(), MoneyTransferPostTransactionActivity.class);
            intent2.putExtra("key_bundle", upiBaseDataModel);
            Bundle arguments = getArguments();
            String str = null;
            intent2.putExtra(LocaleDBContract.BaseTable.KEY, arguments != null ? arguments.getString("username") : null);
            intent2.putExtra("key_amount", UpiUtils.convertToTwoPlaces(this.aa));
            intent2.putExtra("key_comment", this.ab);
            Bundle arguments2 = getArguments();
            intent2.putExtra("key_bank_name", arguments2 != null ? arguments2.getString("bankname") : null);
            intent2.putExtra("key_account_no_vpa_adhaar", this.f55439b);
            intent2.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, this.P);
            Bundle arguments3 = getArguments();
            intent2.putExtra("key_account_number", arguments3 != null ? arguments3.getString("vpa") : null);
            intent2.putExtra("is_from_chat_flow", this.W);
            Bundle arguments4 = getArguments();
            intent2.putExtra("key_ppb_account_number", arguments4 != null ? arguments4.getString("vpa") : null);
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
            if (aVar == null) {
                kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
            }
            intent2.putExtra("key_payer_ppb_account_number", (aVar == null || (yVar2 = aVar.f55565e) == null) ? null : yVar2.getValue());
            intent2.putExtra("is_deeplink", this.f55440c);
            Bundle arguments5 = getArguments();
            intent2.putExtra("ref_id", arguments5 != null ? arguments5.getString(UpiConstants.EXTRA_KEY_REF_ID) : null);
            intent2.putExtra("ifsc", Q());
            intent2.putExtra("key_account_number_selected", R());
            intent2.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, this.f55441d);
            Bundle arguments6 = getArguments();
            intent2.putExtra("picture", arguments6 != null ? arguments6.getString("picture") : null);
            intent2.putExtra("uni_p2p_landing_intent_extra_theme", this.aJ);
            String L2 = L();
            if (L2 == null) {
                L2 = "";
            }
            intent2.putExtra(UpiConstants.EXTRA_PAYER_NAME, L2);
            if (this.V || this.W) {
                intent2.addFlags(33554432);
            }
            intent2.putExtra("from_app_evoke", this.V);
            FragmentActivity activity2 = getActivity();
            intent2.putExtra("split_bill_data", (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getSerializableExtra("split_bill_data"));
            intent2.putExtra(UpiConstants.KEY_INTENT_PARAMS, aE());
            if (V()) {
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = this.Z;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                }
                intent2.putExtra("ppb_ica", (aVar2 == null || (yVar = aVar2.p) == null) ? null : yVar.getValue());
            }
            startActivity(intent2);
            if (this.Q && kotlin.m.p.a("SUCCESS", ((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel).getmStatus(), true) && !TextUtils.isEmpty(this.aj)) {
                if (TextUtils.isEmpty(this.ak) || !kotlin.g.b.k.a((Object) "QR_CODE", (Object) this.ak)) {
                    d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity3, "activity!!");
                    Context context = activity3;
                    Bundle arguments7 = getArguments();
                    if (arguments7 != null) {
                        str = arguments7.getString("username");
                    }
                    String str2 = str;
                    if (str2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) str2, "arguments?.getString(BundleConstants.USERNAME)!!");
                    String str3 = this.aj;
                    if (str3 == null) {
                        kotlin.g.b.k.a();
                    }
                    System.currentTimeMillis();
                    String str4 = this.aa;
                    if (str4 == null) {
                        kotlin.g.b.k.a();
                    }
                    b2.a(context, str2, str3, str4, false);
                } else {
                    d.a aVar4 = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    FragmentActivity activity4 = getActivity();
                    if (activity4 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity4, "activity!!");
                    Context context2 = activity4;
                    Bundle arguments8 = getArguments();
                    if (arguments8 != null) {
                        str = arguments8.getString("username");
                    }
                    String str5 = str;
                    if (str5 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) str5, "arguments?.getString(BundleConstants.USERNAME)!!");
                    String str6 = this.aj;
                    if (str6 == null) {
                        kotlin.g.b.k.a();
                    }
                    System.currentTimeMillis();
                    String str7 = this.aa;
                    if (str7 == null) {
                        kotlin.g.b.k.a();
                    }
                    b3.a(context2, str5, str6, str7, true);
                }
            }
            aa();
            if (!this.V && !this.W && (activity = getActivity()) != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity5 = getActivity();
            if (activity5 != null) {
                activity5.finish();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getSenderInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String L() {
        /*
            r2 = this;
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r2.aR
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.common.entity.p2p.SenderInfo r0 = r0.getSenderInfo()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getName()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0029
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r2.aR
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.common.entity.p2p.SenderInfo r0 = r0.getSenderInfo()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.getName()
            return r0
        L_0x0028:
            return r1
        L_0x0029:
            android.content.Context r0 = r2.getContext()
            java.lang.String r0 = com.paytm.utility.b.j((android.content.Context) r0)
            java.lang.String r0 = net.one97.paytm.upi.f.a((java.lang.String) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.L():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r2 == null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void M() {
        /*
            r10 = this;
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            java.lang.String r1 = "@"
            android.os.Bundle r2 = r10.getArguments()     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = "vpa"
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x007a }
            if (r2 != 0) goto L_0x0015
        L_0x0013:
            java.lang.String r2 = ""
        L_0x0015:
            java.lang.String r4 = "arguments?.getString(Bun…_OR_ACCOUNT_NUMBER) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x007a }
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x007a }
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x007a }
            r6 = 0
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6)     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x007e
            android.os.Bundle r4 = r10.getArguments()     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x0079
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x007a }
            r7 = 6
            int r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String) r1, (int) r6, (boolean) r6, (int) r7)     // Catch:{ Exception -> 0x007a }
            int r5 = r5 + 1
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            if (r2 == 0) goto L_0x0073
            java.lang.String r5 = r2.substring(r5)     // Catch:{ Exception -> 0x007a }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x007a }
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x007a }
            int r1 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r1, (int) r6, (boolean) r6, (int) r7)     // Catch:{ Exception -> 0x007a }
            int r1 = r1 + 1
            if (r2 == 0) goto L_0x006d
            java.lang.String r1 = r2.substring(r1)     // Catch:{ Exception -> 0x007a }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x007a }
            if (r1 == 0) goto L_0x0067
            java.lang.String r0 = r1.toLowerCase()     // Catch:{ Exception -> 0x007a }
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x007a }
            java.lang.String r0 = kotlin.m.p.a(r2, r5, r0, r6)     // Catch:{ Exception -> 0x007a }
            r4.putString(r3, r0)     // Catch:{ Exception -> 0x007a }
            return
        L_0x0067:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x007a }
            r0.<init>(r8)     // Catch:{ Exception -> 0x007a }
            throw r0     // Catch:{ Exception -> 0x007a }
        L_0x006d:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x007a }
            r0.<init>(r8)     // Catch:{ Exception -> 0x007a }
            throw r0     // Catch:{ Exception -> 0x007a }
        L_0x0073:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x007a }
            r0.<init>(r8)     // Catch:{ Exception -> 0x007a }
            throw r0     // Catch:{ Exception -> 0x007a }
        L_0x0079:
            return
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.M():void");
    }

    private final void N() {
        if (TextUtils.isEmpty(this.ab)) {
            this.ab = "NA";
        }
        this.aa = UpiUtils.convertToTwoPlaces(this.aa);
        if (TextUtils.isEmpty(this.af)) {
            this.ag = UpiUtils.getUpiSequenceNo();
        } else {
            this.ag = this.af;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = r0.f54032a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
            boolean r0 = r8.M
            if (r0 == 0) goto L_0x005c
            android.widget.TextView r0 = r8.t
            if (r0 != 0) goto L_0x000d
            java.lang.String r1 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000d:
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005c
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r8.Z
            if (r0 != 0) goto L_0x0026
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0026:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$b>> r0 = r0.o
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
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r1 = net.one97.paytm.moneytransfer.R.string.upi_qr_vpa_verify_fetch_message
            r2 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            goto L_0x006d
        L_0x005c:
            boolean r0 = r8.U
            if (r0 == 0) goto L_0x006a
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r0 = r8.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r0 != r1) goto L_0x006a
            r8.S()
            goto L_0x006d
        L_0x006a:
            r8.D()
        L_0x006d:
            android.content.Context r2 = r8.getContext()
            java.lang.String r3 = "mt_p2p_new_v1"
            java.lang.String r4 = "pay_total_clicked"
            java.lang.String r5 = "/mt_p2p_enter_amt_screen"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.g():void");
    }

    private final boolean O() {
        if (Build.VERSION.SDK_INT >= 23 && !P()) {
            return false;
        }
        if (UpiUtils.isSimAvailable(getActivity())) {
            return true;
        }
        b((int) CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        return false;
    }

    private final boolean P() {
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
                if (!(activity instanceof MoneyTransferV4Activity)) {
                    activity = null;
                }
                MoneyTransferV4Activity moneyTransferV4Activity = (MoneyTransferV4Activity) activity;
                if (moneyTransferV4Activity != null) {
                    moneyTransferV4Activity.a(getString(R.string.upi_mandatory_permission_denied), getString(R.string.upi_read_phone_state_permission_text_new), getString(R.string.upi_grant_permission));
                }
            } else {
                J();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        b(upiBaseDataModel);
    }

    private final String Q() {
        if (this.f55439b == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return arguments.getString("ifsc");
            }
            return null;
        } else if (this.f55439b == MoneyTransferV3Activity.a.VPA) {
            return "UPI";
        } else {
            return null;
        }
    }

    private final String R() {
        if (this.f55439b == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
            return getString(R.string.upi_acc_no_prefix);
        }
        if (this.f55439b == MoneyTransferV3Activity.a.VPA) {
            return getString(R.string.money_transfer_upi_string);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r0 = r4.Z()
            if (r0 == 0) goto L_0x007b
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
            if (r1 == 0) goto L_0x002e
            int r3 = net.one97.paytm.moneytransfer.R.layout.mt_custom_alert_dialog
            android.view.View r1 = r1.inflate(r3, r2)
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            r0.a((android.view.View) r1)
            if (r1 == 0) goto L_0x003d
            int r3 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_title
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x003e
        L_0x003d:
            r3 = r2
        L_0x003e:
            if (r3 == 0) goto L_0x0045
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x0045:
            if (r1 == 0) goto L_0x0050
            int r5 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_message
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x0051
        L_0x0050:
            r5 = r2
        L_0x0051:
            if (r5 == 0) goto L_0x0058
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x0058:
            androidx.appcompat.app.c r5 = r0.a()
            java.lang.String r6 = "dialogBuilder.create()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r1 == 0) goto L_0x006c
            int r6 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_btn_positive
            android.view.View r6 = r1.findViewById(r6)
            r2 = r6
            android.widget.Button r2 = (android.widget.Button) r2
        L_0x006c:
            if (r2 == 0) goto L_0x0078
            net.one97.paytm.moneytransferv4.home.presentation.a.b$ac r6 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$ac
            r6.<init>(r4, r5)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
        L_0x0078:
            r5.show()
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.c(java.lang.String, java.lang.String):void");
    }

    static final class ac implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55449a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f55450b;

        ac(b bVar, androidx.appcompat.app.c cVar) {
            this.f55449a = bVar;
            this.f55450b = cVar;
        }

        public final void onClick(View view) {
            this.f55450b.dismiss();
            FragmentActivity activity = this.f55449a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void S() {
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
        ((TextView) inflate.findViewById(R.id.recent_confirm_btn)).setOnClickListener(new ah(this, a2));
        ((TextView) inflate.findViewById(R.id.recent_cancel_btn)).setOnClickListener(new ai(a2));
        a2.show();
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55457a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f55458b;

        ah(b bVar, androidx.appcompat.app.c cVar) {
            this.f55457a = bVar;
            this.f55458b = cVar;
        }

        public final void onClick(View view) {
            this.f55458b.dismiss();
            this.f55457a.D();
        }
    }

    static final class ai implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f55459a;

        ai(androidx.appcompat.app.c cVar) {
            this.f55459a = cVar;
        }

        public final void onClick(View view) {
            this.f55459a.dismiss();
        }
    }

    private final void T() {
        if (V()) {
            X();
        } else if (U()) {
            W();
        } else {
            h();
        }
    }

    private final boolean U() {
        Double d2 = null;
        if (ax()) {
            String str = this.aa;
            if (str != null) {
                d2 = Double.valueOf(Double.parseDouble(str));
            }
            if (d2 == null) {
                kotlin.g.b.k.a();
            }
            return d2.doubleValue() > az();
        }
        String str2 = this.aa;
        Double valueOf = str2 != null ? Double.valueOf(Double.parseDouble(str2)) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        double doubleValue = valueOf.doubleValue();
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
        if (aVar == null) {
            kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
        }
        if (aVar != null) {
            d2 = Double.valueOf(aVar.l);
        }
        return doubleValue > d2.doubleValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean V() {
        /*
            r2 = this;
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r2.f55444g
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.V():boolean");
    }

    private final void W() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null) {
            String str = this.aa;
            Bundle arguments = getArguments();
            String str2 = null;
            String string = arguments != null ? arguments.getString("ifsc") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str2 = arguments2.getString("username");
            }
            cVar.a(str, string, str2);
        }
    }

    private final void X() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null) {
            String str = this.aa;
            Bundle arguments = getArguments();
            String str2 = null;
            String string = arguments != null ? arguments.getString("ifsc") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str2 = arguments2.getString("username");
            }
            cVar.b(str, string, str2);
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
        a(string, string2, str3, string3, str2, com.paytm.utility.a.b((Context) getActivity()), this.aa, this.ab);
    }

    private final void Y() {
        androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<c.C1032c>> yVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null && (yVar = cVar.f55602c) != null) {
            yVar.observe(this, new v(this));
        }
    }

    private final boolean Z() {
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
    private final void aa() {
        /*
            r3 = this;
            net.one97.paytm.moneytransfer.utils.g$a r0 = net.one97.paytm.moneytransfer.utils.g.f54162a
            android.content.Context r0 = r3.getContext()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.f55444g
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
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r3.f55444g
            if (r1 == 0) goto L_0x002e
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = r1.getIfsc()
        L_0x002e:
            net.one97.paytm.moneytransfer.utils.g.a.b(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aa():void");
    }

    private final void ab() {
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
                                this.f55442e = i2;
                                this.aK = i2;
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

    private final void ac() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null) {
            cVar.a();
        }
    }

    private final void a(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
        if (this.aK == this.f55442e) {
            c(uPIBankHealthResponseModel);
        } else {
            ac();
        }
    }

    private final void b(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
        String str;
        if (Z() && uPIBankHealthResponseModel != null) {
            net.one97.paytm.moneytransfer.view.fragments.c cVar = new net.one97.paytm.moneytransfer.view.fragments.c();
            Bundle bundle = new Bundle();
            bundle.putString("payer_or_payee", uPIBankHealthResponseModel.getBankDown());
            bundle.putString("neft_error_message", uPIBankHealthResponseModel.getMsg());
            bundle.putString("neft_tooltip_message", uPIBankHealthResponseModel.getNote());
            bundle.putString("category", uPIBankHealthResponseModel.getCategory());
            if (this.Y || TextUtils.isEmpty(uPIBankHealthResponseModel.getBankDown())) {
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
        r5 = (r5 = r5.get(r4.aK)).getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c(net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r5) {
        /*
            r4 = this;
            boolean r0 = r4.Z()
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
            int r2 = r4.aK
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.c(net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel):void");
    }

    private final void ad() {
        if (com.paytm.utility.a.m(getContext())) {
            View view = this.aB;
            if (view == null) {
                kotlin.g.b.k.a("accountsLoadingLayout");
            }
            view.setVisibility(0);
            RelativeLayout relativeLayout = this.A;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mOpenBottomSheetRlv");
            }
            relativeLayout.setVisibility(8);
            LinearLayout linearLayout = this.an;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mPayWrapper");
            }
            linearLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.aD;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("accountsLoadingAnimationView");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
            TextView textView = this.y;
            if (textView == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            if (textView != null) {
                textView.setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void ae() {
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
        TextView textView = this.y;
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
    private final void af() {
        /*
            r4 = this;
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.a.m(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0034
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r2 = r0 instanceof net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity
            if (r2 != 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity r0 = (net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity) r0
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
            android.widget.TextView r2 = r4.ao
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
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r4.f55444g
            if (r0 == 0) goto L_0x0059
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r1 = r0.getPaymentMode()
        L_0x0059:
            if (r1 != 0) goto L_0x005c
            return
        L_0x005c:
            int[] r0 = net.one97.paytm.moneytransferv4.home.presentation.a.c.f55497i
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x006f
            r1 = 2
            if (r0 == r1) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            r4.ah()
        L_0x006e:
            return
        L_0x006f:
            r4.ag()
            return
        L_0x0073:
            int r0 = net.one97.paytm.moneytransfer.R.string.mt_set_upi_pin
            java.lang.String r0 = r4.getString(r0)
            android.widget.TextView r2 = r4.ao
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
            int r2 = r4.f55442e
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x00c0
            int r2 = r4.q
            if (r0 == 0) goto L_0x00bc
            int r1 = r4.f55442e
            java.lang.Object r0 = r0.get(r1)
            r1 = r0
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
        L_0x00bc:
            r0 = 0
            r4.a((int) r2, (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1, (boolean) r0)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.af():void");
    }

    /* access modifiers changed from: private */
    public final void ag() {
        if (this.aL == null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            this.aL = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.p)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        UpiProfileDefaultBank upiProfileDefaultBank2 = this.f55444g;
        String str = null;
        upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getDebitBank() : null);
        UpiProfileDefaultBank upiProfileDefaultBank3 = this.f55444g;
        if (upiProfileDefaultBank3 != null) {
            str = upiProfileDefaultBank3.getVirtualAddress();
        }
        upiProfileDefaultBank.setVirtualAddress(str);
        UPICheckBalanceHelper uPICheckBalanceHelper = this.aL;
        if (uPICheckBalanceHelper != null) {
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void ah() {
        /*
            r7 = this;
            r7.ak()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r7.f55444g
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
            java.lang.String r6 = "moneyTransferv4ActivityViewModel"
            if (r2 == r3) goto L_0x008b
            r3 = 1844922713(0x6df74959, float:9.5664337E27)
            if (r2 == r3) goto L_0x002b
            goto L_0x00cd
        L_0x002b:
            java.lang.String r2 = "CURRENT"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = r7.at()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0058
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_new_balance
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = r7.at()
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r2)
            r1[r4] = r2
            java.lang.String r0 = r7.getString(r0, r1)
            r7.d((java.lang.String) r0)
            r7.i()
            return
        L_0x0058:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r7.Z
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x005f:
            if (r0 == 0) goto L_0x00cd
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r7.f55444g
            if (r2 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r3 = r7.Z
            if (r3 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x006f:
            if (r3 == 0) goto L_0x0087
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r3 = r3.p
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
            java.lang.String r0 = r7.G()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00b8
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_new_balance
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = r7.G()
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r2)
            r1[r4] = r2
            java.lang.String r0 = r7.getString(r0, r1)
            r7.d((java.lang.String) r0)
            r7.i()
            return
        L_0x00b8:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r7.Z
            if (r0 != 0) goto L_0x00bf
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00bf:
            if (r0 == 0) goto L_0x00cd
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r7.f55444g
            if (r1 != 0) goto L_0x00c8
            kotlin.g.b.k.a()
        L_0x00c8:
            java.lang.String r2 = ""
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1, (java.lang.String) r2)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.ah():void");
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            d(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            d(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, bVar.name(), "");
    }

    private final void d(boolean z2) {
        if (isAdded()) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new ad(this), childFragmentManager, z2);
        }
    }

    public static final class ad implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55451a;

        ad(b bVar) {
            this.f55451a = bVar;
        }

        public final void onReEnterClicked() {
            this.f55451a.ag();
            net.one97.paytm.moneytransfer.utils.f.a(this.f55451a.getContext(), "mt_p2p_new_v1", "UPI_pin_reentered", CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
        }

        public final void onCreateNewPinClicked() {
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            UpiProfileDefaultBank n = this.f55451a.f55444g;
            String str = null;
            upiProfileDefaultBank.setDebitBank(n != null ? n.getDebitBank() : null);
            UpiProfileDefaultBank n2 = this.f55451a.f55444g;
            if (n2 != null) {
                str = n2.getVirtualAddress();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            b bVar = this.f55451a;
            bVar.a(bVar.q, upiProfileDefaultBank, true);
            net.one97.paytm.moneytransfer.utils.f.a(this.f55451a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (isAdded()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(\n             …alance)\n                )");
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
                if (cVar != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank = this.f55444g;
                    if (upiProfileDefaultBank == null) {
                        kotlin.g.b.k.a();
                    }
                    BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank, "mSelectedVpaSource!!.debitBank");
                    String account = debitBank.getAccount();
                    kotlin.g.b.k.a((Object) account, "mSelectedVpaSource!!.debitBank.account");
                    cVar.a(account, str4);
                }
                net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar = this.aQ;
                if (bVar != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank2 = this.f55444g;
                    if (upiProfileDefaultBank2 == null) {
                        kotlin.g.b.k.a();
                    }
                    BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank2.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank2, "mSelectedVpaSource!!.debitBank");
                    String account2 = debitBank2.getAccount();
                    kotlin.g.b.k.a((Object) account2, "mSelectedVpaSource!!.debitBank.account");
                    bVar.a(account2);
                }
            } else {
                str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar2 = this.f55443f;
                if (cVar2 != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank3 = this.f55444g;
                    if (upiProfileDefaultBank3 == null) {
                        kotlin.g.b.k.a();
                    }
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank3.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank3, "mSelectedVpaSource!!.debitBank");
                    String account3 = debitBank3.getAccount();
                    kotlin.g.b.k.a((Object) account3, "mSelectedVpaSource!!.debitBank.account");
                    cVar2.a(account3, str4);
                }
                net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar2 = this.aQ;
                if (bVar2 != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank4 = this.f55444g;
                    if (upiProfileDefaultBank4 == null) {
                        kotlin.g.b.k.a();
                    }
                    BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank4.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank4, "mSelectedVpaSource!!.debitBank");
                    String account4 = debitBank4.getAccount();
                    kotlin.g.b.k.a((Object) account4, "mSelectedVpaSource!!.debitBank.account");
                    bVar2.a(account4);
                }
            }
            d(str4);
            TextView textView = this.ao;
            if (textView == null) {
                kotlin.g.b.k.a("checkBalanceTV");
            }
            textView.setVisibility(0);
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
        }
    }

    public final void b() {
        i();
    }

    public final void Z_() {
        ak();
    }

    private final void ai() {
        TextView textView = this.ao;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView != null) {
            textView.setText(getString(R.string.check_balance));
        }
        TextView textView2 = this.ao;
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
            TextView textView = this.ao;
            if (textView == null) {
                kotlin.g.b.k.a("checkBalanceTV");
            }
            if (textView != null) {
                textView.setText(charSequence);
            }
            TextView textView2 = this.ao;
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
        }
    }

    private final void aj() {
        TextView textView = this.ao;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        if (textView != null) {
            textView.setText(getString(R.string.mt_set_upi_pin));
        }
        TextView textView2 = this.ao;
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

    private final void ak() {
        TextView textView = this.ao;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        textView.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.ap;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        lottieAnimationView.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = this.ap;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        AnimationFactory.startWalletLoader(lottieAnimationView2);
    }

    public final void i() {
        LottieAnimationView lottieAnimationView = this.ap;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = this.ap;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("checkBalanceLoader");
        }
        lottieAnimationView2.setVisibility(8);
        TextView textView = this.ao;
        if (textView == null) {
            kotlin.g.b.k.a("checkBalanceTV");
        }
        textView.setVisibility(0);
    }

    public final void onFocusChange(View view, boolean z2) {
        if (this.aR == null) {
            a(!z2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r0.f55565e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void al() {
        /*
            r2 = this;
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            if (r0 == 0) goto L_0x0016
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55565e
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            boolean r1 = r2.O
            if (r1 == 0) goto L_0x002d
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002d
            boolean r1 = r2.an()
            if (r1 != 0) goto L_0x002d
            r2.e((java.lang.String) r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.al():void");
    }

    private final void e(String str) {
        if (!ao()) {
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
                    debitBank2.setIfsc(this.r);
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

    private final void am() {
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList != null) {
            Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                UpiProfileDefaultBank next = it2.next();
                String str = this.r;
                UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
                BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
                kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
                if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                    BankAccountDetails.BankAccount debitBank2 = next != null ? next.getDebitBank() : null;
                    kotlin.g.b.k.a((Object) debitBank2, "currentSelectedBankObject?.debitBank");
                    String account = debitBank2.getAccount();
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
                    if (aVar == null) {
                        kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                    }
                    if (!account.equals((aVar == null || (yVar = aVar.f55565e) == null) ? null : yVar.getValue())) {
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

    private final boolean an() {
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.r;
            UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
            BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                BankAccountDetails.BankAccount debitBank2 = next != null ? next.getDebitBank() : null;
                kotlin.g.b.k.a((Object) debitBank2, "currentSelectedBankObject?.debitBank");
                String account = debitBank2.getAccount();
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
                if (aVar == null) {
                    kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                }
                if (!account.equals((aVar == null || (yVar = aVar.f55565e) == null) ? null : yVar.getValue())) {
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

    private final boolean ao() {
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.r;
            UpiProfileDefaultBank.PAYMENT_MODE payment_mode = null;
            BankAccountDetails.BankAccount debitBank = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank.getIfsc(), true)) {
                BankAccountDetails.BankAccount debitBank2 = next != null ? next.getDebitBank() : null;
                kotlin.g.b.k.a((Object) debitBank2, "currentSelectedBankObject?.debitBank");
                String account = debitBank2.getAccount();
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
                if (aVar == null) {
                    kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                }
                if (!account.equals((aVar == null || (yVar = aVar.f55565e) == null) ? null : yVar.getValue())) {
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

    private final boolean ap() {
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        UpiProfileDefaultBank upiProfileDefaultBank = arrayList.get(this.f55442e);
        kotlin.g.b.k.a((Object) upiProfileDefaultBank, "vpaList.get(currentSelectedPosition)");
        UpiProfileDefaultBank upiProfileDefaultBank2 = upiProfileDefaultBank;
        return (upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getPaymentMode() : null) == UpiProfileDefaultBank.PAYMENT_MODE.IMPS;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0 = r0.p;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aq() {
        /*
            r3 = this;
            boolean r0 = r3.ar()
            if (r0 != 0) goto L_0x0052
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r3.Z
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            if (r0 != 0) goto L_0x000f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000f:
            r2 = 0
            if (r0 == 0) goto L_0x0015
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.p
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r3.Z
            if (r0 != 0) goto L_0x001f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001f:
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.p
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r0 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r0
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r3.Z
            if (r0 != 0) goto L_0x0036
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.p
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aq():void");
    }

    private final boolean ar() {
        BankAccountDetails.BankAccount debitBank;
        androidx.lifecycle.y<String> yVar;
        ArrayList<UpiProfileDefaultBank> arrayList = this.aF;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpiProfileDefaultBank> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiProfileDefaultBank next = it2.next();
            String str = this.r;
            String str2 = null;
            BankAccountDetails.BankAccount debitBank2 = next != null ? next.getDebitBank() : null;
            kotlin.g.b.k.a((Object) debitBank2, "currentSelectedBankObject?.debitBank");
            if (kotlin.m.p.a(str, debitBank2.getIfsc(), true)) {
                BankAccountDetails.BankAccount debitBank3 = next != null ? next.getDebitBank() : null;
                kotlin.g.b.k.a((Object) debitBank3, "currentSelectedBankObject?.debitBank");
                String account = debitBank3.getAccount();
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.Z;
                if (aVar == null) {
                    kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                }
                if (!account.equals((aVar == null || (yVar = aVar.f55565e) == null) ? null : yVar.getValue())) {
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
    public final void as() {
        z();
        a(this.f55442e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String at() {
        /*
            r2 = this;
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            androidx.lifecycle.y<java.lang.String> r0 = r0.f55567g
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r0 = ""
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.at():java.lang.String");
    }

    private final void f(String str) {
        String str2;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("amountET");
        }
        if (customAmountTextInputEditText != null) {
            if (str != null) {
                str2 = new kotlin.m.l(this.s).replaceFirst(str, "");
            } else {
                str2 = null;
            }
            customAmountTextInputEditText.setText(str2);
        }
    }

    public final void a(ThemeData themeData) {
        if (au() && themeData != null) {
            UpiAppUtils.hideKeyboard(getActivity());
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
            if (customAmountTextInputEditText == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText.clearFocus();
            a(true);
            net.one97.paytm.moneytransferv4.f.a aVar = this.aM;
            if (!(aVar == null || themeData == null)) {
                aVar.f55407c = themeData;
                aVar.f55405a = true;
                String themeId = themeData.getThemeId();
                if (themeId == null) {
                    kotlin.g.b.k.a();
                }
                aVar.f55406b = themeId;
                int parseColor = Color.parseColor(themeData.getBgcolor());
                aVar.b(parseColor);
                aVar.c(parseColor);
                aVar.d(Color.parseColor(themeData.getColor()));
                aVar.e(Color.parseColor(themeData.getColor()));
                aVar.a(themeData.getJsonData());
                aVar.a(0.6f);
                String color = themeData.getColor();
                kotlin.g.b.k.a((Object) color, "theme.color");
                int c2 = net.one97.paytm.upi.f.c(color);
                String color2 = themeData.getColor();
                kotlin.g.b.k.a((Object) color2, "theme.color");
                aVar.a(androidx.core.graphics.a.b(c2, (int) (((double) Color.alpha(net.one97.paytm.upi.f.c(color2))) * 0.6d)));
            }
            this.aJ = themeData.getThemeId();
            Fragment parentFragment = getParentFragment();
            if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                parentFragment = null;
            }
            net.one97.paytm.moneytransferv4.a.a.a aVar2 = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment;
            if (aVar2 != null) {
                kotlin.g.b.k.c(themeData, "themeData");
                if (aVar2.getView() != null) {
                    net.one97.paytm.moneytransfer.c.q qVar = aVar2.a().f53770i;
                    kotlin.g.b.k.a((Object) qVar, "this.binding.topPaymentCardLayout");
                    int parseColor2 = Color.parseColor(themeData.getColor());
                    int parseColor3 = Color.parseColor(themeData.getBgcolor());
                    net.one97.paytm.moneytransfer.utils.m.a(qVar.f53818a, parseColor2);
                    net.one97.paytm.moneytransfer.utils.m.a(qVar.f53826i, parseColor2);
                    qVar.j.setTextColor(parseColor2);
                    qVar.f53821d.setTextColor(parseColor2);
                    qVar.k.setBackgroundColor(parseColor3);
                    ImageView imageView = qVar.f53825h;
                    kotlin.g.b.k.a((Object) imageView, "motif");
                    net.one97.paytm.upi.f.c((View) imageView);
                    View view = qVar.f53823f;
                    kotlin.g.b.k.a((Object) view, "divider");
                    view.setAlpha(0.6f);
                }
            }
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_THEME_CLICKED, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, this.aJ, "");
        }
    }

    public final void j() {
        if (au()) {
            UpiAppUtils.hideKeyboard(getActivity());
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
            if (customAmountTextInputEditText == null) {
                kotlin.g.b.k.a("amountET");
            }
            customAmountTextInputEditText.clearFocus();
            a(true);
            net.one97.paytm.moneytransferv4.f.a aVar = this.aM;
            if (aVar != null) {
                aVar.f55407c = null;
                aVar.f55405a = false;
                aVar.f55406b = "";
                Context context = aVar.f55408d;
                if (context != null) {
                    int c2 = androidx.core.content.b.c(context, R.color.color_ffffff);
                    aVar.b(c2);
                    aVar.c(c2);
                }
                Context context2 = aVar.f55408d;
                if (context2 != null) {
                    aVar.d(androidx.core.content.b.c(context2, R.color.color_222222));
                    aVar.e(androidx.core.content.b.c(context2, R.color.color_00b9f5));
                }
                aVar.a(1.0f);
                aVar.a("");
                aVar.a(net.one97.paytm.upi.f.c("#506d85"));
            }
            this.aJ = "";
            Fragment parentFragment = getParentFragment();
            if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                parentFragment = null;
            }
            net.one97.paytm.moneytransferv4.a.a.a aVar2 = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment;
            if (!(aVar2 == null || aVar2.getView() == null)) {
                net.one97.paytm.moneytransfer.c.q qVar = aVar2.a().f53770i;
                kotlin.g.b.k.a((Object) qVar, "this.binding.topPaymentCardLayout");
                int parseColor = Color.parseColor("#506d85");
                int parseColor2 = Color.parseColor("#1d252d");
                net.one97.paytm.moneytransfer.utils.m.a(qVar.f53818a, parseColor2);
                net.one97.paytm.moneytransfer.utils.m.a(qVar.f53826i, parseColor2);
                qVar.j.setTextColor(parseColor2);
                qVar.f53821d.setTextColor(parseColor);
                qVar.k.setBackgroundColor(-1);
                ImageView imageView = qVar.f53825h;
                kotlin.g.b.k.a((Object) imageView, "motif");
                net.one97.paytm.upi.f.b((View) imageView);
                View view = qVar.f53823f;
                kotlin.g.b.k.a((Object) view, "divider");
                view.setAlpha(1.0f);
            }
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_THEME_CLICKED, CJRGTMConstants.MT_V4_ENTER_AMOUNT_SCREEN_NAME, "", "");
        }
    }

    private final boolean au() {
        return getActivity() != null && isAdded() && isResumed();
    }

    public final void k() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void c(boolean z2) {
        if (z2) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            if (!cVar.c()) {
                ConstraintLayout constraintLayout = this.j;
                if (constraintLayout == null) {
                    kotlin.g.b.k.a("pullDownLayout");
                }
                net.one97.paytm.upi.f.a((View) constraintLayout);
                return;
            }
            ConstraintLayout constraintLayout2 = this.j;
            if (constraintLayout2 == null) {
                kotlin.g.b.k.a("pullDownLayout");
            }
            net.one97.paytm.upi.f.b((View) constraintLayout2);
            return;
        }
        ConstraintLayout constraintLayout3 = this.j;
        if (constraintLayout3 == null) {
            kotlin.g.b.k.a("pullDownLayout");
        }
        net.one97.paytm.upi.f.a((View) constraintLayout3);
        ConstraintLayout constraintLayout4 = this.j;
        if (constraintLayout4 == null) {
            kotlin.g.b.k.a("pullDownLayout");
        }
        constraintLayout4.clearAnimation();
    }

    public static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55472a;

        public j(b bVar) {
            this.f55472a = bVar;
        }

        public final void run() {
            if (b.t(this.f55472a).hasFocus()) {
                b.u(this.f55472a).scrollTo(0, b.u(this.f55472a).getHeight());
            } else if (b.E(this.f55472a).hasFocus()) {
                b.u(this.f55472a).scrollTo(0, b.u(this.f55472a).getHeight() / 2);
            }
        }
    }

    public final void a(PaymentOptionItem paymentOptionItem, ReceiverInfo receiverInfo) {
        kotlin.g.b.k.c(paymentOptionItem, "paymentOptionItem");
        kotlin.g.b.k.c(receiverInfo, "receiverInfo");
        if (getView() != null) {
            TextView textView = this.t;
            if (textView == null) {
                kotlin.g.b.k.a("receiverName");
            }
            Bundle arguments = getArguments();
            textView.setText(arguments != null ? arguments.getString("username") : null);
            this.l = paymentOptionItem;
            av();
            SourcePayment sourcePayment = paymentOptionItem.getSourcePayment();
            String paymentType = sourcePayment != null ? sourcePayment.getPaymentType() : null;
            if (paymentType != null) {
                int hashCode = paymentType.hashCode();
                if (hashCode != -1741862919) {
                    if (hashCode != 84238) {
                        if (hashCode == 2031164 && paymentType.equals(SDKConstants.TYPE_BANK)) {
                            Fragment parentFragment = getParentFragment();
                            if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                                parentFragment = null;
                            }
                            net.one97.paytm.moneytransferv4.a.a.a aVar = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment;
                            if (aVar != null) {
                                aVar.a(paymentOptionItem, receiverInfo);
                            }
                            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar = this.k;
                            if (dVar != null) {
                                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.f55443f;
                                if (cVar == null) {
                                    kotlin.g.b.k.a();
                                }
                                dVar.a(paymentOptionItem, receiverInfo, cVar.p);
                            }
                            b.a aVar2 = net.one97.paytm.moneytransferv4.g.b.f55426a;
                            PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.aR;
                            if (paymentCombinationAPIResponse == null) {
                                kotlin.g.b.k.a();
                            }
                            this.f55444g = b.a.a(paymentCombinationAPIResponse, paymentOptionItem);
                            this.f55446i = MoneyTransferV3Activity.d.SAVINGS_ACCOUNT;
                        }
                    } else if (paymentType.equals("UPI")) {
                        DestinationPayment destinationPayment = paymentOptionItem.getDestinationPayment();
                        if (kotlin.g.b.k.a((Object) SDKConstants.TYPE_BANK, (Object) destinationPayment != null ? destinationPayment.getPaymentType() : null)) {
                            Fragment parentFragment2 = getParentFragment();
                            if (!(parentFragment2 instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                                parentFragment2 = null;
                            }
                            net.one97.paytm.moneytransferv4.a.a.a aVar3 = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment2;
                            if (aVar3 != null) {
                                aVar3.a(paymentOptionItem, receiverInfo);
                            }
                        } else {
                            Fragment parentFragment3 = getParentFragment();
                            if (!(parentFragment3 instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                                parentFragment3 = null;
                            }
                            net.one97.paytm.moneytransferv4.a.a.a aVar4 = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment3;
                            if (aVar4 != null) {
                                aVar4.a(paymentOptionItem);
                            }
                        }
                        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar2 = this.k;
                        if (dVar2 != null) {
                            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar2 = this.f55443f;
                            if (cVar2 == null) {
                                kotlin.g.b.k.a();
                            }
                            dVar2.a(paymentOptionItem, cVar2.p);
                        }
                        b.a aVar5 = net.one97.paytm.moneytransferv4.g.b.f55426a;
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse2 = this.aR;
                        if (paymentCombinationAPIResponse2 == null) {
                            kotlin.g.b.k.a();
                        }
                        this.f55444g = b.a.a(paymentCombinationAPIResponse2, paymentOptionItem);
                        this.f55446i = MoneyTransferV3Activity.d.VPA;
                    }
                } else if (paymentType.equals(SDKConstants.AI_KEY_WALLET)) {
                    Fragment parentFragment4 = getParentFragment();
                    if (!(parentFragment4 instanceof net.one97.paytm.moneytransferv4.a.a.a)) {
                        parentFragment4 = null;
                    }
                    net.one97.paytm.moneytransferv4.a.a.a aVar6 = (net.one97.paytm.moneytransferv4.a.a.a) parentFragment4;
                    if (aVar6 != null) {
                        aVar6.a(receiverInfo, paymentOptionItem);
                    }
                    this.f55446i = MoneyTransferV3Activity.d.WALLET;
                    this.f55439b = MoneyTransferV3Activity.a.WALLET;
                    net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar3 = this.k;
                    if (dVar3 != null) {
                        dVar3.a(paymentOptionItem);
                    }
                }
            }
        }
    }

    private final void av() {
        ReceiverInfo receiverInfo;
        Editable text;
        String str;
        ReceiverInfo receiverInfo2;
        String phoneNumber;
        String str2;
        ReceiverInfo receiverInfo3;
        String contactName;
        ReceiverInfo receiverInfo4;
        ReceiverInfo receiverInfo5;
        ReceiverInfo receiverInfo6;
        String str3;
        ReceiverInfo receiverInfo7;
        String name;
        ReceiverInfo receiverInfo8;
        ReceiverInfo receiverInfo9;
        ReceiverInfo receiverInfo10;
        String str4;
        PaymentOptionItem paymentOptionItem = this.l;
        if (paymentOptionItem != null) {
            DestinationPayment destinationPayment = paymentOptionItem.getDestinationPayment();
            Editable editable = null;
            if (!TextUtils.isEmpty(destinationPayment != null ? destinationPayment.getVpaId() : null)) {
                DestinationPayment destinationPayment2 = paymentOptionItem.getDestinationPayment();
                if (destinationPayment2 != null) {
                    DestinationPayment destinationPayment3 = paymentOptionItem.getDestinationPayment();
                    destinationPayment2.setVpaId(URLDecoder.decode(destinationPayment3 != null ? destinationPayment3.getVpaId() : null, AppConstants.UTF_8));
                }
                this.f55439b = MoneyTransferV3Activity.a.VPA;
            } else {
                DestinationPayment destinationPayment4 = paymentOptionItem.getDestinationPayment();
                if (!TextUtils.isEmpty(destinationPayment4 != null ? destinationPayment4.getBankAccountNumber() : null)) {
                    this.f55439b = MoneyTransferV3Activity.a.ACCOUNT_NUMBER;
                }
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                DestinationPayment destinationPayment5 = paymentOptionItem.getDestinationPayment();
                if (destinationPayment5 == null || (str4 = destinationPayment5.getVpaId()) == null) {
                    DestinationPayment destinationPayment6 = paymentOptionItem.getDestinationPayment();
                    str4 = destinationPayment6 != null ? destinationPayment6.getBankAccountNumber() : null;
                }
                arguments.putString("vpa", str4);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                DestinationPayment destinationPayment7 = paymentOptionItem.getDestinationPayment();
                arguments2.putString("ifsc", destinationPayment7 != null ? destinationPayment7.getIfscCode() : null);
            }
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                DestinationPayment destinationPayment8 = paymentOptionItem.getDestinationPayment();
                arguments3.putString("bankname", destinationPayment8 != null ? destinationPayment8.getBankName() : null);
            }
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.aR;
            if (!TextUtils.isEmpty((paymentCombinationAPIResponse == null || (receiverInfo10 = paymentCombinationAPIResponse.getReceiverInfo()) == null) ? null : receiverInfo10.getName())) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse2 = this.aR;
                if (!(paymentCombinationAPIResponse2 == null || (receiverInfo8 = paymentCombinationAPIResponse2.getReceiverInfo()) == null)) {
                    PaymentCombinationAPIResponse paymentCombinationAPIResponse3 = this.aR;
                    receiverInfo8.setName(URLDecoder.decode((paymentCombinationAPIResponse3 == null || (receiverInfo9 = paymentCombinationAPIResponse3.getReceiverInfo()) == null) ? null : receiverInfo9.getName(), AppConstants.UTF_8));
                }
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    PaymentCombinationAPIResponse paymentCombinationAPIResponse4 = this.aR;
                    if (paymentCombinationAPIResponse4 == null || (receiverInfo7 = paymentCombinationAPIResponse4.getReceiverInfo()) == null || (name = receiverInfo7.getName()) == null) {
                        str3 = null;
                    } else if (name != null) {
                        str3 = kotlin.m.p.b(name).toString();
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    arguments4.putString("username", str3);
                }
            } else {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse5 = this.aR;
                if (!TextUtils.isEmpty((paymentCombinationAPIResponse5 == null || (receiverInfo6 = paymentCombinationAPIResponse5.getReceiverInfo()) == null) ? null : receiverInfo6.getContactName())) {
                    PaymentCombinationAPIResponse paymentCombinationAPIResponse6 = this.aR;
                    if (!(paymentCombinationAPIResponse6 == null || (receiverInfo4 = paymentCombinationAPIResponse6.getReceiverInfo()) == null)) {
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse7 = this.aR;
                        receiverInfo4.setContactName(URLDecoder.decode((paymentCombinationAPIResponse7 == null || (receiverInfo5 = paymentCombinationAPIResponse7.getReceiverInfo()) == null) ? null : receiverInfo5.getContactName(), AppConstants.UTF_8));
                    }
                    Bundle arguments5 = getArguments();
                    if (arguments5 != null) {
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse8 = this.aR;
                        if (paymentCombinationAPIResponse8 == null || (receiverInfo3 = paymentCombinationAPIResponse8.getReceiverInfo()) == null || (contactName = receiverInfo3.getContactName()) == null) {
                            str2 = null;
                        } else if (contactName != null) {
                            str2 = kotlin.m.p.b(contactName).toString();
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        arguments5.putString("username", str2);
                    }
                } else {
                    Bundle arguments6 = getArguments();
                    if (arguments6 != null) {
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse9 = this.aR;
                        if (paymentCombinationAPIResponse9 == null || (receiverInfo2 = paymentCombinationAPIResponse9.getReceiverInfo()) == null || (phoneNumber = receiverInfo2.getPhoneNumber()) == null) {
                            str = null;
                        } else if (phoneNumber != null) {
                            str = kotlin.m.p.b(phoneNumber).toString();
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        arguments6.putString("username", str);
                    }
                }
            }
            Bundle arguments7 = getArguments();
            if (arguments7 != null) {
                CustomAmountTextInputEditText customAmountTextInputEditText = this.f55438a;
                if (customAmountTextInputEditText == null) {
                    kotlin.g.b.k.a("amountET");
                }
                arguments7.putString("amount", (customAmountTextInputEditText == null || (text = customAmountTextInputEditText.getText()) == null) ? null : text.toString());
            }
            Bundle arguments8 = getArguments();
            if (arguments8 != null) {
                CommentsEditText commentsEditText = this.aP;
                if (commentsEditText == null) {
                    kotlin.g.b.k.a("messageEditText");
                }
                arguments8.putString("comments", String.valueOf(commentsEditText != null ? commentsEditText.getText() : null));
            }
            Bundle arguments9 = getArguments();
            if (arguments9 != null) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse10 = this.aR;
                arguments9.putString("picture", (paymentCombinationAPIResponse10 == null || (receiverInfo = paymentCombinationAPIResponse10.getReceiverInfo()) == null) ? null : receiverInfo.getPicture());
            }
            Bundle arguments10 = getArguments();
            if (arguments10 != null) {
                CommentsEditText commentsEditText2 = this.aP;
                if (commentsEditText2 == null) {
                    kotlin.g.b.k.a("messageEditText");
                }
                if (commentsEditText2 != null) {
                    editable = commentsEditText2.getText();
                }
                arguments10.putString("comments", String.valueOf(editable));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0 = r0.getPaymentOptionList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aw() {
        /*
            r3 = this;
            int r0 = r3.f55442e
            if (r0 != 0) goto L_0x004a
            net.one97.paytm.moneytransferv4.g.b$a r0 = net.one97.paytm.moneytransferv4.g.b.f55426a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r3.aR
            if (r0 != 0) goto L_0x000d
            kotlin.g.b.k.a()
        L_0x000d:
            int r0 = net.one97.paytm.moneytransferv4.g.b.a.a(r0)
            r1 = -1
            if (r0 == r1) goto L_0x004a
            r3.f55442e = r0
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r0 = r3.aQ
            if (r0 == 0) goto L_0x001e
            int r1 = r3.f55442e
            r0.f55106e = r1
        L_0x001e:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r3.aR
            r1 = 0
            if (r0 == 0) goto L_0x0032
            java.util.List r0 = r0.getPaymentOptionList()
            if (r0 == 0) goto L_0x0032
            int r2 = r3.f55442e
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = (net.one97.paytm.common.entity.p2p.PaymentOptionItem) r0
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 != 0) goto L_0x0038
            kotlin.g.b.k.a()
        L_0x0038:
            if (r0 == 0) goto L_0x004a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = r3.aR
            if (r2 == 0) goto L_0x0042
            net.one97.paytm.common.entity.p2p.ReceiverInfo r1 = r2.getReceiverInfo()
        L_0x0042:
            if (r1 != 0) goto L_0x0047
            kotlin.g.b.k.a()
        L_0x0047:
            r3.a((net.one97.paytm.common.entity.p2p.PaymentOptionItem) r0, (net.one97.paytm.common.entity.p2p.ReceiverInfo) r1)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aw():void");
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "upiProfileDefaultBank");
        this.f55446i = MoneyTransferV3Activity.d.VPA;
        this.f55444g = upiProfileDefaultBank;
        g();
    }

    public final boolean l() {
        return this.V || this.W;
    }

    private final boolean ax() {
        return this.aR != null;
    }

    public static final class al implements WalletPaymentCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55462a;

        public final void onAddMoneySuccess() {
        }

        public final void onNetworkTimeOutForWalletLimitsAPI() {
        }

        public final void onPaymentSuccess() {
        }

        al(b bVar) {
            this.f55462a = bVar;
        }

        public final void handleAddMoneyUIChanges() {
            this.f55462a.m = true;
            if (this.f55462a.l != null) {
                PaymentCombinationAPIResponse G = this.f55462a.aR;
                ReceiverInfo receiverInfo = null;
                if ((G != null ? G.getReceiverInfo() : null) != null) {
                    b bVar = this.f55462a;
                    PaymentOptionItem F = bVar.l;
                    if (F == null) {
                        kotlin.g.b.k.a();
                    }
                    PaymentCombinationAPIResponse G2 = this.f55462a.aR;
                    if (G2 != null) {
                        receiverInfo = G2.getReceiverInfo();
                    }
                    if (receiverInfo == null) {
                        kotlin.g.b.k.a();
                    }
                    b.a(bVar, F, receiverInfo);
                }
            }
        }

        public final void onAddMoneyCancelled() {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.b();
            }
        }

        public final void onAddMoneyFailure(String str, String str2) {
            kotlin.g.b.k.c(str, "title");
            kotlin.g.b.k.c(str2, "message");
            b.b(this.f55462a, str, str2);
        }

        public final void onAddMoneyStart() {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.a();
            }
        }

        public final void onBeneficiaryAdditionFailure() {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.b();
            }
        }

        public final void onBeneficiaryAdditionSuccess() {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.b();
            }
        }

        public final void onPaymentFailure() {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.b();
            }
        }

        public final void onWalletNotAvailableUseOtherPaymodes(String str) {
            kotlin.g.b.k.c(str, "message");
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55462a.k;
            if (S != null) {
                S.b();
            }
            b.a aVar = net.one97.paytm.moneytransferv4.g.b.f55426a;
            Activity activity = this.f55462a.getActivity();
            if (activity != null) {
                c.a aVar2 = new c.a(activity);
                aVar2.a(true);
                aVar2.b((CharSequence) str);
                aVar2.a((CharSequence) "");
                aVar2.a(R.string.ok, (DialogInterface.OnClickListener) b.a.C1024a.f55427a);
                aVar2.b();
            }
        }
    }

    private final double ay() {
        try {
            PaymentOptionItem paymentOptionItem = this.l;
            if (paymentOptionItem != null) {
                if (paymentOptionItem.getPpblLimits() != null) {
                    PPBLLimits ppblLimits = paymentOptionItem.getPpblLimits();
                    Double upiMaxLimit = ppblLimits != null ? ppblLimits.getUpiMaxLimit() : null;
                    if (upiMaxLimit == null) {
                        kotlin.g.b.k.a();
                    }
                    return upiMaxLimit.doubleValue();
                }
                Integer maxLimit = paymentOptionItem.getMaxLimit();
                if (maxLimit == null) {
                    kotlin.g.b.k.a();
                }
                return (double) maxLimit.intValue();
            }
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        return UpiUtils.getMaxAmountAllowed(getContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r0 = r0.getPpblLimits();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final double az() {
        /*
            r2 = this;
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = r2.l     // Catch:{ NumberFormatException -> 0x001a }
            if (r0 == 0) goto L_0x000f
            net.one97.paytm.common.entity.p2p.PPBLLimits r0 = r0.getPpblLimits()     // Catch:{ NumberFormatException -> 0x001a }
            if (r0 == 0) goto L_0x000f
            java.lang.Double r0 = r0.getUpiMaxLimit()     // Catch:{ NumberFormatException -> 0x001a }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0015
            kotlin.g.b.k.a()     // Catch:{ NumberFormatException -> 0x001a }
        L_0x0015:
            double r0 = r0.doubleValue()     // Catch:{ NumberFormatException -> 0x001a }
            return r0
        L_0x001a:
            r0 = move-exception
            r0.printStackTrace()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x0027
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0027:
            double r0 = r0.l
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.az():double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r0 = r0.getPpblLimits();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final double aA() {
        /*
            r2 = this;
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = r2.l     // Catch:{ NumberFormatException -> 0x001a }
            if (r0 == 0) goto L_0x000f
            net.one97.paytm.common.entity.p2p.PPBLLimits r0 = r0.getPpblLimits()     // Catch:{ NumberFormatException -> 0x001a }
            if (r0 == 0) goto L_0x000f
            java.lang.Double r0 = r0.getNeftMaxLimit()     // Catch:{ NumberFormatException -> 0x001a }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0015
            kotlin.g.b.k.a()     // Catch:{ NumberFormatException -> 0x001a }
        L_0x0015:
            double r0 = r0.doubleValue()     // Catch:{ NumberFormatException -> 0x001a }
            return r0
        L_0x001a:
            r0 = move-exception
            r0.printStackTrace()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r0 = r2.Z
            if (r0 != 0) goto L_0x0027
            java.lang.String r1 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0027:
            double r0 = r0.k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aA():double");
    }

    static final class af implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55453a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55454b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55455c;

        af(b bVar, String str, String str2) {
            this.f55453a = bVar;
            this.f55454b = str;
            this.f55455c = str2;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (!(this.f55453a.l == null || this.f55453a.aR == null)) {
                this.f55453a.m = true;
                b.I(this.f55453a);
            }
            dialogInterface.dismiss();
        }
    }

    static final class ag implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final ag f55456a = new ag();

        ag() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [androidx.lifecycle.y] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 == 0) goto L_0x0043
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r5.aR
            r2 = 0
            if (r1 == 0) goto L_0x0034
            net.one97.paytm.common.entity.p2p.ReceiverInfo r1 = r1.getReceiverInfo()
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r1.getPhoneNumber()
            if (r1 == 0) goto L_0x0034
            net.one97.paytm.wallet.utility.a.a r3 = net.one97.paytm.wallet.utility.a.a.f72261c
            java.lang.String r4 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r4 = r5.aR
            if (r4 == 0) goto L_0x002e
            net.one97.paytm.common.entity.p2p.ReceiverInfo r4 = r4.getReceiverInfo()
            if (r4 == 0) goto L_0x002e
            java.lang.String r2 = r4.getName()
        L_0x002e:
            java.lang.String r4 = "MT_REFRESH_CALL"
            androidx.lifecycle.y r2 = r3.a(r0, r1, r4, r2)
        L_0x0034:
            if (r2 == 0) goto L_0x0043
            r0 = r5
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            net.one97.paytm.moneytransferv4.home.presentation.a.b$h r1 = new net.one97.paytm.moneytransferv4.home.presentation.a.b$h
            r1.<init>(r5)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r2.observe(r0, r1)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.m():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "accountNumber"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "balance"
            kotlin.g.b.k.c(r3, r0)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r1.f55444g
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getAccount()
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0027
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d r2 = r1.k
            if (r2 == 0) goto L_0x0027
            r2.a((java.lang.String) r3)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void g(String str) {
        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar = this.aQ;
        if (bVar != null) {
            kotlin.g.b.k.c(str, "<set-?>");
            bVar.f55108g = str;
        }
        net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar = this.aH;
        if (aVar != null) {
            kotlin.g.b.k.c(str, "<set-?>");
            aVar.f55013i = str;
        }
        if (this.aR != null) {
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar = this.k;
            if (dVar != null) {
                dVar.a(str, this.l);
                return;
            }
            return;
        }
        TextView textView = this.y;
        if (textView == null) {
            kotlin.g.b.k.a("mProceedPayment");
        }
        String obj = textView.getText().toString();
        String string = getString(R.string.upi_pay);
        kotlin.g.b.k.a((Object) string, "getString(R.string.upi_pay)");
        if (kotlin.m.p.b(obj, string, true)) {
            TextView textView2 = this.y;
            if (textView2 == null) {
                kotlin.g.b.k.a("mProceedPayment");
            }
            net.one97.paytm.moneytransfer.utils.m.a(textView2, str);
            TextView textView3 = this.at;
            if (textView3 == null) {
                kotlin.g.b.k.a("mCardViewProceed");
            }
            net.one97.paytm.moneytransfer.utils.m.a(textView3, str);
        }
    }

    public static final class i implements net.one97.paytm.n.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55471a;

        public final void a() {
        }

        public /* synthetic */ void g(boolean z) {
            b.CC.$default$g(this, z);
        }

        i(b bVar) {
            this.f55471a = bVar;
        }

        public final void a(net.one97.paytm.network.g gVar) {
            kotlin.g.b.k.c(gVar, "paytmCommonError");
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55471a.k;
            if (S != null) {
                S.b();
            }
            if (net.one97.paytm.moneytransfer.utils.m.a(gVar.f55799a)) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                FragmentActivity activity = this.f55471a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                new NetworkCustomError();
                b2.a((Activity) activity, (String) null, true);
            }
        }

        public final void a(boolean z) {
            if (z) {
                net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S = this.f55471a.k;
                if (S != null) {
                    S.a();
                    return;
                }
                return;
            }
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d S2 = this.f55471a.k;
            if (S2 != null) {
                S2.b();
            }
        }

        public final void ae_() {
            b.I(this.f55471a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r1 = (r1 = r1.getText()).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aB() {
        /*
            r21 = this;
            r0 = r21
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r1 = r0.f55438a
            if (r1 != 0) goto L_0x000b
            java.lang.String r2 = "amountET"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x000b:
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001e
            android.text.Editable r1 = r1.getText()
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r10 = r1
            goto L_0x001f
        L_0x001e:
            r10 = r2
        L_0x001f:
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r1 = r0.aF
            if (r1 == 0) goto L_0x002c
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            int r1 = r1.intValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " Banks"
            r3.append(r1)
            java.lang.String r6 = r3.toString()
            boolean r1 = r0.f55441d
            java.lang.String r3 = "vpa"
            if (r1 == 0) goto L_0x0078
            android.content.Context r11 = r21.requireContext()
            android.os.Bundle r1 = r21.getArguments()
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = r1.getString(r3)
            if (r1 != 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r17 = r1
            goto L_0x0063
        L_0x0061:
            r17 = r2
        L_0x0063:
            java.lang.String r12 = "upi_collect_pay_v1"
            java.lang.String r13 = "down_arrow_clicked"
            java.lang.String r14 = ""
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r18 = ""
            java.lang.String r19 = "/mt_enter_amt_screen"
            java.lang.String r20 = ""
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        L_0x0078:
            boolean r1 = r0.f55440c
            if (r1 == 0) goto L_0x00a1
            android.content.Context r1 = r21.getContext()
            android.os.Bundle r4 = r21.getArguments()
            if (r4 == 0) goto L_0x008f
            java.lang.String r3 = r4.getString(r3)
            if (r3 != 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r9 = r3
            goto L_0x0090
        L_0x008f:
            r9 = r2
        L_0x0090:
            java.lang.String r4 = "upi_intent_pay_v1"
            java.lang.String r5 = "down_arrow_clicked"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r11 = "/mt_enter_amt_screen"
            java.lang.String r12 = ""
            r3 = r1
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aB():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getDebitBank()).getBankName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aC() {
        /*
            r12 = this;
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r12.f55444g
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0015
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r0.getBankName()
            if (r0 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r5 = r0
            goto L_0x0016
        L_0x0015:
            r5 = r1
        L_0x0016:
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r12.f55438a
            if (r0 != 0) goto L_0x001f
            java.lang.String r2 = "amountET"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001f:
            if (r0 == 0) goto L_0x0030
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r9 = r0
            goto L_0x0031
        L_0x0030:
            r9 = r1
        L_0x0031:
            boolean r0 = r12.f55441d
            java.lang.String r2 = "vpa"
            if (r0 == 0) goto L_0x005e
            android.content.Context r0 = r12.requireContext()
            android.os.Bundle r3 = r12.getArguments()
            if (r3 == 0) goto L_0x004b
            java.lang.String r2 = r3.getString(r2)
            if (r2 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r8 = r2
            goto L_0x004c
        L_0x004b:
            r8 = r1
        L_0x004c:
            java.lang.String r3 = "upi_collect_pay_v1"
            java.lang.String r4 = "proceed_clicked"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r10 = "/mt_enter_amt_screen"
            java.lang.String r11 = ""
            r2 = r0
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        L_0x005e:
            boolean r0 = r12.f55440c
            if (r0 == 0) goto L_0x0087
            android.content.Context r0 = r12.getContext()
            android.os.Bundle r3 = r12.getArguments()
            if (r3 == 0) goto L_0x0075
            java.lang.String r2 = r3.getString(r2)
            if (r2 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r8 = r2
            goto L_0x0076
        L_0x0075:
            r8 = r1
        L_0x0076:
            java.lang.String r3 = "upi_intent_pay_v1"
            java.lang.String r4 = "proceed_clicked"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r10 = "/mt_enter_amt_screen"
            java.lang.String r11 = ""
            r2 = r0
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aC():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r0 = (r0 = r0.getText()).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(java.lang.String r13) {
        /*
            r12 = this;
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r0 = r12.f55438a
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "amountET"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x001c
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r9 = r0
            goto L_0x001d
        L_0x001c:
            r9 = r1
        L_0x001d:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r5.add(r13)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r12.f55443f
            if (r0 == 0) goto L_0x003a
            java.lang.Boolean r0 = r0.g()
            if (r0 == 0) goto L_0x003a
            boolean r0 = r0.booleanValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r5.add(r0)
        L_0x003a:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r12.f55443f
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r0.h()
            if (r0 == 0) goto L_0x0047
            r5.add(r0)
        L_0x0047:
            android.os.Bundle r0 = r12.getArguments()
            java.lang.String r2 = "vpa"
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            r5.add(r0)
            boolean r0 = r12.f55441d
            if (r0 == 0) goto L_0x0070
            android.content.Context r2 = r12.getContext()
            java.lang.String r3 = "upi_collect_pay_v1"
            java.lang.String r4 = "redirected_to_onboarding"
            java.lang.String r7 = "/mt_enter_amt_screen"
            java.lang.String r8 = ""
            r6 = r9
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x0070:
            boolean r0 = r12.f55440c
            if (r0 == 0) goto L_0x00b1
            android.content.Context r0 = r12.getContext()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r3 = r12.f55443f
            r4 = 0
            if (r3 == 0) goto L_0x0082
            java.lang.Boolean r3 = r3.g()
            goto L_0x0083
        L_0x0082:
            r3 = r4
        L_0x0083:
            java.lang.String r6 = java.lang.String.valueOf(r3)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r3 = r12.f55443f
            if (r3 == 0) goto L_0x008f
            java.lang.String r4 = r3.h()
        L_0x008f:
            java.lang.String r7 = java.lang.String.valueOf(r4)
            android.os.Bundle r3 = r12.getArguments()
            if (r3 == 0) goto L_0x00a2
            java.lang.String r2 = r3.getString(r2)
            if (r2 != 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r8 = r2
            goto L_0x00a3
        L_0x00a2:
            r8 = r1
        L_0x00a3:
            java.lang.String r3 = "upi_intent_pay_v1"
            java.lang.String r4 = "redirected_to_onboarding"
            java.lang.String r10 = "/mt_enter_amt_screen"
            java.lang.String r11 = ""
            r2 = r0
            r5 = r13
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.h(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final boolean aD() {
        return !net.one97.paytm.moneytransfer.utils.m.b(getContext()) && UpiUtils.isInActiveProfileExist(getContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r3 = r3.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final net.one97.paytm.upi.common.upi.CommonPayParams aE() {
        /*
            r10 = this;
            int r0 = r10.aK
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.aR
            if (r1 == 0) goto L_0x000c
            net.one97.paytm.moneytransferv4.g.b$a r0 = net.one97.paytm.moneytransferv4.g.b.f55426a
            int r0 = net.one97.paytm.moneytransferv4.g.b.a.a(r1)
        L_0x000c:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r1 = r10.aQ
            r2 = 0
            if (r1 == 0) goto L_0x0014
            int r1 = r1.f55106e
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.a r3 = r10.aH
            if (r3 == 0) goto L_0x001b
            int r1 = r3.f55009e
        L_0x001b:
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            java.lang.String r4 = "entry_point"
            r5 = 0
            if (r3 == 0) goto L_0x002f
            android.content.Intent r3 = r3.getIntent()
            if (r3 == 0) goto L_0x002f
            java.lang.String r3 = r3.getStringExtra(r4)
            goto L_0x0030
        L_0x002f:
            r3 = r5
        L_0x0030:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r6 = "MONEY_TRANSFER"
            if (r3 != 0) goto L_0x004e
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            if (r3 == 0) goto L_0x004c
            android.content.Intent r3 = r3.getIntent()
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = r3.getStringExtra(r4)
            if (r3 != 0) goto L_0x0068
        L_0x004c:
            r3 = r6
            goto L_0x0068
        L_0x004e:
            boolean r3 = r10.V
            if (r3 == 0) goto L_0x0054
            java.lang.String r6 = "SPLITBILL"
        L_0x0054:
            boolean r3 = r10.W
            if (r3 == 0) goto L_0x005a
            java.lang.String r6 = "CHAT"
        L_0x005a:
            boolean r3 = r10.L
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = "DEEPLINK"
            goto L_0x0062
        L_0x0061:
            r3 = r6
        L_0x0062:
            boolean r4 = r10.M
            if (r4 == 0) goto L_0x0068
            java.lang.String r3 = "PAY"
        L_0x0068:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = new net.one97.paytm.upi.common.upi.CommonPayParams$Builder
            android.os.Bundle r6 = r10.getArguments()
            if (r6 == 0) goto L_0x0079
            java.lang.String r7 = "extra_key_intent_mode"
            java.lang.String r8 = "00"
            java.lang.String r6 = r6.getString(r7, r8)
            goto L_0x007a
        L_0x0079:
            r6 = r5
        L_0x007a:
            android.os.Bundle r7 = r10.getArguments()
            if (r7 == 0) goto L_0x0087
            java.lang.String r8 = "extra_key_intent_sign"
            java.lang.String r7 = r7.getString(r8)
            goto L_0x0088
        L_0x0087:
            r7 = r5
        L_0x0088:
            android.os.Bundle r8 = r10.getArguments()
            if (r8 == 0) goto L_0x0095
            java.lang.String r9 = "extra_key_intent_orgid"
            java.lang.String r8 = r8.getString(r9)
            goto L_0x0096
        L_0x0095:
            r8 = r5
        L_0x0096:
            r4.<init>(r6, r7, r8)
            android.os.Bundle r6 = r10.getArguments()
            if (r6 == 0) goto L_0x00a6
            java.lang.String r7 = "extra_key_intent_mid"
            java.lang.String r6 = r6.getString(r7)
            goto L_0x00a7
        L_0x00a6:
            r6 = r5
        L_0x00a7:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setMerchantId(r6)
            android.os.Bundle r6 = r10.getArguments()
            if (r6 == 0) goto L_0x00b8
            java.lang.String r7 = "extra_key_intent_msid"
            java.lang.String r6 = r6.getString(r7)
            goto L_0x00b9
        L_0x00b8:
            r6 = r5
        L_0x00b9:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setMerchantStoreId(r6)
            android.os.Bundle r6 = r10.getArguments()
            if (r6 == 0) goto L_0x00ca
            java.lang.String r7 = "extra_key_intent_mtid"
            java.lang.String r6 = r6.getString(r7)
            goto L_0x00cb
        L_0x00ca:
            r6 = r5
        L_0x00cb:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setMerchantTerminalId(r6)
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r6 = r10.l
            if (r6 == 0) goto L_0x00d8
            java.util.HashMap r6 = r6.getExtendedInfo()
            goto L_0x00d9
        L_0x00d8:
            r6 = r5
        L_0x00d9:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setExtendedInfoRefId(r6)
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r6 = r10.aR
            if (r6 == 0) goto L_0x00e5
            java.lang.Boolean r5 = r6.isFailSafe()
        L_0x00e5:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setIsFallback(r5)
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r5 = r10.aR
            r6 = 1
            if (r5 == 0) goto L_0x00f0
            r5 = 1
            goto L_0x00f1
        L_0x00f0:
            r5 = 0
        L_0x00f1:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r4 = r4.setIsPCRAvailable(r5)
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r3 = r4.setEntryPoint(r3)
            if (r0 != r1) goto L_0x00fc
            r2 = 1
        L_0x00fc:
            net.one97.paytm.upi.common.upi.CommonPayParams$Builder r0 = r3.setIsPaidByDefaultOption(r2)
            net.one97.paytm.upi.common.upi.CommonPayParams r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.aE():net.one97.paytm.upi.common.upi.CommonPayParams");
    }

    static final class x<T> implements androidx.lifecycle.z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55486a;

        x(b bVar) {
            this.f55486a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55486a.al();
            this.f55486a.as();
            this.f55486a.ae();
        }
    }

    static final class w<T> implements androidx.lifecycle.z<PPBCurrentAccountModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55485a;

        w(b bVar) {
            this.f55485a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55485a.aq();
            this.f55485a.as();
            this.f55485a.ae();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r1 = r5.f55610b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.a r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = r5.f55609a
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
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r1 = r5.f55610b
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
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f55610b
        L_0x0043:
            r4.a((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x0047:
            if (r5 == 0) goto L_0x004b
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f55610b
        L_0x004b:
            r4.b((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x004f:
            if (r5 == 0) goto L_0x0053
            net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel r0 = r5.f55610b
        L_0x0053:
            r4.b((net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel) r0)
            return
        L_0x0057:
            java.lang.String r5 = "ALLOW"
            boolean r5 = r1.equals(r5)
        L_0x005d:
            r4.ac()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$a):void");
    }

    public static final /* synthetic */ void b(b bVar) {
        Dialog dialog;
        if (bVar.I == null) {
            bVar.I = UpiAppUtils.getWalletStyleProgressDialog(bVar.getActivity());
        }
        Dialog dialog2 = bVar.I;
        if (dialog2 != null) {
            if (dialog2 == null) {
                kotlin.g.b.k.a();
            }
            if (!dialog2.isShowing() && (dialog = bVar.I) != null) {
                dialog.show();
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, boolean z2) {
        if (z2) {
            bVar.T();
            return;
        }
        try {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = bVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            bVar.startActivityForResult(b2.a((Activity) activity), 4444);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static final /* synthetic */ void a(b bVar, ArrayList<UpiProfileDefaultBank> arrayList) {
        String str;
        BankAccountDetails.BankAccount debitBank;
        if (bVar.aD()) {
            bVar.x();
            return;
        }
        boolean z2 = false;
        if (!bVar.Y && arrayList != null && !arrayList.isEmpty()) {
            ArrayList<UpiProfileDefaultBank> arrayList2 = new ArrayList<>();
            Bundle arguments = bVar.getArguments();
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
        bVar.aF = arrayList;
        boolean C2 = bVar.C();
        if (bVar.Y) {
            bVar.O = false;
            bVar.am();
        } else {
            if (!C2) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                FragmentActivity activity = bVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                if (b2.b((Context) activity)) {
                    z2 = true;
                }
            }
            bVar.O = z2;
            if (!C2) {
                bVar.al();
            }
            if (!bVar.ar()) {
                bVar.aq();
            }
        }
        bVar.ab();
        bVar.as();
        if (bVar.aR == null) {
            CustomAmountTextInputEditText customAmountTextInputEditText = bVar.f55438a;
            if (customAmountTextInputEditText == null) {
                kotlin.g.b.k.a("amountET");
            }
            Editable text = customAmountTextInputEditText.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            bVar.g(str);
            CustomAmountTextInputEditText customAmountTextInputEditText2 = bVar.f55438a;
            if (customAmountTextInputEditText2 == null) {
                kotlin.g.b.k.a("amountET");
            }
            net.one97.paytm.moneytransfer.utils.m.a((EditText) customAmountTextInputEditText2, (Activity) bVar.getActivity());
            CustomAmountTextInputEditText customAmountTextInputEditText3 = bVar.f55438a;
            if (customAmountTextInputEditText3 == null) {
                kotlin.g.b.k.a("amountET");
            }
            if (!customAmountTextInputEditText3.isEnabled()) {
                bVar.a(true);
            }
        }
    }

    public static final /* synthetic */ void f(b bVar) {
        ArrayList<UpiProfileDefaultBank> arrayList;
        String sb;
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        b bVar2 = bVar;
        if ((!bVar2.S && !bVar2.P && !bVar2.R && !bVar2.T) && (arrayList = bVar2.aF) != null && (true ^ arrayList.isEmpty())) {
            UpiProfileDefaultBank upiProfileDefaultBank = arrayList.get(bVar2.aK);
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) upiProfileDefaultBank, "upiLists?.get(selectedBa…ForHealthCheckPosition)!!");
            String str = null;
            if (bVar2.Y) {
                Bundle arguments = bVar.getArguments();
                sb = arguments != null ? arguments.getString("vpa") : null;
                if (sb == null) {
                    kotlin.g.b.k.a();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                Bundle arguments2 = bVar.getArguments();
                sb2.append(arguments2 != null ? arguments2.getString("vpa") : null);
                sb2.append("@");
                Bundle arguments3 = bVar.getArguments();
                sb2.append(arguments3 != null ? arguments3.getString("ifsc") : null);
                sb2.append(".ifsc.npci");
                sb = sb2.toString();
            }
            String str2 = sb;
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = bVar2.f55443f;
            if (cVar != null) {
                String str3 = bVar2.aa;
                String virtualAddress = upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null;
                String ifsc = (upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank3.getIfsc();
                String account = (upiProfileDefaultBank == null || (debitBank2 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank2.getAccount();
                String customerName = (upiProfileDefaultBank == null || (debitBank = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank.getCustomerName();
                Bundle arguments4 = bVar.getArguments();
                String string = arguments4 != null ? arguments4.getString("username") : null;
                Bundle arguments5 = bVar.getArguments();
                String string2 = arguments5 != null ? arguments5.getString("bankname") : null;
                Bundle arguments6 = bVar.getArguments();
                if (arguments6 != null) {
                    str = arguments6.getString("ifsc");
                }
                new net.one97.paytm.upi.f.b().a(new c.i(cVar), str3, virtualAddress, ifsc, account, customerName, string, string2, str, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02d2 A[Catch:{ IllegalStateException -> 0x02ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransferv4.home.presentation.a.b r24, net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.e r25) {
        /*
            r0 = r24
            r1 = r25
            if (r1 == 0) goto L_0x035d
            java.lang.Integer r2 = r1.f55618b
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
            goto L_0x034a
        L_0x001d:
            int r4 = r2.intValue()
            if (r4 != 0) goto L_0x034a
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.f55444g
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
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.f55444g
            if (r2 == 0) goto L_0x0344
            if (r2 == 0) goto L_0x0041
            java.lang.String r2 = r2.getVirtualAddress()
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            if (r2 != 0) goto L_0x0046
            goto L_0x0344
        L_0x0046:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.f55444g
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
            java.lang.String r7 = "username"
            java.lang.String r8 = ""
            if (r2 != 0) goto L_0x013a
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r0.f55444g
            if (r1 == 0) goto L_0x007e
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = r1.getIfsc()
            goto L_0x007f
        L_0x007e:
            r1 = r4
        L_0x007f:
            java.lang.String r2 = "PYTM0123456"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x00e3
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r1 = r0.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r2 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            if (r1 != r2) goto L_0x00e3
            android.os.Bundle r1 = r24.getArguments()
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = r1.getString(r7)
            goto L_0x0099
        L_0x0098:
            r1 = r4
        L_0x0099:
            android.os.Bundle r2 = r24.getArguments()
            if (r2 == 0) goto L_0x00a4
            java.lang.String r2 = r2.getString(r7)
            goto L_0x00a5
        L_0x00a4:
            r2 = r4
        L_0x00a5:
            android.os.Bundle r3 = r24.getArguments()
            if (r3 == 0) goto L_0x00b2
            java.lang.String r7 = "bankname"
            java.lang.String r3 = r3.getString(r7)
            goto L_0x00b3
        L_0x00b2:
            r3 = r4
        L_0x00b3:
            android.os.Bundle r7 = r24.getArguments()
            if (r7 == 0) goto L_0x00be
            java.lang.String r5 = r7.getString(r5)
            goto L_0x00bf
        L_0x00be:
            r5 = r4
        L_0x00bf:
            android.os.Bundle r7 = r24.getArguments()
            if (r7 == 0) goto L_0x00c9
            java.lang.String r4 = r7.getString(r6)
        L_0x00c9:
            r6 = r4
            androidx.fragment.app.FragmentActivity r4 = r24.getActivity()
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r7 = com.paytm.utility.a.b((android.content.Context) r4)
            java.lang.String r8 = r0.aa
            java.lang.String r9 = r0.ab
            r0 = r24
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x00e3:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = r0.f55444g
            if (r2 != 0) goto L_0x00ef
            kotlin.g.b.k.a()
        L_0x00ef:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            r1.add(r2)
            net.one97.paytm.upi.common.upi.UserUpiDetails$Builder r2 = new net.one97.paytm.upi.common.upi.UserUpiDetails$Builder
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = r0.f55444g
            if (r3 == 0) goto L_0x0101
            java.lang.String r3 = r3.getVirtualAddress()
            goto L_0x0102
        L_0x0101:
            r3 = r4
        L_0x0102:
            r2.<init>(r4, r3)
            java.util.List r1 = (java.util.List) r1
            net.one97.paytm.upi.common.upi.UserUpiDetails$Builder r1 = r2.setBankAccountList(r1)
            net.one97.paytm.upi.common.upi.UserUpiDetails r1 = r1.build()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r0 = r0.f55443f
            if (r0 == 0) goto L_0x0139
            java.lang.String r2 = "userUpiDetails"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            kotlin.g.b.k.c(r1, r2)
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$d>> r2 = r0.f55608i
            if (r2 == 0) goto L_0x0129
            net.one97.paytm.moneytransfer.model.c$a r3 = net.one97.paytm.moneytransfer.model.c.f54031e
            net.one97.paytm.moneytransfer.model.c r3 = net.one97.paytm.moneytransfer.model.c.a.a()
            r2.setValue(r3)
        L_0x0129:
            net.one97.paytm.upi.profile.b.b r2 = r0.f55607h
            if (r2 == 0) goto L_0x0139
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$m r3 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$m
            r3.<init>(r0)
            net.one97.paytm.upi.profile.b.a$a r3 = (net.one97.paytm.upi.profile.b.a.C1382a) r3
            java.lang.String r0 = "SYNC_MPIN_ACCOUNT"
            r2.a((net.one97.paytm.upi.common.upi.UserUpiDetails) r1, (java.lang.String) r0, (net.one97.paytm.upi.profile.b.a.C1382a) r3, (java.lang.String) r8)
        L_0x0139:
            return
        L_0x013a:
            java.lang.String r1 = r1.f55617a
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 != 0) goto L_0x0343
            if (r1 != 0) goto L_0x014a
            kotlin.g.b.k.a()
        L_0x014a:
            r24.M()
            android.os.Bundle r9 = r24.getArguments()
            if (r9 == 0) goto L_0x0159
            java.lang.String r6 = r9.getString(r6)
            if (r6 != 0) goto L_0x015a
        L_0x0159:
            r6 = r8
        L_0x015a:
            java.lang.String r9 = "arguments?.getString(Bun…_OR_ACCOUNT_NUMBER) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r9 = r0.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r10 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.ACCOUNT_NUMBER
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r12 = "(this as java.lang.String).toLowerCase()"
            if (r9 != r10) goto L_0x0195
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = "@"
            r9.append(r6)
            android.os.Bundle r6 = r24.getArguments()
            if (r6 == 0) goto L_0x0181
            java.lang.String r5 = r6.getString(r5)
            goto L_0x0182
        L_0x0181:
            r5 = r4
        L_0x0182:
            r9.append(r5)
            java.lang.String r5 = ".ifsc.npci"
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            r0.ah = r5
            java.lang.String r5 = "ACCOUNTIFSC"
            r0.ai = r5
            goto L_0x01c2
        L_0x0195:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r5 = r0.f55439b
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r9 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.VPA
            if (r5 != r9) goto L_0x01c2
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r9 = android.text.TextUtils.isEmpty(r5)
            if (r9 != 0) goto L_0x01c0
            java.lang.String r9 = "paytm"
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r9, false)
            if (r5 == 0) goto L_0x01c0
            if (r6 == 0) goto L_0x01ba
            java.lang.String r5 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            r0.ah = r5
            goto L_0x01c2
        L_0x01ba:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x01c0:
            r0.ah = r6
        L_0x01c2:
            java.lang.String r5 = r0.ah
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0311
            java.lang.String r5 = r0.ag
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0311
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0311
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r2 = r0.f55443f
            if (r2 == 0) goto L_0x0337
            java.lang.String r10 = r0.aa
            java.lang.String r3 = r0.ah
            boolean r5 = r0.f55441d
            if (r5 == 0) goto L_0x01f8
            android.os.Bundle r5 = r24.getArguments()
            if (r5 == 0) goto L_0x01f6
            java.lang.String r6 = "payer_vpa"
            java.lang.String r5 = r5.getString(r6)
        L_0x01f4:
            r12 = r5
            goto L_0x0210
        L_0x01f6:
            r12 = r4
            goto L_0x0210
        L_0x01f8:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = r0.f55444g
            if (r5 == 0) goto L_0x0201
            java.lang.String r5 = r5.getVirtualAddress()
            goto L_0x0202
        L_0x0201:
            r5 = r4
        L_0x0202:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            if (r5 == 0) goto L_0x030b
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            goto L_0x01f4
        L_0x0210:
            boolean r5 = r24.ax()
            if (r5 == 0) goto L_0x0239
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r5 = r0.aR
            if (r5 == 0) goto L_0x0239
            net.one97.paytm.common.entity.p2p.ReceiverInfo r6 = r5.getReceiverInfo()
            if (r6 == 0) goto L_0x0229
            java.lang.String r6 = r6.getName()
            if (r6 != 0) goto L_0x0227
            goto L_0x0229
        L_0x0227:
            r5 = r6
            goto L_0x0235
        L_0x0229:
            net.one97.paytm.common.entity.p2p.ReceiverInfo r5 = r5.getReceiverInfo()
            if (r5 == 0) goto L_0x0234
            java.lang.String r5 = r5.getContactName()
            goto L_0x0235
        L_0x0234:
            r5 = r4
        L_0x0235:
            if (r5 != 0) goto L_0x0246
            r5 = r8
            goto L_0x0246
        L_0x0239:
            android.os.Bundle r5 = r24.getArguments()
            if (r5 == 0) goto L_0x0248
            java.lang.String r5 = r5.getString(r7)
            if (r5 != 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r13 = r5
            goto L_0x025a
        L_0x0248:
            android.widget.TextView r5 = r0.t
            if (r5 != 0) goto L_0x0251
            java.lang.String r6 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0251:
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            goto L_0x0246
        L_0x025a:
            java.lang.String r14 = r0.ab
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = r0.f55444g
            if (r5 == 0) goto L_0x026b
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
            if (r5 == 0) goto L_0x026b
            java.lang.String r5 = r5.getAccount()
            goto L_0x026c
        L_0x026b:
            r5 = r4
        L_0x026c:
            java.lang.String r15 = net.one97.paytm.upi.util.UpiUtils.maskNumber(r5)
            java.lang.String r5 = r0.ag
            android.os.Bundle r6 = r24.getArguments()
            if (r6 == 0) goto L_0x0281
            java.lang.String r7 = "extra_key_mcc"
            java.lang.String r6 = r6.getString(r7)
            r18 = r6
            goto L_0x0283
        L_0x0281:
            r18 = r4
        L_0x0283:
            android.os.Bundle r6 = r24.getArguments()
            if (r6 == 0) goto L_0x0292
            java.lang.String r7 = "extra_key_ref_id"
            java.lang.String r6 = r6.getString(r7)
            r19 = r6
            goto L_0x0294
        L_0x0292:
            r19 = r4
        L_0x0294:
            android.os.Bundle r6 = r24.getArguments()
            if (r6 == 0) goto L_0x02a3
            java.lang.String r7 = "extra_key_ref_url"
            java.lang.String r6 = r6.getString(r7)
            r20 = r6
            goto L_0x02a5
        L_0x02a3:
            r20 = r4
        L_0x02a5:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r6 = r0.f55444g
            if (r6 == 0) goto L_0x02bc
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r6 = r6.getDebitBank()
            if (r6 == 0) goto L_0x02bc
            net.one97.paytm.upi.common.upi.BankAccountDetails$CredsAllowed r6 = r6.getCredsAllowed()
            if (r6 == 0) goto L_0x02bc
            java.util.List r6 = r6.getChild()
            r22 = r6
            goto L_0x02be
        L_0x02bc:
            r22 = r4
        L_0x02be:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r6 = r0.f55444g
            if (r6 == 0) goto L_0x02cc
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r6 = r6.getDebitBank()
            if (r6 == 0) goto L_0x02cc
            java.lang.String r4 = r6.getBankName()
        L_0x02cc:
            r23 = r4
            net.one97.paytm.moneytransfer.b.a.b r9 = r2.f55600a     // Catch:{ IllegalStateException -> 0x02ee }
            if (r9 == 0) goto L_0x0337
            org.npci.upi.security.services.CLRemoteResultReceiver r4 = new org.npci.upi.security.services.CLRemoteResultReceiver     // Catch:{ IllegalStateException -> 0x02ee }
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.MoneyTransferV4PaymentViewModel$fetchMPin$1 r6 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.MoneyTransferV4PaymentViewModel$fetchMPin$1     // Catch:{ IllegalStateException -> 0x02ee }
            android.os.Handler r7 = new android.os.Handler     // Catch:{ IllegalStateException -> 0x02ee }
            r7.<init>()     // Catch:{ IllegalStateException -> 0x02ee }
            r6.<init>(r2, r7)     // Catch:{ IllegalStateException -> 0x02ee }
            android.os.ResultReceiver r6 = (android.os.ResultReceiver) r6     // Catch:{ IllegalStateException -> 0x02ee }
            r4.<init>(r6)     // Catch:{ IllegalStateException -> 0x02ee }
            r11 = r3
            r16 = r4
            r17 = r5
            r21 = r1
            r9.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ IllegalStateException -> 0x02ee }
            goto L_0x0337
        L_0x02ee:
            net.one97.paytm.upi.common.UpiCustomVolleyError r1 = new net.one97.paytm.upi.common.UpiCustomVolleyError
            r1.<init>()
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r3 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
            java.lang.String r3 = r3.toString()
            r1.setAlertMessage(r3)
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.lang.String>> r2 = r2.f55606g
            if (r2 == 0) goto L_0x0337
            net.one97.paytm.moneytransfer.model.c$a r3 = net.one97.paytm.moneytransfer.model.c.f54031e
            net.one97.paytm.moneytransfer.model.c r1 = net.one97.paytm.moneytransfer.model.c.a.a((net.one97.paytm.upi.common.UpiCustomVolleyError) r1)
            r2.setValue(r1)
            goto L_0x0337
        L_0x030b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x0311:
            android.content.Context r1 = r24.getContext()
            int r2 = net.one97.paytm.moneytransfer.R.string.upi_error_something_went_wrong
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r3)
            r1.show()
            boolean r1 = r0.T
            if (r1 != 0) goto L_0x032e
            boolean r1 = r0.S
            if (r1 != 0) goto L_0x032e
            boolean r1 = r0.P
            if (r1 != 0) goto L_0x032e
            boolean r1 = r0.R
            if (r1 == 0) goto L_0x0337
        L_0x032e:
            androidx.fragment.app.FragmentActivity r1 = r24.getActivity()
            if (r1 == 0) goto L_0x0337
            r1.finish()
        L_0x0337:
            androidx.fragment.app.FragmentActivity r1 = r24.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = net.one97.paytm.upi.util.GetCredentialsApiBuilder.getTrust(r1)
            r0.al = r1
        L_0x0343:
            return
        L_0x0344:
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$b r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG
            r0.a((net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.b) r1)
            return
        L_0x034a:
            if (r2 != 0) goto L_0x034d
            return
        L_0x034d:
            int r1 = r2.intValue()
            if (r1 != r3) goto L_0x035d
            r1 = 2011(0x7db, float:2.818E-42)
            r0.b((int) r1)
            java.lang.String r1 = "device_not_binded"
            r0.h((java.lang.String) r1)
        L_0x035d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.a(net.one97.paytm.moneytransferv4.home.presentation.a.b, net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$e):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(net.one97.paytm.moneytransferv4.home.presentation.a.b r10, java.lang.String r11) {
        /*
            boolean r0 = r10.S
            r1 = -1
            r2 = 0
            if (r0 != 0) goto L_0x0301
            boolean r0 = r10.T
            if (r0 == 0) goto L_0x000c
            goto L_0x0301
        L_0x000c:
            boolean r0 = r10.f()
            java.lang.String r3 = "username"
            java.lang.String r4 = "key_intent_params"
            java.lang.String r5 = "extra_key_ref_id"
            java.lang.String r6 = "extra_key_ref_url"
            java.lang.String r7 = "extra_key_mcc"
            if (r0 == 0) goto L_0x00a1
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "extra_key_mpin"
            r0.putString(r1, r11)
            java.lang.String r11 = r10.ag
            java.lang.String r1 = "extra_key_deeplink_txn_id"
            r0.putString(r1, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x0039
            java.lang.String r11 = r11.getString(r3)
            goto L_0x003a
        L_0x0039:
            r11 = r2
        L_0x003a:
            java.lang.String r1 = "payee_name"
            r0.putString(r1, r11)
            java.lang.String r11 = r10.aa
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.convertToTwoPlaces(r11)
            java.lang.String r1 = "amount"
            r0.putString(r1, r11)
            java.lang.String r11 = r10.ab
            java.lang.String r1 = "extra_key_comments"
            r0.putString(r1, r11)
            java.lang.String r11 = r10.ah
            java.lang.String r1 = "payee_vpa"
            r0.putString(r1, r11)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = r10.f55444g
            java.io.Serializable r11 = (java.io.Serializable) r11
            java.lang.String r1 = "user_upi_details"
            r0.putSerializable(r1, r11)
            net.one97.paytm.upi.common.upi.CommonPayParams r11 = r10.aE()
            java.io.Serializable r11 = (java.io.Serializable) r11
            r0.putSerializable(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x0076
            java.lang.String r11 = r11.getString(r7)
            goto L_0x0077
        L_0x0076:
            r11 = r2
        L_0x0077:
            r0.putString(r7, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x0085
            java.lang.String r11 = r11.getString(r6)
            goto L_0x0086
        L_0x0085:
            r11 = r2
        L_0x0086:
            r0.putString(r6, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x0093
            java.lang.String r2 = r11.getString(r5)
        L_0x0093:
            r0.putString(r5, r2)
            java.lang.String r11 = r10.ac
            java.lang.String r1 = "extra_key_upi_min_amount"
            r0.putString(r1, r11)
            r10.a((android.os.Bundle) r0)
            return
        L_0x00a1:
            java.lang.String r0 = "mpin"
            kotlin.g.b.k.c(r11, r0)
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r8 = r10.getActivity()
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Class<net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity> r9 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.class
            r0.<init>(r8, r9)
            java.lang.String r8 = "key_bundle"
            r0.putExtra(r8, r2)
            net.one97.paytm.upi.common.upi.CommonPayParams r8 = r10.aE()
            java.io.Serializable r8 = (java.io.Serializable) r8
            r0.putExtra(r4, r8)
            android.os.Bundle r4 = r10.getArguments()
            if (r4 == 0) goto L_0x00cc
            java.lang.String r3 = r4.getString(r3)
            goto L_0x00cd
        L_0x00cc:
            r3 = r2
        L_0x00cd:
            java.lang.String r4 = "key_name"
            r0.putExtra(r4, r3)
            java.lang.String r3 = "key_mpin"
            r0.putExtra(r3, r11)
            java.lang.String r11 = r10.al
            java.lang.String r3 = "npci_trust"
            r0.putExtra(r3, r11)
            java.lang.String r11 = r10.R()
            java.lang.String r3 = "key_account_number_selected"
            r0.putExtra(r3, r11)
            java.lang.String r11 = r10.aa
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.convertToTwoPlaces(r11)
            java.lang.String r3 = "key_amount"
            r0.putExtra(r3, r11)
            java.lang.String r11 = r10.ab
            java.lang.String r3 = "key_comment"
            r0.putExtra(r3, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x0106
            java.lang.String r3 = "bankname"
            java.lang.String r11 = r11.getString(r3)
            goto L_0x0107
        L_0x0106:
            r11 = r2
        L_0x0107:
            java.lang.String r3 = "key_bank_name"
            r0.putExtra(r3, r11)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = r10.f55439b
            java.io.Serializable r11 = (java.io.Serializable) r11
            java.lang.String r3 = "key_account_no_vpa_adhaar"
            r0.putExtra(r3, r11)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r11 = r10.Z
            if (r11 != 0) goto L_0x011e
            java.lang.String r3 = "moneyTransferv4ActivityViewModel"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x011e:
            if (r11 == 0) goto L_0x012b
            androidx.lifecycle.y<java.lang.String> r11 = r11.f55565e
            if (r11 == 0) goto L_0x012b
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x012c
        L_0x012b:
            r11 = r2
        L_0x012c:
            java.lang.String r3 = "key_payer_ppb_account_number"
            r0.putExtra(r3, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x013f
            java.lang.String r3 = "vpa"
            java.lang.String r11 = r11.getString(r3)
            goto L_0x0140
        L_0x013f:
            r11 = r2
        L_0x0140:
            java.lang.String r3 = "key_account_number"
            r0.putExtra(r3, r11)
            boolean r11 = r10.V
            java.lang.String r3 = "from_app_evoke"
            r0.putExtra(r3, r11)
            boolean r11 = r10.M
            java.lang.String r3 = "is_from_scan"
            r0.putExtra(r3, r11)
            boolean r11 = r10.W
            java.lang.String r3 = "is_from_chat_flow"
            r0.putExtra(r3, r11)
            boolean r11 = r10.M
            r3 = 0
            java.lang.String r4 = "is_deeplink"
            if (r11 != 0) goto L_0x0167
            boolean r11 = r10.f55440c
            r0.putExtra(r4, r11)
            goto L_0x016a
        L_0x0167:
            r0.putExtra(r4, r3)
        L_0x016a:
            boolean r11 = r10.P
            java.lang.String r4 = "is_from_univ_p2p"
            r0.putExtra(r4, r11)
            java.lang.String r11 = r10.aJ
            java.lang.String r4 = "uni_p2p_landing_intent_extra_theme"
            r0.putExtra(r4, r11)
            java.lang.String r11 = r10.Q()
            java.lang.String r4 = "ifsc"
            r0.putExtra(r4, r11)
            boolean r11 = r10.f55441d
            java.lang.String r4 = "is_collect_request"
            r0.putExtra(r4, r11)
            boolean r11 = r10.N
            java.lang.String r4 = "upi_is_self"
            r0.putExtra(r4, r11)
            boolean r11 = r10.f55441d
            java.lang.String r4 = "payer_vpa"
            java.lang.String r8 = "collect_request_txn_id"
            if (r11 == 0) goto L_0x01b2
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = r10.f55444g
            if (r11 == 0) goto L_0x01ac
            android.os.Bundle r9 = r10.getArguments()
            if (r9 == 0) goto L_0x01a8
            java.lang.String r9 = r9.getString(r4)
            goto L_0x01a9
        L_0x01a8:
            r9 = r2
        L_0x01a9:
            r11.setVirtualAddress(r9)
        L_0x01ac:
            java.lang.String r11 = r10.af
            r0.putExtra(r8, r11)
            goto L_0x01b7
        L_0x01b2:
            java.lang.String r11 = r10.ag
            r0.putExtra(r8, r11)
        L_0x01b7:
            java.lang.String r11 = r10.ah
            java.lang.String r8 = "payee_address"
            r0.putExtra(r8, r11)
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = r10.f55444g
            java.io.Serializable r11 = (java.io.Serializable) r11
            r0.putExtra(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x01d2
            java.lang.String r4 = "mobile"
            java.lang.String r11 = r11.getString(r4)
            goto L_0x01d3
        L_0x01d2:
            r11 = r2
        L_0x01d3:
            java.lang.String r4 = "payee_mob_no"
            r0.putExtra(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x01e3
            java.lang.String r11 = r11.getString(r7)
            goto L_0x01e4
        L_0x01e3:
            r11 = r2
        L_0x01e4:
            java.lang.String r4 = "mcc"
            r0.putExtra(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x01f4
            java.lang.String r11 = r11.getString(r6)
            goto L_0x01f5
        L_0x01f4:
            r11 = r2
        L_0x01f5:
            java.lang.String r4 = "ref_url"
            r0.putExtra(r4, r11)
            java.lang.String r11 = r10.ae
            java.lang.String r4 = "upi_tran_log_id"
            r0.putExtra(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x020d
            java.lang.String r11 = r11.getString(r5)
            goto L_0x020e
        L_0x020d:
            r11 = r2
        L_0x020e:
            java.lang.String r4 = "ref_id"
            r0.putExtra(r4, r11)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r11 = r10.f55439b
            java.io.Serializable r11 = (java.io.Serializable) r11
            java.lang.String r4 = "payee_acc_or_vpa"
            r0.putExtra(r4, r11)
            java.lang.String r11 = r10.ac
            java.lang.String r4 = "min_amt_deep_link"
            r0.putExtra(r4, r11)
            boolean r11 = r10.f55440c
            java.lang.String r4 = "is_from_upi_deep_link"
            r0.putExtra(r4, r11)
            java.lang.String r11 = r10.ai
            java.lang.String r4 = "global_address_type"
            r0.putExtra(r4, r11)
            android.os.Bundle r11 = r10.getArguments()
            java.lang.String r4 = "picture"
            if (r11 == 0) goto L_0x023e
            java.lang.String r11 = r11.getString(r4)
            goto L_0x023f
        L_0x023e:
            r11 = r2
        L_0x023f:
            r0.putExtra(r4, r11)
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            java.lang.String r4 = "split_bill_data"
            if (r11 == 0) goto L_0x0256
            android.content.Intent r11 = r11.getIntent()
            if (r11 == 0) goto L_0x0256
            java.io.Serializable r11 = r11.getSerializableExtra(r4)
            goto L_0x0257
        L_0x0256:
            r11 = r2
        L_0x0257:
            r0.putExtra(r4, r11)
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            java.lang.String r4 = "hide_isa_fd"
            if (r11 == 0) goto L_0x0270
            android.content.Intent r11 = r11.getIntent()
            if (r11 == 0) goto L_0x0270
            boolean r11 = r11.getBooleanExtra(r4, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
        L_0x0270:
            java.io.Serializable r2 = (java.io.Serializable) r2
            r0.putExtra(r4, r2)
            boolean r11 = r10.f55440c
            if (r11 != 0) goto L_0x0281
            boolean r11 = r10.V
            if (r11 != 0) goto L_0x0281
            boolean r11 = r10.W
            if (r11 == 0) goto L_0x0286
        L_0x0281:
            r11 = 33554432(0x2000000, float:9.403955E-38)
            r0.addFlags(r11)
        L_0x0286:
            r10.aa()
            boolean r11 = r10.V
            if (r11 != 0) goto L_0x029d
            boolean r11 = r10.W
            if (r11 != 0) goto L_0x029d
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 != 0) goto L_0x029a
            kotlin.g.b.k.a()
        L_0x029a:
            r11.setResult(r1)
        L_0x029d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "fromScan  :: "
            r11.<init>(r1)
            boolean r1 = r10.M
            r11.append(r1)
            boolean r11 = r10.M
            if (r11 == 0) goto L_0x02f4
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            r1 = -1
            if (r11 == 0) goto L_0x02c8
            android.content.Intent r11 = r11.getIntent()
            if (r11 == 0) goto L_0x02c8
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x02c8
            java.lang.String r3 = "eventStartTime"
            long r3 = r11.getLong(r3)
            goto L_0x02c9
        L_0x02c8:
            r3 = r1
        L_0x02c9:
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x02e1
            android.content.Intent r11 = r11.getIntent()
            if (r11 == 0) goto L_0x02e1
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x02e1
            java.lang.String r1 = "eventScanTime"
            long r1 = r11.getLong(r1)
        L_0x02e1:
            java.lang.String r11 = "eventStartTime"
            r0.putExtra(r11, r3)
            java.lang.String r11 = "eventScanTime"
            r0.putExtra(r11, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r11 = "process"
            r0.putExtra(r11, r1)
        L_0x02f4:
            r10.startActivity(r0)
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            if (r10 != 0) goto L_0x032d
            kotlin.g.b.k.a()
            goto L_0x032d
        L_0x0301:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L_0x0313
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0313
            java.lang.String r3 = "upi_mpin"
            r0.putExtra(r3, r11)
        L_0x0313:
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0326
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L_0x0323
            android.content.Intent r2 = r0.getIntent()
        L_0x0323:
            r11.setResult(r1, r2)
        L_0x0326:
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            if (r10 != 0) goto L_0x032d
            return
        L_0x032d:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.c(net.one97.paytm.moneytransferv4.home.presentation.a.b, java.lang.String):void");
    }

    public static final /* synthetic */ void q(b bVar) {
        ShimmerFrameLayout shimmerFrameLayout = bVar.w;
        if (shimmerFrameLayout == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout.setVisibility(0);
        ShimmerFrameLayout shimmerFrameLayout2 = bVar.w;
        if (shimmerFrameLayout2 == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout2.startShimmerAnimation();
    }

    public static final /* synthetic */ void r(b bVar) {
        ShimmerFrameLayout shimmerFrameLayout = bVar.w;
        if (shimmerFrameLayout == null) {
            kotlin.g.b.k.a("shimmerNameLayout");
        }
        shimmerFrameLayout.setVisibility(8);
        ShimmerFrameLayout shimmerFrameLayout2 = bVar.w;
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
    public static final /* synthetic */ void a(net.one97.paytm.moneytransferv4.home.presentation.a.b r7, net.one97.paytm.moneytransfer.model.c r8) {
        /*
            ResultType r8 = r8.f54033b
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$b r8 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.b) r8
            r0 = 0
            if (r8 == 0) goto L_0x000a
            java.lang.String r1 = r8.f55575b
            goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 1
            if (r3 != 0) goto L_0x00c0
            android.widget.TextView r3 = r7.t
            if (r3 != 0) goto L_0x001e
            java.lang.String r5 = "receiverName"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x001e:
            r3.setText(r2)
            android.os.Bundle r2 = r7.getArguments()
            if (r2 == 0) goto L_0x002d
            java.lang.String r3 = "username"
            r2.putString(r3, r1)
        L_0x002d:
            androidx.fragment.app.Fragment r2 = r7.getParentFragment()
            boolean r3 = r2 instanceof net.one97.paytm.moneytransferv4.a.a.a
            if (r3 != 0) goto L_0x0036
            r2 = r0
        L_0x0036:
            net.one97.paytm.moneytransferv4.a.a.a r2 = (net.one97.paytm.moneytransferv4.a.a.a) r2
            if (r2 == 0) goto L_0x004b
            android.os.Handler r3 = new android.os.Handler
            r3.<init>()
            net.one97.paytm.moneytransferv4.a.a.a$g r5 = new net.one97.paytm.moneytransferv4.a.a.a$g
            r5.<init>(r2, r1)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r1 = 100
            r3.postDelayed(r5, r1)
        L_0x004b:
            if (r8 == 0) goto L_0x0050
            java.lang.String r1 = r8.f55577d
            goto L_0x0051
        L_0x0050:
            r1 = r0
        L_0x0051:
            java.lang.String r2 = "NOT AVAILABLE"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r4)
            if (r1 != 0) goto L_0x0154
            if (r8 == 0) goto L_0x005e
            java.lang.String r1 = r8.f55577d
            goto L_0x005f
        L_0x005e:
            r1 = r0
        L_0x005f:
            java.lang.String r2 = "INVALID"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r4)
            boolean r2 = r7.f55440c
            if (r2 == 0) goto L_0x0096
            r7.U = r1
            android.widget.ImageView r2 = r7.D
            java.lang.String r3 = "ivVerificationLogo"
            if (r2 != 0) goto L_0x0074
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0074:
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r7.aA
            if (r2 != 0) goto L_0x0082
            java.lang.String r6 = "tvbhimUpi"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0082:
            r2.setVisibility(r5)
            android.widget.ImageView r2 = r7.D
            if (r2 != 0) goto L_0x008c
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x008c:
            if (r1 == 0) goto L_0x0091
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_unverified_merchant
            goto L_0x0093
        L_0x0091:
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_verified_merchant
        L_0x0093:
            r2.setBackgroundResource(r1)
        L_0x0096:
            if (r8 == 0) goto L_0x009a
            java.lang.String r0 = r8.f55577d
        L_0x009a:
            java.lang.String r8 = "VERIFIED"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r4)
            if (r8 == 0) goto L_0x0154
            boolean r8 = r7.M
            java.lang.String r0 = "extra_key_intent_mode"
            if (r8 == 0) goto L_0x00b4
            android.os.Bundle r7 = r7.getArguments()
            if (r7 == 0) goto L_0x00b3
            java.lang.String r8 = "02"
            r7.putString(r0, r8)
        L_0x00b3:
            return
        L_0x00b4:
            android.os.Bundle r7 = r7.getArguments()
            if (r7 == 0) goto L_0x00bf
            java.lang.String r8 = "05"
            r7.putString(r0, r8)
        L_0x00bf:
            return
        L_0x00c0:
            if (r8 == 0) goto L_0x00c5
            java.lang.String r1 = r8.f55576c
            goto L_0x00c6
        L_0x00c5:
            r1 = r0
        L_0x00c6:
            if (r8 == 0) goto L_0x00ce
            int r8 = r8.f55574a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
        L_0x00ce:
            java.lang.String r8 = "Error"
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e8
        L_0x00d3:
            int r2 = r0.intValue()
            if (r2 != r4) goto L_0x00e8
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_unable_to_verify_vpa
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "getString(R.string.upi_unable_to_verify_vpa)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r7.c((java.lang.String) r8, (java.lang.String) r0)
            return
        L_0x00e8:
            if (r0 != 0) goto L_0x00eb
            return
        L_0x00eb:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x0154
            java.lang.String r0 = "401"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 == 0) goto L_0x0103
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.moneytransfer.utils.m.b((android.app.Activity) r0)
        L_0x0103:
            java.lang.String r0 = "XH"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "J02"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "U17"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "0037"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 == 0) goto L_0x0131
        L_0x0123:
            int r0 = net.one97.paytm.moneytransfer.R.string.upi_address_incorrect
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "getString(R.string.upi_address_incorrect)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r7.c((java.lang.String) r8, (java.lang.String) r0)
        L_0x0131:
            java.lang.String r0 = "INT-1470"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 == 0) goto L_0x0147
            int r0 = net.one97.paytm.moneytransfer.R.string.mt_vpa_verify_no_bank_linked_err
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "getString(R.string.mt_vp…erify_no_bank_linked_err)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r7.c((java.lang.String) r8, (java.lang.String) r0)
        L_0x0147:
            java.lang.String r8 = "1006"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r4)
            if (r8 == 0) goto L_0x0154
            r8 = 2013(0x7dd, float:2.821E-42)
            r7.b((int) r8)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.a(net.one97.paytm.moneytransferv4.home.presentation.a.b, net.one97.paytm.moneytransfer.model.c):void");
    }

    public static final /* synthetic */ void a(b bVar, c.C1032c cVar) {
        Integer num;
        androidx.lifecycle.y<String> yVar;
        String str = null;
        if (cVar != null) {
            num = cVar.f55611a;
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            String str2 = cVar != null ? cVar.f55612b : null;
            String str3 = cVar != null ? cVar.f55613c : null;
            if (bVar.Z()) {
                net.one97.paytm.moneytransfer.e.a aVar = new net.one97.paytm.moneytransfer.e.a();
                Bundle bundle = new Bundle();
                bundle.putString("amount", bVar.aa);
                Bundle arguments = bVar.getArguments();
                bundle.putString("ifsc", arguments != null ? arguments.getString("ifsc") : null);
                Bundle arguments2 = bVar.getArguments();
                if (!TextUtils.isEmpty(arguments2 != null ? arguments2.getString("bankname") : null)) {
                    Bundle arguments3 = bVar.getArguments();
                    bundle.putString("bankname", arguments3 != null ? arguments3.getString("bankname") : null);
                } else {
                    Bundle arguments4 = bVar.getArguments();
                    bundle.putString("bankname", arguments4 != null ? arguments4.getString("username") : null);
                }
                Bundle arguments5 = bVar.getArguments();
                if (arguments5 != null) {
                    str = arguments5.getString("vpa");
                }
                bundle.putString("vpa", str);
                bundle.putString("neft_error_message", str2);
                bundle.putString("neft_tooltip_message", str3);
                aVar.setArguments(bundle);
                aVar.show(bVar.getChildFragmentManager(), "");
            }
        } else if (num != null && num.intValue() == 2) {
            String str4 = cVar != null ? cVar.f55612b : null;
            if (cVar != null) {
                str = cVar.f55613c;
            }
            if (bVar.Z()) {
                net.one97.paytm.moneytransfer.e.c cVar2 = new net.one97.paytm.moneytransfer.e.c();
                Bundle bundle2 = new Bundle();
                bundle2.putString("neft_error_message", str4);
                bundle2.putString("neft_tooltip_message", str);
                cVar2.setArguments(bundle2);
                cVar2.show(bVar.getChildFragmentManager(), "");
            }
        } else if (num != null && num.intValue() == 1) {
            bVar.h();
        } else if (num != null && num.intValue() == 4) {
            Toast.makeText(bVar.getContext(), cVar.f55612b, 1).show();
        } else if (num != null && num.intValue() == 3) {
            String str5 = cVar != null ? cVar.f55612b : null;
            String str6 = cVar != null ? cVar.f55613c : null;
            if (bVar.Z()) {
                net.one97.paytm.moneytransfer.e.b bVar2 = new net.one97.paytm.moneytransfer.e.b();
                Bundle bundle3 = new Bundle();
                bundle3.putString("amount", bVar.aa);
                bundle3.putString("ifsc", bVar.K);
                bundle3.putString("bankname", bVar.getString(R.string.money_tranfer_balance_paytm_bank_string));
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = bVar.Z;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("moneyTransferv4ActivityViewModel");
                }
                if (!(aVar2 == null || (yVar = aVar2.f55565e) == null)) {
                    str = yVar.getValue();
                }
                bundle3.putString("vpa", String.valueOf(str));
                bundle3.putString("neft_error_message", str5);
                bundle3.putString("neft_tooltip_message", str6);
                bVar2.setArguments(bundle3);
                bVar2.show(bVar.getChildFragmentManager(), "");
            }
        }
    }

    public static final /* synthetic */ void b(b bVar, net.one97.paytm.moneytransfer.model.c cVar) {
        String str;
        if (cVar != null) {
            bVar.i();
            int i2 = c.j[cVar.f54032a.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    a.C1030a aVar = (a.C1030a) resulttype;
                    if (aVar != null) {
                        Integer num = aVar.f55573d;
                        if (num != null && num.intValue() == 0) {
                            if (!TextUtils.isEmpty(aVar.f55570a)) {
                                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f55572c) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f55572c) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                                    str = bVar.getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(aVar.f55571b), UpiAppUtils.priceToString(aVar.f55570a));
                                    kotlin.g.b.k.a((Object) str, "getString(\n             …                        )");
                                } else {
                                    str = bVar.getString(R.string.upi_new_balance, UpiAppUtils.priceToString(aVar.f55570a));
                                    kotlin.g.b.k.a((Object) str, "getString(\n             …                        )");
                                }
                                bVar.d(str);
                                return;
                            }
                            bVar.ai();
                            Toast.makeText(bVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                            return;
                        } else if (num != null && num.intValue() == 2) {
                            Fragment parentFragment = bVar.getParentFragment();
                            if (parentFragment != null) {
                                b bVar2 = (b) parentFragment;
                                if (bVar2 != null) {
                                    bVar2.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                                    return;
                                }
                                return;
                            }
                            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
                        } else if (num != null && num.intValue() == 1) {
                            bVar.b(bVar.p);
                            return;
                        } else if (num != null && num.intValue() == 3) {
                            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
                            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                            FragmentActivity activity = bVar.getActivity();
                            if (activity == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) activity, "activity!!");
                            new NetworkCustomError();
                            b2.a((Activity) activity, (String) null, true);
                            return;
                        } else if (num != null && num.intValue() == 4) {
                            Toast.makeText(bVar.getActivity(), R.string.upi_incorrect_mpin, 1).show();
                        } else if (num != null && num.intValue() == 5) {
                            Toast.makeText(bVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                            bVar.ai();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (i2 == 3) {
                    bVar.ai();
                    Toast.makeText(bVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                    return;
                } else if (i2 != 4) {
                    return;
                }
                bVar.ai();
                return;
            }
            bVar.ak();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        r1 = r1.getBalance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void I(net.one97.paytm.moneytransferv4.home.presentation.a.b r19) {
        /*
            r0 = r19
            boolean r1 = r19.Z()
            if (r1 == 0) goto L_0x00a5
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r1 = r0.l
            if (r1 == 0) goto L_0x00a5
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = r0.aR
            if (r2 == 0) goto L_0x00a5
            net.one97.paytm.common.entity.p2p.ReceiverInfo r2 = r2.getReceiverInfo()
            if (r2 == 0) goto L_0x00a5
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d r3 = r0.k
            if (r3 == 0) goto L_0x001d
            r3.a()
        L_0x001d:
            net.one97.paytm.wallet.utility.d r3 = net.one97.paytm.wallet.utility.d.f72319a
            androidx.fragment.app.FragmentActivity r3 = r19.getActivity()
            if (r3 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            java.lang.String r4 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r5 = r3
            android.app.Activity r5 = (android.app.Activity) r5
            r6 = r0
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r3 = r0.f55438a
            if (r3 != 0) goto L_0x003c
            java.lang.String r4 = "amountET"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x003c:
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r7 = net.one97.paytm.upi.util.UpiAppUtils.getCleanString(r3)
            java.lang.String r3 = "UpiAppUtils.getCleanStri…amountET.text.toString())"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            net.one97.paytm.common.entity.p2p.SourcePayment r1 = r1.getSourcePayment()
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = r1.getBalance()
            if (r1 != 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r8 = r1
            goto L_0x005f
        L_0x005e:
            r8 = r3
        L_0x005f:
            net.one97.paytm.upi.util.CommentsEditText r1 = r0.aP
            if (r1 != 0) goto L_0x0068
            java.lang.String r4 = "messageEditText"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0068:
            android.text.Editable r1 = r1.getText()
            java.lang.String r9 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r2.getPicture()
            if (r1 != 0) goto L_0x0078
            r11 = r3
            goto L_0x0079
        L_0x0078:
            r11 = r1
        L_0x0079:
            java.lang.String r1 = r2.getPhoneNumber()
            if (r1 != 0) goto L_0x0081
            r12 = r3
            goto L_0x0082
        L_0x0081:
            r12 = r1
        L_0x0082:
            java.lang.String r1 = r2.getName()
            if (r1 != 0) goto L_0x008a
            r13 = r3
            goto L_0x008b
        L_0x008a:
            r13 = r1
        L_0x008b:
            java.lang.String r1 = r0.aJ
            if (r1 != 0) goto L_0x0091
            r15 = r3
            goto L_0x0092
        L_0x0091:
            r15 = r1
        L_0x0092:
            boolean r1 = r0.m
            boolean r17 = r19.l()
            net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r0 = r0.n
            java.lang.String r10 = ""
            java.lang.String r14 = ""
            r16 = r1
            r18 = r0
            net.one97.paytm.wallet.utility.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.I(net.one97.paytm.moneytransferv4.home.presentation.a.b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r0 = r0.getPaymentOptionList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void J(net.one97.paytm.moneytransferv4.home.presentation.a.b r5) {
        /*
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r5.aR
            if (r0 == 0) goto L_0x00ba
            net.one97.paytm.moneytransferv4.g.b$a r1 = net.one97.paytm.moneytransferv4.g.b.f55426a
            int r0 = net.one97.paytm.moneytransferv4.g.b.a.a(r0)
            r1 = -1
            java.lang.String r2 = "vpaListAdapter"
            java.lang.String r3 = "response"
            if (r0 == r1) goto L_0x0082
            r5.f55442e = r0
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r0 = r5.aQ
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r5.aR
            if (r1 != 0) goto L_0x001f
            kotlin.g.b.k.a()
        L_0x001f:
            int r4 = r5.f55442e
            kotlin.g.b.k.c(r1, r3)
            r3 = r0
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r3 = (net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b) r3
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a r3 = r3.f55105d
            if (r3 == 0) goto L_0x0052
            java.util.List r3 = r1.getPaymentOptionList()
            if (r3 == 0) goto L_0x0052
            r0.a((net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r1)
            r0.f55106e = r4
            r0.f55107f = r1
            java.util.List r1 = r1.getPaymentOptionList()
            if (r1 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a r3 = r0.f55105d
            if (r3 != 0) goto L_0x0048
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0048:
            if (r3 == 0) goto L_0x004f
            int r2 = r0.f55106e
            r3.a(r1, r2)
        L_0x004f:
            r0.d()
        L_0x0052:
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = r5.aR
            r1 = 0
            if (r0 == 0) goto L_0x0066
            java.util.List r0 = r0.getPaymentOptionList()
            if (r0 == 0) goto L_0x0066
            int r2 = r5.f55442e
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = (net.one97.paytm.common.entity.p2p.PaymentOptionItem) r0
            goto L_0x0067
        L_0x0066:
            r0 = r1
        L_0x0067:
            if (r0 != 0) goto L_0x006c
            kotlin.g.b.k.a()
        L_0x006c:
            if (r0 == 0) goto L_0x0081
            r5.n()
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = r5.aR
            if (r2 == 0) goto L_0x0079
            net.one97.paytm.common.entity.p2p.ReceiverInfo r1 = r2.getReceiverInfo()
        L_0x0079:
            if (r1 != 0) goto L_0x007e
            kotlin.g.b.k.a()
        L_0x007e:
            r5.a((net.one97.paytm.common.entity.p2p.PaymentOptionItem) r0, (net.one97.paytm.common.entity.p2p.ReceiverInfo) r1)
        L_0x0081:
            return
        L_0x0082:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r0 = r5.aQ
            if (r0 == 0) goto L_0x00ba
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r5 = r5.aR
            if (r5 != 0) goto L_0x008d
            kotlin.g.b.k.a()
        L_0x008d:
            kotlin.g.b.k.c(r5, r3)
            r1 = r0
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r1 = (net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b) r1
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a r1 = r1.f55105d
            if (r1 == 0) goto L_0x00ba
            java.util.List r1 = r5.getPaymentOptionList()
            if (r1 == 0) goto L_0x00ba
            r0.a((net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r5)
            r0.f55107f = r5
            java.util.List r5 = r5.getPaymentOptionList()
            if (r5 != 0) goto L_0x00ab
            kotlin.g.b.k.a()
        L_0x00ab:
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a r1 = r0.f55105d
            if (r1 != 0) goto L_0x00b2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00b2:
            int r2 = r0.f55106e
            r1.a(r5, r2)
            r0.d()
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.J(net.one97.paytm.moneytransferv4.home.presentation.a.b):void");
    }

    public static final /* synthetic */ void L(b bVar) {
        ThemeData themeData;
        net.one97.paytm.moneytransferv4.f.a aVar = bVar.aM;
        if (aVar != null) {
            themeData = aVar.f55407c;
        } else {
            themeData = null;
        }
        if (themeData != null) {
            net.one97.paytm.moneytransferv4.f.a aVar2 = bVar.aM;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            ThemeData themeData2 = aVar2.f55407c;
            if (themeData2 == null) {
                kotlin.g.b.k.a();
            }
            String color = themeData2.getColor();
            kotlin.g.b.k.a((Object) color, "theme.color");
            int c2 = net.one97.paytm.upi.f.c(color);
            String color2 = themeData2.getColor();
            kotlin.g.b.k.a((Object) color2, "theme.color");
            int b2 = androidx.core.graphics.a.b(c2, Color.alpha(net.one97.paytm.upi.f.c(color2)));
            TextView textView = bVar.C;
            if (textView == null) {
                kotlin.g.b.k.a("rupeePrefixTV");
            }
            textView.setTextColor(b2);
            return;
        }
        TextView textView2 = bVar.C;
        if (textView2 == null) {
            kotlin.g.b.k.a("rupeePrefixTV");
        }
        textView2.setTextColor(net.one97.paytm.upi.f.c("#506d85"));
    }

    public static final /* synthetic */ void M(b bVar) {
        ThemeData themeData;
        net.one97.paytm.moneytransferv4.f.a aVar = bVar.aM;
        if (aVar != null) {
            themeData = aVar.f55407c;
        } else {
            themeData = null;
        }
        if (themeData != null) {
            net.one97.paytm.moneytransferv4.f.a aVar2 = bVar.aM;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            ThemeData themeData2 = aVar2.f55407c;
            if (themeData2 == null) {
                kotlin.g.b.k.a();
            }
            String color = themeData2.getColor();
            kotlin.g.b.k.a((Object) color, "theme.color");
            int c2 = net.one97.paytm.upi.f.c(color);
            String color2 = themeData2.getColor();
            kotlin.g.b.k.a((Object) color2, "theme.color");
            int b2 = androidx.core.graphics.a.b(c2, Color.alpha(net.one97.paytm.upi.f.c(color2)));
            TextView textView = bVar.C;
            if (textView == null) {
                kotlin.g.b.k.a("rupeePrefixTV");
            }
            textView.setTextColor(b2);
            return;
        }
        TextView textView2 = bVar.C;
        if (textView2 == null) {
            kotlin.g.b.k.a("rupeePrefixTV");
        }
        textView2.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
    }

    public static final /* synthetic */ void N(b bVar) {
        ThemeData themeData;
        String str;
        net.one97.paytm.moneytransferv4.f.a aVar = bVar.aM;
        ThemeData themeData2 = null;
        if (aVar != null) {
            themeData = aVar.f55407c;
        } else {
            themeData = null;
        }
        if (themeData != null) {
            net.one97.paytm.moneytransferv4.f.a aVar2 = bVar.aM;
            if (aVar2 != null) {
                themeData2 = aVar2.f55407c;
            }
            if (themeData2 == null) {
                kotlin.g.b.k.a();
            }
            str = themeData2.getColor();
            kotlin.g.b.k.a((Object) str, "themeController?.getCurrentTheme()!!.color");
        } else {
            str = "#1d2f54";
        }
        int b2 = androidx.core.graphics.a.b(net.one97.paytm.upi.f.c(str), (int) (((double) Color.alpha(net.one97.paytm.upi.f.c(str))) * 0.6d));
        TextView textView = bVar.B;
        if (textView == null) {
            kotlin.g.b.k.a("amountErrorTV");
        }
        textView.setTextColor(b2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008a, code lost:
        r1 = r1.getBalance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransferv4.home.presentation.a.b r17, net.one97.paytm.common.entity.p2p.PaymentOptionItem r18, net.one97.paytm.common.entity.p2p.ReceiverInfo r19) {
        /*
            r0 = r17
            boolean r1 = r0.aV
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.f.b r1 = net.one97.paytm.f.b.a()
            java.lang.String r2 = "RiskInformationController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r1 = r1.b()
            java.lang.String r3 = "RiskInformationControlle…stance().riskExtendedInfo"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r3 = 1
            r1.setGalleryScan(r3)
            net.one97.paytm.f.b r1 = net.one97.paytm.f.b.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r1 = r1.b()
            android.content.Context r3 = r17.getContext()
            java.lang.String r3 = com.paytm.utility.a.g(r3)
            r1.setLatitude(r3)
            net.one97.paytm.f.b r1 = net.one97.paytm.f.b.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r1 = r1.b()
            android.content.Context r2 = r17.getContext()
            java.lang.String r2 = com.paytm.utility.a.h(r2)
            r1.setLongitude(r2)
        L_0x0048:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            if (r1 == 0) goto L_0x00d8
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            boolean r2 = r1.isFinishing()
            if (r2 != 0) goto L_0x00d8
            net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d r2 = r0.k
            if (r2 == 0) goto L_0x0060
            r2.a()
        L_0x0060:
            net.one97.paytm.wallet.utility.d r2 = net.one97.paytm.wallet.utility.d.f72319a
            r3 = r1
            android.app.Activity r3 = (android.app.Activity) r3
            r4 = r0
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r1 = r0.f55438a
            if (r1 != 0) goto L_0x0071
            java.lang.String r2 = "amountET"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0071:
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = net.one97.paytm.upi.util.UpiAppUtils.getCleanString(r1)
            java.lang.String r1 = "UpiAppUtils.getCleanStri…amountET.text.toString())"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            net.one97.paytm.common.entity.p2p.SourcePayment r1 = r18.getSourcePayment()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = r1.getBalance()
            if (r1 != 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r6 = r1
            goto L_0x0094
        L_0x0093:
            r6 = r2
        L_0x0094:
            net.one97.paytm.upi.util.CommentsEditText r1 = r0.aP
            if (r1 != 0) goto L_0x009d
            java.lang.String r7 = "messageEditText"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x009d:
            android.text.Editable r1 = r1.getText()
            java.lang.String r7 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r19.getPicture()
            if (r1 != 0) goto L_0x00ad
            r9 = r2
            goto L_0x00ae
        L_0x00ad:
            r9 = r1
        L_0x00ae:
            java.lang.String r1 = r19.getPhoneNumber()
            if (r1 != 0) goto L_0x00b6
            r10 = r2
            goto L_0x00b7
        L_0x00b6:
            r10 = r1
        L_0x00b7:
            java.lang.String r1 = r19.getName()
            if (r1 != 0) goto L_0x00bf
            r11 = r2
            goto L_0x00c0
        L_0x00bf:
            r11 = r1
        L_0x00c0:
            java.lang.String r1 = r0.aJ
            if (r1 != 0) goto L_0x00c6
            r13 = r2
            goto L_0x00c7
        L_0x00c6:
            r13 = r1
        L_0x00c7:
            boolean r14 = r0.m
            boolean r15 = r17.l()
            net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r0 = r0.n
            java.lang.String r8 = ""
            java.lang.String r12 = ""
            r16 = r0
            net.one97.paytm.wallet.utility.d.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.a.b.a(net.one97.paytm.moneytransferv4.home.presentation.a.b, net.one97.paytm.common.entity.p2p.PaymentOptionItem, net.one97.paytm.common.entity.p2p.ReceiverInfo):void");
    }

    public static final /* synthetic */ void b(b bVar, String str, String str2) {
        FragmentActivity activity = bVar.getActivity();
        if (activity != null) {
            c.a aVar = new c.a(activity);
            aVar.a(true);
            aVar.b((CharSequence) str2);
            aVar.a((CharSequence) str);
            aVar.a(R.string.retry, (DialogInterface.OnClickListener) new af(bVar, str2, str));
            aVar.b(R.string.cancel, (DialogInterface.OnClickListener) ag.f55456a);
            aVar.b();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.ba;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
