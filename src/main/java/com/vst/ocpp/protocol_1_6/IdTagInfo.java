package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;

import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

/**
 * Contains status information about an identifier. It is returned in
 * {@link AuthorizeResponse}, {@link StartTransactionResponse} and
 * {@link StopTransactionResponse} responses.
 *
 * <p>
 * If expiryDate is not given, the status has no end date.
 */
@NoArgsConstructor
public class IdTagInfo {

	private static final int PARENT_ID_MAX_LENGTH = 20;

	private ZonedDateTime expiryDate;
	private String parentIdTag;
	private AuthorizationStatus status;

	public IdTagInfo(ZonedDateTime expiryDate, String parentIdTag, AuthorizationStatus status) {
		this(status);
		setExpiryDate(expiryDate);
		setParentIdTag(parentIdTag);
	}

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link AuthorizationStatus} for IdTag, see
	 *               {@link #setStatus(AuthorizationStatus)}
	 */
	public IdTagInfo(AuthorizationStatus status) {
		setStatus(status);
	}

	/**
	 * This contains the date at which idTag should be removed from the
	 * Authorization Cache.
	 *
	 * @return Expiry date.
	 */
	public ZonedDateTime getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Optional. This contains the date at which idTag should be removed from the
	 * Authorization Cache.
	 *
	 * @param expiryDate ZonedDateTime, expire date.
	 */
	public void setExpiryDate(ZonedDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * This contains the parent-identifier.
	 *
	 * @return the IdToken of the parent.
	 */
	public String getParentIdTag() {
		return parentIdTag;
	}

	/**
	 * Optional. This contains the parent-identifier.
	 *
	 * @param parentIdTag an IdToken. max 25 characters, case insensitive.
	 * 
	 */
	public void setParentIdTag(String parentIdTag) {

		if (!Utils.validate(parentIdTag, PARENT_ID_MAX_LENGTH)) {
			throw new InvalidLengthException(parentIdTag.length(), Utils.createErrorMessage(PARENT_ID_MAX_LENGTH));
		}
		this.parentIdTag = parentIdTag;
	}

	/**
	 * This contains whether the idTag has been accepted or not by the Central
	 * System.
	 *
	 * @return the {@link AuthorizationStatus} for IdTag.
	 */
	public AuthorizationStatus getStatus() {
		return status;
	}

	/**
	 * Required. This contains whether the idTag has been accepted or not by the
	 * Central System.
	 *
	 * @param status the {@link AuthorizationStatus} for IdTag.
	 */
	public void setStatus(AuthorizationStatus status) {
		this.status = status;
	}

}
