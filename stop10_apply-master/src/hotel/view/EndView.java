package hotel.view;

import java.util.ArrayList;
import hotel.log4j.Log4j;
import hotel.model.dto.Reservation;
import net.sf.json.JSONArray;

public class EndView {
	private static Log4j log = new Log4j();

	public static void reservationListView(ArrayList<Reservation> allReservation) {
		for (int index = 0; index < allReservation.size(); index++) {
			System.out.println("예약 " + (index + 1));
			System.out.println(allReservation.get(index));
		}
	}

	public static void reservationJsonListView(JSONArray allReservation) {
		for (int index = 0; index < allReservation.size(); index++) {
			System.out.println("예약 " + (index + 1));
			System.out.println(allReservation.get(index));
		}
	}

	public static void reservationView(Reservation reservation) {
		System.out.println(reservation);
	}

	public static void messageView(String message) {
		log.info(message);
	}

}
