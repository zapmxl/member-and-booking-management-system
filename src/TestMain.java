import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

// Κύρια κλάση για τη δοκιμή του συστήματος
public class TestMain {
    public static void main(String[] args) {
        // Δημιουργία δραστηριοτήτων
        Activity swimmingPool = new Activity("Κολυμβητήριο");
        Activity crossFit = new Activity("CrossFit");

        // Δημιουργία προγραμμάτων για το κολυμβητήριο
        Schedule swimmingMorning = new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
        Schedule swimmingAfternoon = new Schedule(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(18, 0));
        swimmingPool.addSchedule(swimmingMorning);
        swimmingPool.addSchedule(swimmingAfternoon);

        // Δημιουργία προγραμμάτων για το CrossFit
        Schedule crossFitTuesday = new Schedule(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
        Schedule crossFitWednesday = new Schedule(DayOfWeek.WEDNESDAY, LocalTime.of(16, 0), LocalTime.of(17, 0));
        crossFit.addSchedule(crossFitTuesday);
        crossFit.addSchedule(crossFitWednesday);

        // Δημιουργία μελών
        Member john = new Member("Γιάννης Παπαδόπουλος", "john@example.com", "6901234567", 28);
        Member maria = new Member("Μαρία Κωνσταντίνου", "maria@example.com", "6912345678", 35);

        // Δημιουργία συνδρομών
        Subscription johnSwimmingSubscription = new Subscription(PackageOption.EIGHT_SESSIONS, swimmingPool);
        john.addSubscription(johnSwimmingSubscription);

        Subscription mariaCrossFitSubscription = new Subscription(PackageOption.FIFTEEN_SESSIONS, crossFit);
        maria.addSubscription(mariaCrossFitSubscription);

        // Δημιουργία διαχειριστή κρατήσεων
        ReservationManager reservationManager = new ReservationManager();

        // Δημιουργία κράτησης για τον Γιάννη στο κολυμβητήριο τη Δευτέρα το πρωί
        reservationManager.createReservation(john, swimmingPool, swimmingMorning, LocalDate.now());

        // Δημιουργία κράτησης για τη Μαρία στο CrossFit την Τρίτη
        reservationManager.createReservation(maria, crossFit, crossFitTuesday, LocalDate.now());

        // Εμφάνιση υπολοίπου συνεδριών
        System.out.println("Υπόλοιπο συνεδριών για τον Γιάννη: " + johnSwimmingSubscription.getSessionsLeft());
        System.out.println("Υπόλοιπο συνεδριών για τη Μαρία: " + mariaCrossFitSubscription.getSessionsLeft());

        // Αλλαγή κράτησης για τη Μαρία από την Τρίτη στην Τετάρτη
        Reservation mariaReservation = new Reservation(maria, crossFit, crossFitTuesday, LocalDate.now());
        reservationManager.updateReservation(mariaReservation, crossFitWednesday);

        // Ακύρωση κράτησης για τον Γιάννη
        Reservation johnReservation = new Reservation(john, swimmingPool, swimmingMorning, LocalDate.now());
        reservationManager.deleteReservation(johnReservation);
    }
}
