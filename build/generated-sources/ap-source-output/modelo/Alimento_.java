package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-02T14:03:51")
@StaticMetamodel(Alimento.class)
public class Alimento_ { 

    public static volatile SingularAttribute<Alimento, String> descripcion;
    public static volatile SingularAttribute<Alimento, Date> fechaCaducidad;
    public static volatile SingularAttribute<Alimento, Double> precio;
    public static volatile SingularAttribute<Alimento, Integer> idalimento;
    public static volatile SingularAttribute<Alimento, Integer> cantidad;

}