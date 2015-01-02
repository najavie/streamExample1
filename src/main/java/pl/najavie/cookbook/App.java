package pl.najavie.cookbook;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        //tworzenie person...
        List<Person> persons = IntStream.range(1,11).mapToObj(value -> Person.generatePerson(value)).collect(Collectors.toList());

        //wyswietlenie tylko imion
        persons.stream().forEach(person-> System.out.println(person.getName()));

        //stworzenie listy samych numerów telefonów
        List<String> phones = persons.stream().flatMap(person -> person.getPhones().stream()).collect(Collectors.toList());

        //a moze zrobic to wielowątkowo?
        phones = persons.parallelStream().flatMap(person-> person.getPhones().parallelStream()).collect(Collectors.toList());


        //a moze potrzebujemy mapy imie:nrytelefonów?
        Map<String,List<String>> namePhone = persons.parallelStream().collect(Collectors.toMap(Person::getName,Person::getPhones));


        //a moze mapy wg miast?
        Map<City,List<Person>> cityPersonMap = persons.stream().collect(Collectors.groupingBy(Person::getCity));


        //chce tylko osoby, ktore są z Gdyni!
        List<Person> gdyniaPersons = persons.parallelStream().filter(person -> person.getCity().equals(City.GDYNIA)).collect(Collectors.toList());

        //chce sumy osob, ktore sa z Gdyni
        System.out.println(persons.parallelStream().filter(person-> person.getCity().equals(City.GDYNIA)).count());









    }
}
