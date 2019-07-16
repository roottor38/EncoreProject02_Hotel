package hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
	private String lastName;// ������ ��
	private int age; // ������ ����
	private String gender; // Sir / Madam
	private int night; // ��� ������ ��
	private int qualifiedStay; // ������ ���� ���� Ƚ��
	private int qualifiedNight;// ������ ���� ���� �ϼ�
	private String grade;

}
