
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class TeslaCarService implements TeslaCarInterface {

	int i = 0;

	public List<TeslaCar> getTeslaCars(String teslaModel) {

		String readDataLine = null;
		List<TeslaCar> teslaCar = new ArrayList<>();
		BufferedReader bufferedReader = null;

		try {

			bufferedReader = new BufferedReader(new FileReader(teslaModel));
			while ((readDataLine = bufferedReader.readLine()) != null) {

//			System.out.println(readDataLine);
				String[] line = readDataLine.split(",");

				String first_part = line[0];
				String second_part = line[1];
				if (!first_part.equals("Date")) {
					LocalDate stringToDate = LocalDate.parse(first_part, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					int salesConvesion = Integer.parseInt(second_part);
					teslaCar.add(new TeslaCar(stringToDate, salesConvesion));
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File not found. Check File path.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Oops Something is wrong reading the text file");
			ex.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				System.out.println("Something went wrong cannot close file reader");
				e.printStackTrace();
			}
		}

		return teslaCar;
	}

}
