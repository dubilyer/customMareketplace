package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
@JsonIgnoreProperties(ignoreUnknown=true)
@ApiModel(value = "User")
public class UserDto {
    private long id = 0;
    @ApiModelProperty(value = "Users username", required = true)
    @NonNull private String username = null;

    @ApiModelProperty(value = "Users password", required = true)
    @NonNull private String password = null;

}
