package net.one97.paytm.moneytransferv4.accountsbottomsheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.p2p.DestinationPayment;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.c.ai;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55044a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private PaymentManager.PaymentUiModel f55045b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f f55046c;

    /* renamed from: d  reason: collision with root package name */
    private View f55047d;

    /* renamed from: e  reason: collision with root package name */
    private CircularProgressBar f55048e;

    /* renamed from: f  reason: collision with root package name */
    private PaymentFlow f55049f;

    /* renamed from: g  reason: collision with root package name */
    private final int f55050g = 4;

    /* renamed from: h  reason: collision with root package name */
    private String f55051h = "";

    /* renamed from: i  reason: collision with root package name */
    private HashMap f55052i;

    static final class b<T> implements z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55053a;

        b(f fVar) {
            this.f55053a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r1 = r4.f54034c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.moneytransfer.model.c r4 = (net.one97.paytm.moneytransfer.model.c) r4
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r0 = r3.f55053a
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f.a(r0)
                net.one97.paytm.upi.common.UpiCustomVolleyError r0 = r4.f54034c
                if (r0 == 0) goto L_0x0071
                r0 = 0
                if (r4 == 0) goto L_0x0017
                net.one97.paytm.upi.common.UpiCustomVolleyError r1 = r4.f54034c
                if (r1 == 0) goto L_0x0017
                java.lang.String r1 = r1.getMessage()
                goto L_0x0018
            L_0x0017:
                r1 = r0
            L_0x0018:
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x002c
                if (r4 == 0) goto L_0x002b
                net.one97.paytm.upi.common.UpiCustomVolleyError r4 = r4.f54034c
                if (r4 == 0) goto L_0x002b
                java.lang.String r0 = r4.getAlertMessage()
            L_0x002b:
                r1 = r0
            L_0x002c:
                r4 = r1
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x004d
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r4 = r3.f55053a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.content.Context r4 = (android.content.Context) r4
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r0 = r3.f55053a
                android.content.res.Resources r0 = r0.getResources()
                int r2 = net.one97.paytm.moneytransfer.R.string.error
                java.lang.String r0 = r0.getString(r2)
                com.paytm.utility.b.a((android.content.Context) r4, (java.lang.String) r0, (java.lang.String) r1)
                return
            L_0x004d:
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r4 = r3.f55053a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.content.Context r4 = (android.content.Context) r4
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r0 = r3.f55053a
                android.content.res.Resources r0 = r0.getResources()
                int r1 = net.one97.paytm.moneytransfer.R.string.error
                java.lang.String r0 = r0.getString(r1)
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r1 = r3.f55053a
                android.content.res.Resources r1 = r1.getResources()
                int r2 = net.one97.paytm.moneytransfer.R.string.some_went_wrong
                java.lang.String r1 = r1.getString(r2)
                com.paytm.utility.b.a((android.content.Context) r4, (java.lang.String) r0, (java.lang.String) r1)
                return
            L_0x0071:
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f r4 = r3.f55053a
                net.one97.paytm.moneytransferv4.accountsbottomsheet.f.b(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.f.b.onChanged(java.lang.Object):void");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a(Bundle bundle) {
            f fVar = new f();
            fVar.setArguments(bundle);
            return fVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new c(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55054a;

        c(f fVar) {
            this.f55054a = fVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f55054a.getResources().getColor(R.color.transparent));
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String name;
        SourcePayment sourcePayment;
        LayoutInflater layoutInflater2 = layoutInflater;
        k.c(layoutInflater2, "inflater");
        View inflate = layoutInflater2.inflate(R.layout.mt_v4_payee_bottomsheet_fragment, viewGroup, false);
        ai a2 = ai.a(inflate);
        k.a((Object) a2, "MtV4PayeeBottomsheetFragmentBinding.bind(view)");
        androidx.lifecycle.ai a3 = am.a((Fragment) this).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f.class);
        k.a((Object) a3, "ViewModelProviders.of(th…eetViewModel::class.java)");
        this.f55046c = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f) a3;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f fVar = this.f55046c;
        if (fVar == null) {
            k.a("payeeBottomSheetViewModel");
        }
        fVar.f55646b.observe(this, new b(this));
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), CJRGTMConstants.MT_V4_PAYEE_BOTTOMSHEET_SCREEN_NAME);
        View.OnClickListener onClickListener = this;
        a2.p.setOnClickListener(onClickListener);
        a2.f53655d.setOnClickListener(onClickListener);
        ConstraintLayout constraintLayout = a2.f53655d;
        k.a((Object) constraintLayout, "deleteBeneficiaryContainer");
        this.f55047d = constraintLayout;
        CircularProgressBar circularProgressBar = a2.f53657f;
        k.a((Object) circularProgressBar, "deleteProgress");
        this.f55048e = circularProgressBar;
        a2.l.setOnClickListener(onClickListener);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        if (arguments.getSerializable("payment_ui_model") != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            Serializable serializable = arguments2.getSerializable("payment_ui_model");
            if (serializable != null) {
                this.f55045b = (PaymentManager.PaymentUiModel) serializable;
                PaymentManager.PaymentUiModel paymentUiModel = this.f55045b;
                if (paymentUiModel == null) {
                    k.a("paymentUiModel");
                }
                if (!TextUtils.isEmpty(paymentUiModel.getBeneficiaryId())) {
                    View view = this.f55047d;
                    if (view == null) {
                        k.a("deleteContainerView");
                    }
                    net.one97.paytm.upi.f.b(view);
                }
                PaymentManager.PaymentUiModel paymentUiModel2 = this.f55045b;
                if (paymentUiModel2 == null) {
                    k.a("paymentUiModel");
                }
                if (paymentUiModel2.isVpa()) {
                    PaymentManager.PaymentUiModel paymentUiModel3 = this.f55045b;
                    if (paymentUiModel3 == null) {
                        k.a("paymentUiModel");
                    }
                    TextView textView = a2.r;
                    k.a((Object) textView, "upiId");
                    aa aaVar = aa.f47921a;
                    String string = getString(R.string.money_transfer_upi_without_bold);
                    k.a((Object) string, "getString(R.string.money…ransfer_upi_without_bold)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{paymentUiModel3.getAccNoOrVpa()}, 1));
                    k.a((Object) format, "java.lang.String.format(format, *args)");
                    textView.setText(format);
                    TextView textView2 = a2.j;
                    k.a((Object) textView2, "name");
                    textView2.setText(net.one97.paytm.upi.f.a(paymentUiModel3.getUserName()));
                    TextView textView3 = a2.o;
                    k.a((Object) textView3, "requestMoney");
                    textView3.setText(getString(R.string.mt_v4_requestmoney, net.one97.paytm.upi.f.a(paymentUiModel3.getUserName())));
                    TextView textView4 = a2.f53654c;
                    k.a((Object) textView4, "deleteBeneficiary");
                    textView4.setText(getString(R.string.mt_v4_delete_saved_account, net.one97.paytm.upi.f.a(paymentUiModel3.getUserName())));
                    PaymentManager.PaymentUiModel paymentUiModel4 = this.f55045b;
                    if (paymentUiModel4 == null) {
                        k.a("paymentUiModel");
                    }
                    String imageUrl = paymentUiModel4.getImageUrl();
                    PaymentManager.PaymentUiModel paymentUiModel5 = this.f55045b;
                    if (paymentUiModel5 == null) {
                        k.a("paymentUiModel");
                    }
                    String ifsc = paymentUiModel5.getIfsc();
                    ImageView imageView = a2.f53659h;
                    k.a((Object) imageView, H5ResourceHandlerUtil.IMAGE);
                    PaymentManager.PaymentUiModel paymentUiModel6 = this.f55045b;
                    if (paymentUiModel6 == null) {
                        k.a("paymentUiModel");
                    }
                    a(imageUrl, ifsc, imageView, paymentUiModel6.getUserName(), a2.f53653b);
                } else {
                    TextView textView5 = a2.j;
                    k.a((Object) textView5, "name");
                    PaymentManager.PaymentUiModel paymentUiModel7 = this.f55045b;
                    if (paymentUiModel7 == null) {
                        k.a("paymentUiModel");
                    }
                    textView5.setText(net.one97.paytm.upi.f.a(paymentUiModel7.getUserName()));
                    TextView textView6 = a2.f53654c;
                    k.a((Object) textView6, "deleteBeneficiary");
                    int i2 = R.string.mt_v4_delete_saved_account;
                    Object[] objArr = new Object[1];
                    PaymentManager.PaymentUiModel paymentUiModel8 = this.f55045b;
                    if (paymentUiModel8 == null) {
                        k.a("paymentUiModel");
                    }
                    objArr[0] = net.one97.paytm.upi.f.a(paymentUiModel8.getUserName());
                    textView6.setText(getString(i2, objArr));
                    TextView textView7 = a2.r;
                    k.a((Object) textView7, "upiId");
                    aa aaVar2 = aa.f47921a;
                    String string2 = getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                    k.a((Object) string2, "getString(R.string.money…placeholder_without_bold)");
                    Object[] objArr2 = new Object[1];
                    PaymentManager.PaymentUiModel paymentUiModel9 = this.f55045b;
                    if (paymentUiModel9 == null) {
                        k.a("paymentUiModel");
                    }
                    objArr2[0] = UpiUtils.maskAccNumberWithSpace(UpiUtils.maskNumber(paymentUiModel9.getAccNoOrVpa()));
                    String format2 = String.format(string2, Arrays.copyOf(objArr2, 1));
                    k.a((Object) format2, "java.lang.String.format(format, *args)");
                    textView7.setText(format2);
                    TextView textView8 = a2.f53658g;
                    k.a((Object) textView8, "ifsc");
                    aa aaVar3 = aa.f47921a;
                    String string3 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                    k.a((Object) string3, "getString(R.string.money…placeholder_without_bold)");
                    Object[] objArr3 = new Object[1];
                    PaymentManager.PaymentUiModel paymentUiModel10 = this.f55045b;
                    if (paymentUiModel10 == null) {
                        k.a("paymentUiModel");
                    }
                    objArr3[0] = paymentUiModel10.getIfsc();
                    String format3 = String.format(string3, Arrays.copyOf(objArr3, 1));
                    k.a((Object) format3, "java.lang.String.format(format, *args)");
                    textView8.setText(format3);
                    ConstraintLayout constraintLayout2 = a2.p;
                    k.a((Object) constraintLayout2, "requestMoneyContainer");
                    net.one97.paytm.upi.f.a((View) constraintLayout2);
                    TextView textView9 = a2.f53658g;
                    k.a((Object) textView9, "ifsc");
                    net.one97.paytm.upi.f.b((View) textView9);
                    TextView textView10 = a2.f53653b;
                    k.a((Object) textView10, "contactInitials");
                    net.one97.paytm.upi.f.a((View) textView10);
                    PaymentManager.PaymentUiModel paymentUiModel11 = this.f55045b;
                    if (paymentUiModel11 == null) {
                        k.a("paymentUiModel");
                    }
                    String imageUrl2 = paymentUiModel11.getImageUrl();
                    PaymentManager.PaymentUiModel paymentUiModel12 = this.f55045b;
                    if (paymentUiModel12 == null) {
                        k.a("paymentUiModel");
                    }
                    String ifsc2 = paymentUiModel12.getIfsc();
                    ImageView imageView2 = a2.f53659h;
                    k.a((Object) imageView2, H5ResourceHandlerUtil.IMAGE);
                    PaymentManager.PaymentUiModel paymentUiModel13 = this.f55045b;
                    if (paymentUiModel13 == null) {
                        k.a("paymentUiModel");
                    }
                    a(imageUrl2, ifsc2, imageView2, paymentUiModel13.getUserName(), a2.f53653b);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.PaymentManager.PaymentUiModel");
            }
        } else {
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            if (arguments3.getSerializable("payment_flow") != null) {
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    k.a();
                }
                Serializable serializable2 = arguments4.getSerializable("payment_flow");
                if (serializable2 != null) {
                    this.f55049f = (PaymentFlow) serializable2;
                    PaymentFlow paymentFlow = this.f55049f;
                    if (paymentFlow == null) {
                        k.a(PayUtility.PAYMENT_FLOW);
                    }
                    String str2 = null;
                    if (!(paymentFlow instanceof PaymentFlow.PaymentCombination)) {
                        paymentFlow = null;
                    }
                    PaymentFlow.PaymentCombination paymentCombination = (PaymentFlow.PaymentCombination) paymentFlow;
                    PaymentCombinationAPIResponse data = paymentCombination != null ? paymentCombination.getData() : null;
                    if (data != null) {
                        List<PaymentOptionItem> paymentOptionList = data.getPaymentOptionList();
                        if (paymentOptionList == null) {
                            k.a();
                        }
                        Iterator<PaymentOptionItem> it2 = paymentOptionList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            PaymentOptionItem next = it2.next();
                            if (k.a((Object) "ENABLED", (Object) (next == null || (sourcePayment = next.getSourcePayment()) == null) ? null : sourcePayment.getPaymentInstrumentStatus())) {
                                DestinationPayment destinationPayment = next.getDestinationPayment();
                                CharSequence bankAccountNumber = destinationPayment != null ? destinationPayment.getBankAccountNumber() : null;
                                if (!(bankAccountNumber == null || bankAccountNumber.length() == 0)) {
                                    DestinationPayment destinationPayment2 = next.getDestinationPayment();
                                    ReceiverInfo receiverInfo = data.getReceiverInfo();
                                    TextView textView11 = a2.f53653b;
                                    k.a((Object) textView11, "contactInitials");
                                    net.one97.paytm.upi.f.a((View) textView11);
                                    ConstraintLayout constraintLayout3 = a2.p;
                                    k.a((Object) constraintLayout3, "requestMoneyContainer");
                                    net.one97.paytm.upi.f.a((View) constraintLayout3);
                                    ConstraintLayout constraintLayout4 = a2.f53655d;
                                    k.a((Object) constraintLayout4, "deleteBeneficiaryContainer");
                                    net.one97.paytm.upi.f.a((View) constraintLayout4);
                                    if (!(receiverInfo == null || (name = receiverInfo.getName()) == null)) {
                                        TextView textView12 = a2.j;
                                        k.a((Object) textView12, "name");
                                        textView12.setText(net.one97.paytm.upi.f.a(name));
                                    }
                                    TextView textView13 = a2.r;
                                    k.a((Object) textView13, "upiId");
                                    aa aaVar4 = aa.f47921a;
                                    String string4 = getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                                    k.a((Object) string4, "getString(R.string.money…placeholder_without_bold)");
                                    Object[] objArr4 = new Object[1];
                                    objArr4[0] = UpiUtils.maskAccNumberWithSpace(destinationPayment2 != null ? destinationPayment2.getBankAccountNumber() : null);
                                    String format4 = String.format(string4, Arrays.copyOf(objArr4, 1));
                                    k.a((Object) format4, "java.lang.String.format(format, *args)");
                                    textView13.setText(format4);
                                    TextView textView14 = a2.f53658g;
                                    k.a((Object) textView14, "ifsc");
                                    aa aaVar5 = aa.f47921a;
                                    String string5 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                                    k.a((Object) string5, "getString(R.string.money…placeholder_without_bold)");
                                    Object[] objArr5 = new Object[1];
                                    objArr5[0] = destinationPayment2 != null ? destinationPayment2.getIfscCode() : null;
                                    String format5 = String.format(string5, Arrays.copyOf(objArr5, 1));
                                    k.a((Object) format5, "java.lang.String.format(format, *args)");
                                    textView14.setText(format5);
                                    TextView textView15 = a2.f53658g;
                                    k.a((Object) textView15, "ifsc");
                                    net.one97.paytm.upi.f.b((View) textView15);
                                    String picture = receiverInfo != null ? receiverInfo.getPicture() : null;
                                    String ifscCode = destinationPayment2 != null ? destinationPayment2.getIfscCode() : null;
                                    ImageView imageView3 = a2.f53659h;
                                    k.a((Object) imageView3, H5ResourceHandlerUtil.IMAGE);
                                    a(picture, ifscCode, imageView3, receiverInfo != null ? receiverInfo.getName() : null, a2.f53653b);
                                    if (destinationPayment2 != null) {
                                        str2 = destinationPayment2.getBankAccountNumber();
                                    }
                                    String str3 = str2;
                                    if (str3 == null) {
                                        k.a();
                                    }
                                    this.f55051h = str3;
                                } else {
                                    DestinationPayment destinationPayment3 = next.getDestinationPayment();
                                    CharSequence vpaId = destinationPayment3 != null ? destinationPayment3.getVpaId() : null;
                                    if (!(vpaId == null || vpaId.length() == 0)) {
                                        DestinationPayment destinationPayment4 = next.getDestinationPayment();
                                        ReceiverInfo receiverInfo2 = data.getReceiverInfo();
                                        TextView textView16 = a2.r;
                                        k.a((Object) textView16, "upiId");
                                        textView16.setText(destinationPayment4 != null ? destinationPayment4.getVpaId() : null);
                                        if (!TextUtils.isEmpty(receiverInfo2 != null ? receiverInfo2.getName() : null)) {
                                            str = receiverInfo2 != null ? receiverInfo2.getName() : null;
                                            if (str == null) {
                                                k.a();
                                            }
                                        } else {
                                            if (!TextUtils.isEmpty(receiverInfo2 != null ? receiverInfo2.getContactName() : null)) {
                                                str = receiverInfo2 != null ? receiverInfo2.getContactName() : null;
                                                if (str == null) {
                                                    k.a();
                                                }
                                            } else {
                                                str = "";
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            TextView textView17 = a2.j;
                                            k.a((Object) textView17, "name");
                                            textView17.setText(net.one97.paytm.upi.f.a(str));
                                            TextView textView18 = a2.o;
                                            k.a((Object) textView18, "requestMoney");
                                            textView18.setText(getString(R.string.mt_v4_requestmoney, net.one97.paytm.upi.f.a(str)));
                                            TextView textView19 = a2.f53654c;
                                            k.a((Object) textView19, "deleteBeneficiary");
                                            textView19.setText(getString(R.string.mt_v4_delete_saved_account, net.one97.paytm.upi.f.a(str)));
                                        } else {
                                            ConstraintLayout constraintLayout5 = a2.p;
                                            k.a((Object) constraintLayout5, "requestMoneyContainer");
                                            net.one97.paytm.upi.f.a((View) constraintLayout5);
                                        }
                                        String picture2 = receiverInfo2 != null ? receiverInfo2.getPicture() : null;
                                        String ifscCode2 = destinationPayment4 != null ? destinationPayment4.getIfscCode() : null;
                                        ImageView imageView4 = a2.f53659h;
                                        k.a((Object) imageView4, H5ResourceHandlerUtil.IMAGE);
                                        a(picture2, ifscCode2, imageView4, receiverInfo2 != null ? receiverInfo2.getName() : null, a2.f53653b);
                                        if (destinationPayment4 != null) {
                                            str2 = destinationPayment4.getVpaId();
                                        }
                                        String str4 = str2;
                                        if (str4 == null) {
                                            k.a();
                                        }
                                        this.f55051h = str4;
                                    } else {
                                        DestinationPayment destinationPayment5 = next.getDestinationPayment();
                                        if (p.a(destinationPayment5 != null ? destinationPayment5.getPaymentType() : null, SDKConstants.AI_KEY_WALLET, true)) {
                                            DestinationPayment destinationPayment6 = next.getDestinationPayment();
                                            ReceiverInfo receiverInfo3 = data.getReceiverInfo();
                                            TextView textView20 = a2.r;
                                            k.a((Object) textView20, "upiId");
                                            textView20.setText(receiverInfo3 != null ? receiverInfo3.getPhoneNumber() : null);
                                            ConstraintLayout constraintLayout6 = a2.p;
                                            k.a((Object) constraintLayout6, "requestMoneyContainer");
                                            net.one97.paytm.upi.f.a((View) constraintLayout6);
                                            ConstraintLayout constraintLayout7 = a2.f53655d;
                                            k.a((Object) constraintLayout7, "deleteBeneficiaryContainer");
                                            net.one97.paytm.upi.f.a((View) constraintLayout7);
                                            if (!TextUtils.isEmpty(receiverInfo3 != null ? receiverInfo3.getName() : null)) {
                                                TextView textView21 = a2.j;
                                                k.a((Object) textView21, "name");
                                                textView21.setText(net.one97.paytm.upi.f.a(receiverInfo3 != null ? receiverInfo3.getName() : null));
                                                String picture3 = receiverInfo3 != null ? receiverInfo3.getPicture() : null;
                                                String ifscCode3 = destinationPayment6 != null ? destinationPayment6.getIfscCode() : null;
                                                ImageView imageView5 = a2.f53659h;
                                                k.a((Object) imageView5, H5ResourceHandlerUtil.IMAGE);
                                                if (receiverInfo3 != null) {
                                                    str2 = receiverInfo3.getName();
                                                }
                                                a(picture3, ifscCode3, imageView5, str2, a2.f53653b);
                                            } else {
                                                if (!TextUtils.isEmpty(receiverInfo3 != null ? receiverInfo3.getContactName() : null)) {
                                                    TextView textView22 = a2.j;
                                                    k.a((Object) textView22, "name");
                                                    textView22.setText(net.one97.paytm.upi.f.a(receiverInfo3 != null ? receiverInfo3.getContactName() : null));
                                                    String picture4 = receiverInfo3 != null ? receiverInfo3.getPicture() : null;
                                                    String ifscCode4 = destinationPayment6 != null ? destinationPayment6.getIfscCode() : null;
                                                    ImageView imageView6 = a2.f53659h;
                                                    k.a((Object) imageView6, H5ResourceHandlerUtil.IMAGE);
                                                    if (receiverInfo3 != null) {
                                                        str2 = receiverInfo3.getContactName();
                                                    }
                                                    a(picture4, ifscCode4, imageView6, str2, a2.f53653b);
                                                } else {
                                                    TextView textView23 = a2.j;
                                                    k.a((Object) textView23, "name");
                                                    net.one97.paytm.upi.f.c((View) textView23);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.PaymentFlow");
                }
            }
        }
        return inflate;
    }

    private final void a(String str, String str2, ImageView imageView, String str3, TextView textView) {
        boolean z = false;
        if (str != null) {
            if (!(str.length() == 0)) {
                int i2 = this.f55050g;
                imageView.setPadding(i2, i2, i2, i2);
                w.a().a(str).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(imageView);
                return;
            }
        }
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m.a(imageView, str2, getContext());
            return;
        }
        if (textView != null) {
            CharSequence charSequence2 = str3;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                imageView.setImageDrawable((Drawable) null);
                textView.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(str3)));
                return;
            }
        }
        imageView.setPadding(10, 10, 10, 10);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.paytm_logo_money_transfer));
    }

    public final void onClick(View view) {
        if (isAdded()) {
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i2 = R.id.requestMoneyContainer;
            if (valueOf != null && valueOf.intValue() == i2) {
                Intent intent = new Intent(getContext(), RequestMoneyV2Activity.class);
                if (this.f55045b != null) {
                    PaymentManager.PaymentUiModel paymentUiModel = this.f55045b;
                    if (paymentUiModel == null) {
                        k.a("paymentUiModel");
                    }
                    if (paymentUiModel.isVpa()) {
                        PaymentManager.PaymentUiModel paymentUiModel2 = this.f55045b;
                        if (paymentUiModel2 == null) {
                            k.a("paymentUiModel");
                        }
                        intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, paymentUiModel2.getAccNoOrVpa());
                        startActivity(intent);
                        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, CJRGTMConstants.MT_V4_PAYEE_BOTTOMSHEET_SCREEN_NAME, "", "");
                        dismiss();
                        return;
                    }
                }
                if (!(this.f55051h.length() == 0)) {
                    intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, this.f55051h);
                    startActivity(intent);
                    net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, CJRGTMConstants.MT_V4_PAYEE_BOTTOMSHEET_SCREEN_NAME, "", "");
                    dismiss();
                    return;
                }
                return;
            }
            int i3 = R.id.deleteBeneficiaryContainer;
            if (valueOf != null && valueOf.intValue() == i3) {
                CircularProgressBar circularProgressBar = this.f55048e;
                if (circularProgressBar == null) {
                    k.a("deleteProgressBar");
                }
                net.one97.paytm.upi.f.b((View) circularProgressBar);
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.f fVar = this.f55046c;
                if (fVar == null) {
                    k.a("payeeBottomSheetViewModel");
                }
                PaymentManager.PaymentUiModel paymentUiModel3 = this.f55045b;
                if (paymentUiModel3 == null) {
                    k.a("paymentUiModel");
                }
                k.c(paymentUiModel3, "paymentUiModel");
                fVar.f55645a.a((a.C0960a) new f.a(fVar), paymentUiModel3);
                net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_DELETE_BENEFICIARY_CLICKED, CJRGTMConstants.MT_V4_PAYEE_BOTTOMSHEET_SCREEN_NAME, "", "");
                return;
            }
            int i4 = R.id.needHelpContainer;
            if (valueOf != null && valueOf.intValue() == i4) {
                m.e((Activity) getActivity());
                net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_NEED_HELP_CLICKED, CJRGTMConstants.MT_V4_PAYEE_BOTTOMSHEET_SCREEN_NAME, "", "");
                dismiss();
            }
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        CircularProgressBar circularProgressBar = fVar.f55048e;
        if (circularProgressBar == null) {
            k.a("deleteProgressBar");
        }
        net.one97.paytm.upi.f.a((View) circularProgressBar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r0 = (r0 = r0.getSupportFragmentManager()).g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.moneytransferv4.accountsbottomsheet.f r7) {
        /*
            android.view.View r0 = r7.f55047d
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "deleteContainerView"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            net.one97.paytm.upi.f.a((android.view.View) r0)
            r7.dismiss()
            androidx.fragment.app.Fragment r7 = r7.getParentFragment()
            if (r7 == 0) goto L_0x00ac
            net.one97.paytm.moneytransferv4.a.a.a r7 = (net.one97.paytm.moneytransferv4.a.a.a) r7
            if (r7 == 0) goto L_0x00ab
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0031
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0031
            java.util.List r0 = r0.g()
            if (r0 == 0) goto L_0x0031
            int r0 = r0.size()
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            r2 = 1
            if (r0 <= r2) goto L_0x0047
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            if (r2 == 0) goto L_0x0044
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            if (r2 == 0) goto L_0x0044
            r2.e()
        L_0x0044:
            int r0 = r0 + -1
            goto L_0x0032
        L_0x0047:
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r3 = 0
            if (r0 == 0) goto L_0x0063
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.moneytransferv4.home.presentation.view.a$a r4 = net.one97.paytm.moneytransferv4.home.presentation.view.a.f55526c
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r4)
            goto L_0x0064
        L_0x0063:
            r0 = r3
        L_0x0064:
            androidx.fragment.app.FragmentActivity r4 = r7.getActivity()
            if (r4 == 0) goto L_0x0078
            r5 = r4
            android.content.Context r5 = (android.content.Context) r5
            int r6 = net.one97.paytm.moneytransfer.R.color.color_ffffff
            int r5 = androidx.core.content.b.c(r5, r6)
            android.app.Activity r4 = (android.app.Activity) r4
            com.paytm.utility.b.a((android.app.Activity) r4, (int) r5)
        L_0x0078:
            if (r0 == 0) goto L_0x0089
            net.one97.paytm.moneytransferv4.home.presentation.view.a r0 = (net.one97.paytm.moneytransferv4.home.presentation.view.a) r0
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r7 = r0.f55527a
            if (r7 != 0) goto L_0x0085
            java.lang.String r0 = "homeViewModel"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0085:
            r7.b()
            return
        L_0x0089:
            android.content.Context r0 = r7.getContext()
            if (r0 == 0) goto L_0x009b
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x009b
            net.one97.paytm.moneytransfer.utils.l$a r3 = net.one97.paytm.moneytransfer.utils.l.f54175a
            com.paytm.b.a.a r3 = net.one97.paytm.moneytransfer.utils.l.a.a(r0)
        L_0x009b:
            if (r3 == 0) goto L_0x00a2
            java.lang.String r0 = "isRefreshRequired"
            r3.a((java.lang.String) r0, (boolean) r2, (boolean) r1)
        L_0x00a2:
            androidx.fragment.app.FragmentActivity r7 = r7.getActivity()
            if (r7 == 0) goto L_0x00ab
            r7.finish()
        L_0x00ab:
            return
        L_0x00ac:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.moneytransferv4.beneficiary.history.BeneficiaryHistoryFragment"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.f.b(net.one97.paytm.moneytransferv4.accountsbottomsheet.f):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55052i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
