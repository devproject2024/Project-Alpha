package net.one97.paytm.wallet.newdesign.postcard.a;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.common.entity.lifafa.SentLifafaDetailsResponse;
import net.one97.paytm.common.widgets.CJRVolleyImageView;
import net.one97.paytm.wallet.R;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    SentLifafaDetailsResponse f71179a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<SentLifafaDetailsResponse.RecipientDetails> f71180b;

    /* renamed from: c  reason: collision with root package name */
    Context f71181c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f71182d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return i2;
    }

    public b(Context context, SentLifafaDetailsResponse sentLifafaDetailsResponse) {
        this.f71179a = sentLifafaDetailsResponse;
        SentLifafaDetailsResponse sentLifafaDetailsResponse2 = this.f71179a;
        if (sentLifafaDetailsResponse2 != null) {
            this.f71180b = sentLifafaDetailsResponse2.getRecipientDetails();
        }
        this.f71181c = context;
    }

    public final int getItemCount() {
        return this.f71180b.size() + 1;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_received_item_header, viewGroup, false));
        }
        if (i2 == 1) {
            return new C1444b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item, viewGroup, false));
        }
        if (i2 % 2 == 0) {
            return new C1444b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item_graybg, viewGroup, false));
        }
        return new C1444b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str = this.f71182d.get(i2 % 10);
        if (vVar.getItemViewType() != 0) {
            if ((vVar instanceof C1444b) && this.f71181c != null) {
                C1444b bVar = (C1444b) vVar;
                int i3 = i2 - 1;
                ReceivedLifafaDetailsResponse.RecipientInfo recipientInfo = this.f71180b.get(i3).getRecipientInfo();
                bVar.f71190e.setVisibility(0);
                bVar.f71186a.setVisibility(8);
                bVar.f71189d.setText(net.one97.paytm.wallet.utility.a.d(recipientInfo.getName()));
                bVar.f71187b.setText(recipientInfo.getName());
                RoboTextView roboTextView = bVar.f71188c;
                roboTextView.setText(this.f71181c.getResources().getString(R.string.rupee_symbol) + Integer.valueOf(this.f71180b.get(i3).getProposedQuantity().intValue()));
                bVar.f71191f.setBackgroundColor(Color.parseColor(str));
            }
        } else if ((vVar instanceof a) && this.f71181c != null) {
            a aVar = (a) vVar;
            RoboTextView roboTextView2 = aVar.f71183a;
            String string = this.f71181c.getResources().getString(R.string.sent_lifafa_claimed);
            roboTextView2.setText(String.format(string, new Object[]{this.f71180b.size() + " / " + this.f71179a.getLifafaDetail().getProposedReceiverCount()}));
            aVar.f71184b.setVisibility(8);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.postcard.a.b$b  reason: collision with other inner class name */
    public class C1444b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71186a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f71187b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f71188c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f71189d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71190e;

        /* renamed from: f  reason: collision with root package name */
        CJRVolleyImageView f71191f;

        public C1444b(View view) {
            super(view);
            this.f71186a = (ImageView) view.findViewById(R.id.imgProfile);
            this.f71187b = (RoboTextView) view.findViewById(R.id.tvName);
            this.f71188c = (RoboTextView) view.findViewById(R.id.tvAmount);
            this.f71189d = (RoboTextView) view.findViewById(R.id.tvImageName);
            this.f71190e = (RelativeLayout) view.findViewById(R.id.imageLayout);
            this.f71191f = (CJRVolleyImageView) view.findViewById(R.id.ivScanId);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f71183a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f71184b;

        public a(View view) {
            super(view);
            this.f71183a = (RoboTextView) view.findViewById(R.id.tvCliamedAmount);
            this.f71184b = (RoboTextView) view.findViewById(R.id.tvYetToClaimed);
        }
    }
}
