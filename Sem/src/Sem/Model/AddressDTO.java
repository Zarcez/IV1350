package Sem.Model;

public final class AddressDTO {
    private final String name;
    private final String street;
    private final String zip;
    private final String city;

    /**
     * Creates a new instance.
     *
     * @param street Street name and number.
     * @param zip    Zip code
     * @param city   City (postort)
     */
    public AddressDTO(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the value of zip
     *
     * @return the value of zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Get the value of street
     *
     * @return the value of street
     */
    public String getStreet() {
        return street;
    }

}
