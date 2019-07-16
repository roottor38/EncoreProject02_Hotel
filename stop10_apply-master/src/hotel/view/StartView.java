package hotel.view;

import java.util.Scanner;

import hotel.controller.HotelController;
import hotel.model.dto.Guest;
import hotel.model.dto.OptionService;
import hotel.model.dto.Reservation;
import hotel.model.dto.Room;

public class StartView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelController controller = HotelController.getInstance();
		Reservation newReservation = new Reservation("rsv601", new Guest("Song7864", 41, "Madam", 5, 7, 21, "Platium"),
				new Room(701, "Superior", "Queen"),
				new OptionService("notIncluded", "notIncluded", "notIncluded", "notIncluded"));
		int req;
		String s;
		int i;

		while (true) {
			System.out.println("1.전체 검색");
			System.out.println("2.예약 1건 검색");
			System.out.println("3.숙박 일수 변경");
			System.out.println("4 조식 구매");
			System.out.println("5.예약 삭제");
			System.out.println("6 예약 추가");
			System.out.println("7.json 출력");
			System.out.println("0.나가기");
			System.out.printf("입력 : ");
			req = sc.nextInt();
			if (req == 1) {
				System.out.println("전체 검색을 실행 합니다.");
				controller.reservationListView();
			} else if (req == 2) {
				sc.nextLine();
				System.out.println("예약 1건 검색을 실행 합니다.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				controller.reservationView(s);
			} else if (req == 3) {
				sc.nextLine();
				System.out.println("예약 변경을 실행 합니다.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				System.out.println("변경할 일 수를 입력 : ");
				i = sc.nextInt();
				controller.updateReservation2(s, i);
				controller.optionGrade(s);
				controller.reservationView(s);

			} else if (req == 4) {
				sc.nextLine();
				System.out.println("조식 구매");
				System.out.println("put your last name : ");
				System.out.println("Lee9742, Park8854, Woo2387, Kim9910, jung3462");
				s = sc.nextLine();
				controller.reservationView(s);
				controller.updateReservation1(s);
				controller.reservationView(s);
			} else if (req == 5) {
				sc.nextLine();
				System.out.println("예약 삭제를 실행 합니다.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				controller.deleteReservation(s);
				controller.reservationListView();
			} else if (req == 6) {
				System.out.println("추가 ");
				controller.insertReservation(newReservation);
				controller.reservationListView();

			} else if (req == 7) {
				sc.nextLine();
				System.out.println("Json 전체 검색을 실행 합니다.");
				controller.jsonAllget();
			} else if (req == 0) {
				break;
			}

		}

	}
}
