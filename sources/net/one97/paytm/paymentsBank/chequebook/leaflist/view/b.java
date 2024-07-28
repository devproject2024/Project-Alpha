package net.one97.paytm.paymentsBank.chequebook.leaflist.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.leaflist.a;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;

public final class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17647a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f17648b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.chequebook.leaflist.b f17649c;

    /* renamed from: d  reason: collision with root package name */
    private int f17650d = -1;

    /* renamed from: e  reason: collision with root package name */
    private a.e f17651e;

    /* renamed from: f  reason: collision with root package name */
    private final z<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> f17652f = new c(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f17653g;

    public final View a(int i2) {
        if (this.f17653g == null) {
            this.f17653g = new HashMap();
        }
        View view = (View) this.f17653g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17653g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17655a;

        c(b bVar) {
            this.f17655a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.paymentsBank.chequebook.c cVar;
            net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
            String str = null;
            if (bVar != null) {
                cVar = bVar.f17486a;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int i2 = c.f17656a[cVar.ordinal()];
                if (i2 == 1) {
                    AppCompatButton appCompatButton = (AppCompatButton) this.f17655a.a(R.id.cb_stop_payment_proceed);
                    k.a((Object) appCompatButton, "cb_stop_payment_proceed");
                    appCompatButton.setClickable(true);
                    TextView textView = (TextView) this.f17655a.a(R.id.cb_stop_payment_cancel_tv);
                    k.a((Object) textView, "cb_stop_payment_cancel_tv");
                    textView.setClickable(true);
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17655a.a(R.id.wallet_loader));
                    CbStopPaymentResponse cbStopPaymentResponse = (CbStopPaymentResponse) bVar.f17487b;
                    if (!TextUtils.isEmpty(cbStopPaymentResponse != null ? cbStopPaymentResponse.getMessage() : null)) {
                        View view = this.f17655a.getView();
                        if (view == null) {
                            k.a();
                        }
                        CbStopPaymentResponse cbStopPaymentResponse2 = (CbStopPaymentResponse) bVar.f17487b;
                        if (cbStopPaymentResponse2 != null) {
                            str = cbStopPaymentResponse2.getMessage();
                        }
                        if (str == null) {
                            k.a();
                        }
                        Snackbar.a(view, (CharSequence) str, -1).c();
                    }
                    b.a(this.f17655a);
                    this.f17655a.dismiss();
                } else if (i2 == 2) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17655a.a(R.id.wallet_loader));
                    View view2 = this.f17655a.getView();
                    if (view2 == null) {
                        k.a();
                    }
                    Snackbar.a(view2, (CharSequence) this.f17655a.getString(R.string.some_went_wrong), -1).c();
                    AppCompatButton appCompatButton2 = (AppCompatButton) this.f17655a.a(R.id.cb_stop_payment_proceed);
                    k.a((Object) appCompatButton2, "cb_stop_payment_proceed");
                    appCompatButton2.setClickable(true);
                    TextView textView2 = (TextView) this.f17655a.a(R.id.cb_stop_payment_cancel_tv);
                    k.a((Object) textView2, "cb_stop_payment_cancel_tv");
                    textView2.setClickable(true);
                } else if (i2 == 3) {
                    AppCompatButton appCompatButton3 = (AppCompatButton) this.f17655a.a(R.id.cb_stop_payment_proceed);
                    k.a((Object) appCompatButton3, "cb_stop_payment_proceed");
                    appCompatButton3.setClickable(false);
                    TextView textView3 = (TextView) this.f17655a.a(R.id.cb_stop_payment_cancel_tv);
                    k.a((Object) textView3, "cb_stop_payment_cancel_tv");
                    textView3.setClickable(false);
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f17655a.a(R.id.wallet_loader));
                }
            }
        }
    }

    public static final /* synthetic */ a.e a(b bVar) {
        a.e eVar = bVar.f17651e;
        if (eVar == null) {
            k.a("listener");
        }
        return eVar;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.cb_stop_payment_cancel_tv;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            return;
        }
        int i3 = R.id.cb_stop_payment_proceed;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent(getActivity(), BankPasscodeActivity.class);
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", getString(R.string.stop_payment_cb));
            BankPasscodeActivity.a aVar2 = BankPasscodeActivity.r;
            intent.putExtra(BankPasscodeActivity.w, getString(R.string.cb_enter_pcode));
            intent.putExtra("r_token", true);
            startActivityForResult(intent, 121);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof CBListDetailsViewActivity) {
            this.f17651e = (a.e) context;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r2 == null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r2) {
        /*
            r1 = this;
            super.onCreate(r2)
            android.os.Bundle r2 = r1.getArguments()
            if (r2 == 0) goto L_0x0015
            net.one97.paytm.paymentsBank.chequebook.utils.e r0 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r0 = net.one97.paytm.paymentsBank.chequebook.utils.e.y()
            java.lang.String r2 = r2.getString(r0)
            if (r2 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r2 = ""
        L_0x0017:
            r1.f17648b = r2
            android.os.Bundle r2 = r1.getArguments()
            if (r2 == 0) goto L_0x002a
            net.one97.paytm.paymentsBank.chequebook.utils.e r0 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r0 = net.one97.paytm.paymentsBank.chequebook.utils.e.S()
            int r2 = r2.getInt(r0)
            goto L_0x002b
        L_0x002a:
            r2 = -1
        L_0x002b:
            r1.f17650d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.leaflist.view.b.onCreate(android.os.Bundle):void");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(C0277b.f17654a);
        return onCreateDialog;
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.view.b$b  reason: collision with other inner class name */
    static final class C0277b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C0277b f17654a = new C0277b();

        C0277b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) findViewById);
                    k.a((Object) from, "BottomSheetBehavior.from<View>(bottomSheet)");
                    from.setState(3);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.cb_stop_payment_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        this.f17649c = (net.one97.paytm.paymentsBank.chequebook.leaflist.b) net.one97.paytm.paymentsBank.chequebook.utils.b.a(this, net.one97.paytm.paymentsBank.chequebook.leaflist.b.class);
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.leaf_number_tv);
        k.a((Object) textView, "leaf_number_tv");
        String str = this.f17648b;
        if (str == null) {
            k.a("leafNumber");
        }
        textView.setText(str);
        View.OnClickListener onClickListener = this;
        ((TextView) a(R.id.cb_stop_payment_cancel_tv)).setOnClickListener(onClickListener);
        ((AppCompatButton) a(R.id.cb_stop_payment_proceed)).setOnClickListener(onClickListener);
        net.one97.paytm.paymentsBank.chequebook.leaflist.b bVar = this.f17649c;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.f17604c.observe(this, this.f17652f);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("passcode") : null;
            if (!TextUtils.isEmpty(stringExtra) && this.f17650d != -1) {
                net.one97.paytm.paymentsBank.chequebook.leaflist.b bVar = this.f17649c;
                if (bVar == null) {
                    k.a("viewModel");
                }
                if (stringExtra == null) {
                    k.a();
                }
                int i4 = this.f17650d;
                k.c(stringExtra, StringSet.token);
                bVar.f17603b = stringExtra;
                bVar.f17602a.setValue(Integer.valueOf(i4));
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17653g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
