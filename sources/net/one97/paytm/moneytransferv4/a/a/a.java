package net.one97.paytm.moneytransferv4.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.p2p.DestinationPayment;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SenderDisplayInformation;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransferv4.LockableBottomSheetBehavior;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.f;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.g;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.TooltipView;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.moneytransferv4.g.b;
import net.one97.paytm.moneytransferv4.home.presentation.a.b;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a extends net.one97.paytm.moneytransferv4.b.a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0982a f54784c = new C0982a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.moneytransferv4.home.presentation.a.b f54785a;

    /* renamed from: b  reason: collision with root package name */
    public q f54786b;

    /* renamed from: e  reason: collision with root package name */
    private c f54787e;

    /* renamed from: f  reason: collision with root package name */
    private e f54788f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f54789g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f54790h;

    /* renamed from: i  reason: collision with root package name */
    private PaymentFlow f54791i;
    private PaymentManager.PaymentUiModel j;
    private String k = "";
    private String l;
    private Uri m;
    private PaymentManager.PaymentUICollectRequestModel n;
    /* access modifiers changed from: private */
    public net.one97.paytm.moneytransfer.c.j o;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a p;
    private BankAccountDetails.BankAccount q;
    private PopupWindow r;
    private HashMap s;

    public static final a a(PaymentManager.PaymentUiModel paymentUiModel, Activity activity) {
        return C0982a.a(paymentUiModel, activity, 12);
    }

    public final void c() {
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class j<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54803a;

        j(a aVar) {
            this.f54803a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            a aVar = this.f54803a;
            kotlin.g.b.k.a((Object) str, "it");
            kotlin.g.b.k.c(str, CLConstants.FIELD_ERROR_CODE);
            if (UpiUtils.isAuthenticationFailure(str)) {
                m.b((Activity) aVar.getActivity());
                return;
            }
            Context context = aVar.getContext();
            if (context != null) {
                net.one97.paytm.upi.f.a(context, R.string.something_went_wrong, 0);
            }
        }
    }

    static final class k<T> implements z<net.one97.paytm.moneytransfer.model.c<List<? extends UpiTransactionModelV2>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54804a;

        k(a aVar) {
            this.f54804a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            int i2 = b.f54805a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                a aVar = this.f54804a;
                kotlin.g.b.k.a((Object) cVar, Payload.RESPONSE);
                a.a(aVar, cVar);
            } else if (i2 == 2) {
                a aVar2 = this.f54804a;
                kotlin.g.b.k.a((Object) cVar, Payload.RESPONSE);
                a.f(aVar2);
            }
        }
    }

    public static final /* synthetic */ c d(a aVar) {
        c cVar = aVar.f54787e;
        if (cVar == null) {
            kotlin.g.b.k.a("beneficiaryHistoryViewModel");
        }
        return cVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.home.presentation.a.b e(a aVar) {
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = aVar.f54785a;
        if (bVar == null) {
            kotlin.g.b.k.a("paymentFragment");
        }
        return bVar;
    }

    public static final /* synthetic */ PopupWindow g(a aVar) {
        PopupWindow popupWindow = aVar.r;
        if (popupWindow == null) {
            kotlin.g.b.k.a("mPopupWindow");
        }
        return popupWindow;
    }

    public final net.one97.paytm.moneytransfer.c.j a() {
        net.one97.paytm.moneytransfer.c.j jVar = this.o;
        if (jVar == null) {
            kotlin.g.b.k.a();
        }
        return jVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("payment_flow");
            if (!(serializable instanceof PaymentFlow)) {
                serializable = null;
            }
            this.f54791i = (PaymentFlow) serializable;
            Serializable serializable2 = arguments.getSerializable("payment_ui_model");
            if (!(serializable2 instanceof PaymentManager.PaymentUiModel)) {
                serializable2 = null;
            }
            this.j = (PaymentManager.PaymentUiModel) serializable2;
            Serializable serializable3 = arguments.getSerializable("bankAccount_object");
            if (!(serializable3 instanceof BankAccountDetails.BankAccount)) {
                serializable3 = null;
            }
            this.q = (BankAccountDetails.BankAccount) serializable3;
            this.l = arguments.getString("primary_vpa");
            String string = arguments.getString("uri");
            if (string != null) {
                this.m = Uri.parse(string);
            }
            Serializable serializable4 = arguments.getSerializable("collect_flow");
            if (!(serializable4 instanceof PaymentManager.PaymentUICollectRequestModel)) {
                serializable4 = null;
            }
            this.n = (PaymentManager.PaymentUICollectRequestModel) serializable4;
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_beneficiary_history, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        PaymentCombinationAPIResponse data;
        ReceiverInfo receiverInfo;
        String str2;
        DestinationPayment destinationPayment;
        SourcePayment sourcePayment;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.o = net.one97.paytm.moneytransfer.c.j.a(view);
        if (TextUtils.isEmpty(this.k)) {
            PaymentFlow paymentFlow = this.f54791i;
            if (!(paymentFlow instanceof PaymentFlow.PaymentCombination)) {
                paymentFlow = null;
            }
            PaymentFlow.PaymentCombination paymentCombination = (PaymentFlow.PaymentCombination) paymentFlow;
            PaymentCombinationAPIResponse data2 = paymentCombination != null ? paymentCombination.getData() : null;
            if (data2 != null) {
                List<PaymentOptionItem> paymentOptionList = data2.getPaymentOptionList();
                if (paymentOptionList == null) {
                    kotlin.g.b.k.a();
                }
                Iterator<PaymentOptionItem> it2 = paymentOptionList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    PaymentOptionItem next = it2.next();
                    if (kotlin.g.b.k.a((Object) "ENABLED", (Object) (next == null || (sourcePayment = next.getSourcePayment()) == null) ? null : sourcePayment.getPaymentInstrumentStatus())) {
                        DestinationPayment destinationPayment2 = next.getDestinationPayment();
                        if (destinationPayment2 == null || (str2 = destinationPayment2.getBankAccountNumber()) == null) {
                            str2 = (next == null || (destinationPayment = next.getDestinationPayment()) == null) ? null : destinationPayment.getVpaId();
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        this.k = str2;
                    }
                }
                ImageView imageView = a().f53770i.f53826i;
                kotlin.g.b.k.a((Object) imageView, "binding.topPaymentCardLayout.options");
                View view2 = imageView;
                b.a aVar = net.one97.paytm.moneytransferv4.g.b.f55426a;
                net.one97.paytm.upi.f.a(view2, b.a.a(data2) != -1);
            } else {
                if ((this.m == null && this.n == null) ? false : true) {
                    ImageView imageView2 = a().f53770i.f53826i;
                    kotlin.g.b.k.a((Object) imageView2, "binding.topPaymentCardLayout.options");
                    net.one97.paytm.upi.f.a((View) imageView2, false);
                }
            }
        }
        net.one97.paytm.moneytransfer.c.j a2 = a();
        this.f54788f = new e(new ArrayList());
        RecyclerView recyclerView = a2.f53763b;
        kotlin.g.b.k.a((Object) recyclerView, "binding.beneficiaryHistoryRecyclerView");
        e eVar = this.f54788f;
        if (eVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        recyclerView.setAdapter(eVar);
        a();
        ao aoVar = this;
        q qVar = this.f54786b;
        if (qVar == null) {
            kotlin.g.b.k.a("viewModelFactory");
        }
        ai a3 = new al(aoVar, (al.b) qVar).a(c.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProvider(this, …oryViewModel::class.java]");
        this.f54787e = (c) a3;
        c cVar = this.f54787e;
        if (cVar == null) {
            kotlin.g.b.k.a("beneficiaryHistoryViewModel");
        }
        cVar.f54807b.observe(getViewLifecycleOwner(), new j(this));
        c cVar2 = this.f54787e;
        if (cVar2 == null) {
            kotlin.g.b.k.a("beneficiaryHistoryViewModel");
        }
        cVar2.f54806a.observe(getViewLifecycleOwner(), new k(this));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        ai a4 = am.a(activity).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.class);
        kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(ac…ityViewModel::class.java]");
        this.p = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a) a4;
        net.one97.paytm.moneytransfer.c.j a5 = a();
        FrameLayout frameLayout = a5.f53764c;
        kotlin.g.b.k.a((Object) frameLayout, "binding.bottomSheetLayout");
        PaymentFlow paymentFlow2 = this.f54791i;
        if (!(paymentFlow2 instanceof PaymentFlow.PaymentCombination)) {
            paymentFlow2 = null;
        }
        PaymentFlow.PaymentCombination paymentCombination2 = (PaymentFlow.PaymentCombination) paymentFlow2;
        PaymentCombinationAPIResponse data3 = paymentCombination2 != null ? paymentCombination2.getData() : null;
        if (this.j != null) {
            b.a aVar2 = net.one97.paytm.moneytransferv4.home.presentation.a.b.o;
            PaymentManager.PaymentUiModel paymentUiModel = this.j;
            if (paymentUiModel == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(paymentUiModel, "paymentUiModel");
            Bundle bundle2 = new Bundle();
            String accNoOrVpa = paymentUiModel.getAccNoOrVpa();
            String userName = paymentUiModel.getUserName();
            String bankName = paymentUiModel.getBankName();
            String ifsc = paymentUiModel.getIfsc();
            if (com.paytm.utility.b.X(accNoOrVpa)) {
                bundle2.putBoolean("isVPA", true);
                bundle2.putString("vpa", accNoOrVpa);
                bundle2.putString("username", userName);
            } else {
                bundle2.putBoolean("isVPA", false);
                bundle2.putString("vpa", accNoOrVpa);
                bundle2.putString("username", userName);
                bundle2.putString("ifsc", ifsc);
                bundle2.putString("bankname", bankName);
                bundle2.putString("mobile", paymentUiModel.getPayeeMobile());
            }
            bundle2.putInt("source_of_initiation", MoneyTransferV3Activity.c.BENEFICIARY_LIST.ordinal());
            bundle2.putBoolean("is_self_account", paymentUiModel.isSelfAccount());
            bundle2.putSerializable("pcr", data3);
            net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = new net.one97.paytm.moneytransferv4.home.presentation.a.b();
            bVar.setArguments(bundle2);
            this.f54785a = bVar;
        } else {
            PaymentManager.PaymentUICollectRequestModel paymentUICollectRequestModel = this.n;
            if (paymentUICollectRequestModel == null) {
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("pcr", data3);
                b.a aVar3 = net.one97.paytm.moneytransferv4.home.presentation.a.b.o;
                kotlin.g.b.k.c(bundle3, "bundle");
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar2 = new net.one97.paytm.moneytransferv4.home.presentation.a.b();
                bVar2.setArguments(bundle3);
                this.f54785a = bVar2;
            } else if (paymentUICollectRequestModel != null) {
                b.a aVar4 = net.one97.paytm.moneytransferv4.home.presentation.a.b.o;
                kotlin.g.b.k.c(paymentUICollectRequestModel, "collectModel");
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("isVPA", true);
                bundle4.putString("vpa", paymentUICollectRequestModel.getPayeeVpa());
                bundle4.putString(UpiConstants.EXTRA_PAYER_VPA, paymentUICollectRequestModel.getPayerVpa());
                bundle4.putString("username", paymentUICollectRequestModel.getName());
                bundle4.putString("amount", paymentUICollectRequestModel.getAmount());
                bundle4.putString("txn_id", paymentUICollectRequestModel.getTxnId());
                bundle4.putString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, paymentUICollectRequestModel.getTxnLogId());
                bundle4.putSerializable("user_upi_details", paymentUICollectRequestModel.getBank());
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar3 = new net.one97.paytm.moneytransferv4.home.presentation.a.b();
                bVar3.setArguments(bundle4);
                this.f54785a = bVar3;
            }
        }
        androidx.fragment.app.q a6 = getChildFragmentManager().a();
        int i2 = R.id.paymentContainer;
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar4 = this.f54785a;
        if (bVar4 == null) {
            kotlin.g.b.k.a("paymentFragment");
        }
        a6.a(i2, (Fragment) bVar4).b();
        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
        kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(bottomSheetLayout)");
        from.setState(3);
        from.setPeekHeight(0);
        from.setBottomSheetCallback(new b(this));
        a5.f53765d.setOnClickListener(new c(from));
        net.one97.paytm.moneytransfer.c.j a7 = a();
        net.one97.paytm.moneytransfer.c.q qVar2 = a7.f53770i;
        kotlin.g.b.k.a((Object) qVar2, "this.topPaymentCardLayout");
        TextView textView = qVar2.f53821d;
        kotlin.g.b.k.a((Object) textView, "receiverDetails.bankName");
        this.f54789g = textView;
        ImageView imageView3 = qVar2.f53819b;
        kotlin.g.b.k.a((Object) imageView3, "receiverDetails.bankImage");
        this.f54790h = imageView3;
        PaymentFlow paymentFlow3 = this.f54791i;
        if (paymentFlow3 == null) {
            PaymentManager.PaymentUiModel paymentUiModel2 = this.j;
            if (paymentUiModel2 != null) {
                if (paymentUiModel2 == null) {
                    kotlin.g.b.k.a();
                }
                if (paymentUiModel2.isVpa()) {
                    net.one97.paytm.moneytransfer.c.q qVar3 = a7.f53770i;
                    kotlin.g.b.k.a((Object) qVar3, "binding.topPaymentCardLayout");
                    String userName2 = paymentUiModel2.getUserName();
                    int a8 = p.a((CharSequence) paymentUiModel2.getAccNoOrVpa(), ".wallet@paytm", 0, false, 6);
                    CharSequence charSequence = userName2;
                    if (TextUtils.isEmpty(charSequence) || (!TextUtils.isEmpty(charSequence) && p.a(userName2, "null", true))) {
                        TextView textView2 = qVar3.j;
                        kotlin.g.b.k.a((Object) textView2, "receiverDetails.receiverName");
                        net.one97.paytm.upi.f.a((View) textView2);
                    } else if (a8 == 10) {
                        String accNoOrVpa2 = paymentUiModel2.getAccNoOrVpa();
                        if (accNoOrVpa2 != null) {
                            String substring = accNoOrVpa2.substring(0, a8);
                            kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            TextView textView3 = qVar3.j;
                            kotlin.g.b.k.a((Object) textView3, "receiverDetails.receiverName");
                            textView3.setText(substring);
                            TextView textView4 = qVar3.f53821d;
                            kotlin.g.b.k.a((Object) textView4, "receiverDetails.bankName");
                            textView4.setText(getString(R.string.mt_v4_paytm_wallet_linked, substring));
                            ImageView imageView4 = qVar3.f53819b;
                            ImageView imageView5 = this.f54790h;
                            if (imageView5 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            imageView4.setImageDrawable(androidx.core.content.b.a(imageView5.getContext(), R.drawable.mt_v4_wallet));
                            ImageView imageView6 = qVar3.f53820c;
                            ImageView imageView7 = this.f54790h;
                            if (imageView7 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            imageView6.setImageDrawable(androidx.core.content.b.a(imageView7.getContext(), R.drawable.mt_v4_wallet));
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        TextView textView5 = qVar3.j;
                        kotlin.g.b.k.a((Object) textView5, "receiverDetails.receiverName");
                        textView5.setText(net.one97.paytm.upi.f.a(userName2));
                        qVar3.f53820c.setImageDrawable((Drawable) null);
                        TextView textView6 = qVar3.f53822e;
                        kotlin.g.b.k.a((Object) textView6, "receiverDetails.contactInitials");
                        textView6.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(userName2)));
                        TextView textView7 = qVar3.f53821d;
                        kotlin.g.b.k.a((Object) textView7, "receiverDetails.bankName");
                        String accNoOrVpa3 = paymentUiModel2.getAccNoOrVpa();
                        if (accNoOrVpa3 != null) {
                            String lowerCase = accNoOrVpa3.toLowerCase();
                            kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            textView7.setText(lowerCase);
                            ImageView imageView8 = qVar3.f53820c;
                            kotlin.g.b.k.a((Object) imageView8, "receiverDetails.bankImageView");
                            b(imageView8);
                            ImageView imageView9 = this.f54790h;
                            if (imageView9 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            ImageView imageView10 = this.f54790h;
                            if (imageView10 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            m.a(imageView9, "upi", imageView10.getContext());
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    if (a8 != 10) {
                        ImageView imageView11 = this.f54790h;
                        if (imageView11 == null) {
                            kotlin.g.b.k.a("bankImage");
                        }
                        ImageView imageView12 = this.f54790h;
                        if (imageView12 == null) {
                            kotlin.g.b.k.a("bankImage");
                        }
                        m.a(imageView11, "upi", imageView12.getContext());
                        TextView textView8 = qVar3.f53821d;
                        kotlin.g.b.k.a((Object) textView8, "receiverDetails.bankName");
                        String accNoOrVpa4 = paymentUiModel2.getAccNoOrVpa();
                        if (accNoOrVpa4 != null) {
                            String lowerCase2 = accNoOrVpa4.toLowerCase();
                            kotlin.g.b.k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            textView8.setText(lowerCase2);
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } else {
                    net.one97.paytm.moneytransfer.c.q qVar4 = a7.f53770i;
                    kotlin.g.b.k.a((Object) qVar4, "binding.topPaymentCardLayout");
                    TextView textView9 = qVar4.j;
                    kotlin.g.b.k.a((Object) textView9, "receiverDetails.receiverName");
                    textView9.setText(net.one97.paytm.upi.f.a(paymentUiModel2.getUserName()));
                    String bankName2 = paymentUiModel2.getBankName();
                    if (!TextUtils.isEmpty(bankName2) && p.a(bankName2, "null", true)) {
                        bankName2 = "";
                    }
                    String accNoOrVpa5 = paymentUiModel2.getAccNoOrVpa();
                    TextView textView10 = qVar4.f53821d;
                    kotlin.g.b.k.a((Object) textView10, "receiverDetails.bankName");
                    StringBuilder sb = new StringBuilder();
                    sb.append(bankName2);
                    sb.append(" XX ");
                    int length = accNoOrVpa5.length() - 4;
                    if (accNoOrVpa5 != null) {
                        String substring2 = accNoOrVpa5.substring(length);
                        kotlin.g.b.k.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                        sb.append(substring2);
                        textView10.setText(sb.toString());
                        CharSequence imageUrl = paymentUiModel2.getImageUrl();
                        if (!(imageUrl == null || p.a(imageUrl))) {
                            qVar4.f53820c.setPadding(0, 0, 0, 0);
                            w.a().a(paymentUiModel2.getImageUrl()).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(qVar4.f53820c);
                        } else if (!TextUtils.isEmpty(paymentUiModel2.getUserName())) {
                            qVar4.f53820c.setImageDrawable((Drawable) null);
                            TextView textView11 = qVar4.f53822e;
                            kotlin.g.b.k.a((Object) textView11, "receiverDetails.contactInitials");
                            textView11.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(paymentUiModel2.getUserName())));
                            ImageView imageView13 = qVar4.f53820c;
                            kotlin.g.b.k.a((Object) imageView13, "receiverDetails.bankImageView");
                            b(imageView13);
                            ImageView imageView14 = this.f54790h;
                            if (imageView14 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            String ifsc2 = paymentUiModel2.getIfsc();
                            ImageView imageView15 = this.f54790h;
                            if (imageView15 == null) {
                                kotlin.g.b.k.a("bankImage");
                            }
                            m.a(imageView14, ifsc2, imageView15.getContext());
                        } else {
                            m.a(qVar4.f53820c, paymentUiModel2.getIfsc(), getContext());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
            } else {
                Uri uri = this.m;
                if (uri != null) {
                    if (uri != null) {
                        Uri parse = Uri.parse(m.i(uri.toString()));
                        String queryParameter = parse != null ? parse.getQueryParameter("pa") : null;
                        Uri uri2 = this.m;
                        String queryParameter2 = uri2 != null ? uri2.getQueryParameter("pn") : null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                            String decode = URLDecoder.decode(queryParameter, AppConstants.UTF_8);
                            kotlin.g.b.k.a((Object) decode, "uriVPAOrAccount");
                            if (p.c(decode, ".ifsc.npci", true)) {
                                CharSequence charSequence2 = decode;
                                String substring3 = decode.substring(p.a(charSequence2, "@", 0, false, 6) + 1, p.a(charSequence2, ".ifsc.npci", 0, false, 6));
                                kotlin.g.b.k.a((Object) substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                String substring4 = decode.substring(0, p.a(charSequence2, "@", 0, false, 6));
                                kotlin.g.b.k.a((Object) substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                TextView textView12 = this.f54789g;
                                if (textView12 == null) {
                                    kotlin.g.b.k.a("bankNameTV");
                                }
                                aa aaVar = aa.f47921a;
                                String string = getString(R.string.money_transfer_acc_no_with_placeholder_without_bold, UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(substring4), 4));
                                kotlin.g.b.k.a((Object) string, "getString(R.string.money…umber(accountNumber), 4))");
                                String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                                textView12.setText(format);
                                ImageView imageView16 = this.f54790h;
                                if (imageView16 == null) {
                                    kotlin.g.b.k.a("bankImage");
                                }
                                m.a(imageView16, substring3, (Context) getActivity());
                            } else {
                                TextView textView13 = this.f54789g;
                                if (textView13 == null) {
                                    kotlin.g.b.k.a("bankNameTV");
                                }
                                textView13.setText(decode);
                                ImageView imageView17 = this.f54790h;
                                if (imageView17 == null) {
                                    kotlin.g.b.k.a("bankImage");
                                }
                                ImageView imageView18 = this.f54790h;
                                if (imageView18 == null) {
                                    kotlin.g.b.k.a("bankImage");
                                }
                                m.a(imageView17, "upi", imageView18.getContext());
                            }
                        }
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            String l2 = m.l(queryParameter2);
                            net.one97.paytm.moneytransfer.c.j jVar = this.o;
                            if (jVar != null) {
                                TextView textView14 = jVar.f53770i.j;
                                kotlin.g.b.k.a((Object) textView14, "topPaymentCardLayout.receiverName");
                                textView14.setText(l2);
                                jVar.f53770i.f53820c.setImageDrawable((Drawable) null);
                                TextView textView15 = jVar.f53770i.f53822e;
                                kotlin.g.b.k.a((Object) textView15, "topPaymentCardLayout.contactInitials");
                                textView15.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(l2)));
                                ImageView imageView19 = jVar.f53770i.f53820c;
                                kotlin.g.b.k.a((Object) imageView19, "topPaymentCardLayout.bankImageView");
                                b(imageView19);
                            }
                        }
                    }
                } else if (this.n != null) {
                    net.one97.paytm.moneytransfer.c.j jVar2 = this.o;
                    if (jVar2 != null) {
                        TextView textView16 = jVar2.f53770i.j;
                        kotlin.g.b.k.a((Object) textView16, "topPaymentCardLayout.receiverName");
                        PaymentManager.PaymentUICollectRequestModel paymentUICollectRequestModel2 = this.n;
                        textView16.setText(paymentUICollectRequestModel2 != null ? paymentUICollectRequestModel2.getName() : null);
                        str = null;
                        jVar2.f53770i.f53820c.setImageDrawable((Drawable) null);
                        TextView textView17 = jVar2.f53770i.f53822e;
                        kotlin.g.b.k.a((Object) textView17, "topPaymentCardLayout.contactInitials");
                        PaymentManager.PaymentUICollectRequestModel paymentUICollectRequestModel3 = this.n;
                        textView17.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(paymentUICollectRequestModel3 != null ? paymentUICollectRequestModel3.getName() : null)));
                        ImageView imageView20 = jVar2.f53770i.f53820c;
                        kotlin.g.b.k.a((Object) imageView20, "topPaymentCardLayout.bankImageView");
                        b(imageView20);
                    } else {
                        str = null;
                    }
                    TextView textView18 = this.f54789g;
                    if (textView18 == null) {
                        kotlin.g.b.k.a("bankNameTV");
                    }
                    PaymentManager.PaymentUICollectRequestModel paymentUICollectRequestModel4 = this.n;
                    textView18.setText(paymentUICollectRequestModel4 != null ? paymentUICollectRequestModel4.getPayeeVpa() : str);
                    ImageView imageView21 = this.f54790h;
                    if (imageView21 == null) {
                        kotlin.g.b.k.a("bankImage");
                    }
                    ImageView imageView22 = this.f54790h;
                    if (imageView22 == null) {
                        kotlin.g.b.k.a("bankImage");
                    }
                    m.a(imageView21, "upi", imageView22.getContext());
                }
            }
        } else if (paymentFlow3 != null) {
            PaymentFlow.PaymentCombination paymentCombination3 = (PaymentFlow.PaymentCombination) paymentFlow3;
            if (!(paymentCombination3 == null || (data = paymentCombination3.getData()) == null || (receiverInfo = data.getReceiverInfo()) == null)) {
                if (!TextUtils.isEmpty(receiverInfo.getName())) {
                    TextView textView19 = qVar2.j;
                    kotlin.g.b.k.a((Object) textView19, "receiverDetails.receiverName");
                    textView19.setText(net.one97.paytm.upi.f.a(receiverInfo.getName()));
                } else if (!TextUtils.isEmpty(receiverInfo.getContactName())) {
                    TextView textView20 = qVar2.j;
                    kotlin.g.b.k.a((Object) textView20, "receiverDetails.receiverName");
                    textView20.setText(net.one97.paytm.upi.f.a(receiverInfo.getContactName()));
                } else {
                    TextView textView21 = qVar2.j;
                    kotlin.g.b.k.a((Object) textView21, "receiverDetails.receiverName");
                    textView21.setText(getString(R.string.mt_v4_default_contact_name, receiverInfo.getPhoneNumber()));
                }
                qVar2.f53820c.setPadding(0, 0, 0, 0);
                if (!TextUtils.isEmpty(receiverInfo.getPicture())) {
                    w.a().a(receiverInfo.getPicture()).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(qVar2.f53820c);
                } else if (!TextUtils.isEmpty(receiverInfo.getName()) && !TextUtils.isEmpty(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(receiverInfo.getName())))) {
                    qVar2.f53820c.setImageDrawable((Drawable) null);
                    ImageView imageView23 = qVar2.f53820c;
                    kotlin.g.b.k.a((Object) imageView23, "receiverDetails.bankImageView");
                    b(imageView23);
                    TextView textView22 = qVar2.f53822e;
                    kotlin.g.b.k.a((Object) textView22, "receiverDetails.contactInitials");
                    textView22.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(receiverInfo.getName())));
                } else if (TextUtils.isEmpty(receiverInfo.getContactName()) || TextUtils.isEmpty(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(receiverInfo.getContactName())))) {
                    ImageView imageView24 = qVar2.f53820c;
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        kotlin.g.b.k.a();
                    }
                    imageView24.setImageDrawable(androidx.core.content.b.a((Context) activity2, R.drawable.paytm_logo_money_transfer));
                } else {
                    qVar2.f53820c.setImageDrawable((Drawable) null);
                    TextView textView23 = qVar2.f53822e;
                    kotlin.g.b.k.a((Object) textView23, "receiverDetails.contactInitials");
                    textView23.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(receiverInfo.getContactName())));
                    ImageView imageView25 = qVar2.f53820c;
                    kotlin.g.b.k.a((Object) imageView25, "receiverDetails.bankImageView");
                    b(imageView25);
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.PaymentFlow.PaymentCombination");
        }
        a().f53770i.f53818a.setOnClickListener(new d(this));
        a().f53770i.f53826i.setOnClickListener(new e(this));
        a().f53769h.addOnLayoutChangeListener(new f(this));
        BottomSheetBehavior from2 = BottomSheetBehavior.from(a().f53764c);
        if (from2 != null) {
            LockableBottomSheetBehavior lockableBottomSheetBehavior = (LockableBottomSheetBehavior) from2;
            c cVar3 = this.f54787e;
            if (cVar3 == null) {
                kotlin.g.b.k.a("beneficiaryHistoryViewModel");
            }
            lockableBottomSheetBehavior.f54778a = cVar3.a();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.LockableBottomSheetBehavior<android.widget.FrameLayout!>");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54794a;

        d(a aVar) {
            this.f54794a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f54794a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54795a;

        e(a aVar) {
            this.f54795a = aVar;
        }

        public final void onClick(View view) {
            a aVar = this.f54795a;
            kotlin.g.b.k.a((Object) aVar.a().f53770i.f53826i, "binding.topPaymentCardLayout.options");
            a.b(aVar);
        }
    }

    public static final class f implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54796a;

        f(a aVar) {
            this.f54796a = aVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (i5 != i9 || i3 != i7) {
                BottomSheetBehavior from = BottomSheetBehavior.from(this.f54796a.a().f53764c);
                if (from != null) {
                    ((LockableBottomSheetBehavior) from).f54778a = i5 >= i9 && a.d(this.f54796a).a();
                    FrameLayout frameLayout = this.f54796a.a().f53764c;
                    kotlin.g.b.k.a((Object) frameLayout, "binding.bottomSheetLayout");
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    CoordinatorLayout coordinatorLayout = this.f54796a.a().f53769h;
                    kotlin.g.b.k.a((Object) coordinatorLayout, "binding.rootCoordinatorLayout");
                    int height = coordinatorLayout.getHeight();
                    AppBarLayout appBarLayout = this.f54796a.a().f53762a;
                    kotlin.g.b.k.a((Object) appBarLayout, "binding.appBarLayout");
                    layoutParams.height = height - appBarLayout.getHeight();
                    if (i5 < i9) {
                        net.one97.paytm.moneytransferv4.home.presentation.a.b e2 = a.e(this.f54796a);
                        NestedScrollView nestedScrollView = e2.f55445h;
                        if (nestedScrollView == null) {
                            kotlin.g.b.k.a("amountScrollView");
                        }
                        nestedScrollView.post(new b.j(e2));
                        e2.a(false);
                    }
                    FrameLayout frameLayout2 = this.f54796a.a().f53764c;
                    kotlin.g.b.k.a((Object) frameLayout2, "binding.bottomSheetLayout");
                    frameLayout2.setLayoutParams(layoutParams);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.LockableBottomSheetBehavior<android.widget.FrameLayout!>");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(ImageView imageView) {
        int[] c2 = m.c();
        kotlin.g.b.k.a((Object) c2, "MoneyTransferUtils.getColorArray()");
        int a2 = kotlin.a.f.a(c2, (kotlin.i.c) kotlin.i.c.f47937b);
        Drawable background = imageView.getBackground();
        if (background instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setStroke(0, a2);
            gradientDrawable.setColor(a2);
        }
    }

    public static final class b extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54792a;

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "p0");
        }

        b(a aVar) {
            this.f54792a = aVar;
        }

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "p0");
            if (i2 == 4) {
                net.one97.paytm.moneytransferv4.home.presentation.a.b e2 = a.e(this.f54792a);
                ConstraintLayout constraintLayout = e2.j;
                if (constraintLayout == null) {
                    kotlin.g.b.k.a("pullDownLayout");
                }
                net.one97.paytm.upi.f.a((View) constraintLayout);
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = e2.f55443f;
                if (cVar != null) {
                    l.a aVar = l.f54175a;
                    Application application = cVar.getApplication();
                    kotlin.g.b.k.a((Object) application, "getApplication()");
                    com.paytm.b.a.a a2 = l.a.a(application);
                    a2.a("mt_pull_down_count", a2.b("mt_pull_down_count", 0, false) + 1, false);
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f54793a;

        c(BottomSheetBehavior bottomSheetBehavior) {
            this.f54793a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f54793a.setState(3);
        }
    }

    public final void onDestroyView() {
        this.o = null;
        super.onDestroyView();
        c();
    }

    public final void a(PaymentOptionItem paymentOptionItem) {
        String str;
        TextView textView;
        kotlin.g.b.k.c(paymentOptionItem, "paymentOptionItem");
        String str2 = null;
        if (!TextUtils.isEmpty(paymentOptionItem.getDestinationDisplayMessage())) {
            textView = this.f54789g;
            if (textView == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            str = paymentOptionItem.getDestinationDisplayMessage();
        } else {
            textView = this.f54789g;
            if (textView == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            DestinationPayment destinationPayment = paymentOptionItem.getDestinationPayment();
            str = destinationPayment != null ? destinationPayment.getVpaId() : null;
        }
        textView.setText(str);
        if (kotlin.g.b.k.a((Object) "UPI-WALLET", (Object) paymentOptionItem.getCombinationName())) {
            ImageView imageView = this.f54790h;
            if (imageView == null) {
                kotlin.g.b.k.a("bankImage");
            }
            ImageView imageView2 = this.f54790h;
            if (imageView2 == null) {
                kotlin.g.b.k.a("bankImage");
            }
            imageView.setImageDrawable(androidx.core.content.b.a(imageView2.getContext(), R.drawable.mt_v4_wallet));
        } else {
            DestinationPayment destinationPayment2 = paymentOptionItem.getDestinationPayment();
            if (destinationPayment2 != null) {
                str2 = destinationPayment2.getIfscCode();
            }
            if (str2 != null) {
                ImageView imageView3 = this.f54790h;
                if (imageView3 == null) {
                    kotlin.g.b.k.a("bankImage");
                }
                DestinationPayment destinationPayment3 = paymentOptionItem.getDestinationPayment();
                if (destinationPayment3 == null) {
                    kotlin.g.b.k.a();
                }
                String ifscCode = destinationPayment3.getIfscCode();
                ImageView imageView4 = this.f54790h;
                if (imageView4 == null) {
                    kotlin.g.b.k.a("bankImage");
                }
                m.a(imageView3, ifscCode, imageView4.getContext());
            } else {
                ImageView imageView5 = this.f54790h;
                if (imageView5 == null) {
                    kotlin.g.b.k.a("bankImage");
                }
                ImageView imageView6 = this.f54790h;
                if (imageView6 == null) {
                    kotlin.g.b.k.a("bankImage");
                }
                m.a(imageView5, "upi", imageView6.getContext());
            }
        }
        a(paymentOptionItem.getReceiverDisplayInformation());
    }

    public final void a(PaymentOptionItem paymentOptionItem, ReceiverInfo receiverInfo) {
        kotlin.g.b.k.c(paymentOptionItem, "paymentOptionItem");
        kotlin.g.b.k.c(receiverInfo, "receiverInfo");
        if (!TextUtils.isEmpty(paymentOptionItem.getDestinationDisplayMessage())) {
            TextView textView = this.f54789g;
            if (textView == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            textView.setText(paymentOptionItem.getDestinationDisplayMessage());
        } else {
            TextView textView2 = this.f54789g;
            if (textView2 == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            textView2.setText(getString(R.string.mt_v4_paytm_bank_linked, receiverInfo.getPhoneNumber()));
        }
        DestinationPayment destinationPayment = paymentOptionItem.getDestinationPayment();
        String str = null;
        if (kotlin.g.b.k.a((Object) "PYTM0123456", (Object) destinationPayment != null ? destinationPayment.getIfscCode() : null)) {
            ImageView imageView = this.f54790h;
            if (imageView == null) {
                kotlin.g.b.k.a("bankImage");
            }
            DestinationPayment destinationPayment2 = paymentOptionItem.getDestinationPayment();
            if (destinationPayment2 != null) {
                str = destinationPayment2.getIfscCode();
            }
            ImageView imageView2 = this.f54790h;
            if (imageView2 == null) {
                kotlin.g.b.k.a("bankImage");
            }
            m.a(imageView, str, imageView2.getContext());
        } else {
            ImageView imageView3 = this.f54790h;
            if (imageView3 == null) {
                kotlin.g.b.k.a("bankImage");
            }
            DestinationPayment destinationPayment3 = paymentOptionItem.getDestinationPayment();
            if (destinationPayment3 != null) {
                str = destinationPayment3.getIfscCode();
            }
            ImageView imageView4 = this.f54790h;
            if (imageView4 == null) {
                kotlin.g.b.k.a("bankImage");
            }
            m.a(imageView3, str, imageView4.getContext());
        }
        a(paymentOptionItem.getReceiverDisplayInformation());
    }

    public final void a(ReceiverInfo receiverInfo, PaymentOptionItem paymentOptionItem) {
        kotlin.g.b.k.c(receiverInfo, "receiverInfo");
        kotlin.g.b.k.c(paymentOptionItem, "paymentOptionItem");
        if (!TextUtils.isEmpty(paymentOptionItem.getDestinationDisplayMessage())) {
            TextView textView = this.f54789g;
            if (textView == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            textView.setText(paymentOptionItem.getDestinationDisplayMessage());
        } else {
            TextView textView2 = this.f54789g;
            if (textView2 == null) {
                kotlin.g.b.k.a("bankNameTV");
            }
            textView2.setText(getString(R.string.mt_v4_paytm_wallet_linked, receiverInfo.getPhoneNumber()));
        }
        ImageView imageView = this.f54790h;
        if (imageView == null) {
            kotlin.g.b.k.a("bankImage");
        }
        ImageView imageView2 = this.f54790h;
        if (imageView2 == null) {
            kotlin.g.b.k.a("bankImage");
        }
        imageView.setImageDrawable(androidx.core.content.b.a(imageView2.getContext(), R.drawable.mt_v4_wallet));
        a(paymentOptionItem.getReceiverDisplayInformation());
    }

    private final void a(SenderDisplayInformation senderDisplayInformation) {
        if (senderDisplayInformation != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            Object systemService = context.getSystemService("layout_inflater");
            if (systemService != null) {
                View inflate = ((LayoutInflater) systemService).inflate(R.layout.mt_v4_tooltip, (ViewGroup) null);
                net.one97.paytm.moneytransfer.c.al a2 = net.one97.paytm.moneytransfer.c.al.a(inflate);
                kotlin.g.b.k.a((Object) a2, "MtV4TooltipBinding.bind(customView)");
                a2.f53680d.setTooltipPosition(TooltipView.a.TOP);
                TooltipView tooltipView = a2.f53680d;
                Resources resources = getResources();
                kotlin.g.b.k.a((Object) resources, "resources");
                tooltipView.setArrowPosition(resources.getDisplayMetrics().widthPixels / 2, getResources().getDimensionPixelOffset(R.dimen.dimen_16dp));
                if (this.r != null) {
                    PopupWindow popupWindow = this.r;
                    if (popupWindow == null) {
                        kotlin.g.b.k.a("mPopupWindow");
                    }
                    if (popupWindow.isShowing()) {
                        PopupWindow popupWindow2 = this.r;
                        if (popupWindow2 == null) {
                            kotlin.g.b.k.a("mPopupWindow");
                        }
                        popupWindow2.dismiss();
                    }
                }
                this.r = new PopupWindow(inflate, b(), -2);
                a2.f53677a.setOnClickListener(new h(this, senderDisplayInformation));
                TextView textView = a2.f53678b;
                kotlin.g.b.k.a((Object) textView, "heading");
                textView.setText(senderDisplayInformation.getHeading());
                TextView textView2 = a2.f53679c;
                kotlin.g.b.k.a((Object) textView2, "message");
                textView2.setText(senderDisplayInformation.getDisplayMessage());
                if (!TextUtils.isEmpty(senderDisplayInformation.getCtaText())) {
                    TextView textView3 = a2.f53677a;
                    kotlin.g.b.k.a((Object) textView3, "ctaLink");
                    textView3.setText(senderDisplayInformation.getCtaText());
                }
                PopupWindow popupWindow3 = this.r;
                if (popupWindow3 == null) {
                    kotlin.g.b.k.a("mPopupWindow");
                }
                popupWindow3.setBackgroundDrawable(new ColorDrawable(0));
                if (Build.VERSION.SDK_INT >= 21) {
                    PopupWindow popupWindow4 = this.r;
                    if (popupWindow4 == null) {
                        kotlin.g.b.k.a("mPopupWindow");
                    }
                    popupWindow4.setElevation(getResources().getDimension(R.dimen.dimen_4dp));
                }
                PopupWindow popupWindow5 = this.r;
                if (popupWindow5 == null) {
                    kotlin.g.b.k.a("mPopupWindow");
                }
                popupWindow5.setOutsideTouchable(true);
                PopupWindow popupWindow6 = this.r;
                if (popupWindow6 == null) {
                    kotlin.g.b.k.a("mPopupWindow");
                }
                popupWindow6.setFocusable(true);
                a().f53769h.post(new i(this, senderDisplayInformation));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54799a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SenderDisplayInformation f54800b;

        h(a aVar, SenderDisplayInformation senderDisplayInformation) {
            this.f54799a = aVar;
            this.f54800b = senderDisplayInformation;
        }

        public final void onClick(View view) {
            a aVar = this.f54799a;
            SenderDisplayInformation senderDisplayInformation = this.f54800b;
            a.a(aVar, senderDisplayInformation != null ? senderDisplayInformation.getCta() : null);
            a.g(this.f54799a).dismiss();
        }
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54801a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SenderDisplayInformation f54802b;

        i(a aVar, SenderDisplayInformation senderDisplayInformation) {
            this.f54801a = aVar;
            this.f54802b = senderDisplayInformation;
        }

        public final void run() {
            a.g(this.f54801a).showAtLocation(this.f54801a.a().f53769h, 8388659, this.f54801a.getResources().getDimensionPixelOffset(R.dimen.dimen_16dp), a.h(this.f54801a));
        }
    }

    private final int b() {
        Resources resources = getResources();
        kotlin.g.b.k.a((Object) resources, "resources");
        return resources.getDisplayMetrics().widthPixels - getResources().getDimensionPixelOffset(R.dimen.dimen_32dp);
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54797a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f54798b;

        public g(a aVar, String str) {
            this.f54797a = aVar;
            this.f54798b = str;
        }

        public final void run() {
            net.one97.paytm.moneytransfer.c.j i2;
            if (!TextUtils.isEmpty(this.f54798b) && (i2 = this.f54797a.o) != null) {
                TextView textView = i2.f53770i.j;
                kotlin.g.b.k.a((Object) textView, "topPaymentCardLayout.receiverName");
                textView.setText(this.f54798b);
                i2.f53770i.f53820c.setImageDrawable((Drawable) null);
                TextView textView2 = i2.f53770i.f53822e;
                kotlin.g.b.k.a((Object) textView2, "topPaymentCardLayout.contactInitials");
                textView2.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(this.f54798b)));
                ImageView imageView = i2.f53770i.f53820c;
                kotlin.g.b.k.a((Object) imageView, "topPaymentCardLayout.bankImageView");
                a.b(imageView);
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.a.a.a$a  reason: collision with other inner class name */
    public static final class C0982a {
        private C0982a() {
        }

        public /* synthetic */ C0982a(byte b2) {
            this();
        }

        public static a a(PaymentFlow paymentFlow) {
            kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("payment_flow", paymentFlow);
            aVar.setArguments(bundle);
            return aVar;
        }

        public static /* synthetic */ a a(PaymentManager.PaymentUiModel paymentUiModel, Activity activity, int i2) {
            return a((i2 & 1) != 0 ? new PaymentManager.PaymentUiModel((String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (kotlin.g.b.g) null) : paymentUiModel, (i2 & 2) != 0 ? null : activity, (BankAccountDetails.BankAccount) null, (String) null);
        }

        public static a a(PaymentManager.PaymentUiModel paymentUiModel, Activity activity, BankAccountDetails.BankAccount bankAccount, String str) {
            kotlin.g.b.k.c(paymentUiModel, "paymentUiModel");
            UpiAppUtils.hideKeyboard(activity);
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("payment_ui_model", paymentUiModel);
            bundle.putSerializable("bankAccount_object", bankAccount);
            bundle.putString("primary_vpa", str);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        String str;
        if (aVar.n != null) {
            Context requireContext = aVar.requireContext();
            PaymentManager.PaymentUICollectRequestModel paymentUICollectRequestModel = aVar.n;
            if (paymentUICollectRequestModel == null || (str = paymentUICollectRequestModel.getPayeeVpa()) == null) {
                str = "";
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.COLLECT, Events.Action.BACK_ARROW_CLICKED, "", "", "", str, "", Events.Screen.ENTER_AMOUNT, "");
        }
        FragmentActivity activity = aVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static final /* synthetic */ void b(a aVar) {
        if (aVar.isAdded() && aVar.isResumed()) {
            UpiAppUtils.hideKeyboard(aVar.getActivity());
            Bundle bundle = new Bundle();
            androidx.fragment.app.j childFragmentManager = aVar.getChildFragmentManager();
            BankAccountDetails.BankAccount bankAccount = aVar.q;
            if (bankAccount != null) {
                bundle.putSerializable("bankAccount_object", bankAccount);
                bundle.putString("primary_vpa", aVar.l);
                g.a aVar2 = net.one97.paytm.moneytransferv4.accountsbottomsheet.g.f55055b;
                net.one97.paytm.moneytransferv4.accountsbottomsheet.g gVar = new net.one97.paytm.moneytransferv4.accountsbottomsheet.g();
                gVar.setArguments(bundle);
                gVar.show(childFragmentManager, "");
                return;
            }
            PaymentManager.PaymentUiModel paymentUiModel = aVar.j;
            if (paymentUiModel != null) {
                bundle.putSerializable("payment_ui_model", paymentUiModel);
                f.a aVar3 = net.one97.paytm.moneytransferv4.accountsbottomsheet.f.f55044a;
                f.a.a(bundle).show(childFragmentManager, "");
            } else if (!TextUtils.isEmpty(aVar.k)) {
                bundle.putSerializable("payment_flow", aVar.f54791i);
                f.a aVar4 = net.one97.paytm.moneytransferv4.accountsbottomsheet.f.f55044a;
                f.a.a(bundle).show(childFragmentManager, "");
            } else {
                bundle.putSerializable("payment_flow", aVar.f54791i);
                f.a aVar5 = net.one97.paytm.moneytransferv4.accountsbottomsheet.f.f55044a;
                f.a.a(bundle).show(childFragmentManager, "");
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, net.one97.paytm.moneytransfer.model.c cVar) {
        Collection collection = (Collection) cVar.f54033b;
        if (collection == null || collection.isEmpty()) {
            LinearLayout linearLayout = aVar.a().f53766e;
            kotlin.g.b.k.a((Object) linearLayout, "binding.noHistoryLayout");
            net.one97.paytm.upi.f.b((View) linearLayout);
            RecyclerView recyclerView = aVar.a().f53763b;
            kotlin.g.b.k.a((Object) recyclerView, "binding.beneficiaryHistoryRecyclerView");
            net.one97.paytm.upi.f.a((View) recyclerView);
            TextView textView = aVar.a().f53767f;
            kotlin.g.b.k.a((Object) textView, "binding.noHistoryText");
            int i2 = R.string.mt_your_payment_history_will_be;
            TextView textView2 = aVar.a().f53770i.j;
            kotlin.g.b.k.a((Object) textView2, "binding.topPaymentCardLayout.receiverName");
            textView.setText(aVar.getString(i2, textView2.getText().toString()));
            net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = aVar.f54785a;
            if (bVar == null) {
                kotlin.g.b.k.a("paymentFragment");
            }
            bVar.c(false);
        } else {
            net.one97.paytm.moneytransferv4.home.presentation.a.b bVar2 = aVar.f54785a;
            if (bVar2 == null) {
                kotlin.g.b.k.a("paymentFragment");
            }
            c cVar2 = aVar.f54787e;
            if (cVar2 == null) {
                kotlin.g.b.k.a("beneficiaryHistoryViewModel");
            }
            bVar2.c(cVar2.a());
            LinearLayout linearLayout2 = aVar.a().f53766e;
            kotlin.g.b.k.a((Object) linearLayout2, "binding.noHistoryLayout");
            net.one97.paytm.upi.f.a((View) linearLayout2);
            RecyclerView recyclerView2 = aVar.a().f53763b;
            kotlin.g.b.k.a((Object) recyclerView2, "binding.beneficiaryHistoryRecyclerView");
            net.one97.paytm.upi.f.b((View) recyclerView2);
        }
        ResultType resulttype = cVar.f54033b;
        if (resulttype == null) {
            kotlin.g.b.k.a();
        }
        List list = (List) resulttype;
        e eVar = aVar.f54788f;
        if (eVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        eVar.f66589d = cVar.f54035d;
        e eVar2 = aVar.f54788f;
        if (eVar2 == null) {
            kotlin.g.b.k.a("adapter");
        }
        kotlin.g.b.k.c(list, "list");
        int size = eVar2.f54814a.size();
        eVar2.f54814a.addAll(list);
        eVar2.notifyItemRangeChanged(size, eVar2.f54814a.size());
    }

    public static final /* synthetic */ void f(a aVar) {
        Context context = aVar.getContext();
        if (context != null) {
            net.one97.paytm.upi.f.a(context, R.string.something_went_wrong, 0);
        }
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        if (aVar.getActivity() != null && !TextUtils.isEmpty(str)) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = aVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            Context context = activity;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            b2.a(context, str);
        }
    }

    public static final /* synthetic */ int h(a aVar) {
        AppBarLayout appBarLayout = aVar.a().f53762a;
        kotlin.g.b.k.a((Object) appBarLayout, "binding.appBarLayout");
        return appBarLayout.getHeight() + aVar.getResources().getDimensionPixelOffset(R.dimen.dimen_25dp);
    }
}
