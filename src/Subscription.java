// Κλάση που αναπαριστά μια συνδρομή ενός μέλους
public class Subscription {
    private PackageOption packageOption;    // Τύπος πακέτου συνδρομής
    private Activity activitySection;       // Δραστηριότητα/Τμήμα της συνδρομής
    private int sessionsLeft;               // Υπόλοιπο συνεδριών

    // Κατασκευαστής της κλάσης Subscription
    public Subscription(PackageOption packageOption, Activity activitySection) {
        this.packageOption = packageOption;
        this.activitySection = activitySection;
        // Ορισμός του υπολοίπου συνεδριών χρησιμοποιώντας το sessionCount του enum
        this.sessionsLeft = packageOption.getSessionCount();
    }

    // Getters και Setters
    public PackageOption getPackageOption() {
        return packageOption;
    }

    public Activity getActivitySection() {
        return activitySection;
    }

    public int getSessionsLeft() {
        return sessionsLeft;
    }

    // Μέθοδος για τη χρήση μιας συνεδρίας
    public void utilizeSession() {
        if (sessionsLeft > 0) {
            sessionsLeft--;
        } else {
            System.out.println("Δεν υπάρχουν διαθέσιμες συνεδρίες.");
        }
    }

    // Μέθοδος για την ανανέωση της συνδρομής
    public void refreshSubscription() {
        // Επαναφορά του υπολοίπου συνεδριών χρησιμοποιώντας το sessionCount του enum
        sessionsLeft = packageOption.getSessionCount();
    }
}
