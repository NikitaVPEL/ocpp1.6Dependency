package com.vst.ocpp.controller;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.ocpp.chargingProfile.ChargingProfile;
import com.vst.ocpp.chargingProfile.ChargingProfilePurposeType;
import com.vst.ocpp.chargingProfile.ChargingRateUnitType;
import com.vst.ocpp.chargingProfile.ChargingSchedule;
import com.vst.ocpp.protocol_1_6.AuthorizationStatus;
import com.vst.ocpp.protocol_1_6.AuthorizeResponse;
import com.vst.ocpp.protocol_1_6.AvailabilityType;
import com.vst.ocpp.protocol_1_6.BootNotificationResponse;
import com.vst.ocpp.protocol_1_6.CancelReservationRequest;
import com.vst.ocpp.protocol_1_6.ChangeAvailabilityRequest;
import com.vst.ocpp.protocol_1_6.ChangeConfigurationRequest;
import com.vst.ocpp.protocol_1_6.ClearCacheRequest;
import com.vst.ocpp.protocol_1_6.ClearChargingProfileRequest;
import com.vst.ocpp.protocol_1_6.DataTransferRequest;
import com.vst.ocpp.protocol_1_6.DataTransferResponse;
import com.vst.ocpp.protocol_1_6.DataTransferStatus;
import com.vst.ocpp.protocol_1_6.DiagnosticsStatusNotificationResponse;
import com.vst.ocpp.protocol_1_6.FirmwareStatusNotificationResponse;
import com.vst.ocpp.protocol_1_6.GetCompositeScheduleRequest;
import com.vst.ocpp.protocol_1_6.GetConfigurationRequest;
import com.vst.ocpp.protocol_1_6.GetDiagnosticsRequest;
import com.vst.ocpp.protocol_1_6.GetLocalListVersionRequest;
import com.vst.ocpp.protocol_1_6.HeartbeatResponse;
import com.vst.ocpp.protocol_1_6.IdTagInfo;
import com.vst.ocpp.protocol_1_6.LocalAuthorizationList;
import com.vst.ocpp.protocol_1_6.MeterValuesResponse;
import com.vst.ocpp.protocol_1_6.RegistrationStatus;
import com.vst.ocpp.protocol_1_6.RemoteStartTransactionRequest;
import com.vst.ocpp.protocol_1_6.RemoteStopTransactionRequest;
import com.vst.ocpp.protocol_1_6.ReserveNowRequest;
import com.vst.ocpp.protocol_1_6.ResetRequest;
import com.vst.ocpp.protocol_1_6.ResetType;
import com.vst.ocpp.protocol_1_6.SendLocalListRequest;
import com.vst.ocpp.protocol_1_6.SetChargingProfileRequest;
import com.vst.ocpp.protocol_1_6.StartTransactionResponse;
import com.vst.ocpp.protocol_1_6.StatusNotificationResponse;
import com.vst.ocpp.protocol_1_6.StopTransactionResponse;
import com.vst.ocpp.protocol_1_6.TriggerMessageRequest;
import com.vst.ocpp.protocol_1_6.TriggerMessageRequestType;
import com.vst.ocpp.protocol_1_6.UpdateFirmwareRequest;
import com.vst.ocpp.protocol_1_6.UpdateType;
import com.vst.ocpp.testProtocol_1_6.AuthorizeRequest;
import com.vst.ocpp.testProtocol_1_6.AvailabilityStatusEnum;
import com.vst.ocpp.testProtocol_1_6.BootNotificationRequest;
import com.vst.ocpp.testProtocol_1_6.CancelReservationResponse;
import com.vst.ocpp.testProtocol_1_6.CancelReservationStatusEnum;
import com.vst.ocpp.testProtocol_1_6.ChangeAvailabilityResponse;
import com.vst.ocpp.testProtocol_1_6.ChangeConfigurationResponse;
import com.vst.ocpp.testProtocol_1_6.ClearCacheResponse;
import com.vst.ocpp.testProtocol_1_6.ClearCacheStatusEnum;
import com.vst.ocpp.testProtocol_1_6.ClearChargingProfileResponse;
import com.vst.ocpp.testProtocol_1_6.ClearChargingProfileStatusEnum;
import com.vst.ocpp.testProtocol_1_6.ConfigurationStatusEnum;
import com.vst.ocpp.testProtocol_1_6.DiagnosticsStatus;
import com.vst.ocpp.testProtocol_1_6.DiagnosticsStatusNotificationRequest;
import com.vst.ocpp.testProtocol_1_6.FirmwareStatus;
import com.vst.ocpp.testProtocol_1_6.FirmwareStatusNotificationRequest;
import com.vst.ocpp.testProtocol_1_6.GetCompositeScheduleResponse;
import com.vst.ocpp.testProtocol_1_6.GetCompositeScheduleStatus;
import com.vst.ocpp.testProtocol_1_6.GetConfigurationResponse;
import com.vst.ocpp.testProtocol_1_6.GetDiagnosticsResponse;
import com.vst.ocpp.testProtocol_1_6.GetLocalListVersionResponse;
import com.vst.ocpp.testProtocol_1_6.HeartbeatRequest;
import com.vst.ocpp.testProtocol_1_6.KeyValueType;
import com.vst.ocpp.testProtocol_1_6.MeterValue;
import com.vst.ocpp.testProtocol_1_6.MeterValuesRequest;
import com.vst.ocpp.testProtocol_1_6.RemoteStartStopStatusEnum;
import com.vst.ocpp.testProtocol_1_6.RemoteStartTransactionResponse;

