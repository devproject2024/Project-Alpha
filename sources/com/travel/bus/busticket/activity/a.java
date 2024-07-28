package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.crashlytics.c;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.busticket.a.d;
import com.travel.bus.busticket.g.h;
import com.travel.bus.pojo.busticket.CJRBusJourneyIssues;
import com.travel.bus.pojo.busticket.CJRBusRating;
import com.travel.bus.pojo.busticket.CJRBusRatingQuestions;
import com.travel.bus.pojo.busticket.halfcardmodel.CJRRNROptions;
import com.travel.bus.pojo.busticket.halfcardmodel.CJRRNRQuestions;
import com.travel.bus.pojo.busticket.halfcardmodel.CJRRNRQuestionsRoot;
import com.travel.bus.pojo.busticket.rnr.CJRRnRDetailsModel;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.i;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f implements View.OnClickListener, b, d.a {
    private CJRRNRQuestions A;
    private d B;
    private boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f21981a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f21982b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f21983c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f21984d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f21985e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f21986f;

    /* renamed from: g  reason: collision with root package name */
    private int f21987g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f21988h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f21989i;
    private EditText j;
    private ImageView k;
    private String l;
    private String m;
    private String n;
    private CJRBusRating o = new CJRBusRating();
    private String p;
    private boolean q = false;
    private boolean r = false;
    private boolean s;
    private boolean t;
    private TextView u;
    private RecyclerView v;
    private String w;
    private StringBuilder x;
    private i y;
    private List<CJRRNROptions> z;

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener($$Lambda$a$F_ICpzn5_4ILa26n9ufWhA81Y4M.INSTANCE);
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels - 20);
        from.setState(3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.travel.bus.R.layout.bus_new_rnr_bottom_rating_screen, viewGroup, false);
    }

    public static a a() {
        return new a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.C) {
            dismiss();
            return;
        }
        dismiss();
        getActivity().finish();
    }

    private void b() {
        if (!TextUtils.isEmpty(this.w)) {
            this.f21988h.setText(this.w);
            this.f21988h.setVisibility(0);
            return;
        }
        this.f21988h.setVisibility(8);
    }

    private void c() {
        if (TextUtils.isEmpty(this.w)) {
            String d2 = d();
            if (d2 != null && URLUtil.isValidUrl(d2)) {
                a((Context) getActivity(), getResources().getString(com.travel.bus.R.string.please_wait_progress_msg));
                h.a(Uri.parse(d2).buildUpon().appendQueryParameter("s", this.l).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString(), getActivity(), this);
                return;
            }
            return;
        }
        b();
    }

    private static String d() {
        com.travel.bus.a.a();
        return com.travel.bus.a.b().f("RNRDetails");
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_ratings");
        hashMap.put("event_action", "bus_ratings_push_clicked");
        hashMap.put("event_label", "rating=" + this.f21987g + "&order_id=" + this.m);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-ratings");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private void b(int i2) {
        this.x = new StringBuilder(getString(com.travel.bus.R.string.you_rated));
        if (i2 == 1) {
            this.f21982b.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.x.append(getString(com.travel.bus.R.string.poor));
        } else if (i2 == 2) {
            this.f21982b.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21983c.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.x.append(getString(com.travel.bus.R.string.bad));
        } else if (i2 == 3) {
            this.f21982b.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21983c.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21984d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.x.append(getString(com.travel.bus.R.string.avergae));
        } else if (i2 == 4) {
            this.f21982b.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21983c.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21984d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21985e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.x.append(getString(com.travel.bus.R.string.good));
        } else if (i2 == 5) {
            this.f21982b.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21983c.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21984d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21985e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f21986f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.x.append(getString(com.travel.bus.R.string.awesome));
        }
        this.f21989i.setText(this.x);
        f();
    }

    public void onClick(View view) {
        int id = view.getId();
        this.f21983c.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f21984d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f21985e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f21986f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        if (id == com.travel.bus.R.id.star1) {
            this.f21987g = 1;
        } else if (id == com.travel.bus.R.id.star2) {
            this.f21987g = 2;
        } else if (id == com.travel.bus.R.id.star3) {
            this.f21987g = 3;
        } else if (id == com.travel.bus.R.id.star4) {
            this.f21987g = 4;
        } else if (id == com.travel.bus.R.id.star5) {
            this.f21987g = 5;
        }
        b(this.f21987g);
    }

    private void f() {
        e();
        a(Uri.parse(g()).buildUpon().appendQueryParameter("r", String.valueOf(this.f21987g)).appendQueryParameter("s", this.l).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString());
    }

    private static String g() {
        com.travel.bus.a.a();
        String f2 = com.travel.bus.a.b().f("busReviewQuestions");
        if (!TextUtils.isEmpty(f2)) {
            return f2;
        }
        com.travel.bus.a.a();
        return com.travel.bus.a.b().f("busRatings").replace("/v1/", "/v2/");
    }

    private void a(String str) {
        if (str != null) {
            a((Context) getActivity(), getResources().getString(com.travel.bus.R.string.please_wait_progress_msg));
            new ArrayList().add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str;
            bVar.f42885i = new CJRRNRQuestionsRoot();
            bVar.j = this;
            bVar.t = h();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-rating-page";
            bVar.l().a();
        }
    }

    private static JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusRatingScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Dialog dialog, View view) {
        dialog.dismiss();
        if (this.C) {
            dismiss();
        } else {
            j();
        }
    }

    private static boolean a(List<CJRBusRatingQuestions> list) {
        if (list.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CJRBusRatingQuestions cJRBusRatingQuestions = list.get(i2);
            if (cJRBusRatingQuestions.getIssueOptions() != null && cJRBusRatingQuestions.getIssueOptions().size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        j();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        if ((this.z != null) && (this.z.size() > 0)) {
            for (int i2 = 0; i2 < this.z.size(); i2++) {
                if (this.z.get(i2).isSelected()) {
                    sb.append(this.z.get(i2).getName() + AppConstants.AND_SIGN);
                }
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_ratings");
        hashMap.put("event_action", "bus_feedback_submitted");
        hashMap.put("event_label", "rating=" + this.f21987g + "&order_id=" + this.m + "&issues=" + sb2);
        if (TextUtils.isEmpty(this.j.getText())) {
            hashMap.put("event_label2", " ");
        } else {
            hashMap.put("event_label2", this.j.getText());
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-ratings");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private void j() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        com.travel.bus.a.a();
        cJRHomePageItem.setUrl(com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) getActivity(), intent);
        dismiss();
        getActivity().finish();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        k();
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing() && isAdded()) {
            boolean z2 = true;
            if (iJRPaytmDataModel instanceof CJRRNRQuestionsRoot) {
                CJRRNRQuestionsRoot cJRRNRQuestionsRoot = (CJRRNRQuestionsRoot) iJRPaytmDataModel;
                if (cJRRNRQuestionsRoot == null || cJRRNRQuestionsRoot.getBody() == null || cJRRNRQuestionsRoot.getBody().getQuestions() == null || cJRRNRQuestionsRoot.getBody().getQuestions().size() <= 0 || cJRRNRQuestionsRoot.getBody().getQuestions().get(0) == null || cJRRNRQuestionsRoot.getBody().getQuestions().get(0).getOptions() == null) {
                    z2 = false;
                }
                if (z2) {
                    this.A = cJRRNRQuestionsRoot.getBody().getQuestions().get(0);
                    this.z = cJRRNRQuestionsRoot.getBody().getQuestions().get(0).getOptions();
                    this.u.setText(this.A.getCategory());
                    this.B = new d(getActivity(), this.z, this);
                    this.v.setAdapter(this.B);
                }
            } else if (iJRPaytmDataModel instanceof CJRBusRating) {
                this.o = (CJRBusRating) iJRPaytmDataModel;
                if (this.o != null) {
                    this.r = true;
                    if (!this.t) {
                        this.t = true;
                        Dialog dialog = new Dialog(getActivity());
                        dialog.getWindow().setContentView(com.travel.bus.R.layout.pre_b_dialog_feedback_submit);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        TextView textView = (TextView) dialog.findViewById(com.travel.bus.R.id.txt_thankyou_name);
                        ImageView imageView = (ImageView) dialog.findViewById(com.travel.bus.R.id.close_thankyou);
                        ImageView imageView2 = (ImageView) dialog.findViewById(com.travel.bus.R.id.img_thankyou);
                        TextView textView2 = (TextView) dialog.findViewById(com.travel.bus.R.id.txt_descrip);
                        String h2 = com.paytm.utility.b.h((Context) getActivity());
                        if (TextUtils.isEmpty(h2)) {
                            h2 = com.paytm.utility.b.j((Context) getActivity());
                        }
                        if (TextUtils.isEmpty(h2)) {
                            str = "";
                        } else {
                            str = h2 + AppConstants.COMMA;
                        }
                        if (this.f21987g > 3) {
                            textView.setText(getString(com.travel.bus.R.string.thank_you) + " " + str);
                            ResourceUtils.loadBusImagesFromCDN(imageView2, "bus_happy.png", false, false, n.a.V1);
                            textView2.setText(com.travel.bus.R.string.bus_tq_feedback1);
                        } else {
                            textView.setText(getString(com.travel.bus.R.string.we_feel_sorry) + " " + str);
                            ResourceUtils.loadBusImagesFromCDN(imageView2, "bus_sad.png", false, false, n.a.V1);
                            textView2.setText(com.travel.bus.R.string.bus_tq_feedback2);
                        }
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                        imageView.setOnClickListener(new View.OnClickListener(dialog) {
                            private final /* synthetic */ Dialog f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                a.this.a(this.f$1, view);
                            }
                        });
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRRnRDetailsModel) {
                CJRRnRDetailsModel cJRRnRDetailsModel = (CJRRnRDetailsModel) iJRPaytmDataModel;
                if (cJRRnRDetailsModel.getBody() != null && cJRRnRDetailsModel.getBody().getData() != null) {
                    this.w = cJRRnRDetailsModel.getBody().getData().getTravelsName();
                    b();
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            k();
            if (!(iJRPaytmDataModel instanceof CJRRnRDetailsModel) && networkCustomError != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                        if (!jSONObject.isNull("error")) {
                            String string = jSONObject.getString("error");
                            k();
                            if (!getActivity().isFinishing()) {
                                String string2 = getString(com.travel.bus.R.string.error);
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle(string2).setMessage(string).setCancelable(false);
                                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        a.this.a(dialogInterface, i2);
                                    }
                                });
                                builder.show();
                            }
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    private void a(Context context, String str) {
        if (context != null || getActivity().isFinishing()) {
            ProgressDialog progressDialog = this.f21981a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f21981a = new ProgressDialog(context);
                try {
                    this.f21981a.setProgressStyle(0);
                    this.f21981a.setMessage(str);
                    this.f21981a.setCancelable(false);
                    this.f21981a.setCanceledOnTouchOutside(false);
                    this.f21981a.show();
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        q.c(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void k() {
        try {
            if (this.f21981a != null && this.f21981a.isShowing() && !getActivity().isFinishing()) {
                this.f21981a.dismiss();
                this.f21981a = null;
            }
        } catch (Exception e2) {
            c.a().a((Throwable) e2);
        }
    }

    public final void a(int i2) {
        this.z.get(i2).setSelected(!this.z.get(i2).isSelected());
        this.B.notifyDataSetChanged();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.f21988h = (RoboTextView) view.findViewById(com.travel.bus.R.id.tv_bus_name);
        this.f21989i = (RoboTextView) view.findViewById(com.travel.bus.R.id.rating_msg_tv);
        this.j = (EditText) view.findViewById(com.travel.bus.R.id.user_text_msg_tv);
        this.u = (TextView) view.findViewById(com.travel.bus.R.id.entering_issues_tv);
        this.v = (RecyclerView) view.findViewById(com.travel.bus.R.id.recycler_rating_feedback);
        this.k = (ImageView) view.findViewById(com.travel.bus.R.id.close_button);
        this.v.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.y = new i(2, 16, true);
        this.v.addItemDecoration(this.y);
        getActivity().getWindow().setSoftInputMode(3);
        this.f21982b = (ImageView) view.findViewById(com.travel.bus.R.id.star1);
        this.f21983c = (ImageView) view.findViewById(com.travel.bus.R.id.star2);
        this.f21984d = (ImageView) view.findViewById(com.travel.bus.R.id.star3);
        this.f21985e = (ImageView) view.findViewById(com.travel.bus.R.id.star4);
        this.f21986f = (ImageView) view.findViewById(com.travel.bus.R.id.star5);
        this.f21982b.setOnClickListener(this);
        this.f21983c.setOnClickListener(this);
        this.f21984d.setOnClickListener(this);
        this.f21985e.setOnClickListener(this);
        this.f21986f.setOnClickListener(this);
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        ((Button) view.findViewById(com.travel.bus.R.id.submit_feedback_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        if (getArguments().containsKey("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
            if (cJRHomePageItem != null) {
                this.p = cJRHomePageItem.getDeeplink();
                if (TextUtils.isEmpty(this.p)) {
                    this.p = cJRHomePageItem.getURL();
                }
                if (!TextUtils.isEmpty(this.p)) {
                    Uri parse = Uri.parse(this.p);
                    if (!TextUtils.isEmpty(parse.getQueryParameter("rating"))) {
                        this.f21987g = Integer.parseInt(parse.getQueryParameter("rating"));
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("order_Id"))) {
                        this.m = parse.getQueryParameter("order_Id");
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("secret"))) {
                        this.l = parse.getQueryParameter("secret");
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("channel"))) {
                        this.n = parse.getQueryParameter("channel");
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("name"))) {
                        this.w = parse.getQueryParameter("name");
                    }
                    int i2 = this.f21987g;
                    if (i2 != 0) {
                        b(i2);
                    }
                    c();
                    return;
                }
                return;
            }
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f21987g = arguments.getInt("star_count", 0);
            this.l = arguments.getString("secretKey");
            this.m = arguments.getString("orderID");
            this.n = arguments.getString("channel");
            this.w = arguments.getString("operator_name");
            this.C = arguments.getBoolean("bus-from-rnr-home");
            b(this.f21987g);
            c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        List<CJRRNROptions> list = this.z;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (int i2 = 0; i2 < this.z.size(); i2++) {
                if (this.z.get(i2).isSelected()) {
                    CJRBusJourneyIssues cJRBusJourneyIssues = new CJRBusJourneyIssues();
                    cJRBusJourneyIssues.setName(this.z.get(i2).getName());
                    cJRBusJourneyIssues.setId(this.z.get(i2).getId());
                    arrayList2.add(cJRBusJourneyIssues);
                }
            }
            CJRBusRatingQuestions cJRBusRatingQuestions = new CJRBusRatingQuestions();
            cJRBusRatingQuestions.setIssueOptions(arrayList2);
            CJRRNRQuestions cJRRNRQuestions = this.A;
            if (cJRRNRQuestions != null) {
                cJRBusRatingQuestions.setCategory(cJRRNRQuestions.getCategory());
                cJRBusRatingQuestions.setCategoryId(this.A.getCategoryId());
                cJRBusRatingQuestions.setMandatory(this.A.getMandatory());
            }
            arrayList.add(cJRBusRatingQuestions);
            if (!a((List<CJRBusRatingQuestions>) arrayList)) {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(com.travel.bus.R.string.special_characters_title), getString(com.travel.bus.R.string.please_select_journey_issue));
            } else {
                z2 = true;
            }
            if (z2) {
                a((Context) getActivity(), getResources().getString(com.travel.bus.R.string.loading));
                com.travel.bus.a.a();
                String f2 = com.travel.bus.a.b().f("busRatingSubmitNew");
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    String str = "";
                    if (arrayList.size() > 0) {
                        str = new com.google.gsonhtcfix.f().a((Object) arrayList, new com.google.gson.b.a<ArrayList<CJRBusRatingQuestions>>() {
                        }.getType());
                    }
                    jSONArray = new JSONArray(str);
                } catch (JSONException e2) {
                    q.c(e2.getMessage());
                }
                try {
                    jSONObject.put("rating", this.f21987g);
                    jSONObject.put("secret", this.l);
                    jSONObject.put("channel", this.n);
                    jSONObject.put("additionalCommentsInput", this.j.getText());
                    jSONObject.put("reviews", jSONArray);
                } catch (JSONException e3) {
                    q.c(e3.getMessage());
                }
                new HashMap().put("Content-Type", "application/json");
                if (com.paytm.utility.b.c((Context) getActivity()) && !this.s) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(410);
                    arrayList3.add(422);
                    arrayList3.add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
                    arrayList3.add(505);
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = getActivity();
                    bVar.f42878b = a.c.BUS;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.f42880d = f2;
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42881e = null;
                    bVar.f42882f = null;
                    bVar.f42883g = null;
                    bVar.f42885i = new CJRBusRating();
                    bVar.j = this;
                    bVar.t = h();
                    bVar.n = a.b.SILENT;
                    bVar.o = "bus-rating-page";
                    bVar.l().a();
                    this.s = true;
                }
                try {
                    i();
                } catch (Exception unused) {
                }
            }
        }
    }
}
