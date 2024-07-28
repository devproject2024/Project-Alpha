package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.widgets.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;

public final class k extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRUtilityCheckboxItem> f60568a;

    /* renamed from: b  reason: collision with root package name */
    a f60569b;

    /* renamed from: c  reason: collision with root package name */
    boolean f60570c;

    /* renamed from: d  reason: collision with root package name */
    private Context f60571d;

    /* renamed from: e  reason: collision with root package name */
    private String f60572e;

    public interface a {
        void b(List<CJRUtilityCheckboxItem> list);

        void c(List<CJRUtilityCheckboxItem> list);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final b bVar = (b) vVar;
        bVar.f60580a.setText(this.f60568a.get(i2).getName());
        bVar.f60582c.setTag(Integer.valueOf(i2));
        this.f60568a.get(i2).setCheckBox(bVar.f60582c);
        this.f60568a.get(i2).setPriceEditTextView(bVar.f60581b);
        if (this.f60568a.get(i2).getInputMode() != null) {
            String inputMode = this.f60568a.get(i2).getInputMode();
            char c2 = 65535;
            switch (inputMode.hashCode()) {
                case -1617067184:
                    if (inputMode.equals("hard_disabled")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3195115:
                    if (inputMode.equals("hard")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3387192:
                    if (inputMode.equals("none")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3535914:
                    if (inputMode.equals("soft")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                bVar.f60582c.setChecked(true);
                this.f60568a.get(i2).setChecked(true);
                this.f60569b.b(this.f60568a);
                bVar.f60582c.setEnabled(false);
            } else if (c2 == 1) {
                bVar.f60582c.setChecked(true);
                this.f60568a.get(i2).setChecked(true);
                this.f60569b.b(this.f60568a);
                bVar.f60582c.setEnabled(true);
            } else if (c2 == 2) {
                bVar.f60582c.setChecked(false);
                this.f60568a.get(i2).setChecked(false);
                bVar.f60582c.setEnabled(true);
            } else if (c2 == 3) {
                bVar.f60582c.setChecked(false);
                this.f60568a.get(i2).setChecked(false);
                bVar.f60582c.setEnabled(false);
            }
        } else {
            bVar.f60582c.setChecked(false);
            this.f60568a.get(i2).setChecked(false);
            bVar.f60582c.setEnabled(true);
        }
        bVar.f60582c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2;
                int intValue = ((Integer) compoundButton.getTag()).intValue();
                if (z) {
                    k.this.f60568a.get(intValue).setChecked(true);
                    if (k.this.f60570c && (i2 = intValue + 1) < k.this.getItemCount()) {
                        k.this.f60568a.get(i2).getCheckBox().setEnabled(true);
                        k.this.f60568a.get(i2).getCheckBox().setChecked(false);
                        k.this.f60568a.get(i2).getPriceEditTextView().setEnabled(true);
                    }
                } else {
                    k.this.f60568a.get(intValue).setChecked(false);
                    if (k.this.f60570c) {
                        int itemCount = k.this.getItemCount();
                        for (int i3 = intValue + 1; i3 < itemCount; i3++) {
                            k.this.f60568a.get(i3).setChecked(false);
                            if (k.this.f60568a.get(i3).getCheckBox() != null) {
                                k.this.f60568a.get(i3).getCheckBox().setEnabled(false);
                                k.this.f60568a.get(i3).getCheckBox().setChecked(false);
                            }
                            if (k.this.f60568a.get(i3).getPriceEditTextView() != null) {
                                k.this.f60568a.get(i3).getPriceEditTextView().setEnabled(false);
                            }
                        }
                    }
                }
                k.this.f60569b.b(k.this.f60568a);
            }
        });
        if (getItemViewType(i2) == 1) {
            if (this.f60568a.get(i2).isPriceEditable()) {
                bVar.f60581b.setEnabled(true);
                bVar.f60581b.setVisibility(0);
                bVar.f60586g.setVisibility(8);
                bVar.f60581b.setText(z.c(this.f60568a.get(i2).getPrice()));
            } else {
                bVar.f60586g.setVisibility(0);
                bVar.f60586g.setText(z.c(com.paytm.utility.b.M(this.f60568a.get(i2).getPrice())));
                bVar.f60581b.setVisibility(8);
            }
            if (i2 == getItemCount() - 1) {
                bVar.f60585f.setVisibility(8);
            } else {
                bVar.f60585f.setVisibility(0);
            }
            if (this.f60568a.get(i2).getDisplayValues() == null || this.f60568a.get(i2).getDisplayValues().size() <= 0) {
                bVar.f60583d.setVisibility(4);
                bVar.f60583d.setImageResource(R.drawable.down_arrow_hide);
                bVar.f60584e.setVisibility(8);
            } else {
                LinearLayout linearLayout = bVar.f60584e;
                CJRUtilityCheckboxItem cJRUtilityCheckboxItem = this.f60568a.get(i2);
                int f2 = com.paytm.utility.b.f(this.f60571d);
                for (int i3 = 0; i3 < cJRUtilityCheckboxItem.getDisplayValues().size(); i3++) {
                    Context context = this.f60571d;
                    if (context != null) {
                        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recharge_util_description_layout, (ViewGroup) null);
                        TextView textView = (TextView) linearLayout2.findViewById(R.id.firsttext);
                        ((LinearLayout.LayoutParams) textView.getLayoutParams()).setMargins(0, 0, 0, 0);
                        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.secondtext);
                        if (!TextUtils.isEmpty(cJRUtilityCheckboxItem.getDisplayValues().get(i3).getLabel()) && !TextUtils.isEmpty(cJRUtilityCheckboxItem.getDisplayValues().get(i3).getValue())) {
                            textView.setVisibility(0);
                            textView2.setVisibility(0);
                            textView.setText(cJRUtilityCheckboxItem.getDisplayValues().get(i3).getLabel());
                            textView2.setText(cJRUtilityCheckboxItem.getDisplayValues().get(i3).getValue());
                            textView2.setPadding(0, 0, f2, 0);
                        }
                        linearLayout.addView(linearLayout2);
                    }
                }
                bVar.f60583d.setVisibility(0);
                if (this.f60568a.get(i2).isDisplayValuesExpanded()) {
                    bVar.f60583d.setImageResource(R.drawable.up_arrow_show);
                    bVar.f60584e.setVisibility(0);
                } else {
                    bVar.f60583d.setImageResource(R.drawable.down_arrow_hide);
                    bVar.f60584e.setVisibility(8);
                }
                bVar.f60583d.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (k.this.f60568a.get(i2).isDisplayValuesExpanded()) {
                            bVar.f60583d.setImageResource(R.drawable.down_arrow_hide);
                            bVar.f60584e.setVisibility(8);
                            k.this.f60568a.get(i2).setDisplayValuesExpanded(false);
                            return;
                        }
                        bVar.f60583d.setImageResource(R.drawable.up_arrow_show);
                        bVar.f60584e.setVisibility(0);
                        k.this.f60568a.get(i2).setDisplayValuesExpanded(true);
                    }
                });
            }
        } else if (getItemViewType(i2) == 0) {
            bVar.f60581b.setVisibility(0);
            bVar.f60581b.setText(this.f60568a.get(i2).getPrice());
            bVar.f60581b.setEnabled(false);
            if (this.f60568a.get(i2).isPriceEditable()) {
                bVar.f60581b.setEnabled(true);
            }
        }
        bVar.f60581b.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                k.this.f60568a.get(i2).setPrice(charSequence.toString());
                k.this.f60569b.c(k.this.f60568a);
            }

            public final void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable.toString())) {
                    bVar.f60582c.setChecked(false);
                } else if (bVar.f60582c.isEnabled()) {
                    bVar.f60582c.setChecked(true);
                }
            }
        });
        if (!this.f60570c) {
            return;
        }
        if (i2 <= 0 || this.f60568a.get(i2 - 1).isChecked()) {
            bVar.f60582c.setEnabled(true);
            bVar.f60581b.setEnabled(true);
            return;
        }
        bVar.f60582c.setEnabled(false);
        bVar.f60582c.setChecked(false);
        this.f60568a.get(i2).setChecked(false);
        bVar.f60581b.setEnabled(false);
    }

    public k(Context context, List<CJRUtilityCheckboxItem> list, a aVar, String str, boolean z) {
        this.f60568a = list;
        this.f60571d = context;
        this.f60569b = aVar;
        this.f60572e = str;
        this.f60570c = z;
    }

    public final int getItemCount() {
        return this.f60568a.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60580a;

        /* renamed from: b  reason: collision with root package name */
        public EditText f60581b;

        /* renamed from: c  reason: collision with root package name */
        public CheckBox f60582c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f60583d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f60584e;

        /* renamed from: f  reason: collision with root package name */
        public View f60585f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60586g;

        public b(View view, int i2) {
            super(view);
            this.f60580a = (TextView) view.findViewById(R.id.name);
            this.f60582c = (CheckBox) view.findViewById(R.id.utility_check_box);
            if (i2 == 1) {
                this.f60586g = (TextView) view.findViewById(R.id.price_text_view);
                this.f60581b = (EditText) view.findViewById(R.id.price_edit_text_view);
                this.f60583d = (ImageView) view.findViewById(R.id.arrow_hide_show);
                this.f60584e = (LinearLayout) view.findViewById(R.id.description_layout);
                this.f60585f = view.findViewById(R.id.divider);
                InputFilter[] inputFilterArr = {new f(6, 3)};
                this.f60581b.setInputType(2);
                this.f60581b.setFilters(inputFilterArr);
                return;
            }
            this.f60581b = (EditText) view.findViewById(R.id.price);
            InputFilter[] inputFilterArr2 = {new f(6, 3)};
            this.f60581b.setInputType(2);
            this.f60581b.setFilters(inputFilterArr2);
        }
    }

    public final int getItemViewType(int i2) {
        return "list".equalsIgnoreCase(this.f60572e) ? 1 : 0;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.utility_multiple_checkbox_item, (ViewGroup) null), i2);
        }
        if (i2 == 1) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.utility_multiple_checkbox_item_with_description, (ViewGroup) null), i2);
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.utility_multiple_checkbox_item, (ViewGroup) null), i2);
    }
}
