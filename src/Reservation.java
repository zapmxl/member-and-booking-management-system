import java.time.LocalDate;

// Κλάση που αναπαριστά μια κράτηση ενός μέλους σε ένα πρόγραμμα
public class Reservation {
    private Member participant;        // Το μέλος που κάνει την κράτηση
    private Activity bookedActivity;   // Η δραστηριότητα στην οποία γίνεται η κράτηση
    private Schedule scheduledTime;    // Το πρόγραμμα στο οποίο γίνεται η κράτηση
    private LocalDate bookingDate;     // Η ημερομηνία της κράτησης

    // Κατασκευαστής της κλάσης Reservation
    public Reservation(Member participant, Activity bookedActivity, Schedule scheduledTime, LocalDate bookingDate) {
        this.participant = participant;
        this.bookedActivity = bookedActivity;
        this.scheduledTime = scheduledTime;
        this.bookingDate = bookingDate;
    }

    // Getters και Setters
    public Member getParticipant() {
        return participant;
    }

    public Activity getBookedActivity() {
        return bookedActivity;
    }

    public Schedule getScheduledTime() {
        return scheduledTime;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    // Μέθοδος για τη δημιουργία της κράτησης
    public void makeReservation() {
        bookedActivity.enrollParticipant(participant, scheduledTime);
        System.out.println("Κράτηση για " + participant.getName() + " στο " + bookedActivity.getActivityName() + " την " + scheduledTime.getWeekDay() + " στις " + scheduledTime.getStart());
    }

    // Μέθοδος για την ακύρωση της κράτησης
    public void cancelReservation() {
        bookedActivity.dismissParticipant(participant, scheduledTime);
        System.out.println("Η κράτηση ακυρώθηκε για " + participant.getName() + " στο " + bookedActivity.getActivityName());
    }
}
