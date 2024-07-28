package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DropDownPreference extends ListPreference {
    private final Context B;
    private final ArrayAdapter C;
    private Spinner D;
    private final AdapterView.OnItemSelectedListener E;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private DropDownPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.E = new AdapterView.OnItemSelectedListener() {
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                if (i2 >= 0) {
                    String charSequence = DropDownPreference.this.f30775h[i2].toString();
                    if (!charSequence.equals(DropDownPreference.this.f30776i) && DropDownPreference.this.l()) {
                        DropDownPreference.this.a(charSequence);
                    }
                }
            }
        };
        this.B = context;
        this.C = new ArrayAdapter(this.B, 17367049);
        o();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.D.performClick();
    }

    private void o() {
        this.C.clear();
        if (this.f30774g != null) {
            for (CharSequence charSequence : this.f30774g) {
                this.C.add(charSequence.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        super.b();
        ArrayAdapter arrayAdapter = this.C;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public final void a(k kVar) {
        int i2;
        this.D = (Spinner) kVar.itemView.findViewById(R.id.spinner);
        this.D.setAdapter(this.C);
        this.D.setOnItemSelectedListener(this.E);
        Spinner spinner = this.D;
        String str = this.f30776i;
        CharSequence[] charSequenceArr = this.f30775h;
        if (str != null && charSequenceArr != null) {
            i2 = charSequenceArr.length - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                } else if (charSequenceArr[i2].equals(str)) {
                    break;
                } else {
                    i2--;
                }
            }
            spinner.setSelection(i2);
            super.a(kVar);
        }
        i2 = -1;
        spinner.setSelection(i2);
        super.a(kVar);
    }
}
