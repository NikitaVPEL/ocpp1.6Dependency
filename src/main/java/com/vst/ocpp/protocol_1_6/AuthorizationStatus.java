package com.vst.ocpp.protocol_1_6;

/**
 * Accepted values {@link IdTagInfo} for {@link AuthorizeResponse}.
 *
 * @see IdTagInfo
 */
public enum AuthorizationStatus {
	  Accepted,
	  Blocked,
	  Expired,
	  Invalid,
	  ConcurrentTx
	}
