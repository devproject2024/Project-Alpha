package net.one97.paytm.o2o.amusementpark.a;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.c.b.a;
import net.one97.paytm.o2o.amusementpark.c.g;

public final class l extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f73206a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<a, List<CJRSeatDetailsModel>> f73207b;

    /* renamed from: c  reason: collision with root package name */
    g.a f73208c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f73209d;

    public final long getChildId(int i2, int i3) {
        return (long) i3;
    }

    public final long getGroupId(int i2) {
        return (long) i2;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public l(Context context, List<a> list, HashMap<a, List<CJRSeatDetailsModel>> hashMap, g.a aVar) {
        this.f73209d = context;
        this.f73206a = list;
        this.f73207b = hashMap;
        this.f73208c = aVar;
    }

    public final Object getChild(int i2, int i3) {
        return this.f73207b.get(this.f73206a.get(i2)).get(i3);
    }

    public final View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        final CJRSeatDetailsModel cJRSeatDetailsModel = (CJRSeatDetailsModel) getChild(i2, i3);
        if (view == null) {
            view = ((LayoutInflater) this.f73209d.getSystemService("layout_inflater")).inflate(R.layout.amp_package_list_child_item, viewGroup, false);
        }
        final RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.tv_seat_type);
        roboTextView.setText(cJRSeatDetailsModel.getSeatType());
        ((RoboTextView) view.findViewById(R.id.tv_seatDescription)).setText(cJRSeatDetailsModel.getSeatDescription());
        String seatType = cJRSeatDetailsModel.getSeatType();
        String seatDescription = cJRSeatDetailsModel.getSeatDescription();
        boolean z2 = true;
        if ((TextUtils.isEmpty(seatType) || seatType.length() < 18) && (TextUtils.isEmpty(seatDescription) || seatDescription.length() < 18)) {
            z2 = false;
        }
        if (z2) {
            roboTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.amp_info, 0);
            roboTextView.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0 || motionEvent.getRawX() < ((float) (roboTextView.getRight() - roboTextView.getCompoundDrawables()[2].getBounds().width()))) {
                        return false;
                    }
                    View inflate = LayoutInflater.from(l.this.f73209d).inflate(R.layout.amp_info_layout, (ViewGroup) null);
                    ((RoboTextView) inflate.findViewById(R.id.text1)).setText(cJRSeatDetailsModel.getSeatType());
                    ((RoboTextView) inflate.findViewById(R.id.text2)).setText(cJRSeatDetailsModel.getSeatDescription());
                    l.a(inflate, l.this.f73209d);
                    return true;
                }
            });
        } else {
            roboTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        ((RoboTextView) view.findViewById(R.id.tv_seatPrice)).setText(FilterPriceSliderFragment.RUPEE_SYMBOL + cJRSeatDetailsModel.getPrice());
        RoboTextView roboTextView2 = (RoboTextView) view.findViewById(R.id.child);
        TextView textView = (TextView) view.findViewById(R.id.tv_add_button);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout);
        final RoboTextView roboTextView3 = (RoboTextView) view.findViewById(R.id.tv_count);
        if (cJRSeatDetailsModel == null || cJRSeatDetailsModel.getSelectedQuantity() != 0) {
            roboTextView3.setText(String.valueOf(cJRSeatDetailsModel.getSelectedQuantity()));
            linearLayout.setVisibility(0);
            textView.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            textView.setVisibility(0);
        }
        final RoboTextView roboTextView4 = roboTextView3;
        final TextView textView2 = textView;
        final LinearLayout linearLayout2 = linearLayout;
        final CJRSeatDetailsModel cJRSeatDetailsModel2 = cJRSeatDetailsModel;
        ((ImageView) view.findViewById(R.id.iv_decrease)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int a2 = l.a(roboTextView4.getText().toString()) - 1;
                if (a2 == 0) {
                    textView2.setVisibility(0);
                    linearLayout2.setVisibility(8);
                    roboTextView4.setText(String.valueOf(a2));
                    cJRSeatDetailsModel2.setSelectedQuantity(a2);
                } else {
                    cJRSeatDetailsModel2.setSelectedQuantity(a2);
                    roboTextView4.setText(String.valueOf(a2));
                }
                if (l.this.f73208c != null) {
                    l.this.f73208c.a();
                }
            }
        });
        ((ImageView) view.findViewById(R.id.iv_increase)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int a2 = l.a(roboTextView3.getText().toString());
                if (a2 >= cJRSeatDetailsModel.getSeatsAvailable()) {
                    Context context = view.getContext();
                    Toast.makeText(context, "Maximum of " + cJRSeatDetailsModel.getSeatsAvailable() + " tickets can be selected", 1).show();
                } else {
                    int i2 = a2 + 1;
                    roboTextView3.setText(String.valueOf(i2));
                    cJRSeatDetailsModel.setSelectedQuantity(i2);
                }
                if (l.this.f73208c != null) {
                    l.this.f73208c.a();
                }
            }
        });
        final LinearLayout linearLayout3 = linearLayout;
        final RoboTextView roboTextView5 = roboTextView3;
        final CJRSeatDetailsModel cJRSeatDetailsModel3 = cJRSeatDetailsModel;
        final TextView textView3 = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                linearLayout3.setVisibility(0);
                roboTextView5.setText("1");
                cJRSeatDetailsModel3.setSelectedQuantity(l.a(roboTextView5.getText().toString()));
                textView3.setVisibility(8);
                if (l.this.f73208c != null) {
                    l.this.f73208c.a();
                }
            }
        });
        roboTextView2.setText(cJRSeatDetailsModel.getmPackageType());
        return view;
    }

    public final int getChildrenCount(int i2) {
        return this.f73207b.get(this.f73206a.get(i2)).size();
    }

    public final Object getGroup(int i2) {
        return this.f73206a.get(i2);
    }

    public final int getGroupCount() {
        return this.f73206a.size();
    }

    public final View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar = (a) getGroup(i2);
        if (view == null) {
            view = ((LayoutInflater) this.f73209d.getSystemService("layout_inflater")).inflate(R.layout.amp_package_list_parent_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_icon);
        ((RoboTextView) view.findViewById(R.id.tv_packageDescription)).setText(aVar.getPackageDescription());
        ((RoboTextView) view.findViewById(R.id.tv_packageType)).setText(aVar.getmPackageType());
        ((RoboTextView) view.findViewById(R.id.tv_packagePrice)).setText(aVar.getDisplayPriceText());
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.amp_collapsed, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.amp_expand, 0, 0, 0);
        }
        return view;
    }

    public static void a(View view, Context context) {
        AlertDialog create = new AlertDialog.Builder(context).create();
        create.setView(view);
        create.show();
    }

    public final int a() {
        List<a> list = this.f73206a;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.f73206a.size(); i2++) {
                int childrenCount = getChildrenCount(i2);
                for (int i3 = 0; i3 < childrenCount; i3++) {
                    CJRSeatDetailsModel cJRSeatDetailsModel = (CJRSeatDetailsModel) getChild(i2, i3);
                    if (cJRSeatDetailsModel != null && cJRSeatDetailsModel.getSelectedQuantity() > 0) {
                        return i2;
                    }
                }
            }
        }
        List<a> list2 = this.f73206a;
        if (list2 == null || list2.size() <= 0) {
            return -1;
        }
        return 0;
    }

    static /* synthetic */ int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
