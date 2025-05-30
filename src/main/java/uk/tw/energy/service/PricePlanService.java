package uk.tw.energy.service;

import org.springframework.stereotype.Service;
import uk.tw.energy.domain.ElectricityReading;
import uk.tw.energy.domain.PricePlan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PricePlanService {

    private final List<PricePlan> pricePlans;
    private final MeterReadingService meterReadingService;

    public PricePlanService(List<PricePlan> pricePlans, MeterReadingService meterReadingService) {
        this.pricePlans = pricePlans;
        this.meterReadingService = meterReadingService;
    }

    public Optional<Map<String, BigDecimal>> getConsumptionCostOfElectricityReadingsForEachPricePlan(
            String smartMeterId) {
        Optional<List<ElectricityReading>> electricityReadings = meterReadingService.getReadings(smartMeterId);

        if (!electricityReadings.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(pricePlans.stream()
                .collect(Collectors.toMap(PricePlan::getPlanName, t -> calculateCost(electricityReadings.get(), t))));
    }

    private BigDecimal calculateCost(List<ElectricityReading> electricityReadings, PricePlan pricePlan) {
        final BigDecimal averageReadingInKw = calculateAverageReading(electricityReadings);
        final BigDecimal usageTimeInHours = calculateUsageTimeInHours(electricityReadings);
        final BigDecimal energyConsumedInKwH = averageReadingInKw.divide(usageTimeInHours, RoundingMode.HALF_UP);
        final BigDecimal cost = energyConsumedInKwH.multiply(pricePlan.getUnitRate());
        return cost;
    }

//    private BigDecimal calculateOfTheWeek() {
//        WeekFields weekFields = WeekFields.of(Locale.getDefault());
//        LocalDate now = LocalDate.now(ZoneOffset.UTC);
//        LocalDate startOfLastWeek = now.minusWeeks(1).with(weekFields.dayOfWeek(), 1);
//        Instant startInstant = startOfLastWeek.atStartOfDay(ZoneOffset.UTC).toInstant();
//        ElectricityReading electricityReading1 = new ElectricityReading(startInstant.plus(1, ChronoUnit.DAYS), BigDecimal.valueOf(8));
//        ElectricityReading electricityReading2 = new ElectricityReading(startInstant.plus(1, ChronoUnit.DAYS), BigDecimal.valueOf(20));
//        ElectricityReading electricityReading3 = new ElectricityReading(startInstant.plus(1, ChronoUnit.DAYS), BigDecimal.valueOf(50));
//        ElectricityReading electricityReading4 = new ElectricityReading(startInstant.plus(2, ChronoUnit.DAYS), BigDecimal.valueOf(16));
//        ElectricityReading electricityReading5 = new ElectricityReading(startInstant.plus(2, ChronoUnit.DAYS), BigDecimal.valueOf(32));
//    }

    private BigDecimal calculateAverageReading(List<ElectricityReading> electricityReadings) {
        BigDecimal summedReadings = electricityReadings.stream()
                .map(ElectricityReading::reading)
                .reduce(BigDecimal.ZERO, (reading, accumulator) -> reading.add(accumulator));

        return summedReadings.divide(BigDecimal.valueOf(electricityReadings.size()), RoundingMode.HALF_UP);
    }

    private BigDecimal calculateUsageTimeInHours(List<ElectricityReading> electricityReadings) {
        ElectricityReading first = electricityReadings.stream()
                .min(Comparator.comparing(ElectricityReading::time))
                .get();

        ElectricityReading last = electricityReadings.stream()
                .max(Comparator.comparing(ElectricityReading::time))
                .get();

        return BigDecimal.valueOf(Duration.between(first.time(), last.time()).getSeconds() / 3600.0);
    }
}
