
import com.mycompany.webapi.APIService;
import com.mycompany.webapi.DataHolder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bimsa
 */
public class ApiServiceTest {
     @Test
    public void testGetDataFromApi() {
        APIService apiService = new APIService();
        DataHolder data = apiService.getDataFromApi();
        assertNotNull(data);
        assertEquals(2, data.getUserId());
    }
}
