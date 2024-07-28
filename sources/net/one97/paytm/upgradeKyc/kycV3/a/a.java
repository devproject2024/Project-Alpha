package net.one97.paytm.upgradeKyc.kycV3.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.R;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<IJRDataModel> f66034a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f66035b;

    /* renamed from: c  reason: collision with root package name */
    private final int f66036c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final C1319a f66037d;

    /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.a$a  reason: collision with other inner class name */
    public interface C1319a {
        void b(int i2);

        void c(int i2);

        void d(int i2);
    }

    public a(C1319a aVar) {
        k.c(aVar, "listener");
        this.f66037d = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f66036c) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kyc_center_v2, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…center_v2, parent, false)");
            return new b(inflate, this.f66037d);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kyc_center_v2, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…center_v2, parent, false)");
        return new b(inflate2, this.f66037d);
    }

    public final int getItemCount() {
        return this.f66034a.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f66034a.get(i2) instanceof PayTMPartnerListModal.Response) {
            return this.f66036c;
        }
        return this.f66035b;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof b) {
            IJRDataModel iJRDataModel = this.f66034a.get(i2);
            if (iJRDataModel instanceof PayTMPartnerListModal.Response) {
                b bVar = (b) vVar;
                PayTMPartnerListModal.Response response = (PayTMPartnerListModal.Response) iJRDataModel;
                k.c(response, "item");
                if (response.cashPointsDetail != null) {
                    TextView textView = bVar.f66038a;
                    k.a((Object) textView, "title");
                    String str = response.cashPointsDetail.displayName;
                    if (str == null) {
                        str = "";
                    }
                    textView.setText(str);
                    int i3 = Calendar.getInstance().get(11);
                    if (11 <= i3 && 19 >= i3) {
                        ImageView imageView = bVar.f66039b;
                        k.a((Object) imageView, "callIv");
                        imageView.setVisibility(0);
                        TextView textView2 = bVar.f66040c;
                        k.a((Object) textView2, "callTv");
                        textView2.setVisibility(0);
                    } else {
                        ImageView imageView2 = bVar.f66039b;
                        k.a((Object) imageView2, "callIv");
                        imageView2.setVisibility(8);
                        TextView textView3 = bVar.f66040c;
                        k.a((Object) textView3, "callTv");
                        textView3.setVisibility(8);
                    }
                    bVar.f66039b.setOnClickListener(new b.C1320a(bVar));
                    bVar.f66041d.setOnClickListener(new b.C1321b(bVar));
                    TextView textView4 = bVar.f66042e;
                    k.a((Object) textView4, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                    ArrayList<String> arrayList = response.cashPointsDetail.address;
                    StringBuilder sb = new StringBuilder();
                    if (arrayList != null && arrayList.size() > 0) {
                        int size = arrayList.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            if (!TextUtils.isEmpty(arrayList.get(i4))) {
                                sb.append(arrayList.get(i4));
                            }
                            if (i4 < size - 1) {
                                sb.append(" ");
                            }
                        }
                    }
                    String sb2 = sb.toString();
                    k.a((Object) sb2, "addressBuildr.toString()");
                    textView4.setText(sb2);
                    bVar.itemView.setOnClickListener(new b.c(bVar));
                    bVar.f66044g.setImageResource(R.drawable.ic_kyc_point);
                    if (TextUtils.isEmpty(response.cashPointsDetail.logoUrl)) {
                        w.a().a("https://assetscdn.paytm.com/images/catalog/pg/nearby.jpg").a(bVar.f66044g);
                    } else {
                        w.a().a(response.cashPointsDetail.logoUrl).a(bVar.f66044g);
                    }
                    boolean z = response.isPreferable;
                    TextView textView5 = bVar.f66043f;
                    k.a((Object) textView5, "tvRecommended");
                    View view = textView5;
                    if (z) {
                        net.one97.paytm.upgradeKyc.kycV3.b.b(view);
                    } else {
                        net.one97.paytm.upgradeKyc.kycV3.b.a(view);
                    }
                }
            }
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f66038a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f66039b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f66040c;

        /* renamed from: d  reason: collision with root package name */
        final ImageView f66041d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f66042e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f66043f;

        /* renamed from: g  reason: collision with root package name */
        final ImageView f66044g;

        /* renamed from: h  reason: collision with root package name */
        final C1319a f66045h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, C1319a aVar) {
            super(view);
            k.c(view, "itemView");
            k.c(aVar, "listener");
            this.f66045h = aVar;
            this.f66038a = (TextView) view.findViewById(R.id.tv_kyc_center_name);
            this.f66039b = (ImageView) view.findViewById(R.id.nearby_iv);
            this.f66040c = (TextView) view.findViewById(R.id.call_tv);
            this.f66041d = (ImageView) view.findViewById(R.id.direction_iv);
            this.f66042e = (TextView) view.findViewById(R.id.tv_kyc_center_address);
            this.f66043f = (TextView) view.findViewById(R.id.tv_recommended);
            this.f66044g = (ImageView) view.findViewById(R.id.iv_nearby_icon);
        }

        /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.a$b$a  reason: collision with other inner class name */
        static final class C1320a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f66046a;

            C1320a(b bVar) {
                this.f66046a = bVar;
            }

            public final void onClick(View view) {
                this.f66046a.f66045h.b(this.f66046a.getAdapterPosition());
            }
        }

        /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.a$b$b  reason: collision with other inner class name */
        static final class C1321b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f66047a;

            C1321b(b bVar) {
                this.f66047a = bVar;
            }

            public final void onClick(View view) {
                this.f66047a.f66045h.c(this.f66047a.getAdapterPosition());
            }
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f66048a;

            c(b bVar) {
                this.f66048a = bVar;
            }

            public final void onClick(View view) {
                this.f66048a.f66045h.d(this.f66048a.getAdapterPosition());
            }
        }
    }
}
