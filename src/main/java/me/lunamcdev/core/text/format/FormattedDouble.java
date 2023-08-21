package me.lunamcdev.core.text.format;

import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;

@RequiredArgsConstructor
public class FormattedDouble implements INumberFormatter {

	private final double value;

	public String toCommaFormatAndTwoDecimalPlaces() {
		if (this.value > 0) {
			final DecimalFormat formatter = new DecimalFormat("#,###.00");
			return formatter.format(this.value);
		} else
			return "0.00";
	}

	@Override
	public String toString() {
		return toCommaFormatAndTwoDecimalPlaces();
	}

	@Override
	public String toLetterFormat() {
		final DecimalFormat format = new DecimalFormat("0.##");
		if (this.value < 1000) return format.format(this.value);
		final int exp = (int) (Math.log(this.value) / Math.log(1000));
		final String formatValue = format.format(this.value / Math.pow(1000, exp));
		return String.format("%s%c", formatValue, "kMBTQ".charAt(exp - 1));
	}


	@Override
	public String toCommaFormat() {
		if (this.value > 0) {
			final DecimalFormat formatter = new DecimalFormat("#,###");
			return formatter.format(this.value);
		} else
			return "0.00";
	}

	@Override
	public String toRawFormat() {
		return "" + this.value;
	}

	public String toOneDecimalPlaces() {
		if (this.value > 0) {
			final DecimalFormat formatter = new DecimalFormat("#,###.0");
			return formatter.format(this.value);
		} else
			return "0.00";
	}

	public String toTwoDecimalPlaces() {
		if (this.value > 0) {
			final DecimalFormat formatter = new DecimalFormat("#,###.00");
			return formatter.format(this.value);
		} else
			return "0.0";
	}

	public String toLetterShort() {
		final DecimalFormat format = new DecimalFormat("0.#");
		if (this.value < 1000) return format.format(this.value);
		final int exp = (int) (Math.log(this.value) / Math.log(1000));
		final String formatValue = format.format(this.value / Math.pow(1000, exp));
		return String.format("%s%c", formatValue, "kMBTQ".charAt(exp - 1));
	}
}
