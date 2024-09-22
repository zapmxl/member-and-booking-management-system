import java.util.ArrayList;
import java.util.List;

// Κλάση που αναπαριστά ένα μέλος του οργανισμού
public class Member {
    private String name;                        // Ονοματεπώνυμο του μέλους
    private String emailAddress;                // Email του μέλους
    private String phoneNumber;                 // Κινητό τηλέφωνο του μέλους
    private int memberAge;                      // Ηλικία του μέλους
    private List<Subscription> membershipPlans; // Λίστα με τις συνδρομές του μέλους

    // Κατασκευαστής της κλάσης Member
    public Member(String name, String emailAddress, String phoneNumber, int memberAge) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.memberAge = memberAge;
        this.membershipPlans = new ArrayList<>();
    }

    // Getters και Setters
    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public List<Subscription> getMembershipPlans() {
        return membershipPlans;
    }

    // Μέθοδος για την προσθήκη συνδρομής στο μέλος
    public void addSubscription(Subscription subscription) {
        membershipPlans.add(subscription);
    }

    // Μέθοδος για την αλλαγή προγράμματος (προαιρετικά)
    public void modifySchedule(Reservation oldBooking, Schedule newSchedule) {
        // Λογική αλλαγής προγράμματος
    }

    // Μέθοδος για την ακύρωση κράτησης (προαιρετικά)
    public void removeReservation(Reservation booking) {
        // Λογική ακύρωσης κράτησης
    }
}
