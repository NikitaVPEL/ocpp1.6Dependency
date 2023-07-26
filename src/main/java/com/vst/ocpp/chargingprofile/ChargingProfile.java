package com.vst.ocpp.chargingprofile;

import java.time.ZonedDateTime;

import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChargingProfile {

	private Integer chargingProfileId;
	private Integer transactionId;
	private Integer stackLevel;
	private ChargingProfilePurposeType chargingProfilePurpose;
	private ChargingProfileKindType chargingProfileKind;
	private RecurrencyKindType recurrencyKind;
	private ZonedDateTime validFrom;
	private ZonedDateTime validTo;
	private ChargingSchedule chargingSchedule;

	/**
	 * Handle required values
	 *
	 * @param chargingProfileId      Integer, see
	 *                               {@link #setChargingProfileId(Integer)}
	 * @param stackLevel             Integer, see {@link #setStackLevel(Integer)}
	 * @param chargingProfilePurpose the {@link ChargingProfilePurposeType}, see
	 *                               {@link #setChargingProfilePurpose(ChargingProfilePurposeType)}
	 * @param chargingProfileKind    the {@link ChargingProfileKindType}, see
	 *                               {@link #setChargingProfileKind(ChargingProfileKindType)}
	 * @param chargingSchedule       the {@link ChargingSchedule}, see
	 *                               {@link #setChargingSchedule(ChargingSchedule)}
	 */
	public ChargingProfile(Integer chargingProfileId, Integer stackLevel,
			ChargingProfilePurposeType chargingProfilePurpose, ChargingProfileKindType chargingProfileKind,
			ChargingSchedule chargingSchedule) {

		setChargingProfileId(chargingProfileId);
		setStackLevel(stackLevel);
		setChargingProfilePurpose(chargingProfilePurpose);
		setChargingProfileKind(chargingProfileKind);
		setChargingSchedule(chargingSchedule);
	}

	public ChargingProfile(Integer chargingProfileId, Integer transactionId, Integer stackLevel,
			ChargingProfilePurposeType chargingProfilePurpose, ChargingProfileKindType chargingProfileKind,
			RecurrencyKindType recurrencyKind, ZonedDateTime validFrom, ZonedDateTime validTo,
			ChargingSchedule chargingSchedule) {

		this(chargingProfileId, stackLevel, chargingProfilePurpose, chargingProfileKind, chargingSchedule);
		setTransactionId(transactionId);
		setRecurrencyKind(recurrencyKind);
		setValidFrom(validFrom);
		setValidTo(validTo);

	}

	/**
	 * Unique identifier for this profile
	 *
	 * @return identifier for this profile
	 */
	public Integer getChargingProfileId() {
		return chargingProfileId;
	}

	/**
	 * Required. Unique identifier for this profile
	 *
	 * @param chargingProfileId Integer
	 */
	public void setChargingProfileId(Integer chargingProfileId) {
		if (chargingProfileId == null) {
			throw new InvalidDataException(null, "chargingProfileId must be present");
		}
		this.chargingProfileId = chargingProfileId;
	}

	/**
	 * Only valid if ChargingProfilePurpose is set to TxProfile, the transactionId
	 * MAY be used to match the profile to a specific transaction.
	 *
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * Optional. Only valid if ChargingProfilePurpose is set to TxProfile, the
	 * transactionId MAY be used to match the profile to a specific transaction.
	 *
	 * @param transactionId Integer
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Value determining level in hierarchy stack of profiles. Higher values have
	 * precedence over lower values. Lowest level is 0.
	 *
	 * @return level in hierarchy stack of profiles
	 */
	public Integer getStackLevel() {
		return stackLevel;
	}

	/**
	 * Required. Value determining level in hierarchy stack of profiles. Higher
	 * values have precedence over lower values. Lowest level is 0.
	 *
	 * @param stackLevel Integer
	 */
	public void setStackLevel(Integer stackLevel) {
		this.stackLevel = stackLevel;
	}

	/**
	 * Unique identifier for this profile.
	 *
	 * @return identifier for this profile
	 */
	public ChargingProfilePurposeType getChargingProfilePurpose() {
		return chargingProfilePurpose;
	}

	/**
	 * Required. Unique identifier for this profile.
	 *
	 * @param chargingProfilePurpose the {@link ChargingProfilePurposeType}
	 */

	public void setChargingProfilePurpose(ChargingProfilePurposeType chargingProfilePurpose) {
		this.chargingProfilePurpose = chargingProfilePurpose;
	}

	/**
	 * Indicates the kind of schedule.
	 *
	 * @return kind of schedule
	 */
	public ChargingProfileKindType getChargingProfileKind() {
		return chargingProfileKind;
	}

	/**
	 * Required. Indicates the kind of schedule
	 *
	 * @param chargingProfileKind the {@link ChargingProfileKindType}
	 */
	public void setChargingProfileKind(ChargingProfileKindType chargingProfileKind) {
		this.chargingProfileKind = chargingProfileKind;
	}

	/**
	 * Indicates the start point of a recurrence.
	 *
	 * @return start point of a recurrency
	 */
	public RecurrencyKindType getRecurrencyKind() {
		return recurrencyKind;
	}

	/**
	 * Required. Indicates the kind of schedule.
	 *
	 * @param recurrencyKind the {@link RecurrencyKindType}
	 */
	public void setRecurrencyKind(RecurrencyKindType recurrencyKind) {
		this.recurrencyKind = recurrencyKind;
	}

	/**
	 * Point in time at which the profile starts to be valid. If absent, the profile
	 * is valid as soon as it is received by the Charge Point.
	 *
	 * @return Point in time at which the profile starts to be valid
	 */
	public ZonedDateTime getValidFrom() {
		return validFrom;
	}

	/**
	 * Optional. Point in time at which the profile starts to be valid. If absent,
	 * the profile is valid as soon as it is received by the Charge Point.
	 *
	 * @param validFrom the {@link ZonedDateTime}
	 */
	public void setValidFrom(ZonedDateTime validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * Point in time at which the profile stops to be valid. If absent, the profile
	 * is valid until it is replaced by another profile
	 *
	 * @return Point in time at which the profile stops to be valid
	 */
	public ZonedDateTime getValidTo() {
		return validTo;
	}

	/**
	 * Optional. Point in time at which the profile stops to be valid. If absent,
	 * the profile is valid until it is replaced by another profile
	 *
	 * @param validTo the {@link ZonedDateTime}
	 */
	public void setValidTo(ZonedDateTime validTo) {
		this.validTo = validTo;
	}

	/**
	 * Contains limits for the available power or current over time.
	 *
	 * @return charging schedule
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
	 * Required. Contains limits for the available power or current over time.
	 *
	 * @param chargingSchedule the {@link ChargingSchedule}
	 */
	public void setChargingSchedule(ChargingSchedule chargingSchedule) {
		this.chargingSchedule = chargingSchedule;
	}

}
