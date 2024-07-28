package com.travel.train.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryResponse;
import java.util.ArrayList;
import net.one97.paytm.common.entity.trainticket.CJRTrainOrderSummaryContactUs;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    Activity f27289a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainOrderSummaryResponse f27290b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f27291c;

    /* renamed from: d  reason: collision with root package name */
    int f27292d;

    /* renamed from: e  reason: collision with root package name */
    Dialog f27293e;

    /* renamed from: f  reason: collision with root package name */
    Dialog f27294f;

    /* renamed from: g  reason: collision with root package name */
    ab f27295g;

    public g(Activity activity, ab abVar) {
        this.f27289a = activity;
        this.f27295g = abVar;
    }

    public final void a() {
        if (this.f27290b != null) {
            this.f27291c = new ArrayList<>();
            for (int i2 = 0; i2 < this.f27290b.getBody().getContactUsDetails().size(); i2++) {
                this.f27291c.add(this.f27290b.getBody().getContactUsDetails().get(i2).getName());
            }
            CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse = this.f27290b;
            if (cJRTrainOrderSummaryResponse.getBody().getContactUsDetails().size() >= 2) {
                this.f27291c.add(0, "Select All");
                cJRTrainOrderSummaryResponse.getBody().getContactUsDetails().get(0);
                String string = this.f27289a.getResources().getString(R.string.contact_us_title_for_train_regarding);
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f27289a);
                TextView textView = new TextView(this.f27289a);
                textView.setText(string);
                textView.setPadding(10, 10, 10, 10);
                textView.setGravity(17);
                textView.setTextSize(18.0f);
                textView.setTextColor(this.f27289a.getResources().getColor(R.color.color_33b5e5));
                final ListView listView = new ListView(this.f27289a);
                listView.setChoiceMode(1);
                listView.setAdapter(new a(this.f27289a));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        if (g.this.f27293e.isShowing()) {
                            g.this.f27292d = i2;
                        }
                    }
                });
                builder.setCustomTitle(textView);
                builder.setInverseBackgroundForced(true);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        int i3;
                        Resources resources = g.this.f27289a.getResources();
                        ListView listView = listView;
                        boolean z = false;
                        if (Build.VERSION.SDK_INT >= 11) {
                            i3 = listView.getCheckedItemCount();
                        } else {
                            int i4 = 0;
                            for (int count = listView.getCount() - 1; count >= 0; count--) {
                                if (listView.isItemChecked(count)) {
                                    i4++;
                                }
                            }
                            i3 = i4;
                        }
                        if (i3 == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(g.this.f27289a);
                            TextView textView = new TextView(g.this.f27289a);
                            textView.setText(g.this.f27289a.getResources().getString(R.string.error));
                            textView.setPadding(10, 10, 10, 10);
                            textView.setGravity(17);
                            textView.setTextSize(20.0f);
                            textView.setTextColor(g.this.f27289a.getResources().getColor(R.color.color_33b5e5));
                            builder.setCustomTitle(textView);
                            builder.setMessage(g.this.f27289a.getResources().getString(R.string.contact_us_select_item_message));
                            builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    g.this.f27294f.dismiss();
                                    g.this.f27293e.show();
                                }
                            });
                            g.this.f27294f = builder.create();
                            g.this.f27294f.setCanceledOnTouchOutside(true);
                            g.this.f27294f.show();
                            return;
                        }
                        g.this.f27293e.dismiss();
                        if (g.this.f27292d == 0) {
                            z = true;
                        }
                        if (g.this.f27292d > 0) {
                            g.this.f27292d--;
                        }
                        CJRTrainOrderSummaryContactUs cJRTrainOrderSummaryContactUs = g.this.f27290b.getBody().getContactUsDetails().get(g.this.f27292d);
                        cJRTrainOrderSummaryContactUs.setOrderId(g.this.f27290b.getBody().getBookingId());
                        cJRTrainOrderSummaryContactUs.setAllItemsSelected(z);
                        g.this.f27295g.a(cJRTrainOrderSummaryContactUs, ah.CST_HANDLING);
                    }
                });
                builder.setView(listView);
                this.f27293e = builder.create();
                this.f27293e.setCanceledOnTouchOutside(true);
                this.f27292d = 0;
                this.f27293e.show();
            } else if (cJRTrainOrderSummaryResponse.getBody().getContactUsDetails() != null && cJRTrainOrderSummaryResponse.getBody().getContactUsDetails().size() > 0) {
                CJRTrainOrderSummaryContactUs cJRTrainOrderSummaryContactUs = this.f27290b.getBody().getContactUsDetails().get(0);
                cJRTrainOrderSummaryContactUs.setOrderId(this.f27290b.getBody().getBookingId());
                this.f27295g.a(cJRTrainOrderSummaryContactUs, ah.CST_HANDLING);
            }
        }
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater f27301b = ((LayoutInflater) this.f27302c.getSystemService("layout_inflater"));

        /* renamed from: c  reason: collision with root package name */
        private Context f27302c;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context) {
            this.f27302c = context;
        }

        public final int getCount() {
            return g.this.f27291c.size();
        }

        public final Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f27301b.inflate(R.layout.pre_t_contact_all_reason_single_item, (ViewGroup) null);
                bVar.f27303a = (CheckedTextView) view2.findViewById(R.id.singleItem);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f27303a.setText(g.this.f27291c.get(i2));
            return view2;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f27303a;

        b() {
        }
    }
}
