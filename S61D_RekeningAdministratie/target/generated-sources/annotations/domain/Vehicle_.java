package domain;

import domain.Driver;
import domain.History;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T15:07:00")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, Driver> owner;
    public static volatile SingularAttribute<Vehicle, String> licensePlate;
    public static volatile SingularAttribute<Vehicle, String> autorisatieCode;
    public static volatile SingularAttribute<Vehicle, String> iCan;
    public static volatile ListAttribute<Vehicle, History> history;

}