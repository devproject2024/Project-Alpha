package net.one97.paytm.autoaddmoney.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f49454a;

    /* renamed from: b  reason: collision with root package name */
    private String f49455b;

    /* renamed from: c  reason: collision with root package name */
    private IJRDataModel f49456c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f49457d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49458e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f49459f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f49460g;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.am_cardlinked_status_bottomsheet, (ViewGroup) null);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(b.f49462a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f49462a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        from.setState(3);
                        from.setPeekHeight(500);
                        from.setHideable(true);
                        from.setSkipCollapsed(false);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        View view = getView();
        if (view == null) {
            k.a();
        }
        View findViewById = view.findViewById(R.id.status);
        k.a((Object) findViewById, "view!!.findViewById(R.id.status)");
        this.f49457d = (TextView) findViewById;
        View view2 = getView();
        if (view2 == null) {
            k.a();
        }
        View findViewById2 = view2.findViewById(R.id.status_msg);
        k.a((Object) findViewById2, "view!!.findViewById(R.id.status_msg)");
        this.f49458e = (TextView) findViewById2;
        View view3 = getView();
        if (view3 == null) {
            k.a();
        }
        View findViewById3 = view3.findViewById(R.id.img_status);
        k.a((Object) findViewById3, "view!!.findViewById(R.id.img_status)");
        this.f49459f = (ImageView) findViewById3;
        try {
            super.onActivityCreated(bundle);
            Bundle arguments = getArguments();
            Serializable serializable = null;
            this.f49454a = arguments != null ? arguments.getString(SDKConstants.STATUS) : null;
            Bundle arguments2 = getArguments();
            this.f49455b = arguments2 != null ? arguments2.getString("STATUS_MESSAGE") : null;
            Bundle arguments3 = getArguments();
            if ((arguments3 != null ? arguments3.getSerializable("SAVED_CARD") : null) != null) {
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    serializable = arguments4.getSerializable("SAVED_CARD");
                }
                if (serializable != null) {
                    this.f49456c = (IJRDataModel) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.IJRDataModel");
                }
            }
            if (this.f49456c != null) {
                String str = "";
                if (this.f49456c instanceof CJRAvailableInstrumentsAddMoney.Card) {
                    IJRDataModel iJRDataModel = this.f49456c;
                    if (iJRDataModel != null) {
                        str = ((CJRAvailableInstrumentsAddMoney.Card) iJRDataModel).getIssuerDisplayName();
                        k.a((Object) str, "card.issuerDisplayName");
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card");
                    }
                } else if (this.f49456c instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                    IJRDataModel iJRDataModel2 = this.f49456c;
                    if (iJRDataModel2 != null) {
                        str = ((CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel2).getIssuerDisplayName();
                        k.a((Object) str, "card.issuerDisplayName");
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card");
                    }
                } else if (this.f49456c instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                    IJRDataModel iJRDataModel3 = this.f49456c;
                    if (iJRDataModel3 != null) {
                        str = ((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel3).getIssuerDisplayName();
                        k.a((Object) str, "card.issuerDisplayName");
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card");
                    }
                }
                if (p.a(this.f49454a, "SUCCESS", false)) {
                    TextView textView = this.f49457d;
                    if (textView == null) {
                        k.a("mTvStatus");
                    }
                    textView.setText(getString(R.string.sucess_card_linked, str));
                    ImageView imageView = this.f49459f;
                    if (imageView == null) {
                        k.a("mImgStatus");
                    }
                    imageView.setImageResource(R.drawable.uam_ic_success);
                } else {
                    TextView textView2 = this.f49457d;
                    if (textView2 == null) {
                        k.a("mTvStatus");
                    }
                    textView2.setText(getString(R.string.failed_card_linked, str));
                    ImageView imageView2 = this.f49459f;
                    if (imageView2 == null) {
                        k.a("mImgStatus");
                    }
                    imageView2.setImageResource(R.drawable.uam_gv_ic_failed);
                    TextView textView3 = this.f49458e;
                    if (textView3 == null) {
                        k.a("mTvStatusMessage");
                    }
                    textView3.setText(this.f49455b);
                }
            }
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
            a();
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f49461a;

        a(i iVar) {
            this.f49461a = iVar;
        }

        public final void run() {
            if (i.a(this.f49461a)) {
                this.f49461a.dismiss();
            }
        }
    }

    private final void a() {
        new Handler().postDelayed(new a(this), 5000);
    }

    public static final /* synthetic */ boolean a(i iVar) {
        if (iVar.getActivity() == null) {
            return false;
        }
        FragmentActivity activity = iVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        return !activity.isFinishing() && iVar.isResumed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49460g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
