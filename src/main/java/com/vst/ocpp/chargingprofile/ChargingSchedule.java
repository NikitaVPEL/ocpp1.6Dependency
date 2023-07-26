package com.vst.ocpp.chargingprofile;

import java.time.ZonedDateTime;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

/** Class type used with {@link ChargingProfile} */
@NoArgsConstructor
public class ChargingSchedule {

	private Integer duration;
	private ZonedDateTime startSchedule;
	private ChargingRateUnitType chargingRateUnit;
	private List<ChargingSchedulePeriod> chargingSchedulePeriod;
	private Double minChargingRate;

	/**
	 * Handle required fields.
	 *
	 * @param chargingRateUnit       the {@link ChargingRateUnitType}, see
	 *                               {@link #setChargingRateUnit(ChargingRateUnitType)}
	 * @param chargingSchedulePeriod array of {@link ChargingSchedulePeriod}, see
	 *                               {@link #setChargingSchedulePeriod(ChargingSchedulePeriod[])}
	 */
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

	/**
	 * Duration of the charging schedule in seconds.
	 *
	 * @return duration in seconds.
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Optional. Duration of the charging schedule in seconds. If the duration is
	 * left empty, the last period will continue indefinitely or until end of the
	 * transaction in case startSchedule is absent.
	 *
	 * @param duration integer, duration in seconds.
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Starting point of an absolute schedule.
	 *
	 * @return start time.
	 */
	public ZonedDateTime getStartSchedule() {
		return startSchedule;
	}

	/**
	 * Optional. Starting point of an absolute schedule. If absent the schedule will
	 * be relative to start of charging.
	 *
	 * @param startSchedule ZonedDateTime, start time.
	 */
	public void setStartSchedule(ZonedDateTime startSchedule) {
		this.startSchedule = startSchedule;
	}

	/**
	 * The unit of measure Limit is expressed in.
	 *
	 * @return the {@link ChargingRateUnitType}.
	 */
	public ChargingRateUnitType getChargingRateUnit() {
		return chargingRateUnit;
	}

	/**
	 * Required. The unit of measure Limit is expressed in.
	 *
	 * @param chargingRateUnit the {@link ChargingRateUnitType}.
	 */
	public void setChargingRateUnit(ChargingRateUnitType chargingRateUnit) {
		this.chargingRateUnit = chargingRateUnit;
	}

	/**
	 * List of ChargingSchedulePeriod elements defining maximum power or current
	 * usage over time.
	 *
	 * @return array of {@link ChargingSchedulePeriod}.
	 */
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

	/**
	 * Required. List of ChargingSchedulePeriod elements defining maximum power or
	 * current usage over time.
	 *
	 * @param chargingSchedulePeriod array of {@link ChargingSchedulePeriod}.
	 */
	public void setChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
		this.chargingSchedulePeriod = chargingSchedulePeriod;
	}

	/**
	 * Minimum charging rate supported by the electric vehicle. The unit of measure
	 * is defined by {@link #getChargingRateUnit()}.
	 *
	 * @return min charge rate.
	 */
	public Double getMinChargingRate() {
		return minChargingRate;
	}

	/**
	 * Optional. Minimum charging rate supported by the electric vehicle. The unit
	 * of measure is defined by {@link #getChargingRateUnit()}. This parameter is
	 * intended to be used by a local smart charging algorithm to optimize the power
	 * allocation for in the case a charging process is inefficient at lower
	 * charging rates. Accepts at most one digit fraction (e.g. 8.1)
	 *
	 * @param minChargingRate decimal, min charge rate.
	 */
	public void setMinChargingRate(Double minChargingRate) {
		this.minChargingRate = minChargingRate;
	}

}
