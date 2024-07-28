package net.one97.paytm.passbook.transactionDetail.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJREDCTransaction;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private TextView f59076a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f59077b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59078c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f59079d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f59080e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f59081f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59082g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f59083h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f59084i;
    private ImageView j;
    private TextView k;
    private RelativeLayout l;
    private CJREDCTransaction m;
    private TextView n;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_detail_edc, (ViewGroup) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.back_arrow_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.c(view);
            }
        });
        this.m = (CJREDCTransaction) getArguments().getSerializable("passbook_detail_data");
        view.findViewById(R.id.share_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        view.findViewById(R.id.download_receipt_rl).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        this.f59076a = (TextView) view.findViewById(R.id.status_tv);
        this.f59077b = (TextView) view.findViewById(R.id.amount_tv);
        this.f59078c = (TextView) view.findViewById(R.id.date_time_tv);
        this.f59079d = (ImageView) view.findViewById(R.id.status_icon);
        this.f59084i = (ImageView) view.findViewById(R.id.imv1);
        this.f59080e = (TextView) view.findViewById(R.id.txt1);
        this.f59081f = (TextView) view.findViewById(R.id.txt2);
        this.j = (ImageView) view.findViewById(R.id.imv2);
        this.f59082g = (TextView) view.findViewById(R.id.txt3);
        this.f59083h = (TextView) view.findViewById(R.id.txt4);
        this.n = (TextView) view.findViewById(R.id.reference_no_tv);
        this.k = (TextView) view.findViewById(R.id.need_help_tv);
        this.l = (RelativeLayout) view.findViewById(R.id.need_help_rl);
        CJREDCTransaction cJREDCTransaction = this.m;
        TextView textView = this.f59077b;
        String str2 = cJREDCTransaction.amount;
        if (str2 == null) {
            str = null;
        } else {
            str = b.b(str2, str2.contains(AppUtility.CENTER_DOT) ? "##,##,##,##,###.00" : AppConstants.PRICE_PATTERN);
        }
        textView.setText(str);
        this.f59078c.setText(a(cJREDCTransaction.createdOn));
        this.f59080e.setText(cJREDCTransaction.merchantName);
        this.f59081f.setText(cJREDCTransaction.terminalAddress);
        if (!TextUtils.isEmpty(cJREDCTransaction.merchantLogoUrl)) {
            this.f59084i.setVisibility(0);
            w.a().a(cJREDCTransaction.receiptUrl).a(this.f59084i, (e) null);
        } else {
            this.f59084i.setVisibility(8);
        }
        this.f59082g.setText(cJREDCTransaction.bankName);
        this.f59083h.setText(getString(R.string.debit_card_number_, cJREDCTransaction.maskedCardNo));
        if (!TextUtils.isEmpty(cJREDCTransaction.bankLogoUrl)) {
            this.j.setVisibility(0);
            w.a().a(cJREDCTransaction.bankLogoUrl).a(this.j, (e) null);
        } else {
            this.j.setVisibility(8);
        }
        this.n.setText(String.format(getString(R.string.reference_no_), new Object[]{cJREDCTransaction.txnId}));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (isAdded()) {
            getActivity().finish();
        }
    }

    private static String a(String str) {
        if (v.a(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return new SimpleDateFormat("dd MMM, yyyy hh:mm a", Locale.US).format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.m.receiptUrl)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (isAdded() && getActivity() != null) {
            if (getActivity() instanceof PassbookTransactionDetailsActivity) {
                ((PassbookTransactionDetailsActivity) getActivity()).d();
            }
            if (Build.VERSION.SDK_INT < 23 || !s.a() || getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
                    ((PassbookTransactionDetailsActivity) getActivity()).a();
                }
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/png");
                    intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
                    intent.putExtra("android.intent.extra.TEXT", "");
                    View view2 = getView();
                    int visibility = view2.findViewById(R.id.share_imv).getVisibility();
                    view2.findViewById(R.id.share_imv).setVisibility(8);
                    int visibility2 = view2.findViewById(R.id.bottom_btn_ll).getVisibility();
                    view2.findViewById(R.id.bottom_btn_ll).setVisibility(8);
                    Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                    view2.draw(new Canvas(createBitmap));
                    view2.findViewById(R.id.share_imv).setVisibility(visibility);
                    view2.findViewById(R.id.bottom_btn_ll).setVisibility(visibility2);
                    if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
                        ((PassbookTransactionDetailsActivity) getActivity()).b();
                    }
                    String insertImage = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), createBitmap, getString(R.string.title), (String) null);
                    if (insertImage != null) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                        Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
                        if (createChooser.resolveActivity(getContext().getPackageManager()) != null) {
                            startActivity(createChooser);
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.no_app_found), 1).show();
                        }
                    }
                } catch (Exception unused) {
                }
            } else {
                s.b((Activity) getActivity());
                Toast.makeText(getActivity(), getString(R.string.permission_not_granted), 0).show();
            }
        }
    }
}
