package com.travel.flight.flightticket.g;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.v;
import com.travel.flight.flightticket.d.a;
import com.travel.flight.flightticket.e.h;
import com.travel.flight.flightticket.f.n;
import com.travel.flight.flightticket.i.b;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRCancelRefund;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyRoute;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulePolicy;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification;
import com.travel.flight.pojo.flightticket.FareRules.CJRRoutes;
import java.util.ArrayList;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public b f25014a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRMiniRulesLayoutItem> f25015b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f25016c;

    public c(Context context, b bVar) {
        this.f25016c = context;
        this.f25014a = bVar;
    }

    public final void a(h hVar, CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, boolean z) {
        int i2 = AnonymousClass1.f25017a[hVar.ordinal()];
        if (i2 == 1) {
            this.f25014a.setFlightFareBreakupData(cJRFareRulesResponse, str, cJRFlightDetails, cJRFlightPromoResponse, z);
        } else if (i2 == 2) {
            a(str, cJRFareRulesResponse, cJRFlightDetails);
            this.f25014a.setFlightBaggageData(cJRFareRulesResponse, str, cJRFlightDetails);
        } else if (i2 == 3) {
            a(str, cJRFareRulesResponse, cJRFlightDetails);
            this.f25014a.setCancellationData(cJRFareRulesResponse, str, cJRFlightDetails);
        } else if (i2 == 4) {
            a(str, cJRFareRulesResponse, cJRFlightDetails);
            this.f25014a.setRescheduleData(cJRFareRulesResponse, str, cJRFlightDetails);
        }
        this.f25014a.a();
    }

    public static h a(String str) {
        if ("FareBreakUp".equalsIgnoreCase(str)) {
            return h.FareBreakUp;
        }
        if ("Baggage".equalsIgnoreCase(str)) {
            return h.Baggage;
        }
        if ("reschedule_policy".equalsIgnoreCase(str)) {
            return h.Modification;
        }
        return h.Cancellation;
    }

    public static a b(String str) {
        if ("Baggage".equalsIgnoreCase(str)) {
            return a.Baggage;
        }
        if ("reschedule_policy".equalsIgnoreCase(str)) {
            return a.Modification;
        }
        return a.Cancellation;
    }

    public static boolean a(h hVar, CJRFareRulesResponse cJRFareRulesResponse, CJRFlightDetails cJRFlightDetails) {
        if (!(cJRFareRulesResponse == null || cJRFareRulesResponse.getBody() == null || cJRFareRulesResponse.getBody().getMinirules() == null)) {
            int i2 = AnonymousClass1.f25017a[hVar.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (cJRFlightDetails != null) {
                            return true;
                        }
                        return false;
                    } else if (cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy() != null) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy() != null) {
                    return true;
                } else {
                    return false;
                }
            } else if (cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy() != null) {
                return true;
            }
        }
        return false;
    }

    private void a(String str, CJRFareRulesResponse cJRFareRulesResponse, CJRFlightDetails cJRFlightDetails) {
        CJRMiniRulePolicy a2 = a(a(str), cJRFareRulesResponse);
        if (a2 != null) {
            ArrayList<CJRMiniRulesLayoutItem> arrayList = this.f25015b;
            if (arrayList != null) {
                arrayList.clear();
            }
            CJRFareRulesJorneyDetails onward = a2.getOnward();
            if (!(onward == null || onward.getRoutes() == null || onward.getRoutes().size() <= 0)) {
                a(onward.getRoutes(), onward.getTitle(), a2.getHeader_note(), str, cJRFlightDetails);
            }
            CJRFareRulesJorneyDetails cJRFareRulesJorneyDetails = a2.getReturn();
            if (!(cJRFareRulesJorneyDetails == null || cJRFareRulesJorneyDetails.getRoutes() == null || cJRFareRulesJorneyDetails.getRoutes().size() <= 0)) {
                a(cJRFareRulesJorneyDetails.getRoutes(), cJRFareRulesJorneyDetails.getTitle(), a2.getHeader_note(), str, cJRFlightDetails);
            }
            CJRFareRulesJorneyDetails combined = a2.getCombined();
            if (!(combined == null || combined.getRoutes() == null || combined.getRoutes().size() <= 0)) {
                a(combined.getRoutes(), combined.getTitle(), a2.getHeader_note(), str, cJRFlightDetails);
            }
            if (a2.getTc() != null) {
                CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem = new CJRMiniRulesLayoutItem();
                cJRMiniRulesLayoutItem.setmLayoutType(n.ITEM_TANDC_WITH_TEXT.getName());
                cJRMiniRulesLayoutItem.setTermsAndConditions(a2.getTc());
                this.f25015b.add(cJRMiniRulesLayoutItem);
            }
        }
    }

    private void a(List<CJRRoutes> list, String str, String str2, String str3, CJRFlightDetails cJRFlightDetails) {
        int size = list != null ? list.size() : 0;
        for (int i2 = 0; i2 < size; i2++) {
            CJRFareRulesJorneyRoute route = list.get(i2).getRoute();
            if (route != null) {
                CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem = new CJRMiniRulesLayoutItem();
                cJRMiniRulesLayoutItem.setmLayoutType(n.ITEM_ROUTE_VIEW.getName());
                cJRMiniRulesLayoutItem.setHeaderTitle(v.b(str));
                cJRMiniRulesLayoutItem.setRoute(route);
                if ("onward".equalsIgnoreCase(str.toLowerCase()) && cJRFlightDetails.getmOnwardJourney() != null) {
                    cJRMiniRulesLayoutItem.getRoute().setAirlineCode(cJRFlightDetails.getmOnwardJourney().getmAirLineCode());
                } else if ("return".equalsIgnoreCase(str.toLowerCase()) && cJRFlightDetails.getmReturnJourney() != null) {
                    cJRMiniRulesLayoutItem.getRoute().setAirlineCode(cJRFlightDetails.getmReturnJourney().getmAirLineCode());
                }
                CJRCancelRefund refund = list.get(i2).getRefund();
                if (refund != null) {
                    cJRMiniRulesLayoutItem.setRefundable(refund);
                }
                if (str2 != null && !TextUtils.isEmpty(str2)) {
                    cJRMiniRulesLayoutItem.setHeaderNote(str2);
                }
                this.f25015b.add(cJRMiniRulesLayoutItem);
            }
            new ArrayList();
            a b2 = b(str3);
            if (b2 != null) {
                int i3 = AnonymousClass1.f25018b[b2.ordinal()];
                if (i3 == 1) {
                    List<CJRPolicyDetailsCancellationNModification> cancellation_policies = list.get(i2).getCancellation_policies();
                    for (int i4 = 0; i4 < cancellation_policies.size(); i4++) {
                        CJRPolicyDetailsCancellationNModification cJRPolicyDetailsCancellationNModification = cancellation_policies.get(i4);
                        if (cJRPolicyDetailsCancellationNModification != null) {
                            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem2 = new CJRMiniRulesLayoutItem();
                            cJRMiniRulesLayoutItem2.setmLayoutType(n.ITEM_POLICY_VIEW.getName());
                            cJRMiniRulesLayoutItem2.setPolicyDetailCancellationModification(cJRPolicyDetailsCancellationNModification);
                            cJRMiniRulesLayoutItem2.setScreenName("Cancellation");
                            this.f25015b.add(cJRMiniRulesLayoutItem2);
                        }
                    }
                } else if (i3 == 2) {
                    List<CJRPolicyDetailsBaggage> baggage_policies = list.get(i2).getBaggage_policies();
                    for (int i5 = 0; i5 < baggage_policies.size(); i5++) {
                        CJRPolicyDetailsBaggage cJRPolicyDetailsBaggage = baggage_policies.get(i5);
                        if (cJRPolicyDetailsBaggage != null) {
                            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem3 = new CJRMiniRulesLayoutItem();
                            cJRMiniRulesLayoutItem3.setmLayoutType(n.ITEM_POLICY_VIEW.getName());
                            cJRMiniRulesLayoutItem3.setPolicyDetailsBaggage(cJRPolicyDetailsBaggage);
                            cJRMiniRulesLayoutItem3.setScreenName("Baggage");
                            this.f25015b.add(cJRMiniRulesLayoutItem3);
                        }
                    }
                } else if (i3 == 3) {
                    List<CJRPolicyDetailsCancellationNModification> modification_policies = list.get(i2).getModification_policies();
                    for (int i6 = 0; i6 < modification_policies.size(); i6++) {
                        CJRPolicyDetailsCancellationNModification cJRPolicyDetailsCancellationNModification2 = modification_policies.get(i6);
                        if (cJRPolicyDetailsCancellationNModification2 != null) {
                            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem4 = new CJRMiniRulesLayoutItem();
                            cJRMiniRulesLayoutItem4.setmLayoutType(n.ITEM_POLICY_VIEW.getName());
                            cJRMiniRulesLayoutItem4.setPolicyDetailCancellationModification(cJRPolicyDetailsCancellationNModification2);
                            cJRMiniRulesLayoutItem4.setScreenName("Modification");
                            this.f25015b.add(cJRMiniRulesLayoutItem4);
                        }
                    }
                }
            }
            String cancellation_window = list.get(i2).getCancellation_window();
            if (cancellation_window != null && !TextUtils.isEmpty(cancellation_window.trim())) {
                CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem5 = new CJRMiniRulesLayoutItem();
                cJRMiniRulesLayoutItem5.setmLayoutType(n.ITEM_CANCELLATION_WINDOW.getName());
                cJRMiniRulesLayoutItem5.setWindowMessage(cancellation_window);
                this.f25015b.add(cJRMiniRulesLayoutItem5);
            }
            String reschedule_window = list.get(i2).getReschedule_window();
            if (reschedule_window != null && !TextUtils.isEmpty(reschedule_window.trim())) {
                CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem6 = new CJRMiniRulesLayoutItem();
                cJRMiniRulesLayoutItem6.setmLayoutType(n.ITEM_RESCHEDULE_WINDOW.getName());
                cJRMiniRulesLayoutItem6.setWindowMessage(reschedule_window);
                this.f25015b.add(cJRMiniRulesLayoutItem6);
            }
        }
    }

    /* renamed from: com.travel.flight.flightticket.g.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25017a = new int[h.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25018b = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        static {
            /*
                com.travel.flight.flightticket.d.a[] r0 = com.travel.flight.flightticket.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25018b = r0
                r0 = 1
                int[] r1 = f25018b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightticket.d.a r2 = com.travel.flight.flightticket.d.a.Cancellation     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f25018b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightticket.d.a r3 = com.travel.flight.flightticket.d.a.Baggage     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f25018b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightticket.d.a r4 = com.travel.flight.flightticket.d.a.Modification     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.travel.flight.flightticket.e.h[] r3 = com.travel.flight.flightticket.e.h.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f25017a = r3
                int[] r3 = f25017a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.travel.flight.flightticket.e.h r4 = com.travel.flight.flightticket.e.h.FareBreakUp     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f25017a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.travel.flight.flightticket.e.h r3 = com.travel.flight.flightticket.e.h.Baggage     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f25017a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.travel.flight.flightticket.e.h r1 = com.travel.flight.flightticket.e.h.Cancellation     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f25017a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.travel.flight.flightticket.e.h r1 = com.travel.flight.flightticket.e.h.Modification     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.g.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static CJRMiniRulePolicy a(h hVar, CJRFareRulesResponse cJRFareRulesResponse) {
        if (cJRFareRulesResponse == null || cJRFareRulesResponse.getBody() == null || cJRFareRulesResponse.getBody().getMinirules() == null) {
            return null;
        }
        int i2 = AnonymousClass1.f25017a[hVar.ordinal()];
        if (i2 == 2) {
            return cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy();
        }
        if (i2 == 3) {
            return cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy();
        }
        if (i2 != 4) {
            return null;
        }
        return cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy();
    }
}
