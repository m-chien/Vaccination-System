package phantichtkhdt.tiemchung.Schedule;

import java.util.List;

public interface IVaccinationScheduleRepository {
    void addApointment(VaccinationAppointment appointment);
    List<VaccinationAppointment> getAllappointment();
}
