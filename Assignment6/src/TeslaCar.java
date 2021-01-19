import java.time.LocalDate;

public class TeslaCar {

	int sales;
	LocalDate salesDate;

	public TeslaCar(LocalDate salesDate, int sales) {
		this.sales = sales;
		this.salesDate = salesDate;
	}

	public TeslaCar() {

	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}

	@Override
	public String toString() {
		return "TeslaCar [sales=" + sales + ", salesDate=" + salesDate + "]";
	}

}
