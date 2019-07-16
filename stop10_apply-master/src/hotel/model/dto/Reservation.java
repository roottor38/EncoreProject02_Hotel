package hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	private String rsv; // 예약건 명칭
	private Guest guest; // 예약 투숙객 정보
	private Room room; // 예약 룸 정보
	private OptionService option;// 예약 옵셔널서비스 정보

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		builder.append("[예약 번호 : ");
		builder.append(rsv);
		builder.append(", 예약 투숙객 정보 : ");
		builder.append(guest);
		builder.append(", 예약 룸 정보 : ");
		builder.append(room);
		builder.append(", 예약 옵셔널서비스 정보: ");
		builder.append(option);
		return builder.toString();
	}
	
}
