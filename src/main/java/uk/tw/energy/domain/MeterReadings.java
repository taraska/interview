package uk.tw.energy.domain;

import java.util.List;

public record MeterReadings(String smartMeterId, List<ElectricityReading> electricityReadings) {
    public boolean isValid() {
        return smartMeterId != null
            && !smartMeterId.isEmpty()
            && electricityReadings != null
            && !electricityReadings.isEmpty();
    }
}
