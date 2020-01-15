package mgao;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@Builder
public class Track {
    List<Status> statuses;

    public String toString() {
        AtomicReference<String> pr = new AtomicReference<>("");
        this.statuses.forEach( st -> {
            pr.set(pr.get() + st.getValue() + " ");
        });
        return pr.get();
    }
}

