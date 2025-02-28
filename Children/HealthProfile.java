package phantichtkhdt.tiemchung.Children;

public class HealthProfile {
    private double weight;
    private double height;

    public HealthProfile() {
    }

    public HealthProfile(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Chiều cao: " + height + " m, Cân nặng: " + weight + " kg"+"\n";
    }
}
