package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingProfile.ChargingRateUnitType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetCompositeScheduleRequest {

	private Integer connectorId;
	private Integer duration;
	private ChargingRateUnitType chargingRateUnit;

	public GetCompositeScheduleRequest(Integer connectorId, Integer duration, ChargingRateUnitType chargingRateUnit) {
		this(connectorId, duration);
		setChargingRateUnit(chargingRateUnit);
	}

	public GetCompositeScheduleRequest(Integer connectorId, Integer duration) {
		setConnectorId(connectorId);
		setDuration(duration);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ChargingRateUnitType getChargingRateUnit() {
		return chargingRateUnit;
	}

	public void setChargingRateUnit(ChargingRateUnitType chargingRateUnit) {
		this.chargingRateUnit = chargingRateUnit;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("duration", duration);
		
		if (chargingRateUnit!=null) {
		jsonObject.addProperty("chargingRateUnit", chargingRateUnit.toString());
		}
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("GetCompositeSchedule");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}
}
