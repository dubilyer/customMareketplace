package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor @NoArgsConstructor
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@ApiModel(value = "User")
public class UserDto {
    private long id;
    @ApiModelProperty(value = "Users email", required = true)
    @NonNull private String email;
}
