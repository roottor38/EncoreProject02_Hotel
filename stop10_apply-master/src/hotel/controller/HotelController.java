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
//	// ��� ���� �˻�
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
//	// ���� 1�� �˻�
//	public void reservationView(String guestName) {
//		try {
//			EndView.reservationView(service.getOneReservation(guestName));
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//
//	}
//
//	// ���� (�߰�)
//	public void insertReservation(Reservation newReservation) {
//		service.reservationInsert(newReservation);
//	}
//
//	// ��� (����)
//	public void deleteReservation(String guestName) {
//		try {
//			service.reservationDelete(guestName);
//			EndView.messageView("�����Ǿ����ϴ�");
//		} catch (NotExistException e) {
//			FailView.failMessageView(e.getMessage());
//		}
//	}
//
//	// ���� (����)
//	// ������ ���� �� ���� ���� ���
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

	// ��� ���� �˻�
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

	// ���� 1�� �˻�
	public void reservationView(String guestName) {
		try {
			EndView.reservationView(service.getOneReservation(guestName));
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}

	}

	// ���� (�߰�)
	public void insertReservation(Reservation newReservation) {
		service.reservationInsert(newReservation);
	}

	// ��� (����)
	public void deleteReservation(String guestName) {
		try {
			service.reservationDelete(guestName);
			EndView.messageView("xxxxxxx ������ ��ҵǾ����ϴ�. xxxxxxx");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// ����1 �ܼ� ���� ���� - ���� ����
	public void updateReservation1(String reservationName) {
		try {
			service.reservationUpadate1(reservationName);
		}catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());			
		}
	}	
	
	// ����2 ���� �ϼ� ���� & QS/QN ���ǿ� ���� ����� ��� ����
	public void updateReservation2(String reservationName, int night) {
		try {
			service.reservationUpadate2(reservationName, night);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}

	}
	
	// ����3 ����� ��޺� ���� �ο�
	public void optionGrade(String guestName) {
		try {
			service.gradeOption(guestName);
		}catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

}

