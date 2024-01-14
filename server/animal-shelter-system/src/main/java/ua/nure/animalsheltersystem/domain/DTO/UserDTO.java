package ua.nure.animalsheltersystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    private String name;

    private LocalDate dob;

    private String email;

    private String address;

    private String phone_number;
}
