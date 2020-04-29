package Sem.Integration;

import Sem.Model.AddressDTO;

/**
 * The store DTO, used to handle the information of the store
 */

public class StoreDTO {
    private final String name;
    private final AddressDTO address;

    public StoreDTO(String name, AddressDTO address){
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
