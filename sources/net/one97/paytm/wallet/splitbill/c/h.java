package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gson.g;
import com.paytm.network.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.network.f;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText;
import net.one97.paytm.wallet.newdesign.universalp2p.utils.a;
import net.one97.paytm.wallet.splitbill.activity.SBBillDetailActivity;
import net.one97.paytm.wallet.splitbill.activity.SBLandingPageActivity;
import net.one97.paytm.wallet.splitbill.activity.SBSearchContactListActivity;
import net.one97.paytm.wallet.splitbill.activity.SBSplitBillActivity;
import net.one97.paytm.wallet.splitbill.activity.SBSplitBillForTwoActivity;
import net.one97.paytm.wallet.splitbill.b.e;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.e.c;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBAddBillModel;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBAddBillResponse;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBContact;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBCreateGroupModel;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBBillDetailResponse;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBSubRequest;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;

public class h extends net.one97.paytm.i.h implements e {
    private RelativeLayout A;
    private RelativeLayout B;
    private String C;
    private ImageView D;
    private Button E;
    /* access modifiers changed from: private */
    public boolean F = false;
    private boolean G = false;
    private SBBillDetailResponse H;
    /* access modifiers changed from: private */
    public String I;
    /* access modifiers changed from: private */
    public String J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public String L;
    private LottieAnimationView M;
    private String N;
    /* access modifiers changed from: private */
    public boolean O = true;
    private TextWatcher P = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f72172g.setVisibility(8);
            if (h.this.f72169d == null) {
                return;
            }
            if (charSequence.toString().length() <= 0) {
                h.this.f72169d.setTextColor(h.this.f72166a.getResources().getColor(R.color.color_b8c2cb));
            } else if (Double.parseDouble(charSequence.toString().trim()) > 999999.99d) {
                h.this.f72172g.setVisibility(0);
                String substring = charSequence.toString().substring(0, charSequence.length() - 1);
                h.this.f72168c.setText(substring);
                h.this.f72168c.setSelection(substring.toString().length());
            } else {
                if (charSequence.toString().contains(AppUtility.CENTER_DOT) && charSequence.toString().length() - charSequence.toString().indexOf(AppUtility.CENTER_DOT) > 3) {
                    String substring2 = charSequence.toString().substring(0, charSequence.toString().length() - 1);
                    h.this.f72168c.setText(substring2.toString());
                    h.this.f72168c.setSelection(substring2.toString().length());
                }
                h.this.f72169d.setTextColor(h.this.f72166a.getResources().getColor(R.color.color_222222));
                if (h.this.O) {
                    Iterator it2 = h.this.s.iterator();
                    while (it2.hasNext()) {
                        SBContactDetail sBContactDetail = (SBContactDetail) it2.next();
                        if (sBContactDetail.ismIsSelectedForPay()) {
                            sBContactDetail.setmIsSelectedForPay(false);
                        }
                    }
                    boolean unused = h.this.u = true;
                    h.this.w.setText("You");
                    h.this.v.setText("Equally");
                    return;
                }
                boolean unused2 = h.this.O = true;
            }
        }
    };
    private TextWatcher Q = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f72174i.setVisibility(8);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f72166a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<SBContactDetail> f72167b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f72168c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f72169d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f72170e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f72171f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f72172g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f72173h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f72174i;
    private TextView j;
    /* access modifiers changed from: private */
    public CommentsEditText k;
    /* access modifiers changed from: private */
    public View l;
    /* access modifiers changed from: private */
    public View m;
    /* access modifiers changed from: private */
    public String n;
    private FrameLayout o;
    private FrameLayout p;
    private String q;
    /* access modifiers changed from: private */
    public SBGroupDetailsDtoList r;
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> s = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> t = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public TextView v;
    /* access modifiers changed from: private */
    public TextView w;
    private TextView x;
    private c y;
    /* access modifiers changed from: private */
    public LinearLayout z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.sb_fragment_enter_bill_amount, (ViewGroup) null);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72166a = (Activity) context;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey("list")) {
                this.f72167b = (ArrayList) getArguments().getSerializable("list");
            }
            if (getArguments().containsKey("group_name")) {
                this.n = getArguments().getString("group_name");
            }
            if (getArguments().containsKey("group_detail")) {
                this.r = (SBGroupDetailsDtoList) getArguments().getSerializable("group_detail");
            }
            if (getArguments().containsKey("paid_contact_list")) {
                this.s = (ArrayList) getArguments().getSerializable("paid_contact_list");
            }
            if (getArguments().containsKey("split_contact_list")) {
                this.t = (ArrayList) getArguments().getSerializable("split_contact_list");
            }
            if (getArguments().containsKey("equally_switch")) {
                this.u = getArguments().getBoolean("equally_switch");
            }
            if (getArguments().containsKey("group_id")) {
                this.C = getArguments().getString("group_id");
            }
            if (getArguments().containsKey("edit_bill")) {
                this.F = getArguments().getBoolean("edit_bill");
                this.O = false;
            }
            if (getArguments().containsKey("is_from_contact_selection")) {
                this.G = getArguments().getBoolean("is_from_contact_selection");
            }
            if (getArguments().containsKey("bill_name")) {
                this.I = getArguments().getString("bill_name");
            }
            if (getArguments().containsKey("bill_id")) {
                this.L = getArguments().getString("bill_id");
            }
            if (getArguments().containsKey("amount_from_deeplink")) {
                this.N = getArguments().getString("amount_from_deeplink");
            }
            if (getArguments().containsKey("your_id")) {
                this.J = getArguments().getString("your_id");
            }
            if (getArguments().containsKey("bill_detail_response")) {
                this.H = (SBBillDetailResponse) getArguments().getSerializable("bill_detail_response");
                SBBillDetailResponse sBBillDetailResponse = this.H;
                if (sBBillDetailResponse != null) {
                    if (sBBillDetailResponse == null || sBBillDetailResponse.getSplitTag() == null || !"EQUAL".equalsIgnoreCase(this.H.getSplitTag())) {
                        this.u = false;
                    } else {
                        this.u = true;
                    }
                    this.L = this.H.getId();
                    SBBillDetailResponse sBBillDetailResponse2 = this.H;
                    ArrayList<SBContactDetail> arrayList = new ArrayList<>();
                    if (!(sBBillDetailResponse2 == null || sBBillDetailResponse2.getSubRequest() == null)) {
                        Iterator<SBSubRequest> it2 = sBBillDetailResponse2.getSubRequest().iterator();
                        while (it2.hasNext()) {
                            SBSubRequest next = it2.next();
                            SBContactDetail sBContactDetail = new SBContactDetail();
                            sBContactDetail.setUserId(next.getUserId());
                            sBContactDetail.setmName(next.getName());
                            sBContactDetail.setMobile(next.getMobile());
                            sBContactDetail.setAmount(next.getAmount());
                            if (Double.valueOf(next.getAmount()).doubleValue() > 0.0d) {
                                sBContactDetail.setmIsSelectedForPay(true);
                                if ("You".equalsIgnoreCase(next.getName())) {
                                    sBContactDetail.setAdmin(true);
                                } else {
                                    sBContactDetail.setAdmin(false);
                                }
                            }
                            arrayList.add(sBContactDetail);
                        }
                    }
                    this.s = arrayList;
                    this.t = b(this.H);
                    this.f72167b = a(this.H);
                }
            }
            if (getArguments().containsKey("bill_amount")) {
                this.K = getArguments().getString("bill_amount");
            }
        }
        this.o = (FrameLayout) view.findViewById(R.id.fmLayoutPaidBy);
        this.p = (FrameLayout) view.findViewById(R.id.fmLayoutSplitBy);
        this.f72172g = (TextView) view.findViewById(R.id.amount_error);
        this.f72171f = (TextView) view.findViewById(R.id.tvGroupName);
        this.k = (CommentsEditText) view.findViewById(R.id.et_type_message);
        this.k.addTextChangedListener(this.Q);
        this.f72169d = (TextView) view.findViewById(R.id.tv_uni_p2p_rs_symbol);
        this.f72168c = (EditText) view.findViewById(R.id.et_amount);
        this.f72168c.addTextChangedListener(this.P);
        this.f72170e = (TextView) view.findViewById(R.id.tv_uni_add_msg);
        this.l = view.findViewById(R.id.v_uni_et_sep_2);
        this.m = view.findViewById(R.id.v_uni_et_sep_1);
        this.f72173h = (TextView) view.findViewById(R.id.tvGroupDescription);
        this.w = (TextView) view.findViewById(R.id.tvPaidBy);
        this.v = (TextView) view.findViewById(R.id.tvSplitBy);
        this.x = (TextView) view.findViewById(R.id.tvaddbill);
        this.y = new c(this.f72166a, this);
        this.z = (LinearLayout) view.findViewById(R.id.status_ticker_view);
        this.A = (RelativeLayout) view.findViewById(R.id.toolbar_start_ap);
        this.f72174i = (TextView) view.findViewById(R.id.comment_error);
        this.B = (RelativeLayout) view.findViewById(R.id.bill_members);
        this.j = (TextView) view.findViewById(R.id.tvaddbill);
        this.D = (ImageView) view.findViewById(R.id.split_back_button);
        this.E = (Button) view.findViewById(R.id.proceedToBill);
        this.M = (LottieAnimationView) view.findViewById(R.id.lav_lottie_loader);
        this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    h.this.l.setBackgroundColor(Color.parseColor("#00b9f5"));
                } else {
                    h.this.l.setBackgroundColor(Color.parseColor("#f3f7f8"));
                }
            }
        });
        this.f72168c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    h.this.m.setBackgroundColor(Color.parseColor("#00b9f5"));
                } else {
                    h.this.m.setBackgroundColor(Color.parseColor("#f3f7f8"));
                }
            }
        });
        a(this.s, this.t, this.u, this.K);
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h hVar = h.this;
                String unused = hVar.I = hVar.k.getText().toString();
                if (TextUtils.isEmpty(h.this.f72168c.getText().toString())) {
                    h.this.f72172g.setVisibility(0);
                } else if (h.this.f72167b.size() <= 2) {
                    Intent intent = new Intent(h.this.f72166a, SBSplitBillForTwoActivity.class);
                    intent.putExtra("bill_amount", h.this.f72168c.getText().toString());
                    intent.putExtra("list", h.this.f72167b);
                    intent.putExtra("paid_contact_list", h.this.s);
                    intent.putExtra("split_contact_list", h.this.t);
                    intent.putExtra("split_options", "paid_by");
                    intent.putExtra("equally_switch", h.this.u);
                    h.this.f72166a.startActivityForResult(intent, 1);
                } else {
                    Intent intent2 = new Intent(h.this.f72166a, SBSplitBillActivity.class);
                    intent2.putExtra("bill_amount", h.this.f72168c.getText().toString());
                    intent2.putExtra("list", h.this.f72167b);
                    intent2.putExtra("paid_contact_list", h.this.s);
                    intent2.putExtra("split_contact_list", h.this.t);
                    intent2.putExtra("split_options", "paid_by");
                    intent2.putExtra("equally_switch", h.this.u);
                    h.this.f72166a.startActivityForResult(intent2, 1);
                }
                ArrayList arrayList = new ArrayList();
                if (h.this.F) {
                    arrayList.add("editBill");
                } else {
                    arrayList.add("newBill");
                }
                b.a(h.this.f72166a, "split_bill", "customise_split", arrayList, "", "/splitbill/newedit", "split_bill");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h hVar = h.this;
                String unused = hVar.I = hVar.k.getText().toString();
                if (TextUtils.isEmpty(h.this.f72168c.getText().toString())) {
                    h.this.f72172g.setVisibility(0);
                } else if (h.this.f72167b.size() <= 2) {
                    Intent intent = new Intent(h.this.f72166a, SBSplitBillForTwoActivity.class);
                    intent.putExtra("bill_amount", h.this.f72168c.getText().toString());
                    intent.putExtra("list", h.this.f72167b);
                    intent.putExtra("paid_contact_list", h.this.s);
                    intent.putExtra("split_contact_list", h.this.t);
                    intent.putExtra("split_options", "split_by");
                    intent.putExtra("equally_switch", h.this.u);
                    h.this.f72166a.startActivityForResult(intent, 1);
                } else {
                    Intent intent2 = new Intent(h.this.f72166a, SBSplitBillActivity.class);
                    intent2.putExtra("bill_amount", h.this.f72168c.getText().toString());
                    intent2.putExtra("list", h.this.f72167b);
                    intent2.putExtra("paid_contact_list", h.this.s);
                    intent2.putExtra("split_contact_list", h.this.t);
                    intent2.putExtra("split_options", "split_by");
                    intent2.putExtra("equally_switch", h.this.u);
                    h.this.f72166a.startActivityForResult(intent2, 1);
                }
                ArrayList arrayList = new ArrayList();
                if (h.this.F) {
                    arrayList.add("editBill");
                } else {
                    arrayList.add("newBill");
                }
                b.a(h.this.f72166a, "split_bill", "customise_split", arrayList, "", "/splitbill/newedit", "split_bill");
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.startActivity(new Intent(h.this.f72166a, SBLandingPageActivity.class));
            }
        });
        this.f72170e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.f72170e.setVisibility(8);
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            a.a(h.this.l);
                            h.this.k.setVisibility(0);
                            h.this.k.requestFocus();
                        } catch (Exception unused) {
                            h.this.k.setVisibility(0);
                            h.this.k.requestFocus();
                            h.this.l.setVisibility(0);
                        }
                    }
                }, 160);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.f72166a.finish();
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                if (TextUtils.isEmpty(h.this.f72168c.getText().toString())) {
                    h.this.f72172g.setVisibility(0);
                } else if (TextUtils.isEmpty(h.this.k.getText().toString())) {
                    h.this.f72174i.setVisibility(0);
                } else {
                    Iterator it2 = h.this.s.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((SBContactDetail) it2.next()).getmIsSelectedForPay()) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        Iterator it3 = h.this.s.iterator();
                        while (it3.hasNext()) {
                            SBContactDetail sBContactDetail = (SBContactDetail) it3.next();
                            if (sBContactDetail.getmName().equalsIgnoreCase("You")) {
                                sBContactDetail.setmIsSelectedForPay(true);
                                sBContactDetail.setmAmount(h.this.f72168c.getText().toString());
                            } else {
                                sBContactDetail.setmIsSelectedForPay(false);
                                sBContactDetail.setmAmount("0.0");
                            }
                        }
                        boolean unused = h.this.u = true;
                        Iterator it4 = h.this.t.iterator();
                        while (it4.hasNext()) {
                            ((SBContactDetail) it4.next()).setmAmount(String.valueOf(Double.valueOf(h.this.f72168c.getText().toString()).doubleValue() / ((double) h.this.t.size())));
                        }
                    }
                    h.this.a();
                }
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!h.this.F) {
                    c a2 = c.a();
                    String u = (h.this.n == null || TextUtils.isEmpty(h.this.n)) ? "Split New Bill" : h.this.n;
                    if (h.this.r == null || h.this.r.getUserDtoList() == null || h.this.r.getUserDtoList().size() <= 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it2 = h.this.f72167b.iterator();
                        while (it2.hasNext()) {
                            SBContactDetail sBContactDetail = (SBContactDetail) it2.next();
                            arrayList.add(new SBUserList(sBContactDetail.getUserId(), sBContactDetail.getmName(), Boolean.valueOf(sBContactDetail.isAdmin()), Boolean.valueOf(sBContactDetail.isAdmin())));
                        }
                        a2.a(u, arrayList, h.this.J);
                    } else {
                        a2.a(u, h.this.r.getUserDtoList(), h.this.J);
                    }
                    a2.show(h.this.getActivity().getSupportFragmentManager(), "bottom_sheet_group_member_list_fragment");
                    return;
                }
                Intent intent = new Intent(h.this.f72166a, SBSearchContactListActivity.class);
                intent.putExtra("show_group_widget", false);
                intent.putExtra("non_group_bill", true);
                intent.putExtra("edit_bill", true);
                intent.putExtra("list", h.this.f72167b);
                intent.putExtra("is_equal", h.this.u);
                intent.putExtra("bill_name", h.this.I);
                intent.putExtra("bill_amount", h.this.K);
                intent.putExtra("paid_contact_list", h.this.s);
                intent.putExtra("split_contact_list", h.this.t);
                intent.putExtra("bill_id", h.this.L);
                h.this.f72166a.startActivity(intent);
            }
        });
    }

    private static ArrayList<SBContactDetail> a(SBBillDetailResponse sBBillDetailResponse) {
        ArrayList<SBContactDetail> arrayList = new ArrayList<>();
        if (!(sBBillDetailResponse == null || sBBillDetailResponse.getSubRequest() == null)) {
            Iterator<SBSubRequest> it2 = sBBillDetailResponse.getSubRequest().iterator();
            while (it2.hasNext()) {
                SBSubRequest next = it2.next();
                SBContactDetail sBContactDetail = new SBContactDetail();
                sBContactDetail.setUserId(next.getUserId());
                sBContactDetail.setmName(next.getName());
                sBContactDetail.setMobile(next.getMobile());
                sBContactDetail.setAmount(next.getAmount());
                if ("You".equalsIgnoreCase(next.getName())) {
                    sBContactDetail.setAdmin(true);
                } else {
                    sBContactDetail.setAdmin(false);
                }
                if (Double.valueOf(next.getAmount()).doubleValue() > 0.0d) {
                    sBContactDetail.setmIsSelectedForPay(true);
                } else {
                    sBContactDetail.setmIsSelectedForPay(false);
                }
                arrayList.add(sBContactDetail);
            }
        }
        return arrayList;
    }

    private static ArrayList<SBContactDetail> b(SBBillDetailResponse sBBillDetailResponse) {
        ArrayList<SBContactDetail> arrayList = new ArrayList<>();
        if (!(sBBillDetailResponse == null || sBBillDetailResponse.getSubRequest() == null)) {
            Iterator<SBSubRequest> it2 = sBBillDetailResponse.getSubRequest().iterator();
            while (it2.hasNext()) {
                SBSubRequest next = it2.next();
                SBContactDetail sBContactDetail = new SBContactDetail();
                sBContactDetail.setUserId(next.getUserId());
                sBContactDetail.setmName(next.getName());
                sBContactDetail.setMobile(next.getMobile());
                sBContactDetail.setAmount(next.getShare());
                if ("You".equalsIgnoreCase(next.getName())) {
                    sBContactDetail.setAdmin(true);
                } else {
                    sBContactDetail.setAdmin(false);
                }
                arrayList.add(sBContactDetail);
            }
        }
        return arrayList;
    }

    public final void a(ArrayList<SBContactDetail> arrayList, ArrayList<SBContactDetail> arrayList2, boolean z2, String str) {
        this.K = str;
        if (!this.F) {
            String str2 = this.n;
            if (str2 == null || TextUtils.isEmpty(str2)) {
                this.x.setVisibility(4);
                this.f72171f.setText("Split New Bill");
                this.f72173h.setText(b(this.f72167b));
            } else {
                this.f72171f.setText(this.n);
                ArrayList<SBContactDetail> arrayList3 = this.f72167b;
                if (arrayList3 == null || arrayList3.size() == 0) {
                    this.f72173h.setText(a(this.r));
                } else {
                    this.f72173h.setText(b(this.f72167b));
                }
            }
            String str3 = this.N;
            if (str3 != null) {
                this.f72168c.setText(a(Double.valueOf(str3)));
                EditText editText = this.f72168c;
                editText.setSelection(editText.getText().toString().length());
            }
        } else {
            this.f72171f.setText("Edit Bill");
            this.f72173h.setText(b(this.f72167b));
            this.j.setVisibility(8);
            String str4 = this.K;
            if (str4 != null) {
                this.f72168c.setText(str4);
                EditText editText2 = this.f72168c;
                editText2.setSelection(editText2.getText().toString().length());
            } else {
                this.K = a(this.H.getTotalAmount());
                this.f72168c.setText(a(this.H.getTotalAmount()));
                EditText editText3 = this.f72168c;
                editText3.setSelection(editText3.getText().toString().length());
            }
            String str5 = this.I;
            if (str5 != null) {
                this.k.setText(str5);
            } else {
                this.I = this.H.getName();
                this.k.setText(this.H.getName());
            }
            this.E.setText("Save");
        }
        this.u = z2;
        this.s = arrayList;
        this.t = arrayList2;
        if (this.u) {
            this.v.setText(this.f72166a.getResources().getString(R.string.equally));
        } else {
            this.v.setText("Unequally");
        }
        ArrayList<SBContactDetail> arrayList4 = this.s;
        if (arrayList4 == null || arrayList4.size() <= 1) {
            this.w.setText("You");
        } else {
            this.w.setText(a(this.s));
        }
    }

    private static String a(ArrayList<SBContactDetail> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        int i2 = 0;
        boolean z2 = false;
        while (it2.hasNext()) {
            SBContactDetail next = it2.next();
            if (next.getmName().equalsIgnoreCase("You") && next.getmIsSelectedForPay()) {
                sb.append("You ");
                z2 = true;
            }
        }
        if (z2) {
            Iterator<SBContactDetail> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                SBContactDetail next2 = it3.next();
                if (!next2.getmName().equalsIgnoreCase("You") && next2.getmIsSelectedForPay() && Double.parseDouble(next2.getmAmount()) > 0.0d) {
                    i2++;
                }
            }
            if (i2 == 0) {
                return sb.toString();
            }
            if (i2 == 1) {
                sb.append("& ");
                sb.append(i2);
                sb.append(" other");
                return sb.toString();
            }
            sb.append("& ");
            sb.append(i2);
            sb.append(" others");
            return sb.toString();
        }
        Iterator<SBContactDetail> it4 = arrayList.iterator();
        String str = "";
        while (it4.hasNext()) {
            SBContactDetail next3 = it4.next();
            if (!next3.getmName().equalsIgnoreCase("You") && next3.getmIsSelectedForPay()) {
                str = next3.getmName();
                i2++;
            }
        }
        if (i2 == 0) {
            return "You";
        }
        if (i2 == 1) {
            return String.valueOf(str);
        }
        return str + " & " + (i2 - 1) + " people";
    }

    /* access modifiers changed from: private */
    public void a() {
        String str;
        String str2;
        this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.grid_offer_blue));
        this.E.setClickable(false);
        try {
            net.one97.paytm.common.widgets.a.a(this.M);
        } catch (Exception unused) {
        }
        SBCreateGroupModel sBCreateGroupModel = new SBCreateGroupModel();
        sBCreateGroupModel.setClient(UpiConstants.B2C_ANDROID);
        sBCreateGroupModel.setCreatedBy(Long.toString(System.currentTimeMillis()));
        sBCreateGroupModel.setGroupName(this.n);
        this.I = this.k.getText().toString();
        sBCreateGroupModel.setDescription(this.I);
        sBCreateGroupModel.setName(this.I);
        sBCreateGroupModel.setCreatedBy(this.q);
        sBCreateGroupModel.setCreatedByCustId(com.paytm.utility.b.n((Context) this.f72166a));
        SBGroupDetailsDtoList sBGroupDetailsDtoList = this.r;
        if (sBGroupDetailsDtoList != null && !TextUtils.isEmpty(sBGroupDetailsDtoList.getGroupId())) {
            this.C = this.r.getGroupId();
        }
        sBCreateGroupModel.setGroupId(this.C);
        ArrayList<SBContactDetail> arrayList = this.s;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<SBContactDetail> it2 = this.s.iterator();
            while (it2.hasNext()) {
                SBContactDetail next = it2.next();
                if (next.getmAmount() != null && Double.parseDouble(next.getmAmount()) > 0.0d) {
                    arrayList2.add(new SBContact(next.getMobile(), next.getmAmount(), next.getUserId(), next.getmName()));
                }
            }
            sBCreateGroupModel.setPayeeList(arrayList2);
        }
        ArrayList<SBContactDetail> arrayList3 = this.t;
        if (arrayList3 != null && arrayList3.size() > 0) {
            ArrayList arrayList4 = new ArrayList();
            Iterator<SBContactDetail> it3 = this.t.iterator();
            while (it3.hasNext()) {
                SBContactDetail next2 = it3.next();
                if (next2.getmAmount() != null && Double.parseDouble(next2.getmAmount()) >= 0.0d) {
                    arrayList4.add(new SBContact(next2.getMobile(), next2.getmAmount(), next2.getUserId(), next2.getmName()));
                }
            }
            sBCreateGroupModel.setPayerList(arrayList4);
        }
        if (TextUtils.isEmpty(this.f72168c.getText().toString()) || Double.parseDouble(this.f72168c.getText().toString().trim()) <= 0.0d) {
            this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.paytm_blue));
            this.E.setClickable(true);
            this.f72172g.setVisibility(0);
            try {
                net.one97.paytm.common.widgets.a.b(this.M);
            } catch (Exception unused2) {
            }
        } else {
            sBCreateGroupModel.setTotalAmount(this.f72168c.getText().toString());
            if (this.u) {
                sBCreateGroupModel.setSplitTag("EQUAL");
            } else {
                sBCreateGroupModel.setSplitTag("MANUAL");
            }
            if (this.F) {
                sBCreateGroupModel.setRequestId(this.L);
            }
            SBAddBillModel sBAddBillModel = new SBAddBillModel();
            sBAddBillModel.setGroupId(sBCreateGroupModel.getGroupId());
            sBAddBillModel.setRequestId(sBCreateGroupModel.getRequestId());
            sBAddBillModel.setTotalAmount(sBCreateGroupModel.getTotalAmount());
            sBAddBillModel.setName(sBCreateGroupModel.getName());
            sBAddBillModel.setSplitTag(sBCreateGroupModel.getSplitTag());
            sBAddBillModel.setPayeeList(sBCreateGroupModel.getPayeeList());
            sBAddBillModel.setPayerList(sBCreateGroupModel.getPayerList());
            g gVar = new g();
            gVar.f39467e = false;
            String b2 = gVar.a().b(sBAddBillModel);
            if (!this.F) {
                if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72166a, "getAddBillRequestURL"))) {
                    str2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72166a, "getAddBillRequestURL");
                } else {
                    str2 = "https://prms.paytmbank.com/prms/ext/v1/request";
                }
                if (!TextUtils.isEmpty(str2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
                    hashMap.put("content-Type", "application/json");
                    hashMap.put("client-id", UpiConstants.B2C_ANDROID);
                    hashMap.put("user-token", com.paytm.utility.a.q(this.f72166a));
                    new net.one97.paytm.network.b(str2, new SBAddBillResponse(), (Map<String, String>) null, hashMap, b2).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            h.this.b((f) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72166a, "getAddBillRequestURL"))) {
                str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72166a, "getAddBillRequestURL");
            } else {
                str = "https://prms.paytmbank.com/prms/ext/v1/request";
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
                hashMap2.put("content-Type", "application/json");
                hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
                hashMap2.put("user-token", com.paytm.utility.a.q(this.f72166a));
                new net.one97.paytm.network.b(str, new SBAddBillResponse(), (Map<String, String>) null, hashMap2, b2, a.C0715a.PUT, a.c.WALLET, a.b.USER_FACING, getClass().getName()).c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        h.this.a((f) obj);
                    }
                });
            }
        }
    }

    private static String a(SBGroupDetailsDtoList sBGroupDetailsDtoList) {
        StringBuilder sb = new StringBuilder("You and ");
        sb.append(sBGroupDetailsDtoList.getUserDtoList().size() - 1);
        sb.append(" others");
        return sb.toString();
    }

    private static String b(ArrayList<SBContactDetail> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("You");
        int size = arrayList.size();
        if (size == 2) {
            Iterator<SBContactDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SBContactDetail next = it2.next();
                if (!"You".equalsIgnoreCase(next.getmName())) {
                    sb.append(" & ");
                    sb.append(next.getmName());
                }
            }
        } else if (size == 3) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<SBContactDetail> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                SBContactDetail next2 = it3.next();
                if (!"You".equalsIgnoreCase(next2.getmName())) {
                    arrayList2.add(next2.getmName());
                }
            }
            sb.append(", ");
            sb.append(((String) arrayList2.get(0)).split(" ")[0]);
            sb.append(" & ");
            sb.append(((String) arrayList2.get(1)).split(" ")[0]);
        } else if (size != 4) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<SBContactDetail> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                SBContactDetail next3 = it4.next();
                if (!"You".equalsIgnoreCase(next3.getmName())) {
                    arrayList3.add(next3.getmName());
                }
            }
            String str = arrayList.size() - 3 > 1 ? " other" : " others";
            sb.append(", ");
            sb.append(((String) arrayList3.get(0)).split(" ")[0]);
            sb.append(", ");
            sb.append(((String) arrayList3.get(1)).split(" ")[0]);
            sb.append(" & ");
            sb.append(arrayList.size() - 3);
            sb.append(str);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Iterator<SBContactDetail> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                SBContactDetail next4 = it5.next();
                if (!"You".equalsIgnoreCase(next4.getmName())) {
                    arrayList4.add(next4.getmName());
                }
            }
            sb.append(", ");
            sb.append(((String) arrayList4.get(0)).split(" ")[0]);
            sb.append(", ");
            sb.append(((String) arrayList4.get(1)).split(" ")[0]);
            sb.append(" & ");
            sb.append(((String) arrayList4.get(2)).split(" ")[0]);
        }
        return sb.toString();
    }

    public final void b() {
        a();
        this.z.setVisibility(8);
        this.A.setVisibility(0);
    }

    private static String a(Double d2) {
        if (Math.floor(d2.doubleValue()) == Math.ceil(d2.doubleValue())) {
            return new DecimalFormat("#").format(d2);
        }
        return d2.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        f fVar2 = fVar;
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar2.f55797b instanceof SBAddBillResponse) {
                SBAddBillResponse sBAddBillResponse = (SBAddBillResponse) fVar2.f55797b;
                if (sBAddBillResponse == null || sBAddBillResponse.getSuccess() == null || !sBAddBillResponse.getSuccess().booleanValue()) {
                    this.z.removeAllViews();
                    this.z.addView(this.y.a(true));
                    this.z.setVisibility(0);
                    this.A.setVisibility(8);
                    this.y.a("Could not edit the bill", "", false);
                    this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.paytm_blue));
                    this.E.setClickable(true);
                    try {
                        net.one97.paytm.common.widgets.a.b(this.M);
                    } catch (Exception unused) {
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("editBill");
                    arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                    b.a(this.f72166a, "split_bill", "splitbill_success", arrayList, "", "/splitbill/new/proceed", "split_bill");
                } else {
                    this.z.setVisibility(8);
                    this.A.setVisibility(0);
                    try {
                        net.one97.paytm.common.widgets.a.b(this.M);
                    } catch (Exception unused2) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("editBill");
                    arrayList2.add("success");
                    b.a(this.f72166a, "split_bill", "splitbill_success", arrayList2, "", "/splitbill/new/proceed", "split_bill");
                    if (!this.G) {
                        Intent intent = new Intent();
                        intent.putExtra("bill_id", this.L);
                        this.f72166a.setResult(-1, intent);
                        this.f72166a.finish();
                    } else {
                        Intent intent2 = new Intent(this.f72166a, SBBillDetailActivity.class);
                        intent2.putExtra("bill_id", this.L);
                        intent2.putExtra("is_from_edit_bill", true);
                        intent2.setFlags(67108864);
                        this.f72166a.startActivity(intent2);
                        this.f72166a.finish();
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        if (h.this.z != null) {
                            h.this.z.setVisibility(8);
                        }
                    }
                }, 3000);
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR) {
            this.z.removeAllViews();
            this.z.addView(this.y.a(true));
            this.z.setVisibility(0);
            this.y.a("Could not edit the bill", "", false);
            this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.paytm_blue));
            this.E.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.M);
            } catch (Exception unused3) {
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (h.this.z != null) {
                        h.this.z.setVisibility(4);
                    }
                }
            }, 3000);
            net.one97.paytm.network.g gVar = fVar2.f55798c;
            if (gVar != null && (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this.f72166a, gVar.f55801c, h.class.getName(), (Bundle) null, false);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("editBill");
            arrayList3.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            b.a(this.f72166a, "split_bill", "splitbill_success", arrayList3, "", "/splitbill/new/proceed", "split_bill");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        f fVar2 = fVar;
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar2.f55797b instanceof SBAddBillResponse) {
                SBAddBillResponse sBAddBillResponse = (SBAddBillResponse) fVar2.f55797b;
                if (sBAddBillResponse.getSuccess().booleanValue()) {
                    this.z.setVisibility(8);
                    this.A.setVisibility(0);
                    try {
                        net.one97.paytm.common.widgets.a.b(this.M);
                    } catch (Exception unused) {
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("newBill");
                    arrayList.add("success");
                    b.a(this.f72166a, "split_bill", "splitbill_success", arrayList, "", "/splitbill/new/proceed", "split_bill");
                    Intent intent = new Intent(this.f72166a, SBLandingPageActivity.class);
                    intent.putExtra("from", "bill_submit_success");
                    intent.setFlags(67108864);
                    this.f72166a.startActivity(intent);
                    this.f72166a.finish();
                    return;
                }
                this.z.removeAllViews();
                this.z.addView(this.y.a(true));
                this.z.setVisibility(0);
                this.A.setVisibility(8);
                this.y.a("Could Not Create Bill", sBAddBillResponse.getMessage(), false);
                this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.paytm_blue));
                this.E.setClickable(true);
                try {
                    net.one97.paytm.common.widgets.a.b(this.M);
                } catch (Exception unused2) {
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("newBill");
                arrayList2.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                b.a(this.f72166a, "split_bill", "splitbill_success", arrayList2, "", "/splitbill/new/proceed", "split_bill");
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR) {
            this.z.removeAllViews();
            this.z.addView(this.y.a(true));
            this.z.setVisibility(0);
            this.A.setVisibility(8);
            this.y.a("Could Not Create Bill", "", false);
            this.E.setBackgroundColor(this.f72166a.getResources().getColor(R.color.paytm_blue));
            this.E.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.M);
            } catch (Exception unused3) {
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (h.this.z != null) {
                        h.this.z.setVisibility(8);
                    }
                }
            }, 3000);
            net.one97.paytm.network.g gVar = fVar2.f55798c;
            if (gVar != null && (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this.f72166a, gVar.f55801c, h.class.getName(), (Bundle) null, false);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("newBill");
            arrayList3.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            b.a(this.f72166a, "split_bill", "splitbill_success", arrayList3, "", "/splitbill/new/proceed", "split_bill");
        }
    }
}
