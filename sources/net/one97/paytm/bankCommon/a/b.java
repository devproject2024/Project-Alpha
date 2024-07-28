package net.one97.paytm.bankCommon.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.bankOpen.R;

public final class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f16186a;

    /* renamed from: b  reason: collision with root package name */
    private Context f16187b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f16188c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f16189d;

    public final long getItemId(int i2) {
        return 0;
    }

    public b(Context context, String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        this.f16187b = context;
        this.f16188c = strArr;
        this.f16186a = onItemClickListener;
    }

    public final int getCount() {
        String[] strArr = this.f16188c;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    public final Object getItem(int i2) {
        return this.f16188c[i2];
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f16187b).inflate(R.layout.pb_relationship_dialog_item, (ViewGroup) null, false);
        }
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.relationship_dialog_item_rbtn_relation);
        radioButton.setTag(Integer.valueOf(i2));
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.relationship_dialog_item_rtv_item);
        roboTextView.setText(this.f16188c[i2]);
        if (this.f16189d == i2) {
            radioButton.setChecked(true);
            roboTextView.setTypeface(Typeface.create("sans-serif-medium", 0));
        } else {
            roboTextView.setTypeface(Typeface.create("sans-serif-light", 0));
            radioButton.setChecked(false);
        }
        radioButton.setOnClickListener(this);
        return view;
    }

    public final void a(int i2) {
        this.f16189d = i2;
        notifyDataSetChanged();
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.f16186a.onItemClick((AdapterView) null, (View) null, intValue, getItemId(intValue));
    }
}
