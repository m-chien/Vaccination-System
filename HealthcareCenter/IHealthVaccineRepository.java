package phantichtkhdt.tiemchung.HealthcareCenter;

import java.util.List;

public interface IHealthVaccineRepository<T> {
    List<T> getHealthcareCenter();
    void add(T entities);
    T gethealthcenter(int i);
    int getsize();
}
