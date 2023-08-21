package me.lunamcdev.core.text.format;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@RequiredArgsConstructor
public class FormattedInteger implements INumberFormatter {

	private final double value;

	@Override
	public String toLetterFormat() {
		final DecimalFormat format = new DecimalFormat("0");
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
			return "0";
	}

	@Override
	public String toRawFormat() {
		return new BigDecimal(this.value).intValue() + "";
	}

	@Override
	public String toString() {
		return toCommaFormat();
	}
}
