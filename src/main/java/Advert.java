import java.util.Objects;

public class Advert {

    private String make;
    private String model;
    private String registration;
    private String price;

    public Advert(String make, String model, String registration, String price) {
        this.make = make;
        this.model = model;
        this.registration = registration;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Advert advert = (Advert) object;
        return make.equals(advert.make) &&
                model.equals(advert.model) &&
                registration.equals(advert.registration);
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object[] fields = {make, model, registration, price};
        for (Object field:fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return result;
    }
}
