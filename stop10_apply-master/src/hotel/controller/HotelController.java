//package hotel.controller;
//
//import java.util.ArrayList;
//
//import hotel.exception.NotExistException;
//import hotel.model.dto.Reservation;
//import hotel.service.HotelReservationService;
//import hotel.view.EndView;
//import hotel.view.FailView;
//import net.sf.json.JSONArray;
//
//public class HotelController {
//
//	private static HotelController instance = new HotelController();
//	private HotelReservationService service = HotelReservationService.getInstance();
//
//	private HotelController() {
//	}
//
//	public static HotelController getInstance() {
//		return instance;
//	}
//
//	// 모든 예약 검색
//	public void reservationListView() {
//		ArrayList<Reservation> reservationList = service.getAllReservations();
//		if (reservationList.size() != 0) {
//			EndView.reservationListView(reservationList);
//		} else {
//			System.out.println("out");
//		}
//	}
//
//	public void jsonAllget() {
//		JSONArray reservationList = service.jsonGet();
//		if (reservationList.size() != 0) {
//			EndView.reservationJsonListView(reservationList);
//		} else {
//			System.out.println("out");
//		}
//	}
//
//	// 예약 1건 검색
//	public void reservationView(String guestName) {
//		try {
//			EndView.reservationView(service.getOneReservation(guestName));
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//
//	}
//
//	// 예약 (추가)
//	public void insertReservation(Reservation newReservation) {
//		service.reservationInsert(newReservation);
//	}
//
//	// 취소 (삭제)
//	public void deleteReservation(String guestName) {
//		try {
//			service.reservationDelete(guestName);
//			EndView.messageView("삭제되었습니다");
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//	}
//
//	// 변경 (수정)
//	// 숙박일 변경 후 혜택 변경 출력
//	public void updateReservation(String reservationName, int night) {
//		try {
//			service.reservationUpadate(reservationName, night);
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//
//	}
//
//	public void optionGrade(String guestName) {
//		try {
//			service.gradeOption(guestName);
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//	}
//
//}
package hotel.controller;

import java.util.ArrayList;

import hotel.exception.NotExistException;
import hotel.model.dto.Reservation;
import hotel.service.HotelReservationService;
import hotel.view.EndView;
import hotel.view.FailView;
import net.sf.json.JSONArray;

public class HotelController {

	private static HotelController instance = new HotelController();
	private HotelReservationService service = HotelReservationService.getInstance();

	private HotelController() {}

	public static HotelController getInstance() {
		return instance;
	}

	// 모든 예약 검색
	public void reservationListView() {
		ArrayList<Reservation> reservationList = service.getAllReservations();
		if (reservationList.size() != 0) {
			EndView.reservationListView(reservationList);
		} else {
			System.out.println("out");
		}
	}
	
	public void jsonAllget() {
		JSONArray reservationList = service.jsonGet();
		if (reservationList.size() != 0) {
			EndView.reservationJsonListView(reservationList);
		} else {
			System.out.println("out");
		}
	}

	// 예약 1건 검색
	public void reservationView(String guestName) {
		try {
			EndView.reservationView(service.getOneReservation(guestName));
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}

	}

	// 예약 (추가)
	public void insertReservation(Reservation newReservation) {
		service.reservationInsert(newReservation);
	}

	// 취소 (삭제)
	public void deleteReservation(String guestName) {
		try {
			service.reservationDelete(guestName);
			EndView.messageView("xxxxxxx 예약이 취소되었습니다. xxxxxxx");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// 수정1 단순 정보 변경 - 조식 구매
	public void updateReservation1(String reservationName) {
		try {
			service.reservationUpadate1(reservationName);
		}catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());			
		}
	}	
	
	// 수정2 숙박 일수 변경 & QS/QN 조건에 따른 멤버십 등급 변경
	public void updateReservation2(String reservationName, int night) {
		try {
			service.reservationUpadate2(reservationName, night);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}

	}
	
	// 수정3 멤버십 등급별 혜택 부여
	public void optionGrade(String guestName) {
		try {
			service.gradeOption(guestName);
		}catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

}

