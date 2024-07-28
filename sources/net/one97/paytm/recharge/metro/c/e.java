package net.one97.paytm.recharge.metro.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.f;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.metro.f.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.metro.f.d;
import net.one97.paytm.recharge.ordersummary.f.g;
import net.one97.paytm.recharge.widgets.c.b;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class e extends f implements View.OnClickListener, g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRActiveMetroTicketModel f63318a = null;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f63319b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f63320c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f63321d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f63322e = false;

    /* renamed from: f  reason: collision with root package name */
    private final int f63323f = 109;

    public interface a {
        void a(String str, CJRActiveMetroTicketModel cJRActiveMetroTicketModel);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        b.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return e.this.c();
            }
        });
        if (getArguments() == null) {
            throw new RuntimeException("Argument expected");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x c() {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), "mumbai metro qr", "qr_popup", "", "", "", "utility");
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_generate_ticket_bottomsheet_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.heading);
        TextView textView3 = (TextView) view.findViewById(R.id.message);
        ImageView imageView = (ImageView) view.findViewById(R.id.cancel_action);
        TextView textView4 = (TextView) view.findViewById(R.id.btn_confirm);
        Bundle arguments = getArguments();
        this.f63318a = (CJRActiveMetroTicketModel) arguments.getSerializable("activeMetroTickets");
        CJRUtilityAlertV2 cJRUtilityAlertV2 = arguments.containsKey("extra_home_data") ? (CJRUtilityAlertV2) getArguments().getSerializable("extra_home_data") : null;
        if (arguments.containsKey(StringSet.operator)) {
            this.f63321d = getArguments().getString(StringSet.operator);
        }
        if (arguments.containsKey("is_cancellable")) {
            this.f63322e = arguments.getBoolean("is_cancellable");
        }
        c.a aVar = c.f63576a;
        textView.setText(c.a.a(getContext(), this.f63318a.getProductType(), this.f63318a.getSource(), this.f63318a.getDestination(), this.f63318a.getBalanceAmount(), false));
        if (cJRUtilityAlertV2 == null || TextUtils.isEmpty(cJRUtilityAlertV2.getHeading())) {
            textView2.setText(getContext().getString(R.string.metro_confirmation_substitle));
        } else {
            textView2.setText(cJRUtilityAlertV2.getHeading());
        }
        if (cJRUtilityAlertV2 == null || TextUtils.isEmpty(cJRUtilityAlertV2.getPositive_btn_txt())) {
            textView4.setText(getContext().getString(R.string.confirm_re));
        } else {
            textView4.setText(cJRUtilityAlertV2.getPositive_btn_txt());
        }
        if (!c.e.SVP.getValue().equalsIgnoreCase(this.f63318a.getProductType())) {
            int balanceTrip_2 = this.f63318a.getBalanceTrip_2() - 1;
            String string = getContext().getString(R.string.remaining_trips, new Object[]{Integer.valueOf(balanceTrip_2)});
            int indexOf = string.indexOf(String.valueOf(balanceTrip_2));
            SpannableString spannableString = new SpannableString(string);
            if (indexOf != -1) {
                spannableString.setSpan(new StyleSpan(1), indexOf, string.length(), 33);
            }
            textView3.setText(spannableString);
        } else if (cJRUtilityAlertV2 == null || TextUtils.isEmpty(cJRUtilityAlertV2.getMessage())) {
            textView3.setText(getContext().getString(R.string.metro_svp_confirmation_message, new Object[]{this.f63321d}));
        } else {
            textView3.setText(cJRUtilityAlertV2.getMessage());
        }
        imageView.setOnClickListener(this);
        textView4.setOnClickListener(this);
    }

    public final void at_() {
        ProgressDialog progressDialog = this.f63319b;
        if (progressDialog == null) {
            this.f63319b = ProgressDialog.show(getContext(), "", getString(R.string.please_wait), true);
        } else {
            progressDialog.show();
        }
    }

    public final void o() {
        try {
            this.f63319b.dismiss();
        } catch (IllegalStateException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_action) {
            dismiss();
        } else if (id != R.id.btn_confirm) {
        } else {
            if (!com.paytm.utility.b.c(getContext())) {
                com.paytm.utility.b.a(getContext(), getContext().getString(R.string.title_connection_problem), getContext().getString(R.string.msg_connection_problem));
            } else if (!d.INSTANCE.validateIsAlreadyClicked(this)) {
                a();
            }
        }
    }

    public final void a(a aVar) {
        this.f63320c = aVar;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 109) {
            return;
        }
        if (i3 != 0) {
            a();
            return;
        }
        ay ayVar = ay.f61523a;
        ay.a(109);
    }

    private void a() {
        at_();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
        a2.getFlowName().setActionType(ACTION_TYPE.METRO_GENERATE_TICKET.name());
        net.one97.paytm.recharge.metro.f.a.b("metro_generate_ticket", getContext(), this.f63318a.getPassId(), this.f63318a.getOrderId(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                if (iJRPaytmDataModel != null) {
                    CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) iJRPaytmDataModel;
                    cJRActiveMetroTicketModel.setProductType(e.this.f63318a.getProductType());
                    cJRActiveMetroTicketModel.setSource(e.this.f63318a.getSource());
                    cJRActiveMetroTicketModel.setDestination(e.this.f63318a.getDestination());
                    cJRActiveMetroTicketModel.setBalanceAmount(e.this.f63318a.getBalanceAmount());
                    if (c.e.TRIP_PASS.getValue().equalsIgnoreCase(e.this.f63318a.getProductType()) || c.b.TRIPPASS_10.getValue().equalsIgnoreCase(e.this.f63318a.getProductType()) || c.b.TRIPPASS_30.getValue().equalsIgnoreCase(e.this.f63318a.getProductType()) || c.b.TRIPPASS_45.getValue().equalsIgnoreCase(e.this.f63318a.getProductType()) || c.b.TRIPPASS.getValue().equalsIgnoreCase(e.this.f63318a.getProductType()) || c.e.TP.getValue().equalsIgnoreCase(e.this.f63318a.getProductType())) {
                        try {
                            cJRActiveMetroTicketModel.setBalanceTrip_2(cJRActiveMetroTicketModel.getQrCodes().get(0).getBalanceTrip_2());
                        } catch (Exception e2) {
                            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                        }
                    }
                    c.a aVar = c.f63576a;
                    Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
                    k.c(cJRActiveMetroTicketModel, "ticket");
                    k.c(applicationContext, "context");
                    List<CJRActiveMetroTicketModel> a2 = c.a.a(applicationContext);
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    }
                    a2.add(cJRActiveMetroTicketModel);
                    ax.a aVar2 = ax.f61521a;
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    k.a((Object) applicationContext2, "context.applicationContext");
                    com.paytm.b.a.a a3 = ax.a.a(applicationContext2, f.a.METRO_PREF);
                    String n = com.paytm.utility.b.n(applicationContext);
                    k.a((Object) n, "CJRAppCommonUtility.getUserId(context)");
                    a3.a(n, new com.google.gsonhtcfix.f().a((Object) a2), false);
                    a3.a("metroActiveTickets", com.paytm.utility.b.n(applicationContext), false);
                    c.a aVar3 = c.f63576a;
                    boolean c2 = c.a.c((List<? extends CJRActiveMetroTicketModel>) Collections.singletonList(cJRActiveMetroTicketModel));
                    b.a aVar4 = net.one97.paytm.recharge.metro.f.b.f63570c;
                    b.a.a(cJRActiveMetroTicketModel.getProductId(), c2);
                    if (e.this.f63320c != null) {
                        e.this.f63320c.a(e.this.getArguments().getString(StringSet.operator), cJRActiveMetroTicketModel);
                    }
                } else if (!(CJRRechargeUtilities.INSTANCE.getApplicationContext() == null || e.this.getActivity() == null || !e.this.isAdded())) {
                    Toast.makeText(CJRRechargeUtilities.INSTANCE.getApplicationContext(), e.this.getString(R.string.try_again), 1).show();
                }
                e.this.o();
                e.this.dismiss();
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                e.this.o();
                if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                    CJRRechargeUtilities.INSTANCE.handleError(str, e.this.getActivity(), e.this, networkCustomError, true, 109, obj);
                    return;
                }
                e.this.dismiss();
                if (networkCustomError != null) {
                    CJRRechargeUtilities.INSTANCE.handleError(str, e.this.getActivity(), (Fragment) null, networkCustomError, true, 3, obj);
                }
            }
        }, a2);
    }
}
