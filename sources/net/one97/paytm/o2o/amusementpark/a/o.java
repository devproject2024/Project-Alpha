package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.entity.amPark.CJRParkRidesDetailModel;
import net.one97.paytm.o2o.amusementpark.R;

public final class o extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRParkRidesDetailModel> f73253a;

    /* renamed from: b  reason: collision with root package name */
    private Context f73254b;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public o(Context context, ArrayList<CJRParkRidesDetailModel> arrayList) {
        this.f73254b = context;
        this.f73253a = arrayList;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRParkRidesDetailModel cJRParkRidesDetailModel;
        if ((vVar instanceof a) && (cJRParkRidesDetailModel = this.f73253a.get(i2)) != null) {
            a aVar = (a) vVar;
            aVar.f73255a.setVisibility(TextUtils.isEmpty(cJRParkRidesDetailModel.getmRideImage()) ? 8 : 0);
            if (!TextUtils.isEmpty(cJRParkRidesDetailModel.getmRideImage())) {
                t.a(net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory());
                t.b(cJRParkRidesDetailModel.getmRideImage(), aVar.f73255a);
            }
            String str = "";
            aVar.f73256b.setText(TextUtils.isEmpty(cJRParkRidesDetailModel.getmRideName()) ? str : cJRParkRidesDetailModel.getmRideName());
            RoboTextView roboTextView = aVar.f73257c;
            if (!TextUtils.isEmpty(cJRParkRidesDetailModel.getmRideDescription())) {
                str = cJRParkRidesDetailModel.getmRideDescription();
            }
            roboTextView.setText(str);
        }
    }

    public final int getItemCount() {
        return this.f73253a.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f73255a;

        /* renamed from: b  reason: collision with root package name */
        public RoboTextView f73256b;

        /* renamed from: c  reason: collision with root package name */
        public RoboTextView f73257c;

        public a(View view) {
            super(view);
            this.f73255a = (ImageView) view.findViewById(R.id.iv_ride_image);
            this.f73256b = (RoboTextView) view.findViewById(R.id.tv_ride_name);
            this.f73257c = (RoboTextView) view.findViewById(R.id.tv_ride_description);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.park_ride_row, viewGroup, false));
    }
}
