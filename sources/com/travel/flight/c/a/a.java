package com.travel.flight.c.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.b;
import java.util.ArrayList;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<b> f24055a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f24056b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24057c;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, ArrayList<b> arrayList) {
        this.f24055a = arrayList;
        this.f24056b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f24057c = context;
    }

    public final int getCount() {
        ArrayList<b> arrayList = this.f24055a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final Object getItem(int i2) {
        return this.f24055a.get(i2);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C0455a aVar;
        String str;
        String str2;
        if (view == null) {
            view = this.f24056b.inflate(R.layout.pre_f_item_nearby_airport_list, (ViewGroup) null);
            aVar = new C0455a(this, (byte) 0);
            aVar.f24058a = (TextView) view.findViewById(R.id.flight_city_name);
            aVar.f24059b = (TextView) view.findViewById(R.id.flight_airpot_name);
            aVar.f24060c = (TextView) view.findViewById(R.id.iata_code);
            view.setTag(aVar);
        } else {
            aVar = (C0455a) view.getTag();
        }
        if (aVar != null) {
            b bVar = this.f24055a.get(i2);
            String str3 = "";
            if (bVar == null || bVar.getCityName() == null) {
                aVar.f24058a.setText(str3);
                aVar.f24059b.setText(str3);
                aVar.f24060c.setText(str3);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.getCityName());
                if (!TextUtils.isEmpty(bVar.getState())) {
                    str = ", " + bVar.getState();
                } else {
                    str = str3;
                }
                sb.append(str);
                if (bVar.getCountryName() != null) {
                    str2 = ", " + bVar.getCountryName();
                } else {
                    str2 = str3;
                }
                sb.append(str2);
                int dimensionPixelSize = this.f24057c.getResources().getDimensionPixelSize(R.dimen.cart_15sp);
                int dimensionPixelSize2 = this.f24057c.getResources().getDimensionPixelSize(R.dimen.dimen_10sp);
                SpannableString spannableString = new SpannableString(sb);
                spannableString.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, sb.toString().length(), 18);
                StringBuilder sb2 = new StringBuilder("(" + bVar.getmDistance() + " " + this.f24057c.getString(R.string.km_away_txt) + ")");
                SpannableString spannableString2 = new SpannableString(sb2);
                spannableString2.setSpan(new AbsoluteSizeSpan(dimensionPixelSize2), 0, sb2.toString().length(), 18);
                aVar.f24058a.setText(TextUtils.concat(new CharSequence[]{spannableString, " ", spannableString2}));
                TextView textView = aVar.f24059b;
                if (!TextUtils.isEmpty(bVar.getAirPortName())) {
                    str3 = bVar.getAirPortName();
                }
                textView.setText(str3);
                aVar.f24060c.setText(bVar.getShortCityName());
            }
        }
        return view;
    }

    /* renamed from: com.travel.flight.c.a.a$a  reason: collision with other inner class name */
    class C0455a {

        /* renamed from: a  reason: collision with root package name */
        TextView f24058a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24059b;

        /* renamed from: c  reason: collision with root package name */
        TextView f24060c;

        private C0455a() {
        }

        /* synthetic */ C0455a(a aVar, byte b2) {
            this();
        }
    }
}
