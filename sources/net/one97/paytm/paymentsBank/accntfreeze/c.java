package net.one97.paytm.paymentsBank.accntfreeze;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.p;
import net.one97.paytm.paymentsBank.utils.o;
import org.json.JSONObject;

public class c extends p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17353a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private CustProductList f17354b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f17355c;

    private View a(int i2) {
        if (this.f17355c == null) {
            this.f17355c = new HashMap();
        }
        View view = (View) this.f17355c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17355c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.pb_bank_account_freeze_header, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…header, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        String string = arguments.getString("title");
        String string2 = arguments.getString("arg_subtitle");
        String string3 = arguments.getString("arg_action_txt");
        TextView textView = (TextView) a(R.id.titleTv);
        k.a((Object) textView, "titleTv");
        textView.setText(string);
        PBReadMoreTextView pBReadMoreTextView = (PBReadMoreTextView) a(R.id.subtitleTv);
        k.a((Object) pBReadMoreTextView, "subtitleTv");
        pBReadMoreTextView.setText(string2);
        TextView textView2 = (TextView) a(R.id.actionBtn);
        k.a((Object) textView2, "actionBtn");
        textView2.setText(string3);
        ((TextView) a(R.id.actionBtn)).setOnClickListener(new b(this, arguments.getString("arg_action")));
        HashMap hashMap = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) getActivity(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getApplicationContext();
        }
        net.one97.paytm.bankCommon.g.c.a();
        net.one97.paytm.bankCommon.g.c.a(a2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f17356a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17357b;

        b(c cVar, String str) {
            this.f17356a = cVar;
            this.f17357b = str;
        }

        public final void onClick(View view) {
            String str = this.f17357b;
            if (str == null) {
                return;
            }
            if (kotlin.m.p.b(str, "http", false)) {
                o.a().openWebViewActivity(this.f17356a.getActivity(), this.f17357b, this.f17356a.getString(R.string.pb_dormant_info_web_title));
            } else {
                o.a().checkDeepLink(this.f17356a.getActivity(), this.f17357b);
            }
        }
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        CustProductList.Isa isa;
        List<CustProductList.FreezeDescriptionList> list;
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.f17354b = (CustProductList) iJRPaytmDataModel;
            CustProductList custProductList = this.f17354b;
            String str = null;
            if ((custProductList != null ? custProductList.getIsaAccountStatus() : null) != null) {
                CustProductList custProductList2 = this.f17354b;
                String isaAccountStatus = custProductList2 != null ? custProductList2.getIsaAccountStatus() : null;
                if (isaAccountStatus == null) {
                    k.a();
                }
                if (!kotlin.m.p.a(net.one97.paytm.passbook.beans.CustProductList.ISA_CREDIT_FREEZED, isaAccountStatus, true)) {
                    CustProductList custProductList3 = this.f17354b;
                    String isaAccountStatus2 = custProductList3 != null ? custProductList3.getIsaAccountStatus() : null;
                    if (isaAccountStatus2 == null) {
                        k.a();
                    }
                    if (!kotlin.m.p.a(net.one97.paytm.passbook.beans.CustProductList.ISA_DEBIT_FREEZED, isaAccountStatus2, true)) {
                        CustProductList custProductList4 = this.f17354b;
                        String isaAccountStatus3 = custProductList4 != null ? custProductList4.getIsaAccountStatus() : null;
                        if (isaAccountStatus3 == null) {
                            k.a();
                        }
                        if (!kotlin.m.p.a(net.one97.paytm.passbook.beans.CustProductList.ISA_TOTAL_FREEZED, isaAccountStatus3, true)) {
                            return;
                        }
                    }
                }
            }
            c cVar = this;
            CustProductList custProductList5 = cVar.f17354b;
            if (custProductList5 == null) {
                k.a();
            }
            CustProductList.Isa isa2 = custProductList5.getIsa();
            if (isa2 == null) {
                k.a();
            }
            if (isa2.freezeDescriptionList != null) {
                CustProductList custProductList6 = cVar.f17354b;
                CustProductList.FreezeDescriptionList freezeDescriptionList = (custProductList6 == null || (isa = custProductList6.getIsa()) == null || (list = isa.freezeDescriptionList) == null) ? null : list.get(0);
                if (freezeDescriptionList != null) {
                    str = freezeDescriptionList.getActionDescription();
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.getString(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                jSONObject.getString(Item.KEY_REASON);
                jSONObject.getString("action_text");
                jSONObject.getString("deeplink");
            }
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17355c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
