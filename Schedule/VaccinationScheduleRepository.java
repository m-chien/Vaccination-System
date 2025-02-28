package phantichtkhdt.tiemchung.Schedule;

import java.util.ArrayList;
import java.util.List;

public class VaccinationScheduleRepository implements IVaccinationScheduleRepository {
    private List<VaccinationAppointment> qlyvaccine = new ArrayList<>();

    @Override
    public void addApointment(VaccinationAppointment appointment) {
        qlyvaccine.add(appointment);
    }

    @Override
    public List<VaccinationAppointment> getAllappointment() {
        return qlyvaccine;
    }
}
