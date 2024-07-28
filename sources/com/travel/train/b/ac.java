package com.travel.train.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRTrainFilterItem;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;

public final class ac extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJRTrainFilterItem> f26171a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    final Activity f26172b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRTrainFilterItem> f26173c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26174d = false;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f26175e;

    /* renamed from: f  reason: collision with root package name */
    private int f26176f;

    /* renamed from: g  reason: collision with root package name */
    private final String f26177g = "CJRTrainFilterCoachAdapter";

    public ac(Activity activity, ArrayList<CJRTrainFilterItem> arrayList) {
        this.f26172b = activity;
        this.f26173c = arrayList;
        int i2 = 0;
        ArrayList<CJRTrainFilterItem> arrayList2 = this.f26173c;
        if (arrayList2 != null) {
            if (arrayList2 == null) {
                k.a();
            }
            i2 = arrayList2.size();
        }
        this.f26176f = i2;
        Activity activity2 = this.f26172b;
        if (activity2 != null) {
            Object systemService = activity2.getSystemService("layout_inflater");
            if (systemService != null) {
                this.f26175e = (LayoutInflater) systemService;
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String sb;
        String sb2;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        TextView textView = aVar.f26178a;
        ArrayList<CJRTrainFilterItem> arrayList = this.f26173c;
        if (arrayList == null) {
            k.a();
        }
        int i3 = i2 * 2;
        CJRTrainFilterItem cJRTrainFilterItem = arrayList.get(i3);
        k.a((Object) cJRTrainFilterItem, "mCoachTypeList!![2 * position]");
        if (cJRTrainFilterItem.getValues().size() > 1) {
            ArrayList<CJRTrainFilterItem> arrayList2 = this.f26173c;
            if (arrayList2 == null) {
                k.a();
            }
            CJRTrainFilterItem cJRTrainFilterItem2 = arrayList2.get(i3);
            k.a((Object) cJRTrainFilterItem2, "mCoachTypeList!![2 * position]");
            sb = cJRTrainFilterItem2.getLabel();
        } else {
            StringBuilder sb3 = new StringBuilder();
            ArrayList<CJRTrainFilterItem> arrayList3 = this.f26173c;
            if (arrayList3 == null) {
                k.a();
            }
            CJRTrainFilterItem cJRTrainFilterItem3 = arrayList3.get(i3);
            k.a((Object) cJRTrainFilterItem3, "mCoachTypeList!![2 * position]");
            sb3.append(cJRTrainFilterItem3.getValues().get(0));
            sb3.append(" - ");
            ArrayList<CJRTrainFilterItem> arrayList4 = this.f26173c;
            if (arrayList4 == null) {
                k.a();
            }
            CJRTrainFilterItem cJRTrainFilterItem4 = arrayList4.get(i3);
            k.a((Object) cJRTrainFilterItem4, "mCoachTypeList!![2 * position]");
            sb3.append(cJRTrainFilterItem4.getLabel());
            sb = sb3.toString();
        }
        textView.setText(sb);
        ArrayList<CJRTrainFilterItem> arrayList5 = this.f26173c;
        if (arrayList5 == null) {
            k.a();
        }
        if (i2 < arrayList5.size() / 2) {
            TextView textView2 = aVar.f26179b;
            ArrayList<CJRTrainFilterItem> arrayList6 = this.f26173c;
            if (arrayList6 == null) {
                k.a();
            }
            int i4 = i3 + 1;
            CJRTrainFilterItem cJRTrainFilterItem5 = arrayList6.get(i4);
            k.a((Object) cJRTrainFilterItem5, "mCoachTypeList!![2 * position + 1]");
            if (cJRTrainFilterItem5.getValues().size() > 1) {
                ArrayList<CJRTrainFilterItem> arrayList7 = this.f26173c;
                if (arrayList7 == null) {
                    k.a();
                }
                CJRTrainFilterItem cJRTrainFilterItem6 = arrayList7.get(i4);
                k.a((Object) cJRTrainFilterItem6, "mCoachTypeList!![2 * position + 1]");
                sb2 = cJRTrainFilterItem6.getLabel();
            } else {
                StringBuilder sb4 = new StringBuilder();
                ArrayList<CJRTrainFilterItem> arrayList8 = this.f26173c;
                if (arrayList8 == null) {
                    k.a();
                }
                CJRTrainFilterItem cJRTrainFilterItem7 = arrayList8.get(i4);
                k.a((Object) cJRTrainFilterItem7, "mCoachTypeList!![2 * position + 1]");
                sb4.append(cJRTrainFilterItem7.getValues().get(0));
                sb4.append(" - ");
                ArrayList<CJRTrainFilterItem> arrayList9 = this.f26173c;
                if (arrayList9 == null) {
                    k.a();
                }
                CJRTrainFilterItem cJRTrainFilterItem8 = arrayList9.get(i4);
                k.a((Object) cJRTrainFilterItem8, "mCoachTypeList!![2 * position + 1]");
                sb4.append(cJRTrainFilterItem8.getLabel());
                sb2 = sb4.toString();
            }
            textView2.setText(sb2);
        } else {
            aVar.f26179b.setVisibility(8);
        }
        ArrayList<CJRTrainFilterItem> arrayList10 = this.f26173c;
        if (arrayList10 == null) {
            k.a();
        }
        CJRTrainFilterItem cJRTrainFilterItem9 = arrayList10.get(i3);
        k.a((Object) cJRTrainFilterItem9, "mCoachTypeList!![2 * position]");
        if (cJRTrainFilterItem9.isSelectValue()) {
            aVar.f26178a.setSelected(true);
            ArrayList<CJRTrainFilterItem> arrayList11 = this.f26171a;
            ArrayList<CJRTrainFilterItem> arrayList12 = this.f26173c;
            if (arrayList12 == null) {
                k.a();
            }
            arrayList11.add(arrayList12.get(i3));
        }
        ArrayList<CJRTrainFilterItem> arrayList13 = this.f26173c;
        if (arrayList13 == null) {
            k.a();
        }
        if (i2 < arrayList13.size() / 2) {
            ArrayList<CJRTrainFilterItem> arrayList14 = this.f26173c;
            if (arrayList14 == null) {
                k.a();
            }
            int i5 = i3 + 1;
            CJRTrainFilterItem cJRTrainFilterItem10 = arrayList14.get(i5);
            k.a((Object) cJRTrainFilterItem10, "mCoachTypeList!![2 * position + 1]");
            if (cJRTrainFilterItem10.isSelectValue()) {
                aVar.f26179b.setSelected(true);
                ArrayList<CJRTrainFilterItem> arrayList15 = this.f26171a;
                ArrayList<CJRTrainFilterItem> arrayList16 = this.f26173c;
                if (arrayList16 == null) {
                    k.a();
                }
                arrayList15.add(arrayList16.get(i5));
            }
        }
        aVar.f26178a.setOnClickListener(new b(this, aVar, i2));
        aVar.f26179b.setOnClickListener(new c(this, aVar, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater layoutInflater = this.f26175e;
        if (layoutInflater == null) {
            k.a();
        }
        View inflate = layoutInflater.inflate(R.layout.pre_t_train_filter_coach_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f26182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f26183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26184c;

        b(ac acVar, a aVar, int i2) {
            this.f26182a = acVar;
            this.f26183b = aVar;
            this.f26184c = i2;
        }

        public final void onClick(View view) {
            if (!this.f26183b.f26178a.isSelected()) {
                ArrayList<CJRTrainFilterItem> arrayList = this.f26182a.f26173c;
                if (arrayList == null) {
                    k.a();
                }
                CJRTrainFilterItem cJRTrainFilterItem = arrayList.get(this.f26184c * 2);
                k.a((Object) cJRTrainFilterItem, "mCoachTypeList!![2 * position]");
                cJRTrainFilterItem.setSelectValue(true);
                ArrayList<CJRTrainFilterItem> arrayList2 = this.f26182a.f26171a;
                ArrayList<CJRTrainFilterItem> arrayList3 = this.f26182a.f26173c;
                if (arrayList3 == null) {
                    k.a();
                }
                arrayList2.add(arrayList3.get(this.f26184c * 2));
                this.f26183b.f26178a.setSelected(true);
                return;
            }
            ArrayList<CJRTrainFilterItem> arrayList4 = this.f26182a.f26173c;
            if (arrayList4 == null) {
                k.a();
            }
            CJRTrainFilterItem cJRTrainFilterItem2 = arrayList4.get(this.f26184c * 2);
            k.a((Object) cJRTrainFilterItem2, "mCoachTypeList!![2 * position]");
            cJRTrainFilterItem2.setSelectValue(false);
            ArrayList<CJRTrainFilterItem> arrayList5 = this.f26182a.f26171a;
            ArrayList<CJRTrainFilterItem> arrayList6 = this.f26182a.f26173c;
            if (arrayList6 == null) {
                k.a();
            }
            arrayList5.remove(arrayList6.get(this.f26184c * 2));
            this.f26183b.f26178a.setSelected(false);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f26185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f26186b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26187c;

        c(ac acVar, a aVar, int i2) {
            this.f26185a = acVar;
            this.f26186b = aVar;
            this.f26187c = i2;
        }

        public final void onClick(View view) {
            if (!this.f26186b.f26179b.isSelected()) {
                ArrayList<CJRTrainFilterItem> arrayList = this.f26185a.f26173c;
                if (arrayList == null) {
                    k.a();
                }
                CJRTrainFilterItem cJRTrainFilterItem = arrayList.get((this.f26187c * 2) + 1);
                k.a((Object) cJRTrainFilterItem, "mCoachTypeList!![2 * position + 1]");
                cJRTrainFilterItem.setSelectValue(true);
                ArrayList<CJRTrainFilterItem> arrayList2 = this.f26185a.f26171a;
                ArrayList<CJRTrainFilterItem> arrayList3 = this.f26185a.f26173c;
                if (arrayList3 == null) {
                    k.a();
                }
                arrayList2.add(arrayList3.get((this.f26187c * 2) + 1));
                this.f26186b.f26179b.setSelected(true);
                return;
            }
            ArrayList<CJRTrainFilterItem> arrayList4 = this.f26185a.f26173c;
            if (arrayList4 == null) {
                k.a();
            }
            CJRTrainFilterItem cJRTrainFilterItem2 = arrayList4.get((this.f26187c * 2) + 1);
            k.a((Object) cJRTrainFilterItem2, "mCoachTypeList!![2 * position + 1]");
            cJRTrainFilterItem2.setSelectValue(false);
            ArrayList<CJRTrainFilterItem> arrayList5 = this.f26185a.f26171a;
            ArrayList<CJRTrainFilterItem> arrayList6 = this.f26185a.f26173c;
            if (arrayList6 == null) {
                k.a();
            }
            arrayList5.remove(arrayList6.get((this.f26187c * 2) + 1));
            this.f26186b.f26179b.setSelected(false);
        }
    }

    public final int getItemCount() {
        ArrayList<CJRTrainFilterItem> arrayList = this.f26173c;
        if (arrayList == null) {
            k.a();
        }
        if (arrayList.size() % 2 == 0) {
            ArrayList<CJRTrainFilterItem> arrayList2 = this.f26173c;
            if (arrayList2 == null) {
                k.a();
            }
            return arrayList2.size() / 2;
        }
        ArrayList<CJRTrainFilterItem> arrayList3 = this.f26173c;
        if (arrayList3 == null) {
            k.a();
        }
        return (arrayList3.size() / 2) + 1;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f26178a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f26179b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ac f26180c;

        /* renamed from: d  reason: collision with root package name */
        private final RelativeLayout f26181d;

        /* JADX WARNING: type inference failed for: r3v0, types: [android.view.View, com.travel.train.b.ac] */
        /* JADX WARNING: type inference failed for: r4v0, types: [int, android.view.View, java.lang.Object] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.view.View r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "itemView"
                kotlin.g.b.k.c(r4, r0)
                r2.f26180c = r3
                r2.<init>(r4)
                int r0 = com.travel.train.R.id.coach_type_item_name
                android.view.View r0 = r4.findViewById(r0)
                java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
                if (r0 == 0) goto L_0x0044
                android.widget.TextView r0 = (android.widget.TextView) r0
                r2.f26178a = r0
                int r0 = com.travel.train.R.id.coach_type_item_name2
                android.view.View r0 = r4.findViewById(r0)
                if (r0 == 0) goto L_0x003e
                android.widget.TextView r0 = (android.widget.TextView) r0
                r2.f26179b = r0
                android.app.Activity r3 = r3.f26172b
                com.paytm.utility.b.a((android.app.Activity) r3)
                int r3 = com.travel.train.R.id.lyt_coach_parent
                android.view.View r3 = r4.findViewById(r3)
                if (r3 == 0) goto L_0x0036
                android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
                r2.f26181d = r3
                return
            L_0x0036:
                kotlin.u r3 = new kotlin.u
                java.lang.String r4 = "null cannot be cast to non-null type android.widget.RelativeLayout"
                r3.<init>(r4)
                throw r3
            L_0x003e:
                kotlin.u r3 = new kotlin.u
                r3.<init>(r1)
                throw r3
            L_0x0044:
                kotlin.u r3 = new kotlin.u
                r3.<init>(r1)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.ac.a.<init>(com.travel.train.b.ac, android.view.View):void");
        }
    }
}
