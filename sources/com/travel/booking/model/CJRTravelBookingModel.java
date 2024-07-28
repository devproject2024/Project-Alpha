package com.travel.booking.model;

import android.content.Context;
import android.net.Uri;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.booking.datamodel.CJRTravelBookingData;
import com.travel.booking.datamodel.TravelBookingListInfo;
import com.travel.d;
import com.travel.utils.e;
import com.travel.utils.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRTravelBookingModel {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final String RFC_822 = RFC_822;
    /* access modifiers changed from: private */
    public static Date currentdate;
    /* access modifiers changed from: private */
    public static final SimpleDateFormat inputDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    /* access modifiers changed from: private */
    public static final SimpleDateFormat outputDateFormat = new SimpleDateFormat("EEE, d MMM");
    /* access modifiers changed from: private */
    public static final SimpleDateFormat outputTimeFormat = new SimpleDateFormat("hh:mm aa");

    public interface IBookingDataListener {
        void onApiError(int i2, NetworkCustomError networkCustomError);

        void onDataFetch(List<CJRTravelBookingData> list);

        void onNetworkError();
    }

    public static final void fetchBookingData(Context context, IBookingDataListener iBookingDataListener) {
        Companion.fetchBookingData(context, iBookingDataListener);
    }

    private CJRTravelBookingModel() {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final SimpleDateFormat getInputDateTimeFormat() {
            return CJRTravelBookingModel.inputDateTimeFormat;
        }

        public final SimpleDateFormat getOutputDateFormat() {
            return CJRTravelBookingModel.outputDateFormat;
        }

        public final SimpleDateFormat getOutputTimeFormat() {
            return CJRTravelBookingModel.outputTimeFormat;
        }

        public final String getRFC_822() {
            return CJRTravelBookingModel.RFC_822;
        }

        public final Date getCurrentdate() {
            return CJRTravelBookingModel.currentdate;
        }

        public final void setCurrentdate(Date date) {
            CJRTravelBookingModel.currentdate = date;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
            r1 = (r1 = r1.getUpcomingHeading()).getText();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.travel.booking.datamodel.CJRTravelBookingData> formatAPIResponse(android.content.Context r25, com.travel.booking.datamodel.TravelBookingListInfo r26) {
            /*
                r24 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.List r0 = (java.util.List) r0
                android.content.res.Resources r1 = r25.getResources()
                int r2 = com.travel.R.string.upcoming
                java.lang.String r5 = r1.getString(r2)
                java.lang.String r1 = "app.resources.getString(R.string.upcoming)"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x0022
                java.util.List r1 = r1.getUpcoming()
                if (r1 != 0) goto L_0x0026
            L_0x0022:
                kotlin.a.w r1 = kotlin.a.w.INSTANCE
                java.util.List r1 = (java.util.List) r1
            L_0x0026:
                r6 = r1
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x003e
                com.travel.booking.datamodel.EmptyBookingMessage r1 = r1.getUpcomingHeading()
                if (r1 == 0) goto L_0x003e
                java.lang.String r1 = r1.getText()
                if (r1 != 0) goto L_0x003c
                goto L_0x003e
            L_0x003c:
                r7 = r1
                goto L_0x003f
            L_0x003e:
                r7 = r2
            L_0x003f:
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x0054
                com.travel.booking.datamodel.EmptyBookingMessage r1 = r1.getUpcomingHeading()
                if (r1 == 0) goto L_0x0054
                java.lang.String r1 = r1.getSubText()
                if (r1 != 0) goto L_0x0052
                goto L_0x0054
            L_0x0052:
                r8 = r1
                goto L_0x0055
            L_0x0054:
                r8 = r2
            L_0x0055:
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x0064
                java.lang.String r1 = r1.getZeroSearchImage()
                if (r1 != 0) goto L_0x0062
                goto L_0x0064
            L_0x0062:
                r9 = r1
                goto L_0x0065
            L_0x0064:
                r9 = r2
            L_0x0065:
                android.content.res.Resources r1 = r25.getResources()
                int r3 = com.travel.R.string.completed
                java.lang.String r12 = r1.getString(r3)
                java.lang.String r1 = "app.resources.getString(R.string.completed)"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x0080
                java.util.List r1 = r1.getCompleted()
                if (r1 != 0) goto L_0x0084
            L_0x0080:
                kotlin.a.w r1 = kotlin.a.w.INSTANCE
                java.util.List r1 = (java.util.List) r1
            L_0x0084:
                r13 = r1
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x009a
                com.travel.booking.datamodel.EmptyBookingMessage r1 = r1.getCompletedPageHeading()
                if (r1 == 0) goto L_0x009a
                java.lang.String r1 = r1.getText()
                if (r1 != 0) goto L_0x0098
                goto L_0x009a
            L_0x0098:
                r14 = r1
                goto L_0x009b
            L_0x009a:
                r14 = r2
            L_0x009b:
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x00b0
                com.travel.booking.datamodel.EmptyBookingMessage r1 = r1.getCompletedPageHeading()
                if (r1 == 0) goto L_0x00b0
                java.lang.String r1 = r1.getSubText()
                if (r1 != 0) goto L_0x00ae
                goto L_0x00b0
            L_0x00ae:
                r15 = r1
                goto L_0x00b1
            L_0x00b0:
                r15 = r2
            L_0x00b1:
                com.travel.booking.datamodel.Body r1 = r26.getBody()
                if (r1 == 0) goto L_0x00c1
                java.lang.String r1 = r1.getZeroSearchImage()
                if (r1 != 0) goto L_0x00be
                goto L_0x00c1
            L_0x00be:
                r16 = r1
                goto L_0x00c3
            L_0x00c1:
                r16 = r2
            L_0x00c3:
                android.content.res.Resources r1 = r25.getResources()
                int r3 = com.travel.R.string.cancelled
                java.lang.String r1 = r1.getString(r3)
                java.lang.String r3 = "app.resources.getString(R.string.cancelled)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                com.travel.booking.datamodel.Body r3 = r26.getBody()
                if (r3 == 0) goto L_0x00de
                java.util.List r3 = r3.getCancelled()
                if (r3 != 0) goto L_0x00e2
            L_0x00de:
                kotlin.a.w r3 = kotlin.a.w.INSTANCE
                java.util.List r3 = (java.util.List) r3
            L_0x00e2:
                r20 = r3
                com.travel.booking.datamodel.Body r3 = r26.getBody()
                if (r3 == 0) goto L_0x00fa
                com.travel.booking.datamodel.EmptyBookingMessage r3 = r3.getCancelledPageHeading()
                if (r3 == 0) goto L_0x00fa
                java.lang.String r3 = r3.getText()
                if (r3 != 0) goto L_0x00f7
                goto L_0x00fa
            L_0x00f7:
                r21 = r3
                goto L_0x00fc
            L_0x00fa:
                r21 = r2
            L_0x00fc:
                com.travel.booking.datamodel.Body r3 = r26.getBody()
                if (r3 == 0) goto L_0x0112
                com.travel.booking.datamodel.EmptyBookingMessage r3 = r3.getCancelledPageHeading()
                if (r3 == 0) goto L_0x0112
                java.lang.String r3 = r3.getText()
                if (r3 != 0) goto L_0x010f
                goto L_0x0112
            L_0x010f:
                r22 = r3
                goto L_0x0114
            L_0x0112:
                r22 = r2
            L_0x0114:
                com.travel.booking.datamodel.Body r3 = r26.getBody()
                if (r3 == 0) goto L_0x0124
                java.lang.String r3 = r3.getZeroSearchImage()
                if (r3 != 0) goto L_0x0121
                goto L_0x0124
            L_0x0121:
                r23 = r3
                goto L_0x0126
            L_0x0124:
                r23 = r2
            L_0x0126:
                com.travel.booking.model.CJRTravelBookingModel$Companion$formatAPIResponse$1 r2 = new com.travel.booking.model.CJRTravelBookingModel$Companion$formatAPIResponse$1
                r3 = r25
                r2.<init>(r3, r0)
                com.travel.booking.datamodel.BOOKING_TYPE r4 = com.travel.booking.datamodel.BOOKING_TYPE.BOOKING_TYPE_UPCOMING
                r3 = r2
                r3.invoke((com.travel.booking.datamodel.BOOKING_TYPE) r4, (java.lang.String) r5, (java.util.List<com.travel.booking.datamodel.BookingInfo>) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
                com.travel.booking.datamodel.BOOKING_TYPE r11 = com.travel.booking.datamodel.BOOKING_TYPE.BOOKING_TYPE_COMPLETED
                r10 = r2
                r10.invoke((com.travel.booking.datamodel.BOOKING_TYPE) r11, (java.lang.String) r12, (java.util.List<com.travel.booking.datamodel.BookingInfo>) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16)
                com.travel.booking.datamodel.BOOKING_TYPE r18 = com.travel.booking.datamodel.BOOKING_TYPE.BOOKING_TYPE_CANCELLED
                r17 = r2
                r19 = r1
                r17.invoke((com.travel.booking.datamodel.BOOKING_TYPE) r18, (java.lang.String) r19, (java.util.List<com.travel.booking.datamodel.BookingInfo>) r20, (java.lang.String) r21, (java.lang.String) r22, (java.lang.String) r23)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.booking.model.CJRTravelBookingModel.Companion.formatAPIResponse(android.content.Context, com.travel.booking.datamodel.TravelBookingListInfo):java.util.List");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0160, code lost:
            r0 = r8.getFlightBookingInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void formatBookingInfo(android.content.Context r7, com.travel.booking.datamodel.BookingInfo r8, com.travel.booking.datamodel.BOOKING_TYPE r9) {
            /*
                r6 = this;
                java.lang.String r0 = r8.getArrivalDate()
                java.lang.String r1 = r8.getDepartureDate()
                r2 = r6
                com.travel.booking.model.CJRTravelBookingModel$Companion r2 = (com.travel.booking.model.CJRTravelBookingModel.Companion) r2
                java.util.Date r3 = r2.getCurrentdate()
                if (r3 != 0) goto L_0x001d
                java.util.Date r3 = new java.util.Date
                long r4 = java.lang.System.currentTimeMillis()
                r3.<init>(r4)
                r2.setCurrentdate(r3)
            L_0x001d:
                com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$1 r3 = new com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$1
                r3.<init>(r8)
                com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$2 r4 = com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$2.INSTANCE
                java.text.SimpleDateFormat r4 = r2.getInputDateTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.text.SimpleDateFormat r5 = r2.getOutputDateFormat()
                java.text.DateFormat r5 = (java.text.DateFormat) r5
                java.lang.String r4 = r3.invoke((java.lang.String) r1, (java.text.DateFormat) r4, (java.text.DateFormat) r5)
                r8.setFormattedDepartureDate(r4)
                java.text.SimpleDateFormat r4 = r2.getInputDateTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.text.SimpleDateFormat r5 = r2.getOutputTimeFormat()
                java.text.DateFormat r5 = (java.text.DateFormat) r5
                java.lang.String r1 = r3.invoke((java.lang.String) r1, (java.text.DateFormat) r4, (java.text.DateFormat) r5)
                r8.setFormattedDepartureTime(r1)
                java.text.SimpleDateFormat r1 = r2.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                java.text.SimpleDateFormat r4 = r2.getOutputDateFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setFormattedArrivalDate(r1)
                java.text.SimpleDateFormat r1 = r2.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                java.text.SimpleDateFormat r2 = r2.getOutputTimeFormat()
                java.text.DateFormat r2 = (java.text.DateFormat) r2
                java.lang.String r0 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r2)
                r8.setFormattedArrivalTime(r0)
                if (r8 == 0) goto L_0x0081
                com.travel.booking.datamodel.BusBookingInfo r0 = r8.getBusBookingInfo()
                if (r0 == 0) goto L_0x0081
                java.lang.String r0 = r0.getDuration()
                if (r0 == 0) goto L_0x0081
                r8.setFormattedDuration(r0)
            L_0x0081:
                com.travel.booking.datamodel.TrainBookingInfo r0 = r8.getTrainBookingInfo()
                if (r0 == 0) goto L_0x00a6
                java.util.List r0 = r0.getSeats()
                if (r0 == 0) goto L_0x00a6
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.travel.R.string.raw_mybooking_row_seat
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r0 = com.travel.utils.e.a((java.lang.String) r1, (java.util.List<java.lang.String>) r0)
                android.text.Spanned r0 = com.travel.utils.e.b(r0)
                java.lang.String r0 = r0.toString()
                r8.setFormattedSeatInfo(r0)
            L_0x00a6:
                com.travel.booking.datamodel.BusBookingInfo r0 = r8.getBusBookingInfo()
                if (r0 == 0) goto L_0x00cb
                java.util.List r0 = r0.getSeats()
                if (r0 == 0) goto L_0x00cb
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.travel.R.string.raw_mybooking_row_seat
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r0 = com.travel.utils.e.a((java.lang.String) r1, (java.util.List<java.lang.String>) r0)
                android.text.Spanned r0 = com.travel.utils.e.b(r0)
                java.lang.String r0 = r0.toString()
                r8.setFormattedSeatInfo(r0)
            L_0x00cb:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x00f6
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getOnwardInfo()
                if (r0 == 0) goto L_0x00f6
                java.util.List r0 = r0.getSeats()
                if (r0 == 0) goto L_0x00f6
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.travel.R.string.raw_mybooking_row_seat
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r0 = com.travel.utils.e.a((java.lang.String) r1, (java.util.List<java.lang.String>) r0)
                android.text.Spanned r0 = com.travel.utils.e.b(r0)
                java.lang.String r0 = r0.toString()
                r8.setFormattedSeatInfo(r0)
            L_0x00f6:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x0121
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getReturnInfo()
                if (r0 == 0) goto L_0x0121
                java.util.List r0 = r0.getSeats()
                if (r0 == 0) goto L_0x0121
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.travel.R.string.raw_mybooking_row_seat
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r0 = com.travel.utils.e.a((java.lang.String) r1, (java.util.List<java.lang.String>) r0)
                android.text.Spanned r0 = com.travel.utils.e.b(r0)
                java.lang.String r0 = r0.toString()
                r8.setFormattedSeatInfo(r0)
            L_0x0121:
                com.travel.booking.datamodel.TrainBookingInfo r0 = r8.getTrainBookingInfo()
                if (r0 == 0) goto L_0x013e
                java.lang.String r0 = r0.getPnrNumber()
                if (r0 == 0) goto L_0x013e
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.travel.R.string.raw_pnr_row_seat
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r0 = com.travel.utils.e.a((java.lang.String) r1, (java.lang.String) r0)
                r8.setFormattedPNR(r0)
            L_0x013e:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                r1 = 0
                if (r0 == 0) goto L_0x0176
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getOnwardInfo()
                if (r0 == 0) goto L_0x0176
                java.lang.String r0 = r0.getAirline_name()
                if (r0 == 0) goto L_0x0176
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = " "
                r2.append(r0)
                if (r8 == 0) goto L_0x016b
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x016b
                java.lang.String r0 = r0.getOnwardFlight()
                goto L_0x016c
            L_0x016b:
                r0 = r1
            L_0x016c:
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r8.setFormattedAirlinenameandCode(r0)
            L_0x0176:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                r2 = 32
                if (r0 == 0) goto L_0x01ab
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getReturnInfo()
                if (r0 == 0) goto L_0x01ab
                java.lang.String r0 = r0.getAirline_name()
                if (r0 == 0) goto L_0x01ab
                if (r8 == 0) goto L_0x0196
                com.travel.booking.datamodel.FlightBookingInfo r4 = r8.getFlightBookingInfo()
                if (r4 == 0) goto L_0x0196
                java.lang.String r1 = r4.getReturnFlight()
            L_0x0196:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                r4.append(r2)
                r4.append(r1)
                java.lang.String r0 = r4.toString()
                r8.setReturnformattedAirlinenameandCode(r0)
            L_0x01ab:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x01eb
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getReturnInfo()
                if (r0 == 0) goto L_0x01eb
                java.lang.String r0 = r0.getDeparture_time_airport()
                if (r0 == 0) goto L_0x01eb
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputDateFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setReturnformattedDepartureDate(r1)
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r0 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setReturnformattedDepartureTime(r0)
            L_0x01eb:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x022b
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getReturnInfo()
                if (r0 == 0) goto L_0x022b
                java.lang.String r0 = r0.getArrival_time_airport()
                if (r0 == 0) goto L_0x022b
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputDateFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setReturnformattedArrivalDate(r1)
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r0 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setReturnformattedArrivalTime(r0)
            L_0x022b:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x026b
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getOnwardInfo()
                if (r0 == 0) goto L_0x026b
                java.lang.String r0 = r0.getDeparture_time_airport()
                if (r0 == 0) goto L_0x026b
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputDateFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setFormattedDepartureDate(r1)
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r0 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setFormattedDepartureTime(r0)
            L_0x026b:
                com.travel.booking.datamodel.FlightBookingInfo r0 = r8.getFlightBookingInfo()
                if (r0 == 0) goto L_0x02c9
                com.travel.booking.datamodel.FlightTravelInfo r0 = r0.getOnwardInfo()
                if (r0 == 0) goto L_0x02c9
                java.lang.String r0 = r0.getArrival_time_airport()
                if (r0 == 0) goto L_0x02c9
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputDateFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setFormattedArrivalDate(r1)
                com.travel.booking.model.CJRTravelBookingModel$Companion r1 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r1 = r1.getInputDateTimeFormat()
                java.text.DateFormat r1 = (java.text.DateFormat) r1
                com.travel.booking.model.CJRTravelBookingModel$Companion r4 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.text.SimpleDateFormat r4 = r4.getOutputTimeFormat()
                java.text.DateFormat r4 = (java.text.DateFormat) r4
                java.lang.String r1 = r3.invoke((java.lang.String) r0, (java.text.DateFormat) r1, (java.text.DateFormat) r4)
                r8.setFormattedArrivalTime(r1)
                com.travel.booking.datamodel.BOOKING_TYPE r1 = com.travel.booking.datamodel.BOOKING_TYPE.BOOKING_TYPE_UPCOMING
                if (r9 != r1) goto L_0x02c9
                com.travel.booking.model.CJRTravelBookingModel$Companion r9 = com.travel.booking.model.CJRTravelBookingModel.Companion
                java.util.Date r1 = r9.getCurrentdate()
                com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$2 r3 = com.travel.booking.model.CJRTravelBookingModel$Companion$formatBookingInfo$2.INSTANCE
                java.lang.String r4 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                java.util.Date r0 = r3.invoke((java.lang.String) r0, (java.lang.String) r4)
                boolean r9 = r9.isDatePassed(r1, r0)
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                r8.setIsdatePassed(r9)
            L_0x02c9:
                if (r8 == 0) goto L_0x030c
                com.travel.booking.datamodel.CityBusBookingInfo r9 = r8.getCityBusBookingInfo()
                if (r9 == 0) goto L_0x030c
                java.lang.Integer r9 = r9.getPassengerCount()
                if (r9 == 0) goto L_0x030c
                java.lang.Number r9 = (java.lang.Number) r9
                int r9 = r9.intValue()
                com.travel.booking.datamodel.CityBusBookingInfo r0 = r8.getCityBusBookingInfo()
                if (r0 == 0) goto L_0x030c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r9)
                r1.append(r2)
                r2 = 1
                if (r9 <= r2) goto L_0x02f8
                android.content.res.Resources r9 = r7.getResources()
                int r2 = com.travel.R.string.passengers
                goto L_0x02fe
            L_0x02f8:
                android.content.res.Resources r9 = r7.getResources()
                int r2 = com.travel.R.string.city_bus_label_passenger
            L_0x02fe:
                java.lang.String r9 = r9.getString(r2)
                r1.append(r9)
                java.lang.String r9 = r1.toString()
                r0.setFormattedPassengerCount(r9)
            L_0x030c:
                if (r8 == 0) goto L_0x0340
                com.travel.booking.datamodel.CityBusBookingInfo r9 = r8.getCityBusBookingInfo()
                if (r9 == 0) goto L_0x0340
                java.lang.String r9 = r9.getTotalAmount()
                if (r9 == 0) goto L_0x0340
                com.travel.booking.datamodel.CityBusBookingInfo r8 = r8.getCityBusBookingInfo()
                if (r8 == 0) goto L_0x0340
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                android.content.res.Resources r7 = r7.getResources()
                int r1 = com.travel.R.string.city_bus_symbol_rupee
                java.lang.String r7 = r7.getString(r1)
                r0.append(r7)
                java.lang.String r7 = com.paytm.utility.b.x((java.lang.String) r9)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                r8.setFormattedTotalAmount(r7)
            L_0x0340:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.booking.model.CJRTravelBookingModel.Companion.formatBookingInfo(android.content.Context, com.travel.booking.datamodel.BookingInfo, com.travel.booking.datamodel.BOOKING_TYPE):void");
        }

        public final void fetchBookingData(Context context, IBookingDataListener iBookingDataListener) {
            k.c(context, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            k.c(iBookingDataListener, "listener");
            if (b.c(context)) {
                fireApiCall(context, iBookingDataListener);
            } else {
                iBookingDataListener.onNetworkError();
            }
        }

        private final void fireApiCall(Context context, IBookingDataListener iBookingDataListener) {
            r.a aVar = r.f28551a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "app.applicationContext");
            String b2 = r.a.a(applicationContext).b("userId", "", true);
            k.a((Object) d.a(), "TravelController.getInstance()");
            String f2 = d.b().f();
            HashMap hashMap = new HashMap();
            b.a((HashMap<String, String>) hashMap, context);
            String uri = Uri.parse(f2).buildUpon().appendQueryParameter("userId", b2).build().toString();
            k.a((Object) uri, "Uri.parse(baseUrl)\n     …              .toString()");
            a l = new com.paytm.network.b().a(context).a(a.b.SILENT).c(context.getClass().getSimpleName()).a(a.c.FLIGHT).a(a.C0715a.GET).a(uri).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new TravelBookingListInfo()).a((com.paytm.network.listener.b) new APIListener(context, iBookingDataListener)).a(e.a("MyBookingsPage")).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }

        public final boolean isDatePassed(Date date, Date date2) {
            return (date2 == null || date == null || date.getTime() <= date2.getTime()) ? false : true;
        }
    }

    static final class APIListener implements com.paytm.network.listener.b {
        private final Context app;
        private final IBookingDataListener bookingDataListener;

        public APIListener(Context context, IBookingDataListener iBookingDataListener) {
            k.c(context, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            k.c(iBookingDataListener, "bookingDataListener");
            this.app = context;
            this.bookingDataListener = iBookingDataListener;
        }

        public final Context getApp() {
            return this.app;
        }

        public final IBookingDataListener getBookingDataListener() {
            return this.bookingDataListener;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NetworkError || networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NoConnectionError) {
                this.bookingDataListener.onNetworkError();
            } else {
                this.bookingDataListener.onApiError(i2, networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof TravelBookingListInfo) {
                this.bookingDataListener.onDataFetch(CJRTravelBookingModel.Companion.formatAPIResponse(this.app, (TravelBookingListInfo) iJRPaytmDataModel));
            } else {
                this.bookingDataListener.onApiError(200, (NetworkCustomError) null);
            }
        }
    }
}
