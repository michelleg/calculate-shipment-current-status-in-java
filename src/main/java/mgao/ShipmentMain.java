package mgao;

import java.util.List;

public class ShipmentMain {
    public static void main(String[] args) {
        Status s1 = Status.builder()
                .stage("PickedUp")
                .value(1).build();
        Status s2 = Status.builder()
                .stage("InTransit")
                .value(1).build();
        Status s3 = Status.builder()
                .stage("Delivered")
                .value(0).build();
        List<Status> st1 = List.of(s3, s2, s1);

        List<Status> st2 = List.of(s3, s2, s1);

        Track t1 = Track.builder()
                .statuses(st1).build();
        Track t2 = Track.builder()
                .statuses(st2).build();
        Track sumTrack = summaryStatus(List.of(t1, t2));
        System.out.println(sumTrack.toString());
        String currentStatus = findCurrentStatus(sumTrack);
        System.out.println(currentStatus);
    }

    static Track summaryStatus(List<Track> trs) {
        Status s1 = Status.builder()
                .stage("Delivered")
                .value(0).build();
        Status s2 = Status.builder()
                .stage("InTransit")
                .value(0).build();
        Status s3 = Status.builder()
                .stage("PickedUp")
                .value(0).build();
        int length = trs.size();

        trs.forEach( tr ->  {
            s1.setValue((s1.getValue() + tr.getStatuses().get(0).getValue()));
            s2.setValue(s2.getValue() + tr.getStatuses().get(1).getValue());
            s3.setValue(s3.getValue() + tr.getStatuses().get(2).getValue());
        });

        s1.setValue(s1.getValue()/length);
        s2.setValue(s2.getValue()/length);
        s3.setValue(s3.getValue()/length);

        return Track.builder()
                .statuses(List.of(s1, s2, s3)).build();
    }

    static String findCurrentStatus(Track tr) {
        List<Status> st = tr.getStatuses();
        for (int i=0; i<3; i++) {
            if (st.get(i).getValue() == 1) {
                return st.get(i).getStage();
            }
        }
        return "CREATED";
    }
}
