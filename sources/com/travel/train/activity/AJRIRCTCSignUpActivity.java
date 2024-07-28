package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.f;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.j.b;
import com.travel.train.j.c;
import com.travel.train.j.d;
import com.travel.train.j.g;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.j.u;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.CJRUtilityLocationModel;
import com.travel.train.model.trainticket.CJRCountryCodeList;
import com.travel.train.model.trainticket.CJRCountryList;
import com.travel.train.model.trainticket.CJRCountrys;
import com.travel.train.model.trainticket.CJRIRCTCUserAvailability;
import com.travel.train.model.trainticket.CJRIRCTCUserRegister;
import com.travel.train.model.trainticket.CJRPincodeResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRIRCTCSignUpActivity extends CJRTrainBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, e.b, e.c, b.C0491b, c.a, d.b {
    private static String ab = null;
    private static String cg = "AJRIRCTCSignUpActivity";
    /* access modifiers changed from: private */
    public TextView A;
    /* access modifiers changed from: private */
    public TextView B;
    /* access modifiers changed from: private */
    public TextView C;
    private TextView D;
    /* access modifiers changed from: private */
    public EditText E;
    private TextInputLayout F;
    private TextInputLayout G;
    private TextInputLayout H;
    private TextInputLayout I;
    private TextInputLayout J;
    private HashMap<Integer, String> K = new HashMap<>();
    /* access modifiers changed from: private */
    public EditText L;
    /* access modifiers changed from: private */
    public EditText M;
    /* access modifiers changed from: private */
    public EditText N;
    /* access modifiers changed from: private */
    public EditText O;
    /* access modifiers changed from: private */
    public EditText P;
    private EditText Q;
    /* access modifiers changed from: private */
    public EditText R;
    /* access modifiers changed from: private */
    public EditText S;
    /* access modifiers changed from: private */
    public EditText T;
    /* access modifiers changed from: private */
    public RadioGroup U;
    /* access modifiers changed from: private */
    public RadioGroup V;
    /* access modifiers changed from: private */
    public RadioGroup W;
    /* access modifiers changed from: private */
    public RadioGroup X;
    /* access modifiers changed from: private */
    public RadioGroup Y;
    /* access modifiers changed from: private */
    public RadioGroup Z;

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f25836a;
    private Button aA;
    private Button aB;
    private EditText aC;
    private CJRCountrys aD;
    private CJRCountrys aE;
    private CJRCountrys aF;
    /* access modifiers changed from: private */
    public TextView aG;
    /* access modifiers changed from: private */
    public TextView aH;
    /* access modifiers changed from: private */
    public View aI;
    /* access modifiers changed from: private */
    public View aJ;
    private TextView aK;
    /* access modifiers changed from: private */
    public TextView aL;
    private TextView aM;
    /* access modifiers changed from: private */
    public TextView aN;
    private TextView aO;
    private TextView aP;
    private TextView aQ;
    private TextView aR;
    private TextView aS;
    private TextView aT;
    /* access modifiers changed from: private */
    public TextView aU;
    private TextView aV;
    private TextView aW;
    private TextView aX;
    private TextView aY;
    private TextView aZ;
    /* access modifiers changed from: private */
    public RadioGroup aa;
    private HashMap<Integer, String> ac = new HashMap<>();
    private AutoCompleteTextView ad;
    /* access modifiers changed from: private */
    public AutoCompleteTextView ae;
    private ArrayList<CJRCountrys> af;
    private AutoCompleteTextView ag;
    private ArrayList<String> ah = new ArrayList<>();
    private ArrayList<CJRPincodeResponse.CJRCities> ai = new ArrayList<>();
    private TextInputLayout aj;
    private LinearLayout ak;
    private LinearLayout al;
    private LinearLayout am;
    private LinearLayout an;
    /* access modifiers changed from: private */
    public LinearLayout ao;
    private LinearLayout ap;
    private CheckBox aq;
    /* access modifiers changed from: private */
    public String ar = "Y";
    /* access modifiers changed from: private */
    public AutoCompleteTextView as;
    /* access modifiers changed from: private */
    public EditText at;
    private EditText au;
    private TextInputLayout av;
    /* access modifiers changed from: private */
    public boolean aw = false;
    private ArrayList<CJRPincodeResponse.CJRCities> ax;
    private ArrayList<String> ay;
    private Button az;

    /* renamed from: b  reason: collision with root package name */
    boolean f25837b = true;
    /* access modifiers changed from: private */
    public ImageView bA;
    /* access modifiers changed from: private */
    public ImageView bB;
    /* access modifiers changed from: private */
    public ImageView bC;
    /* access modifiers changed from: private */
    public ImageView bD;
    /* access modifiers changed from: private */
    public ImageView bE;
    /* access modifiers changed from: private */
    public ImageView bF;
    /* access modifiers changed from: private */
    public ImageView bG;
    /* access modifiers changed from: private */
    public ImageView bH;
    /* access modifiers changed from: private */
    public ImageView bI;
    /* access modifiers changed from: private */
    public ImageView bJ;
    private ImageView bK;
    /* access modifiers changed from: private */
    public ScrollView bL;
    /* access modifiers changed from: private */
    public RadioButton bM;
    /* access modifiers changed from: private */
    public RadioButton bN;
    /* access modifiers changed from: private */
    public RadioButton bO;
    /* access modifiers changed from: private */
    public RadioButton bP;
    /* access modifiers changed from: private */
    public RadioButton bQ;
    /* access modifiers changed from: private */
    public int bR = -1;
    private int bS = -1;
    /* access modifiers changed from: private */
    public int bT = -1;
    /* access modifiers changed from: private */
    public int bU = -1;
    /* access modifiers changed from: private */
    public int bV = -1;
    private RelativeLayout bW;
    private RelativeLayout bX;
    private RelativeLayout bY;
    private RelativeLayout bZ;
    private TextView ba;
    /* access modifiers changed from: private */
    public TextView bb;
    /* access modifiers changed from: private */
    public View bc;
    /* access modifiers changed from: private */
    public View bd;
    /* access modifiers changed from: private */
    public View be;
    /* access modifiers changed from: private */
    public View bf;
    private View bg;
    private View bh;
    /* access modifiers changed from: private */
    public View bi;
    private View bj;
    private View bk;
    /* access modifiers changed from: private */
    public View bl;
    private View bm;
    /* access modifiers changed from: private */
    public View bn;
    private View bo;
    private View bp;
    /* access modifiers changed from: private */
    public View bq;
    private View br;
    /* access modifiers changed from: private */
    public View bs;
    /* access modifiers changed from: private */
    public ImageView bt;
    /* access modifiers changed from: private */
    public ImageView bu;
    /* access modifiers changed from: private */
    public ImageView bv;
    /* access modifiers changed from: private */
    public ImageView bw;
    /* access modifiers changed from: private */
    public ImageView bx;
    /* access modifiers changed from: private */
    public ImageView by;
    /* access modifiers changed from: private */
    public ImageView bz;

    /* renamed from: c  reason: collision with root package name */
    TextView f25838c;
    private RelativeLayout ca;
    /* access modifiers changed from: private */
    public RelativeLayout cb;
    private int cc = -1;
    private d cd;
    private e ce;
    private String cf = AJRIRCTCSignUpActivity.class.getSimpleName();
    private TextWatcher ch = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.aH.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.aH.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bw.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bw.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.aI.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }
    };
    private TextWatcher ci = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.aL.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.aL.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bt.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bt.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.bd.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }
    };
    private TextWatcher cj = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.aN.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.aN.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bu.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bu.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.bf.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }
    };
    private TextWatcher ck = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bv.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bv.setVisibility(8);
            }
        }
    };
    private TextWatcher cl = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bz.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bz.setVisibility(8);
            }
        }
    };
    private TextWatcher cm = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.aU.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.aU.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bA.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bA.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.bn.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }
    };
    private TextWatcher cn = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bB.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bB.setVisibility(8);
            }
        }
    };
    private TextWatcher co = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bD.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bD.setVisibility(8);
            }
        }
    };
    private TextWatcher cp = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.bb.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.bb.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bE.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bE.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.bs.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }
    };
    private View.OnClickListener cq = new View.OnClickListener() {
        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.answer_clear) {
                if (AJRIRCTCSignUpActivity.this.E != null) {
                    AJRIRCTCSignUpActivity.this.E.setText("");
                }
            } else if (id == R.id.first_name_clear) {
                if (AJRIRCTCSignUpActivity.this.L != null) {
                    AJRIRCTCSignUpActivity.this.L.setText("");
                }
            } else if (id == R.id.last_name_clear) {
                if (AJRIRCTCSignUpActivity.this.M != null) {
                    AJRIRCTCSignUpActivity.this.M.setText("");
                }
            } else if (id == R.id.mobile_clear) {
                if (AJRIRCTCSignUpActivity.this.O != null) {
                    AJRIRCTCSignUpActivity.this.O.setText("");
                }
            } else if (id == R.id.email_clear) {
                if (AJRIRCTCSignUpActivity.this.N != null) {
                    AJRIRCTCSignUpActivity.this.N.setText("");
                }
            } else if (id == R.id.pincode_clear) {
                if (AJRIRCTCSignUpActivity.this.P != null) {
                    AJRIRCTCSignUpActivity.this.P.setText("");
                }
            } else if (id == R.id.alternative_clear) {
                if (AJRIRCTCSignUpActivity.this.R != null) {
                    AJRIRCTCSignUpActivity.this.R.setText("");
                }
            } else if (id == R.id.flat_clear) {
                if (AJRIRCTCSignUpActivity.this.T != null) {
                    AJRIRCTCSignUpActivity.this.T.setText("");
                }
            } else if (id == R.id.home_address_clear) {
                if (AJRIRCTCSignUpActivity.this.S != null) {
                    AJRIRCTCSignUpActivity.this.S.setText("");
                }
            } else if (id == R.id.office_pincode_clear) {
                if (AJRIRCTCSignUpActivity.this.at != null) {
                    AJRIRCTCSignUpActivity.this.at.setText("");
                }
            } else if (id == R.id.office_contact_clear) {
                if (AJRIRCTCSignUpActivity.this.o != null) {
                    AJRIRCTCSignUpActivity.this.o.setText("");
                }
            } else if (id == R.id.office_address_clear && AJRIRCTCSignUpActivity.this.p != null) {
                AJRIRCTCSignUpActivity.this.p.setText("");
            }
        }
    };
    private TextWatcher cr = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bC.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bC.setVisibility(8);
            }
            if (charSequence.length() == 6 && AJRIRCTCSignUpActivity.this.as != null && AJRIRCTCSignUpActivity.this.as.getText().toString().equalsIgnoreCase("India")) {
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                aJRIRCTCSignUpActivity.showProgressDialog(aJRIRCTCSignUpActivity, aJRIRCTCSignUpActivity.getString(R.string.please_wait_progress_msg));
                boolean unused = AJRIRCTCSignUpActivity.this.aw = true;
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity2 = AJRIRCTCSignUpActivity.this;
                new c(aJRIRCTCSignUpActivity2, aJRIRCTCSignUpActivity2).a(charSequence.toString());
            }
        }
    };
    private TextWatcher cs = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.by.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.by.setVisibility(8);
            }
            if (charSequence.length() == 6 && AJRIRCTCSignUpActivity.this.ae != null && AJRIRCTCSignUpActivity.this.ae.getText().toString().equalsIgnoreCase("India")) {
                AJRIRCTCSignUpActivity.this.hideKeyboard();
                boolean unused = AJRIRCTCSignUpActivity.this.aw = false;
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                aJRIRCTCSignUpActivity.showProgressDialog(aJRIRCTCSignUpActivity, aJRIRCTCSignUpActivity.getString(R.string.please_wait_progress_msg));
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity2 = AJRIRCTCSignUpActivity.this;
                new c(aJRIRCTCSignUpActivity2, aJRIRCTCSignUpActivity2).a(charSequence.toString());
            }
        }
    };
    private View.OnFocusChangeListener ct = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            if (!z || AJRIRCTCSignUpActivity.this.m.getText().toString().length() < 30) {
                AJRIRCTCSignUpActivity.this.x.setVisibility(8);
            } else {
                AJRIRCTCSignUpActivity.this.x.setVisibility(0);
            }
        }
    };
    private TextWatcher cu = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.u.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.u.setVisibility(8);
            }
            if (AJRIRCTCSignUpActivity.this.w.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.w.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.v.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }

        public final void afterTextChanged(Editable editable) {
            TextView av = AJRIRCTCSignUpActivity.this.x;
            av.setText("You have " + (35 - editable.toString().length()) + " of 35 chars remaining.");
            if (editable.toString().length() > 0 && AJRIRCTCSignUpActivity.this.f25837b) {
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                aJRIRCTCSignUpActivity.f25837b = false;
                aJRIRCTCSignUpActivity.cb.setVisibility(0);
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        AJRIRCTCSignUpActivity.this.cb.setVisibility(8);
                    }
                }, 5000);
            }
            if (editable.toString().length() > 30) {
                AJRIRCTCSignUpActivity.this.x.setVisibility(0);
                AJRIRCTCSignUpActivity.this.x.setBackgroundColor(Color.parseColor("#ffdcdb"));
                AJRIRCTCSignUpActivity.this.x.setTextColor(Color.parseColor("#ee3131"));
                return;
            }
            AJRIRCTCSignUpActivity.this.x.setVisibility(8);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    TextView f25839d;

    /* renamed from: e  reason: collision with root package name */
    TextView f25840e;

    /* renamed from: f  reason: collision with root package name */
    View f25841f;

    /* renamed from: g  reason: collision with root package name */
    View f25842g;

    /* renamed from: h  reason: collision with root package name */
    View f25843h;

    /* renamed from: i  reason: collision with root package name */
    int f25844i;
    HorizontalScrollView j;
    int k;
    TextWatcher l = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRIRCTCSignUpActivity.this.aG.getVisibility() == 0) {
                AJRIRCTCSignUpActivity.this.aG.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                AJRIRCTCSignUpActivity.this.bx.setVisibility(0);
            } else {
                AJRIRCTCSignUpActivity.this.bx.setVisibility(8);
            }
            AJRIRCTCSignUpActivity.this.aJ.setBackgroundColor(androidx.core.content.b.c(AJRIRCTCSignUpActivity.this, R.color.payment_success_line_grey));
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().length() == 1 && !editable.toString().equals("+")) {
                editable.insert(0, "+91 ");
            }
            if (editable.toString().length() < 4) {
                editable.clear();
            }
        }
    };
    /* access modifiers changed from: private */
    public EditText m;
    private EditText n;
    /* access modifiers changed from: private */
    public EditText o;
    /* access modifiers changed from: private */
    public EditText p;
    private EditText q;
    private EditText r;
    private EditText s;
    private TextInputLayout t;
    /* access modifiers changed from: private */
    public LinearLayout u;
    /* access modifiers changed from: private */
    public View v;
    /* access modifiers changed from: private */
    public TextView w;
    /* access modifiers changed from: private */
    public TextView x;
    /* access modifiers changed from: private */
    public TextView y;
    /* access modifiers changed from: private */
    public TextView z;

    public final void a() {
    }

    public final void a(CJRCountryCodeList cJRCountryCodeList) {
    }

    public final void a(CJRCountryList cJRCountryList) {
    }

    public final void c() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_action_bar_layout);
        String string = getString(R.string.crate_irctc_account);
        setSupportActionBar((Toolbar) findViewById(R.id.base_toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(string);
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRIRCTCSignUpActivity.this.a(view);
            }
        });
        this.f25836a = (FrameLayout) findViewById(R.id.content_frame);
        this.f25836a.addView(getLayoutInflater().inflate(R.layout.pre_t_train_irctc_signup, (ViewGroup) null));
        this.cb = (RelativeLayout) findViewById(R.id.popupTxt);
        this.bG = (ImageView) findViewById(R.id.security_img);
        this.bF = (ImageView) findViewById(R.id.language_img);
        this.bH = (ImageView) findViewById(R.id.occupation_img);
        this.bI = (ImageView) findViewById(R.id.post_img);
        this.bJ = (ImageView) findViewById(R.id.officePost_img);
        this.y = (TextView) findViewById(R.id.security_text);
        this.z = (TextView) findViewById(R.id.language_text);
        this.A = (TextView) findViewById(R.id.occupation_text);
        this.B = (TextView) findViewById(R.id.postOffice_text);
        this.C = (TextView) findViewById(R.id.officePost_text);
        this.q = (EditText) findViewById(R.id.dayEdit);
        this.q.setFilters(new InputFilter[]{new u(31)});
        this.r = (EditText) findViewById(R.id.monthEdit);
        this.r.setFilters(new InputFilter[]{new u(12)});
        this.s = (EditText) findViewById(R.id.yearEdit);
        this.s.setFilters(new InputFilter[]{new u(9999)});
        this.x = (TextView) findViewById(R.id.charTxt);
        this.m = (EditText) findViewById(R.id.irctc_user_id_edt);
        this.t = (TextInputLayout) findViewById(R.id.irctc_user_id_edt_parent);
        this.m.setOnFocusChangeListener(this.ct);
        this.m.addTextChangedListener(this.cu);
        this.aI = findViewById(R.id.email_below_view);
        this.aJ = findViewById(R.id.mobile_below_view);
        this.u = (LinearLayout) findViewById(R.id.available_layout);
        this.v = findViewById(R.id.user_id_view);
        this.w = (TextView) findViewById(R.id.user_id_not_available);
        this.W = (RadioGroup) findViewById(R.id.security_radioGroup);
        this.bM = (RadioButton) findViewById(R.id.security_dummy_radio);
        this.bW = (RelativeLayout) findViewById(R.id.securityRL);
        this.bW.setOnClickListener(this);
        String[] stringArray = getResources().getStringArray(R.array.security_question);
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            this.K.put(Integer.valueOf(i2), stringArray[i2]);
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(stringArray));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) a(5.0f, (Context) this), 0, 0);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText((CharSequence) arrayList.get(i3));
            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
            int a2 = (int) a(15.0f, (Context) this);
            radioButton.setPadding(a2, a2, a2, a2);
            this.W.addView(radioButton, layoutParams);
        }
        this.W.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                int checkedRadioButtonId = AJRIRCTCSignUpActivity.this.W.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) AJRIRCTCSignUpActivity.this.findViewById(checkedRadioButtonId);
                radioButton.setBackgroundResource(R.drawable.pre_t_train_round_light_blue);
                radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button);
                if (AJRIRCTCSignUpActivity.this.bR != -1) {
                    AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                    RadioButton radioButton2 = (RadioButton) aJRIRCTCSignUpActivity.findViewById(aJRIRCTCSignUpActivity.bR);
                    radioButton2.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                    radioButton2.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                }
                int unused = AJRIRCTCSignUpActivity.this.bR = checkedRadioButtonId;
                AJRIRCTCSignUpActivity.this.bc.setVisibility(8);
                AJRIRCTCSignUpActivity.this.W.setVisibility(8);
                AJRIRCTCSignUpActivity.this.bM.setVisibility(0);
                AJRIRCTCSignUpActivity.this.bM.setText(radioButton.getText());
                AJRIRCTCSignUpActivity.this.bG.setImageResource(R.drawable.pre_t_drop);
                AJRIRCTCSignUpActivity.this.y.setTextSize(12.0f);
            }
        });
        this.aG = (TextView) findViewById(R.id.mobile_number_not_available);
        this.aH = (TextView) findViewById(R.id.email_not_avilable);
        this.E = (EditText) findViewById(R.id.security_answer);
        this.E.setOnFocusChangeListener(this);
        this.E.addTextChangedListener(this.ci);
        this.X = (RadioGroup) findViewById(R.id.language_radioGroup);
        this.bN = (RadioButton) findViewById(R.id.language_dummy_radio);
        this.bX = (RelativeLayout) findViewById(R.id.languageRL);
        this.bX.setOnClickListener(this);
        this.be = findViewById(R.id.language_view);
        f();
        int i4 = this.cc;
        if (i4 != -1) {
            b(i4);
            this.be.setVisibility(8);
            this.bN.setVisibility(8);
            this.X.setVisibility(0);
            this.bF.setImageResource(R.drawable.pre_t_drop_up);
            this.z.setTextSize(15.0f);
        }
        this.L = (EditText) findViewById(R.id.first_name);
        this.L.setOnFocusChangeListener(this);
        this.L.addTextChangedListener(this.cj);
        this.M = (EditText) findViewById(R.id.last_name);
        this.M.addTextChangedListener(this.ck);
        this.U = (RadioGroup) findViewById(R.id.gender_group);
        this.V = (RadioGroup) findViewById(R.id.marital_group);
        this.bK = (ImageView) findViewById(R.id.dob_img);
        this.bK.setOnClickListener(this);
        this.Y = (RadioGroup) findViewById(R.id.occupation_radioGroup);
        this.bO = (RadioButton) findViewById(R.id.occupation_dummy_radio);
        this.bY = (RelativeLayout) findViewById(R.id.occupationRL);
        this.bY.setOnClickListener(this);
        this.Z = (RadioGroup) findViewById(R.id.post_radioGroup);
        this.bP = (RadioButton) findViewById(R.id.post_dummy_radio);
        this.bZ = (RelativeLayout) findViewById(R.id.postOfficeRL);
        this.bZ.setOnClickListener(this);
        this.aa = (RadioGroup) findViewById(R.id.officePost_radioGroup);
        this.bQ = (RadioButton) findViewById(R.id.officePost_dummy_radio);
        this.ca = (RelativeLayout) findViewById(R.id.officePostOfficeRL);
        this.ca.setOnClickListener(this);
        e();
        this.N = (EditText) findViewById(R.id.email_id);
        this.N.setOnFocusChangeListener(this);
        this.N.addTextChangedListener(this.ch);
        this.O = (EditText) findViewById(R.id.mobile_number);
        this.O.addTextChangedListener(this.l);
        this.O.setOnFocusChangeListener(this);
        this.ad = (AutoCompleteTextView) findViewById(R.id.personal_info_contry);
        this.ad.setOnClickListener(this);
        this.ae = (AutoCompleteTextView) findViewById(R.id.home_country);
        this.ae.setOnClickListener(this);
        this.P = (EditText) findViewById(R.id.pincode);
        this.Q = (EditText) findViewById(R.id.state);
        this.F = (TextInputLayout) findViewById(R.id.state_parent);
        this.R = (EditText) findViewById(R.id.landline);
        this.R.addTextChangedListener(this.cl);
        this.S = (EditText) findViewById(R.id.home_address);
        this.S.addTextChangedListener(this.cn);
        this.T = (EditText) findViewById(R.id.flat_door_number);
        this.T.setOnFocusChangeListener(this);
        this.T.addTextChangedListener(this.cm);
        this.P.addTextChangedListener(this.cs);
        this.aj = (TextInputLayout) findViewById(R.id.city_text_lyt);
        this.ak = (LinearLayout) findViewById(R.id.post_office_lyt);
        this.ao = (LinearLayout) findViewById(R.id.office_address_lyt);
        this.aq = (CheckBox) findViewById(R.id.copy_residential_address);
        this.as = (AutoCompleteTextView) findViewById(R.id.offic_info_country);
        this.at = (EditText) findViewById(R.id.office_pincode);
        this.bL = (ScrollView) findViewById(R.id.signup_scroll);
        this.G = (TextInputLayout) findViewById(R.id.office_pincode_parent);
        this.au = (EditText) findViewById(R.id.office_state);
        this.H = (TextInputLayout) findViewById(R.id.office_state_parent);
        this.ap = (LinearLayout) findViewById(R.id.office_post_office_lyt);
        this.as.setOnClickListener(this);
        this.av = (TextInputLayout) findViewById(R.id.office_city_text_lyt);
        this.at.addTextChangedListener(this.cr);
        this.az = (Button) findViewById(R.id.irctc_singup_btn);
        this.n = (EditText) findViewById(R.id.city_edit);
        this.aC = (EditText) findViewById(R.id.office_city_edit);
        this.o = (EditText) findViewById(R.id.office_landline);
        this.o.addTextChangedListener(this.co);
        this.I = (TextInputLayout) findViewById(R.id.office_landline_parent);
        this.p = (EditText) findViewById(R.id.office_address);
        this.p.setOnFocusChangeListener(this);
        this.p.addTextChangedListener(this.cp);
        this.J = (TextInputLayout) findViewById(R.id.office_address_parent);
        this.aK = (TextView) findViewById(R.id.question_error);
        this.aL = (TextView) findViewById(R.id.answer_error);
        this.aM = (TextView) findViewById(R.id.language_error);
        this.aN = (TextView) findViewById(R.id.first_name_error);
        this.aO = (TextView) findViewById(R.id.last_name_error);
        this.aP = (TextView) findViewById(R.id.occupation_error);
        this.aQ = (TextView) findViewById(R.id.pincode_error);
        this.aR = (TextView) findViewById(R.id.city_error);
        this.aS = (TextView) findViewById(R.id.post_error);
        this.aT = (TextView) findViewById(R.id.contact_error);
        this.aU = (TextView) findViewById(R.id.flat_error);
        this.aW = (TextView) findViewById(R.id.office_pincode_error);
        this.aX = (TextView) findViewById(R.id.office_city_error);
        this.aY = (TextView) findViewById(R.id.office_post_error);
        this.aZ = (TextView) findViewById(R.id.office_contact_error);
        this.ba = (TextView) findViewById(R.id.office_flat_error);
        this.bb = (TextView) findViewById(R.id.office_address_error);
        this.aV = (TextView) findViewById(R.id.marital_error);
        this.bt = (ImageView) findViewById(R.id.answer_clear);
        this.bt.setOnClickListener(this.cq);
        this.bu = (ImageView) findViewById(R.id.first_name_clear);
        this.bu.setOnClickListener(this.cq);
        this.bv = (ImageView) findViewById(R.id.last_name_clear);
        this.bv.setOnClickListener(this.cq);
        this.bw = (ImageView) findViewById(R.id.email_clear);
        this.bw.setOnClickListener(this.cq);
        this.bx = (ImageView) findViewById(R.id.mobile_clear);
        this.bx.setOnClickListener(this.cq);
        this.by = (ImageView) findViewById(R.id.pincode_clear);
        this.by.setOnClickListener(this.cq);
        this.bz = (ImageView) findViewById(R.id.alternative_clear);
        this.bz.setOnClickListener(this.cq);
        this.bA = (ImageView) findViewById(R.id.flat_clear);
        this.bA.setOnClickListener(this.cq);
        this.bB = (ImageView) findViewById(R.id.home_address_clear);
        this.bB.setOnClickListener(this.cq);
        this.bC = (ImageView) findViewById(R.id.office_pincode_clear);
        this.bC.setOnClickListener(this.cq);
        this.bD = (ImageView) findViewById(R.id.office_contact_clear);
        this.bD.setOnClickListener(this.cq);
        this.bE = (ImageView) findViewById(R.id.office_address_clear);
        this.bE.setOnClickListener(this.cq);
        this.bc = findViewById(R.id.question_view);
        this.bd = findViewById(R.id.answer_view);
        this.bf = findViewById(R.id.first_name_view);
        this.bg = findViewById(R.id.last_name_view);
        this.bi = findViewById(R.id.occupation_view);
        this.bj = findViewById(R.id.pincode_view);
        this.bk = findViewById(R.id.city_view);
        this.bl = findViewById(R.id.post_view);
        this.bm = findViewById(R.id.contact_view);
        this.bn = findViewById(R.id.flat_view);
        this.bh = findViewById(R.id.marital_view);
        this.bo = findViewById(R.id.office_pincode_view);
        this.bp = findViewById(R.id.office_city_view);
        this.bq = findViewById(R.id.office_post_view);
        this.br = findViewById(R.id.office_contact_view);
        this.bs = findViewById(R.id.office_address_view);
        this.az.setOnClickListener(this);
        this.aq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    String unused = AJRIRCTCSignUpActivity.this.ar = "Y";
                    AJRIRCTCSignUpActivity.a(AJRIRCTCSignUpActivity.this, net.one97.paytm.common.utility.d.dk, CommonPayParams.Builder.YES);
                    AJRIRCTCSignUpActivity.this.ao.setVisibility(8);
                    return;
                }
                String unused2 = AJRIRCTCSignUpActivity.this.ar = UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT;
                AJRIRCTCSignUpActivity.a(AJRIRCTCSignUpActivity.this, net.one97.paytm.common.utility.d.dk, CommonPayParams.Builder.NO);
                AJRIRCTCSignUpActivity.this.ao.setVisibility(0);
                AJRIRCTCSignUpActivity.this.bL.post(new Runnable() {
                    public final void run() {
                        AJRIRCTCSignUpActivity.this.bL.smoothScrollTo(0, AJRIRCTCSignUpActivity.this.findViewById(R.id.officeAddressTxtLyt).getTop());
                    }
                });
            }
        });
        this.al = (LinearLayout) findViewById(R.id.irctc_layout_create_id);
        this.am = (LinearLayout) findViewById(R.id.irctc_layout_personal_details);
        this.an = (LinearLayout) findViewById(R.id.irctc_layout_res_details);
        this.aA = (Button) findViewById(R.id.irctc_continue_btn_1);
        this.aB = (Button) findViewById(R.id.irctc_continue_btn_2);
        this.aA.setOnClickListener(this);
        this.aB.setOnClickListener(this);
        RadioGroup radioGroup = this.W;
        if (radioGroup != null && radioGroup.getChildCount() > 0) {
            ((RadioButton) this.W.getChildAt(1)).setChecked(true);
        }
        if (com.paytm.utility.b.l((Context) this) != null && !TextUtils.isEmpty(com.paytm.utility.b.l((Context) this))) {
            StringBuilder sb = new StringBuilder();
            sb.append("+91 ");
            sb.append(com.paytm.utility.b.l((Context) this));
            this.O.setText(sb);
            EditText editText = this.R;
            if (editText != null) {
                editText.setText(sb);
            }
        }
        if (com.paytm.utility.b.m((Context) this) != null && !TextUtils.isEmpty(com.paytm.utility.b.m((Context) this))) {
            this.N.setText(com.paytm.utility.b.m((Context) this));
        }
        this.ad.setText("India");
        this.as.setText("India");
        this.ae.setText("India");
        this.aD = new CJRCountrys();
        this.aD.setCountry("India");
        this.aD.setCountryId("94");
        this.aE = new CJRCountrys();
        this.aE.setCountry("India");
        this.aE.setCountryId("94");
        this.aF = new CJRCountrys();
        this.aF.setCountry("India");
        this.aF.setCountryId("94");
        this.Q.setEnabled(false);
        this.n.setEnabled(false);
        this.aj.setVisibility(8);
        this.F.setVisibility(8);
        this.bk.setVisibility(8);
        findViewById(R.id.state_view).setVisibility(8);
        this.ak.setVisibility(8);
        this.bl.setVisibility(8);
        this.au.setEnabled(false);
        this.aC.setEnabled(false);
        this.H.setVisibility(8);
        this.av.setVisibility(8);
        this.bp.setVisibility(8);
        findViewById(R.id.office_state_view).setVisibility(8);
        this.ap.setVisibility(8);
        this.bq.setVisibility(8);
        RadioGroup radioGroup2 = this.V;
        if (radioGroup2 != null && radioGroup2.getChildCount() > 0) {
            ((RadioButton) this.V.getChildAt(1)).setChecked(true);
        }
        this.U.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                RadioButton radioButton = (RadioButton) AJRIRCTCSignUpActivity.this.findViewById(AJRIRCTCSignUpActivity.this.U.getCheckedRadioButtonId());
                if (AJRIRCTCSignUpActivity.this.getString(R.string.male).equalsIgnoreCase(radioButton.getText().toString())) {
                    ((RadioButton) AJRIRCTCSignUpActivity.this.V.getChildAt(1)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_traveller_train_selector_unmarried_male, 0, 0);
                } else if (AJRIRCTCSignUpActivity.this.getString(R.string.female).equalsIgnoreCase(radioButton.getText().toString())) {
                    ((RadioButton) AJRIRCTCSignUpActivity.this.V.getChildAt(1)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_traveller_train_selector_unmarried_female, 0, 0);
                }
            }
        });
        ((RadioButton) this.U.getChildAt(0)).setChecked(true);
        if (com.paytm.utility.b.G((Context) this) != null && !TextUtils.isEmpty(com.paytm.utility.b.G((Context) this))) {
            if (!com.paytm.utility.b.G((Context) this).equalsIgnoreCase(g.V)) {
                if (com.paytm.utility.b.G((Context) this).equalsIgnoreCase(g.W)) {
                    ((RadioButton) this.U.getChildAt(1)).setChecked(true);
                    ((RadioButton) this.V.getChildAt(1)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_traveller_train_selector_unmarried_female, 0, 0);
                } else if (com.paytm.utility.b.G((Context) this).equalsIgnoreCase(g.X)) {
                    ((RadioButton) this.U.getChildAt(2)).setChecked(true);
                }
            }
            ((RadioButton) this.U.getChildAt(0)).setChecked(true);
            ((RadioButton) this.V.getChildAt(1)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_traveller_train_selector_unmarried_male, 0, 0);
        }
        String[] split = "01/01/1990".split("/");
        this.q.setText(split[0]);
        this.r.setText(split[1]);
        this.s.setText(split[2]);
        if (com.paytm.utility.b.F((Context) this) != null && !TextUtils.isEmpty(com.paytm.utility.b.F((Context) this))) {
            String[] split2 = "01/01/1990".split("/");
            this.q.setText(split2[0]);
            this.r.setText(split2[1]);
            this.s.setText(split2[2]);
        }
        RadioGroup radioGroup3 = this.Y;
        if (radioGroup3 != null && radioGroup3.getChildCount() > 0) {
            RadioGroup radioGroup4 = this.Y;
            ((RadioButton) radioGroup4.getChildAt(radioGroup4.getChildCount() - 1)).setChecked(true);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f25844i = displayMetrics.widthPixels;
        this.f25838c = (TextView) findViewById(R.id.text);
        this.f25839d = (TextView) findViewById(R.id.text2);
        this.f25840e = (TextView) findViewById(R.id.text3);
        this.f25841f = findViewById(R.id.view);
        this.f25842g = findViewById(R.id.view2);
        this.f25843h = findViewById(R.id.view3);
        AnonymousClass23 r9 = new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.j = (HorizontalScrollView) findViewById(R.id.rView);
        this.j.setOnTouchListener(r9);
        this.f25838c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public final boolean onPreDraw() {
                if (AJRIRCTCSignUpActivity.this.f25838c.getViewTreeObserver().isAlive()) {
                    AJRIRCTCSignUpActivity.this.f25838c.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                int width = ((AJRIRCTCSignUpActivity.this.f25844i / 2) + 10) - (AJRIRCTCSignUpActivity.this.f25838c.getWidth() / 2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int a2 = (int) AJRIRCTCSignUpActivity.a(8.0f, (Context) AJRIRCTCSignUpActivity.this);
                layoutParams.setMargins(width, a2, a2, a2);
                AJRIRCTCSignUpActivity.this.f25838c.setLayoutParams(layoutParams);
                return true;
            }
        });
        this.f25839d.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public final boolean onPreDraw() {
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                aJRIRCTCSignUpActivity.k = (aJRIRCTCSignUpActivity.f25844i / 2) - ((AJRIRCTCSignUpActivity.this.f25839d.getWidth() / 2) * 2);
                return true;
            }
        });
        this.f25840e.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public final boolean onPreDraw() {
                if (AJRIRCTCSignUpActivity.this.f25840e.getViewTreeObserver().isAlive()) {
                    AJRIRCTCSignUpActivity.this.f25840e.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                int width = (AJRIRCTCSignUpActivity.this.f25844i / 2) - ((AJRIRCTCSignUpActivity.this.f25840e.getWidth() / 2) + 10);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int a2 = (int) AJRIRCTCSignUpActivity.a(8.0f, (Context) AJRIRCTCSignUpActivity.this);
                layoutParams.setMargins(a2, a2, width, a2);
                AJRIRCTCSignUpActivity.this.f25840e.setLayoutParams(layoutParams);
                return true;
            }
        });
        this.f25838c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRIRCTCSignUpActivity.this.j.fullScroll(17);
                AJRIRCTCSignUpActivity.this.a(0);
            }
        });
        this.f25839d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                boolean unused = AJRIRCTCSignUpActivity.this.k();
            }
        });
        this.f25840e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRIRCTCSignUpActivity.this.l()) {
                    AJRIRCTCSignUpActivity.this.j.fullScroll(66);
                    AJRIRCTCSignUpActivity.this.a(2);
                }
            }
        });
        this.D = (TextView) findViewById(R.id.location_detector);
        this.D.setOnClickListener(this);
        a("train_create_irctc", "create_irctc_opened", "Create IRCTC Account Screen", getApplicationContext());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i2 == 0) {
            this.f25841f.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_not_filled);
            this.f25841f.setAlpha(1.0f);
            this.f25842g.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_filled);
            this.f25842g.setAlpha(0.4f);
            this.f25843h.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_filled);
            this.f25843h.setAlpha(0.4f);
            this.f25838c.setTextSize(14.0f);
            this.f25838c.setTextColor(Color.parseColor("#8f969c"));
            this.f25838c.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f25839d.setTextSize(13.0f);
            this.f25839d.setTextColor(Color.parseColor("#b8c2cb"));
            this.f25839d.setTypeface(Typeface.create("sans-serif", 0));
            this.f25840e.setTextSize(13.0f);
            this.f25840e.setTextColor(Color.parseColor("#b8c2cb"));
            this.f25840e.setTypeface(Typeface.create("sans-serif", 0));
            this.al.setVisibility(0);
            this.am.setVisibility(8);
            this.an.setVisibility(8);
        } else if (i2 == 1) {
            this.f25841f.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_blue_filled);
            this.f25841f.setAlpha(1.0f);
            this.f25842g.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_not_filled);
            this.f25842g.setAlpha(1.0f);
            this.f25843h.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_filled);
            this.f25843h.setAlpha(0.4f);
            this.f25838c.setTextSize(13.0f);
            this.f25838c.setTextColor(Color.parseColor("#00b9f5"));
            this.f25838c.setTypeface(Typeface.create("sans-serif", 0));
            this.f25839d.setTextSize(14.0f);
            this.f25839d.setTextColor(Color.parseColor("#8f969c"));
            this.f25839d.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f25840e.setTextSize(13.0f);
            this.f25840e.setTextColor(Color.parseColor("#b8c2cb"));
            this.f25840e.setTypeface(Typeface.create("sans-serif", 0));
            this.al.setVisibility(8);
            this.am.setVisibility(0);
            this.an.setVisibility(8);
            this.bL.fullScroll(33);
            this.bL.fullScroll(2);
        } else if (i2 == 2) {
            this.f25841f.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_blue_filled);
            this.f25841f.setAlpha(1.0f);
            this.f25842g.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_blue_filled);
            this.f25842g.setAlpha(1.0f);
            this.f25843h.setBackgroundResource(R.drawable.pre_t_train_round_rectangle_grey_not_filled);
            this.f25843h.setAlpha(1.0f);
            this.f25838c.setTextSize(13.0f);
            this.f25838c.setTextColor(Color.parseColor("#00b9f5"));
            this.f25838c.setTypeface(Typeface.create("sans-serif", 0));
            this.f25839d.setTextSize(13.0f);
            this.f25839d.setTextColor(Color.parseColor("#00b9f5"));
            this.f25839d.setTypeface(Typeface.create("sans-serif", 0));
            this.f25840e.setTextSize(14.0f);
            this.f25840e.setTextColor(Color.parseColor("#8f969c"));
            this.f25840e.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.al.setVisibility(8);
            this.am.setVisibility(8);
            this.an.setVisibility(0);
            this.bL.fullScroll(33);
            this.bL.fullScroll(2);
        }
    }

    private void e() {
        this.ac = new HashMap<>();
        String[] stringArray = getResources().getStringArray(R.array.occupation_list);
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            this.ac.put(Integer.valueOf(i2), stringArray[i2]);
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(stringArray));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) a(5.0f, (Context) this), 0, 0);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText((CharSequence) arrayList.get(i3));
            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
            int a2 = (int) a(15.0f, (Context) this);
            radioButton.setPadding(a2, a2, a2, a2);
            this.Y.addView(radioButton, layoutParams);
        }
        this.Y.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                int checkedRadioButtonId = AJRIRCTCSignUpActivity.this.Y.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) AJRIRCTCSignUpActivity.this.findViewById(checkedRadioButtonId);
                radioButton.setBackgroundResource(R.drawable.pre_t_train_round_light_blue);
                radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button);
                if (AJRIRCTCSignUpActivity.this.bT != -1) {
                    AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                    RadioButton radioButton2 = (RadioButton) aJRIRCTCSignUpActivity.findViewById(aJRIRCTCSignUpActivity.bT);
                    radioButton2.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                    radioButton2.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                }
                int unused = AJRIRCTCSignUpActivity.this.bT = checkedRadioButtonId;
                AJRIRCTCSignUpActivity.this.bi.setVisibility(8);
                AJRIRCTCSignUpActivity.this.Y.setVisibility(8);
                AJRIRCTCSignUpActivity.this.bO.setVisibility(0);
                AJRIRCTCSignUpActivity.this.bO.setText(radioButton.getText());
                AJRIRCTCSignUpActivity.this.bH.setImageResource(R.drawable.pre_t_drop);
                AJRIRCTCSignUpActivity.this.A.setTextSize(12.0f);
            }
        });
    }

    private void f() {
        ArrayList arrayList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.prefred_language)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = 0;
        layoutParams.setMargins(0, (int) a(5.0f, (Context) this), 0, 0);
        while (i2 < arrayList.size()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText((CharSequence) arrayList.get(i2));
            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
            int a2 = (int) a(15.0f, (Context) this);
            radioButton.setPadding(a2, a2, a2, a2);
            int i3 = i2 + 1;
            radioButton.setId(i3);
            if (((String) arrayList.get(i2)).equalsIgnoreCase(getString(R.string.train_language_english))) {
                radioButton.setChecked(true);
                this.cc = radioButton.getId();
            }
            this.X.addView(radioButton, layoutParams);
            i2 = i3;
        }
        this.X.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                aJRIRCTCSignUpActivity.b(aJRIRCTCSignUpActivity.X.getCheckedRadioButtonId());
                AJRIRCTCSignUpActivity.this.be.setVisibility(8);
                AJRIRCTCSignUpActivity.this.X.setVisibility(8);
                AJRIRCTCSignUpActivity.this.bN.setVisibility(0);
                AJRIRCTCSignUpActivity.this.bF.setImageResource(R.drawable.pre_t_drop);
                AJRIRCTCSignUpActivity.this.z.setTextSize(12.0f);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 != -1) {
            RadioButton radioButton = (RadioButton) findViewById(i2);
            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_light_blue);
            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button);
            int i3 = this.bS;
            if (i3 != -1) {
                RadioButton radioButton2 = (RadioButton) findViewById(i3);
                radioButton2.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                radioButton2.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
            }
            this.bS = i2;
            this.bN.setText(radioButton.getText());
        }
    }

    private void g() {
        this.n.setText(this.ai.get(0).getCityName());
        ArrayList<CJRPincodeResponse.CJRCities> arrayList = this.ai;
        if (arrayList != null && arrayList.size() > 0) {
            this.ah = this.ai.get(0).getPostOfficeList();
            ArrayList<String> arrayList2 = this.ah;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList<String> arrayList3 = this.ah;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, (int) a(5.0f, (Context) this), 0, 0);
                this.Z.removeAllViews();
                this.bU = -1;
                this.bP.setVisibility(8);
                this.Z.check(-1);
                this.bZ.setEnabled(true);
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(arrayList3.get(i2));
                    radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                    radioButton.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                    int a2 = (int) a(15.0f, (Context) this);
                    radioButton.setPadding(a2, a2, a2, a2);
                    this.Z.addView(radioButton, layoutParams);
                }
                this.Z.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                        AJRIRCTCSignUpActivity.a("train_create_irctc", "po_selected", "Create IRCTC Account Screen", AJRIRCTCSignUpActivity.this.getApplicationContext());
                        if (i2 != -1) {
                            int checkedRadioButtonId = AJRIRCTCSignUpActivity.this.Z.getCheckedRadioButtonId();
                            RadioButton radioButton = (RadioButton) AJRIRCTCSignUpActivity.this.findViewById(checkedRadioButtonId);
                            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_light_blue);
                            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button);
                            if (AJRIRCTCSignUpActivity.this.bU != -1) {
                                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                                RadioButton radioButton2 = (RadioButton) aJRIRCTCSignUpActivity.findViewById(aJRIRCTCSignUpActivity.bU);
                                radioButton2.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                                radioButton2.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                            }
                            int unused = AJRIRCTCSignUpActivity.this.bU = checkedRadioButtonId;
                            AJRIRCTCSignUpActivity.this.bl.setVisibility(8);
                            AJRIRCTCSignUpActivity.this.Z.setVisibility(8);
                            AJRIRCTCSignUpActivity.this.bP.setVisibility(0);
                            AJRIRCTCSignUpActivity.this.bP.setText(radioButton.getText());
                            AJRIRCTCSignUpActivity.this.bI.setImageResource(R.drawable.pre_t_drop);
                            AJRIRCTCSignUpActivity.this.B.setTextSize(12.0f);
                        }
                    }
                });
                if (this.ah.size() == 1) {
                    this.bl.setVisibility(8);
                    this.bP.setVisibility(0);
                    this.bP.setText(this.ah.get(0));
                    this.Z.setVisibility(8);
                    ((RadioButton) this.Z.getChildAt(0)).setChecked(true);
                    this.bI.setImageResource(R.drawable.pre_t_drop);
                    this.bZ.setEnabled(false);
                    this.B.setTextSize(12.0f);
                }
            }
        }
    }

    private void h() {
        this.aC.setText(this.ax.get(0).getCityName());
        ArrayList<CJRPincodeResponse.CJRCities> arrayList = this.ax;
        if (arrayList != null && arrayList.size() > 0) {
            this.ay = this.ax.get(0).getPostOfficeList();
            ArrayList<String> arrayList2 = this.ay;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList<String> arrayList3 = this.ay;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, (int) a(5.0f, (Context) this), 0, 0);
                this.aa.removeAllViews();
                this.bV = -1;
                this.bQ.setVisibility(8);
                this.aa.check(-1);
                this.ca.setEnabled(true);
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(arrayList3.get(i2));
                    radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                    radioButton.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                    int a2 = (int) a(15.0f, (Context) this);
                    radioButton.setPadding(a2, a2, a2, a2);
                    this.aa.addView(radioButton, layoutParams);
                }
                this.aa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                        if (i2 != -1) {
                            int checkedRadioButtonId = AJRIRCTCSignUpActivity.this.aa.getCheckedRadioButtonId();
                            RadioButton radioButton = (RadioButton) AJRIRCTCSignUpActivity.this.findViewById(checkedRadioButtonId);
                            radioButton.setBackgroundResource(R.drawable.pre_t_train_round_light_blue);
                            radioButton.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button);
                            if (AJRIRCTCSignUpActivity.this.bV != -1) {
                                AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity = AJRIRCTCSignUpActivity.this;
                                RadioButton radioButton2 = (RadioButton) aJRIRCTCSignUpActivity.findViewById(aJRIRCTCSignUpActivity.bV);
                                radioButton2.setBackgroundResource(R.drawable.pre_t_train_round_grey_white_fill);
                                radioButton2.setButtonDrawable(R.drawable.pre_t_train_inset_radio_button_deselected);
                            }
                            int unused = AJRIRCTCSignUpActivity.this.bV = checkedRadioButtonId;
                            AJRIRCTCSignUpActivity.this.bq.setVisibility(8);
                            AJRIRCTCSignUpActivity.this.aa.setVisibility(8);
                            AJRIRCTCSignUpActivity.this.bQ.setVisibility(0);
                            AJRIRCTCSignUpActivity.this.bQ.setText(radioButton.getText());
                            AJRIRCTCSignUpActivity.this.bJ.setImageResource(R.drawable.pre_t_drop);
                            AJRIRCTCSignUpActivity.this.C.setTextSize(12.0f);
                        }
                    }
                });
                if (this.ay.size() == 1) {
                    this.bq.setVisibility(8);
                    this.bQ.setVisibility(0);
                    this.bQ.setText(this.ah.get(0));
                    this.aa.setVisibility(8);
                    this.bJ.setImageResource(R.drawable.pre_t_drop);
                    this.ca.setEnabled(false);
                    this.C.setTextSize(12.0f);
                }
            }
        }
    }

    public static float a(float f2, Context context) {
        return f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    private boolean i() {
        if (this.m.getText().toString() != null) {
            if (this.m.getText().toString().length() == 0) {
                this.v.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
                this.w.setVisibility(0);
                this.w.setText(getString(R.string.traveller_empty_field_message, new Object[]{this.t.getHint().toString()}));
                this.w.setText(getString(R.string.train_enter_user_id));
                return false;
            } else if (this.m.getText().toString().length() < 3 || this.m.getText().length() > 35 || !this.m.getText().toString().matches("[a-zA-Z0-9_]*")) {
                this.v.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
                this.w.setVisibility(0);
                this.w.setText(getString(R.string.username_validation_condition_text));
                return false;
            }
        }
        return true;
    }

    private void j() {
        String obj = this.m.getText().toString();
        c cVar = new c(this, this);
        com.travel.train.b.a();
        String aa2 = com.travel.train.b.b().aa();
        if (URLUtil.isValidUrl(aa2)) {
            Uri.Builder buildUpon = Uri.parse(o.b(c.f27512a, com.paytm.utility.b.s(c.f27512a, aa2))).buildUpon();
            buildUpon.appendQueryParameter("userid", obj);
            String builder = buildUpon.toString();
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = c.f27512a;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = builder;
            bVar.f42882f = n.b(c.f27512a);
            bVar.f42885i = new CJRIRCTCUserAvailability();
            bVar.j = cVar;
            a l2 = bVar.l();
            l2.f42859c = false;
            if (com.paytm.utility.b.c(c.f27512a)) {
                l2.a();
            } else {
                cVar.a(l2);
            }
        } else {
            Context context = c.f27512a;
            com.paytm.utility.b.b(context, context.getString(R.string.error), c.f27512a.getString(R.string.msg_invalid_url_train));
        }
        showProgressDialog(this, getResources().getString(R.string.irctc_user_id_progress_string));
    }

    public final void a(CJRPincodeResponse cJRPincodeResponse) {
        removeProgressDialog();
        if (cJRPincodeResponse != null) {
            a("train_create_irctc", "po_loaded", "Create IRCTC Account Screen", getApplicationContext());
            if (!this.aw) {
                this.F.setVisibility(0);
                this.aj.setVisibility(0);
                this.bk.setVisibility(0);
                findViewById(R.id.state_view).setVisibility(0);
                this.ak.setVisibility(0);
                this.bl.setVisibility(0);
                if (this.Q != null && cJRPincodeResponse.getPincodeBody() != null) {
                    this.Q.setText(cJRPincodeResponse.getPincodeBody().getState());
                    if (cJRPincodeResponse.getPincodeBody().getCityList() != null) {
                        this.ai = cJRPincodeResponse.getPincodeBody().getCityList();
                        ArrayList arrayList = new ArrayList();
                        ArrayList<CJRPincodeResponse.CJRCities> arrayList2 = this.ai;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            for (int i2 = 0; i2 < this.ai.size(); i2++) {
                                arrayList.add(this.ai.get(i2).getCityName());
                            }
                            g();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.H.setVisibility(0);
            this.av.setVisibility(0);
            this.bp.setVisibility(0);
            findViewById(R.id.office_state_view).setVisibility(0);
            this.ap.setVisibility(0);
            this.bq.setVisibility(0);
            b(cJRPincodeResponse);
        }
    }

    private void b(CJRPincodeResponse cJRPincodeResponse) {
        if (cJRPincodeResponse.getPincodeBody() != null) {
            this.au.setText(cJRPincodeResponse.getPincodeBody().getState());
            if (cJRPincodeResponse.getPincodeBody().getCityList() != null) {
                this.ax = cJRPincodeResponse.getPincodeBody().getCityList();
                ArrayList arrayList = new ArrayList();
                ArrayList<CJRPincodeResponse.CJRCities> arrayList2 = this.ax;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i2 = 0; i2 < this.ax.size(); i2++) {
                        arrayList.add(this.ax.get(i2).getCityName());
                    }
                    h();
                }
            }
        }
    }

    public final void a(CJRIRCTCUserRegister cJRIRCTCUserRegister) {
        removeProgressDialog();
        if (cJRIRCTCUserRegister != null && cJRIRCTCUserRegister.getStatus() != null && cJRIRCTCUserRegister.getStatus().f27704a.equals("success")) {
            new b(this, this, true, "B", this.m.getText().toString(), (CJRTrainSearchInput) null, getSupportFragmentManager(), false, 0, false, true).a();
        }
    }

    public final void a(CJRIRCTCUserAvailability cJRIRCTCUserAvailability) {
        if (cJRIRCTCUserAvailability != null) {
            removeProgressDialog();
            if (cJRIRCTCUserAvailability.getUserAvailabilityBody() == null) {
                return;
            }
            if (cJRIRCTCUserAvailability.getUserAvailabilityBody().f27701a.equalsIgnoreCase("true")) {
                this.u.setVisibility(0);
                this.j.smoothScrollTo(this.k, 0);
                a(1);
            } else if (cJRIRCTCUserAvailability.getUserAvailabilityBody().f27701a.equalsIgnoreCase("false")) {
                this.v.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
                this.w.setVisibility(0);
                this.w.setText(getString(R.string.user_not_availble_text));
                o.a("train_create_irctc", "user_id_exists", "firstpage_continue", "Create IRCTC Account Screen", getApplicationContext());
            } else {
                if (cJRIRCTCUserAvailability.getUserAvailabilityBody().f27703c.equalsIgnoreCase("false")) {
                    this.aJ.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
                    this.aG.setVisibility(0);
                    this.aG.setText(getString(R.string.mobile_number_used_error));
                    o.a("train_create_irctc", "mobile_exists", "secondpage_continue", "Create IRCTC Account Screen", getApplicationContext());
                }
                if (cJRIRCTCUserAvailability.getUserAvailabilityBody().f27702b.equalsIgnoreCase("false")) {
                    this.aI.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
                    this.aH.setVisibility(0);
                    this.aH.setText(getString(R.string.email_used_error));
                    o.a("train_create_irctc", "email_exists", "secondpage_continue", "Create IRCTC Account Screen", getApplicationContext());
                }
            }
        }
    }

    public void onClick(View view) {
        String str;
        hideKeyboard();
        int id = view.getId();
        if (id == R.id.dob_img) {
            new com.travel.train.fragment.a(this.q, this.r, this.s).show(getSupportFragmentManager(), H5Plugin.CommonEvents.DATE_PICKER);
        } else if (id == R.id.personal_info_contry) {
            this.ag = this.ad;
            p();
        } else if (id == R.id.home_country) {
            this.ag = this.ae;
            p();
        } else if (id == R.id.offic_info_country) {
            this.ag = this.as;
            p();
        } else {
            boolean z2 = false;
            if (id == R.id.irctc_singup_btn) {
                a("train_create_irctc", "signup_clicked", "Create IRCTC Account Screen", getApplicationContext());
                String str2 = net.one97.paytm.common.utility.d.dl;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", com.paytm.utility.b.n((Context) this) != null ? com.paytm.utility.b.n((Context) this) : "");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(str2, (Map<String, Object>) hashMap, (Context) this);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                n();
                o();
                if (this.P.getText().toString().length() == 0) {
                    a(this.aQ, getString(R.string.train_enter_pincode), this.bj);
                    a(this.P);
                } else if (this.Q.getText().toString().length() == 0) {
                    com.paytm.utility.b.b((Context) this, getString(R.string.train_title_state_info_missing), getString(R.string.train_choose_state));
                } else if (this.aj.getVisibility() == 0 && this.n.getText().toString().length() == 0) {
                    a(this.aR, getString(R.string.train_choose_city), this.bk);
                    a(this.aR);
                } else if (this.ak.getVisibility() == 0 && this.Z.getCheckedRadioButtonId() == -1) {
                    a(this.aS, getString(R.string.train_choose_post_office), this.bl);
                } else if (this.R.getText().toString().length() == 0) {
                    a(this.aT, getString(R.string.train_enter_alternative_number), this.bm);
                    a(this.R);
                } else if (this.T.getText() == null || this.T.getText().toString().length() >= 3) {
                    if (this.ao.getVisibility() == 0) {
                        if (this.as.getText().toString().length() == 0) {
                            com.paytm.utility.b.b((Context) this, getString(R.string.train_travellers_error), getString(R.string.user_registration_empty_field_error, new Object[]{getString(R.string.choose_your_office_country)}));
                        } else if (this.at.getText().toString().length() == 0) {
                            a(this.aW, getString(R.string.traveller_empty_field_message, new Object[]{this.G.getHint().toString()}), this.bo);
                            a(this.at);
                        } else if (this.au.getText().toString().length() == 0) {
                            com.paytm.utility.b.b((Context) this, getString(R.string.train_travellers_error), getString(R.string.traveller_empty_field_message, new Object[]{this.H.getHint().toString()}));
                        } else if (this.av.getVisibility() == 0 && this.aC.getText().toString().length() == 0) {
                            a(this.aX, getString(R.string.traveller_empty_field_message, new Object[]{this.av.getHint().toString()}), this.bp);
                            a(this.aC);
                        } else if (this.ap.getVisibility() == 0 && this.aa.getCheckedRadioButtonId() == -1) {
                            a(this.aY, getString(R.string.user_registration_empty_field_error, new Object[]{getString(R.string.office_post_office_text)}), this.bq);
                        } else if (this.o.getText().toString().length() == 0) {
                            a(this.aZ, getString(R.string.traveller_empty_field_message, new Object[]{this.I.getHint().toString()}), this.br);
                            a(this.o);
                        } else if (this.p.getText() != null && this.p.getText().toString().length() < 3) {
                            if (this.p.getText().length() <= 0 || this.p.getText().length() >= 3) {
                                a(this.bb, getString(R.string.traveller_empty_field_message, new Object[]{this.J.getHint().toString()}), this.bs);
                                a(this.p);
                            } else {
                                a(this.bb, getString(R.string.train_min_characters_error), this.bs);
                                a(this.p);
                            }
                        }
                    }
                    if (com.paytm.utility.b.c((Context) this)) {
                        showProgressDialog(this, getString(R.string.please_wait_progress_msg));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("userName", this.m.getText().toString());
                            jSONObject.put("securityQuestion", a(this.bM.getText().toString(), this.K));
                            jSONObject.put("securityAns", this.E.getText().toString());
                            String charSequence = this.bN.getText().toString();
                            jSONObject.put("prefLanguage", (charSequence == null || !charSequence.equalsIgnoreCase(getResources().getStringArray(R.array.prefred_language)[0])) ? "hi" : "en");
                            jSONObject.put("firstName", this.L.getText().toString());
                            jSONObject.put("lastName", this.M.getText().toString());
                            String charSequence2 = ((RadioButton) findViewById(this.U.getCheckedRadioButtonId())).getText().toString();
                            String[] stringArray = getResources().getStringArray(R.array.train_gender_list);
                            String str3 = "M";
                            if (charSequence2.equalsIgnoreCase(stringArray[0])) {
                                str = str3;
                            } else {
                                str = charSequence2.equalsIgnoreCase(stringArray[1]) ? AppConstants.FEED_SUB_TYPE : "T";
                            }
                            jSONObject.put("gender", str);
                            if (!((RadioButton) findViewById(this.V.getCheckedRadioButtonId())).getText().toString().equalsIgnoreCase(getResources().getStringArray(R.array.marital_status_list)[0])) {
                                str3 = AppConstants.USER_SUB_TYPE;
                            }
                            jSONObject.put("martialStatus", str3);
                            jSONObject.put("dob", ab);
                            jSONObject.put(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, this.N.getText().toString());
                            jSONObject.put("mobile", this.O.getText().toString().substring(4));
                            if (this.aD != null) {
                                jSONObject.put("nationalityId", this.aD.getCountryId());
                            }
                            jSONObject.put("occupation", a(this.bO.getText().toString(), this.ac));
                            jSONObject.put("countryId", this.aE.getCountryId());
                            jSONObject.put("countryName", this.aE.getCountry());
                            jSONObject.put("pinCode", this.P.getText().toString());
                            jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, this.T.getText().toString() + " " + this.S.getText().toString());
                            if (this.ak.getVisibility() == 0) {
                                jSONObject.put("postOffice", this.bP.getText().toString());
                            }
                            if (this.aj.getVisibility() == 0) {
                                jSONObject.put("city", this.n.getText().toString());
                            }
                            jSONObject.put("state", this.Q.getText().toString());
                            jSONObject.put("landlineNumber", this.R.getText().toString());
                            jSONObject.put("copyAddressResToOff", this.ar);
                            if (!this.ar.equalsIgnoreCase("Y")) {
                                jSONObject.put("off_CountryId", this.aF.getCountryId());
                                jSONObject.put("off_CountryName", this.aF.getCountry());
                                jSONObject.put("off_PinCode", this.at.getText().toString());
                                jSONObject.put("off_Address", this.p.getText().toString());
                                if (this.ak.getVisibility() == 0) {
                                    jSONObject.put("off_PostOffice", this.bP.getText().toString());
                                }
                                if (this.av.getVisibility() == 0) {
                                    jSONObject.put("off_City", this.aC.getText().toString());
                                }
                                jSONObject.put("off_State", this.au.getText().toString());
                                jSONObject.put("off_LandlineNumber", this.o.getText().toString());
                            }
                            c cVar = new c(this, this);
                            String jSONObject2 = jSONObject.toString();
                            com.travel.train.b.a();
                            String Z2 = com.travel.train.b.b().Z();
                            if (URLUtil.isValidUrl(Z2)) {
                                String b2 = o.b(c.f27512a, com.paytm.utility.b.s(c.f27512a, Z2));
                                com.paytm.network.b bVar = new com.paytm.network.b();
                                bVar.f42877a = c.f27512a;
                                bVar.f42878b = a.c.TRAIN;
                                bVar.n = a.b.SILENT;
                                bVar.o = g.r;
                                bVar.f42879c = a.C0715a.POST;
                                bVar.f42880d = b2;
                                bVar.f42882f = n.c(c.f27512a);
                                bVar.f42884h = jSONObject2;
                                bVar.f42885i = new CJRIRCTCUserRegister();
                                bVar.j = cVar;
                                a l2 = bVar.l();
                                l2.f42859c = false;
                                if (com.paytm.utility.b.c(c.f27512a)) {
                                    l2.a();
                                } else {
                                    cVar.a(l2);
                                }
                            } else {
                                Context context = c.f27512a;
                                com.paytm.utility.b.b(context, context.getString(R.string.error), c.f27512a.getString(R.string.msg_invalid_url_train));
                            }
                        } catch (JSONException e3) {
                            q.c(e3.getMessage());
                        }
                    }
                    z2 = true;
                } else if (this.T.getText().length() <= 0 || this.T.getText().length() >= 3) {
                    a(this.aU, getString(R.string.train_enter_flat_door_no), this.bn);
                    a(this.T);
                } else {
                    a(this.aU, getString(R.string.train_min_characters_error), this.bn);
                    a(this.T);
                }
                if (!z2) {
                }
            } else if (id == R.id.securityRL) {
                if (this.W.getVisibility() == 8) {
                    this.bc.setVisibility(8);
                    this.bM.setVisibility(8);
                    this.W.setVisibility(0);
                    this.bG.setImageResource(R.drawable.pre_t_drop_up);
                    this.y.setTextSize(15.0f);
                    return;
                }
                if (this.W.getCheckedRadioButtonId() == -1) {
                    this.bc.setVisibility(0);
                    this.bM.setVisibility(8);
                    this.y.setTextSize(15.0f);
                } else {
                    this.bc.setVisibility(8);
                    this.bM.setVisibility(0);
                    this.y.setTextSize(12.0f);
                }
                this.W.setVisibility(8);
                this.bG.setImageResource(R.drawable.pre_t_drop);
            } else if (id == R.id.languageRL) {
                if (this.X.getVisibility() == 8) {
                    this.be.setVisibility(8);
                    this.bN.setVisibility(8);
                    this.X.setVisibility(0);
                    this.bF.setImageResource(R.drawable.pre_t_drop_up);
                    this.z.setTextSize(15.0f);
                    return;
                }
                if (this.X.getCheckedRadioButtonId() == -1) {
                    this.be.setVisibility(0);
                    this.bN.setVisibility(8);
                    this.z.setTextSize(15.0f);
                } else {
                    this.be.setVisibility(8);
                    this.bN.setVisibility(0);
                    this.z.setTextSize(12.0f);
                }
                this.X.setVisibility(8);
                this.bF.setImageResource(R.drawable.pre_t_drop);
            } else if (id == R.id.occupationRL) {
                if (this.Y.getVisibility() == 8) {
                    this.bi.setVisibility(8);
                    this.bO.setVisibility(8);
                    this.Y.setVisibility(0);
                    this.bH.setImageResource(R.drawable.pre_t_drop_up);
                    this.A.setTextSize(15.0f);
                    return;
                }
                if (this.Y.getCheckedRadioButtonId() == -1) {
                    this.bi.setVisibility(0);
                    this.bO.setVisibility(8);
                    this.A.setTextSize(15.0f);
                } else {
                    this.bi.setVisibility(8);
                    this.bO.setVisibility(0);
                    this.A.setTextSize(12.0f);
                }
                this.Y.setVisibility(8);
                this.bH.setImageResource(R.drawable.pre_t_drop);
            } else if (id == R.id.postOfficeRL) {
                if (this.Z.getVisibility() == 8) {
                    this.bl.setVisibility(8);
                    this.bP.setVisibility(8);
                    this.Z.setVisibility(0);
                    this.bI.setImageResource(R.drawable.pre_t_drop_up);
                    this.B.setTextSize(15.0f);
                    return;
                }
                if (this.Z.getCheckedRadioButtonId() == -1) {
                    this.bl.setVisibility(0);
                    this.bP.setVisibility(8);
                    this.B.setTextSize(15.0f);
                } else {
                    this.bl.setVisibility(8);
                    this.bP.setVisibility(0);
                    this.B.setTextSize(12.0f);
                }
                this.Z.setVisibility(8);
                this.bI.setImageResource(R.drawable.pre_t_drop);
            } else if (id == R.id.officePostOfficeRL) {
                if (this.aa.getVisibility() == 8) {
                    this.bq.setVisibility(8);
                    this.bQ.setVisibility(8);
                    this.aa.setVisibility(0);
                    this.bJ.setImageResource(R.drawable.pre_t_drop_up);
                    this.C.setTextSize(15.0f);
                    return;
                }
                if (this.aa.getCheckedRadioButtonId() == -1) {
                    this.bq.setVisibility(0);
                    this.bQ.setVisibility(8);
                    this.C.setTextSize(15.0f);
                } else {
                    this.bq.setVisibility(8);
                    this.bQ.setVisibility(0);
                    this.C.setTextSize(12.0f);
                }
                this.aa.setVisibility(8);
                this.bJ.setImageResource(R.drawable.pre_t_drop);
            } else if (id == R.id.irctc_continue_btn_1) {
                if (!k()) {
                }
            } else if (id == R.id.irctc_continue_btn_2) {
                if (l()) {
                    this.j.fullScroll(66);
                    a(2);
                }
            } else if (id == R.id.location_detector) {
                showProgressDialog(this, getResources().getString(R.string.please_wait_progress_msg));
                if (com.paytm.utility.b.O((Context) this) && com.paytm.utility.b.P((Context) this)) {
                    try {
                        this.ce = new e.a(this).a((e.b) this).a((e.c) this).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                        if (this.ce != null) {
                            this.cd = new d(this, this, this.ce, this);
                            this.cd.f27518a = false;
                            this.cd.b();
                            q.d(getResources().getString(R.string.location_check_settings));
                        }
                        if (this.ce != null && !this.ce.f()) {
                            this.ce.d();
                        }
                    } catch (Exception e4) {
                        if (com.paytm.utility.b.v) {
                            q.b(e4.getMessage());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean k() {
        n();
        o();
        if (this.m.getText().toString() != null) {
            if (this.m.getText().toString().length() == 0) {
                a(this.w, getString(R.string.train_enter_user_id), this.v);
                a(this.m);
                return false;
            } else if (this.m.getText().toString().length() < 3 || this.m.getText().length() > 35 || !this.m.getText().toString().matches("[a-zA-Z0-9_]*")) {
                a(this.w, getString(R.string.username_validation_condition_text), this.v);
                a(this.m);
                return false;
            }
        }
        if (this.W.getCheckedRadioButtonId() == -1) {
            a(this.aK, getString(R.string.security_question_empty_error), this.bc);
            return false;
        }
        if (this.E.getText() != null) {
            if (this.E.getText().length() == 0) {
                a(this.aL, getString(R.string.security_answer_empty_error), this.bd);
                a(this.E);
                return false;
            } else if (this.E.getText().length() > 0) {
                if (this.E.getText().length() < 3) {
                    a(this.aL, getString(R.string.train_min_characters_error), this.bd);
                    a(this.E);
                    return false;
                } else if (this.E.getText().length() > 20) {
                    a(this.aL, getString(R.string.train_max_characters_error), this.bd);
                    a(this.E);
                    return false;
                }
            }
        }
        if (this.X.getCheckedRadioButtonId() == -1) {
            a(this.aM, getString(R.string.your_language_empty_error), this.be);
            return false;
        } else if (!i()) {
            return true;
        } else {
            j();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean l() {
        n();
        o();
        if (this.L.getText() == null || this.L.getText().toString().length() >= 3) {
            if (this.M.getText() != null && this.M.getText().toString().length() == 0) {
                a(this.aO, getString(R.string.train_enter_last_name), this.bg);
                a(this.M);
                return false;
            } else if (this.U.getCheckedRadioButtonId() == -1) {
                com.paytm.utility.b.b((Context) this, getString(R.string.train_title_gender_info_missing), getString(R.string.train_enter_gender));
                return false;
            } else if (this.V.getCheckedRadioButtonId() == -1) {
                this.aV.setText(getString(R.string.train_enter_marital_status));
                this.aV.setVisibility(0);
                this.bh.setVisibility(0);
                a(this.aV);
                return false;
            } else if (this.q.getText().toString().trim().length() == 0 || this.r.getText().toString().trim().length() == 0 || this.s.getText().toString().trim().length() == 0 || !o.a(Integer.parseInt(this.q.getText().toString()), Integer.parseInt(this.r.getText().toString()), Integer.parseInt(this.s.getText().toString()))) {
                com.paytm.utility.b.b((Context) this, getString(R.string.train_title_dob_info_missing), getString(R.string.train_enter_dob));
                return false;
            } else if (i.a(Integer.parseInt(this.s.getText().toString()), Integer.parseInt(this.r.getText().toString()), Integer.parseInt(this.q.getText().toString())) < 18) {
                com.paytm.utility.b.b((Context) this, getString(R.string.train_min_age_err), getString(R.string.train_min_age_err_msg));
                return false;
            } else {
                m();
                if (this.Y.getCheckedRadioButtonId() == -1) {
                    a(this.aP, getString(R.string.train_choose_occupation), this.bi);
                    return false;
                } else if (this.N.getText().toString().length() == 0) {
                    a(this.aH, getString(R.string.train_enter_email_id), this.aI);
                    a(this.N);
                    return false;
                } else if (!com.paytm.utility.b.d(this.N.getText().toString())) {
                    a(this.aH, getString(R.string.train_enter_email_id), this.aI);
                    a(this.N);
                    return false;
                } else if (this.O.getText().toString().length() == 0) {
                    a(this.aG, getString(R.string.train_enter_mobile_no), this.aJ);
                    a(this.O);
                    return false;
                } else {
                    String substring = this.O.getText().toString().substring(4);
                    if (TextUtils.isEmpty(substring.trim())) {
                        a(this.aG, getString(R.string.train_enter_mobile_no), this.aJ);
                        a(this.O);
                        return false;
                    } else if (substring.trim().length() < 10) {
                        a(this.aG, getString(R.string.train_invalid_mobile_no), this.aJ);
                        a(this.O);
                        return false;
                    } else if (this.ad.getText().toString().length() == 0) {
                        com.paytm.utility.b.b((Context) this, getString(R.string.train_travellers_error), getString(R.string.user_registration_empty_field_error, new Object[]{getString(R.string.nationality)}));
                        return false;
                    } else if (this.ae.getText().toString().length() != 0) {
                        return true;
                    } else {
                        com.paytm.utility.b.b((Context) this, getString(R.string.train_title_country_info_misisng), getString(R.string.train_choose_country));
                        return false;
                    }
                }
            }
        } else if (this.L.getText().toString().length() <= 0 || this.L.getText().toString().length() >= 3) {
            a(this.aN, getString(R.string.train_enter_first_name), this.bf);
            a(this.L);
            return false;
        } else {
            a(this.aN, getString(R.string.train_min_characters_error), this.bf);
            a(this.L);
            return false;
        }
    }

    private void m() {
        ab = com.paytm.utility.b.d(this.q.getText().toString() + "/" + this.r.getText().toString() + "/" + this.s.getText().toString(), "dd/MM/yyyy", "yyyyMMdd");
    }

    private void n() {
        this.aG.setVisibility(8);
        this.aH.setVisibility(8);
        this.w.setVisibility(8);
        this.aK.setVisibility(8);
        this.aL.setVisibility(8);
        this.aM.setVisibility(8);
        this.aN.setVisibility(8);
        this.aO.setVisibility(8);
        this.aP.setVisibility(8);
        this.aQ.setVisibility(8);
        this.aR.setVisibility(8);
        this.aS.setVisibility(8);
        this.aT.setVisibility(8);
        this.aU.setVisibility(8);
        this.aW.setVisibility(8);
        this.aX.setVisibility(8);
        this.aY.setVisibility(8);
        this.aZ.setVisibility(8);
        this.ba.setVisibility(8);
        this.bb.setVisibility(8);
        this.aV.setVisibility(8);
    }

    private void o() {
        this.bh.setVisibility(8);
        this.aJ.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.aI.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.v.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bc.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bd.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.be.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bf.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bg.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bi.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bj.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bk.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bl.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bm.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bn.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bo.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bp.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bq.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.br.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
        this.bs.setBackgroundColor(getResources().getColor(R.color.payment_success_line_grey));
    }

    private void a(TextView textView, String str, View view) {
        textView.setVisibility(0);
        textView.setText(str);
        view.setBackgroundColor(getResources().getColor(R.color.train_regreat_color));
    }

    private static void a(TextView textView) {
        textView.getParent().requestChildFocus(textView, textView);
    }

    private void a(EditText editText) {
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        inputMethodManager.showSoftInput(editText, 1);
        inputMethodManager.toggleSoftInput(2, 0);
    }

    private static String a(String str, HashMap<Integer, String> hashMap) {
        String str2 = "";
        for (Map.Entry next : hashMap.entrySet()) {
            Integer num = (Integer) next.getKey();
            if (((String) next.getValue()).equalsIgnoreCase(str)) {
                str2 = String.valueOf(num);
            }
        }
        return str2;
    }

    private void p() {
        Intent intent = new Intent(this, AJRSelectCountryActivity.class);
        intent.putExtra("country_list", this.af);
        intent.putExtra("sign_up", true);
        startActivityForResult(intent, 140);
    }

    public final void b() {
        Intent intent = new Intent();
        intent.putExtra("login_success", true);
        setResult(100, intent);
        finish();
    }

    public void onFocusChange(View view, boolean z2) {
        boolean z3;
        if (!z2) {
            if (view.getId() == R.id.security_answer && this.E.getText() != null && this.E.getText().length() > 0) {
                if (this.E.getText().length() < 3) {
                    a(this.aL, getString(R.string.train_min_characters_error), this.bd);
                } else if (this.E.getText().length() > 20) {
                    a(this.aL, getString(R.string.train_max_characters_error), this.bd);
                }
            }
            if (view.getId() == R.id.first_name && this.L.getText() != null && this.L.getText().length() > 0 && this.L.getText().length() < 3) {
                a(this.aN, getString(R.string.train_min_characters_error), this.bf);
            }
            if (view.getId() == R.id.flat_door_number && this.T.getText() != null && this.T.getText().length() > 0 && this.T.getText().length() < 3) {
                a(this.aU, getString(R.string.train_min_characters_error), this.bn);
            }
            if (view.getId() == R.id.office_address && this.p.getText() != null && this.p.getText().length() > 0 && this.p.getText().length() < 3) {
                a(this.bb, getString(R.string.train_min_characters_error), this.bs);
            }
            boolean z4 = true;
            if (view.getId() == R.id.email_id) {
                if (this.N.getText().toString().length() == 0) {
                    b(getString(R.string.traveller_empty_field_message, new Object[]{getString(R.string.sign_up_email_id)}));
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!com.paytm.utility.b.d(this.N.getText().toString())) {
                    b(getString(R.string.please_enter_valid_input_field, new Object[]{getString(R.string.sign_up_email_id)}));
                    z3 = false;
                }
                if (z3) {
                    new c(this, this).a(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, this.N.getText().toString());
                }
            } else if (view.getId() == R.id.mobile_number) {
                if (this.O.getText().toString().length() == 0) {
                    a(getString(R.string.traveller_empty_field_message, new Object[]{getString(R.string.mobile_number)}));
                    z4 = false;
                }
                if (this.O.getText().toString().length() > 0) {
                    String substring = this.O.getText().toString().substring(4);
                    if (TextUtils.isEmpty(substring.trim())) {
                        a(getString(R.string.msg_invalid_mobile));
                        z4 = false;
                    }
                    if (substring.trim().length() < 10) {
                        a(getString(R.string.msg_invalid_mobile));
                        z4 = false;
                    }
                }
                if (z4) {
                    new c(this, this).a("mobile", this.O.getText().toString().substring(4));
                }
            }
        }
    }

    private void a(String str) {
        this.aG.setVisibility(0);
        this.aJ.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
        this.aG.setText(str);
    }

    private void b(String str) {
        this.aH.setVisibility(0);
        this.aH.setText(str);
        this.aI.setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_oos_text));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        EditText editText;
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            return;
        }
        if (i2 == 140) {
            this.af = (ArrayList) intent.getSerializableExtra("country_list");
            CJRCountrys cJRCountrys = (CJRCountrys) intent.getSerializableExtra("selected_country");
            this.ag.setText(cJRCountrys.getCountry());
            if (this.ag.getId() == R.id.home_country) {
                if (cJRCountrys.getCountry().equalsIgnoreCase("India")) {
                    this.aE = cJRCountrys;
                    this.Q.setEnabled(false);
                    this.ak.setVisibility(0);
                    this.aj.setVisibility(8);
                    return;
                }
                this.aE = cJRCountrys;
                ArrayList<String> arrayList = this.ah;
                if (arrayList != null && arrayList.size() > 0) {
                    this.ah.clear();
                }
                ArrayList<CJRPincodeResponse.CJRCities> arrayList2 = this.ai;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.ai.clear();
                }
                this.Q.setEnabled(true);
                this.ak.setVisibility(8);
                this.aj.setVisibility(0);
                this.P.setText("");
                this.Q.setText("");
            } else if (this.ag.getId() == R.id.offic_info_country) {
                this.aF = cJRCountrys;
                if (!cJRCountrys.getCountry().equalsIgnoreCase("India")) {
                    this.aF = cJRCountrys;
                    ArrayList<String> arrayList3 = this.ah;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        this.ah.clear();
                    }
                    ArrayList<CJRPincodeResponse.CJRCities> arrayList4 = this.ai;
                    if (arrayList4 != null && arrayList4.size() > 0) {
                        this.ai.clear();
                    }
                    this.au.setEnabled(true);
                    this.ap.setVisibility(8);
                    this.av.setVisibility(0);
                    this.at.setText("");
                    this.au.setText("");
                } else if (this.ap != null && (editText = this.au) != null) {
                    editText.setEnabled(false);
                    this.ap.setVisibility(0);
                    this.av.setVisibility(8);
                }
            } else if (cJRCountrys != null) {
                this.aD = cJRCountrys;
            }
        } else if (i2 != 115) {
        } else {
            if (i3 == -1) {
                showProgressDialog(this, getResources().getString(R.string.please_wait_progress_msg));
                q.d(getResources().getString(R.string.location_agreed_settings_changes));
                Toast.makeText(this, getResources().getString(R.string.location_on), 1).show();
                d dVar = this.cd;
                if (dVar != null) {
                    dVar.a();
                }
            } else if (i3 == 0) {
                q.d(getResources().getString(R.string.location_not_agreed_settings_changes));
                removeProgressDialog();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 57) {
            showProgressDialog(this, getResources().getString(R.string.please_wait_progress_msg));
            if (s.a(iArr) && this.cd != null) {
                q.d(getResources().getString(R.string.location_marshmallow_permission));
                this.cd.b();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void d() {
        removeProgressDialog();
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        removeProgressDialog();
        if (cJRUtilityLocationModel != null) {
            this.P.setText(cJRUtilityLocationModel.getPinCode());
            String addressLine = cJRUtilityLocationModel.getAddressLine();
            this.T.setText(!TextUtils.isEmpty(addressLine) ? addressLine.replaceAll("[^a-zA-Z0-9,/-_: ]", AppConstants.COLON) : "");
            this.D.setSelected(true);
            this.D.setEnabled(false);
        }
    }

    public final void a(String str, String str2) {
        removeProgressDialog();
    }

    public void onConnected(Bundle bundle) {
        removeProgressDialog();
        showProgressDialog(this, getResources().getString(R.string.please_wait_progress_msg));
        d dVar = this.cd;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.ce != null) {
                this.ce.d();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        d dVar = this.cd;
        if (dVar != null) {
            dVar.a();
        }
    }

    public static void a(String str, String str2, String str3, Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str);
            hashMap.put("user_id", com.paytm.utility.b.n(context));
            hashMap.put("event_action", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
            hashMap.put(net.one97.paytm.common.utility.d.cv, "train");
            com.travel.train.b.a();
            com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public void onBackPressed() {
        if ((TextUtils.isEmpty(this.m.getText()) || this.m.getText().length() <= 0) && (TextUtils.isEmpty(this.E.getText()) || this.E.getText().length() <= 0) && this.W.getCheckedRadioButtonId() == -1) {
            super.onBackPressed();
        } else {
            ((com.travel.train.fragment.d) com.travel.train.fragment.d.instantiate(this, com.travel.train.fragment.d.class.getName())).show(getSupportFragmentManager(), com.travel.train.fragment.d.class.getName());
        }
        hideKeyboard();
    }

    static /* synthetic */ void a(AJRIRCTCSignUpActivity aJRIRCTCSignUpActivity, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) aJRIRCTCSignUpActivity) != null ? com.paytm.utility.b.n((Context) aJRIRCTCSignUpActivity) : "");
            hashMap.put(net.one97.paytm.common.utility.d.di, str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) aJRIRCTCSignUpActivity);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
