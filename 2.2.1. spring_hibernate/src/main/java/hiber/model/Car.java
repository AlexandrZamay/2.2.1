package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    public Car(){}

    @Column
    String model;
    @Column
    int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

}
