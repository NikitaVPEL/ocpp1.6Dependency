package com.vst.ocpp.chargingprofile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChargingSchedulePeriod {

	private Integer startPeriod;
	private Double limit;
	private Integer numberPhases = 3;

	/**
	 * Handle required fields.
	 *
	 * @param startPeriod integer, seconds from start of schedule, see
	 *                    {@link #setStartPeriod(Integer)}
	 * @param limit       decimal, power limit, see {@link #setLimit(Double)}
	 */
	public ChargingSchedulePeriod(Integer startPeriod, Double limit) {

		setStartPeriod(startPeriod);
		setLimit(limit);
	}

	public ChargingSchedulePeriod(Integer startPeriod, Double limit, Integer numberPhases) {

		this(startPeriod, limit);
		setNumberPhases(numberPhases);
	}

}
