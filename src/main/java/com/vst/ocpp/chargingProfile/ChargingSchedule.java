package com.vst.ocpp.chargingProfile;

import java.time.ZonedDateTime;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChargingSchedule {

	private Integer duration;
	private ZonedDateTime startSchedule;
	private ChargingRateUnitType chargingRateUnit;
	private List<ChargingSchedulePeriod> chargingSchedulePeriod;
	private Double minChargingRate;

	public ChargingSchedule(ChargingRateUnitType chargingRateUnit,
			List<ChargingSchedulePeriod> chargingSchedulePeriod) {

		setChargingRateUnit(chargingRateUnit);
		setChargingSchedulePeriod(chargingSchedulePeriod);
	}

	public ChargingSchedule(Integer duration, ZonedDateTime startSchedule, ChargingRateUnitType chargingRateUnit,
			List<ChargingSchedulePeriod> chargingSchedulePeriod, Double minChargingRate) {

		this(chargingRateUnit, chargingSchedulePeriod);
		setDuration(duration);
		setStartSchedule(startSchedule);
		setMinChargingRate(minChargingRate);
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ZonedDateTime getStartSchedule() {
		return startSchedule;
	}

	public void setStartSchedule(ZonedDateTime startSchedule) {
		this.startSchedule = startSchedule;
	}

	public ChargingRateUnitType getChargingRateUnit() {
		return chargingRateUnit;
	}

	public void setChargingRateUnit(ChargingRateUnitType chargingRateUnit) {
		this.chargingRateUnit = chargingRateUnit;
	}

	public JsonArray getChargingSchedulePeriod() {

		JsonArray jsonArray = new JsonArray();

		for (int i = 0; i < chargingSchedulePeriod.size(); i++) {

			JsonObject chargingSchedulePeriodObject = new JsonObject();

			if (chargingSchedulePeriod.get(i).getStartPeriod() != null) {
				chargingSchedulePeriodObject.addProperty("startPeriod", chargingSchedulePeriod.get(i).getStartPeriod());
			}
			if (chargingSchedulePeriod.get(i).getLimit() != null) {
				chargingSchedulePeriodObject.addProperty("limit", chargingSchedulePeriod.get(i).getLimit());
			}
			chargingSchedulePeriodObject.addProperty("numberPhases", chargingSchedulePeriod.get(i).getNumberPhases());

			jsonArray.add(chargingSchedulePeriodObject);

		}
		return jsonArray;

	}

	public void setChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
		this.chargingSchedulePeriod = chargingSchedulePeriod;
	}

	public Double getMinChargingRate() {
		return minChargingRate;
	}

	public void setMinChargingRate(Double minChargingRate) {
		this.minChargingRate = minChargingRate;
	}

}
