package Sem.Integration;

import Sem.Model.AddressDTO;

/**
 * The store DTO, used to handle the information of the store
 */

public class Store {
    private final String name;
    private final AddressDTO address;

    public Store(String name, AddressDTO address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public AddressDTO getAddress() {
        return address;
    }

}
