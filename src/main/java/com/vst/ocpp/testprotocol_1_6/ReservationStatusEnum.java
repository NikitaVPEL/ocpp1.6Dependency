package com.vst.ocpp.testprotocol_1_6;

import com.vst.ocpp.protocol_1_6.ReserveNowRequest;

/** Accepted values used with {@link ReserveNowRequest} */
public enum ReservationStatusEnum {
	Accepted, Faulted, Occupied, Rejected, Unavailable
}
