package domain;

import domain.Driver;
import domain.InvoiceRow;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-13T15:43:56")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, String> month;
    public static volatile SingularAttribute<Invoice, Driver> driver;
    public static volatile SingularAttribute<Invoice, Boolean> paid;
    public static volatile SingularAttribute<Invoice, Integer> id;
    public static volatile ListAttribute<Invoice, InvoiceRow> invoiceRows;
    public static volatile SingularAttribute<Invoice, Long> timestamp;

}