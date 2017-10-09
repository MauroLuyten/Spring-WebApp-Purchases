package domain.db;

public class RepositoryFactory {

    private PurchaseRepository purchaseRepository;
    private UserRepository userRepository;

    public RepositoryFactory(String dbChoices) {
        if (dbChoices != null && dbChoices.equals("memory")) {
            this.purchaseRepository = new PurchaseRepositoryMemory();
        }
        if (dbChoices != null && dbChoices.equals("relational")) {
            this.purchaseRepository = new PurchaseRepositoryRelational();
            this.userRepository = new UserRepositoryRelational();

        }
    }

    public UserRepository getUserRepo() {
        return userRepository;
    }

    public PurchaseRepository getPurchaseRepo() {
        return purchaseRepository;
    }

}
