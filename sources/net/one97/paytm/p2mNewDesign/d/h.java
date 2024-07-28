package net.one97.paytm.p2mNewDesign.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.p2mNewDesign.entity.Buttons;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.RetryInfo;
import net.one97.paytm.p2mNewDesign.f.i;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.wallet.R;

public final class h extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51178a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private RetryInfo f51179b;

    /* renamed from: c  reason: collision with root package name */
    private View f51180c;

    /* renamed from: d  reason: collision with root package name */
    private i f51181d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f51182e;

    public final View a(int i2) {
        if (this.f51182e == null) {
            this.f51182e = new HashMap();
        }
        View view = (View) this.f51182e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f51182e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f51179b = (RetryInfo) arguments.getSerializable(GAConstants.ACTION.RETRY);
        }
        View inflate = layoutInflater.inflate(R.layout.p2m_payment_retry_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        this.f51180c = inflate;
        View view = this.f51180c;
        if (view == null) {
            k.a("rootView");
        }
        return view;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            onCreateDialog.setCanceledOnTouchOutside(true);
        }
        if (onCreateDialog != null) {
            onCreateDialog.setOnShowListener(new b(this, onCreateDialog));
        }
        if (onCreateDialog == null) {
            k.a();
        }
        return onCreateDialog;
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f51183a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Dialog f51184b;

        b(h hVar, Dialog dialog) {
            this.f51183a = hVar;
            this.f51184b = dialog;
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById = this.f51184b.findViewById(R.id.touch_outside);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f51185a;

                    {
                        this.f51185a = r1;
                    }

                    public final void onClick(View view) {
                        View childAt;
                        if (((LinearLayout) this.f51185a.f51183a.a(R.id.btn_container)) != null) {
                            LinearLayout linearLayout = (LinearLayout) this.f51185a.f51183a.a(R.id.btn_container);
                            k.a((Object) linearLayout, "btn_container");
                            if (linearLayout.getChildCount() > 0 && (childAt = ((LinearLayout) this.f51185a.f51183a.a(R.id.btn_container)).getChildAt(0)) != null) {
                                childAt.startAnimation(AnimationUtils.loadAnimation(this.f51185a.f51183a.getContext(), R.anim.wallet_payment_retry_shake));
                            }
                        }
                    }
                });
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList<Buttons> buttons;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RetryInfo retryInfo = this.f51179b;
        if (retryInfo != null) {
            ((TextView) a(R.id.tv_header)).setText(retryInfo.getFailureHeader());
            ((TextView) a(R.id.tv_sub_header)).setText(retryInfo.getFailureMessage());
            RetryInfo retryInfo2 = this.f51179b;
            if (retryInfo2 != null) {
                String failureLogo = retryInfo2.getFailureLogo();
                if (failureLogo != null) {
                    if (TextUtils.isEmpty(failureLogo)) {
                        ImageView imageView = (ImageView) a(R.id.img_failure);
                        k.a((Object) imageView, "img_failure");
                        imageView.setVisibility(8);
                    } else {
                        ImageView imageView2 = (ImageView) a(R.id.img_failure);
                        k.a((Object) imageView2, "img_failure");
                        imageView2.setVisibility(0);
                        w.a().a(retryInfo2.getFailureLogo()).a((ImageView) a(R.id.img_failure));
                    }
                }
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f2, "DirectPaymentBl.getInstance()");
                InstrumentInfo l = f2.l();
                k.a((Object) l, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(getContext(), (ImageView) a(R.id.img_paymode), "", l.getPayMode());
            }
            RetryInfo retryInfo3 = this.f51179b;
            if (retryInfo3 != null && (buttons = retryInfo3.getButtons()) != null && (!buttons.isEmpty())) {
                int i2 = 0;
                for (Object next : buttons) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    Buttons buttons2 = (Buttons) next;
                    if (i2 == 0) {
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.p2m_positive_button, (LinearLayout) a(R.id.btn_container), false);
                        k.a((Object) inflate, "LayoutInflater.from(cont…on, btn_container, false)");
                        k.a((Object) buttons2, "button");
                        ((TextView) inflate.findViewById(R.id.btn_positive_txt)).setText(buttons2.getText());
                        ((TextView) inflate.findViewById(R.id.btn_positive_txt)).setTag(buttons2.getButtonAction());
                        ((TextView) inflate.findViewById(R.id.btn_positive_txt)).setOnClickListener(this);
                        ((LinearLayout) a(R.id.btn_container)).addView(inflate);
                    } else {
                        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.p2m_negative_button, (LinearLayout) a(R.id.btn_container), false);
                        k.a((Object) inflate2, "LayoutInflater.from(cont…on, btn_container, false)");
                        k.a((Object) buttons2, "button");
                        ((TextView) inflate2.findViewById(R.id.btn_negative_txt)).setText(buttons2.getText());
                        ((TextView) inflate2.findViewById(R.id.btn_negative_txt)).setTag(buttons2.getButtonAction());
                        View.OnClickListener onClickListener = this;
                        ((RelativeLayout) inflate2.findViewById(R.id.btn_negative)).setOnClickListener(onClickListener);
                        inflate2.setOnClickListener(onClickListener);
                        ((LinearLayout) a(R.id.btn_container)).addView(inflate2);
                    }
                    i2 = i3;
                }
            }
        }
    }

    public final void onClick(View view) {
        View childAt;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_positive_txt;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.btn_negative;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R.id.parentContainer;
                if (valueOf != null && valueOf.intValue() == i4 && ((LinearLayout) a(R.id.btn_container)) != null) {
                    LinearLayout linearLayout = (LinearLayout) a(R.id.btn_container);
                    k.a((Object) linearLayout, "btn_container");
                    if (linearLayout.getChildCount() > 0 && (childAt = ((LinearLayout) a(R.id.btn_container)).getChildAt(0)) != null) {
                        childAt.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wallet_payment_retry_shake));
                    }
                }
            } else if (((TextView) a(R.id.btn_negative_txt)).getTag() != null) {
                Object tag = ((TextView) a(R.id.btn_negative_txt)).getTag();
                if (tag != null) {
                    String str = (String) tag;
                    if (TextUtils.isEmpty(str) || !str.equals("PROCEED_TO_PAY")) {
                        b(false);
                        i iVar = this.f51181d;
                        if (iVar != null) {
                            RetryInfo retryInfo = this.f51179b;
                            if (retryInfo == null) {
                                k.a();
                            }
                            iVar.b(retryInfo);
                            return;
                        }
                        return;
                    }
                    b(true);
                    i iVar2 = this.f51181d;
                    if (iVar2 != null) {
                        RetryInfo retryInfo2 = this.f51179b;
                        if (retryInfo2 == null) {
                            k.a();
                        }
                        iVar2.a(retryInfo2);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        } else if (((TextView) a(R.id.btn_positive_txt)).getTag() != null) {
            Object tag2 = ((TextView) a(R.id.btn_positive_txt)).getTag();
            if (tag2 != null) {
                String str2 = (String) tag2;
                if (TextUtils.isEmpty(str2) || !str2.equals("PROCEED_TO_PAY")) {
                    a(false);
                    i iVar3 = this.f51181d;
                    if (iVar3 != null) {
                        RetryInfo retryInfo3 = this.f51179b;
                        if (retryInfo3 == null) {
                            k.a();
                        }
                        iVar3.b(retryInfo3);
                        return;
                    }
                    return;
                }
                a(true);
                i iVar4 = this.f51181d;
                if (iVar4 != null) {
                    RetryInfo retryInfo4 = this.f51179b;
                    if (retryInfo4 == null) {
                        k.a();
                    }
                    iVar4.a(retryInfo4);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (z) {
            ((TextView) a(R.id.btn_positive_txt)).setEnabled(false);
            ((TextView) a(R.id.btn_positive_txt)).setVisibility(8);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.p2m_positive_button_loader));
            ((RelativeLayout) a(R.id.payment_proceed_pay_btn_prefill_amount)).setBackgroundColor(getResources().getColor(R.color.grid_offer_blue));
            return;
        }
        ((TextView) a(R.id.btn_positive_txt)).setEnabled(true);
        ((TextView) a(R.id.btn_positive_txt)).setVisibility(0);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.p2m_positive_button_loader));
        ((RelativeLayout) a(R.id.payment_proceed_pay_btn_prefill_amount)).setBackground(getResources().getDrawable(R.drawable.rectangle_blue_filled));
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        if (z) {
            ((TextView) a(R.id.btn_negative_txt)).setEnabled(false);
            ((TextView) a(R.id.btn_negative_txt)).setVisibility(8);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.p2m_negative_button_loader));
            return;
        }
        ((TextView) a(R.id.btn_negative_txt)).setEnabled(true);
        ((TextView) a(R.id.btn_negative_txt)).setVisibility(0);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.p2m_negative_button_loader));
    }

    public final void onCancel(DialogInterface dialogInterface) {
        i iVar;
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        RetryInfo retryInfo = this.f51179b;
        if (retryInfo != null && (iVar = this.f51181d) != null) {
            iVar.b(retryInfo);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f51182e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final h a(RetryInfo retryInfo, i iVar) {
        k.c(retryInfo, "retryInfo");
        k.c(iVar, "paymentRetryListener");
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GAConstants.ACTION.RETRY, retryInfo);
        hVar.setArguments(bundle);
        hVar.setRetainInstance(true);
        hVar.f51181d = iVar;
        return hVar;
    }
}
