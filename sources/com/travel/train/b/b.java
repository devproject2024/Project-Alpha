package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.model.trainticket.BoardingStationData;
import java.util.ArrayList;

public final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<BoardingStationData> f26353a;

    /* renamed from: b  reason: collision with root package name */
    private Context f26354b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26355c;

    public final long getItemId(int i2) {
        return 0;
    }

    public b(Context context, ArrayList<BoardingStationData> arrayList, boolean z) {
        this.f26354b = context;
        this.f26353a = arrayList;
        this.f26355c = z;
    }

    public final int getCount() {
        ArrayList<BoardingStationData> arrayList = this.f26353a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        BoardingStationData boardingStationData = this.f26353a.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f26354b).inflate(R.layout.pre_t_train_boarding_station_row, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f26356a.setVisibility(8);
        if (this.f26355c) {
            aVar.f26362g.setVisibility(8);
            aVar.f26363h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(boardingStationData.getStationTitle())) {
            RoboTextView roboTextView = aVar.f26360e;
            String stationTitle = boardingStationData.getStationTitle();
            if (stationTitle != null && stationTitle.length() > 0 && stationTitle.contains(AppConstants.COMMA)) {
                stationTitle = stationTitle.substring(0, stationTitle.length() - 2);
            }
            roboTextView.setText(stationTitle);
        }
        if (!TextUtils.isEmpty(boardingStationData.getTravelDate())) {
            aVar.f26361f.setText(boardingStationData.getTravelDate().replaceFirst(AppConstants.COMMA, " "));
        }
        return view;
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        BoardingStationData boardingStationData = this.f26353a.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f26354b).inflate(R.layout.pre_t_train_boarding_station_row, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TextUtils.isEmpty(boardingStationData.getStationTitle())) {
            aVar.f26358c.setText(boardingStationData.getStationTitle());
        }
        if (!TextUtils.isEmpty(boardingStationData.getTravelDate())) {
            aVar.f26359d.setText(boardingStationData.getTravelDate());
        }
        aVar.f26360e.setVisibility(8);
        aVar.f26361f.setVisibility(8);
        aVar.f26362g.setVisibility(8);
        aVar.f26363h.setVisibility(8);
        if (this.f26353a.size() - 1 == i2) {
            aVar.f26357b.setVisibility(8);
        } else {
            aVar.f26357b.setVisibility(0);
        }
        return view;
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        LinearLayout f26356a;

        /* renamed from: b  reason: collision with root package name */
        View f26357b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f26358c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f26359d;

        /* renamed from: e  reason: collision with root package name */
        RoboTextView f26360e;

        /* renamed from: f  reason: collision with root package name */
        RoboTextView f26361f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f26362g;

        /* renamed from: h  reason: collision with root package name */
        TextView f26363h;

        public a(View view) {
            this.f26356a = (LinearLayout) view.findViewById(R.id.lv_container);
            this.f26358c = (RoboTextView) view.findViewById(R.id.txt_station);
            this.f26359d = (RoboTextView) view.findViewById(R.id.txt_date);
            this.f26360e = (RoboTextView) view.findViewById(R.id.txt_station_selected);
            this.f26361f = (RoboTextView) view.findViewById(R.id.txt_date_selected);
            this.f26357b = view.findViewById(R.id.view_separator_one);
            this.f26362g = (ImageView) view.findViewById(R.id.arrow_right_icon);
            this.f26363h = (TextView) view.findViewById(R.id.date_change_msg);
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        return this.f26353a.get(i2);
    }
}
