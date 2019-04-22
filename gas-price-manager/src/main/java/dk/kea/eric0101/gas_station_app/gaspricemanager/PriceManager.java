package dk.kea.eric0101.gas_station_app.gaspricemanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

@RestController
@RequestMapping("/pricemanager")
public class PriceManager {
	
	public static final double DEFAULT_PRICE = 50d;
	public static double gasPrice = DEFAULT_PRICE;
	public static float profitMargin = 0.1f;
	public static Date changedAt;




	@GetMapping("/price")
	public double getPrice() {
		return gasPrice;
	}
	
	@GetMapping("/profitmargin")
	public String getProfitMargin() {
		String profitStr = "Profit margin = " + (this.profitMargin * 100) + " %";
		return profitStr;
	}

	@GetMapping("/dateChanged")
	public Date getDateChanged() {
		return changedAt;
	}

}
