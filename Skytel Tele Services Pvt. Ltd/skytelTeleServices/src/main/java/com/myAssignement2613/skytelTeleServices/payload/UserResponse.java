package com.myAssignement2613.skytelTeleServices.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private List<UserDto> getAllDetails;
    private int pageNo;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean lastPage;
}
