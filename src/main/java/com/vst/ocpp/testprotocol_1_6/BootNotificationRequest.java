package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@Slf4j
@NoArgsConstructor
public class BootNotificationRequest {

	private static final int STRING_20_CHAR_MAX_LENGTH = 20;
	private static final int STRING_25_CHAR_MAX_LENGTH = 25;
	private static final int STRING_50_CHAR_MAX_LENGTH = 50;

	private String chargePointVendor;
	private String chargePointModel;
	private String chargeBoxSerialNumber;
	private String chargePointSerialNumber;
	private String firmwareVersion;
	private String iccid;
	private String imsi;
	private String meterSerialNumber;
	private String meterType;

	public BootNotificationRequest(String chargePointVendor, String chargePointModel, String chargeBoxSerialNumber,
			String chargePointSerialNumber, String firmwareVersion, String iccid, String imsi, String meterSerialNumber,
			String meterType) {
		this(chargePointVendor, chargePointModel);
		setChargeBoxSerialNumber(chargeBoxSerialNumber);
		setChargePointSerialNumber(chargePointSerialNumber);
		setFirmwareVersion(firmwareVersion);
		setIccid(iccid);
		setImsi(imsi);
		setMeterSerialNumber(meterSerialNumber);
		setMeterType(meterType);
	}

	/**
	 * Handle required fields.
	 *
	 * @param chargePointVendor Charge Point vendor, see
	 *                          {@link #setChargePointVendor(String)}.
	 * @param chargePointModel  Charge Point model, see
	 *                          {@link #setChargePointModel(String)}.
	 */
	public BootNotificationRequest(String chargePointVendor, String chargePointModel) {
		setChargePointVendor(chargePointVendor);
		setChargePointModel(chargePointModel);
	}

	/**
	 * This contains a value that identifies the vendor of the ChargePoint.
	 *
	 * @return Vendor of the Charge Point.
	 */
	public String getChargePointVendor() {
		return chargePointVendor;
	}

