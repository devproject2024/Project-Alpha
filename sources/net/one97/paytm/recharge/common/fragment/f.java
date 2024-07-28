package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.e;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansRichDesc;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData;

public class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61166a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private CJRBrowsePlanDescription f61167b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f61168c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f61169d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f61170e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f61171f;

    /* renamed from: g  reason: collision with root package name */
    private Button f61172g;

    /* renamed from: h  reason: collision with root package name */
    private e f61173h;

    /* renamed from: i  reason: collision with root package name */
    private String f61174i;
    private CJRMadeForYouPlanData j;

    public static f a(CJRBrowsePlanDescription cJRBrowsePlanDescription, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("browse_plan_descriptionnn", cJRBrowsePlanDescription);
        bundle.putSerializable("title", str);
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    public static f a(CJRMadeForYouPlanData cJRMadeForYouPlanData, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("made_for_you", cJRMadeForYouPlanData);
        bundle.putSerializable("title", str);
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey("browse_plan_descriptionnn")) {
                this.f61167b = (CJRBrowsePlanDescription) getArguments().getSerializable("browse_plan_descriptionnn");
            }
            if (getArguments().containsKey("made_for_you")) {
                this.j = (CJRMadeForYouPlanData) getArguments().getSerializable("made_for_you");
            }
            this.f61174i = getArguments().getString("title", "");
        }
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_browse_plan_detail_bottom_sheet, viewGroup, false);
        this.f61168c = (TextView) inflate.findViewById(R.id.price);
        this.f61169d = (TextView) inflate.findViewById(R.id.validity);
        this.f61170e = (TextView) inflate.findViewById(R.id.talktime);
        this.f61171f = (TextView) inflate.findViewById(R.id.description);
        this.f61172g = (Button) inflate.findViewById(R.id.btn_proceed);
        this.f61172g.setOnClickListener(this);
        inflate.findViewById(R.id.close_button).setOnClickListener(this);
        CJRBrowsePlanDescription cJRBrowsePlanDescription = this.f61167b;
        if (cJRBrowsePlanDescription == null || cJRBrowsePlanDescription.getLongRichDesc() == null || this.f61167b.getLongRichDesc().get(0) == null) {
            CJRMadeForYouPlanData cJRMadeForYouPlanData = this.j;
            if (cJRMadeForYouPlanData != null) {
                if (this.f61170e != null) {
                    String talkTimeDisplayString = cJRMadeForYouPlanData.getTalkTimeDisplayString(getActivity());
                    if (!TextUtils.isEmpty(talkTimeDisplayString)) {
                        this.f61170e.setText(talkTimeDisplayString);
                        this.f61170e.setVisibility(0);
                    } else {
                        this.f61170e.setVisibility(8);
                    }
                }
                if (!TextUtils.isEmpty(this.j.getActualPrice())) {
                    String actualPrice = this.j.getActualPrice();
                    if (b.K(actualPrice).booleanValue()) {
                        this.f61172g.setText(getString(R.string.utility_ff_proceed_to_pay, actualPrice));
                    } else if (b.a(Double.valueOf(Double.parseDouble(actualPrice)))) {
                        String valueOf = String.valueOf((int) Double.parseDouble(actualPrice));
                        this.f61172g.setText(getString(R.string.utility_ff_proceed_to_pay, valueOf));
                    } else {
                        String valueOf2 = String.valueOf(b.b(Double.parseDouble(actualPrice)));
                        this.f61172g.setText(getString(R.string.utility_ff_proceed_to_pay, valueOf2));
                    }
                }
                if (this.f61169d != null) {
                    if (!TextUtils.isEmpty(this.j.getValidity())) {
                        this.f61169d.setText(this.j.getValidityDisplayString(getActivity()));
                        this.f61169d.setVisibility(0);
                    } else {
                        this.f61169d.setVisibility(8);
                    }
                }
                if (this.f61171f != null) {
                    if (!TextUtils.isEmpty(this.j.getName())) {
                        this.f61171f.setText(this.j.getName());
                        this.f61171f.setVisibility(0);
                    } else {
                        this.f61171f.setVisibility(8);
                    }
                }
            }
        } else {
            CJRBrowsePlansRichDesc cJRBrowsePlansRichDesc = this.f61167b.getLongRichDesc().get(0);
            CJRBrowsePlansDescAttributes attributes = cJRBrowsePlansRichDesc.getAttributes();
            if (this.f61170e != null) {
                String talkTimeDisplayString2 = attributes.getTalkTimeDisplayString(getActivity());
                if (!TextUtils.isEmpty(talkTimeDisplayString2)) {
                    this.f61170e.setText(talkTimeDisplayString2);
                    this.f61170e.setVisibility(0);
                } else {
                    this.f61170e.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.f61167b.getOfferPrice())) {
                String offerPrice = this.f61167b.getOfferPrice();
                if (!b.K(offerPrice).booleanValue()) {
                    if (b.a(Double.valueOf(Double.parseDouble(offerPrice)))) {
                        offerPrice = String.valueOf((int) Double.parseDouble(offerPrice));
                    } else {
                        offerPrice = String.valueOf(b.b(Double.parseDouble(offerPrice)));
                    }
                }
                this.f61172g.setText(getString(R.string.utility_ff_proceed_to_pay, offerPrice));
            }
            if (this.f61169d != null) {
                if (!TextUtils.isEmpty(attributes.getValidity())) {
                    this.f61169d.setText(attributes.getValidityDisplayString(getActivity()));
                    this.f61169d.setVisibility(0);
                } else {
                    this.f61169d.setVisibility(8);
                }
            }
            if (this.f61171f != null) {
                String description = cJRBrowsePlansRichDesc.getDescription();
                if (!TextUtils.isEmpty(description)) {
                    if (description.contains("•")) {
                        description = description.replaceAll("•", "");
                    }
                    this.f61171f.setText(description);
                    this.f61171f.setVisibility(0);
                } else {
                    this.f61171f.setVisibility(8);
                }
            }
        }
        return inflate;
    }

    public void onClick(View view) {
        e eVar;
        if (view.getId() == R.id.close_button) {
            dismiss();
        } else if (view.getId() == R.id.btn_proceed && (eVar = this.f61173h) != null) {
            CJRBrowsePlanDescription cJRBrowsePlanDescription = this.f61167b;
            if (cJRBrowsePlanDescription != null) {
                CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes = null;
                String transactionType = cJRBrowsePlanDescription.getTransactionType();
                HashMap<String, String> hashMap = this.f61167b.getmDynamicDataObject();
                if (hashMap != null) {
                    hashMap.put("TransactionType", transactionType);
                }
                if (!(this.f61167b.getLongRichDesc() == null || this.f61167b.getLongRichDesc().get(0) == null)) {
                    CJRBrowsePlansRichDesc cJRBrowsePlansRichDesc = this.f61167b.getLongRichDesc().get(0);
                    cJRBrowsePlansDescAttributes = cJRBrowsePlansRichDesc.getAttributes();
                    cJRBrowsePlansDescAttributes.setPlanType(this.f61174i);
                    cJRBrowsePlansDescAttributes.setPlanDescription(cJRBrowsePlansRichDesc.getDescription());
                }
                CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes2 = cJRBrowsePlansDescAttributes;
                e eVar2 = this.f61173h;
                if (eVar2 != null) {
                    eVar2.a(this.f61167b.getOfferPrice(), this.f61167b.getAttributes().isTopUp(), hashMap, this.f61167b.getmPlanGuiId(), this.f61167b.getmPlanName(), cJRBrowsePlansDescAttributes2, false);
                    return;
                }
                return;
            }
            CJRMadeForYouPlanData cJRMadeForYouPlanData = this.j;
            if (cJRMadeForYouPlanData != null && eVar != null) {
                eVar.a(cJRMadeForYouPlanData.getActualPrice(), false, (HashMap<String, String>) null, (String) null, this.j.getName(), (CJRBrowsePlansDescAttributes) null, true);
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof e) {
            this.f61173h = (e) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f61173h = null;
    }
}
