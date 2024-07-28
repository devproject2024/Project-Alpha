package net.one97.paytm.passbook.search;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.h;
import com.paytm.utility.v;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRActionUrlRequest;
import net.one97.paytm.passbook.beans.CJRBusInvoiceModel;
import net.one97.paytm.passbook.beans.CJRButton;
import net.one97.paytm.passbook.beans.CJRModalActionUrlRequest;
import net.one97.paytm.passbook.beans.CJRModalButton;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.customview.a;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends RecyclerView.a<a> implements View.OnClickListener, a.C1069a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f58417a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public d f58418b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRTransaction> f58419c;

    /* renamed from: d  reason: collision with root package name */
    Resources f58420d;

    /* renamed from: e  reason: collision with root package name */
    int f58421e;

    /* renamed from: f  reason: collision with root package name */
    SparseBooleanArray f58422f;

    /* renamed from: g  reason: collision with root package name */
    int f58423g = Build.VERSION.SDK_INT;

    /* renamed from: h  reason: collision with root package name */
    Dialog f58424h;

    /* renamed from: i  reason: collision with root package name */
    boolean f58425i;
    private String j = "";
    private SparseBooleanArray k;
    /* access modifiers changed from: private */
    public d l;
    private LinkedHashMap<String, Drawable> m = new LinkedHashMap<>();

    interface b {
        void a();
    }

    public interface c {
    }

    public void onClick(View view) {
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        Drawable drawable;
        a aVar = (a) vVar;
        CJRTransaction cJRTransaction = this.f58419c.get(i2);
        aVar.f58457b.setText(cJRTransaction.getTxnDesc1());
        aVar.f58456a.setText(cJRTransaction.getNarration());
        if (!TextUtils.isEmpty(cJRTransaction.getImageUrl())) {
            try {
                w.a().a(cJRTransaction.getImageUrl()).a((ImageView) aVar.f58463h, (com.squareup.picasso.e) null);
            } catch (Exception unused) {
            }
        }
        String txnDate = cJRTransaction.getTxnDate();
        String string = this.f58420d.getString(R.string.wallet_rs);
        if (this.f58417a != null) {
            if (cJRTransaction.getTxnType().equalsIgnoreCase("CR")) {
                string = " + " + String.format(string, new Object[]{net.one97.paytm.passbook.utility.c.d(cJRTransaction.getTxnAmount())});
            } else if (cJRTransaction.getTxnType().equalsIgnoreCase("DR")) {
                string = " - " + String.format(string, new Object[]{net.one97.paytm.passbook.utility.c.d(cJRTransaction.getTxnAmount())});
            }
            txnDate = ((l) this.f58417a).a("yyyy-MM-dd HH:mm:ss", "MMMM dd , hh:mm a", txnDate);
        }
        if (!this.j.equalsIgnoreCase(StringSet.all)) {
            drawable = a(this.j);
        } else if (!cJRTransaction.getTxnType().equalsIgnoreCase("CR") || !cJRTransaction.getNarration().contains("Added ")) {
            drawable = a(cJRTransaction.getTxnType());
        } else {
            drawable = a("CR_added");
        }
        aVar.f58458c.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aVar.f58458c.setText(txnDate);
        aVar.f58459d.setText(string);
        aVar.f58461f.setText(this.f58417a.getString(R.string.wallet_txn_id) + " " + cJRTransaction.getWalletOrderId());
        aVar.f58460e.setText(cJRTransaction.getTxnDesc2());
        a(aVar.k, cJRTransaction.getExtendedTxnInfo());
        if (!TextUtils.isEmpty(cJRTransaction.getTxnDesc3())) {
            aVar.f58460e.setText(aVar.f58460e.getText().toString() + StringUtility.NEW_LINE + cJRTransaction.getTxnDesc3());
        }
        if (cJRTransaction.getTxnStatus() == null || !cJRTransaction.getTxnStatus().equalsIgnoreCase("SUCCESS")) {
            if (cJRTransaction.getTxnStatus() == null || !cJRTransaction.getTxnStatus().equalsIgnoreCase("PENDING")) {
                if (cJRTransaction.getTxnStatus() != null && cJRTransaction.getTxnStatus().equalsIgnoreCase("FAILURE")) {
                    aVar.f58462g.setText(cJRTransaction.getTxnStatus());
                    aVar.f58462g.setTextColor(this.f58420d.getColor(R.color.status_failure));
                } else if (cJRTransaction.getTxnStatus() != null && cJRTransaction.getTxnStatus().equalsIgnoreCase("REFUNDED_BACK")) {
                    aVar.f58462g.setText(cJRTransaction.getTxnStatus());
                    aVar.f58462g.setTextColor(this.f58420d.getColor(R.color.status_failure));
                } else if (cJRTransaction.getTxnStatus() != null && cJRTransaction.getTxnStatus().equalsIgnoreCase(AppConstants.TRANSACTION_STATUS_REFUND_SUCCESS)) {
                    aVar.f58462g.setText(cJRTransaction.getTxnStatus());
                    aVar.f58462g.setTextColor(this.f58420d.getColor(R.color.passbook_row_status_refundsuccess_color));
                }
            }
            aVar.f58462g.setText(cJRTransaction.getTxnStatus());
            aVar.f58462g.setTextColor(this.f58420d.getColor(R.color.status_pending));
        } else {
            aVar.f58462g.setText("");
        }
        a(aVar, i2, cJRTransaction);
        aVar.j.setVisibility(8);
        aVar.f58464i.setVisibility(0);
        RelativeLayout relativeLayout = aVar.l;
        if (this.f58422f.get(i2, false)) {
            View findViewById = relativeLayout.findViewById(R.id.passbook_payer_or_payee_ledger_icon_bg_iv);
            relativeLayout.findViewById(R.id.passbook_payer_or_payee_icons_iv).setAlpha(1.0f);
            relativeLayout.setBackgroundResource(R.color.light_grey);
            a(findViewById, this.f58417a);
        } else {
            relativeLayout.setBackgroundResource(R.color.transparent);
            View findViewById2 = relativeLayout.findViewById(R.id.passbook_payer_or_payee_ledger_icon_bg_iv);
            relativeLayout.findViewById(R.id.passbook_payer_or_payee_icons_iv).setAlpha(1.0f);
            if (this.f58423g >= 16) {
                findViewById2.setBackground(this.f58420d.getDrawable(R.drawable.pass_circle_border));
            } else {
                findViewById2.setBackgroundDrawable(this.f58420d.getDrawable(R.drawable.pass_circle_border));
            }
        }
        RelativeLayout relativeLayout2 = aVar.l;
        CJRTransaction cJRTransaction2 = this.f58419c.get(i2);
        TextView textView = (TextView) relativeLayout2.findViewById(R.id.passbook_extrainfo_btn_need_help_tv);
        ((TextView) relativeLayout2.findViewById(R.id.passbook_extrainfo_btn_receipt_tv)).setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRTransaction cJRTransaction = e.this.f58419c.get(i2);
                if (!cJRTransaction.getTxnDesc1().startsWith("Paytm Order") || cJRTransaction.getType().equals("7")) {
                    net.one97.paytm.passbook.d.b().a((AppCompatActivity) e.this.f58417a, cJRTransaction);
                } else {
                    e.a(e.this, cJRTransaction);
                }
            }
        });
        if (this.k.get(i2, false)) {
            textView.setVisibility(0);
            View findViewById3 = relativeLayout2.findViewById(R.id.passbook_send_receive_txn_dsc_2tv);
            View findViewById4 = relativeLayout2.findViewById(R.id.passbook_send_receive_wallet_ord_id_tv);
            View findViewById5 = relativeLayout2.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
            View findViewById6 = relativeLayout2.findViewById(R.id.passbook_bus_view_receipt_ll);
            if (!TextUtils.isEmpty(cJRTransaction2.getTxnDesc2())) {
                findViewById3.setVisibility(0);
            } else {
                findViewById3.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cJRTransaction2.getWalletOrderId())) {
                findViewById4.setVisibility(0);
            } else {
                findViewById4.setVisibility(8);
            }
            findViewById5.setVisibility(0);
            findViewById6.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
        View findViewById7 = relativeLayout2.findViewById(R.id.passbook_send_receive_txn_dsc_2tv);
        View findViewById8 = relativeLayout2.findViewById(R.id.passbook_send_receive_wallet_ord_id_tv);
        findViewById7.setVisibility(8);
        findViewById8.setVisibility(8);
    }

    public e(Fragment fragment, ArrayList<CJRTransaction> arrayList, String str) {
        ArrayList<CJRTransaction> arrayList2;
        this.f58417a = fragment.getActivity();
        d dVar = (d) fragment;
        this.f58418b = dVar;
        this.f58419c = arrayList;
        this.f58420d = fragment.getResources();
        this.j = str;
        this.f58422f = new SparseBooleanArray();
        this.k = new SparseBooleanArray();
        if (dVar.f58395a && (this.f58417a instanceof l) && (arrayList2 = this.f58419c) != null && arrayList2.size() > 0) {
            l lVar = (l) ((Activity) this.f58417a);
            lVar.a(lVar.a("yyyy-MM-dd HH:mm:ss", "MMMM yyyy", this.f58419c.get(0).getTxnDate()));
        }
    }

    private void a(d dVar, String str) {
        try {
            if ((this.f58417a instanceof l) && this.f58419c != null && this.f58419c.size() > 0) {
                dVar.a(false, str);
            } else if (this.f58419c != null && this.f58419c.size() <= 0) {
                dVar.a(true, str);
            }
        } catch (Exception unused) {
        }
    }

    private void a(a aVar, int i2, CJRTransaction cJRTransaction) {
        a aVar2 = aVar;
        int f2 = com.paytm.utility.b.f(this.f58417a);
        int i3 = f2 / 2;
        int a2 = com.paytm.utility.b.a((Activity) this.f58417a) - (((i3 * 2) + ((int) (((double) f2) * 3.5d))) + i3);
        ArrayList<CJRButton> buttonList = cJRTransaction.getButtonList();
        aVar2.f58464i.removeAllViews();
        aVar2.j.removeAllViews();
        if (buttonList == null || buttonList.size() <= 0) {
            aVar2.f58464i.setVisibility(8);
            return;
        }
        aVar2.f58464i.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < buttonList.size(); i4++) {
            CJRButton cJRButton = buttonList.get(i4);
            if (cJRTransaction.isBtnEnabled()) {
                if (cJRButton.getActionUrl() != null && cJRButton.getActionUrl().toLowerCase().endsWith("refundtopg") && !net.one97.paytm.passbook.mapping.c.ao(this.f58417a)) {
                } else if (cJRButton.getActionUrl() == null && cJRTransaction.getType().equalsIgnoreCase("1") && cJRTransaction.getLabel().equalsIgnoreCase("UTS")) {
                    aVar2.j.setVisibility(0);
                    LinearLayout linearLayout = aVar2.j;
                    String buttonName = cJRButton.getButtonName();
                    final String walletOrderId = cJRTransaction.getWalletOrderId();
                    Button button = new Button(this.f58417a);
                    button.setText(buttonName);
                    button.setTag(buttonName);
                    button.setTextColor(this.f58417a.getResources().getColor(R.color.paytm_blue));
                    button.setTextSize(2, 13.0f);
                    button.setPadding(8, 0, 8, 0);
                    button.setBackgroundColor(0);
                    button.setTextColor(androidx.core.content.b.c(this.f58417a, R.color.color_blue_passbook_action));
                    button.setTypeface(com.paytm.utility.w.a(this.f58417a, "Roboto-Medium.ttf"));
                    button.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            e eVar = e.this;
                            try {
                                if (eVar.f58424h == null) {
                                    eVar.f58424h = net.one97.paytm.passbook.mapping.c.f(eVar.f58418b.getActivity());
                                }
                                if (eVar.f58424h != null && !eVar.f58424h.isShowing()) {
                                    eVar.f58424h.show();
                                }
                            } catch (Exception unused) {
                            }
                            e.a(e.this, walletOrderId);
                        }
                    });
                    linearLayout.addView(button);
                } else if (cJRTransaction.isInvoiceProcessed() && !v.a(cJRButton.getActionUrl())) {
                }
            }
            int size = arrayList.size();
            arrayList.add(cJRButton.getButtonName());
            cJRButton.setButtonTag(size);
        }
        if (arrayList.size() > 0) {
            new net.one97.paytm.passbook.customview.a(this.f58417a, this, arrayList, aVar2.f58464i, a2, i2, cJRTransaction, "");
            return;
        }
        aVar2.f58464i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(final net.one97.paytm.passbook.mapping.a.b bVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f58417a);
        builder.setTitle(this.f58417a.getString(R.string.no_connection));
        builder.setMessage(this.f58417a.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(this.f58417a.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(e.this.f58417a)) {
                    Context unused = e.this.f58417a;
                    net.one97.paytm.passbook.mapping.a.c.a();
                    net.one97.paytm.passbook.mapping.a.c.b(bVar);
                    return;
                }
                e.this.a(bVar);
            }
        });
        builder.show();
    }

    private g c() {
        return new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                e eVar = e.this;
                e.a(eVar, eVar.f58417a.getString(R.string.error), e.this.f58417a.getString(R.string.some_went_wrong));
                e.this.a();
            }
        };
    }

    private i.a<IJRDataModel> d() {
        return new i.a<IJRDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                e.this.a();
                if (iJRDataModel instanceof CJRBusInvoiceModel) {
                    CJRBusInvoiceModel cJRBusInvoiceModel = (CJRBusInvoiceModel) iJRDataModel;
                    if (cJRBusInvoiceModel.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                        net.one97.paytm.passbook.d.b();
                        e.this.f58418b.getActivity();
                        return;
                    }
                    e eVar = e.this;
                    e.a(eVar, eVar.f58418b.getString(R.string.error), cJRBusInvoiceModel.getmStatusMessage());
                }
            }
        };
    }

    public int getItemCount() {
        ArrayList<CJRTransaction> arrayList = this.f58419c;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f58419c.size();
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f58456a;

        /* renamed from: b  reason: collision with root package name */
        TextView f58457b;

        /* renamed from: c  reason: collision with root package name */
        TextView f58458c;

        /* renamed from: d  reason: collision with root package name */
        TextView f58459d;

        /* renamed from: e  reason: collision with root package name */
        TextView f58460e;

        /* renamed from: f  reason: collision with root package name */
        TextView f58461f;

        /* renamed from: g  reason: collision with root package name */
        TextView f58462g;

        /* renamed from: h  reason: collision with root package name */
        CircularImageView f58463h;

        /* renamed from: i  reason: collision with root package name */
        LinearLayout f58464i;
        LinearLayout j;
        LinearLayout k;
        RelativeLayout l;
        ImageView m;

        public a(View view) {
            super(view);
            this.k = (LinearLayout) view.findViewById(R.id.passbook_extrainfo_foodcards_layout);
            this.f58456a = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f58457b = (TextView) view.findViewById(R.id.passbook_send_receive_name);
            this.f58458c = (TextView) view.findViewById(R.id.passbook_send_receive_time);
            this.f58459d = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f58463h = (CircularImageView) view.findViewById(R.id.passbook_payer_or_payee_icons_iv);
            this.f58464i = (LinearLayout) view.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
            this.j = (LinearLayout) view.findViewById(R.id.passbook_bus_view_receipt_ll);
            this.l = (RelativeLayout) view.findViewById(R.id.passbook_entry_row_rl);
            this.m = (ImageView) view.findViewById(R.id.passbook_payer_or_payee_ledger_icon_bg_iv);
            this.f58460e = (TextView) view.findViewById(R.id.passbook_send_receive_txn_dsc_2tv);
            this.f58461f = (TextView) view.findViewById(R.id.passbook_send_receive_wallet_ord_id_tv);
            this.f58462g = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
        }
    }

    public final CJRTransaction a(int i2) {
        ArrayList<CJRTransaction> arrayList = this.f58419c;
        if (arrayList == null || arrayList.size() <= 0 || i2 < 0) {
            return null;
        }
        return this.f58419c.get(i2);
    }

    public final void a(ArrayList<CJRTransaction> arrayList) {
        this.f58419c = arrayList;
        a(this.f58418b, this.j);
        notifyDataSetChanged();
    }

    private void a(CJRButton cJRButton, String str, CJRTransaction cJRTransaction) {
        Dialog dialog = new Dialog(this.f58417a);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.pass_dialog_modal);
        ((TextView) dialog.findViewById(R.id.title)).setText(cJRButton.getModalButtonHeader());
        TextView textView = (TextView) dialog.findViewById(R.id.message);
        textView.setText(cJRButton.getModalButtonText());
        textView.setMinWidth(com.paytm.utility.b.f(this.f58417a) * 14);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.lyt_btn_container);
        ArrayList<CJRModalButton> modalButtonList = cJRButton.getModalButtonList();
        linearLayout.removeAllViews();
        Iterator<CJRModalButton> it2 = modalButtonList.iterator();
        while (it2.hasNext()) {
            final CJRModalButton next = it2.next();
            if (next.getModalActionUrlRequest() == null || next.getModalActionUrlRequest().getOperationType() != "P2P_TRANSFER") {
                Button button = new Button(this.f58417a);
                button.setBackgroundResource(R.drawable.pass_bg_square_btn_blue);
                button.setTextColor(-1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.weight = 1.0f;
                button.setLayoutParams(layoutParams);
                button.setText(next.getmModalButtonName());
                button.setTextSize(2, 16.0f);
                com.paytm.utility.b.a((TextView) button);
                final String str2 = str;
                final CJRTransaction cJRTransaction2 = cJRTransaction;
                final Dialog dialog2 = dialog;
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        final String modalActionUrl = next.getModalActionUrl();
                        String modalActionPage = next.getModalActionPage();
                        if (modalActionPage == null || !modalActionPage.equalsIgnoreCase("paytmCash")) {
                            if (modalActionUrl != null) {
                                if (TextUtils.isEmpty(next.getName()) || (!next.getName().equalsIgnoreCase("Send to bank") && !next.getName().equalsIgnoreCase("return to bank"))) {
                                    e.this.a(modalActionUrl, e.b(next.getModalActionUrlRequest()));
                                } else if (e.this.f58418b != null && e.this.f58418b.getActivity() != null && !e.this.f58418b.getActivity().isFinishing() && !e.this.f58418b.isDetached()) {
                                    try {
                                        d unused = e.this.l = new d(new b() {
                                            public final void a() {
                                                e.this.a(modalActionUrl, e.b(next.getModalActionUrlRequest()));
                                            }
                                        }, str2);
                                        e.this.l.show(e.this.f58418b.getChildFragmentManager().a(), "sendToBankdialog");
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                            String modalRespAction = next.getModalRespAction();
                            if (modalRespAction != null && modalRespAction.equalsIgnoreCase("RELOAD") && e.this.f58418b != null && (e.this.f58418b instanceof c)) {
                                e.this.f58418b.d();
                            }
                        } else if (e.this.f58418b != null && (e.this.f58418b instanceof c)) {
                            e.this.f58418b.a(str2);
                        }
                        dialog2.dismiss();
                    }
                });
                linearLayout.addView(button);
            } else {
                com.paytm.utility.b.j();
            }
        }
        dialog.show();
    }

    /* access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        d dVar = this.f58418b;
        if (dVar != null && (dVar instanceof c)) {
            dVar.a(str, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject b(CJRModalActionUrlRequest cJRModalActionUrlRequest) {
        if (cJRModalActionUrlRequest == null) {
            return null;
        }
        HashMap<Object, Object> request = cJRModalActionUrlRequest.getRequest();
        JSONObject jSONObject = new JSONObject();
        if (request != null) {
            try {
                jSONObject.put("request", new JSONObject(request));
            } catch (JSONException unused) {
            }
        }
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, cJRModalActionUrlRequest.getIpAddress());
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, cJRModalActionUrlRequest.getPlatformName());
        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, cJRModalActionUrlRequest.getOperationType());
        jSONObject.put("metadata", cJRModalActionUrlRequest.getMetadata());
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static JSONObject b(CJRActionUrlRequest cJRActionUrlRequest) {
        if (cJRActionUrlRequest == null) {
            return null;
        }
        HashMap<Object, Object> request = cJRActionUrlRequest.getRequest();
        JSONObject jSONObject = new JSONObject();
        if (request != null) {
            try {
                jSONObject.put("request", new JSONObject(request));
            } catch (JSONException unused) {
            }
        }
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, cJRActionUrlRequest.getIpAddress());
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, cJRActionUrlRequest.getPlatformName());
        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, cJRActionUrlRequest.getOperationType());
        jSONObject.put("metadata", cJRActionUrlRequest.getMetadata());
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, Context context) {
        int[] iArr = {R.drawable.pass_tick_transparent};
        if (this.f58423g >= 16) {
            view.setBackground(a(context, iArr));
        } else {
            view.setBackgroundDrawable(a(context, iArr));
        }
    }

    private static LayerDrawable a(Context context, int[] iArr) {
        Resources resources = context.getResources();
        Drawable[] drawableArr = new Drawable[1];
        for (int i2 = 0; i2 <= 0; i2++) {
            drawableArr[0] = resources.getDrawable(iArr[0]);
        }
        return new LayerDrawable(drawableArr);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            if (this.f58424h != null && this.f58424h.isShowing()) {
                this.f58424h.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public static class d extends net.one97.paytm.i.g {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final b f58465a;

        /* renamed from: b  reason: collision with root package name */
        private final String f58466b;

        /* renamed from: c  reason: collision with root package name */
        private Button f58467c;

        /* renamed from: d  reason: collision with root package name */
        private RoboTextView f58468d;

        /* renamed from: e  reason: collision with root package name */
        private RoboTextView f58469e;

        public d(b bVar, String str) {
            this.f58465a = bVar;
            this.f58466b = str;
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.pass_alert_dialog_send_to_bank, viewGroup);
            getDialog().getWindow().getAttributes().windowAnimations = R.style.CustomPincodeDialogAnimation;
            getDialog().getWindow().requestFeature(1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.f58467c = (Button) inflate.findViewById(R.id.btn_send_to_bank);
            this.f58468d = (RoboTextView) inflate.findViewById(R.id.txt4);
            this.f58469e = (RoboTextView) inflate.findViewById(R.id.txt2);
            String string = getString(R.string.wallet_rs);
            this.f58469e.setText(String.format(string, new Object[]{this.f58466b}));
            this.f58467c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.f58465a.a();
                    d.this.getDialog().dismiss();
                }
            });
            this.f58468d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.getDialog().dismiss();
                }
            });
            return inflate;
        }
    }

    private void a(LinearLayout linearLayout, ArrayList<ExtendedTxnInfo> arrayList) {
        if (arrayList != null) {
            linearLayout.findViewById(R.id.extendedinfo_heading);
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.passbook_extrainfo_foodcards_txn_layout);
            linearLayout2.removeAllViews();
            Iterator<ExtendedTxnInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ExtendedTxnInfo next = it2.next();
                View inflate = LayoutInflater.from(this.f58417a).inflate(R.layout.pass_row_extended_info, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(R.id.wallet_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.wallet_amount);
                if (!TextUtils.isEmpty(next.getDisplayName())) {
                    textView.setText(String.format(this.f58417a.getResources().getString(R.string.bullet), new Object[]{next.getDisplayName()}));
                    if (!TextUtils.isEmpty(next.getDisplayName())) {
                        String string = this.f58417a.getResources().getString(R.string.simple_amount);
                        StringBuilder sb = new StringBuilder();
                        sb.append(next.getAmount());
                        net.one97.paytm.passbook.mapping.c.a(String.format(string, new Object[]{sb.toString()}), textView2);
                        linearLayout2.addView(inflate);
                    }
                }
            }
            linearLayout.setVisibility(0);
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (this.j.equals("DR")) {
            return "paid";
        }
        if (this.j.equals("CR")) {
            return "received";
        }
        return this.j.equals("CR_added") ? SyncContactBean.Status.STATUS_ADDED : StringSet.all;
    }

    public final void a(int i2, final int i3) {
        Context context;
        this.f58425i = true;
        final CJRButton buttonWithTag = this.f58419c.get(i3).getButtonWithTag(i2);
        String txnAmount = this.f58419c.get(i3).getTxnAmount();
        if (buttonWithTag != null) {
            try {
                if ("3".equalsIgnoreCase(this.f58419c.get(i3).getType())) {
                    final Dialog dialog = new Dialog(this.f58417a);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(R.layout.pass_dialog_return_to_bank);
                    ((TextView) dialog.findViewById(R.id.dialog_returntobank_amount)).setText(String.format(this.f58417a.getResources().getString(R.string.wallet_rs), new Object[]{txnAmount}));
                    ((Button) dialog.findViewById(R.id.dialog_returntobank_positive_action)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            JSONObject a2 = e.b(buttonWithTag.getActionUrlRequest());
                            e eVar = e.this;
                            String actionUrl = buttonWithTag.getActionUrl();
                            e.this.f58419c.get(i3);
                            eVar.a(actionUrl, a2);
                            dialog.dismiss();
                        }
                    });
                    ((TextView) dialog.findViewById(R.id.dialog_returntobank_negative_action)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                    return;
                }
            } catch (Exception unused) {
            }
            final CJRTransaction cJRTransaction = this.f58419c.get(i3);
            if (buttonWithTag.getAction().equalsIgnoreCase("Modal")) {
                a(buttonWithTag, txnAmount, cJRTransaction);
                return;
            }
            String actionPage = buttonWithTag.getActionPage();
            if (actionPage != null && actionPage.equalsIgnoreCase("paytmCash")) {
                this.f58418b.a(txnAmount);
            } else if (TextUtils.isEmpty(buttonWithTag.getButtonName()) || (!buttonWithTag.getButtonName().equalsIgnoreCase("Send to bank") && !buttonWithTag.getButtonName().equalsIgnoreCase("return to bank"))) {
                a(buttonWithTag.getActionUrl(), b(buttonWithTag.getActionUrlRequest()));
            } else {
                d dVar = this.f58418b;
                if (dVar != null && dVar.getActivity() != null && !this.f58418b.getActivity().isFinishing() && !this.f58418b.isDetached()) {
                    try {
                        this.l = new d(new b() {
                            public final void a() {
                                e.this.a(buttonWithTag.getActionUrl(), e.b(buttonWithTag.getActionUrlRequest()));
                            }
                        }, txnAmount);
                        this.l.show(this.f58418b.getChildFragmentManager().a(), "sendToBankdialog");
                    } catch (Exception unused2) {
                    }
                }
            }
            String respAction = buttonWithTag.getRespAction();
            if (respAction != null && respAction.equalsIgnoreCase("RELOAD") && (context = this.f58417a) != null && !(context instanceof PassbookSearchActivity)) {
                this.f58418b.d();
                return;
            }
            return;
        }
        com.paytm.utility.b.j();
    }

    private Drawable a(String str) {
        Drawable drawable = this.m.get(str);
        if (drawable == null) {
            if (str.equalsIgnoreCase("CR")) {
                drawable = this.f58417a.getResources().getDrawable(R.drawable.pass_money_received);
            } else if (str.equalsIgnoreCase("DR")) {
                drawable = this.f58417a.getResources().getDrawable(R.drawable.pass_money_sent);
            } else if (str.equalsIgnoreCase("CR_added")) {
                drawable = this.f58417a.getResources().getDrawable(R.drawable.pass_money_received);
            }
            if (this.m.get(str) == null) {
                this.m.put(str, drawable);
            }
        }
        if (drawable == null) {
            return null;
        }
        return drawable;
    }

    public /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_passbook_item_row_layout, viewGroup, false));
    }

    static /* synthetic */ void a(e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("systemTxnId", str);
            jSONObject.put("request", jSONObject2);
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "192.168.1.100");
            jSONObject.put("channel", "WEB");
            jSONObject.put("version", "1.0");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "WITHDRAW_MONEY");
        } catch (JSONException unused) {
        }
        String a2 = net.one97.paytm.passbook.d.b().a("utsGetInvoiceUrl");
        if (a2 != null) {
            String e2 = com.paytm.utility.b.e(eVar.f58417a, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", com.paytm.utility.a.q(eVar.f58417a));
            hashMap.put("Accept-Encoding", "gzip");
            if (com.paytm.utility.b.c(eVar.f58417a)) {
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(e2, eVar.d(), eVar.c(), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.subWallet.b.d.class.getName()));
                return;
            }
            eVar.a(new net.one97.paytm.passbook.mapping.a.b(e2, eVar.d(), eVar.c(), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, e.class.getName()));
        }
    }

    static /* synthetic */ void a(e eVar, String str, String str2) {
        if (eVar.f58418b.getActivity() != null && !eVar.f58418b.isDetached()) {
            final h hVar = new h(eVar.f58417a);
            if (TextUtils.isEmpty(str)) {
                str = eVar.f58417a.getResources().getString(R.string.alert);
            }
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.a(-3, eVar.f58417a.getResources().getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                }
            });
            hVar.show();
        }
    }

    static /* synthetic */ void a(e eVar, final CJRTransaction cJRTransaction) {
        final h hVar = new h(eVar.f58417a);
        hVar.setTitle(eVar.f58417a.getString(R.string.needhelp_dialog_title));
        hVar.a(eVar.f58417a.getString(R.string.passbook_contact_us_order_history));
        hVar.a(-3, eVar.f58417a.getResources().getString(R.string.passbook_go_to_order_history), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
                Intent intent = new Intent(e.this.f58417a, net.one97.paytm.passbook.d.b().i());
                intent.putExtra(UpiConstants.FROM, "Order_history");
                intent.putExtra("order_id", cJRTransaction.getTxnDescription1());
                e.this.f58417a.startActivity(intent);
            }
        });
        hVar.setCancelable(true);
        hVar.show();
    }
}
