package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;

import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdTagInfo {

	Utils utils = new Utils();
	private static final int PARENT_ID_MAX_LENGTH = 20;

	private ZonedDateTime expiryDate;
	private String parentIdTag;
	private AuthorizationStatus status;

	public ZonedDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(ZonedDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getParentIdTag() {
		return parentIdTag;
	}

	public void setParentIdTag(String parentIdTag) {

		if (!utils.validate(parentIdTag, PARENT_ID_MAX_LENGTH)) {
			throw new InvalidLengthException(parentIdTag.length(), utils.createErrorMessage(PARENT_ID_MAX_LENGTH));
		}
		this.parentIdTag = parentIdTag;
	}

	public AuthorizationStatus getStatus() {
		return status;
	}

	public void setStatus(AuthorizationStatus status) {
		this.status = status;
	}

	public IdTagInfo(ZonedDateTime expiryDate, String parentIdTag, AuthorizationStatus status) {
		this(status);
		setExpiryDate(expiryDate);
		setParentIdTag(parentIdTag);
	}

	public IdTagInfo(AuthorizationStatus status) {
		setStatus(status);
	}

}
