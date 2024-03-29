package servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import plug.beans.City;
import plug.beans.Town;
import plug.beans.District;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
import plug.service.DummyService;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 28.11.2012
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testContext.xml")
public class ServiceTest {

    @Autowired
    DummyService dummyService;

    @Test
    public void checkService() {
        assertNotNull(dummyService);
    }

    
    //testing the cities in the database
  //checks if the expected name and the name existing in the database matches
  //checks if the number of cities expected and the number of cities in the database matches
    @Test
    public void testName() throws Exception {
        List<City> cities=dummyService.getCities();
        assertEquals(81,cities.size());
        assertEquals("Adana",cities.get(0).getName());
        assertEquals("Hatay",cities.get(36).getName());
        assertEquals("Kocaeli",cities.get(51).getName());
        assertEquals("A�r�",cities.get(3).getName());
        assertEquals("Malatya",cities.get(54).getName());
        assertEquals("Zonguldak",cities.get(80).getName());
        assertEquals("Edirne",cities.get(27).getName());
    }
    
    
    //testing the towns
    //checks if the expected name and the name existing in the database matches
    //checks if the number of the towns expected and the number of towns in the database matches
    @Test
    public void testTowns() throws Exception {
        List<Town> towns=dummyService.getTowns(1);
        assertEquals(15,towns.size());
        assertEquals("Ceyhan",towns.get(1).getName());
       
        towns=dummyService.getTowns(26);
        assertEquals(14,towns.size());
        assertEquals("Han",towns.get(4).getName());
        
        towns=dummyService.getTowns(34);
        assertEquals(39,towns.size());
        assertEquals("Zeytinburnu",towns.get(38).getName());
        
        towns=dummyService.getTowns(80);
        assertEquals(7,towns.size());
        assertEquals("Toprakkale",towns.get(6).getName());
        
    }
    
    //testing the districts
    //checks if the expected name and the name existing in the database matches
  //checks if the number of the districts expected and the number of districts in the database matches
    @Test
    public void testDistricts() throws Exception {
        List<District> districts=dummyService.getDistricts(1);
        assertEquals(2,districts.size());
        assertEquals("Karsant�",districts.get(0).getName());
    }
    
    //testing offered services
    //checks if the expected name and the name existing in the database matches
    @Test
    public void testOfferedServices() throws Exception {
        List<OfferedServices> offeredServices=dummyService.getOfferedServicesSearchResult("select title from offered_services where user_id=1");
        assertEquals("Guitar Lesson",offeredServices.get(0).getTitle());
        assertEquals("deneme",offeredServices.get(1).getTitle());
        assertEquals("Almanca dersi",offeredServices.get(2).getTitle());
    }

       
    //testing requested services
  //checks if the expected name and the name existing in the database matches
    @Test
    public void testRequestedServices() throws Exception {
        List<RequestedServices> requestedServices=dummyService.getRequestedServicesSearhResult("select title from requested_services where user_id=1");
        assertEquals("perde takma",requestedServices.get(0).getTitle());
        assertEquals("math",requestedServices.get(1).getTitle());
    }
    
}
