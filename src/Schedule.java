import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Κλάση που αναπαριστά ένα πρόγραμμα μιας δραστηριότητας
public class Schedule {
    private DayOfWeek weekDay;             // Ημέρα της εβδομάδας
    private LocalTime start;               // Ώρα έναρξης
    private LocalTime end;                 // Ώρα λήξης
    private List<Member> enrolledMembers;  // Λίστα με τα μέλη που έχουν εγγραφεί στο πρόγραμμα

    private final int maxCapacity = 6;     // Μέγιστος αριθμός συμμετεχόντων (σταθερά 6)

    // Κατασκευαστής της κλάσης Schedule
    public Schedule(DayOfWeek weekDay, LocalTime start, LocalTime end) {
        this.weekDay = weekDay;
        this.start = start;
        this.end = end;
        this.enrolledMembers = new ArrayList<>();
    }

    // Getters και Setters
    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public List<Member> getEnrolledMembers() {
        return enrolledMembers;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Μέθοδος για τον έλεγχο αν υπάρχει διαθέσιμη θέση στο πρόγραμμα
    public boolean isSlotAvailable() {
        return enrolledMembers.size() < maxCapacity;
    }

    // Μέθοδος για την κράτηση θέσης στο πρόγραμμα
    public void bookSlot(Member member) {
        if (isSlotAvailable()) {
            enrolledMembers.add(member);
        } else {
            System.out.println("Δεν υπάρχουν διαθέσιμες θέσεις.");
        }
    }

    // Μέθοδος για την απελευθέρωση θέσης στο πρόγραμμα
    public void releaseSlot(Member member) {
        enrolledMembers.remove(member);
    }
}
