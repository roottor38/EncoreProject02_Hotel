package hotel.model.dto;

import lombok.Data;

@Data
public class Room {

	private int roomNumber; // 201, 301, 401, 501, 601, 701, 801
	private String roomType; // delux, superior, premier, suite
	private String bedSize; // single, twin, queen, king

	public Room() {
	}

	public Room(int roomNumber, String roomType, String bedSize) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.bedSize = bedSize;
	}

}
