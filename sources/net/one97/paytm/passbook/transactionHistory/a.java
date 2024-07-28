package net.one97.paytm.passbook.transactionHistory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import com.appsflyer.internal.referrer.Payload;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.ExtraInfo;
import net.one97.paytm.passbook.beans.SADetailsResponse;
import net.one97.paytm.passbook.beans.SAInstrument;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public SADetailsResponse f59160a;

    /* renamed from: b  reason: collision with root package name */
    public final net.one97.paytm.passbook.transactionHistory.fragments.a f59161b;

    public a(net.one97.paytm.passbook.transactionHistory.fragments.a aVar) {
        k.c(aVar, "transactionHistoryFragment");
        this.f59161b = aVar;
    }

    public final void a(ArrayList<SAInstrument> arrayList) {
        if (arrayList != null) {
            Iterator<SAInstrument> it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                SAInstrument next = it2.next();
                View inflate = LayoutInflater.from(this.f59161b.getContext()).inflate(R.layout.pass_transaction_detail_item_layout, (LinearLayout) this.f59161b.a(R.id.transactionDetailLL), false);
                if (!z) {
                    k.a((Object) inflate, "view");
                    View findViewById = inflate.findViewById(R.id.vTopSpace);
                    k.a((Object) findViewById, "view.vTopSpace");
                    findViewById.setVisibility(0);
                    if (next.getNarration() != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tvNarration);
                        k.a((Object) appCompatTextView, "view.tvNarration");
                        appCompatTextView.setVisibility(0);
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.tvNarration);
                        k.a((Object) appCompatTextView2, "view.tvNarration");
                        appCompatTextView2.setText(next.getNarration());
                        z = true;
                    }
                } else {
                    k.a((Object) inflate, "view");
                    View findViewById2 = inflate.findViewById(R.id.vTopSpace);
                    k.a((Object) findViewById2, "view.vTopSpace");
                    findViewById2.setVisibility(8);
                }
                if (next.getName() != null) {
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) inflate.findViewById(R.id.tvName);
                    k.a((Object) appCompatTextView3, "view.tvName");
                    appCompatTextView3.setVisibility(0);
                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) inflate.findViewById(R.id.tvName);
                    k.a((Object) appCompatTextView4, "view.tvName");
                    appCompatTextView4.setText(next.getName());
                }
                if (next.getInstrumentDetail() != null) {
                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) inflate.findViewById(R.id.tvInstrumentDetail);
                    k.a((Object) appCompatTextView5, "view.tvInstrumentDetail");
                    appCompatTextView5.setVisibility(0);
                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) inflate.findViewById(R.id.tvInstrumentDetail);
                    k.a((Object) appCompatTextView6, "view.tvInstrumentDetail");
                    appCompatTextView6.setText(next.getInstrumentDetail());
                }
                String additionalDetail = next.getAdditionalDetail();
                if (additionalDetail != null) {
                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) inflate.findViewById(R.id.tvAdditionalDetail);
                    k.a((Object) appCompatTextView7, "view.tvAdditionalDetail");
                    appCompatTextView7.setVisibility(0);
                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) inflate.findViewById(R.id.tvAdditionalDetail);
                    k.a((Object) appCompatTextView8, "view.tvAdditionalDetail");
                    appCompatTextView8.setText(additionalDetail);
                }
                w.a().a(next.getLogoUrl()).a((af) new C1140a(inflate));
                ((LinearLayout) this.f59161b.a(R.id.transactionDetailLL)).addView(inflate);
            }
        }
    }

    /* renamed from: net.one97.paytm.passbook.transactionHistory.a$a  reason: collision with other inner class name */
    public static final class C1140a implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f59162a;

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
        }

        public final void onPrepareLoad(Drawable drawable) {
        }

        C1140a(View view) {
            this.f59162a = view;
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            View view = this.f59162a;
            k.a((Object) view, "view");
            ImageView imageView = (ImageView) view.findViewById(R.id.ivIconBg);
            k.a((Object) imageView, "view.ivIconBg");
            View view2 = this.f59162a;
            k.a((Object) view2, "view");
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.ivIcon);
            k.a((Object) imageView2, "view.ivIcon");
            imageView.setBackground(b.a(imageView2.getContext(), R.drawable.pass_circle_white_border_f3f7f8));
            View view3 = this.f59162a;
            k.a((Object) view3, "view");
            ((ImageView) view3.findViewById(R.id.ivIcon)).setImageBitmap(bitmap);
        }
    }

    public final void a(String str) {
        FrameLayout frameLayout = (FrameLayout) this.f59161b.a(R.id.ilError);
        k.a((Object) frameLayout, "transactionHistoryFragment.ilError");
        frameLayout.setVisibility(0);
        ImageView imageView = (ImageView) this.f59161b.a(R.id.share_imv);
        k.a((Object) imageView, "transactionHistoryFragment.share_imv");
        imageView.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) this.f59161b.a(R.id.rvHeader);
        k.a((Object) relativeLayout, "transactionHistoryFragment.rvHeader");
        ((RelativeLayout) this.f59161b.a(R.id.toolbar)).setBackgroundColor(b.c(relativeLayout.getContext(), R.color.white));
        if (TextUtils.isEmpty(str) || p.a(str, "null", true)) {
            Context context = this.f59161b.getContext();
            str = context != null ? context.getString(R.string.pass_payment_history_details_default_failure_msg) : null;
        }
        TextView textView = (TextView) this.f59161b.a(R.id.tvErrorMsg);
        k.a((Object) textView, "transactionHistoryFragment.tvErrorMsg");
        textView.setText(str);
    }

    public static boolean a(SADetailsResponse sADetailsResponse) {
        String payerVPA;
        k.c(sADetailsResponse, Payload.RESPONSE);
        if (!TextUtils.isEmpty(sADetailsResponse.getReportCode())) {
            ExtraInfo extraInfo = sADetailsResponse.getExtraInfo();
            Boolean bool = null;
            if (!TextUtils.isEmpty(extraInfo != null ? extraInfo.getPayerVPA() : null)) {
                String reportCode = sADetailsResponse.getReportCode();
                Boolean valueOf = reportCode != null ? Boolean.valueOf(reportCode.equals("20502")) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    ExtraInfo extraInfo2 = sADetailsResponse.getExtraInfo();
                    if (!(extraInfo2 == null || (payerVPA = extraInfo2.getPayerVPA()) == null)) {
                        bool = Boolean.valueOf(p.c(payerVPA, "@paytm", false));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
