package com.vst.ocpp.testprotocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingprofile.ChargingSchedule;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
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

	/**
	 * Handle required fields.
	 *
	 * @param status {@link GetCompositeScheduleStatus}, see
	 *               {@link #setStatus(GetCompositeScheduleStatus)}
	 */
	public GetCompositeScheduleResponse(GetCompositeScheduleStatus status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);
	}

	/**
	 * Status of the request. The Charge Point will indicate if it was able to
	 * process the request
	 *
	 * @return status of the request
	 */
	public GetCompositeScheduleStatus getStatus() {
		return status;
	}

	/**
	 * Required. Status of the request. The Charge Point will indicate if it was
	 * able to process the request
	 *
	 * @param status {@link GetCompositeScheduleStatus}
	 */
	public void setStatus(GetCompositeScheduleStatus status) {
		this.status = status;
	}

	/**
	 * The charging schedule contained in this notification applies to a Connector.
	 *
	 * @return Integer ID of the connector
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Optional. The charging schedule contained in this notification applies to a
	 * Connector.
	 *
	 * @param connectorId Integer
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId != null) {
			this.connectorId = connectorId;
		}
	}

	/**
	 * Time. Periods contained in the charging profile are relative to this point in
	 * time. If status is "Rejected", this field may be absent.
	 *
	 * @return {@link ZonedDateTime} start of the schedule
	 */
	public ZonedDateTime getScheduleStart() {
		return scheduleStart;
	}

	/**
	 * Optional. Time. Periods contained in the charging profile are relative to
	 * this point in time. If status is "Rejected", this field may be absent.
	 *
	 * @param scheduleStart {@link ZonedDateTime}
	 */
	public void setScheduleStart(ZonedDateTime scheduleStart) {
		if (scheduleStart != null) {
			this.scheduleStart = scheduleStart;
		}
	}

	/**
	 * Planned Composite Charging Schedule, the energy consumption over time. Always
	 * relative to ScheduleStart. If status is "Rejected", this field may be absent.
	 *
	 * @return {@link ChargingSchedule} planned charging schedule
	 */
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

	/**
	 * Optional. Planned Composite Charging Schedule, the energy consumption over
	 * time. Always relative to ScheduleStart. If status is "Rejected", this field
	 * may be absent.
	 *
	 * @param chargingSchedule {@link ChargingSchedule}
	 */
	public void setChargingSchedule(ChargingSchedule chargingSchedule) {
		if (chargingSchedule != null) {
			this.chargingSchedule = chargingSchedule;
		}
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	/**
	 * use this method to generate json string of
	 * {@link GetCompositeScheduleResponse}
	 *
	 * @return string of {@link GetCompositeScheduleResponse}
	 */
	public String toJson() {

		Integer messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());
		if (connectorId != null) {
			jsonObject.addProperty("connectorId", connectorId);
		}
		if (scheduleStart != null) {
			jsonObject.addProperty("scheduleStart", scheduleStart.toString());
		}
		if (chargingSchedule != null) {
			jsonObject.add("chargingSchedule", getChargingSchedule());
		}
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}
}
