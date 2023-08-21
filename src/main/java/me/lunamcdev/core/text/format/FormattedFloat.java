package me.lunamcdev.core.text.format;

public class FormattedFloat extends FormattedDouble {

	public FormattedFloat(final double value) {
		super(value);
	}

	@Override
	public String toString() {
		return toCommaFormatAndTwoDecimalPlaces();
	}
}
