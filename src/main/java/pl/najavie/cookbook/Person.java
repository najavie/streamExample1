package pl.najavie.cookbook;

import org.apache.commons.lang.RandomStringUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by krzysztof on 1/2/15.
 */
public class Person {
    private int id;
    private String name;
    private String lastName;
    private List<String> phones;
    private Address address;

    public City getCity() {
        return address.getCity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static Person generatePerson(int id){
        Person person = new Person();
        person.setAddress(Address.generateAddress());
        person.setId(id);
        person.setLastName(RandomStringUtils.randomAlphabetic(10));
        person.setName(RandomStringUtils.randomAlphabetic(10));
        person.setPhones(IntStream.range(0,3).mapToObj(v->RandomStringUtils.randomNumeric(9)).collect(Collectors.toList()));
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                ", address=" + address +
                "}\n";
    }
}
