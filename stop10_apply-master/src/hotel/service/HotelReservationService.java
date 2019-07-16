//package hotel.service;
//
//import java.util.ArrayList;
//import hotel.exception.NotExistException;
//import hotel.model.HotelModelVirtualDB;
//import hotel.model.dto.Reservation;
//import net.sf.json.JSONArray;

//public class HotelReservationService {
//
//	private static HotelReservationService instance = new HotelReservationService();
//	private HotelModelVirtualDB reservationVirtualData = HotelModelVirtualDB.getInstance();
//
//	private HotelReservationService() {
//	}
//
//	public static HotelReservationService getInstance() {
//		return instance;
//	}
//
//	// 모든 예약 검색
//	public ArrayList<Reservation> getAllReservations() {
//		return reservationVirtualData.getReservationList();
//	}
//
//	public JSONArray jsonGet() {
//		return reservationVirtualData.getJson();
//	}
//
//	// 예약 1건 검색
//	public Reservation getOneReservation(String guestName) throws NotExistException {
//		Reservation v = searchReservation(guestName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx 예약 건이 존재하지 않습니다. xxxxxxx");
//		} else {
//			return v;
//		}
//	}
//
//	public Reservation searchReservation(String guestName) {
//		ArrayList<Reservation> v = reservationVirtualData.getReservationList();
//		for (int i = 0; i < v.size(); i++) {
//			if (v != null && v.get(i).getGuest().getLastName().equals(guestName)) {
//				return v.get(i);
//			}
//		}
//		return null;
//	}
////	public Reservation getOneReservation(String guestName) throws NotExistException {
////		for (Reservation v : getAllReservations())
////			if (v != null && v.getGuest().getLastName().equals(guestName)) {
////				return v;
////			}
////		throw new NotExistException("xxxxxxx 예약 건이 존재하지 않습니다. xxxxxxx");
////	}
//
//	// 예약 (추가)
//	public void reservationInsert(Reservation reservation) {
//		reservationVirtualData.insertReservation(reservation);
//	}
//
//	// 취소 (삭제)
//	public void reservationDelete(String reservationName) throws NotExistException {
//		Reservation v = searchReservation(reservationName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx 삭제하고자 하는 예약이 존재하지 않습니다. xxxxxxx");
//		} else {
//			reservationVirtualData.deleteReservation(v);
//		}
//	}
//
//	public void reservationUpadate(String reservationName, int night) throws NotExistException {
//		Reservation v = searchReservation(reservationName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx  존재하지 않습니다. xxxxxxx\n");
//		} else {
//			v.getGuest().setNight(night);
//		}
//		int allNight = v.getGuest().getNight() + v.getGuest().getQualifiedNight();
//		if (allNight >= 20) {
//			v.getGuest().setGrade("Platinum");
//		} else if (allNight >= 10) {
//			v.getGuest().setGrade("Gold");
//		} else if (allNight < 10) {
//			v.getGuest().setGrade("Normal");
//		} else {
//			throw new NotExistException("xxxxxxx  존재하지 않습니다. xxxxxxx\n");
//		}
//
//	}
//
//	public void gradeOption(String guestName) throws NotExistException {
//		Reservation v = searchReservation(guestName);
//		System.out.println(v);
//		if (v.getGuest().getGrade() == "Platinum") {
//			v.getOption().setLateCheckOut("Included");
//			v.getOption().setFreeLounge("Included");
//			v.getOption().setSpa("Included");
//		} else if (v.getGuest().getGrade() == "Gold") {
//			v.getOption().setSpa("Included");
//		} else {
//			throw new NotExistException();
//		}
//	}
//
//}
package hotel.service;

import java.util.ArrayList;

import hotel.exception.NotExistException;
import hotel.model.HotelModelVirtualDB;
import hotel.model.dto.Guest;
import hotel.model.dto.OptionService;
import hotel.model.dto.Reservation;
import net.sf.json.JSONArray;

