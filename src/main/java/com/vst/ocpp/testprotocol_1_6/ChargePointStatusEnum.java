package com.vst.ocpp.testprotocol_1_6;

/** Accepted values used with {@link StatusNotificationRequest} */
public enum ChargePointStatusEnum {
	  Available,
	  Preparing,
	  Charging,
	  SuspendedEVSE,
	  SuspendedEV,
	  Finishing,
	  Reserved,
	  Unavailable,
	  Faulted
}
