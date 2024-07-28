package net.one97.paytm.passbook.toll_kotlin.imported;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.b;
import com.paytm.utility.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.toll_kotlin.imported.model.PassageHistoryTagWiseResponsemodel;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollWalletPsgHistoryModel;
import net.one97.paytm.passbook.toll_kotlin.model.TollTagListModel;
import net.one97.paytm.upi.util.UpiConstants;

public class PassageHistoryDetail extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    String f58930a = "SUCCESS";

    /* renamed from: b  reason: collision with root package name */
    String f58931b = "PENDING";

    /* renamed from: c  reason: collision with root package name */
    String f58932c = "FAILURE";

    /* renamed from: d  reason: collision with root package name */
    private PassageHistoryTagWiseResponsemodel f58933d;

    /* renamed from: e  reason: collision with root package name */
    private TollWalletPsgHistoryModel f58934e;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f58935f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58936g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f58937h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58938i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private ScrollView q;
    /* access modifiers changed from: private */
    public View r;
    private Button s;
    /* access modifiers changed from: private */
    public IJRDataModel t;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_passsage_detail);
        this.t = (IJRDataModel) getIntent().getSerializableExtra("passageHistoryModel");
        IJRDataModel iJRDataModel = this.t;
        if (iJRDataModel instanceof PassageHistoryTagWiseResponsemodel) {
            this.f58933d = (PassageHistoryTagWiseResponsemodel) iJRDataModel;
        } else if (iJRDataModel instanceof TollWalletPsgHistoryModel) {
            this.f58934e = (TollWalletPsgHistoryModel) iJRDataModel;
        }
        this.f58935f = (Toolbar) findViewById(R.id.toolbar_psg_dtl);
        this.f58936g = (TextView) this.f58935f.findViewById(R.id.header_psg_dtl);
        this.f58936g.setText(R.string.passbook);
        ((ImageView) this.f58935f.findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassageHistoryDetail.this.finish();
            }
        });
        ((ImageView) this.f58935f.findViewById(R.id.share)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassageHistoryDetail passageHistoryDetail = PassageHistoryDetail.this;
                String string = passageHistoryDetail.getString(R.string.your_tool_recipt);
                View a2 = PassageHistoryDetail.this.r;
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "wallet_toll_detail");
                hashMap.put("event_action", "share_button_clicked");
                hashMap.put("user_id", Boolean.valueOf(new ArrayList().add(b.n(passageHistoryDetail.getApplicationContext()))));
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "paid for toll tag screen");
                hashMap.put("vertical_name", "fastag");
                passageHistoryDetail.getApplicationContext();
                if (Build.VERSION.SDK_INT < 23 || !s.a() || passageHistoryDetail == null || passageHistoryDetail.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("image/png");
                        intent.putExtra("android.intent.extra.SUBJECT", passageHistoryDetail.getString(R.string.post_payment_share_subject));
                        intent.putExtra("android.intent.extra.TEXT", string);
                        Bitmap createBitmap = Bitmap.createBitmap(a2.getWidth(), a2.getHeight(), Bitmap.Config.ARGB_8888);
                        a2.draw(new Canvas(createBitmap));
                        String insertImage = MediaStore.Images.Media.insertImage(passageHistoryDetail.getContentResolver(), createBitmap, passageHistoryDetail.getString(R.string.title), (String) null);
                        if (insertImage != null) {
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                            Intent createChooser = Intent.createChooser(intent, passageHistoryDetail.getString(R.string.post_payment_share_title));
                            if (createChooser.resolveActivity(passageHistoryDetail.getPackageManager()) != null) {
                                passageHistoryDetail.startActivity(createChooser);
                            } else {
                                Toast.makeText(passageHistoryDetail, passageHistoryDetail.getString(R.string.no_app_found), 1).show();
                            }
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    s.b((Activity) passageHistoryDetail);
                    Toast.makeText(passageHistoryDetail, passageHistoryDetail.getString(R.string.permission_not_granted), 0).show();
                }
            }
        });
        this.r = findViewById(R.id.parent_toll_psg_list_item);
        this.q = (ScrollView) findViewById(R.id.detailscroll);
        this.f58937h = (TextView) findViewById(R.id.psg_hstry_txt1);
        this.f58938i = (TextView) findViewById(R.id.psg_hstry_txt3);
        this.j = (TextView) findViewById(R.id.psg_hstry_txt4);
        this.l = (TextView) findViewById(R.id.psg_hstry_txt5);
        this.k = (TextView) findViewById(R.id.psg_hstry_txn6);
        this.n = (TextView) findViewById(R.id.psg_hstry_txn7);
        this.m = (TextView) findViewById(R.id.psg_hstry_txn8);
        this.o = (ImageView) findViewById(R.id.txn_type_icon_icon_bg_psbk_dtl);
        this.p = (ImageView) findViewById(R.id.status_symbol_iv);
        this.s = (Button) findViewById(R.id.need_help_psbk_dtl);
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.b().a(PassageHistoryDetail.this.t);
            }
        });
        PassageHistoryTagWiseResponsemodel passageHistoryTagWiseResponsemodel = this.f58933d;
        if (passageHistoryTagWiseResponsemodel != null) {
            if (!TextUtils.isEmpty(passageHistoryTagWiseResponsemodel.getPlazaName())) {
                str2 = this.f58933d.getPlazaName();
            } else if (TextUtils.isEmpty(this.f58933d.getPlazaId())) {
                str2 = a(this.f58933d.getPlazaId());
            } else {
                str2 = getString(R.string.toll);
            }
            this.f58936g.setText(this.f58933d.getNarration());
            this.f58937h.setText(String.format(getString(R.string.recharge_rs), new Object[]{this.f58933d.getTxnAmount()}));
            this.j.setText(str2);
            this.k.setText(String.format(getString(R.string.toll_tag), new Object[]{this.f58933d.getTagId()}));
            this.l.setText(String.format(getString(R.string.veh_reg_no), new Object[]{this.f58933d.getVehicleRegNo()}));
            String h2 = b.h(this.f58933d.getTxnDateTime(), "yyyy-MM-dd'T'HH:mm:ss", "MMMM dd , hh:mm a");
            String format = String.format(getString(R.string.lane_name), new Object[]{this.f58933d.getLaneName()});
            this.n.setText(format + StringUtility.NEW_LINE + String.format(getString(R.string.toll_txn_id), new Object[]{this.f58933d.getTxnId()}));
            this.m.setText(h2);
            a(this.f58933d.getTxnStatus(), this.f58933d.getTxnTypeApp(), this.f58933d.getNarration());
        } else {
            TollWalletPsgHistoryModel tollWalletPsgHistoryModel = this.f58934e;
            if (tollWalletPsgHistoryModel != null) {
                if (!TextUtils.isEmpty(tollWalletPsgHistoryModel.getPlazaName())) {
                    str = this.f58934e.getPlazaName();
                } else if (TextUtils.isEmpty(this.f58934e.getPlazaId())) {
                    str = a(this.f58934e.getPlazaId());
                } else {
                    str = getString(R.string.toll);
                }
                this.f58936g.setText(this.f58934e.getNarration());
                this.f58937h.setText(String.format(getString(R.string.recharge_rs), new Object[]{this.f58934e.getTxnAmount()}));
                this.j.setText(str);
                this.k.setText(String.format(getString(R.string.toll_tag), new Object[]{this.f58934e.getTagId()}));
                this.l.setText(String.format(getString(R.string.veh_reg_no), new Object[]{this.f58934e.getVehicleRegNo()}));
                String h3 = b.h(this.f58934e.getTxnDateTime(), "yyyy-MM-dd'T'HH:mm:ss", "MMMM dd , hh:mm a");
                String format2 = String.format(getString(R.string.lane_name), new Object[]{this.f58934e.getLaneName()});
                this.n.setText(format2 + StringUtility.NEW_LINE + String.format(getString(R.string.toll_txn_id), new Object[]{this.f58934e.getTxnId()}));
                this.m.setText(h3);
                a(this.f58934e.getTxnStatus(), this.f58934e.getTxnTypeApp(), this.f58934e.getNarration());
            }
        }
        this.o.setImageBitmap(TollTagListModel.Companion.getCircularBitmapWithWhiteBorder(BitmapFactory.decodeResource(getResources(), R.drawable.pass_car), 5));
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return String.format(getString(R.string.paid_at), new Object[]{str});
        }
        return String.format(getString(R.string.paid_at), new Object[]{getString(R.string.toll)});
    }

    private void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(this.f58930a)) {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.pass_payment_done_00048));
                if (UpiConstants.DEFAULT_ACCOUNT_CONSTANT.equalsIgnoreCase(str2)) {
                    this.f58938i.setText(getString(R.string.paid_successfully_to));
                    return;
                }
                TextView textView = this.f58938i;
                textView.setText(str3 + " " + getString(R.string.at));
            } else if (str.equalsIgnoreCase(this.f58931b)) {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.pass_group_3_copy));
                if (AppConstants.FEED_COMMUNITY.equalsIgnoreCase(str2)) {
                    this.f58938i.setText(getString(R.string.toll_status_subhead_refund_pending_msg));
                } else {
                    this.f58938i.setText(getString(R.string.toll_status_subhead_pending_msg));
                }
            } else if (str.equalsIgnoreCase(this.f58932c)) {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.pass_ic_failed));
                if (AppConstants.FEED_COMMUNITY.equalsIgnoreCase(str2)) {
                    this.f58938i.setText(getString(R.string.toll_status_subhead_refund_fail_msg));
                } else {
                    this.f58938i.setText(getString(R.string.toll_status_subhead_fail_msg));
                }
            } else {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.pass_payment_done_00048));
            }
        }
    }
}
