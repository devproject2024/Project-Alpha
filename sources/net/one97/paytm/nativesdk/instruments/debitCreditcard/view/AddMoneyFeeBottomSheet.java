package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.a;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

public final class AddMoneyFeeBottomSheet extends f {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "AddMoneyFeeBottomSheet";
    private HashMap _$_findViewCache;
    private String feePercent;
    private ImageView ivClose;
    /* access modifiers changed from: private */
    public AddMoneyBottomSheetListener listener;
    private String payMode;
    private String riskReason;
    private TextView tvBaseAmt;
    private TextView tvChargesText;
    private TextView tvChargesamt;
    private TextView tvDesc;
    private TextView tvNetPayableAmt;
    private RelativeLayout tvProceed;
    private TextView tvTitle;

    public interface AddMoneyBottomSheetListener {
        void onAddMoneyProceedClicked();
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AddMoneyFeeBottomSheet getInstance(String str, String str2, String str3) {
            k.c(str, "feePercent");
            AddMoneyFeeBottomSheet addMoneyFeeBottomSheet = new AddMoneyFeeBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.KEY_RISK_CC_FEES, str);
            bundle.putString(SDKConstants.KEY_RISK_REASON, str2);
            bundle.putString(SDKConstants.KEY_PAYMODE, str3);
            addMoneyFeeBottomSheet.setArguments(bundle);
            return addMoneyFeeBottomSheet;
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            a aVar = (a) onCreateDialog;
            aVar.setOnShowListener(AddMoneyFeeBottomSheet$onCreateDialog$1.INSTANCE);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        String str = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_money_fees, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.tvBaseAmt);
        k.a((Object) findViewById, "view.findViewById(R.id.tvBaseAmt)");
        this.tvBaseAmt = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tvTitle);
        k.a((Object) findViewById2, "view.findViewById(R.id.tvTitle)");
        this.tvTitle = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tvDesc);
        k.a((Object) findViewById3, "view.findViewById(R.id.tvDesc)");
        this.tvDesc = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.tvChargesAmt);
        k.a((Object) findViewById4, "view.findViewById(R.id.tvChargesAmt)");
        this.tvChargesamt = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tvNetPayableAmt);
        k.a((Object) findViewById5, "view.findViewById(R.id.tvNetPayableAmt)");
        this.tvNetPayableAmt = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.tvProceed);
        k.a((Object) findViewById6, "view.findViewById(R.id.tvProceed)");
        this.tvProceed = (RelativeLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.tvChargesText);
        k.a((Object) findViewById7, "view.findViewById(R.id.tvChargesText)");
        this.tvChargesText = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.ivClose);
        k.a((Object) findViewById8, "view.findViewById(R.id.ivClose)");
        this.ivClose = (ImageView) findViewById8;
        ImageView imageView = this.ivClose;
        if (imageView == null) {
            k.a("ivClose");
        }
        imageView.setOnClickListener(new AddMoneyFeeBottomSheet$setupDialog$1(this));
        RelativeLayout relativeLayout = this.tvProceed;
        if (relativeLayout == null) {
            k.a("tvProceed");
        }
        relativeLayout.setOnClickListener(new AddMoneyFeeBottomSheet$setupDialog$2(this));
        Bundle arguments = getArguments();
        this.feePercent = arguments != null ? arguments.getString(SDKConstants.KEY_RISK_CC_FEES) : null;
        Bundle arguments2 = getArguments();
        this.riskReason = arguments2 != null ? arguments2.getString(SDKConstants.KEY_RISK_REASON) : null;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str = arguments3.getString(SDKConstants.KEY_PAYMODE);
        }
        this.payMode = str;
        TextView textView = this.tvTitle;
        if (textView == null) {
            k.a("tvTitle");
        }
        aa aaVar = aa.f47921a;
        String string = getString(R.string.add_money_risk_title);
        k.a((Object) string, "getString(R.string.add_money_risk_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.feePercent}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        TextView textView2 = this.tvChargesText;
        if (textView2 == null) {
            k.a("tvChargesText");
        }
        aa aaVar2 = aa.f47921a;
        String string2 = getString(R.string.add_money_charges);
        k.a((Object) string2, "getString(R.string.add_money_charges)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.feePercent}, 1));
        k.a((Object) format2, "java.lang.String.format(format, *args)");
        textView2.setText(format2);
        String str2 = this.riskReason;
        if (str2 != null) {
            TextView textView3 = this.tvDesc;
            if (textView3 == null) {
                k.a("tvDesc");
            }
            textView3.setText(str2);
        }
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String amount = merchantInstance.getAmount();
        String riskConvenienceFeeAmount = DirectPaymentBL.getInstance().getRiskConvenienceFeeAmount(this.payMode);
        String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(amount);
        String priceWithoutDecimal2 = SDKUtility.priceWithoutDecimal(riskConvenienceFeeAmount);
        TextView textView4 = this.tvBaseAmt;
        if (textView4 == null) {
            k.a("tvBaseAmt");
        }
        textView4.setText(getString(R.string.nativesdk_amount, priceWithoutDecimal));
        TextView textView5 = this.tvChargesamt;
        if (textView5 == null) {
            k.a("tvChargesamt");
        }
        textView5.setText(getString(R.string.nativesdk_amount, priceWithoutDecimal2));
        String priceWithoutDecimal3 = SDKUtility.priceWithoutDecimal(MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.parseDouble(amount) + SDKUtility.parseDouble(riskConvenienceFeeAmount)));
        TextView textView6 = this.tvNetPayableAmt;
        if (textView6 == null) {
            k.a("tvNetPayableAmt");
        }
        textView6.setText(getString(R.string.nativesdk_amount, priceWithoutDecimal3));
        dialog.setContentView(inflate);
        k.a((Object) inflate, "view");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            ((View) parent).setBackgroundResource(R.drawable.native_top_round_corner);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final void setCallbackListener(AddMoneyBottomSheetListener addMoneyBottomSheetListener) {
        k.c(addMoneyBottomSheetListener, "listener");
        this.listener = addMoneyBottomSheetListener;
    }
}
