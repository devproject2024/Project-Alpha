package com.travel.calendar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.squareup.timessquare.v3.CalendarPickerView;
import com.travel.R;
import com.travel.c.i;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.model.CalendarHoliday;
import com.travel.model.CalendarHolidayList;
import com.travel.model.CalendarPriceModel;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class c extends com.travel.travels.b.a implements CalendarPickerView.h, Observer {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22999a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private int f23000c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23001d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public e f23002e = e.CHECKIN_CALENDAR;

    /* renamed from: f  reason: collision with root package name */
    private g f23003f;

    /* renamed from: g  reason: collision with root package name */
    private i f23004g;

    /* renamed from: h  reason: collision with root package name */
    private Calendar f23005h;

    /* renamed from: i  reason: collision with root package name */
    private Calendar f23006i;
    private f j;
    private CalendarPriceModel k;
    private Locale l;
    private String m = "CalendarFragment";
    private boolean n;
    private String o;
    private String p;
    private HashMap q;

    public final void onEditViewClick(View view) {
    }

    static final class b<T> implements z<Date> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23007a;

        b(c cVar) {
            this.f23007a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Date date = (Date) obj;
            if (date != null) {
                c cVar = this.f23007a;
                cVar.a(date, c.a(cVar).s);
                if (this.f23007a.f23002e == e.CHECKOUT_CALENDAR) {
                    c.b(this.f23007a).f22890b.a(date);
                }
            }
        }
    }

    /* renamed from: com.travel.calendar.c$c  reason: collision with other inner class name */
    static final class C0442c<T> implements z<Date> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23008a;

        C0442c(c cVar) {
            this.f23008a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c cVar = this.f23008a;
            cVar.a(c.a(cVar).t, (Date) obj);
        }
    }

    static final class d<T> implements z<CalendarHolidayList> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23009a;

        d(c cVar) {
            this.f23009a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((CalendarHolidayList) obj) != null) {
                this.f23009a.a();
            }
        }
    }

    public static final /* synthetic */ g a(c cVar) {
        g gVar = cVar.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        return gVar;
    }

    public static final /* synthetic */ i b(c cVar) {
        i iVar = cVar.f23004g;
        if (iVar == null) {
            k.a("binding");
        }
        return iVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new Locale(n.a());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f23000c = arguments.getInt("calendar_position");
            this.f23001d = arguments.getBoolean("is_from_search_modification");
            Serializable serializable = arguments.getSerializable("calendar_kind");
            if (serializable != null) {
                this.f23002e = (e) serializable;
                this.n = arguments.getBoolean("is_from_order_modification");
                this.o = arguments.getString("intent_extra_start_date_range");
                this.p = arguments.getString("intent_extra_end_date_range");
                return;
            }
            throw new u("null cannot be cast to non-null type com.travel.calendar.CalendarKind");
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof f) {
            this.j = (f) context;
            return;
        }
        throw new RuntimeException("You for got to Implement CommonCalendarDateSelectionListener in the parent activity");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.fragment_calendar, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…lendar, container, false)");
        this.f23004g = (i) a2;
        i iVar = this.f23004g;
        if (iVar == null) {
            k.a("binding");
        }
        return iVar.getRoot();
    }

    public final void onActivityCreated(Bundle bundle) {
        CalendarPriceModel calendarPriceModel;
        super.onActivityCreated(bundle);
        ai a2 = am.a(requireActivity()).a(g.class);
        k.a((Object) a2, "ViewModelProviders.of(re…darViewModel::class.java]");
        this.f23003f = (g) a2;
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.o) {
            com.travel.f.b bVar = com.travel.f.b.f23450a;
            com.travel.f.c a3 = com.travel.f.b.a();
            if (a3 != null) {
                calendarPriceModel = a3.f23452a;
            } else {
                calendarPriceModel = null;
            }
            this.k = calendarPriceModel;
        }
        a();
        g gVar2 = this.f23003f;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        gVar2.f23014b.observe(getViewLifecycleOwner(), new b(this));
        g gVar3 = this.f23003f;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        gVar3.f23015c.observe(getViewLifecycleOwner(), new C0442c(this));
        g gVar4 = this.f23003f;
        if (gVar4 == null) {
            k.a("viewModel");
        }
        gVar4.f23016d.observe(getViewLifecycleOwner(), new d(this));
    }

    public final void onStart() {
        super.onStart();
        com.travel.f.b bVar = com.travel.f.b.f23450a;
        com.travel.f.c a2 = com.travel.f.b.a();
        if (a2 != null) {
            a2.addObserver(this);
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.f23002e == e.CHECKIN_CALENDAR) {
            g gVar = this.f23003f;
            if (gVar == null) {
                k.a("viewModel");
            }
            Date date = gVar.t;
            if (date != null) {
                i iVar = this.f23004g;
                if (iVar == null) {
                    k.a("binding");
                }
                iVar.f22890b.a(date);
            }
        } else if (this.f23002e == e.CHECKOUT_CALENDAR) {
            g gVar2 = this.f23003f;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            if (gVar2.s != null) {
                i iVar2 = this.f23004g;
                if (iVar2 == null) {
                    k.a("binding");
                }
                CalendarPickerView calendarPickerView = iVar2.f22890b;
                g gVar3 = this.f23003f;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                calendarPickerView.a(gVar3.s);
                return;
            }
            g gVar4 = this.f23003f;
            if (gVar4 == null) {
                k.a("viewModel");
            }
            if (gVar4.t != null) {
                i iVar3 = this.f23004g;
                if (iVar3 == null) {
                    k.a("binding");
                }
                CalendarPickerView calendarPickerView2 = iVar3.f22890b;
                g gVar5 = this.f23003f;
                if (gVar5 == null) {
                    k.a("viewModel");
                }
                calendarPickerView2.a(gVar5.t);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        com.travel.f.b bVar = com.travel.f.b.f23450a;
        com.travel.f.c a2 = com.travel.f.b.a();
        if (a2 != null) {
            a2.deleteObserver(this);
        }
    }

    public final void onDestroy() {
        i iVar = this.f23004g;
        if (iVar == null) {
            k.a("binding");
        }
        CalendarPickerView calendarPickerView = iVar.f22890b;
        k.a((Object) calendarPickerView, "binding.calendarView");
        if (calendarPickerView.getDecorators() != null) {
            i iVar2 = this.f23004g;
            if (iVar2 == null) {
                k.a("binding");
            }
            CalendarPickerView calendarPickerView2 = iVar2.f22890b;
            k.a((Object) calendarPickerView2, "binding.calendarView");
            List<com.squareup.timessquare.v3.a> decorators = calendarPickerView2.getDecorators();
            k.a((Object) decorators, "binding.calendarView.decorators");
            if (!decorators.isEmpty()) {
                i iVar3 = this.f23004g;
                if (iVar3 == null) {
                    k.a("binding");
                }
                CalendarPickerView calendarPickerView3 = iVar3.f22890b;
                k.a((Object) calendarPickerView3, "binding.calendarView");
                List<com.squareup.timessquare.v3.a> decorators2 = calendarPickerView3.getDecorators();
                k.a((Object) decorators2, "binding.calendarView.decorators");
                for (com.squareup.timessquare.v3.a aVar : decorators2) {
                    if (aVar instanceof com.travel.f.d) {
                        com.travel.f.d dVar = (com.travel.f.d) aVar;
                        dVar.f23454a.removeCallbacksAndMessages((Object) null);
                        dVar.f23455b = null;
                        dVar.f23456c = null;
                    }
                }
            }
        }
        i iVar4 = this.f23004g;
        if (iVar4 == null) {
            k.a("binding");
        }
        if (iVar4.f22890b != null) {
            i iVar5 = this.f23004g;
            if (iVar5 == null) {
                k.a("binding");
            }
            CalendarPickerView calendarPickerView4 = iVar5.f22890b;
            k.a((Object) calendarPickerView4, "binding.calendarView");
            calendarPickerView4.getDecorators().clear();
            i iVar6 = this.f23004g;
            if (iVar6 == null) {
                k.a("binding");
            }
            iVar6.f22890b.setCustomDayView((com.squareup.timessquare.v3.b) null);
            i iVar7 = this.f23004g;
            if (iVar7 == null) {
                k.a("binding");
            }
            CalendarPickerView calendarPickerView5 = iVar7.f22890b;
            k.a((Object) calendarPickerView5, "binding.calendarView");
            calendarPickerView5.setDecorators((List<com.squareup.timessquare.v3.a>) null);
            i iVar8 = this.f23004g;
            if (iVar8 == null) {
                k.a("binding");
            }
            iVar8.f22890b.setHolidayList((Map<Date, String>) null);
            i iVar9 = this.f23004g;
            if (iVar9 == null) {
                k.a("binding");
            }
            iVar9.f22890b.setOnDateSelectedListener((CalendarPickerView.h) null);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void a() {
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        String str = gVar.q;
        if (str != null) {
            i iVar = this.f23004g;
            if (iVar == null) {
                k.a("binding");
            }
            TextView textView = iVar.f22893e;
            k.a((Object) textView, "binding.fareDisclaimerText");
            textView.setText(str);
        }
        b();
        g gVar2 = this.f23003f;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        Date date = gVar2.t;
        g gVar3 = this.f23003f;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        a(date, gVar3.s);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r11 = this;
            boolean r0 = r11.n
            r1 = 361(0x169, float:5.06E-43)
            r2 = 5
            java.lang.String r3 = "Calendar.getInstance()"
            if (r0 == 0) goto L_0x0092
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy-MM-dd"
            r0.<init>(r4)
            java.lang.String r4 = r11.o
            r5 = 0
            if (r4 == 0) goto L_0x002d
            java.lang.String r6 = r11.p
            if (r6 == 0) goto L_0x002d
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x0027 }
            java.lang.String r6 = r11.p     // Catch:{ ParseException -> 0x0025 }
            java.util.Date r5 = r0.parse(r6)     // Catch:{ ParseException -> 0x0025 }
            goto L_0x002e
        L_0x0025:
            r0 = move-exception
            goto L_0x0029
        L_0x0027:
            r0 = move-exception
            r4 = r5
        L_0x0029:
            r0.printStackTrace()
            goto L_0x002e
        L_0x002d:
            r4 = r5
        L_0x002e:
            java.lang.String r0 = "nextYear"
            if (r4 == 0) goto L_0x0075
            if (r5 == 0) goto L_0x0075
            long r6 = r4.getTime()
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0075
            long r6 = r5.getTime()
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0075
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r11.f23005h = r1
            java.util.Calendar r1 = r11.f23005h
            if (r1 != 0) goto L_0x005e
            java.lang.String r2 = "currentYear"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x005e:
            r1.setTime(r4)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r11.f23006i = r1
            java.util.Calendar r1 = r11.f23006i
            if (r1 != 0) goto L_0x0071
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0071:
            r1.setTime(r5)
            goto L_0x00a9
        L_0x0075:
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            r11.f23005h = r4
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            r11.f23006i = r4
            java.util.Calendar r4 = r11.f23006i
            if (r4 != 0) goto L_0x008e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x008e:
            r4.add(r2, r1)
            goto L_0x00a9
        L_0x0092:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r11.f23005h = r0
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r0.add(r2, r1)
            java.lang.String r1 = "Calendar.getInstance().a….DATE, 361)\n            }"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r11.f23006i = r0
        L_0x00a9:
            com.travel.calendar.g r0 = r11.f23003f
            java.lang.String r1 = "viewModel"
            if (r0 != 0) goto L_0x00b3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b3:
            java.util.HashMap<java.lang.String, com.travel.model.CalendarDatePriceInfo> r0 = r0.p
            int r0 = r0.size()
            java.lang.String r2 = "binding.fareDisclaimerContainer"
            r4 = 0
            r5 = 1
            java.lang.String r6 = "binding"
            if (r0 != 0) goto L_0x00dc
            com.travel.calendar.g r0 = r11.f23003f
            if (r0 != 0) goto L_0x00c8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c8:
            r0.C = r4
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x00d1
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00d1:
            android.widget.LinearLayout r0 = r0.f22892d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x00f4
        L_0x00dc:
            com.travel.calendar.g r0 = r11.f23003f
            if (r0 != 0) goto L_0x00e3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e3:
            r0.C = r5
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x00ec
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00ec:
            android.widget.LinearLayout r0 = r0.f22892d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r4)
        L_0x00f4:
            com.travel.calendar.g r0 = r11.f23003f
            if (r0 != 0) goto L_0x00fb
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00fb:
            com.travel.common.a.c r0 = r0.a()
            com.travel.common.a.c r2 = com.travel.common.a.c.TRAIN
            if (r0 != r2) goto L_0x0117
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x010a
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x010a:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            com.travel.calendar.a.a r2 = new com.travel.calendar.a.a
            r2.<init>()
            com.squareup.timessquare.v3.b r2 = (com.squareup.timessquare.v3.b) r2
            r0.setCustomDayView(r2)
            goto L_0x012a
        L_0x0117:
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x011e
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x011e:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            com.travel.a.b r2 = new com.travel.a.b
            r2.<init>()
            com.squareup.timessquare.v3.b r2 = (com.squareup.timessquare.v3.b) r2
            r0.setCustomDayView(r2)
        L_0x012a:
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x0131
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0131:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            r2 = r11
            com.squareup.timessquare.v3.CalendarPickerView$h r2 = (com.squareup.timessquare.v3.CalendarPickerView.h) r2
            r0.setOnDateSelectedListener(r2)
            com.travel.calendar.g r0 = r11.f23003f
            if (r0 != 0) goto L_0x0140
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0140:
            java.lang.String r0 = r0.r
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x014c
            r0 = 1
            goto L_0x014d
        L_0x014c:
            r0 = 0
        L_0x014d:
            if (r0 == 0) goto L_0x0175
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy MM dd"
            r0.<init>(r2)
            com.travel.calendar.g r2 = r11.f23003f
            if (r2 != 0) goto L_0x015e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x015e:
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            java.util.Date r3 = r7.getTime()
            java.lang.String r0 = r0.format(r3)
            java.lang.String r3 = "sdf.format(Calendar.getInstance().time)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r2.a((java.lang.String) r0)
        L_0x0175:
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x017c
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x017c:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            java.lang.String r2 = "binding.calendarView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.travel.calendar.g r2 = r11.f23003f
            if (r2 != 0) goto L_0x018a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x018a:
            com.travel.common.a.c r2 = r2.a()
            java.util.List r2 = r11.a((com.travel.common.a.c) r2, (boolean) r5)
            r0.setDecorators(r2)
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x019c
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x019c:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            java.util.Map r2 = r11.e()
            r0.setHolidayList(r2)
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x01ac
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01ac:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            com.travel.calendar.g r2 = r11.f23003f
            if (r2 != 0) goto L_0x01b5
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b5:
            com.travel.common.a.c r1 = r2.a()
            com.travel.common.a.c r2 = com.travel.common.a.c.FLIGHT
            if (r1 != r2) goto L_0x01be
            r4 = 1
        L_0x01be:
            r0.setFromFlight(r4)
            com.travel.c.i r0 = r11.f23004g
            if (r0 != 0) goto L_0x01c8
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01c8:
            com.squareup.timessquare.v3.CalendarPickerView r0 = r0.f22890b
            com.travel.calendar.c$e r1 = new com.travel.calendar.c$e
            r1.<init>(r11)
            android.widget.AbsListView$OnScrollListener r1 = (android.widget.AbsListView.OnScrollListener) r1
            r0.setOnScrollListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.calendar.c.b():void");
    }

    public static final class e implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23010a;

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        e(c cVar) {
            this.f23010a = cVar;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (!c.a(this.f23010a).C || i2 != 0) {
                LinearLayout linearLayout = c.b(this.f23010a).f22892d;
                k.a((Object) linearLayout, "binding.fareDisclaimerContainer");
                linearLayout.setVisibility(8);
                return;
            }
            LinearLayout linearLayout2 = c.b(this.f23010a).f22892d;
            k.a((Object) linearLayout2, "binding.fareDisclaimerContainer");
            linearLayout2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Date date, Date date2) {
        if (date != null && date2 != null) {
            b(date, date2);
        } else if (date != null) {
            b(date);
        } else if (date2 != null) {
            b(date2);
        }
    }

    private final void b(Date date) {
        CalendarPickerView.j jVar;
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        a(date, gVar.t != null);
        g gVar2 = this.f23003f;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        if (gVar2.f23021i) {
            jVar = CalendarPickerView.j.SINGLE;
        } else {
            jVar = CalendarPickerView.j.RANGE;
        }
        i iVar = this.f23004g;
        if (iVar == null) {
            k.a("binding");
        }
        CalendarPickerView calendarPickerView = iVar.f22890b;
        Calendar calendar = this.f23005h;
        if (calendar == null) {
            k.a("currentYear");
        }
        calendarPickerView.a(calendar.getTime(), f(), Locale.ENGLISH).a(jVar).a(date);
    }

    private final void b(Date date, Date date2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(date);
        arrayList.add(date2);
        i iVar = this.f23004g;
        if (iVar == null) {
            k.a("binding");
        }
        CalendarPickerView calendarPickerView = iVar.f22890b;
        Date date3 = new Date();
        Calendar calendar = this.f23006i;
        if (calendar == null) {
            k.a("nextYear");
        }
        calendarPickerView.a(date3, calendar.getTime(), Locale.ENGLISH).a(CalendarPickerView.j.RANGE).a((Collection<Date>) arrayList);
    }

    private final void a(Date date, boolean z) {
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.o) {
            c();
            g gVar2 = this.f23003f;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            if (gVar2.p.size() > 0) {
                i iVar = this.f23004g;
                if (iVar == null) {
                    k.a("binding");
                }
                CalendarPickerView calendarPickerView = iVar.f22890b;
                k.a((Object) calendarPickerView, "binding.calendarView");
                calendarPickerView.getDecorators().clear();
                g gVar3 = this.f23003f;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                gVar3.C = true;
                i iVar2 = this.f23004g;
                if (iVar2 == null) {
                    k.a("binding");
                }
                LinearLayout linearLayout = iVar2.f22892d;
                k.a((Object) linearLayout, "binding.fareDisclaimerContainer");
                linearLayout.setVisibility(0);
            } else {
                g gVar4 = this.f23003f;
                if (gVar4 == null) {
                    k.a("viewModel");
                }
                gVar4.C = false;
                i iVar3 = this.f23004g;
                if (iVar3 == null) {
                    k.a("binding");
                }
                LinearLayout linearLayout2 = iVar3.f22892d;
                k.a((Object) linearLayout2, "binding.fareDisclaimerContainer");
                linearLayout2.setVisibility(8);
            }
            i iVar4 = this.f23004g;
            if (iVar4 == null) {
                k.a("binding");
            }
            CalendarPickerView calendarPickerView2 = iVar4.f22890b;
            k.a((Object) calendarPickerView2, "binding.calendarView");
            g gVar5 = this.f23003f;
            if (gVar5 == null) {
                k.a("viewModel");
            }
            calendarPickerView2.setDecorators(a(gVar5.a(), z));
            if (date != null) {
                i iVar5 = this.f23004g;
                if (iVar5 == null) {
                    k.a("binding");
                }
                iVar5.f22890b.b(date);
            }
        }
    }

    private final void c() {
        CalendarPriceModel calendarPriceModel;
        ArrayList<CalendarDatePriceInfo> returnDatePriceInfo;
        ArrayList<CalendarDatePriceInfo> onwardDatePriceInfo;
        if (this.k != null) {
            g gVar = this.f23003f;
            if (gVar == null) {
                k.a("viewModel");
            }
            gVar.p.clear();
            if (this.f23002e == e.CHECKIN_CALENDAR) {
                CalendarPriceModel calendarPriceModel2 = this.k;
                if (calendarPriceModel2 != null && (onwardDatePriceInfo = calendarPriceModel2.getOnwardDatePriceInfo()) != null) {
                    for (CalendarDatePriceInfo calendarDatePriceInfo : onwardDatePriceInfo) {
                        g gVar2 = this.f23003f;
                        if (gVar2 == null) {
                            k.a("viewModel");
                        }
                        Map map = gVar2.p;
                        String date = calendarDatePriceInfo.getDate();
                        if (date == null) {
                            date = "";
                        }
                        map.put(date, calendarDatePriceInfo);
                    }
                }
            } else if (this.f23002e == e.CHECKOUT_CALENDAR && (calendarPriceModel = this.k) != null && (returnDatePriceInfo = calendarPriceModel.getReturnDatePriceInfo()) != null) {
                for (CalendarDatePriceInfo calendarDatePriceInfo2 : returnDatePriceInfo) {
                    g gVar3 = this.f23003f;
                    if (gVar3 == null) {
                        k.a("viewModel");
                    }
                    Map map2 = gVar3.p;
                    String date2 = calendarDatePriceInfo2.getDate();
                    if (date2 == null) {
                        date2 = "";
                    }
                    map2.put(date2, calendarDatePriceInfo2);
                }
            }
        }
    }

    private final HashMap<String, CalendarHoliday> d() {
        List<CalendarHoliday> holidayList;
        HashMap<String, CalendarHoliday> hashMap = new HashMap<>();
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        CalendarHolidayList calendarHolidayList = gVar.l;
        if (!(calendarHolidayList == null || calendarHolidayList.getHolidayList() == null)) {
            List<CalendarHoliday> holidayList2 = calendarHolidayList.getHolidayList();
            if ((holidayList2 != null ? holidayList2.size() : 0) > 0 && (holidayList = calendarHolidayList.getHolidayList()) != null) {
                for (CalendarHoliday calendarHoliday : holidayList) {
                    if (calendarHoliday != null) {
                        Map map = hashMap;
                        String date = calendarHoliday.getDate();
                        if (date == null) {
                            date = "";
                        }
                        map.put(date, calendarHoliday);
                    }
                }
            }
        }
        return hashMap;
    }

    private final Map<Date, String> e() {
        List<CalendarHoliday> holidayList;
        Map<Date, String> linkedHashMap = new LinkedHashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        CalendarHolidayList calendarHolidayList = gVar.l;
        if (!(calendarHolidayList == null || calendarHolidayList.getHolidayList() == null)) {
            List<CalendarHoliday> holidayList2 = calendarHolidayList.getHolidayList();
            if ((holidayList2 != null ? holidayList2.size() : 0) > 0 && (holidayList = calendarHolidayList.getHolidayList()) != null) {
                for (CalendarHoliday calendarHoliday : holidayList) {
                    if (calendarHoliday != null) {
                        try {
                            Date parse = simpleDateFormat.parse(calendarHoliday.getDate());
                            k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                            String name = calendarHoliday.getName();
                            if (name == null) {
                                name = "";
                            }
                            linkedHashMap.put(parse, name);
                            linkedHashMap = new TreeMap<>(linkedHashMap);
                        } catch (ParseException e2) {
                            q.c(e2.getMessage());
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private final List<com.squareup.timessquare.v3.a> a(com.travel.common.a.c cVar, boolean z) {
        List<com.squareup.timessquare.v3.a> arrayList = new ArrayList<>();
        int i2 = d.f23011a[cVar.ordinal()];
        if (i2 == 1) {
            Context context = getContext();
            g gVar = this.f23003f;
            if (gVar == null) {
                k.a("viewModel");
            }
            arrayList.add(new h(context, gVar.p, z, new Handler(), d()));
        } else if (i2 != 2) {
            Context context2 = getContext();
            g gVar2 = this.f23003f;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            HashMap<String, CalendarDatePriceInfo> hashMap = gVar2.p;
            Handler handler = new Handler();
            HashMap<String, CalendarHoliday> d2 = d();
            boolean z2 = !z;
            g gVar3 = this.f23003f;
            if (gVar3 == null) {
                k.a("viewModel");
            }
            String str = gVar3.r;
            g gVar4 = this.f23003f;
            if (gVar4 == null) {
                k.a("viewModel");
            }
            Date date = gVar4.t;
            g gVar5 = this.f23003f;
            if (gVar5 == null) {
                k.a("viewModel");
            }
            arrayList.add(new com.travel.f.d(context2, hashMap, z, handler, d2, z2, str, date, gVar5.s));
        } else {
            Context context3 = getContext();
            HashMap<String, CalendarHoliday> d3 = d();
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "Calendar.getInstance()");
            Date time = instance.getTime();
            g gVar6 = this.f23003f;
            if (gVar6 == null) {
                k.a("viewModel");
            }
            int i3 = gVar6.f23020h;
            g gVar7 = this.f23003f;
            if (gVar7 == null) {
                k.a("viewModel");
            }
            arrayList.add(new com.travel.calendar.b.a(context3, d3, time, i3, gVar7.B));
        }
        return arrayList;
    }

    private final Date f() {
        Calendar calendar;
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.a() == com.travel.common.a.c.TRAIN) {
            g gVar2 = this.f23003f;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            if (gVar2.f23020h != -1) {
                g gVar3 = this.f23003f;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                calendar = Calendar.getInstance();
                calendar.add(2, gVar3.f23020h / 30);
                calendar.set(5, 30);
                k.a((Object) calendar, "nextYear");
                Date time = calendar.getTime();
                k.a((Object) time, "nextYear.time");
                return time;
            }
        }
        calendar = this.f23006i;
        if (calendar == null) {
            k.a("nextYear");
        }
        Date time2 = calendar.getTime();
        k.a((Object) time2, "nextYear.time");
        return time2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(int i2, e eVar, boolean z, boolean z2, String str, String str2) {
            k.c(eVar, "calendarKind");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putInt("calendar_position", i2);
            bundle.putBoolean("is_from_search_modification", z);
            bundle.putSerializable("calendar_kind", eVar);
            bundle.putBoolean("is_from_order_modification", z2);
            bundle.putString("intent_extra_start_date_range", str);
            bundle.putString("intent_extra_end_date_range", str2);
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    public final void a(Date date) {
        f fVar;
        if (date == null) {
            com.paytm.utility.b.a((Activity) getActivity(), y.b(AJRCommonCalendarActivity.class).b());
            return;
        }
        int i2 = d.f23012b[this.f23002e.ordinal()];
        if (i2 == 1) {
            f fVar2 = this.j;
            if (fVar2 != null) {
                i iVar = this.f23004g;
                if (iVar == null) {
                    k.a("binding");
                }
                CalendarPickerView calendarPickerView = iVar.f22890b;
                k.a((Object) calendarPickerView, "binding.calendarView");
                List<Date> selectedDates = calendarPickerView.getSelectedDates();
                k.a((Object) selectedDates, "binding.calendarView.selectedDates");
                fVar2.a(date, selectedDates);
            }
        } else if (i2 == 2 && (fVar = this.j) != null) {
            i iVar2 = this.f23004g;
            if (iVar2 == null) {
                k.a("binding");
            }
            CalendarPickerView calendarPickerView2 = iVar2.f22890b;
            k.a((Object) calendarPickerView2, "binding.calendarView");
            List<Date> selectedDates2 = calendarPickerView2.getSelectedDates();
            k.a((Object) selectedDates2, "binding.calendarView.selectedDates");
            fVar.b(date, selectedDates2);
        }
    }

    public final void update(Observable observable, Object obj) {
        CalendarPriceModel calendarPriceModel;
        g gVar = this.f23003f;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.o) {
            com.travel.f.b bVar = com.travel.f.b.f23450a;
            com.travel.f.c a2 = com.travel.f.b.a();
            if (a2 != null) {
                calendarPriceModel = a2.f23452a;
            } else {
                calendarPriceModel = null;
            }
            this.k = calendarPriceModel;
        }
        g gVar2 = this.f23003f;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        gVar2.C = this.k != null;
        g gVar3 = this.f23003f;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        if (gVar3.C) {
            i iVar = this.f23004g;
            if (iVar == null) {
                k.a("binding");
            }
            LinearLayout linearLayout = iVar.f22892d;
            k.a((Object) linearLayout, "binding.fareDisclaimerContainer");
            linearLayout.setVisibility(0);
        } else {
            i iVar2 = this.f23004g;
            if (iVar2 == null) {
                k.a("binding");
            }
            LinearLayout linearLayout2 = iVar2.f22892d;
            k.a((Object) linearLayout2, "binding.fareDisclaimerContainer");
            linearLayout2.setVisibility(8);
        }
        g gVar4 = this.f23003f;
        if (gVar4 == null) {
            k.a("viewModel");
        }
        a(gVar4.t, true);
        g gVar5 = this.f23003f;
        if (gVar5 == null) {
            k.a("viewModel");
        }
        Date date = gVar5.t;
        g gVar6 = this.f23003f;
        if (gVar6 == null) {
            k.a("viewModel");
        }
        a(date, gVar6.s);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
