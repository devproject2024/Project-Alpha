package net.one97.paytm.passbook.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.WalletDetailInfo;
import net.one97.paytm.passbook.utility.n;

public final class c extends com.google.android.material.bottomsheet.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57211a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private CJRSubWallet f57212b;

    /* renamed from: c  reason: collision with root package name */
    private n f57213c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57214d;

    public /* synthetic */ c(n nVar, CJRSubWallet cJRSubWallet, byte b2) {
        this(nVar, cJRSubWallet);
    }

    public c() {
    }

    private c(n nVar, CJRSubWallet cJRSubWallet) {
        this.f57213c = nVar;
        this.f57212b = cJRSubWallet;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(C1070c.f57216a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* renamed from: net.one97.paytm.passbook.customview.c$c  reason: collision with other inner class name */
    static final class C1070c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C1070c f57216a = new C1070c();

        C1070c() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (findViewById == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_how_it_works_bottom_sheet_dialog, (ViewGroup) null);
        dialog.setContentView(inflate);
        try {
            ViewParent parent = inflate.getParent();
            if (parent != null) {
                ((View) parent).setBackgroundColor(getResources().getColor(17170445));
                k.a((Object) inflate, "contentView");
                CJRSubWallet cJRSubWallet = this.f57212b;
                if (cJRSubWallet == null) {
                    k.a("mSubWalletData");
                }
                WalletDetailInfo walletData = WalletDetailInfo.Companion.getWalletData(cJRSubWallet);
                if (walletData != null) {
                    ((RoboTextView) inflate.findViewById(net.one97.paytm.passbook.R.id.titleTv)).setText(walletData.getTitle());
                    TextView textView = (TextView) inflate.findViewById(net.one97.paytm.passbook.R.id.descTv);
                    k.a((Object) textView, "view.descTv");
                    Context context = inflate.getContext();
                    k.a((Object) context, "view.context");
                    textView.setText(a(context, walletData));
                    int howItWorkArray = walletData.getHowItWorkArray();
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(net.one97.paytm.passbook.R.id.oneLinearLayout);
                    k.a((Object) linearLayout, "view.oneLinearLayout");
                    for (String text : getResources().getStringArray(howItWorkArray)) {
                        View inflate2 = LayoutInflater.from(getContext()).inflate(net.one97.paytm.passbook.R.layout.pass_layout_sub_wallet_detail_one_liner, linearLayout, false);
                        View findViewById = inflate2.findViewById(net.one97.paytm.passbook.R.id.titleTv);
                        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.titleTv)");
                        ((TextView) findViewById).setText(text);
                        linearLayout.addView(inflate2);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(net.one97.paytm.passbook.R.string.msg_note_your_wallet_is_non_transferable, getString(walletData.getWalletName())));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ffad00")), 0, 5, 34);
                    ((TextView) inflate.findViewById(net.one97.paytm.passbook.R.id.noteTv)).setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
                ((ImageView) inflate.findViewById(net.one97.paytm.passbook.R.id.closeImv)).setOnClickListener(new b(this));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        } catch (Exception unused) {
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57215a;

        b(c cVar) {
            this.f57215a = cVar;
        }

        public final void onClick(View view) {
            this.f57215a.dismiss();
        }
    }

    private final CharSequence a(Context context, WalletDetailInfo walletDetailInfo) {
        String[] strArr = new String[1];
        n nVar = this.f57213c;
        if (nVar == null) {
            k.a("passbookType");
        }
        if (nVar != n.LOYALTY_WALLET) {
            n nVar2 = this.f57213c;
            if (nVar2 == null) {
                k.a("passbookType");
            }
            if (nVar2 != n.LOYALTY_WALLET_TYPE_7) {
                n nVar3 = this.f57213c;
                if (nVar3 == null) {
                    k.a("passbookType");
                }
                if (nVar3 == n.ALLOWALANCE_WALLET) {
                    aa aaVar = aa.f47921a;
                    String string = getString(net.one97.paytm.passbook.R.string.allowance_generic_wallet_details);
                    k.a((Object) string, "getString(R.string.allow…e_generic_wallet_details)");
                    String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                    k.a((Object) format, "java.lang.String.format(format, *args)");
                    return format;
                }
                strArr[0] = null;
                return walletDetailInfo.getDetailText(context, strArr);
            }
        }
        return "It is a prepaid loyalty wallet awarded by merchants as a bonus or loyalty benefit. You may use the balance at the issuing merchant";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(CJRSubWallet cJRSubWallet, j jVar) {
            k.c(cJRSubWallet, "mSubWalletData");
            k.c(jVar, "fragmentManager");
            n passbookTypeByWalletType = n.getPassbookTypeByWalletType(cJRSubWallet);
            if (a(cJRSubWallet)) {
                k.a((Object) passbookTypeByWalletType, "passbookType");
                new c(passbookTypeByWalletType, cJRSubWallet, (byte) 0).show(jVar, c.class.getSimpleName());
            }
        }

        public static boolean a(CJRSubWallet cJRSubWallet) {
            k.c(cJRSubWallet, "mSubWalletData");
            return WalletDetailInfo.Companion.getWalletData(cJRSubWallet) != null;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57214d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
