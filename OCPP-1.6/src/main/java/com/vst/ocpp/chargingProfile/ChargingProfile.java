package com.vst.ocpp.chargingProfile;

import java.time.ZonedDateTime;

import com.google.gson.JsonObject;

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

	public Integer getChargingProfileId() {
		return chargingProfileId;
	}

	public void setChargingProfileId(Integer chargingProfileId) {
		this.chargingProfileId = chargingProfileId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getStackLevel() {
		return stackLevel;
	}

	public void setStackLevel(Integer stackLevel) {
		this.stackLevel = stackLevel;
	}

	public ChargingProfilePurposeType getChargingProfilePurpose() {
		return chargingProfilePurpose;
	}

	public void setChargingProfilePurpose(ChargingProfilePurposeType chargingProfilePurpose) {
		this.chargingProfilePurpose = chargingProfilePurpose;
	}

	public ChargingProfileKindType getChargingProfileKind() {
		return chargingProfileKind;
	}

	public void setChargingProfileKind(ChargingProfileKindType chargingProfileKind) {
		this.chargingProfileKind = chargingProfileKind;
	}

	public RecurrencyKindType getRecurrencyKind() {
		return recurrencyKind;
	}

	public void setRecurrencyKind(RecurrencyKindType recurrencyKind) {
		this.recurrencyKind = recurrencyKind;
	}

	public ZonedDateTime getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(ZonedDateTime validFrom) {
		this.validFrom = validFrom;
	}

	public ZonedDateTime getValidTo() {
		return validTo;
	}

	public void setValidTo(ZonedDateTime validTo) {
		this.validTo = validTo;
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

}