	/**
	 * Required. This contains a value that identifies the vendor of the
	 * ChargePoint.
	 *
	 * @param chargePointVendor String, max 20 characters, case insensitive.
	 */
	public void setChargePointVendor(String chargePointVendor) {
		if (!Utils.validate(chargePointVendor, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargePointVendor.length(),
					Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		this.chargePointVendor = chargePointVendor;
	}

	/**
	 * This contains a value that identifies the model of the ChargePoint.
	 *
	 * @return Model of the Charge Point.
	 */
	public String getChargePointModel() {
		return chargePointModel;
	}

	/**
	 * Required. This contains a value that identifies the model of the ChargePoint.
	 *
	 * @param chargePointModel String, max 20 characters, case insensitive.
	 */
	public void setChargePointModel(String chargePointModel) {
		if (!Utils.validate(chargePointModel, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargePointModel.length(),
					Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		this.chargePointModel = chargePointModel;
	}

	/**
	 * This contains a value that identifies the serial number of the Charge Box
	 * inside the Charge Point.
	 *
	 * @return Serial Number of the Charge Point. will be removed in future version.
	 *         See {@link #getChargeBoxSerialNumber()}.
	 */
	public String getChargeBoxSerialNumber() {
		return chargeBoxSerialNumber;
	}

	/**
	 * Optional. This contains a value that identifies the serial number of the
	 * Charge Box inside the Charge Point.
	 *
	 * @param chargeBoxSerialNumber String, max 25 characters, case insensitive.
	 *                              will be removed in future version. See
	 *                              {@link #setChargePointSerialNumber(String)}.
	 */
	public void setChargeBoxSerialNumber(String chargeBoxSerialNumber) {

		if (chargeBoxSerialNumber != null) {
			if (!Utils.validate(chargeBoxSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(chargeBoxSerialNumber.length(),
						Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
			}
			this.chargeBoxSerialNumber = chargeBoxSerialNumber;
		}
	}

	/**
	 * This contains a value that identifies the serial number of the Charge Point.
	 *
	 * @return Serial Number of the Charge Point.
	 */
	public String getChargePointSerialNumber() {
		return chargePointSerialNumber;
	}

	/**
	 * Optional. This contains a value that identifies the serial number of the
	 * Charge Point.
	 *
	 * @param chargePointSerialNumber String, max 25 characters, case insensitive.
	 */
	public void setChargePointSerialNumber(String chargePointSerialNumber) {

		if (chargePointSerialNumber != null) {
			if (!Utils.validate(chargePointSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(chargePointSerialNumber.length(),
						Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
			}
			this.chargePointSerialNumber = chargePointSerialNumber;
		}
	}

	/**
	 * This contains the firmware version of the Charge Point.
	 *
	 * @return Firmware version of Charge Point.
	 */
	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	/**
	 * Optional. This contains the firmware version of the Charge Point.
	 *
	 * @param firmwareVersion String, max 50 characters, case insensitive.
	 */
	public void setFirmwareVersion(String firmwareVersion) {

		if (firmwareVersion != null) {
			if (!Utils.validate(firmwareVersion, STRING_50_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(firmwareVersion.length(),
						Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
			}
			this.firmwareVersion = firmwareVersion;
		}
	}

	/**
	 * This contains the ICCID of the modem’s SIM card.
	 *
	 * @return ICCID of SIM card.
	 */
	public String getIccid() {
		return iccid;
	}

	/**
	 * Optional. This contains the ICCID of the modem’s SIM card.
	 *
	 * @param iccid String, max 20 characters, case insensitive.
	 */
	public void setIccid(String iccid) {

		if (iccid != null) {
			if (!Utils.validate(iccid, STRING_20_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(iccid.length(), Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
			}
			this.iccid = iccid;
		}
	}

	/**
	 * This contains the IMSI of the modem’s SIM card.
	 *
	 * @return IMSI of SIM card.
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * Optional. This contains the IMSI of the modem’s SIM card.
	 *
	 * @param imsi String, max 20 characters, case insensitive.
	 */
	public void setImsi(String imsi) {

		if (imsi != null) {
			if (!Utils.validate(imsi, STRING_20_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(imsi.length(), Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
			}
			this.imsi = imsi;
		}
	}

	/**
	 * This contains the serial number of the main power meter of the Charge Point.
	 *
	 * @return Serial number of the meter.
	 */
	public String getMeterSerialNumber() {
		return meterSerialNumber;
	}

	/**
	 * Optional. This contains the serial number of the main power meter of the
	 * Charge Point.
	 *
	 * @param meterSerialNumber String, max 25 characters, case insensitive.
	 */
	public void setMeterSerialNumber(String meterSerialNumber) {

		if (meterSerialNumber != null) {
			if (!Utils.validate(meterSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(meterSerialNumber.length(),
						Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
			}
			this.meterSerialNumber = meterSerialNumber;
		}
	}

	/**
	 * This contains the type of the main power meter of the Charge Point.
	 *
	 * @return Type of main power meter.
	 */
	public String getMeterType() {
		return meterType;
	}

	/**
	 * Optional. This contains the type of the main power meter of the Charge Point.
	 *
	 * @param meterType String, max 25 characters, case insensitive.
	 */
	public void setMeterType(String meterType) {

		if (meterType != null) {
			if (!Utils.validate(meterType, STRING_25_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(meterType.length(),
						Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
			}
			this.meterType = meterType;
		}
	}

	/**
	 * use this method to generate json string
	 * 
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("chargePointVendor", chargePointVendor);
		jsonObject.addProperty("chargePointModel", chargePointModel);

		if (chargeBoxSerialNumber != null) {
			jsonObject.addProperty("chargeBoxSerialNumber", chargeBoxSerialNumber);
		}

		if (chargePointSerialNumber != null) {
			jsonObject.addProperty("chargePointSerialNumber", chargePointSerialNumber);
		}

		if (firmwareVersion != null) {
			jsonObject.addProperty("firmwareVersion", firmwareVersion);
		}

		if (iccid != null) {
			jsonObject.addProperty("iccid", iccid);
		}

		if (imsi != null) {
			jsonObject.addProperty("imsi", imsi);
		}

		if (meterSerialNumber != null) {
			jsonObject.addProperty("meterSerialNumber", meterSerialNumber);
		}

		if (meterType != null) {
			jsonObject.addProperty("meterType", meterType);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("BootNotification");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
