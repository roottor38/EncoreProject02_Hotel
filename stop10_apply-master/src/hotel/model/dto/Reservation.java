package hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	private String rsv; // ����� ��Ī
	private Guest guest; // ���� ������ ����
	private Room room; // ���� �� ����
	private OptionService option;// ���� �ɼųμ��� ����

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		builder.append("[���� ��ȣ : ");
		builder.append(rsv);
		builder.append(", ���� ������ ���� : ");
		builder.append(guest);
		builder.append(", ���� �� ���� : ");
		builder.append(room);
		builder.append(", ���� �ɼųμ��� ����: ");
		builder.append(option);
		return builder.toString();
	}
	
}
