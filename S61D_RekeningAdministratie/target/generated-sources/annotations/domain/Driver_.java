package domain;

import domain.Invoice;
import domain.Vehicle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-27T19:18:33")
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, String> city;
    public static volatile ListAttribute<Driver, Vehicle> allVehicle;
    public static volatile SingularAttribute<Driver, String> postalCode;
    public static volatile SingularAttribute<Driver, String> houseNumber;
    public static volatile SingularAttribute<Driver, String> lastname;
    public static volatile SingularAttribute<Driver, String> password;
    public static volatile SingularAttribute<Driver, String> phoneNumber;
    public static volatile SingularAttribute<Driver, String> ican;
    public static volatile SingularAttribute<Driver, String> name;
    public static volatile SingularAttribute<Driver, Integer> id;
    public static volatile ListAttribute<Driver, Invoice> invoice;
    public static volatile SingularAttribute<Driver, String> email;
    public static volatile SingularAttribute<Driver, String> username;

}