@RestController
public class ControllerClass {



//-------------------------------------------------------------------------------------------------------------------------------------------------
		
	@GetMapping("/authorizeRequest")
	public String authorizeRequest(@RequestParam("idTag") String idTag) {
		
		AuthorizeRequest authorizeRequest = new AuthorizeRequest(idTag);
		return authorizeRequest.toJson();
	}

	@GetMapping("/authorizeResponse")
	public String authorizeResponse(@RequestBody IdTagInfo idTagInfo) {

		AuthorizeResponse authorizeResponse = new AuthorizeResponse(idTagInfo, "key");
		return authorizeResponse.toJson();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------

@GetMapping("/bootNotificationRequest")
	public String bootNotificationRequest(@RequestParam("chargePointVendor") String chargePointVendor,
			@RequestParam(value = "chargePointModel") String chargePointModel,
			@RequestParam(value = "chargeBoxSerialNumber") String chargeBoxSerialNumber,
			@RequestParam(value = "chargePointSerialNumber", required = false) String chargePointSerialNumber,
			@RequestParam(value = "firmwareVersion", required = false) String firmwareVersion,
			@RequestParam(value = "iccid", required = false) String iccid,
			@RequestParam(value = "imsi", required = false) String imsi,
			@RequestParam(value = "meterSerialNumber", required = false) String meterSerialNumber,
			@RequestParam(value = "meterType", required = false) String meterType) {

		BootNotificationRequest request = new BootNotificationRequest();

		request.setChargePointVendor(chargePointVendor);
		request.setChargePointModel(chargePointModel);
		request.setChargeBoxSerialNumber(chargeBoxSerialNumber);
		request.setChargePointSerialNumber(chargePointSerialNumber);
		request.setFirmwareVersion(firmwareVersion);
		request.setIccid(iccid);
		request.setImsi(imsi);
		request.setMeterSerialNumber(meterSerialNumber);
		request.setMeterType(meterType);

		return request.toJson();
	}	


@GetMapping("/bootNotificationResponse")
	public String bootNotificationResponse(@RequestParam("currentTime") ZonedDateTime time,
			@RequestParam("interval") int interval, @RequestParam("status") RegistrationStatus status) {

		BootNotificationResponse bootNotificationResponse = new BootNotificationResponse(time, interval, status, "key");
		return bootNotificationResponse.toJson();
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
@GetMapping("/cancelReservationRequest")
	public String cancelReservationRequest(@RequestParam("reservationId") Integer reservationId) {

		CancelReservationRequest cancelReservationRequest = new CancelReservationRequest(reservationId);
		return cancelReservationRequest.toJson();
	}


@GetMapping("/cancelReservationResponse")
	public String cancelReservationResponse(@RequestParam CancelReservationStatusEnum status) {

		CancelReservationResponse cancelReservationResponse = new CancelReservationResponse(status, "key");
		return cancelReservationResponse.toJson();
	}

//-----------------------------------------------------------------------------------------------------------------------------------------

@GetMapping("/changeAvailabilityRequest")
	public String changeAvailabilityRequest(@RequestParam("connectorId") Integer connectorId,
			@RequestParam("type") AvailabilityType type) {

		ChangeAvailabilityRequest changeAvailabilityRequest = new ChangeAvailabilityRequest(connectorId, type);

		return changeAvailabilityRequest.toJson();
	}


@GetMapping("/changeAvailabilityResponse")
	public String changeAvailabilityResponse(@RequestParam("status") AvailabilityStatusEnum status) {
		
		ChangeAvailabilityResponse changeAvailabilityResponse = new ChangeAvailabilityResponse(status, "key");
		return changeAvailabilityResponse.toJson();
	}

//----------------------------------------------------------------------------------------------------------------------------------------	

	@GetMapping("/changeConfigurationRequest")
	public String changeConfigurationRequest(@RequestParam("key") String key, @RequestParam("value") String value) {

		ChangeConfigurationRequest changeConfigurationRequest = new ChangeConfigurationRequest(key, value);
		return changeConfigurationRequest.toJson();
	}


@GetMapping("/changeConfigurationResponse")
	public String changeConfigurationResponse(@RequestParam("status") ConfigurationStatusEnum status) {
		
		ChangeConfigurationResponse changeConfigurationResponse = new ChangeConfigurationResponse(status, "key");
		return changeConfigurationResponse.toJson();
	}

//----------------------------------------------------------------------------------------------------------------------------------------

@GetMapping("/clearCacheRequest")
	public String clearCacheRequest() {

		ClearCacheRequest cancelReservationRequest = new ClearCacheRequest();
		return cancelReservationRequest.toJson();
	}

@GetMapping("/clearCacheResponse")
	public String clearCacheResponse(@RequestParam("status") ClearCacheStatusEnum status) {

		ClearCacheResponse clearCacheResponse = new ClearCacheResponse(status,"key");
		return clearCacheResponse.toJson();
	}

//------------------------------------------------------------------------------------------------------------------------------------------


@GetMapping("/clearChargingProfileRequest")
	public String clearChargingProfileRequest(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "connectorId", required = false) Integer connectorId,
			@RequestParam(value = "chargingProfilePurpose", required = false) ChargingProfilePurposeType chargingProfilePurpose,
			@RequestParam(value = "stackLevel", required = false) Integer stackLevel) {

		ClearChargingProfileRequest clearChargingProfileRequest = new ClearChargingProfileRequest(id, connectorId, chargingProfilePurpose, stackLevel);
		return clearChargingProfileRequest.toJson();
	}	


	@GetMapping("/clearChargingProfileResponse")
	public String clearChargingProfileResponse(@RequestParam("status") ClearChargingProfileStatusEnum status) {
		
		ClearChargingProfileResponse clearChargingProfileResponse = new ClearChargingProfileResponse(status,"key");
		return clearChargingProfileResponse.toJson();
	}


//-------------------------------------------------------------------------------------------------------------------------------------
@GetMapping("/dataTransferRequest")
	public String dataTransferRequest(@RequestParam(value = "vendorId") String vendorId,
			@RequestParam(value = "messageId", required = false) String messageId,
			@RequestParam(value = "data", required = false) String data) {

		DataTransferRequest dataTransferRequest = new DataTransferRequest(vendorId, messageId, data);
		return dataTransferRequest.toJson();
	}

	@GetMapping("/dataTransferResponse")
	public String dataTransferResponse(@RequestParam(value = "status") DataTransferStatus status,
			@RequestParam(value = "data", required = false) String data) {

		DataTransferResponse dataTransferResponse = new DataTransferResponse(status,data,"key");
		return dataTransferResponse.toJson();
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/diagnosticsStatusNotificationRequest")
	public String diagnosticsStatusNotificationRequest(@RequestParam("status") DiagnosticsStatus status) {
		
		DiagnosticsStatusNotificationRequest diagnosticsStatusNotificationRequest = new DiagnosticsStatusNotificationRequest(status);
		return diagnosticsStatusNotificationRequest.toJson();
	}


	@GetMapping("/diagnosticsStatusNotificationResponse")
	public String diagnosticsStatusNotificationResponse() {

		DiagnosticsStatusNotificationResponse diagnosticsStatusNotificationResponse = new DiagnosticsStatusNotificationResponse(
				"key");
		return diagnosticsStatusNotificationResponse.toJson();
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	@GetMapping("/firmwareStatusNotificationRequest")
	public String firmwareStatusNotificationRequest(@RequestParam("status") FirmwareStatus status) {
		
		FirmwareStatusNotificationRequest firmwareStatusNotificationRequest = new FirmwareStatusNotificationRequest(status);
		return firmwareStatusNotificationRequest.toJson();
	}


@GetMapping("/firmwareStatusNotificationResponse")
	public String firmwareStatusNotificationResponse() {

		FirmwareStatusNotificationResponse firmwareStatusNotificationResponse = new FirmwareStatusNotificationResponse(
				"key");
		return firmwareStatusNotificationResponse.toJson();
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/getCompositeScheduleResponse")
	public String getCompositeScheduleResponse(@RequestParam("status") GetCompositeScheduleStatus status,
			@RequestParam(value = "connectorId", required = false) Integer connectorId,
			@RequestParam(value = "scheduleStart", required = false) ZonedDateTime scheduleStart,
			@RequestBody(required = false) ChargingSchedule chargingSchedule) {

		GetCompositeScheduleResponse getCompositeScheduleResponse = new GetCompositeScheduleResponse(status,
				connectorId, scheduleStart, chargingSchedule, "key");
		return getCompositeScheduleResponse.toJson();
	}


	@GetMapping("/getCompositeScheduleRequest")
	public String getCompositeScheduleRequest(@RequestParam(value = "connectorId") Integer connectorId,
			@RequestParam(value = "duration") Integer duration,
			@RequestParam(value = "chargingRateUnit", required = false) ChargingRateUnitType chargingRateUnit) {

		GetCompositeScheduleRequest getCompositeScheduleRequest = new GetCompositeScheduleRequest(connectorId,duration,chargingRateUnit);
		return getCompositeScheduleRequest.toJson();
	}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/getConfigurationRequest")
	public String getConfigurationRequest(@RequestParam("key")String[] key) {

		GetConfigurationRequest getConfigurationRequest = new GetConfigurationRequest(key);
		return getConfigurationRequest.toJson();
	}


	@GetMapping("/getConfigurationResponse")
	public String getConfigurationResponse(@RequestBody(required = false) KeyValueType[] keyValueType,
			@RequestParam(value = "unknownKey", required = false) String[] unknownKey) {

		GetConfigurationResponse getConfigurationResponse = new GetConfigurationResponse(keyValueType, unknownKey, "key");
		return getConfigurationResponse.toJson();
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		@GetMapping("/getDiagnosticsRequest")
	public String getDiagnosticsRequest(@RequestParam(value = "location") String location,
			@RequestParam(value = "retries", required = false) Integer retries,
			@RequestParam(value = "retryInterval", required = false) Integer retryInterval,
			@RequestParam(value = "startTime", required = false) ZonedDateTime startTime,
			@RequestParam(value = "stopTime", required = false) ZonedDateTime stopTime) {

		GetDiagnosticsRequest getDiagnosticsRequest = new GetDiagnosticsRequest(location,retries,retryInterval,startTime,stopTime);
		return getDiagnosticsRequest.toJson();
	}

		@GetMapping("/getDiagnosticsResponse")
	public String getDiagnosticsResponse(@RequestParam(value = "fileName", required = false) String fileName) {
		
		GetDiagnosticsResponse getDiagnosticsResponse = new GetDiagnosticsResponse(fileName, "key");
		return getDiagnosticsResponse.toJson();
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	@GetMapping("/getLocalListVersionRequest")
	public String getLocalListVersionRequest() {

		GetLocalListVersionRequest getLocalListVersionRequest = new GetLocalListVersionRequest();
		return getLocalListVersionRequest.toJson();
	}

		
	@GetMapping("/GetLocalListVersionResponse")
	public String getLocalListVersionResponse(@RequestParam("listVersion") Integer listVersion) {
		
		GetLocalListVersionResponse GetLocalListVersionResponse = new GetLocalListVersionResponse(listVersion, "key");
		return GetLocalListVersionResponse.toJson();
	}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		
	@GetMapping("/heartbeatResponse")
	public String heartbeatResponse(@RequestParam("currentTime") LocalDateTime currentTime) {

		HeartbeatResponse heartbeatResponse = new HeartbeatResponse(currentTime, "key");
		return heartbeatResponse.toJson();
	}
	
	
	@GetMapping("/heartbeatRequest")
	public String heartbeatRequest() {
		
		HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
		return heartbeatRequest.toJson();
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	@GetMapping("/meterValuesResponse")
	public String meterValuesResponse() {

		MeterValuesResponse meterValuesResponse = new MeterValuesResponse("key");
		return meterValuesResponse.toJson();
	}


	@GetMapping("/meterValuesRequest")
	public String meterValuesRequest(@RequestParam("connectorId") Integer connectorId,
			@RequestParam(value = "transactionId", required = false) Integer transactionId,
			@RequestBody MeterValue[] meterValue) {
		
		MeterValuesRequest meterValuesRequest = new MeterValuesRequest(connectorId, transactionId, meterValue);
		return meterValuesRequest.toJson();
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/remoteStartTransactionRequest")
	public String remoteStartTransactionRequest(@RequestParam("idTag") String idtag,
			@RequestParam(value = "connectorId", required = false) Integer connectorId,
			@RequestBody(required = false) ChargingProfile chargingProfile) {

//		ChargingSchedulePeriod chargingSchedulePeriod = new ChargingSchedulePeriod(1, 0.8, 34);
//		ChargingSchedulePeriod chargingSchedulePeriod1 = new ChargingSchedulePeriod(2, 0.1, 37);
//
//		List<ChargingSchedulePeriod> chargingSchedulePeriods = new ArrayList<>();
//		chargingSchedulePeriods.add(chargingSchedulePeriod);
//		chargingSchedulePeriods.add(chargingSchedulePeriod1);
//
//		ChargingSchedule chargingSchedule = new ChargingSchedule(26, ZonedDateTime.now(), ChargingRateUnitType.W,
//				chargingSchedulePeriods, 67.0);
//
//		ChargingProfile chargingProfile1 = new ChargingProfile(1, 1, 1, ChargingProfilePurposeType.TxProfile,
//				ChargingProfileKindType.Recurring, RecurrencyKindType.Daily, ZonedDateTime.now(), ZonedDateTime.now(),
//				chargingSchedule);

		ChargingProfile chargingProfile2 = null;
		if (chargingProfile != null) {
			chargingProfile2 = chargingProfile;
		}
		RemoteStartTransactionRequest request = new RemoteStartTransactionRequest(idtag, connectorId, chargingProfile2);
//		request.setIdTag("8");
//		request.setChargingProfile(chargingProfile);
//		request.setConnectorId(3);

		return request.toJson();
	}


	@GetMapping("/remoteStartTransactionResponse")
	public String remoteStartTransactionResponse(@RequestParam("status") RemoteStartStopStatusEnum status) {
		
		RemoteStartTransactionResponse remoteStartTransactionResponse = new RemoteStartTransactionResponse(status, "key");
		return remoteStartTransactionResponse.toJson();
	}

//------------------------------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/remoteStopTransactionRequest")
	public String remoteStopTransactionRequest() {

		RemoteStopTransactionRequest remoteStopTransactionRequest = new RemoteStopTransactionRequest(123456);

		return remoteStopTransactionRequest.toJson();
	}	





	@GetMapping("/statusNotificationResponse")
	public String statusNotificationResponse() {

		StatusNotificationResponse statusNotificationResponse = new StatusNotificationResponse("key");
		return statusNotificationResponse.toJson();
	}


	@GetMapping("/startTransactionResponse")
	public String startTransactionResponse() {

		StartTransactionResponse startTransactionResponse = new StartTransactionResponse(
				new IdTagInfo(ZonedDateTime.now(), "12", AuthorizationStatus.Accepted), 1234, "KEY");

		return startTransactionResponse.toJson();
	}

	@GetMapping("/stopTransactionResponse")
	public String stopTransactionResponse() {

		StopTransactionResponse stopTransactionResponse = new StopTransactionResponse(
				new IdTagInfo(ZonedDateTime.now(), "12", AuthorizationStatus.Accepted), "KEY");

		return stopTransactionResponse.toJson();
	}


	@GetMapping("/reserveNowRequest")
	public String reserveNowRequest() {

		ReserveNowRequest reserveNowRequest = new ReserveNowRequest(1, ZonedDateTime.now(),
				"1209bvbnb87654321234567890", 123);
		return reserveNowRequest.toJson();
	}


@GetMapping("/resetRequest")
	public String resetRequest(@RequestParam("type") ResetType type) {

		ResetRequest resetRequest = new ResetRequest(type);
		return resetRequest.toJson();
	}

	@GetMapping("/sendLocalListRequest")
	public String sendLocalList() {

		SendLocalListRequest sendLocalListRequest = new SendLocalListRequest(12,
				new LocalAuthorizationList("12",
						new IdTagInfo(ZonedDateTime.now(), "12", AuthorizationStatus.Accepted)),
				UpdateType.Differential);

		return sendLocalListRequest.toJson();
	}

	@GetMapping("/setChargingProfileRequest")
	public String setChargingProfileRequest(@RequestParam("connectorId") Integer connectorId,
			@RequestBody ChargingProfile chargingProfile) {

		SetChargingProfileRequest setChargingProfileRequest = new SetChargingProfileRequest(connectorId,
				chargingProfile);

		return setChargingProfileRequest.toJson();
	}

	@GetMapping("/triggerMessageRequest")
	public String triggerMessageRequest(@RequestParam("connectorId") Integer connectorId,
			@RequestParam("triggerMessageRequestType") TriggerMessageRequestType triggerMessageRequestType) {

		TriggerMessageRequest triggerMessageRequest = new TriggerMessageRequest(connectorId, triggerMessageRequestType);

		return triggerMessageRequest.toJson();
	}

	@GetMapping("/updateFirmwareRequest")
	public String updateFirmwareRequest(@RequestParam("location") String location,
			@RequestParam("retries") Integer retries, @RequestParam("retrieveDate") ZonedDateTime retrieveDate,
			@RequestParam("retryInterval") Integer retryInterval) {

		UpdateFirmwareRequest updateFirmwareRequest = new UpdateFirmwareRequest(location,retries,retrieveDate,retryInterval);

		return updateFirmwareRequest.toJson();
	}
}
