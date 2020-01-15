package mgao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
    private String stage;
    private int value;
}
