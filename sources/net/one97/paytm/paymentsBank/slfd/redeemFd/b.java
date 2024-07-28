package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public Button f19298a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19299b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19300c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19301d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19302e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19303f;

    /* renamed from: g  reason: collision with root package name */
    public String f19304g;

    /* renamed from: h  reason: collision with root package name */
    public String f19305h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f19306i;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("slfd_amount");
            if (string == null) {
                k.a();
            }
            this.f19304g = string;
            String string2 = arguments.getString("account_num");
            if (string2 == null) {
                string2 = "";
            }
            this.f19305h = string2;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fd_bottom_sheet, viewGroup, false);
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.btn_action);
            if (findViewById != null) {
                this.f19298a = (Button) findViewById;
                View findViewById2 = inflate.findViewById(R.id.iv_close);
                if (findViewById2 != null) {
                    this.f19299b = (ImageView) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.tv_confirm_amount);
                    if (findViewById3 != null) {
                        this.f19300c = (TextView) findViewById3;
                        View findViewById4 = inflate.findViewById(R.id.tv_fd_breakup);
                        if (findViewById4 != null) {
                            this.f19301d = (TextView) findViewById4;
                            View findViewById5 = inflate.findViewById(R.id.tv_desc_number);
                            if (findViewById5 != null) {
                                this.f19302e = (TextView) findViewById5;
                                View findViewById6 = inflate.findViewById(R.id.tv_redeem_note);
                                if (findViewById6 != null) {
                                    this.f19303f = (TextView) findViewById6;
                                    View findViewById7 = inflate.findViewById(R.id.small_divider);
                                    k.a((Object) findViewById7, "it.findViewById<View>(R.id.small_divider)");
                                    net.one97.paytm.paymentsBank.slfd.b.a.b.a(findViewById7);
                                    TextView textView = this.f19301d;
                                    if (textView == null) {
                                        k.a("tvViewFdBreakup");
                                    }
                                    net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView);
                                    TextView textView2 = this.f19303f;
                                    if (textView2 == null) {
                                        k.a("tvTdsNote");
                                    }
                                    net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView2);
                                    String str2 = this.f19304g;
                                    if (str2 == null) {
                                        k.a("amount");
                                    }
                                    TextView textView3 = this.f19300c;
                                    if (textView3 == null) {
                                        k.a("tvAmount");
                                    }
                                    e.a(str2, textView3);
                                    TextView textView4 = this.f19302e;
                                    if (textView4 == null) {
                                        k.a("tvBankAcc");
                                    }
                                    FragmentActivity activity = getActivity();
                                    if (activity != null) {
                                        int i2 = R.string.fd_saving_account_no;
                                        Object[] objArr = new Object[1];
                                        String str3 = this.f19305h;
                                        if (str3 == null) {
                                            k.a("accountNo");
                                        }
                                        objArr[0] = str3;
                                        str = activity.getString(i2, objArr);
                                    } else {
                                        str = null;
                                    }
                                    textView4.setText(str);
                                    ImageView imageView = this.f19299b;
                                    if (imageView == null) {
                                        k.a("ivClose");
                                    }
                                    imageView.setOnClickListener(new a(this));
                                    Button button = this.f19298a;
                                    if (button == null) {
                                        k.a("btnProceed");
                                    }
                                    button.setOnClickListener(new C0342b(this));
                                    TextView textView5 = this.f19301d;
                                    if (textView5 == null) {
                                        k.a("tvViewFdBreakup");
                                    }
                                    textView5.setOnClickListener(new c(this));
                                } else {
                                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.Button");
            }
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(d.f19310a);
        }
        return inflate;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19307a;

        a(b bVar) {
            this.f19307a = bVar;
        }

        public final void onClick(View view) {
            this.f19307a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.redeemFd.b$b  reason: collision with other inner class name */
    static final class C0342b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19308a;

        C0342b(b bVar) {
            this.f19308a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19308a.getActivity(), "fixed_deposit", "redeeming_fixed_deposit_button_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/redeem", "fixed_deposit");
            this.f19308a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19309a;

        c(b bVar) {
            this.f19309a = bVar;
        }

        public final void onClick(View view) {
            this.f19309a.dismiss();
        }
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19310a = new d();

        d() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                ViewParent parent = frameLayout.getParent();
                if (parent != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setPeekHeight(frameLayout.getHeight());
                    ((CoordinatorLayout) parent).getParent().requestLayout();
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19306i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
