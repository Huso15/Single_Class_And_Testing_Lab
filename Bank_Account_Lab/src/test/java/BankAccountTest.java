import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setUp(){
        account = new BankAccount("John", "Doe", LocalDate.of(1990, 5, 15), "123456789");
    }

    @Test
    public void testDeposit(){
        // Given
        double initialBalance = account.getBalance();
        double depositAmount = 500;

        // When
        account.deposit(depositAmount);

        // Then
        assertThat(account.getBalance()).isEqualTo(initialBalance + depositAmount);
    }

    @Test
    public void testWithdrawal(){
        // Given
        account.setBalance(1000);
        double initialBalance = account.getBalance();
        double withdrawalAmount = 200;

        // When
        account.withdrawal(withdrawalAmount);

        // Then
        assertThat(account.getBalance()).isEqualTo(initialBalance - withdrawalAmount);
    }

    @Test
    public void testPayInterest(){
        // Given
        account.setBalance(1000);
        double initialBalance = account.getBalance();
        double interestRate = 5; // 5%

        // When
        account.payInterest(interestRate);

        // Then
        double expectedBalance = initialBalance * (1 + (interestRate / 100));
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }
}
