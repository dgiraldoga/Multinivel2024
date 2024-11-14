package co.banco.mio.bancomio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
    private Integer userId;
	private String name;
	private String lastName;
	private String city;
	private Character status;

}
