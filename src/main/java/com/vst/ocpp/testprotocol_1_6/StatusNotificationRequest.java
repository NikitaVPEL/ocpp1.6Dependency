package com.vst.ocpp.testprotocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@NoArgsConstructor
@Slf4j
public class StatusNotificationRequest {

	private static final int MAX_50_LENGTH = 50;
	private static final int MAX_255_LENGTH = 255;

	private Integer connectorId;
	private ChargePointErrorCodeEnum errorCode;
	private String info;
	private ChargePointStatusEnum status;
	private ZonedDateTime timestamp;
	private String vendorId;
	private String vendorErrorCode;

	public StatusNotificationRequest(Integer connectorId, ChargePointErrorCodeEnum errorCode, String info,
			ChargePointStatusEnum status, ZonedDateTime timestamp, String vendorId, String vendorErrorCode) {
		this(connectorId, errorCode, status);
		setInfo(info);
		setTimestamp(timestamp);
		setVendorId(vendorId);
		setVendorErrorCode(vendorErrorCode);
	}

	/**
	 * Handle required fields.
	 *
	 * @param connectorId integer, connector id. 0 = main controller, see
	 *                    {@link #setConnectorId(Integer)}
	 * @param errorCode   the {@link ChargePointErrorCodeEnum}, see
	 *                    {@link #setErrorCode(ChargePointErrorCodeEnum)}
	 * @param status      the {@link ChargePointStatusEnum}, see
	 *                    {@link #setStatus(ChargePointStatusEnum)}
	 */
	public StatusNotificationRequest(Integer connectorId, ChargePointErrorCodeEnum errorCode,
			ChargePointStatusEnum status) {
		setConnectorId(connectorId);
		setErrorCode(errorCode);
		setStatus(status);
	}

	/**
	 * The id of the connector for which the status is reported. Id '0' (zero) is
	 * used if the status is for the Charge Point main controller.
	 *
	 * @return connector id. 0 = main controller.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. The id of the connector for which the status is reported. Id '0'
	 * (zero) is used if the status is for the Charge Point main controller.
	 *
	 * @param connectorId integer, connector id. 0 = main controller.
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId == null || connectorId <= 0) {
			throw new InvalidDataException(connectorId, "connectorId must be greater or equal to 0");
		}
		this.connectorId = connectorId;
	}

	/**
	 * This contains the error code reported by the Charge Point.
	 *
	 * @return the {@link ChargePointErrorCodeEnum}.
	 */
	public ChargePointErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	/**
	 * Required. This contains the error code reported by the Charge Point.
	 *
	 * @param errorCode the {@link ChargePointErrorCodeEnum}.
	 */
	public void setErrorCode(ChargePointErrorCodeEnum errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Additional free format information related to the error.
	 *
	 * @return Additional information.
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Optional. Additional free format information related to the error.
	 *
	 * @param info String, max 50 characters, case insensitive.
	 */
	public void setInfo(String info) {
		if (info != null) {
			if (!Utils.validate(info, MAX_50_LENGTH)) {
				throw new InvalidLengthException(info.length(), Utils.createErrorMessage(MAX_50_LENGTH));
			}
			this.info = info;
		}
	}

	/**
	 * This contains the current status of the Charge Point.
	 *
	 * @return the {@link ChargePointStatusEnum}.
	 */
	public ChargePointStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This contains the current status of the Charge Point.
	 *
	 * @param status the {@link ChargePointStatusEnum}.
	 */
	public void setStatus(ChargePointStatusEnum status) {
		this.status = status;
	}

	/**
	 * The time for which the status is reported. If absent time of receipt of the
	 * message will be assumed.
	 *
	 * @return status time.
	 */
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Optional. The time for which the status is reported. If absent time of
	 * receipt of the message will be assumed.
	 *
	 * @param timestamp ZonedDateTime, status time.
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
		if (timestamp != null) {
			this.timestamp = timestamp;
		}
	}

	/**
	 * This identifies the vendor-specific implementation.
	 *
	 * @return Identification of the vendor.
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * Optional. This identifies the vendor-specific implementation.
	 *
	 * @param vendorId String, max 255 characters, case insensitive.
	 */
	public void setVendorId(String vendorId) {
		if (vendorId != null) {
			if (!Utils.validate(vendorId, MAX_255_LENGTH)) {
				throw new InvalidLengthException(vendorId.length(), Utils.createErrorMessage(MAX_255_LENGTH));
			}
			this.vendorId = vendorId;
		}
	}

	/**
	 * This contains the vendor-specific error code.
	 *
	 * @return Custom vendor error code.
	 */
	public String getVendorErrorCode() {
		return vendorErrorCode;
	}

	/**
	 * Optional. This contains the vendor-specific error code.
	 *
	 * @param vendorErrorCode String, max 50 characters, case insensitive.
	 */
	public void setVendorErrorCode(String vendorErrorCode) {
		if (vendorErrorCode != null) {
			if (!Utils.validate(vendorErrorCode, MAX_50_LENGTH)) {
				throw new InvalidLengthException(vendorErrorCode.length(), Utils.createErrorMessage(MAX_50_LENGTH));
			}
			this.vendorErrorCode = vendorErrorCode;
		}
	}

	/**
	 * use this method to generate json string of {@link StatusNotificationRequest}
	 * 
	 * @return string of {@link StatusNotificationRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("errorCode", errorCode.toString());

		if (info != null) {
			jsonObject.addProperty("info", info);
		}

		jsonObject.addProperty("status", status.toString());

		if (timestamp != null) {
			jsonObject.addProperty("timestamp", timestamp.toString());
		}
		if (vendorId != null) {
			jsonObject.addProperty("vendorId", vendorId);
		}
		if (vendorErrorCode != null) {
			jsonObject.addProperty("vendorErrorCode", vendorErrorCode);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("StatusNotification");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
