package net.one97.paytm.passbook.mgv.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.s;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;

public final class MGVTransactionDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private UserTemplateDetail f57935a;

    /* renamed from: b  reason: collision with root package name */
    private UserCardDetail f57936b;

    /* renamed from: c  reason: collision with root package name */
    private AccountTransactionInfo f57937c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57938d;

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f57943a = new e();

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public final View a(int i2) {
        if (this.f57938d == null) {
            this.f57938d = new HashMap();
        }
        View view = (View) this.f57938d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57938d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mgv_transaction_detail);
        Serializable serializableExtra = getIntent().getSerializableExtra("data");
        if (serializableExtra != null) {
            this.f57937c = (AccountTransactionInfo) serializableExtra;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("mgvUserCardDetail");
            if (serializableExtra2 != null) {
                this.f57936b = (UserCardDetail) serializableExtra2;
                Serializable serializableExtra3 = getIntent().getSerializableExtra("userTemplateDetail");
                if (serializableExtra3 != null) {
                    this.f57935a = (UserTemplateDetail) serializableExtra3;
                    TextView textView = (TextView) a(R.id.amount_tv);
                    k.a((Object) textView, "amount_tv");
                    AccountTransactionInfo accountTransactionInfo = this.f57937c;
                    if (accountTransactionInfo == null) {
                        k.a("mData");
                    }
                    textView.setText(net.one97.paytm.passbook.utility.c.a(accountTransactionInfo.getChangeAmount().getAmountInRs()));
                    AccountTransactionInfo accountTransactionInfo2 = this.f57937c;
                    if (accountTransactionInfo2 == null) {
                        k.a("mData");
                    }
                    long j = net.one97.paytm.passbook.mapping.a.j(accountTransactionInfo2.getAccountingTimestamp(), "yyyy-MM-dd'T'HH:mm:ss");
                    TextView textView2 = (TextView) a(R.id.date_time_tv);
                    k.a((Object) textView2, "date_time_tv");
                    textView2.setText(net.one97.paytm.passbook.mapping.a.a(j + 19800000, "dd MMM yyyy, h:mm a"));
                    TextView textView3 = (TextView) a(R.id.txt1);
                    k.a((Object) textView3, "txt1");
                    UserTemplateDetail userTemplateDetail = this.f57935a;
                    if (userTemplateDetail == null) {
                        k.a("mUserTemplateDetail");
                    }
                    textView3.setText(userTemplateDetail.getCardTemplate().getName());
                    TextView textView4 = (TextView) a(R.id.txt4);
                    k.a((Object) textView4, "txt4");
                    StringBuilder sb = new StringBuilder();
                    UserTemplateDetail userTemplateDetail2 = this.f57935a;
                    if (userTemplateDetail2 == null) {
                        k.a("mUserTemplateDetail");
                    }
                    sb.append(userTemplateDetail2.getCardTemplate().getName());
                    sb.append(StringUtility.NEW_LINE);
                    sb.append(getString(R.string.gift_voucher));
                    textView4.setText(sb.toString());
                    UserTemplateDetail userTemplateDetail3 = this.f57935a;
                    if (userTemplateDetail3 == null) {
                        k.a("mUserTemplateDetail");
                    }
                    String description = userTemplateDetail3.getCardTemplate().getDescription();
                    if (description != null) {
                        CharSequence charSequence = description;
                        if (charSequence.length() > 0) {
                            TextView textView5 = (TextView) a(R.id.txt2);
                            k.a((Object) textView5, "txt2");
                            textView5.setVisibility(0);
                            TextView textView6 = (TextView) a(R.id.txt2);
                            k.a((Object) textView6, "txt2");
                            textView6.setText(charSequence);
                        }
                    }
                    AccountTransactionInfo accountTransactionInfo3 = this.f57937c;
                    if (accountTransactionInfo3 == null) {
                        k.a("mData");
                    }
                    if (p.a("REFUND", accountTransactionInfo3.getTransactionType(), true)) {
                        TextView textView7 = (TextView) a(R.id.status_tv);
                        k.a((Object) textView7, "status_tv");
                        textView7.setText(getString(R.string.money_refunded));
                    }
                    TextView textView8 = (TextView) a(R.id.transactionIdTv);
                    k.a((Object) textView8, "transactionIdTv");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(getString(R.string.pass_mgv_order_id));
                    AccountTransactionInfo accountTransactionInfo4 = this.f57937c;
                    if (accountTransactionInfo4 == null) {
                        k.a("mData");
                    }
                    sb2.append(accountTransactionInfo4.getBizOrderId());
                    textView8.setText(sb2.toString());
                    TextView textView9 = (TextView) a(R.id.txt5);
                    k.a((Object) textView9, "txt5");
                    UserCardDetail userCardDetail = this.f57936b;
                    if (userCardDetail == null) {
                        k.a("mCardDetail");
                    }
                    textView9.setText(userCardDetail.getCardNo());
                    ((ImageView) a(R.id.shareImv)).setOnClickListener(new a(this));
                    ((RelativeLayout) a(R.id.needHelpRl)).setOnClickListener(new b(this));
                    ((ImageView) a(R.id.back_arrow_imv)).setOnClickListener(new c(this));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.UserTemplateDetail");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.UserCardDetail");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionDetailActivity f57939a;

        a(MGVTransactionDetailActivity mGVTransactionDetailActivity) {
            this.f57939a = mGVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            MGVTransactionDetailActivity.a(this.f57939a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionDetailActivity f57940a;

        b(MGVTransactionDetailActivity mGVTransactionDetailActivity) {
            this.f57940a = mGVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a("paytmmp://contactus", (Activity) this.f57940a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionDetailActivity f57941a;

        c(MGVTransactionDetailActivity mGVTransactionDetailActivity) {
            this.f57941a = mGVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            this.f57941a.onBackPressed();
        }
    }

    private final void a() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.from1));
            sb.append(" ");
            UserTemplateDetail userTemplateDetail = this.f57935a;
            if (userTemplateDetail == null) {
                k.a("mUserTemplateDetail");
            }
            sb.append(userTemplateDetail.getCardTemplate().getName());
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.toolbar);
            k.a((Object) relativeLayout, "toolbar");
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.needHelpRl);
            k.a((Object) relativeLayout2, "needHelpRl");
            relativeLayout2.setVisibility(8);
            View a2 = a(R.id.separator);
            k.a((Object) a2, "separator");
            a2.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) a(R.id.rootLayout);
            k.a((Object) linearLayout, "rootLayout");
            int width = linearLayout.getWidth();
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.rootLayout);
            k.a((Object) linearLayout2, "rootLayout");
            Bitmap createBitmap = Bitmap.createBitmap(width, linearLayout2.getHeight(), Bitmap.Config.ARGB_8888);
            ((LinearLayout) a(R.id.rootLayout)).draw(new Canvas(createBitmap));
            RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.toolbar);
            k.a((Object) relativeLayout3, "toolbar");
            relativeLayout3.setVisibility(0);
            RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.needHelpRl);
            k.a((Object) relativeLayout4, "needHelpRl");
            relativeLayout4.setVisibility(0);
            View a3 = a(R.id.separator);
            k.a((Object) a3, "separator");
            a3.setVisibility(0);
            k.a((Object) createBitmap, "bitmap");
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                a();
            } else if (androidx.core.app.a.a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText(this, "Storage permission is required to share the screen.", 0).show();
            } else {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new d(this));
                    builder.setNegativeButton(getResources().getString(R.string.cancel), e.f57943a);
                    builder.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionDetailActivity f57942a;

        d(MGVTransactionDetailActivity mGVTransactionDetailActivity) {
            this.f57942a = mGVTransactionDetailActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b((Context) this.f57942a);
        }
    }

    public static final /* synthetic */ void a(MGVTransactionDetailActivity mGVTransactionDetailActivity) {
        if (s.a()) {
            Activity activity = mGVTransactionDetailActivity;
            if (!s.c(activity)) {
                s.b(activity);
                return;
            }
        }
        mGVTransactionDetailActivity.a();
    }
}
