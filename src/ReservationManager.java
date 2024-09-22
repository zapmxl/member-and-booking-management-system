import java.time.LocalDate;

// Κλάση που διαχειρίζεται τις κρατήσεις
public class ReservationManager {

    // Μέθοδος για τη δημιουργία νέας κράτησης
    public void createReservation(Member participant, Activity bookedActivity, Schedule scheduledTime, LocalDate bookingDate) {
        // Έλεγχος διαθεσιμότητας στο πρόγραμμα
        if (bookedActivity.hasAvailability(scheduledTime)) {
            // Δημιουργία νέας κράτησης
            Reservation reservation = new Reservation(participant, bookedActivity, scheduledTime, bookingDate);
            reservation.makeReservation();
            System.out.println("Η κράτηση ολοκληρώθηκε με επιτυχία.");
        } else {
            System.out.println("Δεν υπάρχουν διαθέσιμες θέσεις για το επιλεγμένο πρόγραμμα.");
        }
    }

    // Μέθοδος για την αλλαγή υπάρχουσας κράτησης
    public void updateReservation(Reservation reservation, Schedule newSchedule) {
        // Έλεγχος διαθεσιμότητας στο νέο πρόγραμμα
        if (reservation.getBookedActivity().hasAvailability(newSchedule)) {
            // Ακύρωση της παλιάς κράτησης
            reservation.cancelReservation();
            // Δημιουργία νέας κράτησης με το νέο πρόγραμμα
            Reservation newReservation = new Reservation(reservation.getParticipant(), reservation.getBookedActivity(), newSchedule, reservation.getBookingDate());
            newReservation.makeReservation();
            System.out.println("Η αλλαγή κράτησης ολοκληρώθηκε με επιτυχία.");
        } else {
            System.out.println("Δεν υπάρχουν διαθέσιμες θέσεις στο νέο πρόγραμμα.");
        }
    }

    // Μέθοδος για την ακύρωση κράτησης
    public void deleteReservation(Reservation reservation) {
        reservation.cancelReservation();
        System.out.println("Η κράτηση ακυρώθηκε με επιτυχία.");
    }
}
