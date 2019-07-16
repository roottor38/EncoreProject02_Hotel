package hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
	private String lastName;// Åõ¼÷°´ ¼º
	private int age; // Åõ¼÷°´ ³ªÀÌ
	private String gender; // Sir / Madam
	private int night; // ´ç°Ç Åõ¼÷ÀÏ ¼ö
	private int qualifiedStay; // Åõ¼÷°´ ÀÌÀü ¼÷¹Ú È½¼ö
	private int qualifiedNight;// Åõ¼÷°´ ÀÌÀü ¼÷¹Ú ÀÏ¼ö
	private String grade;

}
