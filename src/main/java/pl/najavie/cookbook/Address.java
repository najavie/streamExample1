package pl.najavie.cookbook;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by krzysztof on 1/2/15.
 */
public class Address {
    private String street;
    private City city;
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static Address generateAddress() {
        Address address = new Address();
        address.setCity(City.getCity());
        address.setStreet(RandomStringUtils.randomAlphabetic(10));
        address.setZip(RandomStringUtils.randomNumeric(5));
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
