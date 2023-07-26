package com.vst.ocpp.testprotocol_1_6;

import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

/**
 * Single sampled value in {@link MeterValue}. Each value can be accompanied by
 * optional fields.
 */
@NoArgsConstructor
public class SampledValue {

	private String value;
	private String context;
	private ValueFormatEnum format;
	private String measurand;
	private String phase;
	private LocationEnum location;
	private UnitEnum unit;

	public SampledValue(String value, String context, ValueFormatEnum format, String measurand, String phase,
			LocationEnum location, UnitEnum unit) {
		this(value);
		setContext(context);
		setFormat(format);
		setMeasurand(measurand);
		setPhase(phase);
		setLocation(location);
		setUnit(unit);
	}

	/**
	 * Handle required fields.
	 *
	 * @param value String, the value, see {@link #setValue(String)}
	 */
	public SampledValue(String value) {
		setValue(value);
	}

	/**
	 * Value as a Raw (@code decimal) number or {@code SignedData}. Field Type is
	 * String to allow for digitally signed data readings. Decimal numeric values
	 * are also acceptable to allow fractional values for measurands such as
	 * Temperature and Current.
	 *
	 * @return String, the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Required. Value as a {@code Raw} (decimal) number or {@code SignedData}.
	 * Field Type is String to allow for digitally signed data readings. Decimal
	 * numeric values are also acceptable to allow fractional values for measurands
	 * such as Temperature and Current.
	 *
	 * @param value String, the value.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Type of detail value: start, end or sample.
	 *
	 * @return enum value for context.
	 */
	public String getContext() {
		return context;
	}

	/**
	 * Optional. Type of detail value: start, end or sample. Default =
	 * {@code Sample.Periodic}
	 *
	 * <p>
	 * Enum value with accepted values: {@code Interruption.Begin},
	 * {@code Interruption.End}, {@code Other}, {@code Sample.Clock},
	 * {@code Sample.Periodic}, {@code Transaction.Begin}, {@code
	 * Transaction.End}, {@code Trigger}
	 *
	 * @param context String, see description for accepted values.
	 */
	public void setContext(String context) {

		if (context != null && !validateContext(context)) {
			throw new InvalidDataException(context, "context is not properly defined");
		}
		this.context = context;
	}

	private boolean validateContext(String context) {
		String[] readingContext = { "Interruption.Begin", "Interruption.End", "Other", "Sample.Clock",
				"Sample.Periodic", "Transaction.Begin", "Transaction.End", "Trigger" };
		return Utils.checkEnum(context, readingContext);
	}

	/**
	 * Raw or signed data.
	 *
	 * @return the {@link ValueFormat}.
	 */
	public ValueFormatEnum getFormat() {
		return format;
	}

	/**
	 * Optional. Raw or signed data. Default = {@code Raw}.
	 *
	 * @param format the {@link ValueFormat}.
	 */
	public void setFormat(ValueFormatEnum format) {
		this.format = format;
	}

	/**
	 * Type of measurement.
	 *
	 * @return enum value of measurand.
	 */
	public String getMeasurand() {
		return measurand;
	}

	/**
	 * Optional. Type of measurement. Default =
	 * {@code Energy.Active.Import.Register}.
	 *
	 * <p>
	 * Enum value with accepted values: {@code Current.Export},
	 * {@code Current.Import}, {@code
	 * Current.Offered}, {@code Energy.Active.Export.Register},
	 * {@code Energy.Active.Import.Register},
	 * {@code Energy.Reactive.Export.Register},
	 * {@code Energy.Reactive.Import.Register}, {@code
	 * Energy.Active.Export.Interval}, {@code Energy.Active.Import.Interval}, {@code
	 * Energy.Reactive.Export.Interval}, {@code Energy.Reactive.Import.Interval},
	 * {@code Frequency}, {@code Power.Active.Export}, {@code Power.Active.Import},
	 * {@code Power.Factor}, {@code
	 * Power.Offered}, {@code Power.Reactive.Export}, {@code Power.Reactive.Import},
	 * {@code RPM}, {@code SoC}, {@code Temperature}, {@code Voltage}
	 *
	 * @param measurand String, enum value of measurand.
	 */
	public void setMeasurand(String measurand) {

		if (measurand != null && !validateMesurand(measurand)) {
			throw new InvalidDataException(measurand, "measurand value is not properly defined");
		}
		this.measurand = measurand;
	}

	private boolean validateMesurand(String measurand) {
		String[] readingMeasurand = { "Energy.Active.Export.Register", "Energy.Active.Import.Register",
				"Energy.Reactive.Export.Register", "Energy.Reactive.Import.Register", "Energy.Active.Export.Interval",
				"Energy.Active.Import.Interval", "Energy.Reactive.Export.Interval", "Energy.Reactive.Import.Interval",
				"Power.Active.Export", "Power.Active.Import", "Power.Offered", "Power.Reactive.Export",
				"Power.Reactive.Import", "Power.Factor", "Current.Import", "Current.Export", "Current.Offered",
				"Voltage", "Frequency", "Temperature", "SoC", "RPM" };
		return Utils.checkEnum(measurand, readingMeasurand);
	}

	/**
	 * Indicates how the measured value is to be interpreted. For instance between
	 * L1 and neutral (L1-N).
	 *
	 * @return enum value of phase.
	 */
	public String getPhase() {
		return phase;
	}

	/**
	 * Optional. Indicates how the measured value is to be interpreted. For instance
	 * between L1 and neutral (L1-N). Please note that not all values of phase are
	 * applicable to all Measurands. When phase is absent, the measured value is
	 * interpreted as an overall value.
	 *
	 * <p>
	 * Enum value with accepted values: {@code L1}, {@code L2}, {@code L3},
	 * {@code N}, {@code
	 * L1-N}, {@code L2-N}, {@code L3-N}, {@code L1-L2}, {@code L2-L3},
	 * {@code L3-L1}
	 *
	 * @param phase String, enum value of phase.
	 */
	public void setPhase(String phase) {
		if (phase != null && !validatePhase(phase)) {
			throw new InvalidDataException(phase, "phase value is not properly defined");
		}
		this.phase = phase;
	}

	private boolean validatePhase(String phase) {
		String[] readingPhase = { "L1", "L2", "L3", "N", "L1-N", "L2-N", "L3-N", "L1-L2", "L2-L3", "L3-L1" };
		return Utils.checkEnum(phase, readingPhase);
	}

	/**
	 * Location of measurement.
	 *
	 * @return the {@link LocationEnum}.
	 */
	public LocationEnum getLocation() {
		return location;
	}

	/**
	 * Optional. Location of measurement. Default={@code Outlet}
	 *
	 * @param location the {@link LocationEnum}.
	 */
	public void setLocation(LocationEnum location) {
		this.location = location;
	}

	/**
	 * Unit of the value.
	 *
	 * @return Unit of Measure.
	 */
	public UnitEnum getUnit() {
		return unit;
	}

	/**
	 * Optional. Unit of the value. Default = {@code Wh} if the (default) measurand
	 * is an {@code
	 * Energy} type.
	 *
	 * <p>
	 * Enum value with accepted values: {@code Wh}, {@code kWh}, {@code varh},
	 * {@code kvarh}, {@code W}, {@code kW}, {@code VA}, {@code kVA}, {@code var},
	 * {@code kvar}, {@code A}, {@code
	 * V}, {@code Celsius}, {@code Fahrenheit}, {@code K}, {@code Percent}
	 *
	 * @param unit String, enum value, Unit of Measure.
	 */
	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

}