public class HotelReservationService {

	private static HotelReservationService instance = new HotelReservationService();
	private HotelModelVirtualDB reservationVirtualData = HotelModelVirtualDB.getInstance();

	private HotelReservationService() {
	}

	public static HotelReservationService getInstance() {
		return instance;
	}

	// 모든 예약 검색
	public ArrayList<Reservation> getAllReservations() {
		return reservationVirtualData.getReservationList();
	}

	public JSONArray jsonGet() {
		return reservationVirtualData.getJson();
	}

	// 예약 1건 검색
	// 예외 처리와 검색 분리
	public Reservation getOneReservation(String guestName) throws NotExistException {
		Reservation v = searchReservation(guestName);
		if (v == null) {
			throw new NotExistException("xxxxxxx 예약 건이 존재하지 않습니다. xxxxxxx");
		} else {
			return v;
		}
	}

	public Reservation searchReservation(String guestName) {
		ArrayList<Reservation> v = reservationVirtualData.getReservationList();
		for (int i = 0; i < v.size(); i++) {
			if (v != null && v.get(i).getGuest().getLastName().equals(guestName)) {
				return v.get(i);
			}
		}
		return null;
	}

	// 예외 처리와 검색 조합
//	public Reservation getOneReservation(String guestName) throws NotExistException {
//		for (Reservation v : getAllReservations()) {
//			if (v != null && v.getGuest().getLastName().equals(guestName)) {
//				return v;		
//			}
//		}
//		throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
//	}

	// 예약 (추가)
	public void reservationInsert(Reservation reservation) {
		reservationVirtualData.insertReservation(reservation);
	}
	// 예외 처리 ??????????????????????????????????????????
//	public void reservationInsert(Reservation reservation) throws NotExistException{
//		for (Reservation v : getAllReservations()) {
//			if (v != null && v.getGuest().getLastName().equals(guestName)) {
//				return v;	// 날짜 필요함, 같은 날짜, 이름, 전번 -> 예약 거부
//			}
//		}
//		throw new NotExistException("xxxxxxx 이미 등록되어 있는 고객입니다. xxxxxxx\n");
//	}

	// 취소 (삭제)
	public void reservationDelete(String reservationName) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		if (v == null) {
			throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
		} else {
			reservationVirtualData.deleteReservation(v);
		}
	}

	// 수정1 단순 정보 변경 - 조식 구매
	public void reservationUpadate1(String reservationName) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		Guest g = v.getGuest();
		if (v == null) {
			throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
		} else {
			v.getOption().setBreakfast("Included");
		}
	}

	// 수정2 숙박 일수 변경 & QS/QN 조건에 따른 멤버십 등급 변경
	public void reservationUpadate2(String reservationName, int night) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		Guest g = v.getGuest(); // 변수 정리
		if (v == null) {
			throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
		} else {
			g.setNight(night);
		}
		int allNight = g.getNight() + g.getQualifiedNight();
		int allStay = g.getQualifiedStay();
		if (allNight >= 20 || allStay > 10) {
			g.setGrade("Platinum");
		} else if (allNight >= 10 || allStay > 5) {
			g.setGrade("Gold");
		} else if (allNight < 10 || allStay < 5) {
			g.setGrade("Normal");
		} else {
			throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
		}
	}

	// 수정3 멤버십 등급별 혜택 부여
	public void gradeOption(String guestName) throws NotExistException {
		Reservation v = getOneReservation(guestName);
		OptionService o = v.getOption(); // 변수 정리
		if (v.getGuest().getGrade() == "Platinum") {
			o.setLateCheckOut("Included");
			o.setFreeLounge("Included");
			o.setSpa("Included");
		} else if (v.getGuest().getGrade() == "Gold") {
			o.setSpa("Included");
		} else {
			throw new NotExistException("xxxxxxx 요청하신 정보를 찾을 수 없습니다. xxxxxxx\n");
		}
	}
}
