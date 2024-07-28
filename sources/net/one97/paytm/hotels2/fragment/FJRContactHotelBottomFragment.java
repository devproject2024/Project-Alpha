package net.one97.paytm.hotels2.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.hoteldetail.ProviderPhoneNumber;
import net.one97.paytm.i.f;

public final class FJRContactHotelBottomFragment extends f {
    private LinearLayout mLinearLayout;
    private ArrayList<ProviderPhoneNumber> mList;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.mLinearLayout = new LinearLayout(getContext());
        initView();
        return this.mLinearLayout;
    }

    public final void setNumbersList(ArrayList<ProviderPhoneNumber> arrayList) {
        this.mList = arrayList;
    }

    private final void initView() {
        ArrayList<ProviderPhoneNumber> arrayList = this.mList;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            if (arrayList.size() != 0) {
                LinearLayout linearLayout = this.mLinearLayout;
                if (linearLayout == null) {
                    k.a();
                }
                linearLayout.setPadding(48, 48, 48, 0);
                LinearLayout linearLayout2 = this.mLinearLayout;
                if (linearLayout2 == null) {
                    k.a();
                }
                linearLayout2.setOrientation(1);
                ArrayList<ProviderPhoneNumber> arrayList2 = this.mList;
                if (arrayList2 == null) {
                    k.a();
                }
                Iterator<ProviderPhoneNumber> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ProviderPhoneNumber next = it2.next();
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    Drawable resizeDrawable = resizeDrawable(b.a(context, R.drawable.h4_ic_local_phone_steel));
                    k.a((Object) next, "providerPhoneNumber");
                    addNameOfContact(next);
                    addContactTiming(next);
                    addContactNumberAndIcons(next, resizeDrawable);
                    ArrayList<ProviderPhoneNumber> arrayList3 = this.mList;
                    if (arrayList3 == null) {
                        k.a();
                    }
                    ArrayList<ProviderPhoneNumber> arrayList4 = this.mList;
                    if (arrayList4 == null) {
                        k.a();
                    }
                    if (!k.a((Object) next, (Object) arrayList3.get(kotlin.a.k.a(arrayList4)))) {
                        addLastLine();
                    }
                }
                return;
            }
        }
        dismiss();
    }

    private final void addNameOfContact(ProviderPhoneNumber providerPhoneNumber) {
        TextView textView = new TextView(getContext());
        textView.setTypeface((Typeface) null, 1);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        textView.setTextColor(b.c(context, R.color.color_hotel_heading_black));
        textView.setText(providerPhoneNumber.getName());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout == null) {
            k.a();
        }
        linearLayout.addView(textView, layoutParams);
    }

    private final void addContactTiming(ProviderPhoneNumber providerPhoneNumber) {
        if (!TextUtils.isEmpty(providerPhoneNumber.getTiming())) {
            TextView textView = new TextView(getContext());
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            textView.setTextColor(b.c(context, R.color.jade));
            textView.setText(providerPhoneNumber.getTiming());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            LinearLayout linearLayout = this.mLinearLayout;
            if (linearLayout == null) {
                k.a();
            }
            linearLayout.addView(textView, layoutParams);
        }
    }

    private final void addContactNumberAndIcons(ProviderPhoneNumber providerPhoneNumber, Drawable drawable) {
        ArrayList<String> numbers = providerPhoneNumber.getNumbers();
        if (numbers == null) {
            k.a();
        }
        Iterator<String> it2 = numbers.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            TextView textView = new TextView(getContext());
            textView.setText(next);
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = textView.getContext();
            k.a((Object) context, "textView.context");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = net.one97.paytm.hotel4.utils.f.b("call_hotel");
            a2.m = true;
            b.a.C0750a.a(a2.a(100, 100), (ImageView) null, new FJRContactHotelBottomFragment$addContactNumberAndIcons$1(this, textView), 1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 32, 0, 32);
            LinearLayout linearLayout = this.mLinearLayout;
            if (linearLayout == null) {
                k.a();
            }
            linearLayout.addView(textView, layoutParams);
            textView.setOnClickListener(new FJRContactHotelBottomFragment$addContactNumberAndIcons$2(this, next));
        }
    }

    private final void addLastLine() {
        View view = new View(getContext());
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        view.setBackgroundColor(androidx.core.content.b.c(context, R.color.bg_gray));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        layoutParams.setMargins(0, 0, 0, 0);
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout == null) {
            k.a();
        }
        linearLayout.addView(view, layoutParams);
    }

    private final Drawable resizeDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        k.a((Object) bitmap, "(image as BitmapDrawable).bitmap");
        return new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, false));
    }
}
