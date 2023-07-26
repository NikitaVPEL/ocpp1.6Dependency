package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingprofile.ChargingRateUnitType;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the the Central System to the Charge Point. */
@Slf4j
@NoArgsConstructor
public class GetCompositeScheduleRequest {

	private Integer connectorId;
	private Integer duration;
	private ChargingRateUnitType chargingRateUnit;

	public GetCompositeScheduleRequest(Integer connectorId, Integer duration, ChargingRateUnitType chargingRateUnit) {
		this(connectorId, duration);
		setChargingRateUnit(chargingRateUnit);
	}

	  /**
	   * Handle required fields.
	   *
	   * @param connectorId Integer, see {@link #setConnectorId(Integer)}
	   * @param duration Integer, see {@link #setDuration(Integer)}
	   */
	public GetCompositeScheduleRequest(Integer connectorId, Integer duration) {
		setConnectorId(connectorId);
		setDuration(duration);
	}

	  /**
	   * The ID of the Connector for which the schedule is requested. When ConnectorId=0, the Charge
	   * Point will calculate the expected consumption for the grid connection.
	   *
	   * @return ID of the connector.
	   */
	public Integer getConnectorId() {
		return connectorId;
	}

	  /**
	   * Required. The ID of the Connector for which the schedule is requested. When ConnectorId=0, the
	   * Charge Point will calculate the expected consumption for the grid connection.
	   *
	   * @param connectorId Integer
	   */
	public void setConnectorId(Integer connectorId) {
	    if (connectorId == null || connectorId < 0) {
	        throw new InvalidDataException(connectorId, "connectorId must be >= 0");
	      }
		this.connectorId = connectorId;
	}

	  /**
	   * Time in seconds. length of requested schedule
	   *
	   * @return length of requested schedule
	   */
	public Integer getDuration() {
		return duration;
	}

	  /**
	   * Required. Time in seconds. length of requested schedule
	   *
	   * @param duration Integer
	   */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	  /**
	   * Can be used to force a power or current profile
	   *
	   * @return current profile
	   */
	public ChargingRateUnitType getChargingRateUnit() {
		return chargingRateUnit;
	}

	  /**
	   * Optional. Can be used to force a power or current profile
	   *
	   * @param chargingRateUnit the {@link ChargingRateUnitType}
	   */
	public void setChargingRateUnit(ChargingRateUnitType chargingRateUnit) {
		this.chargingRateUnit = chargingRateUnit;
	}

	/**
	 * use this method to generate json string of {@link GetCompositeScheduleRequest}
	 * 
	 * @return string of {@link GetCompositeScheduleRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}
}
