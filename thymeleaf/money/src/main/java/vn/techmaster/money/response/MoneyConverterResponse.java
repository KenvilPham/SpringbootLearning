package vn.techmaster.money.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoneyConverterResponse {
    private float convertResult;
    private String fromCurrency;
    private String toCurrency;
}
