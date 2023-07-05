package com.vst.ocpp.testProtocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingProfile.ChargingSchedule;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetCompositeScheduleResponse {

	private GetCompositeScheduleStatus status;
	private Integer connectorId;
	private ZonedDateTime scheduleStart;
	private ChargingSchedule chargingSchedule;
	private String messageIdKey;

	public GetCompositeScheduleResponse(GetCompositeScheduleStatus status, Integer connectorId,
			ZonedDateTime scheduleStart, ChargingSchedule chargingSchedule, String messageIdKey) {

		this(status, messageIdKey);
		setConnectorId(connectorId);
		setScheduleStart(scheduleStart);
		setChargingSchedule(chargingSchedule);
	}

	public GetCompositeScheduleResponse(GetCompositeScheduleStatus status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);
	}

	public GetCompositeScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(GetCompositeScheduleStatus status) {
		this.status = status;
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public ZonedDateTime getScheduleStart() {
		return scheduleStart;
	}

	public void setScheduleStart(ZonedDateTime scheduleStart) {
		this.scheduleStart = scheduleStart;
	}

	public JsonObject getChargingSchedule() {

		JsonObject chargingScheduleObject = new JsonObject();

		if (chargingSchedule.getDuration() != null) {
			chargingScheduleObject.addProperty("duration", chargingSchedule.getDuration());
		}

		if (chargingSchedule.getStartSchedule() != null) {
			chargingScheduleObject.addProperty("startSchedule", chargingSchedule.getStartSchedule().toString());
		}

		chargingScheduleObject.addProperty("chargingRateUnit", chargingSchedule.getChargingRateUnit().toString());

		chargingScheduleObject.add("chargingSchedulePeriod", chargingSchedule.getChargingSchedulePeriod());

		if (chargingSchedule.getMinChargingRate() != null) {
			chargingScheduleObject.addProperty("minChargingRate", chargingSchedule.getMinChargingRate());
		}

		return chargingScheduleObject;
	}

	public void setChargingSchedule(ChargingSchedule chargingSchedule) {
		this.chargingSchedule = chargingSchedule;
	}

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	public String toJson() {

		Integer messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());
		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("scheduleStart", scheduleStart.toString());
		jsonObject.add("chargingSchedule", getChargingSchedule());
		
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}
}
