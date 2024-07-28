package net.one97.paytm.quickpay.utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.j;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.DeleteQuickPayResponse;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.activity.QuickPaymentEditActivity;
import net.one97.paytm.quickpay.activity.SetReminderActivity;
import net.one97.paytm.quickpay.b.a;
import net.one97.paytm.utils.ao;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends f implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.quickpay.c.b f60120a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f60121b;

    /* renamed from: c  reason: collision with root package name */
    private View f60122c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public StandingInstructionList f60123d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f60124e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f60125f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressDialog f60126g;

    /* renamed from: h  reason: collision with root package name */
    private final int f60127h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final int f60128i = 4;
    /* access modifiers changed from: private */
    public int j = 0;
    private String k;
    private j l;
    private RelativeLayout m;

    public static b a(net.one97.paytm.quickpay.c.b bVar, StandingInstructionList standingInstructionList, j jVar) {
        b bVar2 = new b();
        bVar2.f60120a = bVar;
        bVar2.k = standingInstructionList.getId();
        bVar2.f60123d = standingInstructionList;
        bVar2.l = jVar;
        return bVar2;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f60121b = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f60122c = layoutInflater.inflate(R.layout.quick_pay_bottom_edit_payment, (ViewGroup) null);
        this.f60122c.findViewById(R.id.ivCross).setOnClickListener(this);
        this.f60122c.findViewById(R.id.rlEdit).setOnClickListener(this);
        this.f60122c.findViewById(R.id.rlDisableReminder).setOnClickListener(this);
        this.f60122c.findViewById(R.id.rlDeleteReminder).setOnClickListener(this);
        this.f60122c.findViewById(R.id.rlDeleteFastforwardPayment).setOnClickListener(this);
        this.f60122c.findViewById(R.id.rlSet).setOnClickListener(this);
        this.f60125f = (RelativeLayout) this.f60122c.findViewById(R.id.rlDisableReminder);
        this.f60124e = (RelativeLayout) this.f60122c.findViewById(R.id.rlDeleteReminder);
        this.m = (RelativeLayout) this.f60122c.findViewById(R.id.rlSet);
        this.f60123d = a.a(this.f60121b, String.valueOf(this.k));
        int i2 = 8;
        this.f60125f.setVisibility(8);
        boolean enablePaymentsReminder = this.f60123d.getEnablePaymentsReminder();
        this.f60124e.setVisibility(enablePaymentsReminder ? 0 : 8);
        RelativeLayout relativeLayout = this.m;
        if (!enablePaymentsReminder) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
        return this.f60122c;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.ivCross) {
            if (id == R.id.rlEdit) {
                Intent intent = new Intent(this.f60121b, QuickPaymentEditActivity.class);
                intent.putExtra("entity", this.f60123d);
                Context context = this.f60121b;
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, 1001);
                }
                dismiss();
                return;
            } else if (id == R.id.rlDisableReminder) {
                a(1);
                return;
            } else if (id == R.id.rlDeleteReminder) {
                a(4);
                return;
            } else if (id == R.id.rlDeleteFastforwardPayment) {
                AnonymousClass1 r12 = new net.one97.paytm.quickpay.c.a() {
                    public final void a(int i2) {
                        if (i2 == 1) {
                            b.a(b.this);
                        } else {
                            b.this.dismiss();
                        }
                    }
                };
                String str = "null";
                String tagName = this.f60123d.getSupportingData() != null ? this.f60123d.getSupportingData().getTagName() : str;
                if (this.f60123d.getSupportingData() != null) {
                    str = this.f60123d.getSupportingData().getBeneficiaryName();
                }
                a a2 = a.a((net.one97.paytm.quickpay.c.a) r12, tagName, str);
                ao.a(b.class, "confirmDeleteBotoomSheet");
                a2.show(this.l.a(), (String) null);
                return;
            } else if (id == R.id.rlSet) {
                try {
                    d.a().a(this.f60121b, "my_payments", "set_reminder_option_clicked", "edit", this.f60123d.getSupportingData().getTagName(), (String) null, "/personal-payments/success", "homescreen");
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                }
                Intent intent2 = new Intent(this.f60121b, SetReminderActivity.class);
                intent2.putExtra("is_update", true);
                intent2.putExtra("tag_url", this.f60123d.getSupportingData().getTagUrl());
                intent2.putExtra("tag_name", this.f60123d.getSupportingData().getTagName());
                intent2.putExtra("si_id", Long.parseLong(this.k));
                Context context2 = this.f60121b;
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent2, 1002);
                }
            } else {
                return;
            }
        }
        dismiss();
    }

    private void a(int i2) {
        String a2 = d.b().a("updateQuickPaymentUrl");
        if (URLUtil.isValidUrl(a2)) {
            String str = a2 + "?siId=" + this.f60123d.getId() + "&type=QUICK_PAYMENTS";
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b(this.f60121b));
            hashMap.put("Content-Type", "application/json");
            try {
                this.f60123d.setType("QUICK_PAYMENTS");
                if (i2 == 4) {
                    this.j = 4;
                    this.f60123d.setEnablePaymentsReminder(false);
                    this.f60123d.setMarkedAsPaid(false);
                    this.f60123d.setReminderDateIndex((String) null);
                    this.f60123d.setReminderFrequency((String) null);
                    this.f60123d.setReminderDayOfWeek((String) null);
                    this.f60123d.setReminderFrequency((String) null);
                } else if (i2 == 1) {
                    this.j = 1;
                    this.f60123d.setEnablePaymentsReminder(false);
                }
                final String startDate = this.f60123d.getStartDate();
                this.f60123d.getNextReminderDate();
                this.f60123d.setStartDate((String) null);
                this.f60123d.setNextReminderDate((String) null);
                JSONObject jSONObject = new JSONObject(new com.google.gson.f().b(this.f60123d));
                if (com.paytm.utility.a.m(this.f60121b)) {
                    a(this.f60121b, this.f60121b.getResources().getString(R.string.loading));
                    dismiss();
                    d.a(this.f60121b, str, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            b.b(b.this);
                            if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                if (quickPayAddResponse.getResponseCode() == 200) {
                                    b.this.f60123d.setStartDate(startDate);
                                    Toast.makeText(b.this.f60121b, b.this.j == 4 ? "Reminder deleted Successfully" : "Reminder disabled Successfully", 1).show();
                                    a.a(b.this.f60121b, b.this.f60123d);
                                    net.one97.paytm.quickpay.d.a.a().a(b.this.f60123d);
                                    if (b.this.j == 4 && b.this.f60120a != null) {
                                        b.this.f60120a.a(4);
                                    }
                                    b.this.dismiss();
                                    return;
                                }
                                String responseMessage = quickPayAddResponse.getResponseMessage();
                                if (TextUtils.isEmpty(responseMessage)) {
                                    responseMessage = "Something went wrong";
                                }
                                d.a(b.this.f60121b, "Error", responseMessage);
                                return;
                            }
                            d.a(b.this.f60121b, "Error", "Something went wrong");
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            b.b(b.this);
                            d.a(b.this.f60121b, "Error", "Something went wrong");
                        }
                    }, hashMap, (Map<String, String>) null, a.C0715a.PUT, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                }
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void a(Context context, String str) {
        if (context != null) {
            ProgressDialog progressDialog = this.f60126g;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f60126g = new ProgressDialog(context);
                try {
                    this.f60126g.setProgressStyle(0);
                    this.f60126g.setMessage(str);
                    this.f60126g.setCancelable(false);
                    this.f60126g.setCanceledOnTouchOutside(false);
                    this.f60126g.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", d.a().b(bVar.f60121b));
        hashMap.put("Content-Type", "application/json");
        String str = d.b().a("deactivateQuickPaymentUrl") + "?siId=" + bVar.f60123d.getId() + "&siType=QUICK_PAYMENTS";
        if (com.paytm.utility.a.m(bVar.f60121b)) {
            Context context = bVar.f60121b;
            bVar.a(context, context.getResources().getString(R.string.loading));
            d.a(bVar.f60121b, str, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    b.b(b.this);
                    if (iJRPaytmDataModel instanceof DeleteQuickPayResponse) {
                        DeleteQuickPayResponse deleteQuickPayResponse = (DeleteQuickPayResponse) iJRPaytmDataModel;
                        if (deleteQuickPayResponse.getResponseCode() == 200) {
                            b.this.f60123d.setStatus(i.DEACTIVATE.getStatus());
                            net.one97.paytm.quickpay.b.a.a(b.this.f60121b, b.this.f60123d);
                            net.one97.paytm.quickpay.d.a.a().a(b.this.f60123d);
                            b.this.dismiss();
                            if (b.this.f60120a != null) {
                                b.this.f60120a.a(2);
                            }
                            Toast.makeText(b.this.f60121b, "Deleted Successfully", 1).show();
                            return;
                        }
                        String responseMessage = deleteQuickPayResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage)) {
                            responseMessage = "Something went wrong";
                        }
                        d.a(b.this.f60121b, "Error", responseMessage);
                        return;
                    }
                    d.a(b.this.f60121b, "Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    b.b(b.this);
                    d.a(b.this.f60121b, "Error", "Something went wrong");
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.PUT, (String) null, new DeleteQuickPayResponse(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    static /* synthetic */ void b(b bVar) {
        ProgressDialog progressDialog = bVar.f60126g;
        if (progressDialog != null && progressDialog.isShowing()) {
            bVar.f60126g.dismiss();
            bVar.f60126g = null;
        }
    }
}
