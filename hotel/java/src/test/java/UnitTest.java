import com.techelevator.HotelReservation;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void get_Estimated_Total_With_3Nights() {

        HotelReservation newReservation = new HotelReservation("Mike", 3);

        System.out.println(newReservation.getEstimatedTotal());

    }

    @Test
    public void get_Actual_Total_With_Minibar_and_Cleaning() {

        HotelReservation newReservation1 = new HotelReservation("KEvin", 5);
        System.out.println(newReservation1.getActualTotal(true, true));
    }
    @Test
    public void get_Actual_Total_With_Minibar() {

        HotelReservation newReservation1 = new HotelReservation("KEvin", 5);
        System.out.println(newReservation1.getActualTotal(false, true));
    }
    @Test
    public void get_Actual_Total_With_Cleaning() {

        HotelReservation newReservation1 = new HotelReservation("KEvin", 5);
        System.out.println(newReservation1.getActualTotal(true, false));
    }
    @Test
    public void get_Actual_Total_With_NoAmenities() {

        HotelReservation newReservation1 = new HotelReservation("KEvin", 5);
        System.out.println(newReservation1.getActualTotal(false, false));
}
    }
