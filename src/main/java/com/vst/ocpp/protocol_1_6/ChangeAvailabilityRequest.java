package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Central System to the Charge Point. */
@NoArgsConstructor
@Slf4j
public class ChangeAvailabilityRequest {

	private Integer connectorId = -1;
	private AvailabilityType type;

	/**
	 * Handle required fields.
	 *
	 * @param connectorId integer, must be a non-negative number.
	 * @param type        the {@link AvailabilityType} of the connector, see
	 *                    {@link #setType(AvailabilityType)}
	 */
	public ChangeAvailabilityRequest(Integer connectorId, AvailabilityType type) {
		setConnectorId(connectorId);
		setType(type);
	}

	/**
	 * The id of the connector for which availability needs to change. Id '0' (zero)
	 * is used if the availability of the Charge Point and all its connectors needs
	 * to change.
	 *
	 * @return identification of the connector. 0 = all.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. The id of the connector for which availability needs to change. Id
	 * '0' (zero) is used if the availability of the Charge Point and all its
	 * connectors needs to change.
	 *
	 * @param connectorId integer, must be a non-negative number.
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId < 0) {
			throw new InvalidDataException(connectorId, "connectorId must be >= 0");
		}
		this.connectorId = connectorId;
	}

	  /**
	   * This contains the type of availability change that the Charge Point should perform.
	   *
	   * @return {@link AvailabilityType} of the connector.
	   */
	public AvailabilityType getType() {
		return type;
	}

	  /**
	   * Required. This contains the type of availability change that the Charge Point should perform.
	   *
	   * @param type {@link AvailabilityType} of the connector
	   */
	public void setType(AvailabilityType type) {
		this.type = type;
	}

	/**
	 * use this method to generate json string of {@link ChangeAvailabilityRequest}
	 * 
	 * @return string of {@link ChangeAvailabilityRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("type", type.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ChangeAvailability");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
