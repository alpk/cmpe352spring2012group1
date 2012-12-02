package plug.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import plug.beans.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public interface DummyService {
    public Users getLoggedInUser(String userName);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);

    List<City> getCities();

    List<Town> getTowns(int id);

    List<District> getDistricts(int id);

    boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate);

    boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone);

    List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery);

    List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery);
}