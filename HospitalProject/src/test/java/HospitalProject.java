import org.egitim.spring.model.data.entity.Address;
import org.egitim.spring.model.data.entity.Doctor;
import org.egitim.spring.model.data.entity.Hospital;
import org.egitim.spring.model.data.entity.Polyclinic;
import org.egitim.spring.model.service.base.BaseService;
import org.egitim.spring.model.service.base.IBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HospitalProject {

    @Test
    void name() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        IBaseService<Address> addressService = applicationContext.getBean(BaseService.class);
        IBaseService<Hospital> hospitalService = applicationContext.getBean(BaseService.class);
        IBaseService<Polyclinic> polyclinicService = applicationContext.getBean(BaseService.class);
        IBaseService<Doctor> doctorService = applicationContext.getBean(BaseService.class);

        List<Address> addresses = addressService.getEntityList("Address");
        addressService.printEntityList(addresses);

        List<Hospital> hospitals = hospitalService.getEntityList("Hospital");
        hospitalService.printEntityList(hospitals);

        List<Polyclinic> polyclinics = polyclinicService.getEntityList("Polyclinic");
        polyclinicService.printEntityList(polyclinics);

        List<Doctor> doctors = doctorService.getEntityList("Doctor");
        doctorService.printEntityList(doctors);

    }

}
