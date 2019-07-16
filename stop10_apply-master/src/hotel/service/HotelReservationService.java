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
//	// ��� ���� �˻�
//	public ArrayList<Reservation> getAllReservations() {
//		return reservationVirtualData.getReservationList();
//	}
//
//	public JSONArray jsonGet() {
//		return reservationVirtualData.getJson();
//	}
//
//	// ���� 1�� �˻�
//	public Reservation getOneReservation(String guestName) throws NotExistException {
//		Reservation v = searchReservation(guestName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx ���� ���� �������� �ʽ��ϴ�. xxxxxxx");
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
////		throw new NotExistException("xxxxxxx ���� ���� �������� �ʽ��ϴ�. xxxxxxx");
////	}
//
//	// ���� (�߰�)
//	public void reservationInsert(Reservation reservation) {
//		reservationVirtualData.insertReservation(reservation);
//	}
//
//	// ��� (����)
//	public void reservationDelete(String reservationName) throws NotExistException {
//		Reservation v = searchReservation(reservationName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx �����ϰ��� �ϴ� ������ �������� �ʽ��ϴ�. xxxxxxx");
//		} else {
//			reservationVirtualData.deleteReservation(v);
//		}
//	}
//
//	public void reservationUpadate(String reservationName, int night) throws NotExistException {
//		Reservation v = searchReservation(reservationName);
//		if (v == null) {
//			throw new NotExistException("xxxxxxx  �������� �ʽ��ϴ�. xxxxxxx\n");
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
//			throw new NotExistException("xxxxxxx  �������� �ʽ��ϴ�. xxxxxxx\n");
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

	// ��� ���� �˻�
	public ArrayList<Reservation> getAllReservations() {
		return reservationVirtualData.getReservationList();
	}

	public JSONArray jsonGet() {
		return reservationVirtualData.getJson();
	}

	// ���� 1�� �˻�
	// ���� ó���� �˻� �и�
	public Reservation getOneReservation(String guestName) throws NotExistException {
		Reservation v = searchReservation(guestName);
		if (v == null) {
			throw new NotExistException("xxxxxxx ���� ���� �������� �ʽ��ϴ�. xxxxxxx");
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

	// ���� ó���� �˻� ����
//	public Reservation getOneReservation(String guestName) throws NotExistException {
//		for (Reservation v : getAllReservations()) {
//			if (v != null && v.getGuest().getLastName().equals(guestName)) {
//				return v;		
//			}
//		}
//		throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
//	}

	// ���� (�߰�)
	public void reservationInsert(Reservation reservation) {
		reservationVirtualData.insertReservation(reservation);
	}
	// ���� ó�� ??????????????????????????????????????????
//	public void reservationInsert(Reservation reservation) throws NotExistException{
//		for (Reservation v : getAllReservations()) {
//			if (v != null && v.getGuest().getLastName().equals(guestName)) {
//				return v;	// ��¥ �ʿ���, ���� ��¥, �̸�, ���� -> ���� �ź�
//			}
//		}
//		throw new NotExistException("xxxxxxx �̹� ��ϵǾ� �ִ� ���Դϴ�. xxxxxxx\n");
//	}

	// ��� (����)
	public void reservationDelete(String reservationName) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		if (v == null) {
			throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
		} else {
			reservationVirtualData.deleteReservation(v);
		}
	}

	// ����1 �ܼ� ���� ���� - ���� ����
	public void reservationUpadate1(String reservationName) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		Guest g = v.getGuest();
		if (v == null) {
			throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
		} else {
			v.getOption().setBreakfast("Included");
		}
	}

	// ����2 ���� �ϼ� ���� & QS/QN ���ǿ� ���� ����� ��� ����
	public void reservationUpadate2(String reservationName, int night) throws NotExistException {
		Reservation v = getOneReservation(reservationName);
		Guest g = v.getGuest(); // ���� ����
		if (v == null) {
			throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
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
			throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
		}
	}

	// ����3 ����� ��޺� ���� �ο�
	public void gradeOption(String guestName) throws NotExistException {
		Reservation v = getOneReservation(guestName);
		OptionService o = v.getOption(); // ���� ����
		if (v.getGuest().getGrade() == "Platinum") {
			o.setLateCheckOut("Included");
			o.setFreeLounge("Included");
			o.setSpa("Included");
		} else if (v.getGuest().getGrade() == "Gold") {
			o.setSpa("Included");
		} else {
			throw new NotExistException("xxxxxxx ��û�Ͻ� ������ ã�� �� �����ϴ�. xxxxxxx\n");
		}
	}
}
