package hotel.model;

import java.util.ArrayList;

import hotel.model.dto.Guest;
import hotel.model.dto.OptionService;
import hotel.model.dto.Reservation;
import hotel.model.dto.Room;
import net.sf.json.JSONArray;

public class HotelModelVirtualDB {

	private static HotelModelVirtualDB instance = new HotelModelVirtualDB();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

	private HotelModelVirtualDB() {

		// 기존에 생성된 예약
		reservationList.add(new Reservation("rsv201", new Guest("Lee9742", 31, "Madam", 3, 0, 0, "Normal"),
				new Room(201, "Delux", "Single"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "notIncluded")));
		reservationList.add(new Reservation("rsv301", new Guest("Park8854", 22, "Sir", 2, 8, 10, "Gold"),
				new Room(301, "Delux", "Twin"),
				new OptionService("notIncluded", "Included", "notIncluded", "notIncluded")));
		reservationList.add(new Reservation("rsv401", new Guest("Woo2387", 37, "Sir", 4, 4, 5, "Normal"),
				new Room(401, "Superior", "Queen"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "notIncluded")));
		reservationList.add(new Reservation("rsv501", new Guest("Kim9910", 51, "Madam", 3, 5, 21, "Platinum"),
				new Room(501, "Superior", "Queen"),
				new OptionService("notIncluded", "notIncluded", "Included", "Included")));
		reservationList.add(new Reservation("rsv601", new Guest("jung3462", 60, "Sir", 2, 7, 18, "Gold"),
				new Room(601, "Premier", "Queen"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "Included")));
		reservationList.add(new Reservation("rsv701", new Guest("Lee5697", 28, "Sir", 2, 3, 4, "Normal"),
				new Room(701, "Premier", "Queen"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "notIncluded")));
		reservationList.add(new Reservation("rsv801", new Guest("Choi9401", 33, "Madam", 1, 7, 20, "Platinum"),
				new Room(801, "Suite", "King"),
				new OptionService("notIncluded", "notIncluded", "Included", "Included")));
		reservationList.add(new Reservation("rsv901", new Guest("Ro2232", 47, "Madam", 3, 5, 10, "Gold"),
				new Room(901, "Suite", "King"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "Included")));
	}

	public static HotelModelVirtualDB getInstance() {
		return instance;
	}

	// 모든 예약 리스트
	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public JSONArray getJson() {
		JSONArray jsonArray = JSONArray.fromObject(reservationList);
		return jsonArray;
	}

	// 예약 추가 메소드
	public void insertReservation(Reservation newReservation) {
		reservationList.add(newReservation);
	}

	// 예약 취소 메소드
	public void deleteReservation(Reservation delReservation) {
		reservationList.remove(delReservation);
	}
}

/*
 * reservationList.add(new Reservation("rsv901", new Guest("Ro", 47, "Madam", 3,
 * 5, 10, "Gold"), new Room(901, "Suite", "King"), new
 * PlatinumService("notIncluded", "notIncluded", "notIncluded", "Included")));
 * 
 */
