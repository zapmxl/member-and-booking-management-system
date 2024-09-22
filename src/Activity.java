import java.util.ArrayList;
import java.util.List;

// Κλάση που αναπαριστά μια δραστηριότητα ή τμήμα του οργανισμού
public class Activity {
    private String activityName;           // Όνομα της δραστηριότητας
    private List<Schedule> timetable;      // Λίστα με τα προγράμματα της δραστηριότητας
    private final int participantLimit = 6; // Μέγιστος αριθμός συμμετεχόντων (σταθερά 6)

    // Κατασκευαστής της κλάσης Activity
    public Activity(String activityName) {
        this.activityName = activityName;
        this.timetable = new ArrayList<>();
    }

    // Getters και Setters
    public String getActivityName() {
        return activityName;
    }

    public List<Schedule> getTimetable() {
        return timetable;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    // Μέθοδος για την προσθήκη προγράμματος στη δραστηριότητα
    public void addSchedule(Schedule schedule) {
        timetable.add(schedule);
    }

    // Μέθοδος για τον έλεγχο διαθεσιμότητας σε ένα πρόγραμμα
    public boolean hasAvailability(Schedule schedule) {
        return schedule.isSlotAvailable();
    }

    // Μέθοδος για την εγγραφή μέλους σε ένα πρόγραμμα
    public void enrollParticipant(Member member, Schedule schedule) {
        schedule.bookSlot(member);
    }

    // Μέθοδος για την απομάκρυνση μέλους από ένα πρόγραμμα
    public void dismissParticipant(Member member, Schedule schedule) {
        schedule.releaseSlot(member);
    }
}
