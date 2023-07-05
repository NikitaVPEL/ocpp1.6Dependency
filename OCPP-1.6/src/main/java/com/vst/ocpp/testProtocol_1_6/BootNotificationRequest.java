package com.vst.ocpp.testProtocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

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

	public BootNotificationRequest(String chargePointVendor, String chargePointModel) {
		setChargePointVendor(chargePointVendor);
		setChargePointModel(chargePointModel);
	}

	public String getChargePointVendor() {
		return chargePointVendor;
	}

	public void setChargePointVendor(String chargePointVendor) {
		if (!Utils.validate(chargePointVendor, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargePointVendor.length(),
					Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		this.chargePointVendor = chargePointVendor;
	}

	public String getChargePointModel() {
		return chargePointModel;
	}

	public void setChargePointModel(String chargePointModel) {
		if (!Utils.validate(chargePointModel, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargePointModel.length(),
					Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		this.chargePointModel = chargePointModel;
	}

	public String getChargeBoxSerialNumber() {
		return chargeBoxSerialNumber;
	}

	public void setChargeBoxSerialNumber(String chargeBoxSerialNumber) {
		
		if (chargeBoxSerialNumber!=null) {
		if (!Utils.validate(chargeBoxSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargeBoxSerialNumber.length(),
					Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
		}
		}
		this.chargeBoxSerialNumber = chargeBoxSerialNumber;
	}

	public String getChargePointSerialNumber() {
		return chargePointSerialNumber;
	}

	public void setChargePointSerialNumber(String chargePointSerialNumber) {
		
		if (chargePointSerialNumber!=null) {
		if (!Utils.validate(chargePointSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(chargePointSerialNumber.length(),
					Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
		}
		}
		this.chargePointSerialNumber = chargePointSerialNumber;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		
		if (firmwareVersion!=null) {
		if (!Utils.validate(firmwareVersion, STRING_50_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(firmwareVersion.length(),
					Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
		}
		}
		this.firmwareVersion = firmwareVersion;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		
		if (iccid!=null) {
		if (!Utils.validate(iccid, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(iccid.length(), Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		}
		this.iccid = iccid;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		
		if (imsi!=null) {
		if (!Utils.validate(imsi, STRING_20_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(imsi.length(), Utils.createErrorMessage(STRING_20_CHAR_MAX_LENGTH));
		}
		}
		this.imsi = imsi;
	}

	public String getMeterSerialNumber() {
		return meterSerialNumber;
	}

	public void setMeterSerialNumber(String meterSerialNumber) {
		
		if (meterSerialNumber!=null) {
		if (!Utils.validate(meterSerialNumber, STRING_25_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(meterSerialNumber.length(),
					Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
		}
		}
		this.meterSerialNumber = meterSerialNumber;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
	
		if (meterType!=null) {
		if (!Utils.validate(meterType, STRING_25_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(meterType.length(), Utils.createErrorMessage(STRING_25_CHAR_MAX_LENGTH));
		}
		}
		this.meterType = meterType;
	}

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

		return jsonArray.toString();
	}

}
