import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


public class TeslaCarApplication implements TeslaCarInterface {

	public static void main(String[] args) {

		TeslaCarService teslaCarService = new TeslaCarService();

		List<TeslaCar> model3TeslaCars = teslaCarService.getTeslaCars(TeslaCarInterface.MODEL3_READ_SOURCE);
		List<TeslaCar> modelSTeslaCars = teslaCarService.getTeslaCars(TeslaCarInterface.MODELS_READY_SOURCE);
		List<TeslaCar> modelXTeslaCars = teslaCarService.getTeslaCars(TeslaCarInterface.MODELX_READ_SOURCE);

		List<Integer> years = new ArrayList<>();
		years.add(TeslaCarInterface.TWO_THOUSAND_SIXTEEN);
		years.add(TeslaCarInterface.TWO_THOUSAND_SEVENTEEN);
		years.add(TeslaCarInterface.TWO_THOUSAND_EIGHTEEN);
		years.add(TeslaCarInterface.TWO_THOUSAND_NINETEEN);

		CarReport(years, model3TeslaCars, TeslaCarInterface.MODEL3, TeslaCarInterface.MODEL3_REPORT);
		System.out.println();
		TeslaYearlySalesReport(model3TeslaCars, TeslaCarInterface.MODEL3);

		CarReport(years, modelSTeslaCars, TeslaCarInterface.MODELS, TeslaCarInterface.MODELS_REPORT);
		System.out.println();
		TeslaYearlySalesReport(modelSTeslaCars, TeslaCarInterface.MODELS);

		CarReport(years, modelXTeslaCars, TeslaCarInterface.MODELX, TeslaCarInterface.MODELX_REPORT);
		System.out.println();
		TeslaYearlySalesReport(modelXTeslaCars, TeslaCarInterface.MODELX);

	}

	public static void TeslaYearlySalesReport(List<TeslaCar> modelsTeslaCars, String model) {
		
		IntSummaryStatistics model3BestMonth = modelsTeslaCars.stream()
				                                              .map(x -> x.sales)
				                                              .mapToInt(x -> x.intValue())
				                                              .summaryStatistics();

		int bestSales = model3BestMonth.getMax();
		int worstSales = model3BestMonth.getMin();

		TeslaCar bestTeslaCarSales = modelsTeslaCars.stream()
				                                    .filter(customer -> bestSales == customer.getSales())
				                                    .findAny()
				                                    .orElse(null);

		TeslaCar worstTeslaCarSales = modelsTeslaCars.stream()
				                                     .filter(customer -> worstSales == customer.getSales())
				                                     .findAny().orElse(null);

		LocalDate bestMonthModel3 = bestTeslaCarSales.getSalesDate();
		LocalDate worstMonthModel3 = worstTeslaCarSales.getSalesDate();

		System.out.println("The best month for " + model + " was: " + bestMonthModel3.getYear() + "-" + bestMonthModel3.getMonth());
		System.out.println("The worst month for " + model + " was: " + worstMonthModel3.getYear() + "-" + worstMonthModel3.getMonth());
		System.out.println();
	}

	public static void CarReport(List<Integer> yrs, List<TeslaCar> listOfTeslaModelCars, String model,
			String modelReport) {

		System.out.println(model + " " + modelReport);
		System.out.println("---------------------------");

		for (Integer yearsToBeReported : yrs) {

			long teslaSales = SalesReportByYear(listOfTeslaModelCars, yearsToBeReported);
			System.out.println(yearsToBeReported + " -> " + teslaSales);

		}

	}

	public static long SalesReportByYear(List<TeslaCar> listOfTeslaModelCars, int yearSalesReport) {
		
		List<TeslaCar> tesla = listOfTeslaModelCars.stream()
				                                   .filter(tslCar -> tslCar.getSalesDate().getYear() == yearSalesReport)
				                                   .collect(Collectors.toList());

		long teslaSales = tesla.stream()
				               .map(y -> y.sales)
				               .mapToInt(x -> x.intValue())
				               .sum();
		return teslaSales;
	}

}
