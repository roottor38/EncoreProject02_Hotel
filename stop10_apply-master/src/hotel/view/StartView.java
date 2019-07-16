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
			System.out.println("1.��ü �˻�");
			System.out.println("2.���� 1�� �˻�");
			System.out.println("3.���� �ϼ� ����");
			System.out.println("4 ���� ����");
			System.out.println("5.���� ����");
			System.out.println("6 ���� �߰�");
			System.out.println("7.json ���");
			System.out.println("0.������");
			System.out.printf("�Է� : ");
			req = sc.nextInt();
			if (req == 1) {
				System.out.println("��ü �˻��� ���� �մϴ�.");
				controller.reservationListView();
			} else if (req == 2) {
				sc.nextLine();
				System.out.println("���� 1�� �˻��� ���� �մϴ�.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				controller.reservationView(s);
			} else if (req == 3) {
				sc.nextLine();
				System.out.println("���� ������ ���� �մϴ�.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				System.out.println("������ �� ���� �Է� : ");
				i = sc.nextInt();
				controller.updateReservation2(s, i);
				controller.optionGrade(s);
				controller.reservationView(s);

			} else if (req == 4) {
				sc.nextLine();
				System.out.println("���� ����");
				System.out.println("put your last name : ");
				System.out.println("Lee9742, Park8854, Woo2387, Kim9910, jung3462");
				s = sc.nextLine();
				controller.reservationView(s);
				controller.updateReservation1(s);
				controller.reservationView(s);
			} else if (req == 5) {
				sc.nextLine();
				System.out.println("���� ������ ���� �մϴ�.");
				System.out.println("put your last name : ");
				s = sc.nextLine();
				controller.deleteReservation(s);
				controller.reservationListView();
			} else if (req == 6) {
				System.out.println("�߰� ");
				controller.insertReservation(newReservation);
				controller.reservationListView();

			} else if (req == 7) {
				sc.nextLine();
				System.out.println("Json ��ü �˻��� ���� �մϴ�.");
				controller.jsonAllget();
			} else if (req == 0) {
				break;
			}

		}

	}
}
