package net.one97.paytm.passbook.transactionHistory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.Instrument;
import net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse;
import net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment;
import net.one97.paytm.passbook.utility.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public PassbookTransactionHistoryResponse f59177a;

    /* renamed from: b  reason: collision with root package name */
    public final TransactionHistoryFragment f59178b;

    public b(TransactionHistoryFragment transactionHistoryFragment) {
        k.c(transactionHistoryFragment, "transactionHistoryFragment");
        this.f59178b = transactionHistoryFragment;
    }

    public final void a(ArrayList<Instrument> arrayList, boolean z) {
        String amount;
        if (arrayList != null) {
            Iterator<Instrument> it2 = arrayList.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                Instrument next = it2.next();
                View inflate = LayoutInflater.from(this.f59178b.getContext()).inflate(R.layout.pass_transaction_detail_item_layout, (LinearLayout) this.f59178b.a(R.id.transactionDetailLL), false);
                if (!z2) {
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
                        z2 = true;
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
                if (!z && arrayList.size() > 1 && (amount = next.getAmount()) != null) {
                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) inflate.findViewById(R.id.tvAmount);
                    k.a((Object) appCompatTextView9, "view.tvAmount");
                    appCompatTextView9.setVisibility(0);
                    AppCompatTextView appCompatTextView10 = (AppCompatTextView) inflate.findViewById(R.id.tvAmount);
                    k.a((Object) appCompatTextView10, "view.tvAmount");
                    String string = inflate.getContext().getString(R.string.pass_rupee, new Object[]{f.c(Double.parseDouble(amount))});
                    k.a((Object) string, "view.context.getString(R…Double().amountFormat3())");
                    f.a(appCompatTextView10, string);
                }
                w.a().a(next.getLogoUrl()).a((af) new a(inflate));
                ((LinearLayout) this.f59178b.a(R.id.transactionDetailLL)).addView(inflate);
            }
        }
    }

    public static final class a implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f59179a;

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
        }

        public final void onPrepareLoad(Drawable drawable) {
        }

        a(View view) {
            this.f59179a = view;
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            View view = this.f59179a;
            k.a((Object) view, "view");
            ImageView imageView = (ImageView) view.findViewById(R.id.ivIconBg);
            k.a((Object) imageView, "view.ivIconBg");
            View view2 = this.f59179a;
            k.a((Object) view2, "view");
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.ivIcon);
            k.a((Object) imageView2, "view.ivIcon");
            imageView.setBackground(androidx.core.content.b.a(imageView2.getContext(), R.drawable.pass_circle_white_border_f3f7f8));
            View view3 = this.f59179a;
            k.a((Object) view3, "view");
            ((ImageView) view3.findViewById(R.id.ivIcon)).setImageBitmap(bitmap);
        }
    }
}
