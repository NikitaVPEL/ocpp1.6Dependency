package com.vst.ocpp.testProtocol_1_6;

import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

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

	public SampledValue(String value) {
		setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {

		if (context != null && !validateContext(context)) {
			throw new InvalidDataException(context, "context is not properly defined");
		}
		this.context = context;
	}
	
	  private boolean validateContext(String context) {
		    String[] readingContext = {
		      "Interruption.Begin",
		      "Interruption.End",
		      "Other",
		      "Sample.Clock",
		      "Sample.Periodic",
		      "Transaction.Begin",
		      "Transaction.End",
		      "Trigger"
			};
			return Utils.checkEnum(context, readingContext);
		}

		public ValueFormatEnum getFormat() {
			return format;
		}

		public void setFormat(ValueFormatEnum format) {
			this.format = format;
		}

		public String getMeasurand() {
			return measurand;
		}

		public void setMeasurand(String measurand) {

			if (measurand != null && !validateMesurand(measurand)) {
				throw new InvalidDataException(measurand, "measurand value is not properly defined");
			}
			this.measurand = measurand;
		}

		private boolean validateMesurand(String measurand) {
			String[] readingMeasurand = {
		    		   "Energy.Active.Export.Register",
                       "Energy.Active.Import.Register",
                       "Energy.Reactive.Export.Register",
                       "Energy.Reactive.Import.Register",
                       "Energy.Active.Export.Interval",
                       "Energy.Active.Import.Interval",
                       "Energy.Reactive.Export.Interval",
                       "Energy.Reactive.Import.Interval",
                       "Power.Active.Export",
                       "Power.Active.Import",
                       "Power.Offered",
                       "Power.Reactive.Export",
                       "Power.Reactive.Import",
                       "Power.Factor",
                       "Current.Import",
                       "Current.Export",
                       "Current.Offered",
                       "Voltage",
                       "Frequency",
                       "Temperature",
                       "SoC",
                       "RPM"
		    };
		    return Utils.checkEnum(measurand, readingMeasurand);
		  }

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		if (phase != null && !validatePhase(phase)) {
		      throw new InvalidDataException(phase, "phase value is not properly defined");
		    }
		this.phase = phase;
	}
	
	  private boolean validatePhase(String phase) {
		    String[] readingPhase = {
		    		 "L1",
                     "L2",
                     "L3",
                     "N",
                     "L1-N",
                     "L2-N",
                     "L3-N",
                     "L1-L2",
                     "L2-L3",
					"L3-L1"    };
			return Utils.checkEnum(phase, readingPhase);
		}

		public LocationEnum getLocation() {
			return location;
		}

		public void setLocation(LocationEnum location) {
			this.location = location;
		}

		public UnitEnum getUnit() {
			return unit;
		}

		public void setUnit(UnitEnum unit) {
			this.unit = unit;
		}

}
