// Καθορισμός του enum που αναπαριστά τους τύπους πακέτων συνδρομής
public enum PackageOption {
    EIGHT_SESSIONS(8),        // Πακέτο 8 συνεδριών ανά μήνα
    FIFTEEN_SESSIONS(15);     // Πακέτο 15 συνεδριών ανά μήνα

    private final int sessionCount;

    // Κατασκευαστής του enum
    PackageOption(int sessionCount) {
        this.sessionCount = sessionCount;
    }

    // Μέθοδος για την επιστροφή του αριθμού συνεδριών
    public int getSessionCount() {
        return sessionCount;
    }
}
