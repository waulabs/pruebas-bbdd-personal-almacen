package org.alvarowau.stockroomsandbox.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person implements Comparable<Person>{

    private Integer idPerson;
    private String firstName;
    private String lastName;
    private int numberPhone;
    private String email;
    private String address;
    private LocalDate birthDate;
    private String gender;
    private String personalId;
    private String nationality;
    private LocalDate registrationDate;


    public Person(Integer idPerson, String firstName, String lastName, int numberPhone, String email,
                  String address, LocalDate birthDate, String gender, String personalId,
                  String nationality, LocalDate registrationDate) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.personalId = personalId;
        this.nationality = nationality;
        this.registrationDate = registrationDate;
    }

    public Person() {
    }

    public Person(Integer idPerson, String firstName, String lastName, int numberPhone, String email, String address,
                  LocalDate birthDate, String gender, String personalId, String nationality){
        this(firstName,lastName,numberPhone,email,address,birthDate,gender,personalId,nationality);
        this.idPerson = idPerson;
    }

    public Person(String firstName, String lastName, int numberPhone, String email, String address, LocalDate birthDate, String gender, String personalId, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.personalId = personalId;
        this.nationality = nationality;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public int compareTo(Person other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        return lastNameComparison != 0 ? lastNameComparison : this.firstName.compareTo(other.firstName);
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public boolean isAdult() {
        return getAge() >= 18;
    }

    public boolean isMinor() {
        return getAge() < 18;
    }

    public boolean isUnder16() {
        return getAge() < 16;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return numberPhone == person.numberPhone && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(address, person.address) && Objects.equals(birthDate, person.birthDate) && Objects.equals(gender, person.gender) && Objects.equals(personalId, person.personalId) && Objects.equals(nationality, person.nationality) && Objects.equals(registrationDate, person.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, numberPhone, email, address, birthDate, gender, personalId, nationality, registrationDate);
    }
}
