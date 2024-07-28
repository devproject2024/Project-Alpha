package net.one97.paytm.managebeneficiary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;

public class ManageWalletBeneficiaryActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f53234a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f53235b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f53236c;

    /* renamed from: d  reason: collision with root package name */
    private i f53237d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollView f53238e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f53239f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<BeneficiaryEntity> f53240g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private b f53241h = new b() {
        public final void a() {
            ManageWalletBeneficiaryActivity.a(ManageWalletBeneficiaryActivity.this, false);
        }
    };

    public interface a {
        void a(ImageView imageView, String str);
    }

    public interface b {
        void a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_manage_wallet_beneficiary);
        setTitle(getString(R.string.pb_mb_manage_beneficiary));
        f.a().sendOpenScreenWithDeviceInfo("/beneficiary/wallet/manage", "beneficiary", this);
        this.f53235b = (RecyclerView) findViewById(R.id.wallet_beneficiary_recycler_view);
        this.f53236c = (TextView) findViewById(R.id.wallet_add_benef);
        this.f53238e = (ScrollView) findViewById(R.id.no_benef_lyt);
        this.f53239f = (RelativeLayout) findViewById(R.id.rl_walet_benf);
        this.f53235b.setLayoutManager(new LinearLayoutManager(this));
        this.f53237d = new i(this, this.f53240g, new a() {
            public final void a(ImageView imageView, String str) {
                ManageWalletBeneficiaryActivity.a(ManageWalletBeneficiaryActivity.this, imageView, str);
            }
        }, this.f53241h);
        this.f53235b.setAdapter(this.f53237d);
        findViewById(R.id.wallet_add_no_benef).setOnClickListener(this);
        this.f53236c.setOnClickListener(this);
        String string = getString(R.string.pb_mb_resending_otp);
        ProgressDialog progressDialog = this.f53234a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f53234a = new ProgressDialog(this);
            try {
                this.f53234a.setProgressStyle(0);
                this.f53234a.setMessage(string);
                this.f53234a.setCancelable(false);
                this.f53234a.setCanceledOnTouchOutside(false);
                this.f53234a.show();
            } catch (IllegalArgumentException e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            } catch (Exception unused) {
            }
        }
        AnonymousClass4 r13 = new Response.Listener<IJRPaytmDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                ManageWalletBeneficiaryActivity.this.a();
                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
                    CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = (CJRKYCBeneficiaryBase) iJRPaytmDataModel;
                    if (cJRKYCBeneficiaryBase.getError() != null && (cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1002") || cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1003"))) {
                        ManageWalletBeneficiaryActivity.a(ManageWalletBeneficiaryActivity.this, false);
                    } else if (cJRKYCBeneficiaryBase.getError() != null) {
                        if (cJRKYCBeneficiaryBase.getError().getErrorMsg() != null) {
                            ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity = ManageWalletBeneficiaryActivity.this;
                            com.paytm.utility.b.a((Context) manageWalletBeneficiaryActivity, manageWalletBeneficiaryActivity.getString(R.string.pb_mb_error), cJRKYCBeneficiaryBase.getError().getErrorMsg());
                            return;
                        }
                        ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity2 = ManageWalletBeneficiaryActivity.this;
                        com.paytm.utility.b.a((Context) manageWalletBeneficiaryActivity2, manageWalletBeneficiaryActivity2.getString(R.string.pb_mb_error), ManageWalletBeneficiaryActivity.this.getString(R.string.some_went_wrong));
                    } else if (cJRKYCBeneficiaryBase.getBeneficiariesList() != null && cJRKYCBeneficiaryBase.getBeneficiariesList().size() > 0) {
                        ManageWalletBeneficiaryActivity.a(ManageWalletBeneficiaryActivity.this, true);
                        ManageWalletBeneficiaryActivity.this.f53240g.clear();
                        ArrayList unused = ManageWalletBeneficiaryActivity.this.f53240g = ManageWalletBeneficiaryActivity.a((ArrayList) cJRKYCBeneficiaryBase.getBeneficiariesList());
                        ManageWalletBeneficiaryActivity.b(ManageWalletBeneficiaryActivity.this);
                    }
                }
            }
        };
        AnonymousClass5 r0 = new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                ManageWalletBeneficiaryActivity.this.a();
                ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity = ManageWalletBeneficiaryActivity.this;
                com.paytm.utility.b.b((Context) manageWalletBeneficiaryActivity, manageWalletBeneficiaryActivity.getString(R.string.pb_mb_error), ManageWalletBeneficiaryActivity.this.getString(R.string.some_went_wrong));
            }
        };
        String beneficiaryURLV2 = f.a().getBeneficiaryURLV2(this);
        if (URLUtil.isValidUrl(beneficiaryURLV2)) {
            String e3 = com.paytm.utility.b.e((Context) this, beneficiaryURLV2);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", f.a().getSSOToken(this));
            com.paytm.network.a a2 = f.a(this, e3, new com.paytm.network.listener.b(r13, r0) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Response.Listener f53296a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Response.ErrorListener f53297b;

                {
                    this.f53296a = r1;
                    this.f53297b = r2;
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    this.f53296a.onResponse(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    this.f53297b.onErrorResponse((VolleyError) null);
                }
            }, hashMap, a.C0715a.GET, (String) null, new CJRKYCBeneficiaryBase(), a.c.HOME, a.b.SILENT);
            if (com.paytm.utility.b.c((Context) this)) {
                a2.a();
            } else {
                net.one97.paytm.managebeneficiary.b.a.a(a2, this);
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.wallet_add_no_benef || id == R.id.wallet_add_benef) {
            e.a(this, "beneficiary_wallet", "add_beneficiary_clicked", "/beneficiary/wallet/manage");
            startActivityForResult(new Intent(this, AddNewBeneficiaryV2Activity.class), 2012);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2012 && i3 == -1) {
            finish();
            startActivity(getIntent());
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a() {
        ProgressDialog progressDialog = this.f53234a;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f53234a.dismiss();
            this.f53234a = null;
        }
    }

    static /* synthetic */ void a(ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity, boolean z) {
        if (z) {
            manageWalletBeneficiaryActivity.f53238e.setVisibility(8);
            manageWalletBeneficiaryActivity.f53239f.setVisibility(0);
            return;
        }
        manageWalletBeneficiaryActivity.f53238e.setVisibility(0);
        manageWalletBeneficiaryActivity.f53239f.setVisibility(8);
    }

    static /* synthetic */ void a(ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity, ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a((Context) manageWalletBeneficiaryActivity, R.drawable.pb_mb_icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a((Context) manageWalletBeneficiaryActivity, R.drawable.pb_mb_ic_bhim));
        } else if (URLUtil.isValidUrl(str)) {
            w.a().a(str).a(R.drawable.pb_mb_ic_default_bank).b(R.drawable.pb_mb_ic_default_bank).a(imageView, (e) null);
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(f.a().getBankIconUrl(manageWalletBeneficiaryActivity.getApplicationContext(), str)).a(R.drawable.pb_mb_ic_default_bank).b(R.drawable.pb_mb_ic_default_bank).a(imageView, (e) null);
        }
    }

    static /* synthetic */ ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) it2.next();
            if (beneficiaryEntity.instrumentPreferences.wallet != null) {
                arrayList2.add(beneficiaryEntity);
            } else {
                arrayList3.add(beneficiaryEntity);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    static /* synthetic */ void b(ManageWalletBeneficiaryActivity manageWalletBeneficiaryActivity) {
        i iVar = manageWalletBeneficiaryActivity.f53237d;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
            i iVar2 = manageWalletBeneficiaryActivity.f53237d;
            iVar2.f53310c = manageWalletBeneficiaryActivity.f53240g;
            iVar2.notifyDataSetChanged();
            return;
        }
        manageWalletBeneficiaryActivity.f53237d = new i(manageWalletBeneficiaryActivity, manageWalletBeneficiaryActivity.f53240g, new a() {
            public final void a(ImageView imageView, String str) {
                ManageWalletBeneficiaryActivity.a(ManageWalletBeneficiaryActivity.this, imageView, str);
            }
        }, manageWalletBeneficiaryActivity.f53241h);
        manageWalletBeneficiaryActivity.f53235b.setAdapter(manageWalletBeneficiaryActivity.f53237d);
    }
}
