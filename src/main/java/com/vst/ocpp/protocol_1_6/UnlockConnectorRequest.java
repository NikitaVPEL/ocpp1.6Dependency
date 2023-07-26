package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Central System to the Charge Point. */
@Slf4j
@NoArgsConstructor
public class UnlockConnectorRequest {

	private Integer connectorId;

	/**
	 * Handle required fields.
	 *
	 * @param connectorId integer, value &gt; 0, see
	 *                    {@link #setConnectorId(Integer)}
	 */
	public UnlockConnectorRequest(Integer connectorId) {
		setConnectorId(connectorId);
	}

	/**
	 * Required. This contains the identifier of the connector to be unlocked.
	 *
	 * @param connectorId integer, value &gt; 0.
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId == null || connectorId <= 0) {
			throw new InvalidLengthException(connectorId, "connectorId must be > 0");
		}
		this.connectorId = connectorId;
	}

	/**
	 * This contains the identifier of the connector to be unlocked.
	 *
	 * @return connector.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link UnlockConnectorRequest}
	 */
	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("connectorId", connectorId);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("UnlockConnector");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}
}
