package com.vst.ocpp.chargingProfile;

import java.time.format.DateTimeFormatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class ChargingSchedulePeriod {

	private Integer startPeriod;
	private Double limit;
	private Integer numberPhases = 3;

	public ChargingSchedulePeriod(Integer startPeriod, Double limit) {

		setStartPeriod(startPeriod);
		setLimit(limit);
	}

	public ChargingSchedulePeriod(Integer startPeriod, Double limit, Integer numberPhases) {

		this(startPeriod, limit);
		setNumberPhases(numberPhases);
	}

}
