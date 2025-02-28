package phantichtkhdt.tiemchung.HealthcareCenter;

import java.util.ArrayList;
import java.util.List;

public class HealthCenterRepository<T> implements IHealthVaccineRepository<T> {
    private List<T> qlyhealthcenter = new ArrayList<>();

    @Override
    public List<T> getHealthcareCenter() {
        return qlyhealthcenter;
    }

    @Override
    public void add(T entities) {
        qlyhealthcenter.add(entities);
    }

    @Override
    public T gethealthcenter(int i) {
        return qlyhealthcenter.get(i);
    }

    @Override
    public int getsize() {
        return qlyhealthcenter.size();
    }
}
